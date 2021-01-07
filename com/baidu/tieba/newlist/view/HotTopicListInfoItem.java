package com.baidu.tieba.newlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.f.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newlist.b.b;
/* loaded from: classes8.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private TextView akR;
    private TextView akS;
    private f<b> aks;
    private TextView eKc;
    private int kdK;
    private TbImageView kdS;
    private View kdX;
    private TextView kss;
    private TextView lCh;
    private TextView lCi;
    private TextView lCj;
    private b lCk;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.kdK = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.kdX = findViewById(R.id.rootLayout);
        this.kdS = (TbImageView) findViewById(R.id.coverView);
        this.akR = (TextView) findViewById(R.id.indexView);
        this.eKc = (TextView) findViewById(R.id.titleView);
        this.akS = (TextView) findViewById(R.id.tagView);
        this.lCh = (TextView) findViewById(R.id.numView);
        this.kss = (TextView) findViewById(R.id.descView);
        this.lCi = (TextView) findViewById(R.id.titlePre);
        this.lCj = (TextView) findViewById(R.id.titleNext);
        this.kdS.setPlaceHolder(1);
        this.kdS.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kdS.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aks = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lCk = bVar;
            this.kdS.startLoad(bVar.cover, 10, false);
            this.eKc.setText(bVar.title);
            this.kss.setText(bVar.desc);
            String D = TagTextHelper.D(this.akS.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKc.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lCj.getLayoutParams();
            if (TextUtils.isEmpty(D)) {
                this.akS.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.akS.getContext(), R.dimen.tbds42);
                this.eKc.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lCj.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.akS.getContext(), R.dimen.tbds100);
                this.eKc.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lCj.setLayoutParams(layoutParams2);
                this.akS.setVisibility(0);
                this.akS.setText(D);
            }
            cSH();
            if (bVar.replyNum > 0) {
                this.lCh.setVisibility(0);
                this.lCh.setText(this.lCh.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.dX(bVar.replyNum)));
            } else {
                this.lCh.setVisibility(4);
            }
            this.akR.setText("" + bVar.index);
        }
    }

    private void cSH() {
        if (this.lCk != null) {
            int qk = TagTextHelper.qk(this.lCk.tag);
            Drawable background = this.akS.getBackground();
            DrawableCompat.setTint(background, ao.getColor(qk));
            this.akS.setBackgroundDrawable(background);
            int ql = TagTextHelper.ql(this.lCk.index);
            Drawable background2 = this.akR.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(ql));
            this.akR.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            a.m(this.kdX, R.color.CAM_X0205, R.color.CAM_X0204);
            ao.setViewTextColor(this.akS, R.color.CAM_X0101);
            ao.setViewTextColor(this.akR, R.color.CAM_X0101);
            ao.setViewTextColor(this.kss, R.color.CAM_X0109);
            ao.setViewTextColor(this.lCh, R.color.CAM_X0109);
            ao.setViewTextColor(this.eKc, R.color.CAM_X0105);
            ao.setViewTextColor(this.lCi, R.color.CAM_X0105);
            ao.setViewTextColor(this.lCj, R.color.CAM_X0105);
            cSH();
            this.kdK = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lCk != null && this.lCk.topicId > 0) {
            if (this.aks != null) {
                this.aks.a(view, this.lCk, this.lCk.index, this.lCk.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.lCk.topicId, null, "5").start();
        }
    }
}

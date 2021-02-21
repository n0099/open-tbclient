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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.f.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newlist.b.b;
/* loaded from: classes8.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private TextView ajP;
    private TextView ajQ;
    private f<b> ajq;
    private TextView eHx;
    private int kgW;
    private TbImageView khe;
    private View khj;
    private TextView kwi;
    private TextView lFT;
    private TextView lFU;
    private TextView lFV;
    private b lFW;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.kgW = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.khj = findViewById(R.id.rootLayout);
        this.khe = (TbImageView) findViewById(R.id.coverView);
        this.ajP = (TextView) findViewById(R.id.indexView);
        this.eHx = (TextView) findViewById(R.id.titleView);
        this.ajQ = (TextView) findViewById(R.id.tagView);
        this.lFT = (TextView) findViewById(R.id.numView);
        this.kwi = (TextView) findViewById(R.id.descView);
        this.lFU = (TextView) findViewById(R.id.titlePre);
        this.lFV = (TextView) findViewById(R.id.titleNext);
        this.khe.setPlaceHolder(1);
        this.khe.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.khe.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajq = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lFW = bVar;
            this.khe.startLoad(bVar.cover, 10, false);
            this.eHx.setText(bVar.title);
            this.kwi.setText(bVar.desc);
            String D = TagTextHelper.D(this.ajQ.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHx.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lFV.getLayoutParams();
            if (TextUtils.isEmpty(D)) {
                this.ajQ.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ajQ.getContext(), R.dimen.tbds42);
                this.eHx.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lFV.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ajQ.getContext(), R.dimen.tbds100);
                this.eHx.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lFV.setLayoutParams(layoutParams2);
                this.ajQ.setVisibility(0);
                this.ajQ.setText(D);
            }
            cQT();
            if (bVar.replyNum > 0) {
                this.lFT.setVisibility(0);
                this.lFT.setText(this.lFT.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, au.ed(bVar.replyNum)));
            } else {
                this.lFT.setVisibility(4);
            }
            this.ajP.setText("" + bVar.index);
        }
    }

    private void cQT() {
        if (this.lFW != null) {
            int oI = TagTextHelper.oI(this.lFW.tag);
            Drawable background = this.ajQ.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oI));
            this.ajQ.setBackgroundDrawable(background);
            int oJ = TagTextHelper.oJ(this.lFW.index);
            Drawable background2 = this.ajP.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oJ));
            this.ajP.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            a.m(this.khj, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.ajQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.ajP, R.color.CAM_X0101);
            ap.setViewTextColor(this.kwi, R.color.CAM_X0109);
            ap.setViewTextColor(this.lFT, R.color.CAM_X0109);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
            ap.setViewTextColor(this.lFU, R.color.CAM_X0105);
            ap.setViewTextColor(this.lFV, R.color.CAM_X0105);
            cQT();
            this.kgW = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lFW != null && this.lFW.topicId > 0) {
            if (this.ajq != null) {
                this.ajq.a(view, this.lFW, this.lFW.index, this.lFW.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.lFW.topicId, null, "5").start();
        }
    }
}

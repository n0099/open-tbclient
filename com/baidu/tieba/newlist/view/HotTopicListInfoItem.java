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
/* loaded from: classes7.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> ajB;
    private TextView aka;
    private TextView akb;
    private TextView eFr;
    private int jZf;
    private TbImageView jZn;
    private View jZs;
    private TextView knN;
    private TextView lxB;
    private TextView lxC;
    private TextView lxD;
    private b lxE;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.jZf = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZf = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZf = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.jZs = findViewById(R.id.rootLayout);
        this.jZn = (TbImageView) findViewById(R.id.coverView);
        this.aka = (TextView) findViewById(R.id.indexView);
        this.eFr = (TextView) findViewById(R.id.titleView);
        this.akb = (TextView) findViewById(R.id.tagView);
        this.lxB = (TextView) findViewById(R.id.numView);
        this.knN = (TextView) findViewById(R.id.descView);
        this.lxC = (TextView) findViewById(R.id.titlePre);
        this.lxD = (TextView) findViewById(R.id.titleNext);
        this.jZn.setPlaceHolder(1);
        this.jZn.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jZn.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajB = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lxE = bVar;
            this.jZn.startLoad(bVar.cover, 10, false);
            this.eFr.setText(bVar.title);
            this.knN.setText(bVar.desc);
            String D = TagTextHelper.D(this.akb.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFr.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lxD.getLayoutParams();
            if (TextUtils.isEmpty(D)) {
                this.akb.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.akb.getContext(), R.dimen.tbds42);
                this.eFr.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lxD.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.akb.getContext(), R.dimen.tbds100);
                this.eFr.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lxD.setLayoutParams(layoutParams2);
                this.akb.setVisibility(0);
                this.akb.setText(D);
            }
            cOP();
            if (bVar.replyNum > 0) {
                this.lxB.setVisibility(0);
                this.lxB.setText(this.lxB.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.dX(bVar.replyNum)));
            } else {
                this.lxB.setVisibility(4);
            }
            this.aka.setText("" + bVar.index);
        }
    }

    private void cOP() {
        if (this.lxE != null) {
            int oD = TagTextHelper.oD(this.lxE.tag);
            Drawable background = this.akb.getBackground();
            DrawableCompat.setTint(background, ao.getColor(oD));
            this.akb.setBackgroundDrawable(background);
            int oE = TagTextHelper.oE(this.lxE.index);
            Drawable background2 = this.aka.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(oE));
            this.aka.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            a.m(this.jZs, R.color.CAM_X0205, R.color.CAM_X0204);
            ao.setViewTextColor(this.akb, R.color.CAM_X0101);
            ao.setViewTextColor(this.aka, R.color.CAM_X0101);
            ao.setViewTextColor(this.knN, R.color.CAM_X0109);
            ao.setViewTextColor(this.lxB, R.color.CAM_X0109);
            ao.setViewTextColor(this.eFr, R.color.CAM_X0105);
            ao.setViewTextColor(this.lxC, R.color.CAM_X0105);
            ao.setViewTextColor(this.lxD, R.color.CAM_X0105);
            cOP();
            this.jZf = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lxE != null && this.lxE.topicId > 0) {
            if (this.ajB != null) {
                this.ajB.a(view, this.lxE, this.lxE.index, this.lxE.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.lxE.topicId, null, "5").start();
        }
    }
}

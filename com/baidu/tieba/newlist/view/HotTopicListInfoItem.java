package com.baidu.tieba.newlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newlist.b.b;
/* loaded from: classes20.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> aiR;
    private TextView ajq;
    private TextView ajr;
    private TextView etx;
    private int jCS;
    private TbImageView jDa;
    private View jDf;
    private TextView jRA;
    private TextView ljA;
    private b ljB;
    private TextView ljy;
    private TextView ljz;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.jCS = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.jDf = findViewById(R.id.rootLayout);
        this.jDa = (TbImageView) findViewById(R.id.coverView);
        this.ajq = (TextView) findViewById(R.id.indexView);
        this.etx = (TextView) findViewById(R.id.titleView);
        this.ajr = (TextView) findViewById(R.id.tagView);
        this.ljy = (TextView) findViewById(R.id.numView);
        this.jRA = (TextView) findViewById(R.id.descView);
        this.ljz = (TextView) findViewById(R.id.titlePre);
        this.ljA = (TextView) findViewById(R.id.titleNext);
        this.jDa.setPlaceHolder(1);
        this.jDa.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jDa.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aiR = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ljB = bVar;
            this.jDa.startLoad(bVar.cover, 10, false);
            this.etx.setText(bVar.title);
            this.jRA.setText(bVar.desc);
            String t = TagTextHelper.t(this.ajr.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etx.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ljA.getLayoutParams();
            if (TextUtils.isEmpty(t)) {
                this.ajr.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ajr.getContext(), R.dimen.tbds42);
                this.etx.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ljA.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ajr.getContext(), R.dimen.tbds100);
                this.etx.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ljA.setLayoutParams(layoutParams2);
                this.ajr.setVisibility(0);
                this.ajr.setText(t);
            }
            cKk();
            if (bVar.replyNum > 0) {
                this.ljy.setVisibility(0);
                this.ljy.setText(this.ljy.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, au.dy(bVar.replyNum)));
            } else {
                this.ljy.setVisibility(4);
            }
            this.ajq.setText("" + bVar.index);
        }
    }

    private void cKk() {
        if (this.ljB != null) {
            int pz = TagTextHelper.pz(this.ljB.tag);
            Drawable background = this.ajr.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pz));
            this.ajr.setBackgroundDrawable(background);
            int pA = TagTextHelper.pA(this.ljB.index);
            Drawable background2 = this.ajq.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(pA));
            this.ajq.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            a.h(this.jDf, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.ajr, R.color.CAM_X0101);
            ap.setViewTextColor(this.ajq, R.color.CAM_X0101);
            ap.setViewTextColor(this.jRA, R.color.CAM_X0109);
            ap.setViewTextColor(this.ljy, R.color.CAM_X0109);
            ap.setViewTextColor(this.etx, R.color.CAM_X0105);
            ap.setViewTextColor(this.ljz, R.color.CAM_X0105);
            ap.setViewTextColor(this.ljA, R.color.CAM_X0105);
            cKk();
            this.jCS = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ljB != null && this.ljB.topicId > 0) {
            if (this.aiR != null) {
                this.aiR.a(view, this.ljB, this.ljB.index, this.ljB.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.ljB.topicId, null, "5").start();
        }
    }
}

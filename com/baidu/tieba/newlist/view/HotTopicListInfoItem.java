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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newlist.b.b;
/* loaded from: classes21.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> aiM;
    private TextView ajl;
    private TextView ajm;
    private TextView evg;
    private int jBV;
    private TbImageView jCd;
    private View jCi;
    private TextView jQQ;
    private TextView ljh;
    private TextView lji;
    private TextView ljj;
    private b ljk;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.jBV = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.jCi = findViewById(R.id.rootLayout);
        this.jCd = (TbImageView) findViewById(R.id.coverView);
        this.ajl = (TextView) findViewById(R.id.indexView);
        this.evg = (TextView) findViewById(R.id.titleView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.ljh = (TextView) findViewById(R.id.numView);
        this.jQQ = (TextView) findViewById(R.id.descView);
        this.lji = (TextView) findViewById(R.id.titlePre);
        this.ljj = (TextView) findViewById(R.id.titleNext);
        this.jCd.setPlaceHolder(1);
        this.jCd.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jCd.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aiM = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ljk = bVar;
            this.jCd.startLoad(bVar.cover, 10, false);
            this.evg.setText(bVar.title);
            this.jQQ.setText(bVar.desc);
            String t = TagTextHelper.t(this.ajm.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evg.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ljj.getLayoutParams();
            if (TextUtils.isEmpty(t)) {
                this.ajm.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ajm.getContext(), R.dimen.tbds42);
                this.evg.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ljj.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ajm.getContext(), R.dimen.tbds100);
                this.evg.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ljj.setLayoutParams(layoutParams2);
                this.ajm.setVisibility(0);
                this.ajm.setText(t);
            }
            cKF();
            if (bVar.replyNum > 0) {
                this.ljh.setVisibility(0);
                this.ljh.setText(this.ljh.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.dy(bVar.replyNum)));
            } else {
                this.ljh.setVisibility(4);
            }
            this.ajl.setText("" + bVar.index);
        }
    }

    private void cKF() {
        if (this.ljk != null) {
            int pd = TagTextHelper.pd(this.ljk.tag);
            Drawable background = this.ajm.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pd));
            this.ajm.setBackgroundDrawable(background);
            int pe = TagTextHelper.pe(this.ljk.index);
            Drawable background2 = this.ajl.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(pe));
            this.ajl.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            a.g(this.jCi, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.ajm, R.color.cp_cont_a);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.jQQ, R.color.cp_cont_d);
            ap.setViewTextColor(this.ljh, R.color.cp_cont_d);
            ap.setViewTextColor(this.evg, R.color.cp_cont_b);
            ap.setViewTextColor(this.lji, R.color.cp_cont_b);
            ap.setViewTextColor(this.ljj, R.color.cp_cont_b);
            cKF();
            this.jBV = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ljk != null && this.ljk.topicId > 0) {
            if (this.aiM != null) {
                this.aiM.a(view, this.ljk, this.ljk.index, this.ljk.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.ljk.topicId, null, "5").start();
        }
    }
}

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
/* loaded from: classes15.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> ahY;
    private TextView aiy;
    private TextView aiz;
    private TextView dSD;
    private int iLX;
    private TbImageView iMf;
    private View iMk;
    private TextView jaP;
    private TextView ktc;
    private TextView ktd;
    private TextView kte;
    private b ktf;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.iLX = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.iMk = findViewById(R.id.rootLayout);
        this.iMf = (TbImageView) findViewById(R.id.coverView);
        this.aiy = (TextView) findViewById(R.id.indexView);
        this.dSD = (TextView) findViewById(R.id.titleView);
        this.aiz = (TextView) findViewById(R.id.tagView);
        this.ktc = (TextView) findViewById(R.id.numView);
        this.jaP = (TextView) findViewById(R.id.descView);
        this.ktd = (TextView) findViewById(R.id.titlePre);
        this.kte = (TextView) findViewById(R.id.titleNext);
        this.iMf.setPlaceHolder(1);
        this.iMf.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iMf.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ahY = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ktf = bVar;
            this.iMf.startLoad(bVar.cover, 10, false);
            this.dSD.setText(bVar.title);
            this.jaP.setText(bVar.desc);
            String t = TagTextHelper.t(this.aiz.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSD.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kte.getLayoutParams();
            if (TextUtils.isEmpty(t)) {
                this.aiz.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.aiz.getContext(), R.dimen.tbds42);
                this.dSD.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kte.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.aiz.getContext(), R.dimen.tbds100);
                this.dSD.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kte.setLayoutParams(layoutParams2);
                this.aiz.setVisibility(0);
                this.aiz.setText(t);
            }
            cxI();
            if (bVar.replyNum > 0) {
                this.ktc.setVisibility(0);
                this.ktc.setText(this.ktc.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.cR(bVar.replyNum)));
            } else {
                this.ktc.setVisibility(4);
            }
            this.aiy.setText("" + bVar.index);
        }
    }

    private void cxI() {
        if (this.ktf != null) {
            int nZ = TagTextHelper.nZ(this.ktf.tag);
            Drawable background = this.aiz.getBackground();
            DrawableCompat.setTint(background, ap.getColor(nZ));
            this.aiz.setBackgroundDrawable(background);
            int oa = TagTextHelper.oa(this.ktf.index);
            Drawable background2 = this.aiy.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oa));
            this.aiy.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            a.g(this.iMk, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.aiz, R.color.cp_cont_a);
            ap.setViewTextColor(this.aiy, R.color.cp_cont_a);
            ap.setViewTextColor(this.jaP, R.color.cp_cont_d);
            ap.setViewTextColor(this.ktc, R.color.cp_cont_d);
            ap.setViewTextColor(this.dSD, R.color.cp_cont_b);
            ap.setViewTextColor(this.ktd, R.color.cp_cont_b);
            ap.setViewTextColor(this.kte, R.color.cp_cont_b);
            cxI();
            this.iLX = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ktf != null && this.ktf.topicId > 0) {
            if (this.ahY != null) {
                this.ahY.a(view, this.ktf, this.ktf.index, this.ktf.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.ktf.topicId, null, "5").start();
        }
    }
}

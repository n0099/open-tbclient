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
    private f<b> ahW;
    private TextView aiw;
    private TextView aix;
    private TextView dSz;
    private int iLR;
    private TbImageView iLZ;
    private View iMe;
    private TextView jaJ;
    private TextView ksV;
    private TextView ksW;
    private TextView ksX;
    private b ksY;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.iLR = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLR = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLR = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.iMe = findViewById(R.id.rootLayout);
        this.iLZ = (TbImageView) findViewById(R.id.coverView);
        this.aiw = (TextView) findViewById(R.id.indexView);
        this.dSz = (TextView) findViewById(R.id.titleView);
        this.aix = (TextView) findViewById(R.id.tagView);
        this.ksV = (TextView) findViewById(R.id.numView);
        this.jaJ = (TextView) findViewById(R.id.descView);
        this.ksW = (TextView) findViewById(R.id.titlePre);
        this.ksX = (TextView) findViewById(R.id.titleNext);
        this.iLZ.setPlaceHolder(1);
        this.iLZ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iLZ.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ahW = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ksY = bVar;
            this.iLZ.startLoad(bVar.cover, 10, false);
            this.dSz.setText(bVar.title);
            this.jaJ.setText(bVar.desc);
            String t = TagTextHelper.t(this.aix.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSz.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ksX.getLayoutParams();
            if (TextUtils.isEmpty(t)) {
                this.aix.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.aix.getContext(), R.dimen.tbds42);
                this.dSz.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ksX.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.aix.getContext(), R.dimen.tbds100);
                this.dSz.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ksX.setLayoutParams(layoutParams2);
                this.aix.setVisibility(0);
                this.aix.setText(t);
            }
            cxH();
            if (bVar.replyNum > 0) {
                this.ksV.setVisibility(0);
                this.ksV.setText(this.ksV.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.cR(bVar.replyNum)));
            } else {
                this.ksV.setVisibility(4);
            }
            this.aiw.setText("" + bVar.index);
        }
    }

    private void cxH() {
        if (this.ksY != null) {
            int nZ = TagTextHelper.nZ(this.ksY.tag);
            Drawable background = this.aix.getBackground();
            DrawableCompat.setTint(background, ap.getColor(nZ));
            this.aix.setBackgroundDrawable(background);
            int oa = TagTextHelper.oa(this.ksY.index);
            Drawable background2 = this.aiw.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oa));
            this.aiw.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            a.g(this.iMe, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.aix, R.color.cp_cont_a);
            ap.setViewTextColor(this.aiw, R.color.cp_cont_a);
            ap.setViewTextColor(this.jaJ, R.color.cp_cont_d);
            ap.setViewTextColor(this.ksV, R.color.cp_cont_d);
            ap.setViewTextColor(this.dSz, R.color.cp_cont_b);
            ap.setViewTextColor(this.ksW, R.color.cp_cont_b);
            ap.setViewTextColor(this.ksX, R.color.cp_cont_b);
            cxH();
            this.iLR = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ksY != null && this.ksY.topicId > 0) {
            if (this.ahW != null) {
                this.ahW.a(view, this.ksY, this.ksY.index, this.ksY.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.ksY.topicId, null, "5").start();
        }
    }
}

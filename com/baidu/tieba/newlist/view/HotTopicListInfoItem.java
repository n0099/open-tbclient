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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newlist.b.b;
/* loaded from: classes15.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> agN;
    private TextView dJr;
    private TextView iLL;
    private int iwV;
    private TextView ixh;
    private TextView ixi;
    private TbImageView ixo;
    private View ixt;
    private TextView kdA;
    private TextView kdB;
    private b kdC;
    private TextView kdz;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.iwV = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwV = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwV = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.ixt = findViewById(R.id.rootLayout);
        this.ixo = (TbImageView) findViewById(R.id.coverView);
        this.ixh = (TextView) findViewById(R.id.indexView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.ixi = (TextView) findViewById(R.id.tagView);
        this.kdz = (TextView) findViewById(R.id.numView);
        this.iLL = (TextView) findViewById(R.id.descView);
        this.kdA = (TextView) findViewById(R.id.titlePre);
        this.kdB = (TextView) findViewById(R.id.titleNext);
        this.ixo.setPlaceHolder(1);
        this.ixo.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ixo.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.agN = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.kdC = bVar;
            this.ixo.startLoad(bVar.cover, 10, false);
            this.dJr.setText(bVar.title);
            this.iLL.setText(bVar.desc);
            String s = TagTextHelper.s(this.ixi.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJr.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kdB.getLayoutParams();
            if (TextUtils.isEmpty(s)) {
                this.ixi.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ixi.getContext(), R.dimen.tbds42);
                this.dJr.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kdB.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ixi.getContext(), R.dimen.tbds100);
                this.dJr.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kdB.setLayoutParams(layoutParams2);
                this.ixi.setVisibility(0);
                this.ixi.setText(s);
            }
            cmS();
            if (bVar.replyNum > 0) {
                this.kdz.setVisibility(0);
                this.kdz.setText(this.kdz.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, as.cG(bVar.replyNum)));
            } else {
                this.kdz.setVisibility(4);
            }
            this.ixh.setText("" + bVar.index);
        }
    }

    private void cmS() {
        if (this.kdC != null) {
            int lT = TagTextHelper.lT(this.kdC.tag);
            Drawable background = this.ixi.getBackground();
            DrawableCompat.setTint(background, ao.getColor(lT));
            this.ixi.setBackgroundDrawable(background);
            int lU = TagTextHelper.lU(this.kdC.index);
            Drawable background2 = this.ixh.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(lU));
            this.ixh.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwV != i) {
            a.h(this.ixt, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.ixi, R.color.cp_cont_a);
            ao.setViewTextColor(this.ixh, R.color.cp_cont_a);
            ao.setViewTextColor(this.iLL, R.color.cp_cont_d);
            ao.setViewTextColor(this.kdz, R.color.cp_cont_d);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
            ao.setViewTextColor(this.kdA, R.color.cp_cont_b);
            ao.setViewTextColor(this.kdB, R.color.cp_cont_b);
            cmS();
            this.iwV = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kdC != null && this.kdC.topicId > 0) {
            if (this.agN != null) {
                this.agN.a(view, this.kdC, this.kdC.index, this.kdC.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.kdC.topicId, null, "5").start();
        }
    }
}

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
    private TextView iLJ;
    private int iwT;
    private TextView ixf;
    private TextView ixg;
    private TbImageView ixm;
    private View ixr;
    private b kdA;
    private TextView kdx;
    private TextView kdy;
    private TextView kdz;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.iwT = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwT = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwT = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.ixr = findViewById(R.id.rootLayout);
        this.ixm = (TbImageView) findViewById(R.id.coverView);
        this.ixf = (TextView) findViewById(R.id.indexView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.ixg = (TextView) findViewById(R.id.tagView);
        this.kdx = (TextView) findViewById(R.id.numView);
        this.iLJ = (TextView) findViewById(R.id.descView);
        this.kdy = (TextView) findViewById(R.id.titlePre);
        this.kdz = (TextView) findViewById(R.id.titleNext);
        this.ixm.setPlaceHolder(1);
        this.ixm.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ixm.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.agN = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.kdA = bVar;
            this.ixm.startLoad(bVar.cover, 10, false);
            this.dJr.setText(bVar.title);
            this.iLJ.setText(bVar.desc);
            String s = TagTextHelper.s(this.ixg.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJr.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kdz.getLayoutParams();
            if (TextUtils.isEmpty(s)) {
                this.ixg.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ixg.getContext(), R.dimen.tbds42);
                this.dJr.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kdz.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ixg.getContext(), R.dimen.tbds100);
                this.dJr.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kdz.setLayoutParams(layoutParams2);
                this.ixg.setVisibility(0);
                this.ixg.setText(s);
            }
            cmS();
            if (bVar.replyNum > 0) {
                this.kdx.setVisibility(0);
                this.kdx.setText(this.kdx.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, as.cG(bVar.replyNum)));
            } else {
                this.kdx.setVisibility(4);
            }
            this.ixf.setText("" + bVar.index);
        }
    }

    private void cmS() {
        if (this.kdA != null) {
            int lT = TagTextHelper.lT(this.kdA.tag);
            Drawable background = this.ixg.getBackground();
            DrawableCompat.setTint(background, ao.getColor(lT));
            this.ixg.setBackgroundDrawable(background);
            int lU = TagTextHelper.lU(this.kdA.index);
            Drawable background2 = this.ixf.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(lU));
            this.ixf.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwT != i) {
            a.h(this.ixr, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.ixg, R.color.cp_cont_a);
            ao.setViewTextColor(this.ixf, R.color.cp_cont_a);
            ao.setViewTextColor(this.iLJ, R.color.cp_cont_d);
            ao.setViewTextColor(this.kdx, R.color.cp_cont_d);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
            ao.setViewTextColor(this.kdy, R.color.cp_cont_b);
            ao.setViewTextColor(this.kdz, R.color.cp_cont_b);
            cmS();
            this.iwT = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kdA != null && this.kdA.topicId > 0) {
            if (this.agN != null) {
                this.agN.a(view, this.kdA, this.kdA.index, this.kdA.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.kdA.topicId, null, "5").start();
        }
    }
}

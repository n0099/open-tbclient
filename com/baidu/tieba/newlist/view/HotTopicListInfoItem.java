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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newlist.b.b;
/* loaded from: classes8.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> agW;
    private TextView dDu;
    private TextView iFF;
    private int iqP;
    private TextView irb;
    private TextView irc;
    private TbImageView iri;
    private View irn;
    private TextView jUY;
    private TextView jUZ;
    private TextView jVa;
    private b jVb;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.iqP = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqP = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqP = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.irn = findViewById(R.id.rootLayout);
        this.iri = (TbImageView) findViewById(R.id.coverView);
        this.irb = (TextView) findViewById(R.id.indexView);
        this.dDu = (TextView) findViewById(R.id.titleView);
        this.irc = (TextView) findViewById(R.id.tagView);
        this.jUY = (TextView) findViewById(R.id.numView);
        this.iFF = (TextView) findViewById(R.id.descView);
        this.jUZ = (TextView) findViewById(R.id.titlePre);
        this.jVa = (TextView) findViewById(R.id.titleNext);
        this.iri.setPlaceHolder(1);
        this.iri.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iri.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.agW = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.jVb = bVar;
            this.iri.startLoad(bVar.cover, 10, false);
            this.dDu.setText(bVar.title);
            this.iFF.setText(bVar.desc);
            String s = TagTextHelper.s(this.irc.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDu.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jVa.getLayoutParams();
            if (TextUtils.isEmpty(s)) {
                this.irc.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.irc.getContext(), R.dimen.tbds42);
                this.dDu.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.jVa.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.irc.getContext(), R.dimen.tbds100);
                this.dDu.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.jVa.setLayoutParams(layoutParams2);
                this.irc.setVisibility(0);
                this.irc.setText(s);
            }
            cjq();
            if (bVar.replyNum > 0) {
                this.jUY.setVisibility(0);
                this.jUY.setText(this.jUY.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, ar.cn(bVar.replyNum)));
            } else {
                this.jUY.setVisibility(4);
            }
            this.irb.setText("" + bVar.index);
        }
    }

    private void cjq() {
        if (this.jVb != null) {
            int lz = TagTextHelper.lz(this.jVb.tag);
            Drawable background = this.irc.getBackground();
            DrawableCompat.setTint(background, an.getColor(lz));
            this.irc.setBackgroundDrawable(background);
            int lA = TagTextHelper.lA(this.jVb.index);
            Drawable background2 = this.irb.getBackground();
            DrawableCompat.setTint(background2, an.getColor(lA));
            this.irb.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqP != i) {
            a.f(this.irn, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            an.setViewTextColor(this.irc, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.irb, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.iFF, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jUY, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.dDu, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jUZ, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jVa, (int) R.color.cp_cont_b);
            cjq();
            this.iqP = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jVb != null && this.jVb.topicId > 0) {
            if (this.agW != null) {
                this.agW.a(view, this.jVb, this.jVb.index, this.jVb.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.jVb.topicId, null, "5").start();
        }
    }
}

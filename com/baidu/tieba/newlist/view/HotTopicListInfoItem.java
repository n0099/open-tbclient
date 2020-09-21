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
/* loaded from: classes20.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private TextView aiS;
    private TextView aiT;
    private f<b> ait;
    private TextView dUN;
    private int iUD;
    private TbImageView iUL;
    private View iUQ;
    private TextView jjv;
    private TextView kBB;
    private TextView kBC;
    private TextView kBD;
    private b kBE;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.iUD = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.iUQ = findViewById(R.id.rootLayout);
        this.iUL = (TbImageView) findViewById(R.id.coverView);
        this.aiS = (TextView) findViewById(R.id.indexView);
        this.dUN = (TextView) findViewById(R.id.titleView);
        this.aiT = (TextView) findViewById(R.id.tagView);
        this.kBB = (TextView) findViewById(R.id.numView);
        this.jjv = (TextView) findViewById(R.id.descView);
        this.kBC = (TextView) findViewById(R.id.titlePre);
        this.kBD = (TextView) findViewById(R.id.titleNext);
        this.iUL.setPlaceHolder(1);
        this.iUL.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iUL.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ait = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.kBE = bVar;
            this.iUL.startLoad(bVar.cover, 10, false);
            this.dUN.setText(bVar.title);
            this.jjv.setText(bVar.desc);
            String t = TagTextHelper.t(this.aiT.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUN.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kBD.getLayoutParams();
            if (TextUtils.isEmpty(t)) {
                this.aiT.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.aiT.getContext(), R.dimen.tbds42);
                this.dUN.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kBD.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.aiT.getContext(), R.dimen.tbds100);
                this.dUN.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kBD.setLayoutParams(layoutParams2);
                this.aiT.setVisibility(0);
                this.aiT.setText(t);
            }
            cBq();
            if (bVar.replyNum > 0) {
                this.kBB.setVisibility(0);
                this.kBB.setText(this.kBB.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.cS(bVar.replyNum)));
            } else {
                this.kBB.setVisibility(4);
            }
            this.aiS.setText("" + bVar.index);
        }
    }

    private void cBq() {
        if (this.kBE != null) {
            int ol = TagTextHelper.ol(this.kBE.tag);
            Drawable background = this.aiT.getBackground();
            DrawableCompat.setTint(background, ap.getColor(ol));
            this.aiT.setBackgroundDrawable(background);
            int om = TagTextHelper.om(this.kBE.index);
            Drawable background2 = this.aiS.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(om));
            this.aiS.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            a.g(this.iUQ, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.aiT, R.color.cp_cont_a);
            ap.setViewTextColor(this.aiS, R.color.cp_cont_a);
            ap.setViewTextColor(this.jjv, R.color.cp_cont_d);
            ap.setViewTextColor(this.kBB, R.color.cp_cont_d);
            ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
            ap.setViewTextColor(this.kBC, R.color.cp_cont_b);
            ap.setViewTextColor(this.kBD, R.color.cp_cont_b);
            cBq();
            this.iUD = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kBE != null && this.kBE.topicId > 0) {
            if (this.ait != null) {
                this.ait.a(view, this.kBE, this.kBE.index, this.kBE.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.kBE.topicId, null, "5").start();
        }
    }
}

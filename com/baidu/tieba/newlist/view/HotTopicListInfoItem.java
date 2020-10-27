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
    private TextView epn;
    private TextView jKS;
    private int jvY;
    private TbImageView jwg;
    private View jwl;
    private TextView ldk;
    private TextView ldl;
    private TextView ldm;
    private b ldn;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.jvY = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvY = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvY = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.jwl = findViewById(R.id.rootLayout);
        this.jwg = (TbImageView) findViewById(R.id.coverView);
        this.ajl = (TextView) findViewById(R.id.indexView);
        this.epn = (TextView) findViewById(R.id.titleView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.ldk = (TextView) findViewById(R.id.numView);
        this.jKS = (TextView) findViewById(R.id.descView);
        this.ldl = (TextView) findViewById(R.id.titlePre);
        this.ldm = (TextView) findViewById(R.id.titleNext);
        this.jwg.setPlaceHolder(1);
        this.jwg.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jwg.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aiM = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ldn = bVar;
            this.jwg.startLoad(bVar.cover, 10, false);
            this.epn.setText(bVar.title);
            this.jKS.setText(bVar.desc);
            String t = TagTextHelper.t(this.ajm.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.epn.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ldm.getLayoutParams();
            if (TextUtils.isEmpty(t)) {
                this.ajm.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ajm.getContext(), R.dimen.tbds42);
                this.epn.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ldm.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ajm.getContext(), R.dimen.tbds100);
                this.epn.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.ldm.setLayoutParams(layoutParams2);
                this.ajm.setVisibility(0);
                this.ajm.setText(t);
            }
            cIe();
            if (bVar.replyNum > 0) {
                this.ldk.setVisibility(0);
                this.ldk.setText(this.ldk.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.dc(bVar.replyNum)));
            } else {
                this.ldk.setVisibility(4);
            }
            this.ajl.setText("" + bVar.index);
        }
    }

    private void cIe() {
        if (this.ldn != null) {
            int oT = TagTextHelper.oT(this.ldn.tag);
            Drawable background = this.ajm.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oT));
            this.ajm.setBackgroundDrawable(background);
            int oU = TagTextHelper.oU(this.ldn.index);
            Drawable background2 = this.ajl.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oU));
            this.ajl.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            a.g(this.jwl, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.ajm, R.color.cp_cont_a);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.jKS, R.color.cp_cont_d);
            ap.setViewTextColor(this.ldk, R.color.cp_cont_d);
            ap.setViewTextColor(this.epn, R.color.cp_cont_b);
            ap.setViewTextColor(this.ldl, R.color.cp_cont_b);
            ap.setViewTextColor(this.ldm, R.color.cp_cont_b);
            cIe();
            this.jvY = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ldn != null && this.ldn.topicId > 0) {
            if (this.aiM != null) {
                this.aiM.a(view, this.ldn, this.ldn.index, this.ldn.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.ldn.topicId, null, "5").start();
        }
    }
}

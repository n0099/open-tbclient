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
    private f<b> aiL;
    private TextView ajk;
    private TextView ajl;
    private TextView egP;
    private int jjB;
    private TbImageView jjJ;
    private View jjO;
    private TextView jyt;
    private TextView kQM;
    private TextView kQN;
    private TextView kQO;
    private b kQP;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.jjB = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.jjO = findViewById(R.id.rootLayout);
        this.jjJ = (TbImageView) findViewById(R.id.coverView);
        this.ajk = (TextView) findViewById(R.id.indexView);
        this.egP = (TextView) findViewById(R.id.titleView);
        this.ajl = (TextView) findViewById(R.id.tagView);
        this.kQM = (TextView) findViewById(R.id.numView);
        this.jyt = (TextView) findViewById(R.id.descView);
        this.kQN = (TextView) findViewById(R.id.titlePre);
        this.kQO = (TextView) findViewById(R.id.titleNext);
        this.jjJ.setPlaceHolder(1);
        this.jjJ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jjJ.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aiL = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.kQP = bVar;
            this.jjJ.startLoad(bVar.cover, 10, false);
            this.egP.setText(bVar.title);
            this.jyt.setText(bVar.desc);
            String t = TagTextHelper.t(this.ajl.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egP.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kQO.getLayoutParams();
            if (TextUtils.isEmpty(t)) {
                this.ajl.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ajl.getContext(), R.dimen.tbds42);
                this.egP.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kQO.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ajl.getContext(), R.dimen.tbds100);
                this.egP.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.kQO.setLayoutParams(layoutParams2);
                this.ajl.setVisibility(0);
                this.ajl.setText(t);
            }
            cEX();
            if (bVar.replyNum > 0) {
                this.kQM.setVisibility(0);
                this.kQM.setText(this.kQM.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, at.da(bVar.replyNum)));
            } else {
                this.kQM.setVisibility(4);
            }
            this.ajk.setText("" + bVar.index);
        }
    }

    private void cEX() {
        if (this.kQP != null) {
            int oI = TagTextHelper.oI(this.kQP.tag);
            Drawable background = this.ajl.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oI));
            this.ajl.setBackgroundDrawable(background);
            int oJ = TagTextHelper.oJ(this.kQP.index);
            Drawable background2 = this.ajk.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oJ));
            this.ajk.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            a.g(this.jjO, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.ajk, R.color.cp_cont_a);
            ap.setViewTextColor(this.jyt, R.color.cp_cont_d);
            ap.setViewTextColor(this.kQM, R.color.cp_cont_d);
            ap.setViewTextColor(this.egP, R.color.cp_cont_b);
            ap.setViewTextColor(this.kQN, R.color.cp_cont_b);
            ap.setViewTextColor(this.kQO, R.color.cp_cont_b);
            cEX();
            this.jjB = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kQP != null && this.kQP.topicId > 0) {
            if (this.aiL != null) {
                this.aiL.a(view, this.kQP, this.kQP.index, this.kQP.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.kQP.topicId, null, "5").start();
        }
    }
}

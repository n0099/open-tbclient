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
/* loaded from: classes21.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> ajQ;
    private TextView akp;
    private TextView akq;
    private TextView eAz;
    private TbImageView jQE;
    private View jQJ;
    private int jQw;
    private TextView kfg;
    private TextView lwZ;
    private TextView lxa;
    private TextView lxb;
    private b lxc;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.jQw = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.jQJ = findViewById(R.id.rootLayout);
        this.jQE = (TbImageView) findViewById(R.id.coverView);
        this.akp = (TextView) findViewById(R.id.indexView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.lwZ = (TextView) findViewById(R.id.numView);
        this.kfg = (TextView) findViewById(R.id.descView);
        this.lxa = (TextView) findViewById(R.id.titlePre);
        this.lxb = (TextView) findViewById(R.id.titleNext);
        this.jQE.setPlaceHolder(1);
        this.jQE.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jQE.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajQ = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lxc = bVar;
            this.jQE.startLoad(bVar.cover, 10, false);
            this.eAz.setText(bVar.title);
            this.kfg.setText(bVar.desc);
            String C = TagTextHelper.C(this.akq.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAz.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lxb.getLayoutParams();
            if (TextUtils.isEmpty(C)) {
                this.akq.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.akq.getContext(), R.dimen.tbds42);
                this.eAz.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lxb.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.akq.getContext(), R.dimen.tbds100);
                this.eAz.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lxb.setLayoutParams(layoutParams2);
                this.akq.setVisibility(0);
                this.akq.setText(C);
            }
            cPA();
            if (bVar.replyNum > 0) {
                this.lwZ.setVisibility(0);
                this.lwZ.setText(this.lwZ.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, au.dX(bVar.replyNum)));
            } else {
                this.lwZ.setVisibility(4);
            }
            this.akp.setText("" + bVar.index);
        }
    }

    private void cPA() {
        if (this.lxc != null) {
            int pZ = TagTextHelper.pZ(this.lxc.tag);
            Drawable background = this.akq.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pZ));
            this.akq.setBackgroundDrawable(background);
            int qa = TagTextHelper.qa(this.lxc.index);
            Drawable background2 = this.akp.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(qa));
            this.akp.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            a.g(this.jQJ, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.akq, R.color.CAM_X0101);
            ap.setViewTextColor(this.akp, R.color.CAM_X0101);
            ap.setViewTextColor(this.kfg, R.color.CAM_X0109);
            ap.setViewTextColor(this.lwZ, R.color.CAM_X0109);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
            ap.setViewTextColor(this.lxa, R.color.CAM_X0105);
            ap.setViewTextColor(this.lxb, R.color.CAM_X0105);
            cPA();
            this.jQw = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lxc != null && this.lxc.topicId > 0) {
            if (this.ajQ != null) {
                this.ajQ.a(view, this.lxc, this.lxc.index, this.lxc.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.lxc.topicId, null, "5").start();
        }
    }
}

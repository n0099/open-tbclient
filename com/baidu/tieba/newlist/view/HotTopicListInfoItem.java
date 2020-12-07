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
    private TbImageView jQC;
    private View jQH;
    private int jQu;
    private TextView kfe;
    private TextView lwX;
    private TextView lwY;
    private TextView lwZ;
    private b lxa;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.jQu = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQu = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQu = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.jQH = findViewById(R.id.rootLayout);
        this.jQC = (TbImageView) findViewById(R.id.coverView);
        this.akp = (TextView) findViewById(R.id.indexView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.lwX = (TextView) findViewById(R.id.numView);
        this.kfe = (TextView) findViewById(R.id.descView);
        this.lwY = (TextView) findViewById(R.id.titlePre);
        this.lwZ = (TextView) findViewById(R.id.titleNext);
        this.jQC.setPlaceHolder(1);
        this.jQC.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jQC.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajQ = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lxa = bVar;
            this.jQC.startLoad(bVar.cover, 10, false);
            this.eAz.setText(bVar.title);
            this.kfe.setText(bVar.desc);
            String C = TagTextHelper.C(this.akq.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAz.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lwZ.getLayoutParams();
            if (TextUtils.isEmpty(C)) {
                this.akq.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.akq.getContext(), R.dimen.tbds42);
                this.eAz.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lwZ.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.akq.getContext(), R.dimen.tbds100);
                this.eAz.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lwZ.setLayoutParams(layoutParams2);
                this.akq.setVisibility(0);
                this.akq.setText(C);
            }
            cPz();
            if (bVar.replyNum > 0) {
                this.lwX.setVisibility(0);
                this.lwX.setText(this.lwX.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, au.dX(bVar.replyNum)));
            } else {
                this.lwX.setVisibility(4);
            }
            this.akp.setText("" + bVar.index);
        }
    }

    private void cPz() {
        if (this.lxa != null) {
            int pZ = TagTextHelper.pZ(this.lxa.tag);
            Drawable background = this.akq.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pZ));
            this.akq.setBackgroundDrawable(background);
            int qa = TagTextHelper.qa(this.lxa.index);
            Drawable background2 = this.akp.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(qa));
            this.akp.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQu != i) {
            a.g(this.jQH, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.akq, R.color.CAM_X0101);
            ap.setViewTextColor(this.akp, R.color.CAM_X0101);
            ap.setViewTextColor(this.kfe, R.color.CAM_X0109);
            ap.setViewTextColor(this.lwX, R.color.CAM_X0109);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
            ap.setViewTextColor(this.lwY, R.color.CAM_X0105);
            ap.setViewTextColor(this.lwZ, R.color.CAM_X0105);
            cPz();
            this.jQu = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lxa != null && this.lxa.topicId > 0) {
            if (this.ajQ != null) {
                this.ajQ.a(view, this.lxa, this.lxa.index, this.lxa.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.lxa.topicId, null, "5").start();
        }
    }
}

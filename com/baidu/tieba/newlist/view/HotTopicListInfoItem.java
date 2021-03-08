package com.baidu.tieba.newlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.f.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newlist.b.b;
/* loaded from: classes7.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    private f<b> akI;
    private TextView alh;
    private TextView ali;
    private TextView eIY;
    private int kiZ;
    private TbImageView kjh;
    private View kjm;
    private TextView kyk;
    private TextView lHV;
    private TextView lHW;
    private TextView lHX;
    private b lHY;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.kiZ = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        initView();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.kjm = findViewById(R.id.rootLayout);
        this.kjh = (TbImageView) findViewById(R.id.coverView);
        this.alh = (TextView) findViewById(R.id.indexView);
        this.eIY = (TextView) findViewById(R.id.titleView);
        this.ali = (TextView) findViewById(R.id.tagView);
        this.lHV = (TextView) findViewById(R.id.numView);
        this.kyk = (TextView) findViewById(R.id.descView);
        this.lHW = (TextView) findViewById(R.id.titlePre);
        this.lHX = (TextView) findViewById(R.id.titleNext);
        this.kjh.setPlaceHolder(1);
        this.kjh.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kjh.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.akI = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lHY = bVar;
            this.kjh.startLoad(bVar.cover, 10, false);
            this.eIY.setText(bVar.title);
            this.kyk.setText(bVar.desc);
            String D = TagTextHelper.D(this.ali.getContext(), bVar.tag);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIY.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lHX.getLayoutParams();
            if (TextUtils.isEmpty(D)) {
                this.ali.setVisibility(8);
                layoutParams.rightMargin = l.getDimens(this.ali.getContext(), R.dimen.tbds42);
                this.eIY.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lHX.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ali.getContext(), R.dimen.tbds100);
                this.eIY.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.lHX.setLayoutParams(layoutParams2);
                this.ali.setVisibility(0);
                this.ali.setText(D);
            }
            cRa();
            if (bVar.replyNum > 0) {
                this.lHV.setVisibility(0);
                this.lHV.setText(this.lHV.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, au.ed(bVar.replyNum)));
            } else {
                this.lHV.setVisibility(4);
            }
            this.alh.setText("" + bVar.index);
        }
    }

    private void cRa() {
        if (this.lHY != null) {
            int oJ = TagTextHelper.oJ(this.lHY.tag);
            Drawable background = this.ali.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oJ));
            this.ali.setBackgroundDrawable(background);
            int oK = TagTextHelper.oK(this.lHY.index);
            Drawable background2 = this.alh.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oK));
            this.alh.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            a.m(this.kjm, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.ali, R.color.CAM_X0101);
            ap.setViewTextColor(this.alh, R.color.CAM_X0101);
            ap.setViewTextColor(this.kyk, R.color.CAM_X0109);
            ap.setViewTextColor(this.lHV, R.color.CAM_X0109);
            ap.setViewTextColor(this.eIY, R.color.CAM_X0105);
            ap.setViewTextColor(this.lHW, R.color.CAM_X0105);
            ap.setViewTextColor(this.lHX, R.color.CAM_X0105);
            cRa();
            this.kiZ = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lHY != null && this.lHY.topicId > 0) {
            if (this.akI != null) {
                this.akI.a(view, this.lHY, this.lHY.index, this.lHY.topicId);
            }
            new HotTopicActivityConfig(getContext()).createNormalConfig("" + this.lHY.topicId, null, "5").start();
        }
    }
}

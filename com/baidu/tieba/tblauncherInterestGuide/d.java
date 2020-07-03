package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes9.dex */
public class d extends Dialog implements a {
    private View djj;
    private View lMT;
    private LinearLayout lMW;
    private InterestFrsData.Tag lNc;
    private c lNd;
    private GridView lNe;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.djj = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.lNd = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.lMW = (LinearLayout) this.djj.findViewById(R.id.box_close_layout);
        this.lNe = (GridView) this.djj.findViewById(R.id.layout_content);
        this.lNe.setAdapter((ListAdapter) this.lNd);
        this.lNe.setSelector(R.color.common_color_10022);
        setContentView(this.djj);
        this.mTitle = (TextView) this.djj.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.djj.findViewById(R.id.prompt_sub_title);
        this.lMT = this.djj.findViewById(R.id.view_layout);
        this.lMT.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.lNc = tag;
        if (this.lNc != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.lNd.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Fq(int i) {
        this.lNd.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Fr(int i) {
        this.lNd.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lMW.setOnClickListener(onClickListener);
        this.lNd.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.djj;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.dismissDialog(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

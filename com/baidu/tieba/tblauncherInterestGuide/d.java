package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class d extends Dialog implements a {
    private View bSa;
    private View hvg;
    private LinearLayout hvj;
    private InterestFrsData.Tag hvr;
    private c hvs;
    private GridView hvt;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bSa = View.inflate(this.mContext, e.h.new_user_img_box, null);
        this.hvs = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hvj = (LinearLayout) this.bSa.findViewById(e.g.box_close_layout);
        this.hvt = (GridView) this.bSa.findViewById(e.g.layout_content);
        this.hvt.setAdapter((ListAdapter) this.hvs);
        this.hvt.setSelector(e.d.common_color_10022);
        setContentView(this.bSa);
        this.mTitle = (TextView) this.bSa.findViewById(e.g.prompt_title);
        this.mSubTitle = (TextView) this.bSa.findViewById(e.g.prompt_sub_title);
        this.hvg = this.bSa.findViewById(e.g.view_layout);
        this.hvg.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hvr = tag;
        if (this.hvr != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.hvs.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wa(int i) {
        this.hvs.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wb(int i) {
        this.hvs.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hvj.setOnClickListener(onClickListener);
        this.hvs.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bSa;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

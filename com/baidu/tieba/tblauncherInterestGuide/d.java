package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class d extends Dialog implements a {
    private View cex;
    private TextView eTY;
    private View hfN;
    private LinearLayout hfQ;
    private InterestFrsData.Tag hfY;
    private c hfZ;
    private GridView hga;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cex = View.inflate(this.mContext, d.h.new_user_img_box, null);
        this.hfZ = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hfQ = (LinearLayout) this.cex.findViewById(d.g.box_close_layout);
        this.hga = (GridView) this.cex.findViewById(d.g.layout_content);
        this.hga.setAdapter((ListAdapter) this.hfZ);
        this.hga.setSelector(d.C0141d.common_color_10022);
        setContentView(this.cex);
        this.mTitle = (TextView) this.cex.findViewById(d.g.prompt_title);
        this.eTY = (TextView) this.cex.findViewById(d.g.prompt_sub_title);
        this.hfN = this.cex.findViewById(d.g.view_layout);
        this.hfN.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hfY = tag;
        if (this.hfY != null) {
            this.mTitle.setText(tag.getBname());
            this.eTY.setText(tag.getBdesc());
            this.hfZ.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wh(int i) {
        this.hfZ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wi(int i) {
        this.hfZ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hfQ.setOnClickListener(onClickListener);
        this.hfZ.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cex;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.g.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

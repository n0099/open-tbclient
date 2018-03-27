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
    private View ceA;
    private TextView eUm;
    private View hgl;
    private LinearLayout hgo;
    private InterestFrsData.Tag hgw;
    private c hgx;
    private GridView hgy;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.ceA = View.inflate(this.mContext, d.h.new_user_img_box, null);
        this.hgx = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hgo = (LinearLayout) this.ceA.findViewById(d.g.box_close_layout);
        this.hgy = (GridView) this.ceA.findViewById(d.g.layout_content);
        this.hgy.setAdapter((ListAdapter) this.hgx);
        this.hgy.setSelector(d.C0141d.common_color_10022);
        setContentView(this.ceA);
        this.mTitle = (TextView) this.ceA.findViewById(d.g.prompt_title);
        this.eUm = (TextView) this.ceA.findViewById(d.g.prompt_sub_title);
        this.hgl = this.ceA.findViewById(d.g.view_layout);
        this.hgl.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hgw = tag;
        if (this.hgw != null) {
            this.mTitle.setText(tag.getBname());
            this.eUm.setText(tag.getBdesc());
            this.hgx.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wh(int i) {
        this.hgx.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wi(int i) {
        this.hgx.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hgo.setOnClickListener(onClickListener);
        this.hgx.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.ceA;
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

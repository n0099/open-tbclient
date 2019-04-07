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
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes4.dex */
public class d extends Dialog implements a {
    private TextView aGj;
    private View dcP;
    private View iML;
    private LinearLayout iMO;
    private InterestFrsData.Tag iMW;
    private c iMX;
    private GridView iMY;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dcP = View.inflate(this.mContext, d.h.new_user_img_box, null);
        this.iMX = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.iMO = (LinearLayout) this.dcP.findViewById(d.g.box_close_layout);
        this.iMY = (GridView) this.dcP.findViewById(d.g.layout_content);
        this.iMY.setAdapter((ListAdapter) this.iMX);
        this.iMY.setSelector(d.C0277d.common_color_10022);
        setContentView(this.dcP);
        this.mTitle = (TextView) this.dcP.findViewById(d.g.prompt_title);
        this.aGj = (TextView) this.dcP.findViewById(d.g.prompt_sub_title);
        this.iML = this.dcP.findViewById(d.g.view_layout);
        this.iML.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.iMW = tag;
        if (this.iMW != null) {
            this.mTitle.setText(tag.getBname());
            this.aGj.setText(tag.getBdesc());
            this.iMX.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zI(int i) {
        this.iMX.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zJ(int i) {
        this.iMX.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMO.setOnClickListener(onClickListener);
        this.iMX.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dcP;
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

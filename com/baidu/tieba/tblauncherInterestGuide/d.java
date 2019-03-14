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
    private TextView aGg;
    private View dcL;
    private View iMX;
    private LinearLayout iNa;
    private InterestFrsData.Tag iNi;
    private c iNj;
    private GridView iNk;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dcL = View.inflate(this.mContext, d.h.new_user_img_box, null);
        this.iNj = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.iNa = (LinearLayout) this.dcL.findViewById(d.g.box_close_layout);
        this.iNk = (GridView) this.dcL.findViewById(d.g.layout_content);
        this.iNk.setAdapter((ListAdapter) this.iNj);
        this.iNk.setSelector(d.C0277d.common_color_10022);
        setContentView(this.dcL);
        this.mTitle = (TextView) this.dcL.findViewById(d.g.prompt_title);
        this.aGg = (TextView) this.dcL.findViewById(d.g.prompt_sub_title);
        this.iMX = this.dcL.findViewById(d.g.view_layout);
        this.iMX.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.iNi = tag;
        if (this.iNi != null) {
            this.mTitle.setText(tag.getBname());
            this.aGg.setText(tag.getBdesc());
            this.iNj.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zM(int i) {
        this.iNj.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zN(int i) {
        this.iNj.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iNa.setOnClickListener(onClickListener);
        this.iNj.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dcL;
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

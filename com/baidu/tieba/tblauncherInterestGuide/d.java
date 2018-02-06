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
    private View ceJ;
    private TextView eUk;
    private View hgc;
    private LinearLayout hgf;
    private InterestFrsData.Tag hgn;
    private c hgo;
    private GridView hgp;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.ceJ = View.inflate(this.mContext, d.h.new_user_img_box, null);
        this.hgo = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hgf = (LinearLayout) this.ceJ.findViewById(d.g.box_close_layout);
        this.hgp = (GridView) this.ceJ.findViewById(d.g.layout_content);
        this.hgp.setAdapter((ListAdapter) this.hgo);
        this.hgp.setSelector(d.C0140d.common_color_10022);
        setContentView(this.ceJ);
        this.mTitle = (TextView) this.ceJ.findViewById(d.g.prompt_title);
        this.eUk = (TextView) this.ceJ.findViewById(d.g.prompt_sub_title);
        this.hgc = this.ceJ.findViewById(d.g.view_layout);
        this.hgc.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hgn = tag;
        if (this.hgn != null) {
            this.mTitle.setText(tag.getBname());
            this.eUk.setText(tag.getBdesc());
            this.hgo.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wg(int i) {
        this.hgo.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wh(int i) {
        this.hgo.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hgf.setOnClickListener(onClickListener);
        this.hgo.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.ceJ;
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

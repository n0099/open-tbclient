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
    private View bES;
    private TextView eQk;
    private View hbG;
    private LinearLayout hbJ;
    private InterestFrsData.Tag hbR;
    private c hbS;
    private GridView hbT;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bES = View.inflate(this.mContext, e.h.new_user_img_box, null);
        this.hbS = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hbJ = (LinearLayout) this.bES.findViewById(e.g.box_close_layout);
        this.hbT = (GridView) this.bES.findViewById(e.g.layout_content);
        this.hbT.setAdapter((ListAdapter) this.hbS);
        this.hbT.setSelector(e.d.common_color_10022);
        setContentView(this.bES);
        this.mTitle = (TextView) this.bES.findViewById(e.g.prompt_title);
        this.eQk = (TextView) this.bES.findViewById(e.g.prompt_sub_title);
        this.hbG = this.bES.findViewById(e.g.view_layout);
        this.hbG.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hbR = tag;
        if (this.hbR != null) {
            this.mTitle.setText(tag.getBname());
            this.eQk.setText(tag.getBdesc());
            this.hbS.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uA(int i) {
        this.hbS.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uB(int i) {
        this.hbS.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hbJ.setOnClickListener(onClickListener);
        this.hbS.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bES;
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

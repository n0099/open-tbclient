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
    private View bOg;
    private View hkI;
    private LinearLayout hkL;
    private InterestFrsData.Tag hkT;
    private c hkU;
    private GridView hkV;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bOg = View.inflate(this.mContext, e.h.new_user_img_box, null);
        this.hkU = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hkL = (LinearLayout) this.bOg.findViewById(e.g.box_close_layout);
        this.hkV = (GridView) this.bOg.findViewById(e.g.layout_content);
        this.hkV.setAdapter((ListAdapter) this.hkU);
        this.hkV.setSelector(e.d.common_color_10022);
        setContentView(this.bOg);
        this.mTitle = (TextView) this.bOg.findViewById(e.g.prompt_title);
        this.mSubTitle = (TextView) this.bOg.findViewById(e.g.prompt_sub_title);
        this.hkI = this.bOg.findViewById(e.g.view_layout);
        this.hkI.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hkT = tag;
        if (this.hkT != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.hkU.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void vq(int i) {
        this.hkU.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void vr(int i) {
        this.hkU.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hkL.setOnClickListener(onClickListener);
        this.hkU.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bOg;
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

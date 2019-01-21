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
    private View bSM;
    private c hwA;
    private GridView hwB;
    private View hwo;
    private LinearLayout hwr;
    private InterestFrsData.Tag hwz;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bSM = View.inflate(this.mContext, e.h.new_user_img_box, null);
        this.hwA = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hwr = (LinearLayout) this.bSM.findViewById(e.g.box_close_layout);
        this.hwB = (GridView) this.bSM.findViewById(e.g.layout_content);
        this.hwB.setAdapter((ListAdapter) this.hwA);
        this.hwB.setSelector(e.d.common_color_10022);
        setContentView(this.bSM);
        this.mTitle = (TextView) this.bSM.findViewById(e.g.prompt_title);
        this.mSubTitle = (TextView) this.bSM.findViewById(e.g.prompt_sub_title);
        this.hwo = this.bSM.findViewById(e.g.view_layout);
        this.hwo.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hwz = tag;
        if (this.hwz != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.hwA.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wd(int i) {
        this.hwA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void we(int i) {
        this.hwA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hwr.setOnClickListener(onClickListener);
        this.hwA.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bSM;
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

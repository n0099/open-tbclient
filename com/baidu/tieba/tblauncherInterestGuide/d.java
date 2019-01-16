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
    private View bSL;
    private GridView hwA;
    private View hwn;
    private LinearLayout hwq;
    private InterestFrsData.Tag hwy;
    private c hwz;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bSL = View.inflate(this.mContext, e.h.new_user_img_box, null);
        this.hwz = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hwq = (LinearLayout) this.bSL.findViewById(e.g.box_close_layout);
        this.hwA = (GridView) this.bSL.findViewById(e.g.layout_content);
        this.hwA.setAdapter((ListAdapter) this.hwz);
        this.hwA.setSelector(e.d.common_color_10022);
        setContentView(this.bSL);
        this.mTitle = (TextView) this.bSL.findViewById(e.g.prompt_title);
        this.mSubTitle = (TextView) this.bSL.findViewById(e.g.prompt_sub_title);
        this.hwn = this.bSL.findViewById(e.g.view_layout);
        this.hwn.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hwy = tag;
        if (this.hwy != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.hwz.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void wd(int i) {
        this.hwz.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void we(int i) {
        this.hwz.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hwq.setOnClickListener(onClickListener);
        this.hwz.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bSL;
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

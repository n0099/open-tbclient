package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes2.dex */
public class d extends Dialog implements a {
    private TextView dvr;
    private View eno;
    private Context mContext;
    private TextView mTitle;
    private View nEP;
    private LinearLayout nER;
    private InterestFrsData.Tag nEX;
    private c nEY;
    private GridView nEZ;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.eno = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nEY = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nER = (LinearLayout) this.eno.findViewById(R.id.box_close_layout);
        this.nEZ = (GridView) this.eno.findViewById(R.id.layout_content);
        this.nEZ.setAdapter((ListAdapter) this.nEY);
        this.nEZ.setSelector(R.color.common_color_10022);
        setContentView(this.eno);
        this.mTitle = (TextView) this.eno.findViewById(R.id.prompt_title);
        this.dvr = (TextView) this.eno.findViewById(R.id.prompt_sub_title);
        this.nEP = this.eno.findViewById(R.id.view_layout);
        this.nEP.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nEX = tag;
        if (this.nEX != null) {
            this.mTitle.setText(tag.getBname());
            this.dvr.setText(tag.getBdesc());
            this.nEY.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Kb(int i) {
        this.nEY.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Kc(int i) {
        this.nEY.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nER.setOnClickListener(onClickListener);
        this.nEY.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.eno;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.dismissDialog(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

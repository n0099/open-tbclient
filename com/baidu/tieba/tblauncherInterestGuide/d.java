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
    private View nEp;
    private LinearLayout nEr;
    private InterestFrsData.Tag nEx;
    private c nEy;
    private GridView nEz;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.eno = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nEy = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nEr = (LinearLayout) this.eno.findViewById(R.id.box_close_layout);
        this.nEz = (GridView) this.eno.findViewById(R.id.layout_content);
        this.nEz.setAdapter((ListAdapter) this.nEy);
        this.nEz.setSelector(R.color.common_color_10022);
        setContentView(this.eno);
        this.mTitle = (TextView) this.eno.findViewById(R.id.prompt_title);
        this.dvr = (TextView) this.eno.findViewById(R.id.prompt_sub_title);
        this.nEp = this.eno.findViewById(R.id.view_layout);
        this.nEp.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nEx = tag;
        if (this.nEx != null) {
            this.mTitle.setText(tag.getBname());
            this.dvr.setText(tag.getBdesc());
            this.nEy.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Kb(int i) {
        this.nEy.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Kc(int i) {
        this.nEy.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nEr.setOnClickListener(onClickListener);
        this.nEy.setOnClickListener(onClickListener);
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

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
    private TextView dwS;
    private View eoR;
    private Context mContext;
    private TextView mTitle;
    private View nGV;
    private LinearLayout nGX;
    private InterestFrsData.Tag nHd;
    private c nHe;
    private GridView nHf;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.eoR = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nHe = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nGX = (LinearLayout) this.eoR.findViewById(R.id.box_close_layout);
        this.nHf = (GridView) this.eoR.findViewById(R.id.layout_content);
        this.nHf.setAdapter((ListAdapter) this.nHe);
        this.nHf.setSelector(R.color.common_color_10022);
        setContentView(this.eoR);
        this.mTitle = (TextView) this.eoR.findViewById(R.id.prompt_title);
        this.dwS = (TextView) this.eoR.findViewById(R.id.prompt_sub_title);
        this.nGV = this.eoR.findViewById(R.id.view_layout);
        this.nGV.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nHd = tag;
        if (this.nHd != null) {
            this.mTitle.setText(tag.getBname());
            this.dwS.setText(tag.getBdesc());
            this.nHe.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Kg(int i) {
        this.nHe.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Kh(int i) {
        this.nHe.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nGX.setOnClickListener(onClickListener);
        this.nHe.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.eoR;
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

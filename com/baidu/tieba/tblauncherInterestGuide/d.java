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
    private TextView dxT;
    private View epV;
    private Context mContext;
    private TextView mTitle;
    private View nzj;
    private LinearLayout nzl;
    private InterestFrsData.Tag nzr;
    private c nzs;
    private GridView nzt;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.epV = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nzs = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nzl = (LinearLayout) this.epV.findViewById(R.id.box_close_layout);
        this.nzt = (GridView) this.epV.findViewById(R.id.layout_content);
        this.nzt.setAdapter((ListAdapter) this.nzs);
        this.nzt.setSelector(R.color.common_color_10022);
        setContentView(this.epV);
        this.mTitle = (TextView) this.epV.findViewById(R.id.prompt_title);
        this.dxT = (TextView) this.epV.findViewById(R.id.prompt_sub_title);
        this.nzj = this.epV.findViewById(R.id.view_layout);
        this.nzj.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nzr = tag;
        if (this.nzr != null) {
            this.mTitle.setText(tag.getBname());
            this.dxT.setText(tag.getBdesc());
            this.nzs.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Lo(int i) {
        this.nzs.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Lp(int i) {
        this.nzs.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nzl.setOnClickListener(onClickListener);
        this.nzs.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.epV;
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

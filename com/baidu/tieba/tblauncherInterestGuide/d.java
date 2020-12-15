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
/* loaded from: classes22.dex */
public class d extends Dialog implements a {
    private View egT;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;
    private View ntl;
    private LinearLayout nto;
    private InterestFrsData.Tag ntu;
    private c ntv;
    private GridView ntw;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.egT = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.ntv = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nto = (LinearLayout) this.egT.findViewById(R.id.box_close_layout);
        this.ntw = (GridView) this.egT.findViewById(R.id.layout_content);
        this.ntw.setAdapter((ListAdapter) this.ntv);
        this.ntw.setSelector(R.color.common_color_10022);
        setContentView(this.egT);
        this.mTitle = (TextView) this.egT.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.egT.findViewById(R.id.prompt_sub_title);
        this.ntl = this.egT.findViewById(R.id.view_layout);
        this.ntl.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.ntu = tag;
        if (this.ntu != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.ntv.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ls(int i) {
        this.ntv.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Lt(int i) {
        this.ntv.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nto.setOnClickListener(onClickListener);
        this.ntv.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.egT;
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

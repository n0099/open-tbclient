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
    private View ntj;
    private LinearLayout ntm;
    private InterestFrsData.Tag nts;
    private c ntt;
    private GridView ntu;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.egT = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.ntt = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.ntm = (LinearLayout) this.egT.findViewById(R.id.box_close_layout);
        this.ntu = (GridView) this.egT.findViewById(R.id.layout_content);
        this.ntu.setAdapter((ListAdapter) this.ntt);
        this.ntu.setSelector(R.color.common_color_10022);
        setContentView(this.egT);
        this.mTitle = (TextView) this.egT.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.egT.findViewById(R.id.prompt_sub_title);
        this.ntj = this.egT.findViewById(R.id.view_layout);
        this.ntj.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nts = tag;
        if (this.nts != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.ntt.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ls(int i) {
        this.ntt.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Lt(int i) {
        this.ntt.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ntm.setOnClickListener(onClickListener);
        this.ntt.setOnClickListener(onClickListener);
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

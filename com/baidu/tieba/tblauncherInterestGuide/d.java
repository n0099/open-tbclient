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
/* loaded from: classes21.dex */
public class d extends Dialog implements a {
    private View dZT;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;
    private View nff;
    private LinearLayout nfi;
    private InterestFrsData.Tag nfo;
    private c nfp;
    private GridView nfq;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dZT = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nfp = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nfi = (LinearLayout) this.dZT.findViewById(R.id.box_close_layout);
        this.nfq = (GridView) this.dZT.findViewById(R.id.layout_content);
        this.nfq.setAdapter((ListAdapter) this.nfp);
        this.nfq.setSelector(R.color.common_color_10022);
        setContentView(this.dZT);
        this.mTitle = (TextView) this.dZT.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dZT.findViewById(R.id.prompt_sub_title);
        this.nff = this.dZT.findViewById(R.id.view_layout);
        this.nff.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nfo = tag;
        if (this.nfo != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.nfp.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void KA(int i) {
        this.nfp.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void KB(int i) {
        this.nfp.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nfi.setOnClickListener(onClickListener);
        this.nfp.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dZT;
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

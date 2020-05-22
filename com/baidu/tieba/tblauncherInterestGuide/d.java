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
/* loaded from: classes9.dex */
public class d extends Dialog implements a {
    private View dex;
    private View lsc;
    private LinearLayout lsf;
    private InterestFrsData.Tag lsl;
    private c lsm;
    private GridView lsn;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dex = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.lsm = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.lsf = (LinearLayout) this.dex.findViewById(R.id.box_close_layout);
        this.lsn = (GridView) this.dex.findViewById(R.id.layout_content);
        this.lsn.setAdapter((ListAdapter) this.lsm);
        this.lsn.setSelector(R.color.common_color_10022);
        setContentView(this.dex);
        this.mTitle = (TextView) this.dex.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dex.findViewById(R.id.prompt_sub_title);
        this.lsc = this.dex.findViewById(R.id.view_layout);
        this.lsc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.lsl = tag;
        if (this.lsl != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.lsm.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Em(int i) {
        this.lsm.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void En(int i) {
        this.lsm.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lsf.setOnClickListener(onClickListener);
        this.lsm.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dex;
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

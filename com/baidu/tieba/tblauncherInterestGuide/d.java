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
    private View dVJ;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;
    private View mYi;
    private LinearLayout mYl;
    private InterestFrsData.Tag mYr;
    private c mYs;
    private GridView mYt;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dVJ = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.mYs = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.mYl = (LinearLayout) this.dVJ.findViewById(R.id.box_close_layout);
        this.mYt = (GridView) this.dVJ.findViewById(R.id.layout_content);
        this.mYt.setAdapter((ListAdapter) this.mYs);
        this.mYt.setSelector(R.color.common_color_10022);
        setContentView(this.dVJ);
        this.mTitle = (TextView) this.dVJ.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dVJ.findViewById(R.id.prompt_sub_title);
        this.mYi = this.dVJ.findViewById(R.id.view_layout);
        this.mYi.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mYr = tag;
        if (this.mYr != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.mYs.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JK(int i) {
        this.mYs.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JL(int i) {
        this.mYs.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mYl.setOnClickListener(onClickListener);
        this.mYs.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dVJ;
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

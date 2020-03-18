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
    private View cus;
    private View kpi;
    private LinearLayout kpl;
    private InterestFrsData.Tag kpr;
    private c kps;
    private GridView kpt;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cus = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.kps = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.kpl = (LinearLayout) this.cus.findViewById(R.id.box_close_layout);
        this.kpt = (GridView) this.cus.findViewById(R.id.layout_content);
        this.kpt.setAdapter((ListAdapter) this.kps);
        this.kpt.setSelector(R.color.common_color_10022);
        setContentView(this.cus);
        this.mTitle = (TextView) this.cus.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.cus.findViewById(R.id.prompt_sub_title);
        this.kpi = this.cus.findViewById(R.id.view_layout);
        this.kpi.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.kpr = tag;
        if (this.kpr != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.kps.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CX(int i) {
        this.kps.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CY(int i) {
        this.kps.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kpl.setOnClickListener(onClickListener);
        this.kps.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cus;
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

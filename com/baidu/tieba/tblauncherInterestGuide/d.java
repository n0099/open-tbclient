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
    private View cTu;
    private InterestFrsData.Tag kZB;
    private c kZC;
    private GridView kZD;
    private View kZs;
    private LinearLayout kZv;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cTu = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.kZC = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.kZv = (LinearLayout) this.cTu.findViewById(R.id.box_close_layout);
        this.kZD = (GridView) this.cTu.findViewById(R.id.layout_content);
        this.kZD.setAdapter((ListAdapter) this.kZC);
        this.kZD.setSelector(R.color.common_color_10022);
        setContentView(this.cTu);
        this.mTitle = (TextView) this.cTu.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.cTu.findViewById(R.id.prompt_sub_title);
        this.kZs = this.cTu.findViewById(R.id.view_layout);
        this.kZs.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.kZB = tag;
        if (this.kZB != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.kZC.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void DB(int i) {
        this.kZC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void DC(int i) {
        this.kZC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kZv.setOnClickListener(onClickListener);
        this.kZC.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cTu;
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

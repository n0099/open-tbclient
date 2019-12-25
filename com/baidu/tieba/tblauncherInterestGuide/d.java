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
/* loaded from: classes6.dex */
public class d extends Dialog implements a {
    private View cpR;
    private View kiL;
    private LinearLayout kiO;
    private InterestFrsData.Tag kiU;
    private c kiV;
    private GridView kiW;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cpR = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.kiV = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.kiO = (LinearLayout) this.cpR.findViewById(R.id.box_close_layout);
        this.kiW = (GridView) this.cpR.findViewById(R.id.layout_content);
        this.kiW.setAdapter((ListAdapter) this.kiV);
        this.kiW.setSelector(R.color.common_color_10022);
        setContentView(this.cpR);
        this.mTitle = (TextView) this.cpR.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.cpR.findViewById(R.id.prompt_sub_title);
        this.kiL = this.cpR.findViewById(R.id.view_layout);
        this.kiL.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.kiU = tag;
        if (this.kiU != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.kiV.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CD(int i) {
        this.kiV.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CE(int i) {
        this.kiV.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kiO.setOnClickListener(onClickListener);
        this.kiV.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cpR;
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

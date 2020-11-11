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
    private View ebB;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;
    private View ned;
    private LinearLayout neg;
    private InterestFrsData.Tag nem;
    private c nen;
    private GridView neo;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.ebB = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nen = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.neg = (LinearLayout) this.ebB.findViewById(R.id.box_close_layout);
        this.neo = (GridView) this.ebB.findViewById(R.id.layout_content);
        this.neo.setAdapter((ListAdapter) this.nen);
        this.neo.setSelector(R.color.common_color_10022);
        setContentView(this.ebB);
        this.mTitle = (TextView) this.ebB.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.ebB.findViewById(R.id.prompt_sub_title);
        this.ned = this.ebB.findViewById(R.id.view_layout);
        this.ned.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nem = tag;
        if (this.nem != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.nen.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JX(int i) {
        this.nen.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JY(int i) {
        this.nen.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.neg.setOnClickListener(onClickListener);
        this.nen.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.ebB;
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

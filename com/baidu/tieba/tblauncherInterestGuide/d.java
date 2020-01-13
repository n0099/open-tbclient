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
/* loaded from: classes7.dex */
public class d extends Dialog implements a {
    private View cqd;
    private View kmo;
    private LinearLayout kmr;
    private InterestFrsData.Tag kmx;
    private c kmy;
    private GridView kmz;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cqd = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.kmy = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.kmr = (LinearLayout) this.cqd.findViewById(R.id.box_close_layout);
        this.kmz = (GridView) this.cqd.findViewById(R.id.layout_content);
        this.kmz.setAdapter((ListAdapter) this.kmy);
        this.kmz.setSelector(R.color.common_color_10022);
        setContentView(this.cqd);
        this.mTitle = (TextView) this.cqd.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.cqd.findViewById(R.id.prompt_sub_title);
        this.kmo = this.cqd.findViewById(R.id.view_layout);
        this.kmo.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.kmx = tag;
        if (this.kmx != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.kmy.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CJ(int i) {
        this.kmy.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CK(int i) {
        this.kmy.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kmr.setOnClickListener(onClickListener);
        this.kmy.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cqd;
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

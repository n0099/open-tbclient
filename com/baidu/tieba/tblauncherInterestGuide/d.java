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
    private View cug;
    private View knE;
    private LinearLayout knH;
    private InterestFrsData.Tag knN;
    private c knO;
    private GridView knP;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cug = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.knO = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.knH = (LinearLayout) this.cug.findViewById(R.id.box_close_layout);
        this.knP = (GridView) this.cug.findViewById(R.id.layout_content);
        this.knP.setAdapter((ListAdapter) this.knO);
        this.knP.setSelector(R.color.common_color_10022);
        setContentView(this.cug);
        this.mTitle = (TextView) this.cug.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.cug.findViewById(R.id.prompt_sub_title);
        this.knE = this.cug.findViewById(R.id.view_layout);
        this.knE.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.knN = tag;
        if (this.knN != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.knO.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CP(int i) {
        this.knO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CQ(int i) {
        this.knO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.knH.setOnClickListener(onClickListener);
        this.knO.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cug;
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

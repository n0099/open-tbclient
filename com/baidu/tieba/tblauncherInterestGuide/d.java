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
    private View cuf;
    private InterestFrsData.Tag knB;
    private c knC;
    private GridView knD;
    private View kns;
    private LinearLayout knv;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cuf = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.knC = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.knv = (LinearLayout) this.cuf.findViewById(R.id.box_close_layout);
        this.knD = (GridView) this.cuf.findViewById(R.id.layout_content);
        this.knD.setAdapter((ListAdapter) this.knC);
        this.knD.setSelector(R.color.common_color_10022);
        setContentView(this.cuf);
        this.mTitle = (TextView) this.cuf.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.cuf.findViewById(R.id.prompt_sub_title);
        this.kns = this.cuf.findViewById(R.id.view_layout);
        this.kns.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.knB = tag;
        if (this.knB != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.knC.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CP(int i) {
        this.knC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CQ(int i) {
        this.knC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.knv.setOnClickListener(onClickListener);
        this.knC.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cuf;
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

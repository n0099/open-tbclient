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
    private View dNm;
    private Context mContext;
    private LinearLayout mLC;
    private InterestFrsData.Tag mLI;
    private c mLJ;
    private GridView mLK;
    private View mLz;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dNm = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.mLJ = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.mLC = (LinearLayout) this.dNm.findViewById(R.id.box_close_layout);
        this.mLK = (GridView) this.dNm.findViewById(R.id.layout_content);
        this.mLK.setAdapter((ListAdapter) this.mLJ);
        this.mLK.setSelector(R.color.common_color_10022);
        setContentView(this.dNm);
        this.mTitle = (TextView) this.dNm.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dNm.findViewById(R.id.prompt_sub_title);
        this.mLz = this.dNm.findViewById(R.id.view_layout);
        this.mLz.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mLI = tag;
        if (this.mLI != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.mLJ.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Js(int i) {
        this.mLJ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Jt(int i) {
        this.mLJ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mLC.setOnClickListener(onClickListener);
        this.mLJ.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dNm;
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

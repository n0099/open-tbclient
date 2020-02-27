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
    private View cue;
    private c knA;
    private GridView knB;
    private View knq;
    private LinearLayout knt;
    private InterestFrsData.Tag knz;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.cue = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.knA = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.knt = (LinearLayout) this.cue.findViewById(R.id.box_close_layout);
        this.knB = (GridView) this.cue.findViewById(R.id.layout_content);
        this.knB.setAdapter((ListAdapter) this.knA);
        this.knB.setSelector(R.color.common_color_10022);
        setContentView(this.cue);
        this.mTitle = (TextView) this.cue.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.cue.findViewById(R.id.prompt_sub_title);
        this.knq = this.cue.findViewById(R.id.view_layout);
        this.knq.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.knz = tag;
        if (this.knz != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.knA.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CP(int i) {
        this.knA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void CQ(int i) {
        this.knA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.knt.setOnClickListener(onClickListener);
        this.knA.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.cue;
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

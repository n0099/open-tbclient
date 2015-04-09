package com.baidu.tieba.launcherGuide.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* loaded from: classes.dex */
public class i extends Dialog implements a {
    private View aVC;
    private View bwD;
    private LinearLayout bwG;
    private InterestFrsData.Tag bwR;
    private g bwS;
    private GridView bwT;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public i(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aVC = View.inflate(this.mContext, com.baidu.tieba.w.new_user_img_box, null);
        this.bwS = new g(this.mContext);
        setCanceledOnTouchOutside(true);
        this.bwG = (LinearLayout) this.aVC.findViewById(com.baidu.tieba.v.box_close_layout);
        this.bwT = (GridView) this.aVC.findViewById(com.baidu.tieba.v.layout_content);
        this.bwT.setAdapter((ListAdapter) this.bwS);
        this.bwT.setSelector(com.baidu.tieba.s.transparent);
        setContentView(this.aVC);
        this.mTitle = (TextView) this.aVC.findViewById(com.baidu.tieba.v.prompt_title);
        this.mSubTitle = (TextView) this.aVC.findViewById(com.baidu.tieba.v.prompt_sub_title);
        this.bwD = this.aVC.findViewById(com.baidu.tieba.v.view_layout);
        this.bwD.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.bwR = tag;
        if (this.bwR != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.bwS.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void gH(int i) {
        this.bwS.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void gI(int i) {
        this.bwS.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bwG.setOnClickListener(onClickListener);
        this.bwS.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.aVC;
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.k.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

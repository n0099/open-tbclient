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
    private View aVn;
    private InterestFrsData.Tag bwB;
    private g bwC;
    private GridView bwD;
    private View bwn;
    private LinearLayout bwq;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public i(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aVn = View.inflate(this.mContext, com.baidu.tieba.w.new_user_img_box, null);
        this.bwC = new g(this.mContext);
        setCanceledOnTouchOutside(true);
        this.bwq = (LinearLayout) this.aVn.findViewById(com.baidu.tieba.v.box_close_layout);
        this.bwD = (GridView) this.aVn.findViewById(com.baidu.tieba.v.layout_content);
        this.bwD.setAdapter((ListAdapter) this.bwC);
        this.bwD.setSelector(com.baidu.tieba.s.transparent);
        setContentView(this.aVn);
        this.mTitle = (TextView) this.aVn.findViewById(com.baidu.tieba.v.prompt_title);
        this.mSubTitle = (TextView) this.aVn.findViewById(com.baidu.tieba.v.prompt_sub_title);
        this.bwn = this.aVn.findViewById(com.baidu.tieba.v.view_layout);
        this.bwn.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.bwB = tag;
        if (this.bwB != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.bwC.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void gF(int i) {
        this.bwC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void gG(int i) {
        this.bwC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bwq.setOnClickListener(onClickListener);
        this.bwC.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.aVn;
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

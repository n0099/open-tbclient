package com.baidu.tieba.launcherGuide.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* loaded from: classes.dex */
public class g extends Dialog implements a {
    private TextView aPy;
    private TextView bRQ;
    private View bRR;
    private LinearLayout bRU;
    private InterestFrsData.Tag bSf;
    private f bSg;
    private GridView bSh;
    private View bnR;
    private Context mContext;

    public g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bnR = View.inflate(this.mContext, i.g.new_user_img_box, null);
        this.bSg = new f(this.mContext);
        setCanceledOnTouchOutside(true);
        this.bRU = (LinearLayout) this.bnR.findViewById(i.f.box_close_layout);
        this.bSh = (GridView) this.bnR.findViewById(i.f.layout_content);
        this.bSh.setAdapter((ListAdapter) this.bSg);
        this.bSh.setSelector(i.c.transparent);
        setContentView(this.bnR);
        this.aPy = (TextView) this.bnR.findViewById(i.f.prompt_title);
        this.bRQ = (TextView) this.bnR.findViewById(i.f.prompt_sub_title);
        this.bRR = this.bnR.findViewById(i.f.view_layout);
        this.bRR.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.bSf = tag;
        if (this.bSf != null) {
            this.aPy.setText(tag.getBname());
            this.bRQ.setText(tag.getBdesc());
            this.bSg.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void ii(int i) {
        this.bSg.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void ij(int i) {
        this.bSg.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRU.setOnClickListener(onClickListener);
        this.bSg.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bnR;
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

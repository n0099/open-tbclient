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
    private TextView aPf;
    private f bRA;
    private GridView bRB;
    private TextView bRk;
    private View bRl;
    private LinearLayout bRo;
    private InterestFrsData.Tag bRz;
    private View bnc;
    private Context mContext;

    public g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bnc = View.inflate(this.mContext, i.g.new_user_img_box, null);
        this.bRA = new f(this.mContext);
        setCanceledOnTouchOutside(true);
        this.bRo = (LinearLayout) this.bnc.findViewById(i.f.box_close_layout);
        this.bRB = (GridView) this.bnc.findViewById(i.f.layout_content);
        this.bRB.setAdapter((ListAdapter) this.bRA);
        this.bRB.setSelector(i.c.transparent);
        setContentView(this.bnc);
        this.aPf = (TextView) this.bnc.findViewById(i.f.prompt_title);
        this.bRk = (TextView) this.bnc.findViewById(i.f.prompt_sub_title);
        this.bRl = this.bnc.findViewById(i.f.view_layout);
        this.bRl.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.bRz = tag;
        if (this.bRz != null) {
            this.aPf.setText(tag.getBname());
            this.bRk.setText(tag.getBdesc());
            this.bRA.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void hU(int i) {
        this.bRA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void hV(int i) {
        this.bRA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRo.setOnClickListener(onClickListener);
        this.bRA.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bnc;
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

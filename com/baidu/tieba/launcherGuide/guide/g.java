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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends Dialog implements a {
    private TextView aSh;
    private View bJp;
    private InterestFrsData.Tag cDC;
    private f cDD;
    private GridView cDE;
    private TextView cDn;
    private View cDo;
    private LinearLayout cDr;
    private Context mContext;

    public g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bJp = View.inflate(this.mContext, t.h.new_user_img_box, null);
        this.cDD = new f(this.mContext);
        setCanceledOnTouchOutside(true);
        this.cDr = (LinearLayout) this.bJp.findViewById(t.g.box_close_layout);
        this.cDE = (GridView) this.bJp.findViewById(t.g.layout_content);
        this.cDE.setAdapter((ListAdapter) this.cDD);
        this.cDE.setSelector(t.d.transparent);
        setContentView(this.bJp);
        this.aSh = (TextView) this.bJp.findViewById(t.g.prompt_title);
        this.cDn = (TextView) this.bJp.findViewById(t.g.prompt_sub_title);
        this.cDo = this.bJp.findViewById(t.g.view_layout);
        this.cDo.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.cDC = tag;
        if (this.cDC != null) {
            this.aSh.setText(tag.getBname());
            this.cDn.setText(tag.getBdesc());
            this.cDD.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void kF(int i) {
        this.cDD.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void kG(int i) {
        this.cDD.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cDr.setOnClickListener(onClickListener);
        this.cDD.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bJp;
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.h.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

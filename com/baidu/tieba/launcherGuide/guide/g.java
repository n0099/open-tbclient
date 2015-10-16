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
    private TextView aPq;
    private InterestFrsData.Tag bRK;
    private f bRL;
    private GridView bRM;
    private TextView bRv;
    private View bRw;
    private LinearLayout bRz;
    private View bnn;
    private Context mContext;

    public g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bnn = View.inflate(this.mContext, i.g.new_user_img_box, null);
        this.bRL = new f(this.mContext);
        setCanceledOnTouchOutside(true);
        this.bRz = (LinearLayout) this.bnn.findViewById(i.f.box_close_layout);
        this.bRM = (GridView) this.bnn.findViewById(i.f.layout_content);
        this.bRM.setAdapter((ListAdapter) this.bRL);
        this.bRM.setSelector(i.c.transparent);
        setContentView(this.bnn);
        this.aPq = (TextView) this.bnn.findViewById(i.f.prompt_title);
        this.bRv = (TextView) this.bnn.findViewById(i.f.prompt_sub_title);
        this.bRw = this.bnn.findViewById(i.f.view_layout);
        this.bRw.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.bRK = tag;
        if (this.bRK != null) {
            this.aPq.setText(tag.getBname());
            this.bRv.setText(tag.getBdesc());
            this.bRL.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void hU(int i) {
        this.bRL.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void hV(int i) {
        this.bRL.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRz.setOnClickListener(onClickListener);
        this.bRL.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bnn;
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

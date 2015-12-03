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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class g extends Dialog implements a {
    private TextView aUB;
    private View bwP;
    private TextView cic;
    private View cie;
    private LinearLayout cih;
    private InterestFrsData.Tag cis;
    private f cit;
    private GridView ciu;
    private Context mContext;

    public g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bwP = View.inflate(this.mContext, n.g.new_user_img_box, null);
        this.cit = new f(this.mContext);
        setCanceledOnTouchOutside(true);
        this.cih = (LinearLayout) this.bwP.findViewById(n.f.box_close_layout);
        this.ciu = (GridView) this.bwP.findViewById(n.f.layout_content);
        this.ciu.setAdapter((ListAdapter) this.cit);
        this.ciu.setSelector(n.c.transparent);
        setContentView(this.bwP);
        this.aUB = (TextView) this.bwP.findViewById(n.f.prompt_title);
        this.cic = (TextView) this.bwP.findViewById(n.f.prompt_sub_title);
        this.cie = this.bwP.findViewById(n.f.view_layout);
        this.cie.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.e.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.cis = tag;
        if (this.cis != null) {
            this.aUB.setText(tag.getBname());
            this.cic.setText(tag.getBdesc());
            this.cit.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void jc(int i) {
        this.cit.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void jd(int i) {
        this.cit.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cih.setOnClickListener(onClickListener);
        this.cit.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bwP;
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

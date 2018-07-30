package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class d extends Dialog implements a {
    private View bzb;
    private TextView eIZ;
    private View gTR;
    private LinearLayout gTU;
    private InterestFrsData.Tag gUc;
    private c gUd;
    private GridView gUe;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bzb = View.inflate(this.mContext, d.h.new_user_img_box, null);
        this.gUd = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.gTU = (LinearLayout) this.bzb.findViewById(d.g.box_close_layout);
        this.gUe = (GridView) this.bzb.findViewById(d.g.layout_content);
        this.gUe.setAdapter((ListAdapter) this.gUd);
        this.gUe.setSelector(d.C0140d.common_color_10022);
        setContentView(this.bzb);
        this.mTitle = (TextView) this.bzb.findViewById(d.g.prompt_title);
        this.eIZ = (TextView) this.bzb.findViewById(d.g.prompt_sub_title);
        this.gTR = this.bzb.findViewById(d.g.view_layout);
        this.gTR.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.gUc = tag;
        if (this.gUc != null) {
            this.mTitle.setText(tag.getBname());
            this.eIZ.setText(tag.getBdesc());
            this.gUd.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ua(int i) {
        this.gUd.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ub(int i) {
        this.gUd.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gTU.setOnClickListener(onClickListener);
        this.gUd.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bzb;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}

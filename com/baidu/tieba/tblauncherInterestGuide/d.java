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
import com.baidu.tieba.f;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class d extends Dialog implements a {
    private View bzd;
    private TextView eIU;
    private View gTT;
    private LinearLayout gTW;
    private InterestFrsData.Tag gUe;
    private c gUf;
    private GridView gUg;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bzd = View.inflate(this.mContext, f.h.new_user_img_box, null);
        this.gUf = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.gTW = (LinearLayout) this.bzd.findViewById(f.g.box_close_layout);
        this.gUg = (GridView) this.bzd.findViewById(f.g.layout_content);
        this.gUg.setAdapter((ListAdapter) this.gUf);
        this.gUg.setSelector(f.d.common_color_10022);
        setContentView(this.bzd);
        this.mTitle = (TextView) this.bzd.findViewById(f.g.prompt_title);
        this.eIU = (TextView) this.bzd.findViewById(f.g.prompt_sub_title);
        this.gTT = this.bzd.findViewById(f.g.view_layout);
        this.gTT.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.gUe = tag;
        if (this.gUe != null) {
            this.mTitle.setText(tag.getBname());
            this.eIU.setText(tag.getBdesc());
            this.gUf.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ua(int i) {
        this.gUf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ub(int i) {
        this.gUf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gTW.setOnClickListener(onClickListener);
        this.gUf.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bzd;
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

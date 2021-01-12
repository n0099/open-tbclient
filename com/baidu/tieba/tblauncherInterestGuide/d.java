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
/* loaded from: classes2.dex */
public class d extends Dialog implements a {
    private TextView dtg;
    private View elg;
    private Context mContext;
    private TextView mTitle;
    private View nuE;
    private LinearLayout nuG;
    private InterestFrsData.Tag nuM;
    private c nuN;
    private GridView nuO;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.elg = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nuN = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nuG = (LinearLayout) this.elg.findViewById(R.id.box_close_layout);
        this.nuO = (GridView) this.elg.findViewById(R.id.layout_content);
        this.nuO.setAdapter((ListAdapter) this.nuN);
        this.nuO.setSelector(R.color.common_color_10022);
        setContentView(this.elg);
        this.mTitle = (TextView) this.elg.findViewById(R.id.prompt_title);
        this.dtg = (TextView) this.elg.findViewById(R.id.prompt_sub_title);
        this.nuE = this.elg.findViewById(R.id.view_layout);
        this.nuE.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nuM = tag;
        if (this.nuM != null) {
            this.mTitle.setText(tag.getBname());
            this.dtg.setText(tag.getBdesc());
            this.nuN.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JH(int i) {
        this.nuN.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JI(int i) {
        this.nuN.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nuG.setOnClickListener(onClickListener);
        this.nuN.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.elg;
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

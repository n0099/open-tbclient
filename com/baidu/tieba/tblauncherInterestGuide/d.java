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
    private View nuF;
    private LinearLayout nuH;
    private InterestFrsData.Tag nuN;
    private c nuO;
    private GridView nuP;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.elg = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.nuO = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.nuH = (LinearLayout) this.elg.findViewById(R.id.box_close_layout);
        this.nuP = (GridView) this.elg.findViewById(R.id.layout_content);
        this.nuP.setAdapter((ListAdapter) this.nuO);
        this.nuP.setSelector(R.color.common_color_10022);
        setContentView(this.elg);
        this.mTitle = (TextView) this.elg.findViewById(R.id.prompt_title);
        this.dtg = (TextView) this.elg.findViewById(R.id.prompt_sub_title);
        this.nuF = this.elg.findViewById(R.id.view_layout);
        this.nuF.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.nuN = tag;
        if (this.nuN != null) {
            this.mTitle.setText(tag.getBname());
            this.dtg.setText(tag.getBdesc());
            this.nuO.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JH(int i) {
        this.nuO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JI(int i) {
        this.nuO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nuH.setOnClickListener(onClickListener);
        this.nuO.setOnClickListener(onClickListener);
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

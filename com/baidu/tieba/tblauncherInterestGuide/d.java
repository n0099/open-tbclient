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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes4.dex */
public class d extends Dialog implements a {
    private TextView aJj;
    private View bnp;
    private InterestFrsData.Tag jpH;
    private c jpI;
    private GridView jpJ;
    private View jpw;
    private LinearLayout jpz;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bnp = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.jpI = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.jpz = (LinearLayout) this.bnp.findViewById(R.id.box_close_layout);
        this.jpJ = (GridView) this.bnp.findViewById(R.id.layout_content);
        this.jpJ.setAdapter((ListAdapter) this.jpI);
        this.jpJ.setSelector(R.color.common_color_10022);
        setContentView(this.bnp);
        this.mTitle = (TextView) this.bnp.findViewById(R.id.prompt_title);
        this.aJj = (TextView) this.bnp.findViewById(R.id.prompt_sub_title);
        this.jpw = this.bnp.findViewById(R.id.view_layout);
        this.jpw.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.jpH = tag;
        if (this.jpH != null) {
            this.mTitle.setText(tag.getBname());
            this.aJj.setText(tag.getBdesc());
            this.jpI.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void BD(int i) {
        this.jpI.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void BE(int i) {
        this.jpI.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jpz.setOnClickListener(onClickListener);
        this.jpI.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bnp;
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

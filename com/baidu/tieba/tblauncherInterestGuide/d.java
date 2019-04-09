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
/* loaded from: classes4.dex */
public class d extends Dialog implements a {
    private TextView aGk;
    private View dcQ;
    private View iMM;
    private LinearLayout iMP;
    private InterestFrsData.Tag iMX;
    private c iMY;
    private GridView iMZ;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dcQ = View.inflate(this.mContext, d.h.new_user_img_box, null);
        this.iMY = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.iMP = (LinearLayout) this.dcQ.findViewById(d.g.box_close_layout);
        this.iMZ = (GridView) this.dcQ.findViewById(d.g.layout_content);
        this.iMZ.setAdapter((ListAdapter) this.iMY);
        this.iMZ.setSelector(d.C0277d.common_color_10022);
        setContentView(this.dcQ);
        this.mTitle = (TextView) this.dcQ.findViewById(d.g.prompt_title);
        this.aGk = (TextView) this.dcQ.findViewById(d.g.prompt_sub_title);
        this.iMM = this.dcQ.findViewById(d.g.view_layout);
        this.iMM.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.iMX = tag;
        if (this.iMX != null) {
            this.mTitle.setText(tag.getBname());
            this.aGk.setText(tag.getBdesc());
            this.iMY.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zI(int i) {
        this.iMY.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zJ(int i) {
        this.iMY.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMP.setOnClickListener(onClickListener);
        this.iMY.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dcQ;
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

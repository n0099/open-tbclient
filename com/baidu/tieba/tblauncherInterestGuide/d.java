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
    private TextView eFf;
    private View gST;
    private LinearLayout gSW;
    private InterestFrsData.Tag gTe;
    private c gTf;
    private GridView gTg;
    private Context mContext;
    private TextView mTitle;
    private View root;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.root = View.inflate(this.mContext, d.i.new_user_img_box, null);
        this.gTf = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.gSW = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.gTg = (GridView) this.root.findViewById(d.g.layout_content);
        this.gTg.setAdapter((ListAdapter) this.gTf);
        this.gTg.setSelector(d.C0142d.common_color_10022);
        setContentView(this.root);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eFf = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gST = this.root.findViewById(d.g.view_layout);
        this.gST.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.gTe = tag;
        if (this.gTe != null) {
            this.mTitle.setText(tag.getBname());
            this.eFf.setText(tag.getBdesc());
            this.gTf.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uc(int i) {
        this.gTf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ud(int i) {
        this.gTf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gSW.setOnClickListener(onClickListener);
        this.gTf.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.root;
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

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
    private TextView eBp;
    private InterestFrsData.Tag gOD;
    private c gOE;
    private GridView gOF;
    private View gOs;
    private LinearLayout gOv;
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
        this.gOE = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.gOv = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.gOF = (GridView) this.root.findViewById(d.g.layout_content);
        this.gOF.setAdapter((ListAdapter) this.gOE);
        this.gOF.setSelector(d.C0141d.common_color_10022);
        setContentView(this.root);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eBp = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gOs = this.root.findViewById(d.g.view_layout);
        this.gOs.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.gOD = tag;
        if (this.gOD != null) {
            this.mTitle.setText(tag.getBname());
            this.eBp.setText(tag.getBdesc());
            this.gOE.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tU(int i) {
        this.gOE.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tV(int i) {
        this.gOE.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gOv.setOnClickListener(onClickListener);
        this.gOE.setOnClickListener(onClickListener);
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

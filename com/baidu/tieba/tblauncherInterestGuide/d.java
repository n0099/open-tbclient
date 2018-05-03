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
    private TextView eoP;
    private View gBN;
    private LinearLayout gBQ;
    private InterestFrsData.Tag gBY;
    private c gBZ;
    private GridView gCa;
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
        this.gBZ = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.gBQ = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.gCa = (GridView) this.root.findViewById(d.g.layout_content);
        this.gCa.setAdapter((ListAdapter) this.gBZ);
        this.gCa.setSelector(d.C0126d.common_color_10022);
        setContentView(this.root);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eoP = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gBN = this.root.findViewById(d.g.view_layout);
        this.gBN.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.gBY = tag;
        if (this.gBY != null) {
            this.mTitle.setText(tag.getBname());
            this.eoP.setText(tag.getBdesc());
            this.gBZ.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tJ(int i) {
        this.gBZ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tK(int i) {
        this.gBZ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gBQ.setOnClickListener(onClickListener);
        this.gBZ.setOnClickListener(onClickListener);
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

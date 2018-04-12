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
    private TextView eoS;
    private View gBQ;
    private LinearLayout gBT;
    private InterestFrsData.Tag gCb;
    private c gCc;
    private GridView gCd;
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
        this.gCc = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.gBT = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.gCd = (GridView) this.root.findViewById(d.g.layout_content);
        this.gCd.setAdapter((ListAdapter) this.gCc);
        this.gCd.setSelector(d.C0126d.common_color_10022);
        setContentView(this.root);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eoS = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gBQ = this.root.findViewById(d.g.view_layout);
        this.gBQ.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.gCb = tag;
        if (this.gCb != null) {
            this.mTitle.setText(tag.getBname());
            this.eoS.setText(tag.getBdesc());
            this.gCc.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tK(int i) {
        this.gCc.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tL(int i) {
        this.gCc.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gBT.setOnClickListener(onClickListener);
        this.gCc.setOnClickListener(onClickListener);
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

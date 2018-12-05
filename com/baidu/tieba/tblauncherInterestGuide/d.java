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
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class d extends Dialog implements a {
    private View bRX;
    private View hrU;
    private LinearLayout hrX;
    private InterestFrsData.Tag hsf;
    private c hsg;
    private GridView hsh;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bRX = View.inflate(this.mContext, e.h.new_user_img_box, null);
        this.hsg = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hrX = (LinearLayout) this.bRX.findViewById(e.g.box_close_layout);
        this.hsh = (GridView) this.bRX.findViewById(e.g.layout_content);
        this.hsh.setAdapter((ListAdapter) this.hsg);
        this.hsh.setSelector(e.d.common_color_10022);
        setContentView(this.bRX);
        this.mTitle = (TextView) this.bRX.findViewById(e.g.prompt_title);
        this.mSubTitle = (TextView) this.bRX.findViewById(e.g.prompt_sub_title);
        this.hrU = this.bRX.findViewById(e.g.view_layout);
        this.hrU.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hsf = tag;
        if (this.hsf != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.hsg.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void vN(int i) {
        this.hsg.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void vO(int i) {
        this.hsg.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hrX.setOnClickListener(onClickListener);
        this.hsg.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bRX;
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

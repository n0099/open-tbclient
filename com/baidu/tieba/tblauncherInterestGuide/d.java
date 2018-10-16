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
    private View bNv;
    private View hiX;
    private LinearLayout hja;
    private InterestFrsData.Tag hji;
    private c hjj;
    private GridView hjk;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bNv = View.inflate(this.mContext, e.h.new_user_img_box, null);
        this.hjj = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.hja = (LinearLayout) this.bNv.findViewById(e.g.box_close_layout);
        this.hjk = (GridView) this.bNv.findViewById(e.g.layout_content);
        this.hjk.setAdapter((ListAdapter) this.hjj);
        this.hjk.setSelector(e.d.common_color_10022);
        setContentView(this.bNv);
        this.mTitle = (TextView) this.bNv.findViewById(e.g.prompt_title);
        this.mSubTitle = (TextView) this.bNv.findViewById(e.g.prompt_sub_title);
        this.hiX = this.bNv.findViewById(e.g.view_layout);
        this.hiX.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.hji = tag;
        if (this.hji != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.hjj.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uX(int i) {
        this.hjj.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uY(int i) {
        this.hjj.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hja.setOnClickListener(onClickListener);
        this.hjj.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bNv;
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

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
/* loaded from: classes16.dex */
public class d extends Dialog implements a {
    private View dpe;
    private View lUl;
    private LinearLayout lUo;
    private InterestFrsData.Tag lUu;
    private c lUv;
    private GridView lUw;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dpe = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.lUv = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.lUo = (LinearLayout) this.dpe.findViewById(R.id.box_close_layout);
        this.lUw = (GridView) this.dpe.findViewById(R.id.layout_content);
        this.lUw.setAdapter((ListAdapter) this.lUv);
        this.lUw.setSelector(R.color.common_color_10022);
        setContentView(this.dpe);
        this.mTitle = (TextView) this.dpe.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dpe.findViewById(R.id.prompt_sub_title);
        this.lUl = this.dpe.findViewById(R.id.view_layout);
        this.lUl.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.lUu = tag;
        if (this.lUu != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.lUv.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void FM(int i) {
        this.lUv.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void FN(int i) {
        this.lUv.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lUo.setOnClickListener(onClickListener);
        this.lUv.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dpe;
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

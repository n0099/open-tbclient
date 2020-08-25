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
    private View dzg;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;
    private View mlY;
    private LinearLayout mmb;
    private InterestFrsData.Tag mmh;
    private c mmi;
    private GridView mmj;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dzg = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.mmi = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.mmb = (LinearLayout) this.dzg.findViewById(R.id.box_close_layout);
        this.mmj = (GridView) this.dzg.findViewById(R.id.layout_content);
        this.mmj.setAdapter((ListAdapter) this.mmi);
        this.mmj.setSelector(R.color.common_color_10022);
        setContentView(this.dzg);
        this.mTitle = (TextView) this.dzg.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dzg.findViewById(R.id.prompt_sub_title);
        this.mlY = this.dzg.findViewById(R.id.view_layout);
        this.mlY.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mmh = tag;
        if (this.mmh != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.mmi.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ii(int i) {
        this.mmi.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ij(int i) {
        this.mmi.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mmb.setOnClickListener(onClickListener);
        this.mmi.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dzg;
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

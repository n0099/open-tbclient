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
    private View dzk;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;
    private c mmA;
    private GridView mmB;
    private View mmq;
    private LinearLayout mmt;
    private InterestFrsData.Tag mmz;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dzk = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.mmA = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.mmt = (LinearLayout) this.dzk.findViewById(R.id.box_close_layout);
        this.mmB = (GridView) this.dzk.findViewById(R.id.layout_content);
        this.mmB.setAdapter((ListAdapter) this.mmA);
        this.mmB.setSelector(R.color.common_color_10022);
        setContentView(this.dzk);
        this.mTitle = (TextView) this.dzk.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dzk.findViewById(R.id.prompt_sub_title);
        this.mmq = this.dzk.findViewById(R.id.view_layout);
        this.mmq.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mmz = tag;
        if (this.mmz != null) {
            this.mTitle.setText(tag.getBname());
            this.mSubTitle.setText(tag.getBdesc());
            this.mmA.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ii(int i) {
        this.mmA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ij(int i) {
        this.mmA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mmt.setOnClickListener(onClickListener);
        this.mmA.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dzk;
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

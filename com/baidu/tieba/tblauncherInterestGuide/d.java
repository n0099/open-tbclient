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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes4.dex */
public class d extends Dialog implements a {
    private View bGb;
    private TextView bcx;
    private c jpA;
    private GridView jpB;
    private View jpq;
    private LinearLayout jpt;
    private InterestFrsData.Tag jpz;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bGb = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.jpA = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.jpt = (LinearLayout) this.bGb.findViewById(R.id.box_close_layout);
        this.jpB = (GridView) this.bGb.findViewById(R.id.layout_content);
        this.jpB.setAdapter((ListAdapter) this.jpA);
        this.jpB.setSelector(R.color.common_color_10022);
        setContentView(this.bGb);
        this.mTitle = (TextView) this.bGb.findViewById(R.id.prompt_title);
        this.bcx = (TextView) this.bGb.findViewById(R.id.prompt_sub_title);
        this.jpq = this.bGb.findViewById(R.id.view_layout);
        this.jpq.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.jpz = tag;
        if (this.jpz != null) {
            this.mTitle.setText(tag.getBname());
            this.bcx.setText(tag.getBdesc());
            this.jpA.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Aj(int i) {
        this.jpA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ak(int i) {
        this.jpA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jpt.setOnClickListener(onClickListener);
        this.jpA.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bGb;
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

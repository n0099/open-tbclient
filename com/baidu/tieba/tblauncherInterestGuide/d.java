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
    private View bFk;
    private TextView bcf;
    private LinearLayout joC;
    private InterestFrsData.Tag joI;
    private c joJ;
    private GridView joK;
    private View joz;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bFk = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.joJ = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.joC = (LinearLayout) this.bFk.findViewById(R.id.box_close_layout);
        this.joK = (GridView) this.bFk.findViewById(R.id.layout_content);
        this.joK.setAdapter((ListAdapter) this.joJ);
        this.joK.setSelector(R.color.common_color_10022);
        setContentView(this.bFk);
        this.mTitle = (TextView) this.bFk.findViewById(R.id.prompt_title);
        this.bcf = (TextView) this.bFk.findViewById(R.id.prompt_sub_title);
        this.joz = this.bFk.findViewById(R.id.view_layout);
        this.joz.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.joI = tag;
        if (this.joI != null) {
            this.mTitle.setText(tag.getBname());
            this.bcf.setText(tag.getBdesc());
            this.joJ.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ai(int i) {
        this.joJ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Aj(int i) {
        this.joJ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.joC.setOnClickListener(onClickListener);
        this.joJ.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bFk;
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

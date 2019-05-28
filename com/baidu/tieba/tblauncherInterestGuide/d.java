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
    private TextView aId;
    private View bmd;
    private View jfG;
    private LinearLayout jfJ;
    private InterestFrsData.Tag jfR;
    private c jfS;
    private GridView jfT;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bmd = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.jfS = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.jfJ = (LinearLayout) this.bmd.findViewById(R.id.box_close_layout);
        this.jfT = (GridView) this.bmd.findViewById(R.id.layout_content);
        this.jfT.setAdapter((ListAdapter) this.jfS);
        this.jfT.setSelector(R.color.common_color_10022);
        setContentView(this.bmd);
        this.mTitle = (TextView) this.bmd.findViewById(R.id.prompt_title);
        this.aId = (TextView) this.bmd.findViewById(R.id.prompt_sub_title);
        this.jfG = this.bmd.findViewById(R.id.view_layout);
        this.jfG.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.jfR = tag;
        if (this.jfR != null) {
            this.mTitle.setText(tag.getBname());
            this.aId.setText(tag.getBdesc());
            this.jfS.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void AQ(int i) {
        this.jfS.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void AR(int i) {
        this.jfS.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jfJ.setOnClickListener(onClickListener);
        this.jfS.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bmd;
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

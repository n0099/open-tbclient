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
    private TextView aIL;
    private View bmR;
    private View jlT;
    private LinearLayout jlW;
    private InterestFrsData.Tag jme;
    private c jmf;
    private GridView jmg;
    private Context mContext;
    private TextView mTitle;

    public d(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bmR = View.inflate(this.mContext, R.layout.new_user_img_box, null);
        this.jmf = new c(this.mContext);
        setCanceledOnTouchOutside(true);
        this.jlW = (LinearLayout) this.bmR.findViewById(R.id.box_close_layout);
        this.jmg = (GridView) this.bmR.findViewById(R.id.layout_content);
        this.jmg.setAdapter((ListAdapter) this.jmf);
        this.jmg.setSelector(R.color.common_color_10022);
        setContentView(this.bmR);
        this.mTitle = (TextView) this.bmR.findViewById(R.id.prompt_title);
        this.aIL = (TextView) this.bmR.findViewById(R.id.prompt_sub_title);
        this.jlT = this.bmR.findViewById(R.id.view_layout);
        this.jlT.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.jme = tag;
        if (this.jme != null) {
            this.mTitle.setText(tag.getBname());
            this.aIL.setText(tag.getBdesc());
            this.jmf.setData(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Bx(int i) {
        this.jmf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void By(int i) {
        this.jmf.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jlW.setOnClickListener(onClickListener);
        this.jmf.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bmR;
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

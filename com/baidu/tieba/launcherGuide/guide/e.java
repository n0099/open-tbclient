package com.baidu.tieba.launcherGuide.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends Dialog implements a {
    private View aVn;
    private View bwn;
    private LinearLayout bwo;
    private View.OnClickListener bwp;
    private LinearLayout bwq;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.aVn = View.inflate(this.mContext, com.baidu.tieba.w.new_user_box, null);
        setContentView(this.aVn);
        setCanceledOnTouchOutside(true);
        this.bwq = (LinearLayout) this.aVn.findViewById(com.baidu.tieba.v.box_close_layout);
        this.mTitle = (TextView) this.aVn.findViewById(com.baidu.tieba.v.prompt_title);
        this.mSubTitle = (TextView) this.aVn.findViewById(com.baidu.tieba.v.prompt_sub_title);
        this.bwn = this.aVn.findViewById(com.baidu.tieba.v.view_layout);
        this.bwo = (LinearLayout) findViewById(com.baidu.tieba.v.layout_content);
        this.bwn.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bwp = onClickListener;
        this.bwq.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.k.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.mSubTitle.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new f(this, card, this.bwp).getView();
            this.bwo.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.bwo.addView(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.new_user_line_item, null));
            }
            ((TbImageView) this.bwo.findViewWithTag(card.getAvatar())).c(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds120);
        if ((getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds188) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void gF(int i) {
        View findViewWithTag = this.bwo.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).dq(true);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void gG(int i) {
        View findViewWithTag = this.bwo.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).dq(false);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.aVn;
    }
}

package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ThreadPrivacyIntermediateActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends RelativeLayout implements View.OnClickListener {
    private TextView acd;
    private ImageView fjA;
    private Context mContext;
    private View mRootView;

    public h(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.person_privacy_tip_view, this);
        this.acd = (TextView) findViewById(d.g.tip_view);
        this.fjA = (ImageView) findViewById(d.g.close_view);
        this.fjA.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
    }

    public void show(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            TiebaStatic.log(new ak("c12520"));
            frameLayout.removeView(this);
            frameLayout.addView(this, new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60)));
            onChangeSkinType(i);
        }
    }

    public void hide() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void onChangeSkinType(int i) {
        aj.d(this, d.C0080d.cp_link_tip_a_alpha80, i);
        aj.b(this.acd, d.C0080d.cp_cont_g, 1, i);
        aj.c(this.fjA, d.f.icon_home_card_close_white);
        this.acd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ThreadPrivacyIntermediateActivityConfig(this.mContext)));
            TiebaStatic.log(new ak("c12521").r("obj_locate", 1));
        } else if (view == this.fjA) {
            hide();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("clicked_blue_tip", true);
            TiebaStatic.log(new ak("c12521").r("obj_locate", 2));
        }
    }
}

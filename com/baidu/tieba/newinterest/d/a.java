package com.baidu.tieba.newinterest.d;

import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.util.List;
/* loaded from: classes22.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private BaseFragmentActivity hEa;
    private View icu;
    private TextView kBk;
    private InterestedForumFragment kBl;
    private InterestSelectionFragment kBm;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hEa = baseFragmentActivity;
        initUI();
        ctn();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.hEa).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.kBk = new TextView(this.hEa);
        this.kBk.setClickable(true);
        this.kBk.setText(this.hEa.getString(R.string.skip));
        this.kBk.setTextSize(0, l.getDimens(this.hEa, R.dimen.tbds37));
        ap.setViewTextColor(this.kBk, R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.hEa, R.dimen.tbds44);
        this.kBk.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kBk, this);
        this.icu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kBm = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.kBm).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void ctn() {
        this.kBk.setOnClickListener(this);
        this.icu.setOnClickListener(this);
        this.kBm.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.icu && this.hEa != null) {
            if (this.kBl != null && this.kBl.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                cXB();
            }
        } else if (view == this.kBk) {
            cXB();
        }
    }

    private void cXB() {
        aq aqVar = new aq("c13682");
        aqVar.ai("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.hEa).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void eB(List<b> list) {
        this.kBl = new InterestedForumFragment();
        this.kBl.eC(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.kBl).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.hEa.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

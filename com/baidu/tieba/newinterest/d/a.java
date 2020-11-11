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
/* loaded from: classes23.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private View iJO;
    private BaseFragmentActivity ilu;
    private TextView liQ;
    private InterestedForumFragment liR;
    private InterestSelectionFragment liS;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ilu = baseFragmentActivity;
        initUI();
        cCs();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.ilu).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.liQ = new TextView(this.ilu);
        this.liQ.setClickable(true);
        this.liQ.setText(this.ilu.getString(R.string.skip));
        this.liQ.setTextSize(0, l.getDimens(this.ilu, R.dimen.tbds37));
        ap.setViewTextColor(this.liQ, R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.ilu, R.dimen.tbds44);
        this.liQ.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.liQ, this);
        this.iJO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.liS = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.liS).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void cCs() {
        this.liQ.setOnClickListener(this);
        this.iJO.setOnClickListener(this);
        this.liS.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iJO && this.ilu != null) {
            if (this.liR != null && this.liR.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                dgU();
            }
        } else if (view == this.liQ) {
            dgU();
        }
    }

    private void dgU() {
        aq aqVar = new aq("c13682");
        aqVar.al("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.ilu).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void eV(List<b> list) {
        this.liR = new InterestedForumFragment();
        this.liR.eW(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.liR).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.ilu.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

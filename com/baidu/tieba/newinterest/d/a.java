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
/* loaded from: classes17.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private View hVo;
    private BaseFragmentActivity hwQ;
    private TextView ksE;
    private InterestedForumFragment ksF;
    private InterestSelectionFragment ksG;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hwQ = baseFragmentActivity;
        initUI();
        cpZ();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.hwQ).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.ksE = new TextView(this.hwQ);
        this.ksE.setClickable(true);
        this.ksE.setText(this.hwQ.getString(R.string.skip));
        this.ksE.setTextSize(0, l.getDimens(this.hwQ, R.dimen.tbds37));
        ap.setViewTextColor(this.ksE, R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.hwQ, R.dimen.tbds44);
        this.ksE.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ksE, this);
        this.hVo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ksG = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.ksG).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void cpZ() {
        this.ksE.setOnClickListener(this);
        this.hVo.setOnClickListener(this);
        this.ksG.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVo && this.hwQ != null) {
            if (this.ksF != null && this.ksF.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                cTV();
            }
        } else if (view == this.ksE) {
            cTV();
        }
    }

    private void cTV() {
        aq aqVar = new aq("c13682");
        aqVar.ai("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.hwQ).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void et(List<b> list) {
        this.ksF = new InterestedForumFragment();
        this.ksF.eu(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.ksF).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.hwQ.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private View hCa;
    private BaseFragmentActivity hep;
    private TextView jUI;
    private InterestedForumFragment jUJ;
    private InterestSelectionFragment jUK;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hep = baseFragmentActivity;
        initUI();
        cbW();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.hep).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jUI = new TextView(this.hep);
        this.jUI.setClickable(true);
        this.jUI.setText(this.hep.getString(R.string.skip));
        this.jUI.setTextSize(0, l.getDimens(this.hep, R.dimen.tbds37));
        an.setViewTextColor(this.jUI, (int) R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.hep, R.dimen.tbds44);
        this.jUI.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jUI, this);
        this.hCa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jUK = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.jUK).commitAllowingStateLoss();
        TiebaStatic.log(new ao("c13681"));
    }

    private void cbW() {
        this.jUI.setOnClickListener(this);
        this.hCa.setOnClickListener(this);
        this.jUK.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCa && this.hep != null) {
            if (this.jUJ != null && this.jUJ.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                cFx();
            }
        } else if (view == this.jUI) {
            cFx();
        }
    }

    private void cFx() {
        ao aoVar = new ao("c13682");
        aoVar.ag("obj_type", 1);
        TiebaStatic.log(aoVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.hep).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void ef(List<b> list) {
        this.jUJ = new InterestedForumFragment();
        this.jUJ.eg(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.jUJ).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.hep.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

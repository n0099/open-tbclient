package com.baidu.tieba.newinterest.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private BaseFragmentActivity iEK;
    private View jdb;
    private TextView lxk;
    private InterestedForumFragment lxl;
    private InterestSelectionFragment lxm;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iEK = baseFragmentActivity;
        initUI();
        cFy();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.iEK).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.lxk = new TextView(this.iEK);
        this.lxk.setClickable(true);
        this.lxk.setText(this.iEK.getString(R.string.skip));
        this.lxk.setTextSize(0, l.getDimens(this.iEK, R.dimen.tbds37));
        ao.setViewTextColor(this.lxk, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.iEK, R.dimen.tbds44);
        this.lxk.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lxk, this);
        this.jdb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lxm = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lxm).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void cFy() {
        this.lxk.setOnClickListener(this);
        this.jdb.setOnClickListener(this);
        this.lxm.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jdb && this.iEK != null) {
            if (this.lxl != null && this.lxl.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                dhx();
            }
        } else if (view == this.lxk) {
            dhx();
        }
    }

    private void dhx() {
        aq aqVar = new aq("c13682");
        aqVar.an("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.iEK).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void fg(List<b> list) {
        this.lxl = new InterestedForumFragment();
        this.lxl.fh(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lxl).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.iEK.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
    }
}

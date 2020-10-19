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
    private BaseFragmentActivity hSW;
    private View irv;
    private TextView kQv;
    private InterestedForumFragment kQw;
    private InterestSelectionFragment kQx;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hSW = baseFragmentActivity;
        initUI();
        cwK();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.hSW).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.kQv = new TextView(this.hSW);
        this.kQv.setClickable(true);
        this.kQv.setText(this.hSW.getString(R.string.skip));
        this.kQv.setTextSize(0, l.getDimens(this.hSW, R.dimen.tbds37));
        ap.setViewTextColor(this.kQv, R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.hSW, R.dimen.tbds44);
        this.kQv.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kQv, this);
        this.irv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kQx = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.kQx).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void cwK() {
        this.kQv.setOnClickListener(this);
        this.irv.setOnClickListener(this);
        this.kQx.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.irv && this.hSW != null) {
            if (this.kQw != null && this.kQw.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                dbk();
            }
        } else if (view == this.kQv) {
            dbk();
        }
    }

    private void dbk() {
        aq aqVar = new aq("c13682");
        aqVar.aj("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.hSW).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void eE(List<b> list) {
        this.kQw = new InterestedForumFragment();
        this.kQw.eF(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.kQw).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.hSW.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

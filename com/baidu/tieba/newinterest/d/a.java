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
    private View iDR;
    private BaseFragmentActivity ifx;
    private TextView lcT;
    private InterestedForumFragment lcU;
    private InterestSelectionFragment lcV;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ifx = baseFragmentActivity;
        initUI();
        czR();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.ifx).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.lcT = new TextView(this.ifx);
        this.lcT.setClickable(true);
        this.lcT.setText(this.ifx.getString(R.string.skip));
        this.lcT.setTextSize(0, l.getDimens(this.ifx, R.dimen.tbds37));
        ap.setViewTextColor(this.lcT, R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.ifx, R.dimen.tbds44);
        this.lcT.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lcT, this);
        this.iDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lcV = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lcV).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void czR() {
        this.lcT.setOnClickListener(this);
        this.iDR.setOnClickListener(this);
        this.lcV.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDR && this.ifx != null) {
            if (this.lcU != null && this.lcU.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                des();
            }
        } else if (view == this.lcT) {
            des();
        }
    }

    private void des() {
        aq aqVar = new aq("c13682");
        aqVar.aj("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.ifx).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void eN(List<b> list) {
        this.lcU = new InterestedForumFragment();
        this.lcU.eO(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lcU).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.ifx.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

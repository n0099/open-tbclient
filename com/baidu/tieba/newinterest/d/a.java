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
    private View hVu;
    private BaseFragmentActivity hwW;
    private TextView ksL;
    private InterestedForumFragment ksM;
    private InterestSelectionFragment ksN;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hwW = baseFragmentActivity;
        initUI();
        cqa();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.hwW).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.ksL = new TextView(this.hwW);
        this.ksL.setClickable(true);
        this.ksL.setText(this.hwW.getString(R.string.skip));
        this.ksL.setTextSize(0, l.getDimens(this.hwW, R.dimen.tbds37));
        ap.setViewTextColor(this.ksL, R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.hwW, R.dimen.tbds44);
        this.ksL.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ksL, this);
        this.hVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ksN = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.ksN).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void cqa() {
        this.ksL.setOnClickListener(this);
        this.hVu.setOnClickListener(this);
        this.ksN.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVu && this.hwW != null) {
            if (this.ksM != null && this.ksM.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                cTW();
            }
        } else if (view == this.ksL) {
            cTW();
        }
    }

    private void cTW() {
        aq aqVar = new aq("c13682");
        aqVar.ai("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.hwW).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void et(List<b> list) {
        this.ksM = new InterestedForumFragment();
        this.ksM.eu(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.ksM).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.hwW.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

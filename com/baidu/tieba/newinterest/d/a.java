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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.util.List;
/* loaded from: classes23.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private View iVw;
    private BaseFragmentActivity ixe;
    private TextView lwI;
    private InterestedForumFragment lwJ;
    private InterestSelectionFragment lwK;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ixe = baseFragmentActivity;
        initUI();
        cGq();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.ixe).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.lwI = new TextView(this.ixe);
        this.lwI.setClickable(true);
        this.lwI.setText(this.ixe.getString(R.string.skip));
        this.lwI.setTextSize(0, l.getDimens(this.ixe, R.dimen.tbds37));
        ap.setViewTextColor(this.lwI, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.ixe, R.dimen.tbds44);
        this.lwI.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lwI, this);
        this.iVw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lwK = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lwK).commitAllowingStateLoss();
        TiebaStatic.log(new ar("c13681"));
    }

    private void cGq() {
        this.lwI.setOnClickListener(this);
        this.iVw.setOnClickListener(this);
        this.lwK.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iVw && this.ixe != null) {
            if (this.lwJ != null && this.lwJ.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                dlE();
            }
        } else if (view == this.lwI) {
            dlE();
        }
    }

    private void dlE() {
        ar arVar = new ar("c13682");
        arVar.al("obj_type", 1);
        TiebaStatic.log(arVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.ixe).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void fg(List<b> list) {
        this.lwJ = new InterestedForumFragment();
        this.lwJ.fh(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lwJ).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.ixe.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
    }
}

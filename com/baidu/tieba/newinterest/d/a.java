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
    private View iVu;
    private BaseFragmentActivity ixc;
    private TextView lwG;
    private InterestedForumFragment lwH;
    private InterestSelectionFragment lwI;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ixc = baseFragmentActivity;
        initUI();
        cGp();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.ixc).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.lwG = new TextView(this.ixc);
        this.lwG.setClickable(true);
        this.lwG.setText(this.ixc.getString(R.string.skip));
        this.lwG.setTextSize(0, l.getDimens(this.ixc, R.dimen.tbds37));
        ap.setViewTextColor(this.lwG, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.ixc, R.dimen.tbds44);
        this.lwG.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lwG, this);
        this.iVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lwI = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lwI).commitAllowingStateLoss();
        TiebaStatic.log(new ar("c13681"));
    }

    private void cGp() {
        this.lwG.setOnClickListener(this);
        this.iVu.setOnClickListener(this);
        this.lwI.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iVu && this.ixc != null) {
            if (this.lwH != null && this.lwH.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                dlD();
            }
        } else if (view == this.lwG) {
            dlD();
        }
    }

    private void dlD() {
        ar arVar = new ar("c13682");
        arVar.al("obj_type", 1);
        TiebaStatic.log(arVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.ixc).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void fg(List<b> list) {
        this.lwH = new InterestedForumFragment();
        this.lwH.fh(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lwH).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.ixc.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
    }
}

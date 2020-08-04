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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.util.List;
/* loaded from: classes17.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private View hHY;
    private BaseFragmentActivity hjZ;
    private TextView kdj;
    private InterestedForumFragment kdk;
    private InterestSelectionFragment kdl;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hjZ = baseFragmentActivity;
        initUI();
        cfu();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.hjZ).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.kdj = new TextView(this.hjZ);
        this.kdj.setClickable(true);
        this.kdj.setText(this.hjZ.getString(R.string.skip));
        this.kdj.setTextSize(0, l.getDimens(this.hjZ, R.dimen.tbds37));
        ao.setViewTextColor(this.kdj, R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.hjZ, R.dimen.tbds44);
        this.kdj.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kdj, this);
        this.hHY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kdl = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.kdl).commitAllowingStateLoss();
        TiebaStatic.log(new ap("c13681"));
    }

    private void cfu() {
        this.kdj.setOnClickListener(this);
        this.hHY.setOnClickListener(this);
        this.kdl.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hHY && this.hjZ != null) {
            if (this.kdk != null && this.kdk.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                cJg();
            }
        } else if (view == this.kdj) {
            cJg();
        }
    }

    private void cJg() {
        ap apVar = new ap("c13682");
        apVar.ah("obj_type", 1);
        TiebaStatic.log(apVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.hjZ).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void el(List<b> list) {
        this.kdk = new InterestedForumFragment();
        this.kdk.em(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.kdk).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.hjZ.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

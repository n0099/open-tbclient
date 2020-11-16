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
/* loaded from: classes22.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private View iKB;
    private BaseFragmentActivity imj;
    private TextView ljh;
    private InterestedForumFragment lji;
    private InterestSelectionFragment ljj;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.imj = baseFragmentActivity;
        initUI();
        cBW();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.imj).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.ljh = new TextView(this.imj);
        this.ljh.setClickable(true);
        this.ljh.setText(this.imj.getString(R.string.skip));
        this.ljh.setTextSize(0, l.getDimens(this.imj, R.dimen.tbds37));
        ap.setViewTextColor(this.ljh, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.imj, R.dimen.tbds44);
        this.ljh.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ljh, this);
        this.iKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ljj = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.ljj).commitAllowingStateLoss();
        TiebaStatic.log(new ar("c13681"));
    }

    private void cBW() {
        this.ljh.setOnClickListener(this);
        this.iKB.setOnClickListener(this);
        this.ljj.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iKB && this.imj != null) {
            if (this.lji != null && this.lji.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                dgr();
            }
        } else if (view == this.ljh) {
            dgr();
        }
    }

    private void dgr() {
        ar arVar = new ar("c13682");
        arVar.ak("obj_type", 1);
        TiebaStatic.log(arVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.imj).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void eV(List<b> list) {
        this.lji = new InterestedForumFragment();
        this.lji.eW(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lji).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.imj.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
    }
}

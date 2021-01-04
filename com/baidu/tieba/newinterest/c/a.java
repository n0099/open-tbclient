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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private BaseFragmentActivity iJr;
    private View jhI;
    private TextView lBQ;
    private InterestedForumFragment lBR;
    private InterestSelectionFragment lBS;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iJr = baseFragmentActivity;
        initUI();
        cJp();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.iJr).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.lBQ = new TextView(this.iJr);
        this.lBQ.setClickable(true);
        this.lBQ.setText(this.iJr.getString(R.string.skip));
        this.lBQ.setTextSize(0, l.getDimens(this.iJr, R.dimen.tbds37));
        ao.setViewTextColor(this.lBQ, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.iJr, R.dimen.tbds44);
        this.lBQ.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lBQ, this);
        this.jhI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lBS = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lBS).commitAllowingStateLoss();
        TiebaStatic.log(new aq("c13681"));
    }

    private void cJp() {
        this.lBQ.setOnClickListener(this);
        this.jhI.setOnClickListener(this);
        this.lBS.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jhI && this.iJr != null) {
            if (this.lBR != null && this.lBR.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                dlo();
            }
        } else if (view == this.lBQ) {
            dlo();
        }
    }

    private void dlo() {
        aq aqVar = new aq("c13682");
        aqVar.an("obj_type", 1);
        TiebaStatic.log(aqVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.iJr).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void fg(List<b> list) {
        this.lBR = new InterestedForumFragment();
        this.lBR.fh(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lBR).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.iJr.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
    }
}

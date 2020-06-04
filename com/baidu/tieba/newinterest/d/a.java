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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private BaseFragmentActivity gRG;
    private View hpq;
    private TextView jBp;
    private InterestedForumFragment jBq;
    private InterestSelectionFragment jBr;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gRG = baseFragmentActivity;
        initUI();
        bYI();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.gRG).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jBp = new TextView(this.gRG);
        this.jBp.setClickable(true);
        this.jBp.setText(this.gRG.getString(R.string.skip));
        this.jBp.setTextSize(0, l.getDimens(this.gRG, R.dimen.tbds37));
        am.setViewTextColor(this.jBp, (int) R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.gRG, R.dimen.tbds44);
        this.jBp.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jBp, this);
        this.hpq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jBr = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.jBr).commitAllowingStateLoss();
        TiebaStatic.log(new an("c13681"));
    }

    private void bYI() {
        this.jBp.setOnClickListener(this);
        this.hpq.setOnClickListener(this);
        this.jBr.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpq && this.gRG != null) {
            if (this.jBq != null && this.jBq.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                cBg();
            }
        } else if (view == this.jBp) {
            cBg();
        }
    }

    private void cBg() {
        an anVar = new an("c13682");
        anVar.ag("obj_type", 1);
        TiebaStatic.log(anVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.gRG).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void dR(List<b> list) {
        this.jBq = new InterestedForumFragment();
        this.jBq.dS(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.jBq).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.gRG.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

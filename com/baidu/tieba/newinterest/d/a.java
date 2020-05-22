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
    private BaseFragmentActivity gRv;
    private View hpf;
    private TextView jAj;
    private InterestedForumFragment jAk;
    private InterestSelectionFragment jAl;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gRv = baseFragmentActivity;
        initUI();
        cAH();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.gRv).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jAj = new TextView(this.gRv);
        this.jAj.setClickable(true);
        this.jAj.setText(this.gRv.getString(R.string.skip));
        this.jAj.setTextSize(0, l.getDimens(this.gRv, R.dimen.tbds37));
        am.setViewTextColor(this.jAj, (int) R.color.cp_cont_j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.gRv, R.dimen.tbds44);
        this.jAj.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jAj, this);
        this.hpf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jAl = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.jAl).commitAllowingStateLoss();
        TiebaStatic.log(new an("c13681"));
    }

    private void cAH() {
        this.jAj.setOnClickListener(this);
        this.hpf.setOnClickListener(this);
        this.jAl.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpf && this.gRv != null) {
            if (this.jAk != null && this.jAk.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                cAQ();
            }
        } else if (view == this.jAj) {
            cAQ();
        }
    }

    private void cAQ() {
        an anVar = new an("c13682");
        anVar.ag("obj_type", 1);
        TiebaStatic.log(anVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.gRv).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void dP(List<b> list) {
        this.jAk = new InterestedForumFragment();
        this.jAk.dQ(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.jAk).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.gRv.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
    }
}

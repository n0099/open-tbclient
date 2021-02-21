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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    private BaseFragmentActivity iKH;
    private View jiW;
    private TextView lFC;
    private InterestedForumFragment lFD;
    private InterestSelectionFragment lFE;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iKH = baseFragmentActivity;
        initUI();
        cGS();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.iKH).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.lFC = new TextView(this.iKH);
        this.lFC.setClickable(true);
        this.lFC.setText(this.iKH.getString(R.string.skip));
        this.lFC.setTextSize(0, l.getDimens(this.iKH, R.dimen.tbds37));
        ap.setViewTextColor(this.lFC, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.iKH, R.dimen.tbds44);
        this.lFC.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lFC, this);
        this.jiW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lFE = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lFE).commitAllowingStateLoss();
        TiebaStatic.log(new ar("c13681"));
    }

    private void cGS() {
        this.lFC.setOnClickListener(this);
        this.jiW.setOnClickListener(this);
        this.lFE.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiW && this.iKH != null) {
            if (this.lFD != null && this.lFD.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                djF();
            }
        } else if (view == this.lFC) {
            djF();
        }
    }

    private void djF() {
        ar arVar = new ar("c13682");
        arVar.ap("obj_type", 1);
        TiebaStatic.log(arVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.iKH).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void fe(List<b> list) {
        this.lFD = new InterestedForumFragment();
        this.lFD.ff(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lFD).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.iKH.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
    }
}

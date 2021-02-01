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
    private BaseFragmentActivity iKt;
    private View jiI;
    private TextView lFo;
    private InterestedForumFragment lFp;
    private InterestSelectionFragment lFq;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iKt = baseFragmentActivity;
        initUI();
        cGL();
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.iKt).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.lFo = new TextView(this.iKt);
        this.lFo.setClickable(true);
        this.lFo.setText(this.iKt.getString(R.string.skip));
        this.lFo.setTextSize(0, l.getDimens(this.iKt, R.dimen.tbds37));
        ap.setViewTextColor(this.lFo, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.iKt, R.dimen.tbds44);
        this.lFo.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lFo, this);
        this.jiI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lFq = new InterestSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lFq).commitAllowingStateLoss();
        TiebaStatic.log(new ar("c13681"));
    }

    private void cGL() {
        this.lFo.setOnClickListener(this);
        this.jiI.setOnClickListener(this);
        this.lFq.a(this);
    }

    public View getView() {
        return this.mRoot;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiI && this.iKt != null) {
            if (this.lFp != null && this.lFp.isVisible()) {
                getFragmentManager().popBackStack();
            } else {
                djy();
            }
        } else if (view == this.lFo) {
            djy();
        }
    }

    private void djy() {
        ar arVar = new ar("c13682");
        arVar.ap("obj_type", 1);
        TiebaStatic.log(arVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.iKt).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void fe(List<b> list) {
        this.lFp = new InterestedForumFragment();
        this.lFp.ff(list);
        getFragmentManager().beginTransaction().add(R.id.content_container, this.lFp).addToBackStack(null).commitAllowingStateLoss();
    }

    private FragmentManager getFragmentManager() {
        return this.iKt.getSupportFragmentManager();
    }

    public void onBackPressed() {
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
    }
}

package com.baidu.tieba.square;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class aa extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    public static boolean aWP = false;
    private BaseFragmentActivity axV;
    private NavigationBar mNavigationBar;
    private aq bML = null;
    private am bMM = null;
    private boolean bMN = false;
    private boolean bMO = false;
    private long aAK = -1;
    private Handler mHandler = null;
    private Runnable atU = null;
    private final an bMP = new ab(this);
    private final com.baidu.tbadk.core.view.u ati = new ac(this);
    private final View.OnKeyListener aMn = new ad(this);
    private final com.baidu.adp.widget.ListView.f uo = new ae(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.axV = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return d(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aAK = System.currentTimeMillis();
        dF();
        initUI();
        initData();
    }

    private View d(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.w.square_view, (ViewGroup) null);
    }

    public static String aD(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("square_page");
        try {
            sb.append(URLEncoder.encode("|", "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            sb.append("|");
        }
        sb.append(String.valueOf(str) + "_" + str2);
        return sb.toString();
    }

    private void initUI() {
        this.bML = new aq(this.axV, this, this.aMn);
        this.bML.a(this.uo);
        this.bML.adB().setClickStatKey("sq_tb_search");
        this.mNavigationBar = (NavigationBar) this.axV.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.mNavigationBar.setTitleText(this.axV.getString(com.baidu.tieba.y.ba_square));
    }

    private void initData() {
        this.bMM = new am(this.axV);
        this.bMM.a(this.bMP);
        this.bMO = true;
        eH(this.bMO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS() {
        this.bML.c(this.ati);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CT() {
        this.bML.d(this.ati);
    }

    public void dF() {
        this.mHandler = new Handler();
        this.atU = new ag(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        this.bML.onStop();
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            if (aWP) {
                eH(true);
                aWP = false;
            }
            if (this.mHandler != null && !this.bMO) {
                this.mHandler.removeCallbacks(this.atU);
                this.mHandler.postDelayed(this.atU, 0L);
                this.bML.onResume();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.atU);
        }
        this.bML.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.atU);
        }
        this.bML.onDestroy();
        so();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bML != null) {
            this.bML.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(i);
        }
    }

    private void so() {
        this.bMM.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        if (this.bMM != null) {
            boolean z6 = this.bMM.ady() == null || this.bMM.ady().isEmpty();
            boolean z7 = z;
            if (com.baidu.adp.lib.util.j.fh()) {
                boolean z8 = z6;
                z2 = z7;
                z3 = z8;
            } else {
                this.bMO = false;
                z3 = true;
                z2 = false;
            }
            if (!this.bMO) {
                z4 = z3;
                z5 = z2;
            }
            if (z4 || z5) {
                so();
                if (z5) {
                    this.bMM.adz();
                } else {
                    this.bMM.adA();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.mHandler.removeCallbacks(this.atU);
        this.mHandler.postDelayed(this.atU, 90L);
    }
}

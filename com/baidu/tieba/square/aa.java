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
    public static boolean aXd = false;
    private BaseFragmentActivity aye;
    private NavigationBar mNavigationBar;
    private aq bNa = null;
    private am bNb = null;
    private boolean bNc = false;
    private boolean bNd = false;
    private long aAU = -1;
    private Handler mHandler = null;
    private Runnable aud = null;
    private final an bNe = new ab(this);
    private final com.baidu.tbadk.core.view.u atr = new ac(this);
    private final View.OnKeyListener aMB = new ad(this);
    private final com.baidu.adp.widget.ListView.f uo = new ae(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aye = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return d(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aAU = System.currentTimeMillis();
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
        this.bNa = new aq(this.aye, this, this.aMB);
        this.bNa.a(this.uo);
        this.bNa.adE().setClickStatKey("sq_tb_search");
        this.mNavigationBar = (NavigationBar) this.aye.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.mNavigationBar.setTitleText(this.aye.getString(com.baidu.tieba.y.ba_square));
    }

    private void initData() {
        this.bNb = new am(this.aye);
        this.bNb.a(this.bNe);
        this.bNd = true;
        eH(this.bNd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU() {
        this.bNa.c(this.atr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CV() {
        this.bNa.d(this.atr);
    }

    public void dF() {
        this.mHandler = new Handler();
        this.aud = new ag(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        this.bNa.onStop();
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            if (aXd) {
                eH(true);
                aXd = false;
            }
            if (this.mHandler != null && !this.bNd) {
                this.mHandler.removeCallbacks(this.aud);
                this.mHandler.postDelayed(this.aud, 0L);
                this.bNa.onResume();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aud);
        }
        this.bNa.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aud);
        }
        this.bNa.onDestroy();
        sq();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bNa != null) {
            this.bNa.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(i);
        }
    }

    private void sq() {
        this.bNb.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        if (this.bNb != null) {
            boolean z6 = this.bNb.adB() == null || this.bNb.adB().isEmpty();
            boolean z7 = z;
            if (com.baidu.adp.lib.util.j.fh()) {
                boolean z8 = z6;
                z2 = z7;
                z3 = z8;
            } else {
                this.bNd = false;
                z3 = true;
                z2 = false;
            }
            if (!this.bNd) {
                z4 = z3;
                z5 = z2;
            }
            if (z4 || z5) {
                sq();
                if (z5) {
                    this.bNb.adC();
                } else {
                    this.bNb.adD();
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
        this.mHandler.removeCallbacks(this.aud);
        this.mHandler.postDelayed(this.aud, 90L);
    }
}

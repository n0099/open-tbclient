package com.baidu.tieba.neighbors;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Person.DataRes;
import tbclient.Person.UserInfos;
/* loaded from: classes.dex */
public class NeighborsActivity extends BaseActivity implements aa {
    private View aGI;
    private NavigationBar aGJ;
    private boolean aJD;
    private com.baidu.tbadk.core.view.o ahO;
    private NoNetworkView aoJ;
    private String btE;
    private String btF;
    private List<UserInfos> btH;
    private View btI;
    private View btJ;
    private BdListView btK;
    private k btL;
    private MorePopupWindow btM;
    private View btN;
    private View btO;
    private View btP;
    private View btQ;
    private boolean mHasMore;
    private int mOffset;
    private int mGeo = -1;
    private int btG = 0;
    private y Yc = null;
    private HttpMessageListener btR = new a(this, CmdConfigHttp.CLEAR_LOCATION_INFO);
    private HttpMessageListener btS = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);
    private com.baidu.adp.framework.listener.e btT = new d(this, 303004);
    private com.baidu.adp.lib.d.d btU = new e(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(NeighborsActivityConfig.class, NeighborsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.neighbors_activity);
        rY();
        Ib();
        Intent intent = getIntent();
        dS(intent != null ? intent.getBooleanExtra(NeighborsActivityConfig.LOCATING, false) : false);
    }

    private void rY() {
        this.aGI = findViewById(t.parent);
        this.btK = (BdListView) findViewById(t.neighbors_list);
        this.btI = findViewById(t.locating_failed);
        this.aoJ = (NoNetworkView) this.aGI.findViewById(t.view_no_network);
        this.aoJ.a(new f(this));
        this.Yc = new y(this);
        this.Yc.a(new g(this));
        this.btK.setPullRefresh(this.Yc);
        this.btL = new k(this);
        this.btL.p(new h(this));
        this.btK.setAdapter((ListAdapter) this.btL);
        this.btK.setOnItemClickListener(this);
        this.btK.setOnSrollToBottomListener(this);
        this.ahO = NoDataViewFactory.a(this, this.aGI, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(v.warning_location_error_in_neighbors), null);
        this.aGJ = (NavigationBar) findViewById(t.navigation_bar);
        this.aGJ.setTitleText(v.neighbors);
        this.aGJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
        this.btJ = this.aGJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.navigation_menu, this);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this, u.neighbors_menu_layout, null);
        this.btM = new MorePopupWindow(this, inflate, this.aGJ, getResources().getDrawable(s.bg_pull_down_right_n), null);
        this.btN = inflate.findViewById(t.neighbors_menu_female);
        this.btN.setOnClickListener(this);
        this.btO = inflate.findViewById(t.neighbors_menu_male);
        this.btO.setOnClickListener(this);
        this.btP = inflate.findViewById(t.neighbors_menu_all);
        this.btP.setOnClickListener(this);
        this.btQ = inflate.findViewById(t.neighbors_menu_clear);
        this.btQ.setOnClickListener(this);
    }

    private void Ib() {
        registerListener(this.btT);
        registerListener(this.btS);
        registerListener(this.btR);
    }

    private void dS(boolean z) {
        if (z) {
            VP();
            VQ();
            return;
        }
        this.btE = TbadkApplication.m251getInst().getLocationLat();
        this.btF = TbadkApplication.m251getInst().getLocationLng();
        if (TextUtils.isEmpty(this.btE) || TextUtils.isEmpty(this.btF)) {
            VQ();
        } else {
            dT(true);
        }
    }

    private void VL() {
        this.ahO.setVisibility(8);
        this.btK.setVisibility(0);
    }

    private void VM() {
        com.baidu.tbadk.core.view.s bL;
        if (this.btG == 2) {
            bL = com.baidu.tbadk.core.view.s.bL(v.warning_no_neighbors_female);
        } else if (this.btG == 1) {
            bL = com.baidu.tbadk.core.view.s.bL(v.warning_no_neighbors_male);
        } else {
            bL = com.baidu.tbadk.core.view.s.bL(v.warning_no_neighbors_all);
        }
        this.ahO.setTextOption(bL);
        this.btK.setVisibility(8);
        this.btI.setVisibility(8);
        this.ahO.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VN() {
        this.btK.setVisibility(8);
        this.btI.setVisibility(8);
        this.ahO.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VO() {
        this.btK.setVisibility(8);
        this.ahO.setVisibility(8);
    }

    private void VP() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    private void VQ() {
        if (com.baidu.adp.lib.util.m.isNetOk()) {
            showLoadingDialog(getString(v.warning_locating));
            com.baidu.adp.lib.d.a.dE().a(true, this.btU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(boolean z) {
        this.aJD = true;
        if (z) {
            showLoadingDialog(getString(v.warning_searching_neighbors));
        }
        RequestGetNeighborsMessage requestGetNeighborsMessage = new RequestGetNeighborsMessage(303004);
        requestGetNeighborsMessage.setParams(this.btE, this.btF, this.mGeo, this.btG, this.mOffset);
        sendMessage(requestGetNeighborsMessage);
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (!this.aJD && this.mHasMore) {
            this.aJD = true;
            dT(false);
        }
    }

    private void VS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(v.warning_clear_location_info);
        aVar.a(v.confirm, new j(this));
        aVar.b(v.cancel, new b(this));
        aVar.kT();
        aVar.kW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        boolean z;
        if (dataRes == null) {
            if (this.mOffset == 0) {
                VM();
                return;
            }
            return;
        }
        Integer num = dataRes.has_more;
        if (num == null) {
            this.mHasMore = false;
        } else {
            this.mHasMore = num.intValue() == 1;
        }
        List<UserInfos> list = dataRes.user_infos;
        if ((list == null || list.size() == 0) && this.mOffset == 0) {
            VM();
            return;
        }
        if (this.btH == null) {
            this.btH = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (UserInfos userInfos : list) {
            Iterator<UserInfos> it = this.btH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                UserInfos next = it.next();
                if (next.user_id != null && userInfos.user_id != null && next.user_id.intValue() == userInfos.user_id.intValue()) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                arrayList.add(userInfos);
            }
        }
        this.btH.addAll(arrayList);
        this.mOffset = this.btH.size();
        if (this.mOffset == 0) {
            VM();
            return;
        }
        VL();
        this.btL.setData(this.btH);
        this.btL.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VT() {
        this.mHasMore = false;
        this.mOffset = 0;
        this.btH = new ArrayList();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ahO.nv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ahO.onActivityStop();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.btN) {
            com.baidu.adp.lib.g.j.a(this.btM, this);
            if (this.btG != 2) {
                this.btG = 2;
                VT();
                dT(true);
            }
        } else if (view == this.btO) {
            com.baidu.adp.lib.g.j.a(this.btM, this);
            if (this.btG != 1) {
                this.btG = 1;
                VT();
                dT(true);
            }
        } else if (view == this.btP) {
            com.baidu.adp.lib.g.j.a(this.btM, this);
            if (this.btG != 0) {
                this.btG = 0;
                VT();
                dT(true);
            }
        } else if (view == this.btQ) {
            com.baidu.adp.lib.g.j.a(this.btM, this);
            VS();
        } else if (view == this.btJ) {
            this.btM.showWindowInRightBottomOfHost();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.btL != null) {
            this.btL.Sy();
            this.btL = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        UserInfos item = this.btL.getItem(i);
        if (item != null) {
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, String.valueOf(item.user_id), item.user_name)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.aGI);
        getLayoutMode().h(this.btK);
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
        this.aGJ.onChangeSkinType(i);
        this.aoJ.onChangeSkinType(i);
        this.Yc.bM(i);
        this.btM.onChangeSkinType(this, i, aw.getDrawable(s.bg_pull_down_right_n));
        this.btL.notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        VR();
    }
}

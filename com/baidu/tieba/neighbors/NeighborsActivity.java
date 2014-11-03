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
    private View aGS;
    private NavigationBar aGT;
    private boolean aJQ;
    private com.baidu.tbadk.core.view.o ahX;
    private NoNetworkView aoS;
    private String btS;
    private String btT;
    private List<UserInfos> btV;
    private View btW;
    private View btX;
    private BdListView btY;
    private k btZ;
    private MorePopupWindow bua;
    private View bub;
    private View buc;
    private View bud;
    private View bue;
    private boolean mHasMore;
    private int mOffset;
    private int mGeo = -1;
    private int btU = 0;
    private y Yg = null;
    private HttpMessageListener buf = new a(this, CmdConfigHttp.CLEAR_LOCATION_INFO);
    private HttpMessageListener bug = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);
    private com.baidu.adp.framework.listener.e buh = new d(this, 303004);
    private com.baidu.adp.lib.d.d bui = new e(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(NeighborsActivityConfig.class, NeighborsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.neighbors_activity);
        sa();
        If();
        Intent intent = getIntent();
        dS(intent != null ? intent.getBooleanExtra(NeighborsActivityConfig.LOCATING, false) : false);
    }

    private void sa() {
        this.aGS = findViewById(t.parent);
        this.btY = (BdListView) findViewById(t.neighbors_list);
        this.btW = findViewById(t.locating_failed);
        this.aoS = (NoNetworkView) this.aGS.findViewById(t.view_no_network);
        this.aoS.a(new f(this));
        this.Yg = new y(this);
        this.Yg.a(new g(this));
        this.btY.setPullRefresh(this.Yg);
        this.btZ = new k(this);
        this.btZ.p(new h(this));
        this.btY.setAdapter((ListAdapter) this.btZ);
        this.btY.setOnItemClickListener(this);
        this.btY.setOnSrollToBottomListener(this);
        this.ahX = NoDataViewFactory.a(this, this.aGS, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(v.warning_location_error_in_neighbors), null);
        this.aGT = (NavigationBar) findViewById(t.navigation_bar);
        this.aGT.setTitleText(v.neighbors);
        this.aGT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
        this.btX = this.aGT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.navigation_menu, this);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this, u.neighbors_menu_layout, null);
        this.bua = new MorePopupWindow(this, inflate, this.aGT, getResources().getDrawable(s.bg_pull_down_right_n), null);
        this.bub = inflate.findViewById(t.neighbors_menu_female);
        this.bub.setOnClickListener(this);
        this.buc = inflate.findViewById(t.neighbors_menu_male);
        this.buc.setOnClickListener(this);
        this.bud = inflate.findViewById(t.neighbors_menu_all);
        this.bud.setOnClickListener(this);
        this.bue = inflate.findViewById(t.neighbors_menu_clear);
        this.bue.setOnClickListener(this);
    }

    private void If() {
        registerListener(this.buh);
        registerListener(this.bug);
        registerListener(this.buf);
    }

    private void dS(boolean z) {
        if (z) {
            VS();
            VT();
            return;
        }
        this.btS = TbadkApplication.m251getInst().getLocationLat();
        this.btT = TbadkApplication.m251getInst().getLocationLng();
        if (TextUtils.isEmpty(this.btS) || TextUtils.isEmpty(this.btT)) {
            VT();
        } else {
            dT(true);
        }
    }

    private void VO() {
        this.ahX.setVisibility(8);
        this.btY.setVisibility(0);
    }

    private void VP() {
        com.baidu.tbadk.core.view.s bL;
        if (this.btU == 2) {
            bL = com.baidu.tbadk.core.view.s.bL(v.warning_no_neighbors_female);
        } else if (this.btU == 1) {
            bL = com.baidu.tbadk.core.view.s.bL(v.warning_no_neighbors_male);
        } else {
            bL = com.baidu.tbadk.core.view.s.bL(v.warning_no_neighbors_all);
        }
        this.ahX.setTextOption(bL);
        this.btY.setVisibility(8);
        this.btW.setVisibility(8);
        this.ahX.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VQ() {
        this.btY.setVisibility(8);
        this.btW.setVisibility(8);
        this.ahX.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        this.btY.setVisibility(8);
        this.ahX.setVisibility(8);
    }

    private void VS() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    private void VT() {
        if (com.baidu.adp.lib.util.m.isNetOk()) {
            showLoadingDialog(getString(v.warning_locating));
            com.baidu.adp.lib.d.a.dE().a(true, this.bui);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(boolean z) {
        this.aJQ = true;
        if (z) {
            showLoadingDialog(getString(v.warning_searching_neighbors));
        }
        RequestGetNeighborsMessage requestGetNeighborsMessage = new RequestGetNeighborsMessage(303004);
        requestGetNeighborsMessage.setParams(this.btS, this.btT, this.mGeo, this.btU, this.mOffset);
        sendMessage(requestGetNeighborsMessage);
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        if (!this.aJQ && this.mHasMore) {
            this.aJQ = true;
            dT(false);
        }
    }

    private void VV() {
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
                VP();
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
            VP();
            return;
        }
        if (this.btV == null) {
            this.btV = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (UserInfos userInfos : list) {
            Iterator<UserInfos> it = this.btV.iterator();
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
        this.btV.addAll(arrayList);
        this.mOffset = this.btV.size();
        if (this.mOffset == 0) {
            VP();
            return;
        }
        VO();
        this.btZ.setData(this.btV);
        this.btZ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VW() {
        this.mHasMore = false;
        this.mOffset = 0;
        this.btV = new ArrayList();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ahX.nv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ahX.onActivityStop();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bub) {
            com.baidu.adp.lib.g.j.a(this.bua, this);
            if (this.btU != 2) {
                this.btU = 2;
                VW();
                dT(true);
            }
        } else if (view == this.buc) {
            com.baidu.adp.lib.g.j.a(this.bua, this);
            if (this.btU != 1) {
                this.btU = 1;
                VW();
                dT(true);
            }
        } else if (view == this.bud) {
            com.baidu.adp.lib.g.j.a(this.bua, this);
            if (this.btU != 0) {
                this.btU = 0;
                VW();
                dT(true);
            }
        } else if (view == this.bue) {
            com.baidu.adp.lib.g.j.a(this.bua, this);
            VV();
        } else if (view == this.btX) {
            this.bua.showWindowInRightBottomOfHost();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.btZ != null) {
            this.btZ.SB();
            this.btZ = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        UserInfos item = this.btZ.getItem(i);
        if (item != null) {
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, String.valueOf(item.user_id), item.user_name)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.aGS);
        getLayoutMode().h(this.btY);
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
        this.aGT.onChangeSkinType(i);
        this.aoS.onChangeSkinType(i);
        this.Yg.bM(i);
        this.bua.onChangeSkinType(this, i, aw.getDrawable(s.bg_pull_down_right_n));
        this.btZ.notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        VU();
    }
}

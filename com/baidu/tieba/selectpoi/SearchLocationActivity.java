package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationSearchNetRequestMessage;
import com.baidu.tieba.tbadkCore.location.LocationSearchResponseMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private ImageView Vu;
    private com.baidu.tieba.tbadkCore.location.k bOB;
    private h bOC;
    private LinearLayout bOD;
    private TextView bOE;
    private com.baidu.adp.framework.listener.a bOF = new c(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private AdapterView.OnItemClickListener bOG = new d(this);
    private EditText bsw;
    private BdListView mListView;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002012, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        acQ();
        com.baidu.tieba.tbadkCore.a.a.c(303018, LocationSearchResponseMessage.class, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bOF);
        acQ();
        setContentView(x.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aeV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.bOD = (LinearLayout) this.aeV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.search_location_edit_layout, (View.OnClickListener) null);
        this.Vu = (ImageView) this.bOD.findViewById(w.search_bar_icon);
        this.bsw = (EditText) this.bOD.findViewById(w.search_location_editview);
        this.bsw.addTextChangedListener(new f(this));
        this.bOE = (TextView) this.bOD.findViewById(w.search_location_bt_search_s);
        this.bOE.setEnabled(false);
        this.bOE.setOnClickListener(new g(this));
        this.mListView = (BdListView) findViewById(w.search_position_list);
        this.bOC = new h(this);
        this.mListView.setAdapter((ListAdapter) this.bOC);
        this.mListView.setOnItemClickListener(this.bOG);
    }

    public void initData() {
        this.bOB = new com.baidu.tieba.tbadkCore.location.k();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aic().getLocationData();
        if (locationData != null) {
            this.bOB.R(a(locationData.ahZ(), locationData.ahY(), locationData.aia()));
        }
        this.bOC.a(this.bOB);
        this.bOC.notifyDataSetChanged();
    }

    private ArrayList<com.baidu.tieba.tbadkCore.location.l> a(List<com.baidu.tieba.tbadkCore.location.b> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.location.l> arrayList = new ArrayList<>();
        com.baidu.tieba.tbadkCore.location.b bVar = null;
        for (com.baidu.tieba.tbadkCore.location.b bVar2 : list) {
            if (bVar2 != null && !TextUtils.isEmpty(bVar2.getName())) {
                if (TextUtils.equals(bVar2.getName(), str)) {
                    bVar = bVar2;
                } else {
                    com.baidu.tieba.tbadkCore.location.l lVar = new com.baidu.tieba.tbadkCore.location.l();
                    lVar.setName(bVar2.getName());
                    lVar.iq(bVar2.aia());
                    arrayList.add(lVar);
                }
            }
        }
        if (bVar != null) {
            com.baidu.tieba.tbadkCore.location.l lVar2 = new com.baidu.tieba.tbadkCore.location.l();
            lVar2.setName(bVar.getName());
            lVar2.iq(bVar.aia());
            arrayList.add(0, lVar2);
        } else {
            com.baidu.tieba.tbadkCore.location.l lVar3 = new com.baidu.tieba.tbadkCore.location.l();
            lVar3.setName(str);
            lVar3.iq(str2);
            arrayList.add(0, lVar3);
        }
        return arrayList;
    }

    public void acP() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(acD());
        sendMessage(locationSearchNetRequestMessage);
    }

    private static void acQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, com.baidu.tieba.tbadkCore.a.a.O(TbConfig.GET_SUGGEST_LOCATION_BY_NAME, 303018));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LocationSearchHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public String acD() {
        if (this.bsw != null) {
            return com.baidu.adp.lib.util.k.a(this.bsw.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.i((View) this.bOE, v.btn_titlebar_finish);
        bc.c(this.Vu, v.icon_search_ba);
        bc.b(this.bOE, t.search_location_button_color, 3);
        if (i == 1) {
            this.bsw.setTextColor(-6574132);
            this.bsw.setHintTextColor(-11643034);
        } else {
            this.bsw.setTextColor(-2300171);
            this.bsw.setHintTextColor(-10195067);
        }
        this.bOC.notifyDataSetChanged();
    }
}

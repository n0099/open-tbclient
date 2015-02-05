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
    private ImageView Vr;
    private com.baidu.tieba.tbadkCore.location.k bOA;
    private h bOB;
    private LinearLayout bOC;
    private TextView bOD;
    private com.baidu.adp.framework.listener.a bOE = new c(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private AdapterView.OnItemClickListener bOF = new d(this);
    private EditText bsv;
    private BdListView mListView;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002012, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        acL();
        com.baidu.tieba.tbadkCore.a.a.c(303018, LocationSearchResponseMessage.class, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bOE);
        acL();
        setContentView(x.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aeS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.bOC = (LinearLayout) this.aeS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.search_location_edit_layout, (View.OnClickListener) null);
        this.Vr = (ImageView) this.bOC.findViewById(w.search_bar_icon);
        this.bsv = (EditText) this.bOC.findViewById(w.search_location_editview);
        this.bsv.addTextChangedListener(new f(this));
        this.bOD = (TextView) this.bOC.findViewById(w.search_location_bt_search_s);
        this.bOD.setEnabled(false);
        this.bOD.setOnClickListener(new g(this));
        this.mListView = (BdListView) findViewById(w.search_position_list);
        this.bOB = new h(this);
        this.mListView.setAdapter((ListAdapter) this.bOB);
        this.mListView.setOnItemClickListener(this.bOF);
    }

    public void initData() {
        this.bOA = new com.baidu.tieba.tbadkCore.location.k();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.ahX().getLocationData();
        if (locationData != null) {
            this.bOA.R(a(locationData.ahU(), locationData.ahT(), locationData.ahV()));
        }
        this.bOB.a(this.bOA);
        this.bOB.notifyDataSetChanged();
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
                    lVar.io(bVar2.ahV());
                    arrayList.add(lVar);
                }
            }
        }
        if (bVar != null) {
            com.baidu.tieba.tbadkCore.location.l lVar2 = new com.baidu.tieba.tbadkCore.location.l();
            lVar2.setName(bVar.getName());
            lVar2.io(bVar.ahV());
            arrayList.add(0, lVar2);
        } else {
            com.baidu.tieba.tbadkCore.location.l lVar3 = new com.baidu.tieba.tbadkCore.location.l();
            lVar3.setName(str);
            lVar3.io(str2);
            arrayList.add(0, lVar3);
        }
        return arrayList;
    }

    public void acK() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(acy());
        sendMessage(locationSearchNetRequestMessage);
    }

    private static void acL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, com.baidu.tieba.tbadkCore.a.a.O(TbConfig.GET_SUGGEST_LOCATION_BY_NAME, 303018));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LocationSearchHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public String acy() {
        if (this.bsv != null) {
            return com.baidu.adp.lib.util.k.a(this.bsv.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.i((View) this.bOD, v.btn_titlebar_finish);
        bc.c(this.Vr, v.icon_search_ba);
        bc.b(this.bOD, t.search_location_button_color, 3);
        if (i == 1) {
            this.bsv.setTextColor(-6574132);
            this.bsv.setHintTextColor(-11643034);
        } else {
            this.bsv.setTextColor(-2300171);
            this.bsv.setHintTextColor(-10195067);
        }
        this.bOB.notifyDataSetChanged();
    }
}

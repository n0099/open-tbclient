package com.baidu.tieba.write.selectpoi;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.LocationSearchNetRequestMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private EditText byS;
    private com.baidu.tieba.tbadkCore.location.l cvb;
    private g cvc;
    private LinearLayout cvd;
    private TextView cve;
    private ImageView cvf;
    private com.baidu.adp.framework.listener.a cvg = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private AdapterView.OnItemClickListener cvh = new b(this);
    private BdListView mListView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cvg);
        SearchLocationActivityStatic.aqk();
        setContentView(w.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.cvd = (LinearLayout) this.anm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.search_location_edit_layout, (View.OnClickListener) null);
        this.cvf = (ImageView) this.cvd.findViewById(v.search_bar_icon);
        this.byS = (EditText) this.cvd.findViewById(v.search_location_editview);
        this.byS.addTextChangedListener(new d(this));
        this.cve = (TextView) this.cvd.findViewById(v.search_location_bt_search_s);
        this.cve.setEnabled(false);
        this.cve.setOnClickListener(new e(this));
        this.mListView = (BdListView) findViewById(v.search_position_list);
        this.cvc = new g(this);
        this.mListView.setAdapter((ListAdapter) this.cvc);
        this.mListView.setOnItemClickListener(this.cvh);
    }

    public void initData() {
        this.cvb = new com.baidu.tieba.tbadkCore.location.l();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.d.anb().getLocationData();
        if (locationData != null) {
            this.cvb.W(a(locationData.amY(), locationData.amX(), locationData.amZ()));
        }
        this.cvc.a(this.cvb);
        this.cvc.notifyDataSetChanged();
    }

    private ArrayList<com.baidu.tieba.tbadkCore.location.m> a(List<com.baidu.tieba.tbadkCore.location.b> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.location.m> arrayList = new ArrayList<>();
        com.baidu.tieba.tbadkCore.location.b bVar = null;
        for (com.baidu.tieba.tbadkCore.location.b bVar2 : list) {
            if (bVar2 != null && !TextUtils.isEmpty(bVar2.getName())) {
                if (TextUtils.equals(bVar2.getName(), str)) {
                    bVar = bVar2;
                } else {
                    com.baidu.tieba.tbadkCore.location.m mVar = new com.baidu.tieba.tbadkCore.location.m();
                    mVar.setName(bVar2.getName());
                    mVar.iI(bVar2.amZ());
                    arrayList.add(mVar);
                }
            }
        }
        if (bVar != null) {
            com.baidu.tieba.tbadkCore.location.m mVar2 = new com.baidu.tieba.tbadkCore.location.m();
            mVar2.setName(bVar.getName());
            mVar2.iI(bVar.amZ());
            arrayList.add(0, mVar2);
        } else {
            com.baidu.tieba.tbadkCore.location.m mVar3 = new com.baidu.tieba.tbadkCore.location.m();
            mVar3.setName(str);
            mVar3.iI(str2);
            arrayList.add(0, mVar3);
        }
        return arrayList;
    }

    public void aqj() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(afI());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String afI() {
        if (this.byS != null) {
            return com.baidu.adp.lib.util.m.a(this.byS.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.i((View) this.cve, u.btn_titlebar_finish);
        ba.c(this.cvf, u.icon_search_ba);
        ba.b(this.cve, s.search_location_button_color, 3);
        if (i == 1) {
            this.byS.setTextColor(-6574132);
            this.byS.setHintTextColor(-11643034);
        } else {
            this.byS.setTextColor(-2300171);
            this.byS.setHintTextColor(-10195067);
        }
        this.cvc.notifyDataSetChanged();
    }
}

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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.LocationSearchNetRequestMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private EditText bBM;
    private com.baidu.tieba.tbadkCore.location.l czI;
    private g czJ;
    private LinearLayout czK;
    private TextView czL;
    private ImageView czM;
    private com.baidu.adp.framework.listener.a czN = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private AdapterView.OnItemClickListener czO = new b(this);
    private BdListView mListView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.czN);
        SearchLocationActivityStatic.asp();
        setContentView(r.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.czK = (LinearLayout) this.aox.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.search_location_edit_layout, (View.OnClickListener) null);
        this.czM = (ImageView) this.czK.findViewById(q.search_bar_icon);
        this.bBM = (EditText) this.czK.findViewById(q.search_location_editview);
        this.bBM.addTextChangedListener(new d(this));
        this.czL = (TextView) this.czK.findViewById(q.search_location_bt_search_s);
        this.czL.setEnabled(false);
        this.czL.setOnClickListener(new e(this));
        this.mListView = (BdListView) findViewById(q.search_position_list);
        this.czJ = new g(this);
        this.mListView.setAdapter((ListAdapter) this.czJ);
        this.mListView.setOnItemClickListener(this.czO);
    }

    public void initData() {
        this.czI = new com.baidu.tieba.tbadkCore.location.l();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.d.aph().getLocationData();
        if (locationData != null) {
            this.czI.U(a(locationData.ape(), locationData.apd(), locationData.apf()));
        }
        this.czJ.a(this.czI);
        this.czJ.notifyDataSetChanged();
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
                    mVar.jF(bVar2.apf());
                    arrayList.add(mVar);
                }
            }
        }
        if (bVar != null) {
            com.baidu.tieba.tbadkCore.location.m mVar2 = new com.baidu.tieba.tbadkCore.location.m();
            mVar2.setName(bVar.getName());
            mVar2.jF(bVar.apf());
            arrayList.add(0, mVar2);
        } else {
            com.baidu.tieba.tbadkCore.location.m mVar3 = new com.baidu.tieba.tbadkCore.location.m();
            mVar3.setName(str);
            mVar3.jF(str2);
            arrayList.add(0, mVar3);
        }
        return arrayList;
    }

    public void aso() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(ahM());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String ahM() {
        if (this.bBM != null) {
            return com.baidu.adp.lib.util.m.a(this.bBM.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ay.i((View) this.czL, p.btn_titlebar_finish);
        ay.c(this.czM, p.icon_search_ba);
        ay.b(this.czL, com.baidu.tieba.n.search_location_button_color, 3);
        if (i == 1) {
            this.bBM.setTextColor(-6574132);
            this.bBM.setHintTextColor(-11643034);
        } else {
            this.bBM.setTextColor(-2300171);
            this.bBM.setHintTextColor(-10195067);
        }
        this.czJ.notifyDataSetChanged();
    }
}

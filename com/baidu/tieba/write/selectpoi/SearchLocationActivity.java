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
    private EditText bze;
    private com.baidu.tieba.tbadkCore.location.l cvr;
    private g cvs;
    private LinearLayout cvt;
    private TextView cvu;
    private ImageView cvv;
    private com.baidu.adp.framework.listener.a cvw = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private AdapterView.OnItemClickListener cvx = new b(this);
    private BdListView mListView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cvw);
        SearchLocationActivityStatic.aqz();
        setContentView(w.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.anu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.cvt = (LinearLayout) this.anu.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.search_location_edit_layout, (View.OnClickListener) null);
        this.cvv = (ImageView) this.cvt.findViewById(v.search_bar_icon);
        this.bze = (EditText) this.cvt.findViewById(v.search_location_editview);
        this.bze.addTextChangedListener(new d(this));
        this.cvu = (TextView) this.cvt.findViewById(v.search_location_bt_search_s);
        this.cvu.setEnabled(false);
        this.cvu.setOnClickListener(new e(this));
        this.mListView = (BdListView) findViewById(v.search_position_list);
        this.cvs = new g(this);
        this.mListView.setAdapter((ListAdapter) this.cvs);
        this.mListView.setOnItemClickListener(this.cvx);
    }

    public void initData() {
        this.cvr = new com.baidu.tieba.tbadkCore.location.l();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.d.anq().getLocationData();
        if (locationData != null) {
            this.cvr.Y(a(locationData.ann(), locationData.anm(), locationData.ano()));
        }
        this.cvs.a(this.cvr);
        this.cvs.notifyDataSetChanged();
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
                    mVar.iL(bVar2.ano());
                    arrayList.add(mVar);
                }
            }
        }
        if (bVar != null) {
            com.baidu.tieba.tbadkCore.location.m mVar2 = new com.baidu.tieba.tbadkCore.location.m();
            mVar2.setName(bVar.getName());
            mVar2.iL(bVar.ano());
            arrayList.add(0, mVar2);
        } else {
            com.baidu.tieba.tbadkCore.location.m mVar3 = new com.baidu.tieba.tbadkCore.location.m();
            mVar3.setName(str);
            mVar3.iL(str2);
            arrayList.add(0, mVar3);
        }
        return arrayList;
    }

    public void aqy() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(afX());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String afX() {
        if (this.bze != null) {
            return com.baidu.adp.lib.util.m.a(this.bze.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.i((View) this.cvu, u.btn_titlebar_finish);
        ba.c(this.cvv, u.icon_search_ba);
        ba.b(this.cvu, s.search_location_button_color, 3);
        if (i == 1) {
            this.bze.setTextColor(-6574132);
            this.bze.setHintTextColor(-11643034);
        } else {
            this.bze.setTextColor(-2300171);
            this.bze.setHintTextColor(-10195067);
        }
        this.cvs.notifyDataSetChanged();
    }
}

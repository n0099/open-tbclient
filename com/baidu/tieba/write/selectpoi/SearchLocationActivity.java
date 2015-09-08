package com.baidu.tieba.write.selectpoi;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.LocationSearchNetRequestMessage;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private EditText bQH;
    private com.baidu.tieba.tbadkCore.location.i dai;
    private h daj;
    private LinearLayout dak;
    private TextView dal;
    private ImageView dam;
    private InputMethodManager mInputManager;
    private BdListView mListView;
    private com.baidu.adp.framework.listener.a dan = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener HB = new b(this);
    private AdapterView.OnItemClickListener dao = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dan);
        SearchLocationActivityStatic.ayz();
        setContentView(i.g.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aIp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.dak = (LinearLayout) this.aIp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.search_location_edit_layout, (View.OnClickListener) null);
        this.dam = (ImageView) this.dak.findViewById(i.f.search_bar_icon);
        this.bQH = (EditText) this.dak.findViewById(i.f.search_location_editview);
        this.bQH.addTextChangedListener(new e(this));
        this.dal = (TextView) this.dak.findViewById(i.f.search_location_bt_search_s);
        this.dal.setEnabled(false);
        this.dal.setOnClickListener(new f(this));
        this.mListView = (BdListView) findViewById(i.f.search_position_list);
        this.daj = new h(this);
        this.mListView.setAdapter((ListAdapter) this.daj);
        this.mListView.setOnItemClickListener(this.dao);
        this.mListView.setOnScrollListener(this.HB);
    }

    public void initData() {
        this.dai = new com.baidu.tieba.tbadkCore.location.i();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.auQ().getLocationData();
        if (locationData != null) {
            this.dai.af(a(locationData.auN(), locationData.auM(), locationData.auO()));
        }
        this.daj.a(this.dai);
        this.daj.notifyDataSetChanged();
    }

    private ArrayList<i.a> a(List<a.C0075a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<i.a> arrayList = new ArrayList<>();
        a.C0075a c0075a = null;
        for (a.C0075a c0075a2 : list) {
            if (c0075a2 != null && !TextUtils.isEmpty(c0075a2.getName())) {
                if (TextUtils.equals(c0075a2.getName(), str)) {
                    c0075a = c0075a2;
                } else {
                    i.a aVar = new i.a();
                    aVar.setName(c0075a2.getName());
                    aVar.ld(c0075a2.auO());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0075a != null) {
            i.a aVar2 = new i.a();
            aVar2.setName(c0075a.getName());
            aVar2.ld(c0075a.auO());
            arrayList.add(0, aVar2);
        } else {
            i.a aVar3 = new i.a();
            aVar3.setName(str);
            aVar3.ld(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void ayy() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aog());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aog() {
        if (this.bQH != null) {
            return com.baidu.adp.lib.util.j.a(this.bQH.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.h((View) this.dal, i.e.btn_titlebar_finish);
        al.c(this.dam, i.e.icon_search_ba);
        al.b(this.dal, i.c.search_location_button_color, 3);
        if (i == 1) {
            this.bQH.setTextColor(-6574132);
            this.bQH.setHintTextColor(-11643034);
        } else {
            this.bQH.setTextColor(-2300171);
            this.bQH.setHintTextColor(-10195067);
        }
        this.daj.notifyDataSetChanged();
    }
}

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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.write.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.write.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private EditText cpr;
    private com.baidu.tieba.write.data.b dTU;
    private h dTV;
    private LinearLayout dTW;
    private TextView dTX;
    private ImageView dTY;
    private InputMethodManager mInputManager;
    private BdListView mListView;
    private com.baidu.adp.framework.listener.a dTZ = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener Ik = new b(this);
    private AdapterView.OnItemClickListener dUa = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dTZ);
        SearchLocationActivityStatic.aKu();
        setContentView(n.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aKK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.dTW = (LinearLayout) this.aKK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.h.search_location_edit_layout, (View.OnClickListener) null);
        this.dTY = (ImageView) this.dTW.findViewById(n.g.search_bar_icon);
        this.cpr = (EditText) this.dTW.findViewById(n.g.search_location_editview);
        this.cpr.addTextChangedListener(new e(this));
        this.dTX = (TextView) this.dTW.findViewById(n.g.search_location_bt_search_s);
        this.dTX.setEnabled(false);
        this.dTX.setOnClickListener(new f(this));
        this.mListView = (BdListView) findViewById(n.g.search_position_list);
        this.dTV = new h(this);
        this.mListView.setAdapter((ListAdapter) this.dTV);
        this.mListView.setOnItemClickListener(this.dUa);
        this.mListView.setOnScrollListener(this.Ik);
    }

    public void initData() {
        this.dTU = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aFW().getLocationData();
        if (locationData != null) {
            this.dTU.ap(a(locationData.aFT(), locationData.aFS(), locationData.aFU()));
        }
        this.dTV.a(this.dTU);
        this.dTV.notifyDataSetChanged();
    }

    private ArrayList<b.a> a(List<a.C0083a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<b.a> arrayList = new ArrayList<>();
        a.C0083a c0083a = null;
        for (a.C0083a c0083a2 : list) {
            if (c0083a2 != null && !TextUtils.isEmpty(c0083a2.getName())) {
                if (TextUtils.equals(c0083a2.getName(), str)) {
                    c0083a = c0083a2;
                } else {
                    b.a aVar = new b.a();
                    aVar.setName(c0083a2.getName());
                    aVar.no(c0083a2.aFU());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0083a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0083a.getName());
            aVar2.no(c0083a.aFU());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.no(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aKt() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(ayL());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String ayL() {
        if (this.cpr != null) {
            return com.baidu.adp.lib.util.j.a(this.cpr.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.i((View) this.dTX, n.f.s_navbar_button_bg);
        as.c(this.dTY, n.f.icon_search_ba);
        as.b(this.dTX, n.d.search_location_button_color, 3);
        if (i == 1) {
            this.cpr.setTextColor(-6574132);
            this.cpr.setHintTextColor(-11643034);
        } else {
            this.cpr.setTextColor(-2300171);
            this.cpr.setHintTextColor(-10195067);
        }
        this.dTV.notifyDataSetChanged();
    }
}

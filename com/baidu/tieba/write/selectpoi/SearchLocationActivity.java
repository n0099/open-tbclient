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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.write.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.write.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView Je;
    private EditText cKS;
    private com.baidu.tieba.write.data.b eIv;
    private h eIw;
    private LinearLayout eIx;
    private TextView eIy;
    private ImageView eIz;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eIA = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener IE = new b(this);
    private AdapterView.OnItemClickListener eIB = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eIA);
        SearchLocationActivityStatic.aZE();
        setContentView(t.h.search_location_layout);
        pU();
        initData();
    }

    public void pU() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aOK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.eIx = (LinearLayout) this.aOK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.search_location_edit_layout, (View.OnClickListener) null);
        this.eIz = (ImageView) this.eIx.findViewById(t.g.search_bar_icon);
        this.cKS = (EditText) this.eIx.findViewById(t.g.search_location_editview);
        this.cKS.addTextChangedListener(new e(this));
        this.eIy = (TextView) this.eIx.findViewById(t.g.search_location_bt_search_s);
        this.eIy.setEnabled(false);
        this.eIy.setOnClickListener(new f(this));
        this.Je = (BdListView) findViewById(t.g.search_position_list);
        this.eIw = new h(this);
        this.Je.setAdapter((ListAdapter) this.eIw);
        this.Je.setOnItemClickListener(this.eIB);
        this.Je.setOnScrollListener(this.IE);
    }

    public void initData() {
        this.eIv = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aUd().getLocationData();
        if (locationData != null) {
            this.eIv.ar(a(locationData.aUa(), locationData.aTZ(), locationData.aUb()));
        }
        this.eIw.a(this.eIv);
        this.eIw.notifyDataSetChanged();
    }

    private ArrayList<b.a> a(List<a.C0085a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<b.a> arrayList = new ArrayList<>();
        a.C0085a c0085a = null;
        for (a.C0085a c0085a2 : list) {
            if (c0085a2 != null && !TextUtils.isEmpty(c0085a2.getName())) {
                if (TextUtils.equals(c0085a2.getName(), str)) {
                    c0085a = c0085a2;
                } else {
                    b.a aVar = new b.a();
                    aVar.setName(c0085a2.getName());
                    aVar.oQ(c0085a2.aUb());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0085a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0085a.getName());
            aVar2.oQ(c0085a.aUb());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.oQ(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aZD() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aMD());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aMD() {
        if (this.cKS != null) {
            return com.baidu.adp.lib.util.j.a(this.cKS.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.k(this.eIy, t.f.s_navbar_button_bg);
        at.c(this.eIz, t.f.icon_search_ba);
        at.b(this.eIy, t.d.search_location_button_color, 3);
        if (i == 1) {
            this.cKS.setTextColor(-6574132);
            this.cKS.setHintTextColor(-11643034);
        } else {
            this.cKS.setTextColor(-2300171);
            this.cKS.setHintTextColor(-10195067);
        }
        this.eIw.notifyDataSetChanged();
    }
}

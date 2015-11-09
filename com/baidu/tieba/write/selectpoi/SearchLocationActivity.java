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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.write.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.write.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private EditText bVb;
    private com.baidu.tieba.write.data.b dnp;
    private h dnq;
    private LinearLayout dnr;
    private TextView dns;
    private ImageView dnt;
    private InputMethodManager mInputManager;
    private BdListView mListView;
    private com.baidu.adp.framework.listener.a dnu = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener HD = new b(this);
    private AdapterView.OnItemClickListener dnv = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dnu);
        SearchLocationActivityStatic.aCC();
        setContentView(i.g.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aGn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.dnr = (LinearLayout) this.aGn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.search_location_edit_layout, (View.OnClickListener) null);
        this.dnt = (ImageView) this.dnr.findViewById(i.f.search_bar_icon);
        this.bVb = (EditText) this.dnr.findViewById(i.f.search_location_editview);
        this.bVb.addTextChangedListener(new e(this));
        this.dns = (TextView) this.dnr.findViewById(i.f.search_location_bt_search_s);
        this.dns.setEnabled(false);
        this.dns.setOnClickListener(new f(this));
        this.mListView = (BdListView) findViewById(i.f.search_position_list);
        this.dnq = new h(this);
        this.mListView.setAdapter((ListAdapter) this.dnq);
        this.mListView.setOnItemClickListener(this.dnv);
        this.mListView.setOnScrollListener(this.HD);
    }

    public void initData() {
        this.dnp = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.ayr().getLocationData();
        if (locationData != null) {
            this.dnp.ai(a(locationData.ayo(), locationData.ayn(), locationData.ayp()));
        }
        this.dnq.a(this.dnp);
        this.dnq.notifyDataSetChanged();
    }

    private ArrayList<b.a> a(List<a.C0078a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<b.a> arrayList = new ArrayList<>();
        a.C0078a c0078a = null;
        for (a.C0078a c0078a2 : list) {
            if (c0078a2 != null && !TextUtils.isEmpty(c0078a2.getName())) {
                if (TextUtils.equals(c0078a2.getName(), str)) {
                    c0078a = c0078a2;
                } else {
                    b.a aVar = new b.a();
                    aVar.setName(c0078a2.getName());
                    aVar.mu(c0078a2.ayp());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0078a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0078a.getName());
            aVar2.mu(c0078a.ayp());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.mu(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aCB() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(arg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String arg() {
        if (this.bVb != null) {
            return com.baidu.adp.lib.util.j.a(this.bVb.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.i((View) this.dns, i.e.s_navbar_button_bg);
        an.c(this.dnt, i.e.icon_search_ba);
        an.b(this.dns, i.c.search_location_button_color, 3);
        if (i == 1) {
            this.bVb.setTextColor(-6574132);
            this.bVb.setHintTextColor(-11643034);
        } else {
            this.bVb.setTextColor(-2300171);
            this.bVb.setHintTextColor(-10195067);
        }
        this.dnq.notifyDataSetChanged();
    }
}

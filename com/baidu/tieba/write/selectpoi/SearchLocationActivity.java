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
    private EditText cln;
    private com.baidu.tieba.write.data.b dMv;
    private h dMw;
    private LinearLayout dMx;
    private TextView dMy;
    private ImageView dMz;
    private InputMethodManager mInputManager;
    private BdListView mListView;
    private com.baidu.adp.framework.listener.a dMA = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener HU = new b(this);
    private AdapterView.OnItemClickListener dMB = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dMA);
        SearchLocationActivityStatic.aHZ();
        setContentView(n.g.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aJm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.dMx = (LinearLayout) this.aJm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.g.search_location_edit_layout, (View.OnClickListener) null);
        this.dMz = (ImageView) this.dMx.findViewById(n.f.search_bar_icon);
        this.cln = (EditText) this.dMx.findViewById(n.f.search_location_editview);
        this.cln.addTextChangedListener(new e(this));
        this.dMy = (TextView) this.dMx.findViewById(n.f.search_location_bt_search_s);
        this.dMy.setEnabled(false);
        this.dMy.setOnClickListener(new f(this));
        this.mListView = (BdListView) findViewById(n.f.search_position_list);
        this.dMw = new h(this);
        this.mListView.setAdapter((ListAdapter) this.dMw);
        this.mListView.setOnItemClickListener(this.dMB);
        this.mListView.setOnScrollListener(this.HU);
    }

    public void initData() {
        this.dMv = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aDJ().getLocationData();
        if (locationData != null) {
            this.dMv.ap(a(locationData.aDG(), locationData.aDF(), locationData.aDH()));
        }
        this.dMw.a(this.dMv);
        this.dMw.notifyDataSetChanged();
    }

    private ArrayList<b.a> a(List<a.C0087a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<b.a> arrayList = new ArrayList<>();
        a.C0087a c0087a = null;
        for (a.C0087a c0087a2 : list) {
            if (c0087a2 != null && !TextUtils.isEmpty(c0087a2.getName())) {
                if (TextUtils.equals(c0087a2.getName(), str)) {
                    c0087a = c0087a2;
                } else {
                    b.a aVar = new b.a();
                    aVar.setName(c0087a2.getName());
                    aVar.np(c0087a2.aDH());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0087a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0087a.getName());
            aVar2.np(c0087a.aDH());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.np(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aHY() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(awE());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String awE() {
        if (this.cln != null) {
            return com.baidu.adp.lib.util.j.a(this.cln.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.i((View) this.dMy, n.e.s_navbar_button_bg);
        as.c(this.dMz, n.e.icon_search_ba);
        as.b(this.dMy, n.c.search_location_button_color, 3);
        if (i == 1) {
            this.cln.setTextColor(-6574132);
            this.cln.setHintTextColor(-11643034);
        } else {
            this.cln.setTextColor(-2300171);
            this.cln.setHintTextColor(-10195067);
        }
        this.dMw.notifyDataSetChanged();
    }
}

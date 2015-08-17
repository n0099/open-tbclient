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
    private EditText bQb;
    private TextView cRA;
    private ImageView cRB;
    private com.baidu.tieba.tbadkCore.location.i cRx;
    private h cRy;
    private LinearLayout cRz;
    private InputMethodManager mInputManager;
    private BdListView mListView;
    private com.baidu.adp.framework.listener.a cRC = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener HB = new b(this);
    private AdapterView.OnItemClickListener cRD = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cRC);
        SearchLocationActivityStatic.aug();
        setContentView(i.g.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aIc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.cRz = (LinearLayout) this.aIc.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.search_location_edit_layout, (View.OnClickListener) null);
        this.cRB = (ImageView) this.cRz.findViewById(i.f.search_bar_icon);
        this.bQb = (EditText) this.cRz.findViewById(i.f.search_location_editview);
        this.bQb.addTextChangedListener(new e(this));
        this.cRA = (TextView) this.cRz.findViewById(i.f.search_location_bt_search_s);
        this.cRA.setEnabled(false);
        this.cRA.setOnClickListener(new f(this));
        this.mListView = (BdListView) findViewById(i.f.search_position_list);
        this.cRy = new h(this);
        this.mListView.setAdapter((ListAdapter) this.cRy);
        this.mListView.setOnItemClickListener(this.cRD);
        this.mListView.setOnScrollListener(this.HB);
    }

    public void initData() {
        this.cRx = new com.baidu.tieba.tbadkCore.location.i();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aqC().getLocationData();
        if (locationData != null) {
            this.cRx.Z(a(locationData.aqz(), locationData.aqy(), locationData.aqA()));
        }
        this.cRy.a(this.cRx);
        this.cRy.notifyDataSetChanged();
    }

    private ArrayList<i.a> a(List<a.C0073a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<i.a> arrayList = new ArrayList<>();
        a.C0073a c0073a = null;
        for (a.C0073a c0073a2 : list) {
            if (c0073a2 != null && !TextUtils.isEmpty(c0073a2.getName())) {
                if (TextUtils.equals(c0073a2.getName(), str)) {
                    c0073a = c0073a2;
                } else {
                    i.a aVar = new i.a();
                    aVar.setName(c0073a2.getName());
                    aVar.ky(c0073a2.aqA());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0073a != null) {
            i.a aVar2 = new i.a();
            aVar2.setName(c0073a.getName());
            aVar2.ky(c0073a.aqA());
            arrayList.add(0, aVar2);
        } else {
            i.a aVar3 = new i.a();
            aVar3.setName(str);
            aVar3.ky(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void auf() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aka());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aka() {
        if (this.bQb != null) {
            return com.baidu.adp.lib.util.j.a(this.bQb.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i((View) this.cRA, i.e.btn_titlebar_finish);
        al.c(this.cRB, i.e.icon_search_ba);
        al.b(this.cRA, i.c.search_location_button_color, 3);
        if (i == 1) {
            this.bQb.setTextColor(-6574132);
            this.bQb.setHintTextColor(-11643034);
        } else {
            this.bQb.setTextColor(-2300171);
            this.bQb.setHintTextColor(-10195067);
        }
        this.cRy.notifyDataSetChanged();
    }
}

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
import com.baidu.tbadk.core.util.ar;
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
    private BdListView IY;
    private EditText cvX;
    private h eoA;
    private LinearLayout eoB;
    private TextView eoC;
    private ImageView eoD;
    private com.baidu.tieba.write.data.b eoz;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eoE = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener Ix = new b(this);
    private AdapterView.OnItemClickListener eoF = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eoE);
        SearchLocationActivityStatic.aTe();
        setContentView(t.h.search_location_layout);
        qD();
        initData();
    }

    public void qD() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aLP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.eoB = (LinearLayout) this.aLP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.search_location_edit_layout, (View.OnClickListener) null);
        this.eoD = (ImageView) this.eoB.findViewById(t.g.search_bar_icon);
        this.cvX = (EditText) this.eoB.findViewById(t.g.search_location_editview);
        this.cvX.addTextChangedListener(new e(this));
        this.eoC = (TextView) this.eoB.findViewById(t.g.search_location_bt_search_s);
        this.eoC.setEnabled(false);
        this.eoC.setOnClickListener(new f(this));
        this.IY = (BdListView) findViewById(t.g.search_position_list);
        this.eoA = new h(this);
        this.IY.setAdapter((ListAdapter) this.eoA);
        this.IY.setOnItemClickListener(this.eoF);
        this.IY.setOnScrollListener(this.Ix);
    }

    public void initData() {
        this.eoz = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aNb().getLocationData();
        if (locationData != null) {
            this.eoz.aq(a(locationData.aMY(), locationData.aMX(), locationData.aMZ()));
        }
        this.eoA.a(this.eoz);
        this.eoA.notifyDataSetChanged();
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
                    aVar.nD(c0087a2.aMZ());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0087a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0087a.getName());
            aVar2.nD(c0087a.aMZ());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.nD(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aTd() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aFT());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aFT() {
        if (this.cvX != null) {
            return com.baidu.adp.lib.util.j.a(this.cvX.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ar.k(this.eoC, t.f.s_navbar_button_bg);
        ar.c(this.eoD, t.f.icon_search_ba);
        ar.b(this.eoC, t.d.search_location_button_color, 3);
        if (i == 1) {
            this.cvX.setTextColor(-6574132);
            this.cvX.setHintTextColor(-11643034);
        } else {
            this.cvX.setTextColor(-2300171);
            this.cvX.setHintTextColor(-10195067);
        }
        this.eoA.notifyDataSetChanged();
    }
}

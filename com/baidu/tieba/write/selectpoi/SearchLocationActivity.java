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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.u;
import com.baidu.tieba.write.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.write.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private EditText bmv;
    private com.baidu.tieba.write.data.b fEq;
    private h fEr;
    private LinearLayout fEs;
    private TextView fEt;
    private ImageView fEu;
    private InputMethodManager mInputManager;
    private BdListView zt;
    private com.baidu.adp.framework.listener.a fmP = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener yV = new b(this);
    private AdapterView.OnItemClickListener fEv = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fmP);
        SearchLocationActivityStatic.bgP();
        setContentView(u.h.search_location_layout);
        nl();
        initData();
    }

    public void nl() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aOs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.fEs = (LinearLayout) this.aOs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, u.h.search_location_edit_layout, (View.OnClickListener) null);
        this.fEu = (ImageView) this.fEs.findViewById(u.g.search_bar_icon);
        this.bmv = (EditText) this.fEs.findViewById(u.g.search_location_editview);
        this.bmv.addTextChangedListener(new e(this));
        this.fEt = (TextView) this.fEs.findViewById(u.g.search_location_bt_search_s);
        this.fEt.setEnabled(false);
        this.fEt.setOnClickListener(new f(this));
        this.zt = (BdListView) findViewById(u.g.search_position_list);
        this.fEr = new h(this);
        this.zt.setAdapter((ListAdapter) this.fEr);
        this.zt.setOnItemClickListener(this.fEv);
        this.zt.setOnScrollListener(this.yV);
    }

    public void initData() {
        this.fEq = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bcT().getLocationData();
        if (locationData != null) {
            this.fEq.setSearchLocationDataList(a(locationData.getPoi_info(), locationData.getFormatted_address(), locationData.getSn()));
        }
        this.fEr.a(this.fEq);
        this.fEr.notifyDataSetChanged();
    }

    private ArrayList<b.a> a(List<a.C0079a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<b.a> arrayList = new ArrayList<>();
        a.C0079a c0079a = null;
        for (a.C0079a c0079a2 : list) {
            if (c0079a2 != null && !TextUtils.isEmpty(c0079a2.getName())) {
                if (TextUtils.equals(c0079a2.getName(), str)) {
                    c0079a = c0079a2;
                } else {
                    b.a aVar = new b.a();
                    aVar.setName(c0079a2.getName());
                    aVar.setScreatString(c0079a2.getSn());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0079a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0079a.getName());
            aVar2.setScreatString(c0079a.getSn());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.setScreatString(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void bgu() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aUV());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aUV() {
        if (this.bmv != null) {
            return com.baidu.adp.lib.util.j.a(this.bmv.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.k(this.fEt, u.f.s_navbar_button_bg);
        av.c(this.fEu, u.f.icon_search_ba);
        av.c(this.fEt, u.d.search_location_button_color, 3);
        if (i == 1) {
            this.bmv.setTextColor(getResources().getColor(u.d.cp_cont_b_1));
            this.bmv.setHintTextColor(getResources().getColor(u.d.cp_cont_e_1));
        } else {
            this.bmv.setTextColor(getResources().getColor(u.d.cp_cont_b));
            this.bmv.setHintTextColor(getResources().getColor(u.d.cp_cont_e));
        }
        this.fEr.notifyDataSetChanged();
    }
}

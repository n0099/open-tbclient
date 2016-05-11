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
    private EditText cLO;
    private com.baidu.tieba.write.data.b eZn;
    private h eZo;
    private LinearLayout eZp;
    private TextView eZq;
    private ImageView eZr;
    private InputMethodManager mInputManager;
    private BdListView zu;
    private com.baidu.adp.framework.listener.a eHV = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener yW = new b(this);
    private AdapterView.OnItemClickListener eZs = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eHV);
        SearchLocationActivityStatic.aYy();
        setContentView(t.h.search_location_layout);
        nq();
        initData();
    }

    public void nq() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aKU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.eZp = (LinearLayout) this.aKU.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.search_location_edit_layout, (View.OnClickListener) null);
        this.eZr = (ImageView) this.eZp.findViewById(t.g.search_bar_icon);
        this.cLO = (EditText) this.eZp.findViewById(t.g.search_location_editview);
        this.cLO.addTextChangedListener(new e(this));
        this.eZq = (TextView) this.eZp.findViewById(t.g.search_location_bt_search_s);
        this.eZq.setEnabled(false);
        this.eZq.setOnClickListener(new f(this));
        this.zu = (BdListView) findViewById(t.g.search_position_list);
        this.eZo = new h(this);
        this.zu.setAdapter((ListAdapter) this.eZo);
        this.zu.setOnItemClickListener(this.eZs);
        this.zu.setOnScrollListener(this.yW);
    }

    public void initData() {
        this.eZn = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aUz().getLocationData();
        if (locationData != null) {
            this.eZn.setSearchLocationDataList(a(locationData.getPoi_info(), locationData.getFormatted_address(), locationData.getSn()));
        }
        this.eZo.a(this.eZn);
        this.eZo.notifyDataSetChanged();
    }

    private ArrayList<b.a> a(List<a.C0077a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<b.a> arrayList = new ArrayList<>();
        a.C0077a c0077a = null;
        for (a.C0077a c0077a2 : list) {
            if (c0077a2 != null && !TextUtils.isEmpty(c0077a2.getName())) {
                if (TextUtils.equals(c0077a2.getName(), str)) {
                    c0077a = c0077a2;
                } else {
                    b.a aVar = new b.a();
                    aVar.setName(c0077a2.getName());
                    aVar.setScreatString(c0077a2.getSn());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0077a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0077a.getName());
            aVar2.setScreatString(c0077a.getSn());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.setScreatString(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aYd() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aMN());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aMN() {
        if (this.cLO != null) {
            return com.baidu.adp.lib.util.j.a(this.cLO.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.k(this.eZq, t.f.s_navbar_button_bg);
        at.c(this.eZr, t.f.icon_search_ba);
        at.c(this.eZq, t.d.search_location_button_color, 3);
        if (i == 1) {
            this.cLO.setTextColor(getResources().getColor(t.d.cp_cont_b_1));
            this.cLO.setHintTextColor(getResources().getColor(t.d.cp_cont_e_1));
        } else {
            this.cLO.setTextColor(getResources().getColor(t.d.cp_cont_b));
            this.cLO.setHintTextColor(getResources().getColor(t.d.cp_cont_e));
        }
        this.eZo.notifyDataSetChanged();
    }
}

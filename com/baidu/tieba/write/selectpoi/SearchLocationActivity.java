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
import com.baidu.tbadk.core.util.am;
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
    private EditText bUp;
    private com.baidu.tieba.write.data.b dlh;
    private h dli;
    private LinearLayout dlj;
    private TextView dlk;
    private ImageView dll;
    private InputMethodManager mInputManager;
    private BdListView mListView;
    private com.baidu.adp.framework.listener.a dlm = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener HB = new b(this);
    private AdapterView.OnItemClickListener dln = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dlm);
        SearchLocationActivityStatic.aBG();
        setContentView(i.g.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aHi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.dlj = (LinearLayout) this.aHi.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.search_location_edit_layout, (View.OnClickListener) null);
        this.dll = (ImageView) this.dlj.findViewById(i.f.search_bar_icon);
        this.bUp = (EditText) this.dlj.findViewById(i.f.search_location_editview);
        this.bUp.addTextChangedListener(new e(this));
        this.dlk = (TextView) this.dlj.findViewById(i.f.search_location_bt_search_s);
        this.dlk.setEnabled(false);
        this.dlk.setOnClickListener(new f(this));
        this.mListView = (BdListView) findViewById(i.f.search_position_list);
        this.dli = new h(this);
        this.mListView.setAdapter((ListAdapter) this.dli);
        this.mListView.setOnItemClickListener(this.dln);
        this.mListView.setOnScrollListener(this.HB);
    }

    public void initData() {
        this.dlh = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.axc().getLocationData();
        if (locationData != null) {
            this.dlh.ai(a(locationData.awZ(), locationData.awY(), locationData.axa()));
        }
        this.dli.a(this.dlh);
        this.dli.notifyDataSetChanged();
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
                    aVar.mn(c0078a2.axa());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0078a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0078a.getName());
            aVar2.mn(c0078a.axa());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.mn(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aBF() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aqy());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aqy() {
        if (this.bUp != null) {
            return com.baidu.adp.lib.util.j.a(this.bUp.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i((View) this.dlk, i.e.s_navbar_button_bg);
        am.c(this.dll, i.e.icon_search_ba);
        am.b(this.dlk, i.c.search_location_button_color, 3);
        if (i == 1) {
            this.bUp.setTextColor(-6574132);
            this.bUp.setHintTextColor(-11643034);
        } else {
            this.bUp.setTextColor(-2300171);
            this.bUp.setHintTextColor(-10195067);
        }
        this.dli.notifyDataSetChanged();
    }
}

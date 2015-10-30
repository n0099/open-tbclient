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
    private EditText bUA;
    private com.baidu.tieba.write.data.b dlH;
    private h dlI;
    private LinearLayout dlJ;
    private TextView dlK;
    private ImageView dlL;
    private InputMethodManager mInputManager;
    private BdListView mListView;
    private com.baidu.adp.framework.listener.a dlM = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    private final AbsListView.OnScrollListener HC = new b(this);
    private AdapterView.OnItemClickListener dlN = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dlM);
        SearchLocationActivityStatic.aBM();
        setContentView(i.g.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aHt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.dlJ = (LinearLayout) this.aHt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.search_location_edit_layout, (View.OnClickListener) null);
        this.dlL = (ImageView) this.dlJ.findViewById(i.f.search_bar_icon);
        this.bUA = (EditText) this.dlJ.findViewById(i.f.search_location_editview);
        this.bUA.addTextChangedListener(new e(this));
        this.dlK = (TextView) this.dlJ.findViewById(i.f.search_location_bt_search_s);
        this.dlK.setEnabled(false);
        this.dlK.setOnClickListener(new f(this));
        this.mListView = (BdListView) findViewById(i.f.search_position_list);
        this.dlI = new h(this);
        this.mListView.setAdapter((ListAdapter) this.dlI);
        this.mListView.setOnItemClickListener(this.dlN);
        this.mListView.setOnScrollListener(this.HC);
    }

    public void initData() {
        this.dlH = new com.baidu.tieba.write.data.b();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.axi().getLocationData();
        if (locationData != null) {
            this.dlH.ai(a(locationData.axf(), locationData.axe(), locationData.axg()));
        }
        this.dlI.a(this.dlH);
        this.dlI.notifyDataSetChanged();
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
                    aVar.mq(c0078a2.axg());
                    arrayList.add(aVar);
                }
            }
        }
        if (c0078a != null) {
            b.a aVar2 = new b.a();
            aVar2.setName(c0078a.getName());
            aVar2.mq(c0078a.axg());
            arrayList.add(0, aVar2);
        } else {
            b.a aVar3 = new b.a();
            aVar3.setName(str);
            aVar3.mq(str2);
            arrayList.add(0, aVar3);
        }
        return arrayList;
    }

    public void aBL() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(aqA());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String aqA() {
        if (this.bUA != null) {
            return com.baidu.adp.lib.util.j.a(this.bUA.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.i((View) this.dlK, i.e.s_navbar_button_bg);
        an.c(this.dlL, i.e.icon_search_ba);
        an.b(this.dlK, i.c.search_location_button_color, 3);
        if (i == 1) {
            this.bUA.setTextColor(-6574132);
            this.bUA.setHintTextColor(-11643034);
        } else {
            this.bUA.setTextColor(-2300171);
            this.bUA.setHintTextColor(-10195067);
        }
        this.dlI.notifyDataSetChanged();
    }
}

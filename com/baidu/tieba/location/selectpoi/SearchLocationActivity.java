package com.baidu.tieba.location.selectpoi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.location.data.a;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView Pj;
    private EditText eIa;
    private a gMA;
    private LinearLayout gMB;
    private TextView gMC;
    private ImageView gMD;
    private com.baidu.tieba.location.data.a gMz;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a gME = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.gMz = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.gMz = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.gMA.a(SearchLocationActivity.this.gMz);
                    SearchLocationActivity.this.gMA.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.eIa);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener gMF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.gMA != null && SearchLocationActivity.this.gMA.bBt()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0334a c0334a = (a.C0334a) SearchLocationActivity.this.gMA.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0334a.getName(), c0334a.getName(), c0334a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gME);
        SearchLocationActivityStatic.bBs();
        setContentView(d.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cPK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.eIa.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.eIa);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.gMB = (LinearLayout) this.cPK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.search_location_edit_layout, (View.OnClickListener) null);
        this.gMD = (ImageView) this.gMB.findViewById(d.g.search_bar_icon);
        this.eIa = (EditText) this.gMB.findViewById(d.g.search_location_editview);
        this.eIa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.gMC.setEnabled(false);
                } else {
                    SearchLocationActivity.this.gMC.setEnabled(true);
                }
            }
        });
        this.gMC = (TextView) this.gMB.findViewById(d.g.search_location_bt_search_s);
        this.gMC.setEnabled(false);
        this.gMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.lo()) {
                    SearchLocationActivity.this.showToast(d.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.bBr();
                }
            }
        });
        this.Pj = (BdListView) findViewById(d.g.search_position_list);
        this.gMA = new a(this);
        this.Pj.setAdapter((ListAdapter) this.gMA);
        this.Pj.setOnItemClickListener(this.gMF);
        this.Pj.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.gMz = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceZ().getLocationData();
        if (locationData != null) {
            this.gMz.ae(b(locationData.ceX(), locationData.ceW(), locationData.ceY()));
        }
        this.gMA.a(this.gMz);
        this.gMA.notifyDataSetChanged();
    }

    private ArrayList<a.C0334a> b(List<a.C0391a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0334a> arrayList = new ArrayList<>();
        a.C0391a c0391a = null;
        for (a.C0391a c0391a2 : list) {
            if (c0391a2 != null && !TextUtils.isEmpty(c0391a2.getName())) {
                if (TextUtils.equals(c0391a2.getName(), str)) {
                    c0391a = c0391a2;
                } else {
                    a.C0334a c0334a = new a.C0334a();
                    c0334a.setName(c0391a2.getName());
                    c0334a.yh(c0391a2.ceY());
                    arrayList.add(c0334a);
                }
            }
        }
        if (c0391a != null) {
            a.C0334a c0334a2 = new a.C0334a();
            c0334a2.setName(c0391a.getName());
            c0334a2.yh(c0391a.ceY());
            arrayList.add(0, c0334a2);
        } else {
            a.C0334a c0334a3 = new a.C0334a();
            c0334a3.setName(str);
            c0334a3.yh(str2);
            arrayList.add(0, c0334a3);
        }
        return arrayList;
    }

    public void bBr() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.eIa != null) {
            return k.a(this.eIa.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.k(this.gMC, d.f.s_navbar_button_bg);
        al.c(this.gMD, d.f.icon_search_ba);
        al.d(this.gMC, d.C0277d.search_location_button_color, 3);
        if (i == 1) {
            this.eIa.setTextColor(getResources().getColor(d.C0277d.cp_cont_b_1));
            this.eIa.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e_1));
        } else {
            this.eIa.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
            this.eIa.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        }
        this.gMA.notifyDataSetChanged();
    }
}

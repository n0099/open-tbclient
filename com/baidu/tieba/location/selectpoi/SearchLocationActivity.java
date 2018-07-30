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
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes3.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView LO;
    private EditText cVJ;
    private a eVA;
    private LinearLayout eVB;
    private TextView eVC;
    private ImageView eVD;
    private com.baidu.tieba.location.data.a eVz;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eVE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.eVz = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.eVz = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.eVA.a(SearchLocationActivity.this.eVz);
                    SearchLocationActivity.this.eVA.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cVJ);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener eVF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.eVA != null && SearchLocationActivity.this.eVA.aSQ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0193a c0193a = (a.C0193a) SearchLocationActivity.this.eVA.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0193a.getName(), c0193a.getName(), c0193a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eVE);
        SearchLocationActivityStatic.aSP();
        setContentView(d.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bpN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.cVJ.hasFocus()) {
                    l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cVJ);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.eVB = (LinearLayout) this.bpN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.search_location_edit_layout, (View.OnClickListener) null);
        this.eVD = (ImageView) this.eVB.findViewById(d.g.search_bar_icon);
        this.cVJ = (EditText) this.eVB.findViewById(d.g.search_location_editview);
        this.cVJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.eVC.setEnabled(false);
                } else {
                    SearchLocationActivity.this.eVC.setEnabled(true);
                }
            }
        });
        this.eVC = (TextView) this.eVB.findViewById(d.g.search_location_bt_search_s);
        this.eVC.setEnabled(false);
        this.eVC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.jV()) {
                    SearchLocationActivity.this.showToast(d.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aSO();
                }
            }
        });
        this.LO = (BdListView) findViewById(d.g.search_position_list);
        this.eVA = new a(this);
        this.LO.setAdapter((ListAdapter) this.eVA);
        this.LO.setOnItemClickListener(this.eVF);
        this.LO.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.eVz = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwN().getLocationData();
        if (locationData != null) {
            this.eVz.ab(a(locationData.bwK(), locationData.bwJ(), locationData.bwL()));
        }
        this.eVA.a(this.eVz);
        this.eVA.notifyDataSetChanged();
    }

    private ArrayList<a.C0193a> a(List<a.C0238a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0193a> arrayList = new ArrayList<>();
        a.C0238a c0238a = null;
        for (a.C0238a c0238a2 : list) {
            if (c0238a2 != null && !TextUtils.isEmpty(c0238a2.getName())) {
                if (TextUtils.equals(c0238a2.getName(), str)) {
                    c0238a = c0238a2;
                } else {
                    a.C0193a c0193a = new a.C0193a();
                    c0193a.setName(c0238a2.getName());
                    c0193a.pz(c0238a2.bwL());
                    arrayList.add(c0193a);
                }
            }
        }
        if (c0238a != null) {
            a.C0193a c0193a2 = new a.C0193a();
            c0193a2.setName(c0238a.getName());
            c0193a2.pz(c0238a.bwL());
            arrayList.add(0, c0193a2);
        } else {
            a.C0193a c0193a3 = new a.C0193a();
            c0193a3.setName(str);
            c0193a3.pz(str2);
            arrayList.add(0, c0193a3);
        }
        return arrayList;
    }

    public void aSO() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.cVJ != null) {
            return k.a(this.cVJ.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i(this.eVC, d.f.s_navbar_button_bg);
        am.c(this.eVD, d.f.icon_search_ba);
        am.c(this.eVC, d.C0140d.search_location_button_color, 3);
        if (i == 1) {
            this.cVJ.setTextColor(getResources().getColor(d.C0140d.cp_cont_b_1));
            this.cVJ.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e_1));
        } else {
            this.cVJ.setTextColor(getResources().getColor(d.C0140d.cp_cont_b));
            this.cVJ.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        }
        this.eVA.notifyDataSetChanged();
    }
}

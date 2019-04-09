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
    private EditText eHN;
    private com.baidu.tieba.location.data.a gMn;
    private a gMo;
    private LinearLayout gMp;
    private TextView gMq;
    private ImageView gMr;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a gMs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.gMn = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.gMn = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.gMo.a(SearchLocationActivity.this.gMn);
                    SearchLocationActivity.this.gMo.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.eHN);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener gMt = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.gMo != null && SearchLocationActivity.this.gMo.bBq()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0334a c0334a = (a.C0334a) SearchLocationActivity.this.gMo.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0334a.getName(), c0334a.getName(), c0334a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gMs);
        SearchLocationActivityStatic.bBp();
        setContentView(d.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.eHN.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.eHN);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.gMp = (LinearLayout) this.cPN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.search_location_edit_layout, (View.OnClickListener) null);
        this.gMr = (ImageView) this.gMp.findViewById(d.g.search_bar_icon);
        this.eHN = (EditText) this.gMp.findViewById(d.g.search_location_editview);
        this.eHN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.gMq.setEnabled(false);
                } else {
                    SearchLocationActivity.this.gMq.setEnabled(true);
                }
            }
        });
        this.gMq = (TextView) this.gMp.findViewById(d.g.search_location_bt_search_s);
        this.gMq.setEnabled(false);
        this.gMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.lo()) {
                    SearchLocationActivity.this.showToast(d.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.bBo();
                }
            }
        });
        this.Pj = (BdListView) findViewById(d.g.search_position_list);
        this.gMo = new a(this);
        this.Pj.setAdapter((ListAdapter) this.gMo);
        this.Pj.setOnItemClickListener(this.gMt);
        this.Pj.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.gMn = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceV().getLocationData();
        if (locationData != null) {
            this.gMn.ae(b(locationData.ceT(), locationData.ceS(), locationData.ceU()));
        }
        this.gMo.a(this.gMn);
        this.gMo.notifyDataSetChanged();
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
                    c0334a.yg(c0391a2.ceU());
                    arrayList.add(c0334a);
                }
            }
        }
        if (c0391a != null) {
            a.C0334a c0334a2 = new a.C0334a();
            c0334a2.setName(c0391a.getName());
            c0334a2.yg(c0391a.ceU());
            arrayList.add(0, c0334a2);
        } else {
            a.C0334a c0334a3 = new a.C0334a();
            c0334a3.setName(str);
            c0334a3.yg(str2);
            arrayList.add(0, c0334a3);
        }
        return arrayList;
    }

    public void bBo() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.eHN != null) {
            return k.a(this.eHN.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.k(this.gMq, d.f.s_navbar_button_bg);
        al.c(this.gMr, d.f.icon_search_ba);
        al.d(this.gMq, d.C0277d.search_location_button_color, 3);
        if (i == 1) {
            this.eHN.setTextColor(getResources().getColor(d.C0277d.cp_cont_b_1));
            this.eHN.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e_1));
        } else {
            this.eHN.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
            this.eHN.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        }
        this.gMo.notifyDataSetChanged();
    }
}

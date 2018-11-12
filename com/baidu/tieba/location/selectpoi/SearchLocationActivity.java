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
import com.baidu.tieba.e;
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
    private BdListView OF;
    private EditText dkN;
    private com.baidu.tieba.location.data.a flR;
    private a flS;
    private LinearLayout flT;
    private TextView flU;
    private ImageView flV;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a flW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.flR = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.flR = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.flS.a(SearchLocationActivity.this.flR);
                    SearchLocationActivity.this.flS.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dkN);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener flX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.flS != null && SearchLocationActivity.this.flS.aXL()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0255a c0255a = (a.C0255a) SearchLocationActivity.this.flS.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0255a.getName(), c0255a.getName(), c0255a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.flW);
        SearchLocationActivityStatic.aXK();
        setContentView(e.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bAs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.dkN.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dkN);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.flT = (LinearLayout) this.bAs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.search_location_edit_layout, (View.OnClickListener) null);
        this.flV = (ImageView) this.flT.findViewById(e.g.search_bar_icon);
        this.dkN = (EditText) this.flT.findViewById(e.g.search_location_editview);
        this.dkN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.flU.setEnabled(false);
                } else {
                    SearchLocationActivity.this.flU.setEnabled(true);
                }
            }
        });
        this.flU = (TextView) this.flT.findViewById(e.g.search_location_bt_search_s);
        this.flU.setEnabled(false);
        this.flU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.lm()) {
                    SearchLocationActivity.this.showToast(e.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aXJ();
                }
            }
        });
        this.OF = (BdListView) findViewById(e.g.search_position_list);
        this.flS = new a(this);
        this.OF.setAdapter((ListAdapter) this.flS);
        this.OF.setOnItemClickListener(this.flX);
        this.OF.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.flR = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCc().getLocationData();
        if (locationData != null) {
            this.flR.aa(b(locationData.bCa(), locationData.bBZ(), locationData.bCb()));
        }
        this.flS.a(this.flR);
        this.flS.notifyDataSetChanged();
    }

    private ArrayList<a.C0255a> b(List<a.C0307a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0255a> arrayList = new ArrayList<>();
        a.C0307a c0307a = null;
        for (a.C0307a c0307a2 : list) {
            if (c0307a2 != null && !TextUtils.isEmpty(c0307a2.getName())) {
                if (TextUtils.equals(c0307a2.getName(), str)) {
                    c0307a = c0307a2;
                } else {
                    a.C0255a c0255a = new a.C0255a();
                    c0255a.setName(c0307a2.getName());
                    c0255a.qJ(c0307a2.bCb());
                    arrayList.add(c0255a);
                }
            }
        }
        if (c0307a != null) {
            a.C0255a c0255a2 = new a.C0255a();
            c0255a2.setName(c0307a.getName());
            c0255a2.qJ(c0307a.bCb());
            arrayList.add(0, c0255a2);
        } else {
            a.C0255a c0255a3 = new a.C0255a();
            c0255a3.setName(str);
            c0255a3.qJ(str2);
            arrayList.add(0, c0255a3);
        }
        return arrayList;
    }

    public void aXJ() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.dkN != null) {
            return k.a(this.dkN.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.flU, e.f.s_navbar_button_bg);
        al.c(this.flV, e.f.icon_search_ba);
        al.c(this.flU, e.d.search_location_button_color, 3);
        if (i == 1) {
            this.dkN.setTextColor(getResources().getColor(e.d.cp_cont_b_1));
            this.dkN.setHintTextColor(getResources().getColor(e.d.cp_cont_e_1));
        } else {
            this.dkN.setTextColor(getResources().getColor(e.d.cp_cont_b));
            this.dkN.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        }
        this.flS.notifyDataSetChanged();
    }
}

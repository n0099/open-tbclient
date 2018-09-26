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
    private BdListView Op;
    private EditText dby;
    private com.baidu.tieba.location.data.a fcP;
    private a fcQ;
    private LinearLayout fcR;
    private TextView fcS;
    private ImageView fcT;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a fcU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.fcP = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.fcP = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.fcQ.a(SearchLocationActivity.this.fcP);
                    SearchLocationActivity.this.fcQ.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dby);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener fcV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.fcQ != null && SearchLocationActivity.this.fcQ.aVb()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0195a c0195a = (a.C0195a) SearchLocationActivity.this.fcQ.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0195a.getName(), c0195a.getName(), c0195a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fcU);
        SearchLocationActivityStatic.aVa();
        setContentView(e.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bvF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.dby.hasFocus()) {
                    l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dby);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.fcR = (LinearLayout) this.bvF.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.search_location_edit_layout, (View.OnClickListener) null);
        this.fcT = (ImageView) this.fcR.findViewById(e.g.search_bar_icon);
        this.dby = (EditText) this.fcR.findViewById(e.g.search_location_editview);
        this.dby.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.fcS.setEnabled(false);
                } else {
                    SearchLocationActivity.this.fcS.setEnabled(true);
                }
            }
        });
        this.fcS = (TextView) this.fcR.findViewById(e.g.search_location_bt_search_s);
        this.fcS.setEnabled(false);
        this.fcS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.lb()) {
                    SearchLocationActivity.this.showToast(e.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aUZ();
                }
            }
        });
        this.Op = (BdListView) findViewById(e.g.search_position_list);
        this.fcQ = new a(this);
        this.Op.setAdapter((ListAdapter) this.fcQ);
        this.Op.setOnItemClickListener(this.fcV);
        this.Op.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.fcP = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bzs().getLocationData();
        if (locationData != null) {
            this.fcP.ab(b(locationData.bzp(), locationData.bzo(), locationData.bzq()));
        }
        this.fcQ.a(this.fcP);
        this.fcQ.notifyDataSetChanged();
    }

    private ArrayList<a.C0195a> b(List<a.C0244a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0195a> arrayList = new ArrayList<>();
        a.C0244a c0244a = null;
        for (a.C0244a c0244a2 : list) {
            if (c0244a2 != null && !TextUtils.isEmpty(c0244a2.getName())) {
                if (TextUtils.equals(c0244a2.getName(), str)) {
                    c0244a = c0244a2;
                } else {
                    a.C0195a c0195a = new a.C0195a();
                    c0195a.setName(c0244a2.getName());
                    c0195a.qg(c0244a2.bzq());
                    arrayList.add(c0195a);
                }
            }
        }
        if (c0244a != null) {
            a.C0195a c0195a2 = new a.C0195a();
            c0195a2.setName(c0244a.getName());
            c0195a2.qg(c0244a.bzq());
            arrayList.add(0, c0195a2);
        } else {
            a.C0195a c0195a3 = new a.C0195a();
            c0195a3.setName(str);
            c0195a3.qg(str2);
            arrayList.add(0, c0195a3);
        }
        return arrayList;
    }

    public void aUZ() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.dby != null) {
            return k.a(this.dby.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.fcS, e.f.s_navbar_button_bg);
        al.c(this.fcT, e.f.icon_search_ba);
        al.c(this.fcS, e.d.search_location_button_color, 3);
        if (i == 1) {
            this.dby.setTextColor(getResources().getColor(e.d.cp_cont_b_1));
            this.dby.setHintTextColor(getResources().getColor(e.d.cp_cont_e_1));
        } else {
            this.dby.setTextColor(getResources().getColor(e.d.cp_cont_b));
            this.dby.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        }
        this.fcQ.notifyDataSetChanged();
    }
}

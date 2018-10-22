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
    private BdListView OE;
    private EditText djI;
    private a fkA;
    private LinearLayout fkB;
    private TextView fkC;
    private ImageView fkD;
    private com.baidu.tieba.location.data.a fkz;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a fkE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.fkz = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.fkz = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.fkA.a(SearchLocationActivity.this.fkz);
                    SearchLocationActivity.this.fkA.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.djI);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener fkF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.fkA != null && SearchLocationActivity.this.fkA.aYo()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0229a c0229a = (a.C0229a) SearchLocationActivity.this.fkA.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0229a.getName(), c0229a.getName(), c0229a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fkE);
        SearchLocationActivityStatic.aYn();
        setContentView(e.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bzH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.djI.hasFocus()) {
                    l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.djI);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.fkB = (LinearLayout) this.bzH.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.search_location_edit_layout, (View.OnClickListener) null);
        this.fkD = (ImageView) this.fkB.findViewById(e.g.search_bar_icon);
        this.djI = (EditText) this.fkB.findViewById(e.g.search_location_editview);
        this.djI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.fkC.setEnabled(false);
                } else {
                    SearchLocationActivity.this.fkC.setEnabled(true);
                }
            }
        });
        this.fkC = (TextView) this.fkB.findViewById(e.g.search_location_bt_search_s);
        this.fkC.setEnabled(false);
        this.fkC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.lo()) {
                    SearchLocationActivity.this.showToast(e.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aYm();
                }
            }
        });
        this.OE = (BdListView) findViewById(e.g.search_position_list);
        this.fkA = new a(this);
        this.OE.setAdapter((ListAdapter) this.fkA);
        this.OE.setOnItemClickListener(this.fkF);
        this.OE.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.fkz = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCH().getLocationData();
        if (locationData != null) {
            this.fkz.ab(b(locationData.bCE(), locationData.bCD(), locationData.bCF()));
        }
        this.fkA.a(this.fkz);
        this.fkA.notifyDataSetChanged();
    }

    private ArrayList<a.C0229a> b(List<a.C0279a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0229a> arrayList = new ArrayList<>();
        a.C0279a c0279a = null;
        for (a.C0279a c0279a2 : list) {
            if (c0279a2 != null && !TextUtils.isEmpty(c0279a2.getName())) {
                if (TextUtils.equals(c0279a2.getName(), str)) {
                    c0279a = c0279a2;
                } else {
                    a.C0229a c0229a = new a.C0229a();
                    c0229a.setName(c0279a2.getName());
                    c0229a.qI(c0279a2.bCF());
                    arrayList.add(c0229a);
                }
            }
        }
        if (c0279a != null) {
            a.C0229a c0229a2 = new a.C0229a();
            c0229a2.setName(c0279a.getName());
            c0229a2.qI(c0279a.bCF());
            arrayList.add(0, c0229a2);
        } else {
            a.C0229a c0229a3 = new a.C0229a();
            c0229a3.setName(str);
            c0229a3.qI(str2);
            arrayList.add(0, c0229a3);
        }
        return arrayList;
    }

    public void aYm() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.djI != null) {
            return k.a(this.djI.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.fkC, e.f.s_navbar_button_bg);
        al.c(this.fkD, e.f.icon_search_ba);
        al.c(this.fkC, e.d.search_location_button_color, 3);
        if (i == 1) {
            this.djI.setTextColor(getResources().getColor(e.d.cp_cont_b_1));
            this.djI.setHintTextColor(getResources().getColor(e.d.cp_cont_e_1));
        } else {
            this.djI.setTextColor(getResources().getColor(e.d.cp_cont_b));
            this.djI.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        }
        this.fkA.notifyDataSetChanged();
    }
}

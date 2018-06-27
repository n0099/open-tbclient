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
    private BdListView LS;
    private EditText cSW;
    private com.baidu.tieba.location.data.a eRE;
    private a eRF;
    private LinearLayout eRG;
    private TextView eRH;
    private ImageView eRI;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eRJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.eRE = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.eRE = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.eRF.a(SearchLocationActivity.this.eRE);
                    SearchLocationActivity.this.eRF.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cSW);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener eRK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.eRF != null && SearchLocationActivity.this.eRF.aRO()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0194a c0194a = (a.C0194a) SearchLocationActivity.this.eRF.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0194a.getName(), c0194a.getName(), c0194a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eRJ);
        SearchLocationActivityStatic.aRN();
        setContentView(d.i.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bpg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.cSW.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cSW);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.eRG = (LinearLayout) this.bpg.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.search_location_edit_layout, (View.OnClickListener) null);
        this.eRI = (ImageView) this.eRG.findViewById(d.g.search_bar_icon);
        this.cSW = (EditText) this.eRG.findViewById(d.g.search_location_editview);
        this.cSW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.eRH.setEnabled(false);
                } else {
                    SearchLocationActivity.this.eRH.setEnabled(true);
                }
            }
        });
        this.eRH = (TextView) this.eRG.findViewById(d.g.search_location_bt_search_s);
        this.eRH.setEnabled(false);
        this.eRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.jU()) {
                    SearchLocationActivity.this.showToast(d.k.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aRM();
                }
            }
        });
        this.LS = (BdListView) findViewById(d.g.search_position_list);
        this.eRF = new a(this);
        this.LS.setAdapter((ListAdapter) this.eRF);
        this.LS.setOnItemClickListener(this.eRK);
        this.LS.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.eRE = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.byk().getLocationData();
        if (locationData != null) {
            this.eRE.ab(a(locationData.byh(), locationData.byg(), locationData.byi()));
        }
        this.eRF.a(this.eRE);
        this.eRF.notifyDataSetChanged();
    }

    private ArrayList<a.C0194a> a(List<a.C0238a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0194a> arrayList = new ArrayList<>();
        a.C0238a c0238a = null;
        for (a.C0238a c0238a2 : list) {
            if (c0238a2 != null && !TextUtils.isEmpty(c0238a2.getName())) {
                if (TextUtils.equals(c0238a2.getName(), str)) {
                    c0238a = c0238a2;
                } else {
                    a.C0194a c0194a = new a.C0194a();
                    c0194a.setName(c0238a2.getName());
                    c0194a.py(c0238a2.byi());
                    arrayList.add(c0194a);
                }
            }
        }
        if (c0238a != null) {
            a.C0194a c0194a2 = new a.C0194a();
            c0194a2.setName(c0238a.getName());
            c0194a2.py(c0238a.byi());
            arrayList.add(0, c0194a2);
        } else {
            a.C0194a c0194a3 = new a.C0194a();
            c0194a3.setName(str);
            c0194a3.py(str2);
            arrayList.add(0, c0194a3);
        }
        return arrayList;
    }

    public void aRM() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.cSW != null) {
            return k.a(this.cSW.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i(this.eRH, d.f.s_navbar_button_bg);
        am.c(this.eRI, d.f.icon_search_ba);
        am.c(this.eRH, d.C0142d.search_location_button_color, 3);
        if (i == 1) {
            this.cSW.setTextColor(getResources().getColor(d.C0142d.cp_cont_b_1));
            this.cSW.setHintTextColor(getResources().getColor(d.C0142d.cp_cont_e_1));
        } else {
            this.cSW.setTextColor(getResources().getColor(d.C0142d.cp_cont_b));
            this.cSW.setHintTextColor(getResources().getColor(d.C0142d.cp_cont_e));
        }
        this.eRF.notifyDataSetChanged();
    }
}

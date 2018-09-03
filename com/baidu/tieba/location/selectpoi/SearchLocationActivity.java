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
import com.baidu.tieba.f;
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
    private EditText cVF;
    private com.baidu.tieba.location.data.a eVu;
    private a eVv;
    private LinearLayout eVw;
    private TextView eVx;
    private ImageView eVy;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eVz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(f.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.eVu = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.eVu = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.eVv.a(SearchLocationActivity.this.eVu);
                    SearchLocationActivity.this.eVv.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cVF);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener eVA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.eVv != null && SearchLocationActivity.this.eVv.aSN()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0193a c0193a = (a.C0193a) SearchLocationActivity.this.eVv.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0193a.getName(), c0193a.getName(), c0193a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eVz);
        SearchLocationActivityStatic.aSM();
        setContentView(f.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bpP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.cVF.hasFocus()) {
                    l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cVF);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.eVw = (LinearLayout) this.bpP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, f.h.search_location_edit_layout, (View.OnClickListener) null);
        this.eVy = (ImageView) this.eVw.findViewById(f.g.search_bar_icon);
        this.cVF = (EditText) this.eVw.findViewById(f.g.search_location_editview);
        this.cVF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.eVx.setEnabled(false);
                } else {
                    SearchLocationActivity.this.eVx.setEnabled(true);
                }
            }
        });
        this.eVx = (TextView) this.eVw.findViewById(f.g.search_location_bt_search_s);
        this.eVx.setEnabled(false);
        this.eVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.jV()) {
                    SearchLocationActivity.this.showToast(f.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aSL();
                }
            }
        });
        this.LO = (BdListView) findViewById(f.g.search_position_list);
        this.eVv = new a(this);
        this.LO.setAdapter((ListAdapter) this.eVv);
        this.LO.setOnItemClickListener(this.eVA);
        this.LO.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.eVu = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwO().getLocationData();
        if (locationData != null) {
            this.eVu.ab(a(locationData.bwL(), locationData.bwK(), locationData.bwM()));
        }
        this.eVv.a(this.eVu);
        this.eVv.notifyDataSetChanged();
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
                    c0193a.pB(c0238a2.bwM());
                    arrayList.add(c0193a);
                }
            }
        }
        if (c0238a != null) {
            a.C0193a c0193a2 = new a.C0193a();
            c0193a2.setName(c0238a.getName());
            c0193a2.pB(c0238a.bwM());
            arrayList.add(0, c0193a2);
        } else {
            a.C0193a c0193a3 = new a.C0193a();
            c0193a3.setName(str);
            c0193a3.pB(str2);
            arrayList.add(0, c0193a3);
        }
        return arrayList;
    }

    public void aSL() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.cVF != null) {
            return k.a(this.cVF.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i(this.eVx, f.C0146f.s_navbar_button_bg);
        am.c(this.eVy, f.C0146f.icon_search_ba);
        am.c(this.eVx, f.d.search_location_button_color, 3);
        if (i == 1) {
            this.cVF.setTextColor(getResources().getColor(f.d.cp_cont_b_1));
            this.cVF.setHintTextColor(getResources().getColor(f.d.cp_cont_e_1));
        } else {
            this.cVF.setTextColor(getResources().getColor(f.d.cp_cont_b));
            this.cVF.setHintTextColor(getResources().getColor(f.d.cp_cont_e));
        }
        this.eVv.notifyDataSetChanged();
    }
}

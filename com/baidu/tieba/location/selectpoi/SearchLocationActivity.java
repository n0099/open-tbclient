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
import com.baidu.tbadk.core.util.ak;
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
    private BdListView FL;
    private EditText cKK;
    private com.baidu.tieba.location.data.a eBo;
    private a eBp;
    private LinearLayout eBq;
    private TextView eBr;
    private ImageView eBs;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eBt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.eBo = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.eBo = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.eBp.a(SearchLocationActivity.this.eBo);
                    SearchLocationActivity.this.eBp.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cKK);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener eBu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (SearchLocationActivity.this.eBp != null && SearchLocationActivity.this.eBp.aMm()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0176a c0176a = (a.C0176a) SearchLocationActivity.this.eBp.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0176a.getName(), c0176a.getName(), c0176a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eBt);
        SearchLocationActivityStatic.aMl();
        setContentView(d.i.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SearchLocationActivity.this.cKK.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cKK);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.eBq = (LinearLayout) this.bfy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.search_location_edit_layout, (View.OnClickListener) null);
        this.eBs = (ImageView) this.eBq.findViewById(d.g.search_bar_icon);
        this.cKK = (EditText) this.eBq.findViewById(d.g.search_location_editview);
        this.cKK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.eBr.setEnabled(false);
                } else {
                    SearchLocationActivity.this.eBr.setEnabled(true);
                }
            }
        });
        this.eBr = (TextView) this.eBq.findViewById(d.g.search_location_bt_search_s);
        this.eBr.setEnabled(false);
        this.eBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!l.hg()) {
                    SearchLocationActivity.this.showToast(d.k.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aMk();
                }
            }
        });
        this.FL = (BdListView) findViewById(d.g.search_position_list);
        this.eBp = new a(this);
        this.FL.setAdapter((ListAdapter) this.eBp);
        this.FL.setOnItemClickListener(this.eBu);
        this.FL.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.eBo = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsE().getLocationData();
        if (locationData != null) {
            this.eBo.X(a(locationData.bsB(), locationData.bsA(), locationData.bsC()));
        }
        this.eBp.a(this.eBo);
        this.eBp.notifyDataSetChanged();
    }

    private ArrayList<a.C0176a> a(List<a.C0219a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0176a> arrayList = new ArrayList<>();
        a.C0219a c0219a = null;
        for (a.C0219a c0219a2 : list) {
            if (c0219a2 != null && !TextUtils.isEmpty(c0219a2.getName())) {
                if (TextUtils.equals(c0219a2.getName(), str)) {
                    c0219a = c0219a2;
                } else {
                    a.C0176a c0176a = new a.C0176a();
                    c0176a.setName(c0219a2.getName());
                    c0176a.oG(c0219a2.bsC());
                    arrayList.add(c0176a);
                }
            }
        }
        if (c0219a != null) {
            a.C0176a c0176a2 = new a.C0176a();
            c0176a2.setName(c0219a.getName());
            c0176a2.oG(c0219a.bsC());
            arrayList.add(0, c0176a2);
        } else {
            a.C0176a c0176a3 = new a.C0176a();
            c0176a3.setName(str);
            c0176a3.oG(str2);
            arrayList.add(0, c0176a3);
        }
        return arrayList;
    }

    public void aMk() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.cKK != null) {
            return k.a(this.cKK.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.i(this.eBr, d.f.s_navbar_button_bg);
        ak.c(this.eBs, d.f.icon_search_ba);
        ak.c(this.eBr, d.C0126d.search_location_button_color, 3);
        if (i == 1) {
            this.cKK.setTextColor(getResources().getColor(d.C0126d.cp_cont_b_1));
            this.cKK.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_e_1));
        } else {
            this.cKK.setTextColor(getResources().getColor(d.C0126d.cp_cont_b));
            this.cKK.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_e));
        }
        this.eBp.notifyDataSetChanged();
    }
}

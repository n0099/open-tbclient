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
    private BdListView FH;
    private EditText cLO;
    private com.baidu.tieba.location.data.a eCt;
    private a eCu;
    private LinearLayout eCv;
    private TextView eCw;
    private ImageView eCx;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eCy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.eCt = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.eCt = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.eCu.a(SearchLocationActivity.this.eCt);
                    SearchLocationActivity.this.eCu.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cLO);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener eCz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (SearchLocationActivity.this.eCu != null && SearchLocationActivity.this.eCu.aMl()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0176a c0176a = (a.C0176a) SearchLocationActivity.this.eCu.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0176a.getName(), c0176a.getName(), c0176a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eCy);
        SearchLocationActivityStatic.aMk();
        setContentView(d.i.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bfz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SearchLocationActivity.this.cLO.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cLO);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.eCv = (LinearLayout) this.bfz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.search_location_edit_layout, (View.OnClickListener) null);
        this.eCx = (ImageView) this.eCv.findViewById(d.g.search_bar_icon);
        this.cLO = (EditText) this.eCv.findViewById(d.g.search_location_editview);
        this.cLO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.eCw.setEnabled(false);
                } else {
                    SearchLocationActivity.this.eCw.setEnabled(true);
                }
            }
        });
        this.eCw = (TextView) this.eCv.findViewById(d.g.search_location_bt_search_s);
        this.eCw.setEnabled(false);
        this.eCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!l.hg()) {
                    SearchLocationActivity.this.showToast(d.k.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aMj();
                }
            }
        });
        this.FH = (BdListView) findViewById(d.g.search_position_list);
        this.eCu = new a(this);
        this.FH.setAdapter((ListAdapter) this.eCu);
        this.FH.setOnItemClickListener(this.eCz);
        this.FH.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.eCt = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsC().getLocationData();
        if (locationData != null) {
            this.eCt.X(a(locationData.bsz(), locationData.bsy(), locationData.bsA()));
        }
        this.eCu.a(this.eCt);
        this.eCu.notifyDataSetChanged();
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
                    c0176a.oJ(c0219a2.bsA());
                    arrayList.add(c0176a);
                }
            }
        }
        if (c0219a != null) {
            a.C0176a c0176a2 = new a.C0176a();
            c0176a2.setName(c0219a.getName());
            c0176a2.oJ(c0219a.bsA());
            arrayList.add(0, c0176a2);
        } else {
            a.C0176a c0176a3 = new a.C0176a();
            c0176a3.setName(str);
            c0176a3.oJ(str2);
            arrayList.add(0, c0176a3);
        }
        return arrayList;
    }

    public void aMj() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.cLO != null) {
            return k.a(this.cLO.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.i(this.eCw, d.f.s_navbar_button_bg);
        ak.c(this.eCx, d.f.icon_search_ba);
        ak.c(this.eCw, d.C0126d.search_location_button_color, 3);
        if (i == 1) {
            this.cLO.setTextColor(getResources().getColor(d.C0126d.cp_cont_b_1));
            this.cLO.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_e_1));
        } else {
            this.cLO.setTextColor(getResources().getColor(d.C0126d.cp_cont_b));
            this.cLO.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_e));
        }
        this.eCu.notifyDataSetChanged();
    }
}

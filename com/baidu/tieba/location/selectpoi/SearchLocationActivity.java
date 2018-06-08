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
/* loaded from: classes3.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView LQ;
    private EditText cUU;
    private com.baidu.tieba.location.data.a eNN;
    private a eNO;
    private LinearLayout eNP;
    private TextView eNQ;
    private ImageView eNR;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a eNS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.eNN = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.eNN = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.eNO.a(SearchLocationActivity.this.eNN);
                    SearchLocationActivity.this.eNO.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cUU);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener eNT = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.eNO != null && SearchLocationActivity.this.eNO.aRi()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0192a c0192a = (a.C0192a) SearchLocationActivity.this.eNO.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0192a.getName(), c0192a.getName(), c0192a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eNS);
        SearchLocationActivityStatic.aRh();
        setContentView(d.i.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bnG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.cUU.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.cUU);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.eNP = (LinearLayout) this.bnG.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.search_location_edit_layout, (View.OnClickListener) null);
        this.eNR = (ImageView) this.eNP.findViewById(d.g.search_bar_icon);
        this.cUU = (EditText) this.eNP.findViewById(d.g.search_location_editview);
        this.cUU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.eNQ.setEnabled(false);
                } else {
                    SearchLocationActivity.this.eNQ.setEnabled(true);
                }
            }
        });
        this.eNQ = (TextView) this.eNP.findViewById(d.g.search_location_bt_search_s);
        this.eNQ.setEnabled(false);
        this.eNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.jU()) {
                    SearchLocationActivity.this.showToast(d.k.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aRg();
                }
            }
        });
        this.LQ = (BdListView) findViewById(d.g.search_position_list);
        this.eNO = new a(this);
        this.LQ.setAdapter((ListAdapter) this.eNO);
        this.LQ.setOnItemClickListener(this.eNT);
        this.LQ.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.eNN = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxH().getLocationData();
        if (locationData != null) {
            this.eNN.X(a(locationData.bxE(), locationData.bxD(), locationData.bxF()));
        }
        this.eNO.a(this.eNN);
        this.eNO.notifyDataSetChanged();
    }

    private ArrayList<a.C0192a> a(List<a.C0236a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0192a> arrayList = new ArrayList<>();
        a.C0236a c0236a = null;
        for (a.C0236a c0236a2 : list) {
            if (c0236a2 != null && !TextUtils.isEmpty(c0236a2.getName())) {
                if (TextUtils.equals(c0236a2.getName(), str)) {
                    c0236a = c0236a2;
                } else {
                    a.C0192a c0192a = new a.C0192a();
                    c0192a.setName(c0236a2.getName());
                    c0192a.px(c0236a2.bxF());
                    arrayList.add(c0192a);
                }
            }
        }
        if (c0236a != null) {
            a.C0192a c0192a2 = new a.C0192a();
            c0192a2.setName(c0236a.getName());
            c0192a2.px(c0236a.bxF());
            arrayList.add(0, c0192a2);
        } else {
            a.C0192a c0192a3 = new a.C0192a();
            c0192a3.setName(str);
            c0192a3.px(str2);
            arrayList.add(0, c0192a3);
        }
        return arrayList;
    }

    public void aRg() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.cUU != null) {
            return k.a(this.cUU.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.eNQ, d.f.s_navbar_button_bg);
        al.c(this.eNR, d.f.icon_search_ba);
        al.c(this.eNQ, d.C0141d.search_location_button_color, 3);
        if (i == 1) {
            this.cUU.setTextColor(getResources().getColor(d.C0141d.cp_cont_b_1));
            this.cUU.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e_1));
        } else {
            this.cUU.setTextColor(getResources().getColor(d.C0141d.cp_cont_b));
            this.cUU.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        }
        this.eNO.notifyDataSetChanged();
    }
}

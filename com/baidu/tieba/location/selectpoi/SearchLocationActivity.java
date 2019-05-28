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
import com.baidu.tieba.R;
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
    private BdListView MS;
    private EditText eXX;
    private com.baidu.tieba.location.data.a hdJ;
    private a hdK;
    private LinearLayout hdL;
    private TextView hdM;
    private ImageView hdN;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a hdO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.hdJ = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.hdJ = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.hdK.a(SearchLocationActivity.this.hdJ);
                    SearchLocationActivity.this.hdK.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.eXX);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener hdP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.hdK != null && SearchLocationActivity.this.hdK.bJd()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0352a c0352a = (a.C0352a) SearchLocationActivity.this.hdK.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0352a.getName(), c0352a.getName(), c0352a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hdO);
        SearchLocationActivityStatic.bJc();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cXZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.eXX.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.eXX);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.hdL = (LinearLayout) this.cXZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.hdN = (ImageView) this.hdL.findViewById(R.id.search_bar_icon);
        this.eXX = (EditText) this.hdL.findViewById(R.id.search_location_editview);
        this.eXX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.hdM.setEnabled(false);
                } else {
                    SearchLocationActivity.this.hdM.setEnabled(true);
                }
            }
        });
        this.hdM = (TextView) this.hdL.findViewById(R.id.search_location_bt_search_s);
        this.hdM.setEnabled(false);
        this.hdM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.ki()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.bJb();
                }
            }
        });
        this.MS = (BdListView) findViewById(R.id.search_position_list);
        this.hdK = new a(this);
        this.MS.setAdapter((ListAdapter) this.hdK);
        this.MS.setOnItemClickListener(this.hdP);
        this.MS.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.hdJ = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cnb().getLocationData();
        if (locationData != null) {
            this.hdJ.ai(b(locationData.cna(), locationData.cmZ(), locationData.getSn()));
        }
        this.hdK.a(this.hdJ);
        this.hdK.notifyDataSetChanged();
    }

    private ArrayList<a.C0352a> b(List<a.C0410a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0352a> arrayList = new ArrayList<>();
        a.C0410a c0410a = null;
        for (a.C0410a c0410a2 : list) {
            if (c0410a2 != null && !TextUtils.isEmpty(c0410a2.getName())) {
                if (TextUtils.equals(c0410a2.getName(), str)) {
                    c0410a = c0410a2;
                } else {
                    a.C0352a c0352a = new a.C0352a();
                    c0352a.setName(c0410a2.getName());
                    c0352a.zw(c0410a2.getSn());
                    arrayList.add(c0352a);
                }
            }
        }
        if (c0410a != null) {
            a.C0352a c0352a2 = new a.C0352a();
            c0352a2.setName(c0410a.getName());
            c0352a2.zw(c0410a.getSn());
            arrayList.add(0, c0352a2);
        } else {
            a.C0352a c0352a3 = new a.C0352a();
            c0352a3.setName(str);
            c0352a3.zw(str2);
            arrayList.add(0, c0352a3);
        }
        return arrayList;
    }

    public void bJb() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.eXX != null) {
            return k.a(this.eXX.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.k(this.hdM, R.drawable.s_navbar_button_bg);
        al.c(this.hdN, (int) R.drawable.icon_search_ba);
        al.f(this.hdM, R.color.search_location_button_color, 3);
        if (i == 1) {
            this.eXX.setTextColor(getResources().getColor(R.color.cp_cont_b_1));
            this.eXX.setHintTextColor(getResources().getColor(R.color.cp_cont_e_1));
        } else {
            this.eXX.setTextColor(getResources().getColor(R.color.cp_cont_b));
            this.eXX.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        }
        this.hdK.notifyDataSetChanged();
    }
}

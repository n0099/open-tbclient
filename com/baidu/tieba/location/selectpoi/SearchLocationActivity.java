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
import com.baidu.tbadk.core.util.aj;
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
    private BdListView auZ;
    private EditText drT;
    private com.baidu.tieba.location.data.a fgJ;
    private a fgK;
    private LinearLayout fgL;
    private TextView fgM;
    private ImageView fgN;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a fgO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.fgJ = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.fgJ = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.fgK.a(SearchLocationActivity.this.fgJ);
                    SearchLocationActivity.this.fgK.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.drT);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener fgP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.fgK != null && SearchLocationActivity.this.fgK.aRq()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0193a c0193a = (a.C0193a) SearchLocationActivity.this.fgK.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0193a.getName(), c0193a.getName(), c0193a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fgO);
        SearchLocationActivityStatic.aRp();
        setContentView(d.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bVs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.drT.hasFocus()) {
                    l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.drT);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.fgL = (LinearLayout) this.bVs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.search_location_edit_layout, (View.OnClickListener) null);
        this.fgN = (ImageView) this.fgL.findViewById(d.g.search_bar_icon);
        this.drT = (EditText) this.fgL.findViewById(d.g.search_location_editview);
        this.drT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.fgM.setEnabled(false);
                } else {
                    SearchLocationActivity.this.fgM.setEnabled(true);
                }
            }
        });
        this.fgM = (TextView) this.fgL.findViewById(d.g.search_location_bt_search_s);
        this.fgM.setEnabled(false);
        this.fgM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.pa()) {
                    SearchLocationActivity.this.showToast(d.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aRo();
                }
            }
        });
        this.auZ = (BdListView) findViewById(d.g.search_position_list);
        this.fgK = new a(this);
        this.auZ.setAdapter((ListAdapter) this.fgK);
        this.auZ.setOnItemClickListener(this.fgP);
        this.auZ.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.fgJ = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxE().getLocationData();
        if (locationData != null) {
            this.fgJ.W(a(locationData.bxB(), locationData.bxA(), locationData.bxC()));
        }
        this.fgK.a(this.fgJ);
        this.fgK.notifyDataSetChanged();
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
                    c0193a.oB(c0238a2.bxC());
                    arrayList.add(c0193a);
                }
            }
        }
        if (c0238a != null) {
            a.C0193a c0193a2 = new a.C0193a();
            c0193a2.setName(c0238a.getName());
            c0193a2.oB(c0238a.bxC());
            arrayList.add(0, c0193a2);
        } else {
            a.C0193a c0193a3 = new a.C0193a();
            c0193a3.setName(str);
            c0193a3.oB(str2);
            arrayList.add(0, c0193a3);
        }
        return arrayList;
    }

    public void aRo() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.drT != null) {
            return k.a(this.drT.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.s(this.fgM, d.f.s_navbar_button_bg);
        aj.c(this.fgN, d.f.icon_search_ba);
        aj.e(this.fgM, d.C0141d.search_location_button_color, 3);
        if (i == 1) {
            this.drT.setTextColor(getResources().getColor(d.C0141d.cp_cont_b_1));
            this.drT.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e_1));
        } else {
            this.drT.setTextColor(getResources().getColor(d.C0141d.cp_cont_b));
            this.drT.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        }
        this.fgK.notifyDataSetChanged();
    }
}

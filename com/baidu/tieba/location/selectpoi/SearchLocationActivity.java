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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes8.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView Ao;
    private EditText fYS;
    private com.baidu.tieba.location.data.a ick;
    private a icl;
    private LinearLayout icm;
    private TextView icn;
    private ImageView ico;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a icp = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.ick = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.ick = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.icl.a(SearchLocationActivity.this.ick);
                    SearchLocationActivity.this.icl.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fYS);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener icq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.icl != null && SearchLocationActivity.this.icl.ccj()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0548a c0548a = (a.C0548a) SearchLocationActivity.this.icl.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0548a.getName(), c0548a.getName(), c0548a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.icp);
        SearchLocationActivityStatic.cci();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dXN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.fYS.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fYS);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.icm = (LinearLayout) this.dXN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.ico = (ImageView) this.icm.findViewById(R.id.search_bar_icon);
        this.fYS = (EditText) this.icm.findViewById(R.id.search_location_editview);
        this.fYS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.icn.setEnabled(false);
                } else {
                    SearchLocationActivity.this.icn.setEnabled(true);
                }
            }
        });
        this.icn = (TextView) this.icm.findViewById(R.id.search_location_bt_search_s);
        this.icn.setEnabled(false);
        this.icn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.cch();
                }
            }
        });
        this.Ao = (BdListView) findViewById(R.id.search_position_list);
        this.icl = new a(this);
        this.Ao.setAdapter((ListAdapter) this.icl);
        this.Ao.setOnItemClickListener(this.icq);
        this.Ao.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.ick = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cKe().getLocationData();
        if (locationData != null) {
            this.ick.ax(b(locationData.cKd(), locationData.cKc(), locationData.getSn()));
        }
        this.icl.a(this.ick);
        this.icl.notifyDataSetChanged();
    }

    private ArrayList<a.C0548a> b(List<a.C0605a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0548a> arrayList = new ArrayList<>();
        a.C0605a c0605a = null;
        for (a.C0605a c0605a2 : list) {
            if (c0605a2 != null && !TextUtils.isEmpty(c0605a2.getName())) {
                if (TextUtils.equals(c0605a2.getName(), str)) {
                    c0605a = c0605a2;
                } else {
                    a.C0548a c0548a = new a.C0548a();
                    c0548a.setName(c0605a2.getName());
                    c0548a.DV(c0605a2.getSn());
                    arrayList.add(c0548a);
                }
            }
        }
        if (c0605a != null) {
            a.C0548a c0548a2 = new a.C0548a();
            c0548a2.setName(c0605a.getName());
            c0548a2.DV(c0605a.getSn());
            arrayList.add(0, c0548a2);
        } else {
            a.C0548a c0548a3 = new a.C0548a();
            c0548a3.setName(str);
            c0548a3.DV(str2);
            arrayList.add(0, c0548a3);
        }
        return arrayList;
    }

    public void cch() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.fYS != null) {
            return k.charSequence2String(this.fYS.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.icn, R.drawable.s_navbar_button_bg);
        SvgManager.aEp().a(this.ico, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.icn, R.color.search_location_button_color, 3);
        this.fYS.setTextColor(am.getColor(R.color.cp_cont_b));
        this.fYS.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.icl.notifyDataSetChanged();
    }
}

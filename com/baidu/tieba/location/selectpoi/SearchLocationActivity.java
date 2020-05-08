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
/* loaded from: classes10.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView Ua;
    private EditText gLg;
    private com.baidu.tieba.location.data.a iQg;
    private a iQh;
    private LinearLayout iQi;
    private TextView iQj;
    private ImageView iQk;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a iQl = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.iQg = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.iQg = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.iQh.a(SearchLocationActivity.this.iQg);
                    SearchLocationActivity.this.iQh.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gLg);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener iQm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.iQh != null && SearchLocationActivity.this.iQh.coN()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0614a c0614a = (a.C0614a) SearchLocationActivity.this.iQh.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0614a.getName(), c0614a.getName(), c0614a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.iQl);
        SearchLocationActivityStatic.coM();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eCn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.gLg.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gLg);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.iQi = (LinearLayout) this.eCn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.iQk = (ImageView) this.iQi.findViewById(R.id.search_bar_icon);
        this.gLg = (EditText) this.iQi.findViewById(R.id.search_location_editview);
        this.gLg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.iQj.setEnabled(false);
                } else {
                    SearchLocationActivity.this.iQj.setEnabled(true);
                }
            }
        });
        this.iQj = (TextView) this.iQi.findViewById(R.id.search_location_bt_search_s);
        this.iQj.setEnabled(false);
        this.iQj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.coL();
                }
            }
        });
        this.Ua = (BdListView) findViewById(R.id.search_position_list);
        this.iQh = new a(this);
        this.Ua.setAdapter((ListAdapter) this.iQh);
        this.Ua.setOnItemClickListener(this.iQm);
        this.Ua.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.iQg = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cWU().getLocationData();
        if (locationData != null) {
            this.iQg.az(b(locationData.cWT(), locationData.cWS(), locationData.asR()));
        }
        this.iQh.a(this.iQg);
        this.iQh.notifyDataSetChanged();
    }

    private ArrayList<a.C0614a> b(List<a.C0676a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0614a> arrayList = new ArrayList<>();
        a.C0676a c0676a = null;
        for (a.C0676a c0676a2 : list) {
            if (c0676a2 != null && !TextUtils.isEmpty(c0676a2.getName())) {
                if (TextUtils.equals(c0676a2.getName(), str)) {
                    c0676a = c0676a2;
                } else {
                    a.C0614a c0614a = new a.C0614a();
                    c0614a.setName(c0676a2.getName());
                    c0614a.FW(c0676a2.asR());
                    arrayList.add(c0614a);
                }
            }
        }
        if (c0676a != null) {
            a.C0614a c0614a2 = new a.C0614a();
            c0614a2.setName(c0676a.getName());
            c0614a2.FW(c0676a.asR());
            arrayList.add(0, c0614a2);
        } else {
            a.C0614a c0614a3 = new a.C0614a();
            c0614a3.setName(str);
            c0614a3.FW(str2);
            arrayList.add(0, c0614a3);
        }
        return arrayList;
    }

    public void coL() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.gLg != null) {
            return k.charSequence2String(this.gLg.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.iQj, R.drawable.s_navbar_button_bg);
        SvgManager.aOR().a(this.iQk, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.iQj, R.color.search_location_button_color, 3);
        this.gLg.setTextColor(am.getColor(R.color.cp_cont_b));
        this.gLg.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.iQh.notifyDataSetChanged();
    }
}

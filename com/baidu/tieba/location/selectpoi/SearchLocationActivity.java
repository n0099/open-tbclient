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
    private BdListView AG;
    private EditText gbP;
    private com.baidu.tieba.location.data.a ifZ;
    private a iga;
    private LinearLayout igb;
    private TextView igc;
    private ImageView igd;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a ige = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.ifZ = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.ifZ = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.iga.a(SearchLocationActivity.this.ifZ);
                    SearchLocationActivity.this.iga.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gbP);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener igf = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.iga != null && SearchLocationActivity.this.iga.cej()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0555a c0555a = (a.C0555a) SearchLocationActivity.this.iga.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0555a.getName(), c0555a.getName(), c0555a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ige);
        SearchLocationActivityStatic.cei();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ecv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.gbP.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gbP);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.igb = (LinearLayout) this.ecv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.igd = (ImageView) this.igb.findViewById(R.id.search_bar_icon);
        this.gbP = (EditText) this.igb.findViewById(R.id.search_location_editview);
        this.gbP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.igc.setEnabled(false);
                } else {
                    SearchLocationActivity.this.igc.setEnabled(true);
                }
            }
        });
        this.igc = (TextView) this.igb.findViewById(R.id.search_location_bt_search_s);
        this.igc.setEnabled(false);
        this.igc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.ceh();
                }
            }
        });
        this.AG = (BdListView) findViewById(R.id.search_position_list);
        this.iga = new a(this);
        this.AG.setAdapter((ListAdapter) this.iga);
        this.AG.setOnItemClickListener(this.igf);
        this.AG.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.ifZ = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cMb().getLocationData();
        if (locationData != null) {
            this.ifZ.ax(b(locationData.cMa(), locationData.cLZ(), locationData.getSn()));
        }
        this.iga.a(this.ifZ);
        this.iga.notifyDataSetChanged();
    }

    private ArrayList<a.C0555a> b(List<a.C0614a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0555a> arrayList = new ArrayList<>();
        a.C0614a c0614a = null;
        for (a.C0614a c0614a2 : list) {
            if (c0614a2 != null && !TextUtils.isEmpty(c0614a2.getName())) {
                if (TextUtils.equals(c0614a2.getName(), str)) {
                    c0614a = c0614a2;
                } else {
                    a.C0555a c0555a = new a.C0555a();
                    c0555a.setName(c0614a2.getName());
                    c0555a.Em(c0614a2.getSn());
                    arrayList.add(c0555a);
                }
            }
        }
        if (c0614a != null) {
            a.C0555a c0555a2 = new a.C0555a();
            c0555a2.setName(c0614a.getName());
            c0555a2.Em(c0614a.getSn());
            arrayList.add(0, c0555a2);
        } else {
            a.C0555a c0555a3 = new a.C0555a();
            c0555a3.setName(str);
            c0555a3.Em(str2);
            arrayList.add(0, c0555a3);
        }
        return arrayList;
    }

    public void ceh() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.gbP != null) {
            return k.charSequence2String(this.gbP.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.igc, R.drawable.s_navbar_button_bg);
        SvgManager.aGG().a(this.igd, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.igc, R.color.search_location_button_color, 3);
        this.gbP.setTextColor(am.getColor(R.color.cp_cont_b));
        this.gbP.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.iga.notifyDataSetChanged();
    }
}

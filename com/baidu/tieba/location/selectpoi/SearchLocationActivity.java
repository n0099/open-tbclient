package com.baidu.tieba.location.selectpoi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.location.data.a;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView VY;
    private EditText itS;
    private com.baidu.tieba.location.data.a kLs;
    private a kLt;
    private LinearLayout kLu;
    private TextView kLv;
    private ImageView kLw;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a kLx = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.kLs = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.kLs = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.kLt.a(SearchLocationActivity.this.kLs);
                    SearchLocationActivity.this.kLt.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.itS);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener kLy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.kLt != null && SearchLocationActivity.this.kLt.dbf()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0784a c0784a = (a.C0784a) SearchLocationActivity.this.kLt.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0784a.getName(), c0784a.getName(), c0784a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.kLx);
        SearchLocationActivityStatic.dbe();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fUP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.itS.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.itS);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.kLu = (LinearLayout) this.fUP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.kLw = (ImageView) this.kLu.findViewById(R.id.search_bar_icon);
        this.itS = (EditText) this.kLu.findViewById(R.id.search_location_editview);
        this.itS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.kLv.setEnabled(false);
                } else {
                    SearchLocationActivity.this.kLv.setEnabled(true);
                }
            }
        });
        this.itS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (!l.isNetOk()) {
                        SearchLocationActivity.this.showToast(R.string.no_network_guide);
                        return false;
                    } else if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                        return false;
                    } else {
                        SearchLocationActivity.this.dbd();
                        return true;
                    }
                }
                return false;
            }
        });
        this.kLv = (TextView) this.kLu.findViewById(R.id.search_location_bt_search_s);
        this.kLv.setEnabled(false);
        this.kLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.dbd();
                }
            }
        });
        this.VY = (BdListView) findViewById(R.id.search_position_list);
        this.kLt = new a(this);
        this.VY.setAdapter((ListAdapter) this.kLt);
        this.VY.setOnItemClickListener(this.kLy);
        this.VY.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.kLs = new com.baidu.tieba.location.data.a();
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData();
        if (locationData != null) {
            this.kLs.aM(b(locationData.getPoi_info(), locationData.getFormatted_address(), locationData.getSn()));
        }
        this.kLt.a(this.kLs);
        this.kLt.notifyDataSetChanged();
    }

    private ArrayList<a.C0784a> b(List<LocationData.NearByAddressData> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0784a> arrayList = new ArrayList<>();
        LocationData.NearByAddressData nearByAddressData = null;
        for (LocationData.NearByAddressData nearByAddressData2 : list) {
            if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                    nearByAddressData = nearByAddressData2;
                } else {
                    a.C0784a c0784a = new a.C0784a();
                    c0784a.setName(nearByAddressData2.getName());
                    c0784a.NV(nearByAddressData2.getSn());
                    arrayList.add(c0784a);
                }
            }
        }
        if (nearByAddressData != null) {
            a.C0784a c0784a2 = new a.C0784a();
            c0784a2.setName(nearByAddressData.getName());
            c0784a2.NV(nearByAddressData.getSn());
            arrayList.add(0, c0784a2);
        } else {
            a.C0784a c0784a3 = new a.C0784a();
            c0784a3.setName(str);
            c0784a3.NV(str2);
            arrayList.add(0, c0784a3);
        }
        return arrayList;
    }

    public void dbd() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.itS != null) {
            return k.charSequence2String(this.itS.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.kLv, R.drawable.s_navbar_button_bg);
        SvgManager.brn().a(this.kLw, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.kLv, R.color.search_location_button_color, 3);
        this.itS.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.itS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.kLt.notifyDataSetChanged();
    }
}

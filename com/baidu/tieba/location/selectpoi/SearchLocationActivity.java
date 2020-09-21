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
/* loaded from: classes22.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView VG;
    private EditText hMy;
    private com.baidu.tieba.location.data.a kdL;
    private a kdM;
    private LinearLayout kdN;
    private TextView kdO;
    private ImageView kdP;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a kdQ = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.kdL = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.kdL = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.kdM.a(SearchLocationActivity.this.kdL);
                    SearchLocationActivity.this.kdM.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.hMy);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener kdR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.kdM != null && SearchLocationActivity.this.kdM.cRL()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0736a c0736a = (a.C0736a) SearchLocationActivity.this.kdM.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0736a.getName(), c0736a.getName(), c0736a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.kdQ);
        SearchLocationActivityStatic.cRK();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fuv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.hMy.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.hMy);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.kdN = (LinearLayout) this.fuv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.kdP = (ImageView) this.kdN.findViewById(R.id.search_bar_icon);
        this.hMy = (EditText) this.kdN.findViewById(R.id.search_location_editview);
        this.hMy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.kdO.setEnabled(false);
                } else {
                    SearchLocationActivity.this.kdO.setEnabled(true);
                }
            }
        });
        this.hMy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (!l.isNetOk()) {
                        SearchLocationActivity.this.showToast(R.string.no_network_guide);
                        return false;
                    } else if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                        return false;
                    } else {
                        SearchLocationActivity.this.cRJ();
                        return true;
                    }
                }
                return false;
            }
        });
        this.kdO = (TextView) this.kdN.findViewById(R.id.search_location_bt_search_s);
        this.kdO.setEnabled(false);
        this.kdO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.cRJ();
                }
            }
        });
        this.VG = (BdListView) findViewById(R.id.search_position_list);
        this.kdM = new a(this);
        this.VG.setAdapter((ListAdapter) this.kdM);
        this.VG.setOnItemClickListener(this.kdR);
        this.VG.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.kdL = new com.baidu.tieba.location.data.a();
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dBg().getLocationData();
        if (locationData != null) {
            this.kdL.aJ(b(locationData.getPoi_info(), locationData.getFormatted_address(), locationData.getSn()));
        }
        this.kdM.a(this.kdL);
        this.kdM.notifyDataSetChanged();
    }

    private ArrayList<a.C0736a> b(List<LocationData.NearByAddressData> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0736a> arrayList = new ArrayList<>();
        LocationData.NearByAddressData nearByAddressData = null;
        for (LocationData.NearByAddressData nearByAddressData2 : list) {
            if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                    nearByAddressData = nearByAddressData2;
                } else {
                    a.C0736a c0736a = new a.C0736a();
                    c0736a.setName(nearByAddressData2.getName());
                    c0736a.Mr(nearByAddressData2.getSn());
                    arrayList.add(c0736a);
                }
            }
        }
        if (nearByAddressData != null) {
            a.C0736a c0736a2 = new a.C0736a();
            c0736a2.setName(nearByAddressData.getName());
            c0736a2.Mr(nearByAddressData.getSn());
            arrayList.add(0, c0736a2);
        } else {
            a.C0736a c0736a3 = new a.C0736a();
            c0736a3.setName(str);
            c0736a3.Mr(str2);
            arrayList.add(0, c0736a3);
        }
        return arrayList;
    }

    public void cRJ() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.hMy != null) {
            return k.charSequence2String(this.hMy.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.kdO, R.drawable.s_navbar_button_bg);
        SvgManager.bkl().a(this.kdP, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.kdO, R.color.search_location_button_color, 3);
        this.hMy.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.hMy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.kdM.notifyDataSetChanged();
    }
}

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
/* loaded from: classes5.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private EditText fhh;
    private com.baidu.tieba.location.data.a hkF;
    private a hkG;
    private LinearLayout hkH;
    private TextView hkI;
    private ImageView hkJ;
    private InputMethodManager mInputManager;
    private BdListView xL;
    private com.baidu.adp.framework.listener.a hkK = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.hkF = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.hkF = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.hkG.a(SearchLocationActivity.this.hkF);
                    SearchLocationActivity.this.hkG.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fhh);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener hkL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.hkG != null && SearchLocationActivity.this.hkG.bJN()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0462a c0462a = (a.C0462a) SearchLocationActivity.this.hkG.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0462a.getName(), c0462a.getName(), c0462a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hkK);
        SearchLocationActivityStatic.bJM();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.djV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.fhh.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fhh);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.hkH = (LinearLayout) this.djV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.hkJ = (ImageView) this.hkH.findViewById(R.id.search_bar_icon);
        this.fhh = (EditText) this.hkH.findViewById(R.id.search_location_editview);
        this.fhh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.hkI.setEnabled(false);
                } else {
                    SearchLocationActivity.this.hkI.setEnabled(true);
                }
            }
        });
        this.hkI = (TextView) this.hkH.findViewById(R.id.search_location_bt_search_s);
        this.hkI.setEnabled(false);
        this.hkI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.bJL();
                }
            }
        });
        this.xL = (BdListView) findViewById(R.id.search_position_list);
        this.hkG = new a(this);
        this.xL.setAdapter((ListAdapter) this.hkG);
        this.xL.setOnItemClickListener(this.hkL);
        this.xL.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.hkF = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.coU().getLocationData();
        if (locationData != null) {
            this.hkF.am(b(locationData.coT(), locationData.coS(), locationData.getSn()));
        }
        this.hkG.a(this.hkF);
        this.hkG.notifyDataSetChanged();
    }

    private ArrayList<a.C0462a> b(List<a.C0521a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0462a> arrayList = new ArrayList<>();
        a.C0521a c0521a = null;
        for (a.C0521a c0521a2 : list) {
            if (c0521a2 != null && !TextUtils.isEmpty(c0521a2.getName())) {
                if (TextUtils.equals(c0521a2.getName(), str)) {
                    c0521a = c0521a2;
                } else {
                    a.C0462a c0462a = new a.C0462a();
                    c0462a.setName(c0521a2.getName());
                    c0462a.zd(c0521a2.getSn());
                    arrayList.add(c0462a);
                }
            }
        }
        if (c0521a != null) {
            a.C0462a c0462a2 = new a.C0462a();
            c0462a2.setName(c0521a.getName());
            c0462a2.zd(c0521a.getSn());
            arrayList.add(0, c0462a2);
        } else {
            a.C0462a c0462a3 = new a.C0462a();
            c0462a3.setName(str);
            c0462a3.zd(str2);
            arrayList.add(0, c0462a3);
        }
        return arrayList;
    }

    public void bJL() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.fhh != null) {
            return k.charSequence2String(this.fhh.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.hkI, R.drawable.s_navbar_button_bg);
        SvgManager.amL().a(this.hkJ, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.setViewTextColor(this.hkI, R.color.search_location_button_color, 3);
        this.fhh.setTextColor(am.getColor(R.color.cp_cont_b));
        this.fhh.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.hkG.notifyDataSetChanged();
    }
}

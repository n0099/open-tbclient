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
/* loaded from: classes7.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView Ak;
    private EditText fVJ;
    private com.baidu.tieba.location.data.a hYG;
    private a hYH;
    private LinearLayout hYI;
    private TextView hYJ;
    private ImageView hYK;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a hYL = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.hYG = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.hYG = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.hYH.a(SearchLocationActivity.this.hYG);
                    SearchLocationActivity.this.hYH.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fVJ);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener hYM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.hYH != null && SearchLocationActivity.this.hYH.cba()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0543a c0543a = (a.C0543a) SearchLocationActivity.this.hYH.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0543a.getName(), c0543a.getName(), c0543a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hYL);
        SearchLocationActivityStatic.caZ();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dXE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.fVJ.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fVJ);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.hYI = (LinearLayout) this.dXE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.hYK = (ImageView) this.hYI.findViewById(R.id.search_bar_icon);
        this.fVJ = (EditText) this.hYI.findViewById(R.id.search_location_editview);
        this.fVJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.hYJ.setEnabled(false);
                } else {
                    SearchLocationActivity.this.hYJ.setEnabled(true);
                }
            }
        });
        this.hYJ = (TextView) this.hYI.findViewById(R.id.search_location_bt_search_s);
        this.hYJ.setEnabled(false);
        this.hYJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.caY();
                }
            }
        });
        this.Ak = (BdListView) findViewById(R.id.search_position_list);
        this.hYH = new a(this);
        this.Ak.setAdapter((ListAdapter) this.hYH);
        this.Ak.setOnItemClickListener(this.hYM);
        this.Ak.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.hYG = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cJa().getLocationData();
        if (locationData != null) {
            this.hYG.ax(b(locationData.cIZ(), locationData.cIY(), locationData.getSn()));
        }
        this.hYH.a(this.hYG);
        this.hYH.notifyDataSetChanged();
    }

    private ArrayList<a.C0543a> b(List<a.C0600a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0543a> arrayList = new ArrayList<>();
        a.C0600a c0600a = null;
        for (a.C0600a c0600a2 : list) {
            if (c0600a2 != null && !TextUtils.isEmpty(c0600a2.getName())) {
                if (TextUtils.equals(c0600a2.getName(), str)) {
                    c0600a = c0600a2;
                } else {
                    a.C0543a c0543a = new a.C0543a();
                    c0543a.setName(c0600a2.getName());
                    c0543a.DL(c0600a2.getSn());
                    arrayList.add(c0543a);
                }
            }
        }
        if (c0600a != null) {
            a.C0543a c0543a2 = new a.C0543a();
            c0543a2.setName(c0600a.getName());
            c0543a2.DL(c0600a.getSn());
            arrayList.add(0, c0543a2);
        } else {
            a.C0543a c0543a3 = new a.C0543a();
            c0543a3.setName(str);
            c0543a3.DL(str2);
            arrayList.add(0, c0543a3);
        }
        return arrayList;
    }

    public void caY() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.fVJ != null) {
            return k.charSequence2String(this.fVJ.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.hYJ, R.drawable.s_navbar_button_bg);
        SvgManager.aDW().a(this.hYK, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.hYJ, R.color.search_location_button_color, 3);
        this.fVJ.setTextColor(am.getColor(R.color.cp_cont_b));
        this.fVJ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.hYH.notifyDataSetChanged();
    }
}

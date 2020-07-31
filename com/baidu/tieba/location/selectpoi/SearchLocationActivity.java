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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.location.data.a;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView UL;
    private EditText hsb;
    private com.baidu.tieba.location.data.a jFK;
    private a jFL;
    private LinearLayout jFM;
    private TextView jFN;
    private ImageView jFO;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a jFP = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.jFK = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.jFK = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.jFL.a(SearchLocationActivity.this.jFK);
                    SearchLocationActivity.this.jFL.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.hsb);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener jFQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.jFL != null && SearchLocationActivity.this.jFL.cDo()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0688a c0688a = (a.C0688a) SearchLocationActivity.this.jFL.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0688a.getName(), c0688a.getName(), c0688a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.jFP);
        SearchLocationActivityStatic.cDn();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ffK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.hsb.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.hsb);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.jFM = (LinearLayout) this.ffK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.jFO = (ImageView) this.jFM.findViewById(R.id.search_bar_icon);
        this.hsb = (EditText) this.jFM.findViewById(R.id.search_location_editview);
        this.hsb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.jFN.setEnabled(false);
                } else {
                    SearchLocationActivity.this.jFN.setEnabled(true);
                }
            }
        });
        this.hsb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (!l.isNetOk()) {
                        SearchLocationActivity.this.showToast(R.string.no_network_guide);
                        return false;
                    } else if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                        return false;
                    } else {
                        SearchLocationActivity.this.cDm();
                        return true;
                    }
                }
                return false;
            }
        });
        this.jFN = (TextView) this.jFM.findViewById(R.id.search_location_bt_search_s);
        this.jFN.setEnabled(false);
        this.jFN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.cDm();
                }
            }
        });
        this.UL = (BdListView) findViewById(R.id.search_position_list);
        this.jFL = new a(this);
        this.UL.setAdapter((ListAdapter) this.jFL);
        this.UL.setOnItemClickListener(this.jFQ);
        this.UL.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.jFK = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.dlM().getLocationData();
        if (locationData != null) {
            this.jFK.aB(b(locationData.dlL(), locationData.dlK(), locationData.aAC()));
        }
        this.jFL.a(this.jFK);
        this.jFL.notifyDataSetChanged();
    }

    private ArrayList<a.C0688a> b(List<a.C0756a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0688a> arrayList = new ArrayList<>();
        a.C0756a c0756a = null;
        for (a.C0756a c0756a2 : list) {
            if (c0756a2 != null && !TextUtils.isEmpty(c0756a2.getName())) {
                if (TextUtils.equals(c0756a2.getName(), str)) {
                    c0756a = c0756a2;
                } else {
                    a.C0688a c0688a = new a.C0688a();
                    c0688a.setName(c0756a2.getName());
                    c0688a.IW(c0756a2.aAC());
                    arrayList.add(c0688a);
                }
            }
        }
        if (c0756a != null) {
            a.C0688a c0688a2 = new a.C0688a();
            c0688a2.setName(c0756a.getName());
            c0688a2.IW(c0756a.aAC());
            arrayList.add(0, c0688a2);
        } else {
            a.C0688a c0688a3 = new a.C0688a();
            c0688a3.setName(str);
            c0688a3.IW(str2);
            arrayList.add(0, c0688a3);
        }
        return arrayList;
    }

    public void cDm() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.hsb != null) {
            return k.charSequence2String(this.hsb.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.jFN, R.drawable.s_navbar_button_bg);
        SvgManager.baR().a(this.jFO, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.jFN, R.color.search_location_button_color, 3);
        this.hsb.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.hsb.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        this.jFL.notifyDataSetChanged();
    }
}

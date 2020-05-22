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
    private BdListView Um;
    private EditText gZS;
    private com.baidu.tieba.location.data.a jfh;
    private a jfi;
    private LinearLayout jfj;
    private TextView jfk;
    private ImageView jfl;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a jfm = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.jfh = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.jfh = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.jfi.a(SearchLocationActivity.this.jfh);
                    SearchLocationActivity.this.jfi.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gZS);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener jfn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.jfi != null && SearchLocationActivity.this.jfi.cvq()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0664a c0664a = (a.C0664a) SearchLocationActivity.this.jfi.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0664a.getName(), c0664a.getName(), c0664a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.jfm);
        SearchLocationActivityStatic.cvp();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eQM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.gZS.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gZS);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.jfj = (LinearLayout) this.eQM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.jfl = (ImageView) this.jfj.findViewById(R.id.search_bar_icon);
        this.gZS = (EditText) this.jfj.findViewById(R.id.search_location_editview);
        this.gZS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.jfk.setEnabled(false);
                } else {
                    SearchLocationActivity.this.jfk.setEnabled(true);
                }
            }
        });
        this.gZS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (!l.isNetOk()) {
                        SearchLocationActivity.this.showToast(R.string.no_network_guide);
                        return false;
                    } else if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                        return false;
                    } else {
                        SearchLocationActivity.this.cvo();
                        return true;
                    }
                }
                return false;
            }
        });
        this.jfk = (TextView) this.jfj.findViewById(R.id.search_location_bt_search_s);
        this.jfk.setEnabled(false);
        this.jfk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.cvo();
                }
            }
        });
        this.Um = (BdListView) findViewById(R.id.search_position_list);
        this.jfi = new a(this);
        this.Um.setAdapter((ListAdapter) this.jfi);
        this.Um.setOnItemClickListener(this.jfn);
        this.Um.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.jfh = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.dec().getLocationData();
        if (locationData != null) {
            this.jfh.az(b(locationData.deb(), locationData.dea(), locationData.awy()));
        }
        this.jfi.a(this.jfh);
        this.jfi.notifyDataSetChanged();
    }

    private ArrayList<a.C0664a> b(List<a.C0729a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0664a> arrayList = new ArrayList<>();
        a.C0729a c0729a = null;
        for (a.C0729a c0729a2 : list) {
            if (c0729a2 != null && !TextUtils.isEmpty(c0729a2.getName())) {
                if (TextUtils.equals(c0729a2.getName(), str)) {
                    c0729a = c0729a2;
                } else {
                    a.C0664a c0664a = new a.C0664a();
                    c0664a.setName(c0729a2.getName());
                    c0664a.HF(c0729a2.awy());
                    arrayList.add(c0664a);
                }
            }
        }
        if (c0729a != null) {
            a.C0664a c0664a2 = new a.C0664a();
            c0664a2.setName(c0729a.getName());
            c0664a2.HF(c0729a.awy());
            arrayList.add(0, c0664a2);
        } else {
            a.C0664a c0664a3 = new a.C0664a();
            c0664a3.setName(str);
            c0664a3.HF(str2);
            arrayList.add(0, c0664a3);
        }
        return arrayList;
    }

    public void cvo() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.gZS != null) {
            return k.charSequence2String(this.gZS.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.jfk, R.drawable.s_navbar_button_bg);
        SvgManager.aUV().a(this.jfl, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.jfk, R.color.search_location_button_color, 3);
        this.gZS.setTextColor(am.getColor(R.color.cp_cont_b));
        this.gZS.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.jfi.notifyDataSetChanged();
    }
}

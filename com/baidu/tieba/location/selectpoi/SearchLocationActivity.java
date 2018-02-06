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
    private BdListView avh;
    private EditText dsc;
    private com.baidu.tieba.location.data.a fgH;
    private a fgI;
    private LinearLayout fgJ;
    private TextView fgK;
    private ImageView fgL;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a fgM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.fgH = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.fgH = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.fgI.a(SearchLocationActivity.this.fgH);
                    SearchLocationActivity.this.fgI.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dsc);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener fgN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.fgI != null && SearchLocationActivity.this.fgI.aRq()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0192a c0192a = (a.C0192a) SearchLocationActivity.this.fgI.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0192a.getName(), c0192a.getName(), c0192a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fgM);
        SearchLocationActivityStatic.aRp();
        setContentView(d.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bVB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.dsc.hasFocus()) {
                    l.a(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dsc);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.fgJ = (LinearLayout) this.bVB.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.search_location_edit_layout, (View.OnClickListener) null);
        this.fgL = (ImageView) this.fgJ.findViewById(d.g.search_bar_icon);
        this.dsc = (EditText) this.fgJ.findViewById(d.g.search_location_editview);
        this.dsc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.fgK.setEnabled(false);
                } else {
                    SearchLocationActivity.this.fgK.setEnabled(true);
                }
            }
        });
        this.fgK = (TextView) this.fgJ.findViewById(d.g.search_location_bt_search_s);
        this.fgK.setEnabled(false);
        this.fgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.pa()) {
                    SearchLocationActivity.this.showToast(d.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.aRo();
                }
            }
        });
        this.avh = (BdListView) findViewById(d.g.search_position_list);
        this.fgI = new a(this);
        this.avh.setAdapter((ListAdapter) this.fgI);
        this.avh.setOnItemClickListener(this.fgN);
        this.avh.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.fgH = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxA().getLocationData();
        if (locationData != null) {
            this.fgH.W(a(locationData.bxx(), locationData.bxw(), locationData.bxy()));
        }
        this.fgI.a(this.fgH);
        this.fgI.notifyDataSetChanged();
    }

    private ArrayList<a.C0192a> a(List<a.C0237a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0192a> arrayList = new ArrayList<>();
        a.C0237a c0237a = null;
        for (a.C0237a c0237a2 : list) {
            if (c0237a2 != null && !TextUtils.isEmpty(c0237a2.getName())) {
                if (TextUtils.equals(c0237a2.getName(), str)) {
                    c0237a = c0237a2;
                } else {
                    a.C0192a c0192a = new a.C0192a();
                    c0192a.setName(c0237a2.getName());
                    c0192a.oB(c0237a2.bxy());
                    arrayList.add(c0192a);
                }
            }
        }
        if (c0237a != null) {
            a.C0192a c0192a2 = new a.C0192a();
            c0192a2.setName(c0237a.getName());
            c0192a2.oB(c0237a.bxy());
            arrayList.add(0, c0192a2);
        } else {
            a.C0192a c0192a3 = new a.C0192a();
            c0192a3.setName(str);
            c0192a3.oB(str2);
            arrayList.add(0, c0192a3);
        }
        return arrayList;
    }

    public void aRo() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.dsc != null) {
            return k.a(this.dsc.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.s(this.fgK, d.f.s_navbar_button_bg);
        aj.c(this.fgL, d.f.icon_search_ba);
        aj.e(this.fgK, d.C0140d.search_location_button_color, 3);
        if (i == 1) {
            this.dsc.setTextColor(getResources().getColor(d.C0140d.cp_cont_b_1));
            this.dsc.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e_1));
        } else {
            this.dsc.setTextColor(getResources().getColor(d.C0140d.cp_cont_b));
            this.dsc.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        }
        this.fgI.notifyDataSetChanged();
    }
}

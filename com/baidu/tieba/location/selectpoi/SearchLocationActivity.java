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
    private EditText gaU;
    private com.baidu.tieba.location.data.a ien;
    private a ieo;
    private LinearLayout iep;
    private TextView ieq;
    private ImageView ier;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a ies = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.ien = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.ien = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.ieo.a(SearchLocationActivity.this.ien);
                    SearchLocationActivity.this.ieo.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gaU);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener iet = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.ieo != null && SearchLocationActivity.this.ieo.cdP()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0554a c0554a = (a.C0554a) SearchLocationActivity.this.ieo.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0554a.getName(), c0554a.getName(), c0554a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ies);
        SearchLocationActivityStatic.cdO();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ebS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.gaU.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gaU);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.iep = (LinearLayout) this.ebS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.ier = (ImageView) this.iep.findViewById(R.id.search_bar_icon);
        this.gaU = (EditText) this.iep.findViewById(R.id.search_location_editview);
        this.gaU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.ieq.setEnabled(false);
                } else {
                    SearchLocationActivity.this.ieq.setEnabled(true);
                }
            }
        });
        this.ieq = (TextView) this.iep.findViewById(R.id.search_location_bt_search_s);
        this.ieq.setEnabled(false);
        this.ieq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.cdN();
                }
            }
        });
        this.AG = (BdListView) findViewById(R.id.search_position_list);
        this.ieo = new a(this);
        this.AG.setAdapter((ListAdapter) this.ieo);
        this.AG.setOnItemClickListener(this.iet);
        this.AG.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.ien = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cLG().getLocationData();
        if (locationData != null) {
            this.ien.ax(b(locationData.cLF(), locationData.cLE(), locationData.getSn()));
        }
        this.ieo.a(this.ien);
        this.ieo.notifyDataSetChanged();
    }

    private ArrayList<a.C0554a> b(List<a.C0613a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0554a> arrayList = new ArrayList<>();
        a.C0613a c0613a = null;
        for (a.C0613a c0613a2 : list) {
            if (c0613a2 != null && !TextUtils.isEmpty(c0613a2.getName())) {
                if (TextUtils.equals(c0613a2.getName(), str)) {
                    c0613a = c0613a2;
                } else {
                    a.C0554a c0554a = new a.C0554a();
                    c0554a.setName(c0613a2.getName());
                    c0554a.El(c0613a2.getSn());
                    arrayList.add(c0554a);
                }
            }
        }
        if (c0613a != null) {
            a.C0554a c0554a2 = new a.C0554a();
            c0554a2.setName(c0613a.getName());
            c0554a2.El(c0613a.getSn());
            arrayList.add(0, c0554a2);
        } else {
            a.C0554a c0554a3 = new a.C0554a();
            c0554a3.setName(str);
            c0554a3.El(str2);
            arrayList.add(0, c0554a3);
        }
        return arrayList;
    }

    public void cdN() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.gaU != null) {
            return k.charSequence2String(this.gaU.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.ieq, R.drawable.s_navbar_button_bg);
        SvgManager.aGC().a(this.ier, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.ieq, R.color.search_location_button_color, 3);
        this.gaU.setTextColor(am.getColor(R.color.cp_cont_b));
        this.gaU.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.ieo.notifyDataSetChanged();
    }
}

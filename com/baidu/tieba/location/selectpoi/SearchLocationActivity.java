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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.n1.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    public d.a.j0.n1.e.a mAdapter;
    public LinearLayout mEditLayout;
    public EditText mEditSearch;
    public InputMethodManager mInputManager;
    public BdListView mListView;
    public TextView mSearchButton;
    public d.a.j0.n1.c.a mSearchDatas;
    public ImageView search_bar_icon;
    public d.a.c.c.g.a mSearchDataNetListener = new a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    public final AbsListView.OnScrollListener mOnScrollListener = new f();
    public AdapterView.OnItemClickListener itemListener = new g();

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof LocationSearchHttpResponsedMessage;
            if (z || (responsedMessage instanceof LocationSearchResponseMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (z) {
                        SearchLocationActivity.this.mSearchDatas = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.mSearchDatas = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.mAdapter.d(SearchLocationActivity.this.mSearchDatas);
                    SearchLocationActivity.this.mAdapter.notifyDataSetChanged();
                    return;
                }
                SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SearchLocationActivity.this.mEditSearch.hasFocus()) {
                l.x(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.mEditSearch);
                SearchLocationActivity.this.closeActivity();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                SearchLocationActivity.this.mSearchButton.setEnabled(false);
            } else {
                SearchLocationActivity.this.mSearchButton.setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 3) {
                if (!l.D()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                    return false;
                } else if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    return false;
                } else {
                    SearchLocationActivity.this.getSearchData();
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.D()) {
                SearchLocationActivity.this.showToast(R.string.no_network_guide);
            } else if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
            } else {
                SearchLocationActivity.this.getSearchData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements AbsListView.OnScrollListener {
        public f() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 2 || i2 == 1) {
                l.x(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.mEditSearch);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (SearchLocationActivity.this.mAdapter == null || !SearchLocationActivity.this.mAdapter.c()) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
            MessageManager messageManager = MessageManager.getInstance();
            a.C1364a c1364a = (a.C1364a) SearchLocationActivity.this.mAdapter.getItem(i2);
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c1364a.a(), c1364a.a(), c1364a.b()));
            SearchLocationActivity.this.finish();
        }
    }

    private ArrayList<a.C1364a> processInvalidData(List<LocationData.NearByAddressData> list, String str, String str2) {
        LocationData.NearByAddressData nearByAddressData = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C1364a> arrayList = new ArrayList<>();
        for (LocationData.NearByAddressData nearByAddressData2 : list) {
            if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                    nearByAddressData = nearByAddressData2;
                } else {
                    a.C1364a c1364a = new a.C1364a();
                    c1364a.d(nearByAddressData2.getName());
                    c1364a.e(nearByAddressData2.getSn());
                    arrayList.add(c1364a);
                }
            }
        }
        if (nearByAddressData != null) {
            a.C1364a c1364a2 = new a.C1364a();
            c1364a2.d(nearByAddressData.getName());
            c1364a2.e(nearByAddressData.getSn());
            arrayList.add(0, c1364a2);
        } else {
            a.C1364a c1364a3 = new a.C1364a();
            c1364a3.d(str);
            c1364a3.e(str2);
            arrayList.add(0, c1364a3);
        }
        return arrayList;
    }

    public String getInputMsg() {
        EditText editText = this.mEditSearch;
        if (editText != null) {
            return k.charSequence2String(editText.getText(), null);
        }
        return null;
    }

    public void getSearchData() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public void initData() {
        this.mSearchDatas = new d.a.j0.n1.c.a();
        LocationData b2 = d.a.j0.d3.m0.b.a().b();
        if (b2 != null) {
            this.mSearchDatas.c(processInvalidData(b2.getPoi_info(), b2.getFormatted_address(), b2.getSn()));
        }
        this.mAdapter.d(this.mSearchDatas);
        this.mAdapter.notifyDataSetChanged();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        LinearLayout linearLayout = (LinearLayout) this.navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.mEditLayout = linearLayout;
        this.search_bar_icon = (ImageView) linearLayout.findViewById(R.id.search_bar_icon);
        EditText editText = (EditText) this.mEditLayout.findViewById(R.id.search_location_editview);
        this.mEditSearch = editText;
        editText.addTextChangedListener(new c());
        this.mEditSearch.setOnEditorActionListener(new d());
        TextView textView = (TextView) this.mEditLayout.findViewById(R.id.search_location_bt_search_s);
        this.mSearchButton = textView;
        textView.setEnabled(false);
        this.mSearchButton.setOnClickListener(new e());
        this.mListView = (BdListView) findViewById(R.id.search_position_list);
        d.a.j0.n1.e.a aVar = new d.a.j0.n1.e.a(this);
        this.mAdapter = aVar;
        this.mListView.setAdapter((ListAdapter) aVar);
        this.mListView.setOnItemClickListener(this.itemListener);
        this.mListView.setOnScrollListener(this.mOnScrollListener);
    }

    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.mSearchButton);
        d2.q(R.color.CAM_X0101);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0302);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.search_bar_icon, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.mSearchButton, R.color.search_location_button_color, 3);
        this.mEditSearch.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.mEditSearch.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mSearchDataNetListener);
        SearchLocationActivityStatic.a();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }
}

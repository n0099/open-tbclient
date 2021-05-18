package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.bind;
import com.baidu.wallet.base.widget.listview.internal.BindLayout;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ad;
import com.baidu.wallet.paysdk.datamodel.PaySetResponse;
import com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class PaySortSettingActivity extends PayBaseBeanActivity {
    public static final int STATE_FINISH_SAVE_FAIL = 101;
    public static final int STATE_FINISH_SAVE_SUC = 100;

    /* renamed from: f  reason: collision with root package name */
    public static a f25838f;

    /* renamed from: a  reason: collision with root package name */
    public b f25839a;

    /* renamed from: c  reason: collision with root package name */
    public BdActionBar f25841c;

    /* renamed from: d  reason: collision with root package name */
    public DragSortListView f25842d;

    /* renamed from: b  reason: collision with root package name */
    public final String f25840b = PaySortSettingActivity.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    public boolean f25843e = false;

    /* renamed from: g  reason: collision with root package name */
    public DragSortListView.h f25844g = new DragSortListView.h() { // from class: com.baidu.wallet.paysdk.ui.PaySortSettingActivity.1
        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.h
        public void drop(int i2, int i3) {
            if (i2 != i3) {
                PaySortSettingActivity.this.f25843e = true;
                PaySetResponse.PayInfoBean item = PaySortSettingActivity.this.f25839a.getItem(i2);
                if (item != null) {
                    PaySortSettingActivity.this.f25839a.getList().remove(item);
                    PaySortSettingActivity.this.f25839a.getList().add(i3, item);
                    PaySortSettingActivity.this.f25839a.notifyDataSetChanged();
                }
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class b extends BaseListAdapter<PaySetResponse.PayInfoBean> {
        public b(Context context) {
            super(context);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public void onBindViewHolder(List<Class<?>> list) {
            list.add(c.class);
        }
    }

    private void b() {
        c();
    }

    private void c() {
        com.baidu.wallet.paysdk.ui.widget.dragListView.a buildController = buildController(this.f25842d);
        this.f25842d.setFloatViewManager(buildController);
        this.f25842d.setOnTouchListener(buildController);
        this.f25842d.setDragEnabled(true);
        this.f25842d.setDropListener(this.f25844g);
        ArrayList<PaySetResponse.PayInfoBean> d2 = d();
        if (d2 == null || d2.size() == 0) {
            return;
        }
        b bVar = new b(getActivity());
        this.f25839a = bVar;
        this.f25842d.setAdapter((ListAdapter) bVar);
        this.f25839a.initList(d2);
    }

    public static void clearOnModifyPaySortListener(a aVar) {
        f25838f = null;
    }

    private ArrayList<PaySetResponse.PayInfoBean> d() {
        return (ArrayList) getIntent().getSerializableExtra("paymethod_info");
    }

    private void e() {
        ad adVar = (ad) PayBeanFactory.getInstance().getBean((Context) this, PayBeanFactory.BEAN_ID_PAY_SORT_SAVE, this.f25840b);
        List<PaySetResponse.PayInfoBean> list = this.f25839a.getList();
        adVar.a((list == null || list.size() <= 0) ? null : JsonUtils.toJson(list));
        adVar.setResponseCallback(this);
        adVar.execBean();
    }

    public static Intent getStartIntent(Context context, PaySetResponse.PayInfoBean[] payInfoBeanArr, int i2) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, payInfoBeanArr);
        Intent intent = new Intent(context, PaySortSettingActivity.class);
        intent.putExtra("paymethod_info", arrayList);
        intent.putExtra("paymethod_type", i2);
        return intent;
    }

    public static void setOnModifyPaySortListener(a aVar) {
        f25838f = aVar;
    }

    public com.baidu.wallet.paysdk.ui.widget.dragListView.a buildController(DragSortListView dragSortListView) {
        com.baidu.wallet.paysdk.ui.widget.dragListView.a aVar = new com.baidu.wallet.paysdk.ui.widget.dragListView.a(dragSortListView);
        aVar.c(ResUtils.id(this, "bd_wallet_paysort_click_img"));
        aVar.a(true);
        aVar.b(false);
        aVar.e(-1);
        return aVar;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 560) {
            if (i3 == -8) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_settings_fail_network"));
            } else {
                super.handleFailure(i2, i3, str);
                PaySettingActivity.toast(getActivity(), "ebpay_setting_fail", false);
            }
            setResult(101);
            a aVar = f25838f;
            if (aVar != null) {
                aVar.a(false);
                f25838f = null;
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 560) {
            PaySettingActivity.toast(getActivity(), "ebpay_setting_suc", true);
            setResult(100);
            a aVar = f25838f;
            if (aVar != null) {
                aVar.a(true);
                f25838f = null;
            }
            finish();
        }
    }

    public void initListFoot() {
        TextView textView = (TextView) LayoutInflater.from(this).inflate(ResUtils.layout(this, "wallet_cashdesk_paysort_tip_layout"), (ViewGroup) null);
        textView.setText(ResUtils.getString(getActivity(), "ebpay_paysetting_person_checked_tips"));
        this.f25842d.addFooterView(textView);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f25843e) {
            e();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this, "wallet_cashdesk_pay_sort_set_activity"));
        a();
        b();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(this.f25840b);
        f25838f = null;
    }

    private void a() {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this, "bdactionbar"));
        this.f25841c = bdActionBar;
        bdActionBar.setTitle("扣款顺序");
        this.f25841c.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySortSettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GlobalUtils.hideKeyboard(PaySortSettingActivity.this.getActivity());
                PaySortSettingActivity.this.onBackPressed();
            }
        });
        this.f25842d = (DragSortListView) findViewById(ResUtils.id(this, "listview_sort"));
        ((TextView) findViewById(ResUtils.id(this, "sort_title"))).setText("扣款方式");
        ((TextView) findViewById(ResUtils.id(this, "sort_desc"))).setText("按住右侧拖动以调整顺序");
        this.f25842d.setOverScrollMode(2);
        initListFoot();
    }

    @BindLayout("wallet_cashdesk_pay_sort_setting_item_view")
    /* loaded from: classes5.dex */
    public static class c extends BaseListAdapter.BaseViewHolder<PaySetResponse.PayInfoBean> {
        @bind("bd_wallet_paysort_item_img")

        /* renamed from: a  reason: collision with root package name */
        public NetImageView f25847a;
        @bind("ebpay_sort_tv")

        /* renamed from: b  reason: collision with root package name */
        public TextView f25848b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(PaySetResponse.PayInfoBean payInfoBean, int i2, Context context, BaseListAdapter<PaySetResponse.PayInfoBean> baseListAdapter) {
            if (TextUtils.equals(payInfoBean.pay_type, "easypay")) {
                a(payInfoBean);
            } else {
                a(payInfoBean, context);
            }
        }

        public void a(PaySetResponse.PayInfoBean payInfoBean) {
            String str = payInfoBean.account_no;
            String substring = str.substring(str.length() - 4);
            String str2 = payInfoBean.type_name;
            if (TextUtils.isEmpty(str2)) {
                str2 = ResUtils.getString(this.f25847a.getContext(), payInfoBean.card_type == 1 ? "wallet_base_mode_credit" : "wallet_base_mode_debit");
            }
            this.f25848b.setText(CardData.BondCard.getCardDesc(payInfoBean.name, substring, str2, true));
            this.f25847a.setImageUrl(payInfoBean.bank_url);
        }

        public void a(PaySetResponse.PayInfoBean payInfoBean, Context context) {
            this.f25847a.setImageResource(ResUtils.drawable(context, "wallet_base_paytype_balance"));
            this.f25847a.setImageUrl("no");
            this.f25848b.setText("余额");
        }
    }
}

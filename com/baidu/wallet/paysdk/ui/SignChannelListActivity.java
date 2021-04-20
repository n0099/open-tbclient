package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.af;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.SignBank;
import com.baidu.wallet.paysdk.datamodel.SignChannelResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class SignChannelListActivity extends PayBaseBeanActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public BankPageAdapter f25935a;

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f25936b;

    /* renamed from: d  reason: collision with root package name */
    public ListView f25938d;

    /* renamed from: e  reason: collision with root package name */
    public ListView f25939e;
    public Activity j;
    public BankListAdapter k;
    public BankListAdapter l;
    public BindFastRequest m;
    public af n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public ViewGroup s;
    public ViewGroup t;
    public View u;
    public View v;
    public TableLayout w;

    /* renamed from: c  reason: collision with root package name */
    public List<View> f25937c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<SignBank> f25940f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<SignBank> f25941g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public String f25942h = "0";
    public boolean i = false;

    /* loaded from: classes5.dex */
    public class BankListAdapter extends BaseAdapter implements SectionIndexer, NoProguard {

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f25944b;

        /* renamed from: c  reason: collision with root package name */
        public List<SignBank> f25945c;

        /* loaded from: classes5.dex */
        public class a {

            /* renamed from: b  reason: collision with root package name */
            public LinearLayout f25949b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f25950c;

            /* renamed from: d  reason: collision with root package name */
            public RelativeLayout f25951d;

            /* renamed from: e  reason: collision with root package name */
            public NetImageView f25952e;

            /* renamed from: f  reason: collision with root package name */
            public TextView f25953f;

            public a() {
            }
        }

        public BankListAdapter(List<SignBank> list) {
            this.f25945c = list;
            this.f25944b = LayoutInflater.from(SignChannelListActivity.this.j);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<SignBank> list = this.f25945c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (i < this.f25945c.size()) {
                return this.f25945c.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int i) {
            return -1;
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int i) {
            return 0;
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return null;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null || view.getTag() == null) {
                view = this.f25944b.inflate(ResUtils.layout(SignChannelListActivity.this.j, "wallet_cashdesk_sign_bank_info"), (ViewGroup) null);
                aVar = new a();
                aVar.f25949b = (LinearLayout) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_item_title_layout"));
                aVar.f25950c = (TextView) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "item_title"));
                aVar.f25952e = (NetImageView) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_logo"));
                aVar.f25953f = (TextView) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_name"));
                aVar.f25951d = (RelativeLayout) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_item_layout"));
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.f25951d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.SignChannelListActivity.BankListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (i >= BankListAdapter.this.f25945c.size() || !SignChannelListActivity.this.i) {
                        return;
                    }
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.SDK_FRONTPAGE_IDAUTH_TYPE_CHOICK_BANK, SignChannelListActivity.this.f25936b.getCurrentItem() == 0 ? "1" : "2");
                    SignChannelListActivity.this.m.setSubBankCode(((SignBank) BankListAdapter.this.f25945c.get(i)).bank_code);
                    Intent intent = SignChannelListActivity.this.getIntent();
                    if (intent == null) {
                        intent = new Intent();
                    }
                    intent.putExtra("subbankcode", ((SignBank) BankListAdapter.this.f25945c.get(i)).bank_code);
                    SignChannelListActivity.this.setResult(-1, intent);
                    SignChannelListActivity.this.finish();
                }
            });
            if (i == getPositionForSection(getSectionForPosition(i))) {
                aVar.f25949b.setVisibility(0);
            } else {
                aVar.f25949b.setVisibility(8);
            }
            aVar.f25952e.setVisibility(0);
            aVar.f25952e.setImageResource(ResUtils.drawable(SignChannelListActivity.this.j, "wallet_base_banklogo_defult"));
            aVar.f25952e.setImageUrl(this.f25945c.get(i).bank_url);
            aVar.f25953f.setText(this.f25945c.get(i).bank_name);
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class BankPageAdapter extends PagerAdapter implements NoProguard {
        public BankPageAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView((View) SignChannelListActivity.this.f25937c.get(i));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(View view) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return SignChannelListActivity.this.f25937c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i) {
            View view2 = (View) SignChannelListActivity.this.f25937c.get(i);
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            ((ViewPager) view).addView(view2);
            return view2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Parcelable saveState() {
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(View view) {
        }
    }

    /* loaded from: classes5.dex */
    public class GuidePageChangeListener implements ViewPager.OnPageChangeListener, NoProguard {
        public GuidePageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 0) {
                SignChannelListActivity.this.a(true);
            } else if (i != 1) {
            } else {
                SignChannelListActivity.this.a(false);
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void cancleRequest() {
        if (this.n != null) {
            BeanManager.getInstance().removeBean(this.n);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        WalletGlobalUtils.safeDismissDialog(this, -1);
        if (i == this.n.getBeanId()) {
            GlobalUtils.toast(this.j, str);
            finish();
            return;
        }
        super.handleFailure(i, i2, str);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        SignBank[] signBankArr;
        SignBank[] signBankArr2;
        WalletGlobalUtils.safeDismissDialog(this, -1);
        if (i == this.n.getBeanId()) {
            this.f25937c.clear();
            this.f25935a.notifyDataSetChanged();
            SignChannelResponse signChannelResponse = (SignChannelResponse) obj;
            if (signChannelResponse != null && (signBankArr2 = signChannelResponse.arr_credit) != null && signBankArr2.length > 0) {
                this.f25937c.add(this.f25938d);
                this.f25940f.clear();
                this.f25940f.addAll(Arrays.asList(signChannelResponse.arr_credit));
                BankListAdapter bankListAdapter = this.k;
                if (bankListAdapter != null) {
                    bankListAdapter.notifyDataSetChanged();
                }
            }
            if (signChannelResponse != null && (signBankArr = signChannelResponse.arr_debit) != null && signBankArr.length > 0) {
                this.f25937c.add(this.f25939e);
                this.f25941g.clear();
                this.f25941g.addAll(Arrays.asList(signChannelResponse.arr_debit));
                BankListAdapter bankListAdapter2 = this.l;
                if (bankListAdapter2 != null) {
                    bankListAdapter2.notifyDataSetChanged();
                }
            }
            TableLayout tableLayout = this.w;
            if (tableLayout == null) {
                return;
            }
            tableLayout.setVisibility(0);
            this.f25936b.setVisibility(0);
            this.f25935a.notifyDataSetChanged();
            a(signChannelResponse);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.q) {
            this.f25936b.setCurrentItem(0);
        } else if (view == this.r) {
            this.f25936b.setCurrentItem(1);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.i = getIntent().getExtras().getBoolean("isSelectBank");
        }
        setFlagPaySdk();
        this.j = getActivity();
        c();
        a();
        b();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans("SignChannelListActivity");
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    private void b() {
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.m = bindFastRequest;
        if (bindFastRequest == null) {
            this.m = new BindFastRequest();
            PayRequestCache.getInstance().addBeanRequestToCache(PayRequestCache.BindCategory.Other.name(), this.m);
        }
        WalletGlobalUtils.safeShowDialog(this, -1, "");
        if (this.n == null) {
            this.n = (af) PayBeanFactory.getInstance().getBean((Context) this.j, 517, "SignChannelListActivity");
        }
        this.n.setResponseCallback(this);
        this.n.execBean();
    }

    private void c() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View inflate = layoutInflater.inflate(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_page"), (ViewGroup) null);
        this.o = inflate;
        this.f25938d = (ListView) inflate.findViewById(ResUtils.id(this.j, "bd_wallet_bank_listview"));
        View inflate2 = layoutInflater.inflate(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_page"), (ViewGroup) null);
        this.p = inflate2;
        this.f25939e = (ListView) inflate2.findViewById(ResUtils.id(this.j, "bd_wallet_bank_listview"));
        BankListAdapter bankListAdapter = new BankListAdapter(this.f25940f);
        this.k = bankListAdapter;
        this.f25938d.setAdapter((ListAdapter) bankListAdapter);
        BankListAdapter bankListAdapter2 = new BankListAdapter(this.f25941g);
        this.l = bankListAdapter2;
        this.f25939e.setAdapter((ListAdapter) bankListAdapter2);
    }

    private void a() {
        setContentView(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_list_activity"));
        initActionBar(this.i ? "bd_wallet_own_parent_banks" : "bd_wallet_own_support_banks");
        this.q = (TextView) findViewById(ResUtils.id(this.j, "bd_wallet_credit"));
        this.r = (TextView) findViewById(ResUtils.id(this.j, "bd_wallet_debit"));
        this.s = (ViewGroup) findViewById(ResUtils.id(this.j, "bd_wallet_first_tab"));
        this.t = (ViewGroup) findViewById(ResUtils.id(this.j, "bd_wallet_second_tab"));
        this.f25936b = (ViewPager) findViewById(ResUtils.id(this.j, "bd_wallet_viewPager"));
        this.u = findViewById(ResUtils.id(this.j, "bd_wallet_credit_tab"));
        this.v = findViewById(ResUtils.id(this.j, "bd_wallet_debit_tab"));
        this.w = (TableLayout) findViewById(ResUtils.id(this.j, "table_layout"));
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        BankPageAdapter bankPageAdapter = new BankPageAdapter();
        this.f25935a = bankPageAdapter;
        this.f25936b.setAdapter(bankPageAdapter);
        this.f25936b.setOnPageChangeListener(new GuidePageChangeListener());
    }

    private void b(boolean z) {
        if (z) {
            this.s.getChildAt(0).setVisibility(0);
            this.s.getChildAt(1).setVisibility(4);
            this.t.getChildAt(0).setVisibility(4);
            this.t.getChildAt(1).setVisibility(0);
            return;
        }
        this.s.getChildAt(0).setVisibility(4);
        this.s.getChildAt(1).setVisibility(0);
        this.t.getChildAt(0).setVisibility(0);
        this.t.getChildAt(1).setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.q.setTextColor(getResources().getColor(ResUtils.color(this.j, "wallet_base_mainColor")));
            this.r.setTextColor(getResources().getColor(ResUtils.color(this.j, "wallet_base_font_text3Color")));
            b(true);
            return;
        }
        this.q.setTextColor(getResources().getColor(ResUtils.color(this.j, "wallet_base_font_text3Color")));
        this.r.setTextColor(getResources().getColor(ResUtils.color(this.j, "wallet_base_mainColor")));
        b(false);
    }

    private void a(SignChannelResponse signChannelResponse) {
        if (signChannelResponse == null) {
            this.v.setVisibility(0);
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            b(true);
            this.f25936b.setCurrentItem(0);
            a(true);
            return;
        }
        SignBank[] signBankArr = signChannelResponse.arr_debit;
        if (signBankArr != null && signBankArr.length > 0) {
            this.v.setVisibility(0);
            this.t.setVisibility(0);
            b(true);
        } else {
            this.v.setVisibility(8);
            this.t.setVisibility(8);
            b(false);
        }
        SignBank[] signBankArr2 = signChannelResponse.arr_credit;
        if (signBankArr2 != null && signBankArr2.length > 0) {
            this.u.setVisibility(0);
            this.s.setVisibility(0);
            b(true);
        } else {
            b(false);
            this.u.setVisibility(8);
            this.s.setVisibility(8);
        }
        if (this.u.getVisibility() == 0) {
            this.f25936b.setCurrentItem(0);
            a(true);
            return;
        }
        this.f25936b.setCurrentItem(1);
        a(false);
    }
}

package com.baidu.wallet.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.internal.BindLayout;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.home.beans.HomeCfgBean;
import com.baidu.wallet.home.beans.WalletHomeBeanFactory;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.HomeDataCacheManager;
import com.baidu.wallet.home.ui.widget.BannerLayout;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.FinancingManageLayout;
import com.baidu.wallet.home.ui.widget.HomeInformationLayout;
import com.baidu.wallet.home.ui.widget.HomeRecommendView;
import com.baidu.wallet.home.ui.widget.LifeGridLayout;
import com.baidu.wallet.home.ui.widget.LifeSingleLineLayoutForType6;
import com.baidu.wallet.home.ui.widget.WalletHomeActionBar;
import com.baidu.wallet.home.ui.widget.credithome.CHBannerGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHBigCreditCardGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHCreditGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHFinanceEntryGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHFinanceProductGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHFinanceUserGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHLifeGridGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHMyCustomerGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHNoticeBarGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHToolGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHBannerGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditLongGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditMiniGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditPicGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHFooterView;
import com.baidu.wallet.home.ui.widget.newhome.NHHorListLayout;
import com.baidu.wallet.home.ui.widget.newhome.NHLifeGridLayout;
import com.baidu.wallet.home.ui.widget.newhome.NHSeperator;
import com.baidu.wallet.home.ui.widget.newhome.NHToolGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHGuideGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHHeadGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHNoticeBarGroup;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public class WalletNewHomeActivity extends BeanActivity {
    public static final String PAGE_TYPE = "pageType";

    /* renamed from: e  reason: collision with root package name */
    public static r f24271e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f24272f = "";

    /* renamed from: a  reason: collision with root package name */
    public ListView f24273a;

    /* renamed from: b  reason: collision with root package name */
    public ag f24274b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f24275c;

    /* renamed from: d  reason: collision with root package name */
    public NHFooterView f24276d;

    /* renamed from: i  reason: collision with root package name */
    public HomeCfgResponse f24279i;
    public WalletHomeActionBar j;

    /* renamed from: g  reason: collision with root package name */
    public final String f24277g = toString() + hashCode();

    /* renamed from: h  reason: collision with root package name */
    public String f24278h = HomeCfgBean.PAGE_HOME;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = true;

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class a extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public BannerLayout f24282a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24282a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            BannerLayout bannerLayout = new BannerLayout(context);
            this.f24282a = bannerLayout;
            return bannerLayout;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class aa extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHSeperator f24283a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24283a.setType(configData.getGroup_name());
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHSeperator nHSeperator = new NHSeperator(context);
            this.f24283a = nHSeperator;
            return nHSeperator;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ab extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHToolGroup f24284a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24284a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHToolGroup nHToolGroup = new NHToolGroup(context);
            this.f24284a = nHToolGroup;
            return nHToolGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ac extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public UMHBigCreditCardGroup f24285a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24285a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            UMHBigCreditCardGroup uMHBigCreditCardGroup = new UMHBigCreditCardGroup(context);
            this.f24285a = uMHBigCreditCardGroup;
            return uMHBigCreditCardGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ad extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public UMHGuideGroup f24286a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24286a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            UMHGuideGroup uMHGuideGroup = new UMHGuideGroup(context);
            this.f24286a = uMHGuideGroup;
            return uMHGuideGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ae extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public UMHHeadGroup f24287a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24287a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            UMHHeadGroup uMHHeadGroup = new UMHHeadGroup(context);
            this.f24287a = uMHHeadGroup;
            return uMHHeadGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class af extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public UMHNoticeBarGroup f24288a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24288a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            UMHNoticeBarGroup uMHNoticeBarGroup = new UMHNoticeBarGroup(context);
            this.f24288a = uMHNoticeBarGroup;
            return uMHNoticeBarGroup;
        }
    }

    /* loaded from: classes5.dex */
    public static class ag extends BaseListAdapter<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public int f24289a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f24290b;

        public ag(Context context) {
            super(context);
            this.f24289a = 0;
            this.f24290b = new Handler();
        }

        public ViewGroup a() {
            return this.mParent;
        }

        public void b() {
            this.f24290b.post(new Runnable() { // from class: com.baidu.wallet.home.WalletNewHomeActivity.ag.1
                @Override // java.lang.Runnable
                public void run() {
                    ag.this.notifyDataSetChanged();
                }
            });
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public int getItemTrueType(int i2) {
            char c2;
            String str = getItem(i2).group_layout;
            int hashCode = str.hashCode();
            if (hashCode == 48625) {
                if (str.equals("100")) {
                    c2 = 15;
                }
                c2 = 65535;
            } else if (hashCode == 49617) {
                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE210)) {
                    c2 = 19;
                }
                c2 = 65535;
            } else if (hashCode != 52500) {
                switch (hashCode) {
                    case 49:
                        if (str.equals("1")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 52:
                        if (str.equals("4")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 53:
                        if (str.equals("5")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 54:
                        if (str.equals("6")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 55:
                        if (str.equals("7")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 56:
                        if (str.equals("8")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 57:
                        if (str.equals("9")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        switch (hashCode) {
                            case 49587:
                                if (str.equals("201")) {
                                    c2 = '\t';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49588:
                                if (str.equals("202")) {
                                    c2 = '\n';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49589:
                                if (str.equals("203")) {
                                    c2 = 11;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49590:
                                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204)) {
                                    c2 = '\f';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49591:
                                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE205)) {
                                    c2 = '\r';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49592:
                                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206)) {
                                    c2 = 14;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49593:
                                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE207)) {
                                    c2 = 16;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49594:
                                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE208)) {
                                    c2 = 17;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 49595:
                                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE209)) {
                                    c2 = 18;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                switch (hashCode) {
                                    case 52470:
                                        if (str.equals("501")) {
                                            c2 = 20;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52471:
                                        if (str.equals("502")) {
                                            c2 = 21;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52472:
                                        if (str.equals("503")) {
                                            c2 = 22;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52473:
                                        if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE504)) {
                                            c2 = 23;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52474:
                                        if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE505)) {
                                            c2 = 24;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52475:
                                        if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE506)) {
                                            c2 = 25;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52476:
                                        if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE507)) {
                                            c2 = JSONLexer.EOI;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52477:
                                        if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE508)) {
                                            c2 = 27;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 52478:
                                        if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE509)) {
                                            c2 = DecodedBitStreamParser.FS;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 53431:
                                                if (str.equals("601")) {
                                                    c2 = DecodedBitStreamParser.RS;
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 53432:
                                                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
                                                    c2 = 31;
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 53433:
                                                if (str.equals("603")) {
                                                    c2 = ' ';
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 53434:
                                                if (str.equals("604")) {
                                                    c2 = '!';
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 53435:
                                                if (str.equals("605")) {
                                                    c2 = Typography.quote;
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 53436:
                                                if (str.equals("606")) {
                                                    c2 = '#';
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            default:
                                                c2 = 65535;
                                                break;
                                        }
                                }
                        }
                }
            } else {
                if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE510)) {
                    c2 = DecodedBitStreamParser.GS;
                }
                c2 = 65535;
            }
            switch (c2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case '\b':
                    return 8;
                case '\t':
                    return 9;
                case '\n':
                    return 10;
                case 11:
                    return 11;
                case '\f':
                    return 12;
                case '\r':
                    return 13;
                case 14:
                    return 14;
                case 15:
                    return 15;
                case 16:
                    return 12;
                case 17:
                    return 16;
                case 18:
                    return 17;
                case 19:
                    return 18;
                case 20:
                    return 19;
                case 21:
                    return 20;
                case 22:
                    return 21;
                case 23:
                    return 22;
                case 24:
                    return 23;
                case 25:
                    return 24;
                case 26:
                    return 25;
                case 27:
                    return 26;
                case 28:
                    return 27;
                case 29:
                    return 28;
                case 30:
                    return 29;
                case 31:
                    return 30;
                case ' ':
                    return 31;
                case '!':
                    return 32;
                case '\"':
                    return 33;
                case '#':
                    return 34;
                default:
                    return 0;
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter, android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            int itemTrueType = (i2 * 100) + getItemTrueType(i2);
            if (getViewTypeCount() > itemTrueType) {
                return itemTrueType;
            }
            return 0;
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter, android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 10100;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            this.f24289a++;
            super.notifyDataSetChanged();
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public void onBindViewHolder(List<Class<?>> list) {
            list.add(l.class);
            list.add(l.class);
            list.add(p.class);
            list.add(l.class);
            list.add(a.class);
            list.add(q.class);
            list.add(m.class);
            list.add(o.class);
            list.add(n.class);
            list.add(s.class);
            list.add(ab.class);
            list.add(t.class);
            list.add(x.class);
            list.add(y.class);
            list.add(z.class);
            list.add(aa.class);
            list.add(u.class);
            list.add(w.class);
            list.add(v.class);
            list.add(k.class);
            list.add(c.class);
            list.add(j.class);
            list.add(b.class);
            list.add(d.class);
            list.add(g.class);
            list.add(e.class);
            list.add(f.class);
            list.add(h.class);
            list.add(i.class);
            list.add(ae.class);
            list.add(af.class);
            list.add(ac.class);
            list.add(ac.class);
            list.add(b.class);
            list.add(ad.class);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public boolean useItemTrueType() {
            return true;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class b extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHBannerGroup f24292a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24292a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHBannerGroup cHBannerGroup = new CHBannerGroup(context);
            this.f24292a = cHBannerGroup;
            return cHBannerGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class c extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHBigCreditCardGroup f24293a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24293a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHBigCreditCardGroup cHBigCreditCardGroup = new CHBigCreditCardGroup(context);
            this.f24293a = cHBigCreditCardGroup;
            return cHBigCreditCardGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class d extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHCreditGroup f24294a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24294a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHCreditGroup cHCreditGroup = new CHCreditGroup(context);
            this.f24294a = cHCreditGroup;
            return cHCreditGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class e extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHFinanceEntryGroup f24295a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24295a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHFinanceEntryGroup cHFinanceEntryGroup = new CHFinanceEntryGroup(context);
            this.f24295a = cHFinanceEntryGroup;
            return cHFinanceEntryGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class f extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHFinanceProductGroup f24296a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24296a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHFinanceProductGroup cHFinanceProductGroup = new CHFinanceProductGroup(context);
            this.f24296a = cHFinanceProductGroup;
            return cHFinanceProductGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class g extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHFinanceUserGroup f24297a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24297a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHFinanceUserGroup cHFinanceUserGroup = new CHFinanceUserGroup(context);
            this.f24297a = cHFinanceUserGroup;
            return cHFinanceUserGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class h extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHLifeGridGroup f24298a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24298a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHLifeGridGroup cHLifeGridGroup = new CHLifeGridGroup(context);
            this.f24298a = cHLifeGridGroup;
            return cHLifeGridGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class i extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHMyCustomerGroup f24299a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24299a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHMyCustomerGroup cHMyCustomerGroup = new CHMyCustomerGroup(context);
            this.f24299a = cHMyCustomerGroup;
            return cHMyCustomerGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class j extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHNoticeBarGroup f24300a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24300a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHNoticeBarGroup cHNoticeBarGroup = new CHNoticeBarGroup(context);
            this.f24300a = cHNoticeBarGroup;
            return cHNoticeBarGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class k extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public CHToolGroup f24301a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24301a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            CHToolGroup cHToolGroup = new CHToolGroup(context);
            this.f24301a = cHToolGroup;
            return cHToolGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class l extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public View f24302a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            View view = new View(context);
            this.f24302a = view;
            return view;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class m extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public FinancingManageLayout f24303a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24303a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            FinancingManageLayout financingManageLayout = new FinancingManageLayout(context);
            this.f24303a = financingManageLayout;
            return financingManageLayout;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class n extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public HomeInformationLayout f24304a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24304a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            HomeInformationLayout homeInformationLayout = new HomeInformationLayout(context);
            this.f24304a = homeInformationLayout;
            return homeInformationLayout;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class o extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public HomeRecommendView f24305a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24305a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            HomeRecommendView homeRecommendView = new HomeRecommendView(context);
            this.f24305a = homeRecommendView;
            return homeRecommendView;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class p extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public LifeGridLayout f24306a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24306a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            LifeGridLayout lifeGridLayout = new LifeGridLayout(context);
            this.f24306a = lifeGridLayout;
            return lifeGridLayout;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class q extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public LifeSingleLineLayoutForType6 f24307a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24307a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            LifeSingleLineLayoutForType6 lifeSingleLineLayoutForType6 = new LifeSingleLineLayoutForType6(context);
            this.f24307a = lifeSingleLineLayoutForType6;
            return lifeSingleLineLayoutForType6;
        }
    }

    /* loaded from: classes5.dex */
    public static class r implements com.baidu.wallet.home.ui.widget.b {

        /* renamed from: a  reason: collision with root package name */
        public ag f24308a;

        /* renamed from: b  reason: collision with root package name */
        public HomeCfgResponse f24309b;

        /* renamed from: c  reason: collision with root package name */
        public Context f24310c;

        /* renamed from: d  reason: collision with root package name */
        public WeakReference<Activity> f24311d;

        /* renamed from: e  reason: collision with root package name */
        public String f24312e;

        public r(Activity activity, ag agVar, String str) {
            this.f24312e = str;
            this.f24310c = activity.getApplicationContext();
            this.f24311d = new WeakReference<>(activity);
            this.f24308a = agVar;
        }

        public void a(HomeCfgResponse homeCfgResponse) {
            this.f24309b = homeCfgResponse;
            com.baidu.wallet.home.a.a().a(this.f24309b.abtype);
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public String getAndroidPrefix() {
            return TextUtils.isEmpty(this.f24309b.android_prefix) ? "" : this.f24309b.android_prefix;
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public String getPageType() {
            return this.f24312e;
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public boolean isLoginData() {
            return this.f24309b.isLogin();
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void jump(String str, String str2, String str3, boolean z) {
            WeakReference<Activity> weakReference = this.f24311d;
            com.baidu.wallet.home.a.a().a((weakReference == null || weakReference.get() == null) ? this.f24310c : this.f24311d.get(), str, str2, str3, z, this.f24312e);
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void login() {
            WalletLoginHelper.getInstance().setIntervalDuration(0L);
            WalletLoginHelper.getInstance().onlyLogin(new LoginBackListenerProxy(this.f24310c, new ILoginBackListener() { // from class: com.baidu.wallet.home.WalletNewHomeActivity.r.1
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    if (i2 == 603) {
                        r.this.login();
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                }
            }));
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void onEyeMaskBtnClick() {
            boolean z = !com.baidu.wallet.home.storage.a.a(this.f24310c);
            com.baidu.wallet.home.storage.a.a(this.f24310c, z);
            String str = com.baidu.wallet.home.a.a.f24326a;
            String[] strArr = new String[1];
            strArr[0] = z ? "true" : "false";
            DXMSdkSAUtils.onEventWithValues(str, Arrays.asList(strArr));
            PayStatisticsUtil.onEventWithValue(com.baidu.wallet.home.a.a.f24326a, z ? "true" : "false");
            ag agVar = this.f24308a;
            if (agVar != null) {
                ListView listView = (ListView) agVar.a();
                for (int i2 = 0; i2 < listView.getChildCount(); i2++) {
                    if (listView.getChildAt(i2) instanceof BaseItemLayout) {
                        ((BaseItemLayout) listView.getChildAt(i2)).onEyeMaskChanged();
                    }
                }
                this.f24308a.b();
            }
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void onPointShowChanged() {
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class s extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHAssetGroup f24314a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24314a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHAssetGroup nHAssetGroup = new NHAssetGroup(context);
            this.f24314a = nHAssetGroup;
            return nHAssetGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class t extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHBannerGroup f24315a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24315a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHBannerGroup nHBannerGroup = new NHBannerGroup(context);
            this.f24315a = nHBannerGroup;
            return nHBannerGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class u extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHCreditLongGroup f24316a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24316a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHCreditLongGroup nHCreditLongGroup = new NHCreditLongGroup(context);
            this.f24316a = nHCreditLongGroup;
            return nHCreditLongGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class v extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHCreditMiniGroup f24317a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24317a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHCreditMiniGroup nHCreditMiniGroup = new NHCreditMiniGroup(context);
            this.f24317a = nHCreditMiniGroup;
            return nHCreditMiniGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class w extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHCreditPicGroup f24318a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24318a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHCreditPicGroup nHCreditPicGroup = new NHCreditPicGroup(context);
            this.f24318a = nHCreditPicGroup;
            return nHCreditPicGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class x extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHCreditGroup f24319a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24319a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHCreditGroup nHCreditGroup = new NHCreditGroup(context);
            this.f24319a = nHCreditGroup;
            return nHCreditGroup;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class y extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHHorListLayout f24320a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24320a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHHorListLayout nHHorListLayout = new NHHorListLayout(context);
            this.f24320a = nHHorListLayout;
            return nHHorListLayout;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class z extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {

        /* renamed from: a  reason: collision with root package name */
        public NHLifeGridLayout f24321a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            this.f24321a.setConfigData(configData, WalletNewHomeActivity.f24271e);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            NHLifeGridLayout nHLifeGridLayout = new NHLifeGridLayout(context);
            this.f24321a = nHLifeGridLayout;
            return nHLifeGridLayout;
        }
    }

    private void a() {
        initHomeActionBar("dxm_finance_brand");
        this.j = (WalletHomeActionBar) findViewById(ResUtils.id(this.mAct, "bdactionbar"));
        if (HomeCfgBean.PAGE_CREDIT.equals(this.f24278h)) {
            this.j.setRightImgZone1Visibility(4);
        }
    }

    private void b() {
        this.m = false;
        HomeCfgResponse responseFromCache = HomeDataCacheManager.getInstance().getResponseFromCache(this.mAct, this.f24278h);
        if (responseFromCache != null && responseFromCache.doCheckValidity()) {
            this.f24279i = responseFromCache;
            this.m = true;
            c();
            d();
            return;
        }
        d();
    }

    private void c() {
        if (this.m) {
            this.m = false;
            if (this.l) {
                this.l = false;
                return;
            }
        }
        HomeCfgResponse homeCfgResponse = this.f24279i;
        if (homeCfgResponse == null || !homeCfgResponse.doCheckValidity()) {
            this.f24279i = HomeDataCacheManager.getInstance().getResponseFromAsset(this.mAct, this.f24278h);
        }
        HomeCfgResponse homeCfgResponse2 = this.f24279i;
        if (homeCfgResponse2 == null || !homeCfgResponse2.doCheckValidity()) {
            return;
        }
        r rVar = f24271e;
        if (rVar != null) {
            rVar.a(this.f24279i);
        }
        this.f24275c.setBackgroundColor(ResUtils.getColor(this, "5".equals(this.f24279i.version) ? "wallet_home_nh_whiteColor" : "wallet_extend_home_nh_separate_bright"));
        WalletHomeActionBar walletHomeActionBar = this.j;
        BeanActivity beanActivity = this.mAct;
        HomeCfgResponse homeCfgResponse3 = this.f24279i;
        walletHomeActionBar.toRefreshTitleBar(beanActivity, homeCfgResponse3.android_prefix, homeCfgResponse3.layout_title, this.f24278h);
        HomeCfgResponse.ConfigData[] a2 = com.baidu.wallet.home.ui.widget.newhome.a.a(this.f24279i);
        this.f24274b.initList(Arrays.asList(a2));
        a(this.f24279i, a2);
    }

    private void d() {
        this.l = false;
        HomeCfgBean homeCfgBean = (HomeCfgBean) WalletHomeBeanFactory.getInstance().getBean((Context) this.mAct, WalletHomeBeanFactory.BEAN_ID_HOME_CFG, this.f24277g);
        homeCfgBean.setAbtypeHomePage(true);
        HomeCfgResponse homeCfgResponse = this.f24279i;
        if (homeCfgResponse != null) {
            HomeCfgResponse.AllConfig allConfig = homeCfgResponse.layout_content;
            if (allConfig != null && !TextUtils.isEmpty(allConfig.fingerprint)) {
                homeCfgBean.setAllFingerPrint(this.f24279i.layout_content.fingerprint);
            } else {
                homeCfgBean.setAllFingerPrint(null);
            }
            HomeCfgResponse.TitleConfig titleConfig = this.f24279i.layout_title;
            if (titleConfig != null && !TextUtils.isEmpty(titleConfig.fingerprint)) {
                homeCfgBean.setTitleFingerPrint(this.f24279i.layout_title.fingerprint);
            } else {
                homeCfgBean.setTitleFingerPrint(null);
            }
            HomeCfgResponse.FooterConfig footerConfig = this.f24279i.layout_footer;
            if (footerConfig != null && !TextUtils.isEmpty(footerConfig.fingerprint)) {
                homeCfgBean.setFooterFingerPrint(this.f24279i.layout_footer.fingerprint);
            } else {
                homeCfgBean.setFooterFingerPrint(null);
            }
            if (this.f24279i.doCheckValidity() && !TextUtils.isEmpty(this.f24279i.changedSign)) {
                homeCfgBean.setChangeSign(this.f24279i.changedSign);
            } else {
                homeCfgBean.setChangeSign(null);
            }
        }
        homeCfgBean.setPageId(TextUtils.isEmpty(this.f24278h) ? HomeCfgBean.PAGE_HOME : this.f24278h);
        homeCfgBean.setResponseCallback(this);
        homeCfgBean.execBean();
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i3 == -8) {
            if (!this.k) {
                BeanActivity beanActivity = this.mAct;
                GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "ebpay_no_network"));
            }
        } else if (i3 == 5003) {
            if (!this.k) {
                if (WalletLoginHelper.getInstance().isPassLogin()) {
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                    AccountManager.getInstance(getActivity()).logout();
                    WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(this, new ILoginBackListener() { // from class: com.baidu.wallet.home.WalletNewHomeActivity.1
                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onFail(int i4, String str2) {
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onSuccess(int i4, String str2) {
                        }
                    }));
                }
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_please_login"));
            }
        } else if (!ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.mAct.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener() { // from class: com.baidu.wallet.home.WalletNewHomeActivity.2
            @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
            public void onCallFail(int i4, String str2) {
                WalletNewHomeActivity.this.mAct.finish();
            }

            @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
            public void onCallSuccess(int i4, String str2) {
            }
        })) {
            if (!TextUtils.isEmpty(str)) {
                if (!this.k) {
                    GlobalUtils.toast(this.mAct, str);
                }
            } else if (!this.k) {
                super.handleFailure(i2, i3, str);
            }
        }
        this.k = true;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        this.k = true;
        if (obj == null || !(obj instanceof HomeCfgResponse)) {
            return;
        }
        HomeCfgResponse homeCfgResponse = (HomeCfgResponse) obj;
        if (homeCfgResponse.doCheckValidity()) {
            this.f24279i = homeCfgResponse;
            if (!homeCfgResponse.isLogin()) {
                AccountManager.getInstance(getActivity()).logout();
            }
            this.f24279i.doStoreResponse(this.mAct, this.f24278h);
            c();
            this.l = true;
        }
    }

    public void initViews() {
        this.f24275c = (LinearLayout) findViewById(ResUtils.id(this, "homerootview"));
        this.f24273a = (ListView) findViewById(ResUtils.id(this, "listview"));
        ag agVar = new ag(this);
        this.f24274b = agVar;
        this.f24273a.setAdapter((ListAdapter) agVar);
        this.f24273a.setBackgroundColor(ResUtils.getColor(this, "bd_wallet_white"));
        f24272f = this.f24277g;
        f24271e = new r(getActivity(), this.f24274b, this.f24278h);
        a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.baidu.wallet.home.ui.widget.newhome.NHSeperator */
    /* JADX WARN: Multi-variable type inference failed */
    public int measureHomeLayout(Context context, HomeCfgResponse.ConfigData[] configDataArr, com.baidu.wallet.home.ui.widget.b bVar) {
        BaseItemLayout baseItemLayout;
        int displayHeight = DisplayUtils.getDisplayHeight(context) - DisplayUtils.dip2px(context, ((BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID) ? 38.0f : 50.0f) + 0.0f) + 20.0f);
        int i2 = 0;
        for (int i3 = 0; i3 < configDataArr.length; i3++) {
            if (configDataArr[i3].getGroup_layout().equals("100")) {
                NHSeperator nHSeperator = new NHSeperator(context);
                nHSeperator.setType(configDataArr[i3].getGroup_name());
                baseItemLayout = nHSeperator;
            } else {
                BaseItemLayout a2 = com.baidu.wallet.home.ui.widget.a.a().a(context, configDataArr[i3], null);
                baseItemLayout = a2;
                if (a2 != null) {
                    a2.setConfigData(configDataArr[i3], bVar);
                    baseItemLayout = a2;
                }
            }
            if (baseItemLayout != null) {
                com.baidu.wallet.home.ui.a.a(baseItemLayout);
                i2 += baseItemLayout.getMeasuredHeight();
            }
            if (i2 >= displayHeight) {
                return 0;
            }
        }
        return displayHeight - i2;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = false;
        this.m = false;
        this.n = true;
        String string = getIntent().getExtras().getString("pageType");
        if (!TextUtils.isEmpty(string)) {
            this.f24278h = string;
        }
        getActivity().getWindow().setSoftInputMode(3);
        setContentView(ResUtils.layout(this.mAct, "wallet_home_main_new"));
        initViews();
        b();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(this.f24277g);
        if (f24272f.equals(this.f24277g)) {
            f24271e = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String string = intent.getExtras().getString("pageType");
        if (!TextUtils.isEmpty(string)) {
            this.f24278h = string;
        }
        this.l = false;
        this.m = false;
        this.n = true;
        b();
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.n) {
            this.n = false;
            return;
        }
        HomeDataCacheManager.getInstance().synPPkey(this.mAct);
        d();
    }

    private void a(HomeCfgResponse homeCfgResponse, HomeCfgResponse.ConfigData[] configDataArr) {
        if (homeCfgResponse.layout_footer != null && this.f24276d == null) {
            NHFooterView nHFooterView = new NHFooterView(this);
            this.f24276d = nHFooterView;
            this.f24273a.addFooterView(nHFooterView);
        }
        if (this.f24276d != null) {
            r rVar = f24271e;
            this.f24276d.setData(homeCfgResponse, f24271e, rVar == null ? 0 : measureHomeLayout(this, configDataArr, rVar));
        }
    }
}

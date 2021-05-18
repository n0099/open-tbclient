package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
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
import com.baidu.wallet.home.ui.widget.newhome.NHHorListLayout;
import com.baidu.wallet.home.ui.widget.newhome.NHLifeGridLayout;
import com.baidu.wallet.home.ui.widget.newhome.NHToolGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHGuideGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHHeadGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHNoticeBarGroup;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: com.baidu.wallet.home.ui.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0235a {

        /* renamed from: a  reason: collision with root package name */
        public static a f24312a = new a();
    }

    public static a a() {
        return C0235a.f24312a;
    }

    public a() {
    }

    public BaseItemLayout a(Context context, HomeCfgResponse.ConfigData configData, String str) {
        if (configData == null || TextUtils.isEmpty(configData.group_layout) || configData.group_layout.equals("1") || configData.group_layout.equals("2")) {
            return null;
        }
        if (configData.group_layout.equals("3")) {
            return new LifeGridLayout(context);
        }
        if (configData.group_layout.equals("4")) {
            return null;
        }
        if (configData.group_layout.equals("5")) {
            return new BannerLayout(context);
        }
        if (configData.group_layout.equals("6")) {
            return new LifeSingleLineLayoutForType6(context);
        }
        if (configData.group_layout.equals("7")) {
            return new FinancingManageLayout(context);
        }
        if (configData.group_layout.equals("8")) {
            return new HomeRecommendView(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9)) {
            return new HomeInformationLayout(context);
        }
        if (configData.group_layout.equals("201")) {
            return new NHAssetGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE202)) {
            return new NHToolGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE203)) {
            return new NHBannerGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204)) {
            return new NHCreditGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE205)) {
            return new NHHorListLayout(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206)) {
            return new NHLifeGridLayout(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE207)) {
            return new NHCreditGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE208)) {
            return new NHCreditLongGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE209)) {
            return new NHCreditPicGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE210)) {
            return new NHCreditMiniGroup(context);
        }
        if (configData.group_layout.equals("501")) {
            return new CHToolGroup(context);
        }
        if (configData.group_layout.equals("502")) {
            return new CHBigCreditCardGroup(context);
        }
        if (configData.group_layout.equals("503")) {
            return new CHNoticeBarGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE504)) {
            return new CHBannerGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE505)) {
            return new CHCreditGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE506)) {
            return new CHFinanceUserGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE507)) {
            return new CHFinanceEntryGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE508)) {
            return new CHFinanceProductGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE509)) {
            return new CHLifeGridGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE510)) {
            return new CHMyCustomerGroup(context);
        }
        if (configData.group_layout.equals("601")) {
            return new UMHHeadGroup(context);
        }
        if (configData.group_layout.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
            return new UMHNoticeBarGroup(context);
        }
        if (configData.group_layout.equals("603")) {
            return new UMHBigCreditCardGroup(context);
        }
        if (configData.group_layout.equals("604")) {
            return new UMHBigCreditCardGroup(context);
        }
        if (configData.group_layout.equals("605")) {
            return new CHBannerGroup(context);
        }
        if (configData.group_layout.equals("606")) {
            return new UMHGuideGroup(context);
        }
        return null;
    }
}

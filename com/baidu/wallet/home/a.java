package com.baidu.wallet.home;

import android.content.Context;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.baidu.wallet.home.beans.HomeCfgBean;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f24963a;

    /* renamed from: com.baidu.wallet.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0247a {

        /* renamed from: a  reason: collision with root package name */
        public static a f24966a = new a();
    }

    public a() {
        this.f24963a = "";
    }

    public static a a() {
        return C0247a.f24966a;
    }

    public void a(String str) {
        if (str == null) {
            str = "";
        }
        this.f24963a = str;
    }

    public void a(Context context, String str, String str2, String str3, boolean z, String str4) {
        final String str5;
        if (HomeCfgBean.PAGE_FINANCE.equals(str4)) {
            str5 = "clickTabHomePageItem";
        } else {
            str5 = HomeCfgBean.PAGE_CREDIT.equals(str4) ? "clickCreditHomePageItem" : "clickHomePageItem";
        }
        SDKJumpManager.getInstance().doSDKJump(context, str, str2, str3, z, new SDKJumpManager.OnJumpListener() { // from class: com.baidu.wallet.home.a.1
            @Override // com.baidu.wallet.base.widget.SDKJumpManager.OnJumpListener
            public void beforeJump(Context context2, String str6, String str7, String str8, boolean z2) {
                DXMSdkSAUtils.onEventWithValues(str5, Arrays.asList(str6, str7, str8, a.this.f24963a));
                PayStatisticsUtil.onEventWithValues(str5, Arrays.asList(str6, str7, str8, a.this.f24963a));
            }
        });
    }
}

package com.baidu.wallet.home.ui.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.beans.HomeCfgBean;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f24227a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.home.ui.a.a f24228b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24229c = false;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.TitleConfig f24230d;

    public a(com.baidu.wallet.home.ui.a.a aVar) {
        this.f24228b = aVar;
    }

    private void b(Context context, HomeCfgResponse.TitleItemData titleItemData) {
        com.baidu.wallet.home.ui.a.a aVar = this.f24228b;
        if (aVar != null) {
            aVar.refreshRightZoneDot(a(context, titleItemData));
        }
    }

    public void a(Context context, String str, HomeCfgResponse.TitleConfig titleConfig, String str2) {
        HomeCfgResponse.TitleItem[] titleItemArr;
        this.f24227a = str2;
        com.baidu.wallet.home.ui.a.a aVar = this.f24228b;
        if (aVar == null) {
            return;
        }
        if (titleConfig != null && (titleItemArr = titleConfig.data) != null && titleItemArr.length > 0) {
            aVar.refreshRightZoneDot(false);
            this.f24230d = titleConfig;
            if (!TextUtils.isEmpty(titleConfig.data[0].titlebar)) {
                this.f24228b.refreshTitle(titleConfig.data[0].titlebar);
            }
            this.f24228b.refreshSafeTip(titleConfig.data[0].safe_title);
            HomeCfgResponse.TitleItem[] titleItemArr2 = titleConfig.data;
            if (titleItemArr2[0].list != null && titleItemArr2[0].list.length >= 1) {
                if (titleItemArr2[0].list.length > 1) {
                    this.f24229c = true;
                    this.f24228b.refreshRightZone(ResUtils.drawable(context, "wallet_base_actionbar_more"));
                    this.f24228b.refreshMenu(str, titleConfig.data[0].list, this.f24227a);
                    return;
                } else if (titleItemArr2[0].list.length == 1) {
                    HomeCfgResponse.TitleItemData titleItemData = titleItemArr2[0].list[0];
                    if (titleItemData != null && !TextUtils.isEmpty(titleItemData.setting_addr) && !TextUtils.isEmpty(titleItemData.setting_type)) {
                        this.f24228b.refreshRightZone(ResUtils.drawable(context, a(this.f24227a)));
                        b(context, titleItemData);
                        this.f24229c = false;
                        String str3 = titleConfig.data[0].list[0].setting_icon;
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        this.f24228b.refreshRightZone(str + str3);
                        return;
                    }
                    this.f24228b.hideRightZone();
                    return;
                } else {
                    return;
                }
            }
            this.f24228b.hideRightZone();
            return;
        }
        this.f24228b.hideRightZone();
    }

    public void a(Context context) {
        if (this.f24229c) {
            com.baidu.wallet.home.ui.a.a aVar = this.f24228b;
            if (aVar != null) {
                aVar.showMenu();
            }
        } else if (this.f24230d.checkTitleConfig()) {
            HomeCfgResponse.TitleItem[] titleItemArr = this.f24230d.data;
            if (titleItemArr[0].list == null || titleItemArr[0].list.length <= 0 || titleItemArr[0].list[0] == null || TextUtils.isEmpty(titleItemArr[0].list[0].setting_addr)) {
                return;
            }
            HomeCfgResponse.TitleItemData titleItemData = this.f24230d.data[0].list[0];
            if (a(context, titleItemData)) {
                if (!TextUtils.isEmpty(titleItemData.getLinkAddr())) {
                    com.baidu.wallet.home.storage.a.a(context, titleItemData.getLinkAddr(), TextUtils.isEmpty(titleItemData.getTimeStamp()) ? "0" : titleItemData.getTimeStamp());
                }
                b(context, titleItemData);
            }
            com.baidu.wallet.home.a.a().a(context, titleItemData.setting_name, titleItemData.setting_type, titleItemData.setting_addr, false, this.f24227a);
        }
    }

    public boolean a(Context context, HomeCfgResponse.TitleItemData titleItemData) {
        return titleItemData != null && ("2".equalsIgnoreCase(titleItemData.timestamp_icon) || "1".equalsIgnoreCase(titleItemData.timestamp_icon)) && titleItemData.isShoudShowPoint(context);
    }

    private String a(String str) {
        return HomeCfgBean.PAGE_FINANCE.equals(str) ? "wallet_home_go_wallet_logo" : "wallet_home_go_security_center";
    }
}

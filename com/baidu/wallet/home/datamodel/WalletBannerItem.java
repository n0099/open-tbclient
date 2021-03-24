package com.baidu.wallet.home.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.home.storage.a;
/* loaded from: classes5.dex */
public abstract class WalletBannerItem extends BannerBaseItemInfo {
    public abstract String getCornerAddr();

    public long getNum(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public abstract String getTimeStamp();

    public abstract String getTimeStampIconType();

    public abstract String getValue1();

    public abstract String getValue2();

    public boolean hasCornor() {
        return !TextUtils.isEmpty(getCornerAddr());
    }

    public boolean isShoudShowPoint(Context context) {
        if (("1".equals(getTimeStampIconType()) || "2".equals(getTimeStampIconType()) || "3".equals(getTimeStampIconType())) && !TextUtils.isEmpty(getType())) {
            return (getType().equals("1") || getType().equals("2") || getType().equals("3") || getType().equals("4")) && !TextUtils.isEmpty(getLinkAddr()) && getNum(getTimeStamp(), 0L) > getNum(a.a(context, getLinkAddr()), 0L);
        }
        return false;
    }
}

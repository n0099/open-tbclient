package com.baidu.wallet.base.widget.banner;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public abstract class BannerBaseItemInfo implements NoProguard, Serializable {
    public static final String TIMESTAMP_TYPE_COPY = "3";
    public static final String TIMESTAMP_TYPE_RED_DOT = "2";
    public static final String TIMESTAMP_TYPE_WHITE_DOT = "1";
    public static final String TYPE_H5_INNER = "1";
    public static final String TYPE_H5_OUTER = "2";
    public static final String TYPE_LOGIN = "5";
    public static final String TYPE_SCHEME = "6";
    public static final String TYPE_SDK = "3";
    public static final String TYPE_SDK_OUT = "4";
    public static final long serialVersionUID = -6186522237816791458L;

    public abstract String getLinkAddr();

    public abstract String getName();

    public abstract String getPicAddr();

    public abstract boolean getPrevlogin();

    public String getStat() {
        return null;
    }

    public abstract String getType();
}

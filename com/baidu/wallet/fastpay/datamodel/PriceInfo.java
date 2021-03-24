package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PriceInfo implements NoProguard, Serializable {
    public static final long serialVersionUID = 2303549421246252648L;
    public int canClick;
    public String discount;
    public String face;
    public boolean isExist;
    public String sell_price;

    public PriceInfo() {
        this.discount = "";
        this.canClick = 0;
        this.isExist = false;
    }

    public boolean canClick() {
        return 1 == this.canClick;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PriceInfo) && TextUtils.equals(((PriceInfo) obj).face, this.face);
    }

    public String toString() {
        return "PriceInfo [face=" + this.face + ", sell_price=" + this.sell_price + ", discount=" + this.discount + "]";
    }

    public PriceInfo(String str, String str2, String str3) {
        this.discount = "";
        this.canClick = 0;
        this.isExist = false;
        this.face = str;
        this.sell_price = str2;
        this.discount = str3;
        this.canClick = 0;
    }
}

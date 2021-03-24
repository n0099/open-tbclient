package com.baidu.wallet.fastpay.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class FastPayFacePromotionInfoResponse implements NoProguard, Serializable {
    public static final long serialVersionUID = 230354942121385L;
    public String face = "";
    public String icon = "";

    public String toString() {
        return "FastPayFacePromotionInfoResponse [face=" + this.face + ", icon=" + this.icon + "]";
    }
}

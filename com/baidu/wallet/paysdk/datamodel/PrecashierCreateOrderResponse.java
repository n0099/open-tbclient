package com.baidu.wallet.paysdk.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PrecashierCreateOrderResponse implements NoProguard, Serializable {
    public static final long serialVersionUID = -1148883705592392526L;
    public DirectPayContentResponse content;
    public DirectPayErrorContent errContent;
    public String msg;
    public String ret;
}

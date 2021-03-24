package com.baidu.wallet.paysdk.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class LivingVerifyResultModel implements NoProguard, Serializable {
    public static int ERRORCODECANCEL = -204;
    public Cnt cnt;
    public int result = Integer.MIN_VALUE;

    /* loaded from: classes5.dex */
    public static class Cnt implements NoProguard {
        public Data data;
        public String des;
        public int errCode = Integer.MIN_VALUE;
    }

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public Result result;
        public int retCode = Integer.MIN_VALUE;
        public String retMsg;
    }

    /* loaded from: classes5.dex */
    public static class Result implements NoProguard {
        public String callbackkey;
        public String credentialKey;
    }
}

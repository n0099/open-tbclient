package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
/* loaded from: classes5.dex */
public class LightAppContactSelectModelBase64 implements NoProguard {
    public String cnt;
    public int result;

    public String toJson() {
        return JsonUtils.toJson(this);
    }
}

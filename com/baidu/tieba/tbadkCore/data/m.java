package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String adC;
    private HashMap fbf;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.adC = null;
        this.fbf = null;
        this.mContext = context;
        this.adC = str;
        this.fbf = hashMap;
    }

    public String getPageName() {
        return this.adC;
    }

    public HashMap getParams() {
        return this.fbf;
    }

    public Context getContext() {
        return this.mContext;
    }
}

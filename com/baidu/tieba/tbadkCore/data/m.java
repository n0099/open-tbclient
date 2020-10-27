package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String aaA;
    private HashMap eGd;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.aaA = null;
        this.eGd = null;
        this.mContext = context;
        this.aaA = str;
        this.eGd = hashMap;
    }

    public String dHk() {
        return this.aaA;
    }

    public HashMap getParams() {
        return this.eGd;
    }

    public Context getContext() {
        return this.mContext;
    }
}

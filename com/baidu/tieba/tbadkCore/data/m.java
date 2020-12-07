package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String abC;
    private HashMap eSd;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.abC = null;
        this.eSd = null;
        this.mContext = context;
        this.abC = str;
        this.eSd = hashMap;
    }

    public String getPageName() {
        return this.abC;
    }

    public HashMap getParams() {
        return this.eSd;
    }

    public Context getContext() {
        return this.mContext;
    }
}

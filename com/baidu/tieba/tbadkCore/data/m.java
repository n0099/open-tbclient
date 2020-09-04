package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String ZQ;
    private HashMap ejh;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.ZQ = null;
        this.ejh = null;
        this.mContext = context;
        this.ZQ = str;
        this.ejh = hashMap;
    }

    public String dwx() {
        return this.ZQ;
    }

    public HashMap getParams() {
        return this.ejh;
    }

    public Context getContext() {
        return this.mContext;
    }
}

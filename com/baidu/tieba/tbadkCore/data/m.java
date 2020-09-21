package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String aaj;
    private HashMap elw;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.aaj = null;
        this.elw = null;
        this.mContext = context;
        this.aaj = str;
        this.elw = hashMap;
    }

    public String dAq() {
        return this.aaj;
    }

    public HashMap getParams() {
        return this.elw;
    }

    public Context getContext() {
        return this.mContext;
    }
}

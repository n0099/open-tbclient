package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String aaF;
    private HashMap eKR;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.aaF = null;
        this.eKR = null;
        this.mContext = context;
        this.aaF = str;
        this.eKR = hashMap;
    }

    public String dJD() {
        return this.aaF;
    }

    public HashMap getParams() {
        return this.eKR;
    }

    public Context getContext() {
        return this.mContext;
    }
}

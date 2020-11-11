package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String aaA;
    private HashMap eLS;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.aaA = null;
        this.eLS = null;
        this.mContext = context;
        this.aaA = str;
        this.eLS = hashMap;
    }

    public String dJM() {
        return this.aaA;
    }

    public HashMap getParams() {
        return this.eLS;
    }

    public Context getContext() {
        return this.mContext;
    }
}

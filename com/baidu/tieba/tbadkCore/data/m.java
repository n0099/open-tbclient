package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String aaz;
    private HashMap exF;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.aaz = null;
        this.exF = null;
        this.mContext = context;
        this.aaz = str;
        this.exF = hashMap;
    }

    public String dEc() {
        return this.aaz;
    }

    public HashMap getParams() {
        return this.exF;
    }

    public Context getContext() {
        return this.mContext;
    }
}

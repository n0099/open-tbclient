package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class m {
    private String ZO;
    private HashMap ejd;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.ZO = null;
        this.ejd = null;
        this.mContext = context;
        this.ZO = str;
        this.ejd = hashMap;
    }

    public String dws() {
        return this.ZO;
    }

    public HashMap getParams() {
        return this.ejd;
    }

    public Context getContext() {
        return this.mContext;
    }
}

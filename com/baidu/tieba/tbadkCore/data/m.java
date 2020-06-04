package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private HashMap iXV;
    private String llN;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.llN = null;
        this.iXV = null;
        this.mContext = context;
        this.llN = str;
        this.iXV = hashMap;
    }

    public String ddw() {
        return this.llN;
    }

    public HashMap getParams() {
        return this.iXV;
    }

    public Context getContext() {
        return this.mContext;
    }
}

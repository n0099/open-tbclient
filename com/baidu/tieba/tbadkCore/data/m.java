package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private HashMap iXi;
    private String lkE;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.lkE = null;
        this.iXi = null;
        this.mContext = context;
        this.lkE = str;
        this.iXi = hashMap;
    }

    public String ddh() {
        return this.lkE;
    }

    public HashMap getParams() {
        return this.iXi;
    }

    public Context getContext() {
        return this.mContext;
    }
}

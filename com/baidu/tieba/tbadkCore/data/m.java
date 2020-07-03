package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private HashMap jpf;
    private String lFH;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.lFH = null;
        this.jpf = null;
        this.mContext = context;
        this.lFH = str;
        this.jpf = hashMap;
    }

    public String dhL() {
        return this.lFH;
    }

    public HashMap getParams() {
        return this.jpf;
    }

    public Context getContext() {
        return this.mContext;
    }
}

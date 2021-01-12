package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String acm;
    private HashMap eXq;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.acm = null;
        this.eXq = null;
        this.mContext = context;
        this.acm = str;
        this.eXq = hashMap;
    }

    public String getPageName() {
        return this.acm;
    }

    public HashMap getParams() {
        return this.eXq;
    }

    public Context getContext() {
        return this.mContext;
    }
}

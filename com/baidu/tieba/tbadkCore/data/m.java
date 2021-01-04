package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String aco;
    private HashMap fbY;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.aco = null;
        this.fbY = null;
        this.mContext = context;
        this.aco = str;
        this.fbY = hashMap;
    }

    public String getPageName() {
        return this.aco;
    }

    public HashMap getParams() {
        return this.fbY;
    }

    public Context getContext() {
        return this.mContext;
    }
}

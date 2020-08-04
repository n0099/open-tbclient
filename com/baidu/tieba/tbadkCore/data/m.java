package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String Zj;
    private HashMap dZx;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.Zj = null;
        this.dZx = null;
        this.mContext = context;
        this.Zj = str;
        this.dZx = hashMap;
    }

    public String dkV() {
        return this.Zj;
    }

    public HashMap getParams() {
        return this.dZx;
    }

    public Context getContext() {
        return this.mContext;
    }
}

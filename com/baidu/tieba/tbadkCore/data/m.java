package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private String acf;
    private HashMap eZG;
    private Context mContext;

    public m(Context context, String str, HashMap hashMap) {
        this.mContext = null;
        this.acf = null;
        this.eZG = null;
        this.mContext = context;
        this.acf = str;
        this.eZG = hashMap;
    }

    public String getPageName() {
        return this.acf;
    }

    public HashMap getParams() {
        return this.eZG;
    }

    public Context getContext() {
        return this.mContext;
    }
}

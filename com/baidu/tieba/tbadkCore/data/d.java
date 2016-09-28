package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList fuv;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.fuv = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bjn() {
        return this.fuv;
    }

    public Context getContext() {
        return this.mContext;
    }
}

package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList giA;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.giA = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList brZ() {
        return this.giA;
    }

    public Context getContext() {
        return this.mContext;
    }
}

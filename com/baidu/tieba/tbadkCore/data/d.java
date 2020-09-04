package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private Context mContext;
    private AbsDelegateAdapterList meA;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.meA = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList dwp() {
        return this.meA;
    }
}

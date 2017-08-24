package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList gje;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.gje = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bsz() {
        return this.gje;
    }

    public Context getContext() {
        return this.mContext;
    }
}

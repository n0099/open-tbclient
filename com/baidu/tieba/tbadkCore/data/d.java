package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private Context mContext;
    private AbsDelegateAdapterList nmh;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.nmh = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList dKO() {
        return this.nmh;
    }
}

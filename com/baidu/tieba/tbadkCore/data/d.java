package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList hdQ;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.hdQ = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bAX() {
        return this.hdQ;
    }
}

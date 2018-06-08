package com.baidu.tieba.share;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.coreExtra.c.d;
/* loaded from: classes.dex */
public class ImplicitShareMessage extends CustomMessage<d> {
    private boolean isShowLocation;
    private int mChannel;
    private Context mContext;

    public ImplicitShareMessage(Context context, int i, d dVar, boolean z) {
        super(2016567, dVar);
        this.mContext = context;
        this.mChannel = i;
        this.isShowLocation = z;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }
}

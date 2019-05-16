package com.baidu.tieba.share;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.coreExtra.c.e;
/* loaded from: classes.dex */
public class ImplicitShareMessage extends CustomMessage<e> {
    private boolean isShowLocation;
    private int mChannel;
    private Context mContext;

    public ImplicitShareMessage(Context context, int i, e eVar, boolean z) {
        super(2016567, eVar);
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

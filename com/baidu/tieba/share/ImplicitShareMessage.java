package com.baidu.tieba.share;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes5.dex */
public class ImplicitShareMessage extends CustomMessage<ShareItem> {
    public boolean isShowLocation;
    public int mChannel;
    public Context mContext;

    public ImplicitShareMessage(Context context, int i, ShareItem shareItem, boolean z) {
        super(2016567, shareItem);
        this.mContext = context;
        this.mChannel = i;
        this.isShowLocation = z;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }
}

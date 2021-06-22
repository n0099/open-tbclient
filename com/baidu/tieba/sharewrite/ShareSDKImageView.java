package com.baidu.tieba.sharewrite;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ShareSDKImageView extends TbClipImageView {
    public int C0;
    public int D0;

    public ShareSDKImageView(Context context) {
        this(context, null, 0);
    }

    public final void G() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(false);
        setIsRound(false);
        setDefaultResource(this.C0);
        setDefaultBgResource(this.D0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.C0 = R.drawable.pic_share_link;
        this.D0 = R.color.CAM_X0110;
        G();
    }
}

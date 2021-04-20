package com.baidu.tieba.sharewrite;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ShareSDKImageView extends TbClipImageView {
    public int x0;
    public int y0;

    public ShareSDKImageView(Context context) {
        this(context, null, 0);
    }

    public final void G() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(false);
        setIsRound(false);
        setDefaultResource(this.x0);
        setDefaultBgResource(this.y0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x0 = R.drawable.pic_share_link;
        this.y0 = R.color.CAM_X0110;
        G();
    }
}

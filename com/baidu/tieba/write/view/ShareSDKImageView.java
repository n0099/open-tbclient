package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ShareSDKImageView extends TbClipImageView {
    private int adU;
    private int adV;

    public ShareSDKImageView(Context context) {
        this(context, null, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adU = n.e.pic_share_link;
        this.adV = n.c.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(false);
        setIsRound(false);
        setDefaultResource(this.adU);
        setDefaultBgResource(this.adV);
    }
}

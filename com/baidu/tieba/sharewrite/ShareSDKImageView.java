package com.baidu.tieba.sharewrite;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ShareSDKImageView extends TbClipImageView {
    private int mDefaultBgId;
    private int mDefaultId;

    public ShareSDKImageView(Context context) {
        this(context, null, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultId = f.C0146f.pic_share_link;
        this.mDefaultBgId = f.d.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(false);
        setIsRound(false);
        setDefaultResource(this.mDefaultId);
        setDefaultBgResource(this.mDefaultBgId);
    }
}

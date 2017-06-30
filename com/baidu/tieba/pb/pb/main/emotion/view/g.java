package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private ImageView eFL;
    private int mImageWidth;

    public g(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundResource(w.g.bg_expression_bubble);
        int g = k.g(getContext(), w.f.ds20);
        setPadding(g, g, g, k.g(getContext(), w.f.ds40));
        this.mImageWidth = k.g(getContext(), w.f.ds200);
    }

    public void h(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            removeAllViews();
            if (z) {
                this.eFL = new GifView(getContext());
                ((GifView) this.eFL).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = str;
                gifInfo.mDynamicUrl = str;
                gifInfo.mStaticUrl = str2;
                this.eFL.setTag(gifInfo.mSharpText);
                ((GifView) this.eFL).a(gifInfo);
            } else {
                this.eFL = new TbImageView(getContext());
                ((TbImageView) this.eFL).setGifIconSupport(false);
                ((TbImageView) this.eFL).c(str, 10, true);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mImageWidth, this.mImageWidth);
            layoutParams.gravity = 17;
            addView(this.eFL, layoutParams);
        }
    }
}

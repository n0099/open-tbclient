package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class HeadImageShaderView extends FrameLayout {
    private final View a;
    private final HeadImageView b;
    private final Drawable c;

    public HeadImageShaderView(Context context) {
        this(context, null, 0);
    }

    public HeadImageShaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImageShaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new HeadImageView(context);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.im_msg_head_photo_inner_size);
        this.b.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 17));
        this.c = getResources().getDrawable(u.bg_lt_head_shadow);
        this.a = new View(context);
        this.a.setBackgroundDrawable(this.c);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.a);
        addView(this.b);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.b.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        this.b.setTag(obj);
    }

    public HeadImageView getHeadImageView() {
        return this.b;
    }

    public void setAutoChangeStyle(boolean z) {
        this.b.setAutoChangeStyle(z);
    }

    public void setUserId(String str) {
        this.b.setUserId(str);
    }
}

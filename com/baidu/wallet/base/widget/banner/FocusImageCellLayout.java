package com.baidu.wallet.base.widget.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;
/* loaded from: classes5.dex */
public class FocusImageCellLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24440a;

    /* loaded from: classes5.dex */
    public interface FocusImageEvent {
        void submitPage(int i2);
    }

    public FocusImageCellLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        b(context);
    }

    private void b(Context context) {
        NetImageView netImageView = new NetImageView(context);
        this.f24440a = netImageView;
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f24440a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public NetImageView getFocusView() {
        return this.f24440a;
    }

    public void updateImage(int i2) {
        this.f24440a.setBackgroundResource(i2);
    }

    public FocusImageCellLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void updateImage(Drawable drawable) {
        this.f24440a.setImageDrawable(drawable);
    }
}

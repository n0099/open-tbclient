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
    public NetImageView f23717a;

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
        this.f23717a = netImageView;
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f23717a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public NetImageView getFocusView() {
        return this.f23717a;
    }

    public void updateImage(int i2) {
        this.f23717a.setBackgroundResource(i2);
    }

    public FocusImageCellLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void updateImage(Drawable drawable) {
        this.f23717a.setImageDrawable(drawable);
    }
}

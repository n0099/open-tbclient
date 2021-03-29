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
    public NetImageView f24009a;

    /* loaded from: classes5.dex */
    public interface FocusImageEvent {
        void submitPage(int i);
    }

    public FocusImageCellLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        b(context);
    }

    private void b(Context context) {
        NetImageView netImageView = new NetImageView(context);
        this.f24009a = netImageView;
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f24009a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public NetImageView getFocusView() {
        return this.f24009a;
    }

    public void updateImage(int i) {
        this.f24009a.setBackgroundResource(i);
    }

    public FocusImageCellLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void updateImage(Drawable drawable) {
        this.f24009a.setImageDrawable(drawable);
    }
}

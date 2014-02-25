package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import com.baidu.tbadk.gif.GifView;
import com.slidingmenu.lib.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class EggBreakerView extends GifView {
    private static boolean c = false;
    private RotateAnimation b;
    private com.baidu.adp.widget.ImageView.b d;
    private h e;

    public EggBreakerView(Context context) {
        this(context, null, 0);
    }

    public EggBreakerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EggBreakerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setAutoPlay(false);
        setPlayCallback(new f(this));
        if (c) {
            File file = new File(getContext().getCacheDir() + "/dandan2.gif");
            if (!file.exists()) {
                try {
                    InputStream open = getContext().getAssets().open("dandan2.gif");
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    open.close();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            this.d = com.baidu.adp.gif.b.a().a(getContext().getCacheDir() + "/dandan2.gif");
            setGif(this.d);
            setLayoutParams(new ViewGroup.LayoutParams(getResources().getDimensionPixelSize(R.dimen.egg_breaker_width), getResources().getDimensionPixelSize(R.dimen.egg_breaker_height)));
        }
    }

    public void h() {
        postDelayed(new g(this), 30L);
        if (this.b == null) {
            this.b = (RotateAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.wobble);
        }
        if (this.b != null) {
            startAnimation(this.b);
        }
    }

    public void i() {
        d();
        clearAnimation();
    }

    public void setOnEggBrokeListener(h hVar) {
        this.e = hVar;
    }
}

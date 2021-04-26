package com.baidu.ufosdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f23354a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f23355b;

    /* renamed from: c  reason: collision with root package name */
    public Context f23356c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23357d;

    public n(Context context, ImageView imageView, Handler handler) {
        this.f23357d = null;
        this.f23354a = imageView;
        this.f23355b = handler;
        this.f23356c = context;
    }

    public n(Context context, TextView textView, Handler handler) {
        this.f23357d = null;
        this.f23357d = textView;
        this.f23355b = handler;
        this.f23356c = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ImageView imageView;
        int a2;
        super.handleMessage(message);
        Object obj = message.obj;
        if (obj != null) {
            Bitmap bitmap = (Bitmap) obj;
            if (this.f23357d != null) {
                ImageSpan imageSpan = new ImageSpan(this.f23356c, bitmap);
                SpannableString spannableString = new SpannableString("icon");
                spannableString.setSpan(imageSpan, 0, 4, 33);
                this.f23357d.setText(spannableString.toString());
                return;
            }
            this.f23354a.setImageBitmap(bitmap);
            if (bitmap.getHeight() > bitmap.getWidth()) {
                this.f23354a.setMaxWidth(i.a(this.f23356c, 80.0f));
                imageView = this.f23354a;
                a2 = i.a(this.f23356c, 120.0f);
            } else {
                this.f23354a.setMaxWidth(i.a(this.f23356c, 120.0f));
                imageView = this.f23354a;
                a2 = i.a(this.f23356c, 80.0f);
            }
            imageView.setMaxHeight(a2);
        }
        Handler handler = this.f23355b;
        if (handler != null) {
            handler.obtainMessage(6).sendToTarget();
        }
    }
}

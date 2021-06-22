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
    public ImageView f22713a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f22714b;

    /* renamed from: c  reason: collision with root package name */
    public Context f22715c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22716d;

    public n(Context context, ImageView imageView, Handler handler) {
        this.f22716d = null;
        this.f22713a = imageView;
        this.f22714b = handler;
        this.f22715c = context;
    }

    public n(Context context, TextView textView, Handler handler) {
        this.f22716d = null;
        this.f22716d = textView;
        this.f22714b = handler;
        this.f22715c = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ImageView imageView;
        int a2;
        super.handleMessage(message);
        Object obj = message.obj;
        if (obj != null) {
            Bitmap bitmap = (Bitmap) obj;
            if (this.f22716d != null) {
                ImageSpan imageSpan = new ImageSpan(this.f22715c, bitmap);
                SpannableString spannableString = new SpannableString("icon");
                spannableString.setSpan(imageSpan, 0, 4, 33);
                this.f22716d.setText(spannableString.toString());
                return;
            }
            this.f22713a.setImageBitmap(bitmap);
            if (bitmap.getHeight() > bitmap.getWidth()) {
                this.f22713a.setMaxWidth(i.a(this.f22715c, 80.0f));
                imageView = this.f22713a;
                a2 = i.a(this.f22715c, 120.0f);
            } else {
                this.f22713a.setMaxWidth(i.a(this.f22715c, 120.0f));
                imageView = this.f22713a;
                a2 = i.a(this.f22715c, 80.0f);
            }
            imageView.setMaxHeight(a2);
        }
        Handler handler = this.f22714b;
        if (handler != null) {
            handler.obtainMessage(6).sendToTarget();
        }
    }
}

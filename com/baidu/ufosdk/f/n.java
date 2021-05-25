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
    public ImageView f22528a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f22529b;

    /* renamed from: c  reason: collision with root package name */
    public Context f22530c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22531d;

    public n(Context context, ImageView imageView, Handler handler) {
        this.f22531d = null;
        this.f22528a = imageView;
        this.f22529b = handler;
        this.f22530c = context;
    }

    public n(Context context, TextView textView, Handler handler) {
        this.f22531d = null;
        this.f22531d = textView;
        this.f22529b = handler;
        this.f22530c = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ImageView imageView;
        int a2;
        super.handleMessage(message);
        Object obj = message.obj;
        if (obj != null) {
            Bitmap bitmap = (Bitmap) obj;
            if (this.f22531d != null) {
                ImageSpan imageSpan = new ImageSpan(this.f22530c, bitmap);
                SpannableString spannableString = new SpannableString("icon");
                spannableString.setSpan(imageSpan, 0, 4, 33);
                this.f22531d.setText(spannableString.toString());
                return;
            }
            this.f22528a.setImageBitmap(bitmap);
            if (bitmap.getHeight() > bitmap.getWidth()) {
                this.f22528a.setMaxWidth(i.a(this.f22530c, 80.0f));
                imageView = this.f22528a;
                a2 = i.a(this.f22530c, 120.0f);
            } else {
                this.f22528a.setMaxWidth(i.a(this.f22530c, 120.0f));
                imageView = this.f22528a;
                a2 = i.a(this.f22530c, 80.0f);
            }
            imageView.setMaxHeight(a2);
        }
        Handler handler = this.f22529b;
        if (handler != null) {
            handler.obtainMessage(6).sendToTarget();
        }
    }
}

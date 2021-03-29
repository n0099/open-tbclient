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
    public ImageView f22958a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f22959b;

    /* renamed from: c  reason: collision with root package name */
    public Context f22960c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22961d;

    public n(Context context, ImageView imageView, Handler handler) {
        this.f22961d = null;
        this.f22958a = imageView;
        this.f22959b = handler;
        this.f22960c = context;
    }

    public n(Context context, TextView textView, Handler handler) {
        this.f22961d = null;
        this.f22961d = textView;
        this.f22959b = handler;
        this.f22960c = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ImageView imageView;
        int a2;
        super.handleMessage(message);
        Object obj = message.obj;
        if (obj != null) {
            Bitmap bitmap = (Bitmap) obj;
            if (this.f22961d != null) {
                ImageSpan imageSpan = new ImageSpan(this.f22960c, bitmap);
                SpannableString spannableString = new SpannableString("icon");
                spannableString.setSpan(imageSpan, 0, 4, 33);
                this.f22961d.setText(spannableString.toString());
                return;
            }
            this.f22958a.setImageBitmap(bitmap);
            if (bitmap.getHeight() > bitmap.getWidth()) {
                this.f22958a.setMaxWidth(i.a(this.f22960c, 80.0f));
                imageView = this.f22958a;
                a2 = i.a(this.f22960c, 120.0f);
            } else {
                this.f22958a.setMaxWidth(i.a(this.f22960c, 120.0f));
                imageView = this.f22958a;
                a2 = i.a(this.f22960c, 80.0f);
            }
            imageView.setMaxHeight(a2);
        }
        Handler handler = this.f22959b;
        if (handler != null) {
            handler.obtainMessage(6).sendToTarget();
        }
    }
}

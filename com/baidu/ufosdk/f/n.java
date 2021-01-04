package com.baidu.ufosdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
/* loaded from: classes8.dex */
public final class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    ImageView f5671a;

    /* renamed from: b  reason: collision with root package name */
    Handler f5672b;
    Context c;
    TextView d;

    public n(Context context, ImageView imageView, Handler handler) {
        this.d = null;
        this.f5671a = imageView;
        this.f5672b = handler;
        this.c = context;
    }

    public n(Context context, TextView textView, Handler handler) {
        this.d = null;
        this.d = textView;
        this.f5672b = handler;
        this.c = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.obj != null) {
            Bitmap bitmap = (Bitmap) message.obj;
            if (this.d != null) {
                ImageSpan imageSpan = new ImageSpan(this.c, bitmap);
                SpannableString spannableString = new SpannableString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                spannableString.setSpan(imageSpan, 0, 4, 33);
                this.d.setText(spannableString.toString());
                return;
            }
            this.f5671a.setImageBitmap(bitmap);
            if (bitmap.getHeight() > bitmap.getWidth()) {
                this.f5671a.setMaxWidth(i.a(this.c, 80.0f));
                this.f5671a.setMaxHeight(i.a(this.c, 120.0f));
            } else {
                this.f5671a.setMaxWidth(i.a(this.c, 120.0f));
                this.f5671a.setMaxHeight(i.a(this.c, 80.0f));
            }
        }
        if (this.f5672b != null) {
            this.f5672b.obtainMessage(6).sendToTarget();
        }
    }
}

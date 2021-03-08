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
/* loaded from: classes7.dex */
public final class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    ImageView f3627a;
    Handler b;
    Context c;
    TextView d;

    public n(Context context, ImageView imageView, Handler handler) {
        this.d = null;
        this.f3627a = imageView;
        this.b = handler;
        this.c = context;
    }

    public n(Context context, TextView textView, Handler handler) {
        this.d = null;
        this.d = textView;
        this.b = handler;
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
            this.f3627a.setImageBitmap(bitmap);
            if (bitmap.getHeight() > bitmap.getWidth()) {
                this.f3627a.setMaxWidth(i.a(this.c, 80.0f));
                this.f3627a.setMaxHeight(i.a(this.c, 120.0f));
            } else {
                this.f3627a.setMaxWidth(i.a(this.c, 120.0f));
                this.f3627a.setMaxHeight(i.a(this.c, 80.0f));
            }
        }
        if (this.b != null) {
            this.b.obtainMessage(6).sendToTarget();
        }
    }
}

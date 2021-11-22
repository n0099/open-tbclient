package com.baidu.ufosdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class n extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f57619a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f57620b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57621c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57622d;

    public n(Context context, ImageView imageView, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, imageView, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57622d = null;
        this.f57619a = imageView;
        this.f57620b = handler;
        this.f57621c = context;
    }

    public n(Context context, TextView textView, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, textView, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57622d = null;
        this.f57622d = textView;
        this.f57620b = handler;
        this.f57621c = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ImageView imageView;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj != null) {
                Bitmap bitmap = (Bitmap) obj;
                if (this.f57622d != null) {
                    ImageSpan imageSpan = new ImageSpan(this.f57621c, bitmap);
                    SpannableString spannableString = new SpannableString("icon");
                    spannableString.setSpan(imageSpan, 0, 4, 33);
                    this.f57622d.setText(spannableString.toString());
                    return;
                }
                this.f57619a.setImageBitmap(bitmap);
                if (bitmap.getHeight() > bitmap.getWidth()) {
                    this.f57619a.setMaxWidth(i.a(this.f57621c, 80.0f));
                    imageView = this.f57619a;
                    a2 = i.a(this.f57621c, 120.0f);
                } else {
                    this.f57619a.setMaxWidth(i.a(this.f57621c, 120.0f));
                    imageView = this.f57619a;
                    a2 = i.a(this.f57621c, 80.0f);
                }
                imageView.setMaxHeight(a2);
            }
            Handler handler = this.f57620b;
            if (handler != null) {
                handler.obtainMessage(6).sendToTarget();
            }
        }
    }
}

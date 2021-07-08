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
/* loaded from: classes4.dex */
public final class n extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f23339a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f23340b;

    /* renamed from: c  reason: collision with root package name */
    public Context f23341c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23342d;

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
        this.f23342d = null;
        this.f23339a = imageView;
        this.f23340b = handler;
        this.f23341c = context;
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
        this.f23342d = null;
        this.f23342d = textView;
        this.f23340b = handler;
        this.f23341c = context;
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
                if (this.f23342d != null) {
                    ImageSpan imageSpan = new ImageSpan(this.f23341c, bitmap);
                    SpannableString spannableString = new SpannableString("icon");
                    spannableString.setSpan(imageSpan, 0, 4, 33);
                    this.f23342d.setText(spannableString.toString());
                    return;
                }
                this.f23339a.setImageBitmap(bitmap);
                if (bitmap.getHeight() > bitmap.getWidth()) {
                    this.f23339a.setMaxWidth(i.a(this.f23341c, 80.0f));
                    imageView = this.f23339a;
                    a2 = i.a(this.f23341c, 120.0f);
                } else {
                    this.f23339a.setMaxWidth(i.a(this.f23341c, 120.0f));
                    imageView = this.f23339a;
                    a2 = i.a(this.f23341c, 80.0f);
                }
                imageView.setMaxHeight(a2);
            }
            Handler handler = this.f23340b;
            if (handler != null) {
                handler.obtainMessage(6).sendToTarget();
            }
        }
    }
}

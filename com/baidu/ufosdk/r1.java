package com.baidu.ufosdk;

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
public class r1 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public Handler b;
    public Context c;
    public TextView d;

    public r1(Context context, ImageView imageView, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, imageView, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.a = imageView;
        this.b = handler;
        this.c = context;
    }

    public r1(Context context, TextView textView, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, textView, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.d = textView;
        this.b = handler;
        this.c = context;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj != null) {
                Bitmap bitmap = (Bitmap) obj;
                if (this.d != null) {
                    ImageSpan imageSpan = new ImageSpan(this.c, bitmap);
                    SpannableString spannableString = new SpannableString("icon");
                    spannableString.setSpan(imageSpan, 0, 4, 33);
                    this.d.setText(spannableString.toString());
                    return;
                }
                this.a.setImageBitmap(bitmap);
                if (bitmap.getHeight() > bitmap.getWidth()) {
                    this.a.setMaxWidth(p1.a(this.c, 80.0f));
                    this.a.setMaxHeight(p1.a(this.c, 120.0f));
                } else {
                    this.a.setMaxWidth(p1.a(this.c, 120.0f));
                    this.a.setMaxHeight(p1.a(this.c, 80.0f));
                }
            }
            Handler handler = this.b;
            if (handler != null) {
                handler.obtainMessage(6).sendToTarget();
            }
        }
    }
}

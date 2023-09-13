package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.baidu.tieba.om5;
import com.baidu.tieba.qm5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class im5<R extends om5, W extends qm5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final R a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final Rect g;
    public final Rect h;

    public abstract Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public im5(R r) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new Rect();
        this.h = new Rect();
        this.a = r;
    }
}

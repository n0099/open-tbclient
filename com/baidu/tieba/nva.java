package com.baidu.tieba;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nva extends LinkMovementMethod {
    public static /* synthetic */ Interceptable $ic;
    public static nva f;
    public transient /* synthetic */ FieldHolder $fh;
    public e26 a;
    public int b;
    public int c;
    public long d;
    public int e;

    public nva() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1;
    }

    public static nva a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f == null) {
                f = new nva();
            }
            return f;
        }
        return (nva) invokeV.objValue;
    }

    public static boolean c(float f2, float f3, float f4, float f5, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            float abs = Math.abs(f4 - f2);
            float abs2 = Math.abs(f5 - f3);
            long j4 = j2 - j;
            if (abs <= 100.0f && abs2 <= 100.0f && j4 >= j3) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final e26 b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, textView, spannable, motionEvent)) == null) {
            if (motionEvent != null && motionEvent.getAction() != 3) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                try {
                    Layout layout = textView.getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                    e26[] e26VarArr = (e26[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, e26.class);
                    if (e26VarArr == null || e26VarArr.length <= 0 || e26VarArr[0] == null) {
                        return null;
                    }
                    return e26VarArr[0];
                } catch (Exception e) {
                    BdLog.e(e);
                    return this.a;
                }
            }
            return this.a;
        }
        return (e26) invokeLLL.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, spannable, motionEvent)) == null) {
            e26 b = b(textView, spannable, motionEvent);
            if (b == null && motionEvent.getAction() == 0) {
                try {
                    return super.onTouchEvent(textView, spannable, motionEvent);
                } catch (Exception e) {
                    BdLog.e(e);
                    return true;
                }
            }
            if (b != null) {
                this.a = b;
            }
            int i = this.e;
            if (i > -1) {
                this.a.m(i);
            }
            if (motionEvent.getAction() == 0) {
                this.b = (int) motionEvent.getX();
                this.c = (int) motionEvent.getY();
                this.d = System.currentTimeMillis();
                e26 e26Var = this.a;
                if (e26Var != null) {
                    e26Var.p(1);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.a), spannable.getSpanEnd(this.a));
                }
                textView.invalidate();
            } else if (motionEvent.getAction() == 2) {
                if (this.a != null && (Math.abs(this.b - motionEvent.getX()) > 20.0f || Math.abs(this.c - motionEvent.getY()) > 20.0f)) {
                    this.a.p(2);
                    textView.invalidate();
                    Selection.removeSelection(spannable);
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                e26 e26Var2 = this.a;
                if (e26Var2 != null) {
                    e26Var2.p(2);
                    textView.invalidate();
                    Selection.removeSelection(spannable);
                }
                if (c(this.b, this.c, motionEvent.getX(), motionEvent.getY(), this.d, System.currentTimeMillis(), 500L)) {
                    return true;
                }
            }
            try {
                return super.onTouchEvent(textView, spannable, motionEvent);
            } catch (Exception e2) {
                BdLog.e(e2);
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }
}

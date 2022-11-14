package com.baidu.tieba;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j19 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Spannable a;
    public xm5 b;
    public int c;

    public j19(Spannable spannable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spannable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = 0;
        this.a = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        xm5 xm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (!(view2 instanceof TextView)) {
                return false;
            }
            TextView textView = (TextView) view2;
            if (action == 3 && (xm5Var = this.b) != null) {
                xm5Var.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view2.invalidate();
                this.b = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                Layout layout = textView.getLayout();
                if (layout == null) {
                    return false;
                }
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - textView.getTotalPaddingTop()) + textView.getScrollY()), (x - textView.getTotalPaddingLeft()) + textView.getScrollX());
                Spannable spannable = this.a;
                if (spannable == null) {
                    return false;
                }
                xm5[] xm5VarArr = (xm5[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, xm5.class);
                if (xm5VarArr != null && xm5VarArr.length != 0 && xm5VarArr[0] != null) {
                    if (action == 1) {
                        xm5VarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        xm5VarArr[0].onClick(textView);
                        view2.invalidate();
                    } else {
                        xm5 xm5Var2 = xm5VarArr[0];
                        this.b = xm5Var2;
                        if (xm5Var2.e()) {
                            int i = this.c;
                            if (i != 0) {
                                xm5VarArr[0].g(SkinManager.getColor(i));
                            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                xm5VarArr[0].g(SkinManager.getColor(R.color.CAM_X0204));
                            } else {
                                xm5VarArr[0].g(SkinManager.getColor(R.color.cp_bg_line_z));
                            }
                        }
                        Spannable spannable2 = this.a;
                        Selection.setSelection(spannable2, spannable2.getSpanStart(xm5VarArr[0]), this.a.getSpanEnd(xm5VarArr[0]));
                        view2.invalidate();
                    }
                    return true;
                }
                xm5 xm5Var3 = this.b;
                if (xm5Var3 != null) {
                    xm5Var3.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view2.invalidate();
                }
                Selection.removeSelection(this.a);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

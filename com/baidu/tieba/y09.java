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
/* loaded from: classes6.dex */
public class y09 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Spannable a;
    public nm5 b;
    public int c;

    public y09(Spannable spannable) {
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
        nm5 nm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (!(view2 instanceof TextView)) {
                return false;
            }
            TextView textView = (TextView) view2;
            if (action == 3 && (nm5Var = this.b) != null) {
                nm5Var.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
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
                nm5[] nm5VarArr = (nm5[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, nm5.class);
                if (nm5VarArr != null && nm5VarArr.length != 0 && nm5VarArr[0] != null) {
                    if (action == 1) {
                        nm5VarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        nm5VarArr[0].onClick(textView);
                        view2.invalidate();
                    } else {
                        nm5 nm5Var2 = nm5VarArr[0];
                        this.b = nm5Var2;
                        if (nm5Var2.e()) {
                            int i = this.c;
                            if (i != 0) {
                                nm5VarArr[0].g(SkinManager.getColor(i));
                            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                nm5VarArr[0].g(SkinManager.getColor(R.color.CAM_X0204));
                            } else {
                                nm5VarArr[0].g(SkinManager.getColor(R.color.cp_bg_line_z));
                            }
                        }
                        Spannable spannable2 = this.a;
                        Selection.setSelection(spannable2, spannable2.getSpanStart(nm5VarArr[0]), this.a.getSpanEnd(nm5VarArr[0]));
                        view2.invalidate();
                    }
                    return true;
                }
                nm5 nm5Var3 = this.b;
                if (nm5Var3 != null) {
                    nm5Var3.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view2.invalidate();
                }
                Selection.removeSelection(this.a);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

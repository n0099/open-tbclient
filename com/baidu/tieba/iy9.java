package com.baidu.tieba;

import android.widget.TextView;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tieba.write.write.work.selectview.SelectTagView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class iy9 implements AutoChangeLineView.b {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ iy9 a = new iy9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ iy9() {
    }

    @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
    public final CharSequence a(TextView textView, int i, Object obj) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, obj)) == null) {
            String str = (String) obj;
            SelectTagView.d(textView, i, str);
            return str;
        }
        return (CharSequence) invokeLIL.objValue;
    }
}

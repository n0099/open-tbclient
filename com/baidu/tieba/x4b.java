package com.baidu.tieba;

import android.widget.TextView;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tieba.write.write.work.selectview.SelectTagView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes8.dex */
public final /* synthetic */ class x4b implements AutoChangeLineView.b {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ x4b a = new x4b();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ x4b() {
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

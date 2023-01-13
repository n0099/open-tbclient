package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p81 implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;

    public p81(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int maxLines = textView.getMaxLines();
        this.b = maxLines;
        if (maxLines <= 0) {
            this.b = 1;
        }
        this.a = textView;
        textView.setMaxLines(this.b + 1);
        this.a.setSingleLine(false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        CharSequence text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            if (this.a.getLineCount() > this.b) {
                try {
                    text = this.a.getText().subSequence(0, this.a.getLayout().getLineEnd(this.b - 1) - 2);
                    str = StringHelper.STRING_MORE;
                } catch (Exception e) {
                    bk0.d("CustomLinkByEllipsize", "", e);
                    text = this.a.getText();
                }
                TextUtils.TruncateAt ellipsize = this.a.getEllipsize();
                if (ellipsize == TextUtils.TruncateAt.START) {
                    this.a.setText(str);
                    this.a.append(text);
                } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
                    this.a.setText(text.subSequence(0, text.length() / 2));
                    this.a.append(str);
                    this.a.append(text.subSequence(text.length() / 2, text.length()));
                } else {
                    this.a.setText(text);
                    this.a.append(str);
                }
            }
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x38 extends gi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x38(Context context) {
        super(context, (String) null, 29);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.n = 3;
        TopicDetaiInputContainer topicDetaiInputContainer = new TopicDetaiInputContainer(context);
        this.m = topicDetaiInputContainer;
        this.t = topicDetaiInputContainer.getInputView();
        ((TopicDetaiInputContainer) this.m).setHint(context.getString(R.string.say_your_point));
        this.p = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.t;
        }
        return (EditText) invokeV.objValue;
    }
}

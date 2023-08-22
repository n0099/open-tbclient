package com.baidu.tieba;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;

    public k35() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, intent) != null) || intent == null) {
            return;
        }
        this.a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.b = intent.getStringExtra("recom_source");
        this.c = intent.getStringExtra("recom_abtag");
        this.d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || threadData == null) {
            return;
        }
        this.a = threadData.mRecomWeight;
        this.b = threadData.mRecomSource;
        this.c = threadData.mRecomAbTag;
        this.d = threadData.mRecomExtra;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) && intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.a);
            intent.putExtra("recom_source", this.b);
            intent.putExtra("recom_abtag", this.c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.d);
        }
    }
}

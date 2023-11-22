package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.write.webwrite.data.WriteDataManager;
import com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class lbb extends WriteDataManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lbb() {
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

    @Override // com.baidu.tieba.write.webwrite.data.WriteDataManager
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b().setType(9);
            b().setIsArticle(a9b.n);
        }
    }

    @Override // com.baidu.tieba.write.webwrite.data.WriteDataManager
    public void o(TbPageContext<?> pageContext, bbb fileInterceptor, EditorTools editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pageContext, fileInterceptor, editor) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(fileInterceptor, "fileInterceptor");
            Intrinsics.checkNotNullParameter(editor, "editor");
            a().l(new BaseImageRelatedListener(pageContext, c(), b(), fileInterceptor, d(), editor));
            a().l(new scb(pageContext, c(), b(), d()));
        }
    }
}

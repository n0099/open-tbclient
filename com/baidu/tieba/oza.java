package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class oza extends BaseDraftBiz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oza(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, xya writePageState) {
        super(pageContext, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, writeData, writePageState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (xya) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
    }

    @Override // com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.s();
            if (TextUtils.isEmpty(k().getTopicId())) {
                sda.v(t(), null);
            } else {
                sda.F(k().getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (TextUtils.isEmpty(k().getTopicId())) {
                sda.l(t(), this);
            } else {
                sda.u(k().getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz
    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && 13 != k().getType() && 14 != k().getType() && 12 != k().getType()) {
            if (TextUtils.isEmpty(k().getTopicId())) {
                sda.v(t(), k());
            } else {
                sda.F(k().getTopicId(), k());
            }
        }
    }
}

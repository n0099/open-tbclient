package com.baidu.tieba.write.webwrite.hybirdlistener;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.hi7;
import com.baidu.tieba.k2b;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.p1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/ForumRegionQADialogListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "showForumDialog", "", "data", "", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ForumRegionQADialogListener extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.s1b
    public p1b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (p1b[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    public q1b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (q1b[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRegionQADialogListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, k2b writePageState) {
        super(context, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, webView, writeData, writePageState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (k2b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
    }

    @Override // com.baidu.tieba.s1b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WrapListener[]{h().invoke("writePage.showForumTabDialog", new ForumRegionQADialogListener$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("write", "收到H5通知，ForumRegionQADialogListener：" + str);
            BdUtilHelper.hideSoftKeyPad(i().getPageActivity(), j());
            hi7.a(i().getPageActivity(), i());
        }
    }
}

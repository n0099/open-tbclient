package com.baidu.tieba.write.webwrite.hybirdlistener;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.cya;
import com.baidu.tieba.dya;
import com.baidu.tieba.gl6;
import com.baidu.tieba.iza;
import com.baidu.tieba.q75;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.xya;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/EmotionBiz;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "addEmotion", "", "id", "", Languages.ANY, "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmotionBiz extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.fya
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fya
    public dya[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (dya[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionBiz(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, xya writePageState) {
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

    @Override // com.baidu.tieba.fya
    public cya[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new cya[]{n(24, new EmotionBiz$editorActionHandlers$1(this))} : (cya[]) invokeV.objValue;
    }

    public final void s(int i, Object obj) {
        q75 q75Var;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, obj) == null) {
            if (k().getWriteImagesInfo() == null) {
                k().setWriteImagesInfo(new WriteImagesInfo(9));
            }
            if (obj instanceof q75) {
                q75Var = (q75) obj;
            } else {
                q75Var = null;
            }
            if (q75Var == null) {
                return;
            }
            if (EmotionGroupType.isSendAsPic(q75Var.g())) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(q75Var.d());
                imageFileInfo.width = q75Var.i();
                imageFileInfo.height = q75Var.b();
                Function1<ImageFileInfo, Unit> h = l().h();
                if (h != null) {
                    h.invoke(imageFileInfo);
                    return;
                }
                return;
            }
            String d = q75Var.d();
            q75Var.g();
            JSONObject jSONObject = new JSONObject();
            EmotionGroupType g = q75Var.g();
            Intrinsics.checkNotNullExpressionValue(g, "data.type");
            b = iza.b(g);
            gl6.a(jSONObject, "type", b);
            gl6.a(jSONObject, "name", d);
            if (q75Var.g() != EmotionGroupType.LOCAL) {
                gl6.a(jSONObject, "width", Integer.valueOf(q75Var.i()));
                gl6.a(jSONObject, "height", Integer.valueOf(q75Var.b()));
                gl6.a(jSONObject, "pid", q75Var.e());
                gl6.a(jSONObject, "pname", q75Var.f());
            }
            g().invoke("writePageNa.addEmotion", jSONObject);
        }
    }
}

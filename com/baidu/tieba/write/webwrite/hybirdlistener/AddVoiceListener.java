package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.ac5;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.c4b;
import com.baidu.tieba.h3b;
import com.baidu.tieba.i3b;
import com.baidu.tieba.ij5;
import com.baidu.tieba.jj5;
import com.baidu.tieba.p3b;
import com.baidu.tieba.wi5;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.xq6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0016¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0015\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/AddVoiceListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "editor", "Lcom/baidu/tbadk/editortools/EditorTools;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;Lcom/baidu/tbadk/editortools/EditorTools;)V", "getEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "addDraftData", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "deleteVoice", "data", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "onEditorAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "playVoice", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "stopVoice", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AddVoiceListener extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditorTools g;

    @Override // com.baidu.tieba.k3b
    public i3b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (i3b[]) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a implements VoiceManager.IPlayView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceData.VoiceModel a;

        @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
        public VoiceManager.IPlayView getRealView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (VoiceManager.IPlayView) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
        public void onPlayElapse(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
        public void onPlayPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
        public void onRefreshByPlayStatus(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, voiceModel) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
        public void onShowErr(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            }
        }

        public a(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceModel;
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
        public VoiceData.VoiceModel getVoiceModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (VoiceData.VoiceModel) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddVoiceListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, c4b writePageState, EditorTools editor) {
        super(context, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, webView, writeData, writePageState, editor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (c4b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.g = editor;
    }

    @Override // com.baidu.tieba.write.webwrite.data.BizBase, com.baidu.tieba.k3b
    public Function1<JSONObject, Unit> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new Function1<JSONObject, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.AddVoiceListener$addDraftData$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddVoiceListener this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject json) {
                    JSONObject jsonForWrite;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, json) == null) {
                        Intrinsics.checkNotNullParameter(json, "json");
                        VoiceData.VoiceModel voiceModel = this.this$0.k().getVoiceModel();
                        if (voiceModel != null && (jsonForWrite = voiceModel.toJsonForWrite()) != null) {
                            xq6.a(json, "voice", jsonForWrite.optJSONObject("voice"));
                        }
                    }
                }
            };
        }
        return (Function1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k3b
    public h3b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new h3b[]{new p3b(new Integer[]{10, 11}, new AddVoiceListener$editorActionHandlers$1(this))} : (h3b[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k3b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new WrapListener[]{h().invoke("writePage.deleteVoice", new AddVoiceListener$keyListeners$1(this)), h().invoke("writePage.playVoice", new AddVoiceListener$keyListeners$2(this)), h().invoke("writePage.stopVoice", new AddVoiceListener$keyListeners$3(this))} : (WrapListener[]) invokeV.objValue;
    }

    public final void v(String str) {
        jj5 jj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                ac5.a(ac5.b(new JSONObject(str).optString("voiceId")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            k().setVoiceModel(null);
            ij5 p = this.g.p(6);
            if (p != null && (jj5Var = p.m) != null) {
                jj5Var.O(new wi5(52, 0, null));
            }
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            try {
                JSONObject jSONObject = new JSONObject(str);
                voiceModel.voiceId = jSONObject.optString("voiceId");
                voiceModel.duration = jSONObject.optInt("duration");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i().getPageActivity() instanceof VoiceManager.j) {
                Activity pageActivity = i().getPageActivity();
                if (pageActivity != null) {
                    VoiceManager P0 = ((VoiceManager.j) pageActivity).P0();
                    if (P0 != null) {
                        P0.startPlay(new a(voiceModel));
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.voice.VoiceManager.IVoiceActivity");
            }
        }
    }

    public final void w(wi5 wi5Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wi5Var) == null) {
            int i = wi5Var.a;
            if (i != 10) {
                if (i == 11) {
                    JSONObject jSONObject = new JSONObject();
                    VoiceData.VoiceModel voiceModel = k().getVoiceModel();
                    if (voiceModel != null) {
                        str = voiceModel.voiceId;
                    } else {
                        str = null;
                    }
                    jSONObject.put("voiceId", str);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                    v(jSONObject2);
                    g().invoke("writePageNa.deleteVoice", new JSONObject());
                    return;
                }
                throw new IllegalStateException("AddVoiceListener有没处理的action code:" + wi5Var.a);
            }
            Object obj = wi5Var.c;
            if (obj instanceof VoiceData.VoiceModel) {
                if (obj != null) {
                    VoiceData.VoiceModel voiceModel2 = (VoiceData.VoiceModel) obj;
                    Function2<String, JSONObject, Unit> g = g();
                    JSONObject jsonForWrite = voiceModel2.toJsonForWrite();
                    Intrinsics.checkNotNullExpressionValue(jsonForWrite, "voiceModel.toJsonForWrite()");
                    g.invoke("writePageNa.addVoice", jsonForWrite);
                    k().setVoiceModel(voiceModel2);
                    k().setVoice(voiceModel2.voiceId);
                    k().setVoiceDuringTime(voiceModel2.duration);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.VoiceData.VoiceModel");
            }
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (i().getPageActivity() instanceof VoiceManager.j)) {
            Activity pageActivity = i().getPageActivity();
            if (pageActivity != null) {
                VoiceManager P0 = ((VoiceManager.j) pageActivity).P0();
                if (P0 != null) {
                    P0.stopPlay();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.voice.VoiceManager.IVoiceActivity");
        }
    }
}

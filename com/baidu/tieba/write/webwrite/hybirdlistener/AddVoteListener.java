package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.ebb;
import com.baidu.tieba.fbb;
import com.baidu.tieba.icb;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mdb;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.zbb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0017H\u0016¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020&H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006'"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/AddVoteListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "editor", "Lcom/baidu/tbadk/editortools/EditorTools;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;Lcom/baidu/tbadk/editortools/EditorTools;)V", "getEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "addDraftData", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "deleteVote", "data", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "onActivityResult", "Landroid/content/Intent;", "onOpenVote", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "startVote", "id", "", "", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AddVoteListener extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditorTools g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddVoteListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, zbb writePageState, EditorTools editor) {
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
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (zbb) objArr2[3]);
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

    @Override // com.baidu.tieba.hbb
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WrapListener[]{h().invoke("writePage.addVote", new AddVoteListener$keyListeners$1(this)), h().invoke("writePage.deleteVote", new AddVoteListener$keyListeners$2(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hbb
    public fbb[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new fbb[]{o(25048, new AddVoteListener$requestCodeHandlers$1(this))} : (fbb[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.webwrite.data.BizBase, com.baidu.tieba.hbb
    public Function1<JSONObject, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new Function1<JSONObject, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.AddVoteListener$addDraftData$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddVoteListener this$0;

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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, json) == null) {
                        Intrinsics.checkNotNullParameter(json, "json");
                        WriteVoteData writeVoteData = this.this$0.k().getWriteVoteData();
                        if (writeVoteData != null) {
                            JSONKt.c(json, "vote_data", writeVoteData.toJsonObject());
                        }
                    }
                }
            };
        }
        return (Function1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hbb
    public ebb[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new ebb[]{n(22, new AddVoteListener$editorActionHandlers$1(this))} : (ebb[]) invokeV.objValue;
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            k().setWriteVoteData(null);
        }
    }

    public final void w(Intent intent) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            WriteVoteData writeVoteData = null;
            if (intent != null) {
                serializable = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            } else {
                serializable = null;
            }
            if (serializable instanceof WriteVoteData) {
                writeVoteData = (WriteVoteData) serializable;
            }
            if (writeVoteData != null) {
                k().setWriteVoteData(writeVoteData);
                Function2<String, JSONObject, Unit> g = g();
                JSONObject jsonObject = writeVoteData.toJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "it.toJsonObject()");
                g.invoke("writePageNa.addVoteResult", jsonObject);
                q();
            }
        }
    }

    public final void x(String str) {
        WriteVoteData b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("write", "收到H5通知，编辑投票：" + str);
            try {
                b = icb.b(str);
                WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(i().getPageActivity(), 25048);
                if (b != null) {
                    writeVoteActivityConfig.setExtraData(b);
                }
                i().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
            } catch (Exception e) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("write", "编辑投票：失败：" + e);
            }
        }
    }

    public final void y(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, obj) == null) {
            this.g.y();
            mdb.b(i().getPageActivity(), 10);
            WriteVoteData writeVoteData = k().getWriteVoteData();
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(i().getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            i().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
        }
    }
}

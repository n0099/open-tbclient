package com.baidu.tieba.write.webwrite.data;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.JSONLikeSerializable;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.br6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.ghb;
import com.baidu.tieba.he5;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.ngb;
import com.baidu.tieba.nya;
import com.baidu.tieba.phb;
import com.baidu.tieba.ugb;
import com.baidu.tieba.wfb;
import com.baidu.tieba.write.webwrite.hybirdlistener.AddVoiceListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.AddVoteListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.AtSelectListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.BubbleBizListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.EditorStatusListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.EmotionBiz;
import com.baidu.tieba.write.webwrite.hybirdlistener.ForumRegionQADialogListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.ItemSelectListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.LinkBizListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.QuestionTagListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.SwanAppGoodsListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.TopicSelectListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.UpdateWriteDataBiz;
import com.baidu.tieba.write.webwrite.hybirdlistener.VideoBizListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H&J\"\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'J\u001a\u0010(\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'J\u0018\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010'J\u000e\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020!J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020!2\u0006\u0010&\u001a\u00020'J\u000e\u00106\u001a\u00020!2\u0006\u0010$\u001a\u00020%J*\u00107\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020:2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<J$\u0010=\u001a\u00020!2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010>\u001a\u00020?2\u0006\u00109\u001a\u00020:H&R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/baidu/tieba/write/webwrite/data/WriteDataManager;", "", "()V", "bizBus", "Lcom/baidu/tieba/write/webwrite/data/BizBus;", "getBizBus", "()Lcom/baidu/tieba/write/webwrite/data/BizBus;", "bizBus$delegate", "Lkotlin/Lazy;", "localFiles", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "getMData", "()Lcom/baidu/tbadk/coreExtra/data/WriteData;", "mData$delegate", "mWebView", "Lcom/baidu/tieba/browser/TbWebView;", "getMWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "setMWebView", "(Lcom/baidu/tieba/browser/TbWebView;)V", "mWritePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "getMWritePageState", "()Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "setMWritePageState", "(Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "updateWriteDataBiz", "Lcom/baidu/tieba/write/webwrite/hybirdlistener/UpdateWriteDataBiz;", "initCustomData", "", "initData", "writePageState", "savedInstanceState", "Landroid/os/Bundle;", "intent", "Landroid/content/Intent;", "initFromIntent", "onActivityResultOK", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "", "data", "onAddDraftData", "json", "Lorg/json/JSONObject;", MissionEvent.MESSAGE_DESTROY, "onEditorAction", "", "action", "Lcom/baidu/tbadk/editortools/Action;", "onNewIntent", "onSaveInstanceState", "registerBizListener", "webView", "editor", "Lcom/baidu/tbadk/editortools/EditorTools;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "registerCustomBizListener", "fileInterceptor", "Lcom/baidu/tieba/write/webwrite/ability/LocalFileInterceptor;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class WriteDataManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ugb a;
    public final HashMap<String, String> b;
    public TbWebView c;
    public UpdateWriteDataBiz d;
    public final Lazy e;
    public final Lazy f;

    public abstract void e();

    public abstract void o(TbPageContext<?> tbPageContext, wfb wfbVar, EditorTools editorTools);

    public WriteDataManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<WriteData>(this) { // from class: com.baidu.tieba.write.webwrite.data.WriteDataManager$mData$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteDataManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WriteData invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (this.this$0.d().p() == null && TbadkCoreApplication.getInst().isDebugMode()) {
                        throw new RuntimeException("write page must init isFromErrorDialog before use WriteData");
                    }
                    if (Intrinsics.areEqual(this.this$0.d().p(), Boolean.TRUE)) {
                        return nya.f;
                    }
                    return new WriteData();
                }
                return (WriteData) invokeV.objValue;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(WriteDataManager$bizBus$2.INSTANCE);
    }

    public final BizBus a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (BizBus) this.f.getValue();
        }
        return (BizBus) invokeV.objValue;
    }

    public final WriteData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object value = this.e.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mData>(...)");
            return (WriteData) value;
        }
        return (WriteData) invokeV.objValue;
    }

    public final TbWebView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbWebView tbWebView = this.c;
            if (tbWebView != null) {
                return tbWebView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mWebView");
            return null;
        }
        return (TbWebView) invokeV.objValue;
    }

    public final ugb d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ugb ugbVar = this.a;
            if (ugbVar != null) {
                return ugbVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mWritePageState");
            return null;
        }
        return (ugb) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a().h();
        }
    }

    public final void f(ugb writePageState, Bundle bundle, Intent intent) {
        Boolean bool;
        String str;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, writePageState, bundle, intent) == null) {
            Intrinsics.checkNotNullParameter(writePageState, "writePageState");
            q(writePageState);
            ugb d = d();
            boolean z3 = false;
            if (bundle == null && intent != null) {
                if (intent.getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false)) {
                    WriteData writeData = nya.f;
                    if (writeData != null && d().F() == writeData.getType()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z = true;
                        bool = Boolean.valueOf(z);
                    }
                }
                z = false;
                bool = Boolean.valueOf(z);
            } else {
                bool = Boolean.FALSE;
            }
            d.w(bool);
            ugb d2 = d();
            if (intent != null) {
                str = intent.getStringExtra(WriteActivityConfig.SHOW_NOT_SAVE_POPUP);
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            d2.z(str);
            if (bundle != null) {
                phb.a.b(bundle, b());
            } else if (intent != null) {
                WriteData b = b();
                Boolean p = d().p();
                if (p != null) {
                    z3 = p.booleanValue();
                }
                b.setFromErrorDialog(z3);
                phb.a.c(intent, b());
                Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.KEY_WEBVIEW_DATA);
                if (serializableExtra instanceof JSONLikeSerializable) {
                    d().C(((JSONLikeSerializable) serializableExtra).toJsonObject());
                }
            }
            b().setNewWritePage(true);
            b().setWriteTest(true);
            e();
        }
    }

    public final void g(Bundle bundle, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, intent) == null) {
            a().e(bundle, intent);
        }
    }

    public final void h(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, intent) == null) {
            a().f(i, intent);
        }
    }

    public final void i(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            a().g(json);
        }
    }

    public final void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            a().j(intent);
        }
    }

    public final void m(Bundle savedInstanceState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, savedInstanceState) == null) {
            Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
            a().k(savedInstanceState);
        }
    }

    public final void p(TbWebView tbWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbWebView) == null) {
            Intrinsics.checkNotNullParameter(tbWebView, "<set-?>");
            this.c = tbWebView;
        }
    }

    public final void q(ugb ugbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ugbVar) == null) {
            Intrinsics.checkNotNullParameter(ugbVar, "<set-?>");
            this.a = ugbVar;
        }
    }

    public final boolean k(he5 action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, action)) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
            if (!d().q()) {
                d().A(true);
                br6.b().c(new ngb());
            }
            if (a().i(action)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void n(ugb mWritePageState, TbWebView webView, EditorTools editor, TbPageContext<?> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, mWritePageState, webView, editor, pageContext) == null) {
            Intrinsics.checkNotNullParameter(mWritePageState, "mWritePageState");
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(editor, "editor");
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            wfb wfbVar = new wfb(this.b, b());
            p(webView);
            c().setTargetInterceptor(wfbVar);
            this.d = new UpdateWriteDataBiz(pageContext, c(), b(), mWritePageState, new WriteDataManager$registerBizListener$1(this));
            BizBus a = a();
            UpdateWriteDataBiz updateWriteDataBiz = this.d;
            if (updateWriteDataBiz == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateWriteDataBiz");
                updateWriteDataBiz = null;
            }
            a.l(updateWriteDataBiz);
            a().l(new QuestionTagListener(pageContext, c(), b(), mWritePageState));
            a().l(new EditorStatusListener(pageContext, c(), b(), mWritePageState, editor));
            a().l(new EmotionBiz(pageContext, c(), b(), mWritePageState));
            a().l(new TopicSelectListener(pageContext, c(), b(), mWritePageState, editor));
            a().l(new AddVoteListener(pageContext, c(), b(), mWritePageState, editor));
            a().l(new ItemSelectListener(pageContext, c(), b(), mWritePageState));
            a().l(new AtSelectListener(pageContext, c(), b(), mWritePageState, editor));
            a().l(new SwanAppGoodsListener(pageContext, c(), b(), mWritePageState));
            a().l(new ForumRegionQADialogListener(pageContext, c(), b(), mWritePageState));
            a().l(new AddVoiceListener(pageContext, c(), b(), mWritePageState, editor));
            a().l(new ghb(pageContext, c(), b(), mWritePageState, editor));
            a().l(new LinkBizListener(pageContext, c(), b(), mWritePageState));
            a().l(new VideoBizListener(pageContext, c(), b(), mWritePageState, editor));
            a().l(new BubbleBizListener(pageContext, c(), b(), mWritePageState));
            o(pageContext, wfbVar, editor);
        }
    }
}

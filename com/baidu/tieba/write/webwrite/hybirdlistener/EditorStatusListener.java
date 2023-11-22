package com.baidu.tieba.write.webwrite.hybirdlistener;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.ebb;
import com.baidu.tieba.fbb;
import com.baidu.tieba.ibb;
import com.baidu.tieba.jcb;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nq6;
import com.baidu.tieba.sbb;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.zbb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000*\u0001\u0011\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0015\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020(H\u0002R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/EditorStatusListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "Lcom/baidu/tieba/write/webwrite/data/Clean;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "editor", "Lcom/baidu/tbadk/editortools/EditorTools;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;Lcom/baidu/tbadk/editortools/EditorTools;)V", "getEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "editorDeskListener", "com/baidu/tieba/write/webwrite/hybirdlistener/EditorStatusListener$editorDeskListener$1", "Lcom/baidu/tieba/write/webwrite/hybirdlistener/EditorStatusListener$editorDeskListener$1;", "hasCheckLink", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", MissionEvent.MESSAGE_DESTROY, "", "onOpenEditor", "data", "", "refreshEditorToolStatus", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "setAiWrite", "id", "", "", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EditorStatusListener extends BizBase implements ibb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditorTools g;
    public final a h;
    public boolean i;

    @Override // com.baidu.tieba.hbb
    public fbb[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (fbb[]) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorStatusListener a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EditorStatusListener editorStatusListener) {
            super(2010046);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorStatusListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorStatusListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    JSONObject jSONObject = new JSONObject();
                    if (booleanValue) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    } else {
                        i = 0;
                    }
                    JSONKt.c(jSONObject, "height", Integer.valueOf(i));
                    JSONKt.c(jSONObject, "animationDuration", Float.valueOf(1.0f));
                    this.a.g().invoke("writePageNa.showEditorDesk", jSONObject);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorStatusListener(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, zbb writePageState, EditorTools editor) {
        super(pageContext, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, writeData, writePageState, editor};
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
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.g = editor;
        this.h = new a(this);
        MessageManager.getInstance().registerListener(this.h);
    }

    public final void w(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, obj) == null) {
            g().invoke("writePageNa.postOpenAiWrite", new JSONObject());
        }
    }

    @Override // com.baidu.tieba.hbb
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WrapListener[]{h().invoke("writePage.openEditor", new EditorStatusListener$keyListeners$1(this)), h().invoke("writePage.refreshEditorStatus", new EditorStatusListener$keyListeners$2(this)), h().invoke("writePage.selectCurrentPage", new Function1<String, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.EditorStatusListener$keyListeners$3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EditorStatusListener this$0;

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
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String data) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    this.this$0.l().A(true);
                    nq6.b().c(new sbb());
                }
            }
        }), h().invoke("writePage.refreshPostButtonStatus", new Function1<String, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.EditorStatusListener$keyListeners$4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EditorStatusListener this$0;

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
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String data) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    try {
                        this.this$0.l().t(new JSONObject(data).optBoolean("canPost", false));
                        this.this$0.q();
                    } catch (Exception unused) {
                    }
                }
            }
        })} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hbb
    public ebb[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ebb[]{n(77, new EditorStatusListener$editorActionHandlers$1(this))} : (ebb[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ibb
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("write", "收到H5通知，ChangeEditorVisibleListener：" + str);
            if (!Intrinsics.areEqual(TbadkCoreApplication.getInst().getCurrentActivity(), i().getPageActivity())) {
                DefaultLog.getInstance().i("write", "收到H5通知，但发贴activity已不在栈顶");
                return;
            }
            try {
                String optString = new JSONObject(str).optString("type", "");
                if (optString != null) {
                    switch (optString.hashCode()) {
                        case 3202370:
                            if (optString.equals("hide") && this.g.E()) {
                                this.g.v();
                                break;
                            }
                            break;
                        case 843380153:
                            if (!optString.equals("hideTools")) {
                                break;
                            } else {
                                this.g.y();
                                break;
                            }
                        case 1671764162:
                            if (optString.equals(CriusAttrConstants.DISPLAY) && !this.g.E()) {
                                this.g.m();
                                if (!this.i) {
                                    this.i = true;
                                    l().a();
                                    break;
                                }
                            }
                            break;
                        case 2138863155:
                            if (!optString.equals("hideSoftKey")) {
                                break;
                            } else {
                                this.g.w();
                                break;
                            }
                    }
                }
            } catch (Exception e) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("write", "ChangeEditorVisibleListener：失败：" + e);
            }
        }
    }

    public final void v(String str) {
        int i;
        String str2;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("write", "收到H5通知，刷新底部操作区可用状态：" + str);
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
                if (optJSONArray == null) {
                    return;
                }
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                        i = jcb.b(optString);
                    } else {
                        i = -2;
                    }
                    if (optJSONObject != null) {
                        str2 = optJSONObject.optString("status");
                    } else {
                        str2 = null;
                    }
                    boolean areEqual = Intrinsics.areEqual(str2, "1");
                    if (i != -2) {
                        this.g.setToolEnabled(areEqual, i);
                    }
                }
            } catch (Exception e) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("write", "刷新底部操作区可用状态：失败：" + e);
            }
        }
    }
}

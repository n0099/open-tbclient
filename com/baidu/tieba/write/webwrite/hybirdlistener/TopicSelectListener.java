package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.cd5;
import com.baidu.tieba.cya;
import com.baidu.tieba.dya;
import com.baidu.tieba.k0b;
import com.baidu.tieba.kya;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.xya;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001eH\u0002J5\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0010H\u0016¢\u0006\u0002\u0010(R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/TopicSelectListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "editor", "Lcom/baidu/tbadk/editortools/EditorTools;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;Lcom/baidu/tbadk/editortools/EditorTools;)V", "getEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "onActivityResult", "", "data", "Landroid/content/Intent;", "onEditorAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "onSelectTopic", "", "openSelectHotTopicActivity", "forumId", "", "firstDir", "secondDir", "refer", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TopicSelectListener extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditorTools g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicSelectListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, xya writePageState, EditorTools editor) {
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
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (xya) objArr2[3]);
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

    @Override // com.baidu.tieba.fya
    public cya[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new cya[]{new kya(new Integer[]{43}, new TopicSelectListener$editorActionHandlers$1(this))} : (cya[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fya
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WrapListener[]{h().invoke("writePage.topicSelect", new TopicSelectListener$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fya
    public dya[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new dya[]{o(25004, new TopicSelectListener$requestCodeHandlers$1(this))} : (dya[]) invokeV.objValue;
    }

    public final void u(Intent intent) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            if (intent != null) {
                str = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String stringExtra = intent.getStringExtra(HotSelectActivityConfig.HOT_TOPIC_REFER_STRING);
            if (stringExtra == null) {
                stringExtra = "";
            }
            jSONObject.put("refer", stringExtra);
            jSONObject.put("topicName", str);
            g().invoke("writePageNa.topicSelectResult", jSONObject);
        }
    }

    public final void v(cd5 cd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cd5Var) == null) {
            if (cd5Var.a == 43) {
                k0b.b(i().getPageActivity(), 4);
                SharedPrefHelper.getInstance().putBoolean("hot_topic_has_click", true);
                this.g.D(new cd5(2, 26, null));
                this.g.r();
                x(Long.valueOf(JavaTypesHelper.toLong(k().getForumId(), 0L)), k().getFirstDir(), k().getSecondDir(), "");
                return;
            }
            throw new IllegalStateException("TopicSelectListener有没处理的action code:" + cd5Var.a);
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("write", "收到H5通知，选择话题：" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                Long valueOf = Long.valueOf(JavaTypesHelper.toLong(jSONObject.optString("fid", k().getForumId()), 0L));
                String firstDir = k().getFirstDir();
                if (firstDir == null) {
                    firstDir = "";
                }
                String optString = jSONObject.optString(TiebaStatic.Params.FIRST_DIR, firstDir);
                String secondDir = k().getSecondDir();
                if (secondDir == null) {
                    secondDir = "";
                }
                x(valueOf, optString, jSONObject.optString(TiebaStatic.Params.SECOND_DIR, secondDir), jSONObject.optString("refer", ""));
            } catch (Exception e) {
                TbLog hybridLog2 = HybridLog.getInstance();
                hybridLog2.i("write", "选择话题：失败：" + e);
            }
        }
    }

    public final void x(Long l, String str, String str2, String str3) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, l, str, str2, str3) == null) {
            this.g.t();
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(i().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            hotSelectActivityConfig.addRefer(str3);
            hotSelectActivityConfig.setNoSign();
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            hotSelectActivityConfig.setForumExtra(j, str, str2);
            i().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }
}

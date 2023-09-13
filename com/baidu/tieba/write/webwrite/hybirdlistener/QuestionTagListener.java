package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.QuestionTagChooseActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.c7b;
import com.baidu.tieba.f7b;
import com.baidu.tieba.k2b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.QuestionTagListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0015\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0013H\u0016¢\u0006\u0002\u0010!R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/QuestionTagListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "getContext", "()Lcom/baidu/tbadk/TbPageContext;", "createQuestionTag", "", "refer", "", "defaultCategory", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "onResult", "requestCode", "", "data", "Landroid/content/Intent;", "onSelectQuestionTag", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class QuestionTagListener extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> g;

    @Override // com.baidu.tieba.s1b
    public p1b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (p1b[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionTagListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, k2b writePageState) {
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
        this.g = context;
    }

    public final void t(final String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            new f7b().u(this.g.getPageActivity(), str2, k().getForumId(), new c7b() { // from class: com.baidu.tieba.m2b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.c7b
                public final void a(QuestionTagListData.QuestionTag questionTag) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, questionTag) == null) {
                        QuestionTagListener.u(str, this, questionTag);
                    }
                }
            });
        }
    }

    public static final void u(String refer, QuestionTagListener this$0, QuestionTagListData.QuestionTag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, refer, this$0, tag) == null) {
            Intrinsics.checkNotNullParameter(refer, "$refer");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tag, "tag");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PushConstants.SUB_TAGS_STATUS_ID, tag.id);
            jSONObject.put(PushConstants.SUB_TAGS_STATUS_NAME, tag.tagName);
            jSONObject.put("is_question_tag_manual_created", true);
            jSONObject.put("refer", refer);
            this$0.k().setQuestionTagId(tag.id);
            this$0.k().setQuestionTagManualCreated(true);
            this$0.g().invoke("writePageNa.selectQuestionTagResult", jSONObject);
        }
    }

    @Override // com.baidu.tieba.s1b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WrapListener[]{h().invoke("writePage.selectQuestionTag", new QuestionTagListener$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    public q1b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new q1b[]{p(25072, new QuestionTagListener$requestCodeHandlers$1(this))} : (q1b[]) invokeV.objValue;
    }

    public final TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void v(int i, Intent intent) {
        String str;
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, intent) == null) {
            QuestionTagListData.QuestionTag questionTag = null;
            if (intent != null) {
                str = intent.getStringExtra(QuestionTagChooseActivityConfig.KEY_QUESTION_TAG_REFER);
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (intent != null) {
                z = intent.getBooleanExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, false);
            } else {
                z = false;
            }
            if (intent != null) {
                str2 = intent.getStringExtra(QuestionTagChooseActivityConfig.KEY_QUESTION_TAG_DEFAULT_CATEGORY);
            } else {
                str2 = null;
            }
            if (str2 != null) {
                str3 = str2;
            }
            if (z) {
                t(str, str3);
                return;
            }
            if (intent != null) {
                questionTag = (QuestionTagListData.QuestionTag) intent.getParcelableExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_TAG);
            }
            if (questionTag == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PushConstants.SUB_TAGS_STATUS_ID, questionTag.id);
            jSONObject.put(PushConstants.SUB_TAGS_STATUS_NAME, questionTag.tagName);
            jSONObject.put("is_question_tag_manual_created", false);
            jSONObject.put("refer", str);
            k().setQuestionTagId(questionTag.id);
            k().setQuestionTagManualCreated(false);
            g().invoke("writePageNa.selectQuestionTagResult", jSONObject);
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                QuestionTagChooseActivityConfig questionTagChooseActivityConfig = new QuestionTagChooseActivityConfig(this.g.getPageActivity());
                String defaultCategory = jSONObject.optString("default_category");
                String optString = jSONObject.optString(WriteActivityConfig.FORUM_FIRST_CATEGORY);
                String optString2 = jSONObject.optString("fid");
                String refer = jSONObject.optString("refer");
                k().setForumId(optString2);
                if (StringUtils.isNotNull(optString)) {
                    questionTagChooseActivityConfig.setCategory(optString);
                    questionTagChooseActivityConfig.setKeyQuestionTagDefaultCategory(defaultCategory);
                    questionTagChooseActivityConfig.setKeyQuestionTagRefer(refer);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, questionTagChooseActivityConfig));
                } else {
                    Intrinsics.checkNotNullExpressionValue(refer, "refer");
                    Intrinsics.checkNotNullExpressionValue(defaultCategory, "defaultCategory");
                    t(refer, defaultCategory);
                }
            } catch (Exception unused) {
            }
        }
    }
}

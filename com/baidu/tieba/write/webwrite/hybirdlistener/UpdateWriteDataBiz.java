package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.f3b;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.iza;
import com.baidu.tieba.k2b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.qq6;
import com.baidu.tieba.rj6;
import com.baidu.tieba.rq6;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.UpdateWriteDataBiz;
import com.baidu.tieba.x2b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010H\u0016¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0015\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u00020\"2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\"H\u0002J\u0018\u0010&\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010'\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\fH\u0002¨\u0006*"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/UpdateWriteDataBiz;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "onAddDraftData", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;Lkotlin/jvm/functions/Function1;)V", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "getBubbleData", "getInitData", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "notifyDeleteInput", "id", "", "data", "", "notifyFocusNotClear", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "richContentToJson", "", "richContentData", "", "updateDataAndUse", "updatePrivacy", "updateVirtualImg", "updateWriteData", "json", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UpdateWriteDataBiz extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.s1b
    public q1b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (q1b[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateWriteDataBiz(TbPageContext<?> pageContext, TbWebView webView, final WriteData writeData, k2b writePageState, final Function1<? super JSONObject, Unit> onAddDraftData) {
        super(pageContext, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, writeData, writePageState, onAddDraftData};
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
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        Intrinsics.checkNotNullParameter(onAddDraftData, "onAddDraftData");
        webView.H(WebViewActivityConfig.TAG_PAGE_DATA, new rj6() { // from class: com.baidu.tieba.r2b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? UpdateWriteDataBiz.r(UpdateWriteDataBiz.this) : invokeV.objValue;
            }
        });
        webView.H("draftData", new rj6() { // from class: com.baidu.tieba.p2b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? UpdateWriteDataBiz.s(WriteData.this, this, onAddDraftData) : invokeV.objValue;
            }
        });
        webView.H("bubbleData", new rj6() { // from class: com.baidu.tieba.n2b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? UpdateWriteDataBiz.t(UpdateWriteDataBiz.this) : invokeV.objValue;
            }
        });
    }

    public static final Object r(UpdateWriteDataBiz this$0) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, this$0)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return this$0.A();
        }
        return invokeL.objValue;
    }

    public static final Object t(UpdateWriteDataBiz this$0) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, this$0)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return this$0.z();
        }
        return invokeL.objValue;
    }

    public static final Object s(WriteData writeData, UpdateWriteDataBiz this$0, Function1 onAddDraftData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, writeData, this$0, onAddDraftData)) == null) {
            Intrinsics.checkNotNullParameter(writeData, "$writeData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(onAddDraftData, "$onAddDraftData");
            JSONObject jSONObject = new JSONObject();
            rq6.a(jSONObject, "title", writeData.getTitle());
            if (TextUtils.isEmpty(writeData.getContent()) && writeData.getRichContentData() != null) {
                rq6.a(jSONObject, "content", this$0.D(writeData.getRichContentData()));
            } else {
                rq6.a(jSONObject, "content", writeData.getContent());
            }
            rq6.a(jSONObject, "fid", writeData.getForumId());
            rq6.a(jSONObject, TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
            rq6.a(jSONObject, "topic_id", writeData.getTopicId());
            rq6.a(jSONObject, "post_prefix", writeData.getPostPrefix());
            rq6.a(jSONObject, "is_question", Boolean.valueOf(writeData.isQuestionThread()));
            rq6.a(jSONObject, "selectForumInfo", writeData.getSelectForumInfo());
            onAddDraftData.invoke(jSONObject);
            return jSONObject;
        }
        return invokeLLL.objValue;
    }

    public final void B(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, obj) == null) {
            g().invoke("writePageNa.deleteInput", new JSONObject());
        }
    }

    public final void C(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
            g().invoke("writePageNa.focusNotClear", new JSONObject());
        }
    }

    public final void F(int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, obj) == null) && (obj instanceof Boolean)) {
            k().setPrivacy(((Boolean) obj).booleanValue());
        }
    }

    public final void G(int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, obj) == null) && (obj instanceof Boolean)) {
            k().setShowCustomFigure(((Boolean) obj).booleanValue());
        }
    }

    public final JSONObject A() {
        InterceptResult invokeV;
        String b;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject4 = new JSONObject();
            b = x2b.b(k().getType());
            rq6.a(jSONObject4, "type", b);
            rq6.a(jSONObject4, "fid", k().getForumId());
            rq6.a(jSONObject4, TiebaStatic.Params.H5_FORUM_NAME, k().getForumName());
            rq6.a(jSONObject4, TiebaStatic.Params.FIRST_DIR, k().getFirstDir());
            rq6.a(jSONObject4, TiebaStatic.Params.SECOND_DIR, k().getSecondDir());
            rq6.a(jSONObject4, "tid", k().getThreadId());
            rq6.a(jSONObject4, "title", k().getTitle());
            rq6.a(jSONObject4, "content", k().getContent());
            rq6.a(jSONObject4, IntentConfig.CALL_FROM, k().getCallFrom());
            rq6.a(jSONObject4, "isInterceptWriteResultDialog", Boolean.valueOf(k().isInterceptWriteResultDialog()));
            rq6.a(jSONObject4, "isPutStorageTid", Boolean.valueOf(k().isPutStorageTid()));
            PostPrefixData prefixData = k().getPrefixData();
            String str = null;
            if (prefixData != null) {
                jSONObject = prefixData.toJsonObject();
            } else {
                jSONObject = null;
            }
            rq6.a(jSONObject4, BaseWriteConfig.PREFIX_DATA, jSONObject);
            rq6.a(jSONObject4, "from", k().getFrom());
            rq6.a(jSONObject4, "topic_id", k().getTopicId());
            rq6.a(jSONObject4, "statistic_from", Integer.valueOf(k().getStatisticFrom()));
            rq6.a(jSONObject4, BaseWriteConfig.PRIVATE_THREAD, Integer.valueOf(k().getPrivateThread()));
            FrsTabInfoData frsTabInfoData = k().getFrsTabInfoData();
            if (frsTabInfoData != null) {
                jSONObject2 = frsTabInfoData.toJsonObject();
            } else {
                jSONObject2 = null;
            }
            rq6.a(jSONObject4, "frs_tab_info_data", jSONObject2);
            rq6.a(jSONObject4, "isCanGoods", Boolean.valueOf(k().isCanGoods()));
            rq6.a(jSONObject4, "isVoiceEnable", Boolean.valueOf(k().isVoiceEnable()));
            rq6.a(jSONObject4, WriteActivityConfig.DISABLE_AUDIO_MESSAGE, k().getDisableAudioMessage());
            rq6.a(jSONObject4, "isNotificationH5", Boolean.valueOf(k().isNotificationH5()));
            rq6.a(jSONObject4, "isNotFakePost", Boolean.valueOf(k().isNotFakePost()));
            rq6.a(jSONObject4, "active_name", k().getActiveName());
            rq6.a(jSONObject4, "active_task_name", k().getActiveTaskName());
            rq6.a(jSONObject4, "hint_text", k().getHintText());
            rq6.a(jSONObject4, "input_insert_at_list", k().getInputInsertAtList());
            WriteVoteData writeVoteData = k().getWriteVoteData();
            if (writeVoteData != null) {
                jSONObject3 = writeVoteData.toJsonObject();
            } else {
                jSONObject3 = null;
            }
            rq6.a(jSONObject4, "vote_data", jSONObject3);
            rq6.a(jSONObject4, "isFromItemDetail", Boolean.valueOf(k().isFromItemDetail()));
            rq6.a(jSONObject4, "intent_start_count", Integer.valueOf(k().getIntentStarCount()));
            SerializableItemInfo intentItemInfo = k().getIntentItemInfo();
            if (intentItemInfo != null) {
                str = intentItemInfo.toJson();
            }
            rq6.a(jSONObject4, "intent_item_info", str);
            rq6.a(jSONObject4, "item_id", k().getItem_id());
            rq6.a(jSONObject4, "isSaveDraft", Boolean.valueOf(k().isSaveDraft()));
            rq6.a(jSONObject4, "more_forum_img", k().getMoreForumImg());
            rq6.a(jSONObject4, "more_forum_title", k().getMoreForumTitle());
            rq6.a(jSONObject4, "more_forum_url", k().getMoreForumUrl());
            rq6.a(jSONObject4, WriteActivityConfig.IS_ARTICLE, k().getIsArticle());
            rq6.a(jSONObject4, "isFromGameRank", Boolean.valueOf(k().isFromGameRank()));
            rq6.a(jSONObject4, "game_id", k().getGameId());
            rq6.a(jSONObject4, "game_name", k().getGameName());
            rq6.a(jSONObject4, "rewards_type", k().getRewardsType());
            rq6.a(jSONObject4, "xiuxiu_original_content", k().getXiuxiuOriginalContent());
            rq6.a(jSONObject4, "xiuxiu_original_fname", k().getXiuxiuOriginalFname());
            rq6.a(jSONObject4, "entrance_type", Integer.valueOf(k().getEntranceType()));
            rq6.a(jSONObject4, "isFromErrorDialog", Boolean.valueOf(k().isFromErrorDialog()));
            rq6.a(jSONObject4, "net_img_url", k().getNetImgUrl());
            rq6.a(jSONObject4, WriteActivityConfig.FORUM_FIRST_CATEGORY, k().getFirstClass());
            rq6.a(jSONObject4, "question_tag_id", k().getQuestionTagId());
            if (SharedPrefHelper.getInstance().getBoolean(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                rq6.a(jSONObject4, "isAgreeProtocol", 1);
            } else {
                rq6.a(jSONObject4, "isAgreeProtocol", 0);
            }
            rq6.a(jSONObject4, WriteActivityConfig.KEY_WEBVIEW_DATA, l().m());
            return jSONObject4;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String D(List<? extends Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (obj instanceof String) {
                    sb.append((String) obj);
                } else if (obj instanceof ImageFileInfo) {
                    sb.append("\n");
                    sb.append(iza.c + f3b.a.a((ImageFileInfo) obj, i) + iza.a.d());
                }
                i = i2;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "strBuilder.toString()");
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final void E(String str) {
        JSONObject a;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || (a = qq6.a.a(str)) == null) {
            return;
        }
        H(a);
        int optInt = a.optInt("type", 0);
        if (optInt != 1) {
            if (optInt == 2) {
                l().b();
                l().l().a();
                return;
            }
            return;
        }
        l().r(k().getForumId());
        l().g().d();
        k2b.d(l(), 0, 1, null);
    }

    public final void H(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            k().setTitle(jSONObject.optString("title", k().getTitle()));
            WriteData k = k();
            String content = k().getContent();
            if (content == null) {
                content = "";
            }
            k.setContent(jSONObject.optString("content", content));
            k().setForumId(jSONObject.optString("fid", k().getForumId()));
            k().setForumName(jSONObject.optString(TiebaStatic.Params.H5_FORUM_NAME, k().getForumName()));
            k().setTabId(jSONObject.optInt("tab_id", k().getTabId()));
            k().setTabName(jSONObject.optString("tab_name", k().getTabName()));
            k().setIsGeneralTab(jSONObject.optInt("is_general_tab", k().getIsGeneralTab()));
            k().setPostPrefix(jSONObject.optString("post_prefix", k().getPostPrefix()));
            k().setSelectForumInfo(jSONObject.optJSONObject("selectForumInfo"));
        }
    }

    @Override // com.baidu.tieba.s1b
    public p1b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new p1b[]{n(55, new UpdateWriteDataBiz$editorActionHandlers$1(this)), n(66, new UpdateWriteDataBiz$editorActionHandlers$2(this)), n(3, new UpdateWriteDataBiz$editorActionHandlers$3(this)), n(74, new UpdateWriteDataBiz$editorActionHandlers$4(this))} : (p1b[]) invokeV.objValue;
    }

    public final JSONObject z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(TbadkCoreApplication.getInst().getDefaultIosBUrl())) {
                jSONObject.put("b_url", TbadkCoreApplication.getInst().getDefaultIosBUrl());
            } else {
                jSONObject.put("b_url", TbadkCoreApplication.getInst().getDefaultBubble());
            }
            jSONObject.put("dynamic_url", TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
            jSONObject.put("ios_bimg_format", TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new WrapListener[]{h().invoke("writePage.updateWriteData", new UpdateWriteDataBiz$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }
}

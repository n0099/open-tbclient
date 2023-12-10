package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.tieba.rma;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zs4 implements qj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        pj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void onDestroy() {
        pj6.b(this);
    }

    /* loaded from: classes9.dex */
    public class a extends nu5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(zs4 zs4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public ImMessageCenterPojo doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return iu8.f().i(this.a);
            }
            return (ImMessageCenterPojo) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements st5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ArrayList b;

        public b(zs4 zs4Var, String str, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs4Var, str, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, imMessageCenterPojo) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (imMessageCenterPojo != null) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), JavaTypesHelper.toLong(imMessageCenterPojo.getGid(), 0L), imMessageCenterPojo.getGroup_name(), imMessageCenterPojo.getNameShow(), this.a, 0);
                personalChatActivityConfig.setRequestCode(12019);
                personalChatActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                personalChatActivityConfig.setIsReportSelect(true);
                personalChatActivityConfig.setSelectList(this.b);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalChatActivityConfig));
                return;
            }
            PersonalChatActivityConfig personalChatActivityConfig2 = new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), 0L, "", "", this.a, 0);
            personalChatActivityConfig2.setRequestCode(12019);
            personalChatActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
            personalChatActivityConfig2.setIsReportSelect(true);
            personalChatActivityConfig2.setSelectList(this.b);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalChatActivityConfig2));
        }
    }

    public zs4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r4.optInt("isClose", 0) == 1) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m(String str, String str2, String str3, WebView webView, HashMap hashMap) {
        Class<?> cls;
        int i;
        JSONObject jSONObject;
        boolean z;
        if (hashMap == null) {
            return;
        }
        cls = null;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            try {
                jSONObject.put("page", str2);
                jSONObject.put("refre", str3);
                jSONObject.put("from", 0);
                z = true;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            jSONObject = null;
        }
        z = false;
        if (jSONObject != null) {
            try {
                cls = Class.forName((String) hashMap.get(str2));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cls != null) {
                return;
            }
            Context a2 = fj6.a(webView.getContext());
            if (a2 == null && TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                a2 = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            if (a2 == null && webView.getContext() != null) {
                a2 = webView.getContext();
            }
            if (a2 == null) {
                HybridLog.getInstance().i("handlePortal", "通用路由端能力执行失败，activity为空");
                return;
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (cls2.isAssignableFrom(pma.class)) {
                    try {
                        ((pma) cls.newInstance()).dispatch(jSONObject, a2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (!z && (a2 instanceof Activity)) {
                        ((Activity) a2).finish();
                        return;
                    }
                }
            }
            return;
        }
        return;
        if (cls != null) {
        }
        if (!z) {
        }
    }

    @Override // com.baidu.tieba.qj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.FINISH_THIS_PAGE.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(c(webView, jSONObject.optString("nextPage"), jSONObject.optString("source")).a());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } else if (CommonTbJsBridge.JUMP_TO_HTML_PAGE.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(k(webView, jSONObject2.optString("url"), jSONObject2.optInt("finish_this_page", 1)).toString());
                    return false;
                } catch (JSONException e2) {
                    BdLog.e(e2);
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public gxa c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            gxa gxaVar = new gxa();
            Activity a2 = fj6.a(webView.getContext());
            if (webView instanceof gl6) {
                hl6 jSPromptRedirector = ((gl6) webView).getJSPromptRedirector();
                if ((jSPromptRedirector instanceof us4) && (gxaVar = ((us4) jSPromptRedirector).a(webView, str, str2)) != null) {
                    return gxaVar;
                }
            }
            if (a2 != null) {
                a2.finish();
                if (rd.isEquals(str, "FictionalCharacterDetailsPage")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                    hashMap.put("source", str2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(a2, "FictionalCharacterDetailsPage", hashMap)));
                }
            }
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa u(WebView webView, String str, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, webView, str, arrayList)) == null) {
            gxa gxaVar = new gxa();
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                for (int i = 0; i < arrayList.size(); i++) {
                    JSONObject jSONObject = arrayList.get(i);
                    String optString = jSONObject.optString("reportContent");
                    if (!TextUtils.isEmpty(optString)) {
                        optString = new String(Base64.decode(optString, 2), StandardCharsets.UTF_8);
                    }
                    arrayList2.add(new ReportPrivateMsgData(jSONObject.optString("msgId"), optString, jSONObject.optString(FileMetaUtil.CREATE_TIME)));
                }
            }
            ru5.c(new a(this, str), new b(this, str, arrayList2));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 0);
                gxaVar.o(jSONObject2.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa d(WebView webView, HashMap<String, List<ReportPrivateMsgData>> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            List<ReportPrivateMsgData> list = hashMap.get("private_msg");
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < list.size(); i++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("msgId", list.get(i).getMsgId());
                    String content = list.get(i).getContent();
                    if (!TextUtils.isEmpty(content)) {
                        jSONObject2.put("reportContent", new String(Base64.encode(content.getBytes(StandardCharsets.UTF_8), 2), StandardCharsets.UTF_8));
                    } else {
                        jSONObject2.put("reportContent", "");
                    }
                    jSONObject2.put(FileMetaUtil.CREATE_TIME, list.get(i).getTime());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("resultCode", 1);
                jSONObject.put("msgArray", jSONArray);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa e(WebView webView, HashMap<String, ArrayList<String>> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                ArrayList<String> arrayList = hashMap.get("tid");
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i));
                }
                jSONObject.put("resultCode", 1);
                jSONObject.put("threadArray", jSONArray);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa q(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            if (hashMap == null) {
                return gxaVar;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TailEditActivityConfig.TAIL_ID, hashMap.get("tailId"));
                jSONObject.put(TailEditActivityConfig.TAIL_COLOR, hashMap.get("tailColor"));
                jSONObject.put(TailEditActivityConfig.TAIL_CONTENT, hashMap.get("tailContent"));
                jSONObject.put("font_key_name", webView.getContext().getString(R.string.tail_default_font));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.REFRESH_TAIL, jSONObject);
            gxaVar.o(jSONObject.toString());
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa f(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7})) == null) {
            gxa gxaVar = new gxa();
            Context a2 = fj6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if ("1".equals(str)) {
                WriteActivityConfig.newInstance(a2).setType(9).setForumWriteData(new ForumWriteData(str6, str7, null, null)).setIsSaveDraft(false).setContent(str5).setFrom("frs").setCallFrom("2").send();
            } else if ("2".equals(str)) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(a2).createNormalCfg(str2, null, null);
                createNormalCfg.setJumpToCommentArea(true);
                createNormalCfg.showOpenEditorTips(str5);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            } else if ("3".equals(str)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(a2).createSubPbActivityConfig(str2, str4, "mention", false, "", false, str4, 0);
                createSubPbActivityConfig.showOpenEditorTips(str5);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa g(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        InterceptResult invokeCommon;
        String str19;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18})) == null) {
            gxa gxaVar = new gxa();
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.thread_id = str;
            videoItemData.post_id = str2;
            videoItemData.title = str3;
            UserItemData userItemData = new UserItemData();
            userItemData.user_name = str4;
            userItemData.name_show = str5;
            userItemData.portrait = str6;
            videoItemData.author_info = userItemData;
            videoItemData.thumbnail_url = str7;
            videoItemData.video_url = str8;
            videoItemData.video_width = str9;
            videoItemData.video_height = str10;
            videoItemData.video_duration = JavaTypesHelper.toInt(str11, 0);
            if (JavaTypesHelper.toLong(str10, 0L) > JavaTypesHelper.toLong(str9, 0L)) {
                z = true;
                str19 = str12;
            } else {
                str19 = str12;
                z = false;
            }
            videoItemData.comment_num = str19;
            videoItemData.agree_num = str13;
            videoItemData.is_agreed = str14;
            videoItemData.share_num = str15;
            videoItemData.forum_id = str16;
            videoItemData.forum_name = str17;
            arrayList.add(videoItemData);
            yt5.d(fj6.a(webView.getContext()), arrayList, videoItemData.nid, z, 0, null, "from_nani_video", "personalize_page", "", VideoPlayActivityConfig.FROM_H5_SEARCH, "", "1".equals(str18), false, JavaTypesHelper.toLong(str16, 0L));
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa h(WebView webView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, webView, str, i)) == null) {
            gxa gxaVar = new gxa();
            if (!TextUtils.isEmpty(str)) {
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(webView.getContext(), str, ForumDetailActivityConfig.FromType.BLUEV_SETTLE);
                if (i == 1 || i == 2 || i == 3) {
                    forumDetailActivityConfig.setSelectHostTab(i);
                }
                forumDetailActivityConfig.setRequestCode(25070);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            return gxaVar;
        }
        return (gxa) invokeLLI.objValue;
    }

    public gxa j(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, webView, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ForumRuleEditActivityConfig forumRuleEditActivityConfig = new ForumRuleEditActivityConfig(webView.getContext(), str, str2, null, 0, null);
                forumRuleEditActivityConfig.setRequestCode(25070);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumRuleEditActivityConfig));
            }
            return new gxa();
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa k(WebView webView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, webView, str, i)) == null) {
            gxa gxaVar = new gxa();
            if (webView instanceof gl6) {
                hl6 jSPromptRedirector = ((gl6) webView).getJSPromptRedirector();
                if ((jSPromptRedirector instanceof us4) && (gxaVar = ((us4) jSPromptRedirector).b(webView, str, i)) != null) {
                    return gxaVar;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                Context a2 = fj6.a(webView.getContext());
                if (a2 == null) {
                    a2 = webView.getContext();
                }
                BrowserHelper.startWebActivity(a2, str);
                if (i == 1 && (a2 instanceof Activity)) {
                    ((Activity) a2).finish();
                }
            }
            return gxaVar;
        }
        return (gxa) invokeLLI.objValue;
    }

    public gxa t(WebView webView, String str, ArrayList<String> arrayList) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, webView, str, arrayList)) == null) {
            gxa gxaVar = new gxa();
            ReportThemeActivityConfig reportThemeActivityConfig = new ReportThemeActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), str, arrayList);
            reportThemeActivityConfig.setRequestCode(12018);
            reportThemeActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, reportThemeActivityConfig));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa i(final WebView webView, final String str, final String str2, final String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, str2, str3)) == null) {
            gxa gxaVar = new gxa();
            rma.c().b(new rma.c() { // from class: com.baidu.tieba.ls4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rma.c
                public final void a(HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, hashMap) == null) {
                        zs4.m(str3, str, str2, webView, hashMap);
                    }
                }
            });
            return gxaVar;
        }
        return (gxa) invokeLLLL.objValue;
    }

    public gxa l(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, webView, str, str2, str3)) == null) {
            gxa gxaVar = new gxa();
            if (WriteActivityConfig.isAsyncWriting()) {
                return gxaVar;
            }
            int guideStatus = WriteVideoUtil.getGuideStatus();
            if (WriteVideoUtil.isShowGuide(guideStatus)) {
                Context a2 = fj6.a(webView.getContext());
                if (a2 == null) {
                    a2 = webView.getContext();
                }
                WriteVideoUtil.jumpWorkVideoGuide(a2, guideStatus, 0);
            }
            if (WriteVideoUtil.hasDraft()) {
                WriteVideoUtil.openBottomActionSheet(null, null, null, null, 0, Boolean.TRUE, str, str2, str3);
            } else {
                WriteVideoUtil.sendThread(false, false, null, null, null, null, 0, Boolean.TRUE, str, str2, str3);
            }
            return gxaVar;
        }
        return (gxa) invokeLLLL.objValue;
    }

    public gxa n(WebView webView, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048588, this, webView, i, str)) == null) {
            gxa gxaVar = new gxa();
            if (i == 1) {
                Context a2 = fj6.a(webView.getContext());
                if (a2 == null) {
                    a2 = webView.getContext();
                }
                if (sva.b(a2, "com.tencent.mobileqq")) {
                    eb5.e(8, a2);
                } else {
                    BdToast.makeText(a2, a2.getText(R.string.share_qq_not_install)).show();
                }
            }
            return gxaVar;
        }
        return (gxa) invokeLIL.objValue;
    }

    public gxa o(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.RE_HIDE, jSONObject);
            gxa gxaVar = new gxa();
            gxaVar.o(jSONObject.toString());
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa p(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.RE_SHOW, jSONObject);
            kl6.g(webView);
            gxa gxaVar = new gxa();
            gxaVar.o(jSONObject.toString());
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa s(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa r(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921804, null));
            return new gxa();
        }
        return (gxa) invokeLL.objValue;
    }
}

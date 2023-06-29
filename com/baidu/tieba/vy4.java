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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
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
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.zu9;
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
/* loaded from: classes8.dex */
public class vy4 implements em6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.em6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        dm6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.em6
    public /* synthetic */ void onDestroy() {
        dm6.b(this);
    }

    /* loaded from: classes8.dex */
    public class a extends sx5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(vy4 vy4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy4Var, str};
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
        @Override // com.baidu.tieba.sx5
        /* renamed from: a */
        public ImMessageCenterPojo doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return h98.f().i(this.a);
            }
            return (ImMessageCenterPojo) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ww5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ArrayList b;

        public b(vy4 vy4Var, String str, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy4Var, str, arrayList};
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
        @Override // com.baidu.tieba.ww5
        /* renamed from: a */
        public void onReturnDataInUI(ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, imMessageCenterPojo) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (imMessageCenterPojo != null) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), vg.g(imMessageCenterPojo.getGid(), 0L), imMessageCenterPojo.getGroup_name(), imMessageCenterPojo.getNameShow(), this.a, 0);
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

    public vy4() {
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
            Context a2 = tl6.a(webView.getContext());
            if (a2 == null && TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                a2 = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            if (a2 == null && webView.getContext() != null) {
                a2 = webView.getContext();
            }
            if (a2 == null) {
                HybridLog.getInstance().c("handlePortal", "通用路由端能力执行失败，activity为空");
                return;
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (cls2.isAssignableFrom(xu9.class)) {
                    try {
                        ((xu9) cls.newInstance()).dispatch(jSONObject, a2);
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

    @Override // com.baidu.tieba.em6
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

    public f5a c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            f5a f5aVar = new f5a();
            Activity a2 = tl6.a(webView.getContext());
            if (a2 != null) {
                a2.finish();
                if (wi.isEquals(str, "FictionalCharacterDetailsPage")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                    hashMap.put("source", str2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(a2, "FictionalCharacterDetailsPage", hashMap)));
                }
            }
            return f5aVar;
        }
        return (f5a) invokeLLL.objValue;
    }

    public f5a h(WebView webView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, webView, str, i)) == null) {
            f5a f5aVar = new f5a();
            if (!TextUtils.isEmpty(str)) {
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(webView.getContext(), str, ForumDetailActivityConfig.FromType.BLUEV_SETTLE);
                if (i == 1 || i == 2 || i == 3) {
                    forumDetailActivityConfig.setSelectHostTab(i);
                }
                forumDetailActivityConfig.setRequestCode(25070);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            return f5aVar;
        }
        return (f5a) invokeLLI.objValue;
    }

    public f5a j(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, webView, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ForumRuleEditActivityConfig forumRuleEditActivityConfig = new ForumRuleEditActivityConfig(webView.getContext(), str, str2, null, 0, null);
                forumRuleEditActivityConfig.setRequestCode(25070);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumRuleEditActivityConfig));
            }
            return new f5a();
        }
        return (f5a) invokeLLL.objValue;
    }

    public f5a t(WebView webView, String str, ArrayList<String> arrayList) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, webView, str, arrayList)) == null) {
            f5a f5aVar = new f5a();
            ReportThemeActivityConfig reportThemeActivityConfig = new ReportThemeActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), str, arrayList);
            reportThemeActivityConfig.setRequestCode(12018);
            reportThemeActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, reportThemeActivityConfig));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                f5aVar.o(jSONObject.toString());
                return f5aVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return f5aVar;
            }
        }
        return (f5a) invokeLLL.objValue;
    }

    public f5a d(WebView webView, HashMap<String, List<ReportPrivateMsgData>> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            f5a f5aVar = new f5a();
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
                f5aVar.o(jSONObject.toString());
                return f5aVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return f5aVar;
            }
        }
        return (f5a) invokeLL.objValue;
    }

    public f5a e(WebView webView, HashMap<String, ArrayList<String>> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            f5a f5aVar = new f5a();
            try {
                JSONObject jSONObject = new JSONObject();
                ArrayList<String> arrayList = hashMap.get("tid");
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i));
                }
                jSONObject.put("resultCode", 1);
                jSONObject.put("threadArray", jSONArray);
                f5aVar.o(jSONObject.toString());
                return f5aVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return f5aVar;
            }
        }
        return (f5a) invokeLL.objValue;
    }

    public f5a q(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, hashMap)) == null) {
            f5a f5aVar = new f5a();
            if (hashMap == null) {
                return f5aVar;
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
            f5aVar.o(jSONObject.toString());
            return f5aVar;
        }
        return (f5a) invokeLL.objValue;
    }

    public f5a f(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7})) == null) {
            f5a f5aVar = new f5a();
            Context a2 = tl6.a(webView.getContext());
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
            return f5aVar;
        }
        return (f5a) invokeCommon.objValue;
    }

    public f5a g(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        InterceptResult invokeCommon;
        String str18;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17})) == null) {
            f5a f5aVar = new f5a();
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
            videoItemData.video_duration = vg.e(str11, 0);
            if (vg.g(str10, 0L) > vg.g(str9, 0L)) {
                z = true;
                str18 = str12;
            } else {
                str18 = str12;
                z = false;
            }
            videoItemData.comment_num = str18;
            videoItemData.agree_num = str13;
            videoItemData.share_num = str14;
            videoItemData.forum_id = str15;
            videoItemData.forum_name = str16;
            arrayList.add(videoItemData);
            cx5.d(tl6.a(webView.getContext()), arrayList, videoItemData.nid, z, 0, null, "from_nani_video", "personalize_page", "", VideoPlayActivityConfig.FROM_H5_SEARCH, "", "1".equals(str17), false, vg.g(str15, 0L));
            return f5aVar;
        }
        return (f5a) invokeCommon.objValue;
    }

    public f5a i(final WebView webView, final String str, final String str2, final String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, str2, str3)) == null) {
            f5a f5aVar = new f5a();
            zu9.c().b(new zu9.c() { // from class: com.baidu.tieba.jy4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.zu9.c
                public final void a(HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, hashMap) == null) {
                        vy4.m(str3, str, str2, webView, hashMap);
                    }
                }
            });
            return f5aVar;
        }
        return (f5a) invokeLLLL.objValue;
    }

    public f5a k(WebView webView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, webView, str, i)) == null) {
            f5a f5aVar = new f5a();
            if (!TextUtils.isEmpty(str)) {
                Context a2 = tl6.a(webView.getContext());
                if (a2 == null) {
                    a2 = webView.getContext();
                }
                ux4.s(a2, str);
                if (i == 1 && (a2 instanceof Activity)) {
                    ((Activity) a2).finish();
                }
            }
            return f5aVar;
        }
        return (f5a) invokeLLI.objValue;
    }

    public f5a n(WebView webView, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048588, this, webView, i, str)) == null) {
            f5a f5aVar = new f5a();
            if (i == 1) {
                Context a2 = tl6.a(webView.getContext());
                if (a2 == null) {
                    a2 = webView.getContext();
                }
                if (r3a.b(a2, "com.tencent.mobileqq")) {
                    qf5.e(8, a2);
                } else {
                    BdToast.b(a2, a2.getText(R.string.share_qq_not_install)).q();
                }
            }
            return f5aVar;
        }
        return (f5a) invokeLIL.objValue;
    }

    public f5a l(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, webView, str, str2, str3)) == null) {
            f5a f5aVar = new f5a();
            if (WriteActivityConfig.isAsyncWriting()) {
                return f5aVar;
            }
            int a2 = tka.a();
            if (tka.c(a2)) {
                Context a3 = tl6.a(webView.getContext());
                if (a3 == null) {
                    a3 = webView.getContext();
                }
                tka.e(a3, a2, 0);
            }
            if (tka.b()) {
                tka.h(null, null, null, null, 0, Boolean.TRUE, str, str2, str3);
            } else {
                tka.k(false, false, null, null, null, null, 0, Boolean.TRUE, str, str2, str3);
            }
            return f5aVar;
        }
        return (f5a) invokeLLLL.objValue;
    }

    public f5a o(WebView webView, HashMap hashMap) {
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
            f5a f5aVar = new f5a();
            f5aVar.o(jSONObject.toString());
            return f5aVar;
        }
        return (f5a) invokeLL.objValue;
    }

    public f5a p(WebView webView, HashMap hashMap) {
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
            f5a f5aVar = new f5a();
            f5aVar.o(jSONObject.toString());
            return f5aVar;
        }
        return (f5a) invokeLL.objValue;
    }

    public f5a s(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, hashMap)) == null) {
            f5a f5aVar = new f5a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                f5aVar.o(jSONObject.toString());
                return f5aVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return f5aVar;
            }
        }
        return (f5a) invokeLL.objValue;
    }

    public f5a r(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921804, null));
            return new f5a();
        }
        return (f5a) invokeLL.objValue;
    }

    public f5a u(WebView webView, String str, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, webView, str, arrayList)) == null) {
            f5a f5aVar = new f5a();
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
            wx5.c(new a(this, str), new b(this, str, arrayList2));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 0);
                f5aVar.o(jSONObject2.toString());
                return f5aVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return f5aVar;
            }
        }
        return (f5a) invokeLLL.objValue;
    }
}

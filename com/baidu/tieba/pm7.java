package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class pm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Context context, ri7 forum, ni7 secondFloorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, context, forum, secondFloorData) == null) {
            Intrinsics.checkNotNullParameter(forum, "forum");
            Intrinsics.checkNotNullParameter(secondFloorData, "secondFloorData");
            String valueOf = String.valueOf(secondFloorData.e().b());
            String d = secondFloorData.e().d();
            String a = secondFloorData.e().a();
            if (a == null) {
                a = "";
            }
            String a2 = secondFloorData.a();
            if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(d)) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("page", "im/AISingleChat");
                jSONObject.put(YunDialogManager.PAGE_PARAMS_KEY, jSONObject2);
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, 1111);
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_H5_URL, URLEncoder.encode(a2, "UTF-8"));
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_CHAT_PIC_URL, URLEncoder.encode(a, "UTF-8"));
                jSONObject2.put("paid", valueOf);
                jSONObject2.put("uk", d);
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_IS_ANIMATION, 1);
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_CAN_SLIDE_BACK, 0);
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_FROM, 1);
                jSONObject2.put("fid", forum.e());
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_FORUM_NAME, forum.f());
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_FORUM_PORTRAIT, URLEncoder.encode(forum.d(), "UTF-8"));
                jSONObject2.put(AiBotChatDispatcher.AI_SINGLE_SHOW_BOT_LIST, 1);
                pma.a(context, new String[]{"tiebaapp://router/portal?params=" + jSONObject});
            }
        }
    }
}

package com.baidu.tieba;

import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.ChatroomSignInfo;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.RankInfo;
import tbclient.FrsPage.SignForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.SignUser;
/* loaded from: classes8.dex */
public final class sh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final JSONObject a(eh7 eh7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eh7Var)) == null) {
            Intrinsics.checkNotNullParameter(eh7Var, "<this>");
            JSONObject jSONObject = new JSONObject();
            DataRes d = eh7Var.d();
            if (d != null) {
                DataRes.Builder builder = new DataRes.Builder(d);
                ForumInfo.Builder builder2 = new ForumInfo.Builder(builder.forum);
                builder2.banner_list = null;
                builder.forum = builder2.build(true);
                builder.thread_list = null;
                builder.page_data = null;
                builder.user_list = null;
                builder.nav_tab_info = null;
                try {
                    JSONObject b = wuc.b(builder.build(true));
                    Intrinsics.checkNotNullExpressionValue(b, "toJSON(data)");
                    return b;
                } catch (Exception e) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("BottomData", "frs接口数据转换失败：" + e);
                    return jSONObject;
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static final SignData b(SignInfo signInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, signInfo)) == null) {
            Intrinsics.checkNotNullParameter(signInfo, "<this>");
            SignData signData = new SignData();
            SignUser user_info = signInfo.user_info;
            if (user_info != null) {
                Intrinsics.checkNotNullExpressionValue(user_info, "user_info");
                Integer num = user_info.is_sign_in;
                Intrinsics.checkNotNullExpressionValue(num, "user_info.is_sign_in");
                signData.is_signed = num.intValue();
                Integer num2 = user_info.user_sign_rank;
                Intrinsics.checkNotNullExpressionValue(num2, "user_info.user_sign_rank");
                signData.user_sign_rank = num2.intValue();
                Integer num3 = user_info.cont_sign_num;
                Intrinsics.checkNotNullExpressionValue(num3, "user_info.cont_sign_num");
                signData.count_sign_num = num3.intValue();
                Integer num4 = user_info.miss_sign_num;
                Intrinsics.checkNotNullExpressionValue(num4, "user_info.miss_sign_num");
                signData.miss_sign_num = num4.intValue();
            }
            SignForum forum_info = signInfo.forum_info;
            if (forum_info != null) {
                Intrinsics.checkNotNullExpressionValue(forum_info, "forum_info");
                Integer num5 = forum_info.is_on;
                if (num5 != null && num5.intValue() == 0) {
                    signData.forum_rank = -2;
                } else {
                    RankInfo current_rank_info = forum_info.current_rank_info;
                    if (current_rank_info != null) {
                        Intrinsics.checkNotNullExpressionValue(current_rank_info, "current_rank_info");
                        Integer num6 = current_rank_info.sign_rank;
                        Intrinsics.checkNotNullExpressionValue(num6, "rank_info.sign_rank");
                        signData.forum_rank = num6.intValue();
                        Integer num7 = current_rank_info.sign_count;
                        Intrinsics.checkNotNullExpressionValue(num7, "rank_info.sign_count");
                        signData.sign_count = num7.intValue();
                    }
                }
            }
            Integer num8 = signInfo.has_chatroom_sign;
            boolean z = true;
            signData.showGuideToChatRoom = (num8 == null || num8.intValue() != 1) ? false : false;
            ChatroomSignInfo chatroom_sign_info = signInfo.chatroom_sign_info;
            if (chatroom_sign_info != null) {
                Intrinsics.checkNotNullExpressionValue(chatroom_sign_info, "chatroom_sign_info");
                signData.chatRoomGuideData = yw4.d.a(chatroom_sign_info);
            }
            return signData;
        }
        return (SignData) invokeL.objValue;
    }
}

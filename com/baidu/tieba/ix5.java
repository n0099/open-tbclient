package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ix5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(SdkLiveInfoData.AlaLiveInfo alaLiveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveInfo)) == null) {
            SdkLiveInfoData.YYExt yYExt = alaLiveInfo.yyExt;
            int i = 1;
            if (yYExt != null) {
                if (yYExt.isYYGame == 1) {
                    return 3;
                }
                return 2;
            }
            if (alaLiveInfo.liveType != 1) {
                i = 5;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            int dimensionPixelSize = zi.s(context)[0] - (context.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            return new int[]{dimensionPixelSize, (int) ((dimensionPixelSize * 9.0d) / 16.0d)};
        }
        return (int[]) invokeL.objValue;
    }

    public static boolean c(SdkLiveInfoData sdkLiveInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sdkLiveInfoData)) == null) {
            if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null || yi.isEmpty(sdkLiveInfoData.liveId) || yi.isEmpty(sdkLiveInfoData.roomId) || !StringHelper.equals(sdkLiveInfoData.source, "jiaoyoufang") || sdkLiveInfoData.liveInfo.roomStatus != 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(SdkLiveInfoData sdkLiveInfoData) {
        InterceptResult invokeL;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sdkLiveInfoData)) == null) {
            if (sdkLiveInfoData == null || (alaLiveInfo = sdkLiveInfoData.liveInfo) == null || alaLiveInfo.yyExt == null || yi.isEmpty(sdkLiveInfoData.roomId) || yi.isEmpty(sdkLiveInfoData.liveInfo.yyExt.sid) || yi.isEmpty(sdkLiveInfoData.liveInfo.yyExt.ssid) || yi.isEmpty(sdkLiveInfoData.liveInfo.yyExt.templateId)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, sdkLiveInfoData, str) == null) && tbPageContext != null && sdkLiveInfoData != null) {
            UrlManager urlManager = UrlManager.getInstance();
            urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + sdkLiveInfoData.roomId + "&live_id=" + sdkLiveInfoData.liveId + "&enterroom_type=1&from=" + str});
        }
    }

    public static void f(Context context, ThreadData threadData, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, threadData, str) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                zi.N(context, context.getString(R.string.no_network_guide));
            } else if (context != null && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = threadData.getAuthor().getUserId();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, currentAccount);
                    str2 = currentAccount;
                } else {
                    str2 = "";
                    z = false;
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, str, str2, z, null, null)));
            }
        }
    }

    public static void g(Context context, SdkLiveInfoData sdkLiveInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, context, sdkLiveInfoData) != null) || sdkLiveInfoData == null) {
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = yg.g(sdkLiveInfoData.liveId, 0L);
        alaLiveInfoCoreData.threadId = yg.g(sdkLiveInfoData.tid, 0L);
        SdkLiveInfoData.LiveAuthor liveAuthor = sdkLiveInfoData.liveAuthor;
        if (liveAuthor != null) {
            alaLiveInfoCoreData.userName = liveAuthor.name;
        }
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
        if (alaLiveInfo != null) {
            alaLiveInfoCoreData.sessionID = alaLiveInfo.sessionId;
            alaLiveInfoCoreData.liveType = alaLiveInfo.liveType;
            alaLiveInfoCoreData.screenDirection = alaLiveInfo.screenDirection;
            alaLiveInfoCoreData.hslUrl = alaLiveInfo.hlsUrl;
            alaLiveInfoCoreData.liveCover = alaLiveInfo.cover;
            alaLiveInfoCoreData.rtmpUrl = alaLiveInfo.rtmpUrl;
            alaLiveInfoCoreData.liveTitle = sdkLiveInfoData.title;
            alaLiveInfoCoreData.audienceCount = alaLiveInfo.audienceCount;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
    }

    public static void h(Context context, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, threadData) == null) {
            f(context, threadData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN);
        }
    }

    public static YyExtData j(SdkLiveInfoData.YYExt yYExt, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, yYExt, str)) == null) {
            YyExtData yyExtData = new YyExtData();
            yyExtData.mSid = yYExt.sid;
            yyExtData.mSsid = yYExt.ssid;
            yyExtData.mYyUid = yYExt.yyUid;
            yyExtData.mTemplateId = yYExt.templateId;
            yyExtData.liveId = str;
            return yyExtData;
        }
        return (YyExtData) invokeLL.objValue;
    }

    public static void i(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData, String str) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65544, null, tbPageContext, sdkLiveInfoData, str) == null) && sdkLiveInfoData != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null && (yYExt = alaLiveInfo.yyExt) != null && !yi.isEmpty(yYExt.sid) && !yi.isEmpty(sdkLiveInfoData.liveInfo.yyExt.ssid)) {
            SdkLiveInfoData.YYExt yYExt2 = sdkLiveInfoData.liveInfo.yyExt;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yYExt2.sid, yYExt2.ssid, yYExt2.templateId, sdkLiveInfoData.roomId, yYExt2.streamInfo, str);
        }
    }
}

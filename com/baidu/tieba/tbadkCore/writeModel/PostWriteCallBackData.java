package com.baidu.tieba.tbadkCore.writeModel;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.w1;
import b.a.q0.u.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class PostWriteCallBackData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COPY_TW_ZHIBO_TAG = 3;
    public static final int ERROR_ANTI_USER = 340016;
    public static final int ERROR_DISABLE_AT = 230278;
    public static final int ERROR_DISABLE_REPLY = 230277;
    public static final int ERROR_LEVEL_UNDER_THREE = 1990032;
    public static final String GENERAL_TAB_ID = "general_tab_id";
    public static final int VIDEO_FROM_ACTIVITY = 3;
    public static final int VIDEO_FROM_FRS = 2;
    public static final int VIDEO_FROM_MAINTAB = 1;
    public static final long serialVersionUID = 3542955843976043534L;
    public transient /* synthetic */ FieldHolder $fh;
    public AccessState accessState;
    public String colorMsg;
    public int errorCode;
    public String errorString;
    public int generalTabId;
    public IconStampData iconStampData;
    public int isCopyTWZhibo;
    public boolean isDyamicCallback;
    public CustomDialogData mActDialogData;
    public a mAdverSegmentData;
    public ContriInfo mContriInfo;
    public int mFrom;
    public w1 mReplyPrivacyTip;
    public VideoEasterEggData mVideoEasterEggData;
    public String mVideoMd5;
    public VideoTitleData mVideoTitleData;
    public String postId;
    public String preMsg;
    public int proZone;
    public ArrayList<String> sensitiveWords;
    public String threadId;
    public String video_id;
    public WriteData writeDataForVideo;

    public PostWriteCallBackData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.threadId = null;
        this.postId = null;
        this.accessState = null;
        this.sensitiveWords = null;
        this.isDyamicCallback = false;
    }

    public String buildVideoFakeOnWallUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoTitleData videoTitleData = this.mVideoTitleData;
            if (videoTitleData == null || StringUtils.isNull(videoTitleData.url)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.mVideoTitleData.url);
            if (!StringUtils.isNull(this.mVideoMd5)) {
                sb.append("&video_md5=");
                sb.append(this.mVideoMd5);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public AccessState getAccessState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.accessState : (AccessState) invokeV.objValue;
    }

    public CustomDialogData getActivityDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mActDialogData : (CustomDialogData) invokeV.objValue;
    }

    public String getColorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.colorMsg : (String) invokeV.objValue;
    }

    public ContriInfo getContriInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mContriInfo : (ContriInfo) invokeV.objValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.errorCode : invokeV.intValue;
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.errorString : (String) invokeV.objValue;
    }

    public int getGeneralTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.generalTabId : invokeV.intValue;
    }

    public IconStampData getIconStampData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.iconStampData : (IconStampData) invokeV.objValue;
    }

    public int getIsCopyTWZhibo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isCopyTWZhibo : invokeV.intValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.postId : (String) invokeV.objValue;
    }

    public String getPreMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.preMsg : (String) invokeV.objValue;
    }

    public int getProZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.proZone : invokeV.intValue;
    }

    public w1 getReplyPrivacyTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mReplyPrivacyTip : (w1) invokeV.objValue;
    }

    public ArrayList<String> getSensitiveWords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.sensitiveWords : (ArrayList) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.threadId : (String) invokeV.objValue;
    }

    public VideoEasterEggData getVideoEasterEggData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mVideoEasterEggData : (VideoEasterEggData) invokeV.objValue;
    }

    public String getVideoid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.video_id : (String) invokeV.objValue;
    }

    public a getmAdverSegmentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mAdverSegmentData : (a) invokeV.objValue;
    }

    public boolean isDyamicCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.isDyamicCallback : invokeV.booleanValue;
    }

    public boolean isErrorLinkCountExceedLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.errorCode == 3300001 : invokeV.booleanValue;
    }

    public boolean isErrorShowApplyMemberDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.errorCode == 3300003 : invokeV.booleanValue;
    }

    public boolean isSensitiveError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.errorCode == 220015 : invokeV.booleanValue;
    }

    public void setAccessState(AccessState accessState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, accessState) == null) {
            this.accessState = accessState;
        }
    }

    public void setActivityDialog(CustomDialogData customDialogData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, customDialogData) == null) {
            this.mActDialogData = customDialogData;
        }
    }

    public void setColorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.colorMsg = str;
        }
    }

    public void setContriInfo(ContriInfo contriInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, contriInfo) == null) {
            this.mContriInfo = contriInfo;
        }
    }

    public void setDyamicCallback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.isDyamicCallback = z;
        }
    }

    public void setErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.errorCode = i2;
        }
    }

    public void setErrorString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.errorString = str;
        }
    }

    public void setGeneralTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.generalTabId = i2;
        }
    }

    public void setIconStampData(IconStampData iconStampData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iconStampData) == null) {
            this.iconStampData = iconStampData;
        }
    }

    public void setIsCopyTWZhibo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.isCopyTWZhibo = i2;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.postId = str;
        }
    }

    public void setPreMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.preMsg = str;
        }
    }

    public void setProZone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.proZone = i2;
        }
    }

    public void setReplyPrivacyTip(w1 w1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, w1Var) == null) {
            this.mReplyPrivacyTip = w1Var;
        }
    }

    public void setSensitiveWords(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, arrayList) == null) {
            this.sensitiveWords = arrayList;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.threadId = str;
        }
    }

    public void setVideoEasterEggData(VideoEasterEggData videoEasterEggData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, videoEasterEggData) == null) {
            this.mVideoEasterEggData = videoEasterEggData;
        }
    }

    public void setVideoid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.video_id = str;
        }
    }

    public void setmAdverSegmentData(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, aVar) == null) {
            this.mAdverSegmentData = aVar;
        }
    }

    public PostWriteCallBackData(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.threadId = null;
        this.postId = null;
        this.accessState = null;
        this.sensitiveWords = null;
        this.isDyamicCallback = false;
        this.errorCode = i2;
        this.errorString = str;
        this.preMsg = str2;
        this.colorMsg = str3;
    }
}

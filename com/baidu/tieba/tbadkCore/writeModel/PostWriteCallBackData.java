package com.baidu.tieba.tbadkCore.writeModel;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.s35;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
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
    public String inviteesNumber;
    public int isCopyTWZhibo;
    public boolean isDyamicCallback;
    public CustomDialogData mActDialogData;
    public AdverSegmentData mAdverSegmentData;
    public ContriInfo mContriInfo;
    public int mFrom;
    public s35 mReplyPrivacyTip;
    public VideoEasterEggData mVideoEasterEggData;
    public String mVideoMd5;
    public VideoTitleData mVideoTitleData;
    public String postId;
    public String preMsg;
    public String questionExp;
    public String questionMsg;
    public ArrayList<String> sensitiveWords;
    public String threadId;
    public BdToastData toast;
    public String video_id;
    public WriteData writeDataForVideo;

    public PostWriteCallBackData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public AccessState getAccessState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.accessState;
        }
        return (AccessState) invokeV.objValue;
    }

    public CustomDialogData getActivityDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mActDialogData;
        }
        return (CustomDialogData) invokeV.objValue;
    }

    public String getColorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.colorMsg;
        }
        return (String) invokeV.objValue;
    }

    public ContriInfo getContriInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mContriInfo;
        }
        return (ContriInfo) invokeV.objValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.errorCode;
        }
        return invokeV.intValue;
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.errorString;
        }
        return (String) invokeV.objValue;
    }

    public int getGeneralTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.generalTabId;
        }
        return invokeV.intValue;
    }

    public IconStampData getIconStampData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.iconStampData;
        }
        return (IconStampData) invokeV.objValue;
    }

    public String getInviteesNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.inviteesNumber;
        }
        return (String) invokeV.objValue;
    }

    public int getInviteesNumberInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return JavaTypesHelper.toInt(this.inviteesNumber, 0);
        }
        return invokeV.intValue;
    }

    public int getIsCopyTWZhibo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.isCopyTWZhibo;
        }
        return invokeV.intValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.postId;
        }
        return (String) invokeV.objValue;
    }

    public String getPreMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.preMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getQuestionExp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.questionExp;
        }
        return (String) invokeV.objValue;
    }

    public String getQuestionMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.questionMsg;
        }
        return (String) invokeV.objValue;
    }

    public s35 getReplyPrivacyTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mReplyPrivacyTip;
        }
        return (s35) invokeV.objValue;
    }

    public ArrayList<String> getSensitiveWords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.sensitiveWords;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.threadId;
        }
        return (String) invokeV.objValue;
    }

    public BdToastData getToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.toast;
        }
        return (BdToastData) invokeV.objValue;
    }

    public VideoEasterEggData getVideoEasterEggData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mVideoEasterEggData;
        }
        return (VideoEasterEggData) invokeV.objValue;
    }

    public String getVideoid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.video_id;
        }
        return (String) invokeV.objValue;
    }

    public AdverSegmentData getmAdverSegmentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mAdverSegmentData;
        }
        return (AdverSegmentData) invokeV.objValue;
    }

    public boolean isDyamicCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.isDyamicCallback;
        }
        return invokeV.booleanValue;
    }

    public boolean isErrorLinkCountExceedLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.errorCode == 3300001) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isErrorShowApplyMemberDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.errorCode == 3300003) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSensitiveError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.errorCode == 220015) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PostWriteCallBackData(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.errorCode = i;
        this.errorString = str;
        this.preMsg = str2;
        this.colorMsg = str3;
    }

    public PostWriteCallBackData(int i, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.threadId = null;
        this.postId = null;
        this.accessState = null;
        this.sensitiveWords = null;
        this.isDyamicCallback = false;
        this.errorCode = i;
        this.errorString = str;
        this.preMsg = str2;
        this.colorMsg = str3;
        this.questionMsg = str4;
        this.questionExp = str5;
    }

    public String buildVideoFakeOnWallUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoTitleData videoTitleData = this.mVideoTitleData;
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.url)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mVideoTitleData.url);
                if (!StringUtils.isNull(this.mVideoMd5)) {
                    sb.append("&video_md5=");
                    sb.append(this.mVideoMd5);
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void setAccessState(AccessState accessState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, accessState) == null) {
            this.accessState = accessState;
        }
    }

    public void setActivityDialog(CustomDialogData customDialogData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, customDialogData) == null) {
            this.mActDialogData = customDialogData;
        }
    }

    public void setColorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.colorMsg = str;
        }
    }

    public void setContriInfo(ContriInfo contriInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, contriInfo) == null) {
            this.mContriInfo = contriInfo;
        }
    }

    public void setDyamicCallback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.isDyamicCallback = z;
        }
    }

    public void setErrorCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.errorCode = i;
        }
    }

    public void setErrorString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.errorString = str;
        }
    }

    public void setGeneralTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.generalTabId = i;
        }
    }

    public void setIconStampData(IconStampData iconStampData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, iconStampData) == null) {
            this.iconStampData = iconStampData;
        }
    }

    public void setInviteesNumber(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.inviteesNumber = str;
        }
    }

    public void setIsCopyTWZhibo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.isCopyTWZhibo = i;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.postId = str;
        }
    }

    public void setPreMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.preMsg = str;
        }
    }

    public void setQuestionExp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.questionExp = str;
        }
    }

    public void setQuestionMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.questionMsg = str;
        }
    }

    public void setReplyPrivacyTip(s35 s35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, s35Var) == null) {
            this.mReplyPrivacyTip = s35Var;
        }
    }

    public void setSensitiveWords(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, arrayList) == null) {
            this.sensitiveWords = arrayList;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.threadId = str;
        }
    }

    public void setToast(BdToastData bdToastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bdToastData) == null) {
            this.toast = bdToastData;
        }
    }

    public void setVideoEasterEggData(VideoEasterEggData videoEasterEggData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, videoEasterEggData) == null) {
            this.mVideoEasterEggData = videoEasterEggData;
        }
    }

    public void setVideoid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.video_id = str;
        }
    }

    public void setmAdverSegmentData(AdverSegmentData adverSegmentData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, adverSegmentData) == null) {
            this.mAdverSegmentData = adverSegmentData;
        }
    }
}

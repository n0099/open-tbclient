package com.baidu.tieba.myCollection.baseHistory;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tieba.rr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PbHistoryData implements rr5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_CACHE_KEY_SUFFIX = "_ala";
    public transient /* synthetic */ FieldHolder $fh;
    public long cartoonId;
    public int chapterId;
    public String description;
    public String forumName;
    public boolean isHostOnly;
    public boolean isLive;
    public boolean isManga;
    public boolean isShareThread;
    public boolean isSquence;
    public String liveId;
    public String postID;
    public String threadId;
    public String threadName;
    public int threadType;
    public long time;
    public String userName;

    public PbHistoryData() {
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
        this.threadId = "";
        this.threadName = "";
        this.forumName = "";
        this.time = System.currentTimeMillis();
        this.postID = "";
        this.isHostOnly = false;
        this.isSquence = false;
        this.threadType = 0;
        this.isManga = false;
        this.liveId = "";
        this.userName = "";
        this.description = "";
        this.isLive = true;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj != null && (obj instanceof PbHistoryData)) {
                PbHistoryData pbHistoryData = (PbHistoryData) obj;
                if (this.threadType == 49) {
                    String str3 = this.liveId;
                    if (str3 != null && (str2 = pbHistoryData.liveId) != null && str3.equals(str2)) {
                        return true;
                    }
                } else {
                    String str4 = this.threadId;
                    if (str4 != null && (str = pbHistoryData.threadId) != null && str4.equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pr5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.threadType == 49) {
                return this.liveId + ALA_CACHE_KEY_SUFFIX;
            }
            return this.threadId;
        }
        return (String) invokeV.objValue;
    }

    public long getCartoonId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cartoonId;
        }
        return invokeV.longValue;
    }

    public int getChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.chapterId;
        }
        return invokeV.intValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.description;
        }
        return (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public String getLiveId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.liveId;
        }
        return (String) invokeV.objValue;
    }

    public String getPostID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.postID;
        }
        return (String) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.threadId;
        }
        return (String) invokeV.objValue;
    }

    public String getThreadName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.threadName;
        }
        return (String) invokeV.objValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.threadType;
        }
        return invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.time;
        }
        return invokeV.longValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.userName;
        }
        return (String) invokeV.objValue;
    }

    public boolean isHostOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.isHostOnly;
        }
        return invokeV.booleanValue;
    }

    public boolean isLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isLive;
        }
        return invokeV.booleanValue;
    }

    public boolean isManga() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.isManga;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.isShareThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isSquence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.isSquence;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rr5
    public String toCacheString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return toJsonObject().toString();
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (TextUtils.isEmpty(this.threadId)) {
                hashCode = 120;
            } else {
                hashCode = 119 + this.threadId.hashCode();
            }
            if (TextUtils.isEmpty(this.threadName)) {
                hashCode2 = (hashCode * 7) + 1;
            } else {
                hashCode2 = (hashCode * 7) + this.threadName.hashCode();
            }
            if (TextUtils.isEmpty(this.forumName)) {
                hashCode3 = (hashCode2 * 7) + 1;
            } else {
                hashCode3 = (hashCode2 * 7) + this.forumName.hashCode();
            }
            int i = (hashCode3 * 7) + ((int) this.time);
            if (TextUtils.isEmpty(this.postID)) {
                hashCode4 = (i * 7) + 1;
            } else {
                hashCode4 = (i * 7) + this.postID.hashCode();
            }
            if (TextUtils.isEmpty(this.liveId)) {
                hashCode5 = (hashCode4 * 7) + 1;
            } else {
                hashCode5 = (hashCode4 * 7) + this.liveId.hashCode();
            }
            if (TextUtils.isEmpty(this.description)) {
                hashCode6 = (hashCode5 * 7) + 1;
            } else {
                hashCode6 = (hashCode5 * 7) + this.description.hashCode();
            }
            return (((hashCode6 * 7) + (this.isHostOnly ? 1 : 0)) * 7) + (this.isSquence ? 1 : 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rr5
    public boolean initByString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (str != null) {
                try {
                    return parserByJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCartoonId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.cartoonId = j;
        }
    }

    public void setChapterId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.chapterId = i;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.description = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setHostOnly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.isHostOnly = z;
        }
    }

    public void setIsShareThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.isShareThread = z;
        }
    }

    public void setLive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.isLive = z;
        }
    }

    public void setLiveId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.liveId = str;
        }
    }

    public void setManga(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.isManga = z;
        }
    }

    public void setPostID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.postID = str;
        }
    }

    public void setSquence(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.isSquence = z;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.threadId = str;
        }
    }

    public void setThreadName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.threadName = str;
        }
    }

    public void setThreadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.threadType = i;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j) == null) {
            this.time = j;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.userName = str;
        }
    }

    public boolean parserByJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            String optString = jSONObject.optString("forum_name");
            String optString2 = jSONObject.optString("thread_id");
            String optString3 = jSONObject.optString(CrashHianalyticsData.THREAD_NAME);
            long optLong = jSONObject.optLong("thread_time");
            this.postID = jSONObject.optString("post_id");
            this.isHostOnly = jSONObject.optBoolean("host_only");
            this.isSquence = jSONObject.optBoolean("squence");
            this.isManga = jSONObject.optBoolean("is_manga");
            this.cartoonId = jSONObject.optLong(MangaBrowserActivityConfig.CARTOON_ID);
            this.chapterId = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
            this.isShareThread = jSONObject.optBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            if (!TextUtils.isEmpty(optString)) {
                this.forumName = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.threadId = optString2;
            }
            if (!TextUtils.isEmpty(optString3)) {
                this.threadName = optString3;
            }
            if (optLong > 2000) {
                this.time = optLong;
            }
            this.threadType = jSONObject.optInt("thread_type");
            this.liveId = jSONObject.optString("live_id", "");
            this.userName = jSONObject.optString("user_name", "");
            this.description = jSONObject.optString("live_description", "");
            return true;
        }
        return invokeL.booleanValue;
    }

    public JSONObject toJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_name", this.forumName);
                jSONObject.put("thread_id", this.threadId);
                jSONObject.put("thread_time", this.time);
                jSONObject.put(CrashHianalyticsData.THREAD_NAME, this.threadName);
                jSONObject.put("post_id", this.postID);
                jSONObject.put("host_only", this.isHostOnly);
                jSONObject.put("squence", this.isSquence);
                jSONObject.put("thread_type", this.threadType);
                jSONObject.put("is_manga", this.isManga);
                jSONObject.put(MangaBrowserActivityConfig.CARTOON_ID, this.cartoonId);
                jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.chapterId);
                jSONObject.put(VideoPlayActivityConfig.IS_SHARE_THREAD, this.isShareThread);
                jSONObject.put("live_id", this.liveId);
                jSONObject.put("user_name", this.userName);
                jSONObject.put("live_description", this.description);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}

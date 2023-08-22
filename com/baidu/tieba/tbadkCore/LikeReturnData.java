package com.baidu.tieba.tbadkCore;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.pea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class LikeReturnData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String blockUrl;
    public int cur_score;
    public int errorCode;
    public String errorMsg;
    public List<FeedForumData> feedForumDataList;
    public String fid;
    public int is_black;
    public int is_like;
    public String level_name;
    public int levelup_score;
    public int like_num;
    public BlockPopInfoData mBlockPopInfoData;
    public String memberSum;
    public List<pea> recommendForums;
    public BdToastData toastData;
    public int user_level;

    public LikeReturnData() {
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
        this.feedForumDataList = new ArrayList();
        this.recommendForums = new ArrayList();
        this.is_black = 0;
        this.like_num = 0;
        this.user_level = 0;
        setLevelName("");
        setLike(0);
        setCurScore(0);
        setLevelupScore(0);
    }

    private void parseBlockAnti(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.blockUrl = jSONObject.optString("block_dealurl");
        String optString = jSONObject.optString("block_content");
        if (!StringUtils.isNull(optString)) {
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.mBlockPopInfoData = blockPopInfoData;
            blockPopInfoData.block_info = optString;
            blockPopInfoData.ahead_url = this.blockUrl;
            blockPopInfoData.ahead_info = jSONObject.optString("block_confirm");
            this.mBlockPopInfoData.ok_info = jSONObject.optString("block_cancel");
        }
    }

    public void parseRecommendForums(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONArray) == null) {
            this.recommendForums.clear();
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        pea a = pea.a((JSONObject) jSONArray.opt(i));
                        if (a != null) {
                            this.recommendForums.add(a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                parserJson(jSONObject.optJSONObject("info"));
                parseFeedForumList(jSONObject.optJSONArray("feed_forum"));
                parseRecommendForums(jSONObject.optJSONArray("recom_forum"));
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public BlockPopInfoData getBlockPopInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBlockPopInfoData;
        }
        return (BlockPopInfoData) invokeV.objValue;
    }

    public String getBlockUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.blockUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getCurScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cur_score;
        }
        return invokeV.intValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.errorCode;
        }
        return invokeV.intValue;
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.errorMsg;
        }
        return (String) invokeV.objValue;
    }

    public List<FeedForumData> getFeedForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.feedForumDataList;
        }
        return (List) invokeV.objValue;
    }

    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.fid;
        }
        return (String) invokeV.objValue;
    }

    public String getLevelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.level_name;
        }
        return (String) invokeV.objValue;
    }

    public int getLevelupScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.levelup_score;
        }
        return invokeV.intValue;
    }

    public int getLikeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.like_num;
        }
        return invokeV.intValue;
    }

    public String getMemberSum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.memberSum;
        }
        return (String) invokeV.objValue;
    }

    public List<pea> getRecommendForums() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.recommendForums;
        }
        return (List) invokeV.objValue;
    }

    public BdToastData getToastData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.toastData;
        }
        return (BdToastData) invokeV.objValue;
    }

    public int getUserLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.user_level;
        }
        return invokeV.intValue;
    }

    public int isBlack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.is_black;
        }
        return invokeV.intValue;
    }

    public int isLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.is_like;
        }
        return invokeV.intValue;
    }

    public void parseFeedForumList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONArray) == null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                    FeedForumData feedForumData = new FeedForumData();
                    feedForumData.setForumId(jSONObject.optString("forum_id"));
                    feedForumData.setForumName(jSONObject.optString("forum_name"));
                    feedForumData.setMemberCount(jSONObject.optInt("member_count", 0));
                    feedForumData.setPostNum(jSONObject.optInt("post_num", 0));
                    feedForumData.setAvatar(jSONObject.optString("avatar"));
                    feedForumData.setReason(jSONObject.optString("reason"));
                    feedForumData.setIsLike(jSONObject.optInt("is_like", 0));
                    feedForumData.setPos(jSONObject.optInt("pos", 0));
                    this.feedForumDataList.add(feedForumData);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.is_black = jSONObject.optInt("is_black", 0);
            this.like_num = jSONObject.optInt("like_num", 0);
            this.user_level = jSONObject.optInt("level_id", 0);
            this.memberSum = jSONObject.optString("member_sum");
            setLike(jSONObject.optInt("is_like", 0));
            setLevelName(jSONObject.optString("level_name", ""));
            setLevelupScore(jSONObject.optInt("levelup_score", 0));
            setCurScore(jSONObject.optInt("cur_score", 0));
            parseBlockAnti(jSONObject);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void setBlockPopInfoData(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, blockPopInfoData) == null) {
            this.mBlockPopInfoData = blockPopInfoData;
        }
    }

    public void setBlockUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.blockUrl = str;
        }
    }

    public void setCurScore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.cur_score = i;
        }
    }

    public void setErrorCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.errorCode = i;
        }
    }

    public void setErrorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.errorMsg = str;
        }
    }

    public void setFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.feedForumDataList = list;
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.fid = str;
        }
    }

    public void setLevelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.level_name = str;
        }
    }

    public void setLevelupScore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.levelup_score = i;
        }
    }

    public void setLike(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.is_like = i;
        }
    }

    public void setMemberSum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.memberSum = str;
        }
    }

    public void setToastData(BdToastData bdToastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdToastData) == null) {
            this.toastData = bdToastData;
        }
    }

    public void setUserLevel(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i) == null) && i >= 0) {
            this.user_level = i;
        }
    }
}

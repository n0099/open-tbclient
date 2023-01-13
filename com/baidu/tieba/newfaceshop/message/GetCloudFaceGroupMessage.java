package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ca5;
import com.baidu.tieba.d18;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.DiyEmotionData;
import com.baidu.tieba.g18;
import com.baidu.tieba.gj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetCloudFaceGroupMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CollectEmotionData> mCollectEmotionList;
    public long mCollectUpdateTime;
    public List<DiyEmotionData> mDiyEmotionList;
    public long mDiyUpdateTime;
    public List<String> mFaceGroupData;
    public long mFaceGroupUpdateTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCloudFaceGroupMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                d18.a("【表情云同步】：2 - 开始：解析请求返回数据");
                parseData(jSONObject.optJSONObject("data"));
                return;
            }
            d18.a("【表情云同步】：2 - 失败：返回数据异常，网络异常");
        }
    }

    public List<CollectEmotionData> getCollectEmotionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCollectEmotionList;
        }
        return (List) invokeV.objValue;
    }

    public long getCollectUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCollectUpdateTime;
        }
        return invokeV.longValue;
    }

    public List<DiyEmotionData> getDiyEmotionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDiyEmotionList;
        }
        return (List) invokeV.objValue;
    }

    public long getDiyUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDiyUpdateTime;
        }
        return invokeV.longValue;
    }

    public List<String> getFaceGroupData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mFaceGroupData;
        }
        return (List) invokeV.objValue;
    }

    public long getFaceGroupUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mFaceGroupUpdateTime;
        }
        return invokeV.longValue;
    }

    public void parseCollectData(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONArray) == null) {
            if (jSONArray == null) {
                d18.a("【表情云同步】：2 - 开始：解析收藏表情数据为null");
                return;
            }
            d18.a("【表情云同步】：2 - 开始：解析收藏表情");
            this.mCollectEmotionList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        CollectEmotionData collectEmotionData = new CollectEmotionData();
                        collectEmotionData.pid = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                        collectEmotionData.picUrl = jSONObject.optString("pic_url");
                        collectEmotionData.width = jSONObject.optInt("width");
                        collectEmotionData.height = jSONObject.optInt("height");
                        collectEmotionData.thumbnail = jSONObject.optString("thumbnail");
                        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
                        collectEmotionData.pkgId = jSONObject.optString("pck_id");
                        StringBuilder sb = new StringBuilder(ca5.h);
                        if (TextUtils.isEmpty(collectEmotionData.pkgId)) {
                            sb.append(collectEmotionData.pkgId);
                            sb.append(",");
                        } else {
                            sb.append(collectEmotionData.pkgId);
                            sb.append("_");
                            sb.append(collectEmotionData.pid);
                            sb.append(",");
                        }
                        sb.append(collectEmotionData.width);
                        sb.append(",");
                        sb.append(collectEmotionData.height);
                        sb.append(",");
                        String lowerCase = gj.c(sb.toString().replace("collect_", "") + UploadedImageInfo.MD5_KEY).toLowerCase();
                        collectEmotionData.setSharpText(SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
                        d18.a("【表情云同步】：2 - 开始：解析收藏表情：" + i + "-" + collectEmotionData.picUrl);
                        this.mCollectEmotionList.add(collectEmotionData);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void parseData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            if (jSONObject == null) {
                d18.a("【表情云同步】：2 - 失败：返回数据异常，数据为null");
                return;
            }
            this.mCollectUpdateTime = jSONObject.optLong("pic_update_time");
            this.mDiyUpdateTime = jSONObject.optLong("diy_pic_update_time");
            if (g18.l() < this.mCollectUpdateTime) {
                parseCollectData(jSONObject.optJSONArray("pic_ids"));
            } else {
                d18.a("【表情云同步】：2 - 开始：不需要解析收藏表情，" + this.mCollectUpdateTime);
            }
            if (g18.m() < this.mDiyUpdateTime) {
                parseDiyData(jSONObject.optJSONArray("diy_pic_ids"));
            } else {
                d18.a("【表情云同步】：2 - 开始：不需要解析diy表情，" + this.mCollectUpdateTime);
            }
            this.mFaceGroupUpdateTime = jSONObject.optLong("pkg_update_time");
            if (g18.n() < this.mFaceGroupUpdateTime) {
                parseFaceGroupData(jSONObject.optString("package_ids"));
                return;
            }
            d18.a("【表情云同步】：2 - 开始：不需要解析表情包组，" + this.mFaceGroupUpdateTime);
        }
    }

    public void parseDiyData(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONArray) == null) {
            if (jSONArray == null) {
                d18.a("【表情云同步】：2 - 开始：解析DIY表情数据为null");
                return;
            }
            d18.a("【表情云同步】：2 - 开始：解析DIY表情");
            this.mDiyEmotionList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        DiyEmotionData diyEmotionData = new DiyEmotionData();
                        diyEmotionData.setPid(jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY));
                        diyEmotionData.setPicUrl(jSONObject.optString("pic_url"));
                        diyEmotionData.setWidth(jSONObject.optInt("width"));
                        diyEmotionData.setHeight(jSONObject.optInt("height"));
                        diyEmotionData.setThumbnail(jSONObject.optString("thumbnail"));
                        diyEmotionData.setUid(TbadkCoreApplication.getCurrentAccount());
                        diyEmotionData.setPkgId(jSONObject.optString("pck_id"));
                        StringBuilder sb = new StringBuilder("meme,diy_");
                        if (TextUtils.isEmpty(diyEmotionData.getPkgId())) {
                            sb.append(diyEmotionData.getPkgId());
                            sb.append(",");
                        } else {
                            sb.append(diyEmotionData.getPkgId());
                            sb.append("_");
                            sb.append(diyEmotionData.getPid());
                            sb.append(",");
                        }
                        sb.append(diyEmotionData.getWidth());
                        sb.append(",");
                        sb.append(diyEmotionData.getHeight());
                        sb.append(",");
                        String lowerCase = gj.c(sb.toString().replace("diy_", "") + UploadedImageInfo.MD5_KEY).toLowerCase();
                        diyEmotionData.setSharpText(SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
                        d18.a("【表情云同步】：2 - 开始：解析DIY表情：" + i + "-" + diyEmotionData.getPicUrl());
                        this.mDiyEmotionList.add(diyEmotionData);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void parseFaceGroupData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            d18.a("【表情云同步】：2 - 开始：解析表情包组，" + str);
            this.mFaceGroupData = Arrays.asList(str.split("_"));
        }
    }
}

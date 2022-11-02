package com.baidubce.services.vod.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.model.AbstractBceResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetMediaResourceResponse extends AbstractBceResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Attributes attributes;
    public String createTime;
    public VodError error;
    public String mediaId;
    public MediaMeta meta;
    public List<PlayableUrl> playableUrlList;
    public String publishTime;
    public String source;
    public String status;
    public List<String> thumbnailList;
    public String transcodingPresetGroupName;

    public GetMediaResourceResponse() {
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
        this.playableUrlList = new ArrayList();
        this.thumbnailList = new ArrayList();
    }

    public Attributes getAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.attributes;
        }
        return (Attributes) invokeV.objValue;
    }

    public String getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.createTime;
        }
        return (String) invokeV.objValue;
    }

    public VodError getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.error;
        }
        return (VodError) invokeV.objValue;
    }

    public String getMediaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mediaId;
        }
        return (String) invokeV.objValue;
    }

    public MediaMeta getMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.meta;
        }
        return (MediaMeta) invokeV.objValue;
    }

    public List<PlayableUrl> getPlayableUrlList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.playableUrlList;
        }
        return (List) invokeV.objValue;
    }

    public String getPublishTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.publishTime;
        }
        return (String) invokeV.objValue;
    }

    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.source;
        }
        return (String) invokeV.objValue;
    }

    public String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.status;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getThumbnailList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.thumbnailList;
        }
        return (List) invokeV.objValue;
    }

    public String getTranscodingPresetGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.transcodingPresetGroupName;
        }
        return (String) invokeV.objValue;
    }

    public static void formatJsonToObject(JSONObject jSONObject, GetMediaResourceResponse getMediaResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, getMediaResourceResponse) == null) {
            try {
                getMediaResourceResponse.setMediaId(jSONObject.getString("mediaId"));
                getMediaResourceResponse.setStatus(jSONObject.getString("status"));
                getMediaResourceResponse.setAttributes(Attributes.formatFromJson(jSONObject.getJSONObject("attributes")));
                getMediaResourceResponse.setMeta(MediaMeta.formatFromJson(jSONObject.getJSONObject("meta")));
                if (getMediaResourceResponse.getStatus().equalsIgnoreCase("failed")) {
                    getMediaResourceResponse.setError(VodError.formatFromJson(jSONObject.getJSONObject("error")));
                }
                getMediaResourceResponse.setPublishTime(jSONObject.optString("publishTime"));
                getMediaResourceResponse.setCreateTime(jSONObject.getString(FileMetaUtil.CREATE_TIME));
                getMediaResourceResponse.setTranscodingPresetGroupName(jSONObject.getString("transcodingPresetGroupName"));
                JSONArray optJSONArray = jSONObject.optJSONArray("playableUrlList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(PlayableUrl.formatFromJson(optJSONArray.getJSONObject(i)));
                    }
                    getMediaResourceResponse.setPlayableUrlList(arrayList);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("thumbnailList");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList2.add(optJSONArray2.getString(i2));
                    }
                    getMediaResourceResponse.setThumbnailList(arrayList2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setAttributes(Attributes attributes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, attributes) == null) {
            this.attributes = attributes;
        }
    }

    public void setCreateTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.createTime = str;
        }
    }

    public void setError(VodError vodError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vodError) == null) {
            this.error = vodError;
        }
    }

    public void setMediaId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mediaId = str;
        }
    }

    public void setMeta(MediaMeta mediaMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mediaMeta) == null) {
            this.meta = mediaMeta;
        }
    }

    public void setPlayableUrlList(List<PlayableUrl> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.playableUrlList = list;
        }
    }

    public void setPublishTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.publishTime = str;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.source = str;
        }
    }

    public void setStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.status = str;
        }
    }

    public void setThumbnailList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            this.thumbnailList = list;
        }
    }

    public void setTranscodingPresetGroupName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.transcodingPresetGroupName = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            StringBuilder sb = new StringBuilder("GetMediaResourceResponse { \n");
            sb.append("  mediaId = ");
            sb.append(this.mediaId);
            sb.append("\n");
            sb.append("  status = ");
            sb.append(this.status);
            sb.append("\n");
            sb.append("  attributes = ");
            sb.append(this.attributes);
            sb.append("\n");
            sb.append("  meta = ");
            sb.append(this.meta);
            sb.append("\n");
            sb.append("  createTime = ");
            sb.append(this.createTime);
            sb.append("\n");
            sb.append("  publishTime = ");
            sb.append(this.publishTime);
            sb.append("\n");
            sb.append("  transcodingPresetGroupName = ");
            sb.append(this.transcodingPresetGroupName);
            sb.append("\n");
            sb.append("  source = ");
            sb.append(this.source);
            sb.append("\n");
            sb.append("  playableUrlList = [");
            sb.append("\n");
            for (PlayableUrl playableUrl : this.playableUrlList) {
                sb.append(playableUrl.toString());
                sb.append("\n");
            }
            sb.append("] \n");
            sb.append("  thumbnailList = [");
            sb.append("\n");
            for (String str : this.thumbnailList) {
                sb.append("    thumbnail =");
                sb.append(str);
                sb.append("\n");
            }
            VodError vodError = this.error;
            if (vodError != null) {
                sb.append(vodError);
                sb.append("\n");
            }
            sb.append("}\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

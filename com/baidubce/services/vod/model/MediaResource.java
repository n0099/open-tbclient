package com.baidubce.services.vod.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MediaResource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Attributes attributes;
    public String createTime;
    public String mediaId;
    public MediaMeta meta;
    public List<PlayableUrl> playableUrlList;
    public String publishTime;
    public String source;
    public String status;
    public List<String> thumbnailList;
    public String transcodingPresetGroupName;

    public MediaResource() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.attributes : (Attributes) invokeV.objValue;
    }

    public String getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.createTime : (String) invokeV.objValue;
    }

    public String getMediaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mediaId : (String) invokeV.objValue;
    }

    public MediaMeta getMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.meta : (MediaMeta) invokeV.objValue;
    }

    public List<PlayableUrl> getPlayableUrlList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.playableUrlList : (List) invokeV.objValue;
    }

    public String getPublishTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.publishTime : (String) invokeV.objValue;
    }

    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.source : (String) invokeV.objValue;
    }

    public String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.status : (String) invokeV.objValue;
    }

    public List<String> getThumbnailList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.thumbnailList : (List) invokeV.objValue;
    }

    public String getTranscodingPresetGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.transcodingPresetGroupName : (String) invokeV.objValue;
    }

    public void setAttributes(Attributes attributes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, attributes) == null) {
            this.attributes = attributes;
        }
    }

    public void setCreateTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.createTime = str;
        }
    }

    public void setMediaId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mediaId = str;
        }
    }

    public void setMeta(MediaMeta mediaMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mediaMeta) == null) {
            this.meta = mediaMeta;
        }
    }

    public void setPlayableUrlList(List<PlayableUrl> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.playableUrlList = list;
        }
    }

    public void setPublishTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.publishTime = str;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.source = str;
        }
    }

    public void setStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.status = str;
        }
    }

    public void setThumbnailList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.thumbnailList = list;
        }
    }

    public void setTranscodingPresetGroupName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.transcodingPresetGroupName = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = new StringBuilder("  MediaResource { \n");
            sb.append("    mediaId = ");
            sb.append(this.mediaId);
            sb.append("\n");
            sb.append("    status = ");
            sb.append(this.status);
            sb.append("\n");
            sb.append("    attributes = ");
            sb.append(this.attributes);
            sb.append("\n");
            sb.append("    meta = ");
            sb.append(this.meta);
            sb.append("\n");
            sb.append("    createTime = ");
            sb.append(this.createTime);
            sb.append("\n");
            sb.append("    publishTime = ");
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
            sb.append("  }\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

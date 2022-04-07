package com.baidu.ugc.bean;

import android.media.MediaMetadataRetriever;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class VideoInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitRate;
    public long cutDuration;
    public long cutPoint;
    public int duration;
    public int expHeight;
    public int expWidth;
    public int frameInterval;
    public int frameRate;
    public int height;
    public String path;
    public int rotation;
    public int width;

    public VideoInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static VideoInfo getVideoInfo(String str) {
        InterceptResult invokeL;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            VideoInfo videoInfo2 = null;
            try {
                mediaMetadataRetriever.setDataSource(str);
                videoInfo = new VideoInfo();
            } catch (Exception e) {
                e = e;
            }
            try {
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(9);
                videoInfo.path = str;
                videoInfo.width = Integer.parseInt(extractMetadata2);
                videoInfo.height = Integer.parseInt(extractMetadata3);
                videoInfo.duration = Integer.parseInt(extractMetadata4);
                videoInfo.rotation = Integer.parseInt(extractMetadata);
                return videoInfo;
            } catch (Exception e2) {
                e = e2;
                videoInfo2 = videoInfo;
                e.printStackTrace();
                return videoInfo2;
            }
        }
        return (VideoInfo) invokeL.objValue;
    }

    public String getInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "path:" + this.path + ", rotation:" + this.rotation + ", width:" + this.width + ", height:" + this.height + ", bitRate:" + this.bitRate + ", frameRate:" + this.frameRate + ", frameInterval:" + this.frameInterval + ", duration:" + this.duration + ", expWidth:" + this.expWidth + ", expHeight:" + this.expHeight + ", cutPoint:" + this.cutPoint + ", cutDuration:" + this.cutDuration;
        }
        return (String) invokeV.objValue;
    }
}

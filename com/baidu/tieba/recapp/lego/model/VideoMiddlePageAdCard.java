package com.baidu.tieba.recapp.lego.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.e;
import c.a.e.d;
import c.a.t0.j3.i0.b.a;
import c.a.t0.j3.i0.b.g;
import c.a.t0.x1.o.h.b;
import c.a.t0.x1.o.l.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes12.dex */
public class VideoMiddlePageAdCard extends BaseLegoCardInfo implements i, c.a.e.i, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d adFacadeData;
    public boolean autoPlay;
    public a operateData;
    public b.a parallelChargeInfo;
    public String tagName;
    public g tailFrame;
    public String threadTitle;
    public String userName;
    public String userPortrait;
    public VideoInfo video;
    public boolean waitConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageAdCard(JSONObject jSONObject) {
        super(jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSONObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.autoPlay = false;
        this.waitConfirm = false;
        this.userName = jSONObject.optString("user_name");
        this.userPortrait = jSONObject.optString("user_portrait");
        this.threadTitle = jSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
        String optString = jSONObject.optString("tag_name", "广告");
        this.tagName = optString;
        if (TextUtils.isEmpty(optString)) {
            this.tagName = "广告";
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject != null && optJSONObject.length() > 0) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = optJSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5, "");
            builder.video_url = optJSONObject.optString("video_url", "");
            builder.video_duration = Integer.valueOf(optJSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
            builder.video_width = Integer.valueOf(optJSONObject.optInt("video_width", 0));
            builder.video_height = Integer.valueOf(optJSONObject.optInt("video_height", 0));
            builder.thumbnail_url = optJSONObject.optString("thumbnail_url", "");
            builder.thumbnail_width = Integer.valueOf(optJSONObject.optInt("thumbnail_width", 0));
            builder.thumbnail_height = Integer.valueOf(optJSONObject.optInt("thumbnail_height", 0));
            builder.video_length = Integer.valueOf(optJSONObject.optInt("video_length", 0));
            builder.play_count = Integer.valueOf(optJSONObject.optInt("play_count", -1));
            builder.media_subtitle = optJSONObject.optString("media_subtitle", "");
            this.video = builder.build(true);
        } else {
            this.video = null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
        g gVar = new g();
        this.tailFrame = gVar;
        gVar.b(optJSONObject2);
        this.operateData = a.a(jSONObject.optJSONObject("operate"));
        b.a aVar = new b.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
        if (TextUtils.isEmpty(this.operateData.a)) {
            this.operateData.a = this.userName;
        }
    }

    private JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("card_type", this.cardType);
                jSONObject.put("user_portrait", this.userPortrait);
                jSONObject.put("user_name", this.userPortrait);
                jSONObject.put(MissonDetailsActivityConfig.THREAD_TITLE, this.userPortrait);
                jSONObject.put("scheme", this.userPortrait);
                jSONObject.put("tag_name", this.userPortrait);
                JSONObject jSONObject2 = new JSONObject();
                if (this.video != null) {
                    jSONObject2.put("thumbnail_url", this.video.thumbnail_url);
                    jSONObject2.put("thumbnail_width", this.video.thumbnail_width);
                    jSONObject2.put("thumbnail_height", this.video.video_height);
                    jSONObject2.put("thumbnail_width", this.video.thumbnail_width);
                    jSONObject2.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.video.video_duration);
                    jSONObject2.put("video_width", this.video.video_width);
                    jSONObject2.put("video_height", this.video.video_height);
                    jSONObject2.put("video_url", this.video.video_url);
                }
                jSONObject.put(WriteActivityConfig.VIDEO_INFO, jSONObject2);
                jSONObject.put(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.tailFrame.d());
                jSONObject.put("operate", this.operateData.b());
                if (this.adFacadeData != null && this.adFacadeData.i() != null) {
                    jSONObject.put("extraparams", this.adFacadeData.i().f3438b);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String adCollect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] bytes = toJson().toString().getBytes();
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bytes[i2] = (byte) (bytes[i2] ^ 47);
            }
            return new String(e.m(bytes));
        }
        return (String) invokeV.objValue;
    }

    public d getAdFacadeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.adFacadeData : (d) invokeV.objValue;
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.autoPlay : invokeV.booleanValue;
    }

    public String getButtonScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = this.operateData;
            if (aVar != null && !TextUtils.isEmpty(aVar.f18391c)) {
                return this.operateData.f18391c;
            }
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.t0.x1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.parallelChargeInfo : (b.a) invokeV.objValue;
    }

    public boolean getWaitConfirm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.waitConfirm : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.e.i
    public void setAdFacadeData(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.adFacadeData = dVar;
        }
    }

    @Override // c.a.t0.x1.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.autoPlay = z;
        }
    }

    @Override // c.a.t0.x1.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.waitConfirm = z;
        }
    }
}

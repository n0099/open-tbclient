package com.baidu.ugc.editvideo.data;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.google.gson.reflect.TypeToken;
import d.a.y0.j.b;
import d.a.y0.t.h;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MultiMediaData implements Parcelable, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<MultiMediaData> CREATOR;
    public static final float MAX_SPEED = 8.0f;
    public static final float MIN_SPEED = 0.01f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean addDefaultEffect;
    public float angle;
    public int backupFrameTextureId;
    public long basePts;
    public long currentPts;
    public long end;
    public String ext;
    public int frameCount;
    public int frameFps;
    public int frameIndex;
    public int frameStartIndex;
    public String frameSuffix;
    public int height;
    public String inputType;
    public boolean loop;
    public float mSpeed;
    public boolean mipmap;
    public float[] mtx;
    public long offset;
    public long originalDuration;
    public String path;
    public transient VLogSimplePlayer player;
    public transient boolean playerReady;
    public float rotation;
    public String scaleType;
    public float scaleX;
    public float scaleY;
    public long start;
    public String subTitleText;
    public transient Surface surface;
    public transient SurfaceTexture surfaceTexture;
    public int textureId;
    @IntRange(from = 0, to = 1)
    public int textureMode;
    @IntRange(from = 0, to = 1)
    public int type;
    public String uuid;
    public transient MediaCodec videoDecoder;
    public transient boolean videoDecoderDone;
    public transient MediaExtractor videoExtractor;
    public transient boolean videoExtractorDone;
    public float volume;
    public int width;
    public float x;
    public float y;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface MultiMediaType {
        public static final int TYPE_IMAGE = 0;
        public static final int TYPE_VIDEO = 1;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(932789707, "Lcom/baidu/ugc/editvideo/data/MultiMediaData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(932789707, "Lcom/baidu/ugc/editvideo/data/MultiMediaData;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<MultiMediaData>() { // from class: com.baidu.ugc.editvideo.data.MultiMediaData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MultiMediaData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new MultiMediaData(parcel) : (MultiMediaData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MultiMediaData[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new MultiMediaData[i2] : (MultiMediaData[]) invokeI.objValue;
            }
        };
    }

    public MultiMediaData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mtx = new float[16];
        this.textureMode = 1;
        this.scaleType = MultiDataSourceUtil.sDefaultScaleType;
        this.frameIndex = -1;
        this.volume = 1.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.mSpeed = 1.0f;
        this.uuid = UUID.randomUUID().toString();
    }

    public MultiMediaData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mtx = new float[16];
        this.textureMode = 1;
        this.scaleType = MultiDataSourceUtil.sDefaultScaleType;
        this.frameIndex = -1;
        this.volume = 1.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.mSpeed = 1.0f;
        this.type = parcel.readInt();
        this.path = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.rotation = parcel.readFloat();
        this.angle = parcel.readFloat();
        this.inputType = parcel.readString();
        this.textureId = parcel.readInt();
        this.mtx = parcel.createFloatArray();
        this.textureMode = parcel.readInt();
        this.scaleType = parcel.readString();
        this.mipmap = parcel.readByte() != 0;
        this.frameFps = parcel.readInt();
        this.frameSuffix = parcel.readString();
        this.frameCount = parcel.readInt();
        this.frameIndex = parcel.readInt();
        this.frameStartIndex = parcel.readInt();
        this.backupFrameTextureId = parcel.readInt();
        this.start = parcel.readLong();
        this.end = parcel.readLong();
        this.originalDuration = parcel.readLong();
        this.offset = parcel.readLong();
        this.currentPts = parcel.readLong();
        this.basePts = parcel.readLong();
        this.addDefaultEffect = parcel.readByte() != 0;
        this.volume = parcel.readFloat();
        this.loop = parcel.readByte() != 0;
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.scaleX = parcel.readFloat();
        this.scaleY = parcel.readFloat();
        this.subTitleText = parcel.readString();
        this.uuid = parcel.readString();
        this.mSpeed = parcel.readFloat();
        this.ext = parcel.readString();
    }

    public static String arratToJson(List<MultiMediaData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (h.e(list)) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                MultiMediaData multiMediaData = (MultiMediaData) list.get(i2).clone();
                multiMediaData.textureId = 0;
                arrayList.add(multiMediaData);
            }
            return h.e(arrayList) ? "" : new b().a(arrayList);
        }
        return (String) invokeL.objValue;
    }

    public static List<String> getExtList(List<MultiMediaData> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, list, str)) == null) {
            if (h.e(list) || TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (MultiMediaData multiMediaData : list) {
                if (multiMediaData != null) {
                    String ext = multiMediaData.getExt(str);
                    if (!TextUtils.isEmpty(ext)) {
                        arrayList.add(ext);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<MultiMediaData> parseArrayList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            new ArrayList();
            try {
                return (List) new b().c(str, new TypeToken<List<MultiMediaData>>() { // from class: com.baidu.ugc.editvideo.data.MultiMediaData.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }
                }.getType());
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return new MultiMediaData();
            }
        }
        return invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public float getCurrentSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mSpeed <= 0.0f) {
                this.mSpeed = 1.0f;
            }
            if (this.mSpeed > 8.0f) {
                this.mSpeed = 8.0f;
            }
            if (this.mSpeed < 0.01f) {
                this.mSpeed = 0.01f;
            }
            return this.mSpeed;
        }
        return invokeV.floatValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((float) (this.end - this.start)) / getCurrentSpeed() : invokeV.longValue;
    }

    public String getExt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.ext)) {
                return "";
            }
            try {
                return new JSONObject(this.ext).optString(str);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean isFooter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(this.inputType) : invokeV.booleanValue;
    }

    public boolean isFrameSequential() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.frameFps == 0 || TextUtils.isEmpty(this.frameSuffix)) ? false : true : invokeV.booleanValue;
    }

    public boolean isHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? MediaSegment.SEG_TYPE_INPUT_HEADER.equals(this.inputType) : invokeV.booleanValue;
    }

    public boolean isOtherTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.inputType) || this.inputType.contains("input")) ? false : true : invokeV.booleanValue;
    }

    public boolean isSuperpositionFooter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? MediaSegment.SEG_TYPE_INPUT_SUPERPOSITION_FOOTER.equals(this.inputType) : invokeV.booleanValue;
    }

    public boolean isSuperpositionHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? MediaSegment.SEG_TYPE_INPUT_SUPERPOSITION_HEADER.equals(this.inputType) : invokeV.booleanValue;
    }

    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            releasePlayer(false);
        }
    }

    public void releasePlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            try {
                try {
                    if (this.player != null) {
                        if (z) {
                            this.player.releaseOnInvokeThread();
                        } else {
                            this.player.release();
                        }
                        this.player = null;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.player = null;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.SurfaceTexture, android.view.Surface] */
    public void releaseSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                try {
                    if (this.surfaceTexture != null) {
                        this.surfaceTexture.release();
                        this.surfaceTexture = null;
                    }
                } finally {
                    this.surfaceTexture = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    if (this.surface != null) {
                        this.surface.release();
                        this.surface = null;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } finally {
                this.surface = null;
            }
        }
    }

    public void setExt(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) && !TextUtils.isEmpty(str) && str2 != null) {
            try {
                JSONObject jSONObject = TextUtils.isEmpty(this.ext) ? new JSONObject() : new JSONObject(this.ext);
                jSONObject.put(str, str2);
                this.ext = jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }

    public boolean updatePlayerSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            VLogSimplePlayer vLogSimplePlayer = this.player;
            if (vLogSimplePlayer != null) {
                float speed = vLogSimplePlayer.getSpeed();
                float f2 = this.mSpeed;
                if (speed != f2) {
                    this.player.setSpeed(f2);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, parcel, i2) == null) {
            parcel.writeInt(this.type);
            parcel.writeString(this.path);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeFloat(this.rotation);
            parcel.writeFloat(this.angle);
            parcel.writeString(this.inputType);
            parcel.writeInt(this.textureId);
            parcel.writeFloatArray(this.mtx);
            parcel.writeInt(this.textureMode);
            parcel.writeString(this.scaleType);
            parcel.writeByte(this.mipmap ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.frameFps);
            parcel.writeString(this.frameSuffix);
            parcel.writeInt(this.frameCount);
            parcel.writeInt(this.frameIndex);
            parcel.writeInt(this.frameStartIndex);
            parcel.writeInt(this.backupFrameTextureId);
            parcel.writeLong(this.start);
            parcel.writeLong(this.end);
            parcel.writeLong(this.originalDuration);
            parcel.writeLong(this.offset);
            parcel.writeLong(this.currentPts);
            parcel.writeLong(this.basePts);
            parcel.writeByte(this.addDefaultEffect ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.volume);
            parcel.writeByte(this.loop ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.x);
            parcel.writeFloat(this.y);
            parcel.writeFloat(this.scaleX);
            parcel.writeFloat(this.scaleY);
            parcel.writeString(this.subTitleText);
            parcel.writeString(this.uuid);
            parcel.writeFloat(this.mSpeed);
            parcel.writeString(this.ext);
        }
    }
}

package com.baidu.ugc.editvideo.data;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.IntRange;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.tieba.dva;
import com.baidu.tieba.ksa;
import com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class MultiMediaData implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<MultiMediaData> CREATOR = new Parcelable.Creator<MultiMediaData>() { // from class: com.baidu.ugc.editvideo.data.MultiMediaData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiMediaData createFromParcel(Parcel parcel) {
            return new MultiMediaData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiMediaData[] newArray(int i) {
            return new MultiMediaData[i];
        }
    };
    public static final float MAX_SPEED = 8.0f;
    public static final float MIN_SPEED = 0.01f;
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
    /* loaded from: classes8.dex */
    public @interface MultiMediaType {
        public static final int TYPE_IMAGE = 0;
        public static final int TYPE_VIDEO = 1;
    }

    public MultiMediaData() {
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
        if (dva.e(list)) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MultiMediaData multiMediaData = (MultiMediaData) list.get(i).clone();
            multiMediaData.textureId = 0;
            arrayList.add(multiMediaData);
        }
        return dva.e(arrayList) ? "" : new ksa().a(arrayList);
    }

    public static List<String> getExtList(List<MultiMediaData> list, String str) {
        if (dva.e(list) || TextUtils.isEmpty(str)) {
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

    public static List<MultiMediaData> parseArrayList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new ArrayList();
        try {
            return (List) new ksa().c(str, new TypeToken<List<MultiMediaData>>() { // from class: com.baidu.ugc.editvideo.data.MultiMediaData.2
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new MultiMediaData();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getCurrentSpeed() {
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

    public long getDuration() {
        return ((float) (this.end - this.start)) / getCurrentSpeed();
    }

    public String getExt(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.ext)) {
            return "";
        }
        try {
            return new JSONObject(this.ext).optString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean isFooter() {
        return MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(this.inputType);
    }

    public boolean isFrameSequential() {
        return (this.frameFps == 0 || TextUtils.isEmpty(this.frameSuffix)) ? false : true;
    }

    public boolean isHeader() {
        return MediaSegment.SEG_TYPE_INPUT_HEADER.equals(this.inputType);
    }

    public boolean isOtherTrack() {
        return (TextUtils.isEmpty(this.inputType) || this.inputType.contains("input")) ? false : true;
    }

    public boolean isSuperpositionFooter() {
        return MediaSegment.SEG_TYPE_INPUT_SUPERPOSITION_FOOTER.equals(this.inputType);
    }

    public boolean isSuperpositionHeader() {
        return MediaSegment.SEG_TYPE_INPUT_SUPERPOSITION_HEADER.equals(this.inputType);
    }

    public void releasePlayer() {
        releasePlayer(false);
    }

    public void releasePlayer(boolean z) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.player = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.SurfaceTexture, android.view.Surface] */
    public void releaseSurface() {
        try {
            try {
                if (this.surfaceTexture != null) {
                    this.surfaceTexture.release();
                    this.surfaceTexture = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                try {
                    if (this.surface != null) {
                        this.surface.release();
                        this.surface = null;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.surface = null;
            }
        } finally {
            this.surfaceTexture = null;
        }
    }

    public void setExt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            try {
                JSONObject jSONObject = TextUtils.isEmpty(this.ext) ? new JSONObject() : new JSONObject(this.ext);
                jSONObject.put(str, str2);
                this.ext = jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }

    public boolean updatePlayerSpeed() {
        VLogSimplePlayer vLogSimplePlayer = this.player;
        if (vLogSimplePlayer != null) {
            float speed = vLogSimplePlayer.getSpeed();
            float f = this.mSpeed;
            if (speed != f) {
                this.player.setSpeed(f);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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

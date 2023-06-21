package com.baidu.ugc.bean;

import androidx.annotation.NonNull;
import com.baidu.tieba.dua;
import java.util.List;
/* loaded from: classes8.dex */
public class LocalAlbumInfo extends LocalEntity implements Cloneable, Comparable<LocalAlbumInfo> {
    public static final int FACE_SCORE_BASE = 20;
    public static final int IMAGE = 0;
    public static final String LOCAL_ALBUM_KEY = "localalbuminfo";
    public static final int LOCAL_VIDEO_DURATION_NORMAL = 0;
    public static final int LOCAL_VIDEO_DURATION_SO_LONG = 2;
    public static final int LOCAL_VIDEO_DURATION_SO_SHORT = 1;
    public static final float MAX_SPEED = 8.0f;
    public static final float MIN_SPEED = 0.01f;
    public static final int NORMAL_SCORE_MAX = 10;
    public static final int SUPPORT_MAX_WIDTH_HEIGHT = 3000;
    public static final int VIDEO = 1;
    public static final int VIDEO_SCORE_BASE = 10;
    public static final long serialVersionUID = -7570868377253183814L;
    public float angle;
    public long date;
    public long duration;
    public long endTime;
    public int height;
    public int imageId;
    public boolean mIsShowSpeedChanger;
    public int orientation;
    public String path;
    public int score;
    public long size;
    public long startTime;
    public String uri;
    public String uuid;
    public int width;
    public int mediaType = 0;
    public boolean isSelected = false;
    public int faceNum = 0;
    public int selectCount = 0;
    public int durationType = 0;
    public float mGlobalSpeed = 1.0f;
    public float mSelfSpeed = 1.0f;
    public boolean isOverSupportSize = false;

    public float getCurrentSpeed() {
        float f = this.mSelfSpeed;
        float f2 = this.mGlobalSpeed;
        if (f * f2 <= 0.0f) {
            return 1.0f;
        }
        if (f * f2 > 8.0f) {
            return 8.0f;
        }
        if (f * f2 < 0.01f) {
            return 0.01f;
        }
        return f * f2;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDurationWithSpeed() {
        return ((float) (this.endTime - this.startTime)) / getCurrentSpeed();
    }

    public long getEndTimeMSWithSpeed() {
        return ((float) this.endTime) / getCurrentSpeed();
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public long getStartTimeMSWithSpeed() {
        return ((float) this.startTime) / getCurrentSpeed();
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isOverSupportSize() {
        return this.isOverSupportSize;
    }

    public boolean isShowSpeedChanger() {
        return this.mIsShowSpeedChanger;
    }

    public static boolean checkOverSupportSize(int i, int i2) {
        if (Math.max(i, i2) > 3000) {
            return true;
        }
        return false;
    }

    public static String toJSONList(List<LocalAlbumInfo> list) {
        if (list == null) {
            return null;
        }
        try {
            return new dua().a(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toJsonString(LocalAlbumInfo localAlbumInfo) {
        if (localAlbumInfo == null) {
            return null;
        }
        try {
            return new dua().a(localAlbumInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull LocalAlbumInfo localAlbumInfo) {
        if (localAlbumInfo == null) {
            return -1;
        }
        long j = this.date;
        long j2 = localAlbumInfo.date;
        if (j > j2) {
            return -1;
        }
        if (j < j2) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalAlbumInfo)) {
            return false;
        }
        LocalAlbumInfo localAlbumInfo = (LocalAlbumInfo) obj;
        String str = localAlbumInfo.uri;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        localAlbumInfo.uri = str;
        String str3 = this.uri;
        if (str3 != null) {
            str2 = str3;
        }
        this.uri = str2;
        if (!str2.equals(localAlbumInfo.uri) || this.mediaType != localAlbumInfo.mediaType) {
            return false;
        }
        return true;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setOverSupportSize(boolean z) {
        this.isOverSupportSize = z;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setShowSpeedChanger(boolean z) {
        this.mIsShowSpeedChanger = z;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public LocalAlbumInfo m150clone() {
        LocalAlbumInfo localAlbumInfo = new LocalAlbumInfo();
        localAlbumInfo.path = this.path;
        localAlbumInfo.uri = this.uri;
        localAlbumInfo.date = this.date;
        localAlbumInfo.size = this.size;
        localAlbumInfo.width = this.width;
        localAlbumInfo.height = this.height;
        localAlbumInfo.imageId = this.imageId;
        localAlbumInfo.isSelected = this.isSelected;
        localAlbumInfo.mediaType = this.mediaType;
        localAlbumInfo.duration = this.duration;
        localAlbumInfo.startTime = this.startTime;
        localAlbumInfo.endTime = this.endTime;
        localAlbumInfo.durationType = this.durationType;
        localAlbumInfo.score = this.score;
        localAlbumInfo.uuid = this.uuid;
        localAlbumInfo.orientation = this.orientation;
        localAlbumInfo.mGlobalSpeed = this.mGlobalSpeed;
        localAlbumInfo.mSelfSpeed = this.mSelfSpeed;
        localAlbumInfo.setShowSpeedChanger(this.mIsShowSpeedChanger);
        return localAlbumInfo;
    }
}

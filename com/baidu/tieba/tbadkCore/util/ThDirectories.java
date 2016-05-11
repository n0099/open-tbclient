package com.baidu.tieba.tbadkCore.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public class ThDirectories {
    private static final String sROOT = Environment.getExternalStorageDirectory() + "/tieba/togetherhi/";
    private static final String CAMERA_IMAGE_DIR = String.valueOf(sROOT) + "/image/";
    private static final String CAMERA_RECORD_DIR = String.valueOf(sROOT) + "record/";

    public static String getRootPath() {
        return sROOT;
    }

    public static String getCameraImagePath() {
        return CAMERA_IMAGE_DIR;
    }

    public static String getCameraRecordPath() {
        return CAMERA_RECORD_DIR;
    }

    public static String getVideoPath() {
        return String.valueOf(sROOT) + "video/";
    }

    public static String getAudioPath() {
        return String.valueOf(sROOT) + "audio/";
    }

    public static String getTempPath() {
        return String.valueOf(sROOT) + "temp/";
    }

    public static String getVideoTempPath() {
        return String.valueOf(sROOT) + ".video_temp/";
    }

    public static String getCacheDir() {
        return String.valueOf(getVideoPath()) + "cache/";
    }

    public static String getPhotoWonderSettingDir() {
        return String.valueOf(sROOT) + "settings/";
    }

    public static void init(Context context) {
        new File(getRootPath()).mkdirs();
        new File(getPhotoWonderSettingDir()).mkdirs();
        new File(getVideoPath()).mkdirs();
        new File(getAudioPath()).mkdirs();
        new File(getCameraImagePath()).mkdirs();
        new File(getCacheDir()).mkdirs();
        new File(CAMERA_IMAGE_DIR).mkdirs();
        new File(getTempPath()).mkdirs();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x000b: INVOKE  (r3v0 int A[REMOVE]) = (r4v0 java.lang.String) type: VIRTUAL call: java.lang.String.hashCode():int)] */
    public static File createTemp(String str) {
        return new File(getTempPath(), new StringBuilder().append(str.hashCode()).toString());
    }
}

package com.baidu.webkit.sdk;

import android.net.Uri;
/* loaded from: classes5.dex */
public abstract class PermissionRequest {
    public static final String RESOURCE_AUDIO_CAPTURE = "android.permission.RECORD_AUDIO";
    public static final String RESOURCE_MIDI_SYSEX = "com.baidu.webkit.sdk.resource.MIDI_SYSEX";
    public static final String RESOURCE_PROTECTED_MEDIA_ID = "com.baidu.webkit.sdk.resource.PROTECTED_MEDIA_ID";
    public static final String RESOURCE_VIDEO_CAPTURE = "android.permission.CAMERA";

    public abstract boolean defaultHandler();

    public abstract void deny();

    public abstract Uri getOrigin();

    public abstract String[] getResources();

    public abstract void grant(String[] strArr);
}

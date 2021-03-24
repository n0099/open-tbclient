package com.baidu.wallet.core.utils;

import com.baidu.searchbox.track.ui.TrackUI;
/* loaded from: classes5.dex */
public class ExceptionUtils {
    public static String createStackTrackMessage(Exception exc) {
        StackTraceElement[] stackTrace;
        StringBuffer stringBuffer = new StringBuffer();
        if (exc != null) {
            stringBuffer.append(exc.getClass());
            stringBuffer.append(": ");
            stringBuffer.append(exc.getMessage());
            stringBuffer.append("\n");
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                stringBuffer.append(TrackUI.SEPERATOR);
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }
}

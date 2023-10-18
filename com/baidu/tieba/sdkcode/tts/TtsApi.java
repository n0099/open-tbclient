package com.baidu.tieba.sdkcode.tts;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import kotlin.Metadata;
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/sdkcode/tts/TtsApi;", "", "addWeakListener", "", "speakerId", "", "ttsListener", "Lcom/baidu/tieba/sdkcode/tts/TtsListener;", "init", "context", "Landroid/content/Context;", DownloadStatisticConstants.UBC_TYPE_PAUSE, "pauseAll", "release", "releaseAll", DownloadStatisticConstants.UBC_TYPE_RESUME, "resumeAll", "speak", "text", "stop", "stopAll", "SdkCodeInterface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface TtsApi {
    void addWeakListener(String str, TtsListener ttsListener);

    void init(Context context);

    void pause(String str);

    void pauseAll();

    void release(String str);

    void releaseAll();

    void resume(String str);

    void resumeAll();

    void speak(String str, String str2);

    void stop(String str);

    void stopAll();
}

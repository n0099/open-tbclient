package com.baidu.tieba.sdkcode;

import android.content.Context;
import com.baidu.tieba.sdkcode.tts.TtsApi;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/tieba/sdkcode/ISdkCodePlugin;", "", "createTtsApi", "Lcom/baidu/tieba/sdkcode/tts/TtsApi;", "init", "", "context", "Landroid/content/Context;", "SdkCodeInterface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface ISdkCodePlugin {
    TtsApi createTtsApi();

    void init(Context context);
}

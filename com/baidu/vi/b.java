package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ AudioRecorder a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AudioRecorder audioRecorder, String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioRecorder, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = audioRecorder;
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x001a */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        AudioRecord audioRecord;
        boolean z;
        int i;
        AudioRecord audioRecord2;
        AudioRecord audioRecord3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Process.setThreadPriority(-19);
            audioRecord = this.a.a;
            audioRecord.startRecording();
            int i3 = 0;
            while (z) {
                i = this.a.f;
                byte[] bArr = new byte[i];
                audioRecord2 = this.a.a;
                if (audioRecord2 != null) {
                    audioRecord3 = this.a.a;
                    i2 = this.a.f;
                    i3 = audioRecord3.read(bArr, 0, i2);
                }
                if (i3 != -3 && i3 != -2 && i3 != -1 && i3 != 0) {
                    this.a.a(bArr, i3);
                } else {
                    this.a.a();
                }
            }
        }
    }
}

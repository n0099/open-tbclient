package com.baidu.tieba;

import android.media.MediaFormat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.NativeIttiam;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class sjc extends mjc implements NativeIttiam.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gjc
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public sjc(pic picVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {picVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l.d(-16);
        this.G = new WeakReference<>(picVar);
        this.w = true;
        this.b = i;
        this.A.i(i);
        this.o = 2;
    }

    public void M(MediaInfo mediaInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaInfo) == null) {
            TLog.g(this, mediaInfo.toString());
            synchronized (this) {
                if (this.q.e(mediaInfo)) {
                    this.q.c(mediaInfo);
                }
                if (this.B == null || this.B.capacity() < this.q.i) {
                    this.B = ByteBuffer.allocateDirect(this.q.i);
                }
                int j = ((((int) cjc.j(this.q.d, 16L)) * ((int) cjc.j(this.q.e, 16L))) * 3) >> 1;
                if (j > this.D) {
                    this.D = j;
                    this.C = ByteBuffer.allocateDirect(j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.gjc
    public void z(MediaFormat mediaFormat, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, mediaFormat, i) == null) {
            this.x = System.currentTimeMillis();
            this.a = i;
            this.A.m(this);
            this.A.h(i);
            String string = mediaFormat.getString("mime");
            if (string.compareTo(MimeTypes.VIDEO_H265) == 0) {
                i2 = 7;
            } else {
                i2 = 0;
            }
            if (this.A.j(i2, mediaFormat) != 0) {
                m(50);
                TLog.g(this, "createDecoder failed mine: " + string);
            }
            M(MediaInfo.b(2, mediaFormat.getInteger("width"), mediaFormat.getInteger("height")));
            this.y = System.currentTimeMillis();
            TLog.g(this, "ittiamDecoder handleCreateDecoder: taskId " + i + ", spent: " + (this.y - this.x));
        }
    }
}

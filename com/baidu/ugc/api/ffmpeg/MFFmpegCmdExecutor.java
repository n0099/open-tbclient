package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.bcb;
import com.baidu.tieba.vfb;
import com.baidu.tieba.ye0;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MFFmpegCmdExecutor implements vfb {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public vfb.a mFFmpegCmdListener;

    /* loaded from: classes9.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ vfb.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, vfb.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            vfb.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            vfb.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            vfb.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (ye0.a() == null || TextUtils.isEmpty(ye0.b())) {
            Context context = bcb.c().getContext() != null ? bcb.c().getContext() : null;
            if (!TextUtils.isEmpty(bcb.c().b())) {
                str = bcb.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    ye0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.vfb
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.vfb
    public void start() {
        if (ye0.a() != null && !TextUtils.isEmpty(ye0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        vfb.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.vfb
    public synchronized void setListener(vfb.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.vfb
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

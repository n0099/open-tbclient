package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.fib;
import com.baidu.tieba.leb;
import com.baidu.tieba.ze0;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MFFmpegCmdExecutor implements fib {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public fib.a mFFmpegCmdListener;

    /* loaded from: classes9.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ fib.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, fib.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            fib.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            fib.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            fib.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (ze0.a() == null || TextUtils.isEmpty(ze0.b())) {
            Context context = leb.c().getContext() != null ? leb.c().getContext() : null;
            if (!TextUtils.isEmpty(leb.c().b())) {
                str = leb.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    ze0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.fib
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.fib
    public void start() {
        if (ze0.a() != null && !TextUtils.isEmpty(ze0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        fib.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.fib
    public synchronized void setListener(fib.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.fib
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

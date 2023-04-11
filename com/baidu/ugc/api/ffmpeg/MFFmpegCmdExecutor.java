package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.aha;
import com.baidu.tieba.gda;
import com.baidu.tieba.qd0;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MFFmpegCmdExecutor implements aha {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public aha.a mFFmpegCmdListener;

    /* loaded from: classes7.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ aha.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, aha.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            aha.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            aha.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            aha.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (qd0.a() == null || TextUtils.isEmpty(qd0.b())) {
            Context context = gda.c().getContext() != null ? gda.c().getContext() : null;
            if (!TextUtils.isEmpty(gda.c().b())) {
                str = gda.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    qd0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.aha
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.aha
    public void start() {
        if (qd0.a() != null && !TextUtils.isEmpty(qd0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        aha.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.aha
    public synchronized void setListener(aha.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.aha
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

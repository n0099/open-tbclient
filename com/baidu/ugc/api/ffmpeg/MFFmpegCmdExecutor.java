package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.dna;
import com.baidu.tieba.je0;
import com.baidu.tieba.jja;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MFFmpegCmdExecutor implements dna {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public dna.a mFFmpegCmdListener;

    /* loaded from: classes8.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ dna.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, dna.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            dna.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            dna.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            dna.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (je0.a() == null || TextUtils.isEmpty(je0.b())) {
            Context context = jja.c().getContext() != null ? jja.c().getContext() : null;
            if (!TextUtils.isEmpty(jja.c().b())) {
                str = jja.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    je0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.dna
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.dna
    public void start() {
        if (je0.a() != null && !TextUtils.isEmpty(je0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        dna.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.dna
    public synchronized void setListener(dna.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.dna
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

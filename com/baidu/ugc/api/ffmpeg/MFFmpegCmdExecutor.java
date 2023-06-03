package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.qua;
import com.baidu.tieba.sf0;
import com.baidu.tieba.wqa;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MFFmpegCmdExecutor implements qua {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public qua.a mFFmpegCmdListener;

    /* loaded from: classes8.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ qua.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, qua.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            qua.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            qua.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            qua.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (sf0.a() == null || TextUtils.isEmpty(sf0.b())) {
            Context context = wqa.c().getContext() != null ? wqa.c().getContext() : null;
            if (!TextUtils.isEmpty(wqa.c().b())) {
                str = wqa.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    sf0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.qua
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.qua
    public void start() {
        if (sf0.a() != null && !TextUtils.isEmpty(sf0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        qua.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.qua
    public synchronized void setListener(qua.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.qua
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

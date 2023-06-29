package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.e1b;
import com.baidu.tieba.kxa;
import com.baidu.tieba.wf0;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MFFmpegCmdExecutor implements e1b {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public e1b.a mFFmpegCmdListener;

    /* loaded from: classes8.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ e1b.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, e1b.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            e1b.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            e1b.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            e1b.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (wf0.a() == null || TextUtils.isEmpty(wf0.b())) {
            Context context = kxa.c().getContext() != null ? kxa.c().getContext() : null;
            if (!TextUtils.isEmpty(kxa.c().b())) {
                str = kxa.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    wf0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.e1b
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.e1b
    public void start() {
        if (wf0.a() != null && !TextUtils.isEmpty(wf0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        e1b.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.e1b
    public synchronized void setListener(e1b.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.e1b
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

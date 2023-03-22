package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.j7a;
import com.baidu.tieba.p3a;
import com.baidu.tieba.pd0;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MFFmpegCmdExecutor implements j7a {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public j7a.a mFFmpegCmdListener;

    /* loaded from: classes7.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ j7a.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, j7a.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            j7a.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            j7a.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            j7a.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (pd0.a() == null || TextUtils.isEmpty(pd0.b())) {
            Context context = p3a.c().getContext() != null ? p3a.c().getContext() : null;
            if (!TextUtils.isEmpty(p3a.c().b())) {
                str = p3a.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    pd0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.j7a
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.j7a
    public void start() {
        if (pd0.a() != null && !TextUtils.isEmpty(pd0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        j7a.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.j7a
    public synchronized void setListener(j7a.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.j7a
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

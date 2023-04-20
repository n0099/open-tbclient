package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.iha;
import com.baidu.tieba.oda;
import com.baidu.tieba.rd0;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MFFmpegCmdExecutor implements iha {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public iha.a mFFmpegCmdListener;

    /* loaded from: classes7.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ iha.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, iha.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            iha.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            iha.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            iha.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (rd0.a() == null || TextUtils.isEmpty(rd0.b())) {
            Context context = oda.c().getContext() != null ? oda.c().getContext() : null;
            if (!TextUtils.isEmpty(oda.c().b())) {
                str = oda.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    rd0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.iha
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.iha
    public void start() {
        if (rd0.a() != null && !TextUtils.isEmpty(rd0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        iha.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.iha
    public synchronized void setListener(iha.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.iha
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

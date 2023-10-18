package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.seb;
import com.baidu.tieba.v90;
import com.baidu.tieba.yab;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MFFmpegCmdExecutor implements seb {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public seb.a mFFmpegCmdListener;

    /* loaded from: classes9.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ seb.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, seb.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            seb.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            seb.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            seb.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (v90.a() == null || TextUtils.isEmpty(v90.b())) {
            Context b = yab.d().b() != null ? yab.d().b() : null;
            if (!TextUtils.isEmpty(yab.d().c())) {
                str = yab.d().c();
            } else {
                str = "quanmin_unknow";
            }
            if (b != null) {
                try {
                    v90.d(b, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.seb
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.seb
    public void start() {
        if (v90.a() != null && !TextUtils.isEmpty(v90.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        seb.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.seb
    public synchronized void setListener(seb.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.seb
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

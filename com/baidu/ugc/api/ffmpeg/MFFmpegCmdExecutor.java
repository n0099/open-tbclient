package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.na0;
import com.baidu.tieba.pwb;
import com.baidu.tieba.vsb;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MFFmpegCmdExecutor implements pwb {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public pwb.a mFFmpegCmdListener;

    /* loaded from: classes9.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ pwb.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, pwb.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            pwb.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            pwb.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            pwb.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (na0.a() == null || TextUtils.isEmpty(na0.b())) {
            Context b = vsb.d().b() != null ? vsb.d().b() : null;
            if (!TextUtils.isEmpty(vsb.d().c())) {
                str = vsb.d().c();
            } else {
                str = "quanmin_unknow";
            }
            if (b != null) {
                try {
                    na0.d(b, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.pwb
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.pwb
    public void start() {
        if (na0.a() != null && !TextUtils.isEmpty(na0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        pwb.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.pwb
    public synchronized void setListener(pwb.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.pwb
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

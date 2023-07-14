package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.cab;
import com.baidu.tieba.i6b;
import com.baidu.tieba.xf0;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MFFmpegCmdExecutor implements cab {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public cab.a mFFmpegCmdListener;

    /* loaded from: classes9.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ cab.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, cab.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            cab.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            cab.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            cab.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (xf0.a() == null || TextUtils.isEmpty(xf0.b())) {
            Context context = i6b.c().getContext() != null ? i6b.c().getContext() : null;
            if (!TextUtils.isEmpty(i6b.c().b())) {
                str = i6b.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    xf0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.cab
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.cab
    public void start() {
        if (xf0.a() != null && !TextUtils.isEmpty(xf0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        cab.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.cab
    public synchronized void setListener(cab.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.cab
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

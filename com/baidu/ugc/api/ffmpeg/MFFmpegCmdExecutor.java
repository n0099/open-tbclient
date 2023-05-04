package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.ela;
import com.baidu.tieba.kha;
import com.baidu.tieba.td0;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MFFmpegCmdExecutor implements ela {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public ela.a mFFmpegCmdListener;

    /* loaded from: classes7.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ ela.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, ela.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            ela.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            ela.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            ela.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (td0.a() == null || TextUtils.isEmpty(td0.b())) {
            Context context = kha.c().getContext() != null ? kha.c().getContext() : null;
            if (!TextUtils.isEmpty(kha.c().b())) {
                str = kha.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    td0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.ela
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.ela
    public void start() {
        if (td0.a() != null && !TextUtils.isEmpty(td0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        ela.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.ela
    public synchronized void setListener(ela.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.ela
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

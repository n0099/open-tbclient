package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.tieba.owa;
import com.baidu.tieba.tf0;
import com.baidu.tieba.usa;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MFFmpegCmdExecutor implements owa {
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public owa.a mFFmpegCmdListener;

    /* loaded from: classes8.dex */
    public class a implements FFmpegCmdExecutor.b {
        public final /* synthetic */ owa.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, owa.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            owa.a aVar = this.a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            owa.a aVar = this.a;
            if (aVar != null) {
                return aVar.onError(i, i2, obj);
            }
            return false;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            owa.a aVar = this.a;
            if (aVar != null) {
                return aVar.onInfo(i, i2, obj);
            }
            return false;
        }
    }

    public MFFmpegCmdExecutor() {
        String str;
        if (tf0.a() == null || TextUtils.isEmpty(tf0.b())) {
            Context context = usa.c().getContext() != null ? usa.c().getContext() : null;
            if (!TextUtils.isEmpty(usa.c().b())) {
                str = usa.c().b();
            } else {
                str = "quanmin_unknow";
            }
            if (context != null) {
                try {
                    tf0.d(context, str);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.baidu.tieba.owa
    public void release() {
        this.mFFmpegCmdExecutor.g();
    }

    @Override // com.baidu.tieba.owa
    public void start() {
        if (tf0.a() != null && !TextUtils.isEmpty(tf0.b())) {
            this.mFFmpegCmdExecutor.j();
            return;
        }
        owa.a aVar = this.mFFmpegCmdListener;
        if (aVar != null) {
            aVar.onError(-9527, -9527, "TranscoderManager install error");
        }
    }

    @Override // com.baidu.tieba.owa
    public synchronized void setListener(owa.a aVar) {
        this.mFFmpegCmdListener = aVar;
        this.mFFmpegCmdExecutor.h(new a(this, aVar));
    }

    @Override // com.baidu.tieba.owa
    public void setSource(ArrayList<String> arrayList) {
        this.mFFmpegCmdExecutor.i(arrayList);
    }
}

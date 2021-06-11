package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes6.dex */
public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    public static final Handler HANDLER = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bumptech.glide.request.target.PreloadTarget.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((PreloadTarget) message.obj).clear();
                return true;
            }
            return false;
        }
    });
    public static final int MESSAGE_CLEAR = 1;
    public final RequestManager requestManager;

    public PreloadTarget(RequestManager requestManager, int i2, int i3) {
        super(i2, i3);
        this.requestManager = requestManager;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int i2, int i3) {
        return new PreloadTarget<>(requestManager, i2, i3);
    }

    public void clear() {
        this.requestManager.clear(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }
}

package com.baidu.tieba.newfaceshop;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public abstract class FaceBaseModel extends BdBaseModel {

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Message f19183e;

        public a(Message message) {
            this.f19183e = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            FaceBaseModel.this.sendMessage(this.f19183e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void sendMessage(Message message) {
        if (l.B()) {
            super.sendMessage(message);
        } else {
            new Handler(Looper.getMainLooper()).post(new a(message));
        }
    }
}

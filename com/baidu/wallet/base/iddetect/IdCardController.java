package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.fastjson.asm.Label;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class IdCardController {

    /* renamed from: a  reason: collision with root package name */
    public IIdCardRecognizeListener f23279a;

    /* loaded from: classes5.dex */
    public interface IIdCardRecognizeListener extends NoProguard {
        void onFail(int i2, Bundle bundle);

        void onSuccess(Bundle bundle);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static IdCardController f23280a = new IdCardController();
    }

    public static IdCardController getInstance() {
        return a.f23280a;
    }

    public void fail(int i2, Bundle bundle) {
        IIdCardRecognizeListener iIdCardRecognizeListener = this.f23279a;
        if (iIdCardRecognizeListener != null) {
            iIdCardRecognizeListener.onFail(i2, bundle);
        }
        this.f23279a = null;
    }

    public void startIdcarddetect(Context context, IIdCardRecognizeListener iIdCardRecognizeListener) {
        this.f23279a = iIdCardRecognizeListener;
        Intent intent = new Intent(context, IdCardActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public void success(Bundle bundle) {
        IIdCardRecognizeListener iIdCardRecognizeListener = this.f23279a;
        if (iIdCardRecognizeListener != null) {
            iIdCardRecognizeListener.onSuccess(bundle);
        }
        this.f23279a = null;
    }

    public IdCardController() {
    }
}

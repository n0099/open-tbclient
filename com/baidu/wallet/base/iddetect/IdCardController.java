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
    public IIdCardRecognizeListener f23316a;

    /* loaded from: classes5.dex */
    public interface IIdCardRecognizeListener extends NoProguard {
        void onFail(int i, Bundle bundle);

        void onSuccess(Bundle bundle);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static IdCardController f23317a = new IdCardController();
    }

    public static IdCardController getInstance() {
        return a.f23317a;
    }

    public void fail(int i, Bundle bundle) {
        IIdCardRecognizeListener iIdCardRecognizeListener = this.f23316a;
        if (iIdCardRecognizeListener != null) {
            iIdCardRecognizeListener.onFail(i, bundle);
        }
        this.f23316a = null;
    }

    public void startIdcarddetect(Context context, IIdCardRecognizeListener iIdCardRecognizeListener) {
        this.f23316a = iIdCardRecognizeListener;
        Intent intent = new Intent(context, IdCardActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public void success(Bundle bundle) {
        IIdCardRecognizeListener iIdCardRecognizeListener = this.f23316a;
        if (iIdCardRecognizeListener != null) {
            iIdCardRecognizeListener.onSuccess(bundle);
        }
        this.f23316a = null;
    }

    public IdCardController() {
    }
}

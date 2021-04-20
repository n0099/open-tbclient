package com.baidu.wallet.base.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.fastjson.asm.Label;
import com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity;
import com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class IdCardDetectionController {
    public IIdCardDetectionListener mIdCardResultListener;

    /* loaded from: classes5.dex */
    public interface IIdCardDetectionListener extends NoProguard {
        void onDetectFailed(int i, String str);

        void onDetectOK(Bundle bundle);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final IdCardDetectionController f23272a = new IdCardDetectionController();
    }

    public static final IdCardDetectionController getInstance() {
        return a.f23272a;
    }

    public void IdCardDeteFailed(int i, String str) {
        IIdCardDetectionListener iIdCardDetectionListener = this.mIdCardResultListener;
        if (iIdCardDetectionListener != null) {
            iIdCardDetectionListener.onDetectFailed(i, str);
        }
        this.mIdCardResultListener = null;
    }

    public void IdCardDeteSuccess(Bundle bundle) {
        IIdCardDetectionListener iIdCardDetectionListener = this.mIdCardResultListener;
        if (iIdCardDetectionListener != null) {
            iIdCardDetectionListener.onDetectOK(bundle);
        }
        this.mIdCardResultListener = null;
    }

    public void clearIdCardResultCallback() {
        this.mIdCardResultListener = null;
    }

    public IIdCardDetectionListener getIdCardDetectionListener() {
        return this.mIdCardResultListener;
    }

    public void startIdcarddetect(Context context, int i, IIdCardDetectionListener iIdCardDetectionListener, boolean z) {
        this.mIdCardResultListener = iIdCardDetectionListener;
        if (i != 5 && i != 6) {
            Intent intent = new Intent(context, IdentityCardDetectionActivity.class);
            intent.putExtra("step", i);
            intent.putExtra("show_album", z);
            if (!(context instanceof Activity)) {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, IdCardDetectionH5Activity.class);
        intent2.putExtra("step", i);
        if (!(context instanceof Activity)) {
            intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent2);
    }

    public IdCardDetectionController() {
    }
}

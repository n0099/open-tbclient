package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.core.NoProguard;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes10.dex */
public class BankcardDetectionController extends Observable implements NoProguard, Observer {

    /* renamed from: a  reason: collision with root package name */
    private IDetectionListener f3918a;

    /* loaded from: classes10.dex */
    public interface IDetectionListener extends NoProguard {
        void onFail(int i, String str);

        void onResult(String str);
    }

    private BankcardDetectionController() {
    }

    /* loaded from: classes10.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static BankcardDetectionController f3919a = new BankcardDetectionController();
    }

    public static BankcardDetectionController getInstance() {
        return a.f3919a;
    }

    public void gotoDetctionCard(Context context, IDetectionListener iDetectionListener) {
        PayStatisticsUtil.onEvent("takephotoPhotoread");
        if (iDetectionListener != null) {
            this.f3918a = iDetectionListener;
            Intent intent = new Intent(context, BankCardDetectionActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.f3918a != null) {
            this.f3918a.onResult(obj == null ? "" : (String) obj);
            this.f3918a = null;
        }
        this.f3918a = null;
    }

    public void updateFail(int i, String str) {
        if (this.f3918a != null) {
            this.f3918a.onFail(i, str);
            this.f3918a = null;
        }
        this.f3918a = null;
    }

    public void clearCardDetectionCallback() {
        this.f3918a = null;
    }
}

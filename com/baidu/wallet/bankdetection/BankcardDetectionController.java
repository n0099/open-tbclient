package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.core.NoProguard;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes4.dex */
public class BankcardDetectionController extends Observable implements NoProguard, Observer {

    /* renamed from: a  reason: collision with root package name */
    private IDetectionListener f5933a;

    /* loaded from: classes4.dex */
    public interface IDetectionListener extends NoProguard {
        void onFail(int i, String str);

        void onResult(String str);
    }

    private BankcardDetectionController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static BankcardDetectionController f5934a = new BankcardDetectionController();
    }

    public static BankcardDetectionController getInstance() {
        return a.f5934a;
    }

    public void gotoDetctionCard(Context context, IDetectionListener iDetectionListener) {
        PayStatisticsUtil.onEvent("takephotoPhotoread");
        if (iDetectionListener != null) {
            this.f5933a = iDetectionListener;
            Intent intent = new Intent(context, BankCardDetectionActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.f5933a != null) {
            this.f5933a.onResult(obj == null ? "" : (String) obj);
            this.f5933a = null;
        }
        this.f5933a = null;
    }

    public void updateFail(int i, String str) {
        if (this.f5933a != null) {
            this.f5933a.onFail(i, str);
            this.f5933a = null;
        }
        this.f5933a = null;
    }

    public void clearCardDetectionCallback() {
        this.f5933a = null;
    }
}

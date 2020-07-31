package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.core.NoProguard;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes9.dex */
public class BankcardDetectionController extends Observable implements NoProguard, Observer {
    private IDetectionListener a;

    /* loaded from: classes9.dex */
    public interface IDetectionListener extends NoProguard {
        void onFail(int i, String str);

        void onResult(String str);
    }

    private BankcardDetectionController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static BankcardDetectionController a = new BankcardDetectionController();
    }

    public static BankcardDetectionController getInstance() {
        return a.a;
    }

    public void gotoDetctionCard(Context context, IDetectionListener iDetectionListener) {
        PayStatisticsUtil.onEvent("takephotoPhotoread");
        if (iDetectionListener != null) {
            this.a = iDetectionListener;
            Intent intent = new Intent(context, BankCardDetectionActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.a != null) {
            this.a.onResult(obj == null ? "" : (String) obj);
            this.a = null;
        }
        this.a = null;
    }

    public void updateFail(int i, String str) {
        if (this.a != null) {
            this.a.onFail(i, str);
            this.a = null;
        }
        this.a = null;
    }

    public void clearCardDetectionCallback() {
        this.a = null;
    }
}

package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes5.dex */
public class BankcardDetectionController extends Observable implements NoProguard, Observer {

    /* renamed from: a  reason: collision with root package name */
    public IDetectionListener f23512a;

    /* loaded from: classes5.dex */
    public interface IDetectionListener extends NoProguard {
        void onFail(int i, String str);

        void onResult(String str);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BankcardDetectionController f23513a = new BankcardDetectionController();
    }

    public static BankcardDetectionController getInstance() {
        return a.f23513a;
    }

    public void clearCardDetectionCallback() {
        this.f23512a = null;
    }

    public void gotoDetctionCard(Context context, IDetectionListener iDetectionListener) {
        PayStatisticsUtil.onEvent(StatServiceEvent.STAT_PHOTOREAD);
        if (iDetectionListener == null) {
            return;
        }
        this.f23512a = iDetectionListener;
        Intent intent = new Intent(context, BankCardDetectionActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.f23512a != null) {
            this.f23512a.onResult(obj == null ? "" : (String) obj);
            this.f23512a = null;
        }
        this.f23512a = null;
    }

    public void updateFail(int i, String str) {
        IDetectionListener iDetectionListener = this.f23512a;
        if (iDetectionListener != null) {
            iDetectionListener.onFail(i, str);
            this.f23512a = null;
        }
        this.f23512a = null;
    }

    public BankcardDetectionController() {
    }
}

package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes5.dex */
public class BankcardDetectionController extends Observable implements NoProguard, Observer {

    /* renamed from: a  reason: collision with root package name */
    public IDetectionListener f23920a;

    /* loaded from: classes5.dex */
    public interface IDetectionListener extends NoProguard {
        void onFail(int i2, String str);

        void onResult(String str);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BankcardDetectionController f23921a = new BankcardDetectionController();
    }

    public static BankcardDetectionController getInstance() {
        return a.f23921a;
    }

    public void clearCardDetectionCallback() {
        this.f23920a = null;
    }

    public void gotoDetctionCard(Context context, IDetectionListener iDetectionListener) {
        PayStatisticsUtil.onEvent(StatServiceEvent.STAT_PHOTOREAD);
        if (iDetectionListener == null) {
            return;
        }
        this.f23920a = iDetectionListener;
        Intent intent = new Intent(context, BankCardDetectionActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.f23920a != null) {
            this.f23920a.onResult(obj == null ? "" : (String) obj);
            this.f23920a = null;
        }
        this.f23920a = null;
    }

    public void updateFail(int i2, String str) {
        IDetectionListener iDetectionListener = this.f23920a;
        if (iDetectionListener != null) {
            iDetectionListener.onFail(i2, str);
            this.f23920a = null;
        }
        this.f23920a = null;
    }

    public BankcardDetectionController() {
    }
}

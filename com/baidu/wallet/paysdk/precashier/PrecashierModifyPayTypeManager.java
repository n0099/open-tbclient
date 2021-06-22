package com.baidu.wallet.paysdk.precashier;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.widget.LoadingDialog;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierModifyPayTypeBean;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes5.dex */
public class PrecashierModifyPayTypeManager implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public LoadingDialog f25534a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f25535b;

    /* renamed from: c  reason: collision with root package name */
    public PrecashierModifyPayTypeBean f25536c;

    /* renamed from: d  reason: collision with root package name */
    public TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> f25537d;

    /* renamed from: e  reason: collision with root package name */
    public String f25538e;

    /* loaded from: classes5.dex */
    public static class TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> implements Serializable {
        public final PrecashierModifyPayTypeDefaultData datas;
        public final Boolean isFromChange;

        public TwoTupleForPrecashier(Boolean r1, PrecashierModifyPayTypeDefaultData precashiermodifypaytypedefaultdata) {
            this.isFromChange = r1;
            this.datas = precashiermodifypaytypedefaultdata;
        }

        public Boolean isFromChange() {
            return this.isFromChange;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PrecashierModifyPayTypeManager f25544a = new PrecashierModifyPayTypeManager();
    }

    public static PrecashierModifyPayTypeManager getInstance() {
        return a.f25544a;
    }

    public void dismissLoadingDialog() {
        LoadingDialog loadingDialog = this.f25534a;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            this.f25534a = null;
        }
    }

    public TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> generateTwoTupleForPrecashier(boolean z, PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
        return new TwoTupleForPrecashier<>(Boolean.valueOf(z), precashierModifyPayTypeDefaultData);
    }

    public void getModifyPayType(Activity activity, Map<String, String> map) {
        setTwoTupleForPrecashier(new TwoTupleForPrecashier<>(Boolean.TRUE, a(map)));
        this.f25535b = new WeakReference<>(activity);
        showLoadingDialog();
        if (this.f25536c == null) {
            this.f25536c = new PrecashierModifyPayTypeBean(activity);
        }
        PrecashierModifyPayTypeBean precashierModifyPayTypeBean = this.f25536c;
        precashierModifyPayTypeBean.rec_params = map;
        precashierModifyPayTypeBean.setResponseCallback(this);
        this.f25536c.execBean();
    }

    public String getSpNo() {
        return this.f25538e;
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, final String str) {
        this.f25536c = null;
        dismissLoadingDialog();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (PrecashierModifyPayTypeManager.this.f25535b != null && PrecashierModifyPayTypeManager.this.f25535b.get() != null) {
                    GlobalUtils.toast((Context) PrecashierModifyPayTypeManager.this.f25535b.get(), str);
                }
                PayController.getInstance().clearPreModifiedCallBack();
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i2, final Object obj, String str) {
        dismissLoadingDialog();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2 = obj;
                if (obj2 != null) {
                    if (i2 != 2) {
                        PrecashierModifyPayTypeManager.this.f25536c = null;
                        return;
                    }
                    PrecashierModifyPayTypeResponse precashierModifyPayTypeResponse = (PrecashierModifyPayTypeResponse) obj2;
                    if (PrecashierModifyPayTypeManager.this.f25536c != null) {
                        precashierModifyPayTypeResponse.setOriginHttpResponse(PrecashierModifyPayTypeManager.this.f25536c.getHttpRealContent());
                    }
                    if (precashierModifyPayTypeResponse.checkResponseValidity()) {
                        if (PrecashierModifyPayTypeManager.this.f25535b != null && PrecashierModifyPayTypeManager.this.f25535b.get() != null) {
                            PayController.getInstance().modifyPayType((Context) PrecashierModifyPayTypeManager.this.f25535b.get(), PrecashierModifyPayTypeManager.this.f25537d);
                            return;
                        } else {
                            PrecashierModifyPayTypeManager.this.f25536c = null;
                            return;
                        }
                    }
                    PrecashierModifyPayTypeManager.this.f25536c = null;
                    return;
                }
                PrecashierModifyPayTypeManager.this.f25536c = null;
            }
        });
    }

    public void setSpNo(String str) {
        this.f25538e = str;
    }

    public void setTwoTupleForPrecashier(TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier) {
        this.f25537d = twoTupleForPrecashier;
    }

    public void showLoadingDialog() {
        WeakReference<Activity> weakReference;
        if (this.f25534a == null && (weakReference = this.f25535b) != null && weakReference.get() != null) {
            this.f25534a = new LoadingDialog(this.f25535b.get());
        }
        LoadingDialog loadingDialog = this.f25534a;
        if (loadingDialog != null) {
            loadingDialog.show();
        } else {
            LogUtil.d("mContext or mContext.get() may be null!");
        }
    }

    public PrecashierModifyPayTypeManager() {
    }

    private PrecashierModifyPayTypeDefaultData a(Map map) {
        PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
        if (map != null && !map.isEmpty()) {
            Object obj = map.get("pay_type");
            String str = (obj == null || !(obj instanceof String)) ? null : (String) obj;
            if (TextUtils.isEmpty(str)) {
                return precashierModifyPayTypeDefaultData;
            }
            if ("balance".equals(str)) {
                precashierModifyPayTypeDefaultData.setDatas(str, "", null);
            } else if ("easypay".equals(str)) {
                Object obj2 = map.get("account_no");
                String str2 = (obj2 == null || !(obj2 instanceof String)) ? null : (String) obj2;
                PrecashierModifyPayTypeDefaultData.Card card = new PrecashierModifyPayTypeDefaultData.Card();
                card.account_no = str2;
                precashierModifyPayTypeDefaultData.setDatas(str, null, card);
            }
            map.remove("pay_type");
            map.remove("account_no");
        }
        return precashierModifyPayTypeDefaultData;
    }
}

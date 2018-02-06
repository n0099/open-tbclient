package com.baidu.tieba.qrlogin;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.QrPcLoginCallback;
import com.baidu.sapi2.result.QrPcLoginResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private final BaseActivity bSO;
    private Map<String, String> gAA;
    private QrPcLoginCallback gAB;
    private QrLoginAction gAC;
    private final b gAz;

    public a(BaseActivity baseActivity, b bVar) {
        this.bSO = baseActivity;
        this.gAz = bVar;
    }

    public void start(String str) {
        this.gAA = SapiUtils.parseQrLoginSchema(str);
        if (j.ox()) {
            a(this.gAA, QrLoginAction.NOTICE);
        } else {
            this.gAz.bnC();
        }
    }

    public void bnE() {
        if (!j.ox()) {
            this.bSO.showToast(d.j.network_not_available);
        } else {
            a(this.gAA, QrLoginAction.LOGIN);
        }
    }

    public void bnF() {
        a(this.gAA, QrLoginAction.CANCEL);
    }

    private void a(Map<String, String> map, final QrLoginAction qrLoginAction) {
        if (!TbadkCoreApplication.isLogin()) {
            onError("loginError");
            return;
        }
        this.gAB = new QrPcLoginCallback() { // from class: com.baidu.tieba.qrlogin.a.1
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                a.this.gAz.bnj();
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                a.this.gAz.bnk();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            /* renamed from: a */
            public void onBdussExpired(QrPcLoginResult qrPcLoginResult) {
                a.this.onError(String.format("%s(%d)", qrPcLoginResult.getResultMsg(), Integer.valueOf(qrPcLoginResult.getResultCode())));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.IncompleteUserAware
            /* renamed from: b */
            public void onIncompleteUser(QrPcLoginResult qrPcLoginResult) {
                a.this.onError(String.format("%s(%d)", qrPcLoginResult.getResultMsg(), Integer.valueOf(qrPcLoginResult.getResultCode())));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: c */
            public void onFailure(QrPcLoginResult qrPcLoginResult) {
                a.this.onError(String.format("%s(%d)", qrPcLoginResult.getResultMsg(), Integer.valueOf(qrPcLoginResult.getResultCode())));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: d */
            public void onSuccess(QrPcLoginResult qrPcLoginResult) {
                a.this.gAz.bnk();
                switch (AnonymousClass2.gAF[qrLoginAction.ordinal()]) {
                    case 1:
                        a.this.gAz.bnC();
                        return;
                    case 2:
                        a.this.bSO.finish();
                        return;
                    case 3:
                        a.this.bSO.finish();
                        return;
                    default:
                        return;
                }
            }
        };
        SapiAccountManager.getInstance().getAccountService().qrPcLogin(this.gAB, map.get("sign"), qrLoginAction.getName(), TbadkCoreApplication.getCurrentBduss());
        this.gAC = qrLoginAction;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.qrlogin.a$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] gAF = new int[QrLoginAction.values().length];

        static {
            try {
                gAF[QrLoginAction.NOTICE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gAF[QrLoginAction.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gAF[QrLoginAction.LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onDestory() {
        if (this.gAC != null && this.gAC == QrLoginAction.NOTICE) {
            bnF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(String str) {
        if (!StringUtils.isNull(str)) {
            UtilHelper.showToast(this.bSO, str);
        }
        this.bSO.finish();
    }
}

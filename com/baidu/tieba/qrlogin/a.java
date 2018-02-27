package com.baidu.tieba.qrlogin;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private final BaseActivity bSC;
    private final b gAo;
    private Map<String, String> gAp;
    private QrLoginAction gAq;

    public a(BaseActivity baseActivity, b bVar) {
        this.bSC = baseActivity;
        this.gAo = bVar;
    }

    public void start(String str) {
        this.gAp = SapiUtils.parseQrLoginSchema(str);
        if (j.ox()) {
            a(this.gAp, QrLoginAction.NOTICE);
        } else {
            this.gAo.bnB();
        }
    }

    public void bnD() {
        if (!j.ox()) {
            this.bSC.showToast(d.j.network_not_available);
        } else {
            a(this.gAp, QrLoginAction.LOGIN);
        }
    }

    public void bnE() {
        a(this.gAp, QrLoginAction.CANCEL);
    }

    private void a(Map<String, String> map, QrLoginAction qrLoginAction) {
        if (!TbadkCoreApplication.isLogin()) {
            onError("loginError");
        } else {
            this.gAq = qrLoginAction;
        }
    }

    public void onDestory() {
        if (this.gAq != null && this.gAq == QrLoginAction.NOTICE) {
            bnE();
        }
    }

    private void onError(String str) {
        if (!StringUtils.isNull(str)) {
            UtilHelper.showToast(this.bSC, str);
        }
        this.bSC.finish();
    }
}

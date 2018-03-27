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
    private final BaseActivity bSF;
    private final b gAE;
    private Map<String, String> gAF;
    private QrLoginAction gAG;

    public a(BaseActivity baseActivity, b bVar) {
        this.bSF = baseActivity;
        this.gAE = bVar;
    }

    public void start(String str) {
        this.gAF = SapiUtils.parseQrLoginSchema(str);
        if (j.ox()) {
            a(this.gAF, QrLoginAction.NOTICE);
        } else {
            this.gAE.bnC();
        }
    }

    public void bnE() {
        if (!j.ox()) {
            this.bSF.showToast(d.j.network_not_available);
        } else {
            a(this.gAF, QrLoginAction.LOGIN);
        }
    }

    public void bnF() {
        a(this.gAF, QrLoginAction.CANCEL);
    }

    private void a(Map<String, String> map, QrLoginAction qrLoginAction) {
        if (!TbadkCoreApplication.isLogin()) {
            onError("loginError");
        } else {
            this.gAG = qrLoginAction;
        }
    }

    public void onDestory() {
        if (this.gAG != null && this.gAG == QrLoginAction.NOTICE) {
            bnF();
        }
    }

    private void onError(String str) {
        if (!StringUtils.isNull(str)) {
            UtilHelper.showToast(this.bSF, str);
        }
        this.bSF.finish();
    }
}

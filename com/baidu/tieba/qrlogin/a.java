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
    private final BaseActivity bkU;
    private final b ghJ;
    private Map<String, String> ghK;
    private QrLoginAction ghL;

    public a(BaseActivity baseActivity, b bVar) {
        this.bkU = baseActivity;
        this.ghJ = bVar;
    }

    public void start(String str) {
        this.ghK = SapiUtils.parseQrLoginSchema(str);
        if (j.jr()) {
            a(this.ghK, QrLoginAction.NOTICE);
        } else {
            this.ghJ.bnG();
        }
    }

    public void bnI() {
        if (!j.jr()) {
            this.bkU.showToast(d.k.network_not_available);
        } else {
            a(this.ghK, QrLoginAction.LOGIN);
        }
    }

    public void bnJ() {
        a(this.ghK, QrLoginAction.CANCEL);
    }

    private void a(Map<String, String> map, QrLoginAction qrLoginAction) {
        if (!TbadkCoreApplication.isLogin()) {
            onError("loginError");
        } else {
            this.ghL = qrLoginAction;
        }
    }

    public void onDestory() {
        if (this.ghL != null && this.ghL == QrLoginAction.NOTICE) {
            bnJ();
        }
    }

    private void onError(String str) {
        if (!StringUtils.isNull(str)) {
            UtilHelper.showToast(this.bkU, str);
        }
        this.bkU.finish();
    }
}

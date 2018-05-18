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
    private final BaseActivity bcK;
    private final b fWu;
    private Map<String, String> fWv;
    private QrLoginAction fWw;

    public a(BaseActivity baseActivity, b bVar) {
        this.bcK = baseActivity;
        this.fWu = bVar;
    }

    public void start(String str) {
        this.fWv = SapiUtils.parseQrLoginSchema(str);
        if (j.gD()) {
            a(this.fWv, QrLoginAction.NOTICE);
        } else {
            this.fWu.biI();
        }
    }

    public void biK() {
        if (!j.gD()) {
            this.bcK.showToast(d.k.network_not_available);
        } else {
            a(this.fWv, QrLoginAction.LOGIN);
        }
    }

    public void biL() {
        a(this.fWv, QrLoginAction.CANCEL);
    }

    private void a(Map<String, String> map, QrLoginAction qrLoginAction) {
        if (!TbadkCoreApplication.isLogin()) {
            onError("loginError");
        } else {
            this.fWw = qrLoginAction;
        }
    }

    public void onDestory() {
        if (this.fWw != null && this.fWw == QrLoginAction.NOTICE) {
            biL();
        }
    }

    private void onError(String str) {
        if (!StringUtils.isNull(str)) {
            UtilHelper.showToast(this.bcK, str);
        }
        this.bcK.finish();
    }
}

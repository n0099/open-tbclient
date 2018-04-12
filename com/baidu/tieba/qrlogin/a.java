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
    private final BaseActivity bcJ;
    private final b fVr;
    private Map<String, String> fVs;
    private QrLoginAction fVt;

    public a(BaseActivity baseActivity, b bVar) {
        this.bcJ = baseActivity;
        this.fVr = bVar;
    }

    public void start(String str) {
        this.fVs = SapiUtils.parseQrLoginSchema(str);
        if (j.gD()) {
            a(this.fVs, QrLoginAction.NOTICE);
        } else {
            this.fVr.biI();
        }
    }

    public void biK() {
        if (!j.gD()) {
            this.bcJ.showToast(d.k.network_not_available);
        } else {
            a(this.fVs, QrLoginAction.LOGIN);
        }
    }

    public void biL() {
        a(this.fVs, QrLoginAction.CANCEL);
    }

    private void a(Map<String, String> map, QrLoginAction qrLoginAction) {
        if (!TbadkCoreApplication.isLogin()) {
            onError("loginError");
        } else {
            this.fVt = qrLoginAction;
        }
    }

    public void onDestory() {
        if (this.fVt != null && this.fVt == QrLoginAction.NOTICE) {
            biL();
        }
    }

    private void onError(String str) {
        if (!StringUtils.isNull(str)) {
            UtilHelper.showToast(this.bcJ, str);
        }
        this.bcJ.finish();
    }
}

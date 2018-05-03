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
    private final b fVo;
    private Map<String, String> fVp;
    private QrLoginAction fVq;

    public a(BaseActivity baseActivity, b bVar) {
        this.bcJ = baseActivity;
        this.fVo = bVar;
    }

    public void start(String str) {
        this.fVp = SapiUtils.parseQrLoginSchema(str);
        if (j.gD()) {
            a(this.fVp, QrLoginAction.NOTICE);
        } else {
            this.fVo.biI();
        }
    }

    public void biK() {
        if (!j.gD()) {
            this.bcJ.showToast(d.k.network_not_available);
        } else {
            a(this.fVp, QrLoginAction.LOGIN);
        }
    }

    public void biL() {
        a(this.fVp, QrLoginAction.CANCEL);
    }

    private void a(Map<String, String> map, QrLoginAction qrLoginAction) {
        if (!TbadkCoreApplication.isLogin()) {
            onError("loginError");
        } else {
            this.fVq = qrLoginAction;
        }
    }

    public void onDestory() {
        if (this.fVq != null && this.fVq == QrLoginAction.NOTICE) {
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

package com.baidu.tieba.passaccount.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
/* loaded from: classes7.dex */
public class b implements View.OnClickListener, a {
    private ImageView lIA;
    private TextView lIB;
    private TextView lIC;
    private TextView lID;
    private TextView lIE;
    private TextView lIF;
    private TextView lIG;
    private TextView lIH;
    private TextView lII;
    private TextView lIJ;
    private TextView lIK;
    private TextView lIL;
    private LoginDialogActivity lIw;
    private View lIx;
    private View lIy;
    private View lIz;
    private String operator;
    private int operatorType;
    private String phoneNum;
    private String sign;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r7.equals("CU") != false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(String str, String str2, String str3) {
        boolean z = false;
        this.operatorType = 0;
        this.phoneNum = str;
        this.operator = str2;
        this.sign = str3;
        switch (str2.hashCode()) {
            case 2154:
                if (str2.equals("CM")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2161:
                if (str2.equals("CT")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2162:
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                this.operatorType = 1;
                return;
            case true:
                this.operatorType = 2;
                return;
            default:
                this.operatorType = 3;
                return;
        }
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.lIw = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.onekey_login_dialog_activity_layout, viewGroup, true);
        this.lIx = inflate.findViewById(R.id.dialog_background);
        this.lIy = inflate.findViewById(R.id.dialog_layout);
        this.lIz = inflate.findViewById(R.id.close_btn_layout);
        this.lIA = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.lIB = (TextView) inflate.findViewById(R.id.dialog_title);
        this.lIC = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.lID = (TextView) inflate.findViewById(R.id.user_number);
        this.lIE = (TextView) inflate.findViewById(R.id.login_btn);
        this.lIF = (TextView) inflate.findViewById(R.id.other_login_btn);
        this.lIG = (TextView) inflate.findViewById(R.id.tip_1);
        this.lIH = (TextView) inflate.findViewById(R.id.operator_text);
        this.lII = (TextView) inflate.findViewById(R.id.tip_2);
        this.lIJ = (TextView) inflate.findViewById(R.id.agreement_text);
        this.lIK = (TextView) inflate.findViewById(R.id.tip_3);
        this.lIL = (TextView) inflate.findViewById(R.id.privacy_text);
        this.lIx.setOnClickListener(this);
        this.lIz.setOnClickListener(this);
        this.lIA.setOnClickListener(this);
        this.lIy.setOnClickListener(this);
        this.lIE.setOnClickListener(this);
        this.lIF.setOnClickListener(this);
        this.lIH.setOnClickListener(this);
        this.lIJ.setOnClickListener(this);
        this.lIL.setOnClickListener(this);
        initData();
    }

    private void initData() {
        this.lID.setText(this.phoneNum);
        Fq(this.operatorType);
    }

    private void Fq(int i) {
        switch (i) {
            case 1:
                this.lIH.setText(R.string.onekey_login_dialog_activity_operator_1);
                return;
            case 2:
                this.lIH.setText(R.string.onekey_login_dialog_activity_operator_2);
                return;
            case 3:
                this.lIH.setText(R.string.onekey_login_dialog_activity_operator_3);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void rz(int i) {
        ap.setBackgroundResource(this.lIy, R.drawable.nav_bg_corner_shape, i);
        SvgManager.bsU().a(this.lIA, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIB).nZ(R.color.CAM_X0105).oa(R.dimen.T_X05).ob(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIC).nZ(R.color.CAM_X0108).oa(R.dimen.T_X08).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lID).nZ(R.color.CAM_X0105).oa(R.dimen.T_X03).ob(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIF).nZ(R.color.CAM_X0107).oa(R.dimen.T_X07).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIE).nZ(R.color.CAM_X0101).oa(R.dimen.T_X05).ob(R.string.F_X01).oh(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIG).nZ(R.color.CAM_X0108).oa(R.dimen.tbds29).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lII).nZ(R.color.CAM_X0108).oa(R.dimen.tbds29).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIK).nZ(R.color.CAM_X0108).oa(R.dimen.tbds29).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIH).nZ(R.color.CAM_X0302).oa(R.dimen.tbds29).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIJ).nZ(R.color.CAM_X0302).oa(R.dimen.tbds29).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIL).nZ(R.color.CAM_X0302).oa(R.dimen.tbds29).ob(R.string.F_X01);
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public Intent bEN() {
        return null;
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dialog_background || id == R.id.close_btn_layout || id == R.id.close_btn_view) {
            dkd();
        } else if (id == R.id.login_btn) {
            login();
        } else if (id == R.id.operator_text) {
            dka();
        } else if (id == R.id.agreement_text) {
            dkb();
        } else if (id == R.id.privacy_text) {
            dkc();
        } else if (id == R.id.other_login_btn) {
            djZ();
        }
    }

    private String Pe(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        return str.substring(0, 8) + MD5Util.toMd5((str.substring(8, str.length()) + MD5Util.toMd5(SapiUtils.getClientId(this.lIw).toUpperCase().getBytes(), false)).getBytes(), false);
    }

    private void login() {
        this.lIw.showLoading();
        PassportSDK.getInstance().loadOneKeyLogin(this.lIw, Pe(this.sign), new OneKeyLoginCallback() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                b.this.lIw.djV();
                b.this.lIw.Pd("yijiandenglu");
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                b.this.lIw.closeLoadingDialog();
                b.this.lIw.showToast(String.format(b.this.lIw.getString(R.string.onekey_login_fail), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            }
        });
    }

    private void djZ() {
        this.lIw.finish();
        new LoginActivityConfig((Context) this.lIw, true).start();
    }

    private void dka() {
        switch (this.operatorType) {
            case 1:
                new TbWebViewActivityConfig(this.lIw, this.lIw.getResources().getString(R.string.onekey_login_dialog_activity_operator_1), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
                return;
            case 2:
                new TbWebViewActivityConfig(this.lIw, this.lIw.getResources().getString(R.string.onekey_login_dialog_activity_operator_2), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
                return;
            case 3:
                new TbWebViewActivityConfig(this.lIw, this.lIw.getResources().getString(R.string.onekey_login_dialog_activity_operator_3), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
                return;
            default:
                return;
        }
    }

    private void dkb() {
        new TbWebViewActivityConfig(this.lIw, this.lIw.getResources().getString(R.string.onekey_login_dialog_activity_agreement_text), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
    }

    private void dkc() {
        new TbWebViewActivityConfig(this.lIw, this.lIw.getResources().getString(R.string.onekey_login_dialog_activity_privacy_text), "http://privacy.baidu.com/mdetail?id=288", false).start();
    }

    private void dkd() {
        this.lIw.finish();
    }
}

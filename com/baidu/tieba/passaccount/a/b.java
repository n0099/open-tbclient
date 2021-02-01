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
/* loaded from: classes8.dex */
public class b implements View.OnClickListener, a {
    private LoginDialogActivity lGg;
    private View lGh;
    private View lGi;
    private View lGj;
    private ImageView lGk;
    private TextView lGl;
    private TextView lGm;
    private TextView lGn;
    private TextView lGo;
    private TextView lGp;
    private TextView lGq;
    private TextView lGr;
    private TextView lGs;
    private TextView lGt;
    private TextView lGu;
    private TextView lGv;
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
        this.lGg = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.onekey_login_dialog_activity_layout, viewGroup, true);
        this.lGh = inflate.findViewById(R.id.dialog_background);
        this.lGi = inflate.findViewById(R.id.dialog_layout);
        this.lGj = inflate.findViewById(R.id.close_btn_layout);
        this.lGk = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.lGl = (TextView) inflate.findViewById(R.id.dialog_title);
        this.lGm = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.lGn = (TextView) inflate.findViewById(R.id.user_number);
        this.lGo = (TextView) inflate.findViewById(R.id.login_btn);
        this.lGp = (TextView) inflate.findViewById(R.id.other_login_btn);
        this.lGq = (TextView) inflate.findViewById(R.id.tip_1);
        this.lGr = (TextView) inflate.findViewById(R.id.operator_text);
        this.lGs = (TextView) inflate.findViewById(R.id.tip_2);
        this.lGt = (TextView) inflate.findViewById(R.id.agreement_text);
        this.lGu = (TextView) inflate.findViewById(R.id.tip_3);
        this.lGv = (TextView) inflate.findViewById(R.id.privacy_text);
        this.lGh.setOnClickListener(this);
        this.lGj.setOnClickListener(this);
        this.lGk.setOnClickListener(this);
        this.lGi.setOnClickListener(this);
        this.lGo.setOnClickListener(this);
        this.lGp.setOnClickListener(this);
        this.lGr.setOnClickListener(this);
        this.lGt.setOnClickListener(this);
        this.lGv.setOnClickListener(this);
        initData();
    }

    private void initData() {
        this.lGn.setText(this.phoneNum);
        Fn(this.operatorType);
    }

    private void Fn(int i) {
        switch (i) {
            case 1:
                this.lGr.setText(R.string.onekey_login_dialog_activity_operator_1);
                return;
            case 2:
                this.lGr.setText(R.string.onekey_login_dialog_activity_operator_2);
                return;
            case 3:
                this.lGr.setText(R.string.onekey_login_dialog_activity_operator_3);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void rx(int i) {
        ap.setBackgroundResource(this.lGi, R.drawable.nav_bg_corner_shape, i);
        SvgManager.bsR().a(this.lGk, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGl).nY(R.color.CAM_X0105).nZ(R.dimen.T_X05).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGm).nY(R.color.CAM_X0108).nZ(R.dimen.T_X08).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGn).nY(R.color.CAM_X0105).nZ(R.dimen.T_X03).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGp).nY(R.color.CAM_X0107).nZ(R.dimen.T_X07).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGo).nY(R.color.CAM_X0101).nZ(R.dimen.T_X05).oa(R.string.F_X01).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGq).nY(R.color.CAM_X0108).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGs).nY(R.color.CAM_X0108).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGu).nY(R.color.CAM_X0108).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGr).nY(R.color.CAM_X0302).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGt).nY(R.color.CAM_X0302).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGv).nY(R.color.CAM_X0302).nZ(R.dimen.tbds29).oa(R.string.F_X01);
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public Intent bEJ() {
        return null;
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dialog_background || id == R.id.close_btn_layout || id == R.id.close_btn_view) {
            djN();
        } else if (id == R.id.login_btn) {
            login();
        } else if (id == R.id.operator_text) {
            djK();
        } else if (id == R.id.agreement_text) {
            djL();
        } else if (id == R.id.privacy_text) {
            djM();
        } else if (id == R.id.other_login_btn) {
            djJ();
        }
    }

    private String OX(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        return str.substring(0, 8) + MD5Util.toMd5((str.substring(8, str.length()) + MD5Util.toMd5(SapiUtils.getClientId(this.lGg).toUpperCase().getBytes(), false)).getBytes(), false);
    }

    private void login() {
        this.lGg.showLoading();
        PassportSDK.getInstance().loadOneKeyLogin(this.lGg, OX(this.sign), new OneKeyLoginCallback() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                b.this.lGg.djF();
                b.this.lGg.OW("yijiandenglu");
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                b.this.lGg.closeLoadingDialog();
                b.this.lGg.showToast(String.format(b.this.lGg.getString(R.string.onekey_login_fail), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            }
        });
    }

    private void djJ() {
        this.lGg.finish();
        new LoginActivityConfig((Context) this.lGg, true).start();
    }

    private void djK() {
        switch (this.operatorType) {
            case 1:
                new TbWebViewActivityConfig(this.lGg, this.lGg.getResources().getString(R.string.onekey_login_dialog_activity_operator_1), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
                return;
            case 2:
                new TbWebViewActivityConfig(this.lGg, this.lGg.getResources().getString(R.string.onekey_login_dialog_activity_operator_2), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
                return;
            case 3:
                new TbWebViewActivityConfig(this.lGg, this.lGg.getResources().getString(R.string.onekey_login_dialog_activity_operator_3), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
                return;
            default:
                return;
        }
    }

    private void djL() {
        new TbWebViewActivityConfig(this.lGg, this.lGg.getResources().getString(R.string.onekey_login_dialog_activity_agreement_text), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
    }

    private void djM() {
        new TbWebViewActivityConfig(this.lGg, this.lGg.getResources().getString(R.string.onekey_login_dialog_activity_privacy_text), "http://privacy.baidu.com/mdetail?id=288", false).start();
    }

    private void djN() {
        this.lGg.finish();
    }
}

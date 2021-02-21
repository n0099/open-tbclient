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
    private TextView lGA;
    private TextView lGB;
    private TextView lGC;
    private TextView lGD;
    private TextView lGE;
    private TextView lGF;
    private TextView lGG;
    private TextView lGH;
    private TextView lGI;
    private TextView lGJ;
    private LoginDialogActivity lGu;
    private View lGv;
    private View lGw;
    private View lGx;
    private ImageView lGy;
    private TextView lGz;
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
        this.lGu = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.onekey_login_dialog_activity_layout, viewGroup, true);
        this.lGv = inflate.findViewById(R.id.dialog_background);
        this.lGw = inflate.findViewById(R.id.dialog_layout);
        this.lGx = inflate.findViewById(R.id.close_btn_layout);
        this.lGy = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.lGz = (TextView) inflate.findViewById(R.id.dialog_title);
        this.lGA = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.lGB = (TextView) inflate.findViewById(R.id.user_number);
        this.lGC = (TextView) inflate.findViewById(R.id.login_btn);
        this.lGD = (TextView) inflate.findViewById(R.id.other_login_btn);
        this.lGE = (TextView) inflate.findViewById(R.id.tip_1);
        this.lGF = (TextView) inflate.findViewById(R.id.operator_text);
        this.lGG = (TextView) inflate.findViewById(R.id.tip_2);
        this.lGH = (TextView) inflate.findViewById(R.id.agreement_text);
        this.lGI = (TextView) inflate.findViewById(R.id.tip_3);
        this.lGJ = (TextView) inflate.findViewById(R.id.privacy_text);
        this.lGv.setOnClickListener(this);
        this.lGx.setOnClickListener(this);
        this.lGy.setOnClickListener(this);
        this.lGw.setOnClickListener(this);
        this.lGC.setOnClickListener(this);
        this.lGD.setOnClickListener(this);
        this.lGF.setOnClickListener(this);
        this.lGH.setOnClickListener(this);
        this.lGJ.setOnClickListener(this);
        initData();
    }

    private void initData() {
        this.lGB.setText(this.phoneNum);
        Fn(this.operatorType);
    }

    private void Fn(int i) {
        switch (i) {
            case 1:
                this.lGF.setText(R.string.onekey_login_dialog_activity_operator_1);
                return;
            case 2:
                this.lGF.setText(R.string.onekey_login_dialog_activity_operator_2);
                return;
            case 3:
                this.lGF.setText(R.string.onekey_login_dialog_activity_operator_3);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void rx(int i) {
        ap.setBackgroundResource(this.lGw, R.drawable.nav_bg_corner_shape, i);
        SvgManager.bsR().a(this.lGy, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGz).nY(R.color.CAM_X0105).nZ(R.dimen.T_X05).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGA).nY(R.color.CAM_X0108).nZ(R.dimen.T_X08).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGB).nY(R.color.CAM_X0105).nZ(R.dimen.T_X03).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGD).nY(R.color.CAM_X0107).nZ(R.dimen.T_X07).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGC).nY(R.color.CAM_X0101).nZ(R.dimen.T_X05).oa(R.string.F_X01).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGE).nY(R.color.CAM_X0108).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGG).nY(R.color.CAM_X0108).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGI).nY(R.color.CAM_X0108).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGF).nY(R.color.CAM_X0302).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGH).nY(R.color.CAM_X0302).nZ(R.dimen.tbds29).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGJ).nY(R.color.CAM_X0302).nZ(R.dimen.tbds29).oa(R.string.F_X01);
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
            djU();
        } else if (id == R.id.login_btn) {
            login();
        } else if (id == R.id.operator_text) {
            djR();
        } else if (id == R.id.agreement_text) {
            djS();
        } else if (id == R.id.privacy_text) {
            djT();
        } else if (id == R.id.other_login_btn) {
            djQ();
        }
    }

    private String OY(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        return str.substring(0, 8) + MD5Util.toMd5((str.substring(8, str.length()) + MD5Util.toMd5(SapiUtils.getClientId(this.lGu).toUpperCase().getBytes(), false)).getBytes(), false);
    }

    private void login() {
        this.lGu.showLoading();
        PassportSDK.getInstance().loadOneKeyLogin(this.lGu, OY(this.sign), new OneKeyLoginCallback() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                b.this.lGu.djM();
                b.this.lGu.OX("yijiandenglu");
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                b.this.lGu.closeLoadingDialog();
                b.this.lGu.showToast(String.format(b.this.lGu.getString(R.string.onekey_login_fail), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            }
        });
    }

    private void djQ() {
        this.lGu.finish();
        new LoginActivityConfig((Context) this.lGu, true).start();
    }

    private void djR() {
        switch (this.operatorType) {
            case 1:
                new TbWebViewActivityConfig(this.lGu, this.lGu.getResources().getString(R.string.onekey_login_dialog_activity_operator_1), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
                return;
            case 2:
                new TbWebViewActivityConfig(this.lGu, this.lGu.getResources().getString(R.string.onekey_login_dialog_activity_operator_2), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
                return;
            case 3:
                new TbWebViewActivityConfig(this.lGu, this.lGu.getResources().getString(R.string.onekey_login_dialog_activity_operator_3), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
                return;
            default:
                return;
        }
    }

    private void djS() {
        new TbWebViewActivityConfig(this.lGu, this.lGu.getResources().getString(R.string.onekey_login_dialog_activity_agreement_text), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
    }

    private void djT() {
        new TbWebViewActivityConfig(this.lGu, this.lGu.getResources().getString(R.string.onekey_login_dialog_activity_privacy_text), "http://privacy.baidu.com/mdetail?id=288", false).start();
    }

    private void djU() {
        this.lGu.finish();
    }
}

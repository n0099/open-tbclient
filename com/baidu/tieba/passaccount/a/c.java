package com.baidu.tieba.passaccount.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.google.gson.Gson;
/* loaded from: classes7.dex */
public class c implements View.OnClickListener, a {
    private TextView hZP;
    private ImageView lIA;
    private TextView lIB;
    private TextView lIC;
    private TextView lIE;
    private View lIN;
    private TbImageView lIO;
    private TextView lIP;
    private View lIQ;
    private View lIR;
    private View lIS;
    private View lIT;
    private final ShareStorage.StorageModel lIU;
    private LoginDialogActivity lIw;
    private View lIx;
    private View lIy;
    private View lIz;

    public c(@NonNull String str) {
        this.lIU = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.lIw = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.share_login_dialog_activity_layout, viewGroup, true);
        this.lIx = inflate.findViewById(R.id.dialog_background);
        this.lIy = inflate.findViewById(R.id.dialog_layout);
        this.lIz = inflate.findViewById(R.id.close_btn_layout);
        this.lIA = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.lIB = (TextView) inflate.findViewById(R.id.dialog_title);
        this.lIC = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.lIN = inflate.findViewById(R.id.user_info_layout);
        this.lIO = (TbImageView) inflate.findViewById(R.id.user_avatar);
        this.hZP = (TextView) inflate.findViewById(R.id.user_name);
        this.lIP = (TextView) inflate.findViewById(R.id.user_subtitle);
        this.lIE = (TextView) inflate.findViewById(R.id.login_btn);
        this.lIQ = inflate.findViewById(R.id.qq_login_btn);
        this.lIR = inflate.findViewById(R.id.wechat_login_btn);
        this.lIS = inflate.findViewById(R.id.weibo_login_btn);
        this.lIT = inflate.findViewById(R.id.more_login_btn);
        this.lIx.setOnClickListener(this);
        this.lIz.setOnClickListener(this);
        this.lIA.setOnClickListener(this);
        this.lIy.setOnClickListener(this);
        this.lIO.setIsRound(true);
        this.lIO.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.lIE.setOnClickListener(this);
        this.lIQ.setOnClickListener(this);
        this.lIR.setOnClickListener(this);
        this.lIS.setOnClickListener(this);
        this.lIT.setOnClickListener(this);
        initData();
    }

    private void initData() {
        if (this.lIU != null) {
            this.lIO.startLoad(this.lIU.url, 10, false);
            this.hZP.setText(this.lIU.displayname);
            this.lIP.setText(this.lIw.getResources().getString(R.string.share_login_dialog_subtitle, this.lIU.app));
        }
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void rz(int i) {
        ap.setBackgroundResource(this.lIy, R.drawable.nav_bg_corner_shape, i);
        SvgManager.bsU().a(this.lIA, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIB).nZ(R.color.CAM_X0105).oa(R.dimen.T_X05).ob(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIC).nZ(R.color.CAM_X0108).oa(R.dimen.T_X08).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIN).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.br(this.hZP).nZ(R.color.CAM_X0105).oa(R.dimen.T_X05).ob(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIP).nZ(R.color.CAM_X0108).oa(R.dimen.T_X08).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lIE).nZ(R.color.CAM_X0101).oa(R.dimen.T_X05).ob(R.string.F_X01).oh(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public Intent bEN() {
        return null;
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void onActivityResult(int i, int i2, Intent intent) {
        PassportSDK.getInstance().onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dialog_background || id == R.id.close_btn_layout || id == R.id.close_btn_view) {
            dkd();
        } else if (id == R.id.login_btn) {
            login();
        } else if (id == R.id.qq_login_btn) {
            dke();
        } else if (id == R.id.wechat_login_btn) {
            dkf();
        } else if (id == R.id.weibo_login_btn) {
            dkg();
        } else if (id == R.id.more_login_btn) {
            dkh();
        }
    }

    private void login() {
        if (this.lIU != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.lIw, new WebAuthListener() { // from class: com.baidu.tieba.passaccount.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    c.this.lIw.djV();
                    c.this.lIw.Pd("hutongdenglu");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    c.this.lIw.showToast(String.format(c.this.lIw.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                }
            }, this.lIU);
        }
    }

    private void dke() {
        b(SocialType.QQ_SSO);
    }

    private void dkf() {
        b(SocialType.WEIXIN);
    }

    private void dkg() {
        b(SocialType.SINA_WEIBO_SSO);
    }

    private void b(final SocialType socialType) {
        PassportSDK.getInstance().loadThirdPartyLogin(new WebAuthListener() { // from class: com.baidu.tieba.passaccount.a.c.2
            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
                c.this.lIw.showLoading();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                c.this.lIw.djV();
                c.this.lIw.Pd(socialType.name().toLowerCase());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                c.this.lIw.closeLoadingDialog();
                c.this.lIw.showToast(String.format(c.this.lIw.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
            }
        }, socialType);
    }

    private void dkh() {
        this.lIw.finish();
        new LoginActivityConfig((Context) this.lIw, true).start();
    }

    private void dkd() {
        this.lIw.finish();
    }
}

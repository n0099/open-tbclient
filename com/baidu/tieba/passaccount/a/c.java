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
/* loaded from: classes8.dex */
public class c implements View.OnClickListener, a {
    private TextView hXS;
    private View lGA;
    private View lGB;
    private View lGC;
    private View lGD;
    private final ShareStorage.StorageModel lGE;
    private LoginDialogActivity lGg;
    private View lGh;
    private View lGi;
    private View lGj;
    private ImageView lGk;
    private TextView lGl;
    private TextView lGm;
    private TextView lGo;
    private View lGx;
    private TbImageView lGy;
    private TextView lGz;

    public c(@NonNull String str) {
        this.lGE = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.lGg = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.share_login_dialog_activity_layout, viewGroup, true);
        this.lGh = inflate.findViewById(R.id.dialog_background);
        this.lGi = inflate.findViewById(R.id.dialog_layout);
        this.lGj = inflate.findViewById(R.id.close_btn_layout);
        this.lGk = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.lGl = (TextView) inflate.findViewById(R.id.dialog_title);
        this.lGm = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.lGx = inflate.findViewById(R.id.user_info_layout);
        this.lGy = (TbImageView) inflate.findViewById(R.id.user_avatar);
        this.hXS = (TextView) inflate.findViewById(R.id.user_name);
        this.lGz = (TextView) inflate.findViewById(R.id.user_subtitle);
        this.lGo = (TextView) inflate.findViewById(R.id.login_btn);
        this.lGA = inflate.findViewById(R.id.qq_login_btn);
        this.lGB = inflate.findViewById(R.id.wechat_login_btn);
        this.lGC = inflate.findViewById(R.id.weibo_login_btn);
        this.lGD = inflate.findViewById(R.id.more_login_btn);
        this.lGh.setOnClickListener(this);
        this.lGj.setOnClickListener(this);
        this.lGk.setOnClickListener(this);
        this.lGi.setOnClickListener(this);
        this.lGy.setIsRound(true);
        this.lGy.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.lGo.setOnClickListener(this);
        this.lGA.setOnClickListener(this);
        this.lGB.setOnClickListener(this);
        this.lGC.setOnClickListener(this);
        this.lGD.setOnClickListener(this);
        initData();
    }

    private void initData() {
        if (this.lGE != null) {
            this.lGy.startLoad(this.lGE.url, 10, false);
            this.hXS.setText(this.lGE.displayname);
            this.lGz.setText(this.lGg.getResources().getString(R.string.share_login_dialog_subtitle, this.lGE.app));
        }
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void rx(int i) {
        ap.setBackgroundResource(this.lGi, R.drawable.nav_bg_corner_shape, i);
        SvgManager.bsR().a(this.lGk, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGl).nY(R.color.CAM_X0105).nZ(R.dimen.T_X05).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGm).nY(R.color.CAM_X0108).nZ(R.dimen.T_X08).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGx).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.br(this.hXS).nY(R.color.CAM_X0105).nZ(R.dimen.T_X05).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGz).nY(R.color.CAM_X0108).nZ(R.dimen.T_X08).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGo).nY(R.color.CAM_X0101).nZ(R.dimen.T_X05).oa(R.string.F_X01).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public Intent bEJ() {
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
            djN();
        } else if (id == R.id.login_btn) {
            login();
        } else if (id == R.id.qq_login_btn) {
            djO();
        } else if (id == R.id.wechat_login_btn) {
            djP();
        } else if (id == R.id.weibo_login_btn) {
            djQ();
        } else if (id == R.id.more_login_btn) {
            djR();
        }
    }

    private void login() {
        if (this.lGE != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.lGg, new WebAuthListener() { // from class: com.baidu.tieba.passaccount.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    c.this.lGg.djF();
                    c.this.lGg.OW("hutongdenglu");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    c.this.lGg.showToast(String.format(c.this.lGg.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                }
            }, this.lGE);
        }
    }

    private void djO() {
        b(SocialType.QQ_SSO);
    }

    private void djP() {
        b(SocialType.WEIXIN);
    }

    private void djQ() {
        b(SocialType.SINA_WEIBO_SSO);
    }

    private void b(final SocialType socialType) {
        PassportSDK.getInstance().loadThirdPartyLogin(new WebAuthListener() { // from class: com.baidu.tieba.passaccount.a.c.2
            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
                c.this.lGg.showLoading();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                c.this.lGg.djF();
                c.this.lGg.OW(socialType.name().toLowerCase());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                c.this.lGg.closeLoadingDialog();
                c.this.lGg.showToast(String.format(c.this.lGg.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
            }
        }, socialType);
    }

    private void djR() {
        this.lGg.finish();
        new LoginActivityConfig((Context) this.lGg, true).start();
    }

    private void djN() {
        this.lGg.finish();
    }
}

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
    private TextView hYg;
    private TextView lGA;
    private TextView lGC;
    private View lGL;
    private TbImageView lGM;
    private TextView lGN;
    private View lGO;
    private View lGP;
    private View lGQ;
    private View lGR;
    private final ShareStorage.StorageModel lGS;
    private LoginDialogActivity lGu;
    private View lGv;
    private View lGw;
    private View lGx;
    private ImageView lGy;
    private TextView lGz;

    public c(@NonNull String str) {
        this.lGS = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        this.lGu = loginDialogActivity;
        View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.share_login_dialog_activity_layout, viewGroup, true);
        this.lGv = inflate.findViewById(R.id.dialog_background);
        this.lGw = inflate.findViewById(R.id.dialog_layout);
        this.lGx = inflate.findViewById(R.id.close_btn_layout);
        this.lGy = (ImageView) inflate.findViewById(R.id.close_btn_view);
        this.lGz = (TextView) inflate.findViewById(R.id.dialog_title);
        this.lGA = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        this.lGL = inflate.findViewById(R.id.user_info_layout);
        this.lGM = (TbImageView) inflate.findViewById(R.id.user_avatar);
        this.hYg = (TextView) inflate.findViewById(R.id.user_name);
        this.lGN = (TextView) inflate.findViewById(R.id.user_subtitle);
        this.lGC = (TextView) inflate.findViewById(R.id.login_btn);
        this.lGO = inflate.findViewById(R.id.qq_login_btn);
        this.lGP = inflate.findViewById(R.id.wechat_login_btn);
        this.lGQ = inflate.findViewById(R.id.weibo_login_btn);
        this.lGR = inflate.findViewById(R.id.more_login_btn);
        this.lGv.setOnClickListener(this);
        this.lGx.setOnClickListener(this);
        this.lGy.setOnClickListener(this);
        this.lGw.setOnClickListener(this);
        this.lGM.setIsRound(true);
        this.lGM.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.lGC.setOnClickListener(this);
        this.lGO.setOnClickListener(this);
        this.lGP.setOnClickListener(this);
        this.lGQ.setOnClickListener(this);
        this.lGR.setOnClickListener(this);
        initData();
    }

    private void initData() {
        if (this.lGS != null) {
            this.lGM.startLoad(this.lGS.url, 10, false);
            this.hYg.setText(this.lGS.displayname);
            this.lGN.setText(this.lGu.getResources().getString(R.string.share_login_dialog_subtitle, this.lGS.app));
        }
    }

    @Override // com.baidu.tieba.passaccount.a.a
    public void rx(int i) {
        ap.setBackgroundResource(this.lGw, R.drawable.nav_bg_corner_shape, i);
        SvgManager.bsR().a(this.lGy, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGz).nY(R.color.CAM_X0105).nZ(R.dimen.T_X05).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGA).nY(R.color.CAM_X0108).nZ(R.dimen.T_X08).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGL).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.br(this.hYg).nY(R.color.CAM_X0105).nZ(R.dimen.T_X05).oa(R.string.F_X02);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGN).nY(R.color.CAM_X0108).nZ(R.dimen.T_X08).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lGC).nY(R.color.CAM_X0101).nZ(R.dimen.T_X05).oa(R.string.F_X01).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
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
            djU();
        } else if (id == R.id.login_btn) {
            login();
        } else if (id == R.id.qq_login_btn) {
            djV();
        } else if (id == R.id.wechat_login_btn) {
            djW();
        } else if (id == R.id.weibo_login_btn) {
            djX();
        } else if (id == R.id.more_login_btn) {
            djY();
        }
    }

    private void login() {
        if (this.lGS != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.lGu, new WebAuthListener() { // from class: com.baidu.tieba.passaccount.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    c.this.lGu.djM();
                    c.this.lGu.OX("hutongdenglu");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    c.this.lGu.showToast(String.format(c.this.lGu.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                }
            }, this.lGS);
        }
    }

    private void djV() {
        b(SocialType.QQ_SSO);
    }

    private void djW() {
        b(SocialType.WEIXIN);
    }

    private void djX() {
        b(SocialType.SINA_WEIBO_SSO);
    }

    private void b(final SocialType socialType) {
        PassportSDK.getInstance().loadThirdPartyLogin(new WebAuthListener() { // from class: com.baidu.tieba.passaccount.a.c.2
            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
                c.this.lGu.showLoading();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                c.this.lGu.djM();
                c.this.lGu.OX(socialType.name().toLowerCase());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                c.this.lGu.closeLoadingDialog();
                c.this.lGu.showToast(String.format(c.this.lGu.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
            }
        }, socialType);
    }

    private void djY() {
        this.lGu.finish();
        new LoginActivityConfig((Context) this.lGu, true).start();
    }

    private void djU() {
        this.lGu.finish();
    }
}

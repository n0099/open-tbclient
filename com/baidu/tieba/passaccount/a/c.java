package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c {
    private static volatile c hET;
    private a hEU;

    /* loaded from: classes3.dex */
    public interface a {
        void bPl();

        void d(boolean z, boolean z2, String str);

        void onFail();

        void q(boolean z, String str);
    }

    public static c bPD() {
        if (hET == null) {
            synchronized (c.class) {
                if (hET == null) {
                    hET = new c();
                }
            }
        }
        return hET;
    }

    public void a(a aVar) {
        this.hEU = aVar;
    }

    public void b(a aVar) {
        this.hEU = aVar;
        bPE();
    }

    private void bPE() {
        final SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE);
            SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new SapiCallback<CheckUserFaceIdResult>() { // from class: com.baidu.tieba.passaccount.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(CheckUserFaceIdResult checkUserFaceIdResult) {
                    if (checkUserFaceIdResult.status == 1) {
                        if (!TextUtils.isEmpty(checkUserFaceIdResult.livingUname)) {
                            BdLog.e("非实名人脸验证流程");
                            c.this.a(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.livingUname, session.bduss);
                            return;
                        }
                        BdLog.e("实名人脸验证流程");
                        c.this.a(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, "", session.bduss);
                    } else if (checkUserFaceIdResult.status == 2) {
                        BdLog.e("人脸注册流程");
                        c.this.a(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.authsid, checkUserFaceIdResult.livingUname, checkUserFaceIdResult.authWidgetURL);
                    } else if (checkUserFaceIdResult.status == 3) {
                        BdLog.e("人脸验证不可用");
                        l.showToast(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                        if (c.this.hEU != null) {
                            c.this.hEU.bPl();
                        }
                    } else {
                        BdLog.e("人脸验证不可用");
                        l.showToast(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                        if (c.this.hEU != null) {
                            c.this.hEU.bPl();
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onFailure(CheckUserFaceIdResult checkUserFaceIdResult) {
                    if (checkUserFaceIdResult != null) {
                        l.showToast(TbadkCoreApplication.getInst(), checkUserFaceIdResult.getResultMsg());
                    }
                    if (c.this.hEU != null) {
                        c.this.hEU.onFail();
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, session.bduss, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final boolean z2, String str, String str2, String str3) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.livingUname = str2;
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str3;
        faceIDVerifyDTO.showGuidePage = false;
        PassportSDK.getInstance().verifyUserFaceId(new VerifyUserFaceIDCallback() { // from class: com.baidu.tieba.passaccount.a.c.2
            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onSuccess(SapiResult sapiResult) {
                if (sapiResult instanceof RealNameFaceIDResult) {
                    RealNameFaceIDResult realNameFaceIDResult = (RealNameFaceIDResult) sapiResult;
                    BdLog.d("实名人脸验证成功,callBackKey:" + realNameFaceIDResult.callBackKey + ",authSid:" + realNameFaceIDResult.authSid);
                    l.showToast(TbadkCoreApplication.getInst(), "刷脸验证成功");
                    if (c.this.hEU != null) {
                        c.this.hEU.d(true, true, realNameFaceIDResult.callBackKey);
                    }
                    if (z) {
                        c.this.t(z2, realNameFaceIDResult.callBackKey);
                    }
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    BdLog.d("非实名人脸验证成功 callBackKey" + ((UnRealNameFaceIDResult) sapiResult).registerResult);
                    l.showToast(TbadkCoreApplication.getInst(), "刷脸验证成功");
                    if (c.this.hEU != null) {
                        c.this.hEU.d(false, true, ((UnRealNameFaceIDResult) sapiResult).callBackKey);
                    }
                    if (z) {
                        c.this.t(z2, ((UnRealNameFaceIDResult) sapiResult).callBackKey);
                    }
                }
            }

            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onFailure(SapiResult sapiResult) {
                if (sapiResult != null && sapiResult.getResultCode() != -204 && !aq.equals("用户取消操作", sapiResult.getResultMsg())) {
                    l.showToast(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
                }
                if (c.this.hEU != null) {
                    c.this.hEU.d(sapiResult instanceof RealNameFaceIDResult, false, null);
                }
            }
        }, faceIDVerifyDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final boolean z2, String str, String str2, String str3, String str4) {
        FaceIDRegDTO faceIDRegDTO = new FaceIDRegDTO();
        faceIDRegDTO.authsid = str2;
        faceIDRegDTO.livingUname = str3;
        faceIDRegDTO.businessSence = str;
        faceIDRegDTO.authWidgetURL = str4;
        faceIDRegDTO.showGuidePage = true;
        PassportSDK.getInstance().registerUserFaceID(new RegisterUserFaceIDCallback() { // from class: com.baidu.tieba.passaccount.a.c.3
            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onSuccess(SapiResult sapiResult) {
                if (sapiResult instanceof UnRealNameFaceIDResult) {
                    BdLog.d("人脸注册结果" + ((UnRealNameFaceIDResult) sapiResult).registerResult);
                    l.showToast(TbadkCoreApplication.getInst(), "刷脸注册成功");
                    if (c.this.hEU != null) {
                        c.this.hEU.q(true, ((UnRealNameFaceIDResult) sapiResult).callBackKey);
                    }
                    if (z) {
                        c.this.t(z2, ((UnRealNameFaceIDResult) sapiResult).callBackKey);
                    }
                }
            }

            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onFailure(SapiResult sapiResult) {
                if (sapiResult != null && sapiResult.getResultCode() != -204 && !aq.equals("用户取消操作", sapiResult.getResultMsg())) {
                    l.showToast(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
                }
                if (c.this.hEU != null) {
                    c.this.hEU.q(false, null);
                }
            }
        }, faceIDRegDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final boolean z, String str) {
        SapiAccountManager.getInstance().getAccountService().faceLoginSwitch(new SapiCallback<SapiResult>() { // from class: com.baidu.tieba.passaccount.a.c.4
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(SapiResult sapiResult) {
                BdLog.d("faceLginSwitch onSuccess()" + sapiResult.getResultCode());
                if (z) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(SapiResult sapiResult) {
                if (z) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, SapiAccountManager.getInstance().getSession().bduss, !z, str);
    }
}

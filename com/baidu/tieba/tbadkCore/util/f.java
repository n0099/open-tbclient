package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.AuthVerifyData;
import com.baidu.tieba.e;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private static WeakReference<a> hnU;
    private static a hnV;
    private static AtomicBoolean hnW;
    private static int hnX;
    private static boolean hnY;
    private static int hnZ;
    private static List<Integer> hoa;

    static {
        bEs();
        bEt();
        hnW = new AtomicBoolean(false);
        hnX = 0;
        hnY = true;
        hnZ = 0;
        hoa = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 3250017);
    }

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!hoa.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return a(i, authTokenData.getAuthToken(), aVar);
    }

    private static boolean a(int i, String str, a aVar) {
        AuthVerifyData createDataForAuthWidget;
        boolean z;
        if (hnW.compareAndSet(false, true)) {
            if (hnU == null || hnU.get() == null) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                if (aVar != null) {
                    aVar.setFrom(valueOf);
                    hnU = new WeakReference<>(aVar);
                }
                if (i == 3250022) {
                    final AuthVerifyData createDataForModifyPwd = AuthVerifyData.createDataForModifyPwd(valueOf);
                    if (hnU != null && hnU.get() != null) {
                        hnU.get().onFail();
                    }
                    final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(TbadkCoreApplication.getInst().getCurrentActivity());
                    aVar2.db(e.j.anti_account_modifypwd_tip);
                    aVar2.a(e.j.modify_pwd, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, createDataForModifyPwd));
                        }
                    });
                    aVar2.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                            f.reset();
                        }
                    });
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof BdBaseActivity) {
                        aVar2.b(((BdBaseActivity) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        aVar2.BF();
                    }
                } else {
                    if (i == 3250017) {
                        createDataForAuthWidget = AuthVerifyData.createDataForBindMobile(valueOf);
                    } else if (i == 3250023) {
                        createDataForAuthWidget = AuthVerifyData.createDataForFaceId(valueOf);
                    } else if (i == 3250024) {
                        createDataForAuthWidget = new AuthVerifyData(4, null, valueOf);
                    } else {
                        createDataForAuthWidget = AuthVerifyData.createDataForAuthWidget(str, valueOf);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, createDataForAuthWidget));
                }
                z = true;
            } else {
                hnX++;
                if (hnY && hnZ < 3 && hnX > 0 && hnX / 3 == 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921373));
                    hnZ++;
                }
                z = false;
            }
            hnW.set(false);
            return z;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        protected String from;

        public abstract void bEv();

        public abstract void vT(String str);

        public abstract void vU(String str);

        protected void setFrom(String str) {
            this.from = str;
        }

        public void b(AuthVerifyData.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof AuthVerifyData.a) {
                    vT(((AuthVerifyData.a) cVar).authSid);
                    return;
                } else if (cVar instanceof AuthVerifyData.b) {
                    vU(((AuthVerifyData.b) cVar).aNI);
                    return;
                } else {
                    bEv();
                    return;
                }
            }
            onFail();
        }

        public void onFail() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reset() {
        if (hnU != null) {
            hnU.clear();
        }
        hnU = null;
        hnV = null;
        hnZ = 0;
        hnX = 0;
    }

    public static void bEs() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921372) { // from class: com.baidu.tieba.tbadkCore.util.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof AuthVerifyData) {
                        AuthVerifyData authVerifyData = (AuthVerifyData) data;
                        if (f.hnU != null && f.hnU.get() != null) {
                            a aVar = (a) f.hnU.get();
                            if (TextUtils.equals(aVar.from, authVerifyData.getFrom())) {
                                aVar.b(authVerifyData.getResult());
                            }
                        }
                        f.reset();
                    }
                }
            }
        });
    }

    public static void bEt() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921373) { // from class: com.baidu.tieba.tbadkCore.util.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Boolean) && !((Boolean) data).booleanValue()) {
                        f.reset();
                    }
                }
            }
        });
    }
}

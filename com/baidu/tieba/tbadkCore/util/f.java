package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.AuthVerifyData;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private static WeakReference<a> kir;
    private static a kis;
    private static AtomicBoolean kit;
    private static int kiu;
    private static boolean kiv;
    private static int kiw;
    private static List<Integer> kix;

    static {
        cKD();
        cKE();
        kit = new AtomicBoolean(false);
        kiu = 0;
        kiv = true;
        kiw = 0;
        kix = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 3250017);
    }

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!kix.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return b(i, authTokenData.getAuthToken(), aVar);
    }

    public static boolean a(int i, String str, a aVar) {
        if (!kix.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str))) {
            return false;
        }
        return b(i, str, aVar);
    }

    private static boolean b(int i, String str, a aVar) {
        AuthVerifyData createDataForAuthWidget;
        boolean z;
        if (kit.compareAndSet(false, true)) {
            if (kir == null || kir.get() == null) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                if (aVar != null) {
                    aVar.setFrom(valueOf);
                    kir = new WeakReference<>(aVar);
                }
                if (i == 3250022) {
                    final AuthVerifyData createDataForModifyPwd = AuthVerifyData.createDataForModifyPwd(valueOf);
                    if (kir != null && kir.get() != null) {
                        kir.get().onFail();
                    }
                    if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                        final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(TbadkCoreApplication.getInst().getCurrentActivity());
                        aVar2.jF(R.string.anti_account_modifypwd_tip);
                        aVar2.a(R.string.modify_pwd, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                com.baidu.tbadk.core.dialog.a.this.dismiss();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, createDataForModifyPwd));
                            }
                        });
                        aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                com.baidu.tbadk.core.dialog.a.this.dismiss();
                                f.reset();
                            }
                        });
                        if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof com.baidu.adp.base.f) {
                            aVar2.b(((com.baidu.adp.base.f) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                            aVar2.aCp();
                        }
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
                kiu++;
                if (kiv && kiw < 3 && kiu > 0 && kiu / 3 == 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921373));
                    kiw++;
                }
                z = false;
            }
            kit.set(false);
            return z;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        protected String from;

        public abstract void bwa();

        public abstract void zW(String str);

        public abstract void zX(String str);

        protected void setFrom(String str) {
            this.from = str;
        }

        public void b(AuthVerifyData.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof AuthVerifyData.a) {
                    zW(((AuthVerifyData.a) cVar).authSid);
                    return;
                } else if (cVar instanceof AuthVerifyData.b) {
                    zX(((AuthVerifyData.b) cVar).callbackKey);
                    return;
                } else {
                    bwa();
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
        if (kir != null) {
            kir.clear();
        }
        kir = null;
        kis = null;
        kiw = 0;
        kiu = 0;
    }

    public static void cKD() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921372) { // from class: com.baidu.tieba.tbadkCore.util.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof AuthVerifyData) {
                        AuthVerifyData authVerifyData = (AuthVerifyData) data;
                        if (f.kir != null && f.kir.get() != null) {
                            a aVar = (a) f.kir.get();
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

    public static void cKE() {
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

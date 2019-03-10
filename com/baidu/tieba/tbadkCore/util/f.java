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
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private static WeakReference<a> iIW;
    private static a iIX;
    private static AtomicBoolean iIY;
    private static int iIZ;
    private static boolean iJa;
    private static int iJb;
    private static List<Integer> iJc;

    static {
        cfs();
        cft();
        iIY = new AtomicBoolean(false);
        iIZ = 0;
        iJa = true;
        iJb = 0;
        iJc = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 2121002);
    }

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!iJc.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return b(i, authTokenData.getAuthToken(), aVar);
    }

    public static boolean a(int i, String str, a aVar) {
        if (!iJc.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str))) {
            return false;
        }
        return b(i, str, aVar);
    }

    private static boolean b(int i, String str, a aVar) {
        AuthVerifyData createDataForAuthWidget;
        boolean z;
        if (iIY.compareAndSet(false, true)) {
            if (iIW == null || iIW.get() == null) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                if (aVar != null) {
                    aVar.setFrom(valueOf);
                    iIW = new WeakReference<>(aVar);
                }
                if (i == 3250022) {
                    final AuthVerifyData createDataForModifyPwd = AuthVerifyData.createDataForModifyPwd(valueOf);
                    if (iIW != null && iIW.get() != null) {
                        iIW.get().onFail();
                    }
                    final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(TbadkCoreApplication.getInst().getCurrentActivity());
                    aVar2.gD(d.j.anti_account_modifypwd_tip);
                    aVar2.a(d.j.modify_pwd, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, createDataForModifyPwd));
                        }
                    });
                    aVar2.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                            f.reset();
                        }
                    });
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof BdBaseActivity) {
                        aVar2.b(((BdBaseActivity) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        aVar2.aaZ();
                    }
                } else {
                    if (i == 2121002) {
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
                iIZ++;
                if (iJa && iJb < 3 && iIZ > 0 && iIZ / 3 == 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921373));
                    iJb++;
                }
                z = false;
            }
            iIY.set(false);
            return z;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        protected String from;

        public abstract void aVZ();

        public abstract void ub(String str);

        public abstract void uc(String str);

        protected void setFrom(String str) {
            this.from = str;
        }

        public void b(AuthVerifyData.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof AuthVerifyData.a) {
                    ub(((AuthVerifyData.a) cVar).authSid);
                    return;
                } else if (cVar instanceof AuthVerifyData.b) {
                    uc(((AuthVerifyData.b) cVar).bfv);
                    return;
                } else {
                    aVZ();
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
        if (iIW != null) {
            iIW.clear();
        }
        iIW = null;
        iIX = null;
        iJb = 0;
        iIZ = 0;
    }

    public static void cfs() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921372) { // from class: com.baidu.tieba.tbadkCore.util.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof AuthVerifyData) {
                        AuthVerifyData authVerifyData = (AuthVerifyData) data;
                        if (f.iIW != null && f.iIW.get() != null) {
                            a aVar = (a) f.iIW.get();
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

    public static void cft() {
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

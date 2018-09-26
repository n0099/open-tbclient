package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.AuthVerifyData;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private static WeakReference<a> gYj;
    private static a gYk;
    private static AtomicBoolean gYl;
    private static int gYm;
    private static boolean gYn;
    private static int gYo;
    private static List<Integer> gYp;

    static {
        bzN();
        bzO();
        gYl = new AtomicBoolean(false);
        gYm = 0;
        gYn = true;
        gYo = 0;
        gYp = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 3250017);
    }

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!gYp.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return a(i, authTokenData.getAuthToken(), aVar);
    }

    private static boolean a(int i, String str, a aVar) {
        AuthVerifyData createDataForAuthWidget;
        boolean z;
        if (gYl.compareAndSet(false, true)) {
            if (gYj == null || gYj.get() == null) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                if (aVar != null) {
                    aVar.setFrom(valueOf);
                    gYj = new WeakReference<>(aVar);
                }
                if (i == 3250022) {
                    createDataForAuthWidget = AuthVerifyData.createDataForModifyPwd(valueOf);
                } else if (i == 3250017) {
                    createDataForAuthWidget = AuthVerifyData.createDataForBindMobile(valueOf);
                } else if (i == 3250023) {
                    createDataForAuthWidget = AuthVerifyData.createDataForFaceId(valueOf);
                } else if (i == 3250024) {
                    createDataForAuthWidget = new AuthVerifyData(4, null, valueOf);
                } else {
                    createDataForAuthWidget = AuthVerifyData.createDataForAuthWidget(str, valueOf);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921364, createDataForAuthWidget));
                z = true;
            } else {
                gYm++;
                if (gYn && gYo < 3 && gYm > 0 && gYm / 3 == 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921365));
                    gYo++;
                }
                z = false;
            }
            gYl.set(false);
            return z;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        protected String from;

        public abstract void bzQ();

        public abstract void uL(String str);

        public abstract void uM(String str);

        protected void setFrom(String str) {
            this.from = str;
        }

        public void b(AuthVerifyData.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof AuthVerifyData.a) {
                    uL(((AuthVerifyData.a) cVar).authSid);
                    return;
                } else if (cVar instanceof AuthVerifyData.b) {
                    uM(((AuthVerifyData.b) cVar).aEP);
                    return;
                } else {
                    bzQ();
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
        if (gYj != null) {
            gYj.clear();
        }
        gYj = null;
        gYk = null;
        gYo = 0;
        gYm = 0;
    }

    public static void bzN() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921364) { // from class: com.baidu.tieba.tbadkCore.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof AuthVerifyData) {
                        AuthVerifyData authVerifyData = (AuthVerifyData) data;
                        if (f.gYj != null && f.gYj.get() != null) {
                            a aVar = (a) f.gYj.get();
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

    public static void bzO() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921365) { // from class: com.baidu.tieba.tbadkCore.util.f.2
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

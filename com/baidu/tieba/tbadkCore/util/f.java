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
    private static WeakReference<a> hfD;
    private static a hfE;
    private static AtomicBoolean hfF;
    private static int hfG;
    private static boolean hfH;
    private static int hfI;
    private static List<Integer> hfJ;

    static {
        bDc();
        bDd();
        hfF = new AtomicBoolean(false);
        hfG = 0;
        hfH = true;
        hfI = 0;
        hfJ = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 3250017);
    }

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!hfJ.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return a(i, authTokenData.getAuthToken(), aVar);
    }

    private static boolean a(int i, String str, a aVar) {
        AuthVerifyData createDataForAuthWidget;
        boolean z;
        if (hfF.compareAndSet(false, true)) {
            if (hfD == null || hfD.get() == null) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                if (aVar != null) {
                    aVar.setFrom(valueOf);
                    hfD = new WeakReference<>(aVar);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, createDataForAuthWidget));
                z = true;
            } else {
                hfG++;
                if (hfH && hfI < 3 && hfG > 0 && hfG / 3 == 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921373));
                    hfI++;
                }
                z = false;
            }
            hfF.set(false);
            return z;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        protected String from;

        public abstract void bDf();

        public abstract void vn(String str);

        public abstract void vo(String str);

        protected void setFrom(String str) {
            this.from = str;
        }

        public void b(AuthVerifyData.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof AuthVerifyData.a) {
                    vn(((AuthVerifyData.a) cVar).authSid);
                    return;
                } else if (cVar instanceof AuthVerifyData.b) {
                    vo(((AuthVerifyData.b) cVar).aJs);
                    return;
                } else {
                    bDf();
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
        if (hfD != null) {
            hfD.clear();
        }
        hfD = null;
        hfE = null;
        hfI = 0;
        hfG = 0;
    }

    public static void bDc() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921372) { // from class: com.baidu.tieba.tbadkCore.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof AuthVerifyData) {
                        AuthVerifyData authVerifyData = (AuthVerifyData) data;
                        if (f.hfD != null && f.hfD.get() != null) {
                            a aVar = (a) f.hfD.get();
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

    public static void bDd() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921373) { // from class: com.baidu.tieba.tbadkCore.util.f.2
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

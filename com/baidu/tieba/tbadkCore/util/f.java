package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private static AtomicBoolean kli = new AtomicBoolean(false);
    private static List<Integer> klj = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 3250017);

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!klj.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return b(i, authTokenData.getAuthToken(), aVar);
    }

    public static boolean a(int i, String str, a aVar) {
        if (!klj.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str))) {
            return false;
        }
        return b(i, str, aVar);
    }

    private static boolean b(int i, String str, a aVar) {
        i uh;
        if (kli.compareAndSet(false, true)) {
            String.valueOf(System.currentTimeMillis());
            if (i == 3250022) {
                final i aJr = i.aJr();
                aJr.a(aVar);
                if (aVar != null) {
                    aVar.onFail();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(TbadkCoreApplication.getInst().getCurrentActivity());
                    aVar2.jW(R.string.anti_account_modifypwd_tip);
                    aVar2.a(R.string.modify_pwd, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, aJr));
                        }
                    });
                    aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                        }
                    });
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof com.baidu.adp.base.f) {
                        aVar2.b(((com.baidu.adp.base.f) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        aVar2.aEG();
                    }
                }
            } else {
                if (i == 3250017) {
                    uh = i.aJs();
                } else if (i == 3250023) {
                    uh = i.aJt();
                } else if (i == 3250024) {
                    uh = new i(4, null);
                } else {
                    uh = i.uh(str);
                }
                uh.a(aVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, uh));
            }
            kli.set(false);
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void Ao(String str);

        public abstract void Ap(String str);

        public abstract void bxM();

        public void b(i.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof i.a) {
                    Ao(((i.a) cVar).authSid);
                    return;
                } else if (cVar instanceof i.b) {
                    Ap(((i.b) cVar).callbackKey);
                    return;
                } else {
                    bxM();
                    return;
                }
            }
            onFail();
        }

        public void onFail() {
        }
    }
}

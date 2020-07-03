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
    private static AtomicBoolean lIU = new AtomicBoolean(false);
    private static List<Integer> lIV = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 3250017);

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!lIV.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return b(i, authTokenData.getAuthToken(), aVar);
    }

    public static boolean a(int i, String str, a aVar) {
        if (!lIV.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str))) {
            return false;
        }
        return b(i, str, aVar);
    }

    private static boolean b(int i, String str, a aVar) {
        i xy;
        if (lIU.compareAndSet(false, true)) {
            String.valueOf(System.currentTimeMillis());
            if (i == 3250022) {
                final i aZY = i.aZY();
                aZY.a(aVar);
                if (aVar != null) {
                    aVar.onFail();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(TbadkCoreApplication.getInst().getCurrentActivity());
                    aVar2.kT(R.string.anti_account_modifypwd_tip);
                    aVar2.a(R.string.modify_pwd, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, aZY));
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
                        aVar2.aUN();
                    }
                }
            } else {
                if (i == 3250017) {
                    xy = i.aZZ();
                } else if (i == 3250023) {
                    xy = i.baa();
                } else if (i == 3250024) {
                    xy = new i(4, null);
                } else {
                    xy = i.xy(str);
                }
                xy.a(aVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, xy));
            }
            lIU.set(false);
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void Ei(String str);

        public abstract void Ej(String str);

        public abstract void bQX();

        public void b(i.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof i.a) {
                    Ei(((i.a) cVar).authSid);
                    return;
                } else if (cVar instanceof i.b) {
                    Ej(((i.b) cVar).callbackKey);
                    return;
                } else {
                    bQX();
                    return;
                }
            }
            onFail();
        }

        public void onFail() {
        }
    }
}

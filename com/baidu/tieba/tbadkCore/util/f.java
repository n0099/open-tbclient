package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private static AtomicBoolean nqh = new AtomicBoolean(false);
    private static List<Integer> nqi = Arrays.asList(3250020, 3250021, 3250022, 3250023, 3250024, 3250017);

    public static boolean a(int i, AuthTokenData authTokenData, a aVar) {
        if (!nqi.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken())))) {
            return false;
        }
        return b(i, authTokenData.getAuthToken(), aVar);
    }

    public static boolean a(int i, String str, a aVar) {
        if (!nqi.contains(Integer.valueOf(i)) || ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str))) {
            return false;
        }
        return b(i, str, aVar);
    }

    private static boolean b(int i, String str, a aVar) {
        j BB;
        if (nqh.compareAndSet(false, true)) {
            String.valueOf(System.currentTimeMillis());
            if (i == 3250022) {
                final j bvP = j.bvP();
                bvP.a(aVar);
                if (aVar != null) {
                    aVar.onFail();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(TbadkCoreApplication.getInst().getCurrentActivity());
                    aVar2.nu(R.string.anti_account_modifypwd_tip);
                    aVar2.a(R.string.modify_pwd, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, bvP));
                        }
                    });
                    aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.f.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            com.baidu.tbadk.core.dialog.a.this.dismiss();
                        }
                    });
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof g) {
                        aVar2.b(((g) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        aVar2.bqe();
                    }
                }
            } else {
                if (i == 3250017) {
                    BB = j.bvQ();
                } else if (i == 3250023) {
                    BB = j.bvR();
                } else if (i == 3250024) {
                    BB = new j(4, null);
                } else {
                    BB = j.BB(str);
                }
                BB.a(aVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, BB));
            }
            nqh.set(false);
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void Iw(String str);

        public abstract void Ix(String str);

        public abstract void ctJ();

        public void b(j.c cVar) {
            if (cVar != null && cVar.isSuccess) {
                if (cVar instanceof j.a) {
                    Iw(((j.a) cVar).authSid);
                    return;
                } else if (cVar instanceof j.b) {
                    Ix(((j.b) cVar).callbackKey);
                    return;
                } else {
                    ctJ();
                    return;
                }
            }
            onFail();
        }

        public void onFail() {
        }
    }
}

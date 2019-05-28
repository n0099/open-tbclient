package com.baidu.tieba.n;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.j;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a iyA;
    private e iyB;
    private int mScore = 0;

    public static a cet() {
        if (iyA == null) {
            synchronized (a.class) {
                if (iyA == null) {
                    iyA = new a();
                }
            }
        }
        return iyA;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.agM().getString("key_rate_version", ""))) {
            b.agM().putString("key_rate_version", version);
            b.agM().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void w(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            A(tbPageContext);
        }
    }

    public void x(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.agM().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.agM().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.agM().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.agM().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.agM().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.agM().putInt("key_rate_like_count" + currentAccount, 0);
                A(tbPageContext);
                return;
            }
            b.agM().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void y(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            j jVar = new j(tbPageContext.getContext());
            jVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            jVar.BV(8);
            jVar.BU(0);
            int g = l.g(tbPageContext.getContext(), R.dimen.ds86);
            int g2 = l.g(tbPageContext.getContext(), R.dimen.ds138);
            int g3 = l.g(tbPageContext.getContext(), R.dimen.ds27);
            jVar.setTitleSize(R.dimen.ds28);
            jVar.setTitlePadding(0, g, 0, g3);
            jVar.C(0, 0, 0, g2);
            jVar.rG(true);
            jVar.a(new j.e() { // from class: com.baidu.tieba.n.a.1
                @Override // com.baidu.tieba.view.j.e
                public void yR(int i) {
                    if (a.this.iyB != null) {
                        a.this.iyB.dismiss();
                        a.this.iyB = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new am("c13072").P("obj_type", a.this.mScore));
                        a.this.z(tbPageContext);
                    }
                }
            });
            this.iyB = new e(tbPageContext.getContext(), jVar.afZ());
            this.iyB.an(0.7f);
            g.a(this.iyB, tbPageContext);
            TiebaStatic.log(new am("c13071"));
        }
    }

    public void z(final TbPageContext tbPageContext) {
        j.a aVar;
        if (tbPageContext != null) {
            j jVar = new j(tbPageContext.getContext());
            if (this.mScore == 1 || this.mScore == 2) {
                jVar.setTitleText(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
                aVar = new j.a(tbPageContext.getContext().getString(R.string.go_feedback), jVar);
            } else {
                jVar.setTitleText(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
                aVar = new j.a(tbPageContext.getContext().getString(R.string.go_score), jVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            jVar.BT(this.mScore);
            jVar.BU(0);
            jVar.BV(0);
            jVar.rG(false);
            l.g(tbPageContext.getContext(), R.dimen.ds42);
            int g = l.g(tbPageContext.getContext(), R.dimen.ds32);
            l.g(tbPageContext.getContext(), R.dimen.ds51);
            jVar.setTitlePadding(0, l.g(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            jVar.C(0, g, 0, g);
            aVar.a(new j.c() { // from class: com.baidu.tieba.n.a.2
                @Override // com.baidu.tieba.view.j.c
                public void onClick() {
                    if (a.this.iyB != null) {
                        a.this.iyB.dismiss();
                        a.this.iyB = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.B(tbPageContext);
                            TiebaStatic.log(new am("c13077"));
                            return;
                        }
                        a.this.C(tbPageContext);
                        TiebaStatic.log(new am("c13074"));
                    }
                }
            });
            jVar.a(new j.b() { // from class: com.baidu.tieba.n.a.3
                @Override // com.baidu.tieba.view.j.b
                public void onClick() {
                    if (a.this.iyB != null) {
                        a.this.iyB.dismiss();
                        a.this.iyB = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new am("c13078"));
                        } else {
                            TiebaStatic.log(new am("c13075"));
                        }
                    }
                }
            });
            jVar.W(arrayList);
            this.iyB = new e(tbPageContext.getContext(), jVar.afZ());
            this.iyB.an(0.7f);
            g.a(this.iyB, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new am("c13076"));
            } else {
                TiebaStatic.log(new am("c13073"));
            }
        }
    }

    private void A(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.agM().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.agM().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.agM().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    y(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            ba.aiz().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

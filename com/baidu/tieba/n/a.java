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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.f;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.j;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a gnt;
    private e fiF;
    private int mScore = 0;

    public static a bmW() {
        if (gnt == null) {
            synchronized (a.class) {
                if (gnt == null) {
                    gnt = new a();
                }
            }
        }
        return gnt;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.getInstance().getString("key_rate_version", ""))) {
            b.getInstance().putString("key_rate_version", version);
            b.getInstance().putLong("key_rate_version_time", Long.valueOf(new Date().getTime()).longValue());
        }
    }

    public void x(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            B(tbPageContext);
        }
    }

    public void y(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.getInstance().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.getInstance().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.getInstance().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.getInstance().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.getInstance().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.getInstance().putInt("key_rate_like_count" + currentAccount, 0);
                B(tbPageContext);
                return;
            }
            b.getInstance().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void z(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            j jVar = new j(tbPageContext.getContext());
            jVar.setTitleText(tbPageContext.getContext().getString(f.j.is_tieba_pleased));
            jVar.vc(8);
            jVar.vb(0);
            int f = l.f(tbPageContext.getContext(), f.e.ds86);
            int f2 = l.f(tbPageContext.getContext(), f.e.ds138);
            int f3 = l.f(tbPageContext.getContext(), f.e.ds27);
            jVar.setTitleSize(f.e.ds28);
            jVar.y(0, f, 0, f3);
            jVar.x(0, 0, 0, f2);
            jVar.nk(true);
            jVar.a(new j.e() { // from class: com.baidu.tieba.n.a.1
                @Override // com.baidu.tieba.view.j.e
                public void sd(int i) {
                    if (a.this.fiF != null) {
                        a.this.fiF.dismiss();
                        a.this.fiF = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new an("c13072").r("obj_type", a.this.mScore));
                        a.this.A(tbPageContext);
                    }
                }
            });
            this.fiF = new e(tbPageContext.getContext(), jVar.bEs());
            this.fiF.aA(0.7f);
            g.a(this.fiF, tbPageContext);
            TiebaStatic.log(new an("c13071"));
        }
    }

    public void A(final TbPageContext tbPageContext) {
        j.a aVar;
        if (tbPageContext != null) {
            j jVar = new j(tbPageContext.getContext());
            if (this.mScore == 1 || this.mScore == 2) {
                jVar.setTitleText(tbPageContext.getContext().getString(f.j.help_my_improving_experience));
                aVar = new j.a(tbPageContext.getContext().getString(f.j.go_feedback), jVar);
            } else {
                jVar.setTitleText(tbPageContext.getContext().getString(f.j.go_shop_give_me_comment));
                aVar = new j.a(tbPageContext.getContext().getString(f.j.go_score), jVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            jVar.va(this.mScore);
            jVar.vb(0);
            jVar.vc(0);
            jVar.nk(false);
            l.f(tbPageContext.getContext(), f.e.ds42);
            int f = l.f(tbPageContext.getContext(), f.e.ds32);
            l.f(tbPageContext.getContext(), f.e.ds51);
            jVar.y(0, l.f(tbPageContext.getContext(), f.e.ds21), 0, 0);
            jVar.x(0, f, 0, f);
            aVar.a(new j.c() { // from class: com.baidu.tieba.n.a.2
                @Override // com.baidu.tieba.view.j.c
                public void onClick() {
                    if (a.this.fiF != null) {
                        a.this.fiF.dismiss();
                        a.this.fiF = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.C(tbPageContext);
                            TiebaStatic.log(new an("c13077"));
                            return;
                        }
                        a.this.D(tbPageContext);
                        TiebaStatic.log(new an("c13074"));
                    }
                }
            });
            jVar.a(new j.b() { // from class: com.baidu.tieba.n.a.3
                @Override // com.baidu.tieba.view.j.b
                public void onClick() {
                    if (a.this.fiF != null) {
                        a.this.fiF.dismiss();
                        a.this.fiF = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new an("c13078"));
                        } else {
                            TiebaStatic.log(new an("c13075"));
                        }
                    }
                }
            });
            jVar.dM(arrayList);
            this.fiF = new e(tbPageContext.getContext(), jVar.bEs());
            this.fiF.aA(0.7f);
            g.a(this.fiF, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new an("c13076"));
            } else {
                TiebaStatic.log(new an("c13073"));
            }
        }
    }

    private void B(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.getInstance().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.getInstance().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.getInstance().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    z(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            az.zI().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

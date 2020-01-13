package com.baidu.tieba.n;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.g;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a jDM;
    private e jDN;
    private int mScore = 0;

    public static a cAA() {
        if (jDM == null) {
            synchronized (a.class) {
                if (jDM == null) {
                    jDM = new a();
                }
            }
        }
        return jDM;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.aDr().getString("key_rate_version", ""))) {
            b.aDr().putString("key_rate_version", version);
            b.aDr().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void A(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            E(tbPageContext);
        }
    }

    public void B(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.aDr().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.aDr().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.aDr().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.aDr().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.aDr().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.aDr().putInt("key_rate_like_count" + currentAccount, 0);
                E(tbPageContext);
                return;
            }
            b.aDr().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void C(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            g gVar = new g(tbPageContext.getContext());
            gVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            gVar.DO(8);
            gVar.DN(0);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds86);
            int dimens2 = l.getDimens(tbPageContext.getContext(), R.dimen.ds138);
            int dimens3 = l.getDimens(tbPageContext.getContext(), R.dimen.ds27);
            gVar.setTitleSize(R.dimen.ds28);
            gVar.setTitlePadding(0, dimens, 0, dimens3);
            gVar.F(0, 0, 0, dimens2);
            gVar.ty(true);
            gVar.a(new g.e() { // from class: com.baidu.tieba.n.a.1
                @Override // com.baidu.tieba.view.g.e
                public void AG(int i) {
                    if (a.this.jDN != null) {
                        a.this.jDN.dismiss();
                        a.this.jDN = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new an("c13072").Z("obj_type", a.this.mScore));
                        a.this.D(tbPageContext);
                    }
                }
            });
            this.jDN = new e(tbPageContext.getContext(), gVar.aCF());
            this.jDN.af(0.7f);
            com.baidu.adp.lib.f.g.a(this.jDN, tbPageContext);
            TiebaStatic.log(new an("c13071"));
        }
    }

    public void D(final TbPageContext tbPageContext) {
        g.a aVar;
        if (tbPageContext != null) {
            g gVar = new g(tbPageContext.getContext());
            if (this.mScore == 1 || this.mScore == 2) {
                gVar.setTitleText(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
                aVar = new g.a(tbPageContext.getContext().getString(R.string.go_feedback), gVar);
            } else {
                gVar.setTitleText(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
                aVar = new g.a(tbPageContext.getContext().getString(R.string.go_score), gVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            gVar.DM(this.mScore);
            gVar.DN(0);
            gVar.DO(0);
            gVar.ty(false);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds42);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds32);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds51);
            gVar.setTitlePadding(0, l.getDimens(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            gVar.F(0, dimens, 0, dimens);
            aVar.a(new g.c() { // from class: com.baidu.tieba.n.a.2
                @Override // com.baidu.tieba.view.g.c
                public void onClick() {
                    if (a.this.jDN != null) {
                        a.this.jDN.dismiss();
                        a.this.jDN = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.F(tbPageContext);
                            TiebaStatic.log(new an("c13077"));
                            return;
                        }
                        a.this.G(tbPageContext);
                        TiebaStatic.log(new an("c13074"));
                    }
                }
            });
            gVar.a(new g.b() { // from class: com.baidu.tieba.n.a.3
                @Override // com.baidu.tieba.view.g.b
                public void onClick() {
                    if (a.this.jDN != null) {
                        a.this.jDN.dismiss();
                        a.this.jDN = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new an("c13078"));
                        } else {
                            TiebaStatic.log(new an("c13075"));
                        }
                    }
                }
            });
            gVar.az(arrayList);
            this.jDN = new e(tbPageContext.getContext(), gVar.aCF());
            this.jDN.af(0.7f);
            com.baidu.adp.lib.f.g.a(this.jDN, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new an("c13076"));
            } else {
                TiebaStatic.log(new an("c13073"));
            }
        }
    }

    private void E(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.aDr().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.aDr().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.aDr().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    C(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            ba.aEt().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

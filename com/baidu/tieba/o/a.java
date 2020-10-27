package com.baidu.tieba.o;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a mlZ;
    private int mScore = 0;
    private e mma;

    public static a dxr() {
        if (mlZ == null) {
            synchronized (a.class) {
                if (mlZ == null) {
                    mlZ = new a();
                }
            }
        }
        return mlZ;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.bnH().getString("key_rate_version", ""))) {
            b.bnH().putString("key_rate_version", version);
            b.bnH().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void F(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            J(tbPageContext);
        }
    }

    public void G(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.bnH().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.bnH().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.bnH().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.bnH().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.bnH().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.bnH().putInt("key_rate_like_count" + currentAccount, 0);
                J(tbPageContext);
                return;
            }
            b.bnH().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void H(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            h hVar = new h(tbPageContext.getContext());
            hVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            hVar.KP(8);
            hVar.KO(0);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds86);
            int dimens2 = l.getDimens(tbPageContext.getContext(), R.dimen.ds138);
            int dimens3 = l.getDimens(tbPageContext.getContext(), R.dimen.ds27);
            hVar.setTitleSize(R.dimen.ds28);
            hVar.setTitlePadding(0, dimens, 0, dimens3);
            hVar.I(0, 0, 0, dimens2);
            hVar.yc(true);
            hVar.a(new h.e() { // from class: com.baidu.tieba.o.a.1
                @Override // com.baidu.tieba.view.h.e
                public void HC(int i) {
                    if (a.this.mma != null) {
                        a.this.mma.dismiss();
                        a.this.mma = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new aq("c13072").aj("obj_type", a.this.mScore));
                        a.this.I(tbPageContext);
                    }
                }
            });
            this.mma = new e(tbPageContext.getContext(), hVar.bmS());
            this.mma.Y(0.7f);
            g.a(this.mma, tbPageContext);
            TiebaStatic.log(new aq("c13071"));
        }
    }

    public void I(final TbPageContext tbPageContext) {
        h.a aVar;
        if (tbPageContext != null) {
            h hVar = new h(tbPageContext.getContext());
            if (this.mScore == 1 || this.mScore == 2) {
                hVar.setTitleText(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
                aVar = new h.a(tbPageContext.getContext().getString(R.string.go_feedback), hVar);
            } else {
                hVar.setTitleText(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
                aVar = new h.a(tbPageContext.getContext().getString(R.string.go_score), hVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            hVar.KN(this.mScore);
            hVar.KO(0);
            hVar.KP(0);
            hVar.yc(false);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds42);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds32);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds51);
            hVar.setTitlePadding(0, l.getDimens(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            hVar.I(0, dimens, 0, dimens);
            aVar.a(new h.c() { // from class: com.baidu.tieba.o.a.2
                @Override // com.baidu.tieba.view.h.c
                public void onClick() {
                    if (a.this.mma != null) {
                        a.this.mma.dismiss();
                        a.this.mma = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.K(tbPageContext);
                            TiebaStatic.log(new aq("c13077"));
                            return;
                        }
                        a.this.L(tbPageContext);
                        TiebaStatic.log(new aq("c13074"));
                    }
                }
            });
            hVar.a(new h.b() { // from class: com.baidu.tieba.o.a.3
                @Override // com.baidu.tieba.view.h.b
                public void onClick() {
                    if (a.this.mma != null) {
                        a.this.mma.dismiss();
                        a.this.mma = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new aq("c13078"));
                        } else {
                            TiebaStatic.log(new aq("c13075"));
                        }
                    }
                }
            });
            hVar.bk(arrayList);
            this.mma = new e(tbPageContext.getContext(), hVar.bmS());
            this.mma.Y(0.7f);
            g.a(this.mma, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new aq("c13076"));
            } else {
                TiebaStatic.log(new aq("c13073"));
            }
        }
    }

    private void J(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.bnH().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.bnH().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.bnH().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    H(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            be.boR().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

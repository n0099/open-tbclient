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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a ldo;
    private e ldp;
    private int mScore = 0;

    public static a cYy() {
        if (ldo == null) {
            synchronized (a.class) {
                if (ldo == null) {
                    ldo = new a();
                }
            }
        }
        return ldo;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.aVP().getString("key_rate_version", ""))) {
            b.aVP().putString("key_rate_version", version);
            b.aVP().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void G(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            K(tbPageContext);
        }
    }

    public void H(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.aVP().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.aVP().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.aVP().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.aVP().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.aVP().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.aVP().putInt("key_rate_like_count" + currentAccount, 0);
                K(tbPageContext);
                return;
            }
            b.aVP().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void I(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            h hVar = new h(tbPageContext.getContext());
            hVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            hVar.Gv(8);
            hVar.Gu(0);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds86);
            int dimens2 = l.getDimens(tbPageContext.getContext(), R.dimen.ds138);
            int dimens3 = l.getDimens(tbPageContext.getContext(), R.dimen.ds27);
            hVar.setTitleSize(R.dimen.ds28);
            hVar.setTitlePadding(0, dimens, 0, dimens3);
            hVar.G(0, 0, 0, dimens2);
            hVar.vA(true);
            hVar.a(new h.e() { // from class: com.baidu.tieba.o.a.1
                @Override // com.baidu.tieba.view.h.e
                public void Dl(int i) {
                    if (a.this.ldp != null) {
                        a.this.ldp.dismiss();
                        a.this.ldp = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new ao("c13072").ag("obj_type", a.this.mScore));
                        a.this.J(tbPageContext);
                    }
                }
            });
            this.ldp = new e(tbPageContext.getContext(), hVar.aVb());
            this.ldp.P(0.7f);
            g.a(this.ldp, tbPageContext);
            TiebaStatic.log(new ao("c13071"));
        }
    }

    public void J(final TbPageContext tbPageContext) {
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
            hVar.Gt(this.mScore);
            hVar.Gu(0);
            hVar.Gv(0);
            hVar.vA(false);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds42);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds32);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds51);
            hVar.setTitlePadding(0, l.getDimens(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            hVar.G(0, dimens, 0, dimens);
            aVar.a(new h.c() { // from class: com.baidu.tieba.o.a.2
                @Override // com.baidu.tieba.view.h.c
                public void onClick() {
                    if (a.this.ldp != null) {
                        a.this.ldp.dismiss();
                        a.this.ldp = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.L(tbPageContext);
                            TiebaStatic.log(new ao("c13077"));
                            return;
                        }
                        a.this.M(tbPageContext);
                        TiebaStatic.log(new ao("c13074"));
                    }
                }
            });
            hVar.a(new h.b() { // from class: com.baidu.tieba.o.a.3
                @Override // com.baidu.tieba.view.h.b
                public void onClick() {
                    if (a.this.ldp != null) {
                        a.this.ldp.dismiss();
                        a.this.ldp = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new ao("c13078"));
                        } else {
                            TiebaStatic.log(new ao("c13075"));
                        }
                    }
                }
            });
            hVar.aL(arrayList);
            this.ldp = new e(tbPageContext.getContext(), hVar.aVb());
            this.ldp.P(0.7f);
            g.a(this.ldp, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new ao("c13076"));
            } else {
                TiebaStatic.log(new ao("c13073"));
            }
        }
    }

    private void K(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.aVP().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.aVP().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.aVP().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    I(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            bc.aWU().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

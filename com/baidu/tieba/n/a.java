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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.j;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a iGK;
    private e iGL;
    private int mScore = 0;

    public static a cfp() {
        if (iGK == null) {
            synchronized (a.class) {
                if (iGK == null) {
                    iGK = new a();
                }
            }
        }
        return iGK;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.alR().getString("key_rate_version", ""))) {
            b.alR().putString("key_rate_version", version);
            b.alR().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void y(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            C(tbPageContext);
        }
    }

    public void z(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.alR().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.alR().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.alR().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.alR().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.alR().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.alR().putInt("key_rate_like_count" + currentAccount, 0);
                C(tbPageContext);
                return;
            }
            b.alR().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void A(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            j jVar = new j(tbPageContext.getContext());
            jVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            jVar.Bn(8);
            jVar.Bm(0);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds86);
            int dimens2 = l.getDimens(tbPageContext.getContext(), R.dimen.ds138);
            int dimens3 = l.getDimens(tbPageContext.getContext(), R.dimen.ds27);
            jVar.setTitleSize(R.dimen.ds28);
            jVar.setTitlePadding(0, dimens, 0, dimens3);
            jVar.B(0, 0, 0, dimens2);
            jVar.rH(true);
            jVar.a(new j.e() { // from class: com.baidu.tieba.n.a.1
                @Override // com.baidu.tieba.view.j.e
                public void yg(int i) {
                    if (a.this.iGL != null) {
                        a.this.iGL.dismiss();
                        a.this.iGL = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new an("c13072").O("obj_type", a.this.mScore));
                        a.this.B(tbPageContext);
                    }
                }
            });
            this.iGL = new e(tbPageContext.getContext(), jVar.ale());
            this.iGL.ab(0.7f);
            g.a(this.iGL, tbPageContext);
            TiebaStatic.log(new an("c13071"));
        }
    }

    public void B(final TbPageContext tbPageContext) {
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
            jVar.Bl(this.mScore);
            jVar.Bm(0);
            jVar.Bn(0);
            jVar.rH(false);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds42);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds32);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds51);
            jVar.setTitlePadding(0, l.getDimens(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            jVar.B(0, dimens, 0, dimens);
            aVar.a(new j.c() { // from class: com.baidu.tieba.n.a.2
                @Override // com.baidu.tieba.view.j.c
                public void onClick() {
                    if (a.this.iGL != null) {
                        a.this.iGL.dismiss();
                        a.this.iGL = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.D(tbPageContext);
                            TiebaStatic.log(new an("c13077"));
                            return;
                        }
                        a.this.E(tbPageContext);
                        TiebaStatic.log(new an("c13074"));
                    }
                }
            });
            jVar.a(new j.b() { // from class: com.baidu.tieba.n.a.3
                @Override // com.baidu.tieba.view.j.b
                public void onClick() {
                    if (a.this.iGL != null) {
                        a.this.iGL.dismiss();
                        a.this.iGL = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new an("c13078"));
                        } else {
                            TiebaStatic.log(new an("c13075"));
                        }
                    }
                }
            });
            jVar.at(arrayList);
            this.iGL = new e(tbPageContext.getContext(), jVar.ale());
            this.iGL.ab(0.7f);
            g.a(this.iGL, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new an("c13076"));
            } else {
                TiebaStatic.log(new an("c13073"));
            }
        }
    }

    private void C(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.alR().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.alR().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.alR().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    A(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            ba.amQ().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

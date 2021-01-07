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
    private static a mLO;
    private e mLP;
    private int mScore = 0;

    public static a dEB() {
        if (mLO == null) {
            synchronized (a.class) {
                if (mLO == null) {
                    mLO = new a();
                }
            }
        }
        return mLO;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.bvr().getString("key_rate_version", ""))) {
            b.bvr().putString("key_rate_version", version);
            b.bvr().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void E(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            I(tbPageContext);
        }
    }

    public void F(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.bvr().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.bvr().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.bvr().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.bvr().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.bvr().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.bvr().putInt("key_rate_like_count" + currentAccount, 0);
                I(tbPageContext);
                return;
            }
            b.bvr().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void G(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            h hVar = new h(tbPageContext.getContext());
            hVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            hVar.Mk(8);
            hVar.Mj(0);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds86);
            int dimens2 = l.getDimens(tbPageContext.getContext(), R.dimen.ds138);
            int dimens3 = l.getDimens(tbPageContext.getContext(), R.dimen.ds27);
            hVar.setTitleSize(R.dimen.ds28);
            hVar.setTitlePadding(0, dimens, 0, dimens3);
            hVar.N(0, 0, 0, dimens2);
            hVar.yX(true);
            hVar.a(new h.e() { // from class: com.baidu.tieba.o.a.1
                @Override // com.baidu.tieba.view.h.e
                public void IY(int i) {
                    if (a.this.mLP != null) {
                        a.this.mLP.dismiss();
                        a.this.mLP = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new aq("c13072").an("obj_type", a.this.mScore));
                        a.this.H(tbPageContext);
                    }
                }
            });
            this.mLP = new e(tbPageContext.getContext(), hVar.bus());
            this.mLP.ab(0.7f);
            g.a(this.mLP, tbPageContext);
            TiebaStatic.log(new aq("c13071"));
        }
    }

    public void H(final TbPageContext tbPageContext) {
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
            hVar.Mi(this.mScore);
            hVar.Mj(0);
            hVar.Mk(0);
            hVar.yX(false);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds42);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds32);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds51);
            hVar.setTitlePadding(0, l.getDimens(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            hVar.N(0, dimens, 0, dimens);
            aVar.a(new h.c() { // from class: com.baidu.tieba.o.a.2
                @Override // com.baidu.tieba.view.h.c
                public void onClick() {
                    if (a.this.mLP != null) {
                        a.this.mLP.dismiss();
                        a.this.mLP = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.J(tbPageContext);
                            TiebaStatic.log(new aq("c13077"));
                            return;
                        }
                        a.this.K(tbPageContext);
                        TiebaStatic.log(new aq("c13074"));
                    }
                }
            });
            hVar.a(new h.b() { // from class: com.baidu.tieba.o.a.3
                @Override // com.baidu.tieba.view.h.b
                public void onClick() {
                    if (a.this.mLP != null) {
                        a.this.mLP.dismiss();
                        a.this.mLP = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new aq("c13078"));
                        } else {
                            TiebaStatic.log(new aq("c13075"));
                        }
                    }
                }
            });
            hVar.bB(arrayList);
            this.mLP = new e(tbPageContext.getContext(), hVar.bus());
            this.mLP.ab(0.7f);
            g.a(this.mLP, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new aq("c13076"));
            } else {
                TiebaStatic.log(new aq("c13073"));
            }
        }
    }

    private void I(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.bvr().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.bvr().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.bvr().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    G(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            be.bwv().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

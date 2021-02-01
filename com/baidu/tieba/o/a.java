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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a mQq;
    private e mQr;
    private int mScore = 0;

    public static a dCR() {
        if (mQq == null) {
            synchronized (a.class) {
                if (mQq == null) {
                    mQq = new a();
                }
            }
        }
        return mQq;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.brQ().getString("key_rate_version", ""))) {
            b.brQ().putString("key_rate_version", version);
            b.brQ().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void I(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            M(tbPageContext);
        }
    }

    public void J(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.brQ().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.brQ().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.brQ().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.brQ().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.brQ().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.brQ().putInt("key_rate_like_count" + currentAccount, 0);
                M(tbPageContext);
                return;
            }
            b.brQ().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void K(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            h hVar = new h(tbPageContext.getContext());
            hVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            hVar.KY(8);
            hVar.KX(0);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds86);
            int dimens2 = l.getDimens(tbPageContext.getContext(), R.dimen.ds138);
            int dimens3 = l.getDimens(tbPageContext.getContext(), R.dimen.ds27);
            hVar.setTitleSize(R.dimen.ds28);
            hVar.setTitlePadding(0, dimens, 0, dimens3);
            hVar.L(0, 0, 0, dimens2);
            hVar.zp(true);
            hVar.a(new h.e() { // from class: com.baidu.tieba.o.a.1
                @Override // com.baidu.tieba.view.h.e
                public void HJ(int i) {
                    if (a.this.mQr != null) {
                        a.this.mQr.dismiss();
                        a.this.mQr = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new ar("c13072").ap("obj_type", a.this.mScore));
                        a.this.L(tbPageContext);
                    }
                }
            });
            this.mQr = new e(tbPageContext.getContext(), hVar.bqR());
            this.mQr.ac(0.7f);
            g.a(this.mQr, tbPageContext);
            TiebaStatic.log(new ar("c13071"));
        }
    }

    public void L(final TbPageContext tbPageContext) {
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
            hVar.KW(this.mScore);
            hVar.KX(0);
            hVar.KY(0);
            hVar.zp(false);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds42);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds32);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds51);
            hVar.setTitlePadding(0, l.getDimens(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            hVar.L(0, dimens, 0, dimens);
            aVar.a(new h.c() { // from class: com.baidu.tieba.o.a.2
                @Override // com.baidu.tieba.view.h.c
                public void onClick() {
                    if (a.this.mQr != null) {
                        a.this.mQr.dismiss();
                        a.this.mQr = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.N(tbPageContext);
                            TiebaStatic.log(new ar("c13077"));
                            return;
                        }
                        a.this.O(tbPageContext);
                        TiebaStatic.log(new ar("c13074"));
                    }
                }
            });
            hVar.a(new h.b() { // from class: com.baidu.tieba.o.a.3
                @Override // com.baidu.tieba.view.h.b
                public void onClick() {
                    if (a.this.mQr != null) {
                        a.this.mQr.dismiss();
                        a.this.mQr = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new ar("c13078"));
                        } else {
                            TiebaStatic.log(new ar("c13075"));
                        }
                    }
                }
            });
            hVar.bw(arrayList);
            this.mQr = new e(tbPageContext.getContext(), hVar.bqR());
            this.mQr.ac(0.7f);
            g.a(this.mQr, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new ar("c13076"));
            } else {
                TiebaStatic.log(new ar("c13073"));
            }
        }
    }

    private void M(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.brQ().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.brQ().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.brQ().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    K(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            bf.bsV().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

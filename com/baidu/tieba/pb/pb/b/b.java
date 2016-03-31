package com.baidu.tieba.pb.pb.b;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.c.m;
import com.baidu.tbadk.core.c.n;
import com.baidu.tbadk.core.c.r;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private PbActivity dfA;
    private com.baidu.tieba.pb.pb.b.a dfB;
    private BaseWebView dfy;
    private m dfz;

    public b(PbActivity pbActivity) {
        com.baidu.tbadk.core.data.a aVar = (pbActivity == null || pbActivity.awj() == null || pbActivity.awj().getPbData() == null || !pbActivity.awj().getPbData().avA()) ? null : pbActivity.awj().getPbData().avv().tw().get(0);
        if (aVar != null) {
            this.dfA = pbActivity;
            this.dfy = new BaseWebView(pbActivity.getPageContext().getPageActivity());
            this.dfy.setOnFocusChangeListener(new c(this));
            this.dfy.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.dfy.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
            this.dfz = r.a(true, (WebView) this.dfy, (com.baidu.tbadk.core.c.a) new a(this, null));
            this.dfB = new com.baidu.tieba.pb.pb.b.a(this.dfz, aVar, pbActivity);
            com.baidu.tbadk.core.c.a.b bVar = new com.baidu.tbadk.core.c.a.b(this.dfz, pbActivity.getPageContext());
            this.dfz.a(this.dfB);
            this.dfz.a(bVar);
            this.dfy.loadUrl("file:///android_asset/senior_lottery.html");
            this.dfy.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avY() {
        try {
            this.dfz.a(n.a("TBHY_EXT_SeniorLotteryPB", "getInitPageData", this.dfB.avW(), 1000L, new d(this)));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public WebView avZ() {
        return this.dfy;
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.tbadk.core.c.a {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.c.a
        public void uM() {
        }

        @Override // com.baidu.tbadk.core.c.a
        public void uN() {
            b.this.avY();
        }
    }

    public void H(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(i));
        if (!StringUtils.isNULL(str)) {
            hashMap.put("award_id", str);
        }
        this.dfz.a(n.a("TBHY_EXT_SeniorLotteryPB", "drawLotteryResult", (Map<String, Object>) hashMap, 0L, false));
    }

    public void awa() {
        this.dfz.a(n.a("TBHY_EXT_SeniorLotteryPB", "drawLotteryRun", (Map<String, Object>) null, 0L, false));
    }
}

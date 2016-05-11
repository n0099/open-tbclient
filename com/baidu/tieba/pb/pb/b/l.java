package com.baidu.tieba.pb.pb.b;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.c.r;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private BaseWebView dia;
    private com.baidu.tbadk.core.c.m dib;
    private PbActivity dic;
    private k did;

    public l(PbActivity pbActivity) {
        com.baidu.tbadk.core.data.a aVar = (pbActivity == null || pbActivity.awu() == null || pbActivity.awu().getPbData() == null || !pbActivity.awu().getPbData().avG()) ? null : pbActivity.awu().getPbData().avB().qU().get(0);
        if (aVar != null) {
            this.dic = pbActivity;
            this.dia = new BaseWebView(pbActivity.getPageContext().getPageActivity());
            this.dia.setOnFocusChangeListener(new m(this));
            this.dia.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.dia.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
            this.dib = r.a(true, (WebView) this.dia, (com.baidu.tbadk.core.c.a) new a(this, null));
            this.did = new k(this.dib, aVar, pbActivity);
            com.baidu.tbadk.core.c.a.b bVar = new com.baidu.tbadk.core.c.a.b(this.dib, pbActivity.getPageContext());
            this.dib.a(this.did);
            this.dib.a(bVar);
            this.dia.loadUrl("file:///android_asset/senior_lottery.html");
            this.dia.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awo() {
        try {
            this.dib.a(com.baidu.tbadk.core.c.n.a("TBHY_EXT_SeniorLotteryPB", "getInitPageData", this.did.awm(), 1000L, new n(this)));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public WebView awp() {
        return this.dia;
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.tbadk.core.c.a {
        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.c.a
        public void sr() {
        }

        @Override // com.baidu.tbadk.core.c.a
        public void ss() {
            l.this.awo();
        }
    }

    public void G(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(i));
        if (!StringUtils.isNULL(str)) {
            hashMap.put("award_id", str);
        }
        this.dib.a(com.baidu.tbadk.core.c.n.a("TBHY_EXT_SeniorLotteryPB", "drawLotteryResult", (Map<String, Object>) hashMap, 0L, false));
    }

    public void awl() {
        this.dib.a(com.baidu.tbadk.core.c.n.a("TBHY_EXT_SeniorLotteryPB", "drawLotteryRun", (Map<String, Object>) null, 0L, false));
    }
}

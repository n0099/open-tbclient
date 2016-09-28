package com.baidu.tieba.write.vcode.newVcode.a;

import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class d implements c {
    private String czA;
    private String czB;
    private final com.baidu.tieba.tbadkCore.writeModel.b gbT;
    private final NewVcodeView gdX;
    private boolean geb = false;
    private String gec = null;
    private Runnable ged = new e(this);
    private final b.d avZ = new f(this);

    public d(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.gdX = newVcodeView;
        this.gbT = bVar;
        this.gbT.b(this.avZ);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.czA = com.baidu.tbadk.j.a.gF(str);
            if (this.czA != null && this.gbT.bfE() != null) {
                this.gdX.runJsMethod(this.czA, "'" + this.gbT.bfE().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gdX.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return kN(com.baidu.tbadk.j.a.gF(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.gdX != null) {
            this.gdX.showWebViewDelay(500);
            if (this.geb) {
                h.eG().postDelayed(this.ged, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void o(boolean z, String str) {
        this.geb = z;
        this.gec = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lN(boolean z) {
        this.gdX.setRatio(1.2631578f);
        this.gdX.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.gdX.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.eG().removeCallbacks(this.ged);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void brW() {
        this.gdX.showPostThreadLoadingView(false);
        this.gbT.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akW() {
        this.gdX.runJsMethod(this.czB, "'" + this.gbT.bfE().getVcodeUrl() + "'");
    }

    private boolean kN(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.czB = split[0];
        sz(split[1]);
        return true;
    }

    private void sz(String str) {
        if (!k.gD()) {
            this.gdX.getContext().showToast(r.j.neterror);
            this.gdX.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gdX.showPostThreadLoadingView(true);
            this.gbT.bfE().setVcode(str);
            this.gbT.bfE().setVcodeType("4");
            this.gbT.bkY();
        } else {
            this.gdX.getContext().showToast(r.j.neterror);
            this.gdX.getContext().finish();
        }
    }
}

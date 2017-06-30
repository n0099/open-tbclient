package com.baidu.tieba.tblauncher;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import java.net.URLDecoder;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements be.a {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.tbadk.core.util.be.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        Map<String, String> dV;
        if (strArr == null || strArr[0] == null) {
            return 3;
        }
        String lowerCase = strArr[0].toLowerCase();
        if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
            String str = "";
            String dW = be.dW(lowerCase);
            if (!StringUtils.isNull(dW) && (dV = be.dV(dW)) != null) {
                str = URLDecoder.decode(dV.get(VrPlayerActivityConfig.TITLE));
                if (!aw.isEmpty(str)) {
                    str = "#" + str + "#";
                }
            }
            if (XiaoyingUtil.showXiaoyingTool() && bl.aN(this.this$0.getBaseContext())) {
                com.baidu.tieba.write.q.b(tbPageContext, "", "", str);
            }
            return 1;
        }
        return 3;
    }
}

package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class LeftNaviScanMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public b dcr;
        public List<com.baidu.tieba.tblauncher.a.a> list;
    }

    /* loaded from: classes.dex */
    public interface b {
        void bw(List<com.baidu.tieba.tblauncher.a.a> list);
    }

    public LeftNaviScanMessage(a aVar) {
        super(CmdConfigCustom.CMD_LEFT_NAVI_SCAN, aVar);
    }
}

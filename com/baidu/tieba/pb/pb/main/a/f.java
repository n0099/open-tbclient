package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private TbPageContext GO;
    private View bL;
    private boolean eDn;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d Hu = null;
    int eDo = 0;
    private Runnable eDp = new g(this);
    private Runnable eDq = new i(this);

    public f(TbPageContext tbPageContext, View view) {
        this.GO = tbPageContext;
        this.bL = view;
    }

    public void aSI() {
        com.baidu.tbadk.core.sharedPref.b.um().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips", this.eDo + 1);
    }

    public void pI(String str) {
        if (!this.eDn && !StringUtils.isNull(str) && this.bL != null && this.bL.getVisibility() != 8) {
            this.mMessage = str;
            this.eDo = com.baidu.tbadk.core.sharedPref.b.um().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips", 0);
            if (this.eDo < 3) {
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.eDp, 1000L);
            }
        }
    }

    public void aSJ() {
        if (this.Hu != null) {
            this.Hu.dismiss();
            this.Hu = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eDp);
            this.mHandler.removeCallbacks(this.eDq);
        }
    }
}

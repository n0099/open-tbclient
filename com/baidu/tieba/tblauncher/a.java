package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class a {
    private l dHa;
    private Runnable fJQ = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mActivity != null && a.this.mAnchorView != null && a.this.gSD != null && a.this.gSD.getContentView() != null) {
                int f = com.baidu.adp.lib.util.l.f(a.this.mActivity, f.e.ds252);
                a.this.gSD.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(a.this.gSD, a.this.mAnchorView, (-(com.baidu.adp.lib.util.l.f(a.this.mActivity, f.e.ds430) - a.this.mAnchorView.getMeasuredWidth())) / 2, -f);
                com.baidu.adp.lib.g.e.in().postDelayed(a.this.fJR, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new an("c13016").r("obj_locate", 2));
            }
        }
    };
    private Runnable fJR = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bfi();
        }
    };
    private View.OnClickListener fJS = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bxU();
            if (a.this.dHa != null && a.this.dHa.gLG != null && a.this.dHa.aZg() != null) {
                if (a.this.gSE == null || a.this.gSE.axq()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(a.this.mActivity, 9, a.this.dHa.aZg().getId(), a.this.dHa.aZg().getName(), null, null, 0, a.this.dHa.ug(), 13003, false, false, null, false, false, null, null, a.this.dHa.aZg().getPrefixData(), 0);
                    if (!StringUtils.isNull(a.this.dHa.gLG.recom_topic)) {
                        writeActivityConfig.setTitle(a.this.dHa.gLG.recom_topic, true);
                    }
                    ForumData aZg = a.this.dHa.aZg();
                    writeActivityConfig.setForumDir(aZg.getFirst_class(), aZg.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").r("obj_locate", 2));
                }
            }
        }
    };
    private PopupWindow gSD;
    private com.baidu.tieba.frs.entelechy.b.d gSE;
    private Activity mActivity;
    private View mAnchorView;

    public a(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.gSE = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.gLG != null && this.mActivity != null) {
            this.dHa = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(f.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(f.g.tips)).setText(ap.f(lVar.gLG.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(f.g.tips_content)).setText(f.j.topic_join);
            inflate.setOnClickListener(this.fJS);
            this.gSD = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJQ);
            com.baidu.adp.lib.g.e.in().postDelayed(this.fJQ, 100L);
        }
    }

    public void bxU() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJQ);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJR);
        bfi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfi() {
        g.a(this.gSD);
    }
}

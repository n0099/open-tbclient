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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes6.dex */
public class a {
    private l dWh;
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mActivity != null && a.this.mAnchorView != null && a.this.hhI != null && a.this.hhI.getContentView() != null) {
                int h = com.baidu.adp.lib.util.l.h(a.this.mActivity, e.C0175e.ds252);
                a.this.hhI.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(a.this.hhI, a.this.mAnchorView, (-(com.baidu.adp.lib.util.l.h(a.this.mActivity, e.C0175e.ds430) - a.this.mAnchorView.getMeasuredWidth())) / 2, -h);
                com.baidu.adp.lib.g.e.jI().postDelayed(a.this.fYX, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 2));
            }
        }
    };
    private Runnable fYX = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bkY();
        }
    };
    private View.OnClickListener fYY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bDQ();
            if (a.this.dWh != null && a.this.dWh.haE != null && a.this.dWh.beT() != null) {
                if (a.this.hhJ == null || a.this.hhJ.aCX()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(a.this.mActivity, 9, a.this.dWh.beT().getId(), a.this.dWh.beT().getName(), null, null, 0, a.this.dWh.xs(), 13003, false, false, null, false, false, null, null, a.this.dWh.beT().getPrefixData(), 0);
                    if (!StringUtils.isNull(a.this.dWh.haE.recom_topic)) {
                        writeActivityConfig.setTitle(a.this.dWh.haE.recom_topic, true);
                    }
                    ForumData beT = a.this.dWh.beT();
                    writeActivityConfig.setForumDir(beT.getFirst_class(), beT.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").x("obj_locate", 2));
                }
            }
        }
    };
    private PopupWindow hhI;
    private com.baidu.tieba.frs.entelechy.b.d hhJ;
    private Activity mActivity;
    private View mAnchorView;

    public a(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.hhJ = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.haE != null && this.mActivity != null) {
            this.dWh = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.tips)).setText(ao.f(lVar.haE.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(e.g.tips_content)).setText(e.j.topic_join);
            inflate.setOnClickListener(this.fYY);
            this.hhI = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.fYW, 100L);
        }
    }

    public void bDQ() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYX);
        bkY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        g.a(this.hhI);
    }
}

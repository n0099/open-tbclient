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
/* loaded from: classes2.dex */
public class a {
    private l dOl;
    private Runnable fRv = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mActivity != null && a.this.mAnchorView != null && a.this.hap != null && a.this.hap.getContentView() != null) {
                int h = com.baidu.adp.lib.util.l.h(a.this.mActivity, e.C0141e.ds252);
                a.this.hap.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(a.this.hap, a.this.mAnchorView, (-(com.baidu.adp.lib.util.l.h(a.this.mActivity, e.C0141e.ds430) - a.this.mAnchorView.getMeasuredWidth())) / 2, -h);
                com.baidu.adp.lib.g.e.jt().postDelayed(a.this.fRw, 5000L);
                TiebaStatic.log(new am("c13016").w("obj_locate", 2));
            }
        }
    };
    private Runnable fRw = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bhM();
        }
    };
    private View.OnClickListener fRx = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bAC();
            if (a.this.dOl != null && a.this.dOl.gTi != null && a.this.dOl.bbH() != null) {
                if (a.this.haq == null || a.this.haq.azD()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(a.this.mActivity, 9, a.this.dOl.bbH().getId(), a.this.dOl.bbH().getName(), null, null, 0, a.this.dOl.vj(), 13003, false, false, null, false, false, null, null, a.this.dOl.bbH().getPrefixData(), 0);
                    if (!StringUtils.isNull(a.this.dOl.gTi.recom_topic)) {
                        writeActivityConfig.setTitle(a.this.dOl.gTi.recom_topic, true);
                    }
                    ForumData bbH = a.this.dOl.bbH();
                    writeActivityConfig.setForumDir(bbH.getFirst_class(), bbH.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").w("obj_locate", 2));
                }
            }
        }
    };
    private PopupWindow hap;
    private com.baidu.tieba.frs.entelechy.b.d haq;
    private Activity mActivity;
    private View mAnchorView;

    public a(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.haq = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.gTi != null && this.mActivity != null) {
            this.dOl = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.tips)).setText(ao.f(lVar.gTi.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(e.g.tips_content)).setText(e.j.topic_join);
            inflate.setOnClickListener(this.fRx);
            this.hap = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRv);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.fRv, 100L);
        }
    }

    public void bAC() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRv);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRw);
        bhM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhM() {
        g.a(this.hap);
    }
}

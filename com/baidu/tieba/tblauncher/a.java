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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class a {
    private l dqO;
    private Runnable ftn = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mActivity != null && a.this.mAnchorView != null && a.this.gAD != null && a.this.gAD.getContentView() != null) {
                int e = com.baidu.adp.lib.util.l.e(a.this.mActivity, d.e.ds252);
                a.this.gAD.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(a.this.gAD, a.this.mAnchorView, (-(com.baidu.adp.lib.util.l.e(a.this.mActivity, d.e.ds430) - a.this.mAnchorView.getMeasuredWidth())) / 2, -e);
                com.baidu.adp.lib.g.e.fw().postDelayed(a.this.fto, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new al("c13016").r("obj_locate", 2));
            }
        }
    };
    private Runnable fto = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bbn();
        }
    };
    private View.OnClickListener ftp = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            a.this.btE();
            if (a.this.dqO != null && a.this.dqO.guo != null && a.this.dqO.aVq() != null) {
                if (a.this.gAE == null || a.this.gAE.ase()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(a.this.mActivity, 9, a.this.dqO.aVq().getId(), a.this.dqO.aVq().getName(), null, null, 0, a.this.dqO.qT(), 13003, false, false, null, false, false, null, null, a.this.dqO.aVq().getPrefixData(), 0);
                    if (!StringUtils.isNull(a.this.dqO.guo.recom_topic)) {
                        writeActivityConfig.setTitle(a.this.dqO.guo.recom_topic, true);
                    }
                    ForumData aVq = a.this.dqO.aVq();
                    writeActivityConfig.setForumDir(aVq.getFirst_class(), aVq.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new al("c13017").r("obj_locate", 2));
                }
            }
        }
    };
    private PopupWindow gAD;
    private com.baidu.tieba.frs.entelechy.b.d gAE;
    private Activity mActivity;
    private View mAnchorView;

    public a(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.gAE = dVar;
    }

    public void b(View view2, l lVar) {
        if (view2 != null && lVar != null && lVar.guo != null && this.mActivity != null) {
            this.dqO = lVar;
            this.mAnchorView = view2;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tips)).setText(an.g(lVar.guo.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(d.g.tips_content)).setText(d.k.topic_join);
            inflate.setOnClickListener(this.ftp);
            this.gAD = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.ftn);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.ftn, 100L);
        }
    }

    public void btE() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.ftn);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fto);
        bbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbn() {
        g.a(this.gAD);
    }
}

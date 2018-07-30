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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class a {
    private l dHe;
    private Runnable fJX = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mActivity != null && a.this.mAnchorView != null && a.this.gSC != null && a.this.gSC.getContentView() != null) {
                int f = com.baidu.adp.lib.util.l.f(a.this.mActivity, d.e.ds252);
                a.this.gSC.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(a.this.gSC, a.this.mAnchorView, (-(com.baidu.adp.lib.util.l.f(a.this.mActivity, d.e.ds430) - a.this.mAnchorView.getMeasuredWidth())) / 2, -f);
                com.baidu.adp.lib.g.e.in().postDelayed(a.this.fJY, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new an("c13016").r("obj_locate", 2));
            }
        }
    };
    private Runnable fJY = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bfn();
        }
    };
    private View.OnClickListener fJZ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bxT();
            if (a.this.dHe != null && a.this.dHe.gLE != null && a.this.dHe.aZl() != null) {
                if (a.this.gSD == null || a.this.gSD.axr()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(a.this.mActivity, 9, a.this.dHe.aZl().getId(), a.this.dHe.aZl().getName(), null, null, 0, a.this.dHe.uh(), 13003, false, false, null, false, false, null, null, a.this.dHe.aZl().getPrefixData(), 0);
                    if (!StringUtils.isNull(a.this.dHe.gLE.recom_topic)) {
                        writeActivityConfig.setTitle(a.this.dHe.gLE.recom_topic, true);
                    }
                    ForumData aZl = a.this.dHe.aZl();
                    writeActivityConfig.setForumDir(aZl.getFirst_class(), aZl.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").r("obj_locate", 2));
                }
            }
        }
    };
    private PopupWindow gSC;
    private com.baidu.tieba.frs.entelechy.b.d gSD;
    private Activity mActivity;
    private View mAnchorView;

    public a(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.gSD = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.gLE != null && this.mActivity != null) {
            this.dHe = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tips)).setText(ap.g(lVar.gLE.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(d.g.tips_content)).setText(d.j.topic_join);
            inflate.setOnClickListener(this.fJZ);
            this.gSC = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJX);
            com.baidu.adp.lib.g.e.in().postDelayed(this.fJX, 100L);
        }
    }

    public void bxT() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJX);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJY);
        bfn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfn() {
        g.a(this.gSC);
    }
}

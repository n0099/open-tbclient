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
    private l dEs;
    private Runnable fJJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mActivity != null && a.this.mAnchorView != null && a.this.gRE != null && a.this.gRE.getContentView() != null) {
                int e = com.baidu.adp.lib.util.l.e(a.this.mActivity, d.e.ds252);
                a.this.gRE.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(a.this.gRE, a.this.mAnchorView, (-(com.baidu.adp.lib.util.l.e(a.this.mActivity, d.e.ds430) - a.this.mAnchorView.getMeasuredWidth())) / 2, -e);
                com.baidu.adp.lib.g.e.im().postDelayed(a.this.fJK, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new an("c13016").r("obj_locate", 2));
            }
        }
    };
    private Runnable fJK = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bgU();
        }
    };
    private View.OnClickListener fJL = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bzq();
            if (a.this.dEs != null && a.this.dEs.gKH != null && a.this.dEs.baT() != null) {
                if (a.this.gRF == null || a.this.gRF.awM()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(a.this.mActivity, 9, a.this.dEs.baT().getId(), a.this.dEs.baT().getName(), null, null, 0, a.this.dEs.uu(), 13003, false, false, null, false, false, null, null, a.this.dEs.baT().getPrefixData(), 0);
                    if (!StringUtils.isNull(a.this.dEs.gKH.recom_topic)) {
                        writeActivityConfig.setTitle(a.this.dEs.gKH.recom_topic, true);
                    }
                    ForumData baT = a.this.dEs.baT();
                    writeActivityConfig.setForumDir(baT.getFirst_class(), baT.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").r("obj_locate", 2));
                }
            }
        }
    };
    private PopupWindow gRE;
    private com.baidu.tieba.frs.entelechy.b.d gRF;
    private Activity mActivity;
    private View mAnchorView;

    public a(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.gRF = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.gKH != null && this.mActivity != null) {
            this.dEs = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tips)).setText(ap.g(lVar.gKH.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(d.g.tips_content)).setText(d.k.topic_join);
            inflate.setOnClickListener(this.fJL);
            this.gRE = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fJJ);
            com.baidu.adp.lib.g.e.im().postDelayed(this.fJJ, 100L);
        }
    }

    public void bzq() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fJJ);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fJK);
        bgU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgU() {
        g.a(this.gRE);
    }
}

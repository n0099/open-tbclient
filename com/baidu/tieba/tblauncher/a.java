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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class a {
    private l dBg;
    private Runnable fFI = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mActivity != null && a.this.mAnchorView != null && a.this.gNe != null && a.this.gNe.getContentView() != null) {
                int e = com.baidu.adp.lib.util.l.e(a.this.mActivity, d.e.ds252);
                a.this.gNe.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(a.this.gNe, a.this.mAnchorView, (-(com.baidu.adp.lib.util.l.e(a.this.mActivity, d.e.ds430) - a.this.mAnchorView.getMeasuredWidth())) / 2, -e);
                com.baidu.adp.lib.g.e.im().postDelayed(a.this.fFJ, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new am("c13016").r("obj_locate", 2));
            }
        }
    };
    private Runnable fFJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bgm();
        }
    };
    private View.OnClickListener fFK = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.byH();
            if (a.this.dBg != null && a.this.dBg.gGM != null && a.this.dBg.bam() != null) {
                if (a.this.gNf == null || a.this.gNf.awi()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(a.this.mActivity, 9, a.this.dBg.bam().getId(), a.this.dBg.bam().getName(), null, null, 0, a.this.dBg.uo(), 13003, false, false, null, false, false, null, null, a.this.dBg.bam().getPrefixData(), 0);
                    if (!StringUtils.isNull(a.this.dBg.gGM.recom_topic)) {
                        writeActivityConfig.setTitle(a.this.dBg.gGM.recom_topic, true);
                    }
                    ForumData bam = a.this.dBg.bam();
                    writeActivityConfig.setForumDir(bam.getFirst_class(), bam.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").r("obj_locate", 2));
                }
            }
        }
    };
    private PopupWindow gNe;
    private com.baidu.tieba.frs.entelechy.b.d gNf;
    private Activity mActivity;
    private View mAnchorView;

    public a(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.gNf = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.gGM != null && this.mActivity != null) {
            this.dBg = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tips)).setText(ao.g(lVar.gGM.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(d.g.tips_content)).setText(d.k.topic_join);
            inflate.setOnClickListener(this.fFK);
            this.gNe = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fFI);
            com.baidu.adp.lib.g.e.im().postDelayed(this.fFI, 100L);
        }
    }

    public void byH() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fFI);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fFJ);
        bgm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgm() {
        g.a(this.gNe);
    }
}

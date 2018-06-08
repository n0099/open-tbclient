package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private FragmentTabHost aoi;
    private TextView dXF;
    private Runnable fFI = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aoi != null && d.this.gNe != null && d.this.gNe.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.aoi.getFragmentTabWidget();
                int ah = l.ah(d.this.gNS.getActivity());
                int e = l.e(d.this.gNS.getActivity(), d.e.ds252);
                d.this.gNe.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.gNe, fragmentTabWidget, (ah - l.e(d.this.gNS.getActivity(), d.e.ds430)) / 2, -e);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.gNT);
                com.baidu.adp.lib.g.e.im().postDelayed(d.this.fFJ, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new am("c13016").r("obj_locate", 1));
            }
        }
    };
    private Runnable fFJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bgm();
        }
    };
    private View.OnClickListener fFK = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.byH();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.gNS, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").r("obj_locate", 1));
        }
    };
    private MainTabActivity gNS;
    private long gNT;
    private View gNU;
    private TextView gNV;
    private PopupWindow gNe;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.gNS = mainTabActivity;
        this.aoi = (FragmentTabHost) this.gNS.findViewById(d.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gNT = j;
            if (this.gNU == null) {
                this.gNU = LayoutInflater.from(this.gNS.getActivity()).inflate(d.i.tips_blue_twice_line_down, (ViewGroup) null);
                this.dXF = (TextView) this.gNU.findViewById(d.g.tips);
                this.gNV = (TextView) this.gNU.findViewById(d.g.tips_content);
                this.gNU.setOnClickListener(this.fFK);
            }
            this.dXF.setText(ao.g(str, 24, "..."));
            this.gNV.setText(d.k.topic_join);
            if (this.gNe == null) {
                this.gNe = new PopupWindow(this.gNU, -2, -2);
                this.gNe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.gNS.getActivity()));
                    }
                });
            } else {
                byH();
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fFI);
            com.baidu.adp.lib.g.e.im().postDelayed(this.fFI, 100L);
        }
    }

    public void byH() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fFI);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fFJ);
        bgm();
    }

    public void bgm() {
        g.a(this.gNe);
    }

    public void onDestroy() {
        byH();
    }
}

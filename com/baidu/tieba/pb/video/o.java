package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class o extends j.a {
    private TbPageContext abm;
    public TextView cBM;
    public View cdB;
    public TbImageView eTM;
    public ImageView eTN;
    public TextView eTO;
    public TextView eTP;
    public TextView eTQ;
    public View eTR;
    public View eTS;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.abm = tbPageContext;
            this.eTM = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.eTN = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.eTM.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.eTM.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.eTO = (TextView) view.findViewById(d.h.video_title_view);
            this.eTP = (TextView) view.findViewById(d.h.channel_name_view);
            this.cBM = (TextView) view.findViewById(d.h.video_play_count_view);
            this.eTQ = (TextView) view.findViewById(d.h.video_duration_view);
            this.eTR = view.findViewById(d.h.divider_view);
            this.eTS = view.findViewById(d.h.top_divider_view);
            this.cdB = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.eTM.c(kVar.eTH, 10, false);
            this.eTO.setText(kVar.eTI);
            if (kVar.videoDuration <= 0) {
                this.eTQ.setText("");
            } else {
                this.eTQ.setText(am.cX(kVar.videoDuration * 1000));
            }
            this.cBM.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), am.u(kVar.cuv)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.eTP.setText(am.f(kVar.channelName, 14, "..."));
                this.eTP.setVisibility(0);
                this.eTN.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.VK)) {
                    this.eTP.setText(am.f(kVar.VK, 14, "..."));
                    this.eTP.setVisibility(0);
                } else {
                    this.eTP.setVisibility(8);
                }
                this.eTN.setVisibility(8);
            }
            if (kVar.eTJ) {
                this.eTR.setVisibility(0);
            } else {
                this.eTR.setVisibility(8);
            }
            if (kVar.eTK) {
                this.eTS.setVisibility(0);
            } else {
                this.eTS.setVisibility(8);
            }
            if (kVar.cBn) {
                this.cdB.setVisibility(0);
            } else {
                this.cdB.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.ps(kVar.threadId);
                        ak akVar = new ak("c11927");
                        akVar.r("obj_locate", kVar.position);
                        akVar.ac("tid", kVar.threadId);
                        akVar.f("fid", kVar.forumId);
                        akVar.ac("obj_param1", kVar.eTG);
                        akVar.ac("obj_param2", "1");
                        akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                        akVar.ac("obj_name", kVar.eTE);
                        akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eTF);
                        akVar.f("obj_id", kVar.channelId);
                        TiebaStatic.log(akVar);
                    }
                }
            });
            As();
            a(kVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ps(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.abm.getPageActivity()).createNormalCfg(str, null, null)));
        this.abm.getPageActivity().finish();
    }

    public void As() {
        this.abm.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abm.getLayoutMode().t(this.rootView);
        aj.j(this.eTN, d.g.icon_weiba);
    }

    private void a(k kVar, ArrayList<String> arrayList) {
        boolean z;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<String> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    String next = it.next();
                    if (next != null && currentAccount.endsWith(next)) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                ak akVar = new ak("c11960");
                akVar.r("obj_locate", kVar.position);
                akVar.ac("tid", kVar.threadId);
                akVar.f("fid", kVar.forumId);
                akVar.ac("obj_param1", kVar.eTG);
                akVar.ac("obj_param2", "1");
                akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                akVar.ac("obj_name", kVar.eTE);
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eTF);
                akVar.f("obj_id", kVar.channelId);
                TiebaStatic.log(akVar);
            }
        }
    }

    private void a(k kVar, int i) {
        ArrayList<String> pQ;
        if (kVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pQ = null;
            } else {
                pQ = pQ(i);
            }
            a(kVar, pQ);
        }
    }

    private ArrayList<String> pQ(int i) {
        if (i <= 0) {
            return null;
        }
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add("" + random.nextInt(10));
        }
        return arrayList;
    }
}

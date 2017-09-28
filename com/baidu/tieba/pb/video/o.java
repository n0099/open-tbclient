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
    private TbPageContext abz;
    public TextView cBY;
    public View cdN;
    public TbImageView eUa;
    public ImageView eUb;
    public TextView eUc;
    public TextView eUd;
    public TextView eUe;
    public View eUf;
    public View eUg;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.abz = tbPageContext;
            this.eUa = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.eUb = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.eUa.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.eUa.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.eUc = (TextView) view.findViewById(d.h.video_title_view);
            this.eUd = (TextView) view.findViewById(d.h.channel_name_view);
            this.cBY = (TextView) view.findViewById(d.h.video_play_count_view);
            this.eUe = (TextView) view.findViewById(d.h.video_duration_view);
            this.eUf = view.findViewById(d.h.divider_view);
            this.eUg = view.findViewById(d.h.top_divider_view);
            this.cdN = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.eUa.c(kVar.eTV, 10, false);
            this.eUc.setText(kVar.eTW);
            if (kVar.videoDuration <= 0) {
                this.eUe.setText("");
            } else {
                this.eUe.setText(am.cY(kVar.videoDuration * 1000));
            }
            this.cBY.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), am.t(kVar.cuH)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.eUd.setText(am.f(kVar.channelName, 14, "..."));
                this.eUd.setVisibility(0);
                this.eUb.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.VW)) {
                    this.eUd.setText(am.f(kVar.VW, 14, "..."));
                    this.eUd.setVisibility(0);
                } else {
                    this.eUd.setVisibility(8);
                }
                this.eUb.setVisibility(8);
            }
            if (kVar.eTX) {
                this.eUf.setVisibility(0);
            } else {
                this.eUf.setVisibility(8);
            }
            if (kVar.eTY) {
                this.eUg.setVisibility(0);
            } else {
                this.eUg.setVisibility(8);
            }
            if (kVar.cBz) {
                this.cdN.setVisibility(0);
            } else {
                this.cdN.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.pt(kVar.threadId);
                        ak akVar = new ak("c11927");
                        akVar.r("obj_locate", kVar.position);
                        akVar.ad("tid", kVar.threadId);
                        akVar.f("fid", kVar.forumId);
                        akVar.ad("obj_param1", kVar.eTU);
                        akVar.ad("obj_param2", "1");
                        akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                        akVar.ad("obj_name", kVar.eTS);
                        akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eTT);
                        akVar.f("obj_id", kVar.channelId);
                        TiebaStatic.log(akVar);
                    }
                }
            });
            Ay();
            a(kVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.abz.getPageActivity()).createNormalCfg(str, null, null)));
        this.abz.getPageActivity().finish();
    }

    public void Ay() {
        this.abz.getLayoutMode().ai(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abz.getLayoutMode().t(this.rootView);
        aj.j(this.eUb, d.g.icon_weiba);
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
                akVar.ad("tid", kVar.threadId);
                akVar.f("fid", kVar.forumId);
                akVar.ad("obj_param1", kVar.eTU);
                akVar.ad("obj_param2", "1");
                akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                akVar.ad("obj_name", kVar.eTS);
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eTT);
                akVar.f("obj_id", kVar.channelId);
                TiebaStatic.log(akVar);
            }
        }
    }

    private void a(k kVar, int i) {
        ArrayList<String> pR;
        if (kVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pR = null;
            } else {
                pR = pR(i);
            }
            a(kVar, pR);
        }
    }

    private ArrayList<String> pR(int i) {
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

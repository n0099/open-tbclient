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
    private TbPageContext aby;
    public TextView cBf;
    public View cdM;
    public TbImageView eZR;
    public ImageView eZS;
    public TextView eZT;
    public TextView eZU;
    public TextView eZV;
    public View eZW;
    public View eZX;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aby = tbPageContext;
            this.eZR = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.eZS = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.eZR.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.eZR.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.eZT = (TextView) view.findViewById(d.h.video_title_view);
            this.eZU = (TextView) view.findViewById(d.h.channel_name_view);
            this.cBf = (TextView) view.findViewById(d.h.video_play_count_view);
            this.eZV = (TextView) view.findViewById(d.h.video_duration_view);
            this.eZW = view.findViewById(d.h.divider_view);
            this.eZX = view.findViewById(d.h.top_divider_view);
            this.cdM = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.eZR.c(kVar.eZM, 10, false);
            this.eZT.setText(kVar.eZN);
            if (kVar.videoDuration <= 0) {
                this.eZV.setText("");
            } else {
                this.eZV.setText(am.da(kVar.videoDuration * 1000));
            }
            this.cBf.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), am.u(kVar.cud)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.eZU.setText(am.f(kVar.channelName, 14, "..."));
                this.eZU.setVisibility(0);
                this.eZS.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.VI)) {
                    this.eZU.setText(am.f(kVar.VI, 14, "..."));
                    this.eZU.setVisibility(0);
                } else {
                    this.eZU.setVisibility(8);
                }
                this.eZS.setVisibility(8);
            }
            if (kVar.eZO) {
                this.eZW.setVisibility(0);
            } else {
                this.eZW.setVisibility(8);
            }
            if (kVar.eZP) {
                this.eZX.setVisibility(0);
            } else {
                this.eZX.setVisibility(8);
            }
            if (kVar.cAG) {
                this.cdM.setVisibility(0);
            } else {
                this.cdM.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.pK(kVar.threadId);
                        ak akVar = new ak("c11927");
                        akVar.r("obj_locate", kVar.position);
                        akVar.ad("tid", kVar.threadId);
                        akVar.f("fid", kVar.forumId);
                        akVar.ad("obj_param1", kVar.eZL);
                        akVar.ad("obj_param2", "1");
                        akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                        akVar.ad("obj_name", kVar.eZJ);
                        akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eZK);
                        akVar.f("obj_id", kVar.channelId);
                        TiebaStatic.log(akVar);
                    }
                }
            });
            Ba();
            a(kVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aby.getPageActivity()).createNormalCfg(str, null, null)));
        this.aby.getPageActivity().finish();
    }

    public void Ba() {
        this.aby.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aby.getLayoutMode().t(this.rootView);
        aj.j(this.eZS, d.g.icon_weiba);
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
                akVar.ad("obj_param1", kVar.eZL);
                akVar.ad("obj_param2", "1");
                akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                akVar.ad("obj_name", kVar.eZJ);
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eZK);
                akVar.f("obj_id", kVar.channelId);
                TiebaStatic.log(akVar);
            }
        }
    }

    private void a(k kVar, int i) {
        ArrayList<String> pW;
        if (kVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pW = null;
            } else {
                pW = pW(i);
            }
            a(kVar, pW);
        }
    }

    private ArrayList<String> pW(int i) {
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

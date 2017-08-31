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
    public TextView cAn;
    public View ccU;
    public TbImageView eYX;
    public ImageView eYY;
    public TextView eYZ;
    public TextView eZa;
    public TextView eZb;
    public View eZc;
    public View eZd;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aby = tbPageContext;
            this.eYX = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.eYY = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.eYX.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.eYX.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.eYZ = (TextView) view.findViewById(d.h.video_title_view);
            this.eZa = (TextView) view.findViewById(d.h.channel_name_view);
            this.cAn = (TextView) view.findViewById(d.h.video_play_count_view);
            this.eZb = (TextView) view.findViewById(d.h.video_duration_view);
            this.eZc = view.findViewById(d.h.divider_view);
            this.eZd = view.findViewById(d.h.top_divider_view);
            this.ccU = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.eYX.c(kVar.eYS, 10, false);
            this.eYZ.setText(kVar.eYT);
            if (kVar.videoDuration <= 0) {
                this.eZb.setText("");
            } else {
                this.eZb.setText(am.da(kVar.videoDuration * 1000));
            }
            this.cAn.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), am.u(kVar.ctk)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.eZa.setText(am.f(kVar.channelName, 14, "..."));
                this.eZa.setVisibility(0);
                this.eYY.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.VI)) {
                    this.eZa.setText(am.f(kVar.VI, 14, "..."));
                    this.eZa.setVisibility(0);
                } else {
                    this.eZa.setVisibility(8);
                }
                this.eYY.setVisibility(8);
            }
            if (kVar.eYU) {
                this.eZc.setVisibility(0);
            } else {
                this.eZc.setVisibility(8);
            }
            if (kVar.eYV) {
                this.eZd.setVisibility(0);
            } else {
                this.eZd.setVisibility(8);
            }
            if (kVar.czO) {
                this.ccU.setVisibility(0);
            } else {
                this.ccU.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.pI(kVar.threadId);
                        ak akVar = new ak("c11927");
                        akVar.r("obj_locate", kVar.position);
                        akVar.ad("tid", kVar.threadId);
                        akVar.f("fid", kVar.forumId);
                        akVar.ad("obj_param1", kVar.eYR);
                        akVar.ad("obj_param2", "1");
                        akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                        akVar.ad("obj_name", kVar.eYP);
                        akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eYQ);
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
    public void pI(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aby.getPageActivity()).createNormalCfg(str, null, null)));
        this.aby.getPageActivity().finish();
    }

    public void Ba() {
        this.aby.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aby.getLayoutMode().t(this.rootView);
        aj.j(this.eYY, d.g.icon_weiba);
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
                akVar.ad("obj_param1", kVar.eYR);
                akVar.ad("obj_param2", "1");
                akVar.f("obj_param3", System.currentTimeMillis() / 1000);
                akVar.ad("obj_name", kVar.eYP);
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eYQ);
                akVar.f("obj_id", kVar.channelId);
                TiebaStatic.log(akVar);
            }
        }
    }

    private void a(k kVar, int i) {
        ArrayList<String> pU;
        if (kVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pU = null;
            } else {
                pU = pU(i);
            }
            a(kVar, pU);
        }
    }

    private ArrayList<String> pU(int i) {
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

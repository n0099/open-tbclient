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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class o extends j.a {
    private TbPageContext acp;
    public View bZn;
    public TextView ctd;
    public View eYA;
    public TbImageView eYu;
    public ImageView eYv;
    public TextView eYw;
    public TextView eYx;
    public TextView eYy;
    public View eYz;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.acp = tbPageContext;
            this.eYu = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.eYv = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.eYu.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.eYu.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.eYw = (TextView) view.findViewById(d.h.video_title_view);
            this.eYx = (TextView) view.findViewById(d.h.channel_name_view);
            this.ctd = (TextView) view.findViewById(d.h.video_play_count_view);
            this.eYy = (TextView) view.findViewById(d.h.video_duration_view);
            this.eYz = view.findViewById(d.h.divider_view);
            this.eYA = view.findViewById(d.h.top_divider_view);
            this.bZn = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.eYu.c(kVar.eYo, 10, false);
            this.eYw.setText(kVar.eYp);
            if (kVar.videoDuration <= 0) {
                this.eYy.setText("");
            } else {
                this.eYy.setText(al.cZ(kVar.videoDuration * 1000));
            }
            this.ctd.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), al.u(kVar.eYq)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.eYx.setText(al.e(kVar.channelName, 14, "..."));
                this.eYx.setVisibility(0);
                this.eYv.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.Wx)) {
                    this.eYx.setText(al.e(kVar.Wx, 14, "..."));
                    this.eYx.setVisibility(0);
                } else {
                    this.eYx.setVisibility(8);
                }
                this.eYv.setVisibility(8);
            }
            if (kVar.eYr) {
                this.eYz.setVisibility(0);
            } else {
                this.eYz.setVisibility(8);
            }
            if (kVar.eYs) {
                this.eYA.setVisibility(0);
            } else {
                this.eYA.setVisibility(8);
            }
            if (kVar.csE) {
                this.bZn.setVisibility(0);
            } else {
                this.bZn.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.pO(kVar.threadId);
                        aj ajVar = new aj("c11927");
                        ajVar.r("obj_locate", kVar.position);
                        ajVar.aa("tid", kVar.threadId);
                        ajVar.g("fid", kVar.forumId);
                        ajVar.aa("obj_param1", kVar.eYn);
                        ajVar.aa("obj_param2", "1");
                        ajVar.g("obj_param3", System.currentTimeMillis() / 1000);
                        ajVar.aa("obj_name", kVar.eYl);
                        ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eYm);
                        ajVar.g("obj_id", kVar.channelId);
                        TiebaStatic.log(ajVar);
                    }
                }
            });
            Bf();
            a(kVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pO(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.acp.getPageActivity()).createNormalCfg(str, null, null)));
        this.acp.getPageActivity().finish();
    }

    public void Bf() {
        this.acp.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acp.getLayoutMode().t(this.rootView);
        ai.j(this.eYv, d.g.icon_weiba);
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
                aj ajVar = new aj("c11960");
                ajVar.r("obj_locate", kVar.position);
                ajVar.aa("tid", kVar.threadId);
                ajVar.g("fid", kVar.forumId);
                ajVar.aa("obj_param1", kVar.eYn);
                ajVar.aa("obj_param2", "1");
                ajVar.g("obj_param3", System.currentTimeMillis() / 1000);
                ajVar.aa("obj_name", kVar.eYl);
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eYm);
                ajVar.g("obj_id", kVar.channelId);
                TiebaStatic.log(ajVar);
            }
        }
    }

    private void a(k kVar, int i) {
        ArrayList<String> pK;
        if (kVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pK = null;
            } else {
                pK = pK(i);
            }
            a(kVar, pK);
        }
    }

    private ArrayList<String> pK(int i) {
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

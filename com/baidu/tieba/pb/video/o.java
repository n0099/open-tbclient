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
    private TbPageContext aaS;
    public View bYh;
    public TextView crS;
    public TbImageView eXi;
    public ImageView eXj;
    public TextView eXk;
    public TextView eXl;
    public TextView eXm;
    public View eXn;
    public View eXo;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aaS = tbPageContext;
            this.eXi = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.eXj = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.eXi.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.eXi.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.eXk = (TextView) view.findViewById(d.h.video_title_view);
            this.eXl = (TextView) view.findViewById(d.h.channel_name_view);
            this.crS = (TextView) view.findViewById(d.h.video_play_count_view);
            this.eXm = (TextView) view.findViewById(d.h.video_duration_view);
            this.eXn = view.findViewById(d.h.divider_view);
            this.eXo = view.findViewById(d.h.top_divider_view);
            this.bYh = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.eXi.c(kVar.eXc, 10, false);
            this.eXk.setText(kVar.eXd);
            if (kVar.videoDuration <= 0) {
                this.eXm.setText("");
            } else {
                this.eXm.setText(al.cX(kVar.videoDuration * 1000));
            }
            this.crS.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), al.u(kVar.eXe)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.eXl.setText(al.e(kVar.channelName, 14, "..."));
                this.eXl.setVisibility(0);
                this.eXj.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.Vb)) {
                    this.eXl.setText(al.e(kVar.Vb, 14, "..."));
                    this.eXl.setVisibility(0);
                } else {
                    this.eXl.setVisibility(8);
                }
                this.eXj.setVisibility(8);
            }
            if (kVar.eXf) {
                this.eXn.setVisibility(0);
            } else {
                this.eXn.setVisibility(8);
            }
            if (kVar.eXg) {
                this.eXo.setVisibility(0);
            } else {
                this.eXo.setVisibility(8);
            }
            if (kVar.crt) {
                this.bYh.setVisibility(0);
            } else {
                this.bYh.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.pJ(kVar.threadId);
                        aj ajVar = new aj("c11927");
                        ajVar.r("obj_locate", kVar.position);
                        ajVar.aa("tid", kVar.threadId);
                        ajVar.f("fid", kVar.forumId);
                        ajVar.aa("obj_param1", kVar.eXb);
                        ajVar.aa("obj_param2", "1");
                        ajVar.f("obj_param3", System.currentTimeMillis() / 1000);
                        ajVar.aa("obj_name", kVar.eWZ);
                        ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eXa);
                        ajVar.f("obj_id", kVar.channelId);
                        TiebaStatic.log(ajVar);
                    }
                }
            });
            AX();
            a(kVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aaS.getPageActivity()).createNormalCfg(str, null, null)));
        this.aaS.getPageActivity().finish();
    }

    public void AX() {
        this.aaS.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aaS.getLayoutMode().t(this.rootView);
        ai.j(this.eXj, d.g.icon_weiba);
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
                ajVar.f("fid", kVar.forumId);
                ajVar.aa("obj_param1", kVar.eXb);
                ajVar.aa("obj_param2", "1");
                ajVar.f("obj_param3", System.currentTimeMillis() / 1000);
                ajVar.aa("obj_name", kVar.eWZ);
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.eXa);
                ajVar.f("obj_id", kVar.channelId);
                TiebaStatic.log(ajVar);
            }
        }
    }

    private void a(k kVar, int i) {
        ArrayList<String> pL;
        if (kVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pL = null;
            } else {
                pL = pL(i);
            }
            a(kVar, pL);
        }
    }

    private ArrayList<String> pL(int i) {
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

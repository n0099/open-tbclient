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
    private TbPageContext acr;
    public View bZZ;
    public TextView ctK;
    public TbImageView fan;
    public ImageView fao;
    public TextView fap;
    public TextView faq;
    public TextView far;
    public View fas;
    public View fat;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.acr = tbPageContext;
            this.fan = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.fao = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.fan.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.fan.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.fap = (TextView) view.findViewById(d.h.video_title_view);
            this.faq = (TextView) view.findViewById(d.h.channel_name_view);
            this.ctK = (TextView) view.findViewById(d.h.video_play_count_view);
            this.far = (TextView) view.findViewById(d.h.video_duration_view);
            this.fas = view.findViewById(d.h.divider_view);
            this.fat = view.findViewById(d.h.top_divider_view);
            this.bZZ = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.fan.c(kVar.fah, 10, false);
            this.fap.setText(kVar.fai);
            if (kVar.videoDuration <= 0) {
                this.far.setText("");
            } else {
                this.far.setText(al.cZ(kVar.videoDuration * 1000));
            }
            this.ctK.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), al.u(kVar.faj)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.faq.setText(al.e(kVar.channelName, 14, "..."));
                this.faq.setVisibility(0);
                this.fao.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.Wz)) {
                    this.faq.setText(al.e(kVar.Wz, 14, "..."));
                    this.faq.setVisibility(0);
                } else {
                    this.faq.setVisibility(8);
                }
                this.fao.setVisibility(8);
            }
            if (kVar.fak) {
                this.fas.setVisibility(0);
            } else {
                this.fas.setVisibility(8);
            }
            if (kVar.fal) {
                this.fat.setVisibility(0);
            } else {
                this.fat.setVisibility(8);
            }
            if (kVar.ctl) {
                this.bZZ.setVisibility(0);
            } else {
                this.bZZ.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.pQ(kVar.threadId);
                        aj ajVar = new aj("c11927");
                        ajVar.r("obj_locate", kVar.position);
                        ajVar.aa("tid", kVar.threadId);
                        ajVar.g("fid", kVar.forumId);
                        ajVar.aa("obj_param1", kVar.fag);
                        ajVar.aa("obj_param2", "1");
                        ajVar.g("obj_param3", System.currentTimeMillis() / 1000);
                        ajVar.aa("obj_name", kVar.fae);
                        ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.faf);
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
    public void pQ(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.acr.getPageActivity()).createNormalCfg(str, null, null)));
        this.acr.getPageActivity().finish();
    }

    public void Bf() {
        this.acr.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acr.getLayoutMode().t(this.rootView);
        ai.j(this.fao, d.g.icon_weiba);
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
                ajVar.aa("obj_param1", kVar.fag);
                ajVar.aa("obj_param2", "1");
                ajVar.g("obj_param3", System.currentTimeMillis() / 1000);
                ajVar.aa("obj_name", kVar.fae);
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.faf);
                ajVar.g("obj_id", kVar.channelId);
                TiebaStatic.log(ajVar);
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

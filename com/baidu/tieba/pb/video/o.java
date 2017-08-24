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
    public View caa;
    public TextView ctK;
    public TbImageView fap;
    public ImageView faq;
    public TextView far;
    public TextView fas;
    public TextView fat;
    public View fau;
    public View fav;
    public View rootView;

    public o(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.acr = tbPageContext;
            this.fap = (TbImageView) view.findViewById(d.h.video_thumbnail_view);
            this.faq = (ImageView) view.findViewById(d.h.channel_icon_view);
            this.fap.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.fap.setDefaultErrorResource(d.g.pic_bg_video_frs);
            this.far = (TextView) view.findViewById(d.h.video_title_view);
            this.fas = (TextView) view.findViewById(d.h.channel_name_view);
            this.ctK = (TextView) view.findViewById(d.h.video_play_count_view);
            this.fat = (TextView) view.findViewById(d.h.video_duration_view);
            this.fau = view.findViewById(d.h.divider_view);
            this.fav = view.findViewById(d.h.top_divider_view);
            this.caa = view.findViewById(d.h.top_divider_line);
        }
    }

    public void a(final k kVar) {
        if (kVar != null) {
            this.fap.c(kVar.faj, 10, false);
            this.far.setText(kVar.fak);
            if (kVar.videoDuration <= 0) {
                this.fat.setText("");
            } else {
                this.fat.setText(al.cZ(kVar.videoDuration * 1000));
            }
            this.ctK.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.video_play_count), al.u(kVar.fal)));
            if (!StringUtils.isNull(kVar.channelName)) {
                this.fas.setText(al.f(kVar.channelName, 14, "..."));
                this.fas.setVisibility(0);
                this.faq.setVisibility(0);
            } else {
                if (!StringUtils.isNull(kVar.WA)) {
                    this.fas.setText(al.f(kVar.WA, 14, "..."));
                    this.fas.setVisibility(0);
                } else {
                    this.fas.setVisibility(8);
                }
                this.faq.setVisibility(8);
            }
            if (kVar.fam) {
                this.fau.setVisibility(0);
            } else {
                this.fau.setVisibility(8);
            }
            if (kVar.fan) {
                this.fav.setVisibility(0);
            } else {
                this.fav.setVisibility(8);
            }
            if (kVar.ctl) {
                this.caa.setVisibility(0);
            } else {
                this.caa.setVisibility(8);
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.o.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kVar != null) {
                        o.this.pV(kVar.threadId);
                        aj ajVar = new aj("c11927");
                        ajVar.r("obj_locate", kVar.position);
                        ajVar.aa("tid", kVar.threadId);
                        ajVar.g("fid", kVar.forumId);
                        ajVar.aa("obj_param1", kVar.fai);
                        ajVar.aa("obj_param2", "1");
                        ajVar.g("obj_param3", System.currentTimeMillis() / 1000);
                        ajVar.aa("obj_name", kVar.fag);
                        ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.fah);
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
    public void pV(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.acr.getPageActivity()).createNormalCfg(str, null, null)));
        this.acr.getPageActivity().finish();
    }

    public void Bf() {
        this.acr.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acr.getLayoutMode().t(this.rootView);
        ai.j(this.faq, d.g.icon_weiba);
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
                ajVar.aa("obj_param1", kVar.fai);
                ajVar.aa("obj_param2", "1");
                ajVar.g("obj_param3", System.currentTimeMillis() / 1000);
                ajVar.aa("obj_name", kVar.fag);
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, kVar.fah);
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

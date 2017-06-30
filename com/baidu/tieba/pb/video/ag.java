package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class ag extends z.a {
    private TbPageContext aat;
    public View bTT;
    public TextView clR;
    public TbImageView eKH;
    public ImageView eKI;
    public TextView eKJ;
    public TextView eKK;
    public TextView eKL;
    public View eKM;
    public View eKN;
    public View rootView;

    public ag(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aat = tbPageContext;
            this.eKH = (TbImageView) view.findViewById(w.h.video_thumbnail_view);
            this.eKI = (ImageView) view.findViewById(w.h.channel_icon_view);
            this.eKH.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.eKH.setDefaultErrorResource(w.g.pic_bg_video_frs);
            this.eKJ = (TextView) view.findViewById(w.h.video_title_view);
            this.eKK = (TextView) view.findViewById(w.h.channel_name_view);
            this.clR = (TextView) view.findViewById(w.h.video_play_count_view);
            this.eKL = (TextView) view.findViewById(w.h.video_duration_view);
            this.eKM = view.findViewById(w.h.divider_view);
            this.eKN = view.findViewById(w.h.top_divider_view);
            this.bTT = view.findViewById(w.h.top_divider_line);
        }
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.eKH.c(acVar.eKB, 10, false);
            this.eKJ.setText(acVar.eKC);
            if (acVar.videoDuration <= 0) {
                this.eKL.setText("");
            } else {
                this.eKL.setText(aw.cV(acVar.videoDuration * 1000));
            }
            this.clR.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.video_play_count), aw.t(acVar.eKD)));
            if (!StringUtils.isNull(acVar.channelName)) {
                this.eKK.setText(aw.e(acVar.channelName, 14, "..."));
                this.eKK.setVisibility(0);
                this.eKI.setVisibility(0);
            } else {
                if (!StringUtils.isNull(acVar.UK)) {
                    this.eKK.setText(aw.e(acVar.UK, 14, "..."));
                    this.eKK.setVisibility(0);
                } else {
                    this.eKK.setVisibility(8);
                }
                this.eKI.setVisibility(8);
            }
            if (acVar.eKE) {
                this.eKM.setVisibility(0);
            } else {
                this.eKM.setVisibility(8);
            }
            if (acVar.eKF) {
                this.eKN.setVisibility(0);
            } else {
                this.eKN.setVisibility(8);
            }
            if (acVar.cls) {
                this.bTT.setVisibility(0);
            } else {
                this.bTT.setVisibility(8);
            }
            this.rootView.setOnClickListener(new ah(this, acVar));
            AM();
            a(acVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aat.getPageActivity()).createNormalCfg(str, null, null)));
        this.aat.getPageActivity().finish();
    }

    public void AM() {
        this.aat.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aat.getLayoutMode().t(this.rootView);
        as.j(this.eKI, w.g.icon_weiba);
    }

    private void a(ac acVar, ArrayList<String> arrayList) {
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
                au auVar = new au("c11960");
                auVar.r("obj_locate", acVar.position);
                auVar.Z("tid", acVar.threadId);
                auVar.f("fid", acVar.forumId);
                auVar.Z("obj_param1", acVar.eKA);
                auVar.Z("obj_param2", "1");
                auVar.f("obj_param3", System.currentTimeMillis() / 1000);
                auVar.Z("obj_name", acVar.eKy);
                auVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, acVar.eKz);
                auVar.f("obj_id", acVar.channelId);
                TiebaStatic.log(auVar);
            }
        }
    }

    private void a(ac acVar, int i) {
        ArrayList<String> pv;
        if (acVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pv = null;
            } else {
                pv = pv(i);
            }
            a(acVar, pv);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0018: INVOKE  (r4v1 int A[REMOVE]) = (r2v0 java.util.Random), (10 int) type: VIRTUAL call: java.util.Random.nextInt(int):int)] */
    private ArrayList<String> pv(int i) {
        if (i <= 0) {
            return null;
        }
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new StringBuilder().append(random.nextInt(10)).toString());
        }
        return arrayList;
    }
}

package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class w extends y.a {
    private TbPageContext aaX;
    public View bKE;
    public TextView bXp;
    public TbImageView evm;
    public ImageView evn;
    public TextView evo;
    public TextView evp;
    public TextView evq;
    public View evr;
    public View evs;
    public View rootView;

    public w(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aaX = tbPageContext;
            this.evm = (TbImageView) view.findViewById(w.h.video_thumbnail_view);
            this.evn = (ImageView) view.findViewById(w.h.channel_icon_view);
            this.evm.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.evm.setDefaultErrorResource(w.g.pic_bg_video_frs);
            this.evo = (TextView) view.findViewById(w.h.video_title_view);
            this.evp = (TextView) view.findViewById(w.h.channel_name_view);
            this.bXp = (TextView) view.findViewById(w.h.video_play_count_view);
            this.evq = (TextView) view.findViewById(w.h.video_duration_view);
            this.evr = view.findViewById(w.h.divider_view);
            this.evs = view.findViewById(w.h.top_divider_view);
            this.bKE = view.findViewById(w.h.top_divider_line);
        }
    }

    public void a(s sVar) {
        if (sVar != null) {
            this.evm.c(sVar.evg, 10, false);
            this.evo.setText(sVar.evh);
            if (sVar.videoDuration <= 0) {
                this.evq.setText("");
            } else {
                this.evq.setText(au.cW(sVar.videoDuration * 1000));
            }
            this.bXp.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.video_play_count), au.t(sVar.evi)));
            if (!StringUtils.isNull(sVar.channelName)) {
                this.evp.setText(au.e(sVar.channelName, 14, "..."));
                this.evp.setVisibility(0);
                this.evn.setVisibility(0);
            } else {
                if (!StringUtils.isNull(sVar.VE)) {
                    this.evp.setText(au.e(sVar.VE, 14, "..."));
                    this.evp.setVisibility(0);
                } else {
                    this.evp.setVisibility(8);
                }
                this.evn.setVisibility(8);
            }
            if (sVar.evj) {
                this.evr.setVisibility(0);
            } else {
                this.evr.setVisibility(8);
            }
            if (sVar.evk) {
                this.evs.setVisibility(0);
            } else {
                this.evs.setVisibility(8);
            }
            if (sVar.bWQ) {
                this.bKE.setVisibility(0);
            } else {
                this.bKE.setVisibility(8);
            }
            this.rootView.setOnClickListener(new x(this, sVar));
            Bn();
            a(sVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nT(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aaX.getPageActivity()).createNormalCfg(str, null, null)));
        this.aaX.getPageActivity().finish();
    }

    public void Bn() {
        this.aaX.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaX.getLayoutMode().t(this.rootView);
        aq.j(this.evn, w.g.icon_weiba);
    }

    private void a(s sVar, ArrayList<String> arrayList) {
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
                as asVar = new as("c11960");
                asVar.s("obj_locate", sVar.position);
                asVar.aa("tid", sVar.threadId);
                asVar.g("fid", sVar.forumId);
                asVar.aa("obj_param1", sVar.evf);
                asVar.aa("obj_param2", "1");
                asVar.g("obj_param3", System.currentTimeMillis() / 1000);
                asVar.aa("obj_name", sVar.evd);
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, sVar.eve);
                asVar.g("obj_id", sVar.channelId);
                TiebaStatic.log(asVar);
            }
        }
    }

    private void a(s sVar, int i) {
        ArrayList<String> oH;
        if (sVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                oH = null;
            } else {
                oH = oH(i);
            }
            a(sVar, oH);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0018: INVOKE  (r4v1 int A[REMOVE]) = (r2v0 java.util.Random), (10 int) type: VIRTUAL call: java.util.Random.nextInt(int):int)] */
    private ArrayList<String> oH(int i) {
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

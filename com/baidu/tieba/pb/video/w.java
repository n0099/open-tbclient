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
    private TbPageContext aaI;
    public View bKL;
    public TextView bXA;
    public TbImageView exg;
    public ImageView exh;
    public TextView exi;
    public TextView exj;
    public TextView exk;
    public View exl;
    public View exm;
    public View rootView;

    public w(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aaI = tbPageContext;
            this.exg = (TbImageView) view.findViewById(w.h.video_thumbnail_view);
            this.exh = (ImageView) view.findViewById(w.h.channel_icon_view);
            this.exg.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.exg.setDefaultErrorResource(w.g.pic_bg_video_frs);
            this.exi = (TextView) view.findViewById(w.h.video_title_view);
            this.exj = (TextView) view.findViewById(w.h.channel_name_view);
            this.bXA = (TextView) view.findViewById(w.h.video_play_count_view);
            this.exk = (TextView) view.findViewById(w.h.video_duration_view);
            this.exl = view.findViewById(w.h.divider_view);
            this.exm = view.findViewById(w.h.top_divider_view);
            this.bKL = view.findViewById(w.h.top_divider_line);
        }
    }

    public void a(s sVar) {
        if (sVar != null) {
            this.exg.c(sVar.exa, 10, false);
            this.exi.setText(sVar.exb);
            if (sVar.videoDuration <= 0) {
                this.exk.setText("");
            } else {
                this.exk.setText(au.cT(sVar.videoDuration * 1000));
            }
            this.bXA.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.video_play_count), au.t(sVar.exc)));
            if (!StringUtils.isNull(sVar.channelName)) {
                this.exj.setText(au.e(sVar.channelName, 14, "..."));
                this.exj.setVisibility(0);
                this.exh.setVisibility(0);
            } else {
                if (!StringUtils.isNull(sVar.Vm)) {
                    this.exj.setText(au.e(sVar.Vm, 14, "..."));
                    this.exj.setVisibility(0);
                } else {
                    this.exj.setVisibility(8);
                }
                this.exh.setVisibility(8);
            }
            if (sVar.exd) {
                this.exl.setVisibility(0);
            } else {
                this.exl.setVisibility(8);
            }
            if (sVar.exe) {
                this.exm.setVisibility(0);
            } else {
                this.exm.setVisibility(8);
            }
            if (sVar.bXb) {
                this.bKL.setVisibility(0);
            } else {
                this.bKL.setVisibility(8);
            }
            this.rootView.setOnClickListener(new x(this, sVar));
            AO();
            a(sVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aaI.getPageActivity()).createNormalCfg(str, null, null)));
        this.aaI.getPageActivity().finish();
    }

    public void AO() {
        this.aaI.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaI.getLayoutMode().t(this.rootView);
        aq.j(this.exh, w.g.icon_weiba);
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
                asVar.Z("tid", sVar.threadId);
                asVar.g("fid", sVar.forumId);
                asVar.Z("obj_param1", sVar.ewZ);
                asVar.Z("obj_param2", "1");
                asVar.g("obj_param3", System.currentTimeMillis() / 1000);
                asVar.Z("obj_name", sVar.ewX);
                asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, sVar.ewY);
                asVar.g("obj_id", sVar.channelId);
                TiebaStatic.log(asVar);
            }
        }
    }

    private void a(s sVar, int i) {
        ArrayList<String> oJ;
        if (sVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                oJ = null;
            } else {
                oJ = oJ(i);
            }
            a(sVar, oJ);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0018: INVOKE  (r4v1 int A[REMOVE]) = (r2v0 java.util.Random), (10 int) type: VIRTUAL call: java.util.Random.nextInt(int):int)] */
    private ArrayList<String> oJ(int i) {
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

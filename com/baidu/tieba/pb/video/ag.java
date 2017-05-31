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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class ag extends z.a {
    private TbPageContext aas;
    public View bRM;
    public TextView cdF;
    public TbImageView eBj;
    public ImageView eBk;
    public TextView eBl;
    public TextView eBm;
    public TextView eBn;
    public View eBo;
    public View eBp;
    public View rootView;

    public ag(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aas = tbPageContext;
            this.eBj = (TbImageView) view.findViewById(w.h.video_thumbnail_view);
            this.eBk = (ImageView) view.findViewById(w.h.channel_icon_view);
            this.eBj.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.eBj.setDefaultErrorResource(w.g.pic_bg_video_frs);
            this.eBl = (TextView) view.findViewById(w.h.video_title_view);
            this.eBm = (TextView) view.findViewById(w.h.channel_name_view);
            this.cdF = (TextView) view.findViewById(w.h.video_play_count_view);
            this.eBn = (TextView) view.findViewById(w.h.video_duration_view);
            this.eBo = view.findViewById(w.h.divider_view);
            this.eBp = view.findViewById(w.h.top_divider_view);
            this.bRM = view.findViewById(w.h.top_divider_line);
        }
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.eBj.c(acVar.eBd, 10, false);
            this.eBl.setText(acVar.eBe);
            if (acVar.videoDuration <= 0) {
                this.eBn.setText("");
            } else {
                this.eBn.setText(au.cT(acVar.videoDuration * 1000));
            }
            this.cdF.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.video_play_count), au.t(acVar.eBf)));
            if (!StringUtils.isNull(acVar.channelName)) {
                this.eBm.setText(au.e(acVar.channelName, 14, "..."));
                this.eBm.setVisibility(0);
                this.eBk.setVisibility(0);
            } else {
                if (!StringUtils.isNull(acVar.UL)) {
                    this.eBm.setText(au.e(acVar.UL, 14, "..."));
                    this.eBm.setVisibility(0);
                } else {
                    this.eBm.setVisibility(8);
                }
                this.eBk.setVisibility(8);
            }
            if (acVar.eBg) {
                this.eBo.setVisibility(0);
            } else {
                this.eBo.setVisibility(8);
            }
            if (acVar.eBh) {
                this.eBp.setVisibility(0);
            } else {
                this.eBp.setVisibility(8);
            }
            if (acVar.cdg) {
                this.bRM.setVisibility(0);
            } else {
                this.bRM.setVisibility(8);
            }
            this.rootView.setOnClickListener(new ah(this, acVar));
            Ar();
            a(acVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aas.getPageActivity()).createNormalCfg(str, null, null)));
        this.aas.getPageActivity().finish();
    }

    public void Ar() {
        this.aas.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aas.getLayoutMode().t(this.rootView);
        aq.j(this.eBk, w.g.icon_weiba);
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
                as asVar = new as("c11960");
                asVar.r("obj_locate", acVar.position);
                asVar.Z("tid", acVar.threadId);
                asVar.f("fid", acVar.forumId);
                asVar.Z("obj_param1", acVar.eBc);
                asVar.Z("obj_param2", "1");
                asVar.f("obj_param3", System.currentTimeMillis() / 1000);
                asVar.Z("obj_name", acVar.eBa);
                asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, acVar.eBb);
                asVar.f("obj_id", acVar.channelId);
                TiebaStatic.log(asVar);
            }
        }
    }

    private void a(ac acVar, int i) {
        ArrayList<String> pc;
        if (acVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                pc = null;
            } else {
                pc = pc(i);
            }
            a(acVar, pc);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0018: INVOKE  (r4v1 int A[REMOVE]) = (r2v0 java.util.Random), (10 int) type: VIRTUAL call: java.util.Random.nextInt(int):int)] */
    private ArrayList<String> pc(int i) {
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

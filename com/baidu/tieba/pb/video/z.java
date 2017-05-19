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
public class z extends y.a {
    private TbPageContext aat;
    public View bLZ;
    public TextView bXG;
    public TbImageView etn;
    public ImageView eto;
    public TextView etp;
    public TextView etq;
    public TextView etr;
    public View ets;
    public View ett;
    public View rootView;

    public z(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.aat = tbPageContext;
            this.etn = (TbImageView) view.findViewById(w.h.video_thumbnail_view);
            this.eto = (ImageView) view.findViewById(w.h.channel_icon_view);
            this.etn.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.etn.setDefaultErrorResource(w.g.pic_bg_video_frs);
            this.etp = (TextView) view.findViewById(w.h.video_title_view);
            this.etq = (TextView) view.findViewById(w.h.channel_name_view);
            this.bXG = (TextView) view.findViewById(w.h.video_play_count_view);
            this.etr = (TextView) view.findViewById(w.h.video_duration_view);
            this.ets = view.findViewById(w.h.divider_view);
            this.ett = view.findViewById(w.h.top_divider_view);
            this.bLZ = view.findViewById(w.h.top_divider_line);
        }
    }

    public void a(v vVar) {
        if (vVar != null) {
            this.etn.c(vVar.eth, 10, false);
            this.etp.setText(vVar.eti);
            if (vVar.videoDuration <= 0) {
                this.etr.setText("");
            } else {
                this.etr.setText(au.cS(vVar.videoDuration * 1000));
            }
            this.bXG.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.video_play_count), au.t(vVar.etj)));
            if (!StringUtils.isNull(vVar.channelName)) {
                this.etq.setText(au.e(vVar.channelName, 14, "..."));
                this.etq.setVisibility(0);
                this.eto.setVisibility(0);
            } else {
                if (!StringUtils.isNull(vVar.UZ)) {
                    this.etq.setText(au.e(vVar.UZ, 14, "..."));
                    this.etq.setVisibility(0);
                } else {
                    this.etq.setVisibility(8);
                }
                this.eto.setVisibility(8);
            }
            if (vVar.etk) {
                this.ets.setVisibility(0);
            } else {
                this.ets.setVisibility(8);
            }
            if (vVar.etl) {
                this.ett.setVisibility(0);
            } else {
                this.ett.setVisibility(8);
            }
            if (vVar.bXh) {
                this.bLZ.setVisibility(0);
            } else {
                this.bLZ.setVisibility(8);
            }
            this.rootView.setOnClickListener(new aa(this, vVar));
            Ay();
            a(vVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aat.getPageActivity()).createNormalCfg(str, null, null)));
        this.aat.getPageActivity().finish();
    }

    public void Ay() {
        this.aat.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aat.getLayoutMode().t(this.rootView);
        aq.j(this.eto, w.g.icon_weiba);
    }

    private void a(v vVar, ArrayList<String> arrayList) {
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
                asVar.s("obj_locate", vVar.position);
                asVar.aa("tid", vVar.threadId);
                asVar.g("fid", vVar.forumId);
                asVar.aa("obj_param1", vVar.etg);
                asVar.aa("obj_param2", "1");
                asVar.g("obj_param3", System.currentTimeMillis() / 1000);
                asVar.aa("obj_name", vVar.ete);
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, vVar.etf);
                asVar.g("obj_id", vVar.channelId);
                TiebaStatic.log(asVar);
            }
        }
    }

    private void a(v vVar, int i) {
        ArrayList<String> oD;
        if (vVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                oD = null;
            } else {
                oD = oD(i);
            }
            a(vVar, oD);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0018: INVOKE  (r4v1 int A[REMOVE]) = (r2v0 java.util.Random), (10 int) type: VIRTUAL call: java.util.Random.nextInt(int):int)] */
    private ArrayList<String> oD(int i) {
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

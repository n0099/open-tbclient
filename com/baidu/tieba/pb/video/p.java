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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class p extends y.a {
    private TbPageContext Fp;
    public View bDE;
    public TextView bQs;
    public TbImageView etL;
    public ImageView etM;
    public TextView etN;
    public TextView etO;
    public TextView etP;
    public View etQ;
    public View etR;
    public View rootView;

    public p(TbPageContext tbPageContext, View view) {
        super(view);
        if (tbPageContext != null && view != null) {
            this.rootView = view;
            this.Fp = tbPageContext;
            this.etL = (TbImageView) view.findViewById(r.h.video_thumbnail_view);
            this.etM = (ImageView) view.findViewById(r.h.channel_icon_view);
            this.etL.setDefaultBgResource(r.g.pic_bg_video_frs);
            this.etL.setDefaultErrorResource(r.g.pic_bg_video_frs);
            this.etN = (TextView) view.findViewById(r.h.video_title_view);
            this.etO = (TextView) view.findViewById(r.h.channel_name_view);
            this.bQs = (TextView) view.findViewById(r.h.video_play_count_view);
            this.etP = (TextView) view.findViewById(r.h.video_duration_view);
            this.etQ = view.findViewById(r.h.divider_view);
            this.etR = view.findViewById(r.h.top_divider_view);
            this.bDE = view.findViewById(r.h.top_divider_line);
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.etL.c(lVar.etF, 10, false);
            this.etN.setText(lVar.etG);
            if (lVar.videoDuration <= 0) {
                this.etP.setText("");
            } else {
                this.etP.setText(at.cX(lVar.videoDuration * 1000));
            }
            this.bQs.setText(String.format(TbadkCoreApplication.m9getInst().getString(r.l.video_play_count), at.u(lVar.etH)));
            if (!StringUtils.isNull(lVar.channelName)) {
                this.etO.setText(at.e(lVar.channelName, 14, "..."));
                this.etO.setVisibility(0);
                this.etM.setVisibility(0);
            } else {
                if (!StringUtils.isNull(lVar.PZ)) {
                    this.etO.setText(at.e(lVar.PZ, 14, "..."));
                    this.etO.setVisibility(0);
                } else {
                    this.etO.setVisibility(8);
                }
                this.etM.setVisibility(8);
            }
            if (lVar.etI) {
                this.etQ.setVisibility(0);
            } else {
                this.etQ.setVisibility(8);
            }
            if (lVar.etJ) {
                this.etR.setVisibility(0);
            } else {
                this.etR.setVisibility(8);
            }
            if (lVar.bPT) {
                this.bDE.setVisibility(0);
            } else {
                this.bDE.setVisibility(8);
            }
            this.rootView.setOnClickListener(new q(this, lVar));
            lJ();
            a(lVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Fp.getPageActivity()).createNormalCfg(str, null, null)));
    }

    public void lJ() {
        this.Fp.getLayoutMode().v(this.rootView);
    }

    private void a(l lVar, ArrayList<String> arrayList) {
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
                ar arVar = new ar("c11960");
                arVar.s("obj_locate", lVar.position);
                arVar.ab("tid", lVar.threadId);
                arVar.g("fid", lVar.forumId);
                arVar.ab("obj_param1", lVar.etE);
                arVar.ab("obj_param2", "1");
                arVar.g("obj_param3", System.currentTimeMillis() / 1000);
                arVar.ab("obj_name", lVar.etC);
                arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.etD);
                arVar.g("obj_id", lVar.channelId);
                TiebaStatic.log(arVar);
            }
        }
    }

    private void a(l lVar, int i) {
        ArrayList<String> oN;
        if (lVar != null && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            if (i < 1 || i > 10) {
                i = 1;
            }
            if (i == 10) {
                oN = null;
            } else {
                oN = oN(i);
            }
            a(lVar, oN);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0018: INVOKE  (r4v1 int A[REMOVE]) = (r2v0 java.util.Random), (10 int) type: VIRTUAL call: java.util.Random.nextInt(int):int)] */
    private ArrayList<String> oN(int i) {
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

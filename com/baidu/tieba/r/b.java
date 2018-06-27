package com.baidu.tieba.r;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private com.baidu.tieba.r.a gFg;
    private LinearLayout gZx;
    private CustomMessageListener gZy = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.r.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int z = w.z(b.this.mForumList);
                if (z > 0) {
                    b.this.ghG = b.this.mForumList.subList(0, Math.min(6, z));
                }
                b.this.updateView();
            }
        }
    };
    private List<TransmitForumData> ghG;
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gZy);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int z = w.z(arrayList);
        if (z > 0) {
            this.ghG = arrayList.subList(0, Math.min(6, z));
        }
    }

    public void setShareItemClickListener(com.baidu.tieba.r.a aVar) {
        this.gFg = aVar;
    }

    public View getView() {
        if (this.gZx == null) {
            this.gZx = new LinearLayout(this.mContext);
            this.gZx.setOrientation(0);
            int e = l.e(this.mContext, d.e.ds18);
            this.gZx.setPadding(e, l.e(this.mContext, d.e.ds32), e, l.e(this.mContext, d.e.ds26));
            bBa();
            bBb();
            bBc();
        }
        return this.gZx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.gZx != null) {
            this.gZx.removeAllViews();
            bBa();
            bBb();
            bBc();
        }
    }

    private void bBa() {
        a bBd = bBd();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bBd.aWc.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bBd.bvD.setText(d.k.my_homepage);
        bBd.gZA.setTag(100);
        bBd.gZA.setOnClickListener(this);
        this.gZx.addView(bBd.gZA);
    }

    private void bBb() {
        int z = w.z(this.ghG);
        for (int i = 0; i < z; i++) {
            TransmitForumData transmitForumData = this.ghG.get(i);
            if (transmitForumData != null) {
                a bBd = bBd();
                bBd.aWc.startLoad(transmitForumData.avatar, 10, false);
                bBd.bvD.setText(transmitForumData.forumName);
                bBd.gZA.setTag(transmitForumData);
                bBd.gZA.setOnClickListener(this);
                this.gZx.addView(bBd.gZA);
            }
        }
    }

    private void bBc() {
        a bBd = bBd();
        am.c(bBd.aWc, d.f.icon_share_more_ba);
        am.j(bBd.aWc, d.C0142d.cp_bg_line_d);
        bBd.bvD.setText(d.k.more_forums);
        bBd.gZA.setTag(200);
        bBd.gZA.setOnClickListener(this);
        this.gZx.addView(bBd.gZA);
    }

    private a bBd() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.share_dialog_forum_item, (ViewGroup) this.gZx, false);
        a aVar = new a();
        aVar.gZA = viewGroup;
        aVar.aWc = (TbImageView) viewGroup.findViewById(d.g.photo);
        aVar.bvD = (TextView) viewGroup.findViewById(d.g.name);
        am.h(aVar.bvD, d.C0142d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gFg != null) {
            this.gFg.bx(view);
        }
        if (!j.jD()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                uv(11);
            } else if (num.intValue() == 200) {
                bBe();
                uv(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            uv(12);
        }
    }

    private void uv(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new an("c10125").ah(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ah("tid", this.mShareItem.tid).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aGh).r("obj_param1", this.mShareItem.aGi));
        }
    }

    private void bBe() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, 25018);
        selectForumActivityConfig.setForumList(this.mForumList);
        selectForumActivityConfig.setFrom(2);
        selectForumActivityConfig.setOriginalThread(this.mShareItem.originalThreadInfo);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
    }

    private void a(String str, TransmitForumData transmitForumData, int i) {
        String str2;
        String str3;
        if (transmitForumData != null) {
            str3 = String.valueOf(transmitForumData.forumId);
            str2 = transmitForumData.forumName;
        } else {
            str2 = null;
            str3 = null;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mContext, 9, str3, str2, null, null, 13011, null, null, null, this.mShareItem.originalThreadInfo);
        transmitPostEditActivityConfig.setCallFrom(str);
        transmitPostEditActivityConfig.setPrivateThread(i);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.gZy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView aWc;
        public TextView bvD;
        public ViewGroup gZA;

        private a() {
        }
    }
}

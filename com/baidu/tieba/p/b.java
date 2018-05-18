package com.baidu.tieba.p;

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private List<TransmitForumData> fSt;
    private LinearLayout gJQ;
    private CustomMessageListener gJR = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.p.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int v = v.v(b.this.mForumList);
                if (v > 0) {
                    b.this.fSt = b.this.mForumList.subList(0, Math.min(6, v));
                }
                b.this.updateView();
            }
        }
    };
    private com.baidu.tieba.p.a gpP;
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gJR);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int v = v.v(arrayList);
        if (v > 0) {
            this.fSt = arrayList.subList(0, Math.min(6, v));
        }
    }

    public void setShareItemClickListener(com.baidu.tieba.p.a aVar) {
        this.gpP = aVar;
    }

    public View getView() {
        if (this.gJQ == null) {
            this.gJQ = new LinearLayout(this.mContext);
            this.gJQ.setOrientation(0);
            int e = l.e(this.mContext, d.e.ds18);
            this.gJQ.setPadding(e, l.e(this.mContext, d.e.ds32), e, l.e(this.mContext, d.e.ds26));
            bvt();
            bvu();
            bvv();
        }
        return this.gJQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.gJQ != null) {
            this.gJQ.removeAllViews();
            bvt();
            bvu();
            bvv();
        }
    }

    private void bvt() {
        a bvw = bvw();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bvw.aNj.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bvw.bmc.setText(d.k.my_homepage);
        bvw.gJT.setTag(100);
        bvw.gJT.setOnClickListener(this);
        this.gJQ.addView(bvw.gJT);
    }

    private void bvu() {
        int v = v.v(this.fSt);
        for (int i = 0; i < v; i++) {
            TransmitForumData transmitForumData = this.fSt.get(i);
            if (transmitForumData != null) {
                a bvw = bvw();
                bvw.aNj.startLoad(transmitForumData.avatar, 10, false);
                bvw.bmc.setText(transmitForumData.forumName);
                bvw.gJT.setTag(transmitForumData);
                bvw.gJT.setOnClickListener(this);
                this.gJQ.addView(bvw.gJT);
            }
        }
    }

    private void bvv() {
        a bvw = bvw();
        ak.c(bvw.aNj, d.f.icon_share_more_ba);
        ak.j(bvw.aNj, d.C0126d.cp_bg_line_d);
        bvw.bmc.setText(d.k.more_forums);
        bvw.gJT.setTag(200);
        bvw.gJT.setOnClickListener(this);
        this.gJQ.addView(bvw.gJT);
    }

    private a bvw() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.share_dialog_forum_item, (ViewGroup) this.gJQ, false);
        a aVar = new a();
        aVar.gJT = viewGroup;
        aVar.aNj = (TbImageView) viewGroup.findViewById(d.g.photo);
        aVar.bmc = (TextView) viewGroup.findViewById(d.g.name);
        ak.h(aVar.bmc, d.C0126d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.gpP != null) {
            this.gpP.bt(view2);
        }
        if (!j.gP()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
            return;
        }
        Object tag = view2.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                ub(11);
            } else if (num.intValue() == 200) {
                bvx();
                ub(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            ub(12);
        }
    }

    private void ub(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new al("c10125").ac(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ac("tid", this.mShareItem.tid).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.axb).r("obj_param1", this.mShareItem.axc));
        }
    }

    private void bvx() {
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
        MessageManager.getInstance().unRegisterListener(this.gJR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView aNj;
        public TextView bmc;
        public ViewGroup gJT;

        private a() {
        }
    }
}

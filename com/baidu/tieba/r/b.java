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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private List<TransmitForumData> gig;
    private CustomMessageListener haA = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.r.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int y = w.y(b.this.mForumList);
                if (y > 0) {
                    b.this.gig = b.this.mForumList.subList(0, Math.min(6, y));
                }
                b.this.updateView();
            }
        }
    };
    private LinearLayout hay;
    private com.baidu.tieba.r.a haz;
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.haA);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int y = w.y(arrayList);
        if (y > 0) {
            this.gig = arrayList.subList(0, Math.min(6, y));
        }
    }

    public void a(com.baidu.tieba.r.a aVar) {
        this.haz = aVar;
    }

    public View getView() {
        if (this.hay == null) {
            this.hay = new LinearLayout(this.mContext);
            this.hay.setOrientation(0);
            int f = l.f(this.mContext, f.e.ds18);
            this.hay.setPadding(f, l.f(this.mContext, f.e.ds32), f, l.f(this.mContext, f.e.ds26));
            bzE();
            bzF();
            bzG();
        }
        return this.hay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.hay != null) {
            this.hay.removeAllViews();
            bzE();
            bzF();
            bzG();
        }
    }

    private void bzE() {
        a bzH = bzH();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bzH.aWe.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bzH.bwl.setText(f.j.my_homepage);
        bzH.haC.setTag(100);
        bzH.haC.setOnClickListener(this);
        this.hay.addView(bzH.haC);
    }

    private void bzF() {
        int y = w.y(this.gig);
        for (int i = 0; i < y; i++) {
            TransmitForumData transmitForumData = this.gig.get(i);
            if (transmitForumData != null) {
                a bzH = bzH();
                bzH.aWe.startLoad(transmitForumData.avatar, 10, false);
                bzH.bwl.setText(transmitForumData.forumName);
                bzH.haC.setTag(transmitForumData);
                bzH.haC.setOnClickListener(this);
                this.hay.addView(bzH.haC);
            }
        }
    }

    private void bzG() {
        a bzH = bzH();
        am.c(bzH.aWe, f.C0146f.icon_share_more_ba);
        am.j(bzH.aWe, f.d.cp_bg_line_d);
        bzH.bwl.setText(f.j.more_forums);
        bzH.haC.setTag(200);
        bzH.haC.setOnClickListener(this);
        this.hay.addView(bzH.haC);
    }

    private a bzH() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(f.h.share_dialog_forum_item, (ViewGroup) this.hay, false);
        a aVar = new a();
        aVar.haC = viewGroup;
        aVar.aWe = (TbImageView) viewGroup.findViewById(f.g.photo);
        aVar.bwl = (TextView) viewGroup.findViewById(f.g.name);
        am.h(aVar.bwl, f.d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.haz != null) {
            this.haz.bE(view);
        }
        if (!j.jE()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                ut(11);
            } else if (num.intValue() == 200) {
                bzI();
                ut(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            ut(12);
        }
    }

    private void ut(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new an("c10125").ae(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ae("tid", this.mShareItem.tid).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aGg).r("obj_param1", this.mShareItem.aGh));
        }
    }

    private void bzI() {
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
        MessageManager.getInstance().unRegisterListener(this.haA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView aWe;
        public TextView bwl;
        public ViewGroup haC;

        private a() {
        }
    }
}

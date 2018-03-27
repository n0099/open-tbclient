package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class g extends com.baidu.tbadk.g.b implements View.OnClickListener, BdListView.e, j.b {
    private ArrayList<MarkData> fys;
    private com.baidu.tieba.myCollection.baseEditMark.a fyp = null;
    private h fyV = null;
    private int fyr = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    g.this.fyV.aIH();
                    g.this.fyV.completePullRefresh();
                    g.this.fyV.ct(false);
                    g.this.fyV.fG(false);
                    return;
                }
                g.this.fyp.d(false);
                g.this.fyV.fG(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (g.this.fys != null && data != null) {
                    if (data.biK != null && AntiHelper.a(g.this.getActivity(), data.biK, g.this.mInjectListener) != null) {
                        TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXA));
                    }
                    if (data.apH) {
                        Iterator it = g.this.fys.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && am.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(g.this.getPageContext().getPageActivity(), d.j.attention_success);
                        }
                        g.this.fyV.aXT();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.g.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXA));
        }
    };

    public static final g aXZ() {
        return new g();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aYa();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.edit_mark_activity, (ViewGroup) null);
        this.fyp = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fyV = new h(this, inflate);
        this.fyV.c(new a.b() { // from class: com.baidu.tieba.myCollection.g.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                g.this.fyV.startRefresh(g.this.fyp.getOffset());
                g.this.fyp.d(true);
            }
        });
        this.fyV.fG(com.baidu.adp.lib.util.j.oJ());
        this.fyp.a(new d() { // from class: com.baidu.tieba.myCollection.g.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        g.this.fyV.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        g.this.fyV.a(r3, g.this.fyp, ((Boolean) objArr[2]).booleanValue());
                        g.this.fys = g.this.fyp.aYd();
                        g gVar = g.this;
                        if (g.this.fys != null && !g.this.fys.isEmpty()) {
                            r2 = true;
                        }
                        gVar.aIA = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        g.this.fyV.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        g.this.fyV.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        g.this.fyV.a(g.this.fyp, false);
                        g.this.aIA = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        g.this.fyV.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            g.this.fyV.startRefresh(g.this.fyp.getOffset());
                            g.this.fyp.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        g.this.fyV.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, g.this.fyp);
                        g.this.fys = g.this.fyp.aYd();
                        g.this.aIA = (g.this.fys == null || g.this.fys.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                g.this.eb(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fyp.getCount() == 0) {
            this.fyV.startRefresh(this.fyp.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fyV != null) {
            this.fyV.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fyV != null) {
            this.fyV.ah(this.fys);
            this.aIA = (this.fys == null || this.fys.isEmpty()) ? false : true;
            eb(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.g.b, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fyV.aYb();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fyV.onDestroy();
        this.fyp.onDestroy();
        super.onDestroy();
    }

    private void aYa() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == g.this.getType()) {
                        g.this.fyV.jx(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.f(this.fys, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            ak akVar = new ak("c12529");
            if (view.getId() == this.fyV.jy(isShareThread)) {
                this.fyV.arB();
                if (!this.fyp.sr(intValue)) {
                    this.fyV.aIH();
                }
            } else if (view.getId() == this.fyV.jz(isShareThread)) {
                this.fyV.e(markData);
                akVar.s("obj_locate", 1);
            } else if (view.getId() == this.fyV.jA(isShareThread)) {
                akVar.s("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            akVar.ab("tid", markData.getId());
            akVar.ab("obj_id", markData.getUesrId());
            TiebaStatic.log(akVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fyp.aYd().size()) {
            this.fyr = i;
            MarkData markData = this.fyp.aYd().get(i);
            MarkData markData2 = this.fys.get(i);
            ak akVar = new ak("c12529");
            akVar.s("obj_locate", 2);
            akVar.ab("tid", markData2.getId());
            akVar.ab("obj_id", markData2.getUesrId());
            TiebaStatic.log(akVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ay.aZ(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), d.j.manga_plugin_not_install_tip);
                    }
                } else {
                    PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001);
                    createMarkCfg.setStartFrom(10);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createMarkCfg));
                }
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    private void d(MarkData markData) {
        if (markData != null && this.fyp != null) {
            int aYc = this.fyp.aYc();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgBookmark(0);
                }
                if (aYc > 0) {
                    this.fyp.sq(aYc - 1);
                } else {
                    this.fyp.sq(0);
                }
            }
            markData.setNewCounts(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (17001 == i) {
                MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                if (this.fyp != null && markData != null && this.fyV != null && v.D(this.fyp.aYd()) > this.fyr && this.fyr >= 0) {
                    this.fyp.aYd().get(this.fyr).setPostId(markData.getPostId());
                    this.fyp.aYd().get(this.fyr).setHostMode(markData.getHostMode());
                    this.fyp.aYd().get(this.fyr).setSequence(markData.getSequence());
                    this.fyV.aXT();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fyp != null && this.fyV != null && v.D(this.fyp.aYd()) > this.fyr && this.fyr >= 0) {
            this.fyp.aYd().remove(this.fyr);
            this.fyV.aXT();
            this.fyV.a(this.fyp, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        if (this.fyp != null && this.fyV != null) {
            this.fyp.reset();
            this.fyV.ct(true);
            this.fyp.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fyV != null && this.fyp != null && this.fyp.hasMore()) {
            this.fyV.startRefresh(this.fyp.getOffset());
            this.fyp.d(false);
        }
    }

    @Override // com.baidu.tbadk.g.b
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.g.b
    public boolean wP() {
        return this.fys == null || this.fys.isEmpty();
    }
}

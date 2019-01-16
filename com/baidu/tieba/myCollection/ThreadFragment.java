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
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, j.b {
    private ArrayList<MarkData> fKE;
    private com.baidu.tieba.myCollection.baseEditMark.a fKB = null;
    private g fLh = null;
    private int fKD = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    ThreadFragment.this.fLh.aHb();
                    ThreadFragment.this.fLh.completePullRefresh();
                    ThreadFragment.this.fLh.cH(false);
                    ThreadFragment.this.fLh.gr(false);
                    return;
                }
                ThreadFragment.this.fKB.e(false);
                ThreadFragment.this.fLh.gr(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.fKE != null && data != null) {
                    if (data.aPX != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aPX, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDq));
                    }
                    if (data.Jr) {
                        Iterator it = ThreadFragment.this.fKE.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ao.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                        }
                        ThreadFragment.this.fLh.beL();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDq));
        }
    };

    public static final ThreadFragment beP() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        beQ();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.edit_mark_activity, (ViewGroup) null);
        this.fKB = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fLh = new g(this, inflate);
        this.fLh.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.fLh.startRefresh(ThreadFragment.this.fKB.getOffset());
                ThreadFragment.this.fKB.e(true);
            }
        });
        this.fLh.gr(com.baidu.adp.lib.util.j.kV());
        this.fKB.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.fLh.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fLh.a(r3, ThreadFragment.this.fKB, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.fKE = ThreadFragment.this.fKB.beT();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.fKE != null && !ThreadFragment.this.fKE.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.anX = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.fLh.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fLh.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.fLh.a(ThreadFragment.this.fKB, false);
                        ThreadFragment.this.anX = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.fLh.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.fLh.startRefresh(ThreadFragment.this.fKB.getOffset());
                            ThreadFragment.this.fKB.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.fLh.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.fKB);
                        ThreadFragment.this.fKE = ThreadFragment.this.fKB.beT();
                        ThreadFragment.this.anX = (ThreadFragment.this.fKE == null || ThreadFragment.this.fKE.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.cb(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fKB.getCount() == 0) {
            this.fLh.startRefresh(this.fKB.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fLh != null) {
            this.fLh.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fLh != null) {
            this.fLh.aj(this.fKE);
            this.anX = (this.fKE == null || this.fKE.isEmpty()) ? false : true;
            cb(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fLh.beR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fLh.onDestroy();
        this.fKB.onDestroy();
        super.onDestroy();
    }

    private void beQ() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.fLh.kb(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.d(this.fKE, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            am amVar = new am("c12529");
            if (view.getId() == this.fLh.kc(isShareThread)) {
                if (this.fLh.eev == null || this.fLh.eev.isRefreshDone()) {
                    this.fLh.axy();
                    if (!this.fKB.se(intValue)) {
                        this.fLh.aHb();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.fLh.kd(isShareThread)) {
                this.fLh.e(markData);
                amVar.y("obj_locate", 1);
            } else if (view.getId() == this.fLh.ke(isShareThread)) {
                amVar.y("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            amVar.aB("tid", markData.getId());
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(amVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fKB.beT().size()) {
            this.fKD = i;
            MarkData markData = this.fKB.beT().get(i);
            MarkData markData2 = this.fKE.get(i);
            am amVar = new am("c12529");
            amVar.y("obj_locate", 2);
            amVar.aB("tid", markData2.getId());
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(amVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ba.bI(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), e.j.manga_plugin_not_install_tip);
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
        if (markData != null && this.fKB != null) {
            int beS = this.fKB.beS();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.If().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgBookmark(0);
                }
                if (beS > 0) {
                    this.fKB.sd(beS - 1);
                } else {
                    this.fKB.sd(0);
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
                if (this.fKB != null && markData != null && this.fLh != null && v.H(this.fKB.beT()) > this.fKD && this.fKD >= 0) {
                    this.fKB.beT().get(this.fKD).setPostId(markData.getPostId());
                    this.fKB.beT().get(this.fKD).setHostMode(markData.getHostMode());
                    this.fKB.beT().get(this.fKD).setSequence(markData.getSequence());
                    this.fLh.beL();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fKB != null && this.fLh != null && v.H(this.fKB.beT()) > this.fKD && this.fKD >= 0) {
            this.fKB.beT().remove(this.fKD);
            this.fLh.beL();
            this.fLh.a(this.fKB, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        if (this.fKB != null && this.fLh != null) {
            this.fKB.reset();
            this.fLh.cH(true);
            this.fKB.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fLh != null && this.fKB != null && this.fKB.hasMore()) {
            this.fLh.startRefresh(this.fKB.getOffset());
            this.fKB.e(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean xu() {
        return this.fKE == null || this.fKE.isEmpty();
    }
}

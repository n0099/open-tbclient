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
    private ArrayList<MarkData> fAc;
    private com.baidu.tieba.myCollection.baseEditMark.a fzZ = null;
    private g fAF = null;
    private int fAb = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    ThreadFragment.this.fAF.aEd();
                    ThreadFragment.this.fAF.completePullRefresh();
                    ThreadFragment.this.fAF.cD(false);
                    ThreadFragment.this.fAF.gl(false);
                    return;
                }
                ThreadFragment.this.fzZ.e(false);
                ThreadFragment.this.fAF.gl(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.fAc != null && data != null) {
                    if (data.aLS != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aLS, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azn));
                    }
                    if (data.Jr) {
                        Iterator it = ThreadFragment.this.fAc.iterator();
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
                        ThreadFragment.this.fAF.bbH();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azn));
        }
    };

    public static final ThreadFragment bbN() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bbO();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.edit_mark_activity, (ViewGroup) null);
        this.fzZ = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fAF = new g(this, inflate);
        this.fAF.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.fAF.startRefresh(ThreadFragment.this.fzZ.getOffset());
                ThreadFragment.this.fzZ.e(true);
            }
        });
        this.fAF.gl(com.baidu.adp.lib.util.j.kV());
        this.fzZ.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.fAF.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fAF.a(r3, ThreadFragment.this.fzZ, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.fAc = ThreadFragment.this.fzZ.bbR();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.fAc != null && !ThreadFragment.this.fAc.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.ajT = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.fAF.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fAF.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.fAF.a(ThreadFragment.this.fzZ, false);
                        ThreadFragment.this.ajT = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.fAF.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.fAF.startRefresh(ThreadFragment.this.fzZ.getOffset());
                            ThreadFragment.this.fzZ.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.fAF.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.fzZ);
                        ThreadFragment.this.fAc = ThreadFragment.this.fzZ.bbR();
                        ThreadFragment.this.ajT = (ThreadFragment.this.fAc == null || ThreadFragment.this.fAc.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.bN(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fzZ.getCount() == 0) {
            this.fAF.startRefresh(this.fzZ.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fAF != null) {
            this.fAF.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fAF != null) {
            this.fAF.aj(this.fAc);
            this.ajT = (this.fAc == null || this.fAc.isEmpty()) ? false : true;
            bN(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fAF.bbP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fAF.onDestroy();
        this.fzZ.onDestroy();
        super.onDestroy();
    }

    private void bbO() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.fAF.jV(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.d(this.fAc, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            am amVar = new am("c12529");
            if (view.getId() == this.fAF.jW(isShareThread)) {
                if (this.fAF.dUv == null || this.fAF.dUv.isRefreshDone()) {
                    this.fAF.auB();
                    if (!this.fzZ.rv(intValue)) {
                        this.fAF.aEd();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.fAF.jX(isShareThread)) {
                this.fAF.e(markData);
                amVar.x("obj_locate", 1);
            } else if (view.getId() == this.fAF.jY(isShareThread)) {
                amVar.x("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            amVar.ax("tid", markData.getId());
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(amVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fzZ.bbR().size()) {
            this.fAb = i;
            MarkData markData = this.fzZ.bbR().get(i);
            MarkData markData2 = this.fAc.get(i);
            am amVar = new am("c12529");
            amVar.x("obj_locate", 2);
            amVar.ax("tid", markData2.getId());
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(amVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ba.bF(getPageContext().getPageActivity());
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
        if (markData != null && this.fzZ != null) {
            int bbQ = this.fzZ.bbQ();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.GL().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgBookmark(0);
                }
                if (bbQ > 0) {
                    this.fzZ.ru(bbQ - 1);
                } else {
                    this.fzZ.ru(0);
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
                if (this.fzZ != null && markData != null && this.fAF != null && v.H(this.fzZ.bbR()) > this.fAb && this.fAb >= 0) {
                    this.fzZ.bbR().get(this.fAb).setPostId(markData.getPostId());
                    this.fzZ.bbR().get(this.fAb).setHostMode(markData.getHostMode());
                    this.fzZ.bbR().get(this.fAb).setSequence(markData.getSequence());
                    this.fAF.bbH();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fzZ != null && this.fAF != null && v.H(this.fzZ.bbR()) > this.fAb && this.fAb >= 0) {
            this.fzZ.bbR().remove(this.fAb);
            this.fAF.bbH();
            this.fAF.a(this.fzZ, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        if (this.fzZ != null && this.fAF != null) {
            this.fzZ.reset();
            this.fAF.cD(true);
            this.fzZ.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fAF != null && this.fzZ != null && this.fzZ.hasMore()) {
            this.fAF.startRefresh(this.fzZ.getOffset());
            this.fzZ.e(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean wd() {
        return this.fAc == null || this.fAc.isEmpty();
    }
}

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
    private ArrayList<MarkData> fyF;
    private com.baidu.tieba.myCollection.baseEditMark.a fyC = null;
    private g fzi = null;
    private int fyE = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!com.baidu.adp.lib.util.j.kX()) {
                    ThreadFragment.this.fzi.aEH();
                    ThreadFragment.this.fzi.completePullRefresh();
                    ThreadFragment.this.fzi.cm(false);
                    ThreadFragment.this.fzi.gb(false);
                    return;
                }
                ThreadFragment.this.fyC.e(false);
                ThreadFragment.this.fzi.gb(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.fyF != null && data != null) {
                    if (data.aLc != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aLc, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayA));
                    }
                    if (data.Jo) {
                        Iterator it = ThreadFragment.this.fyF.iterator();
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
                        ThreadFragment.this.fzi.bci();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayA));
        }
    };

    public static final ThreadFragment bco() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bcp();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.edit_mark_activity, (ViewGroup) null);
        this.fyC = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fzi = new g(this, inflate);
        this.fzi.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.fzi.startRefresh(ThreadFragment.this.fyC.getOffset());
                ThreadFragment.this.fyC.e(true);
            }
        });
        this.fzi.gb(com.baidu.adp.lib.util.j.kX());
        this.fyC.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.fzi.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fzi.a(r3, ThreadFragment.this.fyC, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.fyF = ThreadFragment.this.fyC.bcs();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.fyF != null && !ThreadFragment.this.fyF.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.ajg = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.fzi.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fzi.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.fzi.a(ThreadFragment.this.fyC, false);
                        ThreadFragment.this.ajg = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.fzi.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.fzi.startRefresh(ThreadFragment.this.fyC.getOffset());
                            ThreadFragment.this.fyC.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.fzi.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.fyC);
                        ThreadFragment.this.fyF = ThreadFragment.this.fyC.bcs();
                        ThreadFragment.this.ajg = (ThreadFragment.this.fyF == null || ThreadFragment.this.fyF.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.by(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fyC.getCount() == 0) {
            this.fzi.startRefresh(this.fyC.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fzi != null) {
            this.fzi.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fzi != null) {
            this.fzi.ak(this.fyF);
            this.ajg = (this.fyF == null || this.fyF.isEmpty()) ? false : true;
            by(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fzi.bcq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fzi.onDestroy();
        this.fyC.onDestroy();
        super.onDestroy();
    }

    private void bcp() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.fzi.jL(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.d(this.fyF, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            am amVar = new am("c12529");
            if (view.getId() == this.fzi.jM(isShareThread)) {
                if (this.fzi.dTp == null || this.fzi.dTp.isRefreshDone()) {
                    this.fzi.avd();
                    if (!this.fyC.rc(intValue)) {
                        this.fzi.aEH();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.fzi.jN(isShareThread)) {
                this.fzi.e(markData);
                amVar.x("obj_locate", 1);
            } else if (view.getId() == this.fzi.jO(isShareThread)) {
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
        if (i >= 0 && i < this.fyC.bcs().size()) {
            this.fyE = i;
            MarkData markData = this.fyC.bcs().get(i);
            MarkData markData2 = this.fyF.get(i);
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
                            ba.bH(getPageContext().getPageActivity());
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
        if (markData != null && this.fyC != null) {
            int bcr = this.fyC.bcr();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Gz().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgBookmark(0);
                }
                if (bcr > 0) {
                    this.fyC.rb(bcr - 1);
                } else {
                    this.fyC.rb(0);
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
                if (this.fyC != null && markData != null && this.fzi != null && v.I(this.fyC.bcs()) > this.fyE && this.fyE >= 0) {
                    this.fyC.bcs().get(this.fyE).setPostId(markData.getPostId());
                    this.fyC.bcs().get(this.fyE).setHostMode(markData.getHostMode());
                    this.fyC.bcs().get(this.fyE).setSequence(markData.getSequence());
                    this.fzi.bci();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fyC != null && this.fzi != null && v.I(this.fyC.bcs()) > this.fyE && this.fyE >= 0) {
            this.fyC.bcs().remove(this.fyE);
            this.fzi.bci();
            this.fzi.a(this.fyC, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        if (this.fyC != null && this.fzi != null) {
            this.fyC.reset();
            this.fzi.cm(true);
            this.fyC.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fzi != null && this.fyC != null && this.fyC.hasMore()) {
            this.fzi.startRefresh(this.fyC.getOffset());
            this.fyC.e(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean vV() {
        return this.fyF == null || this.fyF.isEmpty();
    }
}

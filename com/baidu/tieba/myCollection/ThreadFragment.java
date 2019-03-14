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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, h.c {
    private ArrayList<MarkData> hbk;
    private com.baidu.tieba.myCollection.baseEditMark.a hbh = null;
    private f hbi = null;
    private int hbj = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.kY()) {
                    ThreadFragment.this.hbi.bhr();
                    ThreadFragment.this.hbi.completePullRefresh();
                    ThreadFragment.this.hbi.eX(false);
                    ThreadFragment.this.hbi.iO(false);
                    return;
                }
                ThreadFragment.this.hbh.g(false);
                ThreadFragment.this.hbi.iO(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.hbk != null && data != null) {
                    if (data.bYz != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.bYz, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLn));
                    }
                    if (data.Jy) {
                        Iterator it = ThreadFragment.this.hbk.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ap.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), d.j.attention_success);
                        }
                        ThreadFragment.this.hbi.bFr();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLn));
        }
    };

    public static final ThreadFragment bFn() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bFo();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.edit_mark_activity, (ViewGroup) null);
        this.hbh = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.hbi = new f(this, inflate);
        this.hbi.d(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.hbi.startRefresh(ThreadFragment.this.hbh.getOffset());
                ThreadFragment.this.hbh.g(true);
            }
        });
        this.hbi.iO(j.kY());
        this.hbh.a(new c() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.c
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.hbi.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.hbi.a(r3, ThreadFragment.this.hbh, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.hbk = ThreadFragment.this.hbh.bFt();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.hbk != null && !ThreadFragment.this.hbk.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.buJ = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.hbi.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.hbi.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.hbi.a(ThreadFragment.this.hbh, false);
                        ThreadFragment.this.buJ = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.hbi.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.hbi.startRefresh(ThreadFragment.this.hbh.getOffset());
                            ThreadFragment.this.hbh.g(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.hbi.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.hbh);
                        ThreadFragment.this.hbk = ThreadFragment.this.hbh.bFt();
                        ThreadFragment.this.buJ = (ThreadFragment.this.hbk == null || ThreadFragment.this.hbk.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.fD(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.hbh.getCount() == 0) {
            this.hbi.startRefresh(this.hbh.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hbi != null) {
            this.hbi.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hbi != null) {
            this.hbi.an(this.hbk);
            this.buJ = (this.hbk == null || this.hbk.isEmpty()) ? false : true;
            fD(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hbi.bFp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.hbi.onDestroy();
        this.hbh.onDestroy();
        super.onDestroy();
    }

    private void bFo() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.hbi.mC(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.c(this.hbk, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            am amVar = new am("c12529");
            if (view.getId() == this.hbi.mD(isShareThread)) {
                if (this.hbi.fsL == null || this.hbi.fsL.isRefreshDone()) {
                    this.hbi.aYb();
                    if (!this.hbh.vN(intValue)) {
                        this.hbi.bhr();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.hbi.mE(isShareThread)) {
                this.hbi.e(markData);
                amVar.T("obj_locate", 1);
            } else if (view.getId() == this.hbi.mF(isShareThread)) {
                amVar.T("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            amVar.bJ("tid", markData.getId());
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(amVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.hbh.bFt().size()) {
            this.hbj = i;
            MarkData markData = this.hbh.bFt().get(i);
            MarkData markData2 = this.hbk.get(i);
            am amVar = new am("c12529");
            amVar.T("obj_locate", 2);
            amVar.bJ("tid", markData2.getId());
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(amVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bc.cY(getPageContext().getPageActivity());
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
        if (markData != null && this.hbh != null) {
            int bFs = this.hbh.bFs();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.ahA().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgBookmark(0);
                }
                if (bFs > 0) {
                    this.hbh.vM(bFs - 1);
                } else {
                    this.hbh.vM(0);
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
                if (this.hbh != null && markData != null && this.hbi != null && v.S(this.hbh.bFt()) > this.hbj && this.hbj >= 0) {
                    this.hbh.bFt().get(this.hbj).setPostId(markData.getPostId());
                    this.hbh.bFt().get(this.hbj).setHostMode(markData.getHostMode());
                    this.hbh.bFt().get(this.hbj).setSequence(markData.getSequence());
                    this.hbi.bFr();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.hbh != null && this.hbi != null && v.S(this.hbh.bFt()) > this.hbj && this.hbj >= 0) {
            this.hbh.bFt().remove(this.hbj);
            this.hbi.bFr();
            this.hbi.a(this.hbh, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (this.hbh != null && this.hbi != null) {
            this.hbh.reset();
            this.hbi.eX(true);
            this.hbh.g(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hbi != null && this.hbh != null && this.hbh.hasMore()) {
            this.hbi.startRefresh(this.hbh.getOffset());
            this.hbh.g(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean Wb() {
        return this.hbk == null || this.hbk.isEmpty();
    }
}

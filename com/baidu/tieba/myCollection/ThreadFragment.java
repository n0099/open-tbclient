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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, h.c {
    private ArrayList<MarkData> hss;
    private com.baidu.tieba.myCollection.baseEditMark.a hsp = null;
    private e hsq = null;
    private int hsr = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.jS()) {
                    ThreadFragment.this.hsq.boL();
                    ThreadFragment.this.hsq.completePullRefresh();
                    ThreadFragment.this.hsq.ft(false);
                    ThreadFragment.this.hsq.jw(false);
                    return;
                }
                ThreadFragment.this.hsp.g(false);
                ThreadFragment.this.hsq.jw(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.hss != null && data != null) {
                    if (data.cgz != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.cgz, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTc));
                    }
                    if (data.Hi) {
                        Iterator it = ThreadFragment.this.hss.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ap.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                        }
                        ThreadFragment.this.hsq.bNb();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTc));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTc));
        }
    };

    public static final ThreadFragment bMX() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bMY();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.hsp = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.hsq = new e(this, inflate);
        this.hsq.d(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.hsq.startRefresh(ThreadFragment.this.hsp.getOffset());
                ThreadFragment.this.hsp.g(true);
            }
        });
        this.hsq.jw(j.jS());
        this.hsp.a(new c() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.c
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.hsq.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.hsq.a(r3, ThreadFragment.this.hsp, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.hss = ThreadFragment.this.hsp.bNd();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.hss != null && !ThreadFragment.this.hss.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.bBQ = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.hsq.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.hsq.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.hsq.a(ThreadFragment.this.hsp, false);
                        ThreadFragment.this.bBQ = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.hsq.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.hsq.startRefresh(ThreadFragment.this.hsp.getOffset());
                            ThreadFragment.this.hsp.g(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.hsq.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.hsp);
                        ThreadFragment.this.hss = ThreadFragment.this.hsp.bNd();
                        ThreadFragment.this.bBQ = (ThreadFragment.this.hss == null || ThreadFragment.this.hss.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.go(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.hsp.getCount() == 0) {
            this.hsq.startRefresh(this.hsp.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hsq != null) {
            this.hsq.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hsq != null) {
            this.hsq.ar(this.hss);
            this.bBQ = (this.hss == null || this.hss.isEmpty()) ? false : true;
            go(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hsq.bMZ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.hsq.onDestroy();
        this.hsp.onDestroy();
        super.onDestroy();
    }

    private void bMY() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.hsq.nr(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.c(this.hss, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            am amVar = new am("c12529");
            if (view.getId() == this.hsq.ns(isShareThread)) {
                if (this.hsq.fIU == null || this.hsq.fIU.isRefreshDone()) {
                    this.hsq.bfv();
                    if (!this.hsp.wO(intValue)) {
                        this.hsq.boL();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.hsq.nt(isShareThread)) {
                this.hsq.e(markData);
                amVar.P("obj_locate", 1);
            } else if (view.getId() == this.hsq.nu(isShareThread)) {
                amVar.P("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            amVar.bT("tid", markData.getId());
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(amVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.hsp.bNd().size()) {
            this.hsr = i;
            MarkData markData = this.hsp.bNd().get(i);
            MarkData markData2 = this.hss.get(i);
            am amVar = new am("c12529");
            amVar.P("obj_locate", 2);
            amVar.bT("tid", markData2.getId());
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(amVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bc.cD(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), (int) R.string.manga_plugin_not_install_tip);
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
        if (markData != null && this.hsp != null) {
            int bNc = this.hsp.bNc();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.amy().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgBookmark(0);
                }
                if (bNc > 0) {
                    this.hsp.wN(bNc - 1);
                } else {
                    this.hsp.wN(0);
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
                if (this.hsp != null && markData != null && this.hsq != null && v.Z(this.hsp.bNd()) > this.hsr && this.hsr >= 0) {
                    this.hsp.bNd().get(this.hsr).setPostId(markData.getPostId());
                    this.hsp.bNd().get(this.hsr).setHostMode(markData.getHostMode());
                    this.hsp.bNd().get(this.hsr).setSequence(markData.getSequence());
                    this.hsq.bNb();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.hsp != null && this.hsq != null && v.Z(this.hsp.bNd()) > this.hsr && this.hsr >= 0) {
            this.hsp.bNd().remove(this.hsr);
            this.hsq.bNb();
            this.hsq.a(this.hsp, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (this.hsp != null && this.hsq != null) {
            this.hsp.reset();
            this.hsq.ft(true);
            this.hsp.g(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hsq != null && this.hsp != null && this.hsp.hasMore()) {
            this.hsq.startRefresh(this.hsp.getOffset());
            this.hsp.g(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean aaE() {
        return this.hss == null || this.hss.isEmpty();
    }
}

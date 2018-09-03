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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, g.b {
    private ArrayList<MarkData> fjD;
    private com.baidu.tieba.myCollection.baseEditMark.a fjA = null;
    private g fkg = null;
    private int fjC = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.jE()) {
                    ThreadFragment.this.fkg.azg();
                    ThreadFragment.this.fkg.completePullRefresh();
                    ThreadFragment.this.fkg.bR(false);
                    ThreadFragment.this.fkg.fs(false);
                    return;
                }
                ThreadFragment.this.fjA.e(false);
                ThreadFragment.this.fkg.fs(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.fjD != null && data != null) {
                    if (data.aDt != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aDt, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arr));
                    }
                    if (data.Gp) {
                        Iterator it = ThreadFragment.this.fjD.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ap.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), f.j.attention_success);
                        }
                        ThreadFragment.this.fkg.aWJ();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arr));
        }
    };

    public static final ThreadFragment aWP() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aWQ();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.edit_mark_activity, (ViewGroup) null);
        this.fjA = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fkg = new g(this, inflate);
        this.fkg.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.fkg.startRefresh(ThreadFragment.this.fjA.getOffset());
                ThreadFragment.this.fjA.e(true);
            }
        });
        this.fkg.fs(j.jE());
        this.fjA.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.fkg.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fkg.a(r3, ThreadFragment.this.fjA, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.fjD = ThreadFragment.this.fjA.aWT();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.fjD != null && !ThreadFragment.this.fjD.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.abH = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.fkg.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fkg.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.fkg.a(ThreadFragment.this.fjA, false);
                        ThreadFragment.this.abH = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.fkg.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.fkg.startRefresh(ThreadFragment.this.fjA.getOffset());
                            ThreadFragment.this.fjA.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.fkg.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.fjA);
                        ThreadFragment.this.fjD = ThreadFragment.this.fjA.aWT();
                        ThreadFragment.this.abH = (ThreadFragment.this.fjD == null || ThreadFragment.this.fjD.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.bd(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fjA.getCount() == 0) {
            this.fkg.startRefresh(this.fjA.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fkg != null) {
            this.fkg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fkg != null) {
            this.fkg.ak(this.fjD);
            this.abH = (this.fjD == null || this.fjD.isEmpty()) ? false : true;
            bd(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fkg.aWR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fkg.onDestroy();
        this.fjA.onDestroy();
        super.onDestroy();
    }

    private void aWQ() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.fkg.iV(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) w.d(this.fjD, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            an anVar = new an("c12529");
            if (view.getId() == this.fkg.iW(isShareThread)) {
                if (this.fkg.dFw == null || this.fkg.dFw.isRefreshDone()) {
                    this.fkg.apS();
                    if (!this.fjA.qa(intValue)) {
                        this.fkg.azg();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.fkg.iX(isShareThread)) {
                this.fkg.e(markData);
                anVar.r("obj_locate", 1);
            } else if (view.getId() == this.fkg.iY(isShareThread)) {
                anVar.r("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            anVar.ae("tid", markData.getId());
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(anVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fjA.aWT().size()) {
            this.fjC = i;
            MarkData markData = this.fjA.aWT().get(i);
            MarkData markData2 = this.fjD.get(i);
            an anVar = new an("c12529");
            anVar.r("obj_locate", 2);
            anVar.ae("tid", markData2.getId());
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(anVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bb.aT(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), f.j.manga_plugin_not_install_tip);
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
        if (markData != null && this.fjA != null) {
            int aWS = this.fjA.aWS();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(0);
                }
                if (aWS > 0) {
                    this.fjA.pZ(aWS - 1);
                } else {
                    this.fjA.pZ(0);
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
                if (this.fjA != null && markData != null && this.fkg != null && w.y(this.fjA.aWT()) > this.fjC && this.fjC >= 0) {
                    this.fjA.aWT().get(this.fjC).setPostId(markData.getPostId());
                    this.fjA.aWT().get(this.fjC).setHostMode(markData.getHostMode());
                    this.fjA.aWT().get(this.fjC).setSequence(markData.getSequence());
                    this.fkg.aWJ();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fjA != null && this.fkg != null && w.y(this.fjA.aWT()) > this.fjC && this.fjC >= 0) {
            this.fjA.aWT().remove(this.fjC);
            this.fkg.aWJ();
            this.fkg.a(this.fjA, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
        if (this.fjA != null && this.fkg != null) {
            this.fjA.reset();
            this.fkg.bR(true);
            this.fjA.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fkg != null && this.fjA != null && this.fjA.hasMore()) {
            this.fkg.startRefresh(this.fjA.getOffset());
            this.fjA.e(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean sG() {
        return this.fjD == null || this.fjD.isEmpty();
    }
}

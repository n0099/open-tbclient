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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, h.c {
    private ArrayList<MarkData> hyF;
    private com.baidu.tieba.myCollection.baseEditMark.a hyC = null;
    private e hyD = null;
    private int hyE = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.kc()) {
                    ThreadFragment.this.hyD.bqO();
                    ThreadFragment.this.hyD.completePullRefresh();
                    ThreadFragment.this.hyD.fx(false);
                    ThreadFragment.this.hyD.jG(false);
                    return;
                }
                ThreadFragment.this.hyC.g(false);
                ThreadFragment.this.hyD.jG(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.hyF != null && data != null) {
                    if (data.chF != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.chF, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUe));
                    }
                    if (data.Hs) {
                        Iterator it = ThreadFragment.this.hyF.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && aq.bV(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                        }
                        ThreadFragment.this.hyD.bPK();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUe));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUe));
        }
    };

    public static final ThreadFragment bPG() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bPH();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.hyC = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.hyD = new e(this, inflate);
        this.hyD.d(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.hyD.startRefresh(ThreadFragment.this.hyC.getOffset());
                ThreadFragment.this.hyC.g(true);
            }
        });
        this.hyD.jG(j.kc());
        this.hyC.a(new c() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.c
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.hyD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.hyD.a(r3, ThreadFragment.this.hyC, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.hyF = ThreadFragment.this.hyC.bPM();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.hyF != null && !ThreadFragment.this.hyF.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.bCO = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.hyD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.hyD.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.hyD.a(ThreadFragment.this.hyC, false);
                        ThreadFragment.this.bCO = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.hyD.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.hyD.startRefresh(ThreadFragment.this.hyC.getOffset());
                            ThreadFragment.this.hyC.g(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.hyD.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.hyC);
                        ThreadFragment.this.hyF = ThreadFragment.this.hyC.bPM();
                        ThreadFragment.this.bCO = (ThreadFragment.this.hyF == null || ThreadFragment.this.hyF.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.gs(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.hyC.getCount() == 0) {
            this.hyD.startRefresh(this.hyC.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hyD != null) {
            this.hyD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hyD != null) {
            this.hyD.ar(this.hyF);
            this.bCO = (this.hyF == null || this.hyF.isEmpty()) ? false : true;
            gs(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hyD.bPI();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.hyD.onDestroy();
        this.hyC.onDestroy();
        super.onDestroy();
    }

    private void bPH() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.hyD.nG(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.c(this.hyF, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            an anVar = new an("c12529");
            if (view.getId() == this.hyD.nH(isShareThread)) {
                if (this.hyD.fNU == null || this.hyD.fNU.isRefreshDone()) {
                    this.hyD.bhy();
                    if (!this.hyC.xr(intValue)) {
                        this.hyD.bqO();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.hyD.nI(isShareThread)) {
                this.hyD.e(markData);
                anVar.P("obj_locate", 1);
            } else if (view.getId() == this.hyD.nJ(isShareThread)) {
                anVar.P("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            anVar.bT("tid", markData.getId());
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(anVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.hyC.bPM().size()) {
            this.hyE = i;
            MarkData markData = this.hyC.bPM().get(i);
            MarkData markData2 = this.hyF.get(i);
            an anVar = new an("c12529");
            anVar.P("obj_locate", 2);
            anVar.bT("tid", markData2.getId());
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(anVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bd.cE(getPageContext().getPageActivity());
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
        if (markData != null && this.hyC != null) {
            int bPL = this.hyC.bPL();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.anD().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgBookmark(0);
                }
                if (bPL > 0) {
                    this.hyC.xq(bPL - 1);
                } else {
                    this.hyC.xq(0);
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
                if (this.hyC != null && markData != null && this.hyD != null && v.Z(this.hyC.bPM()) > this.hyE && this.hyE >= 0) {
                    this.hyC.bPM().get(this.hyE).setPostId(markData.getPostId());
                    this.hyC.bPM().get(this.hyE).setHostMode(markData.getHostMode());
                    this.hyC.bPM().get(this.hyE).setSequence(markData.getSequence());
                    this.hyD.bPK();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.hyC != null && this.hyD != null && v.Z(this.hyC.bPM()) > this.hyE && this.hyE >= 0) {
            this.hyC.bPM().remove(this.hyE);
            this.hyD.bPK();
            this.hyD.a(this.hyC, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        if (this.hyC != null && this.hyD != null) {
            this.hyC.reset();
            this.hyD.fx(true);
            this.hyC.g(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hyD != null && this.hyC != null && this.hyC.hasMore()) {
            this.hyD.startRefresh(this.hyC.getOffset());
            this.hyC.g(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean abD() {
        return this.hyF == null || this.hyF.isEmpty();
    }
}

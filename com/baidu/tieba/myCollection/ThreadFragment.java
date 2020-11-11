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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, f.c {
    private ArrayList<MarkData> las;
    private com.baidu.tieba.myCollection.baseEditMark.a lap = null;
    private e laq = null;
    private int lar = -1;
    private final CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.isNetWorkAvailable()) {
                    ThreadFragment.this.laq.hideLoading();
                    ThreadFragment.this.laq.completePullRefresh();
                    ThreadFragment.this.laq.ks(false);
                    ThreadFragment.this.laq.pl(false);
                    return;
                }
                ThreadFragment.this.lap.p(false);
                ThreadFragment.this.laq.pl(true);
            }
        }
    };
    private final CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.las != null && data != null) {
                    if (data.feD != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.feD, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                    }
                    if (data.isSucc) {
                        Iterator it = ThreadFragment.this.las.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && at.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                        }
                        ThreadFragment.this.laq.deX();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };

    public static final ThreadFragment deT() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        deU();
        registerListener(this.exb);
        registerListener(this.eNv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.lap = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.laq = new e(this, inflate);
        this.laq.d(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.laq.startRefresh(ThreadFragment.this.lap.getOffset());
                ThreadFragment.this.lap.p(true);
            }
        });
        this.laq.pl(j.isNetWorkAvailable());
        this.lap.a(new c() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.c
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.laq.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.laq.a(r3, ThreadFragment.this.lap, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.las = ThreadFragment.this.lap.deZ();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.las != null && !ThreadFragment.this.las.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.exa = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.laq.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.laq.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.laq.a(ThreadFragment.this.lap, false);
                        ThreadFragment.this.exa = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.laq.b(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.laq.startRefresh(ThreadFragment.this.lap.getOffset());
                            ThreadFragment.this.lap.p(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.laq.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.lap);
                        ThreadFragment.this.las = ThreadFragment.this.lap.deZ();
                        ThreadFragment.this.exa = (ThreadFragment.this.las == null || ThreadFragment.this.las.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.nL(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.lap.getCount() == 0) {
            this.laq.startRefresh(this.lap.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.laq != null) {
            this.laq.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.laq != null) {
            this.laq.aV(this.las);
            this.exa = (this.las == null || this.las.isEmpty()) ? false : true;
            nL(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.laq.deV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.laq.onDestroy();
        this.lap.onDestroy();
        super.onDestroy();
    }

    private void deU() {
        registerListener(new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.laq.ts(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) y.getItem(this.las, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            aq aqVar = new aq("c12529");
            if (view.getId() == this.laq.tt(isShareThread)) {
                if (this.laq.jgz == null || this.laq.jgz.isRefreshDone()) {
                    this.laq.cur();
                    if (!this.lap.EY(intValue)) {
                        this.laq.hideLoading();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.laq.tu(isShareThread)) {
                this.laq.e(markData);
                aqVar.al("obj_locate", 1);
            } else if (view.getId() == this.laq.tv(isShareThread)) {
                aqVar.al("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, RequestResponseCode.REQUEST_MODIFY_MARK)));
            }
            aqVar.dR("tid", markData.getId());
            aqVar.dR("obj_id", markData.getUesrId());
            TiebaStatic.log(aqVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.lap.deZ().size()) {
            this.lar = i;
            MarkData markData = this.lap.deZ().get(i);
            MarkData markData2 = this.las.get(i);
            aq aqVar = new aq("c12529");
            aqVar.al("obj_locate", 2);
            aqVar.dR("tid", markData2.getId());
            aqVar.dR("obj_id", markData2.getUesrId());
            TiebaStatic.log(aqVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bg.skipToLoginActivity(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                    }
                } else {
                    PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, RequestResponseCode.REQUEST_MODIFY_MARK);
                    createMarkCfg.setStartFrom(10);
                    createMarkCfg.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createMarkCfg));
                }
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    private void d(MarkData markData) {
        if (markData != null && this.lap != null) {
            int deY = this.lap.deY();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.bvS().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgBookmark(0);
                }
                if (deY > 0) {
                    this.lap.EX(deY - 1);
                } else {
                    this.lap.EX(0);
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
                if (this.lap != null && markData != null && this.laq != null && y.getCount(this.lap.deZ()) > this.lar && this.lar >= 0) {
                    this.lap.deZ().get(this.lar).setPostId(markData.getPostId());
                    this.lap.deZ().get(this.lar).setHostMode(markData.getHostMode());
                    this.lap.deZ().get(this.lar).setSequence(markData.getSequence());
                    this.laq.deX();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.lap != null && this.laq != null && y.getCount(this.lap.deZ()) > this.lar && this.lar >= 0) {
            this.lap.deZ().remove(this.lar);
            this.laq.deX();
            this.laq.a(this.lap, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.lap != null && this.laq != null) {
            this.lap.reset();
            this.laq.ks(true);
            this.lap.p(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.laq != null && this.lap != null && this.lap.hasMore()) {
            this.laq.startRefresh(this.lap.getOffset());
            this.lap.p(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean bjE() {
        return this.las == null || this.las.isEmpty();
    }
}

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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, f.c {
    private ArrayList<MarkData> jMl;
    private com.baidu.tieba.myCollection.baseEditMark.a jMi = null;
    private e jMj = null;
    private int jMk = -1;
    private final CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.isNetWorkAvailable()) {
                    ThreadFragment.this.jMj.hideLoading();
                    ThreadFragment.this.jMj.completePullRefresh();
                    ThreadFragment.this.jMj.is(false);
                    ThreadFragment.this.jMj.mO(false);
                    return;
                }
                ThreadFragment.this.jMi.j(false);
                ThreadFragment.this.jMj.mO(true);
            }
        }
    };
    private final CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.jMl != null && data != null) {
                    if (data.els != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.els, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
                    }
                    if (data.isSucc) {
                        Iterator it = ThreadFragment.this.jMl.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ar.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                        }
                        ThreadFragment.this.jMj.cDA();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }
    };

    public static final ThreadFragment cDw() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cDx();
        registerListener(this.dFp);
        registerListener(this.dUF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.jMi = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.jMj = new e(this, inflate);
        this.jMj.d(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.jMj.startRefresh(ThreadFragment.this.jMi.getOffset());
                ThreadFragment.this.jMi.j(true);
            }
        });
        this.jMj.mO(j.isNetWorkAvailable());
        this.jMi.a(new c() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.c
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.jMj.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.jMj.a(r3, ThreadFragment.this.jMi, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.jMl = ThreadFragment.this.jMi.cDC();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.jMl != null && !ThreadFragment.this.jMl.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.dFo = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.jMj.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.jMj.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.jMj.a(ThreadFragment.this.jMi, false);
                        ThreadFragment.this.dFo = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.jMj.b(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.jMj.startRefresh(ThreadFragment.this.jMi.getOffset());
                            ThreadFragment.this.jMi.j(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.jMj.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.jMi);
                        ThreadFragment.this.jMl = ThreadFragment.this.jMi.cDC();
                        ThreadFragment.this.dFo = (ThreadFragment.this.jMl == null || ThreadFragment.this.jMl.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.kj(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.jMi.getCount() == 0) {
            this.jMj.startRefresh(this.jMi.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jMj != null) {
            this.jMj.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jMj != null) {
            this.jMj.aJ(this.jMl);
            this.dFo = (this.jMl == null || this.jMl.isEmpty()) ? false : true;
            kj(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.jMj.cDy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.jMj.onDestroy();
        this.jMi.onDestroy();
        super.onDestroy();
    }

    private void cDx() {
        registerListener(new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.jMj.qQ(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) w.getItem(this.jMl, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            ao aoVar = new ao("c12529");
            if (view.getId() == this.jMj.qR(isShareThread)) {
                if (this.jMj.hXJ == null || this.jMj.hXJ.isRefreshDone()) {
                    this.jMj.bUh();
                    if (!this.jMi.At(intValue)) {
                        this.jMj.hideLoading();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.jMj.qS(isShareThread)) {
                this.jMj.e(markData);
                aoVar.ag("obj_locate", 1);
            } else if (view.getId() == this.jMj.qT(isShareThread)) {
                aoVar.ag("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, RequestResponseCode.REQUEST_MODIFY_MARK)));
            }
            aoVar.dk("tid", markData.getId());
            aoVar.dk("obj_id", markData.getUesrId());
            TiebaStatic.log(aoVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.jMi.cDC().size()) {
            this.jMk = i;
            MarkData markData = this.jMi.cDC().get(i);
            MarkData markData2 = this.jMl.get(i);
            ao aoVar = new ao("c12529");
            aoVar.ag("obj_locate", 2);
            aoVar.dk("tid", markData2.getId());
            aoVar.dk("obj_id", markData2.getUesrId());
            TiebaStatic.log(aoVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            be.skipToLoginActivity(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), (int) R.string.manga_plugin_not_install_tip);
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
        if (markData != null && this.jMi != null) {
            int cDB = this.jMi.cDB();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.bbo().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgBookmark(0);
                }
                if (cDB > 0) {
                    this.jMi.As(cDB - 1);
                } else {
                    this.jMi.As(0);
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
                if (this.jMi != null && markData != null && this.jMj != null && w.getCount(this.jMi.cDC()) > this.jMk && this.jMk >= 0) {
                    this.jMi.cDC().get(this.jMk).setPostId(markData.getPostId());
                    this.jMi.cDC().get(this.jMk).setHostMode(markData.getHostMode());
                    this.jMi.cDC().get(this.jMk).setSequence(markData.getSequence());
                    this.jMj.cDA();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.jMi != null && this.jMj != null && w.getCount(this.jMi.cDC()) > this.jMk && this.jMk >= 0) {
            this.jMi.cDC().remove(this.jMk);
            this.jMj.cDA();
            this.jMj.a(this.jMi, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.jMi != null && this.jMj != null) {
            this.jMi.reset();
            this.jMj.is(true);
            this.jMi.j(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jMj != null && this.jMi != null && this.jMi.hasMore()) {
            this.jMj.startRefresh(this.jMi.getOffset());
            this.jMi.j(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean aPx() {
        return this.jMl == null || this.jMl.isEmpty();
    }
}

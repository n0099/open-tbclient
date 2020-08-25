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
/* loaded from: classes18.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, f.c {
    private ArrayList<MarkData> kkh;
    private com.baidu.tieba.myCollection.baseEditMark.a kke = null;
    private e kkf = null;
    private int kkg = -1;
    private final CustomMessageListener dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.isNetWorkAvailable()) {
                    ThreadFragment.this.kkf.hideLoading();
                    ThreadFragment.this.kkf.completePullRefresh();
                    ThreadFragment.this.kkf.jv(false);
                    ThreadFragment.this.kkf.nX(false);
                    return;
                }
                ThreadFragment.this.kke.n(false);
                ThreadFragment.this.kkf.nX(true);
            }
        }
    };
    private final CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.kkh != null && data != null) {
                    if (data.eCa != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.eCa, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                    }
                    if (data.isSucc) {
                        Iterator it = ThreadFragment.this.kkh.iterator();
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
                        ThreadFragment.this.kkf.cRY();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };

    public static final ThreadFragment cRU() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cRV();
        registerListener(this.dUu);
        registerListener(this.ekH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.kke = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.kkf = new e(this, inflate);
        this.kkf.d(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.kkf.startRefresh(ThreadFragment.this.kke.getOffset());
                ThreadFragment.this.kke.n(true);
            }
        });
        this.kkf.nX(j.isNetWorkAvailable());
        this.kke.a(new c() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.c
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.kkf.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.kkf.a(r3, ThreadFragment.this.kke, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.kkh = ThreadFragment.this.kke.cSa();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.kkh != null && !ThreadFragment.this.kkh.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.dUt = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.kkf.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.kkf.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.kkf.a(ThreadFragment.this.kke, false);
                        ThreadFragment.this.dUt = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.kkf.b(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.kkf.startRefresh(ThreadFragment.this.kke.getOffset());
                            ThreadFragment.this.kke.n(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.kkf.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.kke);
                        ThreadFragment.this.kkh = ThreadFragment.this.kke.cSa();
                        ThreadFragment.this.dUt = (ThreadFragment.this.kkh == null || ThreadFragment.this.kkh.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.mI(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.kke.getCount() == 0) {
            this.kkf.startRefresh(this.kke.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kkf != null) {
            this.kkf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.kkf != null) {
            this.kkf.aQ(this.kkh);
            this.dUt = (this.kkh == null || this.kkh.isEmpty()) ? false : true;
            mI(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.kkf.cRW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.kkf.onDestroy();
        this.kke.onDestroy();
        super.onDestroy();
    }

    private void cRV() {
        registerListener(new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.kkf.sb(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) y.getItem(this.kkh, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            aq aqVar = new aq("c12529");
            if (view.getId() == this.kkf.sc(isShareThread)) {
                if (this.kkf.irR == null || this.kkf.irR.isRefreshDone()) {
                    this.kkf.chX();
                    if (!this.kke.Dl(intValue)) {
                        this.kkf.hideLoading();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.kkf.sd(isShareThread)) {
                this.kkf.e(markData);
                aqVar.ai("obj_locate", 1);
            } else if (view.getId() == this.kkf.se(isShareThread)) {
                aqVar.ai("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, RequestResponseCode.REQUEST_MODIFY_MARK)));
            }
            aqVar.dD("tid", markData.getId());
            aqVar.dD("obj_id", markData.getUesrId());
            TiebaStatic.log(aqVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.kke.cSa().size()) {
            this.kkg = i;
            MarkData markData = this.kke.cSa().get(i);
            MarkData markData2 = this.kkh.get(i);
            aq aqVar = new aq("c12529");
            aqVar.ai("obj_locate", 2);
            aqVar.dD("tid", markData2.getId());
            aqVar.dD("obj_id", markData2.getUesrId());
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
        if (markData != null && this.kke != null) {
            int cRZ = this.kke.cRZ();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.bnV().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgBookmark(0);
                }
                if (cRZ > 0) {
                    this.kke.Dk(cRZ - 1);
                } else {
                    this.kke.Dk(0);
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
                if (this.kke != null && markData != null && this.kkf != null && y.getCount(this.kke.cSa()) > this.kkg && this.kkg >= 0) {
                    this.kke.cSa().get(this.kkg).setPostId(markData.getPostId());
                    this.kke.cSa().get(this.kkg).setHostMode(markData.getHostMode());
                    this.kke.cSa().get(this.kkg).setSequence(markData.getSequence());
                    this.kkf.cRY();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.kke != null && this.kkf != null && y.getCount(this.kke.cSa()) > this.kkg && this.kkg >= 0) {
            this.kke.cSa().remove(this.kkg);
            this.kkf.cRY();
            this.kkf.a(this.kke, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.kke != null && this.kkf != null) {
            this.kke.reset();
            this.kkf.jv(true);
            this.kke.n(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kkf != null && this.kke != null && this.kke.hasMore()) {
            this.kkf.startRefresh(this.kke.getOffset());
            this.kke.n(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean bbJ() {
        return this.kkh == null || this.kkh.isEmpty();
    }
}

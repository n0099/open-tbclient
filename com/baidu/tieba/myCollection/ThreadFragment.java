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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, f.c {
    private ArrayList<MarkData> juU;
    private com.baidu.tieba.myCollection.baseEditMark.a juR = null;
    private e juS = null;
    private int juT = -1;
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.isNetWorkAvailable()) {
                    ThreadFragment.this.juS.hideLoading();
                    ThreadFragment.this.juS.completePullRefresh();
                    ThreadFragment.this.juS.ij(false);
                    ThreadFragment.this.juS.mD(false);
                    return;
                }
                ThreadFragment.this.juR.j(false);
                ThreadFragment.this.juS.mD(true);
            }
        }
    };
    private final CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.juU != null && data != null) {
                    if (data.ecK != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.ecK, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
                    }
                    if (data.isSucc) {
                        Iterator it = ThreadFragment.this.juU.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && aq.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                        }
                        ThreadFragment.this.juS.czD();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };

    public static final ThreadFragment czz() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        czA();
        registerListener(this.dyW);
        registerListener(this.dNP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.juR = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.juS = new e(this, inflate);
        this.juS.d(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.juS.startRefresh(ThreadFragment.this.juR.getOffset());
                ThreadFragment.this.juR.j(true);
            }
        });
        this.juS.mD(j.isNetWorkAvailable());
        this.juR.a(new c() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.c
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.juS.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.juS.a(r3, ThreadFragment.this.juR, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.juU = ThreadFragment.this.juR.czF();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.juU != null && !ThreadFragment.this.juU.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.dyV = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.juS.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.juS.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.juS.a(ThreadFragment.this.juR, false);
                        ThreadFragment.this.dyV = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.juS.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.juS.startRefresh(ThreadFragment.this.juR.getOffset());
                            ThreadFragment.this.juR.j(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.juS.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.juR);
                        ThreadFragment.this.juU = ThreadFragment.this.juR.czF();
                        ThreadFragment.this.dyV = (ThreadFragment.this.juU == null || ThreadFragment.this.juU.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.jY(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.juR.getCount() == 0) {
            this.juS.startRefresh(this.juR.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juS != null) {
            this.juS.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.juS != null) {
            this.juS.aI(this.juU);
            this.dyV = (this.juU == null || this.juU.isEmpty()) ? false : true;
            jY(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.juS.czB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.juS.onDestroy();
        this.juR.onDestroy();
        super.onDestroy();
    }

    private void czA() {
        registerListener(new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.juS.qG(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.getItem(this.juU, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            an anVar = new an("c12529");
            if (view.getId() == this.juS.qH(isShareThread)) {
                if (this.juS.hKx == null || this.juS.hKx.isRefreshDone()) {
                    this.juS.bRl();
                    if (!this.juR.zH(intValue)) {
                        this.juS.hideLoading();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.juS.qI(isShareThread)) {
                this.juS.e(markData);
                anVar.ag("obj_locate", 1);
            } else if (view.getId() == this.juS.qJ(isShareThread)) {
                anVar.ag("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, RequestResponseCode.REQUEST_MODIFY_MARK)));
            }
            anVar.dh("tid", markData.getId());
            anVar.dh("obj_id", markData.getUesrId());
            TiebaStatic.log(anVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.juR.czF().size()) {
            this.juT = i;
            MarkData markData = this.juR.czF().get(i);
            MarkData markData2 = this.juU.get(i);
            an anVar = new an("c12529");
            anVar.ag("obj_locate", 2);
            anVar.dh("tid", markData2.getId());
            anVar.dh("obj_id", markData2.getUesrId());
            TiebaStatic.log(anVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bc.skipToLoginActivity(getPageContext().getPageActivity());
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
        if (markData != null && this.juR != null) {
            int czE = this.juR.czE();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.aZm().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgBookmark(0);
                }
                if (czE > 0) {
                    this.juR.zG(czE - 1);
                } else {
                    this.juR.zG(0);
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
                if (this.juR != null && markData != null && this.juS != null && v.getCount(this.juR.czF()) > this.juT && this.juT >= 0) {
                    this.juR.czF().get(this.juT).setPostId(markData.getPostId());
                    this.juR.czF().get(this.juT).setHostMode(markData.getHostMode());
                    this.juR.czF().get(this.juT).setSequence(markData.getSequence());
                    this.juS.czD();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.juR != null && this.juS != null && v.getCount(this.juR.czF()) > this.juT && this.juT >= 0) {
            this.juR.czF().remove(this.juT);
            this.juS.czD();
            this.juS.a(this.juR, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.juR != null && this.juS != null) {
            this.juR.reset();
            this.juS.ij(true);
            this.juR.j(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.juS != null && this.juR != null && this.juR.hasMore()) {
            this.juS.startRefresh(this.juR.getOffset());
            this.juR.j(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean aNN() {
        return this.juU == null || this.juU.isEmpty();
    }
}

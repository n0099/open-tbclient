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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, f.c {
    private ArrayList<MarkData> lxn;
    private MarkData lxo;
    private com.baidu.tieba.myCollection.baseEditMark.a lxk = null;
    private f lxl = null;
    private int lxm = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.isNetWorkAvailable()) {
                    ThreadFragment.this.lxl.hideLoading();
                    ThreadFragment.this.lxl.completePullRefresh();
                    ThreadFragment.this.lxl.lh(false);
                    ThreadFragment.this.lxl.qo(false);
                    return;
                }
                ThreadFragment.this.lxk.p(false);
                ThreadFragment.this.lxl.qo(true);
            }
        }
    };
    private final CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.lxn != null && data != null) {
                    if (data.fsD != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.fsD, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                    }
                    if (data.isSucc) {
                        Iterator it = ThreadFragment.this.lxn.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && au.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                        }
                        ThreadFragment.this.lxl.dhM();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.7
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };

    public static final ThreadFragment dhH() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dhI();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.faJ);
        dhJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.lxk = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.lxl = new f(this, inflate);
        this.lxl.b(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.lxl.startRefresh(ThreadFragment.this.lxk.getOffset());
                ThreadFragment.this.lxk.p(true);
            }
        });
        this.lxl.qo(j.isNetWorkAvailable());
        this.lxk.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.lxl.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.lxl.a(r3, ThreadFragment.this.lxk, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.lxn = ThreadFragment.this.lxk.dhO();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.lxn != null && !ThreadFragment.this.lxn.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.eJs = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.lxl.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.lxl.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.lxl.a(ThreadFragment.this.lxk, false);
                        ThreadFragment.this.eJs = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.lxl.b(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.lxl.startRefresh(ThreadFragment.this.lxk.getOffset());
                            ThreadFragment.this.lxk.p(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.lxl.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.lxk);
                        ThreadFragment.this.lxn = ThreadFragment.this.lxk.dhO();
                        ThreadFragment.this.eJs = (ThreadFragment.this.lxn == null || ThreadFragment.this.lxn.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.mM(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.lxk.getCount() == 0) {
            this.lxl.startRefresh(this.lxk.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxl != null) {
            this.lxl.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.lxl != null) {
            this.lxl.aS(this.lxn);
            this.eJs = (this.lxn == null || this.lxn.isEmpty()) ? false : true;
            mM(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lxl.dhK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.lxl.onDestroy();
        this.lxk.onDestroy();
        super.onDestroy();
    }

    private void dhI() {
        registerListener(new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.lxl.uh(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    private void dhJ() {
        registerListener(new CustomMessageListener(2921531) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    c.a("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), ThreadFragment.this.lxo);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) y.getItem(this.lxn, intValue);
        this.lxo = markData;
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            ar arVar = new ar("c12529");
            if (view.getId() == this.lxl.ui(isShareThread)) {
                if (this.lxl.jIw == null || this.lxl.jIw.isRefreshDone()) {
                    this.lxl.cyE();
                    if (!this.lxk.EP(intValue)) {
                        this.lxl.hideLoading();
                    }
                    c.A("c14069", markData);
                } else {
                    return;
                }
            } else if (view.getId() == this.lxl.uj(isShareThread)) {
                this.lxl.e(markData);
                arVar.ap("obj_locate", 1);
                c.A("c14064", markData);
            } else if (view.getId() == this.lxl.uk(isShareThread)) {
                arVar.ap("obj_locate", 3);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, RequestResponseCode.REQUEST_MODIFY_MARK)));
                c.A("c14063", markData);
                d(markData);
            }
            arVar.dR("tid", markData.getId());
            arVar.dR("obj_id", markData.getUesrId());
            TiebaStatic.log(arVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.lxk.dhO().size()) {
            this.lxm = i;
            MarkData markData = this.lxk.dhO().get(i);
            MarkData markData2 = this.lxn.get(i);
            this.lxo = markData2;
            ar arVar = new ar("c12529");
            arVar.ap("obj_locate", 2);
            arVar.dR("tid", markData2.getId());
            arVar.dR("obj_id", markData2.getUesrId());
            TiebaStatic.log(arVar);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bh.skipToLoginActivity(getPageContext().getPageActivity());
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
                    c.A("c14063", markData2);
                }
            }
            d(markData2);
            markData2.setRedTipShow(false);
        }
        super.onItemClick(adapterView, view, i, j);
    }

    private void d(MarkData markData) {
        if (markData != null && this.lxk != null) {
            int dhN = this.lxk.dhN();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.bxB().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgBookmark(0);
                }
                if (dhN > 0) {
                    this.lxk.EO(dhN - 1);
                } else {
                    this.lxk.EO(0);
                }
            }
            markData.setNewCounts(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (17001 == i) {
                MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                if (this.lxk != null && markData != null && this.lxl != null && y.getCount(this.lxk.dhO()) > this.lxm && this.lxm >= 0) {
                    this.lxk.dhO().get(this.lxm).setPostId(markData.getPostId());
                    this.lxk.dhO().get(this.lxm).setHostMode(markData.getHostMode());
                    this.lxk.dhO().get(this.lxm).setSequence(markData.getSequence());
                    this.lxl.dhM();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.lxk != null && this.lxl != null && y.getCount(this.lxk.dhO()) > this.lxm && this.lxm >= 0) {
            this.lxk.dhO().remove(this.lxm);
            this.lxl.dhM();
            this.lxl.a(this.lxk, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.lxk != null && this.lxl != null) {
            this.lxk.reset();
            this.lxl.lh(true);
            this.lxk.p(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lxl != null && this.lxk != null && this.lxk.hasMore()) {
            this.lxl.startRefresh(this.lxk.getOffset());
            this.lxk.p(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean bkQ() {
        return this.lxn == null || this.lxn.isEmpty();
    }
}

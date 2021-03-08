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
/* loaded from: classes7.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, f.c {
    private ArrayList<MarkData> lzq;
    private MarkData lzr;
    private com.baidu.tieba.myCollection.baseEditMark.a lzn = null;
    private f lzo = null;
    private int lzp = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.isNetWorkAvailable()) {
                    ThreadFragment.this.lzo.hideLoading();
                    ThreadFragment.this.lzo.completePullRefresh();
                    ThreadFragment.this.lzo.lh(false);
                    ThreadFragment.this.lzo.qo(false);
                    return;
                }
                ThreadFragment.this.lzn.p(false);
                ThreadFragment.this.lzo.qo(true);
            }
        }
    };
    private final CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.lzq != null && data != null) {
                    if (data.fud != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.fud, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                    }
                    if (data.isSucc) {
                        Iterator it = ThreadFragment.this.lzq.iterator();
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
                        ThreadFragment.this.lzo.dhV();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.7
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };

    public static final ThreadFragment dhQ() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dhR();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.fci);
        dhS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
        this.lzn = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.lzo = new f(this, inflate);
        this.lzo.b(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.lzo.startRefresh(ThreadFragment.this.lzn.getOffset());
                ThreadFragment.this.lzn.p(true);
            }
        });
        this.lzo.qo(j.isNetWorkAvailable());
        this.lzn.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.lzo.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.lzo.a(r3, ThreadFragment.this.lzn, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.lzq = ThreadFragment.this.lzn.dhX();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.lzq != null && !ThreadFragment.this.lzq.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.eKT = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.lzo.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.lzo.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.lzo.a(ThreadFragment.this.lzn, false);
                        ThreadFragment.this.eKT = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.lzo.b(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.lzo.startRefresh(ThreadFragment.this.lzn.getOffset());
                            ThreadFragment.this.lzn.p(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.lzo.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.lzn);
                        ThreadFragment.this.lzq = ThreadFragment.this.lzn.dhX();
                        ThreadFragment.this.eKT = (ThreadFragment.this.lzq == null || ThreadFragment.this.lzq.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.mN(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.lzn.getCount() == 0) {
            this.lzo.startRefresh(this.lzn.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lzo != null) {
            this.lzo.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.lzo != null) {
            this.lzo.aS(this.lzq);
            this.eKT = (this.lzq == null || this.lzq.isEmpty()) ? false : true;
            mN(1);
            refresh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lzo.dhT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.lzo.onDestroy();
        this.lzn.onDestroy();
        super.onDestroy();
    }

    private void dhR() {
        registerListener(new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.lzo.uh(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    private void dhS() {
        registerListener(new CustomMessageListener(2921531) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    c.a("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), ThreadFragment.this.lzr);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) y.getItem(this.lzq, intValue);
        this.lzr = markData;
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            ar arVar = new ar("c12529");
            if (view.getId() == this.lzo.ui(isShareThread)) {
                if (this.lzo.jKf == null || this.lzo.jKf.isRefreshDone()) {
                    this.lzo.cyK();
                    if (!this.lzn.ES(intValue)) {
                        this.lzo.hideLoading();
                    }
                    c.A("c14069", markData);
                } else {
                    return;
                }
            } else if (view.getId() == this.lzo.uj(isShareThread)) {
                this.lzo.e(markData);
                arVar.aq("obj_locate", 1);
                c.A("c14064", markData);
            } else if (view.getId() == this.lzo.uk(isShareThread)) {
                arVar.aq("obj_locate", 3);
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
        if (i >= 0 && i < this.lzn.dhX().size()) {
            this.lzp = i;
            MarkData markData = this.lzn.dhX().get(i);
            MarkData markData2 = this.lzq.get(i);
            this.lzr = markData2;
            ar arVar = new ar("c12529");
            arVar.aq("obj_locate", 2);
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
        if (markData != null && this.lzn != null) {
            int dhW = this.lzn.dhW();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.b.bxE().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgBookmark(0);
                }
                if (dhW > 0) {
                    this.lzn.ER(dhW - 1);
                } else {
                    this.lzn.ER(0);
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
                if (this.lzn != null && markData != null && this.lzo != null && y.getCount(this.lzn.dhX()) > this.lzp && this.lzp >= 0) {
                    this.lzn.dhX().get(this.lzp).setPostId(markData.getPostId());
                    this.lzn.dhX().get(this.lzp).setHostMode(markData.getHostMode());
                    this.lzn.dhX().get(this.lzp).setSequence(markData.getSequence());
                    this.lzo.dhV();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.lzn != null && this.lzo != null && y.getCount(this.lzn.dhX()) > this.lzp && this.lzp >= 0) {
            this.lzn.dhX().remove(this.lzp);
            this.lzo.dhV();
            this.lzo.a(this.lzn, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.lzn != null && this.lzo != null) {
            this.lzn.reset();
            this.lzo.lh(true);
            this.lzn.p(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lzo != null && this.lzn != null && this.lzn.hasMore()) {
            this.lzo.startRefresh(this.lzn.getOffset());
            this.lzn.p(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean bkS() {
        return this.lzq == null || this.lzq.isEmpty();
    }
}

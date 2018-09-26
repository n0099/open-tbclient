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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, j.b {
    private ArrayList<MarkData> fqZ;
    private com.baidu.tieba.myCollection.baseEditMark.a fqW = null;
    private g frD = null;
    private int fqY = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!com.baidu.adp.lib.util.j.kK()) {
                    ThreadFragment.this.frD.aBo();
                    ThreadFragment.this.frD.completePullRefresh();
                    ThreadFragment.this.frD.cd(false);
                    ThreadFragment.this.frD.fJ(false);
                    return;
                }
                ThreadFragment.this.fqW.e(false);
                ThreadFragment.this.frD.fJ(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.fqZ != null && data != null) {
                    if (data.aGz != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aGz, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atP));
                    }
                    if (data.IM) {
                        Iterator it = ThreadFragment.this.fqZ.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ao.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                        }
                        ThreadFragment.this.frD.aYW();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atP));
        }
    };

    public static final ThreadFragment aZc() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aZd();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.edit_mark_activity, (ViewGroup) null);
        this.fqW = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.frD = new g(this, inflate);
        this.frD.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.frD.startRefresh(ThreadFragment.this.fqW.getOffset());
                ThreadFragment.this.fqW.e(true);
            }
        });
        this.frD.fJ(com.baidu.adp.lib.util.j.kK());
        this.fqW.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.frD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.frD.a(r3, ThreadFragment.this.fqW, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.fqZ = ThreadFragment.this.fqW.aZg();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.fqZ != null && !ThreadFragment.this.fqZ.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.aej = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.frD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.frD.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.frD.a(ThreadFragment.this.fqW, false);
                        ThreadFragment.this.aej = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.frD.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.frD.startRefresh(ThreadFragment.this.fqW.getOffset());
                            ThreadFragment.this.fqW.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.frD.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.fqW);
                        ThreadFragment.this.fqZ = ThreadFragment.this.fqW.aZg();
                        ThreadFragment.this.aej = (ThreadFragment.this.fqZ == null || ThreadFragment.this.fqZ.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.bn(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fqW.getCount() == 0) {
            this.frD.startRefresh(this.fqW.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.frD != null) {
            this.frD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.frD != null) {
            this.frD.ak(this.fqZ);
            this.aej = (this.fqZ == null || this.fqZ.isEmpty()) ? false : true;
            bn(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.frD.aZe();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.frD.onDestroy();
        this.fqW.onDestroy();
        super.onDestroy();
    }

    private void aZd() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.frD.jt(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) v.d(this.fqZ, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            am amVar = new am("c12529");
            if (view.getId() == this.frD.ju(isShareThread)) {
                if (this.frD.dLs == null || this.frD.dLs.isRefreshDone()) {
                    this.frD.arG();
                    if (!this.fqW.qE(intValue)) {
                        this.frD.aBo();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.frD.jv(isShareThread)) {
                this.frD.e(markData);
                amVar.w("obj_locate", 1);
            } else if (view.getId() == this.frD.jw(isShareThread)) {
                amVar.w("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            amVar.al("tid", markData.getId());
            amVar.al(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(amVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fqW.aZg().size()) {
            this.fqY = i;
            MarkData markData = this.fqW.aZg().get(i);
            MarkData markData2 = this.fqZ.get(i);
            am amVar = new am("c12529");
            amVar.w("obj_locate", 2);
            amVar.al("tid", markData2.getId());
            amVar.al(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(amVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ba.bz(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), e.j.manga_plugin_not_install_tip);
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
        if (markData != null && this.fqW != null) {
            int aZf = this.fqW.aZf();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Ey().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgBookmark(0);
                }
                if (aZf > 0) {
                    this.fqW.qD(aZf - 1);
                } else {
                    this.fqW.qD(0);
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
                if (this.fqW != null && markData != null && this.frD != null && v.y(this.fqW.aZg()) > this.fqY && this.fqY >= 0) {
                    this.fqW.aZg().get(this.fqY).setPostId(markData.getPostId());
                    this.fqW.aZg().get(this.fqY).setHostMode(markData.getHostMode());
                    this.fqW.aZg().get(this.fqY).setSequence(markData.getSequence());
                    this.frD.aYW();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fqW != null && this.frD != null && v.y(this.fqW.aZg()) > this.fqY && this.fqY >= 0) {
            this.fqW.aZg().remove(this.fqY);
            this.frD.aYW();
            this.frD.a(this.fqW, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
        if (this.fqW != null && this.frD != null) {
            this.fqW.reset();
            this.frD.cd(true);
            this.fqW.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.frD != null && this.fqW != null && this.fqW.hasMore()) {
            this.frD.startRefresh(this.fqW.getOffset());
            this.fqW.e(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean tM() {
        return this.fqZ == null || this.fqZ.isEmpty();
    }
}

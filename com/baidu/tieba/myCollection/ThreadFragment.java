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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, e.b {
    private ArrayList<MarkData> eTa;
    private com.baidu.tieba.myCollection.baseEditMark.a eSX = null;
    private g eTD = null;
    private int eSZ = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.gP()) {
                    ThreadFragment.this.eTD.atM();
                    ThreadFragment.this.eTD.completePullRefresh();
                    ThreadFragment.this.eTD.bL(false);
                    ThreadFragment.this.eTD.fl(false);
                    return;
                }
                ThreadFragment.this.eSX.d(false);
                ThreadFragment.this.eTD.fl(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.eTa != null && data != null) {
                    if (data.auo != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.auo, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.aje));
                    }
                    if (data.Aj) {
                        Iterator it = ThreadFragment.this.eTa.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && an.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                        }
                        ThreadFragment.this.eTD.aSO();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.aje));
        }
    };

    public static final ThreadFragment aSU() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aSV();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.edit_mark_activity, (ViewGroup) null);
        this.eSX = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.eTD = new g(this, inflate);
        this.eTD.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.eTD.startRefresh(ThreadFragment.this.eSX.getOffset());
                ThreadFragment.this.eSX.d(true);
            }
        });
        this.eTD.fl(j.gP());
        this.eSX.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.eTD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.eTD.a(r3, ThreadFragment.this.eSX, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.eTa = ThreadFragment.this.eSX.aSY();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.eTa != null && !ThreadFragment.this.eTa.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.TU = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.eTD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.eTD.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.eTD.a(ThreadFragment.this.eSX, false);
                        ThreadFragment.this.TU = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.eTD.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.eTD.startRefresh(ThreadFragment.this.eSX.getOffset());
                            ThreadFragment.this.eSX.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.eTD.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.eSX);
                        ThreadFragment.this.eTa = ThreadFragment.this.eSX.aSY();
                        ThreadFragment.this.TU = (ThreadFragment.this.eTa == null || ThreadFragment.this.eTa.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.aZ(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.eSX.getCount() == 0) {
            this.eTD.startRefresh(this.eSX.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eTD != null) {
            this.eTD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eTD != null) {
            this.eTD.ai(this.eTa);
            this.TU = (this.eTa == null || this.eTa.isEmpty()) ? false : true;
            aZ(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eTD.aSW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.eTD.onDestroy();
        this.eSX.onDestroy();
        super.onDestroy();
    }

    private void aSV() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.eTD.iT(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        int intValue = ((Integer) view2.getTag()).intValue();
        MarkData markData = (MarkData) v.c(this.eTa, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            al alVar = new al("c12529");
            if (view2.getId() == this.eTD.iU(isShareThread)) {
                this.eTD.alR();
                if (!this.eSX.pL(intValue)) {
                    this.eTD.atM();
                }
            } else if (view2.getId() == this.eTD.iV(isShareThread)) {
                this.eTD.e(markData);
                alVar.r("obj_locate", 1);
            } else if (view2.getId() == this.eTD.iW(isShareThread)) {
                alVar.r("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            alVar.ac("tid", markData.getId());
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(alVar);
            super.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (i >= 0 && i < this.eSX.aSY().size()) {
            this.eSZ = i;
            MarkData markData = this.eSX.aSY().get(i);
            MarkData markData2 = this.eTa.get(i);
            al alVar = new al("c12529");
            alVar.r("obj_locate", 2);
            alVar.ac("tid", markData2.getId());
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(alVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            az.aJ(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), d.k.manga_plugin_not_install_tip);
                    }
                } else {
                    PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001);
                    createMarkCfg.setStartFrom(10);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createMarkCfg));
                }
            }
        }
        super.onItemClick(adapterView, view2, i, j);
    }

    private void d(MarkData markData) {
        if (markData != null && this.eSX != null) {
            int aSX = this.eSX.aSX();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.zx().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgBookmark(0);
                }
                if (aSX > 0) {
                    this.eSX.pK(aSX - 1);
                } else {
                    this.eSX.pK(0);
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
                if (this.eSX != null && markData != null && this.eTD != null && v.v(this.eSX.aSY()) > this.eSZ && this.eSZ >= 0) {
                    this.eSX.aSY().get(this.eSZ).setPostId(markData.getPostId());
                    this.eSX.aSY().get(this.eSZ).setHostMode(markData.getHostMode());
                    this.eSX.aSY().get(this.eSZ).setSequence(markData.getSequence());
                    this.eTD.aSO();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.eSX != null && this.eTD != null && v.v(this.eSX.aSY()) > this.eSZ && this.eSZ >= 0) {
            this.eSX.aSY().remove(this.eSZ);
            this.eTD.aSO();
            this.eTD.a(this.eSX, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        if (this.eSX != null && this.eTD != null) {
            this.eSX.reset();
            this.eTD.bL(true);
            this.eSX.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eTD != null && this.eSX != null && this.eSX.hasMore()) {
            this.eTD.startRefresh(this.eSX.getOffset());
            this.eSX.d(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean pz() {
        return this.eTa == null || this.eTa.isEmpty();
    }
}

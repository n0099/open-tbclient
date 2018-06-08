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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, f.b {
    private ArrayList<MarkData> ffz;
    private com.baidu.tieba.myCollection.baseEditMark.a ffw = null;
    private g fgc = null;
    private int ffy = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.jD()) {
                    ThreadFragment.this.fgc.axY();
                    ThreadFragment.this.fgc.completePullRefresh();
                    ThreadFragment.this.fgc.bP(false);
                    ThreadFragment.this.fgc.fq(false);
                    return;
                }
                ThreadFragment.this.ffw.d(false);
                ThreadFragment.this.fgc.fq(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.ffz != null && data != null) {
                    if (data.aCA != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aCA, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arm));
                    }
                    if (data.Gp) {
                        Iterator it = ThreadFragment.this.ffz.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ao.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                        }
                        ThreadFragment.this.fgc.aXK();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arm));
        }
    };

    public static final ThreadFragment aXQ() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aXR();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.edit_mark_activity, (ViewGroup) null);
        this.ffw = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fgc = new g(this, inflate);
        this.fgc.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.fgc.startRefresh(ThreadFragment.this.ffw.getOffset());
                ThreadFragment.this.ffw.d(true);
            }
        });
        this.fgc.fq(j.jD());
        this.ffw.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.fgc.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fgc.a(r3, ThreadFragment.this.ffw, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.ffz = ThreadFragment.this.ffw.aXU();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.ffz != null && !ThreadFragment.this.ffz.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.abX = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.fgc.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fgc.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.fgc.a(ThreadFragment.this.ffw, false);
                        ThreadFragment.this.abX = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.fgc.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.fgc.startRefresh(ThreadFragment.this.ffw.getOffset());
                            ThreadFragment.this.ffw.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.fgc.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.ffw);
                        ThreadFragment.this.ffz = ThreadFragment.this.ffw.aXU();
                        ThreadFragment.this.abX = (ThreadFragment.this.ffz == null || ThreadFragment.this.ffz.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.bb(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.ffw.getCount() == 0) {
            this.fgc.startRefresh(this.ffw.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fgc != null) {
            this.fgc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fgc != null) {
            this.fgc.ai(this.ffz);
            this.abX = (this.ffz == null || this.ffz.isEmpty()) ? false : true;
            bb(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fgc.aXS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fgc.onDestroy();
        this.ffw.onDestroy();
        super.onDestroy();
    }

    private void aXR() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.fgc.ja(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) w.c(this.ffz, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            am amVar = new am("c12529");
            if (view.getId() == this.fgc.jb(isShareThread)) {
                if (this.fgc.dzA == null || this.fgc.dzA.isRefreshDone()) {
                    this.fgc.apX();
                    if (!this.ffw.pW(intValue)) {
                        this.fgc.axY();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.fgc.jc(isShareThread)) {
                this.fgc.e(markData);
                amVar.r("obj_locate", 1);
            } else if (view.getId() == this.fgc.jd(isShareThread)) {
                amVar.r("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            amVar.ah("tid", markData.getId());
            amVar.ah(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(amVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.ffw.aXU().size()) {
            this.ffy = i;
            MarkData markData = this.ffw.aXU().get(i);
            MarkData markData2 = this.ffz.get(i);
            am amVar = new am("c12529");
            amVar.r("obj_locate", 2);
            amVar.ah("tid", markData2.getId());
            amVar.ah(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(amVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ba.aT(getPageContext().getPageActivity());
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
        super.onItemClick(adapterView, view, i, j);
    }

    private void d(MarkData markData) {
        if (markData != null && this.ffw != null) {
            int aXT = this.ffw.aXT();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.CX().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgBookmark(0);
                }
                if (aXT > 0) {
                    this.ffw.pV(aXT - 1);
                } else {
                    this.ffw.pV(0);
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
                if (this.ffw != null && markData != null && this.fgc != null && w.y(this.ffw.aXU()) > this.ffy && this.ffy >= 0) {
                    this.ffw.aXU().get(this.ffy).setPostId(markData.getPostId());
                    this.ffw.aXU().get(this.ffy).setHostMode(markData.getHostMode());
                    this.ffw.aXU().get(this.ffy).setSequence(markData.getSequence());
                    this.fgc.aXK();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.ffw != null && this.fgc != null && w.y(this.ffw.aXU()) > this.ffy && this.ffy >= 0) {
            this.ffw.aXU().remove(this.ffy);
            this.fgc.aXK();
            this.fgc.a(this.ffw, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        if (this.ffw != null && this.fgc != null) {
            this.ffw.reset();
            this.fgc.bP(true);
            this.ffw.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fgc != null && this.ffw != null && this.ffw.hasMore()) {
            this.fgc.startRefresh(this.ffw.getOffset());
            this.ffw.d(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean sT() {
        return this.ffz == null || this.ffz.isEmpty();
    }
}

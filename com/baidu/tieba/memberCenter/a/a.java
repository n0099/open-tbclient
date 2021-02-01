package com.baidu.tieba.memberCenter.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import com.baidu.tieba.memberCenter.bubble.SetBubbleResultData;
import com.baidu.tieba.memberCenter.bubble.c;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.editortools.view.a {
    private BubbleListModel llo;
    private BubbleListData llp;
    private String llq;
    private Context mContext;
    private int dAv = 0;
    private BubbleListModel.a lkI = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.a.a.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            if (bubbleListData == null) {
                a.this.bCz().onLoadFail();
                return;
            }
            a.this.llp = bubbleListData.m35clone();
            if (a.this.llo.deX() > 0) {
                List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                if (b_info != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == a.this.llo.deX()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            a.this.llo.Eq(a.this.llo.deX());
                            a.this.llo.W(a.this.llo.deX(), l.getEquipmentWidth(a.this.mContext), l.getEquipmentHeight(a.this.mContext));
                        }
                    }
                    a.this.llo.Er(-1);
                } else {
                    return;
                }
            }
            a.this.dfa();
            a.this.bCz().c(a.this);
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            a.this.llp = null;
            if (bubbleListData == null) {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            } else if (bubbleListData.getError_code().equals("0")) {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                UtilHelper.showToast(a.this.mContext, bubbleListData.getError_msg());
            } else {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            }
            if (a.this.bCz() != null) {
                a.this.bCz().onLoadFail();
            }
        }
    };
    private BubbleListModel.b lkJ = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.a.a.3
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            if (setBubbleResultData == null || setBubbleResultData.getB_info() == null) {
                a.this.bCz().onLoadFail();
                return;
            }
            a.this.llq = setBubbleResultData.getB_info().getB_url();
            TbadkCoreApplication.getInst().setDefaultBubble(a.this.llq);
            int deW = a.this.llo.deW();
            if (deW == 0) {
                TbadkCoreApplication.getInst().setDefaultBubble("");
                for (BubbleListData.BubbleData bubbleData : a.this.llp.getB_info()) {
                    if (bubbleData.getBcode() != 0) {
                        if (bubbleData.isDef()) {
                            bubbleData.setIs_def(0);
                        }
                    } else {
                        bubbleData.setIs_def(1);
                    }
                }
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : a.this.llp.getB_info()) {
                    if (bubbleData2.getBcode() == deW) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                    if (bubbleData2.getBcode() == deW) {
                        bubbleData2.setCan_use(1);
                    }
                }
            } else {
                UtilHelper.showToast(a.this.mContext, R.string.setdefualt_error);
                if (a.this.llp != null && a.this.llp.getB_info() != null && a.this.llp.getB_info().size() > 0) {
                    if (a.this.llp.getB_info().get(0).getBcode() == 0) {
                        a.this.dAv = 0;
                        int i = 0;
                        while (true) {
                            if (i >= a.this.llp.getB_info().size()) {
                                break;
                            } else if (a.this.llp.getB_info().get(i).isDef()) {
                                a.this.dAv = i;
                                break;
                            } else {
                                i++;
                            }
                        }
                        a.this.llp.getB_info().get(a.this.dAv).setIs_def(0);
                        a.this.llp.getB_info().get(0).setIs_def(1);
                    } else {
                        BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                        bubbleData3.setBcode(0);
                        a.this.llp.getB_info().add(0, bubbleData3);
                    }
                }
            }
            a.this.dfa();
            a.this.bCz().c(a.this);
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void b(SetBubbleResultData setBubbleResultData) {
            if (setBubbleResultData == null) {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            } else if (setBubbleResultData.getError_code().equals("0")) {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                UtilHelper.showToast(a.this.mContext, setBubbleResultData.getError_msg());
            } else {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            }
            if (a.this.bCz() != null) {
                a.this.bCz().onLoadFail();
            }
        }
    };
    public CustomMessageListener lkM = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.a.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.llo.I(0, 50, 0, 0);
        }
    };
    private View.OnClickListener llr = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.a.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.llp != null && (view instanceof BubbleView)) {
                BubbleListData.BubbleData bubbleData = (BubbleListData.BubbleData) y.getItem(a.this.llp.getB_info(), ((Integer) view.getTag()).intValue());
                boolean loadBoolean = TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
                if (bubbleData != null && !bubbleData.isDef()) {
                    if (bubbleData.getBcode() == 0 || bubbleData.canUse() || loadBoolean) {
                        a.this.En(bubbleData.getBcode());
                    } else if (bubbleData.isFree()) {
                        if (a.this.mContext instanceof TbPageContextSupport) {
                            c.a(((TbPageContextSupport) a.this.mContext).getPageContext(), bubbleData, a.this.lkK);
                        }
                    } else if (a.this.mContext instanceof TbPageContextSupport) {
                        c.b(((TbPageContextSupport) a.this.mContext).getPageContext(), bubbleData, a.this.lkL);
                    }
                }
            }
        }
    };
    private c.a lkK = new c.a() { // from class: com.baidu.tieba.memberCenter.a.a.6
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            a.this.En(i);
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deS() {
        }
    };
    private c.a lkL = new c.a() { // from class: com.baidu.tieba.memberCenter.a.a.7
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            a.this.llo.Er(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(a.this.mContext, true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable");
            memberPayActivityConfig.setSceneId("4002001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deS() {
        }
    };

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(final Context context) {
        this.mContext = context;
        a.b bVar = new a.b();
        bVar.fEQ = R.drawable.icon_bubble;
        bVar.fER = 0;
        setVerticalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26));
        setHorizontalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30));
        a(bVar);
        setColumn(2);
        rh(2);
        a(new a.InterfaceC0575a() { // from class: com.baidu.tieba.memberCenter.a.a.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0575a
            public View getView(int i, View view, ViewGroup viewGroup) {
                BubbleView bubbleView;
                if (view == null) {
                    BubbleView bubbleView2 = new BubbleView(context);
                    bubbleView = bubbleView2;
                    view = bubbleView2;
                } else {
                    bubbleView = (BubbleView) view;
                }
                BubbleListData.BubbleData Ep = a.this.Ep(i);
                if (Ep != null) {
                    bubbleView.setData(Ep, BubbleListModel.eR(a.this.llp.getB_info()));
                    bubbleView.setGravity(17);
                    bubbleView.setTag(Integer.valueOf(i));
                    bubbleView.setOnClickListener(a.this.llr);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) j.K(a.this.mContext);
                tbPageContext.getLayoutMode().setNightMode(skinType == 1);
                tbPageContext.getLayoutMode().onModeChanged(view);
                return view;
            }
        });
        this.llq = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.llo == null) {
            if (this.mContext instanceof TbPageContext) {
                this.llo = new BubbleListModel((TbPageContext) this.mContext);
            } else {
                this.llo = new BubbleListModel(null);
            }
        }
        this.llo.a(this.lkI);
        this.llo.a(this.lkJ);
        this.llo.a(this.lkM);
        this.llo.deY();
        this.llo.deZ();
        if (bCz() != null) {
            bCz().preLoad();
        }
        this.llo.I(0, 50, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void En(int i) {
        this.llo.W(i, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
        this.llo.Eq(i);
        if (bCz() != null) {
            bCz().preLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfa() {
        boolean z = false;
        if (this.llp != null && this.llp.getB_info() != null && this.llp.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.llp.getB_info().get(0).getBcode() != 0) {
                this.llp.getB_info().add(0, bubbleData);
            }
            this.dAv = 0;
            int i = 0;
            while (true) {
                if (i >= this.llp.getB_info().size()) {
                    break;
                } else if (!this.llp.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.dAv = i;
                    this.llq = this.llp.getB_info().get(i).getBg_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.llq);
                    break;
                }
            }
        }
        if (this.dAv == 0 || TextUtils.isEmpty(this.llq)) {
            b(new com.baidu.tbadk.editortools.a(2, 12, null));
        } else {
            b(new com.baidu.tbadk.editortools.a(2, 12, " "));
            z = true;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, Boolean.valueOf(z)));
        b(new com.baidu.tbadk.editortools.a(25, -1, this.llq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData Ep(int i) {
        if (i < 0 || i >= getCount() || this.llp == null) {
            return null;
        }
        return this.llp.getB_info().get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.llp == null || this.llp.getB_info() == null) {
            return 0;
        }
        return this.llp.getB_info().size();
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.llo != null) {
            this.llo.unRegisterListener();
            this.llo.b(this.lkM);
            this.llo = null;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (this.llo == null) {
            if (this.mContext instanceof TbPageContext) {
                this.llo = new BubbleListModel((TbPageContext) this.mContext);
            } else {
                this.llo = new BubbleListModel(null);
            }
        }
        if (bCz() != null) {
            bCz().preLoad();
        }
        this.llo.I(0, 50, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
    }
}

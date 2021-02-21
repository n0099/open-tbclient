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
    private BubbleListModel llC;
    private BubbleListData llD;
    private String llE;
    private Context mContext;
    private int dAv = 0;
    private BubbleListModel.a lkW = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.a.a.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            if (bubbleListData == null) {
                a.this.bCz().onLoadFail();
                return;
            }
            a.this.llD = bubbleListData.m35clone();
            if (a.this.llC.dfe() > 0) {
                List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                if (b_info != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == a.this.llC.dfe()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            a.this.llC.Eq(a.this.llC.dfe());
                            a.this.llC.W(a.this.llC.dfe(), l.getEquipmentWidth(a.this.mContext), l.getEquipmentHeight(a.this.mContext));
                        }
                    }
                    a.this.llC.Er(-1);
                } else {
                    return;
                }
            }
            a.this.dfh();
            a.this.bCz().c(a.this);
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            a.this.llD = null;
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
    private BubbleListModel.b lkX = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.a.a.3
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            if (setBubbleResultData == null || setBubbleResultData.getB_info() == null) {
                a.this.bCz().onLoadFail();
                return;
            }
            a.this.llE = setBubbleResultData.getB_info().getB_url();
            TbadkCoreApplication.getInst().setDefaultBubble(a.this.llE);
            int dfd = a.this.llC.dfd();
            if (dfd == 0) {
                TbadkCoreApplication.getInst().setDefaultBubble("");
                for (BubbleListData.BubbleData bubbleData : a.this.llD.getB_info()) {
                    if (bubbleData.getBcode() != 0) {
                        if (bubbleData.isDef()) {
                            bubbleData.setIs_def(0);
                        }
                    } else {
                        bubbleData.setIs_def(1);
                    }
                }
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : a.this.llD.getB_info()) {
                    if (bubbleData2.getBcode() == dfd) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                    if (bubbleData2.getBcode() == dfd) {
                        bubbleData2.setCan_use(1);
                    }
                }
            } else {
                UtilHelper.showToast(a.this.mContext, R.string.setdefualt_error);
                if (a.this.llD != null && a.this.llD.getB_info() != null && a.this.llD.getB_info().size() > 0) {
                    if (a.this.llD.getB_info().get(0).getBcode() == 0) {
                        a.this.dAv = 0;
                        int i = 0;
                        while (true) {
                            if (i >= a.this.llD.getB_info().size()) {
                                break;
                            } else if (a.this.llD.getB_info().get(i).isDef()) {
                                a.this.dAv = i;
                                break;
                            } else {
                                i++;
                            }
                        }
                        a.this.llD.getB_info().get(a.this.dAv).setIs_def(0);
                        a.this.llD.getB_info().get(0).setIs_def(1);
                    } else {
                        BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                        bubbleData3.setBcode(0);
                        a.this.llD.getB_info().add(0, bubbleData3);
                    }
                }
            }
            a.this.dfh();
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
    public CustomMessageListener lla = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.a.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.llC.I(0, 50, 0, 0);
        }
    };
    private View.OnClickListener llF = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.a.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.llD != null && (view instanceof BubbleView)) {
                BubbleListData.BubbleData bubbleData = (BubbleListData.BubbleData) y.getItem(a.this.llD.getB_info(), ((Integer) view.getTag()).intValue());
                boolean loadBoolean = TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
                if (bubbleData != null && !bubbleData.isDef()) {
                    if (bubbleData.getBcode() == 0 || bubbleData.canUse() || loadBoolean) {
                        a.this.En(bubbleData.getBcode());
                    } else if (bubbleData.isFree()) {
                        if (a.this.mContext instanceof TbPageContextSupport) {
                            c.a(((TbPageContextSupport) a.this.mContext).getPageContext(), bubbleData, a.this.lkY);
                        }
                    } else if (a.this.mContext instanceof TbPageContextSupport) {
                        c.b(((TbPageContextSupport) a.this.mContext).getPageContext(), bubbleData, a.this.lkZ);
                    }
                }
            }
        }
    };
    private c.a lkY = new c.a() { // from class: com.baidu.tieba.memberCenter.a.a.6
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            a.this.En(i);
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deZ() {
        }
    };
    private c.a lkZ = new c.a() { // from class: com.baidu.tieba.memberCenter.a.a.7
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            a.this.llC.Er(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(a.this.mContext, true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable");
            memberPayActivityConfig.setSceneId("4002001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deZ() {
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
                    bubbleView.setData(Ep, BubbleListModel.eR(a.this.llD.getB_info()));
                    bubbleView.setGravity(17);
                    bubbleView.setTag(Integer.valueOf(i));
                    bubbleView.setOnClickListener(a.this.llF);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) j.K(a.this.mContext);
                tbPageContext.getLayoutMode().setNightMode(skinType == 1);
                tbPageContext.getLayoutMode().onModeChanged(view);
                return view;
            }
        });
        this.llE = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.llC == null) {
            if (this.mContext instanceof TbPageContext) {
                this.llC = new BubbleListModel((TbPageContext) this.mContext);
            } else {
                this.llC = new BubbleListModel(null);
            }
        }
        this.llC.a(this.lkW);
        this.llC.a(this.lkX);
        this.llC.a(this.lla);
        this.llC.dff();
        this.llC.dfg();
        if (bCz() != null) {
            bCz().preLoad();
        }
        this.llC.I(0, 50, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void En(int i) {
        this.llC.W(i, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
        this.llC.Eq(i);
        if (bCz() != null) {
            bCz().preLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfh() {
        boolean z = false;
        if (this.llD != null && this.llD.getB_info() != null && this.llD.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.llD.getB_info().get(0).getBcode() != 0) {
                this.llD.getB_info().add(0, bubbleData);
            }
            this.dAv = 0;
            int i = 0;
            while (true) {
                if (i >= this.llD.getB_info().size()) {
                    break;
                } else if (!this.llD.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.dAv = i;
                    this.llE = this.llD.getB_info().get(i).getBg_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.llE);
                    break;
                }
            }
        }
        if (this.dAv == 0 || TextUtils.isEmpty(this.llE)) {
            b(new com.baidu.tbadk.editortools.a(2, 12, null));
        } else {
            b(new com.baidu.tbadk.editortools.a(2, 12, " "));
            z = true;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, Boolean.valueOf(z)));
        b(new com.baidu.tbadk.editortools.a(25, -1, this.llE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData Ep(int i) {
        if (i < 0 || i >= getCount() || this.llD == null) {
            return null;
        }
        return this.llD.getB_info().get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.llD == null || this.llD.getB_info() == null) {
            return 0;
        }
        return this.llD.getB_info().size();
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.llC != null) {
            this.llC.unRegisterListener();
            this.llC.b(this.lla);
            this.llC = null;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (this.llC == null) {
            if (this.mContext instanceof TbPageContext) {
                this.llC = new BubbleListModel((TbPageContext) this.mContext);
            } else {
                this.llC = new BubbleListModel(null);
            }
        }
        if (bCz() != null) {
            bCz().preLoad();
        }
        this.llC.I(0, 50, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
    }
}

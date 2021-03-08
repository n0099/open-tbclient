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
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.editortools.view.a {
    private BubbleListModel lnF;
    private BubbleListData lnG;
    private String lnH;
    private Context mContext;
    private int dBW = 0;
    private BubbleListModel.a lmY = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.a.a.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            if (bubbleListData == null) {
                a.this.bCC().onLoadFail();
                return;
            }
            a.this.lnG = bubbleListData.m36clone();
            if (a.this.lnF.dfn() > 0) {
                List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                if (b_info != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == a.this.lnF.dfn()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            a.this.lnF.Et(a.this.lnF.dfn());
                            a.this.lnF.W(a.this.lnF.dfn(), l.getEquipmentWidth(a.this.mContext), l.getEquipmentHeight(a.this.mContext));
                        }
                    }
                    a.this.lnF.Eu(-1);
                } else {
                    return;
                }
            }
            a.this.dfq();
            a.this.bCC().c(a.this);
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            a.this.lnG = null;
            if (bubbleListData == null) {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            } else if (bubbleListData.getError_code().equals("0")) {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                UtilHelper.showToast(a.this.mContext, bubbleListData.getError_msg());
            } else {
                UtilHelper.showToast(a.this.mContext, R.string.neterror);
            }
            if (a.this.bCC() != null) {
                a.this.bCC().onLoadFail();
            }
        }
    };
    private BubbleListModel.b lmZ = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.a.a.3
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            if (setBubbleResultData == null || setBubbleResultData.getB_info() == null) {
                a.this.bCC().onLoadFail();
                return;
            }
            a.this.lnH = setBubbleResultData.getB_info().getB_url();
            TbadkCoreApplication.getInst().setDefaultBubble(a.this.lnH);
            int dfm = a.this.lnF.dfm();
            if (dfm == 0) {
                TbadkCoreApplication.getInst().setDefaultBubble("");
                for (BubbleListData.BubbleData bubbleData : a.this.lnG.getB_info()) {
                    if (bubbleData.getBcode() != 0) {
                        if (bubbleData.isDef()) {
                            bubbleData.setIs_def(0);
                        }
                    } else {
                        bubbleData.setIs_def(1);
                    }
                }
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : a.this.lnG.getB_info()) {
                    if (bubbleData2.getBcode() == dfm) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                    if (bubbleData2.getBcode() == dfm) {
                        bubbleData2.setCan_use(1);
                    }
                }
            } else {
                UtilHelper.showToast(a.this.mContext, R.string.setdefualt_error);
                if (a.this.lnG != null && a.this.lnG.getB_info() != null && a.this.lnG.getB_info().size() > 0) {
                    if (a.this.lnG.getB_info().get(0).getBcode() == 0) {
                        a.this.dBW = 0;
                        int i = 0;
                        while (true) {
                            if (i >= a.this.lnG.getB_info().size()) {
                                break;
                            } else if (a.this.lnG.getB_info().get(i).isDef()) {
                                a.this.dBW = i;
                                break;
                            } else {
                                i++;
                            }
                        }
                        a.this.lnG.getB_info().get(a.this.dBW).setIs_def(0);
                        a.this.lnG.getB_info().get(0).setIs_def(1);
                    } else {
                        BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                        bubbleData3.setBcode(0);
                        a.this.lnG.getB_info().add(0, bubbleData3);
                    }
                }
            }
            a.this.dfq();
            a.this.bCC().c(a.this);
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
            if (a.this.bCC() != null) {
                a.this.bCC().onLoadFail();
            }
        }
    };
    public CustomMessageListener lnc = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.a.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.lnF.I(0, 50, 0, 0);
        }
    };
    private View.OnClickListener lnI = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.a.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lnG != null && (view instanceof BubbleView)) {
                BubbleListData.BubbleData bubbleData = (BubbleListData.BubbleData) y.getItem(a.this.lnG.getB_info(), ((Integer) view.getTag()).intValue());
                boolean loadBoolean = TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
                if (bubbleData != null && !bubbleData.isDef()) {
                    if (bubbleData.getBcode() == 0 || bubbleData.canUse() || loadBoolean) {
                        a.this.Eq(bubbleData.getBcode());
                    } else if (bubbleData.isFree()) {
                        if (a.this.mContext instanceof TbPageContextSupport) {
                            c.a(((TbPageContextSupport) a.this.mContext).getPageContext(), bubbleData, a.this.lna);
                        }
                    } else if (a.this.mContext instanceof TbPageContextSupport) {
                        c.b(((TbPageContextSupport) a.this.mContext).getPageContext(), bubbleData, a.this.lnb);
                    }
                }
            }
        }
    };
    private c.a lna = new c.a() { // from class: com.baidu.tieba.memberCenter.a.a.6
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Er(int i) {
            a.this.Eq(i);
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dfi() {
        }
    };
    private c.a lnb = new c.a() { // from class: com.baidu.tieba.memberCenter.a.a.7
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Er(int i) {
            a.this.lnF.Eu(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(a.this.mContext, true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable");
            memberPayActivityConfig.setSceneId("4002001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dfi() {
        }
    };

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(final Context context) {
        this.mContext = context;
        a.b bVar = new a.b();
        bVar.fGp = R.drawable.icon_bubble;
        bVar.fGq = 0;
        setVerticalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26));
        setHorizontalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30));
        a(bVar);
        setColumn(2);
        ri(2);
        a(new a.InterfaceC0581a() { // from class: com.baidu.tieba.memberCenter.a.a.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0581a
            public View getView(int i, View view, ViewGroup viewGroup) {
                BubbleView bubbleView;
                if (view == null) {
                    BubbleView bubbleView2 = new BubbleView(context);
                    bubbleView = bubbleView2;
                    view = bubbleView2;
                } else {
                    bubbleView = (BubbleView) view;
                }
                BubbleListData.BubbleData Es = a.this.Es(i);
                if (Es != null) {
                    bubbleView.setData(Es, BubbleListModel.eR(a.this.lnG.getB_info()));
                    bubbleView.setGravity(17);
                    bubbleView.setTag(Integer.valueOf(i));
                    bubbleView.setOnClickListener(a.this.lnI);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) j.J(a.this.mContext);
                tbPageContext.getLayoutMode().setNightMode(skinType == 1);
                tbPageContext.getLayoutMode().onModeChanged(view);
                return view;
            }
        });
        this.lnH = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lnF == null) {
            if (this.mContext instanceof TbPageContext) {
                this.lnF = new BubbleListModel((TbPageContext) this.mContext);
            } else {
                this.lnF = new BubbleListModel(null);
            }
        }
        this.lnF.a(this.lmY);
        this.lnF.a(this.lmZ);
        this.lnF.a(this.lnc);
        this.lnF.dfo();
        this.lnF.dfp();
        if (bCC() != null) {
            bCC().preLoad();
        }
        this.lnF.I(0, 50, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq(int i) {
        this.lnF.W(i, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
        this.lnF.Et(i);
        if (bCC() != null) {
            bCC().preLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfq() {
        boolean z = false;
        if (this.lnG != null && this.lnG.getB_info() != null && this.lnG.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.lnG.getB_info().get(0).getBcode() != 0) {
                this.lnG.getB_info().add(0, bubbleData);
            }
            this.dBW = 0;
            int i = 0;
            while (true) {
                if (i >= this.lnG.getB_info().size()) {
                    break;
                } else if (!this.lnG.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.dBW = i;
                    this.lnH = this.lnG.getB_info().get(i).getBg_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.lnH);
                    break;
                }
            }
        }
        if (this.dBW == 0 || TextUtils.isEmpty(this.lnH)) {
            b(new com.baidu.tbadk.editortools.a(2, 12, null));
        } else {
            b(new com.baidu.tbadk.editortools.a(2, 12, " "));
            z = true;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, Boolean.valueOf(z)));
        b(new com.baidu.tbadk.editortools.a(25, -1, this.lnH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData Es(int i) {
        if (i < 0 || i >= getCount() || this.lnG == null) {
            return null;
        }
        return this.lnG.getB_info().get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.lnG == null || this.lnG.getB_info() == null) {
            return 0;
        }
        return this.lnG.getB_info().size();
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        if (this.lnF != null) {
            this.lnF.unRegisterListener();
            this.lnF.b(this.lnc);
            this.lnF = null;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (this.lnF == null) {
            if (this.mContext instanceof TbPageContext) {
                this.lnF = new BubbleListModel((TbPageContext) this.mContext);
            } else {
                this.lnF = new BubbleListModel(null);
            }
        }
        if (bCC() != null) {
            bCC().preLoad();
        }
        this.lnF.I(0, 50, l.getEquipmentWidth(this.mContext), l.getEquipmentHeight(this.mContext));
    }
}

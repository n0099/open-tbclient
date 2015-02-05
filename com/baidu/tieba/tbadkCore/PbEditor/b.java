package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
/* loaded from: classes.dex */
public class b extends ao {
    private com.baidu.tieba.tbadkCore.bubble.h bUX;
    private BubbleListData bUY;
    private int bUZ;
    private String bVa;
    private boolean bVb;
    private com.baidu.tieba.tbadkCore.bubble.k bVc;
    private com.baidu.tieba.tbadkCore.bubble.l bVd;
    public CustomMessageListener bVe;
    private View.OnClickListener bVf;
    private com.baidu.tieba.tbadkCore.bubble.x bVg;
    private com.baidu.tieba.tbadkCore.bubble.x bVh;
    private Context mContext;

    public b(au auVar) {
        super(auVar);
        this.bUZ = 0;
        this.bVb = false;
        this.bVc = new c(this);
        this.bVd = new d(this);
        this.bVe = new e(this, 2010040);
        this.bVf = new f(this);
        this.bVg = new g(this);
        this.bVh = new h(this);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public void init(Context context) {
        if (this.bVb) {
            if (agv() != null) {
                agv().b(this);
                return;
            }
            return;
        }
        this.bVb = true;
        this.mContext = context;
        aq aqVar = new aq();
        aqVar.bWK = com.baidu.tieba.v.icon_bubble;
        aqVar.bWL = 0;
        setVerticalSpacing(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26));
        setHorizontalSpacing(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30));
        a(aqVar);
        hR(2);
        hS(2);
        a(new i(this, context));
        this.bVa = TbadkCoreApplication.m255getInst().getDefaultBubble();
        if (this.bUX == null) {
            if (this.mContext instanceof TbPageContext) {
                this.bUX = new com.baidu.tieba.tbadkCore.bubble.h((TbPageContext) this.mContext);
            } else {
                this.bUX = new com.baidu.tieba.tbadkCore.bubble.h(null);
            }
        }
        this.bUX.a(this.bVc);
        this.bUX.a(this.bVd);
        this.bUX.b(this.bVe);
        this.bUX.agQ();
        this.bUX.agR();
        if (agv() != null) {
            agv().OA();
        }
        this.bUX.g(0, 50, com.baidu.adp.lib.util.l.M(this.mContext), com.baidu.adp.lib.util.l.N(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(int i) {
        this.bUX.w(i, com.baidu.adp.lib.util.l.M(this.mContext), com.baidu.adp.lib.util.l.N(this.mContext));
        this.bUX.hU(i);
        if (agv() != null) {
            agv().OA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        int i = 0;
        if (this.bUY != null && this.bUY.getB_info() != null && this.bUY.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.bUY.getB_info().get(0).getBcode() != 0) {
                this.bUY.getB_info().add(0, bubbleData);
            }
            this.bUZ = 0;
            while (true) {
                if (i >= this.bUY.getB_info().size()) {
                    break;
                } else if (!this.bUY.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.bUZ = i;
                    break;
                }
            }
        }
        if (agw() != null) {
            if (this.bUZ == 0 || TextUtils.isEmpty(this.bVa)) {
                agw().handleAction(47, null);
            } else {
                agw().handleAction(46, this.bVa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData hM(int i) {
        if (i < 0 || i >= getCount() || this.bUY == null) {
            return null;
        }
        return this.bUY.getB_info().get(i);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public int getCount() {
        if (this.bUY == null || this.bUY.getB_info() == null) {
            return 0;
        }
        return this.bUY.getB_info().size();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public void exit() {
        if (this.bUX != null) {
            this.bUX.unRegisterListener();
            this.bUX.c(this.bVe);
            this.bUX = null;
            this.bVb = false;
        }
    }
}

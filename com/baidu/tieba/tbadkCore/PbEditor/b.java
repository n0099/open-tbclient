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
    private com.baidu.tieba.tbadkCore.bubble.h bUY;
    private BubbleListData bUZ;
    private int bVa;
    private String bVb;
    private boolean bVc;
    private com.baidu.tieba.tbadkCore.bubble.k bVd;
    private com.baidu.tieba.tbadkCore.bubble.l bVe;
    public CustomMessageListener bVf;
    private View.OnClickListener bVg;
    private com.baidu.tieba.tbadkCore.bubble.x bVh;
    private com.baidu.tieba.tbadkCore.bubble.x bVi;
    private Context mContext;

    public b(au auVar) {
        super(auVar);
        this.bVa = 0;
        this.bVc = false;
        this.bVd = new c(this);
        this.bVe = new d(this);
        this.bVf = new e(this, 2010040);
        this.bVg = new f(this);
        this.bVh = new g(this);
        this.bVi = new h(this);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public void init(Context context) {
        if (this.bVc) {
            if (agA() != null) {
                agA().b(this);
                return;
            }
            return;
        }
        this.bVc = true;
        this.mContext = context;
        aq aqVar = new aq();
        aqVar.bWL = com.baidu.tieba.v.icon_bubble;
        aqVar.bWM = 0;
        setVerticalSpacing(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26));
        setHorizontalSpacing(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30));
        a(aqVar);
        hR(2);
        hS(2);
        a(new i(this, context));
        this.bVb = TbadkCoreApplication.m255getInst().getDefaultBubble();
        if (this.bUY == null) {
            if (this.mContext instanceof TbPageContext) {
                this.bUY = new com.baidu.tieba.tbadkCore.bubble.h((TbPageContext) this.mContext);
            } else {
                this.bUY = new com.baidu.tieba.tbadkCore.bubble.h(null);
            }
        }
        this.bUY.a(this.bVd);
        this.bUY.a(this.bVe);
        this.bUY.b(this.bVf);
        this.bUY.agV();
        this.bUY.agW();
        if (agA() != null) {
            agA().OF();
        }
        this.bUY.g(0, 50, com.baidu.adp.lib.util.l.M(this.mContext), com.baidu.adp.lib.util.l.N(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(int i) {
        this.bUY.w(i, com.baidu.adp.lib.util.l.M(this.mContext), com.baidu.adp.lib.util.l.N(this.mContext));
        this.bUY.hU(i);
        if (agA() != null) {
            agA().OF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afp() {
        int i = 0;
        if (this.bUZ != null && this.bUZ.getB_info() != null && this.bUZ.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.bUZ.getB_info().get(0).getBcode() != 0) {
                this.bUZ.getB_info().add(0, bubbleData);
            }
            this.bVa = 0;
            while (true) {
                if (i >= this.bUZ.getB_info().size()) {
                    break;
                } else if (!this.bUZ.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.bVa = i;
                    break;
                }
            }
        }
        if (agB() != null) {
            if (this.bVa == 0 || TextUtils.isEmpty(this.bVb)) {
                agB().handleAction(47, null);
            } else {
                agB().handleAction(46, this.bVb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData hM(int i) {
        if (i < 0 || i >= getCount() || this.bUZ == null) {
            return null;
        }
        return this.bUZ.getB_info().get(i);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public int getCount() {
        if (this.bUZ == null || this.bUZ.getB_info() == null) {
            return 0;
        }
        return this.bUZ.getB_info().size();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public void exit() {
        if (this.bUY != null) {
            this.bUY.unRegisterListener();
            this.bUY.c(this.bVf);
            this.bUY = null;
            this.bVc = false;
        }
    }
}

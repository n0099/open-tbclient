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
    private com.baidu.tieba.tbadkCore.bubble.h bTf;
    private BubbleListData bTg;
    private int bTh;
    private String bTi;
    private boolean bTj;
    private com.baidu.tieba.tbadkCore.bubble.k bTk;
    private com.baidu.tieba.tbadkCore.bubble.l bTl;
    public CustomMessageListener bTm;
    private View.OnClickListener bTn;
    private com.baidu.tieba.tbadkCore.bubble.x bTo;
    private com.baidu.tieba.tbadkCore.bubble.x bTp;
    private Context mContext;

    public b(au auVar) {
        super(auVar);
        this.bTh = 0;
        this.bTj = false;
        this.bTk = new c(this);
        this.bTl = new d(this);
        this.bTm = new e(this, 2010040);
        this.bTn = new f(this);
        this.bTo = new g(this);
        this.bTp = new h(this);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public void init(Context context) {
        if (this.bTj) {
            if (afW() != null) {
                afW().b(this);
                return;
            }
            return;
        }
        this.bTj = true;
        this.mContext = context;
        aq aqVar = new aq();
        aqVar.bUS = com.baidu.tieba.v.icon_bubble;
        aqVar.bUT = 0;
        setVerticalSpacing(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds26));
        setHorizontalSpacing(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30));
        a(aqVar);
        hI(2);
        hJ(2);
        a(new i(this, context));
        this.bTi = TbadkCoreApplication.m255getInst().getDefaultBubble();
        if (this.bTf == null) {
            if (this.mContext instanceof TbPageContext) {
                this.bTf = new com.baidu.tieba.tbadkCore.bubble.h((TbPageContext) this.mContext);
            } else {
                this.bTf = new com.baidu.tieba.tbadkCore.bubble.h(null);
            }
        }
        this.bTf.a(this.bTk);
        this.bTf.a(this.bTl);
        this.bTf.b(this.bTm);
        this.bTf.agq();
        this.bTf.agr();
        if (afW() != null) {
            afW().Oj();
        }
        this.bTf.g(0, 50, com.baidu.adp.lib.util.l.M(this.mContext), com.baidu.adp.lib.util.l.N(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(int i) {
        this.bTf.w(i, com.baidu.adp.lib.util.l.M(this.mContext), com.baidu.adp.lib.util.l.N(this.mContext));
        this.bTf.hL(i);
        if (afW() != null) {
            afW().Oj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeL() {
        int i = 0;
        if (this.bTg != null && this.bTg.getB_info() != null && this.bTg.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.bTg.getB_info().get(0).getBcode() != 0) {
                this.bTg.getB_info().add(0, bubbleData);
            }
            this.bTh = 0;
            while (true) {
                if (i >= this.bTg.getB_info().size()) {
                    break;
                } else if (!this.bTg.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.bTh = i;
                    break;
                }
            }
        }
        if (afX() != null) {
            if (this.bTh == 0 || TextUtils.isEmpty(this.bTi)) {
                afX().handleAction(47, null);
            } else {
                afX().handleAction(46, this.bTi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData hD(int i) {
        if (i < 0 || i >= getCount() || this.bTg == null) {
            return null;
        }
        return this.bTg.getB_info().get(i);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public int getCount() {
        if (this.bTg == null || this.bTg.getB_info() == null) {
            return 0;
        }
        return this.bTg.getB_info().size();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ao
    public void exit() {
        if (this.bTf != null) {
            this.bTf.unRegisterListener();
            this.bTf.c(this.bTm);
            this.bTf = null;
            this.bTj = false;
        }
    }
}

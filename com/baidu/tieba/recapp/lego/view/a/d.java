package com.baidu.tieba.recapp.lego.view.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.j;
import com.baidu.tieba.card.r;
import com.baidu.tieba.lego.card.e.k;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
/* loaded from: classes3.dex */
public abstract class d<T extends PostAdBaseData> extends LinearLayout implements k<T> {
    protected TbPageContext aRG;
    protected int faw;
    protected View fbl;
    protected com.baidu.tieba.lego.card.a fbq;
    protected com.baidu.tieba.lego.card.c fbr;
    private boolean isInit;
    protected int mSkinType;
    protected int position;

    protected abstract void a(T t, int i);

    protected abstract View aPS();

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.position = 0;
        this.aRG = tbPageContext;
        setOrientation(1);
    }

    public void a(T t) {
    }

    protected final void b(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            ak akVar = new ak(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    akVar.ab(split[0], split[1]);
                }
            }
            akVar.s("obj_locate", getStatPosition());
            akVar.ab("obj_param3", j.alf());
            r.als().a(akVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.recapp.lego.view.a.d<T extends com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.e.k
    public void aT(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            b((PostAdBaseData) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aPY();
                a((PostAdBaseData) updateCard, this.mSkinType);
            }
            aPW();
            a((PostAdBaseData) updateCard);
            c((PostAdBaseData) updateCard);
        }
    }

    private void aPY() {
    }

    protected final void c(T t) {
    }

    public final void aPW() {
        this.fbl.setVisibility(0);
    }

    private void init() {
        aPU();
        aPV();
        this.isInit = false;
    }

    protected void aPV() {
    }

    public final void aPU() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fbl = aPS();
        frameLayout.addView(this.fbl, aPT());
        addView(frameLayout, layoutParams);
    }

    protected final ViewGroup.LayoutParams aPT() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public int getStatPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void setPosition(int i) {
        this.position = i;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void setBusinessType(int i) {
        this.faw = i;
    }

    public int getBusinessType() {
        return 0;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aPZ() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQa() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQb() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.fbq = aVar;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.fbr = cVar;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQc() {
    }
}

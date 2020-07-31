package com.baidu.tieba.recapp.lego.view.postad;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes20.dex */
public abstract class PostAdBaseView<T extends PostAdBaseData> extends LinearLayout implements e<T> {
    protected TbPageContext dVN;
    private boolean isInit;
    protected View jzJ;
    protected a jzO;
    protected c jzP;
    protected int mBusinessType;
    protected int mSkinType;
    protected int position;

    protected abstract void a(T t, int i);

    protected abstract View cBx();

    public PostAdBaseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.position = 0;
        this.dVN = tbPageContext;
        setOrientation(1);
    }

    public void a(T t) {
    }

    protected final void b(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            ap apVar = new ap(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split(ETAG.EQUAL);
                if (split.length == 2) {
                    apVar.dn(split[0], split[1]);
                }
            }
            apVar.ah("obj_locate", getStatPosition());
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, m.bRC());
            s.bRL().e(apVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView<T extends com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public void aE(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            b((PostAdBaseData) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                cBB();
                a((PostAdBaseData) updateCard, this.mSkinType);
            }
            cBA();
            a((PostAdBaseData) updateCard);
            c((PostAdBaseData) updateCard);
        }
    }

    private void cBB() {
    }

    protected final void c(T t) {
    }

    public final void cBA() {
        this.jzJ.setVisibility(0);
    }

    private void init() {
        cBz();
        Zj();
        this.isInit = false;
    }

    protected void Zj() {
    }

    public final void cBz() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jzJ = cBx();
        frameLayout.addView(this.jzJ, cBy());
        addView(frameLayout, layoutParams);
    }

    protected final ViewGroup.LayoutParams cBy() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public int getStatPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setPosition(int i) {
        this.position = i;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setBusinessType(int i) {
        this.mBusinessType = i;
    }

    public int getBusinessType() {
        return 0;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cBC() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aBi() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cov() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void m(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(a aVar) {
        this.jzO = aVar;
    }

    public void setDownloadAppCallback(c cVar) {
        this.jzP = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cBD() {
    }
}

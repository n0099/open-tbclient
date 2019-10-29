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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
/* loaded from: classes3.dex */
public abstract class PostAdBaseView<T extends PostAdBaseData> extends LinearLayout implements e<T> {
    protected TbPageContext cfl;
    protected int heO;
    protected View hfI;
    protected a hfN;
    protected c hfO;
    private boolean isInit;
    protected int mSkinType;
    protected int position;

    protected abstract void a(T t, int i);

    protected abstract View bIg();

    public PostAdBaseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.position = 0;
        this.cfl = tbPageContext;
        setOrientation(1);
    }

    public void a(T t) {
    }

    protected final void b(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            an anVar = new an(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    anVar.bS(split[0], split[1]);
                }
            }
            anVar.O("obj_locate", getStatPosition());
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, n.ban());
            t.baw().c(anVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView<T extends com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public void al(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            b((PostAdBaseData) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                bIk();
                a((PostAdBaseData) updateCard, this.mSkinType);
            }
            bIj();
            a((PostAdBaseData) updateCard);
            c((PostAdBaseData) updateCard);
        }
    }

    private void bIk() {
    }

    protected final void c(T t) {
    }

    public final void bIj() {
        this.hfI.setVisibility(0);
    }

    private void init() {
        bIi();
        DP();
        this.isInit = false;
    }

    protected void DP() {
    }

    public final void bIi() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.hfI = bIg();
        frameLayout.addView(this.hfI, bIh());
        addView(frameLayout, layoutParams);
    }

    protected final ViewGroup.LayoutParams bIh() {
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
        this.heO = i;
    }

    public int getBusinessType() {
        return 0;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bIl() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void VH() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bIm() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void j(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(a aVar) {
        this.hfN = aVar;
    }

    public void setDownloadAppCallback(c cVar) {
        this.hfO = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bIn() {
    }
}

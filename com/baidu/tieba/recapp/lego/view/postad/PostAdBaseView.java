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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes13.dex */
public abstract class PostAdBaseView<T extends PostAdBaseData> extends LinearLayout implements e<T> {
    protected TbPageContext dPv;
    private boolean isInit;
    protected View jrg;
    protected a jrl;
    protected c jrm;
    protected int mBusinessType;
    protected int mSkinType;
    protected int position;

    protected abstract void a(T t, int i);

    protected abstract View cxz();

    public PostAdBaseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.position = 0;
        this.dPv = tbPageContext;
        setOrientation(1);
    }

    public void a(T t) {
    }

    protected final void b(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            ao aoVar = new ao(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split(ETAG.EQUAL);
                if (split.length == 2) {
                    aoVar.dk(split[0], split[1]);
                }
            }
            aoVar.ag("obj_locate", getStatPosition());
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, m.bOs());
            s.bOB().e(aoVar);
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
                cxD();
                a((PostAdBaseData) updateCard, this.mSkinType);
            }
            cxC();
            a((PostAdBaseData) updateCard);
            c((PostAdBaseData) updateCard);
        }
    }

    private void cxD() {
    }

    protected final void c(T t) {
    }

    public final void cxC() {
        this.jrg.setVisibility(0);
    }

    private void init() {
        cxB();
        Yt();
        this.isInit = false;
    }

    protected void Yt() {
    }

    public final void cxB() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jrg = cxz();
        frameLayout.addView(this.jrg, cxA());
        addView(frameLayout, layoutParams);
    }

    protected final ViewGroup.LayoutParams cxA() {
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
    public void cxE() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void axS() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void ckV() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(a aVar) {
        this.jrl = aVar;
    }

    public void setDownloadAppCallback(c cVar) {
        this.jrm = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cxF() {
    }
}

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
import com.baidu.tbadk.core.util.aq;
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
    protected TbPageContext efn;
    private boolean isInit;
    protected View jPf;
    protected a jPk;
    protected c jPl;
    protected int mBusinessType;
    protected int mSkinType;
    protected int position;

    protected abstract void a(T t, int i);

    protected abstract View cMp();

    public PostAdBaseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.position = 0;
        this.efn = tbPageContext;
        setOrientation(1);
    }

    public void a(T t) {
    }

    protected final void b(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            aq aqVar = new aq(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split(ETAG.EQUAL);
                if (split.length == 2) {
                    aqVar.dD(split[0], split[1]);
                }
            }
            aqVar.ai("obj_locate", getStatPosition());
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, m.cbO());
            s.cbX().e(aqVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView<T extends com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public void aG(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            b((PostAdBaseData) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                cMt();
                a((PostAdBaseData) updateCard, this.mSkinType);
            }
            cMs();
            a((PostAdBaseData) updateCard);
            c((PostAdBaseData) updateCard);
        }
    }

    private void cMt() {
    }

    protected final void c(T t) {
    }

    public final void cMs() {
        this.jPf.setVisibility(0);
    }

    private void init() {
        cMr();
        afs();
        this.isInit = false;
    }

    protected void afs() {
    }

    public final void cMr() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jPf = cMp();
        frameLayout.addView(this.jPf, cMq());
        addView(frameLayout, layoutParams);
    }

    protected final ViewGroup.LayoutParams cMq() {
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
    public void cMu() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aJY() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void czo() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void m(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(a aVar) {
        this.jPk = aVar;
    }

    public void setDownloadAppCallback(c cVar) {
        this.jPl = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cMv() {
    }
}

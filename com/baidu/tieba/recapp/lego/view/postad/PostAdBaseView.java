package com.baidu.tieba.recapp.lego.view.postad;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public abstract class PostAdBaseView<T extends PostAdBaseData> extends LinearLayout implements e<T> {
    protected int fpB;
    protected a fqA;
    protected c fqB;
    protected View fqv;
    private boolean isInit;
    protected TbPageContext mContext;
    protected int mSkinType;
    protected int position;

    protected abstract void a(T t, int i);

    protected abstract View aYY();

    public PostAdBaseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.position = 0;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    public void a(T t) {
    }

    protected final void b(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            am amVar = new am(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split(ETAG.EQUAL);
                if (split.length == 2) {
                    amVar.aA(split[0], split[1]);
                }
            }
            amVar.x("obj_locate", getStatPosition());
            amVar.aA("obj_param3", o.aqj());
            v.aqs().a(amVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView<T extends com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public void Z(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            b((PostAdBaseData) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aZc();
                a((PostAdBaseData) updateCard, this.mSkinType);
            }
            aZb();
            a((PostAdBaseData) updateCard);
            c((PostAdBaseData) updateCard);
        }
    }

    private void aZc() {
    }

    protected final void c(T t) {
    }

    public final void aZb() {
        this.fqv.setVisibility(0);
    }

    private void init() {
        aZa();
        postInit();
        this.isInit = false;
    }

    protected void postInit() {
    }

    public final void aZa() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fqv = aYY();
        frameLayout.addView(this.fqv, aYZ());
        addView(frameLayout, layoutParams);
    }

    protected final ViewGroup.LayoutParams aYZ() {
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
        this.fpB = i;
    }

    public int getBusinessType() {
        return 0;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZd() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZe() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZf() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(a aVar) {
        this.fqA = aVar;
    }

    public void setDownloadAppCallback(c cVar) {
        this.fqB = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZg() {
    }
}

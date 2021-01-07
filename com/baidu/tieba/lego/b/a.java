package com.baidu.tieba.lego.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.lego.card.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends e {
    private TbPageContext eXu;
    protected boolean fKN;
    private NoDataView fKO;
    private FrameLayout fKP;
    private NoDataViewFactory.d fKQ;
    private NoDataViewFactory.c fKR;
    private NoDataViewFactory.b fKS;
    private FrameLayout.LayoutParams fKT;
    private String from;
    private boolean jia;
    private List<ICardInfo> kXL;
    private int mCount;

    protected void bHh() {
        if (this.fKP != null && this.fKO != null) {
            this.fKP.removeView(this.fKO);
            this.fKO = null;
        }
    }

    protected View bHi() {
        if (this.fKP == null) {
            this.fKP = new FrameLayout(this.eXu.getPageActivity());
        }
        if (this.fKO == null) {
            this.fKO = NoDataViewFactory.a(this.eXu.getPageActivity(), this.fKP, this.fKR, this.fKQ, this.fKS);
        }
        this.fKO.setVisibility(0);
        if (this.fKT != null) {
            this.fKO.setLayoutParams(this.fKT);
        }
        this.fKP.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fKO.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        return this.fKP;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fKR = cVar;
        this.fKQ = dVar;
        this.fKS = bVar;
        this.fKT = layoutParams;
        if (this.fKO != null) {
            this.fKO.setTextOption(dVar);
            this.fKO.setImgOption(cVar);
            this.fKO.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fKO.setLayoutParams(layoutParams);
            }
        }
    }

    public void tv(boolean z) {
        this.fKN = z;
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mCount = 0;
        this.fKN = true;
        this.eXu = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter, com.baidu.adp.widget.ListView.o
    public int getCount() {
        if (this.mCount == 0 && this.fKN) {
            return 1;
        }
        return this.mCount;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mCount == 0;
    }

    private int getAdapterCount() {
        int i = 0;
        if (this.kXL == null) {
            return 0;
        }
        Iterator<ICardInfo> it = this.kXL.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().getAdapterCount() + i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter, com.baidu.adp.widget.ListView.o
    /* renamed from: Fc */
    public ICardInfo getItem(int i) {
        return getAdapterItem(i);
    }

    private ICardInfo getAdapterItem(int i) {
        for (ICardInfo iCardInfo : this.kXL) {
            int adapterCount = iCardInfo.getAdapterCount();
            if (i < adapterCount) {
                return iCardInfo.getAdapterItem(i);
            }
            i -= adapterCount;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        ICardInfo adapterItem = getAdapterItem(i);
        if (adapterItem != null) {
            return com.baidu.tieba.lego.card.e.kXO.get(adapterItem.getAdapterType());
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return com.baidu.tieba.lego.card.e.kXO.size() + 1;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.fKN && isDataEmpty()) {
            return bHi();
        }
        bHh();
        Fd(i);
        ICardInfo adapterItem = getAdapterItem(i);
        BaseLegoCardView a2 = a(view, adapterItem);
        if (a2 != null) {
            a2.mFrom = this.from;
            a2.aN(adapterItem);
            return a2;
        }
        return a2;
    }

    private void Fd(int i) {
        if (this.jia) {
            int Ff = Ff(i - 1);
            int Ff2 = Ff(i - 2);
            Fe(Ff);
            Fe(Ff2);
            return;
        }
        int Ff3 = Ff(i + 1);
        int Ff4 = Ff(i + 2);
        Fe(Ff3);
        Fe(Ff4);
    }

    private void Fe(int i) {
        ICardInfo iCardInfo = this.kXL.get(i);
        if (iCardInfo instanceof com.baidu.tieba.lego.card.b.a) {
            ((com.baidu.tieba.lego.card.b.a) iCardInfo).doLoad(iCardInfo, this.eXu);
        }
    }

    private int Ff(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i >= this.kXL.size()) {
            return this.kXL.size() - 1;
        }
        return i;
    }

    public BaseLegoCardView a(View view, ICardInfo iCardInfo) {
        if (iCardInfo == null) {
            return null;
        }
        if (view instanceof BaseLegoCardView) {
            return (BaseLegoCardView) view;
        }
        return (BaseLegoCardView) b.ddm().a(this.eXu, iCardInfo, 0);
    }

    public void eM(List<ICardInfo> list) {
        if (this.kXL == null) {
            this.kXL = new ArrayList();
        } else {
            this.kXL.clear();
        }
        if (list != null) {
            this.kXL.addAll(list);
        }
        this.mCount = getAdapterCount();
        notifyDataSetChanged();
    }

    protected boolean isDataEmpty() {
        return this.kXL != null && this.kXL.size() == 0;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void tw(boolean z) {
        this.jia = z;
    }
}

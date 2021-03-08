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
/* loaded from: classes8.dex */
public class a extends e {
    private TbPageContext eWx;
    protected boolean fJR;
    private NoDataView fJS;
    private FrameLayout fJT;
    private NoDataViewFactory.d fJU;
    private NoDataViewFactory.c fJV;
    private NoDataViewFactory.b fJW;
    private FrameLayout.LayoutParams fJX;
    private String from;
    private boolean jkX;
    private List<ICardInfo> ldA;
    private int mCount;

    protected void bDJ() {
        if (this.fJT != null && this.fJS != null) {
            this.fJT.removeView(this.fJS);
            this.fJS = null;
        }
    }

    protected View bDK() {
        if (this.fJT == null) {
            this.fJT = new FrameLayout(this.eWx.getPageActivity());
        }
        if (this.fJS == null) {
            this.fJS = NoDataViewFactory.a(this.eWx.getPageActivity(), this.fJT, this.fJV, this.fJU, this.fJW);
        }
        this.fJS.setVisibility(0);
        if (this.fJX != null) {
            this.fJS.setLayoutParams(this.fJX);
        }
        this.fJT.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fJS.onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        return this.fJT;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fJV = cVar;
        this.fJU = dVar;
        this.fJW = bVar;
        this.fJX = layoutParams;
        if (this.fJS != null) {
            this.fJS.setTextOption(dVar);
            this.fJS.setImgOption(cVar);
            this.fJS.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fJS.setLayoutParams(layoutParams);
            }
        }
    }

    public void tE(boolean z) {
        this.fJR = z;
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mCount = 0;
        this.fJR = true;
        this.eWx = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter, com.baidu.adp.widget.ListView.o
    public int getCount() {
        if (this.mCount == 0 && this.fJR) {
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
        if (this.ldA == null) {
            return 0;
        }
        Iterator<ICardInfo> it = this.ldA.iterator();
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
    /* renamed from: DR */
    public ICardInfo getItem(int i) {
        return getAdapterItem(i);
    }

    private ICardInfo getAdapterItem(int i) {
        for (ICardInfo iCardInfo : this.ldA) {
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
            return com.baidu.tieba.lego.card.e.ldD.get(adapterItem.getAdapterType());
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return com.baidu.tieba.lego.card.e.ldD.size() + 1;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.fJR && isDataEmpty()) {
            return bDK();
        }
        bDJ();
        DS(i);
        ICardInfo adapterItem = getAdapterItem(i);
        BaseLegoCardView a2 = a(view, adapterItem);
        if (a2 != null) {
            a2.mFrom = this.from;
            a2.aP(adapterItem);
            return a2;
        }
        return a2;
    }

    private void DS(int i) {
        if (this.jkX) {
            int DU = DU(i - 1);
            int DU2 = DU(i - 2);
            DT(DU);
            DT(DU2);
            return;
        }
        int DU3 = DU(i + 1);
        int DU4 = DU(i + 2);
        DT(DU3);
        DT(DU4);
    }

    private void DT(int i) {
        ICardInfo iCardInfo = this.ldA.get(i);
        if (iCardInfo instanceof com.baidu.tieba.lego.card.b.a) {
            ((com.baidu.tieba.lego.card.b.a) iCardInfo).doLoad(iCardInfo, this.eWx);
        }
    }

    private int DU(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i >= this.ldA.size()) {
            return this.ldA.size() - 1;
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
        return (BaseLegoCardView) b.dbI().a(this.eWx, iCardInfo, 0);
    }

    public void eK(List<ICardInfo> list) {
        if (this.ldA == null) {
            this.ldA = new ArrayList();
        } else {
            this.ldA.clear();
        }
        if (list != null) {
            this.ldA.addAll(list);
        }
        this.mCount = getAdapterCount();
        notifyDataSetChanged();
    }

    protected boolean isDataEmpty() {
        return this.ldA != null && this.ldA.size() == 0;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void tF(boolean z) {
        this.jkX = z;
    }
}

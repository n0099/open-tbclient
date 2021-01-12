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
    private TbPageContext eSJ;
    protected boolean fGg;
    private NoDataView fGh;
    private FrameLayout fGi;
    private NoDataViewFactory.d fGj;
    private NoDataViewFactory.c fGk;
    private NoDataViewFactory.b fGl;
    private FrameLayout.LayoutParams fGm;
    private String from;
    private boolean jdt;
    private List<ICardInfo> kTg;
    private int mCount;

    protected void bDo() {
        if (this.fGi != null && this.fGh != null) {
            this.fGi.removeView(this.fGh);
            this.fGh = null;
        }
    }

    protected View bDp() {
        if (this.fGi == null) {
            this.fGi = new FrameLayout(this.eSJ.getPageActivity());
        }
        if (this.fGh == null) {
            this.fGh = NoDataViewFactory.a(this.eSJ.getPageActivity(), this.fGi, this.fGk, this.fGj, this.fGl);
        }
        this.fGh.setVisibility(0);
        if (this.fGm != null) {
            this.fGh.setLayoutParams(this.fGm);
        }
        this.fGi.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fGh.onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        return this.fGi;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fGk = cVar;
        this.fGj = dVar;
        this.fGl = bVar;
        this.fGm = layoutParams;
        if (this.fGh != null) {
            this.fGh.setTextOption(dVar);
            this.fGh.setImgOption(cVar);
            this.fGh.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fGh.setLayoutParams(layoutParams);
            }
        }
    }

    public void tr(boolean z) {
        this.fGg = z;
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mCount = 0;
        this.fGg = true;
        this.eSJ = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter, com.baidu.adp.widget.ListView.o
    public int getCount() {
        if (this.mCount == 0 && this.fGg) {
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
        if (this.kTg == null) {
            return 0;
        }
        Iterator<ICardInfo> it = this.kTg.iterator();
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
    /* renamed from: Dw */
    public ICardInfo getItem(int i) {
        return getAdapterItem(i);
    }

    private ICardInfo getAdapterItem(int i) {
        for (ICardInfo iCardInfo : this.kTg) {
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
            return com.baidu.tieba.lego.card.e.kTj.get(adapterItem.getAdapterType());
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return com.baidu.tieba.lego.card.e.kTj.size() + 1;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.fGg && isDataEmpty()) {
            return bDp();
        }
        bDo();
        Dx(i);
        ICardInfo adapterItem = getAdapterItem(i);
        BaseLegoCardView a2 = a(view, adapterItem);
        if (a2 != null) {
            a2.mFrom = this.from;
            a2.aN(adapterItem);
            return a2;
        }
        return a2;
    }

    private void Dx(int i) {
        if (this.jdt) {
            int Dz = Dz(i - 1);
            int Dz2 = Dz(i - 2);
            Dy(Dz);
            Dy(Dz2);
            return;
        }
        int Dz3 = Dz(i + 1);
        int Dz4 = Dz(i + 2);
        Dy(Dz3);
        Dy(Dz4);
    }

    private void Dy(int i) {
        ICardInfo iCardInfo = this.kTg.get(i);
        if (iCardInfo instanceof com.baidu.tieba.lego.card.b.a) {
            ((com.baidu.tieba.lego.card.b.a) iCardInfo).doLoad(iCardInfo, this.eSJ);
        }
    }

    private int Dz(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i >= this.kTg.size()) {
            return this.kTg.size() - 1;
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
        return (BaseLegoCardView) b.cZu().a(this.eSJ, iCardInfo, 0);
    }

    public void eM(List<ICardInfo> list) {
        if (this.kTg == null) {
            this.kTg = new ArrayList();
        } else {
            this.kTg.clear();
        }
        if (list != null) {
            this.kTg.addAll(list);
        }
        this.mCount = getAdapterCount();
        notifyDataSetChanged();
    }

    protected boolean isDataEmpty() {
        return this.kTg != null && this.kTg.size() == 0;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void ts(boolean z) {
        this.jdt = z;
    }
}

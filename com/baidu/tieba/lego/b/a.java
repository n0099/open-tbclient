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
/* loaded from: classes2.dex */
public class a extends e {
    private NoDataViewFactory.b cpA;
    private FrameLayout.LayoutParams cpB;
    protected boolean cpv;
    private NoDataView cpw;
    private FrameLayout cpx;
    private NoDataViewFactory.d cpy;
    private NoDataViewFactory.c cpz;
    private boolean fbe;
    private String from;
    private List<ICardInfo> gGv;
    private TbPageContext mContext;
    private int mCount;

    protected void aoH() {
        if (this.cpx != null && this.cpw != null) {
            this.cpx.removeView(this.cpw);
            this.cpw = null;
        }
    }

    protected View aoI() {
        if (this.cpx == null) {
            this.cpx = new FrameLayout(this.mContext.getPageActivity());
        }
        if (this.cpw == null) {
            this.cpw = NoDataViewFactory.a(this.mContext.getPageActivity(), this.cpx, this.cpz, this.cpy, this.cpA);
        }
        this.cpw.setVisibility(0);
        if (this.cpB != null) {
            this.cpw.setLayoutParams(this.cpB);
        }
        this.cpx.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cpw.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        return this.cpx;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cpz = cVar;
        this.cpy = dVar;
        this.cpA = bVar;
        this.cpB = layoutParams;
        if (this.cpw != null) {
            this.cpw.setTextOption(dVar);
            this.cpw.setImgOption(cVar);
            this.cpw.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cpw.setLayoutParams(layoutParams);
            }
        }
    }

    public void lV(boolean z) {
        this.cpv = z;
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mCount = 0;
        this.cpv = true;
        this.mContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter, com.baidu.adp.widget.ListView.n
    public int getCount() {
        if (this.mCount == 0 && this.cpv) {
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
        if (this.gGv == null) {
            return 0;
        }
        Iterator<ICardInfo> it = this.gGv.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().getAdapterCount() + i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter, com.baidu.adp.widget.ListView.n
    /* renamed from: uK */
    public ICardInfo getItem(int i) {
        return getAdapterItem(i);
    }

    private ICardInfo getAdapterItem(int i) {
        for (ICardInfo iCardInfo : this.gGv) {
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
            return com.baidu.tieba.lego.card.e.gGz.get(adapterItem.getAdapterType());
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return com.baidu.tieba.lego.card.e.gGz.size() + 1;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.cpv && aoJ()) {
            return aoI();
        }
        aoH();
        uL(i);
        ICardInfo adapterItem = getAdapterItem(i);
        BaseLegoCardView a = a(view, adapterItem);
        if (a != null) {
            a.mFrom = this.from;
            a.aq(adapterItem);
            return a;
        }
        return a;
    }

    private void uL(int i) {
        if (this.fbe) {
            int uN = uN(i - 1);
            int uN2 = uN(i - 2);
            uM(uN);
            uM(uN2);
            return;
        }
        int uN3 = uN(i + 1);
        int uN4 = uN(i + 2);
        uM(uN3);
        uM(uN4);
    }

    private void uM(int i) {
        ICardInfo iCardInfo = this.gGv.get(i);
        if (iCardInfo instanceof com.baidu.tieba.lego.card.c.a) {
            ((com.baidu.tieba.lego.card.c.a) iCardInfo).doLoad(iCardInfo, this.mContext);
        }
    }

    private int uN(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i >= this.gGv.size()) {
            return this.gGv.size() - 1;
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
        return (BaseLegoCardView) b.bzI().a(this.mContext, iCardInfo, 0);
    }

    public void dj(List<ICardInfo> list) {
        if (this.gGv == null) {
            this.gGv = new ArrayList();
        } else {
            this.gGv.clear();
        }
        if (list != null) {
            this.gGv.addAll(list);
        }
        this.mCount = getAdapterCount();
        notifyDataSetChanged();
    }

    protected boolean aoJ() {
        return this.gGv != null && this.gGv.size() == 0;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void lW(boolean z) {
        this.fbe = z;
    }
}

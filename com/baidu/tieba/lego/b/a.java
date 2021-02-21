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
    private TbPageContext eUY;
    protected boolean fIs;
    private NoDataView fIt;
    private FrameLayout fIu;
    private NoDataViewFactory.d fIv;
    private NoDataViewFactory.c fIw;
    private NoDataViewFactory.b fIx;
    private FrameLayout.LayoutParams fIy;
    private String from;
    private boolean jjo;
    private List<ICardInfo> lbx;
    private int mCount;

    protected void bDG() {
        if (this.fIu != null && this.fIt != null) {
            this.fIu.removeView(this.fIt);
            this.fIt = null;
        }
    }

    protected View bDH() {
        if (this.fIu == null) {
            this.fIu = new FrameLayout(this.eUY.getPageActivity());
        }
        if (this.fIt == null) {
            this.fIt = NoDataViewFactory.a(this.eUY.getPageActivity(), this.fIu, this.fIw, this.fIv, this.fIx);
        }
        this.fIt.setVisibility(0);
        if (this.fIy != null) {
            this.fIt.setLayoutParams(this.fIy);
        }
        this.fIu.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fIt.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        return this.fIu;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fIw = cVar;
        this.fIv = dVar;
        this.fIx = bVar;
        this.fIy = layoutParams;
        if (this.fIt != null) {
            this.fIt.setTextOption(dVar);
            this.fIt.setImgOption(cVar);
            this.fIt.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fIt.setLayoutParams(layoutParams);
            }
        }
    }

    public void tE(boolean z) {
        this.fIs = z;
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mCount = 0;
        this.fIs = true;
        this.eUY = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter, com.baidu.adp.widget.ListView.o
    public int getCount() {
        if (this.mCount == 0 && this.fIs) {
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
        if (this.lbx == null) {
            return 0;
        }
        Iterator<ICardInfo> it = this.lbx.iterator();
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
    /* renamed from: DO */
    public ICardInfo getItem(int i) {
        return getAdapterItem(i);
    }

    private ICardInfo getAdapterItem(int i) {
        for (ICardInfo iCardInfo : this.lbx) {
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
            return com.baidu.tieba.lego.card.e.lbA.get(adapterItem.getAdapterType());
        }
        return 0;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return com.baidu.tieba.lego.card.e.lbA.size() + 1;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.fIs && isDataEmpty()) {
            return bDH();
        }
        bDG();
        DP(i);
        ICardInfo adapterItem = getAdapterItem(i);
        BaseLegoCardView a2 = a(view, adapterItem);
        if (a2 != null) {
            a2.mFrom = this.from;
            a2.aN(adapterItem);
            return a2;
        }
        return a2;
    }

    private void DP(int i) {
        if (this.jjo) {
            int DR = DR(i - 1);
            int DR2 = DR(i - 2);
            DQ(DR);
            DQ(DR2);
            return;
        }
        int DR3 = DR(i + 1);
        int DR4 = DR(i + 2);
        DQ(DR3);
        DQ(DR4);
    }

    private void DQ(int i) {
        ICardInfo iCardInfo = this.lbx.get(i);
        if (iCardInfo instanceof com.baidu.tieba.lego.card.b.a) {
            ((com.baidu.tieba.lego.card.b.a) iCardInfo).doLoad(iCardInfo, this.eUY);
        }
    }

    private int DR(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i >= this.lbx.size()) {
            return this.lbx.size() - 1;
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
        return (BaseLegoCardView) b.dbz().a(this.eUY, iCardInfo, 0);
    }

    public void eK(List<ICardInfo> list) {
        if (this.lbx == null) {
            this.lbx = new ArrayList();
        } else {
            this.lbx.clear();
        }
        if (list != null) {
            this.lbx.addAll(list);
        }
        this.mCount = getAdapterCount();
        notifyDataSetChanged();
    }

    protected boolean isDataEmpty() {
        return this.lbx != null && this.lbx.size() == 0;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void tF(boolean z) {
        this.jjo = z;
    }
}

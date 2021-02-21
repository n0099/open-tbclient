package com.baidu.tieba.newdetail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] had = {"最热", "最新"};
    private static final int lyB = had.length;
    private int abv;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> ksQ;
    private bo kux;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        f<?> K = j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.mHotTopicDataList = new ArrayList();
        this.ksQ = new ArrayList();
        HotTopicDetailFeedView Fc = new HotTopicDetailFeedView(context).Fc(1);
        HotTopicDetailFeedView Fc2 = new HotTopicDetailFeedView(context).Fc(0);
        this.ksQ.add(Fc);
        this.ksQ.add(Fc2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return had.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.abv != i) {
            int i2 = this.abv;
            this.abv = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.ksQ, i2 % lyB);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.ksQ, this.abv % lyB);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.abv);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().ES(die());
                } else {
                    hotTopicDetailFeedView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: O */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.ksQ.get(i % had.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return had[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.ksQ) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView dij = dij();
        if (dij != null) {
            dij.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView dij = dij();
        if (dij != null) {
            dij.pause();
        }
    }

    private void Cl(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.ksQ != null && Fb(i) < this.ksQ.size() && (hotTopicDetailFeedView = this.ksQ.get(Fb(i))) != null) {
            hotTopicDetailFeedView.WX();
        }
    }

    private void Cm(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.ksQ != null && Fb(i) < this.ksQ.size() && (hotTopicDetailFeedView = this.ksQ.get(Fb(i))) != null) {
            hotTopicDetailFeedView.WY();
        }
    }

    private void Cn(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.ksQ != null && Fb(i) < this.ksQ.size() && (hotTopicDetailFeedView = this.ksQ.get(Fb(i))) != null) {
            hotTopicDetailFeedView.bSy();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.ksQ.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void EU(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.ksQ != null && Fb(i) < this.ksQ.size() && (hotTopicDetailFeedView = this.ksQ.get(Fb(i))) != null) {
            hotTopicDetailFeedView.ir(true);
        }
    }

    public void EV(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.ksQ != null && Fb(i) < this.ksQ.size() && (hotTopicDetailFeedView = this.ksQ.get(Fb(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void E(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.ksQ != null && Fb(i) < this.ksQ.size() && (hotTopicDetailFeedView = this.ksQ.get(Fb(i))) != null) {
            hotTopicDetailFeedView.qa(z);
        }
    }

    public void EW(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.ksQ != null && Fb(i) < this.ksQ.size() && (hotTopicDetailFeedView = this.ksQ.get(Fb(i))) != null) {
            hotTopicDetailFeedView.WZ();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, Fb(i) % lyB);
        if (dVar2 != null) {
            if (z) {
                dVar2.list = dVar.list;
            } else if (!y.isEmpty(dVar.list)) {
                if (dVar2.list == null) {
                    dVar2.list = new ArrayList();
                }
                dVar2.list.addAll(dVar.list);
            }
            dVar2.pageData = dVar.pageData;
            dVar2.lastId = dVar.lastId;
            if ((dVar2.pageData == null || dVar2.pageData.bmF() == 0) ? false : true) {
                Cl(i);
            } else {
                Cn(i);
                Cm(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.ksQ, Fb(i) % lyB)).setData(dVar2.e(this.kux));
        }
    }

    public d EX(int i) {
        return (d) y.getItem(this.mHotTopicDataList, Fb(i) % lyB);
    }

    private HotTopicDetailFeedView dij() {
        return (HotTopicDetailFeedView) y.getItem(this.ksQ, this.abv % lyB);
    }

    public int die() {
        return this.abv == 1 ? 0 : 1;
    }

    private int Fb(int i) {
        return i == 1 ? 0 : 1;
    }

    public void dif() {
        this.hasInit = true;
    }

    public void c(bo boVar) {
        this.kux = boVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.ksQ) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

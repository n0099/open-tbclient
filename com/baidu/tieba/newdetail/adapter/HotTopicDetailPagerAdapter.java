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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] hbL = {"最热", "最新"};
    private static final int luO = hbL.length;
    private int abC;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> kpa;
    private bm kqH;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        f<?> K = j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.mHotTopicDataList = new ArrayList();
        this.kpa = new ArrayList();
        HotTopicDetailFeedView Gq = new HotTopicDetailFeedView(context).Gq(1);
        HotTopicDetailFeedView Gq2 = new HotTopicDetailFeedView(context).Gq(0);
        this.kpa.add(Gq);
        this.kpa.add(Gq2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return hbL.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.abC != i) {
            int i2 = this.abC;
            this.abC = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) x.getItem(this.kpa, i2 % luO);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) x.getItem(this.kpa, this.abC % luO);
            d dVar = (d) x.getItem(this.mHotTopicDataList, this.abC);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (x.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().Gg(djN());
                } else {
                    hotTopicDetailFeedView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: N */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.kpa.get(i % hbL.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return hbL[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.kpa) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView djS = djS();
        if (djS != null) {
            djS.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView djS = djS();
        if (djS != null) {
            djS.pause();
        }
    }

    private void DA(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kpa != null && Gp(i) < this.kpa.size() && (hotTopicDetailFeedView = this.kpa.get(Gp(i))) != null) {
            hotTopicDetailFeedView.Zg();
        }
    }

    private void DB(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kpa != null && Gp(i) < this.kpa.size() && (hotTopicDetailFeedView = this.kpa.get(Gp(i))) != null) {
            hotTopicDetailFeedView.Zh();
        }
    }

    private void DC(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kpa != null && Gp(i) < this.kpa.size() && (hotTopicDetailFeedView = this.kpa.get(Gp(i))) != null) {
            hotTopicDetailFeedView.bVF();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.kpa.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void Gi(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kpa != null && Gp(i) < this.kpa.size() && (hotTopicDetailFeedView = this.kpa.get(Gp(i))) != null) {
            hotTopicDetailFeedView.it(true);
        }
    }

    public void Gj(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kpa != null && Gp(i) < this.kpa.size() && (hotTopicDetailFeedView = this.kpa.get(Gp(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void E(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kpa != null && Gp(i) < this.kpa.size() && (hotTopicDetailFeedView = this.kpa.get(Gp(i))) != null) {
            hotTopicDetailFeedView.pU(z);
        }
    }

    public void Gk(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kpa != null && Gp(i) < this.kpa.size() && (hotTopicDetailFeedView = this.kpa.get(Gp(i))) != null) {
            hotTopicDetailFeedView.Zi();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) x.getItem(this.mHotTopicDataList, Gp(i) % luO);
        if (dVar2 != null) {
            if (z) {
                dVar2.list = dVar.list;
            } else if (!x.isEmpty(dVar.list)) {
                if (dVar2.list == null) {
                    dVar2.list = new ArrayList();
                }
                dVar2.list.addAll(dVar.list);
            }
            dVar2.pageData = dVar.pageData;
            dVar2.lastId = dVar.lastId;
            if ((dVar2.pageData == null || dVar2.pageData.bqf() == 0) ? false : true) {
                DA(i);
            } else {
                DC(i);
                DB(i);
            }
            ((HotTopicDetailFeedView) x.getItem(this.kpa, Gp(i) % luO)).setData(dVar2.e(this.kqH));
        }
    }

    public d Gl(int i) {
        return (d) x.getItem(this.mHotTopicDataList, Gp(i) % luO);
    }

    private HotTopicDetailFeedView djS() {
        return (HotTopicDetailFeedView) x.getItem(this.kpa, this.abC % luO);
    }

    public int djN() {
        return this.abC == 1 ? 0 : 1;
    }

    private int Gp(int i) {
        return i == 1 ? 0 : 1;
    }

    public void djO() {
        this.hasInit = true;
    }

    public void c(bm bmVar) {
        this.kqH = bmVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.kpa) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

package com.baidu.tieba.newdetail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] fPL = {"最热", "最新"};
    private static final int jWe = fPL.length;
    private int Yz;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> iIt;
    private bi iKb;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        this.mHotTopicDataList = new ArrayList();
        this.iIt = new ArrayList();
        HotTopicDetailFeedView Bf = new HotTopicDetailFeedView(context).Bf(1);
        HotTopicDetailFeedView Bf2 = new HotTopicDetailFeedView(context).Bf(0);
        this.iIt.add(Bf);
        this.iIt.add(Bf2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return fPL.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.Yz != i) {
            int i2 = this.Yz;
            this.Yz = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) x.getItem(this.iIt, i2 % jWe);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) x.getItem(this.iIt, this.Yz % jWe);
            d dVar = (d) x.getItem(this.mHotTopicDataList, this.Yz);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (x.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().AV(cHF());
                } else {
                    hotTopicDetailFeedView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: F */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.iIt.get(i % fPL.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return fPL[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.iIt) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView cHK = cHK();
        if (cHK != null) {
            cHK.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView cHK = cHK();
        if (cHK != null) {
            cHK.pause();
        }
    }

    private void xS(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iIt != null && Be(i) < this.iIt.size() && (hotTopicDetailFeedView = this.iIt.get(Be(i))) != null) {
            hotTopicDetailFeedView.bxS();
        }
    }

    private void xT(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iIt != null && Be(i) < this.iIt.size() && (hotTopicDetailFeedView = this.iIt.get(Be(i))) != null) {
            hotTopicDetailFeedView.bxT();
        }
    }

    private void xU(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iIt != null && Be(i) < this.iIt.size() && (hotTopicDetailFeedView = this.iIt.get(Be(i))) != null) {
            hotTopicDetailFeedView.bxU();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.iIt.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void AX(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iIt != null && Be(i) < this.iIt.size() && (hotTopicDetailFeedView = this.iIt.get(Be(i))) != null) {
            hotTopicDetailFeedView.gw(true);
        }
    }

    public void AY(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iIt != null && Be(i) < this.iIt.size() && (hotTopicDetailFeedView = this.iIt.get(Be(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void C(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iIt != null && Be(i) < this.iIt.size() && (hotTopicDetailFeedView = this.iIt.get(Be(i))) != null) {
            hotTopicDetailFeedView.ng(z);
        }
    }

    public void AZ(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iIt != null && Be(i) < this.iIt.size() && (hotTopicDetailFeedView = this.iIt.get(Be(i))) != null) {
            hotTopicDetailFeedView.bwX();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) x.getItem(this.mHotTopicDataList, Be(i) % jWe);
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
            if ((dVar2.pageData == null || dVar2.pageData.aVb() == 0) ? false : true) {
                xS(i);
            } else {
                xU(i);
                xT(i);
            }
            ((HotTopicDetailFeedView) x.getItem(this.iIt, Be(i) % jWe)).setData(dVar2.e(this.iKb));
        }
    }

    public d Ba(int i) {
        return (d) x.getItem(this.mHotTopicDataList, Be(i) % jWe);
    }

    private HotTopicDetailFeedView cHK() {
        return (HotTopicDetailFeedView) x.getItem(this.iIt, this.Yz % jWe);
    }

    public int cHF() {
        return this.Yz == 1 ? 0 : 1;
    }

    private int Be(int i) {
        return i == 1 ? 0 : 1;
    }

    public void cHG() {
        this.hasInit = true;
    }

    public void c(bi biVar) {
        this.iKb = biVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.iIt) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

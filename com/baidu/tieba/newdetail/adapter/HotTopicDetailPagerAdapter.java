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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] gGP = {"最热", "最新"};
    private static final int lce = gGP.length;
    private int ZV;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> jOj;
    private bk jPQ;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jOj = new ArrayList();
        HotTopicDetailFeedView FJ = new HotTopicDetailFeedView(context).FJ(1);
        HotTopicDetailFeedView FJ2 = new HotTopicDetailFeedView(context).FJ(0);
        this.jOj.add(FJ);
        this.jOj.add(FJ2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gGP.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.ZV != i) {
            int i2 = this.ZV;
            this.ZV = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.jOj, i2 % lce);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.jOj, this.ZV % lce);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.ZV);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().Fz(deQ());
                } else {
                    hotTopicDetailFeedView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: J */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.jOj.get(i % gGP.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gGP[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jOj) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView deV = deV();
        if (deV != null) {
            deV.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView deV = deV();
        if (deV != null) {
            deV.pause();
        }
    }

    private void Cx(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jOj != null && FI(i) < this.jOj.size() && (hotTopicDetailFeedView = this.jOj.get(FI(i))) != null) {
            hotTopicDetailFeedView.Vz();
        }
    }

    private void Cy(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jOj != null && FI(i) < this.jOj.size() && (hotTopicDetailFeedView = this.jOj.get(FI(i))) != null) {
            hotTopicDetailFeedView.VA();
        }
    }

    private void Cz(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jOj != null && FI(i) < this.jOj.size() && (hotTopicDetailFeedView = this.jOj.get(FI(i))) != null) {
            hotTopicDetailFeedView.bPp();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.jOj.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void FB(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jOj != null && FI(i) < this.jOj.size() && (hotTopicDetailFeedView = this.jOj.get(FI(i))) != null) {
            hotTopicDetailFeedView.hM(true);
        }
    }

    public void FC(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jOj != null && FI(i) < this.jOj.size() && (hotTopicDetailFeedView = this.jOj.get(FI(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void F(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jOj != null && FI(i) < this.jOj.size() && (hotTopicDetailFeedView = this.jOj.get(FI(i))) != null) {
            hotTopicDetailFeedView.pb(z);
        }
    }

    public void FD(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jOj != null && FI(i) < this.jOj.size() && (hotTopicDetailFeedView = this.jOj.get(FI(i))) != null) {
            hotTopicDetailFeedView.VB();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, FI(i) % lce);
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
            if ((dVar2.pageData == null || dVar2.pageData.bks() == 0) ? false : true) {
                Cx(i);
            } else {
                Cz(i);
                Cy(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.jOj, FI(i) % lce)).setData(dVar2.e(this.jPQ));
        }
    }

    public d FE(int i) {
        return (d) y.getItem(this.mHotTopicDataList, FI(i) % lce);
    }

    private HotTopicDetailFeedView deV() {
        return (HotTopicDetailFeedView) y.getItem(this.jOj, this.ZV % lce);
    }

    public int deQ() {
        return this.ZV == 1 ? 0 : 1;
    }

    private int FI(int i) {
        return i == 1 ? 0 : 1;
    }

    public void deR() {
        this.hasInit = true;
    }

    public void c(bk bkVar) {
        this.jPQ = bkVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jOj) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

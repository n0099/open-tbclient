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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] gPW = {"最热", "最新"};
    private static final int lpE = gPW.length;
    private int aaR;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> kbM;
    private bl kdt;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.mHotTopicDataList = new ArrayList();
        this.kbM = new ArrayList();
        HotTopicDetailFeedView Gy = new HotTopicDetailFeedView(context).Gy(1);
        HotTopicDetailFeedView Gy2 = new HotTopicDetailFeedView(context).Gy(0);
        this.kbM.add(Gy);
        this.kbM.add(Gy2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gPW.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.aaR != i) {
            int i2 = this.aaR;
            this.aaR = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.kbM, i2 % lpE);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.kbM, this.aaR % lpE);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.aaR);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().Go(dkc());
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
        HotTopicDetailFeedView hotTopicDetailFeedView = this.kbM.get(i % gPW.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gPW[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.kbM) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView dkh = dkh();
        if (dkh != null) {
            dkh.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView dkh = dkh();
        if (dkh != null) {
            dkh.pause();
        }
    }

    private void Dm(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kbM != null && Gx(i) < this.kbM.size() && (hotTopicDetailFeedView = this.kbM.get(Gx(i))) != null) {
            hotTopicDetailFeedView.XZ();
        }
    }

    private void Dn(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kbM != null && Gx(i) < this.kbM.size() && (hotTopicDetailFeedView = this.kbM.get(Gx(i))) != null) {
            hotTopicDetailFeedView.Ya();
        }
    }

    private void Do(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kbM != null && Gx(i) < this.kbM.size() && (hotTopicDetailFeedView = this.kbM.get(Gx(i))) != null) {
            hotTopicDetailFeedView.bTa();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.kbM.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void Gq(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kbM != null && Gx(i) < this.kbM.size() && (hotTopicDetailFeedView = this.kbM.get(Gx(i))) != null) {
            hotTopicDetailFeedView.ib(true);
        }
    }

    public void Gr(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kbM != null && Gx(i) < this.kbM.size() && (hotTopicDetailFeedView = this.kbM.get(Gx(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void F(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kbM != null && Gx(i) < this.kbM.size() && (hotTopicDetailFeedView = this.kbM.get(Gx(i))) != null) {
            hotTopicDetailFeedView.px(z);
        }
    }

    public void Gs(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kbM != null && Gx(i) < this.kbM.size() && (hotTopicDetailFeedView = this.kbM.get(Gx(i))) != null) {
            hotTopicDetailFeedView.Yb();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, Gx(i) % lpE);
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
            if ((dVar2.pageData == null || dVar2.pageData.bnF() == 0) ? false : true) {
                Dm(i);
            } else {
                Do(i);
                Dn(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.kbM, Gx(i) % lpE)).setData(dVar2.e(this.kdt));
        }
    }

    public d Gt(int i) {
        return (d) y.getItem(this.mHotTopicDataList, Gx(i) % lpE);
    }

    private HotTopicDetailFeedView dkh() {
        return (HotTopicDetailFeedView) y.getItem(this.kbM, this.aaR % lpE);
    }

    public int dkc() {
        return this.aaR == 1 ? 0 : 1;
    }

    private int Gx(int i) {
        return i == 1 ? 0 : 1;
    }

    public void dkd() {
        this.hasInit = true;
    }

    public void c(bl blVar) {
        this.kdt = blVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.kbM) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

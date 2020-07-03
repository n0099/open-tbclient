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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] fKq = {"最热", "最新"};
    private static final int jNE = fKq.length;
    private int YJ;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> iCn;
    private bh iDV;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        this.mHotTopicDataList = new ArrayList();
        this.iCn = new ArrayList();
        HotTopicDetailFeedView AG = new HotTopicDetailFeedView(context).AG(1);
        HotTopicDetailFeedView AG2 = new HotTopicDetailFeedView(context).AG(0);
        this.iCn.add(AG);
        this.iCn.add(AG2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return fKq.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.YJ != i) {
            int i2 = this.YJ;
            this.YJ = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) w.getItem(this.iCn, i2 % jNE);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) w.getItem(this.iCn, this.YJ % jNE);
            d dVar = (d) w.getItem(this.mHotTopicDataList, this.YJ);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (w.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().Aw(cDW());
                } else {
                    hotTopicDetailFeedView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: E */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.iCn.get(i % fKq.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return fKq[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.iCn) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView cEb = cEb();
        if (cEb != null) {
            cEb.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView cEb = cEb();
        if (cEb != null) {
            cEb.pause();
        }
    }

    private void xA(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iCn != null && AF(i) < this.iCn.size() && (hotTopicDetailFeedView = this.iCn.get(AF(i))) != null) {
            hotTopicDetailFeedView.buI();
        }
    }

    private void xB(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iCn != null && AF(i) < this.iCn.size() && (hotTopicDetailFeedView = this.iCn.get(AF(i))) != null) {
            hotTopicDetailFeedView.buJ();
        }
    }

    private void xC(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iCn != null && AF(i) < this.iCn.size() && (hotTopicDetailFeedView = this.iCn.get(AF(i))) != null) {
            hotTopicDetailFeedView.buK();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.iCn.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void Ay(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iCn != null && AF(i) < this.iCn.size() && (hotTopicDetailFeedView = this.iCn.get(AF(i))) != null) {
            hotTopicDetailFeedView.ga(true);
        }
    }

    public void Az(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iCn != null && AF(i) < this.iCn.size() && (hotTopicDetailFeedView = this.iCn.get(AF(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void C(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iCn != null && AF(i) < this.iCn.size() && (hotTopicDetailFeedView = this.iCn.get(AF(i))) != null) {
            hotTopicDetailFeedView.mB(z);
        }
    }

    public void AA(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iCn != null && AF(i) < this.iCn.size() && (hotTopicDetailFeedView = this.iCn.get(AF(i))) != null) {
            hotTopicDetailFeedView.btN();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) w.getItem(this.mHotTopicDataList, AF(i) % jNE);
        if (dVar2 != null) {
            if (z) {
                dVar2.list = dVar.list;
            } else if (!w.isEmpty(dVar.list)) {
                if (dVar2.list == null) {
                    dVar2.list = new ArrayList();
                }
                dVar2.list.addAll(dVar.list);
            }
            dVar2.pageData = dVar.pageData;
            dVar2.lastId = dVar.lastId;
            if ((dVar2.pageData == null || dVar2.pageData.aRf() == 0) ? false : true) {
                xA(i);
            } else {
                xC(i);
                xB(i);
            }
            ((HotTopicDetailFeedView) w.getItem(this.iCn, AF(i) % jNE)).setData(dVar2.e(this.iDV));
        }
    }

    public d AB(int i) {
        return (d) w.getItem(this.mHotTopicDataList, AF(i) % jNE);
    }

    private HotTopicDetailFeedView cEb() {
        return (HotTopicDetailFeedView) w.getItem(this.iCn, this.YJ % jNE);
    }

    public int cDW() {
        return this.YJ == 1 ? 0 : 1;
    }

    private int AF(int i) {
        return i == 1 ? 0 : 1;
    }

    public void cDX() {
        this.hasInit = true;
    }

    public void c(bh bhVar) {
        this.iDV = bhVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.iCn) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

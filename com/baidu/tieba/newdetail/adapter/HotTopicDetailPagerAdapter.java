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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] gfb = {"最热", "最新"};
    private static final int kug = gfb.length;
    private int Zz;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> jgd;
    private bj jhK;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jgd = new ArrayList();
        HotTopicDetailFeedView DZ = new HotTopicDetailFeedView(context).DZ(1);
        HotTopicDetailFeedView DZ2 = new HotTopicDetailFeedView(context).DZ(0);
        this.jgd.add(DZ);
        this.jgd.add(DZ2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gfb.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.Zz != i) {
            int i2 = this.Zz;
            this.Zz = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.jgd, i2 % kug);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.jgd, this.Zz % kug);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.Zz);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().DP(cWa());
                } else {
                    hotTopicDetailFeedView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: H */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.jgd.get(i % gfb.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gfb[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jgd) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView cWf = cWf();
        if (cWf != null) {
            cWf.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView cWf = cWf();
        if (cWf != null) {
            cWf.pause();
        }
    }

    private void AN(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jgd != null && DY(i) < this.jgd.size() && (hotTopicDetailFeedView = this.jgd.get(DY(i))) != null) {
            hotTopicDetailFeedView.bIi();
        }
    }

    private void AO(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jgd != null && DY(i) < this.jgd.size() && (hotTopicDetailFeedView = this.jgd.get(DY(i))) != null) {
            hotTopicDetailFeedView.bIj();
        }
    }

    private void AP(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jgd != null && DY(i) < this.jgd.size() && (hotTopicDetailFeedView = this.jgd.get(DY(i))) != null) {
            hotTopicDetailFeedView.bIk();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.jgd.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void DR(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jgd != null && DY(i) < this.jgd.size() && (hotTopicDetailFeedView = this.jgd.get(DY(i))) != null) {
            hotTopicDetailFeedView.gR(true);
        }
    }

    public void DS(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jgd != null && DY(i) < this.jgd.size() && (hotTopicDetailFeedView = this.jgd.get(DY(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void C(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jgd != null && DY(i) < this.jgd.size() && (hotTopicDetailFeedView = this.jgd.get(DY(i))) != null) {
            hotTopicDetailFeedView.nS(z);
        }
    }

    public void DT(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jgd != null && DY(i) < this.jgd.size() && (hotTopicDetailFeedView = this.jgd.get(DY(i))) != null) {
            hotTopicDetailFeedView.bHn();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, DY(i) % kug);
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
            if ((dVar2.pageData == null || dVar2.pageData.beo() == 0) ? false : true) {
                AN(i);
            } else {
                AP(i);
                AO(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.jgd, DY(i) % kug)).setData(dVar2.e(this.jhK));
        }
    }

    public d DU(int i) {
        return (d) y.getItem(this.mHotTopicDataList, DY(i) % kug);
    }

    private HotTopicDetailFeedView cWf() {
        return (HotTopicDetailFeedView) y.getItem(this.jgd, this.Zz % kug);
    }

    public int cWa() {
        return this.Zz == 1 ? 0 : 1;
    }

    private int DY(int i) {
        return i == 1 ? 0 : 1;
    }

    public void cWb() {
        this.hasInit = true;
    }

    public void c(bj bjVar) {
        this.jhK = bjVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jgd) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

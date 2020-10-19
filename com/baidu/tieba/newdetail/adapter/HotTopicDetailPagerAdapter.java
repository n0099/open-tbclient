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
/* loaded from: classes21.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] grq = {"最热", "最新"};
    private static final int kJs = grq.length;
    private int ZP;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> jvc;
    private bj jwJ;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jvc = new ArrayList();
        HotTopicDetailFeedView EF = new HotTopicDetailFeedView(context).EF(1);
        HotTopicDetailFeedView EF2 = new HotTopicDetailFeedView(context).EF(0);
        this.jvc.add(EF);
        this.jvc.add(EF2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return grq.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.ZP != i) {
            int i2 = this.ZP;
            this.ZP = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.jvc, i2 % kJs);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.jvc, this.ZP % kJs);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.ZP);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().Ev(cZJ());
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
        HotTopicDetailFeedView hotTopicDetailFeedView = this.jvc.get(i % grq.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return grq[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jvc) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView cZO = cZO();
        if (cZO != null) {
            cZO.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView cZO = cZO();
        if (cZO != null) {
            cZO.pause();
        }
    }

    private void Bt(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jvc != null && EE(i) < this.jvc.size() && (hotTopicDetailFeedView = this.jvc.get(EE(i))) != null) {
            hotTopicDetailFeedView.SI();
        }
    }

    private void Bu(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jvc != null && EE(i) < this.jvc.size() && (hotTopicDetailFeedView = this.jvc.get(EE(i))) != null) {
            hotTopicDetailFeedView.SJ();
        }
    }

    private void Bv(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jvc != null && EE(i) < this.jvc.size() && (hotTopicDetailFeedView = this.jvc.get(EE(i))) != null) {
            hotTopicDetailFeedView.bKU();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.jvc.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void Ex(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jvc != null && EE(i) < this.jvc.size() && (hotTopicDetailFeedView = this.jvc.get(EE(i))) != null) {
            hotTopicDetailFeedView.hn(true);
        }
    }

    public void Ey(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jvc != null && EE(i) < this.jvc.size() && (hotTopicDetailFeedView = this.jvc.get(EE(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void F(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jvc != null && EE(i) < this.jvc.size() && (hotTopicDetailFeedView = this.jvc.get(EE(i))) != null) {
            hotTopicDetailFeedView.ox(z);
        }
    }

    public void Ez(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jvc != null && EE(i) < this.jvc.size() && (hotTopicDetailFeedView = this.jvc.get(EE(i))) != null) {
            hotTopicDetailFeedView.SK();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, EE(i) % kJs);
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
            if ((dVar2.pageData == null || dVar2.pageData.bgX() == 0) ? false : true) {
                Bt(i);
            } else {
                Bv(i);
                Bu(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.jvc, EE(i) % kJs)).setData(dVar2.e(this.jwJ));
        }
    }

    public d EA(int i) {
        return (d) y.getItem(this.mHotTopicDataList, EE(i) % kJs);
    }

    private HotTopicDetailFeedView cZO() {
        return (HotTopicDetailFeedView) y.getItem(this.jvc, this.ZP % kJs);
    }

    public int cZJ() {
        return this.ZP == 1 ? 0 : 1;
    }

    private int EE(int i) {
        return i == 1 ? 0 : 1;
    }

    public void cZK() {
        this.hasInit = true;
    }

    public void c(bj bjVar) {
        this.jwJ = bjVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jvc) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

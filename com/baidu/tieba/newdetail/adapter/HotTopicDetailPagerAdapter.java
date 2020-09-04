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
/* loaded from: classes15.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] gbO = {"最热", "最新"};
    private static final int klH = gbO.length;
    private int Zh;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> iXx;
    private bj iZf;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.iXx = new ArrayList();
        HotTopicDetailFeedView Dy = new HotTopicDetailFeedView(context).Dy(1);
        HotTopicDetailFeedView Dy2 = new HotTopicDetailFeedView(context).Dy(0);
        this.iXx.add(Dy);
        this.iXx.add(Dy2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gbO.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.Zh != i) {
            int i2 = this.Zh;
            this.Zh = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.iXx, i2 % klH);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.iXx, this.Zh % klH);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.Zh);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().Do(cSv());
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
        HotTopicDetailFeedView hotTopicDetailFeedView = this.iXx.get(i % gbO.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gbO[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.iXx) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView cSA = cSA();
        if (cSA != null) {
            cSA.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView cSA = cSA();
        if (cSA != null) {
            cSA.pause();
        }
    }

    private void Am(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iXx != null && Dx(i) < this.iXx.size() && (hotTopicDetailFeedView = this.iXx.get(Dx(i))) != null) {
            hotTopicDetailFeedView.bGS();
        }
    }

    private void An(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iXx != null && Dx(i) < this.iXx.size() && (hotTopicDetailFeedView = this.iXx.get(Dx(i))) != null) {
            hotTopicDetailFeedView.bGT();
        }
    }

    private void Ao(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iXx != null && Dx(i) < this.iXx.size() && (hotTopicDetailFeedView = this.iXx.get(Dx(i))) != null) {
            hotTopicDetailFeedView.bGU();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.iXx.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void Dq(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iXx != null && Dx(i) < this.iXx.size() && (hotTopicDetailFeedView = this.iXx.get(Dx(i))) != null) {
            hotTopicDetailFeedView.gT(true);
        }
    }

    public void Dr(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iXx != null && Dx(i) < this.iXx.size() && (hotTopicDetailFeedView = this.iXx.get(Dx(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void C(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iXx != null && Dx(i) < this.iXx.size() && (hotTopicDetailFeedView = this.iXx.get(Dx(i))) != null) {
            hotTopicDetailFeedView.nM(z);
        }
    }

    public void Ds(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.iXx != null && Dx(i) < this.iXx.size() && (hotTopicDetailFeedView = this.iXx.get(Dx(i))) != null) {
            hotTopicDetailFeedView.bFX();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, Dx(i) % klH);
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
            if ((dVar2.pageData == null || dVar2.pageData.bdu() == 0) ? false : true) {
                Am(i);
            } else {
                Ao(i);
                An(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.iXx, Dx(i) % klH)).setData(dVar2.e(this.iZf));
        }
    }

    public d Dt(int i) {
        return (d) y.getItem(this.mHotTopicDataList, Dx(i) % klH);
    }

    private HotTopicDetailFeedView cSA() {
        return (HotTopicDetailFeedView) y.getItem(this.iXx, this.Zh % klH);
    }

    public int cSv() {
        return this.Zh == 1 ? 0 : 1;
    }

    private int Dx(int i) {
        return i == 1 ? 0 : 1;
    }

    public void cSw() {
        this.hasInit = true;
    }

    public void c(bj bjVar) {
        this.iZf = bjVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.iXx) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

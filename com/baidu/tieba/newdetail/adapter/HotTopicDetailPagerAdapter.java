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
    private static String[] gBu = {"最热", "最新"};
    private static final int kVP = gBu.length;
    private int ZQ;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> jHB;
    private bj jJi;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jHB = new ArrayList();
        HotTopicDetailFeedView EY = new HotTopicDetailFeedView(context).EY(1);
        HotTopicDetailFeedView EY2 = new HotTopicDetailFeedView(context).EY(0);
        this.jHB.add(EY);
        this.jHB.add(EY2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gBu.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.ZQ != i) {
            int i2 = this.ZQ;
            this.ZQ = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.jHB, i2 % kVP);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.jHB, this.ZQ % kVP);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.ZQ);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().EO(dcR());
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
        HotTopicDetailFeedView hotTopicDetailFeedView = this.jHB.get(i % gBu.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gBu[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jHB) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView dcW = dcW();
        if (dcW != null) {
            dcW.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView dcW = dcW();
        if (dcW != null) {
            dcW.pause();
        }
    }

    private void BM(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jHB != null && EX(i) < this.jHB.size() && (hotTopicDetailFeedView = this.jHB.get(EX(i))) != null) {
            hotTopicDetailFeedView.TI();
        }
    }

    private void BN(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jHB != null && EX(i) < this.jHB.size() && (hotTopicDetailFeedView = this.jHB.get(EX(i))) != null) {
            hotTopicDetailFeedView.TJ();
        }
    }

    private void BO(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jHB != null && EX(i) < this.jHB.size() && (hotTopicDetailFeedView = this.jHB.get(EX(i))) != null) {
            hotTopicDetailFeedView.bNw();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.jHB.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void EQ(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jHB != null && EX(i) < this.jHB.size() && (hotTopicDetailFeedView = this.jHB.get(EX(i))) != null) {
            hotTopicDetailFeedView.hA(true);
        }
    }

    public void ER(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jHB != null && EX(i) < this.jHB.size() && (hotTopicDetailFeedView = this.jHB.get(EX(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void F(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jHB != null && EX(i) < this.jHB.size() && (hotTopicDetailFeedView = this.jHB.get(EX(i))) != null) {
            hotTopicDetailFeedView.oP(z);
        }
    }

    public void ES(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.jHB != null && EX(i) < this.jHB.size() && (hotTopicDetailFeedView = this.jHB.get(EX(i))) != null) {
            hotTopicDetailFeedView.TK();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, EX(i) % kVP);
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
            if ((dVar2.pageData == null || dVar2.pageData.biQ() == 0) ? false : true) {
                BM(i);
            } else {
                BO(i);
                BN(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.jHB, EX(i) % kVP)).setData(dVar2.e(this.jJi));
        }
    }

    public d ET(int i) {
        return (d) y.getItem(this.mHotTopicDataList, EX(i) % kVP);
    }

    private HotTopicDetailFeedView dcW() {
        return (HotTopicDetailFeedView) y.getItem(this.jHB, this.ZQ % kVP);
    }

    public int dcR() {
        return this.ZQ == 1 ? 0 : 1;
    }

    private int EX(int i) {
        return i == 1 ? 0 : 1;
    }

    public void dcS() {
        this.hasInit = true;
    }

    public void c(bj bjVar) {
        this.jJi = bjVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.jHB) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

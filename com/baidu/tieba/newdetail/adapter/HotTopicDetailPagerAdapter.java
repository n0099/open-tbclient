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
/* loaded from: classes7.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    private static String[] hbM = {"最热", "最新"};
    private static final int lAD = hbM.length;
    private int acR;
    private boolean hasInit = false;
    private List<HotTopicDetailFeedView> kuS;
    private bo kwz;
    private List<d> mHotTopicDataList;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPagerAdapter(Context context) {
        f<?> J = j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.mHotTopicDataList = new ArrayList();
        this.kuS = new ArrayList();
        HotTopicDetailFeedView Ff = new HotTopicDetailFeedView(context).Ff(1);
        HotTopicDetailFeedView Ff2 = new HotTopicDetailFeedView(context).Ff(0);
        this.kuS.add(Ff);
        this.kuS.add(Ff2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.mHotTopicDataList.add(dVar);
        this.mHotTopicDataList.add(dVar2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return hbM.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hasInit && this.acR != i) {
            int i2 = this.acR;
            this.acR = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) y.getItem(this.kuS, i2 % lAD);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.pause();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) y.getItem(this.kuS, this.acR % lAD);
            d dVar = (d) y.getItem(this.mHotTopicDataList, this.acR);
            if (hotTopicDetailFeedView2 != null && dVar != null) {
                if (y.isEmpty(dVar.list)) {
                    this.pageContext.getOrignalPage().EV(din());
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
        HotTopicDetailFeedView hotTopicDetailFeedView = this.kuS.get(i % hbM.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return hbM[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void destroy() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.kuS) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicDetailFeedView dis = dis();
        if (dis != null) {
            dis.resume();
        }
    }

    public void pause() {
        HotTopicDetailFeedView dis = dis();
        if (dis != null) {
            dis.pause();
        }
    }

    private void Co(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kuS != null && Fe(i) < this.kuS.size() && (hotTopicDetailFeedView = this.kuS.get(Fe(i))) != null) {
            hotTopicDetailFeedView.Xa();
        }
    }

    private void Cp(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kuS != null && Fe(i) < this.kuS.size() && (hotTopicDetailFeedView = this.kuS.get(Fe(i))) != null) {
            hotTopicDetailFeedView.Xb();
        }
    }

    private void Cq(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kuS != null && Fe(i) < this.kuS.size() && (hotTopicDetailFeedView = this.kuS.get(Fe(i))) != null) {
            hotTopicDetailFeedView.bSE();
        }
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.kuS.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void EX(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kuS != null && Fe(i) < this.kuS.size() && (hotTopicDetailFeedView = this.kuS.get(Fe(i))) != null) {
            hotTopicDetailFeedView.ir(true);
        }
    }

    public void EY(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kuS != null && Fe(i) < this.kuS.size() && (hotTopicDetailFeedView = this.kuS.get(Fe(i))) != null) {
            hotTopicDetailFeedView.hideLoadingView();
        }
    }

    public void E(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kuS != null && Fe(i) < this.kuS.size() && (hotTopicDetailFeedView = this.kuS.get(Fe(i))) != null) {
            hotTopicDetailFeedView.qa(z);
        }
    }

    public void EZ(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.kuS != null && Fe(i) < this.kuS.size() && (hotTopicDetailFeedView = this.kuS.get(Fe(i))) != null) {
            hotTopicDetailFeedView.Xc();
        }
    }

    public void a(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) y.getItem(this.mHotTopicDataList, Fe(i) % lAD);
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
            if ((dVar2.pageData == null || dVar2.pageData.bmH() == 0) ? false : true) {
                Co(i);
            } else {
                Cq(i);
                Cp(i);
            }
            ((HotTopicDetailFeedView) y.getItem(this.kuS, Fe(i) % lAD)).setData(dVar2.e(this.kwz));
        }
    }

    public d Fa(int i) {
        return (d) y.getItem(this.mHotTopicDataList, Fe(i) % lAD);
    }

    private HotTopicDetailFeedView dis() {
        return (HotTopicDetailFeedView) y.getItem(this.kuS, this.acR % lAD);
    }

    public int din() {
        return this.acR == 1 ? 0 : 1;
    }

    private int Fe(int i) {
        return i == 1 ? 0 : 1;
    }

    public void dio() {
        this.hasInit = true;
    }

    public void c(bo boVar) {
        this.kwz = boVar;
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.kuS) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }
}

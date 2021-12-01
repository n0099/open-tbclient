package com.baidu.tieba.newdetail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import c.a.d.a.f;
import c.a.d.a.j;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.r1;
import c.a.r0.p1.l.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static String[] f47137g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f47138h;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicDetailActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicDetailFeedView> f47139b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f47140c;

    /* renamed from: d  reason: collision with root package name */
    public r1 f47141d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47142e;

    /* renamed from: f  reason: collision with root package name */
    public int f47143f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-314445936, "Lcom/baidu/tieba/newdetail/adapter/HotTopicDetailPagerAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-314445936, "Lcom/baidu/tieba/newdetail/adapter/HotTopicDetailPagerAdapter;");
                return;
            }
        }
        String[] strArr = {"最热", "最新"};
        f47137g = strArr;
        f47138h = strArr.length;
    }

    public HotTopicDetailPagerAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47142e = false;
        f<?> a = j.a(context);
        if (a instanceof TbPageContext) {
            this.a = (TbPageContext) a;
        }
        this.f47140c = new ArrayList();
        this.f47139b = new ArrayList();
        HotTopicDetailFeedView sortType = new HotTopicDetailFeedView(context).setSortType(1);
        HotTopicDetailFeedView sortType2 = new HotTopicDetailFeedView(context).setSortType(0);
        this.f47139b.add(sortType);
        this.f47139b.add(sortType2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.f47140c.add(dVar);
        this.f47140c.add(dVar2);
    }

    public final HotTopicDetailFeedView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (HotTopicDetailFeedView) ListUtils.getItem(this.f47139b, this.f47143f % f47138h) : (HotTopicDetailFeedView) invokeV.objValue;
    }

    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 == 1 ? 0 : 1 : invokeI.intValue;
    }

    public d curFeedData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (d) ListUtils.getItem(this.f47140c, b(i2) % f47138h) : (d) invokeI.objValue;
    }

    public int curFeedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f47143f == 1 ? 0 : 1 : invokeV.intValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f47139b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.destroy();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i2, obj) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f47137g.length : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? f47137g[i2] : (CharSequence) invokeI.objValue;
    }

    public void hideFeedEmpty(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f47139b == null || b(i2) >= this.f47139b.size() || (hotTopicDetailFeedView = this.f47139b.get(b(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.hideNetRefreshView();
    }

    public void hideFeedLoading(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f47139b == null || b(i2) >= this.f47139b.size() || (hotTopicDetailFeedView = this.f47139b.get(b(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.hideLoadingView();
    }

    public final void hideLoadMoreView(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f47139b == null || b(i2) >= this.f47139b.size() || (hotTopicDetailFeedView = this.f47139b.get(b(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.hideLoadMoreView();
    }

    public void initViewPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f47142e = true;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            for (int i3 = 0; i3 < this.f47140c.size(); i3++) {
                HotTopicDetailFeedView hotTopicDetailFeedView = this.f47139b.get(i3);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.onChangeSkinType(i2);
                }
            }
        }
    }

    public void pause() {
        HotTopicDetailFeedView a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (a = a()) == null) {
            return;
        }
        a.pause();
    }

    public void resume() {
        HotTopicDetailFeedView a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (a = a()) == null) {
            return;
        }
        a.resume();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.f47142e && (i3 = this.f47143f) != i2) {
                this.f47143f = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.f47139b, i3 % f47138h);
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.pause();
                }
                HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.f47139b, this.f47143f % f47138h);
                d dVar = (d) ListUtils.getItem(this.f47140c, this.f47143f);
                if (hotTopicDetailFeedView2 == null || dVar == null) {
                    return;
                }
                if (ListUtils.isEmpty(dVar.g4)) {
                    this.a.getOrignalPage().refreshFeedData(curFeedType());
                } else {
                    hotTopicDetailFeedView2.resume();
                }
            }
        }
    }

    public void setRecommendForumInfoListData(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, r1Var) == null) {
            this.f47141d = r1Var;
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onScrollListener) == null) {
            for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f47139b) {
                if (hotTopicDetailFeedView != null) {
                    hotTopicDetailFeedView.setScrollListener(onScrollListener);
                }
            }
        }
    }

    public void showFeedEmpty(boolean z, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f47139b == null || b(i2) >= this.f47139b.size() || (hotTopicDetailFeedView = this.f47139b.get(b(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.showNetRefreshView(z);
    }

    public void showFeedLoading(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || this.f47139b == null || b(i2) >= this.f47139b.size() || (hotTopicDetailFeedView = this.f47139b.get(b(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.showLoadingView(true);
    }

    public void showFeedView(@NonNull d dVar, boolean z, int i2) {
        d dVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (dVar2 = (d) ListUtils.getItem(this.f47140c, b(i2) % f47138h)) == null) {
            return;
        }
        if (z) {
            dVar2.g4 = dVar.g4;
        } else if (!ListUtils.isEmpty(dVar.g4)) {
            if (dVar2.g4 == null) {
                dVar2.g4 = new ArrayList();
            }
            dVar2.g4.addAll(dVar.g4);
        }
        b1 b1Var = dVar.d4;
        dVar2.d4 = b1Var;
        dVar2.e4 = dVar.e4;
        if ((b1Var == null || b1Var.b() == 0) ? false : true) {
            showLoadMoreView(i2);
        } else {
            hideLoadMoreView(i2);
            showNoMoreView(i2);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.f47139b, b(i2) % f47138h)).setData(dVar2.U4(this.f47141d));
    }

    public final void showLoadMoreView(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.f47139b == null || b(i2) >= this.f47139b.size() || (hotTopicDetailFeedView = this.f47139b.get(b(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.showLoadMoreView();
    }

    public final void showNoMoreView(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || this.f47139b == null || b(i2) >= this.f47139b.size() || (hotTopicDetailFeedView = this.f47139b.get(b(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.showNoMoreView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, viewGroup, i2)) == null) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.f47139b.get(i2 % f47137g.length);
            if (hotTopicDetailFeedView.getParent() != null) {
                viewGroup.removeView(hotTopicDetailFeedView);
            }
            viewGroup.addView(hotTopicDetailFeedView);
            return hotTopicDetailFeedView;
        }
        return (HotTopicDetailFeedView) invokeLI.objValue;
    }
}

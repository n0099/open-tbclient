package com.baidu.tieba.videoplay;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.tieba.videoplay.fragment.VideoAttentionPageFragment;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoAttentionNotLoginFragment;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoLoadingFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n2.f;
import d.a.q0.x3.c.b;
import d.a.q0.x3.c.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes4.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f21968a;

    /* renamed from: b  reason: collision with root package name */
    public int f21969b;

    /* renamed from: c  reason: collision with root package name */
    public d f21970c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21971d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f21972e;

    /* renamed from: f  reason: collision with root package name */
    public String f21973f;

    /* renamed from: g  reason: collision with root package name */
    public String f21974g;

    /* renamed from: h  reason: collision with root package name */
    public long f21975h;

    /* renamed from: i  reason: collision with root package name */
    public String f21976i;
    public final Activity j;
    public int k;
    public boolean l;
    public BaseFragment m;
    public BdUniqueId n;
    public d.a.q0.x3.g.a o;
    public final SparseArray<d.a.q0.x3.h.a.a> p;
    public f.c q;
    public VideoPlayFragment.u0 r;
    public final int s;
    public CustomMessageListener t;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragmentAdapter f21977a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPlayFragmentAdapter videoPlayFragmentAdapter, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragmentAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21977a = videoPlayFragmentAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.f12868c)) {
                return;
            }
            for (int i2 = 0; i2 < this.f21977a.f21970c.i(); i2++) {
                VideoItemData o = this.f21977a.f21970c.o(i2);
                if (o != null && (userItemData = o.author_info) != null && data.f12868c.equals(userItemData.user_id)) {
                    if (!data.f12866a && !"0".equals(o.author_info.is_follow)) {
                        o.author_info.is_follow = "0";
                    } else if (!updateAttentionMessage.isAttention()) {
                        o.author_info.is_follow = "0";
                    } else {
                        o.author_info.is_follow = "1";
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayFragmentAdapter(BdUniqueId bdUniqueId, BaseFragment baseFragment, Activity activity, BdUniqueId bdUniqueId2, int i2, int i3) {
        super(baseFragment.getChildFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, baseFragment, activity, bdUniqueId2, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21975h = -1L;
        this.k = -1;
        this.p = new SparseArray<>();
        this.t = new a(this, 2001115);
        this.f21968a = bdUniqueId;
        this.m = baseFragment;
        this.n = bdUniqueId2;
        new b();
        this.j = activity;
        this.s = i2;
        this.f21969b = i3;
    }

    public VideoAttentionListPageFragment c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            d.a.q0.x3.h.a.a aVar = this.p.get(i2);
            if (aVar instanceof VideoAttentionListPageFragment) {
                return (VideoAttentionListPageFragment) aVar;
            }
            return null;
        }
        return (VideoAttentionListPageFragment) invokeI.objValue;
    }

    public CustomMessageListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : (CustomMessageListener) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2, obj) == null) {
            super.destroyItem(viewGroup, i2, obj);
            this.p.remove(i2);
        }
    }

    public VideoPlayFragment e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            d.a.q0.x3.h.a.a aVar = this.p.get(i2);
            if (aVar instanceof VideoPlayFragment) {
                return (VideoPlayFragment) aVar;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public VideoAdFragment f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            d.a.q0.x3.h.a.a aVar = this.p.get(i2);
            if (aVar instanceof VideoAdFragment) {
                return (VideoAdFragment) aVar;
            }
            return null;
        }
        return (VideoAdFragment) invokeI.objValue;
    }

    public void g(int i2) {
        String str;
        List<String> list;
        VideoPlayFragment e2;
        VideoPlayFragment e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            d.a.q0.x3.h.a.a aVar = this.p.get(i2);
            VideoPlayFragment videoPlayFragment = aVar instanceof VideoPlayFragment ? (VideoPlayFragment) aVar : null;
            if (videoPlayFragment != null) {
                list = videoPlayFragment.d2();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.c2();
            } else {
                str = null;
                list = null;
            }
            int i3 = i2 - 1;
            String c2 = (i3 < 0 || (e3 = e(i3)) == null) ? null : e3.c2();
            int i4 = i2 + 1;
            String c22 = (i4 >= getCount() || (e2 = e(i4)) == null) ? null : e2.c2();
            ArrayList arrayList = new ArrayList();
            int count = ListUtils.getCount(list);
            for (int i5 = 0; i5 < count; i5++) {
                String str2 = list.get(i5);
                if (!TextUtils.equals(str2, str) && !TextUtils.equals(str2, c2) && !TextUtils.equals(str2, c22)) {
                    arrayList.add(str2);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
            }
            if (this.s == 1 && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f21970c.s(i2)) {
                if (d.a.p0.b.d.b0()) {
                    d.a.q0.v0.a.i().p(this.j, null, this.f21970c.l());
                }
                if (d.a.p0.b.d.a0()) {
                    d.a.q0.v0.a.i().q(this.j, null, this.f21970c.l());
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d dVar = this.f21970c;
            if (dVar == null) {
                return 0;
            }
            return dVar.i();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            VideoItemModel j = this.f21970c.j(i2);
            if (j != null && j.isNoLoginType()) {
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = new VideoAttentionNotLoginFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("video_data", j);
                bundle.putSerializable("from", this.f21974g);
                bundle.putInt("current_type", this.f21969b);
                videoAttentionNotLoginFragment.setArguments(bundle);
                return videoAttentionNotLoginFragment;
            } else if (j != null && j.isLoadingType()) {
                VideoLoadingFragment videoLoadingFragment = new VideoLoadingFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("video_data", j);
                bundle2.putSerializable("from", this.f21974g);
                bundle2.putInt("current_type", this.f21969b);
                videoLoadingFragment.setArguments(bundle2);
                return videoLoadingFragment;
            } else if (j != null && j.isNoAttentionType()) {
                VideoAttentionListPageFragment videoAttentionListPageFragment = new VideoAttentionListPageFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("video_data", j);
                bundle3.putSerializable("from", this.f21974g);
                bundle3.putSerializable("video_attention_list", (Serializable) this.f21970c.m());
                bundle3.putString("video_attention_showword", this.f21970c.n());
                videoAttentionListPageFragment.setArguments(bundle3);
                return videoAttentionListPageFragment;
            } else if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && j != null && j.isFunAdType()) {
                VideoAdFragment videoAdFragment = new VideoAdFragment();
                if (j.getVideoAdData() == null) {
                    j.setVideoAdData(new d.a.q0.v3.f(d.a.q0.f1.a.a.a(10, 500)));
                }
                videoAdFragment.g1(this.f21970c.k());
                videoAdFragment.h1(this.f21970c.l());
                videoAdFragment.j1(this.o);
                videoAdFragment.i1(j);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("video_index", Integer.valueOf(i2));
                bundle4.putSerializable("page_from", this.f21973f);
                bundle4.putSerializable("from", this.f21974g);
                bundle4.putSerializable("obj_id", this.f21976i);
                videoAdFragment.setArguments(bundle4);
                return videoAdFragment;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.s2(this.q);
                videoPlayFragment.y2(this.r);
                videoPlayFragment.x2(this.o);
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("video_data", j);
                bundle5.putSerializable("video_index", Integer.valueOf(i2));
                bundle5.putSerializable("page_from", this.f21973f);
                bundle5.putSerializable("from", this.f21974g);
                bundle5.putSerializable("obj_id", this.f21976i);
                BaseFragment baseFragment = this.m;
                if (baseFragment != null && this.n == baseFragment.getUniqueId()) {
                    BaseFragment baseFragment2 = this.m;
                    if (baseFragment2 instanceof VideoAttentionPageFragment) {
                        bundle5.putSerializable("video_channel_tab", "a089");
                    } else if (baseFragment2 instanceof VideoVerticalPageFragment) {
                        bundle5.putSerializable("video_channel_tab", "a088");
                    }
                }
                if (this.f21971d) {
                    bundle5.putParcelable("video_cover_rect", this.f21972e);
                    this.f21971d = false;
                }
                bundle5.putSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID, this.f21968a);
                bundle5.putInt("current_type", this.f21969b);
                videoPlayFragment.setArguments(bundle5);
                return videoPlayFragment;
            }
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof d.a.q0.x3.h.a.a) {
                d.a.q0.x3.h.a.a aVar = (d.a.q0.x3.h.a.a) obj;
                VideoItemModel c0 = aVar.c0();
                VideoItemModel j = this.f21970c.j(aVar.n());
                if (Objects.equals(c0, j) && (c0 == null || c0.getDataType() == j.getDataType())) {
                    return super.getItemPosition(obj);
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i2) == null) && this.s == 1 && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f21970c.s(i2)) {
            if (d.a.p0.b.d.a0()) {
                d.a.q0.v0.a.i().q(this.j, null, this.f21970c.l());
                if (!d.a.q0.v0.a.i().m("6061002332-203360688") && this.f21970c.g(i2)) {
                    notifyDataSetChanged();
                }
            }
            if (d.a.p0.b.d.b0()) {
                d.a.q0.v0.a.i().p(this.j, null, this.f21970c.l());
                if (d.a.q0.v0.a.i().m("6061002410-390177882") || !this.f21970c.g(i2)) {
                    return;
                }
                notifyDataSetChanged();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int k = d.a.p0.s.d0.b.j().k("nani_key_download_show_rate", 2);
            if (this.f21975h <= 0 || k == 1) {
                return;
            }
            d.a.p0.s.d0.b.j().w("key_vertical_shown_time", this.f21975h);
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i2)) == null) {
            d.a.q0.x3.h.a.a aVar = (d.a.q0.x3.h.a.a) super.instantiateItem(viewGroup, i2);
            aVar.Q(i2);
            this.p.put(i2, aVar);
            return aVar;
        }
        return invokeLI.objValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.l = z;
            int i2 = this.k;
            if (i2 == -1 || e(i2) == null) {
                return;
            }
            e(this.k).setUserVisibleHint(z);
        }
    }

    public void k(d dVar, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, dVar, rect) == null) {
            this.f21970c = dVar;
            this.f21971d = true;
            this.f21972e = rect;
        }
    }

    public void l(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.q = cVar;
        }
    }

    public void m(d.a.q0.x3.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.o = aVar;
        }
    }

    public void n(VideoPlayFragment.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, u0Var) == null) {
            this.r = u0Var;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Parcelable[] parcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Bundle bundle = (Bundle) super.saveState();
            if (bundle != null && (parcelableArray = bundle.getParcelableArray("states")) != null && parcelableArray.length > 5) {
                bundle.putParcelableArray("states", null);
            }
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, viewGroup, i2, obj) == null) {
            int i4 = this.k;
            if (i4 != i2 && i4 != -1 && e(i4) != null) {
                e(this.k).setPrimary(false);
                e(this.k).setUserVisibleHint(false);
            }
            this.k = i2;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) obj;
                if (baseFragment.isPrimary()) {
                    return;
                }
                baseFragment.setPrimary(true);
                if (!this.l || (i3 = this.k) == -1 || e(i3) == null) {
                    return;
                }
                e(this.k).setUserVisibleHint(true);
            }
        }
    }
}

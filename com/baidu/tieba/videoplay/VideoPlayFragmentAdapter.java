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
import c.a.p0.c3.h;
import c.a.p0.n4.f;
import c.a.p0.p4.c.b;
import c.a.p0.p4.c.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.videoplay.nad.AdVideoFlowFragment;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoAttentionNotLoginFragment;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoLoadingFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes6.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public int f36613b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36614c;

    /* renamed from: d  reason: collision with root package name */
    public d f36615d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36616e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f36617f;

    /* renamed from: g  reason: collision with root package name */
    public String f36618g;

    /* renamed from: h  reason: collision with root package name */
    public String f36619h;
    public long i;
    public String j;
    public final Activity k;
    public int l;
    public boolean m;
    public BaseFragment n;
    public BdUniqueId o;
    public c.a.p0.p4.i.a p;
    public final SparseArray<c.a.p0.p4.j.b.a> q;
    public h.c r;
    public VideoPlayFragment.m1 s;
    public c.a.p0.p4.h.a t;
    public final int u;
    public CustomMessageListener v;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragmentAdapter a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPlayFragmentAdapter videoPlayFragmentAdapter, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragmentAdapter, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragmentAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.f30338c)) {
                return;
            }
            for (int i = 0; i < this.a.f36615d.k(); i++) {
                VideoItemData s = this.a.f36615d.s(i);
                if (s != null && (userItemData = s.author_info) != null && data.f30338c.equals(userItemData.user_id)) {
                    if (!data.a && !"0".equals(s.author_info.is_follow)) {
                        s.author_info.is_follow = "0";
                    } else if (!updateAttentionMessage.isAttention()) {
                        s.author_info.is_follow = "0";
                    } else {
                        s.author_info.is_follow = "1";
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayFragmentAdapter(BdUniqueId bdUniqueId, BaseFragment baseFragment, Activity activity, BdUniqueId bdUniqueId2, int i, int i2, boolean z) {
        super(baseFragment.getChildFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, baseFragment, activity, bdUniqueId2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = -1L;
        this.l = -1;
        this.q = new SparseArray<>();
        this.v = new a(this, 2001115);
        this.a = bdUniqueId;
        this.n = baseFragment;
        this.o = bdUniqueId2;
        new b();
        this.k = activity;
        this.u = i;
        this.f36613b = i2;
        this.f36614c = z;
    }

    public VideoAttentionListPageFragment c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            c.a.p0.p4.j.b.a aVar = this.q.get(i);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (CustomMessageListener) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i, obj) == null) {
            super.destroyItem(viewGroup, i, obj);
            this.q.remove(i);
            c.a.p0.p4.h.a aVar = this.t;
            if (aVar != null) {
                aVar.f(i);
            }
        }
    }

    public VideoPlayFragment e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            c.a.p0.p4.j.b.a aVar = this.q.get(i);
            if (aVar instanceof VideoPlayFragment) {
                return (VideoPlayFragment) aVar;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public VideoItemData f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            d dVar = this.f36615d;
            if (dVar == null) {
                return null;
            }
            return dVar.s(i);
        }
        return (VideoItemData) invokeI.objValue;
    }

    public VideoAdFragment g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            c.a.p0.p4.j.b.a aVar = this.q.get(i);
            if (aVar instanceof VideoAdFragment) {
                return (VideoAdFragment) aVar;
            }
            return null;
        }
        return (VideoAdFragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d dVar = this.f36615d;
            if (dVar == null) {
                return 0;
            }
            return dVar.k();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        c.a.p0.p4.h.a aVar;
        AdVideoFlowFragment g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            VideoItemModel m = this.f36615d.m(i);
            if (m != null && m.isNoLoginType()) {
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = new VideoAttentionNotLoginFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("video_data", m);
                bundle.putSerializable("from", this.f36619h);
                bundle.putInt("current_type", this.f36613b);
                bundle.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f36614c);
                videoAttentionNotLoginFragment.setArguments(bundle);
                return videoAttentionNotLoginFragment;
            } else if (m != null && m.isLoadingType()) {
                VideoLoadingFragment videoLoadingFragment = new VideoLoadingFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("video_data", m);
                bundle2.putSerializable("from", this.f36619h);
                bundle2.putInt("current_type", this.f36613b);
                bundle2.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f36614c);
                videoLoadingFragment.setArguments(bundle2);
                return videoLoadingFragment;
            } else if (m != null && m.isNoAttentionType()) {
                VideoAttentionListPageFragment videoAttentionListPageFragment = new VideoAttentionListPageFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("video_data", m);
                bundle3.putSerializable("from", this.f36619h);
                bundle3.putInt("current_type", this.f36613b);
                bundle3.putSerializable("video_attention_list", (Serializable) this.f36615d.p());
                bundle3.putString("video_attention_showword", this.f36615d.q());
                videoAttentionListPageFragment.setArguments(bundle3);
                return videoAttentionListPageFragment;
            } else if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && m != null && m.isFunAdType()) {
                VideoAdFragment videoAdFragment = new VideoAdFragment();
                if (m.getVideoAdData() == null) {
                    m.setVideoAdData(new f(c.a.p0.r1.a.a.a(10, 500)));
                }
                videoAdFragment.Y0(this.f36615d.n());
                videoAdFragment.Z0(this.f36615d.o());
                videoAdFragment.b1(this.p);
                videoAdFragment.a1(m);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("video_index", Integer.valueOf(i));
                bundle4.putSerializable("page_from", this.f36618g);
                bundle4.putSerializable("from", this.f36619h);
                bundle4.putSerializable("obj_id", this.j);
                videoAdFragment.setArguments(bundle4);
                return videoAdFragment;
            } else if (m != null && m.isNADType() && (aVar = this.t) != null && (g2 = aVar.g(i)) != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("video_data", m);
                bundle5.putInt("current_type", this.f36613b);
                bundle5.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f36614c);
                g2.setArguments(bundle5);
                return g2;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.F3(this.r);
                videoPlayFragment.Q3(this.s);
                videoPlayFragment.P3(this.p);
                Bundle bundle6 = new Bundle();
                bundle6.putSerializable("video_data", m);
                bundle6.putSerializable("video_index", Integer.valueOf(i));
                bundle6.putSerializable("page_from", this.f36618g);
                bundle6.putSerializable("from", this.f36619h);
                bundle6.putSerializable("obj_id", this.j);
                BaseFragment baseFragment = this.n;
                if (baseFragment != null && this.o == baseFragment.getUniqueId()) {
                    BaseFragment baseFragment2 = this.n;
                    if (baseFragment2 instanceof VideoAttentionPageFragment) {
                        bundle6.putSerializable("video_channel_tab", "a089");
                    } else if (baseFragment2 instanceof VideoVerticalPageFragment) {
                        bundle6.putSerializable("video_channel_tab", "a088");
                    }
                }
                if (this.f36616e) {
                    bundle6.putParcelable("video_cover_rect", this.f36617f);
                    this.f36616e = false;
                }
                bundle6.putSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID, this.a);
                bundle6.putInt("current_type", this.f36613b);
                bundle6.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f36614c);
                videoPlayFragment.setArguments(bundle6);
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
            if (obj instanceof c.a.p0.p4.j.b.a) {
                c.a.p0.p4.j.b.a aVar = (c.a.p0.p4.j.b.a) obj;
                VideoItemModel W = aVar.W();
                VideoItemModel m = this.f36615d.m(aVar.l());
                if (Objects.equals(W, m) && (W == null || W.getDataType() == m.getDataType())) {
                    return super.getItemPosition(obj);
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public void h(int i) {
        String str;
        List<String> list;
        VideoPlayFragment e2;
        VideoPlayFragment e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            c.a.p0.p4.j.b.a aVar = this.q.get(i);
            String str2 = null;
            VideoPlayFragment videoPlayFragment = aVar instanceof VideoPlayFragment ? (VideoPlayFragment) aVar : null;
            if (videoPlayFragment != null) {
                list = videoPlayFragment.T2();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.Q2();
            } else {
                str = null;
                list = null;
            }
            int i2 = i - 1;
            String Q2 = (i2 < 0 || (e3 = e(i2)) == null) ? null : e3.Q2();
            int i3 = i + 1;
            if (i3 < getCount() && (e2 = e(i3)) != null) {
                str2 = e2.Q2();
            }
            ArrayList arrayList = new ArrayList();
            int count = ListUtils.getCount(list);
            for (int i4 = 0; i4 < count; i4++) {
                String str3 = list.get(i4);
                if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, Q2) && !TextUtils.equals(str3, str2)) {
                    arrayList.add(str3);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.u == 1 && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f36615d.y(i)) {
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                c.a.p0.g1.b.j().s(this.k, null, this.f36615d.o());
                if (c.a.p0.g1.b.j().o("6061002332-203360688") || !this.f36615d.g(i)) {
                    return;
                }
                notifyDataSetChanged();
            } else if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                c.a.p0.g1.b.j().r(this.k, null, this.f36615d.o());
                if (c.a.p0.g1.b.j().o("6061002410-390177882") || !this.f36615d.g(i)) {
                    return;
                }
                notifyDataSetChanged();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            c.a.p0.p4.j.b.a aVar = (c.a.p0.p4.j.b.a) super.instantiateItem(viewGroup, i);
            aVar.M(i);
            this.q.put(i, aVar);
            return aVar;
        }
        return invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int l = c.a.o0.r.j0.b.k().l("nani_key_download_show_rate", 2);
            if (this.i <= 0 || l == 1) {
                return;
            }
            c.a.o0.r.j0.b.k().x("key_vertical_shown_time", this.i);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.m = z;
            int i = this.l;
            if (i != -1) {
                if (e(i) != null) {
                    e(this.l).setUserVisibleHint(z);
                    return;
                }
                c.a.p0.p4.j.b.a aVar = this.q.get(this.l);
                if (aVar instanceof AdVideoFlowFragment) {
                    ((BaseFragment) aVar).setUserVisibleHint(z);
                }
            }
        }
    }

    public void l(d dVar, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, dVar, rect) == null) {
            this.f36615d = dVar;
            this.f36616e = true;
            int i = this.f36613b;
            if (i == 3 || i == 1 || i == 7) {
                this.f36617f = rect;
            }
        }
    }

    public void m(c.a.p0.p4.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.t = aVar;
        }
    }

    public void n(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public void o(c.a.p0.p4.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void p(VideoPlayFragment.m1 m1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, m1Var) == null) {
            this.s = m1Var;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Parcelable[] parcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Bundle bundle = (Bundle) super.saveState();
            if (bundle != null && (parcelableArray = bundle.getParcelableArray("states")) != null && parcelableArray.length > 5) {
                bundle.putParcelableArray("states", null);
            }
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, viewGroup, i, obj) == null) {
            int i3 = this.l;
            if (i3 != i && i3 != -1) {
                if (e(i3) != null) {
                    e(this.l).setPrimary(false);
                    e(this.l).setUserVisibleHint(false);
                } else {
                    c.a.p0.p4.j.b.a aVar = this.q.get(this.l);
                    if (aVar instanceof AdVideoFlowFragment) {
                        BaseFragment baseFragment = (BaseFragment) aVar;
                        baseFragment.setPrimary(false);
                        baseFragment.setUserVisibleHint(false);
                    }
                }
            }
            this.l = i;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment2 = (BaseFragment) obj;
                if (baseFragment2.isPrimary()) {
                    return;
                }
                baseFragment2.setPrimary(true);
                if (!this.m || (i2 = this.l) == -1) {
                    return;
                }
                if (e(i2) != null) {
                    e(this.l).setUserVisibleHint(true);
                    return;
                }
                c.a.p0.p4.j.b.a aVar2 = this.q.get(this.l);
                if (aVar2 instanceof AdVideoFlowFragment) {
                    ((BaseFragment) aVar2).setUserVisibleHint(true);
                }
            }
        }
    }
}

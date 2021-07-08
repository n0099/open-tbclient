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
import d.a.p0.n2.f;
import d.a.p0.x3.c.b;
import d.a.p0.x3.c.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes4.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f21834a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21835b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f21836c;

    /* renamed from: d  reason: collision with root package name */
    public String f21837d;

    /* renamed from: e  reason: collision with root package name */
    public String f21838e;

    /* renamed from: f  reason: collision with root package name */
    public long f21839f;

    /* renamed from: g  reason: collision with root package name */
    public String f21840g;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f21841h;

    /* renamed from: i  reason: collision with root package name */
    public int f21842i;
    public boolean j;
    public BaseFragment k;
    public BdUniqueId l;
    public d.a.p0.x3.f.a m;
    public final SparseArray<d.a.p0.x3.g.a.a> n;
    public f.c o;
    public VideoPlayFragment.p0 p;
    public final int q;
    public CustomMessageListener r;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragmentAdapter f21843a;

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
            this.f21843a = videoPlayFragmentAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.f12819c)) {
                return;
            }
            for (int i2 = 0; i2 < this.f21843a.f21834a.h(); i2++) {
                VideoItemData n = this.f21843a.f21834a.n(i2);
                if (n != null && (userItemData = n.author_info) != null && data.f12819c.equals(userItemData.user_id)) {
                    if (!data.f12817a && !"0".equals(n.author_info.is_follow)) {
                        n.author_info.is_follow = "0";
                    } else if (!updateAttentionMessage.isAttention()) {
                        n.author_info.is_follow = "0";
                    } else {
                        n.author_info.is_follow = "1";
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayFragmentAdapter(BaseFragment baseFragment, Activity activity, BdUniqueId bdUniqueId, int i2) {
        super(baseFragment.getChildFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, activity, bdUniqueId, Integer.valueOf(i2)};
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
        this.f21839f = -1L;
        this.f21842i = -1;
        this.n = new SparseArray<>();
        this.r = new a(this, 2001115);
        this.k = baseFragment;
        this.l = bdUniqueId;
        new b();
        this.f21841h = activity;
        this.q = i2;
    }

    public VideoAttentionListPageFragment c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            d.a.p0.x3.g.a.a aVar = this.n.get(i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (CustomMessageListener) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2, obj) == null) {
            super.destroyItem(viewGroup, i2, obj);
            this.n.remove(i2);
        }
    }

    public VideoPlayFragment e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            d.a.p0.x3.g.a.a aVar = this.n.get(i2);
            if (aVar instanceof VideoPlayFragment) {
                return (VideoPlayFragment) aVar;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public void f(int i2) {
        String str;
        List<String> list;
        VideoPlayFragment e2;
        VideoPlayFragment e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            d.a.p0.x3.g.a.a aVar = this.n.get(i2);
            VideoPlayFragment videoPlayFragment = aVar instanceof VideoPlayFragment ? (VideoPlayFragment) aVar : null;
            if (videoPlayFragment != null) {
                list = videoPlayFragment.O1();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.N1();
            } else {
                str = null;
                list = null;
            }
            int i3 = i2 - 1;
            String N1 = (i3 < 0 || (e3 = e(i3)) == null) ? null : e3.N1();
            int i4 = i2 + 1;
            String N12 = (i4 >= getCount() || (e2 = e(i4)) == null) ? null : e2.N1();
            ArrayList arrayList = new ArrayList();
            int count = ListUtils.getCount(list);
            for (int i5 = 0; i5 < count; i5++) {
                String str2 = list.get(i5);
                if (!TextUtils.equals(str2, str) && !TextUtils.equals(str2, N1) && !TextUtils.equals(str2, N12)) {
                    arrayList.add(str2);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
            }
            if (this.q == 1 && VideoMiddleAdSwitch.isOn() && this.f21834a.r(i2)) {
                d.a.p0.v0.a.h().n(this.f21841h, null, this.f21834a.k());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int k = d.a.o0.r.d0.b.j().k("nani_key_download_show_rate", 2);
            if (this.f21839f <= 0 || k == 1) {
                return;
            }
            d.a.o0.r.d0.b.j().w("key_vertical_shown_time", this.f21839f);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d dVar = this.f21834a;
            if (dVar == null) {
                return 0;
            }
            return dVar.h();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            VideoItemModel i3 = this.f21834a.i(i2);
            if (i3 != null && i3.isNoLoginType()) {
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = new VideoAttentionNotLoginFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, i3);
                bundle.putSerializable("from", this.f21838e);
                videoAttentionNotLoginFragment.setArguments(bundle);
                return videoAttentionNotLoginFragment;
            } else if (i3 != null && i3.isLoadingType()) {
                VideoLoadingFragment videoLoadingFragment = new VideoLoadingFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, i3);
                bundle2.putSerializable("from", this.f21838e);
                videoLoadingFragment.setArguments(bundle2);
                return videoLoadingFragment;
            } else if (i3 != null && i3.isNoAttentionType()) {
                VideoAttentionListPageFragment videoAttentionListPageFragment = new VideoAttentionListPageFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, i3);
                bundle3.putSerializable("from", this.f21838e);
                bundle3.putSerializable(VideoPlayActivityConfig.VIDEO_ATTENTION_LIST, (Serializable) this.f21834a.l());
                bundle3.putString(VideoPlayActivityConfig.VIDEO_ATTENTION_SHOWWORD, this.f21834a.m());
                videoAttentionListPageFragment.setArguments(bundle3);
                return videoAttentionListPageFragment;
            } else if (VideoMiddleAdSwitch.isOn() && i3 != null && i3.isFunAdType()) {
                VideoAdFragment videoAdFragment = new VideoAdFragment();
                videoAdFragment.M0(this.f21834a.j());
                videoAdFragment.N0(this.f21834a.k());
                videoAdFragment.O0(this.m);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, i3);
                bundle4.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
                bundle4.putSerializable("page_from", this.f21837d);
                bundle4.putSerializable("from", this.f21838e);
                bundle4.putSerializable("obj_id", this.f21840g);
                videoAdFragment.setArguments(bundle4);
                return videoAdFragment;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.f2(this.o);
                videoPlayFragment.k2(this.p);
                videoPlayFragment.j2(this.m);
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, i3);
                bundle5.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
                bundle5.putSerializable("page_from", this.f21837d);
                bundle5.putSerializable("from", this.f21838e);
                bundle5.putSerializable("obj_id", this.f21840g);
                BaseFragment baseFragment = this.k;
                if (baseFragment != null && this.l == baseFragment.getUniqueId()) {
                    BaseFragment baseFragment2 = this.k;
                    if (baseFragment2 instanceof VideoAttentionPageFragment) {
                        bundle5.putSerializable(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, "a089");
                    } else if (baseFragment2 instanceof VideoVerticalPageFragment) {
                        bundle5.putSerializable(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, "a088");
                    }
                }
                if (this.f21835b) {
                    bundle5.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.f21836c);
                    this.f21835b = false;
                }
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
            if (obj instanceof d.a.p0.x3.g.a.a) {
                d.a.p0.x3.g.a.a aVar = (d.a.p0.x3.g.a.a) obj;
                VideoItemModel a0 = aVar.a0();
                VideoItemModel i2 = this.f21834a.i(aVar.n());
                if (Objects.equals(a0, i2) && (a0 == null || a0.getDataType() == i2.getDataType())) {
                    return super.getItemPosition(obj);
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j = z;
            int i2 = this.f21842i;
            if (i2 == -1 || e(i2) == null) {
                return;
            }
            e(this.f21842i).setUserVisibleHint(z);
        }
    }

    public void i(d dVar, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, dVar, rect) == null) {
            this.f21834a = dVar;
            this.f21835b = true;
            this.f21836c = rect;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i2)) == null) {
            d.a.p0.x3.g.a.a aVar = (d.a.p0.x3.g.a.a) super.instantiateItem(viewGroup, i2);
            aVar.P(i2);
            this.n.put(i2, aVar);
            return aVar;
        }
        return invokeLI.objValue;
    }

    public void j(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048589, this, z) != null) || this.f21842i == -1) {
        }
    }

    public void l(d.a.p0.x3.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void m(VideoPlayFragment.p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, p0Var) == null) {
            this.p = p0Var;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Parcelable[] parcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        if (interceptable == null || interceptable.invokeLIL(1048593, this, viewGroup, i2, obj) == null) {
            int i4 = this.f21842i;
            if (i4 != i2 && i4 != -1 && e(i4) != null) {
                e(this.f21842i).setPrimary(false);
                e(this.f21842i).setUserVisibleHint(false);
            }
            this.f21842i = i2;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) obj;
                if (baseFragment.isPrimary()) {
                    return;
                }
                baseFragment.setPrimary(true);
                if (!this.j || (i3 = this.f21842i) == -1 || e(i3) == null) {
                    return;
                }
                e(this.f21842i).setUserVisibleHint(true);
            }
        }
    }
}

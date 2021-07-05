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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n2.f;
import d.a.s0.x3.b.b;
import d.a.s0.x3.b.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes5.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f21784a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21785b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f21786c;

    /* renamed from: d  reason: collision with root package name */
    public String f21787d;

    /* renamed from: e  reason: collision with root package name */
    public String f21788e;

    /* renamed from: f  reason: collision with root package name */
    public long f21789f;

    /* renamed from: g  reason: collision with root package name */
    public String f21790g;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f21791h;

    /* renamed from: i  reason: collision with root package name */
    public int f21792i;
    public boolean j;
    public BaseFragment k;
    public BdUniqueId l;
    public final SparseArray<d.a.s0.x3.d.a.a> m;
    public f.c n;
    public VideoPlayFragment.l0 o;
    public final int p;
    public CustomMessageListener q;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragmentAdapter f21793a;

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
            this.f21793a = videoPlayFragmentAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.f12802c)) {
                return;
            }
            for (int i2 = 0; i2 < this.f21793a.f21784a.e(); i2++) {
                VideoItemData k = this.f21793a.f21784a.k(i2);
                if (k != null && (userItemData = k.author_info) != null && data.f12802c.equals(userItemData.user_id)) {
                    if (!data.f12800a && !"0".equals(k.author_info.is_follow)) {
                        k.author_info.is_follow = "0";
                    } else if (!updateAttentionMessage.isAttention()) {
                        k.author_info.is_follow = "0";
                    } else {
                        k.author_info.is_follow = "1";
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
        this.f21789f = -1L;
        this.f21792i = -1;
        this.m = new SparseArray<>();
        this.q = new a(this, 2001115);
        this.k = baseFragment;
        this.l = bdUniqueId;
        new b();
        this.f21791h = activity;
        this.p = i2;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            super.destroyItem(viewGroup, i2, obj);
            this.m.remove(i2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f21784a;
            if (cVar == null) {
                return 0;
            }
            return cVar.e();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            VideoItemModel f2 = this.f21784a.f(i2);
            if (f2 != null && f2.isNoLoginType()) {
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = new VideoAttentionNotLoginFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, f2);
                bundle.putSerializable("from", this.f21788e);
                videoAttentionNotLoginFragment.setArguments(bundle);
                return videoAttentionNotLoginFragment;
            } else if (f2 != null && f2.isNoAttentionType()) {
                VideoAttentionListPageFragment videoAttentionListPageFragment = new VideoAttentionListPageFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, f2);
                bundle2.putSerializable("from", this.f21788e);
                bundle2.putSerializable(VideoPlayActivityConfig.VIDEO_ATTENTION_LIST, (Serializable) this.f21784a.i());
                bundle2.putString(VideoPlayActivityConfig.VIDEO_ATTENTION_SHOWWORD, this.f21784a.j());
                videoAttentionListPageFragment.setArguments(bundle2);
                return videoAttentionListPageFragment;
            } else if (VideoMiddleAdSwitch.isOn() && f2 != null && f2.isFunAdType()) {
                VideoAdFragment videoAdFragment = new VideoAdFragment();
                videoAdFragment.K0(this.f21784a.g());
                videoAdFragment.L0(this.f21784a.h());
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, f2);
                bundle3.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
                bundle3.putSerializable("page_from", this.f21787d);
                bundle3.putSerializable("from", this.f21788e);
                bundle3.putSerializable("obj_id", this.f21790g);
                videoAdFragment.setArguments(bundle3);
                return videoAdFragment;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.a2(this.n);
                videoPlayFragment.e2(this.o);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, f2);
                bundle4.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
                bundle4.putSerializable("page_from", this.f21787d);
                bundle4.putSerializable("from", this.f21788e);
                bundle4.putSerializable("obj_id", this.f21790g);
                BaseFragment baseFragment = this.k;
                if (baseFragment != null && this.l == baseFragment.getUniqueId()) {
                    BaseFragment baseFragment2 = this.k;
                    if (baseFragment2 instanceof VideoAttentionPageFragment) {
                        bundle4.putSerializable(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, "a089");
                    } else if (baseFragment2 instanceof VideoVerticalPageFragment) {
                        bundle4.putSerializable(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, "a088");
                    }
                }
                if (this.f21785b) {
                    bundle4.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.f21786c);
                    this.f21785b = false;
                }
                videoPlayFragment.setArguments(bundle4);
                return videoPlayFragment;
            }
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof d.a.s0.x3.d.a.a) {
                d.a.s0.x3.d.a.a aVar = (d.a.s0.x3.d.a.a) obj;
                if (Objects.equals(aVar.a0(), this.f21784a.f(aVar.o()))) {
                    return super.getItemPosition(obj);
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public VideoAttentionListPageFragment i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            d.a.s0.x3.d.a.a aVar = this.m.get(i2);
            if (aVar instanceof VideoAttentionListPageFragment) {
                return (VideoAttentionListPageFragment) aVar;
            }
            return null;
        }
        return (VideoAttentionListPageFragment) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            d.a.s0.x3.d.a.a aVar = (d.a.s0.x3.d.a.a) super.instantiateItem(viewGroup, i2);
            aVar.P(i2);
            this.m.put(i2, aVar);
            return aVar;
        }
        return invokeLI.objValue;
    }

    public CustomMessageListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (CustomMessageListener) invokeV.objValue;
    }

    public VideoPlayFragment k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            d.a.s0.x3.d.a.a aVar = this.m.get(i2);
            if (aVar instanceof VideoPlayFragment) {
                return (VideoPlayFragment) aVar;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public void l(int i2) {
        String str;
        List<String> list;
        VideoPlayFragment k;
        VideoPlayFragment k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            d.a.s0.x3.d.a.a aVar = this.m.get(i2);
            VideoPlayFragment videoPlayFragment = aVar instanceof VideoPlayFragment ? (VideoPlayFragment) aVar : null;
            if (videoPlayFragment != null) {
                list = videoPlayFragment.M1();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.L1();
            } else {
                str = null;
                list = null;
            }
            int i3 = i2 - 1;
            String L1 = (i3 < 0 || (k2 = k(i3)) == null) ? null : k2.L1();
            int i4 = i2 + 1;
            String L12 = (i4 >= getCount() || (k = k(i4)) == null) ? null : k.L1();
            ArrayList arrayList = new ArrayList();
            int count = ListUtils.getCount(list);
            for (int i5 = 0; i5 < count; i5++) {
                String str2 = list.get(i5);
                if (!TextUtils.equals(str2, str) && !TextUtils.equals(str2, L1) && !TextUtils.equals(str2, L12)) {
                    arrayList.add(str2);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
            }
            if (this.p == 1 && VideoMiddleAdSwitch.isOn() && this.f21784a.n(i2)) {
                d.a.s0.v0.a.h().n(this.f21791h, null, this.f21784a.h());
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int k = d.a.r0.r.d0.b.j().k("nani_key_download_show_rate", 2);
            if (this.f21789f <= 0 || k == 1) {
                return;
            }
            d.a.r0.r.d0.b.j().w("key_vertical_shown_time", this.f21789f);
        }
    }

    public void n(c cVar, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cVar, rect) == null) {
            this.f21784a = cVar;
            this.f21785b = true;
            this.f21786c = rect;
        }
    }

    public void o(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.j = z;
            int i2 = this.f21792i;
            if (i2 == -1 || k(i2) == null) {
                return;
            }
            k(this.f21792i).Y1(z);
        }
    }

    public void q(VideoPlayFragment.l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l0Var) == null) {
            this.o = l0Var;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Parcelable[] parcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048591, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            int i3 = this.f21792i;
            if (i3 != i2) {
                if (i3 != -1 && k(i3) != null) {
                    k(this.f21792i).Y1(this.j);
                    k(this.f21792i).setPrimary(false);
                    k(this.f21792i).setUserVisibleHint(false);
                }
                this.f21792i = i2;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment = (BaseFragment) obj;
                    baseFragment.setPrimary(true);
                    baseFragment.setUserVisibleHint(true);
                }
                if (obj instanceof VideoPlayFragment) {
                    ((VideoPlayFragment) obj).Y1(this.j);
                }
            }
        }
    }
}

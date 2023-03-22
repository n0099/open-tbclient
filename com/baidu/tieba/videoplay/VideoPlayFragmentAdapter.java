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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.dn9;
import com.baidu.tieba.do9;
import com.baidu.tieba.eo9;
import com.baidu.tieba.fn9;
import com.baidu.tieba.ga7;
import com.baidu.tieba.jo9;
import com.baidu.tieba.m35;
import com.baidu.tieba.rx8;
import com.baidu.tieba.tk9;
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
import com.baidu.tieba.vl7;
import com.baidu.tieba.zm9;
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
    public int b;
    public boolean c;
    public fn9 d;
    public boolean e;
    public Rect f;
    public String g;
    public String h;
    public long i;
    public String j;
    public final Activity k;
    public int l;
    public boolean m;
    public BaseFragment n;
    public BdUniqueId o;
    public eo9 p;
    public zm9 q;
    public final SparseArray<jo9> r;
    public rx8.c s;
    public VideoPlayFragment.i1 t;
    public do9 u;
    public final int v;
    public boolean w;
    public boolean x;
    public CustomMessageListener y;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null && !TextUtils.isEmpty(data.c)) {
                for (int i = 0; i < this.a.d.k(); i++) {
                    VideoItemData s = this.a.d.s(i);
                    if (s != null && (userItemData = s.author_info) != null && data.c.equals(userItemData.user_id)) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayFragmentAdapter(BdUniqueId bdUniqueId, BaseFragment baseFragment, Activity activity, BdUniqueId bdUniqueId2, int i, int i2, boolean z, boolean z2) {
        super(baseFragment.getChildFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, baseFragment, activity, bdUniqueId2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
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
        this.r = new SparseArray<>();
        this.w = false;
        this.x = false;
        this.y = new a(this, 2001115);
        this.a = bdUniqueId;
        this.n = baseFragment;
        this.o = bdUniqueId2;
        new dn9();
        this.k = activity;
        this.v = i;
        this.b = i2;
        this.c = z;
        this.x = z2;
    }

    public VideoAttentionListPageFragment c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            jo9 jo9Var = this.r.get(i);
            if (jo9Var instanceof VideoAttentionListPageFragment) {
                return (VideoAttentionListPageFragment) jo9Var;
            }
            return null;
        }
        return (VideoAttentionListPageFragment) invokeI.objValue;
    }

    public VideoPlayFragment e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            jo9 jo9Var = this.r.get(i);
            if (jo9Var instanceof VideoPlayFragment) {
                return (VideoPlayFragment) jo9Var;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public VideoItemData f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            fn9 fn9Var = this.d;
            if (fn9Var == null) {
                return null;
            }
            return fn9Var.s(i);
        }
        return (VideoItemData) invokeI.objValue;
    }

    public VideoAdFragment g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            jo9 jo9Var = this.r.get(i);
            if (jo9Var instanceof VideoAdFragment) {
                return (VideoAdFragment) jo9Var;
            }
            return null;
        }
        return (VideoAdFragment) invokeI.objValue;
    }

    public void k(zm9 zm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zm9Var) == null) {
            this.q = zm9Var;
        }
    }

    public void n(do9 do9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, do9Var) == null) {
            this.u = do9Var;
        }
    }

    public void o(rx8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void p(eo9 eo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eo9Var) == null) {
            this.p = eo9Var;
        }
    }

    public void q(VideoPlayFragment.i1 i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, i1Var) == null) {
            this.t = i1Var;
        }
    }

    public CustomMessageListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.y;
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            fn9 fn9Var = this.d;
            if (fn9Var == null) {
                return 0;
            }
            return fn9Var.k();
        }
        return invokeV.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int n = m35.m().n("nani_key_download_show_rate", 2);
            if (this.i > 0 && n != 1) {
                m35.m().A("key_vertical_shown_time", this.i);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Parcelable[] parcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Bundle bundle = (Bundle) super.saveState();
            if (bundle != null && (parcelableArray = bundle.getParcelableArray("states")) != null && parcelableArray.length > 5) {
                bundle.putParcelableArray("states", null);
            }
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i, obj) == null) {
            super.destroyItem(viewGroup, i, obj);
            this.r.remove(i);
            do9 do9Var = this.u;
            if (do9Var != null) {
                do9Var.f(i);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        do9 do9Var;
        AdVideoFlowFragment g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            VideoItemModel m = this.d.m(i);
            if (m != null && m.isNoLoginType()) {
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = new VideoAttentionNotLoginFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("video_data", m);
                bundle.putSerializable("from", this.h);
                bundle.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                videoAttentionNotLoginFragment.setArguments(bundle);
                return videoAttentionNotLoginFragment;
            } else if (m != null && m.isLoadingType()) {
                VideoLoadingFragment videoLoadingFragment = new VideoLoadingFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("video_data", m);
                bundle2.putSerializable("from", this.h);
                bundle2.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle2.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                videoLoadingFragment.setArguments(bundle2);
                return videoLoadingFragment;
            } else if (m != null && m.isNoAttentionType()) {
                VideoAttentionListPageFragment videoAttentionListPageFragment = new VideoAttentionListPageFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("video_data", m);
                bundle3.putSerializable("from", this.h);
                bundle3.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle3.putSerializable("video_attention_list", (Serializable) this.d.p());
                bundle3.putString("video_attention_showword", this.d.q());
                videoAttentionListPageFragment.setArguments(bundle3);
                return videoAttentionListPageFragment;
            } else if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && m != null && m.isFunAdType()) {
                VideoAdFragment videoAdFragment = new VideoAdFragment();
                if (m.getVideoAdData() == null) {
                    m.setVideoAdData(new tk9(vl7.a(10, 500)));
                }
                videoAdFragment.Y1(this.d.n());
                videoAdFragment.Z1(this.d.o());
                videoAdFragment.b2(this.p);
                videoAdFragment.a2(m);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("video_index", Integer.valueOf(i));
                bundle4.putSerializable("page_from", this.g);
                bundle4.putSerializable("from", this.h);
                bundle4.putSerializable("obj_id", this.j);
                videoAdFragment.setArguments(bundle4);
                return videoAdFragment;
            } else if (m != null && m.isNADType() && (do9Var = this.u) != null && (g = do9Var.g(i)) != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("video_data", m);
                bundle5.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle5.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                g.setArguments(bundle5);
                return g;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.N4(this.s);
                videoPlayFragment.Y4(this.t);
                videoPlayFragment.X4(this.p);
                videoPlayFragment.I4(this.q);
                Bundle bundle6 = new Bundle();
                bundle6.putBoolean(VideoPlayActivityConfig.IS_SCROLLED, this.w);
                bundle6.putBoolean(VideoPlayActivityConfig.IS_NEED_SHOW_SECOND_FLOOR, this.x);
                bundle6.putSerializable("video_data", m);
                bundle6.putSerializable("video_index", Integer.valueOf(i));
                bundle6.putSerializable("page_from", this.g);
                bundle6.putSerializable("from", this.h);
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
                if (this.e) {
                    bundle6.putParcelable("video_cover_rect", this.f);
                    this.e = false;
                }
                bundle6.putSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID, this.a);
                bundle6.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle6.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                videoPlayFragment.setArguments(bundle6);
                return videoPlayFragment;
            }
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof jo9) {
                jo9 jo9Var = (jo9) obj;
                VideoItemModel I0 = jo9Var.I0();
                VideoItemModel m = this.d.m(jo9Var.p());
                if (Objects.equals(I0, m) && (I0 == null || I0.getDataType() == m.getDataType())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return super.getItemPosition(obj);
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public void h(int i) {
        VideoPlayFragment videoPlayFragment;
        String str;
        List<String> list;
        String str2;
        VideoPlayFragment e;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            jo9 jo9Var = this.r.get(i);
            String str3 = null;
            if (jo9Var instanceof VideoPlayFragment) {
                videoPlayFragment = (VideoPlayFragment) jo9Var;
            } else {
                videoPlayFragment = null;
            }
            if (videoPlayFragment != null) {
                list = videoPlayFragment.Y3();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.V3();
            } else {
                str = null;
                list = null;
            }
            int i2 = i - 1;
            if (i2 >= 0 && (e2 = e(i2)) != null) {
                str2 = e2.V3();
            } else {
                str2 = null;
            }
            int i3 = i + 1;
            if (i3 < getCount() && (e = e(i3)) != null) {
                str3 = e.V3();
            }
            ArrayList arrayList = new ArrayList();
            int count = ListUtils.getCount(list);
            for (int i4 = 0; i4 < count; i4++) {
                String str4 = list.get(i4);
                if (!TextUtils.equals(str4, str) && !TextUtils.equals(str4, str2) && !TextUtils.equals(str4, str3)) {
                    arrayList.add(str4);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
            }
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.w = true;
            if (this.v == 1 && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.d.y(i)) {
                if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                    ga7.m().z(this.k, null, this.d.o());
                    if (!ga7.m().v("6061002332-203360688") && this.d.g(i)) {
                        notifyDataSetChanged();
                    }
                } else if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    ga7.m().y(this.k, null, this.d.o());
                    if (!ga7.m().v(ga7.s()) && this.d.g(i)) {
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            jo9 jo9Var = (jo9) super.instantiateItem(viewGroup, i);
            jo9Var.r0(i);
            this.r.put(i, jo9Var);
            return jo9Var;
        }
        return invokeLI.objValue;
    }

    public void m(fn9 fn9Var, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, fn9Var, rect) == null) {
            this.d = fn9Var;
            this.e = true;
            int i = this.b;
            if (i == 3 || i == 1 || i == 7) {
                this.f = rect;
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.m = z;
            int i = this.l;
            if (i != -1) {
                if (e(i) != null) {
                    e(this.l).setUserVisibleHint(z);
                    return;
                }
                jo9 jo9Var = this.r.get(this.l);
                if (jo9Var instanceof AdVideoFlowFragment) {
                    ((BaseFragment) jo9Var).setUserVisibleHint(z);
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048597, this, viewGroup, i, obj) == null) {
            int i3 = this.l;
            if (i3 != i && i3 != -1) {
                if (e(i3) != null) {
                    e(this.l).setPrimary(false);
                    e(this.l).setUserVisibleHint(false);
                } else {
                    jo9 jo9Var = this.r.get(this.l);
                    if (jo9Var instanceof AdVideoFlowFragment) {
                        BaseFragment baseFragment = (BaseFragment) jo9Var;
                        baseFragment.setPrimary(false);
                        baseFragment.setUserVisibleHint(false);
                    }
                }
            }
            this.l = i;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment2 = (BaseFragment) obj;
                if (!baseFragment2.isPrimary()) {
                    baseFragment2.setPrimary(true);
                    if (this.m && (i2 = this.l) != -1) {
                        if (e(i2) != null) {
                            e(this.l).setUserVisibleHint(true);
                            return;
                        }
                        jo9 jo9Var2 = this.r.get(this.l);
                        if (jo9Var2 instanceof AdVideoFlowFragment) {
                            ((BaseFragment) jo9Var2).setUserVisibleHint(true);
                        }
                    }
                }
            }
        }
    }
}

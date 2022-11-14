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
import com.baidu.tieba.j87;
import com.baidu.tieba.jx8;
import com.baidu.tieba.py4;
import com.baidu.tieba.pz8;
import com.baidu.tieba.sc8;
import com.baidu.tieba.t09;
import com.baidu.tieba.tz8;
import com.baidu.tieba.u09;
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
import com.baidu.tieba.vz8;
import com.baidu.tieba.xw6;
import com.baidu.tieba.z09;
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
    public vz8 d;
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
    public u09 p;
    public pz8 q;
    public final SparseArray<z09> r;
    public sc8.c s;
    public VideoPlayFragment.i1 t;
    public t09 u;
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
        new tz8();
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
            z09 z09Var = this.r.get(i);
            if (z09Var instanceof VideoAttentionListPageFragment) {
                return (VideoAttentionListPageFragment) z09Var;
            }
            return null;
        }
        return (VideoAttentionListPageFragment) invokeI.objValue;
    }

    public VideoPlayFragment e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            z09 z09Var = this.r.get(i);
            if (z09Var instanceof VideoPlayFragment) {
                return (VideoPlayFragment) z09Var;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public VideoItemData f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            vz8 vz8Var = this.d;
            if (vz8Var == null) {
                return null;
            }
            return vz8Var.s(i);
        }
        return (VideoItemData) invokeI.objValue;
    }

    public VideoAdFragment g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            z09 z09Var = this.r.get(i);
            if (z09Var instanceof VideoAdFragment) {
                return (VideoAdFragment) z09Var;
            }
            return null;
        }
        return (VideoAdFragment) invokeI.objValue;
    }

    public void k(pz8 pz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pz8Var) == null) {
            this.q = pz8Var;
        }
    }

    public void n(t09 t09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, t09Var) == null) {
            this.u = t09Var;
        }
    }

    public void o(sc8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void p(u09 u09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, u09Var) == null) {
            this.p = u09Var;
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
            vz8 vz8Var = this.d;
            if (vz8Var == null) {
                return 0;
            }
            return vz8Var.k();
        }
        return invokeV.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int l = py4.k().l("nani_key_download_show_rate", 2);
            if (this.i > 0 && l != 1) {
                py4.k().x("key_vertical_shown_time", this.i);
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
            t09 t09Var = this.u;
            if (t09Var != null) {
                t09Var.f(i);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        t09 t09Var;
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
                    m.setVideoAdData(new jx8(j87.a(10, 500)));
                }
                videoAdFragment.L1(this.d.n());
                videoAdFragment.M1(this.d.o());
                videoAdFragment.O1(this.p);
                videoAdFragment.N1(m);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("video_index", Integer.valueOf(i));
                bundle4.putSerializable("page_from", this.g);
                bundle4.putSerializable("from", this.h);
                bundle4.putSerializable("obj_id", this.j);
                videoAdFragment.setArguments(bundle4);
                return videoAdFragment;
            } else if (m != null && m.isNADType() && (t09Var = this.u) != null && (g = t09Var.g(i)) != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("video_data", m);
                bundle5.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle5.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                g.setArguments(bundle5);
                return g;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.B4(this.s);
                videoPlayFragment.M4(this.t);
                videoPlayFragment.L4(this.p);
                videoPlayFragment.w4(this.q);
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
            if (obj instanceof z09) {
                z09 z09Var = (z09) obj;
                VideoItemModel D0 = z09Var.D0();
                VideoItemModel m = this.d.m(z09Var.q());
                if (Objects.equals(D0, m) && (D0 == null || D0.getDataType() == m.getDataType())) {
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
            z09 z09Var = this.r.get(i);
            String str3 = null;
            if (z09Var instanceof VideoPlayFragment) {
                videoPlayFragment = (VideoPlayFragment) z09Var;
            } else {
                videoPlayFragment = null;
            }
            if (videoPlayFragment != null) {
                list = videoPlayFragment.M3();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.J3();
            } else {
                str = null;
                list = null;
            }
            int i2 = i - 1;
            if (i2 >= 0 && (e2 = e(i2)) != null) {
                str2 = e2.J3();
            } else {
                str2 = null;
            }
            int i3 = i + 1;
            if (i3 < getCount() && (e = e(i3)) != null) {
                str3 = e.J3();
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
                    xw6.m().z(this.k, null, this.d.o());
                    if (!xw6.m().v("6061002332-203360688") && this.d.g(i)) {
                        notifyDataSetChanged();
                    }
                } else if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    xw6.m().y(this.k, null, this.d.o());
                    if (!xw6.m().v(xw6.s()) && this.d.g(i)) {
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
            z09 z09Var = (z09) super.instantiateItem(viewGroup, i);
            z09Var.m0(i);
            this.r.put(i, z09Var);
            return z09Var;
        }
        return invokeLI.objValue;
    }

    public void m(vz8 vz8Var, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, vz8Var, rect) == null) {
            this.d = vz8Var;
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
                z09 z09Var = this.r.get(this.l);
                if (z09Var instanceof AdVideoFlowFragment) {
                    ((BaseFragment) z09Var).setUserVisibleHint(z);
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
                    z09 z09Var = this.r.get(this.l);
                    if (z09Var instanceof AdVideoFlowFragment) {
                        BaseFragment baseFragment = (BaseFragment) z09Var;
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
                        z09 z09Var2 = this.r.get(this.l);
                        if (z09Var2 instanceof AdVideoFlowFragment) {
                            ((BaseFragment) z09Var2).setUserVisibleHint(true);
                        }
                    }
                }
            }
        }
    }
}

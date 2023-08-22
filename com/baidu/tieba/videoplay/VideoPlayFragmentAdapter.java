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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.ata;
import com.baidu.tieba.bsa;
import com.baidu.tieba.bta;
import com.baidu.tieba.hta;
import com.baidu.tieba.ita;
import com.baidu.tieba.kx9;
import com.baidu.tieba.ppa;
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
import com.baidu.tieba.videoplay.videoLive.VideoLiveFragment;
import com.baidu.tieba.vra;
import com.baidu.tieba.y98;
import com.baidu.tieba.yw7;
import com.baidu.tieba.zra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes8.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final BdUniqueId a;
    public int b;
    public boolean c;
    public bsa d;
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
    public bta p;
    public vra q;
    public final SparseArray<hta> r;
    public kx9.c s;
    public VideoPlayFragment.g1 t;
    public ata u;
    public int v;
    public boolean w;
    public final int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
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
            UpdateAttentionMessage.UpdateAttentionData data;
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null && !TextUtils.isEmpty(data.toUid)) {
                for (int i = 0; i < this.a.d.k(); i++) {
                    VideoItemData t = this.a.d.t(i);
                    if (t != null && (userItemData = t.author_info) != null && data.toUid.equals(userItemData.user_id)) {
                        if (!data.isSucc && !"0".equals(t.author_info.is_follow)) {
                            t.author_info.is_follow = "0";
                        } else if (!updateAttentionMessage.isAttention()) {
                            t.author_info.is_follow = "0";
                        } else {
                            t.author_info.is_follow = "1";
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
        this.v = 0;
        this.w = false;
        this.y = false;
        this.z = false;
        this.A = new a(this, 2001115);
        this.a = bdUniqueId;
        this.n = baseFragment;
        this.o = bdUniqueId2;
        new zra();
        this.k = activity;
        this.x = i;
        this.b = i2;
        this.c = z;
        this.z = z2;
    }

    public VideoAttentionListPageFragment c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            hta htaVar = this.r.get(i);
            if (htaVar instanceof VideoAttentionListPageFragment) {
                return (VideoAttentionListPageFragment) htaVar;
            }
            return null;
        }
        return (VideoAttentionListPageFragment) invokeI.objValue;
    }

    public VideoPlayFragment e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            hta htaVar = this.r.get(i);
            if (htaVar instanceof VideoPlayFragment) {
                return (VideoPlayFragment) htaVar;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public VideoItemData f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            bsa bsaVar = this.d;
            if (bsaVar == null) {
                return null;
            }
            return bsaVar.t(i);
        }
        return (VideoItemData) invokeI.objValue;
    }

    public VideoAdFragment g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            hta htaVar = this.r.get(i);
            if (htaVar instanceof VideoAdFragment) {
                return (VideoAdFragment) htaVar;
            }
            return null;
        }
        return (VideoAdFragment) invokeI.objValue;
    }

    public VideoLiveFragment h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            hta htaVar = this.r.get(i);
            if (htaVar instanceof VideoLiveFragment) {
                return (VideoLiveFragment) htaVar;
            }
            return null;
        }
        return (VideoLiveFragment) invokeI.objValue;
    }

    public void l(vra vraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vraVar) == null) {
            this.q = vraVar;
        }
    }

    public void o(ata ataVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ataVar) == null) {
            this.u = ataVar;
        }
    }

    public void p(kx9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void q(bta btaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, btaVar) == null) {
            this.p = btaVar;
        }
    }

    public void r(VideoPlayFragment.g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, g1Var) == null) {
            this.t = g1Var;
        }
    }

    public CustomMessageListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.A;
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            bsa bsaVar = this.d;
            if (bsaVar == null) {
                return 0;
            }
            return bsaVar.k();
        }
        return invokeV.intValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = SharedPrefHelper.getInstance().getInt("nani_key_download_show_rate", 2);
            if (this.i > 0 && i != 1) {
                SharedPrefHelper.getInstance().putLong("key_vertical_shown_time", this.i);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Parcelable[] parcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
            ata ataVar = this.u;
            if (ataVar != null) {
                ataVar.f(i);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        ata ataVar;
        AdVideoFlowFragment g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            VideoItemModel n = this.d.n(i);
            if (n != null && n.isNoLoginType()) {
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = new VideoAttentionNotLoginFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("video_data", n);
                bundle.putSerializable("from", this.h);
                bundle.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                videoAttentionNotLoginFragment.setArguments(bundle);
                return videoAttentionNotLoginFragment;
            } else if (n != null && n.isLoadingType()) {
                VideoLoadingFragment videoLoadingFragment = new VideoLoadingFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("video_data", n);
                bundle2.putSerializable("from", this.h);
                bundle2.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle2.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                videoLoadingFragment.setArguments(bundle2);
                return videoLoadingFragment;
            } else if (n != null && n.isNoAttentionType()) {
                VideoAttentionListPageFragment videoAttentionListPageFragment = new VideoAttentionListPageFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("video_data", n);
                bundle3.putSerializable("from", this.h);
                bundle3.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle3.putSerializable("video_attention_list", (Serializable) this.d.q());
                bundle3.putString("video_attention_showword", this.d.r());
                videoAttentionListPageFragment.setArguments(bundle3);
                return videoAttentionListPageFragment;
            } else if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && n != null && n.isFunAdType()) {
                VideoAdFragment videoAdFragment = new VideoAdFragment();
                if (n.getVideoAdData() == null) {
                    n.setVideoAdData(new ppa(y98.a(10, 500)));
                }
                videoAdFragment.m2(this.d.o());
                videoAdFragment.n2(this.d.p());
                videoAdFragment.p2(this.p);
                videoAdFragment.o2(n);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("video_index", Integer.valueOf(i));
                bundle4.putSerializable("page_from", this.g);
                bundle4.putSerializable("from", this.h);
                bundle4.putSerializable("obj_id", this.j);
                videoAdFragment.setArguments(bundle4);
                return videoAdFragment;
            } else if (n != null && n.isNADType() && (ataVar = this.u) != null && (g = ataVar.g(i)) != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("video_data", n);
                bundle5.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle5.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                g.setArguments(bundle5);
                return g;
            } else if (n != null && n.getVideoItemData() != null && n.getVideoItemData().getLivePageData() != null) {
                VideoLiveFragment videoLiveFragment = new VideoLiveFragment();
                videoLiveFragment.B2(this.t);
                Bundle bundle6 = new Bundle();
                bundle6.putSerializable("video_data", n);
                bundle6.putSerializable("live_config", this.d.m());
                bundle6.putInt("video_index", i);
                bundle6.putString("live_page_from", ita.a(this.h));
                videoLiveFragment.setArguments(bundle6);
                return videoLiveFragment;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.i5(this.s);
                videoPlayFragment.t5(this.t);
                videoPlayFragment.s5(this.p);
                videoPlayFragment.d5(this.q);
                Bundle bundle7 = new Bundle();
                bundle7.putBoolean(VideoPlayActivityConfig.IS_SCROLLED, this.y);
                bundle7.putBoolean(VideoPlayActivityConfig.IS_NEED_SHOW_SECOND_FLOOR, this.z);
                bundle7.putSerializable("video_data", n);
                bundle7.putSerializable("video_index", Integer.valueOf(i));
                bundle7.putSerializable("page_from", this.g);
                bundle7.putSerializable("from", this.h);
                bundle7.putSerializable("obj_id", this.j);
                BaseFragment baseFragment = this.n;
                if (baseFragment != null && this.o == baseFragment.getUniqueId()) {
                    BaseFragment baseFragment2 = this.n;
                    if (baseFragment2 instanceof VideoAttentionPageFragment) {
                        bundle7.putSerializable("video_channel_tab", "a089");
                    } else if (baseFragment2 instanceof VideoVerticalPageFragment) {
                        bundle7.putSerializable("video_channel_tab", "a088");
                    }
                }
                if (this.e) {
                    bundle7.putParcelable("video_cover_rect", this.f);
                    this.e = false;
                }
                bundle7.putSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID, this.a);
                bundle7.putInt(VideoPlayActivityConfig.CURRENT_TYPE, this.b);
                bundle7.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.c);
                videoPlayFragment.setArguments(bundle7);
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
            if (obj instanceof hta) {
                hta htaVar = (hta) obj;
                VideoItemModel X0 = htaVar.X0();
                VideoItemModel n = this.d.n(htaVar.A());
                if (Objects.equals(X0, n) && (X0 == null || X0.getDataType() == n.getDataType())) {
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

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.y = true;
            if (this.x == 1 && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.d.z(i)) {
                yw7.m().y(this.k, null, this.d.p());
                if (!yw7.m().v(yw7.s()) && this.d.g(i)) {
                    notifyDataSetChanged();
                }
            }
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.m = z;
            int i = this.l;
            if (i != -1) {
                if (e(i) != null) {
                    e(this.l).setUserVisibleHint(z);
                } else if (h(this.l) != null) {
                    h(this.l).z2(this.w);
                    h(this.l).setUserVisibleHint(z);
                } else {
                    hta htaVar = this.r.get(this.l);
                    if (htaVar instanceof AdVideoFlowFragment) {
                        ((BaseFragment) htaVar).setUserVisibleHint(z);
                    }
                }
            }
        }
    }

    public void i(int i) {
        VideoPlayFragment videoPlayFragment;
        String str;
        List<String> list;
        String str2;
        VideoPlayFragment e;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (this.v > i) {
                this.w = true;
            } else {
                this.w = false;
            }
            this.v = i;
            hta htaVar = this.r.get(i);
            String str3 = null;
            if (htaVar instanceof VideoPlayFragment) {
                videoPlayFragment = (VideoPlayFragment) htaVar;
            } else {
                videoPlayFragment = null;
            }
            if (videoPlayFragment != null) {
                list = videoPlayFragment.p4();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.m4();
            } else {
                str = null;
                list = null;
            }
            int i2 = i - 1;
            if (i2 >= 0 && (e2 = e(i2)) != null) {
                str2 = e2.m4();
            } else {
                str2 = null;
            }
            int i3 = i + 1;
            if (i3 < getCount() && (e = e(i3)) != null) {
                str3 = e.m4();
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

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            hta htaVar = (hta) super.instantiateItem(viewGroup, i);
            htaVar.E0(i);
            this.r.put(i, htaVar);
            return htaVar;
        }
        return invokeLI.objValue;
    }

    public void n(bsa bsaVar, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bsaVar, rect) == null) {
            this.d = bsaVar;
            this.e = true;
            int i = this.b;
            if (i == 3 || i == 1 || i == 7) {
                this.f = rect;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048598, this, viewGroup, i, obj) == null) {
            int i3 = this.l;
            if (i3 != i && i3 != -1) {
                if (e(i3) != null) {
                    e(this.l).setPrimary(false);
                    e(this.l).setUserVisibleHint(false);
                } else if (h(this.l) != null) {
                    h(this.l).setPrimary(false);
                    h(this.l).z2(this.w);
                    h(this.l).setUserVisibleHint(false);
                } else {
                    hta htaVar = this.r.get(this.l);
                    if (htaVar instanceof AdVideoFlowFragment) {
                        BaseFragment baseFragment = (BaseFragment) htaVar;
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
                        } else if (h(this.l) != null) {
                            h(this.l).z2(this.w);
                            h(this.l).setUserVisibleHint(true);
                        } else {
                            hta htaVar2 = this.r.get(this.l);
                            if (htaVar2 instanceof AdVideoFlowFragment) {
                                ((BaseFragment) htaVar2).setUserVisibleHint(true);
                            }
                        }
                    }
                }
            }
        }
    }
}

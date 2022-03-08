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
import c.a.r0.a3.h;
import c.a.r0.l4.f;
import c.a.r0.n4.c.b;
import c.a.r0.n4.c.d;
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
    public int f47415b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47416c;

    /* renamed from: d  reason: collision with root package name */
    public d f47417d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47418e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f47419f;

    /* renamed from: g  reason: collision with root package name */
    public long f47420g;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f47421h;

    /* renamed from: i  reason: collision with root package name */
    public int f47422i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f47423j;
    public BaseFragment k;
    public BdUniqueId l;
    public c.a.r0.n4.i.a m;
    public String mFrom;
    public String mFromPage;
    public final SparseArray<c.a.r0.n4.j.b.a> n;
    public h.c o;
    public String objId;
    public VideoPlayFragment.m1 p;
    public c.a.r0.n4.h.a q;
    public final int r;
    public CustomMessageListener s;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragmentAdapter a;

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
            this.a = videoPlayFragmentAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.f39406c)) {
                return;
            }
            for (int i2 = 0; i2 < this.a.f47417d.k(); i2++) {
                VideoItemData s = this.a.f47417d.s(i2);
                if (s != null && (userItemData = s.author_info) != null && data.f39406c.equals(userItemData.user_id)) {
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
    public VideoPlayFragmentAdapter(BdUniqueId bdUniqueId, BaseFragment baseFragment, Activity activity, BdUniqueId bdUniqueId2, int i2, int i3, boolean z) {
        super(baseFragment.getChildFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, baseFragment, activity, bdUniqueId2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
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
        this.f47420g = -1L;
        this.f47422i = -1;
        this.n = new SparseArray<>();
        this.s = new a(this, 2001115);
        this.a = bdUniqueId;
        this.k = baseFragment;
        this.l = bdUniqueId2;
        new b();
        this.f47421h = activity;
        this.r = i2;
        this.f47415b = i3;
        this.f47416c = z;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            super.destroyItem(viewGroup, i2, obj);
            this.n.remove(i2);
            c.a.r0.n4.h.a aVar = this.q;
            if (aVar != null) {
                aVar.f(i2);
            }
        }
    }

    public VideoAttentionListPageFragment getAttentionListFragment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c.a.r0.n4.j.b.a aVar = this.n.get(i2);
            if (aVar instanceof VideoAttentionListPageFragment) {
                return (VideoAttentionListPageFragment) aVar;
            }
            return null;
        }
        return (VideoAttentionListPageFragment) invokeI.objValue;
    }

    public CustomMessageListener getAttentionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (CustomMessageListener) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d dVar = this.f47417d;
            if (dVar == null) {
                return 0;
            }
            return dVar.k();
        }
        return invokeV.intValue;
    }

    public VideoPlayFragment getCurrentFragment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            c.a.r0.n4.j.b.a aVar = this.n.get(i2);
            if (aVar instanceof VideoPlayFragment) {
                return (VideoPlayFragment) aVar;
            }
            return null;
        }
        return (VideoPlayFragment) invokeI.objValue;
    }

    public VideoItemData getData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            d dVar = this.f47417d;
            if (dVar == null) {
                return null;
            }
            return dVar.s(i2);
        }
        return (VideoItemData) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        c.a.r0.n4.h.a aVar;
        AdVideoFlowFragment g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            VideoItemModel m = this.f47417d.m(i2);
            if (m != null && m.isNoLoginType()) {
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = new VideoAttentionNotLoginFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("video_data", m);
                bundle.putSerializable("from", this.mFromPage);
                bundle.putInt("current_type", this.f47415b);
                bundle.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f47416c);
                videoAttentionNotLoginFragment.setArguments(bundle);
                return videoAttentionNotLoginFragment;
            } else if (m != null && m.isLoadingType()) {
                VideoLoadingFragment videoLoadingFragment = new VideoLoadingFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("video_data", m);
                bundle2.putSerializable("from", this.mFromPage);
                bundle2.putInt("current_type", this.f47415b);
                bundle2.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f47416c);
                videoLoadingFragment.setArguments(bundle2);
                return videoLoadingFragment;
            } else if (m != null && m.isNoAttentionType()) {
                VideoAttentionListPageFragment videoAttentionListPageFragment = new VideoAttentionListPageFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("video_data", m);
                bundle3.putSerializable("from", this.mFromPage);
                bundle3.putInt("current_type", this.f47415b);
                bundle3.putSerializable("video_attention_list", (Serializable) this.f47417d.p());
                bundle3.putString("video_attention_showword", this.f47417d.q());
                videoAttentionListPageFragment.setArguments(bundle3);
                return videoAttentionListPageFragment;
            } else if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && m != null && m.isFunAdType()) {
                VideoAdFragment videoAdFragment = new VideoAdFragment();
                if (m.getVideoAdData() == null) {
                    m.setVideoAdData(new f(c.a.r0.p1.a.a.a(10, 500)));
                }
                videoAdFragment.setBaseActivityId(this.f47417d.n());
                videoAdFragment.setPageType(this.f47417d.o());
                videoAdFragment.setVideoPlayPrefetcher(this.m);
                videoAdFragment.setVideoAdDataModel(m);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("video_index", Integer.valueOf(i2));
                bundle4.putSerializable("page_from", this.mFrom);
                bundle4.putSerializable("from", this.mFromPage);
                bundle4.putSerializable("obj_id", this.objId);
                videoAdFragment.setArguments(bundle4);
                return videoAdFragment;
            } else if (m != null && m.isNADType() && (aVar = this.q) != null && (g2 = aVar.g(i2)) != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("video_data", m);
                bundle5.putInt("current_type", this.f47415b);
                bundle5.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f47416c);
                g2.setArguments(bundle5);
                return g2;
            } else {
                VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
                videoPlayFragment.setOnProgressUpdatedListener(this.o);
                videoPlayFragment.setVideoStatusListener(this.p);
                videoPlayFragment.setVideoPlayPrefetcher(this.m);
                Bundle bundle6 = new Bundle();
                bundle6.putSerializable("video_data", m);
                bundle6.putSerializable("video_index", Integer.valueOf(i2));
                bundle6.putSerializable("page_from", this.mFrom);
                bundle6.putSerializable("from", this.mFromPage);
                bundle6.putSerializable("obj_id", this.objId);
                BaseFragment baseFragment = this.k;
                if (baseFragment != null && this.l == baseFragment.getUniqueId()) {
                    BaseFragment baseFragment2 = this.k;
                    if (baseFragment2 instanceof VideoAttentionPageFragment) {
                        bundle6.putSerializable("video_channel_tab", "a089");
                    } else if (baseFragment2 instanceof VideoVerticalPageFragment) {
                        bundle6.putSerializable("video_channel_tab", "a088");
                    }
                }
                if (this.f47418e) {
                    bundle6.putParcelable("video_cover_rect", this.f47419f);
                    this.f47418e = false;
                }
                bundle6.putSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID, this.a);
                bundle6.putInt("current_type", this.f47415b);
                bundle6.putBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, this.f47416c);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof c.a.r0.n4.j.b.a) {
                c.a.r0.n4.j.b.a aVar = (c.a.r0.n4.j.b.a) obj;
                VideoItemModel currentData = aVar.getCurrentData();
                VideoItemModel m = this.f47417d.m(aVar.getFragmentIndex());
                if (Objects.equals(currentData, m) && (currentData == null || currentData.getDataType() == m.getDataType())) {
                    return super.getItemPosition(obj);
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public VideoAdFragment getVideoAdFragment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            c.a.r0.n4.j.b.a aVar = this.n.get(i2);
            if (aVar instanceof VideoAdFragment) {
                return (VideoAdFragment) aVar;
            }
            return null;
        }
        return (VideoAdFragment) invokeI.objValue;
    }

    public SparseArray<c.a.r0.n4.j.b.a> getVideoFragmentList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : (SparseArray) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i2)) == null) {
            c.a.r0.n4.j.b.a aVar = (c.a.r0.n4.j.b.a) super.instantiateItem(viewGroup, i2);
            aVar.setFragmentIndex(i2);
            this.n.put(i2, aVar);
            return aVar;
        }
        return invokeLI.objValue;
    }

    public void onPageScrollIdle(int i2) {
        String str;
        List<String> list;
        VideoPlayFragment currentFragment;
        VideoPlayFragment currentFragment2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            c.a.r0.n4.j.b.a aVar = this.n.get(i2);
            String str2 = null;
            VideoPlayFragment videoPlayFragment = aVar instanceof VideoPlayFragment ? (VideoPlayFragment) aVar : null;
            if (videoPlayFragment != null) {
                list = videoPlayFragment.getMediaIDs();
                if (ListUtils.getCount(list) < 5) {
                    return;
                }
                str = videoPlayFragment.getCurrentMediaID();
            } else {
                str = null;
                list = null;
            }
            int i3 = i2 - 1;
            String currentMediaID = (i3 < 0 || (currentFragment2 = getCurrentFragment(i3)) == null) ? null : currentFragment2.getCurrentMediaID();
            int i4 = i2 + 1;
            if (i4 < getCount() && (currentFragment = getCurrentFragment(i4)) != null) {
                str2 = currentFragment.getCurrentMediaID();
            }
            ArrayList arrayList = new ArrayList();
            int count = ListUtils.getCount(list);
            for (int i5 = 0; i5 < count; i5++) {
                String str3 = list.get(i5);
                if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, currentMediaID) && !TextUtils.equals(str3, str2)) {
                    arrayList.add(str3);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }

    public void onStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && this.r == 1 && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f47417d.y(i2)) {
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                c.a.r0.e1.a.i().q(this.f47421h, null, this.f47417d.o());
                if (c.a.r0.e1.a.i().m("6061002332-203360688") || !this.f47417d.g(i2)) {
                    return;
                }
                notifyDataSetChanged();
            } else if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                c.a.r0.e1.a.i().p(this.f47421h, null, this.f47417d.o());
                if (c.a.r0.e1.a.i().m("6061002410-390177882") || !this.f47417d.g(i2)) {
                    return;
                }
                notifyDataSetChanged();
            }
        }
    }

    public void saveNaniShowTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int l = c.a.q0.r.j0.b.k().l("nani_key_download_show_rate", 2);
            if (this.f47420g <= 0 || l == 1) {
                return;
            }
            c.a.q0.r.j0.b.k().x("key_vertical_shown_time", this.f47420g);
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

    public void setCurrentFragmentUserHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f47423j = z;
            int i2 = this.f47422i;
            if (i2 != -1) {
                if (getCurrentFragment(i2) != null) {
                    getCurrentFragment(this.f47422i).setUserVisibleHint(z);
                    return;
                }
                c.a.r0.n4.j.b.a aVar = this.n.get(this.f47422i);
                if (aVar instanceof AdVideoFlowFragment) {
                    ((BaseFragment) aVar).setUserVisibleHint(z);
                }
            }
        }
    }

    public void setDatas(d dVar, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, dVar, rect) == null) {
            this.f47417d = dVar;
            this.f47418e = true;
            int i2 = this.f47415b;
            if (i2 == 3 || i2 == 1 || i2 == 7) {
                this.f47419f = rect;
            }
        }
    }

    public void setNadDispatcher(c.a.r0.n4.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void setOnProgressUpdatedListener(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.o = cVar;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, viewGroup, i2, obj) == null) {
            int i4 = this.f47422i;
            if (i4 != i2 && i4 != -1) {
                if (getCurrentFragment(i4) != null) {
                    getCurrentFragment(this.f47422i).setPrimary(false);
                    getCurrentFragment(this.f47422i).setUserVisibleHint(false);
                } else {
                    c.a.r0.n4.j.b.a aVar = this.n.get(this.f47422i);
                    if (aVar instanceof AdVideoFlowFragment) {
                        BaseFragment baseFragment = (BaseFragment) aVar;
                        baseFragment.setPrimary(false);
                        baseFragment.setUserVisibleHint(false);
                    }
                }
            }
            this.f47422i = i2;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment2 = (BaseFragment) obj;
                if (baseFragment2.isPrimary()) {
                    return;
                }
                baseFragment2.setPrimary(true);
                if (!this.f47423j || (i3 = this.f47422i) == -1) {
                    return;
                }
                if (getCurrentFragment(i3) != null) {
                    getCurrentFragment(this.f47422i).setUserVisibleHint(true);
                    return;
                }
                c.a.r0.n4.j.b.a aVar2 = this.n.get(this.f47422i);
                if (aVar2 instanceof AdVideoFlowFragment) {
                    ((BaseFragment) aVar2).setUserVisibleHint(true);
                }
            }
        }
    }

    public void setVideoPlayPrefetcher(c.a.r0.n4.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void setVideoStatusListener(VideoPlayFragment.m1 m1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, m1Var) == null) {
            this.p = m1Var;
        }
    }
}

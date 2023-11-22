package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.HeaderCard;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class we8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ye8 a;
    public final int b;
    public int c;
    public ff8 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<oi> k;
    public wc8 l;

    public final int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Comparator<vm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(we8 we8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(vm6 vm6Var, vm6 vm6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vm6Var, vm6Var2)) == null) {
                if (vm6Var != null && vm6Var2 != null) {
                    if (vm6Var.getPosition() > vm6Var2.getPosition()) {
                        return 1;
                    }
                    if (vm6Var.getPosition() < vm6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends jy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm6 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(we8 we8Var, int i, String str, gm6 gm6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we8Var, Integer.valueOf(i), str, gm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = gm6Var;
        }

        @Override // com.baidu.tieba.jy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), g(), null)));
                gm6 gm6Var = this.n;
                if (gm6Var instanceof om6) {
                    statisticItem = ((om6) gm6Var).N();
                } else if (gm6Var instanceof pm6) {
                    statisticItem = ((pm6) gm6Var).J(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public we8(wc8 wc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = new ff8();
        this.e = 0;
        this.j = 0L;
        this.a = new ye8();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = SharedPrefHelper.getInstance().getInt("home_page_max_thread_count", 300);
        }
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
        this.l = wc8Var;
    }

    public final void A(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
            this.f = ListUtils.getCount(list);
            BannerList bannerList = builder.banner_list;
            if (bannerList != null) {
                this.g = ListUtils.getCount(bannerList.app);
            } else {
                this.g = 0;
            }
            int count = ListUtils.getCount(list) + ListUtils.getCount(this.h);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                    hashSet2.add(threadInfo.lego_card);
                } else if (threadInfo != null && threadInfo.tid != null) {
                    hashSet.add(ue8.a(builder, threadInfo));
                }
            }
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            Iterator<ThreadInfo> it = this.h.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                    hashSet4.add(next.lego_card);
                } else if (next != null && next.tid != null) {
                    hashSet3.add(ue8.a(builder, next));
                }
            }
            if (i == 1) {
                if (!ListUtils.isEmpty(list2)) {
                    this.d.b((ThreadInfo) ListUtils.getItem(list2, 0));
                }
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                        if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                            list.add(threadInfo2);
                        }
                    } else if (threadInfo2 != null && threadInfo2.tid != null) {
                        te8 a2 = ue8.a(builder2, threadInfo2);
                        if (!hashSet.contains(a2) && !hashSet3.contains(a2)) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!a2.a() || !z3) {
                            list.add(threadInfo2);
                            JSONObject b2 = nea.b(threadInfo2);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (y()) {
                    BannerList bannerList2 = builder.banner_list;
                    if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                        this.i.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.h.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (ListUtils.getCount(this.h) > this.b) {
                        for (int size = this.h.size() - 1; size >= this.b; size--) {
                            this.h.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo next2 = it2.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                            hashSet4.add(next2.lego_card);
                        } else if (next2 != null && next2.tid != null) {
                            hashSet3.add(ue8.a(builder, next2));
                        }
                    }
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) ListUtils.getItem(list2, count2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && threadInfo3.tid != null) {
                        te8 a3 = ue8.a(builder2, threadInfo3);
                        if (!hashSet.contains(a3) && !hashSet3.contains(a3)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!a3.a() || !z2 || threadInfo3.is_highlight.intValue() == 1) {
                            list.add(0, threadInfo3);
                            JSONObject b3 = nea.b(threadInfo3);
                            if (b3 != null) {
                                arrayList.add(0, b3);
                            }
                        }
                    }
                }
            }
            if (y()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            dca.c(builder4, count3);
                            App build = builder4.build(false);
                            this.i.remove(i2);
                            this.i.add(i2, build);
                        }
                    }
                }
                if (ListUtils.getCount(list) >= this.e) {
                    list.addAll(this.h);
                    this.h.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.i);
                    builder.banner_list = builder5.build(false);
                    this.i.clear();
                }
            }
            int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.h)) - count;
            this.a.b = count4;
            this.c = count4;
            nea.f().h("HOME", arrayList);
        }
    }

    public final void B(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void C(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
            Integer num = builder2.fresh_ctrl_num;
            if (num != null && num.intValue() > 0) {
                i2 = builder2.fresh_ctrl_num.intValue();
            } else {
                i2 = 0;
            }
            this.e = i2;
            int i3 = this.b;
            if (i2 > i3) {
                i2 = i3;
            }
            this.e = i2;
            A(z, builder, builder2, i);
            z(z, builder, builder2, i);
            B(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final List<ThreadInfo> D(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, builder, i, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (builder != null && (list = builder.thread_list) != null) {
                if (i == 1) {
                    for (int count = ((ListUtils.getCount(list) - i2) + 30) - 1; count >= 30; count--) {
                        if (list.size() > count) {
                            arrayList.add(list.remove(count));
                        }
                    }
                } else {
                    for (int count2 = ListUtils.getCount(list) - 1; count2 >= i2; count2--) {
                        list.remove(count2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }

    public void s(List<oi> list, oe8 oe8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, list, oe8Var, z) == null) {
            if (z) {
                DefaultLog.getInstance().i("RecentForumLog", "插入最进逛的吧，有直播数据，不插入");
            } else if (list != null && this.a.a != null) {
                E(list);
                E(this.a.a);
                int l = l(list);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("RecentForumLog", "插入最进逛的吧，Banner位置为：" + l);
                list.add(l + 1, oe8Var);
                this.a.a.add(0, oe8Var);
                oe8Var.position = -1;
            }
        }
    }

    public final void E(List<oi> list) {
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, list) == null) && (e = e(list)) != -1) {
            list.remove(e);
        }
    }

    public final boolean G(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, builder)) == null) {
            if (builder == null || (num = builder.show_adsense) == null || num.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H(List<vm6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }

    public final int e(List<oi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof oe8) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int l(List<oi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof qe8) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void F(List<oi> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            Iterator<oi> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                oi next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if ((next instanceof RecommendBarCardModel) && !((RecommendBarCardModel) next).i()) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final void a(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            int i = 0;
            int i2 = 0;
            for (oi oiVar : list) {
                if (oiVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) oiVar;
                    if (recommendBarCardModel.i()) {
                        recommendBarCardModel.position = i2 + 1;
                        i++;
                    }
                }
                if (oiVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) oiVar;
                    i2 = baseCardInfo.position + i;
                    baseCardInfo.position = i2;
                }
            }
        }
    }

    public void I(long j, boolean z) {
        ye8 ye8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (ye8Var = this.a) != null && !ListUtils.isEmpty(ye8Var.a)) {
            for (oi oiVar : this.a.a) {
                if (oiVar instanceof gm6) {
                    gm6 gm6Var = (gm6) oiVar;
                    if (gm6Var.n && j == gm6Var.getThreadData().getFid() && z != gm6Var.getThreadData().getForumData().f()) {
                        gm6Var.getThreadData().getForumData().o(z);
                    }
                }
            }
        }
    }

    public boolean v(List<oi> list, l98 l98Var) {
        InterceptResult invokeLL;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, list, l98Var)) == null) {
            if (list != null && this.a.a != null && l98Var != null && StringUtils.isNotNull(l98Var.getTid())) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    oi oiVar = list.get(i2);
                    if (oiVar instanceof om6) {
                        om6 om6Var = (om6) oiVar;
                        if (om6Var.getThreadData() != null && StringUtils.isNotNull(om6Var.getThreadData().getTid()) && om6Var.getThreadData().getTid().equals(l98Var.getTid())) {
                            l98Var.Y(om6Var.getThreadData().getClickBackCard());
                            i = i2;
                            break;
                        }
                    }
                    i2++;
                }
                if (x(list, l98Var) || !l98.Z(l98Var) || (j = j(i, list, l98Var.getTid())) < 0) {
                    return false;
                }
                list.add(j, l98Var);
                this.a.a.add(j, l98Var);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final me8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ye8 ye8Var = this.a;
            if (ye8Var != null && !ListUtils.isEmpty(ye8Var.a)) {
                for (oi oiVar : this.a.a) {
                    if (oiVar instanceof me8) {
                        return (me8) oiVar;
                    }
                }
            }
            return null;
        }
        return (me8) invokeV.objValue;
    }

    public final pe8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ye8 ye8Var = this.a;
            if (ye8Var != null && !ListUtils.isEmpty(ye8Var.a)) {
                for (oi oiVar : this.a.a) {
                    if (oiVar instanceof pe8) {
                        return (pe8) oiVar;
                    }
                }
            }
            return null;
        }
        return (pe8) invokeV.objValue;
    }

    @Nullable
    public final List<RecommendBarCardModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ye8 ye8Var = this.a;
            if (ye8Var != null && !ListUtils.isEmpty(ye8Var.a)) {
                ArrayList arrayList = new ArrayList();
                for (oi oiVar : this.a.a) {
                    if (oiVar instanceof RecommendBarCardModel) {
                        RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) oiVar;
                        if (recommendBarCardModel.i()) {
                            arrayList.add(recommendBarCardModel);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public ye8 f(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder3 = new DataRes.Builder();
            } else {
                builder3 = builder;
            }
            if (builder2 == null) {
                builder4 = new DataRes.Builder();
            } else {
                builder4 = builder2;
            }
            af8.c(builder3);
            af8.c(builder4);
            C(z, builder3, builder4, i);
            List<ThreadInfo> D = D(builder3, i, this.b);
            af8.p(builder3);
            List<AdvertAppInfo> g = zca.m().g();
            int i3 = 0;
            if (i != 0 && z && g != null) {
                i2 = g.size();
            } else {
                i2 = 0;
            }
            List<vm6> d = af8.d(builder3);
            H(d);
            int i4 = i2;
            List<oi> o = o(builder3.thread_list, d, builder4.user_follow_live, i, 0, builder4, i4, z);
            List<oi> o2 = o(D, new ArrayList(), builder4.user_follow_live, i, 1, null, i4, z);
            this.d.a(o);
            xe8.c(builder3, o);
            ye8 ye8Var = this.a;
            ye8Var.a = o;
            if (o2 != null) {
                i3 = o2.size();
            }
            ye8Var.c = i3;
            return this.a;
        }
        return (ye8) invokeCommon.objValue;
    }

    public List<ThreadInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int j(int i, @NonNull List<oi> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048594, this, i, list, str)) == null) {
            return lf8.a(i, list, str);
        }
        return invokeILL.intValue;
    }

    public final int k(@NonNull String str, @NonNull List<oi> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                oi oiVar = list.get(i);
                if (oiVar instanceof gm6) {
                    gm6 gm6Var = (gm6) oiVar;
                    if (gm6Var.getThreadData() != null && !TextUtils.isEmpty(gm6Var.getThreadData().getTid()) && str.equals(gm6Var.getThreadData().getTid())) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void n(List<oi> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, list, userFollowLive) == null) && b() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            DefaultLog.getInstance().i("RecentForumLog", "直播入口插入，删除最近逛的吧模快");
            E(list);
            E(this.a.a);
            me8 me8Var = new me8();
            me8Var.d(userFollowLive);
            list.add(0, me8Var);
            this.a.a.add(0, me8Var);
            me8Var.position = -1;
        }
    }

    public final void m(vm6 vm6Var, List<oi> list, int i, int i2, int i3) {
        z26 z26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{vm6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = v26.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof z26) {
                z26Var = (z26) g;
            } else {
                z26Var = null;
            }
            if (vm6Var instanceof he8) {
                str = ((he8) vm6Var).a.a;
            }
            if (z26Var != null && !ListUtils.isEmpty(z26Var.d()) && z26Var.d().contains(str)) {
                v26.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && v26.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                v26.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && z26Var != null && z26Var.d() != null) {
                    z26Var.d().add(str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<oi> o(List<ThreadInfo> list, List<vm6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3, boolean z) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        Iterator<oi> it;
        boolean z2;
        int e;
        me8 b2;
        List<RecommendBarCardModel> c2;
        int j;
        Iterator<oi> it2;
        long j2;
        long j3;
        pe8 pe8Var;
        boolean z3;
        gm6 e2;
        om6 i5;
        ThreadRecommendInfoData threadRecommendInfoData;
        om6 i6;
        tm6 h;
        l98 g;
        om6 i7;
        om6 i8;
        om6 i9;
        int e3;
        RecommendBarCardModel recommendBarCardModel;
        int i10;
        j98 j98Var;
        int d;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (list == null) {
                return null;
            }
            long j4 = 0;
            int i11 = 1;
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && zo4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<oi> arrayList = new ArrayList<>(ListUtils.getCount(list));
            Iterator<ThreadInfo> it3 = list.iterator();
            while (true) {
                c = 0;
                if (!it3.hasNext()) {
                    break;
                }
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(it3.next());
                arrayList.add(threadData);
            }
            p6b p6bVar = new p6b();
            if (builder != null && (headerCard = builder.header_card) != null) {
                p6bVar.g(headerCard);
            }
            if (i2 == 0 && v6b.p(p6bVar, false)) {
                v6b v6bVar = new v6b();
                v6bVar.n(1);
                v6bVar.h(p6bVar);
                if (ListUtils.add(arrayList, v6bVar.getPosition(), v6bVar)) {
                    int position = v6bVar.getPosition();
                    v6bVar.position = position;
                    i4 = position;
                    if (i2 == 0 && j98.l(builder)) {
                        j98Var = new j98();
                        j98Var.i(builder.hot_card);
                        d = j98Var.d() - 1;
                        if (d >= 0 && ListUtils.add(arrayList, d, j98Var)) {
                            j98Var.position = d;
                        }
                    }
                    if (builder != null && RecommendBarCardModel.t(builder.hot_recomforum, -1)) {
                        recommendBarCardModel = new RecommendBarCardModel();
                        if (builder.hot_recomforum.floor.intValue() <= 0) {
                            i10 = builder.hot_recomforum.floor.intValue() - 1;
                        } else {
                            i10 = 0;
                        }
                        recommendBarCardModel.floorPosition = i10;
                        if (recommendBarCardModel.n(builder.hot_recomforum.tab_list)) {
                            p(recommendBarCardModel, recommendBarCardModel.floorPosition, arrayList);
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && G(builder)) {
                        int f = s75.f();
                        e3 = s75.e();
                        if (i == 0) {
                            e3 = s75.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e3 > i4) {
                            e3++;
                        }
                        q(e3, f, arrayList);
                    }
                    List<oi> linkedList = new LinkedList<>();
                    it = arrayList.iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        oi next = it.next();
                        boolean z4 = next instanceof ThreadData;
                        if (z4 && ((ThreadData) next).isFunAdPlaceHolder()) {
                            if (G(builder)) {
                                linkedList.add(next);
                                i12++;
                            }
                            it2 = it;
                            j2 = j4;
                        } else if (z4) {
                            ThreadData threadData2 = (ThreadData) next;
                            int i13 = i12 + 1;
                            threadData2.floorPosition = i13;
                            threadData2.isFromNet = z;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                ux4 ux4Var = new ux4();
                                ux4Var.e(threadData2.getLegoCard());
                                ux4Var.position = i12;
                                linkedList.add(ux4Var);
                            } else if (nh8.G(threadData2)) {
                                if (StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    j4 = 0;
                                } else {
                                    nh8 nh8Var = new nh8();
                                    nh8Var.I(threadData2.getTopicModule());
                                    nh8Var.Z = i11;
                                    nh8Var.position = i12;
                                    nh8Var.J(threadData2);
                                    nh8Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(nh8Var);
                                }
                            } else if (!om6.R(threadData2) && !pm6.L(threadData2) && !qm6.R(threadData2)) {
                                if (jm6.R(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    jm6 jm6Var = new jm6(threadData2);
                                    jm6Var.position = i12;
                                    linkedList.add(jm6Var);
                                } else {
                                    gm6 e4 = af8.e(threadData2);
                                    if (e4 != null) {
                                        e4.g = threadData2.getTid();
                                        e4.position = i12;
                                    }
                                    if (e4 != null && e4.isValid()) {
                                        linkedList.add(e4);
                                    }
                                }
                            } else {
                                om6 i14 = af8.i(threadData2);
                                if (i14 != null) {
                                    if (!threadData2.showCardEnterFourm() && !"user".equals(threadData2.getHeadType())) {
                                        ThreadData threadData3 = i14.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            i14.g = threadData2.getTid();
                                            i14.position = i12;
                                            af8.t(i14);
                                            linkedList.add(i14);
                                            z3 = true;
                                            e2 = af8.e(threadData2);
                                            if (e2 != null) {
                                                e2.g = threadData2.getTid();
                                                e2.position = i12;
                                                if (e2 instanceof om6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        af8.w(e2);
                                                    } else if (threadData2.picCount() == i11) {
                                                        af8.y(e2);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        it2 = it;
                                                        e2.j = imageWidthAndHeight[c];
                                                        e2.k = imageWidthAndHeight[i11];
                                                    } else {
                                                        it2 = it;
                                                        if (threadData2.picCount() >= 2) {
                                                            af8.x(e2);
                                                        } else {
                                                            af8.z(e2);
                                                        }
                                                    }
                                                } else {
                                                    it2 = it;
                                                    if (e2 instanceof pm6) {
                                                        af8.A(e2);
                                                    }
                                                }
                                                if (e2 instanceof qm6) {
                                                    af8.B(e2);
                                                }
                                                if (e2 != null && e2.isValid()) {
                                                    e2.a.insertItemToTitleOrAbstractText();
                                                    if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z3) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                        Object[] objArr = new Object[i11];
                                                        objArr[c] = threadData2.getAuthor().getName_show();
                                                        String format = String.format(string, objArr);
                                                        SpannableString spannableString = new SpannableString(format);
                                                        spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format.length() - 1, 33);
                                                        e2.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                                    }
                                                    linkedList.add(e2);
                                                }
                                                if (threadData2.getItem() != null && (i9 = af8.i(threadData2)) != null) {
                                                    i9.g = threadData2.getTid();
                                                    i9.position = i12;
                                                    af8.C(i9);
                                                    if (!om6.R(threadData2)) {
                                                        i9.E("1");
                                                    } else if (pm6.L(threadData2)) {
                                                        i9.E("2");
                                                    }
                                                    linkedList.add(i9);
                                                }
                                                if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (i5 = af8.i(threadData2)) != null) {
                                                    i5.g = threadData2.getTid();
                                                    i5.position = i12;
                                                    if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) == 1) {
                                                        af8.F(i5);
                                                    } else {
                                                        af8.D(i5);
                                                    }
                                                    linkedList.add(i5);
                                                }
                                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                                if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (i8 = af8.i(threadData2)) != null) {
                                                    i8.g = threadData2.getTid();
                                                    i8.position = i12;
                                                    af8.E(i8);
                                                    if (i8.isValid()) {
                                                        linkedList.add(i8);
                                                    }
                                                }
                                                if (threadData2.showCardEnterFourm() && (i7 = af8.i(threadData2)) != null) {
                                                    i7.g = threadData2.getTid();
                                                    i7.position = i12;
                                                    af8.s(i7);
                                                    if (!om6.R(threadData2)) {
                                                        i7.E("1");
                                                    } else if (pm6.L(threadData2)) {
                                                        i7.E("2");
                                                    }
                                                    if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                        linkedList.add(i7);
                                                    } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                        linkedList.add(i7);
                                                    }
                                                }
                                                if (threadData2.getTopAgreePost() != null) {
                                                    om6 i15 = af8.i(threadData2);
                                                    if (i15 != null) {
                                                        i15.g = threadData2.getTid();
                                                        i15.position = i12;
                                                        af8.u(i15);
                                                    }
                                                    if (i15 != null && i15.isValid()) {
                                                        linkedList.add(i15);
                                                    }
                                                }
                                                i6 = af8.i(threadData2);
                                                if (i6 != null) {
                                                    i6.g = threadData2.getTid();
                                                    i6.position = i12;
                                                    af8.r(i6);
                                                }
                                                if (i6 != null && i6.isValid() && ThreadCardUtils.isBottomShowOp(i6.a)) {
                                                    linkedList.add(i6);
                                                }
                                                h = af8.h(threadData2, z);
                                                if (h != null) {
                                                    h.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                                                    h.position = i13;
                                                    h.setTid(threadData2.tid);
                                                    linkedList.add(h);
                                                }
                                                g = af8.g(threadData2);
                                                if (g != null && l98.X(g) && x(this.a.a, g) && !x(linkedList, g)) {
                                                    g.g = threadData2.getTid();
                                                    linkedList.add(g);
                                                }
                                                j2 = 0;
                                                j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                                if (j3 != 0 && j3 == this.j.longValue()) {
                                                    if (builder.active_center == null) {
                                                        pe8Var = new pe8();
                                                        pe8Var.G(builder.active_center);
                                                    } else {
                                                        pe8Var = null;
                                                    }
                                                    if (pe8Var == null) {
                                                        pe8Var = d();
                                                    }
                                                    if (pe8Var != null) {
                                                        pe8Var.R = i13;
                                                        linkedList.add(pe8Var);
                                                        i12 = i13;
                                                    }
                                                }
                                                i12++;
                                            }
                                            it2 = it;
                                            if (e2 instanceof qm6) {
                                            }
                                            if (e2 != null) {
                                                e2.a.insertItemToTitleOrAbstractText();
                                                if (!threadData2.isUgcThreadType()) {
                                                    String string2 = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                    Object[] objArr2 = new Object[i11];
                                                    objArr2[c] = threadData2.getAuthor().getName_show();
                                                    String format2 = String.format(string2, objArr2);
                                                    SpannableString spannableString2 = new SpannableString(format2);
                                                    spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format2.length() - 1, 33);
                                                    e2.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                                                }
                                                linkedList.add(e2);
                                            }
                                            if (threadData2.getItem() != null) {
                                                i9.g = threadData2.getTid();
                                                i9.position = i12;
                                                af8.C(i9);
                                                if (!om6.R(threadData2)) {
                                                }
                                                linkedList.add(i9);
                                            }
                                            if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                            }
                                            i5.g = threadData2.getTid();
                                            i5.position = i12;
                                            if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) == 1) {
                                            }
                                            linkedList.add(i5);
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null) {
                                                i8.g = threadData2.getTid();
                                                i8.position = i12;
                                                af8.E(i8);
                                                if (i8.isValid()) {
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm()) {
                                                i7.g = threadData2.getTid();
                                                i7.position = i12;
                                                af8.s(i7);
                                                if (!om6.R(threadData2)) {
                                                }
                                                if (!threadData2.showCardEnterFourm()) {
                                                }
                                                if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                            }
                                            i6 = af8.i(threadData2);
                                            if (i6 != null) {
                                            }
                                            if (i6 != null) {
                                                linkedList.add(i6);
                                            }
                                            h = af8.h(threadData2, z);
                                            if (h != null) {
                                            }
                                            g = af8.g(threadData2);
                                            if (g != null) {
                                                g.g = threadData2.getTid();
                                                linkedList.add(g);
                                            }
                                            j2 = 0;
                                            j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                            if (j3 != 0) {
                                                if (builder.active_center == null) {
                                                }
                                                if (pe8Var == null) {
                                                }
                                                if (pe8Var != null) {
                                                }
                                            }
                                            i12++;
                                        } else if (i14.isValid()) {
                                            i14.g = threadData2.getTid();
                                            i14.position = i12;
                                            af8.v(i14);
                                            linkedList.add(i14);
                                        }
                                    } else if (i14.isValid()) {
                                        i14.g = threadData2.getTid();
                                        i14.position = i12;
                                        af8.v(i14);
                                        linkedList.add(i14);
                                    }
                                }
                                z3 = false;
                                e2 = af8.e(threadData2);
                                if (e2 != null) {
                                }
                                it2 = it;
                                if (e2 instanceof qm6) {
                                }
                                if (e2 != null) {
                                }
                                if (threadData2.getItem() != null) {
                                }
                                if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                }
                                i5.g = threadData2.getTid();
                                i5.position = i12;
                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) == 1) {
                                }
                                linkedList.add(i5);
                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                if (threadRecommendInfoData != null) {
                                }
                                if (threadData2.showCardEnterFourm()) {
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                i6 = af8.i(threadData2);
                                if (i6 != null) {
                                }
                                if (i6 != null) {
                                }
                                h = af8.h(threadData2, z);
                                if (h != null) {
                                }
                                g = af8.g(threadData2);
                                if (g != null) {
                                }
                                j2 = 0;
                                j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                if (j3 != 0) {
                                }
                                i12++;
                            }
                            it2 = it;
                            j2 = 0;
                            j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                            if (j3 != 0) {
                            }
                            i12++;
                        } else {
                            it2 = it;
                            j2 = j4;
                            if (next instanceof BaseCardInfo) {
                                linkedList.add(next);
                            } else {
                                linkedList.add(next);
                            }
                            i12++;
                        }
                        j4 = j2;
                        it = it2;
                        i11 = 1;
                        c = 0;
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i16 = 0;
                        int i17 = 0;
                        for (int i18 = 0; i18 < ListUtils.getCount(list2); i18++) {
                            vm6 vm6Var = (vm6) ListUtils.getItem(list2, i18);
                            if (vm6Var != null && i16 < linkedList.size()) {
                                int i19 = i16;
                                while (i19 < linkedList.size() && (!(linkedList.get(i19) instanceof gm6) || h(((gm6) linkedList.get(i19)).position, i4) + i17 != vm6Var.getPosition() - 1)) {
                                    i19++;
                                }
                                if (linkedList.size() > i19 && i19 > 0) {
                                    linkedList.add(i19, vm6Var);
                                    int i20 = i17 + 1;
                                    m(vm6Var, linkedList, i19, i20, i3);
                                    i16 = i19;
                                    i17 = i20;
                                } else {
                                    i16 = i19;
                                }
                            }
                        }
                        int i21 = 0;
                        int i22 = 0;
                        for (oi oiVar : linkedList) {
                            if (oiVar instanceof tx4) {
                                ((tx4) oiVar).setPosition(i21 + 1);
                                i22++;
                            } else if (oiVar instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) oiVar;
                                i21 = baseCardInfo.position + i22;
                                baseCardInfo.position = i21;
                            }
                        }
                    }
                    if (i2 == 0 && i == 1) {
                        c2 = c();
                        if (!ListUtils.isEmpty(c2)) {
                            for (RecommendBarCardModel recommendBarCardModel2 : c2) {
                                String f2 = recommendBarCardModel2.f();
                                if (!TextUtils.isEmpty(f2) && (j = j(k(f2, linkedList), linkedList, f2)) >= 0 && j <= linkedList.size()) {
                                    linkedList.add(j, recommendBarCardModel2);
                                    a(linkedList);
                                }
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                            DefaultLog.getInstance().i("RecentForumLog", "首页接口插入直播入口");
                            me8 me8Var = new me8();
                            me8Var.d(userFollowLive);
                            linkedList.add(0, me8Var);
                            me8Var.position = -1;
                        } else if (i == 1 && (b2 = b()) != null) {
                            linkedList.add(0, b2);
                            b2.position = -1;
                        } else {
                            z2 = false;
                            if (z2) {
                                DefaultLog.getInstance().i("RecentForumLog", "首页接口返回，设置有直播数据标志位");
                                this.l.a1(true);
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                    } else {
                        z2 = false;
                    }
                    if (i2 == 0 && !z2) {
                        if (i != 0 && this.l.l0() > 0) {
                            DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 且没有插入直播数据");
                            if (this.l.g0() != null) {
                                DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 插入最近逛的吧模快");
                                linkedList.add(0, this.l.g0());
                            }
                        } else {
                            e = e(this.a.a);
                            if (e != -1) {
                                linkedList.add(0, (oe8) this.a.a.get(e));
                            }
                        }
                    }
                    if (i2 == 0 && i == 0) {
                        wc8 wc8Var = this.l;
                        wc8Var.e1(wc8Var.l0() + 1);
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i("RecentForumLog", "推荐接口返回, 等待值：" + this.l.l0());
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    return linkedList;
                }
            }
            i4 = -1;
            if (i2 == 0) {
                j98Var = new j98();
                j98Var.i(builder.hot_card);
                d = j98Var.d() - 1;
                if (d >= 0) {
                    j98Var.position = d;
                }
            }
            if (builder != null) {
                recommendBarCardModel = new RecommendBarCardModel();
                if (builder.hot_recomforum.floor.intValue() <= 0) {
                }
                recommendBarCardModel.floorPosition = i10;
                if (recommendBarCardModel.n(builder.hot_recomforum.tab_list)) {
                }
            }
            if (i2 == 0) {
                int f3 = s75.f();
                e3 = s75.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e3++;
                }
                q(e3, f3, arrayList);
            }
            List<oi> linkedList2 = new LinkedList<>();
            it = arrayList.iterator();
            int i122 = 0;
            while (it.hasNext()) {
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
            }
            if (i2 == 0) {
                c2 = c();
                if (!ListUtils.isEmpty(c2)) {
                }
            }
            if (i2 != 0) {
            }
            if (i2 == 0) {
                if (i != 0) {
                }
                e = e(this.a.a);
                if (e != -1) {
                }
            }
            if (i2 == 0) {
                wc8 wc8Var2 = this.l;
                wc8Var2.e1(wc8Var2.l0() + 1);
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("RecentForumLog", "推荐接口返回, 等待值：" + this.l.l0());
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList2);
            return linkedList2;
        }
        return (List) invokeCommon.objValue;
    }

    public void p(bw4 bw4Var, int i, List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048600, this, bw4Var, i, list) != null) || bw4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    bw4Var.floorPosition = i;
                    ListUtils.add(list, i3, bw4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void q(int i, int i2, List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048601, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<oi> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        tra traVar = new tra();
                        traVar.n(true);
                        threadData.funAdData = traVar;
                        listIterator.add(threadData);
                        this.k.add(threadData);
                    }
                    i5++;
                    if (i3 == 0) {
                        i3 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i3 > 0 && v26.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                v26.i().n(list, i3, 1);
            }
        }
    }

    public void u(List<oi> list, eia eiaVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048605, this, list, eiaVar, i) != null) || ListUtils.isEmpty(list) || eiaVar == null || i < 0) {
            return;
        }
        F(list);
        if (i == 0) {
            t(list, RecommendBarCardModel.e(eiaVar), eiaVar.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof gm6) && !(list.get(i) instanceof tx4)) {
            i++;
        }
        if (list.get(i) instanceof gm6) {
            t(list, RecommendBarCardModel.e(eiaVar), ((gm6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof tx4) {
            t(list, RecommendBarCardModel.e(eiaVar), ((tx4) list.get(i)).m() + 2);
        }
    }

    public boolean r(List<oi> list, ne8 ne8Var, int i, int i2) {
        InterceptResult invokeLLII;
        RecommendBarCardModel d;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048602, this, list, ne8Var, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || ne8Var == null || TextUtils.isEmpty(ne8Var.b()) || i < 0 || i >= list.size() || i2 < 0 || i2 < i || i2 >= list.size() || (d = RecommendBarCardModel.d(ne8Var)) == null || (j = j(k(ne8Var.b(), list), list, ne8Var.b())) < 0 || j > list.size() || j <= i) {
                return false;
            }
            d.o(ne8Var.b());
            d.q(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
            list.add(j, d);
            this.a.a.add(j, d);
            a(list);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r5.size() <= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r5.add(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r5.add(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(List<oi> list, RecommendBarCardModel recommendBarCardModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048604, this, list, recommendBarCardModel, i) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.h())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof gm6) || ((gm6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof tx4) || ((tx4) list.get(i3)).m() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (oi oiVar : list) {
                if (oiVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel2 = (RecommendBarCardModel) oiVar;
                    if (!recommendBarCardModel2.i()) {
                        recommendBarCardModel2.position = i4 + 1;
                        i2++;
                    }
                }
                if (oiVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) oiVar;
                    i4 = baseCardInfo.position + i2;
                    baseCardInfo.position = i4;
                }
            }
        }
    }

    public final boolean x(List<oi> list, l98 l98Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, list, l98Var)) == null) {
            if (this.a != null && !ListUtils.isEmpty(list)) {
                for (oi oiVar : list) {
                    if ((oiVar instanceof l98) && ((l98) oiVar).getTid().equals(l98Var.getTid())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void z(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            af8.m(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }
}

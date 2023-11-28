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
import com.baidu.tbadk.abtest.helper.LiveEnterForumTestHelper;
import com.baidu.tbadk.abtest.helper.LiveEnterForumTestHelperKt;
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
public class th8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vh8 a;
    public final int b;
    public int c;
    public ci8 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<pi> k;
    public sf8 l;

    public final int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Comparator<gn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(th8 th8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th8Var};
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
        public int compare(gn6 gn6Var, gn6 gn6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gn6Var, gn6Var2)) == null) {
                if (gn6Var != null && gn6Var2 != null) {
                    if (gn6Var.getPosition() > gn6Var2.getPosition()) {
                        return 1;
                    }
                    if (gn6Var.getPosition() < gn6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends qy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm6 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(th8 th8Var, int i, String str, qm6 qm6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th8Var, Integer.valueOf(i), str, qm6Var};
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
            this.n = qm6Var;
        }

        @Override // com.baidu.tieba.qy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), g(), null)));
                qm6 qm6Var = this.n;
                if (qm6Var instanceof zm6) {
                    statisticItem = ((zm6) qm6Var).N();
                } else if (qm6Var instanceof an6) {
                    statisticItem = ((an6) qm6Var).J(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public th8(sf8 sf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf8Var};
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
        this.d = new ci8();
        this.e = 0;
        this.j = 0L;
        this.a = new vh8();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = SharedPrefHelper.getInstance().getInt("home_page_max_thread_count", 300);
        }
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
        this.l = sf8Var;
    }

    public final void A(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            xh8.m(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void B(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
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
                    hashSet.add(rh8.a(builder, threadInfo));
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
                    hashSet3.add(rh8.a(builder, next));
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
                        qh8 a2 = rh8.a(builder2, threadInfo2);
                        if (!hashSet.contains(a2) && !hashSet3.contains(a2)) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!a2.a() || !z3) {
                            list.add(threadInfo2);
                            JSONObject b2 = fja.b(threadInfo2);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (z()) {
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
                            hashSet3.add(rh8.a(builder, next2));
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
                        qh8 a3 = rh8.a(builder2, threadInfo3);
                        if (!hashSet.contains(a3) && !hashSet3.contains(a3)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!a3.a() || !z2 || threadInfo3.is_highlight.intValue() == 1) {
                            list.add(0, threadInfo3);
                            JSONObject b3 = fja.b(threadInfo3);
                            if (b3 != null) {
                                arrayList.add(0, b3);
                            }
                        }
                    }
                }
            }
            if (z()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            vga.c(builder4, count3);
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
            fja.f().h("HOME", arrayList);
        }
    }

    public final void C(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void D(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
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
            B(z, builder, builder2, i);
            A(z, builder, builder2, i);
            C(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final List<ThreadInfo> E(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, builder, i, i2)) == null) {
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

    public final void F(List<pi> list) {
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && (e = e(list)) != -1) {
            list.remove(e);
        }
    }

    public final boolean H(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, builder)) == null) {
            if (builder == null || (num = builder.show_adsense) == null || num.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(List<gn6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }

    public final int e(List<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof lh8) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int l(List<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof nh8) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void t(@NonNull List<pi> list) {
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, list) == null) && (e = e(this.a.a)) != -1) {
            list.add(0, (lh8) this.a.a.get(e));
        }
    }

    public final void G(List<pi> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<pi> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                pi next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if ((next instanceof RecommendBarCardModel) && !((RecommendBarCardModel) next).k()) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final void a(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            int i = 0;
            int i2 = 0;
            for (pi piVar : list) {
                if (piVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) piVar;
                    if (recommendBarCardModel.k()) {
                        recommendBarCardModel.position = i2 + 1;
                        i++;
                    }
                }
                if (piVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) piVar;
                    i2 = baseCardInfo.position + i;
                    baseCardInfo.position = i2;
                }
            }
        }
    }

    public void J(long j, boolean z) {
        vh8 vh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (vh8Var = this.a) != null && !ListUtils.isEmpty(vh8Var.a)) {
            for (pi piVar : this.a.a) {
                if (piVar instanceof qm6) {
                    qm6 qm6Var = (qm6) piVar;
                    if (qm6Var.n && j == qm6Var.getThreadData().getFid() && z != qm6Var.getThreadData().getForumData().f()) {
                        qm6Var.getThreadData().getForumData().o(z);
                    }
                }
            }
        }
    }

    public boolean w(List<pi> list, gc8 gc8Var) {
        InterceptResult invokeLL;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, list, gc8Var)) == null) {
            if (list != null && this.a.a != null && gc8Var != null && StringUtils.isNotNull(gc8Var.getTid())) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    pi piVar = list.get(i2);
                    if (piVar instanceof zm6) {
                        zm6 zm6Var = (zm6) piVar;
                        if (zm6Var.getThreadData() != null && StringUtils.isNotNull(zm6Var.getThreadData().getTid()) && zm6Var.getThreadData().getTid().equals(gc8Var.getTid())) {
                            gc8Var.Y(zm6Var.getThreadData().getClickBackCard());
                            i = i2;
                            break;
                        }
                    }
                    i2++;
                }
                if (y(list, gc8Var) || !gc8.Z(gc8Var) || (j = j(i, list, gc8Var.getTid())) < 0) {
                    return false;
                }
                list.add(j, gc8Var);
                this.a.a.add(j, gc8Var);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final jh8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            vh8 vh8Var = this.a;
            if (vh8Var != null && !ListUtils.isEmpty(vh8Var.a)) {
                for (pi piVar : this.a.a) {
                    if (piVar instanceof jh8) {
                        return (jh8) piVar;
                    }
                }
            }
            return null;
        }
        return (jh8) invokeV.objValue;
    }

    public final mh8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            vh8 vh8Var = this.a;
            if (vh8Var != null && !ListUtils.isEmpty(vh8Var.a)) {
                for (pi piVar : this.a.a) {
                    if (piVar instanceof mh8) {
                        return (mh8) piVar;
                    }
                }
            }
            return null;
        }
        return (mh8) invokeV.objValue;
    }

    @Nullable
    public final List<RecommendBarCardModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            vh8 vh8Var = this.a;
            if (vh8Var != null && !ListUtils.isEmpty(vh8Var.a)) {
                ArrayList arrayList = new ArrayList();
                for (pi piVar : this.a.a) {
                    if (piVar instanceof RecommendBarCardModel) {
                        RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) piVar;
                        if (recommendBarCardModel.k()) {
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

    public vh8 f(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
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
            xh8.c(builder3);
            xh8.c(builder4);
            D(z, builder3, builder4, i);
            List<ThreadInfo> E = E(builder3, i, this.b);
            xh8.p(builder3);
            List<AdvertAppInfo> g = rha.m().g();
            int i3 = 0;
            if (i != 0 && z && g != null) {
                i2 = g.size();
            } else {
                i2 = 0;
            }
            List<gn6> d = xh8.d(builder3);
            I(d);
            int i4 = i2;
            List<pi> o = o(builder3.thread_list, d, builder4.user_follow_live, i, 0, builder4, i4, z);
            List<pi> o2 = o(E, new ArrayList(), builder4.user_follow_live, i, 1, null, i4, z);
            this.d.a(o);
            uh8.c(builder3, o);
            vh8 vh8Var = this.a;
            vh8Var.a = o;
            if (o2 != null) {
                i3 = o2.size();
            }
            vh8Var.c = i3;
            return this.a;
        }
        return (vh8) invokeCommon.objValue;
    }

    public List<ThreadInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int j(int i, @NonNull List<pi> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048595, this, i, list, str)) == null) {
            return ii8.a(i, list, str);
        }
        return invokeILL.intValue;
    }

    public final int k(@NonNull String str, @NonNull List<pi> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                pi piVar = list.get(i);
                if (piVar instanceof qm6) {
                    qm6 qm6Var = (qm6) piVar;
                    if (qm6Var.getThreadData() != null && !TextUtils.isEmpty(qm6Var.getThreadData().getTid()) && str.equals(qm6Var.getThreadData().getTid())) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public boolean n(List<pi> list, UserFollowLive userFollowLive) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, list, userFollowLive)) == null) {
            if (b() != null || list == null || this.a.a == null || userFollowLive == null || userFollowLive._switch.intValue() != 1 || ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                return false;
            }
            DefaultLog.getInstance().i("RecentForumLog", "直播入口插入，删除最近逛的吧模快");
            F(list);
            F(this.a.a);
            jh8 jh8Var = new jh8();
            jh8Var.d(userFollowLive);
            list.add(0, jh8Var);
            this.a.a.add(0, jh8Var);
            jh8Var.position = -1;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void m(gn6 gn6Var, List<pi> list, int i, int i2, int i3) {
        g36 g36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{gn6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = c36.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof g36) {
                g36Var = (g36) g;
            } else {
                g36Var = null;
            }
            if (gn6Var instanceof eh8) {
                str = ((eh8) gn6Var).a.a;
            }
            if (g36Var != null && !ListUtils.isEmpty(g36Var.d()) && g36Var.d().contains(str)) {
                c36.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && c36.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                c36.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && g36Var != null && g36Var.d() != null) {
                    g36Var.d().add(str);
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
    /* JADX WARN: Removed duplicated region for block: B:226:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<pi> o(List<ThreadInfo> list, List<gn6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3, boolean z) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        Iterator<pi> it;
        boolean z2;
        boolean z3;
        jh8 b2;
        List<RecommendBarCardModel> c2;
        int j;
        Iterator<pi> it2;
        long j2;
        long j3;
        mh8 mh8Var;
        boolean z4;
        qm6 e;
        zm6 i5;
        ThreadRecommendInfoData threadRecommendInfoData;
        zm6 i6;
        en6 h;
        gc8 g;
        zm6 i7;
        zm6 i8;
        zm6 i9;
        int e2;
        RecommendBarCardModel recommendBarCardModel;
        int i10;
        ec8 ec8Var;
        int d;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (list == null) {
                return null;
            }
            long j4 = 0;
            int i11 = 1;
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && ap4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<pi> arrayList = new ArrayList<>(ListUtils.getCount(list));
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
            lbb lbbVar = new lbb();
            if (builder != null && (headerCard = builder.header_card) != null) {
                lbbVar.g(headerCard);
            }
            if (i2 == 0 && rbb.p(lbbVar, false)) {
                rbb rbbVar = new rbb();
                rbbVar.n(1);
                rbbVar.h(lbbVar);
                if (ListUtils.add(arrayList, rbbVar.getPosition(), rbbVar)) {
                    int position = rbbVar.getPosition();
                    rbbVar.position = position;
                    i4 = position;
                    if (i2 == 0 && ec8.l(builder)) {
                        ec8Var = new ec8();
                        ec8Var.k(builder.hot_card);
                        d = ec8Var.d() - 1;
                        if (d >= 0 && ListUtils.add(arrayList, d, ec8Var)) {
                            ec8Var.position = d;
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
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && H(builder)) {
                        int f = y75.f();
                        e2 = y75.e();
                        if (i == 0) {
                            e2 = y75.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e2 > i4) {
                            e2++;
                        }
                        q(e2, f, arrayList);
                    }
                    List<pi> linkedList = new LinkedList<>();
                    it = arrayList.iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        pi next = it.next();
                        boolean z5 = next instanceof ThreadData;
                        if (z5 && ((ThreadData) next).isFunAdPlaceHolder()) {
                            if (H(builder)) {
                                linkedList.add(next);
                                i12++;
                            }
                            it2 = it;
                            j2 = j4;
                        } else if (z5) {
                            ThreadData threadData2 = (ThreadData) next;
                            int i13 = i12 + 1;
                            threadData2.floorPosition = i13;
                            threadData2.isFromNet = z;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                wx4 wx4Var = new wx4();
                                wx4Var.e(threadData2.getLegoCard());
                                wx4Var.position = i12;
                                linkedList.add(wx4Var);
                            } else if (kk8.G(threadData2)) {
                                if (StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    j4 = 0;
                                } else {
                                    kk8 kk8Var = new kk8();
                                    kk8Var.I(threadData2.getTopicModule());
                                    kk8Var.Z = i11;
                                    kk8Var.position = i12;
                                    kk8Var.J(threadData2);
                                    kk8Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(kk8Var);
                                }
                            } else if (!zm6.R(threadData2) && !an6.L(threadData2) && !bn6.R(threadData2)) {
                                if (tm6.R(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    tm6 tm6Var = new tm6(threadData2);
                                    tm6Var.position = i12;
                                    linkedList.add(tm6Var);
                                } else {
                                    qm6 e3 = xh8.e(threadData2);
                                    if (e3 != null) {
                                        e3.g = threadData2.getTid();
                                        e3.position = i12;
                                    }
                                    if (e3 != null && e3.isValid()) {
                                        linkedList.add(e3);
                                    }
                                }
                            } else {
                                zm6 i14 = xh8.i(threadData2);
                                if (i14 != null) {
                                    if (!threadData2.showCardEnterFourm() && !"user".equals(threadData2.getHeadType())) {
                                        ThreadData threadData3 = i14.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            i14.g = threadData2.getTid();
                                            i14.position = i12;
                                            xh8.t(i14);
                                            linkedList.add(i14);
                                            z4 = true;
                                            e = xh8.e(threadData2);
                                            if (e != null) {
                                                e.g = threadData2.getTid();
                                                e.position = i12;
                                                if (e instanceof zm6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        xh8.w(e);
                                                    } else if (threadData2.picCount() == i11) {
                                                        xh8.y(e);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        it2 = it;
                                                        e.j = imageWidthAndHeight[c];
                                                        e.k = imageWidthAndHeight[i11];
                                                    } else {
                                                        it2 = it;
                                                        if (threadData2.picCount() >= 2) {
                                                            xh8.x(e);
                                                        } else {
                                                            xh8.z(e);
                                                        }
                                                    }
                                                } else {
                                                    it2 = it;
                                                    if (e instanceof an6) {
                                                        xh8.A(e);
                                                    }
                                                }
                                                if (e instanceof bn6) {
                                                    xh8.B(e);
                                                }
                                                if (e != null && e.isValid()) {
                                                    e.a.insertItemToTitleOrAbstractText();
                                                    if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z4) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                        Object[] objArr = new Object[i11];
                                                        objArr[c] = threadData2.getAuthor().getName_show();
                                                        String format = String.format(string, objArr);
                                                        SpannableString spannableString = new SpannableString(format);
                                                        spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format.length() - 1, 33);
                                                        e.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                                    }
                                                    linkedList.add(e);
                                                }
                                                if (threadData2.getItem() != null && (i9 = xh8.i(threadData2)) != null) {
                                                    i9.g = threadData2.getTid();
                                                    i9.position = i12;
                                                    xh8.C(i9);
                                                    if (!zm6.R(threadData2)) {
                                                        i9.E("1");
                                                    } else if (an6.L(threadData2)) {
                                                        i9.E("2");
                                                    }
                                                    linkedList.add(i9);
                                                }
                                                if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (i5 = xh8.i(threadData2)) != null) {
                                                    i5.g = threadData2.getTid();
                                                    i5.position = i12;
                                                    if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) == 1) {
                                                        xh8.F(i5);
                                                    } else {
                                                        xh8.D(i5);
                                                    }
                                                    linkedList.add(i5);
                                                }
                                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                                if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (i8 = xh8.i(threadData2)) != null) {
                                                    i8.g = threadData2.getTid();
                                                    i8.position = i12;
                                                    xh8.E(i8);
                                                    if (i8.isValid()) {
                                                        linkedList.add(i8);
                                                    }
                                                }
                                                if (threadData2.showCardEnterFourm() && (i7 = xh8.i(threadData2)) != null) {
                                                    i7.g = threadData2.getTid();
                                                    i7.position = i12;
                                                    xh8.s(i7);
                                                    if (!zm6.R(threadData2)) {
                                                        i7.E("1");
                                                    } else if (an6.L(threadData2)) {
                                                        i7.E("2");
                                                    }
                                                    if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                        linkedList.add(i7);
                                                    } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                        linkedList.add(i7);
                                                    }
                                                }
                                                if (threadData2.getTopAgreePost() != null) {
                                                    zm6 i15 = xh8.i(threadData2);
                                                    if (i15 != null) {
                                                        i15.g = threadData2.getTid();
                                                        i15.position = i12;
                                                        xh8.u(i15);
                                                    }
                                                    if (i15 != null && i15.isValid()) {
                                                        linkedList.add(i15);
                                                    }
                                                }
                                                i6 = xh8.i(threadData2);
                                                if (i6 != null) {
                                                    i6.g = threadData2.getTid();
                                                    i6.position = i12;
                                                    xh8.r(i6);
                                                }
                                                if (i6 != null && i6.isValid() && ThreadCardUtils.isBottomShowOp(i6.a)) {
                                                    if (ThreadCardUtils.needBottomEmptyOp(threadData2)) {
                                                        linkedList.add(i6);
                                                    } else {
                                                        linkedList.add(new vm6());
                                                    }
                                                }
                                                h = xh8.h(threadData2, z);
                                                if (h != null) {
                                                    h.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                                                    h.position = i13;
                                                    h.setTid(threadData2.tid);
                                                    linkedList.add(h);
                                                }
                                                g = xh8.g(threadData2);
                                                if (g != null && gc8.X(g) && y(this.a.a, g) && !y(linkedList, g)) {
                                                    g.g = threadData2.getTid();
                                                    linkedList.add(g);
                                                }
                                                j2 = 0;
                                                j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                                if (j3 != 0 && j3 == this.j.longValue()) {
                                                    if (builder.active_center == null) {
                                                        mh8Var = new mh8();
                                                        mh8Var.G(builder.active_center);
                                                    } else {
                                                        mh8Var = null;
                                                    }
                                                    if (mh8Var == null) {
                                                        mh8Var = d();
                                                    }
                                                    if (mh8Var != null) {
                                                        mh8Var.R = i13;
                                                        linkedList.add(mh8Var);
                                                        i12 = i13;
                                                    }
                                                }
                                                i12++;
                                            }
                                            it2 = it;
                                            if (e instanceof bn6) {
                                            }
                                            if (e != null) {
                                                e.a.insertItemToTitleOrAbstractText();
                                                if (!threadData2.isUgcThreadType()) {
                                                    String string2 = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                    Object[] objArr2 = new Object[i11];
                                                    objArr2[c] = threadData2.getAuthor().getName_show();
                                                    String format2 = String.format(string2, objArr2);
                                                    SpannableString spannableString2 = new SpannableString(format2);
                                                    spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format2.length() - 1, 33);
                                                    e.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                                                }
                                                linkedList.add(e);
                                            }
                                            if (threadData2.getItem() != null) {
                                                i9.g = threadData2.getTid();
                                                i9.position = i12;
                                                xh8.C(i9);
                                                if (!zm6.R(threadData2)) {
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
                                                xh8.E(i8);
                                                if (i8.isValid()) {
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm()) {
                                                i7.g = threadData2.getTid();
                                                i7.position = i12;
                                                xh8.s(i7);
                                                if (!zm6.R(threadData2)) {
                                                }
                                                if (!threadData2.showCardEnterFourm()) {
                                                }
                                                if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                            }
                                            i6 = xh8.i(threadData2);
                                            if (i6 != null) {
                                            }
                                            if (i6 != null) {
                                                if (ThreadCardUtils.needBottomEmptyOp(threadData2)) {
                                                }
                                            }
                                            h = xh8.h(threadData2, z);
                                            if (h != null) {
                                            }
                                            g = xh8.g(threadData2);
                                            if (g != null) {
                                                g.g = threadData2.getTid();
                                                linkedList.add(g);
                                            }
                                            j2 = 0;
                                            j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                            if (j3 != 0) {
                                                if (builder.active_center == null) {
                                                }
                                                if (mh8Var == null) {
                                                }
                                                if (mh8Var != null) {
                                                }
                                            }
                                            i12++;
                                        } else if (i14.isValid()) {
                                            i14.g = threadData2.getTid();
                                            i14.position = i12;
                                            xh8.v(i14);
                                            linkedList.add(i14);
                                        }
                                    } else if (i14.isValid()) {
                                        i14.g = threadData2.getTid();
                                        i14.position = i12;
                                        xh8.v(i14);
                                        linkedList.add(i14);
                                    }
                                }
                                z4 = false;
                                e = xh8.e(threadData2);
                                if (e != null) {
                                }
                                it2 = it;
                                if (e instanceof bn6) {
                                }
                                if (e != null) {
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
                                i6 = xh8.i(threadData2);
                                if (i6 != null) {
                                }
                                if (i6 != null) {
                                }
                                h = xh8.h(threadData2, z);
                                if (h != null) {
                                }
                                g = xh8.g(threadData2);
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
                            gn6 gn6Var = (gn6) ListUtils.getItem(list2, i18);
                            if (gn6Var != null && i16 < linkedList.size()) {
                                int i19 = i16;
                                while (i19 < linkedList.size() && (!(linkedList.get(i19) instanceof qm6) || h(((qm6) linkedList.get(i19)).position, i4) + i17 != gn6Var.getPosition() - 1)) {
                                    i19++;
                                }
                                if (linkedList.size() > i19 && i19 > 0) {
                                    linkedList.add(i19, gn6Var);
                                    int i20 = i17 + 1;
                                    m(gn6Var, linkedList, i19, i20, i3);
                                    i16 = i19;
                                    i17 = i20;
                                } else {
                                    i16 = i19;
                                }
                            }
                        }
                        int i21 = 0;
                        int i22 = 0;
                        for (pi piVar : linkedList) {
                            if (piVar instanceof vx4) {
                                ((vx4) piVar).setPosition(i21 + 1);
                                i22++;
                            } else if (piVar instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) piVar;
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
                    if (LiveEnterForumTestHelper.forbidInsertLiveModel() && i2 == 0) {
                        if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                            DefaultLog.getInstance().i("RecentForumLog", "首页接口插入直播入口");
                            jh8 jh8Var = new jh8();
                            jh8Var.d(userFollowLive);
                            linkedList.add(0, jh8Var);
                            jh8Var.position = -1;
                        } else if (i == 1 && (b2 = b()) != null) {
                            linkedList.add(0, b2);
                            b2.position = -1;
                        } else {
                            z3 = false;
                            if (z3) {
                                DefaultLog.getInstance().i("RecentForumLog", "首页接口返回，设置有直播数据标志位");
                                this.l.a1(true);
                            }
                            z2 = z3;
                        }
                        z3 = true;
                        if (z3) {
                        }
                        z2 = z3;
                    } else {
                        z2 = false;
                    }
                    if (LiveEnterForumTestHelper.isLiveEnterForumTestA() && i2 == 0) {
                        if (i != 0) {
                            pi b3 = nqa.c().b();
                            if (b3 != null) {
                                DefaultLog.getInstance().i(LiveEnterForumTestHelperKt.LIVE_ENTER_FORUM_TEST_LOG_TAGE, "命中实验A后首页接口一同渲染进吧数据");
                                linkedList.add(0, b3);
                            }
                        } else {
                            t(linkedList);
                        }
                    }
                    if (LiveEnterForumTestHelper.isLiveEnterForumTestB()) {
                        if (i2 == 0 && !z2) {
                            if (i == 0 && this.l.l0() > 0) {
                                DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 且没有插入直播数据");
                                if (this.l.g0() != null) {
                                    DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 插入最近逛的吧模快");
                                    linkedList.add(0, this.l.g0());
                                }
                            } else {
                                t(linkedList);
                            }
                        }
                        if (i2 == 0 && i == 0) {
                            sf8 sf8Var = this.l;
                            sf8Var.e1(sf8Var.l0() + 1);
                            TbLog defaultLog = DefaultLog.getInstance();
                            defaultLog.i("RecentForumLog", "推荐接口返回, 等待值：" + this.l.l0());
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    return linkedList;
                }
            }
            i4 = -1;
            if (i2 == 0) {
                ec8Var = new ec8();
                ec8Var.k(builder.hot_card);
                d = ec8Var.d() - 1;
                if (d >= 0) {
                    ec8Var.position = d;
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
                int f3 = y75.f();
                e2 = y75.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e2++;
                }
                q(e2, f3, arrayList);
            }
            List<pi> linkedList2 = new LinkedList<>();
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
            if (LiveEnterForumTestHelper.forbidInsertLiveModel()) {
            }
            z2 = false;
            if (LiveEnterForumTestHelper.isLiveEnterForumTestA()) {
                if (i != 0) {
                }
            }
            if (LiveEnterForumTestHelper.isLiveEnterForumTestB()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList2);
            return linkedList2;
        }
        return (List) invokeCommon.objValue;
    }

    public void p(cw4 cw4Var, int i, List<pi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048601, this, cw4Var, i, list) != null) || cw4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    cw4Var.floorPosition = i;
                    ListUtils.add(list, i3, cw4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void q(int i, int i2, List<pi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048602, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<pi> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        lwa lwaVar = new lwa();
                        lwaVar.n(true);
                        threadData.funAdData = lwaVar;
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
            if (i3 > 0 && c36.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                c36.i().n(list, i3, 1);
            }
        }
    }

    public boolean s(List<pi> list, lh8 lh8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048604, this, list, lh8Var, z)) == null) {
            if (a2b.b().a() || LiveEnterForumTestHelper.isLiveEnterForumTestA()) {
                if (e(this.a.a) == -1) {
                    DefaultLog.getInstance().i(LiveEnterForumTestHelperKt.LIVE_ENTER_FORUM_TEST_LOG_TAGE, "命中新框架、对照组、实验组A且无");
                    return false;
                }
                nqa.c().h(false);
            }
            if (this.l.e0) {
                return false;
            }
            if (z) {
                DefaultLog.getInstance().i("RecentForumLog", "插入最进逛的吧，有直播数据，不插入");
                return false;
            } else if (list == null || this.a.a == null) {
                return false;
            } else {
                F(list);
                F(this.a.a);
                int l = l(list);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("RecentForumLog", "插入最进逛的吧，Banner位置为：" + l);
                list.add(l + 1, lh8Var);
                this.a.a.add(0, lh8Var);
                lh8Var.position = -1;
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public void v(List<pi> list, xma xmaVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048607, this, list, xmaVar, i) != null) || ListUtils.isEmpty(list) || xmaVar == null || i < 0) {
            return;
        }
        G(list);
        if (i == 0) {
            u(list, RecommendBarCardModel.e(xmaVar), xmaVar.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof qm6) && !(list.get(i) instanceof vx4)) {
            i++;
        }
        if (list.get(i) instanceof qm6) {
            u(list, RecommendBarCardModel.e(xmaVar), ((qm6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof vx4) {
            u(list, RecommendBarCardModel.e(xmaVar), ((vx4) list.get(i)).m() + 2);
        }
    }

    public boolean r(List<pi> list, kh8 kh8Var, int i, int i2) {
        InterceptResult invokeLLII;
        RecommendBarCardModel d;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048603, this, list, kh8Var, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || kh8Var == null || TextUtils.isEmpty(kh8Var.b()) || i < 0 || i >= list.size() || i2 < 0 || i2 < i || i2 >= list.size() || (d = RecommendBarCardModel.d(kh8Var)) == null || (j = j(k(kh8Var.b(), list), list, kh8Var.b())) < 0 || j > list.size() || j <= i) {
                return false;
            }
            d.o(kh8Var.b());
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
    public final void u(List<pi> list, RecommendBarCardModel recommendBarCardModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048606, this, list, recommendBarCardModel, i) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.h())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof qm6) || ((qm6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof vx4) || ((vx4) list.get(i3)).m() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (pi piVar : list) {
                if (piVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel2 = (RecommendBarCardModel) piVar;
                    if (!recommendBarCardModel2.k()) {
                        recommendBarCardModel2.position = i4 + 1;
                        i2++;
                    }
                }
                if (piVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) piVar;
                    i4 = baseCardInfo.position + i2;
                    baseCardInfo.position = i4;
                }
            }
        }
    }

    public final boolean y(List<pi> list, gc8 gc8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, list, gc8Var)) == null) {
            if (this.a != null && !ListUtils.isEmpty(list)) {
                for (pi piVar : list) {
                    if ((piVar instanceof gc8) && ((gc8) piVar).getTid().equals(gc8Var.getTid())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

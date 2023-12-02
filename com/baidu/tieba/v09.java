package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.FunImageView;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.p88;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class v09 implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final boolean c;
    public final TbPageContext<?> d;
    public final ArrayList<String> e;
    public final Map<String, u09> f;
    public int g;
    public final boolean h;
    public final int i;
    public final int j;
    public final int k;
    public int l;
    public long m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public final String r;
    public final HashSet<String> s;
    public FunImageView t;
    public View u;
    public LinearLayout v;
    public TextView w;
    public TBLottieAnimationView x;
    public int y;
    public final Runnable z;

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewGroup, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v09 a;

        public a(v09 v09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v09Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.u != null && this.a.x != null && this.a.u.getVisibility() == 0) {
                this.a.x.cancelAnimation();
                this.a.u.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v09 a;

        public b(v09 v09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v09Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.x.resumeAnimation();
                this.a.x.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.z.run();
                this.a.u.removeCallbacks(this.a.z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ v09 b;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
            }
        }

        public c(v09 v09Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v09Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v09Var;
            this.a = i;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
                this.b.y = this.a;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements p88.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<p88.g> a;
        public final WeakReference<v09> b;

        public d(p88.g gVar, v09 v09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, v09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(gVar);
            this.b = new WeakReference<>(v09Var);
        }

        @Override // com.baidu.tieba.p88.g
        public void a(String str, int i) {
            p88.g gVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) || (gVar = this.a.get()) == null) {
                return;
            }
            gVar.a(str, i);
            v09 v09Var = this.b.get();
            if (v09Var == null) {
                return;
            }
            if (p88.m().v(str)) {
                v09Var.n(0);
            } else {
                v09Var.n(1);
            }
        }

        @Override // com.baidu.tieba.p88.g
        public void onError(String str) {
            p88.g gVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || (gVar = this.a.get()) == null) {
                return;
            }
            gVar.onError(str);
            v09 v09Var = this.b.get();
            if (v09Var == null) {
                return;
            }
            v09Var.n(1);
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements p88.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final WeakReference<v09> b;

        @Override // com.baidu.tieba.p88.h
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.p88.h
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public e(int i, v09 v09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), v09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = new WeakReference<>(v09Var);
        }

        @Override // com.baidu.tieba.p88.h
        public void onAdClicked(String str, String str2, String str3) {
            v09 v09Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) != null) || (v09Var = this.b.get()) == null) {
                return;
            }
            v09Var.k(str2, str3, this.a);
        }

        @Override // com.baidu.tieba.p88.h
        public void onAdShow(String str, String str2, String str3) {
            v09 v09Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(1048580, this, str, str2, str3) != null) || (v09Var = this.b.get()) == null) {
                return;
            }
            v09Var.y = this.a;
            v09Var.o(0, this.a, str2, str3);
        }

        @Override // com.baidu.tieba.p88.h
        public void onAdError(String str) {
            v09 v09Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (v09Var = this.b.get()) != null) {
                v09Var.y = -1;
                v09Var.l();
                v09Var.o(1, this.a, null, null);
            }
        }
    }

    public v09(@NonNull ArrayList<String> arrayList, String str, String str2, boolean z, int i, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, str2, Boolean.valueOf(z), Integer.valueOf(i), tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = -1;
        this.s = new HashSet<>();
        this.y = -2;
        this.z = new a(this);
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = tbPageContext;
        this.e = arrayList;
        this.f = new HashMap();
        this.i = b85.c() - 1;
        this.j = b85.b() + 1;
        this.k = b85.d() + 1;
        this.h = SharedPrefHelper.getInstance().getInt("fun_ad_big_image_switch", -1) == 1;
        String str3 = (String) ListUtils.getItem(arrayList, i);
        this.r = StringUtils.isNull(str3) ? (String) ListUtils.getItem(arrayList, 0) : str3;
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.o = z;
        }
    }

    public final void m(@NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            String b2 = r88.b(list.size());
            this.s.add(b2);
            ListUtils.add(list, b2);
            this.n = true;
        }
    }

    public boolean t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            return r88.d((String) ListUtils.getItem(this.e, i));
        }
        return invokeI.booleanValue;
    }

    public boolean v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (i >= this.m) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            int p = p();
            int i2 = this.i;
            while (true) {
                p += i2;
                if (p < ListUtils.getCount(this.e)) {
                    if (i == p) {
                        return true;
                    }
                    i2 = this.j;
                } else {
                    return false;
                }
            }
        } else {
            return invokeI.booleanValue;
        }
    }

    public void C(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.m = j;
            this.l = i;
        }
    }

    public boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.q >= i) {
                this.q = i;
                return false;
            }
            this.q = i;
            for (int i2 = i + 1; i2 <= this.j + i; i2++) {
                String str = (String) ListUtils.getItem(this.e, i2);
                if (r88.d(str)) {
                    if (i2 < this.g + p()) {
                        this.g--;
                    }
                    ArrayList<String> arrayList = this.e;
                    if (arrayList != null) {
                        arrayList.remove(str);
                    }
                    o(2, i2, null, null);
                    if (this.n) {
                        this.n = false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void E(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.t.removeView(this.v);
            this.t.setFunAdViewVisible(0);
            this.t.getFunAdView().setOnHierarchyChangeListener(new c(this, i));
            p88 m = p88.m();
            Activity pageActivity = this.d.getPageActivity();
            String r = p88.r();
            ViewGroup funAdView = this.t.getFunAdView();
            e eVar = new e(i, this);
            if (UbsABTestHelper.isPicPageFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            m.D(pageActivity, r, funAdView, eVar, p88.b("pic", str));
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i);
            if (i == 1) {
                param.param("resource_id", 0);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i), this.b, this.a, "0");
            } else {
                param.param("resource_id", 1);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i), this.b, this.a, null);
            }
            TiebaStatic.log(param);
        }
    }

    public void B(p88.g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            FunAdRecordHttpMessage.uploadRequestRecord("a008", "2", this.b, this.a, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.b).param("fid", this.a).param("obj_locate", 2).param("obj_type", "a008").eventStat();
            p88 m = p88.m();
            Activity pageActivity = this.d.getPageActivity();
            String r = p88.r();
            d dVar = new d(gVar, this);
            if (UbsABTestHelper.isPicPageFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            m.w(pageActivity, r, -1, dVar, p88.b("pic", str));
        }
    }

    public final View r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            TbPageContext<?> tbPageContext = this.d;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || this.s.contains(str)) {
                return null;
            }
            View view2 = this.u;
            if (view2 != null) {
                return view2;
            }
            View inflate = LayoutInflater.from(this.d.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0459, (ViewGroup) null);
            this.u = inflate;
            EMManager.from(inflate.findViewById(R.id.obfuscated_res_0x7f090117)).setGradientColor(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.u.findViewById(R.id.obfuscated_res_0x7f090100);
            this.x = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.ad_left_slide_guide_lottie);
            this.x.setRepeatCount(3);
            this.u.addOnAttachStateChangeListener(new b(this));
            return this.u;
        }
        return (View) invokeL.objValue;
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            String str = (String) ListUtils.getItem(this.e, i);
            if (!r88.d(str)) {
                this.z.run();
                return;
            }
            LinearLayout linearLayout = this.v;
            if (linearLayout != null && linearLayout.getParent() != null) {
                E(i);
            }
            if (!this.s.contains(str) && i < ListUtils.getCount(this.e) - 1) {
                View r = r(str);
                if (r != null) {
                    ViewParent parent = r.getParent();
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(r);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(15);
                    this.t.addView(r, layoutParams);
                    this.u.setVisibility(0);
                    this.u.postDelayed(this.z, 10000L);
                }
                this.s.add(str);
                return;
            }
            this.z.run();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            if (this.t == null) {
                this.t = new FunImageView(this.d.getPageActivity());
            }
            this.t.b();
            viewGroup.addView(this.t);
            if (!this.c) {
                l();
                return this.t;
            }
            boolean z = true;
            if (i != ListUtils.getCount(this.e) - 1) {
                z = false;
            }
            this.n = z;
            this.t.setCurUrlTagAndIndex((String) ListUtils.getItem(this.e, i), i);
            if (this.t.getFunAdView() != null && p88.m().v(p88.r())) {
                E(i);
                return this.t;
            }
            o(3, i, null, null);
            l();
            return this.t;
        }
        return (View) invokeLI.objValue;
    }

    public final void k(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, str, str2, i) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").param(TiebaStatic.Params.OBJ_TO, str).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, i).eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a008", "0", this.b, this.a, null, null, null, null, null);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View q = q();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.t.addView(q, layoutParams);
            this.t.setFunAdViewVisible(8);
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return Math.max(ListUtils.getPosition(this.e, this.r), 0);
        }
        return invokeV.intValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            p88.m().d(p88.r());
        }
    }

    public final void o(int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
            statisticItem.param("obj_source", 6).param("obj_type", "a008").param("tid", this.b).param("fid", this.a).param("obj_locate", i).param(TiebaStatic.Params.OBJ_PARAM3, i2);
            if (str != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str);
            }
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            TiebaStatic.log(statisticItem);
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i), this.b, this.a, null, null, null, null, null);
        }
    }

    public final View q() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbPageContext<?> tbPageContext = this.d;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                if (this.v == null) {
                    LinearLayout linearLayout = new LinearLayout(this.d.getPageActivity());
                    this.v = linearLayout;
                    linearLayout.setOrientation(1);
                    ImageView imageView = new ImageView(this.d.getPageActivity());
                    imageView.setBackgroundResource(R.drawable.new_pic_emotion_01);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.v.addView(imageView, layoutParams);
                    TextView textView = new TextView(this.d.getPageActivity());
                    this.w = textView;
                    textView.setIncludeFontPadding(false);
                    EMManager.from(this.w).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X01);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.topMargin = BdUtilHelper.getDimens(this.d.getPageActivity(), R.dimen.tbds120);
                    layoutParams2.gravity = 17;
                    this.v.addView(this.w, layoutParams2);
                }
                TextView textView2 = this.w;
                if (textView2 != null) {
                    if (this.n) {
                        i = R.string.obfuscated_res_0x7f0f0aa1;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f0aa0;
                    }
                    textView2.setText(i);
                }
                ViewParent parent = this.v.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.v);
                }
                this.v.setVisibility(0);
                return this.v;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void s(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && this.c && this.e != null) {
            ArrayList arrayList = new ArrayList(this.e);
            if (UbsABTestHelper.isPicPageFunAdSdkTest()) {
                if (this.o && this.l <= ListUtils.getCount(this.e)) {
                    m(arrayList);
                }
            } else if (!UbsABTestHelper.isPicPageFunAdInsert()) {
                return;
            } else {
                if (this.p != z) {
                    this.p = z;
                    this.g = 0;
                    this.s.clear();
                    this.f.clear();
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (r88.d(it.next()) && it.hasNext()) {
                            it.remove();
                        }
                    }
                }
                if (this.p) {
                    if (this.h && !t(arrayList.size() - 1) && this.l <= ListUtils.getCount(this.e)) {
                        m(arrayList);
                    }
                } else {
                    int p = p();
                    if (this.l <= ListUtils.getCount(this.e) && this.i + p >= ListUtils.getCount(this.e)) {
                        m(arrayList);
                    } else {
                        int i2 = this.g;
                        int i3 = p + i2;
                        if (i2 > 0) {
                            i = this.j;
                        } else {
                            i = this.i;
                        }
                        while (true) {
                            i3 += i;
                            if (i3 > arrayList.size() || this.f.size() >= this.k) {
                                break;
                            }
                            if (!r88.d((String) ListUtils.getItem(this.e, i3))) {
                                this.g = i3 - p;
                                String b2 = r88.b(i3);
                                u09 u09Var = new u09(b2);
                                this.f.put(b2, u09Var);
                                ListUtils.add(arrayList, i3, u09Var.a());
                            }
                            i = this.j;
                        }
                        if (this.h && (arrayList.size() - this.g) - p > this.j && !t(arrayList.size() - 1) && this.l <= ListUtils.getCount(this.e)) {
                            m(arrayList);
                        }
                    }
                }
            }
            ListUtils.clear(this.e);
            ArrayList<String> arrayList2 = this.e;
            ListUtils.addAll(arrayList2, ListUtils.getCount(arrayList2), arrayList);
        }
    }

    public boolean w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            int i2 = i;
            while (true) {
                if (i2 < ListUtils.getCount(this.e)) {
                    if (r88.d((String) ListUtils.getItem(this.e, i2))) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (this.y == i2 || i2 == -1 || i < i2 - 3 || i >= i2) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }
}

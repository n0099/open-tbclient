package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class sr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zr6 a;
    public ThreadData b;
    public CustomMessageListener c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public CustomMessageListener h;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sr6 c;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public a(sr6 sr6Var, View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, view2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sr6Var;
            this.a = view2;
            this.b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.c.a != null && this.c.a.j1() != null && this.c.a.j1().e0() != null && this.c.a.j1().Y() != null) {
                this.c.a.j1().e0().removeView(this.a);
                this.c.k(this.b);
                this.c.a.j1().Y().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ View c;
        public final /* synthetic */ sr6 d;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public b(sr6 sr6Var, String str, String str2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, str, str2, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sr6Var;
            this.a = str;
            this.b = str2;
            this.c = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.d.l(this.a, this.b);
            this.c.setVisibility(8);
            if (this.d.a.j1() != null && this.d.a.j1().Y() != null) {
                this.d.a.j1().Y().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ sr6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(sr6 sr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, Integer.valueOf(i)};
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
            this.f = sr6Var;
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.b = jSONObject.optString("tid", "");
                    this.c = jSONObject.optString("fid", "");
                    this.d = jSONObject.optString("liveId", "");
                    this.e = jSONObject.optString("sid", "");
                } else if ((this.a != null && TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.a)) || ((this.d != null && TextUtils.equals(jSONObject.optString("liveId"), this.d)) || (this.e != null && TextUtils.equals(jSONObject.optString("sid"), this.e)))) {
                    try {
                        jSONObject.put("tid", this.b);
                        jSONObject.put("fid", this.c);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.f.w(customResponsedMessage, false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(sr6 sr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, Integer.valueOf(i)};
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
            this.a = sr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.q(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(sr6 sr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, Integer.valueOf(i)};
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
            this.a = sr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.w(customResponsedMessage, true);
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sr6 sr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, Integer.valueOf(i)};
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
            this.a = sr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.k(this.a.x(customResponsedMessage));
            this.a.a.j1().Y().notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public g(sr6 sr6Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, Integer.valueOf(i), view2};
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
            this.b = view2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                int i = this.a;
                this.b.getLayoutParams().height = i - ((int) (i * f));
                this.b.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(sr6 sr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, Integer.valueOf(i)};
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
            this.a = sr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.a != null && this.a.a.J0() != null && this.a.a.J0().g0() != null) {
                String str = (String) customResponsedMessage.getData();
                this.a.n(str, this.a.a.J0().g0().getForum().getBannerListData().getAllAdvertList());
                sr6 sr6Var = this.a;
                sr6Var.m(str, sr6Var.a.j1().e0().getData());
                sr6 sr6Var2 = this.a;
                sr6Var2.m(str, sr6Var2.a.Z0().f().C());
                this.a.a.J0().L(str);
                if (this.a.a.j1() != null && this.a.a.j1().Y() != null) {
                    this.a.a.j1().Y().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(sr6 sr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, Integer.valueOf(i)};
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
            this.a = sr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.o();
            }
        }
    }

    public sr6(zr6 zr6Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zr6Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new c(this, 2921547);
        this.d = new d(this, 2921324);
        this.e = new e(this, 2016488);
        this.f = new f(this, 2016553);
        this.g = new h(this, 2016331);
        this.h = new i(this, 2921746);
        this.a = zr6Var;
        this.e.setTag(bdUniqueId);
        this.g.setTag(bdUniqueId);
        this.h.setTag(bdUniqueId);
        this.d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(this.e);
        MessageManager.getInstance().registerListener(this.g);
        MessageManager.getInstance().registerListener(this.h);
        this.f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f);
        this.c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.c);
    }

    public final String x(CustomResponsedMessage customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, customResponsedMessage)) == null) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                return ((JSONObject) customResponsedMessage.getData()).optString("tid");
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void r(View view2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, animationListener) == null) {
            g gVar = new g(this, view2.getMeasuredHeight(), view2);
            gVar.setAnimationListener(animationListener);
            gVar.setDuration(300L);
            view2.startAnimation(gVar);
        }
    }

    public final void j() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (threadData = this.b) != null && threadData.isHeadLinePost) {
            TbPageTag tbPageTag = null;
            zr6 zr6Var = this.a;
            if (zr6Var != null && zr6Var.j1() != null) {
                tbPageTag = ud5.k(this.a.j1().getContext());
            }
            pt6.l(this.b, tbPageTag);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        ArrayList<wn> threadList = this.a.J0().g0().getThreadList();
        s(str, threadList);
        s(str, this.a.j1().e0().getData());
        s(str, this.a.Z0().e());
        this.a.J0().N(str);
        if (threadList != null && threadList.size() < 5) {
            this.a.b();
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            ArrayList<wn> threadList = this.a.J0().g0().getThreadList();
            t(str, str2, threadList);
            t(str, str2, this.a.j1().e0().getData());
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                this.a.J0().M(str2);
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                this.a.J0().N(str2);
            }
            if (threadList != null && threadList.size() < 5) {
                this.a.b();
            }
        }
    }

    public final void m(String str, List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<wn> it = list.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i2++;
                wn next = it.next();
                if (i3 + 1 == i2 && (next instanceof er5)) {
                    it.remove();
                }
                if (next instanceof lo5) {
                    Object a2 = ((lo5) next).a();
                    if ((a2 instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) a2).a)) {
                        it.remove();
                        i3 = i2;
                    }
                }
            }
        }
    }

    public final void s(String str, List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, str, list) != null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (wn wnVar : list) {
            if (wnVar instanceof vu4) {
                ThreadData threadData = ((vu4) wnVar).t;
                if (threadData.getTid() != null && threadData.getTid().equals(str)) {
                    arrayList.add(wnVar);
                }
            }
        }
        list.removeAll(arrayList);
        wn wnVar2 = (wn) ListUtils.getItem(list, 0);
        if (wnVar2 instanceof fj6) {
            list.remove(wnVar2);
        }
    }

    public final int u(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i2 = 0;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getAdapter().getItemCount(); i3++) {
                wn B = bdTypeRecyclerView.B(i3);
                if (B instanceof vu4) {
                    ThreadData threadData = ((vu4) B).t;
                    if (threadData.getTid() != null && threadData.getTid().equals(str)) {
                        this.b = threadData;
                        i2 = i3;
                    }
                }
            }
            return (i2 + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLL.intValue;
    }

    public final void n(String str, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.a)) {
                    it.remove();
                }
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ArrayList<AdvertAppInfo> allAdvertList = this.a.J0().g0().getForum().getBannerListData().getAllAdvertList();
            if (!ListUtils.isEmpty(allAdvertList)) {
                allAdvertList.clear();
            }
            zr6 zr6Var = this.a;
            if (zr6Var != null && zr6Var.j1() != null && this.a.j1().e0() != null) {
                p(this.a.j1().e0().getData());
            }
            zr6 zr6Var2 = this.a;
            if (zr6Var2 != null && zr6Var2.Z0() != null && this.a.Z0().f() != null) {
                p(this.a.Z0().f().C());
            }
            this.a.J0().L(null);
            zr6 zr6Var3 = this.a;
            if (zr6Var3 != null && zr6Var3.j1() != null && this.a.j1().Y() != null) {
                this.a.j1().Y().notifyDataSetChanged();
            }
        }
    }

    public final void p(List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<wn> it = list.iterator();
        while (it.hasNext()) {
            wn next = it.next();
            if ((next instanceof lo5) || (next instanceof er5)) {
                it.remove();
            }
        }
    }

    public final void q(CustomResponsedMessage<?> customResponsedMessage) {
        zr6 zr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (zr6Var = this.a) != null && zr6Var.J0() != null && this.a.J0().g0() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("type");
            if (StringUtils.isNull(optString)) {
                return;
            }
            String optString2 = jSONObject.optString("tid");
            if (this.a.j1() != null && this.a.j1().Y() != null) {
                View childAt = this.a.j1().e0().getChildAt(v(optString, optString2, this.a.j1().e0()));
                if (childAt != null) {
                    r(childAt, new b(this, optString, optString2, childAt));
                    return;
                }
                l(optString, optString2);
                this.a.j1().Y().notifyDataSetChanged();
            }
        }
    }

    public final void t(String str, String str2, List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048586, this, str, str2, list) != null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (wn wnVar : list) {
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                if (wnVar instanceof jn8) {
                    arrayList.add((jn8) wnVar);
                }
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (wnVar instanceof vu4)) {
                ThreadData threadData = ((vu4) wnVar).t;
                if (threadData.getTid() != null && threadData.getTid().equals(str2)) {
                    arrayList.add(threadData);
                }
            }
        }
        list.removeAll(arrayList);
        wn wnVar2 = (wn) ListUtils.getItem(list, 0);
        if (wnVar2 instanceof fj6) {
            list.remove(wnVar2);
        }
    }

    public final int v(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, str, str2, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i3 = 0;
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                i2 = 0;
                while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                    if (bdTypeRecyclerView.B(i3) instanceof jn8) {
                        i2 = i3;
                    }
                    i3++;
                }
            } else {
                if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                    i2 = 0;
                    while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                        wn B = bdTypeRecyclerView.B(i3);
                        if (B instanceof vu4) {
                            ThreadData threadData = ((vu4) B).t;
                            if (threadData.getTid() != null && threadData.getTid().equals(str2)) {
                                i2 = i3;
                            }
                        }
                        i3++;
                    }
                }
                return (i3 + headerViewsCount) - firstVisiblePosition;
            }
            i3 = i2;
            return (i3 + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLLL.intValue;
    }

    public final void w(CustomResponsedMessage<?> customResponsedMessage, boolean z) {
        zr6 zr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, customResponsedMessage, z) == null) && (zr6Var = this.a) != null && zr6Var.J0() != null && this.a.J0().g0() != null) {
            String x = x(customResponsedMessage);
            if (!StringUtils.isNull(x) && this.a.j1() != null && this.a.j1().Y() != null) {
                View childAt = this.a.j1().e0().getChildAt(u(x, this.a.j1().e0()));
                if (childAt != null) {
                    r(childAt, new a(this, childAt, x));
                } else {
                    k(x);
                    this.a.j1().Y().notifyDataSetChanged();
                }
                if (z) {
                    j();
                }
            }
        }
    }
}

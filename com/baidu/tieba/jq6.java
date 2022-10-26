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
/* loaded from: classes4.dex */
public class jq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qq6 a;
    public ThreadData b;
    public CustomMessageListener c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jq6 c;

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

        public a(jq6 jq6Var, View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, view2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jq6Var;
            this.a = view2;
            this.b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.c.a != null && this.c.a.j1() != null && this.c.a.j1().e0() != null && this.c.a.j1().Y() != null) {
                this.c.a.j1().e0().removeView(this.a);
                this.c.j(this.b);
                this.c.a.j1().Y().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ View c;
        public final /* synthetic */ jq6 d;

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

        public b(jq6 jq6Var, String str, String str2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, str, str2, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jq6Var;
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
            this.d.k(this.a, this.b);
            this.c.setVisibility(8);
            if (this.d.a.j1() != null && this.d.a.j1().Y() != null) {
                this.d.a.j1().Y().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ jq6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(jq6 jq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, Integer.valueOf(i)};
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
            this.f = jq6Var;
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
                    this.f.t(customResponsedMessage, false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(jq6 jq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, Integer.valueOf(i)};
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
            this.a = jq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.n(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(jq6 jq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, Integer.valueOf(i)};
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
            this.a = jq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.t(customResponsedMessage, true);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(jq6 jq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, Integer.valueOf(i)};
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
            this.a = jq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.j(this.a.u(customResponsedMessage));
            this.a.a.j1().Y().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
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

        public g(jq6 jq6Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, Integer.valueOf(i), view2};
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

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(jq6 jq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq6Var, Integer.valueOf(i)};
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
            this.a = jq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.a != null && this.a.a.J0() != null && this.a.a.J0().g0() != null) {
                String str = (String) customResponsedMessage.getData();
                this.a.m(str, this.a.a.J0().g0().getForum().getBannerListData().getAllAdvertList());
                jq6 jq6Var = this.a;
                jq6Var.l(str, jq6Var.a.j1().e0().getData());
                jq6 jq6Var2 = this.a;
                jq6Var2.l(str, jq6Var2.a.Z0().f().C());
                this.a.a.J0().L(str);
                if (this.a.a.j1() != null && this.a.a.j1().Y() != null) {
                    this.a.a.j1().Y().notifyDataSetChanged();
                }
            }
        }
    }

    public jq6(qq6 qq6Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qq6Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.a = qq6Var;
        this.e.setTag(bdUniqueId);
        this.g.setTag(bdUniqueId);
        this.d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(this.e);
        MessageManager.getInstance().registerListener(this.g);
        this.f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f);
        this.c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.c);
    }

    public final String u(CustomResponsedMessage customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, customResponsedMessage)) == null) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                return ((JSONObject) customResponsedMessage.getData()).optString("tid");
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void o(View view2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, animationListener) == null) {
            g gVar = new g(this, view2.getMeasuredHeight(), view2);
            gVar.setAnimationListener(animationListener);
            gVar.setDuration(300L);
            view2.startAnimation(gVar);
        }
    }

    public final void i() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (threadData = this.b) != null && threadData.isHeadLinePost) {
            TbPageTag tbPageTag = null;
            qq6 qq6Var = this.a;
            if (qq6Var != null && qq6Var.j1() != null) {
                tbPageTag = yc5.k(this.a.j1().getContext());
            }
            gs6.l(this.b, tbPageTag);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        ArrayList<eo> threadList = this.a.J0().g0().getThreadList();
        p(str, threadList);
        p(str, this.a.j1().e0().getData());
        p(str, this.a.Z0().e());
        this.a.J0().N(str);
        if (threadList != null && threadList.size() < 5) {
            this.a.b();
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            ArrayList<eo> threadList = this.a.J0().g0().getThreadList();
            q(str, str2, threadList);
            q(str, str2, this.a.j1().e0().getData());
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

    public final void l(String str, List<eo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<eo> it = list.iterator();
            while (it.hasNext()) {
                eo next = it.next();
                if (next instanceof mn5) {
                    Object a2 = ((mn5) next).a();
                    if ((a2 instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) a2).a)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void p(String str, List<eo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, str, list) != null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (eo eoVar : list) {
            if (eoVar instanceof du4) {
                ThreadData threadData = ((du4) eoVar).t;
                if (threadData.getTid() != null && threadData.getTid().equals(str)) {
                    arrayList.add(eoVar);
                }
            }
        }
        list.removeAll(arrayList);
        eo eoVar2 = (eo) ListUtils.getItem(list, 0);
        if (eoVar2 instanceof vh6) {
            list.remove(eoVar2);
        }
    }

    public final int r(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i = 0;
            for (int i2 = 0; i2 < bdTypeRecyclerView.getAdapter().getItemCount(); i2++) {
                eo B = bdTypeRecyclerView.B(i2);
                if (B instanceof du4) {
                    ThreadData threadData = ((du4) B).t;
                    if (threadData.getTid() != null && threadData.getTid().equals(str)) {
                        this.b = threadData;
                        i = i2;
                    }
                }
            }
            return (i + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLL.intValue;
    }

    public final void m(String str, List<AdvertAppInfo> list) {
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

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        qq6 qq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (qq6Var = this.a) != null && qq6Var.J0() != null && this.a.J0().g0() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("type");
            if (StringUtils.isNull(optString)) {
                return;
            }
            String optString2 = jSONObject.optString("tid");
            if (this.a.j1() != null && this.a.j1().Y() != null) {
                View childAt = this.a.j1().e0().getChildAt(s(optString, optString2, this.a.j1().e0()));
                if (childAt != null) {
                    o(childAt, new b(this, optString, optString2, childAt));
                    return;
                }
                k(optString, optString2);
                this.a.j1().Y().notifyDataSetChanged();
            }
        }
    }

    public final void q(String str, String str2, List<eo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, list) != null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (eo eoVar : list) {
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                if (eoVar instanceof am8) {
                    arrayList.add((am8) eoVar);
                }
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (eoVar instanceof du4)) {
                ThreadData threadData = ((du4) eoVar).t;
                if (threadData.getTid() != null && threadData.getTid().equals(str2)) {
                    arrayList.add(threadData);
                }
            }
        }
        list.removeAll(arrayList);
        eo eoVar2 = (eo) ListUtils.getItem(list, 0);
        if (eoVar2 instanceof vh6) {
            list.remove(eoVar2);
        }
    }

    public final int s(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i2 = 0;
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                i = 0;
                while (i2 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                    if (bdTypeRecyclerView.B(i2) instanceof am8) {
                        i = i2;
                    }
                    i2++;
                }
            } else {
                if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                    i = 0;
                    while (i2 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                        eo B = bdTypeRecyclerView.B(i2);
                        if (B instanceof du4) {
                            ThreadData threadData = ((du4) B).t;
                            if (threadData.getTid() != null && threadData.getTid().equals(str2)) {
                                i = i2;
                            }
                        }
                        i2++;
                    }
                }
                return (i2 + headerViewsCount) - firstVisiblePosition;
            }
            i2 = i;
            return (i2 + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLLL.intValue;
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage, boolean z) {
        qq6 qq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, customResponsedMessage, z) == null) && (qq6Var = this.a) != null && qq6Var.J0() != null && this.a.J0().g0() != null) {
            String u = u(customResponsedMessage);
            if (!StringUtils.isNull(u) && this.a.j1() != null && this.a.j1().Y() != null) {
                View childAt = this.a.j1().e0().getChildAt(r(u, this.a.j1().e0()));
                if (childAt != null) {
                    o(childAt, new a(this, childAt, u));
                } else {
                    j(u);
                    this.a.j1().Y().notifyDataSetChanged();
                }
                if (z) {
                    i();
                }
            }
        }
    }
}

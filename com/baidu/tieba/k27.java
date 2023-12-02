package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.f05;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterChangeView;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterForumView;
import com.baidu.tieba.p55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class k27 implements View.OnClickListener, j27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public q55 c;
    public RelativeLayout d;
    public NoNetworkView e;
    public PbListView f;
    public View g;
    public RelativeLayout h;
    public TextView i;
    public ImageView j;
    public c27 k;
    public EmotionCenterForumView l;
    public EmotionCenterChangeView m;
    public d27 n;
    public EmotionCenterData o;
    public h27 p;
    public LinearLayout q;
    public ImageView r;
    public TextView s;
    public Animation t;
    public boolean u;
    public int v;
    public String w;
    public LoadingView x;

    /* loaded from: classes6.dex */
    public class a implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k27 k27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(k27 k27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    public k27(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = true;
        this.v = 0;
        this.w = "";
        this.a = tbPageContext;
        this.d = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0341, (ViewGroup) null);
        this.e = new NoNetworkView(tbPageContext.getPageActivity());
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.e.setVisibility(8);
        }
        this.d.addView(this.e);
        BdTypeListView bdTypeListView = (BdTypeListView) this.d.findViewById(R.id.obfuscated_res_0x7f0909f8);
        this.b = bdTypeListView;
        bdTypeListView.setDivider(null);
        q55 q55Var = new q55(this.a);
        this.c = q55Var;
        q55Var.W(bdUniqueId);
        this.b.setPullRefresh(this.c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f = pbListView;
        pbListView.a();
        c27 c27Var = new c27(this.a);
        this.k = c27Var;
        c27Var.c().setVisibility(8);
        EmotionCenterForumView emotionCenterForumView = new EmotionCenterForumView(this.a);
        this.l = emotionCenterForumView;
        emotionCenterForumView.setVisibility(8);
        this.n = new d27(this.a, this.b);
        EmotionCenterChangeView emotionCenterChangeView = new EmotionCenterChangeView(this.a);
        this.m = emotionCenterChangeView;
        emotionCenterChangeView.setVisibility(8);
        this.b.addHeaderView(this.k.c());
        this.b.addHeaderView(this.l);
        this.b.addHeaderView(this.m);
        this.g = this.d.findViewById(R.id.obfuscated_res_0x7f0909f6);
        this.h = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0909f6);
        this.i = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09013d);
        this.j = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09106f);
        this.g.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090a41);
        this.q = linearLayout;
        linearLayout.setClickable(false);
        this.q.setOnClickListener(this);
        this.q.setVisibility(8);
        this.r = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f092902);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09013f);
        x();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h27 h27Var = this.p;
            if (h27Var != null) {
                h27Var.dismiss();
            }
            e();
            this.q.setVisibility(0);
            this.g.setVisibility(8);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            SkinManager.setImageResource(this.r, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.s, (int) R.color.common_color_10037);
            this.s.setText(R.string.obfuscated_res_0x7f0f0650);
            this.q.setClickable(true);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            h27 h27Var = this.p;
            if (h27Var != null) {
                h27Var.dismiss();
            }
            z();
            this.q.setVisibility(0);
            this.g.setVisibility(8);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            SkinManager.setImageResource(this.r, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0302);
            this.s.setText(R.string.obfuscated_res_0x7f0f0673);
            this.q.setClickable(false);
        }
    }

    public void B(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionPackageData) != null) || emotionPackageData == null) {
            return;
        }
        EmotionCenterChangeView emotionCenterChangeView = this.m;
        if (emotionCenterChangeView != null) {
            emotionCenterChangeView.f(emotionPackageData);
        }
        d27 d27Var = this.n;
        if (d27Var != null) {
            d27Var.e(emotionPackageData);
        }
    }

    public void q(p55.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
            this.c.a(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.b.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z) {
        c27 c27Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (c27Var = this.k) != null) {
            c27Var.g(z);
        }
    }

    @Override // com.baidu.tieba.j27
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageActivity(), 25021)));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.y();
        }
    }

    public void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (imageView = this.r) != null) {
            imageView.clearAnimation();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public ViewGroup i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public EmotionCenterChangeView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.m;
        }
        return (EmotionCenterChangeView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.g();
            }
            this.b.setNextPage(null);
        }
    }

    public void l() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (loadingView = this.x) != null) {
            loadingView.dettachView(this.d);
            this.x = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            h27 h27Var = this.p;
            if (h27Var != null) {
                h27Var.dismiss();
            }
            e();
            this.q.setVisibility(8);
            this.g.setVisibility(0);
        }
    }

    public void u() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (pbListView = this.f) != null) {
            if (pbListView.c().getParent() == null) {
                this.b.setNextPage(this.f);
            }
            this.f.S();
            this.f.U();
        }
    }

    public void x() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (tbPageContext = this.a) != null && this.d != null) {
            LoadingView loadingView = new LoadingView(tbPageContext.getPageActivity());
            this.x = loadingView;
            loadingView.attachView(this.d, false);
            this.x.onChangeSkinType();
        }
    }

    public void z() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (imageView = this.r) != null) {
            imageView.startAnimation(g());
        }
    }

    @Override // com.baidu.tieba.j27
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.v == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageActivity(), true, 25021)));
            } else if (!TextUtils.isEmpty(this.w)) {
                f05 f05Var = new f05(this.a.getPageActivity());
                f05Var.setMessage(this.w);
                f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new a(this));
                f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                f05Var.create(this.a).show();
            }
        }
    }

    public void c(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, emotionCenterData) != null) || emotionCenterData == null) {
            return;
        }
        this.o = emotionCenterData;
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                f27 f27Var = new f27();
                f27Var.a = emotionPackageData;
                arrayList.add(f27Var);
            }
            this.n.a(arrayList);
        }
        this.n.c();
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.t == null) {
                this.t = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.obfuscated_res_0x7f010134);
                this.t.setInterpolator(new LinearInterpolator());
                this.t.setFillAfter(true);
            }
            return this.t;
        }
        return (Animation) invokeV.objValue;
    }

    public void y() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (pbListView = this.f) != null) {
            if (pbListView.c().getParent() == null) {
                this.b.setNextPage(this.f);
            }
            this.f.H(this.a.getResources().getString(R.string.list_no_more));
            this.f.g();
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f.s(R.color.CAM_X0204);
            this.f.e(i);
            this.c.D(i);
            this.n.c();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.e.onChangeSkinType(this.a, i);
            EmotionCenterForumView emotionCenterForumView = this.l;
            if (emotionCenterForumView != null) {
                emotionCenterForumView.b(i);
            }
            RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.cp_bg_line_d_alpha90, i);
            }
            TextView textView = this.i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            if (this.q != null) {
                SkinManager.setBackgroundColor(this.h, R.color.cp_bg_line_d_alpha90, i);
            }
            ImageView imageView2 = this.r;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            boolean z = false;
            if (view2 == this.g) {
                if (this.o == null) {
                    return;
                }
                if (this.v != 0) {
                    if (this.p == null) {
                        h27 h27Var = new h27(this.a.getPageActivity(), this.v);
                        this.p = h27Var;
                        h27Var.d(this);
                    }
                    this.p.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.a.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.p.showAtLocation(this.d, 81, 0, this.a.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                a();
            } else if (view2 == this.q) {
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = this.a.getPageActivity();
                if (this.v == 1) {
                    z = true;
                }
                messageManager.sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(pageActivity, z, 25021)));
            }
        }
    }

    public void p(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, emotionCenterData) != null) || emotionCenterData == null) {
            return;
        }
        l();
        if (ListUtils.isEmpty(this.m.getDataList())) {
            this.m.d();
            this.m.setVisibility(0);
        }
        this.o = emotionCenterData;
        if (this.u) {
            this.v = JavaTypesHelper.toInt(emotionCenterData.is_bazhu, 0);
            this.w = emotionCenterData.bazhu_message;
            this.u = false;
        }
        if (emotionCenterData.banner != null) {
            this.k.c().setVisibility(0);
            this.k.f(this.a.getUniqueId());
            this.k.e(new g27(emotionCenterData.banner));
            this.k.h();
        }
        if (emotionCenterData.forum != null) {
            this.l.setVisibility(0);
            this.l.setData(emotionCenterData.forum);
        }
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new e27());
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                f27 f27Var = new f27();
                f27Var.a = emotionPackageData;
                arrayList.add(f27Var);
            }
            this.n.d(arrayList);
        }
        this.n.c();
    }
}

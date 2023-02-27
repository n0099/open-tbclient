package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
import com.baidu.tieba.faceshop.FacePackageDetailModel;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.LinkedList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class sq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public final ScrollView E;
    public int F;
    public int G;
    public final TbImageView H;
    public int I;
    public int J;
    public final Runnable K;
    public final TbPageContext<FacePackageDetailActivity> a;
    public final View b;
    public final NavigationBar c;
    public final NoNetworkView d;
    public final TbImageView e;
    public final TextView f;
    public TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final FrameLayout l;
    public final ImageView m;
    public final ImageView n;
    public final LinearLayout o;
    public TextView p;
    public final int q;
    public final int r;
    public final int s;
    public final GridView t;
    public tq6 u;
    public final Handler v;
    public final rq6 w;
    public GifView x;
    public WindowManager y;
    public WindowManager.LayoutParams z;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq6 a;

        public a(sq6 sq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq6Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.t.setSelection(-1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq6 a;

        public b(sq6 sq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.k();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public sq6(TbPageContext<FacePackageDetailActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = -1;
        this.K = new b(this);
        this.a = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.obfuscated_res_0x7f0d0293);
        this.b = tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090a3a);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g = this.c.setTitleText("");
        this.d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.o = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090a3c);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092449);
        this.p = textView;
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + ej.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070282);
        this.e = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090a3d);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a45);
        this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a43);
        this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a44);
        this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a3b);
        this.k = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a42);
        this.t = (GridView) this.b.findViewById(R.id.obfuscated_res_0x7f090a41);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090a46);
        this.H = tbImageView;
        tbImageView.setDefaultResource(0);
        this.H.setDefaultBgResource(0);
        this.t.setSelection(-1);
        try {
            this.t.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.t.setOnItemClickListener(new a(this));
        this.l = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090a3e);
        this.m = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090a40);
        this.n = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090a3f);
        TbadkApplication.getInst().getSkinType();
        this.I = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026e);
        this.J = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026e);
        this.v = new Handler();
        this.j.setOnClickListener(tbPageContext.getOrignalPage());
        this.n.setOnClickListener(tbPageContext.getOrignalPage());
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_down);
        Bitmap cashBitmap2 = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_up);
        this.r = cashBitmap.getWidth();
        this.q = cashBitmap2.getWidth();
        this.s = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027a);
        this.w = new rq6(this.a, R.style.obfuscated_res_0x7f1003ac);
        this.E = (ScrollView) this.b.findViewById(R.id.obfuscated_res_0x7f090761);
        i(tbPageContext);
    }

    public void b(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.d.a(bVar);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            BdListViewHelper.c(this.p, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void o(FacePackageDetailModel facePackageDetailModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, facePackageDetailModel) != null) || facePackageDetailModel == null) {
            return;
        }
        u(facePackageDetailModel);
    }

    public void q(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.d.e(bVar);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f054e));
            SkinManager.setViewTextColor(this.j, R.color.common_color_10172, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_content_buy_d);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0da0));
            SkinManager.setViewTextColor(this.j, R.color.common_color_10172, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_content_buy_d);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.a.getResources().getString(R.string.buy_book));
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0382));
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
        }
    }

    public void B(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.setVisibility(8);
            this.l.setVisibility(0);
            int i = (int) (this.r * (((float) j2) / ((float) j)));
            int i2 = this.q;
            if (i < i2) {
                i = i2;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.width = i;
            this.m.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, Rect rect, FacePackageData facePackageData) {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, rect, facePackageData) == null) && i != this.G && (arrayList = facePackageData.face_dynamic_list) != null && i >= 0 && i <= arrayList.size()) {
            int i2 = this.G;
            if (i2 != -1) {
                v(i2, false);
            }
            this.G = i;
            this.t.setSelection(i);
            v(i, true);
            this.D = true;
            this.x.setVisibility(0);
            String str = SmallTailInfo.EMOTION_PREFIX + facePackageData.face_dynamic_list.get(i) + SmallTailInfo.EMOTION_SUFFIX;
            this.x.setTag(str);
            if (dq5.c()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.J;
                gifInfo.mGifWidth = this.I;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i);
                this.x.i0(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.J;
                gifInfo2.mGifWidth = this.I;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i);
                this.x.i0(gifInfo2);
            }
            this.z.x = rect.left - ((this.A - rect.width()) / 2);
            WindowManager.LayoutParams layoutParams = this.z;
            int i3 = rect.top - layoutParams.height;
            layoutParams.y = i3;
            int i4 = this.F;
            if (i3 < i4) {
                this.E.scrollBy(0, i3 - i4);
                this.z.y = this.F;
            }
            WindowManager.LayoutParams layoutParams2 = this.z;
            int i5 = layoutParams2.y;
            GridView gridView = this.t;
            layoutParams2.y = i5 + gridView.getChildAt(i - gridView.getFirstVisiblePosition()).getPaddingTop();
            if (!this.C) {
                this.y.addView(this.x, this.z);
                this.C = true;
                return;
            }
            this.y.updateViewLayout(this.x, this.z);
        }
    }

    public final void E() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (handler = this.v) != null) {
            handler.removeCallbacks(this.K);
            this.v.postDelayed(this.K, 90L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.D = false;
            this.x.setVisibility(8);
            this.t.setSelection(-1);
            v(this.G, false);
            this.G = -1;
        }
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (TextView) invokeV.objValue;
    }

    public ImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.n;
        }
        return (ImageView) invokeV.objValue;
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.t;
        }
        return (GridView) invokeV.objValue;
    }

    public void h() {
        rq6 rq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (rq6Var = this.w) != null) {
            ih.b(rq6Var, this.a);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.D;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (noNetworkView = this.d) != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
            this.d.update(false);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.D = false;
            if (this.C) {
                this.C = false;
                this.y.removeView(this.x);
            }
        }
    }

    public void r() {
        rq6 rq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (rq6Var = this.w) != null) {
            rq6Var.c();
        }
    }

    public void y() {
        rq6 rq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (rq6Var = this.w) != null) {
            rq6Var.d();
            ih.j(this.w, this.a);
        }
    }

    public final void i(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tbPageContext) == null) {
            GifView gifView = new GifView(tbPageContext.getPageActivity());
            this.x = gifView;
            SkinManager.setBackgroundResource(gifView, R.drawable.bg_expression_bubble);
            this.x.setVisibility(8);
            this.x.setSupportNoImage(false);
            this.y = (WindowManager) tbPageContext.getPageActivity().getSystemService("window");
            this.z = new WindowManager.LayoutParams();
            this.A = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070279);
            int dimensionPixelSize = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070284);
            this.B = dimensionPixelSize;
            WindowManager.LayoutParams layoutParams = this.z;
            layoutParams.width = this.A;
            layoutParams.height = dimensionPixelSize;
            layoutParams.gravity = 51;
            layoutParams.format = -3;
            layoutParams.type = 1000;
            layoutParams.flags |= 56;
            this.F = ej.u(tbPageContext.getPageActivity());
            if (MenuKeyUtils.hasSmartBar()) {
                WindowManager.LayoutParams layoutParams2 = this.z;
                layoutParams2.type = 1000;
                layoutParams2.flags = 25165832;
            }
        }
    }

    public void u(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, facePackageDetailModel) == null) && facePackageDetailModel != null && facePackageDetailModel.V() != null && (facePackageData = facePackageDetailModel.V().faces_list) != null) {
            if (facePackageDetailModel.X()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.o.setVisibility(0);
            this.e.setTag(facePackageData.cover_url);
            this.f.setText(facePackageData.pname);
            this.H.setTag(facePackageData.tag_url);
            TextView textView = this.h;
            textView.setText(this.a.getResources().getString(R.string.price_tip) + facePackageData.price);
            this.k.setText(facePackageData.pdesc);
            this.g.setText(facePackageData.pname);
            s(facePackageData);
            n(facePackageDetailModel.getPid());
            t(facePackageData);
            E();
        }
    }

    public void w(FacePackageDetailModel facePackageDetailModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, facePackageDetailModel) == null) && facePackageDetailModel != null && facePackageDetailModel.V() != null && facePackageDetailModel.V().faces_list != null) {
            FacePackageData facePackageData = facePackageDetailModel.V().faces_list;
            if (facePackageData.buy_status == 1) {
                this.i.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08c8));
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            switch (facePackageDetailModel.Z()) {
                case 1:
                    A();
                    return;
                case 2:
                case 3:
                    z();
                    return;
                case 4:
                    x();
                    return;
                case 5:
                    B(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    D();
                    return;
                default:
                    return;
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TbImageView tbImageView = this.e;
            if (tbImageView != null && tbImageView.getTag() != null) {
                this.e.G(this.e.getTag().toString(), 10, this.I, this.J, false);
            }
            TbImageView tbImageView2 = this.H;
            if (tbImageView2 != null && tbImageView2.getTag() != null) {
                this.H.G(this.H.getTag().toString(), 10, this.I, this.J, false);
            }
        }
    }

    public void l(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            TbPageContext<FacePackageDetailActivity> tbPageContext = this.a;
            if (tbPageContext != null) {
                xw4 layoutMode = tbPageContext.getLayoutMode();
                if (i == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.l(z);
                this.a.getLayoutMode().k(this.b);
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            NoNetworkView noNetworkView = this.d;
            if (noNetworkView != null) {
                noNetworkView.d(this.a, i);
            }
        }
    }

    public final void s(FacePackageData facePackageData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, facePackageData) == null) && facePackageData != null && facePackageData.face_list != null) {
            this.t.setLayoutParams(new LinearLayout.LayoutParams(-1, ((ej.l(this.a.getPageActivity()) - (this.s * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
        }
    }

    public void t(FacePackageData facePackageData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, facePackageData) != null) || facePackageData == null) {
            return;
        }
        tq6 tq6Var = this.u;
        if (tq6Var == null) {
            tq6 tq6Var2 = new tq6(this.a.getPageActivity(), facePackageData.face_list);
            this.u = tq6Var2;
            this.t.setAdapter((ListAdapter) tq6Var2);
            return;
        }
        tq6Var.a(facePackageData.face_list);
        this.u.notifyDataSetChanged();
    }

    public final void v(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            GridView gridView = this.t;
            ((ViewGroup) gridView.getChildAt(i - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
        }
    }
}

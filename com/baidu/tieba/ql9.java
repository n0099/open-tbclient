package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverPendantDragView;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import com.baidu.tieba.yk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ql9 extends y8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public CoverSeekBar b;
    public LinearLayout c;
    public ol9 d;
    public HListView e;
    public yk9 f;
    public CoverPendantDragView g;

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements yk9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql9 a;

        public a(ql9 ql9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql9Var;
        }

        @Override // com.baidu.tieba.yk9.b
        public void a(View view2, int i, PendantData pendantData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, pendantData) == null) {
                this.a.g.u(view2, pendantData);
                StatisticItem statisticItem = new StatisticItem("c12305");
                statisticItem.param("obj_locate", i + 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CoverSeekBar.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql9 a;

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(ql9 ql9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql9Var;
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log("c12304");
            }
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                int duration = (int) ((this.a.d.F().getDuration() * i) / 1000);
                this.a.b.setProgressImage(i, duration);
                this.a.d.F().seekTo(duration);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql9 a;

        public c(ql9 ql9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql9Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql9 a;

        public d(ql9 ql9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.k(this.a.b.getCurrentPosition());
                this.a.d.M();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ql9(a9 a9Var, ol9 ol9Var) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var, ol9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ol9Var;
        View inflate = LayoutInflater.from(a9Var.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d025c, (ViewGroup) null);
        this.a = inflate;
        inflate.getResources();
        u();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.g.K(z);
            if (z) {
                CoverSeekBar coverSeekBar = this.b;
                coverSeekBar.k(coverSeekBar.getCurrentPosition());
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setData(str);
    }

    public void E(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.addAll(0, p());
            this.f.c(list);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CoverSeekBar coverSeekBar = this.b;
            if (coverSeekBar != null) {
                coverSeekBar.j();
            }
            CoverPendantDragView coverPendantDragView = this.g;
            if (coverPendantDragView != null) {
                coverPendantDragView.I();
            }
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g.getText();
        }
        return (String) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g.A();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            jg.a().postDelayed(new d(this), 500L);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setVideoSize(this.d.F().getWidth(), this.d.F().getHeight());
            this.g.setVideoLocation(this.d.F().getLeft(), this.d.F().getTop(), this.d.F().getRight(), this.d.F().getBottom());
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b = (CoverSeekBar) this.a.findViewById(R.id.obfuscated_res_0x7f0907c2);
            this.e = (HListView) this.a.findViewById(R.id.obfuscated_res_0x7f091a52);
            yk9 yk9Var = new yk9(getPageContext());
            this.f = yk9Var;
            yk9Var.d(new a(this));
            this.e.setAdapter((ListAdapter) this.f);
            this.f.c(p());
            this.b.setOnProgressChanged(new b(this));
        }
    }

    public Bitmap o(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            this.g.A();
            String text = this.g.getText();
            if (bitmap == null || TextUtils.isEmpty(text)) {
                return null;
            }
            int width = this.d.F().getWidth();
            int height = this.d.F().getHeight();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Bitmap tempBitmap = this.g.getTempBitmap();
            if (tempBitmap != null) {
                Matrix matrix = new Matrix();
                matrix.postScale(width2 / width, height2 / height);
                Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.d.F().getLeft(), this.d.F().getTop(), width, height, matrix, true);
                if (createBitmap2 != null) {
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
                }
            }
            canvas.save();
            canvas.restore();
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view2.findViewById(R.id.obfuscated_res_0x7f0907be);
            this.g = coverPendantDragView;
            coverPendantDragView.setParentViewController(this);
            this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907c8);
            if (m35.m().i("video_cover_first_in", true)) {
                this.c.setVisibility(0);
                this.c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new c(this)).start();
                m35.m().w("video_cover_first_in", false);
            }
        }
    }

    public final List<PendantData> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, new PendantData(0));
            arrayList.add(1, new PendantData(1));
            arrayList.add(2, new PendantData(2));
            arrayList.add(3, new PendantData(3));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void x(a9 a9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, a9Var, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        }
    }
}

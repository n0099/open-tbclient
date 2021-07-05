package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.b0.g.e;
import d.a.r0.r.s.a;
import d.a.r0.z0.h;
import d.a.s0.a4.u.j;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public WriteMultiImgsActivity f22684e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo[] f22685f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f22686g;

    /* renamed from: h  reason: collision with root package name */
    public c f22687h;

    /* renamed from: i  reason: collision with root package name */
    public int f22688i;
    public int j;
    public d[] k;
    public int l;
    public LinkedList<ImageFileInfo> m;
    public int n;
    public int o;
    public j p;
    public d.a.r0.r.s.a q;
    public Bitmap r;
    public boolean s;

    /* loaded from: classes5.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f22689e;

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0245a implements d.a.s0.a4.u.n.b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f22690a;

            public C0245a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22690a = aVar;
            }

            @Override // d.a.s0.a4.u.n.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f22690a.f22689e.f22687h.a();
                }
            }

            @Override // d.a.s0.a4.u.n.b.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // d.a.s0.a4.u.n.b.c
            public boolean c(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // d.a.s0.a4.u.n.b.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                }
            }
        }

        public a(MultiImagePagerAdapter multiImagePagerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImagePagerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22689e = multiImagePagerAdapter;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f22689e.q != null) {
                    this.f22689e.q.dismiss();
                }
                this.f22689e.p.f57689f.f(new C0245a(this));
                MultiImagePagerAdapter multiImagePagerAdapter = this.f22689e;
                multiImagePagerAdapter.j(multiImagePagerAdapter.l, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f22691e;

        public b(MultiImagePagerAdapter multiImagePagerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImagePagerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22691e = multiImagePagerAdapter;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f22691e.q == null) {
                return;
            }
            this.f22691e.q.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b(int i2, boolean z);

        boolean c();

        void d();
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f22692a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f22693b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f22694c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.r0.b0.b f22695d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f22696e;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f22697e;

            public a(d dVar, MultiImagePagerAdapter multiImagePagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, multiImagePagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22697e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22697e.f22696e.f22687h == null) {
                    return;
                }
                this.f22697e.f22696e.f22687h.d();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements d.a.r0.a0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageFileInfo f22698e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f22699f;

            public b(d dVar, ImageFileInfo imageFileInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, imageFileInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22699f = dVar;
                this.f22698e = imageFileInfo;
            }

            @Override // d.a.r0.a0.b
            public void a(d.a.c.k.d.a aVar, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                    this.f22699f.e(this.f22698e, aVar);
                    this.f22699f.f22694c.setVisibility(8);
                    if (this.f22699f.f22696e.p != null) {
                        this.f22699f.f22696e.p.n();
                    }
                }
            }
        }

        public d(MultiImagePagerAdapter multiImagePagerAdapter, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImagePagerAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22696e = multiImagePagerAdapter;
            this.f22694c = null;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(multiImagePagerAdapter.f22684e.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.f22692a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.progress_tb_imageview);
            this.f22693b = tbImageView;
            tbImageView.setClickable(true);
            this.f22693b.setDefaultResource(0);
            this.f22693b.setDefaultBgResource(0);
            this.f22693b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f22693b.setPadding(0, 0, 0, 0);
            this.f22695d = new d.a.r0.b0.b();
            this.f22693b.setOnClickListener(new a(this, multiImagePagerAdapter));
            ProgressBar progressBar = (ProgressBar) this.f22692a.findViewById(R.id.progress_tb_imageview_progress);
            this.f22694c = progressBar;
            progressBar.setVisibility(8);
        }

        public void d() {
            d.a.r0.b0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f22695d) == null) {
                return;
            }
            bVar.b();
        }

        public final void e(ImageFileInfo imageFileInfo, d.a.c.k.d.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, aVar) == null) || aVar == null || this.f22693b == null) {
                return;
            }
            int[] l = l.l(aVar.r(), aVar.m(), l.k(this.f22696e.f22684e), (l.i(this.f22696e.f22684e) - l.g(this.f22696e.f22684e, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f22693b.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = l[0];
            layoutParams.height = l[1];
            this.f22693b.setLayoutParams(layoutParams);
            aVar.h(this.f22693b);
            if (this.f22696e.p != null && this.f22696e.p.f57689f != null && imageFileInfo != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f22696e.p.f57689f.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.width = l[0];
                layoutParams2.height = l[1];
                this.f22696e.p.f57689f.setLayoutParams(layoutParams2);
            }
            if (aVar.p() == null || aVar.p().isRecycled()) {
                return;
            }
            this.f22696e.r = aVar.p();
        }

        public View f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22692a : (View) invokeV.objValue;
        }

        public void g(ImageFileInfo imageFileInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, imageFileInfo) == null) || imageFileInfo == null) {
                return;
            }
            d();
            this.f22694c.setVisibility(0);
            d.a.c.k.d.a c2 = this.f22695d.c(imageFileInfo, false);
            if (c2 != null) {
                e(imageFileInfo, c2);
                this.f22694c.setVisibility(8);
                return;
            }
            this.f22695d.d(imageFileInfo, new b(this, imageFileInfo), false);
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22694c.getVisibility() != 0 : invokeV.booleanValue;
        }
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i2, c cVar, j jVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeMultiImgsActivity, viewPager, linkedList, Integer.valueOf(i2), cVar, jVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22684e = null;
        this.f22685f = null;
        this.f22686g = null;
        this.f22687h = null;
        this.f22688i = 0;
        this.j = 0;
        this.k = null;
        this.m = new LinkedList<>();
        this.n = 120;
        this.o = 120;
        this.s = z;
        this.f22684e = writeMultiImgsActivity;
        this.p = jVar;
        this.n = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.o = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.j = o(linkedList, i2);
        int size = this.m.size();
        this.f22688i = size;
        this.f22685f = new ImageFileInfo[size];
        this.k = new d[size];
        for (int i5 = 0; i5 < this.f22688i; i5++) {
            this.f22685f[i5] = this.m.get(i5).cloneWithoutFilterAction(true);
            this.f22685f[i5].addPageAction(d.a.r0.b0.g.d.g(this.n, this.o));
            linkedList.set(linkedList.indexOf(this.m.get(i5)), this.f22685f[i5]);
            this.f22685f[i5].mCount = 0;
        }
        this.f22686g = viewPager;
        this.f22687h = cVar;
        viewPager.setOffscreenPageLimit(1);
        this.f22686g.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            this.f22686g.removeView(this.k[i2].f());
        }
    }

    public void g(boolean z) {
        j jVar;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f22685f == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ImageFileInfo[] imageFileInfoArr = this.f22685f;
            if (i2 >= imageFileInfoArr.length) {
                break;
            }
            ImageFileInfo imageFileInfo = imageFileInfoArr[i2];
            if (imageFileInfo != null) {
                imageFileInfoArr[i2].applayRotatePageActionToPersistAction(imageFileInfo);
            }
            i2++;
        }
        if (!i()) {
            if (z || !this.s) {
                return;
            }
            q(this.r);
            return;
        }
        c cVar = this.f22687h;
        if (cVar != null && cVar.c() && (jVar = this.p) != null && (stickerLayout = jVar.f57689f) != null) {
            stickerLayout.e();
            TbImageView tbImageView = this.k[this.j].f22693b;
            try {
                bitmap = this.p.f57689f.c();
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                return;
            }
            try {
                bitmap2 = h.c(tbImageView);
            } catch (OutOfMemoryError unused2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap2 = null;
                if (bitmap != null) {
                    return;
                }
                return;
            }
            if (bitmap != null || bitmap2 == null || (f2 = h.f(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) == null) {
                return;
            }
            this.f22685f[this.j].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), f2, 100));
            this.f22685f[this.j].setContentUriStr(null);
            this.f22685f[this.j].clearAllActions();
            this.f22685f[this.j].clearPageActions();
            this.f22685f[this.j].setIsGif(false);
            if (z || !this.s) {
                return;
            }
            q(f2);
        } else if (z || !this.s) {
        } else {
            q(this.r);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22688i : invokeV.intValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        int i2;
        ImageFileInfo[] imageFileInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d[] dVarArr = this.k;
            return (dVarArr == null || (i2 = this.j) >= dVarArr.length || dVarArr[i2] == null || (imageFileInfoArr = this.f22685f) == null || i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            d[] dVarArr = this.k;
            if (dVarArr[i2] == null) {
                dVarArr[i2] = new d(this, i2);
            }
            this.f22686g.addView(this.k[i2].f());
            return this.k[i2].f();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j(int i2, boolean z) {
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (m()) {
                c cVar = this.f22687h;
                if (cVar != null) {
                    cVar.b(i2, z);
                }
            } else if (z) {
                r(i2);
            } else if (i()) {
                d[] dVarArr = this.k;
                int i3 = this.j;
                d dVar = dVarArr[i3];
                if (dVar == null || (imageFileInfo = this.f22685f[i3]) == null || !dVar.h()) {
                    return;
                }
                imageFileInfo.addPageAction(e.e(i2));
                this.f22684e.addAction();
                dVar.g(imageFileInfo);
            }
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.j;
            ImageFileInfo[] imageFileInfoArr = this.f22685f;
            if (i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null || !imageFileInfoArr[i2].isGif()) {
                return false;
            }
            ImageFileInfo[] imageFileInfoArr2 = this.f22685f;
            int i3 = this.j;
            if (imageFileInfoArr2[i3].mCount > 0) {
                return false;
            }
            imageFileInfoArr2[i3].mCount++;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        int i2;
        d[] dVarArr;
        d[] dVarArr2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (i2 = this.j) < 0 || (dVarArr = this.k) == null || i2 >= dVarArr.length) {
            return;
        }
        ImageFileInfo[] imageFileInfoArr = this.f22685f;
        if (i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            dVarArr2 = this.k;
            if (i3 >= dVarArr2.length) {
                break;
            }
            if (dVarArr2[i3] != null) {
                dVarArr2[i3].d();
            }
            i3++;
        }
        int i4 = this.j;
        if (dVarArr2[i4] == null) {
            dVarArr2[i4] = new d(this, i4);
        }
        d[] dVarArr3 = this.k;
        int i5 = this.j;
        dVarArr3[i5].g(this.f22685f[i5]);
    }

    public final int o(LinkedList<ImageFileInfo> linkedList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, linkedList, i2)) == null) {
            if (linkedList == null || i2 < 0 || i2 >= linkedList.size()) {
                return i2;
            }
            this.m.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i2);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.m.add(next);
                }
            }
            return this.m.indexOf(imageFileInfo);
        }
        return invokeLI.intValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.j = i2;
            n();
        }
    }

    public final boolean p(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, bitmap)) == null) {
            try {
                FileHelper.SaveFile(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
                Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
                if (resizeBitmap != null) {
                    return FileHelper.SaveFile(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null;
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void q(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, bitmap) == null) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Date date = new Date();
        String str = "tieba" + String.valueOf(date.getTime()) + ".jpg";
        if (p(str, bitmap)) {
            this.f22685f[0].extra = str;
        }
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.l = i2;
            if (this.q == null) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f22684e);
                this.q = aVar;
                aVar.setMessageId(R.string.rorate_tip);
                this.q.setPositiveButton(R.string.alert_yes_button, new a(this));
                this.q.setNegativeButton(R.string.cancel, new b(this));
                this.q.create(this.f22684e.getPageContext());
            }
            this.q.show();
        }
    }
}

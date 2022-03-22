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
import c.a.d.f.p.n;
import c.a.o0.c0.i.e;
import c.a.o0.c1.m;
import c.a.o0.r.t.a;
import c.a.p0.s4.u.j;
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
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WriteMultiImgsActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ImageFileInfo[] f37428b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f37429c;

    /* renamed from: d  reason: collision with root package name */
    public c f37430d;

    /* renamed from: e  reason: collision with root package name */
    public int f37431e;

    /* renamed from: f  reason: collision with root package name */
    public int f37432f;

    /* renamed from: g  reason: collision with root package name */
    public d[] f37433g;

    /* renamed from: h  reason: collision with root package name */
    public int f37434h;
    public LinkedList<ImageFileInfo> i;
    public int j;
    public int k;
    public j l;
    public c.a.o0.r.t.a m;
    public Bitmap n;
    public boolean o;

    /* loaded from: classes6.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImagePagerAdapter a;

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1900a implements c.a.p0.s4.u.n.b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1900a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.p0.s4.u.n.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f37430d.a();
                }
            }

            @Override // c.a.p0.s4.u.n.b.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // c.a.p0.s4.u.n.b.c
            public boolean c(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // c.a.p0.s4.u.n.b.c
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImagePagerAdapter;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.a.m != null) {
                    this.a.m.dismiss();
                }
                this.a.l.f18517f.f(new C1900a(this));
                MultiImagePagerAdapter multiImagePagerAdapter = this.a;
                multiImagePagerAdapter.j(multiImagePagerAdapter.f37434h, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImagePagerAdapter a;

        public b(MultiImagePagerAdapter multiImagePagerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImagePagerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImagePagerAdapter;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.a.m == null) {
                return;
            }
            this.a.m.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void b(int i, boolean z);

        boolean c();

        void d();
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f37435b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f37436c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.o0.c0.b f37437d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f37438e;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar, MultiImagePagerAdapter multiImagePagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, multiImagePagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f37438e.f37430d == null) {
                    return;
                }
                this.a.f37438e.f37430d.d();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements c.a.o0.b0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageFileInfo a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f37439b;

            public b(d dVar, ImageFileInfo imageFileInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, imageFileInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37439b = dVar;
                this.a = imageFileInfo;
            }

            @Override // c.a.o0.b0.b
            public void a(c.a.d.o.d.a aVar, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                    this.f37439b.e(this.a, aVar);
                    this.f37439b.f37436c.setVisibility(8);
                    if (this.f37439b.f37438e.l != null) {
                        this.f37439b.f37438e.l.n();
                    }
                }
            }
        }

        public d(MultiImagePagerAdapter multiImagePagerAdapter, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImagePagerAdapter, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37438e = multiImagePagerAdapter;
            this.f37436c = null;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(multiImagePagerAdapter.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d070d, (ViewGroup) null);
            this.a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091935);
            this.f37435b = tbImageView;
            tbImageView.setClickable(true);
            this.f37435b.setDefaultResource(0);
            this.f37435b.setDefaultBgResource(0);
            this.f37435b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f37435b.setPadding(0, 0, 0, 0);
            this.f37437d = new c.a.o0.c0.b();
            this.f37435b.setOnClickListener(new a(this, multiImagePagerAdapter));
            ProgressBar progressBar = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091936);
            this.f37436c = progressBar;
            progressBar.setVisibility(8);
        }

        public void d() {
            c.a.o0.c0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f37437d) == null) {
                return;
            }
            bVar.b();
        }

        public final void e(ImageFileInfo imageFileInfo, c.a.d.o.d.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, aVar) == null) || aVar == null || this.f37435b == null) {
                return;
            }
            int[] l = n.l(aVar.r(), aVar.m(), n.k(this.f37438e.a), (n.i(this.f37438e.a) - n.f(this.f37438e.a, R.dimen.obfuscated_res_0x7f0702b2)) - UtilHelper.getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f37435b.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = l[0];
            layoutParams.height = l[1];
            this.f37435b.setLayoutParams(layoutParams);
            aVar.h(this.f37435b);
            if (this.f37438e.l != null && this.f37438e.l.f18517f != null && imageFileInfo != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f37438e.l.f18517f.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.width = l[0];
                layoutParams2.height = l[1];
                this.f37438e.l.f18517f.setLayoutParams(layoutParams2);
            }
            if (aVar.p() == null || aVar.p().isRecycled()) {
                return;
            }
            this.f37438e.n = aVar.p();
        }

        public View f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (View) invokeV.objValue;
        }

        public void g(ImageFileInfo imageFileInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, imageFileInfo) == null) || imageFileInfo == null) {
                return;
            }
            d();
            this.f37436c.setVisibility(0);
            c.a.d.o.d.a c2 = this.f37437d.c(imageFileInfo, false);
            if (c2 != null) {
                e(imageFileInfo, c2);
                this.f37436c.setVisibility(8);
                return;
            }
            this.f37437d.d(imageFileInfo, new b(this, imageFileInfo), false);
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37436c.getVisibility() != 0 : invokeV.booleanValue;
        }
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, c cVar, j jVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeMultiImgsActivity, viewPager, linkedList, Integer.valueOf(i), cVar, jVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f37428b = null;
        this.f37429c = null;
        this.f37430d = null;
        this.f37431e = 0;
        this.f37432f = 0;
        this.f37433g = null;
        this.i = new LinkedList<>();
        this.j = 120;
        this.k = 120;
        this.o = z;
        this.a = writeMultiImgsActivity;
        this.l = jVar;
        this.j = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702f3);
        this.k = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239);
        this.f37432f = o(linkedList, i);
        int size = this.i.size();
        this.f37431e = size;
        this.f37428b = new ImageFileInfo[size];
        this.f37433g = new d[size];
        for (int i4 = 0; i4 < this.f37431e; i4++) {
            this.f37428b[i4] = this.i.get(i4).cloneWithoutFilterAction(true);
            this.f37428b[i4].addPageAction(c.a.o0.c0.i.d.g(this.j, this.k));
            linkedList.set(linkedList.indexOf(this.i.get(i4)), this.f37428b[i4]);
            this.f37428b[i4].mCount = 0;
        }
        this.f37429c = viewPager;
        this.f37430d = cVar;
        viewPager.setOffscreenPageLimit(1);
        this.f37429c.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
            this.f37429c.removeView(this.f37433g[i].f());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37431e : invokeV.intValue;
    }

    public void h(boolean z) {
        j jVar;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f37428b == null) {
            return;
        }
        int i = 0;
        while (true) {
            ImageFileInfo[] imageFileInfoArr = this.f37428b;
            if (i >= imageFileInfoArr.length) {
                break;
            }
            ImageFileInfo imageFileInfo = imageFileInfoArr[i];
            if (imageFileInfo != null) {
                imageFileInfoArr[i].applayRotatePageActionToPersistAction(imageFileInfo);
            }
            i++;
        }
        if (!i()) {
            if (z || !this.o) {
                return;
            }
            q(this.n);
            return;
        }
        c cVar = this.f37430d;
        if (cVar != null && cVar.c() && (jVar = this.l) != null && (stickerLayout = jVar.f18517f) != null) {
            stickerLayout.e();
            TbImageView tbImageView = this.f37433g[this.f37432f].f37435b;
            try {
                bitmap = this.l.f18517f.c();
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                return;
            }
            try {
                bitmap2 = m.c(tbImageView);
            } catch (OutOfMemoryError unused2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap2 = null;
                if (bitmap != null) {
                    return;
                }
                return;
            }
            if (bitmap != null || bitmap2 == null || (f2 = m.f(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) == null) {
                return;
            }
            this.f37428b[this.f37432f].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), f2, 100));
            this.f37428b[this.f37432f].setContentUriStr(null);
            this.f37428b[this.f37432f].clearAllActions();
            this.f37428b[this.f37432f].clearPageActions();
            this.f37428b[this.f37432f].setIsGif(false);
            if (z || !this.o) {
                return;
            }
            q(f2);
        } else if (z || !this.o) {
        } else {
            q(this.n);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        int i;
        ImageFileInfo[] imageFileInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d[] dVarArr = this.f37433g;
            return (dVarArr == null || (i = this.f37432f) >= dVarArr.length || dVarArr[i] == null || (imageFileInfoArr = this.f37428b) == null || i >= imageFileInfoArr.length || imageFileInfoArr[i] == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            d[] dVarArr = this.f37433g;
            if (dVarArr[i] == null) {
                dVarArr[i] = new d(this, i);
            }
            this.f37429c.addView(this.f37433g[i].f());
            return this.f37433g[i].f();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j(int i, boolean z) {
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (m()) {
                c cVar = this.f37430d;
                if (cVar != null) {
                    cVar.b(i, z);
                }
            } else if (z) {
                r(i);
            } else if (i()) {
                d[] dVarArr = this.f37433g;
                int i2 = this.f37432f;
                d dVar = dVarArr[i2];
                if (dVar == null || (imageFileInfo = this.f37428b[i2]) == null || !dVar.h()) {
                    return;
                }
                imageFileInfo.addPageAction(e.e(i));
                this.a.addAction();
                dVar.g(imageFileInfo);
            }
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37432f : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37432f : invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.f37432f;
            ImageFileInfo[] imageFileInfoArr = this.f37428b;
            if (i >= imageFileInfoArr.length || imageFileInfoArr[i] == null || !imageFileInfoArr[i].isGif()) {
                return false;
            }
            ImageFileInfo[] imageFileInfoArr2 = this.f37428b;
            int i2 = this.f37432f;
            if (imageFileInfoArr2[i2].mCount > 0) {
                return false;
            }
            imageFileInfoArr2[i2].mCount++;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        int i;
        d[] dVarArr;
        d[] dVarArr2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (i = this.f37432f) < 0 || (dVarArr = this.f37433g) == null || i >= dVarArr.length) {
            return;
        }
        ImageFileInfo[] imageFileInfoArr = this.f37428b;
        if (i >= imageFileInfoArr.length || imageFileInfoArr[i] == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            dVarArr2 = this.f37433g;
            if (i2 >= dVarArr2.length) {
                break;
            }
            if (dVarArr2[i2] != null) {
                dVarArr2[i2].d();
            }
            i2++;
        }
        int i3 = this.f37432f;
        if (dVarArr2[i3] == null) {
            dVarArr2[i3] = new d(this, i3);
        }
        d[] dVarArr3 = this.f37433g;
        int i4 = this.f37432f;
        dVarArr3[i4].g(this.f37428b[i4]);
    }

    public final int o(LinkedList<ImageFileInfo> linkedList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, linkedList, i)) == null) {
            if (linkedList == null || i < 0 || i >= linkedList.size()) {
                return i;
            }
            this.i.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.i.add(next);
                }
            }
            return this.i.indexOf(imageFileInfo);
        }
        return invokeLI.intValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f37432f = i;
            n();
        }
    }

    public final boolean p(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, bitmap)) == null) {
            try {
                FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
                Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
                if (resizeBitmap != null) {
                    return FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null;
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
            this.f37428b[0].setExtra(str);
        }
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f37434h = i;
            if (this.m == null) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a);
                this.m = aVar;
                aVar.setMessageId(R.string.obfuscated_res_0x7f0f0fc2);
                this.m.setPositiveButton(R.string.obfuscated_res_0x7f0f025c, new a(this));
                this.m.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new b(this));
                this.m.create(this.a.getPageContext());
            }
            this.m.show();
        }
    }
}

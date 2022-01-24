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
import c.a.s0.d1.m;
import c.a.s0.s.s.a;
import c.a.t0.p4.e;
import c.a.t0.p4.e0.j;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes13.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public WriteMultiImgsActivity f49817e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo[] f49818f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f49819g;

    /* renamed from: h  reason: collision with root package name */
    public c f49820h;

    /* renamed from: i  reason: collision with root package name */
    public int f49821i;

    /* renamed from: j  reason: collision with root package name */
    public int f49822j;
    public d[] k;
    public int l;
    public LinkedList<ImageFileInfo> m;
    public int n;
    public int o;
    public j p;
    public c.a.s0.s.s.a q;
    public Bitmap r;
    public boolean s;

    /* loaded from: classes13.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f49823e;

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C1972a implements c.a.t0.p4.e0.n.b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1972a(a aVar) {
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
                this.a = aVar;
            }

            @Override // c.a.t0.p4.e0.n.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f49823e.f49820h.a();
                }
            }

            @Override // c.a.t0.p4.e0.n.b.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // c.a.t0.p4.e0.n.b.c
            public boolean c(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // c.a.t0.p4.e0.n.b.c
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
            this.f49823e = multiImagePagerAdapter;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f49823e.q != null) {
                    this.f49823e.q.dismiss();
                }
                this.f49823e.p.f21390f.removeAllSticker(new C1972a(this));
                MultiImagePagerAdapter multiImagePagerAdapter = this.f49823e;
                multiImagePagerAdapter.i(multiImagePagerAdapter.l, false);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f49824e;

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
            this.f49824e = multiImagePagerAdapter;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f49824e.q == null) {
                return;
            }
            this.f49824e.q.dismiss();
        }
    }

    /* loaded from: classes13.dex */
    public interface c {
        void a();

        void b(int i2, boolean z);

        boolean c();

        void d();
    }

    /* loaded from: classes13.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f49825b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f49826c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.s0.d0.b f49827d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f49828e;

        /* loaded from: classes13.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f49829e;

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
                this.f49829e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49829e.f49828e.f49820h == null) {
                    return;
                }
                this.f49829e.f49828e.f49820h.d();
            }
        }

        /* loaded from: classes13.dex */
        public class b implements c.a.s0.c0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageFileInfo f49830e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f49831f;

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
                this.f49831f = dVar;
                this.f49830e = imageFileInfo;
            }

            @Override // c.a.s0.c0.b
            public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                    this.f49831f.e(this.f49830e, aVar);
                    this.f49831f.f49826c.setVisibility(8);
                    if (this.f49831f.f49828e.p != null) {
                        this.f49831f.f49828e.p.n();
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
            this.f49828e = multiImagePagerAdapter;
            this.f49826c = null;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(multiImagePagerAdapter.f49817e.getPageContext().getContext()).inflate(h.progress_tb_imageview, (ViewGroup) null);
            this.a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(g.progress_tb_imageview);
            this.f49825b = tbImageView;
            tbImageView.setClickable(true);
            this.f49825b.setDefaultResource(0);
            this.f49825b.setDefaultBgResource(0);
            this.f49825b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f49825b.setPadding(0, 0, 0, 0);
            this.f49827d = new c.a.s0.d0.b();
            this.f49825b.setOnClickListener(new a(this, multiImagePagerAdapter));
            ProgressBar progressBar = (ProgressBar) this.a.findViewById(g.progress_tb_imageview_progress);
            this.f49826c = progressBar;
            progressBar.setVisibility(8);
        }

        public void d() {
            c.a.s0.d0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f49827d) == null) {
                return;
            }
            bVar.b();
        }

        public final void e(ImageFileInfo imageFileInfo, c.a.d.n.d.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, aVar) == null) || aVar == null || this.f49825b == null) {
                return;
            }
            int[] l = n.l(aVar.r(), aVar.m(), n.k(this.f49828e.f49817e), (n.i(this.f49828e.f49817e) - n.f(this.f49828e.f49817e, e.ds418)) - UtilHelper.getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f49825b.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = l[0];
            layoutParams.height = l[1];
            this.f49825b.setLayoutParams(layoutParams);
            aVar.h(this.f49825b);
            if (this.f49828e.p != null && this.f49828e.p.f21390f != null && imageFileInfo != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f49828e.p.f21390f.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.width = l[0];
                layoutParams2.height = l[1];
                this.f49828e.p.f21390f.setLayoutParams(layoutParams2);
            }
            if (aVar.p() == null || aVar.p().isRecycled()) {
                return;
            }
            this.f49828e.r = aVar.p();
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
            this.f49826c.setVisibility(0);
            c.a.d.n.d.a c2 = this.f49827d.c(imageFileInfo, false);
            if (c2 != null) {
                e(imageFileInfo, c2);
                this.f49826c.setVisibility(8);
                return;
            }
            this.f49827d.d(imageFileInfo, new b(this, imageFileInfo), false);
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49826c.getVisibility() != 0 : invokeV.booleanValue;
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
        this.f49817e = null;
        this.f49818f = null;
        this.f49819g = null;
        this.f49820h = null;
        this.f49821i = 0;
        this.f49822j = 0;
        this.k = null;
        this.m = new LinkedList<>();
        this.n = 120;
        this.o = 120;
        this.s = z;
        this.f49817e = writeMultiImgsActivity;
        this.p = jVar;
        this.n = (int) writeMultiImgsActivity.getResources().getDimension(e.ds720);
        this.o = (int) writeMultiImgsActivity.getResources().getDimension(e.ds1280);
        this.f49822j = l(linkedList, i2);
        int size = this.m.size();
        this.f49821i = size;
        this.f49818f = new ImageFileInfo[size];
        this.k = new d[size];
        for (int i5 = 0; i5 < this.f49821i; i5++) {
            this.f49818f[i5] = this.m.get(i5).cloneWithoutFilterAction(true);
            this.f49818f[i5].addPageAction(c.a.s0.d0.i.d.g(this.n, this.o));
            linkedList.set(linkedList.indexOf(this.m.get(i5)), this.f49818f[i5]);
            this.f49818f[i5].mCount = 0;
        }
        this.f49819g = viewPager;
        this.f49820h = cVar;
        viewPager.setOffscreenPageLimit(1);
        this.f49819g.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            this.f49819g.removeView(this.k[i2].f());
        }
    }

    public void g(boolean z) {
        j jVar;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f49818f == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ImageFileInfo[] imageFileInfoArr = this.f49818f;
            if (i2 >= imageFileInfoArr.length) {
                break;
            }
            ImageFileInfo imageFileInfo = imageFileInfoArr[i2];
            if (imageFileInfo != null) {
                imageFileInfoArr[i2].applayRotatePageActionToPersistAction(imageFileInfo);
            }
            i2++;
        }
        if (!h()) {
            if (z || !this.s) {
                return;
            }
            n(this.r);
            return;
        }
        c cVar = this.f49820h;
        if (cVar != null && cVar.c() && (jVar = this.p) != null && (stickerLayout = jVar.f21390f) != null) {
            stickerLayout.redraw();
            TbImageView tbImageView = this.k[this.f49822j].f49825b;
            try {
                bitmap = this.p.f21390f.generateCombinedBitmap();
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
            this.f49818f[this.f49822j].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), f2, 100));
            this.f49818f[this.f49822j].setContentUriStr(null);
            this.f49818f[this.f49822j].clearAllActions();
            this.f49818f[this.f49822j].clearPageActions();
            this.f49818f[this.f49822j].setIsGif(false);
            if (z || !this.s) {
                return;
            }
            n(f2);
        } else if (z || !this.s) {
        } else {
            n(this.r);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49821i : invokeV.intValue;
    }

    public int getFixedCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49822j : invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        int i2;
        ImageFileInfo[] imageFileInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d[] dVarArr = this.k;
            return (dVarArr == null || (i2 = this.f49822j) >= dVarArr.length || dVarArr[i2] == null || (imageFileInfoArr = this.f49818f) == null || i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void i(int i2, boolean z) {
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (judgeVaild()) {
                c cVar = this.f49820h;
                if (cVar != null) {
                    cVar.b(i2, z);
                }
            } else if (z) {
                o(i2);
            } else if (h()) {
                d[] dVarArr = this.k;
                int i3 = this.f49822j;
                d dVar = dVarArr[i3];
                if (dVar == null || (imageFileInfo = this.f49818f[i3]) == null || !dVar.h()) {
                    return;
                }
                imageFileInfo.addPageAction(c.a.s0.d0.i.e.e(i2));
                this.f49817e.addAction();
                dVar.g(imageFileInfo);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            d[] dVarArr = this.k;
            if (dVarArr[i2] == null) {
                dVarArr[i2] = new d(this, i2);
            }
            this.f49819g.addView(this.k[i2].f());
            return this.k[i2].f();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f49822j : invokeV.intValue;
    }

    public boolean judgeVaild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f49822j;
            ImageFileInfo[] imageFileInfoArr = this.f49818f;
            if (i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null || !imageFileInfoArr[i2].isGif()) {
                return false;
            }
            ImageFileInfo[] imageFileInfoArr2 = this.f49818f;
            int i3 = this.f49822j;
            if (imageFileInfoArr2[i3].mCount > 0) {
                return false;
            }
            imageFileInfoArr2[i3].mCount++;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        int i2;
        d[] dVarArr;
        d[] dVarArr2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (i2 = this.f49822j) < 0 || (dVarArr = this.k) == null || i2 >= dVarArr.length) {
            return;
        }
        ImageFileInfo[] imageFileInfoArr = this.f49818f;
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
        int i4 = this.f49822j;
        if (dVarArr2[i4] == null) {
            dVarArr2[i4] = new d(this, i4);
        }
        d[] dVarArr3 = this.k;
        int i5 = this.f49822j;
        dVarArr3[i5].g(this.f49818f[i5]);
    }

    public final int l(LinkedList<ImageFileInfo> linkedList, int i2) {
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

    public final boolean m(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, bitmap)) == null) {
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

    public final void n(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bitmap) == null) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Date date = new Date();
        String str = "tieba" + String.valueOf(date.getTime()) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
        if (m(str, bitmap)) {
            this.f49818f[0].setExtra(str);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l = i2;
            if (this.q == null) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f49817e);
                this.q = aVar;
                aVar.setMessageId(c.a.t0.p4.j.rorate_tip);
                this.q.setPositiveButton(c.a.t0.p4.j.alert_yes_button, new a(this));
                this.q.setNegativeButton(c.a.t0.p4.j.cancel, new b(this));
                this.q.create(this.f49817e.getPageContext());
            }
            this.q.show();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f49822j = i2;
            k();
        }
    }
}

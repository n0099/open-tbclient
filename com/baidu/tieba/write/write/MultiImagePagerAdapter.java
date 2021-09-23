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
import c.a.e.e.p.l;
import c.a.q0.d0.i.e;
import c.a.q0.d1.k;
import c.a.q0.s.s.a;
import c.a.r0.c4.u.j;
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
/* loaded from: classes7.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public WriteMultiImgsActivity f59077e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo[] f59078f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f59079g;

    /* renamed from: h  reason: collision with root package name */
    public c f59080h;

    /* renamed from: i  reason: collision with root package name */
    public int f59081i;

    /* renamed from: j  reason: collision with root package name */
    public int f59082j;
    public d[] k;
    public int l;
    public LinkedList<ImageFileInfo> m;
    public int n;
    public int o;
    public j p;
    public c.a.q0.s.s.a q;
    public Bitmap r;
    public boolean s;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f59083e;

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1809a implements c.a.r0.c4.u.n.b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f59084a;

            public C1809a(a aVar) {
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
                this.f59084a = aVar;
            }

            @Override // c.a.r0.c4.u.n.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59084a.f59083e.f59080h.a();
                }
            }

            @Override // c.a.r0.c4.u.n.b.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // c.a.r0.c4.u.n.b.c
            public boolean c(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // c.a.r0.c4.u.n.b.c
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
            this.f59083e = multiImagePagerAdapter;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f59083e.q != null) {
                    this.f59083e.q.dismiss();
                }
                this.f59083e.p.f16982f.removeAllSticker(new C1809a(this));
                MultiImagePagerAdapter multiImagePagerAdapter = this.f59083e;
                multiImagePagerAdapter.i(multiImagePagerAdapter.l, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f59085e;

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
            this.f59085e = multiImagePagerAdapter;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f59085e.q == null) {
                return;
            }
            this.f59085e.q.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();

        void b(int i2, boolean z);

        boolean c();

        void d();
    }

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f59086a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f59087b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f59088c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.q0.d0.b f59089d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImagePagerAdapter f59090e;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f59091e;

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
                this.f59091e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59091e.f59090e.f59080h == null) {
                    return;
                }
                this.f59091e.f59090e.f59080h.d();
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c.a.q0.c0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageFileInfo f59092e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f59093f;

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
                this.f59093f = dVar;
                this.f59092e = imageFileInfo;
            }

            @Override // c.a.q0.c0.b
            public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                    this.f59093f.e(this.f59092e, aVar);
                    this.f59093f.f59088c.setVisibility(8);
                    if (this.f59093f.f59090e.p != null) {
                        this.f59093f.f59090e.p.n();
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
            this.f59090e = multiImagePagerAdapter;
            this.f59088c = null;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(multiImagePagerAdapter.f59077e.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.f59086a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.progress_tb_imageview);
            this.f59087b = tbImageView;
            tbImageView.setClickable(true);
            this.f59087b.setDefaultResource(0);
            this.f59087b.setDefaultBgResource(0);
            this.f59087b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f59087b.setPadding(0, 0, 0, 0);
            this.f59089d = new c.a.q0.d0.b();
            this.f59087b.setOnClickListener(new a(this, multiImagePagerAdapter));
            ProgressBar progressBar = (ProgressBar) this.f59086a.findViewById(R.id.progress_tb_imageview_progress);
            this.f59088c = progressBar;
            progressBar.setVisibility(8);
        }

        public void d() {
            c.a.q0.d0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f59089d) == null) {
                return;
            }
            bVar.b();
        }

        public final void e(ImageFileInfo imageFileInfo, c.a.e.l.d.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, aVar) == null) || aVar == null || this.f59087b == null) {
                return;
            }
            int[] l = l.l(aVar.r(), aVar.m(), l.k(this.f59090e.f59077e), (l.i(this.f59090e.f59077e) - l.g(this.f59090e.f59077e, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f59087b.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = l[0];
            layoutParams.height = l[1];
            this.f59087b.setLayoutParams(layoutParams);
            aVar.h(this.f59087b);
            if (this.f59090e.p != null && this.f59090e.p.f16982f != null && imageFileInfo != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f59090e.p.f16982f.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.width = l[0];
                layoutParams2.height = l[1];
                this.f59090e.p.f16982f.setLayoutParams(layoutParams2);
            }
            if (aVar.p() == null || aVar.p().isRecycled()) {
                return;
            }
            this.f59090e.r = aVar.p();
        }

        public View f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59086a : (View) invokeV.objValue;
        }

        public void g(ImageFileInfo imageFileInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, imageFileInfo) == null) || imageFileInfo == null) {
                return;
            }
            d();
            this.f59088c.setVisibility(0);
            c.a.e.l.d.a c2 = this.f59089d.c(imageFileInfo, false);
            if (c2 != null) {
                e(imageFileInfo, c2);
                this.f59088c.setVisibility(8);
                return;
            }
            this.f59089d.d(imageFileInfo, new b(this, imageFileInfo), false);
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59088c.getVisibility() != 0 : invokeV.booleanValue;
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
        this.f59077e = null;
        this.f59078f = null;
        this.f59079g = null;
        this.f59080h = null;
        this.f59081i = 0;
        this.f59082j = 0;
        this.k = null;
        this.m = new LinkedList<>();
        this.n = 120;
        this.o = 120;
        this.s = z;
        this.f59077e = writeMultiImgsActivity;
        this.p = jVar;
        this.n = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.o = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.f59082j = l(linkedList, i2);
        int size = this.m.size();
        this.f59081i = size;
        this.f59078f = new ImageFileInfo[size];
        this.k = new d[size];
        for (int i5 = 0; i5 < this.f59081i; i5++) {
            this.f59078f[i5] = this.m.get(i5).cloneWithoutFilterAction(true);
            this.f59078f[i5].addPageAction(c.a.q0.d0.i.d.g(this.n, this.o));
            linkedList.set(linkedList.indexOf(this.m.get(i5)), this.f59078f[i5]);
            this.f59078f[i5].mCount = 0;
        }
        this.f59079g = viewPager;
        this.f59080h = cVar;
        viewPager.setOffscreenPageLimit(1);
        this.f59079g.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            this.f59079g.removeView(this.k[i2].f());
        }
    }

    public void g(boolean z) {
        j jVar;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f59078f == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ImageFileInfo[] imageFileInfoArr = this.f59078f;
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
        c cVar = this.f59080h;
        if (cVar != null && cVar.c() && (jVar = this.p) != null && (stickerLayout = jVar.f16982f) != null) {
            stickerLayout.redraw();
            TbImageView tbImageView = this.k[this.f59082j].f59087b;
            try {
                bitmap = this.p.f16982f.generateCombinedBitmap();
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                return;
            }
            try {
                bitmap2 = k.c(tbImageView);
            } catch (OutOfMemoryError unused2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap2 = null;
                if (bitmap != null) {
                    return;
                }
                return;
            }
            if (bitmap != null || bitmap2 == null || (f2 = k.f(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) == null) {
                return;
            }
            this.f59078f[this.f59082j].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), f2, 100));
            this.f59078f[this.f59082j].setContentUriStr(null);
            this.f59078f[this.f59082j].clearAllActions();
            this.f59078f[this.f59082j].clearPageActions();
            this.f59078f[this.f59082j].setIsGif(false);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59081i : invokeV.intValue;
    }

    public int getFixedCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59082j : invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        int i2;
        ImageFileInfo[] imageFileInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d[] dVarArr = this.k;
            return (dVarArr == null || (i2 = this.f59082j) >= dVarArr.length || dVarArr[i2] == null || (imageFileInfoArr = this.f59078f) == null || i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void i(int i2, boolean z) {
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (judgeVaild()) {
                c cVar = this.f59080h;
                if (cVar != null) {
                    cVar.b(i2, z);
                }
            } else if (z) {
                o(i2);
            } else if (h()) {
                d[] dVarArr = this.k;
                int i3 = this.f59082j;
                d dVar = dVarArr[i3];
                if (dVar == null || (imageFileInfo = this.f59078f[i3]) == null || !dVar.h()) {
                    return;
                }
                imageFileInfo.addPageAction(e.e(i2));
                this.f59077e.addAction();
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
            this.f59079g.addView(this.k[i2].f());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59082j : invokeV.intValue;
    }

    public boolean judgeVaild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f59082j;
            ImageFileInfo[] imageFileInfoArr = this.f59078f;
            if (i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null || !imageFileInfoArr[i2].isGif()) {
                return false;
            }
            ImageFileInfo[] imageFileInfoArr2 = this.f59078f;
            int i3 = this.f59082j;
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (i2 = this.f59082j) < 0 || (dVarArr = this.k) == null || i2 >= dVarArr.length) {
            return;
        }
        ImageFileInfo[] imageFileInfoArr = this.f59078f;
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
        int i4 = this.f59082j;
        if (dVarArr2[i4] == null) {
            dVarArr2[i4] = new d(this, i4);
        }
        d[] dVarArr3 = this.k;
        int i5 = this.f59082j;
        dVarArr3[i5].g(this.f59078f[i5]);
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

    public final void n(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bitmap) == null) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Date date = new Date();
        String str = "tieba" + String.valueOf(date.getTime()) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
        if (m(str, bitmap)) {
            this.f59078f[0].extra = str;
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l = i2;
            if (this.q == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f59077e);
                this.q = aVar;
                aVar.setMessageId(R.string.rorate_tip);
                this.q.setPositiveButton(R.string.alert_yes_button, new a(this));
                this.q.setNegativeButton(R.string.cancel, new b(this));
                this.q.create(this.f59077e.getPageContext());
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
            this.f59082j = i2;
            k();
        }
    }
}

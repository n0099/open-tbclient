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
import com.repackage.dq4;
import com.repackage.ex8;
import com.repackage.g35;
import com.repackage.h35;
import com.repackage.li;
import com.repackage.lx8;
import com.repackage.mb5;
import com.repackage.t25;
import com.repackage.um;
import com.repackage.x25;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WriteMultiImgsActivity a;
    public ImageFileInfo[] b;
    public ViewPager c;
    public c d;
    public int e;
    public int f;
    public d[] g;
    public int h;
    public LinkedList<ImageFileInfo> i;
    public int j;
    public int k;
    public ex8 l;
    public dq4 m;
    public Bitmap n;
    public boolean o;

    /* loaded from: classes4.dex */
    public class a implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImagePagerAdapter a;

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0240a implements lx8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0240a(a aVar) {
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

            @Override // com.repackage.lx8
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.d.a();
                }
            }

            @Override // com.repackage.lx8
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.repackage.lx8
            public boolean c(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.repackage.lx8
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                if (this.a.m != null) {
                    this.a.m.dismiss();
                }
                this.a.l.f.f(new C0240a(this));
                MultiImagePagerAdapter multiImagePagerAdapter = this.a;
                multiImagePagerAdapter.j(multiImagePagerAdapter.h, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || this.a.m == null) {
                return;
            }
            this.a.m.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b(int i, boolean z);

        boolean c();

        void d();
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;
        public TbImageView b;
        public ProgressBar c;
        public x25 d;
        public final /* synthetic */ MultiImagePagerAdapter e;

        /* loaded from: classes4.dex */
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e.d == null) {
                    return;
                }
                this.a.e.d.d();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements t25 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageFileInfo a;
            public final /* synthetic */ d b;

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
                this.b = dVar;
                this.a = imageFileInfo;
            }

            @Override // com.repackage.t25
            public void a(um umVar, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLZ(1048576, this, umVar, str, z) == null) {
                    this.b.e(this.a, umVar);
                    this.b.c.setVisibility(8);
                    if (this.b.e.l != null) {
                        this.b.e.l.n();
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
            this.e = multiImagePagerAdapter;
            this.c = null;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(multiImagePagerAdapter.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d06f1, (ViewGroup) null);
            this.a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091932);
            this.b = tbImageView;
            tbImageView.setClickable(true);
            this.b.setDefaultResource(0);
            this.b.setDefaultBgResource(0);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b.setPadding(0, 0, 0, 0);
            this.d = new x25();
            this.b.setOnClickListener(new a(this, multiImagePagerAdapter));
            ProgressBar progressBar = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091933);
            this.c = progressBar;
            progressBar.setVisibility(8);
        }

        public void d() {
            x25 x25Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (x25Var = this.d) == null) {
                return;
            }
            x25Var.b();
        }

        public final void e(ImageFileInfo imageFileInfo, um umVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, umVar) == null) || umVar == null || this.b == null) {
                return;
            }
            int[] l = li.l(umVar.r(), umVar.m(), li.k(this.e.a), (li.i(this.e.a) - li.f(this.e.a, R.dimen.obfuscated_res_0x7f0702c0)) - UtilHelper.getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = l[0];
            layoutParams.height = l[1];
            this.b.setLayoutParams(layoutParams);
            umVar.h(this.b);
            if (this.e.l != null && this.e.l.f != null && imageFileInfo != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e.l.f.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.width = l[0];
                layoutParams2.height = l[1];
                this.e.l.f.setLayoutParams(layoutParams2);
            }
            if (umVar.p() == null || umVar.p().isRecycled()) {
                return;
            }
            this.e.n = umVar.p();
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
            this.c.setVisibility(0);
            um c = this.d.c(imageFileInfo, false);
            if (c != null) {
                e(imageFileInfo, c);
                this.c.setVisibility(8);
                return;
            }
            this.d.d(imageFileInfo, new b(this, imageFileInfo), false);
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.getVisibility() != 0 : invokeV.booleanValue;
        }
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, c cVar, ex8 ex8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeMultiImgsActivity, viewPager, linkedList, Integer.valueOf(i), cVar, ex8Var, Boolean.valueOf(z)};
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.i = new LinkedList<>();
        this.j = 120;
        this.k = 120;
        this.o = z;
        this.a = writeMultiImgsActivity;
        this.l = ex8Var;
        this.j = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702fd);
        this.k = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070243);
        this.f = o(linkedList, i);
        int size = this.i.size();
        this.e = size;
        this.b = new ImageFileInfo[size];
        this.g = new d[size];
        for (int i4 = 0; i4 < this.e; i4++) {
            this.b[i4] = this.i.get(i4).cloneWithoutFilterAction(true);
            this.b[i4].addPageAction(g35.g(this.j, this.k));
            linkedList.set(linkedList.indexOf(this.i.get(i4)), this.b[i4]);
            this.b[i4].mCount = 0;
        }
        this.c = viewPager;
        this.d = cVar;
        viewPager.setOffscreenPageLimit(1);
        this.c.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
            this.c.removeView(this.g[i].f());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : invokeV.intValue;
    }

    public void h(boolean z) {
        ex8 ex8Var;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.b == null) {
            return;
        }
        int i = 0;
        while (true) {
            ImageFileInfo[] imageFileInfoArr = this.b;
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
            r(this.n);
            return;
        }
        c cVar = this.d;
        if (cVar != null && cVar.c() && (ex8Var = this.l) != null && (stickerLayout = ex8Var.f) != null) {
            stickerLayout.e();
            TbImageView tbImageView = this.g[this.f].b;
            try {
                bitmap = this.l.f.c();
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                return;
            }
            try {
                bitmap2 = mb5.c(tbImageView);
            } catch (OutOfMemoryError unused2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap2 = null;
                if (bitmap != null) {
                    return;
                }
                return;
            }
            if (bitmap != null || bitmap2 == null || (f = mb5.f(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) == null) {
                return;
            }
            this.b[this.f].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), f, 100));
            this.b[this.f].setContentUriStr(null);
            this.b[this.f].clearAllActions();
            this.b[this.f].clearPageActions();
            this.b[this.f].setIsGif(false);
            if (z || !this.o) {
                return;
            }
            r(f);
        } else if (z || !this.o) {
        } else {
            r(this.n);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        int i;
        ImageFileInfo[] imageFileInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d[] dVarArr = this.g;
            return (dVarArr == null || (i = this.f) >= dVarArr.length || dVarArr[i] == null || (imageFileInfoArr = this.b) == null || i >= imageFileInfoArr.length || imageFileInfoArr[i] == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            d[] dVarArr = this.g;
            if (dVarArr[i] == null) {
                dVarArr[i] = new d(this, i);
            }
            this.c.addView(this.g[i].f());
            return this.g[i].f();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public void j(int i, boolean z) {
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (m()) {
                c cVar = this.d;
                if (cVar != null) {
                    cVar.b(i, z);
                }
            } else if (z) {
                s(i);
            } else if (i()) {
                d[] dVarArr = this.g;
                int i2 = this.f;
                d dVar = dVarArr[i2];
                if (dVar == null || (imageFileInfo = this.b[i2]) == null || !dVar.h()) {
                    return;
                }
                imageFileInfo.addPageAction(h35.e(i));
                this.a.addAction();
                dVar.g(imageFileInfo);
            }
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.f;
            ImageFileInfo[] imageFileInfoArr = this.b;
            if (i >= imageFileInfoArr.length || imageFileInfoArr[i] == null || !imageFileInfoArr[i].isGif()) {
                return false;
            }
            ImageFileInfo[] imageFileInfoArr2 = this.b;
            int i2 = this.f;
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (i = this.f) < 0 || (dVarArr = this.g) == null || i >= dVarArr.length) {
            return;
        }
        ImageFileInfo[] imageFileInfoArr = this.b;
        if (i >= imageFileInfoArr.length || imageFileInfoArr[i] == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            dVarArr2 = this.g;
            if (i2 >= dVarArr2.length) {
                break;
            }
            if (dVarArr2[i2] != null) {
                dVarArr2[i2].d();
            }
            i2++;
        }
        int i3 = this.f;
        if (dVarArr2[i3] == null) {
            dVarArr2[i3] = new d(this, i3);
        }
        d[] dVarArr3 = this.g;
        int i4 = this.f;
        dVarArr3[i4].g(this.b[i4]);
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
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f = i;
            n();
        }
    }

    public final boolean q(String str, Bitmap bitmap) {
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
            } catch (Exception e) {
                BdLog.e(e.toString());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void r(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, bitmap) == null) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Date date = new Date();
        String str = "tieba" + String.valueOf(date.getTime()) + ".jpg";
        if (q(str, bitmap)) {
            this.b[0].setExtra(str);
        }
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.h = i;
            if (this.m == null) {
                dq4 dq4Var = new dq4(this.a);
                this.m = dq4Var;
                dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0ff0);
                this.m.setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new a(this));
                this.m.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this));
                this.m.create(this.a.getPageContext());
            }
            this.m.show();
        }
    }
}

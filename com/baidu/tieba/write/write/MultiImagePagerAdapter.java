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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aj5;
import com.baidu.tieba.kdb;
import com.baidu.tieba.kj5;
import com.baidu.tieba.lj5;
import com.baidu.tieba.qgb;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.tieba.ws5;
import com.baidu.tieba.xi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WriteMultiImgsActivity a;
    public ImageFileInfo[] b;
    public ViewPager c;
    public b d;
    public int e;
    public int f;
    public c[] g;
    public int h;
    public LinkedList<ImageFileInfo> i;
    public int j;
    public int k;
    public kdb l;
    public Bitmap m;
    public boolean n;

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b(int i, boolean z);

        boolean c();

        void d();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
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

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImagePagerAdapter a;

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0522a implements qgb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // com.baidu.tieba.qgb
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.tieba.qgb
            public boolean c(Bitmap bitmap) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.tieba.qgb
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                }
            }

            public C0522a(a aVar) {
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

            @Override // com.baidu.tieba.qgb
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.d.a();
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.f.f(new C0522a(this));
                MultiImagePagerAdapter multiImagePagerAdapter = this.a;
                multiImagePagerAdapter.i(multiImagePagerAdapter.h, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;
        public TbImageView b;
        public ProgressBar c;
        public aj5 d;
        public final /* synthetic */ MultiImagePagerAdapter e;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar, MultiImagePagerAdapter multiImagePagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, multiImagePagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e.d != null) {
                    this.a.e.d.d();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements xi5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageFileInfo a;
            public final /* synthetic */ c b;

            public b(c cVar, ImageFileInfo imageFileInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, imageFileInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = imageFileInfo;
            }

            @Override // com.baidu.tieba.xi5
            public void a(BdImage bdImage, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLLZ(1048576, this, bdImage, str, z) != null) {
                    return;
                }
                this.b.e(this.a, bdImage);
                this.b.c.setVisibility(8);
                if (this.b.e.l != null) {
                    this.b.e.l.n();
                }
            }
        }

        public c(MultiImagePagerAdapter multiImagePagerAdapter, int i) {
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
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(multiImagePagerAdapter.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0843, (ViewGroup) null);
            this.a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091df1);
            this.b = tbImageView;
            tbImageView.setClickable(true);
            this.b.setDefaultResource(0);
            this.b.setDefaultBgResource(0);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b.setPadding(0, 0, 0, 0);
            this.d = new aj5();
            this.b.setOnClickListener(new a(this, multiImagePagerAdapter));
            ProgressBar progressBar = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091df2);
            this.c = progressBar;
            progressBar.setVisibility(8);
        }

        public final void e(ImageFileInfo imageFileInfo, BdImage bdImage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, bdImage) == null) && bdImage != null && this.b != null) {
                int[] imageResize = BdUtilHelper.getImageResize(bdImage.getWidth(), bdImage.getHeight(), BdUtilHelper.getEquipmentWidth(this.e.a), (BdUtilHelper.getEquipmentHeight(this.e.a) - BdUtilHelper.getDimens(this.e.a, R.dimen.obfuscated_res_0x7f0703d7)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.b.setLayoutParams(layoutParams);
                bdImage.drawImageTo(this.b);
                if (this.e.l != null && this.e.l.f != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e.l.f.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    this.e.l.f.setLayoutParams(layoutParams2);
                }
                if (bdImage.getRawBitmap() != null && !bdImage.getRawBitmap().isRecycled()) {
                    this.e.m = bdImage.getRawBitmap();
                }
            }
        }

        public void d() {
            aj5 aj5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aj5Var = this.d) != null) {
                aj5Var.b();
            }
        }

        public View f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (View) invokeV.objValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.c.getVisibility() != 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void g(ImageFileInfo imageFileInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, imageFileInfo) != null) || imageFileInfo == null) {
                return;
            }
            d();
            this.c.setVisibility(0);
            BdImage c = this.d.c(imageFileInfo, false);
            if (c != null) {
                e(imageFileInfo, c);
                this.c.setVisibility(8);
                return;
            }
            this.d.d(imageFileInfo, new b(this, imageFileInfo), false);
        }
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, b bVar, kdb kdbVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeMultiImgsActivity, viewPager, linkedList, Integer.valueOf(i), bVar, kdbVar, Boolean.valueOf(z)};
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
        this.n = z;
        this.a = writeMultiImgsActivity;
        this.l = kdbVar;
        this.j = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070414);
        this.k = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070368);
        this.f = o(linkedList, i);
        int size = this.i.size();
        this.e = size;
        this.b = new ImageFileInfo[size];
        this.g = new c[size];
        for (int i4 = 0; i4 < this.e; i4++) {
            this.b[i4] = this.i.get(i4).cloneWithoutFilterAction(true);
            this.b[i4].addPageAction(kj5.g(this.j, this.k));
            linkedList.set(linkedList.indexOf(this.i.get(i4)), this.b[i4]);
            this.b[i4].mCount = 0;
        }
        this.c = viewPager;
        this.d = bVar;
        viewPager.setOffscreenPageLimit(1);
        this.c.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f = i;
            n();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
            this.c.removeView(this.g[i].f());
        }
    }

    public void g(boolean z) {
        kdb kdbVar;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.b == null) {
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
        if (!h()) {
            if (!z && this.n) {
                q(this.m);
                return;
            }
            return;
        }
        b bVar = this.d;
        if (bVar != null && bVar.c() && (kdbVar = this.l) != null && (stickerLayout = kdbVar.f) != null) {
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
                bitmap2 = ws5.c(tbImageView);
            } catch (OutOfMemoryError unused2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap2 = null;
                if (bitmap != null) {
                    return;
                }
                return;
            }
            if (bitmap != null || bitmap2 == null || (f = ws5.f(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) == null) {
                return;
            }
            this.b[this.f].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), f, 100));
            this.b[this.f].setContentUriStr(null);
            this.b[this.f].clearAllActions();
            this.b[this.f].clearPageActions();
            this.b[this.f].setIsGif(false);
            if (!z && this.n) {
                q(f);
            }
        } else if (!z && this.n) {
            q(this.m);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        int i;
        ImageFileInfo[] imageFileInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c[] cVarArr = this.g;
            if (cVarArr != null && (i = this.f) < cVarArr.length && cVarArr[i] != null && (imageFileInfoArr = this.b) != null && i < imageFileInfoArr.length && imageFileInfoArr[i] != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public void i(int i, boolean z) {
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (m()) {
                b bVar = this.d;
                if (bVar != null) {
                    bVar.b(i, z);
                }
            } else if (z) {
                r(i);
            } else if (!h()) {
            } else {
                c[] cVarArr = this.g;
                int i2 = this.f;
                c cVar = cVarArr[i2];
                if (cVar != null && (imageFileInfo = this.b[i2]) != null && cVar.h()) {
                    imageFileInfo.addPageAction(lj5.e(i));
                    this.a.L0();
                    cVar.g(imageFileInfo);
                }
            }
        }
    }

    public final int o(LinkedList<ImageFileInfo> linkedList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, linkedList, i)) == null) {
            if (linkedList != null && i >= 0 && i < linkedList.size()) {
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
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            c[] cVarArr = this.g;
            if (cVarArr[i] == null) {
                cVarArr[i] = new c(this, i);
            }
            this.c.addView(this.g[i].f());
            return this.g[i].f();
        }
        return invokeLI.objValue;
    }

    public final boolean p(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, bitmap)) == null) {
            try {
                FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
                Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
                if (resizeBitmap != null) {
                    if (FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.toString());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.f;
            ImageFileInfo[] imageFileInfoArr = this.b;
            if (i < imageFileInfoArr.length && imageFileInfoArr[i] != null && imageFileInfoArr[i].isGif()) {
                ImageFileInfo[] imageFileInfoArr2 = this.b;
                int i2 = this.f;
                if (imageFileInfoArr2[i2].mCount <= 0) {
                    imageFileInfoArr2[i2].mCount++;
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        int i;
        c[] cVarArr;
        c[] cVarArr2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (i = this.f) >= 0 && (cVarArr = this.g) != null && i < cVarArr.length) {
            ImageFileInfo[] imageFileInfoArr = this.b;
            if (i < imageFileInfoArr.length && imageFileInfoArr[i] != null) {
                int i2 = 0;
                while (true) {
                    cVarArr2 = this.g;
                    if (i2 >= cVarArr2.length) {
                        break;
                    }
                    if (cVarArr2[i2] != null) {
                        cVarArr2[i2].d();
                    }
                    i2++;
                }
                int i3 = this.f;
                if (cVarArr2[i3] == null) {
                    cVarArr2[i3] = new c(this, i3);
                }
                c[] cVarArr3 = this.g;
                int i4 = this.f;
                cVarArr3[i4].g(this.b[i4]);
            }
        }
    }

    public final void q(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bitmap) == null) && bitmap != null && !bitmap.isRecycled()) {
            Date date = new Date();
            String str = "tieba" + String.valueOf(date.getTime()) + ".jpg";
            if (p(str, bitmap)) {
                this.b[0].setExtra(str);
            }
        }
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.h = i;
            new TBAlertBuilder(this.a).setTitle(R.string.obfuscated_res_0x7f0f10e3).setDesc(R.string.obfuscated_res_0x7f0f12a8).setOperateBtn(new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.obfuscated_res_0x7f0f03d3), TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.alert_yes_button), TBAlertConfig.OperateBtnStyle.MAIN, new a(this))).setAutoClose().show();
        }
    }
}

package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import d.a.c.e.p.l;
import d.a.i0.b0.g.e;
import d.a.i0.r.s.a;
import d.a.i0.z0.h;
import d.a.j0.v3.u.j;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public WriteMultiImgsActivity f22811e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo[] f22812f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f22813g;

    /* renamed from: h  reason: collision with root package name */
    public c f22814h;

    /* renamed from: i  reason: collision with root package name */
    public int f22815i;
    public int j;
    public d[] k;
    public int l;
    public LinkedList<ImageFileInfo> m = new LinkedList<>();
    public int n;
    public int o;
    public j p;
    public d.a.i0.r.s.a q;
    public Bitmap r;
    public boolean s;

    /* loaded from: classes5.dex */
    public class a implements a.e {

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0230a implements d.a.j0.v3.u.n.b.c {
            public C0230a() {
            }

            @Override // d.a.j0.v3.u.n.b.c
            public void a() {
                MultiImagePagerAdapter.this.f22814h.a();
            }

            @Override // d.a.j0.v3.u.n.b.c
            public void b() {
            }

            @Override // d.a.j0.v3.u.n.b.c
            public boolean c(Bitmap bitmap) {
                return false;
            }

            @Override // d.a.j0.v3.u.n.b.c
            public void d() {
            }
        }

        public a() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (MultiImagePagerAdapter.this.q != null) {
                MultiImagePagerAdapter.this.q.dismiss();
            }
            MultiImagePagerAdapter.this.p.f62218f.f(new C0230a());
            MultiImagePagerAdapter multiImagePagerAdapter = MultiImagePagerAdapter.this;
            multiImagePagerAdapter.j(multiImagePagerAdapter.l, false);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (MultiImagePagerAdapter.this.q != null) {
                MultiImagePagerAdapter.this.q.dismiss();
            }
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

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f22819a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f22820b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f22821c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.i0.b0.b f22822d;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a(MultiImagePagerAdapter multiImagePagerAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MultiImagePagerAdapter.this.f22814h != null) {
                    MultiImagePagerAdapter.this.f22814h.d();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements d.a.i0.a0.b {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageFileInfo f22825e;

            public b(ImageFileInfo imageFileInfo) {
                this.f22825e = imageFileInfo;
            }

            @Override // d.a.i0.a0.b
            public void a(d.a.c.j.d.a aVar, String str, boolean z) {
                d.this.e(this.f22825e, aVar);
                d.this.f22821c.setVisibility(8);
                if (MultiImagePagerAdapter.this.p != null) {
                    MultiImagePagerAdapter.this.p.n();
                }
            }
        }

        public d(int i2) {
            this.f22821c = null;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.f22811e.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.f22819a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.progress_tb_imageview);
            this.f22820b = tbImageView;
            tbImageView.setClickable(true);
            this.f22820b.setDefaultResource(0);
            this.f22820b.setDefaultBgResource(0);
            this.f22820b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f22820b.setPadding(0, 0, 0, 0);
            this.f22822d = new d.a.i0.b0.b();
            this.f22820b.setOnClickListener(new a(MultiImagePagerAdapter.this));
            ProgressBar progressBar = (ProgressBar) this.f22819a.findViewById(R.id.progress_tb_imageview_progress);
            this.f22821c = progressBar;
            progressBar.setVisibility(8);
        }

        public void d() {
            d.a.i0.b0.b bVar = this.f22822d;
            if (bVar != null) {
                bVar.b();
            }
        }

        public final void e(ImageFileInfo imageFileInfo, d.a.c.j.d.a aVar) {
            if (aVar == null || this.f22820b == null) {
                return;
            }
            int[] l = l.l(aVar.r(), aVar.m(), l.k(MultiImagePagerAdapter.this.f22811e), (l.i(MultiImagePagerAdapter.this.f22811e) - l.g(MultiImagePagerAdapter.this.f22811e, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f22820b.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = l[0];
            layoutParams.height = l[1];
            this.f22820b.setLayoutParams(layoutParams);
            aVar.h(this.f22820b);
            if (MultiImagePagerAdapter.this.p != null && MultiImagePagerAdapter.this.p.f62218f != null && imageFileInfo != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.p.f62218f.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.width = l[0];
                layoutParams2.height = l[1];
                MultiImagePagerAdapter.this.p.f62218f.setLayoutParams(layoutParams2);
            }
            if (aVar.p() == null || aVar.p().isRecycled()) {
                return;
            }
            MultiImagePagerAdapter.this.r = aVar.p();
        }

        public View f() {
            return this.f22819a;
        }

        public void g(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return;
            }
            d();
            this.f22821c.setVisibility(0);
            d.a.c.j.d.a c2 = this.f22822d.c(imageFileInfo, false);
            if (c2 != null) {
                e(imageFileInfo, c2);
                this.f22821c.setVisibility(8);
                return;
            }
            this.f22822d.d(imageFileInfo, new b(imageFileInfo), false);
        }

        public boolean h() {
            return this.f22821c.getVisibility() != 0;
        }
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i2, c cVar, j jVar, boolean z) {
        this.f22811e = null;
        this.f22812f = null;
        this.f22813g = null;
        this.f22814h = null;
        this.f22815i = 0;
        this.j = 0;
        this.k = null;
        this.n = 120;
        this.o = 120;
        this.s = z;
        this.f22811e = writeMultiImgsActivity;
        this.p = jVar;
        this.n = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.o = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.j = o(linkedList, i2);
        int size = this.m.size();
        this.f22815i = size;
        this.f22812f = new ImageFileInfo[size];
        this.k = new d[size];
        for (int i3 = 0; i3 < this.f22815i; i3++) {
            this.f22812f[i3] = this.m.get(i3).cloneWithoutFilterAction(true);
            this.f22812f[i3].addPageAction(d.a.i0.b0.g.d.g(this.n, this.o));
            linkedList.set(linkedList.indexOf(this.m.get(i3)), this.f22812f[i3]);
            this.f22812f[i3].mCount = 0;
        }
        this.f22813g = viewPager;
        this.f22814h = cVar;
        viewPager.setOffscreenPageLimit(1);
        this.f22813g.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        this.f22813g.removeView(this.k[i2].f());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f22815i;
    }

    public void h(boolean z) {
        j jVar;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap c2;
        if (this.f22812f == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ImageFileInfo[] imageFileInfoArr = this.f22812f;
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
        c cVar = this.f22814h;
        if (cVar != null && cVar.c() && (jVar = this.p) != null && (stickerLayout = jVar.f62218f) != null) {
            stickerLayout.e();
            TbImageView tbImageView = this.k[this.j].f22820b;
            try {
                bitmap = this.p.f62218f.c();
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                return;
            }
            try {
                bitmap2 = h.a(tbImageView);
            } catch (OutOfMemoryError unused2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap2 = null;
                if (bitmap != null) {
                    return;
                }
                return;
            }
            if (bitmap != null || bitmap2 == null || (c2 = h.c(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) == null) {
                return;
            }
            this.f22812f[this.j].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), c2, 100));
            this.f22812f[this.j].setContentUriStr(null);
            this.f22812f[this.j].clearAllActions();
            this.f22812f[this.j].clearPageActions();
            this.f22812f[this.j].setIsGif(false);
            if (z || !this.s) {
                return;
            }
            q(c2);
        } else if (z || !this.s) {
        } else {
            q(this.r);
        }
    }

    public final boolean i() {
        int i2;
        ImageFileInfo[] imageFileInfoArr;
        d[] dVarArr = this.k;
        return (dVarArr == null || (i2 = this.j) >= dVarArr.length || dVarArr[i2] == null || (imageFileInfoArr = this.f22812f) == null || i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null) ? false : true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        d[] dVarArr = this.k;
        if (dVarArr[i2] == null) {
            dVarArr[i2] = new d(i2);
        }
        this.f22813g.addView(this.k[i2].f());
        return this.k[i2].f();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(int i2, boolean z) {
        ImageFileInfo imageFileInfo;
        if (m()) {
            c cVar = this.f22814h;
            if (cVar != null) {
                cVar.b(i2, z);
            }
        } else if (z) {
            r(i2);
        } else if (i()) {
            d[] dVarArr = this.k;
            int i3 = this.j;
            d dVar = dVarArr[i3];
            if (dVar == null || (imageFileInfo = this.f22812f[i3]) == null || !dVar.h()) {
                return;
            }
            imageFileInfo.addPageAction(e.e(i2));
            this.f22811e.addAction();
            dVar.g(imageFileInfo);
        }
    }

    public int k() {
        return this.j;
    }

    public int l() {
        return this.j;
    }

    public boolean m() {
        int i2 = this.j;
        ImageFileInfo[] imageFileInfoArr = this.f22812f;
        if (i2 >= imageFileInfoArr.length || imageFileInfoArr[i2] == null || !imageFileInfoArr[i2].isGif()) {
            return false;
        }
        ImageFileInfo[] imageFileInfoArr2 = this.f22812f;
        int i3 = this.j;
        if (imageFileInfoArr2[i3].mCount > 0) {
            return false;
        }
        imageFileInfoArr2[i3].mCount++;
        return true;
    }

    public final void n() {
        d[] dVarArr;
        d[] dVarArr2;
        int i2 = this.j;
        if (i2 < 0 || (dVarArr = this.k) == null || i2 >= dVarArr.length) {
            return;
        }
        ImageFileInfo[] imageFileInfoArr = this.f22812f;
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
            dVarArr2[i4] = new d(i4);
        }
        d[] dVarArr3 = this.k;
        int i5 = this.j;
        dVarArr3[i5].g(this.f22812f[i5]);
    }

    public final int o(LinkedList<ImageFileInfo> linkedList, int i2) {
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.j = i2;
        n();
    }

    public final boolean p(String str, Bitmap bitmap) {
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

    public final void q(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Date date = new Date();
        String str = "tieba" + String.valueOf(date.getTime()) + ".jpg";
        if (p(str, bitmap)) {
            this.f22812f[0].extra = str;
        }
    }

    public final void r(int i2) {
        this.l = i2;
        if (this.q == null) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f22811e);
            this.q = aVar;
            aVar.setMessageId(R.string.rorate_tip);
            this.q.setPositiveButton(R.string.alert_yes_button, new a());
            this.q.setNegativeButton(R.string.cancel, new b());
            this.q.create(this.f22811e.getPageContext());
        }
        this.q.show();
    }
}

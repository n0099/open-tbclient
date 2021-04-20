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
import d.b.c.e.p.l;
import d.b.h0.b0.g.e;
import d.b.h0.r.s.a;
import d.b.h0.z0.h;
import d.b.i0.v3.v.j;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public WriteMultiImgsActivity f22116e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo[] f22117f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f22118g;

    /* renamed from: h  reason: collision with root package name */
    public c f22119h;
    public int i;
    public int j;
    public d[] k;
    public int l;
    public LinkedList<ImageFileInfo> m = new LinkedList<>();
    public int n;
    public int o;
    public j p;
    public d.b.h0.r.s.a q;
    public Bitmap r;
    public boolean s;

    /* loaded from: classes5.dex */
    public class a implements a.e {

        /* renamed from: com.baidu.tieba.write.write.MultiImagePagerAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0233a implements d.b.i0.v3.v.n.b.c {
            public C0233a() {
            }

            @Override // d.b.i0.v3.v.n.b.c
            public void a() {
                MultiImagePagerAdapter.this.f22119h.a();
            }

            @Override // d.b.i0.v3.v.n.b.c
            public boolean b(Bitmap bitmap) {
                return false;
            }

            @Override // d.b.i0.v3.v.n.b.c
            public void c() {
            }

            @Override // d.b.i0.v3.v.n.b.c
            public void d() {
            }
        }

        public a() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (MultiImagePagerAdapter.this.q != null) {
                MultiImagePagerAdapter.this.q.dismiss();
            }
            MultiImagePagerAdapter.this.p.f63552f.f(new C0233a());
            MultiImagePagerAdapter multiImagePagerAdapter = MultiImagePagerAdapter.this;
            multiImagePagerAdapter.j(multiImagePagerAdapter.l, false);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (MultiImagePagerAdapter.this.q != null) {
                MultiImagePagerAdapter.this.q.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        boolean b();

        void c();

        void e(int i, boolean z);
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f22123a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f22124b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f22125c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.h0.b0.b f22126d;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a(MultiImagePagerAdapter multiImagePagerAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MultiImagePagerAdapter.this.f22119h != null) {
                    MultiImagePagerAdapter.this.f22119h.c();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements d.b.h0.a0.b {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageFileInfo f22129e;

            public b(ImageFileInfo imageFileInfo) {
                this.f22129e = imageFileInfo;
            }

            @Override // d.b.h0.a0.b
            public void a(d.b.c.j.d.a aVar, String str, boolean z) {
                d.this.e(this.f22129e, aVar);
                d.this.f22125c.setVisibility(8);
                if (MultiImagePagerAdapter.this.p != null) {
                    MultiImagePagerAdapter.this.p.n();
                }
            }
        }

        public d(int i) {
            this.f22125c = null;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.f22116e.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.f22123a = frameLayout;
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.progress_tb_imageview);
            this.f22124b = tbImageView;
            tbImageView.setClickable(true);
            this.f22124b.setDefaultResource(0);
            this.f22124b.setDefaultBgResource(0);
            this.f22124b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f22124b.setPadding(0, 0, 0, 0);
            this.f22126d = new d.b.h0.b0.b();
            this.f22124b.setOnClickListener(new a(MultiImagePagerAdapter.this));
            ProgressBar progressBar = (ProgressBar) this.f22123a.findViewById(R.id.progress_tb_imageview_progress);
            this.f22125c = progressBar;
            progressBar.setVisibility(8);
        }

        public void d() {
            d.b.h0.b0.b bVar = this.f22126d;
            if (bVar != null) {
                bVar.b();
            }
        }

        public final void e(ImageFileInfo imageFileInfo, d.b.c.j.d.a aVar) {
            if (aVar == null || this.f22124b == null) {
                return;
            }
            int[] l = l.l(aVar.r(), aVar.m(), l.k(MultiImagePagerAdapter.this.f22116e), (l.i(MultiImagePagerAdapter.this.f22116e) - l.g(MultiImagePagerAdapter.this.f22116e, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f22124b.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = l[0];
            layoutParams.height = l[1];
            this.f22124b.setLayoutParams(layoutParams);
            aVar.h(this.f22124b);
            if (MultiImagePagerAdapter.this.p != null && MultiImagePagerAdapter.this.p.f63552f != null && imageFileInfo != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.p.f63552f.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.width = l[0];
                layoutParams2.height = l[1];
                MultiImagePagerAdapter.this.p.f63552f.setLayoutParams(layoutParams2);
            }
            if (aVar.p() == null || aVar.p().isRecycled()) {
                return;
            }
            MultiImagePagerAdapter.this.r = aVar.p();
        }

        public View f() {
            return this.f22123a;
        }

        public void g(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return;
            }
            d();
            this.f22125c.setVisibility(0);
            d.b.c.j.d.a c2 = this.f22126d.c(imageFileInfo, false);
            if (c2 != null) {
                e(imageFileInfo, c2);
                this.f22125c.setVisibility(8);
                return;
            }
            this.f22126d.d(imageFileInfo, new b(imageFileInfo), false);
        }

        public boolean h() {
            return this.f22125c.getVisibility() != 0;
        }
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, c cVar, j jVar, boolean z) {
        this.f22116e = null;
        this.f22117f = null;
        this.f22118g = null;
        this.f22119h = null;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.n = 120;
        this.o = 120;
        this.s = z;
        this.f22116e = writeMultiImgsActivity;
        this.p = jVar;
        this.n = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.o = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.j = o(linkedList, i);
        int size = this.m.size();
        this.i = size;
        this.f22117f = new ImageFileInfo[size];
        this.k = new d[size];
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f22117f[i2] = this.m.get(i2).cloneWithoutFilterAction(true);
            this.f22117f[i2].addPageAction(d.b.h0.b0.g.d.g(this.n, this.o));
            linkedList.set(linkedList.indexOf(this.m.get(i2)), this.f22117f[i2]);
            this.f22117f[i2].mCount = 0;
        }
        this.f22118g = viewPager;
        this.f22119h = cVar;
        viewPager.setOffscreenPageLimit(1);
        this.f22118g.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.f22118g.removeView(this.k[i].f());
    }

    public void g(boolean z) {
        j jVar;
        StickerLayout stickerLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap c2;
        if (this.f22117f == null) {
            return;
        }
        int i = 0;
        while (true) {
            ImageFileInfo[] imageFileInfoArr = this.f22117f;
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
            if (z || !this.s) {
                return;
            }
            q(this.r);
            return;
        }
        c cVar = this.f22119h;
        if (cVar != null && cVar.b() && (jVar = this.p) != null && (stickerLayout = jVar.f63552f) != null) {
            stickerLayout.e();
            TbImageView tbImageView = this.k[this.j].f22124b;
            try {
                bitmap = this.p.f63552f.c();
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
            this.f22117f[this.j].setFilePath(FileHelper.saveFileAsPNG(FileHelper.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), c2, 100));
            this.f22117f[this.j].setContentUriStr(null);
            this.f22117f[this.j].clearAllActions();
            this.f22117f[this.j].clearPageActions();
            this.f22117f[this.j].setIsGif(false);
            if (z || !this.s) {
                return;
            }
            q(c2);
        } else if (z || !this.s) {
        } else {
            q(this.r);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.i;
    }

    public final boolean i() {
        int i;
        ImageFileInfo[] imageFileInfoArr;
        d[] dVarArr = this.k;
        return (dVarArr == null || (i = this.j) >= dVarArr.length || dVarArr[i] == null || (imageFileInfoArr = this.f22117f) == null || i >= imageFileInfoArr.length || imageFileInfoArr[i] == null) ? false : true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d[] dVarArr = this.k;
        if (dVarArr[i] == null) {
            dVarArr[i] = new d(i);
        }
        this.f22118g.addView(this.k[i].f());
        return this.k[i].f();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(int i, boolean z) {
        ImageFileInfo imageFileInfo;
        if (m()) {
            c cVar = this.f22119h;
            if (cVar != null) {
                cVar.e(i, z);
            }
        } else if (z) {
            r(i);
        } else if (i()) {
            d[] dVarArr = this.k;
            int i2 = this.j;
            d dVar = dVarArr[i2];
            if (dVar == null || (imageFileInfo = this.f22117f[i2]) == null || !dVar.h()) {
                return;
            }
            imageFileInfo.addPageAction(e.e(i));
            this.f22116e.addAction();
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
        int i = this.j;
        ImageFileInfo[] imageFileInfoArr = this.f22117f;
        if (i >= imageFileInfoArr.length || imageFileInfoArr[i] == null || !imageFileInfoArr[i].isGif()) {
            return false;
        }
        ImageFileInfo[] imageFileInfoArr2 = this.f22117f;
        int i2 = this.j;
        if (imageFileInfoArr2[i2].mCount > 0) {
            return false;
        }
        imageFileInfoArr2[i2].mCount++;
        return true;
    }

    public final void n() {
        d[] dVarArr;
        d[] dVarArr2;
        int i = this.j;
        if (i < 0 || (dVarArr = this.k) == null || i >= dVarArr.length) {
            return;
        }
        ImageFileInfo[] imageFileInfoArr = this.f22117f;
        if (i >= imageFileInfoArr.length || imageFileInfoArr[i] == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            dVarArr2 = this.k;
            if (i2 >= dVarArr2.length) {
                break;
            }
            if (dVarArr2[i2] != null) {
                dVarArr2[i2].d();
            }
            i2++;
        }
        int i3 = this.j;
        if (dVarArr2[i3] == null) {
            dVarArr2[i3] = new d(i3);
        }
        d[] dVarArr3 = this.k;
        int i4 = this.j;
        dVarArr3[i4].g(this.f22117f[i4]);
    }

    public final int o(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList == null || i < 0 || i >= linkedList.size()) {
            return i;
        }
        this.m.clear();
        ImageFileInfo imageFileInfo = linkedList.get(i);
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
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.j = i;
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
            this.f22117f[0].extra = str;
        }
    }

    public final void r(int i) {
        this.l = i;
        if (this.q == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f22116e);
            this.q = aVar;
            aVar.setMessageId(R.string.rorate_tip);
            this.q.setPositiveButton(R.string.alert_yes_button, new a());
            this.q.setNegativeButton(R.string.cancel, new b());
            this.q.create(this.f22116e.getPageContext());
        }
        this.q.show();
    }
}

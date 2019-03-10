package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int biR;
    private WriteMultiImgsActivity jsm;
    private ImageFileInfo[] jsn;
    private a jso;
    private b[] jsp;
    private int jsq;
    private LinkedList<ImageFileInfo> jsr = new LinkedList<>();
    private int jss;
    private int jst;
    private h jsu;
    private com.baidu.tbadk.core.dialog.a jsv;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void P(int i, boolean z);

        void cqn();

        void cqp();

        boolean cqq();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jsm = null;
        this.jsn = null;
        this.mViewPager = null;
        this.jso = null;
        this.mCount = 0;
        this.biR = 0;
        this.jsp = null;
        this.jss = 120;
        this.jst = 120;
        this.mIsFromIm = z;
        this.jsm = writeMultiImgsActivity;
        this.jsu = hVar;
        this.jss = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.jst = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        this.biR = e(linkedList, i);
        this.mCount = this.jsr.size();
        this.jsn = new ImageFileInfo[this.mCount];
        this.jsp = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jsn[i2] = this.jsr.get(i2).cloneWithoutFilterAction(true);
            this.jsn[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jss, this.jst));
            linkedList.set(linkedList.indexOf(this.jsr.get(i2)), this.jsn[i2]);
            this.jsn[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jso = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jsr.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jsr.add(next);
                }
            }
            return this.jsr.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cqj() {
        return this.biR;
    }

    private boolean RK() {
        return (this.jsp == null || this.biR >= this.jsp.length || this.jsp[this.biR] == null || this.jsn == null || this.biR >= this.jsn.length || this.jsn[this.biR] == null) ? false : true;
    }

    public boolean cqk() {
        if (this.biR >= this.jsn.length || this.jsn[this.biR] == null || !this.jsn[this.biR].isGif() || this.jsn[this.biR].mCount > 0) {
            return false;
        }
        this.jsn[this.biR].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cqk()) {
            if (this.jso != null) {
                this.jso.P(i, z);
            }
        } else if (z) {
            Bx(i);
        } else if (RK() && (bVar = this.jsp[this.biR]) != null && (imageFileInfo = this.jsn[this.biR]) != null && bVar.cqr()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.jN(i));
            this.jsm.crm();
            bVar.i(imageFileInfo);
        }
    }

    private void Bx(int i) {
        this.jsq = i;
        if (this.jsv == null) {
            this.jsv = new com.baidu.tbadk.core.dialog.a(this.jsm);
            this.jsv.gD(d.j.rorate_tip);
            this.jsv.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsv != null) {
                        MultiImagePagerAdapter.this.jsv.dismiss();
                    }
                    MultiImagePagerAdapter.this.jsu.juJ.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqm() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqn() {
                            MultiImagePagerAdapter.this.jso.cqn();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean O(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqo() {
                        }
                    });
                    MultiImagePagerAdapter.this.O(MultiImagePagerAdapter.this.jsq, false);
                }
            });
            this.jsv.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsv != null) {
                        MultiImagePagerAdapter.this.jsv.dismiss();
                    }
                }
            });
            this.jsv.b(this.jsm.getPageContext());
        }
        this.jsv.aaZ();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jsp[i] == null) {
            this.jsp[i] = new b(i);
        }
        this.mViewPager.addView(this.jsp[i].getView());
        return this.jsp[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jsp[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.biR = i;
        cql();
    }

    private void cql() {
        if (this.biR >= 0 && this.jsp != null && this.biR < this.jsp.length && this.biR < this.jsn.length && this.jsn[this.biR] != null) {
            for (int i = 0; i < this.jsp.length; i++) {
                if (this.jsp[i] != null) {
                    this.jsp[i].aPT();
                }
            }
            if (this.jsp[this.biR] == null) {
                this.jsp[this.biR] = new b(this.biR);
            }
            this.jsp[this.biR].i(this.jsn[this.biR]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.biR;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean f(String str, Bitmap bitmap) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rg(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jsn != null) {
            for (int i = 0; i < this.jsn.length; i++) {
                ImageFileInfo imageFileInfo = this.jsn[i];
                if (imageFileInfo != null) {
                    this.jsn[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!RK()) {
                if (!z && this.mIsFromIm) {
                    N(this.mBitmap);
                }
            } else if (this.jso != null && this.jso.cqq() && this.jsu != null && this.jsu.juJ != null) {
                this.jsu.juJ.bGs();
                TbImageView tbImageView = this.jsp[this.biR].Uy;
                try {
                    bitmap = this.jsu.juJ.crP();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.f.aZ(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.f.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.jsn[this.biR].setFilePath(m.b(m.acg(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jsn[this.biR].clearAllActions();
                        this.jsn[this.biR].clearPageActions();
                        this.jsn[this.biR].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            N(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                N(this.mBitmap);
            }
        }
    }

    private void N(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (f(str, bitmap)) {
                this.jsn[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Uy;
        private ProgressBar iBM;
        private int index;
        private FrameLayout jsy;
        private com.baidu.tbadk.img.b jsz;

        public b(int i) {
            this.iBM = null;
            this.index = -1;
            this.index = i;
            this.jsy = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jsm.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.Uy = (TbImageView) this.jsy.findViewById(d.g.progress_tb_imageview);
            this.Uy.setClickable(true);
            this.Uy.setDefaultResource(0);
            this.Uy.setDefaultErrorResource(0);
            this.Uy.setDefaultBgResource(0);
            this.Uy.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Uy.setPadding(0, 0, 0, 0);
            this.jsz = new com.baidu.tbadk.img.b();
            this.Uy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jso != null) {
                        MultiImagePagerAdapter.this.jso.cqp();
                    }
                }
            });
            this.iBM = (ProgressBar) this.jsy.findViewById(d.g.progress_tb_imageview_progress);
            this.iBM.setVisibility(8);
        }

        public View getView() {
            return this.jsy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Uy != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.aO(MultiImagePagerAdapter.this.jsm), (l.aQ(MultiImagePagerAdapter.this.jsm) - l.h(MultiImagePagerAdapter.this.jsm, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Uy.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.Uy.setLayoutParams(layoutParams);
                aVar.a(this.Uy);
                if (MultiImagePagerAdapter.this.jsu != null && MultiImagePagerAdapter.this.jsu.juJ != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jsu.juJ.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.jsu.juJ.setLayoutParams(layoutParams2);
                }
                if (aVar.oy() != null && !aVar.oy().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.oy();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aPT();
                this.iBM.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jsz.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iBM.setVisibility(8);
                    return;
                }
                this.jsz.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iBM.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jsu != null) {
                            MultiImagePagerAdapter.this.jsu.cqe();
                        }
                    }
                }, false);
            }
        }

        public void aPT() {
            if (this.jsz != null) {
                this.jsz.anA();
            }
            if (this.Uy != null) {
            }
        }

        public boolean cqr() {
            return this.iBM.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

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
    private WriteMultiImgsActivity jrT;
    private ImageFileInfo[] jrU;
    private a jrV;
    private b[] jrW;
    private int jrX;
    private LinkedList<ImageFileInfo> jrY = new LinkedList<>();
    private int jrZ;
    private int jsa;
    private h jsb;
    private com.baidu.tbadk.core.dialog.a jsc;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void P(int i, boolean z);

        void cqd();

        void cqf();

        boolean cqg();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jrT = null;
        this.jrU = null;
        this.mViewPager = null;
        this.jrV = null;
        this.mCount = 0;
        this.biR = 0;
        this.jrW = null;
        this.jrZ = 120;
        this.jsa = 120;
        this.mIsFromIm = z;
        this.jrT = writeMultiImgsActivity;
        this.jsb = hVar;
        this.jrZ = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.jsa = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        this.biR = e(linkedList, i);
        this.mCount = this.jrY.size();
        this.jrU = new ImageFileInfo[this.mCount];
        this.jrW = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jrU[i2] = this.jrY.get(i2).cloneWithoutFilterAction(true);
            this.jrU[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jrZ, this.jsa));
            linkedList.set(linkedList.indexOf(this.jrY.get(i2)), this.jrU[i2]);
            this.jrU[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jrV = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jrY.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jrY.add(next);
                }
            }
            return this.jrY.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cpZ() {
        return this.biR;
    }

    private boolean RK() {
        return (this.jrW == null || this.biR >= this.jrW.length || this.jrW[this.biR] == null || this.jrU == null || this.biR >= this.jrU.length || this.jrU[this.biR] == null) ? false : true;
    }

    public boolean cqa() {
        if (this.biR >= this.jrU.length || this.jrU[this.biR] == null || !this.jrU[this.biR].isGif() || this.jrU[this.biR].mCount > 0) {
            return false;
        }
        this.jrU[this.biR].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cqa()) {
            if (this.jrV != null) {
                this.jrV.P(i, z);
            }
        } else if (z) {
            Bw(i);
        } else if (RK() && (bVar = this.jrW[this.biR]) != null && (imageFileInfo = this.jrU[this.biR]) != null && bVar.cqh()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.jN(i));
            this.jrT.crc();
            bVar.i(imageFileInfo);
        }
    }

    private void Bw(int i) {
        this.jrX = i;
        if (this.jsc == null) {
            this.jsc = new com.baidu.tbadk.core.dialog.a(this.jrT);
            this.jsc.gD(d.j.rorate_tip);
            this.jsc.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsc != null) {
                        MultiImagePagerAdapter.this.jsc.dismiss();
                    }
                    MultiImagePagerAdapter.this.jsb.juq.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqc() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqd() {
                            MultiImagePagerAdapter.this.jrV.cqd();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean O(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqe() {
                        }
                    });
                    MultiImagePagerAdapter.this.O(MultiImagePagerAdapter.this.jrX, false);
                }
            });
            this.jsc.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsc != null) {
                        MultiImagePagerAdapter.this.jsc.dismiss();
                    }
                }
            });
            this.jsc.b(this.jrT.getPageContext());
        }
        this.jsc.aaZ();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jrW[i] == null) {
            this.jrW[i] = new b(i);
        }
        this.mViewPager.addView(this.jrW[i].getView());
        return this.jrW[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jrW[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.biR = i;
        cqb();
    }

    private void cqb() {
        if (this.biR >= 0 && this.jrW != null && this.biR < this.jrW.length && this.biR < this.jrU.length && this.jrU[this.biR] != null) {
            for (int i = 0; i < this.jrW.length; i++) {
                if (this.jrW[i] != null) {
                    this.jrW[i].aPS();
                }
            }
            if (this.jrW[this.biR] == null) {
                this.jrW[this.biR] = new b(this.biR);
            }
            this.jrW[this.biR].i(this.jrU[this.biR]);
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
        if (this.jrU != null) {
            for (int i = 0; i < this.jrU.length; i++) {
                ImageFileInfo imageFileInfo = this.jrU[i];
                if (imageFileInfo != null) {
                    this.jrU[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!RK()) {
                if (!z && this.mIsFromIm) {
                    N(this.mBitmap);
                }
            } else if (this.jrV != null && this.jrV.cqg() && this.jsb != null && this.jsb.juq != null) {
                this.jsb.juq.bGr();
                TbImageView tbImageView = this.jrW[this.biR].Uy;
                try {
                    bitmap = this.jsb.juq.crF();
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
                        this.jrU[this.biR].setFilePath(m.b(m.acg(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jrU[this.biR].clearAllActions();
                        this.jrU[this.biR].clearPageActions();
                        this.jrU[this.biR].setIsGif(false);
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
                this.jrU[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Uy;
        private ProgressBar iBL;
        private int index;
        private FrameLayout jsf;
        private com.baidu.tbadk.img.b jsg;

        public b(int i) {
            this.iBL = null;
            this.index = -1;
            this.index = i;
            this.jsf = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jrT.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.Uy = (TbImageView) this.jsf.findViewById(d.g.progress_tb_imageview);
            this.Uy.setClickable(true);
            this.Uy.setDefaultResource(0);
            this.Uy.setDefaultErrorResource(0);
            this.Uy.setDefaultBgResource(0);
            this.Uy.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Uy.setPadding(0, 0, 0, 0);
            this.jsg = new com.baidu.tbadk.img.b();
            this.Uy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jrV != null) {
                        MultiImagePagerAdapter.this.jrV.cqf();
                    }
                }
            });
            this.iBL = (ProgressBar) this.jsf.findViewById(d.g.progress_tb_imageview_progress);
            this.iBL.setVisibility(8);
        }

        public View getView() {
            return this.jsf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Uy != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.aO(MultiImagePagerAdapter.this.jrT), (l.aQ(MultiImagePagerAdapter.this.jrT) - l.h(MultiImagePagerAdapter.this.jrT, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Uy.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.Uy.setLayoutParams(layoutParams);
                aVar.a(this.Uy);
                if (MultiImagePagerAdapter.this.jsb != null && MultiImagePagerAdapter.this.jsb.juq != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jsb.juq.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.jsb.juq.setLayoutParams(layoutParams2);
                }
                if (aVar.oy() != null && !aVar.oy().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.oy();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aPS();
                this.iBL.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jsg.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iBL.setVisibility(8);
                    return;
                }
                this.jsg.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iBL.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jsb != null) {
                            MultiImagePagerAdapter.this.jsb.cpU();
                        }
                    }
                }, false);
            }
        }

        public void aPS() {
            if (this.jsg != null) {
                this.jsg.anA();
            }
            if (this.Uy != null) {
            }
        }

        public boolean cqh() {
            return this.iBL.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

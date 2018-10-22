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
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int aWO;
    private WriteMultiImgsActivity hNW;
    private ImageFileInfo[] hNX;
    private a hNY;
    private b[] hNZ;
    private int hOa;
    private int hOb;
    private int hOc;
    private h hOd;
    private com.baidu.tbadk.core.dialog.a hOe;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bNq();

        void bNs();

        boolean bNt();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hNW = null;
        this.hNX = null;
        this.mViewPager = null;
        this.hNY = null;
        this.mCount = 0;
        this.aWO = 0;
        this.hNZ = null;
        this.hOb = 120;
        this.hOc = 120;
        this.mIsFromIm = z;
        this.hNW = writeMultiImgsActivity;
        this.hOd = hVar;
        this.hOb = (int) writeMultiImgsActivity.getResources().getDimension(e.C0175e.ds720);
        this.hOc = (int) writeMultiImgsActivity.getResources().getDimension(e.C0175e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hNX = new ImageFileInfo[this.mCount];
        this.hNZ = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hNX[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hNX[i2].addPageAction(com.baidu.tbadk.img.effect.d.K(this.hOb, this.hOc));
            linkedList.set(i2, this.hNX[i2]);
            this.hNX[i2].mCount = 0;
        }
        this.aWO = i;
        this.mViewPager = viewPager;
        this.hNY = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bNm() {
        return (this.hNZ == null || this.aWO >= this.hNZ.length || this.hNZ[this.aWO] == null || this.hNX == null || this.aWO >= this.hNX.length || this.hNX[this.aWO] == null) ? false : true;
    }

    public boolean bNn() {
        if (this.aWO >= this.hNX.length || this.hNX[this.aWO] == null || !this.hNX[this.aWO].isGif() || this.hNX[this.aWO].mCount > 0) {
            return false;
        }
        this.hNX[this.aWO].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bNn()) {
            if (this.hNY != null) {
                this.hNY.J(i, z);
            }
        } else if (z) {
            wC(i);
        } else if (bNm() && (bVar = this.hNZ[this.aWO]) != null && (imageFileInfo = this.hNX[this.aWO]) != null && bVar.bNu()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fz(i));
            this.hNW.bOq();
            bVar.h(imageFileInfo);
        }
    }

    private void wC(int i) {
        this.hOa = i;
        if (this.hOe == null) {
            this.hOe = new com.baidu.tbadk.core.dialog.a(this.hNW);
            this.hOe.cz(e.j.rorate_tip);
            this.hOe.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hOe != null) {
                        MultiImagePagerAdapter.this.hOe.dismiss();
                    }
                    MultiImagePagerAdapter.this.hOd.hQr.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNp() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNq() {
                            MultiImagePagerAdapter.this.hNY.bNq();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNr() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.hOa, false);
                }
            });
            this.hOe.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hOe != null) {
                        MultiImagePagerAdapter.this.hOe.dismiss();
                    }
                }
            });
            this.hOe.b(this.hNW.getPageContext());
        }
        this.hOe.Au();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hNZ[i] == null) {
            this.hNZ[i] = new b(i);
        }
        this.mViewPager.addView(this.hNZ[i].getView());
        return this.hNZ[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hNZ[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aWO = i;
        bNo();
    }

    private void bNo() {
        if (this.aWO >= 0 && this.hNZ != null && this.aWO < this.hNZ.length && this.aWO < this.hNX.length && this.hNX[this.aWO] != null) {
            for (int i = 0; i < this.hNZ.length; i++) {
                if (this.hNZ[i] != null) {
                    this.hNZ[i].amX();
                }
            }
            if (this.hNZ[this.aWO] == null) {
                this.hNZ[this.aWO] = new b(this.aWO);
            }
            this.hNZ[this.aWO].h(this.hNX[this.aWO]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aWO;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            l.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (l.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void om(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hNX != null) {
            for (int i = 0; i < this.hNX.length; i++) {
                ImageFileInfo imageFileInfo = this.hNX[i];
                if (imageFileInfo != null) {
                    this.hNX[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bNm()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.hNY != null && this.hNY.bNt() && this.hOd != null && this.hOd.hQr != null) {
                this.hOd.hQr.bdn();
                TbImageView tbImageView = this.hNZ[this.aWO].fda;
                try {
                    bitmap = this.hOd.hQr.bOT();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.e.af(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.e.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.hNX[this.aWO].setFilePath(l.b(l.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hNX[this.aWO].clearAllActions();
                        this.hNX[this.aWO].clearPageActions();
                        this.hNX[this.aWO].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            F(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                F(this.mBitmap);
            }
        }
    }

    private void F(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = NgWebViewInitHelper.INIT_BWEBKIT_APPID + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.hNX[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView fda;
        private ProgressBar gXw;
        private FrameLayout hOh;
        private com.baidu.tbadk.img.b hOi;
        private int index;

        public b(int i) {
            this.gXw = null;
            this.index = -1;
            this.index = i;
            this.hOh = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hNW.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.fda = (TbImageView) this.hOh.findViewById(e.g.progress_tb_imageview);
            this.fda.setClickable(true);
            this.fda.setDefaultResource(0);
            this.fda.setDefaultErrorResource(0);
            this.fda.setDefaultBgResource(0);
            this.fda.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fda.setPadding(0, 0, 0, 0);
            this.hOi = new com.baidu.tbadk.img.b();
            this.fda.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hNY != null) {
                        MultiImagePagerAdapter.this.hNY.bNs();
                    }
                }
            });
            this.gXw = (ProgressBar) this.hOh.findViewById(e.g.progress_tb_imageview_progress);
            this.gXw.setVisibility(8);
        }

        public View getView() {
            return this.hOh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.fda != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.hNW), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.hNW) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.hNW, e.C0175e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fda.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.fda.setLayoutParams(layoutParams);
                aVar.a(this.fda);
                if (MultiImagePagerAdapter.this.hOd != null && MultiImagePagerAdapter.this.hOd.hQr != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hOd.hQr.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hOd.hQr.setLayoutParams(layoutParams2);
                }
                if (aVar.os() != null && !aVar.os().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.os();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                amX();
                this.gXw.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hOi.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gXw.setVisibility(8);
                    return;
                }
                this.hOi.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gXw.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hOd != null) {
                            MultiImagePagerAdapter.this.hOd.bNh();
                        }
                    }
                }, false);
            }
        }

        public void amX() {
            if (this.hOi != null) {
                this.hOi.Mo();
            }
            if (this.fda != null) {
            }
        }

        public boolean bNu() {
            return this.gXw.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

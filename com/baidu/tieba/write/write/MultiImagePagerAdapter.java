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
    private WriteMultiImgsActivity hPG;
    private ImageFileInfo[] hPH;
    private a hPI;
    private b[] hPJ;
    private int hPK;
    private int hPL;
    private int hPM;
    private h hPN;
    private com.baidu.tbadk.core.dialog.a hPO;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bMP();

        void bMR();

        boolean bMS();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hPG = null;
        this.hPH = null;
        this.mViewPager = null;
        this.hPI = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.hPJ = null;
        this.hPL = 120;
        this.hPM = 120;
        this.mIsFromIm = z;
        this.hPG = writeMultiImgsActivity;
        this.hPN = hVar;
        this.hPL = (int) writeMultiImgsActivity.getResources().getDimension(e.C0200e.ds720);
        this.hPM = (int) writeMultiImgsActivity.getResources().getDimension(e.C0200e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hPH = new ImageFileInfo[this.mCount];
        this.hPJ = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hPH[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hPH[i2].addPageAction(com.baidu.tbadk.img.effect.d.K(this.hPL, this.hPM));
            linkedList.set(i2, this.hPH[i2]);
            this.hPH[i2].mCount = 0;
        }
        this.mCurrentIndex = i;
        this.mViewPager = viewPager;
        this.hPI = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bML() {
        return (this.hPJ == null || this.mCurrentIndex >= this.hPJ.length || this.hPJ[this.mCurrentIndex] == null || this.hPH == null || this.mCurrentIndex >= this.hPH.length || this.hPH[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean bMM() {
        if (this.mCurrentIndex >= this.hPH.length || this.hPH[this.mCurrentIndex] == null || !this.hPH[this.mCurrentIndex].isGif() || this.hPH[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.hPH[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bMM()) {
            if (this.hPI != null) {
                this.hPI.J(i, z);
            }
        } else if (z) {
            wV(i);
        } else if (bML() && (bVar = this.hPJ[this.mCurrentIndex]) != null && (imageFileInfo = this.hPH[this.mCurrentIndex]) != null && bVar.bMT()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fN(i));
            this.hPG.bNP();
            bVar.h(imageFileInfo);
        }
    }

    private void wV(int i) {
        this.hPK = i;
        if (this.hPO == null) {
            this.hPO = new com.baidu.tbadk.core.dialog.a(this.hPG);
            this.hPO.cN(e.j.rorate_tip);
            this.hPO.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hPO != null) {
                        MultiImagePagerAdapter.this.hPO.dismiss();
                    }
                    MultiImagePagerAdapter.this.hPN.hSb.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bMO() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bMP() {
                            MultiImagePagerAdapter.this.hPI.bMP();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bMQ() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.hPK, false);
                }
            });
            this.hPO.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hPO != null) {
                        MultiImagePagerAdapter.this.hPO.dismiss();
                    }
                }
            });
            this.hPO.b(this.hPG.getPageContext());
        }
        this.hPO.AB();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hPJ[i] == null) {
            this.hPJ[i] = new b(i);
        }
        this.mViewPager.addView(this.hPJ[i].getView());
        return this.hPJ[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hPJ[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        bMN();
    }

    private void bMN() {
        if (this.mCurrentIndex >= 0 && this.hPJ != null && this.mCurrentIndex < this.hPJ.length && this.mCurrentIndex < this.hPH.length && this.hPH[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.hPJ.length; i++) {
                if (this.hPJ[i] != null) {
                    this.hPJ[i].amw();
                }
            }
            if (this.hPJ[this.mCurrentIndex] == null) {
                this.hPJ[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.hPJ[this.mCurrentIndex].h(this.hPH[this.mCurrentIndex]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurrentIndex;
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
    public void oA(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hPH != null) {
            for (int i = 0; i < this.hPH.length; i++) {
                ImageFileInfo imageFileInfo = this.hPH[i];
                if (imageFileInfo != null) {
                    this.hPH[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bML()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.hPI != null && this.hPI.bMS() && this.hPN != null && this.hPN.hSb != null) {
                this.hPN.hSb.bcM();
                TbImageView tbImageView = this.hPJ[this.mCurrentIndex].feu;
                try {
                    bitmap = this.hPN.hSb.bOs();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.e.ae(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.e.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.hPH[this.mCurrentIndex].setFilePath(l.b(l.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hPH[this.mCurrentIndex].clearAllActions();
                        this.hPH[this.mCurrentIndex].clearPageActions();
                        this.hPH[this.mCurrentIndex].setIsGif(false);
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
                this.hPH[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView feu;
        private ProgressBar gYU;
        private FrameLayout hPR;
        private com.baidu.tbadk.img.b hPS;
        private int index;

        public b(int i) {
            this.gYU = null;
            this.index = -1;
            this.index = i;
            this.hPR = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hPG.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.feu = (TbImageView) this.hPR.findViewById(e.g.progress_tb_imageview);
            this.feu.setClickable(true);
            this.feu.setDefaultResource(0);
            this.feu.setDefaultErrorResource(0);
            this.feu.setDefaultBgResource(0);
            this.feu.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.feu.setPadding(0, 0, 0, 0);
            this.hPS = new com.baidu.tbadk.img.b();
            this.feu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hPI != null) {
                        MultiImagePagerAdapter.this.hPI.bMR();
                    }
                }
            });
            this.gYU = (ProgressBar) this.hPR.findViewById(e.g.progress_tb_imageview_progress);
            this.gYU.setVisibility(8);
        }

        public View getView() {
            return this.hPR;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.feu != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.hPG), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.hPG) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.hPG, e.C0200e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.feu.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.feu.setLayoutParams(layoutParams);
                aVar.a(this.feu);
                if (MultiImagePagerAdapter.this.hPN != null && MultiImagePagerAdapter.this.hPN.hSb != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hPN.hSb.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hPN.hSb.setLayoutParams(layoutParams2);
                }
                if (aVar.oq() != null && !aVar.oq().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.oq();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                amw();
                this.gYU.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hPS.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gYU.setVisibility(8);
                    return;
                }
                this.hPS.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gYU.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hPN != null) {
                            MultiImagePagerAdapter.this.hPN.bMG();
                        }
                    }
                }, false);
            }
        }

        public void amw() {
            if (this.hPS != null) {
                this.hPS.MA();
            }
            if (this.feu != null) {
            }
        }

        public boolean bMT() {
            return this.gYU.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

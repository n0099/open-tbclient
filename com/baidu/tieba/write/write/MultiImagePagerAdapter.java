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
    private int aSn;
    private WriteMultiImgsActivity hGJ;
    private ImageFileInfo[] hGK;
    private a hGL;
    private b[] hGM;
    private int hGN;
    private int hGO;
    private int hGP;
    private h hGQ;
    private com.baidu.tbadk.core.dialog.a hGR;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bKe();

        void bKg();

        boolean bKh();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hGJ = null;
        this.hGK = null;
        this.mViewPager = null;
        this.hGL = null;
        this.mCount = 0;
        this.aSn = 0;
        this.hGM = null;
        this.hGO = 120;
        this.hGP = 120;
        this.mIsFromIm = z;
        this.hGJ = writeMultiImgsActivity;
        this.hGQ = hVar;
        this.hGO = (int) writeMultiImgsActivity.getResources().getDimension(e.C0141e.ds720);
        this.hGP = (int) writeMultiImgsActivity.getResources().getDimension(e.C0141e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hGK = new ImageFileInfo[this.mCount];
        this.hGM = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hGK[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hGK[i2].addPageAction(com.baidu.tbadk.img.effect.d.K(this.hGO, this.hGP));
            linkedList.set(i2, this.hGK[i2]);
            this.hGK[i2].mCount = 0;
        }
        this.aSn = i;
        this.mViewPager = viewPager;
        this.hGL = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bKa() {
        return (this.hGM == null || this.aSn >= this.hGM.length || this.hGM[this.aSn] == null || this.hGK == null || this.aSn >= this.hGK.length || this.hGK[this.aSn] == null) ? false : true;
    }

    public boolean bKb() {
        if (this.aSn >= this.hGK.length || this.hGK[this.aSn] == null || !this.hGK[this.aSn].isGif() || this.hGK[this.aSn].mCount > 0) {
            return false;
        }
        this.hGK[this.aSn].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bKb()) {
            if (this.hGL != null) {
                this.hGL.J(i, z);
            }
        } else if (z) {
            wf(i);
        } else if (bKa() && (bVar = this.hGM[this.aSn]) != null && (imageFileInfo = this.hGK[this.aSn]) != null && bVar.bKi()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fq(i));
            this.hGJ.bLf();
            bVar.h(imageFileInfo);
        }
    }

    private void wf(int i) {
        this.hGN = i;
        if (this.hGR == null) {
            this.hGR = new com.baidu.tbadk.core.dialog.a(this.hGJ);
            this.hGR.cp(e.j.rorate_tip);
            this.hGR.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hGR != null) {
                        MultiImagePagerAdapter.this.hGR.dismiss();
                    }
                    MultiImagePagerAdapter.this.hGQ.hJe.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bKd() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bKe() {
                            MultiImagePagerAdapter.this.hGL.bKe();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bKf() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.hGN, false);
                }
            });
            this.hGR.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hGR != null) {
                        MultiImagePagerAdapter.this.hGR.dismiss();
                    }
                }
            });
            this.hGR.b(this.hGJ.getPageContext());
        }
        this.hGR.yl();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hGM[i] == null) {
            this.hGM[i] = new b(i);
        }
        this.mViewPager.addView(this.hGM[i].getView());
        return this.hGM[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hGM[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aSn = i;
        bKc();
    }

    private void bKc() {
        if (this.aSn >= 0 && this.hGM != null && this.aSn < this.hGM.length && this.aSn < this.hGK.length && this.hGK[this.aSn] != null) {
            for (int i = 0; i < this.hGM.length; i++) {
                if (this.hGM[i] != null) {
                    this.hGM[i].ajs();
                }
            }
            if (this.hGM[this.aSn] == null) {
                this.hGM[this.aSn] = new b(this.aSn);
            }
            this.hGM[this.aSn].h(this.hGK[this.aSn]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aSn;
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
    public void nW(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hGK != null) {
            for (int i = 0; i < this.hGK.length; i++) {
                ImageFileInfo imageFileInfo = this.hGK[i];
                if (imageFileInfo != null) {
                    this.hGK[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bKa()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.hGL != null && this.hGL.bKh() && this.hGQ != null && this.hGQ.hJe != null) {
                this.hGQ.hJe.bab();
                TbImageView tbImageView = this.hGM[this.aSn].eVr;
                try {
                    bitmap = this.hGQ.hJe.bLI();
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
                        this.hGK[this.aSn].setFilePath(l.b(l.zq(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hGK[this.aSn].clearAllActions();
                        this.hGK[this.aSn].clearPageActions();
                        this.hGK[this.aSn].setIsGif(false);
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
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.hGK[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView eVr;
        private ProgressBar gQa;
        private FrameLayout hGU;
        private com.baidu.tbadk.img.b hGV;
        private int index;

        public b(int i) {
            this.gQa = null;
            this.index = -1;
            this.index = i;
            this.hGU = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hGJ.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.eVr = (TbImageView) this.hGU.findViewById(e.g.progress_tb_imageview);
            this.eVr.setClickable(true);
            this.eVr.setDefaultResource(0);
            this.eVr.setDefaultErrorResource(0);
            this.eVr.setDefaultBgResource(0);
            this.eVr.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eVr.setPadding(0, 0, 0, 0);
            this.hGV = new com.baidu.tbadk.img.b();
            this.eVr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hGL != null) {
                        MultiImagePagerAdapter.this.hGL.bKg();
                    }
                }
            });
            this.gQa = (ProgressBar) this.hGU.findViewById(e.g.progress_tb_imageview_progress);
            this.gQa.setVisibility(8);
        }

        public View getView() {
            return this.hGU;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.eVr != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.hGJ), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.hGJ) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.hGJ, e.C0141e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eVr.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.eVr.setLayoutParams(layoutParams);
                aVar.a(this.eVr);
                if (MultiImagePagerAdapter.this.hGQ != null && MultiImagePagerAdapter.this.hGQ.hJe != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hGQ.hJe.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hGQ.hJe.setLayoutParams(layoutParams2);
                }
                if (aVar.oh() != null && !aVar.oh().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.oh();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                ajs();
                this.gQa.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hGV.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gQa.setVisibility(8);
                    return;
                }
                this.hGV.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gQa.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hGQ != null) {
                            MultiImagePagerAdapter.this.hGQ.bJV();
                        }
                    }
                }, false);
            }
        }

        public void ajs() {
            if (this.hGV != null) {
                this.hGV.Kq();
            }
            if (this.eVr != null) {
            }
        }

        public boolean bKi() {
            return this.gQa.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

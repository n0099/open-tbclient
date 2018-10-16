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
    private WriteMultiImgsActivity hNV;
    private ImageFileInfo[] hNW;
    private a hNX;
    private b[] hNY;
    private int hNZ;
    private int hOa;
    private int hOb;
    private h hOc;
    private com.baidu.tbadk.core.dialog.a hOd;
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
        this.hNV = null;
        this.hNW = null;
        this.mViewPager = null;
        this.hNX = null;
        this.mCount = 0;
        this.aWO = 0;
        this.hNY = null;
        this.hOa = 120;
        this.hOb = 120;
        this.mIsFromIm = z;
        this.hNV = writeMultiImgsActivity;
        this.hOc = hVar;
        this.hOa = (int) writeMultiImgsActivity.getResources().getDimension(e.C0175e.ds720);
        this.hOb = (int) writeMultiImgsActivity.getResources().getDimension(e.C0175e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hNW = new ImageFileInfo[this.mCount];
        this.hNY = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hNW[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hNW[i2].addPageAction(com.baidu.tbadk.img.effect.d.K(this.hOa, this.hOb));
            linkedList.set(i2, this.hNW[i2]);
            this.hNW[i2].mCount = 0;
        }
        this.aWO = i;
        this.mViewPager = viewPager;
        this.hNX = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bNm() {
        return (this.hNY == null || this.aWO >= this.hNY.length || this.hNY[this.aWO] == null || this.hNW == null || this.aWO >= this.hNW.length || this.hNW[this.aWO] == null) ? false : true;
    }

    public boolean bNn() {
        if (this.aWO >= this.hNW.length || this.hNW[this.aWO] == null || !this.hNW[this.aWO].isGif() || this.hNW[this.aWO].mCount > 0) {
            return false;
        }
        this.hNW[this.aWO].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bNn()) {
            if (this.hNX != null) {
                this.hNX.J(i, z);
            }
        } else if (z) {
            wC(i);
        } else if (bNm() && (bVar = this.hNY[this.aWO]) != null && (imageFileInfo = this.hNW[this.aWO]) != null && bVar.bNu()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fz(i));
            this.hNV.bOq();
            bVar.h(imageFileInfo);
        }
    }

    private void wC(int i) {
        this.hNZ = i;
        if (this.hOd == null) {
            this.hOd = new com.baidu.tbadk.core.dialog.a(this.hNV);
            this.hOd.cz(e.j.rorate_tip);
            this.hOd.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hOd != null) {
                        MultiImagePagerAdapter.this.hOd.dismiss();
                    }
                    MultiImagePagerAdapter.this.hOc.hQq.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNp() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNq() {
                            MultiImagePagerAdapter.this.hNX.bNq();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNr() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.hNZ, false);
                }
            });
            this.hOd.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hOd != null) {
                        MultiImagePagerAdapter.this.hOd.dismiss();
                    }
                }
            });
            this.hOd.b(this.hNV.getPageContext());
        }
        this.hOd.Au();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hNY[i] == null) {
            this.hNY[i] = new b(i);
        }
        this.mViewPager.addView(this.hNY[i].getView());
        return this.hNY[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hNY[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aWO = i;
        bNo();
    }

    private void bNo() {
        if (this.aWO >= 0 && this.hNY != null && this.aWO < this.hNY.length && this.aWO < this.hNW.length && this.hNW[this.aWO] != null) {
            for (int i = 0; i < this.hNY.length; i++) {
                if (this.hNY[i] != null) {
                    this.hNY[i].amW();
                }
            }
            if (this.hNY[this.aWO] == null) {
                this.hNY[this.aWO] = new b(this.aWO);
            }
            this.hNY[this.aWO].h(this.hNW[this.aWO]);
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
        if (this.hNW != null) {
            for (int i = 0; i < this.hNW.length; i++) {
                ImageFileInfo imageFileInfo = this.hNW[i];
                if (imageFileInfo != null) {
                    this.hNW[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bNm()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.hNX != null && this.hNX.bNt() && this.hOc != null && this.hOc.hQq != null) {
                this.hOc.hQq.bdn();
                TbImageView tbImageView = this.hNY[this.aWO].fcZ;
                try {
                    bitmap = this.hOc.hQq.bOT();
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
                        this.hNW[this.aWO].setFilePath(l.b(l.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hNW[this.aWO].clearAllActions();
                        this.hNW[this.aWO].clearPageActions();
                        this.hNW[this.aWO].setIsGif(false);
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
                this.hNW[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView fcZ;
        private ProgressBar gXv;
        private FrameLayout hOg;
        private com.baidu.tbadk.img.b hOh;
        private int index;

        public b(int i) {
            this.gXv = null;
            this.index = -1;
            this.index = i;
            this.hOg = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hNV.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.fcZ = (TbImageView) this.hOg.findViewById(e.g.progress_tb_imageview);
            this.fcZ.setClickable(true);
            this.fcZ.setDefaultResource(0);
            this.fcZ.setDefaultErrorResource(0);
            this.fcZ.setDefaultBgResource(0);
            this.fcZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fcZ.setPadding(0, 0, 0, 0);
            this.hOh = new com.baidu.tbadk.img.b();
            this.fcZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hNX != null) {
                        MultiImagePagerAdapter.this.hNX.bNs();
                    }
                }
            });
            this.gXv = (ProgressBar) this.hOg.findViewById(e.g.progress_tb_imageview_progress);
            this.gXv.setVisibility(8);
        }

        public View getView() {
            return this.hOg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.fcZ != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.hNV), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.hNV) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.hNV, e.C0175e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fcZ.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.fcZ.setLayoutParams(layoutParams);
                aVar.a(this.fcZ);
                if (MultiImagePagerAdapter.this.hOc != null && MultiImagePagerAdapter.this.hOc.hQq != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hOc.hQq.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hOc.hQq.setLayoutParams(layoutParams2);
                }
                if (aVar.os() != null && !aVar.os().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.os();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                amW();
                this.gXv.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hOh.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gXv.setVisibility(8);
                    return;
                }
                this.hOh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gXv.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hOc != null) {
                            MultiImagePagerAdapter.this.hOc.bNh();
                        }
                    }
                }, false);
            }
        }

        public void amW() {
            if (this.hOh != null) {
                this.hOh.Mo();
            }
            if (this.fcZ != null) {
            }
        }

        public boolean bNu() {
            return this.gXv.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

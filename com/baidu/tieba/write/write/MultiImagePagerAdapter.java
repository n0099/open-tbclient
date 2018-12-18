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
    private WriteMultiImgsActivity hWQ;
    private ImageFileInfo[] hWR;
    private a hWS;
    private b[] hWT;
    private int hWU;
    private int hWV;
    private int hWW;
    private h hWX;
    private com.baidu.tbadk.core.dialog.a hWY;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bOU();

        void bOW();

        boolean bOX();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hWQ = null;
        this.hWR = null;
        this.mViewPager = null;
        this.hWS = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.hWT = null;
        this.hWV = 120;
        this.hWW = 120;
        this.mIsFromIm = z;
        this.hWQ = writeMultiImgsActivity;
        this.hWX = hVar;
        this.hWV = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds720);
        this.hWW = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hWR = new ImageFileInfo[this.mCount];
        this.hWT = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hWR[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hWR[i2].addPageAction(com.baidu.tbadk.img.effect.d.L(this.hWV, this.hWW));
            linkedList.set(i2, this.hWR[i2]);
            this.hWR[i2].mCount = 0;
        }
        this.mCurrentIndex = i;
        this.mViewPager = viewPager;
        this.hWS = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bOQ() {
        return (this.hWT == null || this.mCurrentIndex >= this.hWT.length || this.hWT[this.mCurrentIndex] == null || this.hWR == null || this.mCurrentIndex >= this.hWR.length || this.hWR[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean bOR() {
        if (this.mCurrentIndex >= this.hWR.length || this.hWR[this.mCurrentIndex] == null || !this.hWR[this.mCurrentIndex].isGif() || this.hWR[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.hWR[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bOR()) {
            if (this.hWS != null) {
                this.hWS.J(i, z);
            }
        } else if (z) {
            xs(i);
        } else if (bOQ() && (bVar = this.hWT[this.mCurrentIndex]) != null && (imageFileInfo = this.hWR[this.mCurrentIndex]) != null && bVar.bOY()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.gb(i));
            this.hWQ.bPU();
            bVar.h(imageFileInfo);
        }
    }

    private void xs(int i) {
        this.hWU = i;
        if (this.hWY == null) {
            this.hWY = new com.baidu.tbadk.core.dialog.a(this.hWQ);
            this.hWY.db(e.j.rorate_tip);
            this.hWY.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hWY != null) {
                        MultiImagePagerAdapter.this.hWY.dismiss();
                    }
                    MultiImagePagerAdapter.this.hWX.hZl.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bOT() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bOU() {
                            MultiImagePagerAdapter.this.hWS.bOU();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bOV() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.hWU, false);
                }
            });
            this.hWY.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hWY != null) {
                        MultiImagePagerAdapter.this.hWY.dismiss();
                    }
                }
            });
            this.hWY.b(this.hWQ.getPageContext());
        }
        this.hWY.BF();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hWT[i] == null) {
            this.hWT[i] = new b(i);
        }
        this.mViewPager.addView(this.hWT[i].getView());
        return this.hWT[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hWT[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        bOS();
    }

    private void bOS() {
        if (this.mCurrentIndex >= 0 && this.hWT != null && this.mCurrentIndex < this.hWT.length && this.mCurrentIndex < this.hWR.length && this.hWR[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.hWT.length; i++) {
                if (this.hWT[i] != null) {
                    this.hWT[i].aoi();
                }
            }
            if (this.hWT[this.mCurrentIndex] == null) {
                this.hWT[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.hWT[this.mCurrentIndex].h(this.hWR[this.mCurrentIndex]);
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

    private boolean e(String str, Bitmap bitmap) {
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
    public void oC(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hWR != null) {
            for (int i = 0; i < this.hWR.length; i++) {
                ImageFileInfo imageFileInfo = this.hWR[i];
                if (imageFileInfo != null) {
                    this.hWR[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bOQ()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.hWS != null && this.hWS.bOX() && this.hWX != null && this.hWX.hZl != null) {
                this.hWX.hZl.beC();
                TbImageView tbImageView = this.hWT[this.mCurrentIndex].flm;
                try {
                    bitmap = this.hWX.hZl.bQx();
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
                        this.hWR[this.mCurrentIndex].setFilePath(l.b(l.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hWR[this.mCurrentIndex].clearAllActions();
                        this.hWR[this.mCurrentIndex].clearPageActions();
                        this.hWR[this.mCurrentIndex].setIsGif(false);
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
            if (e(str, bitmap)) {
                this.hWR[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView flm;
        private FrameLayout hXb;
        private com.baidu.tbadk.img.b hXc;
        private ProgressBar hfM;
        private int index;

        public b(int i) {
            this.hfM = null;
            this.index = -1;
            this.index = i;
            this.hXb = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hWQ.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.flm = (TbImageView) this.hXb.findViewById(e.g.progress_tb_imageview);
            this.flm.setClickable(true);
            this.flm.setDefaultResource(0);
            this.flm.setDefaultErrorResource(0);
            this.flm.setDefaultBgResource(0);
            this.flm.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.flm.setPadding(0, 0, 0, 0);
            this.hXc = new com.baidu.tbadk.img.b();
            this.flm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hWS != null) {
                        MultiImagePagerAdapter.this.hWS.bOW();
                    }
                }
            });
            this.hfM = (ProgressBar) this.hXb.findViewById(e.g.progress_tb_imageview_progress);
            this.hfM.setVisibility(8);
        }

        public View getView() {
            return this.hXb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.flm != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.hWQ), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.hWQ) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.hWQ, e.C0210e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.flm.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.flm.setLayoutParams(layoutParams);
                aVar.a(this.flm);
                if (MultiImagePagerAdapter.this.hWX != null && MultiImagePagerAdapter.this.hWX.hZl != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hWX.hZl.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hWX.hZl.setLayoutParams(layoutParams2);
                }
                if (aVar.op() != null && !aVar.op().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.op();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aoi();
                this.hfM.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hXc.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.hfM.setVisibility(8);
                    return;
                }
                this.hXc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.hfM.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hWX != null) {
                            MultiImagePagerAdapter.this.hWX.bOL();
                        }
                    }
                }, false);
            }
        }

        public void aoi() {
            if (this.hXc != null) {
                this.hXc.NE();
            }
            if (this.flm != null) {
            }
        }

        public boolean bOY() {
            return this.hfM.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

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
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int aFG;
    private WriteMultiImgsActivity hfV;
    private ImageFileInfo[] hfW;
    private a hfX;
    private b[] hfY;
    private int hfZ;
    private int hga;
    private h hgb;
    private com.baidu.tbadk.core.dialog.a hgc;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bCT();

        void bCV();

        boolean bCW();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hfV = null;
        this.hfW = null;
        this.mViewPager = null;
        this.hfX = null;
        this.mCount = 0;
        this.aFG = 0;
        this.hfY = null;
        this.hfZ = 120;
        this.hga = 120;
        this.mIsFromIm = z;
        this.hfV = writeMultiImgsActivity;
        this.hgb = hVar;
        this.hfZ = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hga = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hfW = new ImageFileInfo[this.mCount];
        this.hfY = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hfW[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hfW[i2].addPageAction(com.baidu.tbadk.img.effect.d.G(this.hfZ, this.hga));
            linkedList.set(i2, this.hfW[i2]);
            this.hfW[i2].mCount = 0;
        }
        this.aFG = i;
        this.mViewPager = viewPager;
        this.hfX = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hfY == null || this.aFG >= this.hfY.length || this.hfY[this.aFG] == null || this.hfW == null || this.aFG >= this.hfW.length || this.hfW[this.aFG] == null) ? false : true;
    }

    public boolean bCQ() {
        if (this.aFG >= this.hfW.length || this.hfW[this.aFG] == null || !this.hfW[this.aFG].isGif() || this.hfW[this.aFG].mCount > 0) {
            return false;
        }
        this.hfW[this.aFG].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bCQ()) {
            if (this.hfX != null) {
                this.hfX.J(i, z);
            }
        } else if (z) {
            vg(i);
        } else if (checkValid() && (bVar = this.hfY[this.aFG]) != null && (imageFileInfo = this.hfW[this.aFG]) != null && bVar.bCX()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.eY(i));
            this.hfV.bDT();
            bVar.h(imageFileInfo);
        }
    }

    private void vg(final int i) {
        if (this.hgc == null) {
            this.hgc = new com.baidu.tbadk.core.dialog.a(this.hfV);
            this.hgc.bZ(d.k.rorate_tip);
            this.hgc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hgc != null) {
                        MultiImagePagerAdapter.this.hgc.dismiss();
                    }
                    MultiImagePagerAdapter.this.hgb.hip.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCS() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCT() {
                            MultiImagePagerAdapter.this.hfX.bCT();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean H(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCU() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(i, false);
                }
            });
            this.hgc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hgc != null) {
                        MultiImagePagerAdapter.this.hgc.dismiss();
                    }
                }
            });
            this.hgc.b(this.hfV.getPageContext());
        }
        this.hgc.tD();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hfY[i] == null) {
            this.hfY[i] = new b(i);
        }
        this.mViewPager.addView(this.hfY[i].getView());
        return this.hfY[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hfY[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aFG = i;
        bCR();
    }

    private void bCR() {
        if (this.aFG >= 0 && this.hfY != null && this.aFG < this.hfY.length && this.aFG < this.hfW.length && this.hfW[this.aFG] != null) {
            for (int i = 0; i < this.hfY.length; i++) {
                if (this.hfY[i] != null) {
                    this.hfY[i].aep();
                }
            }
            if (this.hfY[this.aFG] == null) {
                this.hfY[this.aFG] = new b(this.aFG);
            }
            this.hfY[this.aFG].h(this.hfW[this.aFG]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aFG;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (com.baidu.tbadk.core.util.k.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nu(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hfW != null) {
            for (int i = 0; i < this.hfW.length; i++) {
                ImageFileInfo imageFileInfo = this.hfW[i];
                if (imageFileInfo != null) {
                    this.hfW[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    G(this.mBitmap);
                }
            } else if (this.hfX != null && this.hfX.bCW() && this.hgb != null && this.hgb.hip != null) {
                this.hgb.hip.aTV();
                TbImageView tbImageView = this.hfY[this.aFG].etS;
                try {
                    bitmap = this.hgb.hip.bEw();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.d.R(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.d.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.hfW[this.aFG].setFilePath(com.baidu.tbadk.core.util.k.b(com.baidu.tbadk.core.util.k.uF(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hfW[this.aFG].clearAllActions();
                        this.hfW[this.aFG].clearPageActions();
                        this.hfW[this.aFG].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            G(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                G(this.mBitmap);
            }
        }
    }

    private void G(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.hfW[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView etS;
        private ProgressBar gre;
        private FrameLayout hgf;
        private com.baidu.tbadk.img.b hgg;
        private int index;

        public b(int i) {
            this.gre = null;
            this.index = -1;
            this.index = i;
            this.hgf = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hfV.getPageContext().getContext()).inflate(d.i.progress_tb_imageview, (ViewGroup) null);
            this.etS = (TbImageView) this.hgf.findViewById(d.g.progress_tb_imageview);
            this.etS.setClickable(true);
            this.etS.setDefaultResource(0);
            this.etS.setDefaultErrorResource(0);
            this.etS.setDefaultBgResource(0);
            this.etS.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.etS.setPadding(0, 0, 0, 0);
            this.hgg = new com.baidu.tbadk.img.b();
            this.etS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (MultiImagePagerAdapter.this.hfX != null) {
                        MultiImagePagerAdapter.this.hfX.bCV();
                    }
                }
            });
            this.gre = (ProgressBar) this.hgf.findViewById(d.g.progress_tb_imageview_progress);
            this.gre.setVisibility(8);
        }

        public View getView() {
            return this.hgf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.etS != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.hfV), (l.ah(MultiImagePagerAdapter.this.hfV) - l.e(MultiImagePagerAdapter.this.hfV, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.etS.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.etS.setLayoutParams(layoutParams);
                aVar.a(this.etS);
                if (MultiImagePagerAdapter.this.hgb != null && MultiImagePagerAdapter.this.hgb.hip != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hgb.hip.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hgb.hip.setLayoutParams(layoutParams2);
                }
                if (aVar.km() != null && !aVar.km().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.km();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aep();
                com.baidu.adp.widget.ImageView.a a = this.hgg.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                } else {
                    this.hgg.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            b.this.a(imageFileInfo, aVar);
                            if (MultiImagePagerAdapter.this.hgb != null) {
                                MultiImagePagerAdapter.this.hgb.bCL();
                            }
                        }
                    }, false);
                }
            }
        }

        public void aep() {
            if (this.hgg != null) {
                this.hgg.Fk();
            }
            if (this.etS != null) {
                this.etS.setImageDrawable(null);
            }
        }

        public boolean bCX() {
            return this.gre.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

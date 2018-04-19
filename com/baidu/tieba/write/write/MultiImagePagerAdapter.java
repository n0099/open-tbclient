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
    private WriteMultiImgsActivity hfY;
    private ImageFileInfo[] hfZ;
    private a hga;
    private b[] hgb;
    private int hgc;
    private int hgd;
    private h hge;
    private com.baidu.tbadk.core.dialog.a hgf;
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
        this.hfY = null;
        this.hfZ = null;
        this.mViewPager = null;
        this.hga = null;
        this.mCount = 0;
        this.aFG = 0;
        this.hgb = null;
        this.hgc = 120;
        this.hgd = 120;
        this.mIsFromIm = z;
        this.hfY = writeMultiImgsActivity;
        this.hge = hVar;
        this.hgc = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hgd = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hfZ = new ImageFileInfo[this.mCount];
        this.hgb = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hfZ[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hfZ[i2].addPageAction(com.baidu.tbadk.img.effect.d.G(this.hgc, this.hgd));
            linkedList.set(i2, this.hfZ[i2]);
            this.hfZ[i2].mCount = 0;
        }
        this.aFG = i;
        this.mViewPager = viewPager;
        this.hga = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hgb == null || this.aFG >= this.hgb.length || this.hgb[this.aFG] == null || this.hfZ == null || this.aFG >= this.hfZ.length || this.hfZ[this.aFG] == null) ? false : true;
    }

    public boolean bCQ() {
        if (this.aFG >= this.hfZ.length || this.hfZ[this.aFG] == null || !this.hfZ[this.aFG].isGif() || this.hfZ[this.aFG].mCount > 0) {
            return false;
        }
        this.hfZ[this.aFG].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bCQ()) {
            if (this.hga != null) {
                this.hga.J(i, z);
            }
        } else if (z) {
            vg(i);
        } else if (checkValid() && (bVar = this.hgb[this.aFG]) != null && (imageFileInfo = this.hfZ[this.aFG]) != null && bVar.bCX()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.eY(i));
            this.hfY.bDT();
            bVar.h(imageFileInfo);
        }
    }

    private void vg(final int i) {
        if (this.hgf == null) {
            this.hgf = new com.baidu.tbadk.core.dialog.a(this.hfY);
            this.hgf.bZ(d.k.rorate_tip);
            this.hgf.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hgf != null) {
                        MultiImagePagerAdapter.this.hgf.dismiss();
                    }
                    MultiImagePagerAdapter.this.hge.his.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCS() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCT() {
                            MultiImagePagerAdapter.this.hga.bCT();
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
            this.hgf.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hgf != null) {
                        MultiImagePagerAdapter.this.hgf.dismiss();
                    }
                }
            });
            this.hgf.b(this.hfY.getPageContext());
        }
        this.hgf.tD();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hgb[i] == null) {
            this.hgb[i] = new b(i);
        }
        this.mViewPager.addView(this.hgb[i].getView());
        return this.hgb[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hgb[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aFG = i;
        bCR();
    }

    private void bCR() {
        if (this.aFG >= 0 && this.hgb != null && this.aFG < this.hgb.length && this.aFG < this.hfZ.length && this.hfZ[this.aFG] != null) {
            for (int i = 0; i < this.hgb.length; i++) {
                if (this.hgb[i] != null) {
                    this.hgb[i].aep();
                }
            }
            if (this.hgb[this.aFG] == null) {
                this.hgb[this.aFG] = new b(this.aFG);
            }
            this.hgb[this.aFG].h(this.hfZ[this.aFG]);
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
        if (this.hfZ != null) {
            for (int i = 0; i < this.hfZ.length; i++) {
                ImageFileInfo imageFileInfo = this.hfZ[i];
                if (imageFileInfo != null) {
                    this.hfZ[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    G(this.mBitmap);
                }
            } else if (this.hga != null && this.hga.bCW() && this.hge != null && this.hge.his != null) {
                this.hge.his.aTV();
                TbImageView tbImageView = this.hgb[this.aFG].etV;
                try {
                    bitmap = this.hge.his.bEw();
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
                        this.hfZ[this.aFG].setFilePath(com.baidu.tbadk.core.util.k.b(com.baidu.tbadk.core.util.k.uF(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hfZ[this.aFG].clearAllActions();
                        this.hfZ[this.aFG].clearPageActions();
                        this.hfZ[this.aFG].setIsGif(false);
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
                this.hfZ[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView etV;
        private ProgressBar grh;
        private FrameLayout hgi;
        private com.baidu.tbadk.img.b hgj;
        private int index;

        public b(int i) {
            this.grh = null;
            this.index = -1;
            this.index = i;
            this.hgi = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hfY.getPageContext().getContext()).inflate(d.i.progress_tb_imageview, (ViewGroup) null);
            this.etV = (TbImageView) this.hgi.findViewById(d.g.progress_tb_imageview);
            this.etV.setClickable(true);
            this.etV.setDefaultResource(0);
            this.etV.setDefaultErrorResource(0);
            this.etV.setDefaultBgResource(0);
            this.etV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.etV.setPadding(0, 0, 0, 0);
            this.hgj = new com.baidu.tbadk.img.b();
            this.etV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (MultiImagePagerAdapter.this.hga != null) {
                        MultiImagePagerAdapter.this.hga.bCV();
                    }
                }
            });
            this.grh = (ProgressBar) this.hgi.findViewById(d.g.progress_tb_imageview_progress);
            this.grh.setVisibility(8);
        }

        public View getView() {
            return this.hgi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.etV != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.hfY), (l.ah(MultiImagePagerAdapter.this.hfY) - l.e(MultiImagePagerAdapter.this.hfY, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.etV.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.etV.setLayoutParams(layoutParams);
                aVar.a(this.etV);
                if (MultiImagePagerAdapter.this.hge != null && MultiImagePagerAdapter.this.hge.his != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hge.his.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hge.his.setLayoutParams(layoutParams2);
                }
                if (aVar.km() != null && !aVar.km().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.km();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aep();
                com.baidu.adp.widget.ImageView.a a = this.hgj.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                } else {
                    this.hgj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            b.this.a(imageFileInfo, aVar);
                            if (MultiImagePagerAdapter.this.hge != null) {
                                MultiImagePagerAdapter.this.hge.bCL();
                            }
                        }
                    }, false);
                }
            }
        }

        public void aep() {
            if (this.hgj != null) {
                this.hgj.Fk();
            }
            if (this.etV != null) {
                this.etV.setImageDrawable(null);
            }
        }

        public boolean bCX() {
            return this.grh.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

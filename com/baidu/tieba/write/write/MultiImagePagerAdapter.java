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
    private int aFH;
    private WriteMultiImgsActivity hgZ;
    private ImageFileInfo[] hha;
    private a hhb;
    private b[] hhc;
    private int hhd;
    private int hhe;
    private h hhf;
    private com.baidu.tbadk.core.dialog.a hhg;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bCR();

        void bCT();

        boolean bCU();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hgZ = null;
        this.hha = null;
        this.mViewPager = null;
        this.hhb = null;
        this.mCount = 0;
        this.aFH = 0;
        this.hhc = null;
        this.hhd = 120;
        this.hhe = 120;
        this.mIsFromIm = z;
        this.hgZ = writeMultiImgsActivity;
        this.hhf = hVar;
        this.hhd = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hhe = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hha = new ImageFileInfo[this.mCount];
        this.hhc = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hha[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hha[i2].addPageAction(com.baidu.tbadk.img.effect.d.G(this.hhd, this.hhe));
            linkedList.set(i2, this.hha[i2]);
            this.hha[i2].mCount = 0;
        }
        this.aFH = i;
        this.mViewPager = viewPager;
        this.hhb = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hhc == null || this.aFH >= this.hhc.length || this.hhc[this.aFH] == null || this.hha == null || this.aFH >= this.hha.length || this.hha[this.aFH] == null) ? false : true;
    }

    public boolean bCO() {
        if (this.aFH >= this.hha.length || this.hha[this.aFH] == null || !this.hha[this.aFH].isGif() || this.hha[this.aFH].mCount > 0) {
            return false;
        }
        this.hha[this.aFH].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bCO()) {
            if (this.hhb != null) {
                this.hhb.J(i, z);
            }
        } else if (z) {
            vf(i);
        } else if (checkValid() && (bVar = this.hhc[this.aFH]) != null && (imageFileInfo = this.hha[this.aFH]) != null && bVar.bCV()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.eZ(i));
            this.hgZ.bDR();
            bVar.h(imageFileInfo);
        }
    }

    private void vf(final int i) {
        if (this.hhg == null) {
            this.hhg = new com.baidu.tbadk.core.dialog.a(this.hgZ);
            this.hhg.ca(d.k.rorate_tip);
            this.hhg.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hhg != null) {
                        MultiImagePagerAdapter.this.hhg.dismiss();
                    }
                    MultiImagePagerAdapter.this.hhf.hjt.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCQ() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCR() {
                            MultiImagePagerAdapter.this.hhb.bCR();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean H(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bCS() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(i, false);
                }
            });
            this.hhg.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hhg != null) {
                        MultiImagePagerAdapter.this.hhg.dismiss();
                    }
                }
            });
            this.hhg.b(this.hgZ.getPageContext());
        }
        this.hhg.tC();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hhc[i] == null) {
            this.hhc[i] = new b(i);
        }
        this.mViewPager.addView(this.hhc[i].getView());
        return this.hhc[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hhc[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aFH = i;
        bCP();
    }

    private void bCP() {
        if (this.aFH >= 0 && this.hhc != null && this.aFH < this.hhc.length && this.aFH < this.hha.length && this.hha[this.aFH] != null) {
            for (int i = 0; i < this.hhc.length; i++) {
                if (this.hhc[i] != null) {
                    this.hhc[i].aep();
                }
            }
            if (this.hhc[this.aFH] == null) {
                this.hhc[this.aFH] = new b(this.aFH);
            }
            this.hhc[this.aFH].h(this.hha[this.aFH]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aFH;
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
    public void nv(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hha != null) {
            for (int i = 0; i < this.hha.length; i++) {
                ImageFileInfo imageFileInfo = this.hha[i];
                if (imageFileInfo != null) {
                    this.hha[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    G(this.mBitmap);
                }
            } else if (this.hhb != null && this.hhb.bCU() && this.hhf != null && this.hhf.hjt != null) {
                this.hhf.hjt.aTV();
                TbImageView tbImageView = this.hhc[this.aFH].eva;
                try {
                    bitmap = this.hhf.hjt.bEu();
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
                        this.hha[this.aFH].setFilePath(com.baidu.tbadk.core.util.k.b(com.baidu.tbadk.core.util.k.uE(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hha[this.aFH].clearAllActions();
                        this.hha[this.aFH].clearPageActions();
                        this.hha[this.aFH].setIsGif(false);
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
                this.hha[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView eva;
        private ProgressBar gsj;
        private FrameLayout hhj;
        private com.baidu.tbadk.img.b hhk;
        private int index;

        public b(int i) {
            this.gsj = null;
            this.index = -1;
            this.index = i;
            this.hhj = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hgZ.getPageContext().getContext()).inflate(d.i.progress_tb_imageview, (ViewGroup) null);
            this.eva = (TbImageView) this.hhj.findViewById(d.g.progress_tb_imageview);
            this.eva.setClickable(true);
            this.eva.setDefaultResource(0);
            this.eva.setDefaultErrorResource(0);
            this.eva.setDefaultBgResource(0);
            this.eva.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eva.setPadding(0, 0, 0, 0);
            this.hhk = new com.baidu.tbadk.img.b();
            this.eva.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (MultiImagePagerAdapter.this.hhb != null) {
                        MultiImagePagerAdapter.this.hhb.bCT();
                    }
                }
            });
            this.gsj = (ProgressBar) this.hhj.findViewById(d.g.progress_tb_imageview_progress);
            this.gsj.setVisibility(8);
        }

        public View getView() {
            return this.hhj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.eva != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.hgZ), (l.ah(MultiImagePagerAdapter.this.hgZ) - l.e(MultiImagePagerAdapter.this.hgZ, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eva.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.eva.setLayoutParams(layoutParams);
                aVar.a(this.eva);
                if (MultiImagePagerAdapter.this.hhf != null && MultiImagePagerAdapter.this.hhf.hjt != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hhf.hjt.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hhf.hjt.setLayoutParams(layoutParams2);
                }
                if (aVar.kl() != null && !aVar.kl().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.kl();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aep();
                com.baidu.adp.widget.ImageView.a a = this.hhk.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                } else {
                    this.hhk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            b.this.a(imageFileInfo, aVar);
                            if (MultiImagePagerAdapter.this.hhf != null) {
                                MultiImagePagerAdapter.this.hhf.bCJ();
                            }
                        }
                    }, false);
                }
            }
        }

        public void aep() {
            if (this.hhk != null) {
                this.hhk.Fi();
            }
            if (this.eva != null) {
                this.eva.setImageDrawable(null);
            }
        }

        public boolean bCV() {
            return this.gsj.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

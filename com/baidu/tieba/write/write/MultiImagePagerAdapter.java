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
import com.baidu.tieba.d;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int aOZ;
    private WriteMultiImgsActivity hxd;
    private ImageFileInfo[] hxe;
    private a hxf;
    private b[] hxg;
    private int hxh;
    private int hxi;
    private int hxj;
    private h hxk;
    private com.baidu.tbadk.core.dialog.a hxl;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        boolean bIA();

        void bIx();

        void bIz();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hxd = null;
        this.hxe = null;
        this.mViewPager = null;
        this.hxf = null;
        this.mCount = 0;
        this.aOZ = 0;
        this.hxg = null;
        this.hxi = 120;
        this.hxj = 120;
        this.mIsFromIm = z;
        this.hxd = writeMultiImgsActivity;
        this.hxk = hVar;
        this.hxi = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hxj = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hxe = new ImageFileInfo[this.mCount];
        this.hxg = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hxe[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hxe[i2].addPageAction(com.baidu.tbadk.img.effect.d.H(this.hxi, this.hxj));
            linkedList.set(i2, this.hxe[i2]);
            this.hxe[i2].mCount = 0;
        }
        this.aOZ = i;
        this.mViewPager = viewPager;
        this.hxf = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hxg == null || this.aOZ >= this.hxg.length || this.hxg[this.aOZ] == null || this.hxe == null || this.aOZ >= this.hxe.length || this.hxe[this.aOZ] == null) ? false : true;
    }

    public boolean bIu() {
        if (this.aOZ >= this.hxe.length || this.hxe[this.aOZ] == null || !this.hxe[this.aOZ].isGif() || this.hxe[this.aOZ].mCount > 0) {
            return false;
        }
        this.hxe[this.aOZ].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bIu()) {
            if (this.hxf != null) {
                this.hxf.J(i, z);
            }
        } else if (z) {
            vG(i);
        } else if (checkValid() && (bVar = this.hxg[this.aOZ]) != null && (imageFileInfo = this.hxe[this.aOZ]) != null && bVar.bIB()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fe(i));
            this.hxd.bJx();
            bVar.h(imageFileInfo);
        }
    }

    private void vG(int i) {
        this.hxh = i;
        if (this.hxl == null) {
            this.hxl = new com.baidu.tbadk.core.dialog.a(this.hxd);
            this.hxl.cd(d.k.rorate_tip);
            this.hxl.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hxl != null) {
                        MultiImagePagerAdapter.this.hxl.dismiss();
                    }
                    MultiImagePagerAdapter.this.hxk.hzx.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIw() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIx() {
                            MultiImagePagerAdapter.this.hxf.bIx();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIy() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.hxh, false);
                }
            });
            this.hxl.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hxl != null) {
                        MultiImagePagerAdapter.this.hxl.dismiss();
                    }
                }
            });
            this.hxl.b(this.hxd.getPageContext());
        }
        this.hxl.xn();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hxg[i] == null) {
            this.hxg[i] = new b(i);
        }
        this.mViewPager.addView(this.hxg[i].getView());
        return this.hxg[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hxg[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aOZ = i;
        bIv();
    }

    private void bIv() {
        if (this.aOZ >= 0 && this.hxg != null && this.aOZ < this.hxg.length && this.aOZ < this.hxe.length && this.hxe[this.aOZ] != null) {
            for (int i = 0; i < this.hxg.length; i++) {
                if (this.hxg[i] != null) {
                    this.hxg[i].ahf();
                }
            }
            if (this.hxg[this.aOZ] == null) {
                this.hxg[this.aOZ] = new b(this.aOZ);
            }
            this.hxg[this.aOZ].h(this.hxe[this.aOZ]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aOZ;
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
    public void nL(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hxe != null) {
            for (int i = 0; i < this.hxe.length; i++) {
                ImageFileInfo imageFileInfo = this.hxe[i];
                if (imageFileInfo != null) {
                    this.hxe[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.hxf != null && this.hxf.bIA() && this.hxk != null && this.hxk.hzx != null) {
                this.hxk.hzx.aZy();
                TbImageView tbImageView = this.hxg[this.aOZ].eKh;
                try {
                    bitmap = this.hxk.hzx.bKa();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.d.S(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.d.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.hxe[this.aOZ].setFilePath(l.b(l.ys(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hxe[this.aOZ].clearAllActions();
                        this.hxe[this.aOZ].clearPageActions();
                        this.hxe[this.aOZ].setIsGif(false);
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
                this.hxe[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView eKh;
        private ProgressBar gHA;
        private FrameLayout hxo;
        private com.baidu.tbadk.img.b hxp;
        private int index;

        public b(int i) {
            this.gHA = null;
            this.index = -1;
            this.index = i;
            this.hxo = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hxd.getPageContext().getContext()).inflate(d.i.progress_tb_imageview, (ViewGroup) null);
            this.eKh = (TbImageView) this.hxo.findViewById(d.g.progress_tb_imageview);
            this.eKh.setClickable(true);
            this.eKh.setDefaultResource(0);
            this.eKh.setDefaultErrorResource(0);
            this.eKh.setDefaultBgResource(0);
            this.eKh.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eKh.setPadding(0, 0, 0, 0);
            this.hxp = new com.baidu.tbadk.img.b();
            this.eKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hxf != null) {
                        MultiImagePagerAdapter.this.hxf.bIz();
                    }
                }
            });
            this.gHA = (ProgressBar) this.hxo.findViewById(d.g.progress_tb_imageview_progress);
            this.gHA.setVisibility(8);
        }

        public View getView() {
            return this.hxo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.eKh != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.ah(MultiImagePagerAdapter.this.hxd), (com.baidu.adp.lib.util.l.aj(MultiImagePagerAdapter.this.hxd) - com.baidu.adp.lib.util.l.e(MultiImagePagerAdapter.this.hxd, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eKh.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.eKh.setLayoutParams(layoutParams);
                aVar.a(this.eKh);
                if (MultiImagePagerAdapter.this.hxk != null && MultiImagePagerAdapter.this.hxk.hzx != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hxk.hzx.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.hxk.hzx.setLayoutParams(layoutParams2);
                }
                if (aVar.mZ() != null && !aVar.mZ().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.mZ();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                ahf();
                this.gHA.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hxp.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gHA.setVisibility(8);
                    return;
                }
                this.hxp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gHA.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hxk != null) {
                            MultiImagePagerAdapter.this.hxk.bIp();
                        }
                    }
                }, false);
            }
        }

        public void ahf() {
            if (this.hxp != null) {
                this.hxp.Jf();
            }
            if (this.eKh != null) {
            }
        }

        public boolean bIB() {
            return this.gHA.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

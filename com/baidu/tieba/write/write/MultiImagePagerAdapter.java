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
    private int aOd;
    private WriteMultiImgsActivity hsV;
    private ImageFileInfo[] hsW;
    private a hsX;
    private b[] hsY;
    private int hsZ;
    private int hta;
    private h htb;
    private com.baidu.tbadk.core.dialog.a htc;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bHW();

        void bHY();

        boolean bHZ();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hsV = null;
        this.hsW = null;
        this.mViewPager = null;
        this.hsX = null;
        this.mCount = 0;
        this.aOd = 0;
        this.hsY = null;
        this.hsZ = 120;
        this.hta = 120;
        this.mIsFromIm = z;
        this.hsV = writeMultiImgsActivity;
        this.htb = hVar;
        this.hsZ = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hta = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hsW = new ImageFileInfo[this.mCount];
        this.hsY = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hsW[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hsW[i2].addPageAction(com.baidu.tbadk.img.effect.d.H(this.hsZ, this.hta));
            linkedList.set(i2, this.hsW[i2]);
            this.hsW[i2].mCount = 0;
        }
        this.aOd = i;
        this.mViewPager = viewPager;
        this.hsX = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hsY == null || this.aOd >= this.hsY.length || this.hsY[this.aOd] == null || this.hsW == null || this.aOd >= this.hsW.length || this.hsW[this.aOd] == null) ? false : true;
    }

    public boolean bHT() {
        if (this.aOd >= this.hsW.length || this.hsW[this.aOd] == null || !this.hsW[this.aOd].isGif() || this.hsW[this.aOd].mCount > 0) {
            return false;
        }
        this.hsW[this.aOd].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bHT()) {
            if (this.hsX != null) {
                this.hsX.J(i, z);
            }
        } else if (z) {
            vx(i);
        } else if (checkValid() && (bVar = this.hsY[this.aOd]) != null && (imageFileInfo = this.hsW[this.aOd]) != null && bVar.bIa()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fd(i));
            this.hsV.bIW();
            bVar.h(imageFileInfo);
        }
    }

    private void vx(final int i) {
        if (this.htc == null) {
            this.htc = new com.baidu.tbadk.core.dialog.a(this.hsV);
            this.htc.cc(d.k.rorate_tip);
            this.htc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.htc != null) {
                        MultiImagePagerAdapter.this.htc.dismiss();
                    }
                    MultiImagePagerAdapter.this.htb.hvo.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHV() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHW() {
                            MultiImagePagerAdapter.this.hsX.bHW();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHX() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(i, false);
                }
            });
            this.htc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.htc != null) {
                        MultiImagePagerAdapter.this.htc.dismiss();
                    }
                }
            });
            this.htc.b(this.hsV.getPageContext());
        }
        this.htc.xa();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hsY[i] == null) {
            this.hsY[i] = new b(i);
        }
        this.mViewPager.addView(this.hsY[i].getView());
        return this.hsY[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hsY[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aOd = i;
        bHU();
    }

    private void bHU() {
        if (this.aOd >= 0 && this.hsY != null && this.aOd < this.hsY.length && this.aOd < this.hsW.length && this.hsW[this.aOd] != null) {
            for (int i = 0; i < this.hsY.length; i++) {
                if (this.hsY[i] != null) {
                    this.hsY[i].ahM();
                }
            }
            if (this.hsY[this.aOd] == null) {
                this.hsY[this.aOd] = new b(this.aOd);
            }
            this.hsY[this.aOd].h(this.hsW[this.aOd]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aOd;
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
    public void nD(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hsW != null) {
            for (int i = 0; i < this.hsW.length; i++) {
                ImageFileInfo imageFileInfo = this.hsW[i];
                if (imageFileInfo != null) {
                    this.hsW[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.hsX != null && this.hsX.bHZ() && this.htb != null && this.htb.hvo != null) {
                this.htb.hvo.aYR();
                TbImageView tbImageView = this.hsY[this.aOd].eGr;
                try {
                    bitmap = this.htb.hvo.bJz();
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
                        this.hsW[this.aOd].setFilePath(l.b(l.ye(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hsW[this.aOd].clearAllActions();
                        this.hsW[this.aOd].clearPageActions();
                        this.hsW[this.aOd].setIsGif(false);
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
                this.hsW[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView eGr;
        private ProgressBar gDH;
        private FrameLayout htf;
        private com.baidu.tbadk.img.b htg;
        private int index;

        public b(int i) {
            this.gDH = null;
            this.index = -1;
            this.index = i;
            this.htf = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hsV.getPageContext().getContext()).inflate(d.i.progress_tb_imageview, (ViewGroup) null);
            this.eGr = (TbImageView) this.htf.findViewById(d.g.progress_tb_imageview);
            this.eGr.setClickable(true);
            this.eGr.setDefaultResource(0);
            this.eGr.setDefaultErrorResource(0);
            this.eGr.setDefaultBgResource(0);
            this.eGr.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eGr.setPadding(0, 0, 0, 0);
            this.htg = new com.baidu.tbadk.img.b();
            this.eGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hsX != null) {
                        MultiImagePagerAdapter.this.hsX.bHY();
                    }
                }
            });
            this.gDH = (ProgressBar) this.htf.findViewById(d.g.progress_tb_imageview_progress);
            this.gDH.setVisibility(8);
        }

        public View getView() {
            return this.htf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.eGr != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.ah(MultiImagePagerAdapter.this.hsV), (com.baidu.adp.lib.util.l.aj(MultiImagePagerAdapter.this.hsV) - com.baidu.adp.lib.util.l.e(MultiImagePagerAdapter.this.hsV, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eGr.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.eGr.setLayoutParams(layoutParams);
                aVar.a(this.eGr);
                if (MultiImagePagerAdapter.this.htb != null && MultiImagePagerAdapter.this.htb.hvo != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.htb.hvo.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.htb.hvo.setLayoutParams(layoutParams2);
                }
                if (aVar.mZ() != null && !aVar.mZ().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.mZ();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                ahM();
                this.gDH.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.htg.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gDH.setVisibility(8);
                    return;
                }
                this.htg.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gDH.setVisibility(8);
                        if (MultiImagePagerAdapter.this.htb != null) {
                            MultiImagePagerAdapter.this.htb.bHO();
                        }
                    }
                }, false);
            }
        }

        public void ahM() {
            if (this.htg != null) {
                this.htg.IN();
            }
            if (this.eGr != null) {
            }
        }

        public boolean bIa() {
            return this.gDH.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

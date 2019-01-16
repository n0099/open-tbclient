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
    private WriteMultiImgsActivity ibi;
    private ImageFileInfo[] ibj;
    private a ibk;
    private b[] ibl;
    private int ibm;
    private int ibn;
    private int ibo;
    private h ibp;
    private com.baidu.tbadk.core.dialog.a ibq;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bQt();

        void bQv();

        boolean bQw();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.ibi = null;
        this.ibj = null;
        this.mViewPager = null;
        this.ibk = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.ibl = null;
        this.ibn = 120;
        this.ibo = 120;
        this.mIsFromIm = z;
        this.ibi = writeMultiImgsActivity;
        this.ibp = hVar;
        this.ibn = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds720);
        this.ibo = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.ibj = new ImageFileInfo[this.mCount];
        this.ibl = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.ibj[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.ibj[i2].addPageAction(com.baidu.tbadk.img.effect.d.L(this.ibn, this.ibo));
            linkedList.set(i2, this.ibj[i2]);
            this.ibj[i2].mCount = 0;
        }
        this.mCurrentIndex = i;
        this.mViewPager = viewPager;
        this.ibk = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bQp() {
        return (this.ibl == null || this.mCurrentIndex >= this.ibl.length || this.ibl[this.mCurrentIndex] == null || this.ibj == null || this.mCurrentIndex >= this.ibj.length || this.ibj[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean bQq() {
        if (this.mCurrentIndex >= this.ibj.length || this.ibj[this.mCurrentIndex] == null || !this.ibj[this.mCurrentIndex].isGif() || this.ibj[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.ibj[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bQq()) {
            if (this.ibk != null) {
                this.ibk.J(i, z);
            }
        } else if (z) {
            xH(i);
        } else if (bQp() && (bVar = this.ibl[this.mCurrentIndex]) != null && (imageFileInfo = this.ibj[this.mCurrentIndex]) != null && bVar.bQx()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.gc(i));
            this.ibi.bRt();
            bVar.h(imageFileInfo);
        }
    }

    private void xH(int i) {
        this.ibm = i;
        if (this.ibq == null) {
            this.ibq = new com.baidu.tbadk.core.dialog.a(this.ibi);
            this.ibq.db(e.j.rorate_tip);
            this.ibq.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ibq != null) {
                        MultiImagePagerAdapter.this.ibq.dismiss();
                    }
                    MultiImagePagerAdapter.this.ibp.idG.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bQs() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bQt() {
                            MultiImagePagerAdapter.this.ibk.bQt();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bQu() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.ibm, false);
                }
            });
            this.ibq.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ibq != null) {
                        MultiImagePagerAdapter.this.ibq.dismiss();
                    }
                }
            });
            this.ibq.b(this.ibi.getPageContext());
        }
        this.ibq.BS();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ibl[i] == null) {
            this.ibl[i] = new b(i);
        }
        this.mViewPager.addView(this.ibl[i].getView());
        return this.ibl[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.ibl[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        bQr();
    }

    private void bQr() {
        if (this.mCurrentIndex >= 0 && this.ibl != null && this.mCurrentIndex < this.ibl.length && this.mCurrentIndex < this.ibj.length && this.ibj[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.ibl.length; i++) {
                if (this.ibl[i] != null) {
                    this.ibl[i].apu();
                }
            }
            if (this.ibl[this.mCurrentIndex] == null) {
                this.ibl[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.ibl[this.mCurrentIndex].h(this.ibj[this.mCurrentIndex]);
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
    public void oG(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.ibj != null) {
            for (int i = 0; i < this.ibj.length; i++) {
                ImageFileInfo imageFileInfo = this.ibj[i];
                if (imageFileInfo != null) {
                    this.ibj[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bQp()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.ibk != null && this.ibk.bQw() && this.ibp != null && this.ibp.idG != null) {
                this.ibp.idG.bfO();
                TbImageView tbImageView = this.ibl[this.mCurrentIndex].foX;
                try {
                    bitmap = this.ibp.idG.bRW();
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
                        this.ibj[this.mCurrentIndex].setFilePath(l.b(l.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.ibj[this.mCurrentIndex].clearAllActions();
                        this.ibj[this.mCurrentIndex].clearPageActions();
                        this.ibj[this.mCurrentIndex].setIsGif(false);
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
                this.ibj[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView foX;
        private ProgressBar hjV;
        private FrameLayout ibt;
        private com.baidu.tbadk.img.b ibu;
        private int index;

        public b(int i) {
            this.hjV = null;
            this.index = -1;
            this.index = i;
            this.ibt = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.ibi.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.foX = (TbImageView) this.ibt.findViewById(e.g.progress_tb_imageview);
            this.foX.setClickable(true);
            this.foX.setDefaultResource(0);
            this.foX.setDefaultErrorResource(0);
            this.foX.setDefaultBgResource(0);
            this.foX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.foX.setPadding(0, 0, 0, 0);
            this.ibu = new com.baidu.tbadk.img.b();
            this.foX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.ibk != null) {
                        MultiImagePagerAdapter.this.ibk.bQv();
                    }
                }
            });
            this.hjV = (ProgressBar) this.ibt.findViewById(e.g.progress_tb_imageview_progress);
            this.hjV.setVisibility(8);
        }

        public View getView() {
            return this.ibt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.foX != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.ibi), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.ibi) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.ibi, e.C0210e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.foX.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.foX.setLayoutParams(layoutParams);
                aVar.a(this.foX);
                if (MultiImagePagerAdapter.this.ibp != null && MultiImagePagerAdapter.this.ibp.idG != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.ibp.idG.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.ibp.idG.setLayoutParams(layoutParams2);
                }
                if (aVar.ot() != null && !aVar.ot().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.ot();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                apu();
                this.hjV.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.ibu.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.hjV.setVisibility(8);
                    return;
                }
                this.ibu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.hjV.setVisibility(8);
                        if (MultiImagePagerAdapter.this.ibp != null) {
                            MultiImagePagerAdapter.this.ibp.bQk();
                        }
                    }
                }, false);
            }
        }

        public void apu() {
            if (this.ibu != null) {
                this.ibu.NW();
            }
            if (this.foX != null) {
            }
        }

        public boolean bQx() {
            return this.hjV.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

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
    private WriteMultiImgsActivity ibj;
    private ImageFileInfo[] ibk;
    private a ibl;
    private b[] ibm;
    private int ibn;
    private int ibo;
    private int ibp;
    private h ibq;
    private com.baidu.tbadk.core.dialog.a ibr;
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
        this.ibj = null;
        this.ibk = null;
        this.mViewPager = null;
        this.ibl = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.ibm = null;
        this.ibo = 120;
        this.ibp = 120;
        this.mIsFromIm = z;
        this.ibj = writeMultiImgsActivity;
        this.ibq = hVar;
        this.ibo = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds720);
        this.ibp = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.ibk = new ImageFileInfo[this.mCount];
        this.ibm = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.ibk[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.ibk[i2].addPageAction(com.baidu.tbadk.img.effect.d.L(this.ibo, this.ibp));
            linkedList.set(i2, this.ibk[i2]);
            this.ibk[i2].mCount = 0;
        }
        this.mCurrentIndex = i;
        this.mViewPager = viewPager;
        this.ibl = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bQp() {
        return (this.ibm == null || this.mCurrentIndex >= this.ibm.length || this.ibm[this.mCurrentIndex] == null || this.ibk == null || this.mCurrentIndex >= this.ibk.length || this.ibk[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean bQq() {
        if (this.mCurrentIndex >= this.ibk.length || this.ibk[this.mCurrentIndex] == null || !this.ibk[this.mCurrentIndex].isGif() || this.ibk[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.ibk[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bQq()) {
            if (this.ibl != null) {
                this.ibl.J(i, z);
            }
        } else if (z) {
            xH(i);
        } else if (bQp() && (bVar = this.ibm[this.mCurrentIndex]) != null && (imageFileInfo = this.ibk[this.mCurrentIndex]) != null && bVar.bQx()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.gc(i));
            this.ibj.bRt();
            bVar.h(imageFileInfo);
        }
    }

    private void xH(int i) {
        this.ibn = i;
        if (this.ibr == null) {
            this.ibr = new com.baidu.tbadk.core.dialog.a(this.ibj);
            this.ibr.db(e.j.rorate_tip);
            this.ibr.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ibr != null) {
                        MultiImagePagerAdapter.this.ibr.dismiss();
                    }
                    MultiImagePagerAdapter.this.ibq.idH.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bQs() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bQt() {
                            MultiImagePagerAdapter.this.ibl.bQt();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bQu() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.ibn, false);
                }
            });
            this.ibr.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ibr != null) {
                        MultiImagePagerAdapter.this.ibr.dismiss();
                    }
                }
            });
            this.ibr.b(this.ibj.getPageContext());
        }
        this.ibr.BS();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ibm[i] == null) {
            this.ibm[i] = new b(i);
        }
        this.mViewPager.addView(this.ibm[i].getView());
        return this.ibm[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.ibm[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        bQr();
    }

    private void bQr() {
        if (this.mCurrentIndex >= 0 && this.ibm != null && this.mCurrentIndex < this.ibm.length && this.mCurrentIndex < this.ibk.length && this.ibk[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.ibm.length; i++) {
                if (this.ibm[i] != null) {
                    this.ibm[i].apu();
                }
            }
            if (this.ibm[this.mCurrentIndex] == null) {
                this.ibm[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.ibm[this.mCurrentIndex].h(this.ibk[this.mCurrentIndex]);
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
        if (this.ibk != null) {
            for (int i = 0; i < this.ibk.length; i++) {
                ImageFileInfo imageFileInfo = this.ibk[i];
                if (imageFileInfo != null) {
                    this.ibk[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bQp()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.ibl != null && this.ibl.bQw() && this.ibq != null && this.ibq.idH != null) {
                this.ibq.idH.bfO();
                TbImageView tbImageView = this.ibm[this.mCurrentIndex].foY;
                try {
                    bitmap = this.ibq.idH.bRW();
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
                        this.ibk[this.mCurrentIndex].setFilePath(l.b(l.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.ibk[this.mCurrentIndex].clearAllActions();
                        this.ibk[this.mCurrentIndex].clearPageActions();
                        this.ibk[this.mCurrentIndex].setIsGif(false);
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
                this.ibk[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView foY;
        private ProgressBar hjW;
        private FrameLayout ibu;
        private com.baidu.tbadk.img.b ibv;
        private int index;

        public b(int i) {
            this.hjW = null;
            this.index = -1;
            this.index = i;
            this.ibu = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.ibj.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.foY = (TbImageView) this.ibu.findViewById(e.g.progress_tb_imageview);
            this.foY.setClickable(true);
            this.foY.setDefaultResource(0);
            this.foY.setDefaultErrorResource(0);
            this.foY.setDefaultBgResource(0);
            this.foY.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.foY.setPadding(0, 0, 0, 0);
            this.ibv = new com.baidu.tbadk.img.b();
            this.foY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.ibl != null) {
                        MultiImagePagerAdapter.this.ibl.bQv();
                    }
                }
            });
            this.hjW = (ProgressBar) this.ibu.findViewById(e.g.progress_tb_imageview_progress);
            this.hjW.setVisibility(8);
        }

        public View getView() {
            return this.ibu;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.foY != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.ibj), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.ibj) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.ibj, e.C0210e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.foY.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.foY.setLayoutParams(layoutParams);
                aVar.a(this.foY);
                if (MultiImagePagerAdapter.this.ibq != null && MultiImagePagerAdapter.this.ibq.idH != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.ibq.idH.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.ibq.idH.setLayoutParams(layoutParams2);
                }
                if (aVar.ot() != null && !aVar.ot().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.ot();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                apu();
                this.hjW.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.ibv.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.hjW.setVisibility(8);
                    return;
                }
                this.ibv.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.hjW.setVisibility(8);
                        if (MultiImagePagerAdapter.this.ibq != null) {
                            MultiImagePagerAdapter.this.ibq.bQk();
                        }
                    }
                }, false);
            }
        }

        public void apu() {
            if (this.ibv != null) {
                this.ibv.NW();
            }
            if (this.foY != null) {
            }
        }

        public boolean bQx() {
            return this.hjW.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

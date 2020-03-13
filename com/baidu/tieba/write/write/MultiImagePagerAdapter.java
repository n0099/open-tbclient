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
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes13.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private WriteMultiImgsActivity kRZ;
    private ImageFileInfo[] kSa;
    private a kSb;
    private b[] kSc;
    private int kSd;
    private LinkedList<ImageFileInfo> kSe = new LinkedList<>();
    private int kSf;
    private int kSg;
    private h kSh;
    private com.baidu.tbadk.core.dialog.a kSi;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes13.dex */
    public interface a {
        void U(int i, boolean z);

        void cVF();

        void cVH();

        boolean cVI();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.kRZ = null;
        this.kSa = null;
        this.mViewPager = null;
        this.kSb = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.kSc = null;
        this.kSf = 120;
        this.kSg = 120;
        this.mIsFromIm = z;
        this.kRZ = writeMultiImgsActivity;
        this.kSh = hVar;
        this.kSf = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.kSg = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.kSe.size();
        this.kSa = new ImageFileInfo[this.mCount];
        this.kSc = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.kSa[i2] = this.kSe.get(i2).cloneWithoutFilterAction(true);
            this.kSa[i2].addPageAction(com.baidu.tbadk.img.effect.d.aJ(this.kSf, this.kSg));
            linkedList.set(linkedList.indexOf(this.kSe.get(i2)), this.kSa[i2]);
            this.kSa[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.kSb = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.kSe.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.kSe.add(next);
                }
            }
            return this.kSe.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cVB() {
        return this.mCurrentIndex;
    }

    private boolean PU() {
        return (this.kSc == null || this.mCurrentIndex >= this.kSc.length || this.kSc[this.mCurrentIndex] == null || this.kSa == null || this.mCurrentIndex >= this.kSa.length || this.kSa[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean cVC() {
        if (this.mCurrentIndex >= this.kSa.length || this.kSa[this.mCurrentIndex] == null || !this.kSa[this.mCurrentIndex].isGif() || this.kSa[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.kSa[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cVC()) {
            if (this.kSb != null) {
                this.kSb.U(i, z);
            }
        } else if (z) {
            Er(i);
        } else if (PU() && (bVar = this.kSc[this.mCurrentIndex]) != null && (imageFileInfo = this.kSa[this.mCurrentIndex]) != null && bVar.cVJ()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mC(i));
            this.kRZ.cWH();
            bVar.j(imageFileInfo);
        }
    }

    private void Er(int i) {
        this.kSd = i;
        if (this.kSi == null) {
            this.kSi = new com.baidu.tbadk.core.dialog.a(this.kRZ);
            this.kSi.jW(R.string.rorate_tip);
            this.kSi.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kSi != null) {
                        MultiImagePagerAdapter.this.kSi.dismiss();
                    }
                    MultiImagePagerAdapter.this.kSh.kUv.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVE() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVF() {
                            MultiImagePagerAdapter.this.kSb.cVF();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVG() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.kSd, false);
                }
            });
            this.kSi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kSi != null) {
                        MultiImagePagerAdapter.this.kSi.dismiss();
                    }
                }
            });
            this.kSi.b(this.kRZ.getPageContext());
        }
        this.kSi.aEC();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kSc[i] == null) {
            this.kSc[i] = new b(i);
        }
        this.mViewPager.addView(this.kSc[i].getView());
        return this.kSc[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.kSc[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        cVD();
    }

    private void cVD() {
        if (this.mCurrentIndex >= 0 && this.kSc != null && this.mCurrentIndex < this.kSc.length && this.mCurrentIndex < this.kSa.length && this.kSa[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.kSc.length; i++) {
                if (this.kSc[i] != null) {
                    this.kSc[i].cMm();
                }
            }
            if (this.kSc[this.mCurrentIndex] == null) {
                this.kSc[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.kSc[this.mCurrentIndex].j(this.kSa[this.mCurrentIndex]);
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

    private boolean c(String str, Bitmap bitmap) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void tR(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.kSa != null) {
            for (int i = 0; i < this.kSa.length; i++) {
                ImageFileInfo imageFileInfo = this.kSa[i];
                if (imageFileInfo != null) {
                    this.kSa[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!PU()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.kSb != null && this.kSb.cVI() && this.kSh != null && this.kSh.kUv != null) {
                this.kSh.kUv.ciK();
                TbImageView tbImageView = this.kSc[this.mCurrentIndex].EB;
                try {
                    bitmap = this.kSh.kUv.cXk();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.g.bi(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.g.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.kSa[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.kSa[this.mCurrentIndex].clearAllActions();
                        this.kSa[this.mCurrentIndex].clearPageActions();
                        this.kSa[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            M(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                M(this.mBitmap);
            }
        }
    }

    private void M(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.kSa[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b {
        private TbImageView EB;
        private int index;
        private FrameLayout kSl;
        private com.baidu.tbadk.img.b kSm;
        private ProgressBar kcg;

        public b(int i) {
            this.kcg = null;
            this.index = -1;
            this.index = i;
            this.kSl = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.kRZ.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.EB = (TbImageView) this.kSl.findViewById(R.id.progress_tb_imageview);
            this.EB.setClickable(true);
            this.EB.setDefaultResource(0);
            this.EB.setDefaultErrorResource(0);
            this.EB.setDefaultBgResource(0);
            this.EB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.EB.setPadding(0, 0, 0, 0);
            this.kSm = new com.baidu.tbadk.img.b();
            this.EB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.kSb != null) {
                        MultiImagePagerAdapter.this.kSb.cVH();
                    }
                }
            });
            this.kcg = (ProgressBar) this.kSl.findViewById(R.id.progress_tb_imageview_progress);
            this.kcg.setVisibility(8);
        }

        public View getView() {
            return this.kSl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.EB != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.kRZ), (l.getEquipmentHeight(MultiImagePagerAdapter.this.kRZ) - l.getDimens(MultiImagePagerAdapter.this.kRZ, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.EB.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.EB.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.EB);
                if (MultiImagePagerAdapter.this.kSh != null && MultiImagePagerAdapter.this.kSh.kUv != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.kSh.kUv.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.kSh.kUv.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cMm();
                this.kcg.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.kSm.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kcg.setVisibility(8);
                    return;
                }
                this.kSm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kcg.setVisibility(8);
                        if (MultiImagePagerAdapter.this.kSh != null) {
                            MultiImagePagerAdapter.this.kSh.bfN();
                        }
                    }
                }, false);
            }
        }

        public void cMm() {
            if (this.kSm != null) {
                this.kSm.cancelAllAsyncTask();
            }
            if (this.EB != null) {
            }
        }

        public boolean cVJ() {
            return this.kcg.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

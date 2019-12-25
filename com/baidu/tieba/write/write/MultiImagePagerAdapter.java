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
/* loaded from: classes10.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ImageFileInfo[] kNA;
    private a kNB;
    private b[] kNC;
    private int kND;
    private LinkedList<ImageFileInfo> kNE = new LinkedList<>();
    private int kNF;
    private int kNG;
    private h kNH;
    private com.baidu.tbadk.core.dialog.a kNI;
    private WriteMultiImgsActivity kNz;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes10.dex */
    public interface a {
        void V(int i, boolean z);

        void cTj();

        void cTl();

        boolean cTm();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.kNz = null;
        this.kNA = null;
        this.mViewPager = null;
        this.kNB = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.kNC = null;
        this.kNF = 120;
        this.kNG = 120;
        this.mIsFromIm = z;
        this.kNz = writeMultiImgsActivity;
        this.kNH = hVar;
        this.kNF = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.kNG = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.kNE.size();
        this.kNA = new ImageFileInfo[this.mCount];
        this.kNC = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.kNA[i2] = this.kNE.get(i2).cloneWithoutFilterAction(true);
            this.kNA[i2].addPageAction(com.baidu.tbadk.img.effect.d.aF(this.kNF, this.kNG));
            linkedList.set(linkedList.indexOf(this.kNE.get(i2)), this.kNA[i2]);
            this.kNA[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.kNB = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.kNE.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.kNE.add(next);
                }
            }
            return this.kNE.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cTf() {
        return this.mCurrentIndex;
    }

    private boolean Ni() {
        return (this.kNC == null || this.mCurrentIndex >= this.kNC.length || this.kNC[this.mCurrentIndex] == null || this.kNA == null || this.mCurrentIndex >= this.kNA.length || this.kNA[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean cTg() {
        if (this.mCurrentIndex >= this.kNA.length || this.kNA[this.mCurrentIndex] == null || !this.kNA[this.mCurrentIndex].isGif() || this.kNA[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.kNA[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cTg()) {
            if (this.kNB != null) {
                this.kNB.V(i, z);
            }
        } else if (z) {
            Eh(i);
        } else if (Ni() && (bVar = this.kNC[this.mCurrentIndex]) != null && (imageFileInfo = this.kNA[this.mCurrentIndex]) != null && bVar.cTn()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mk(i));
            this.kNz.cUl();
            bVar.j(imageFileInfo);
        }
    }

    private void Eh(int i) {
        this.kND = i;
        if (this.kNI == null) {
            this.kNI = new com.baidu.tbadk.core.dialog.a(this.kNz);
            this.kNI.jF(R.string.rorate_tip);
            this.kNI.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kNI != null) {
                        MultiImagePagerAdapter.this.kNI.dismiss();
                    }
                    MultiImagePagerAdapter.this.kNH.kPV.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cTi() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cTj() {
                            MultiImagePagerAdapter.this.kNB.cTj();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cTk() {
                        }
                    });
                    MultiImagePagerAdapter.this.U(MultiImagePagerAdapter.this.kND, false);
                }
            });
            this.kNI.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kNI != null) {
                        MultiImagePagerAdapter.this.kNI.dismiss();
                    }
                }
            });
            this.kNI.b(this.kNz.getPageContext());
        }
        this.kNI.aBW();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kNC[i] == null) {
            this.kNC[i] = new b(i);
        }
        this.mViewPager.addView(this.kNC[i].getView());
        return this.kNC[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.kNC[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        cTh();
    }

    private void cTh() {
        if (this.mCurrentIndex >= 0 && this.kNC != null && this.mCurrentIndex < this.kNC.length && this.mCurrentIndex < this.kNA.length && this.kNA[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.kNC.length; i++) {
                if (this.kNC[i] != null) {
                    this.kNC[i].cJI();
                }
            }
            if (this.kNC[this.mCurrentIndex] == null) {
                this.kNC[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.kNC[this.mCurrentIndex].j(this.kNA[this.mCurrentIndex]);
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
    public void tB(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.kNA != null) {
            for (int i = 0; i < this.kNA.length; i++) {
                ImageFileInfo imageFileInfo = this.kNA[i];
                if (imageFileInfo != null) {
                    this.kNA[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!Ni()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.kNB != null && this.kNB.cTm() && this.kNH != null && this.kNH.kPV != null) {
                this.kNH.kPV.cfU();
                TbImageView tbImageView = this.kNC[this.mCurrentIndex].Ed;
                try {
                    bitmap = this.kNH.kPV.cUO();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.g.be(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.g.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.kNA[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.kNA[this.mCurrentIndex].clearAllActions();
                        this.kNA[this.mCurrentIndex].clearPageActions();
                        this.kNA[this.mCurrentIndex].setIsGif(false);
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
                this.kNA[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b {
        private TbImageView Ed;
        private int index;
        private ProgressBar jXl;
        private FrameLayout kNL;
        private com.baidu.tbadk.img.b kNM;

        public b(int i) {
            this.jXl = null;
            this.index = -1;
            this.index = i;
            this.kNL = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.kNz.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Ed = (TbImageView) this.kNL.findViewById(R.id.progress_tb_imageview);
            this.Ed.setClickable(true);
            this.Ed.setDefaultResource(0);
            this.Ed.setDefaultErrorResource(0);
            this.Ed.setDefaultBgResource(0);
            this.Ed.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Ed.setPadding(0, 0, 0, 0);
            this.kNM = new com.baidu.tbadk.img.b();
            this.Ed.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.kNB != null) {
                        MultiImagePagerAdapter.this.kNB.cTl();
                    }
                }
            });
            this.jXl = (ProgressBar) this.kNL.findViewById(R.id.progress_tb_imageview_progress);
            this.jXl.setVisibility(8);
        }

        public View getView() {
            return this.kNL;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Ed != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.kNz), (l.getEquipmentHeight(MultiImagePagerAdapter.this.kNz) - l.getDimens(MultiImagePagerAdapter.this.kNz, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Ed.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Ed.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Ed);
                if (MultiImagePagerAdapter.this.kNH != null && MultiImagePagerAdapter.this.kNH.kPV != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.kNH.kPV.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.kNH.kPV.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cJI();
                this.jXl.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.kNM.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.jXl.setVisibility(8);
                    return;
                }
                this.kNM.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.jXl.setVisibility(8);
                        if (MultiImagePagerAdapter.this.kNH != null) {
                            MultiImagePagerAdapter.this.kNH.bdh();
                        }
                    }
                }, false);
            }
        }

        public void cJI() {
            if (this.kNM != null) {
                this.kNM.cancelAllAsyncTask();
            }
            if (this.Ed != null) {
            }
        }

        public boolean cTn() {
            return this.jXl.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

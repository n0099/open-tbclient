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
    private WriteMultiImgsActivity kTC;
    private ImageFileInfo[] kTD;
    private a kTE;
    private b[] kTF;
    private int kTG;
    private LinkedList<ImageFileInfo> kTH = new LinkedList<>();
    private int kTI;
    private int kTJ;
    private h kTK;
    private com.baidu.tbadk.core.dialog.a kTL;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes13.dex */
    public interface a {
        void U(int i, boolean z);

        void cWc();

        void cWe();

        boolean cWf();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.kTC = null;
        this.kTD = null;
        this.mViewPager = null;
        this.kTE = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.kTF = null;
        this.kTI = 120;
        this.kTJ = 120;
        this.mIsFromIm = z;
        this.kTC = writeMultiImgsActivity;
        this.kTK = hVar;
        this.kTI = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.kTJ = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.kTH.size();
        this.kTD = new ImageFileInfo[this.mCount];
        this.kTF = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.kTD[i2] = this.kTH.get(i2).cloneWithoutFilterAction(true);
            this.kTD[i2].addPageAction(com.baidu.tbadk.img.effect.d.aK(this.kTI, this.kTJ));
            linkedList.set(linkedList.indexOf(this.kTH.get(i2)), this.kTD[i2]);
            this.kTD[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.kTE = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.kTH.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.kTH.add(next);
                }
            }
            return this.kTH.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cVY() {
        return this.mCurrentIndex;
    }

    private boolean PX() {
        return (this.kTF == null || this.mCurrentIndex >= this.kTF.length || this.kTF[this.mCurrentIndex] == null || this.kTD == null || this.mCurrentIndex >= this.kTD.length || this.kTD[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean cVZ() {
        if (this.mCurrentIndex >= this.kTD.length || this.kTD[this.mCurrentIndex] == null || !this.kTD[this.mCurrentIndex].isGif() || this.kTD[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.kTD[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cVZ()) {
            if (this.kTE != null) {
                this.kTE.U(i, z);
            }
        } else if (z) {
            Ey(i);
        } else if (PX() && (bVar = this.kTF[this.mCurrentIndex]) != null && (imageFileInfo = this.kTD[this.mCurrentIndex]) != null && bVar.cWg()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mE(i));
            this.kTC.cXf();
            bVar.j(imageFileInfo);
        }
    }

    private void Ey(int i) {
        this.kTG = i;
        if (this.kTL == null) {
            this.kTL = new com.baidu.tbadk.core.dialog.a(this.kTC);
            this.kTL.jW(R.string.rorate_tip);
            this.kTL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kTL != null) {
                        MultiImagePagerAdapter.this.kTL.dismiss();
                    }
                    MultiImagePagerAdapter.this.kTK.kVY.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cWb() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cWc() {
                            MultiImagePagerAdapter.this.kTE.cWc();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cWd() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.kTG, false);
                }
            });
            this.kTL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kTL != null) {
                        MultiImagePagerAdapter.this.kTL.dismiss();
                    }
                }
            });
            this.kTL.b(this.kTC.getPageContext());
        }
        this.kTL.aEG();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kTF[i] == null) {
            this.kTF[i] = new b(i);
        }
        this.mViewPager.addView(this.kTF[i].getView());
        return this.kTF[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.kTF[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        cWa();
    }

    private void cWa() {
        if (this.mCurrentIndex >= 0 && this.kTF != null && this.mCurrentIndex < this.kTF.length && this.mCurrentIndex < this.kTD.length && this.kTD[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.kTF.length; i++) {
                if (this.kTF[i] != null) {
                    this.kTF[i].cMG();
                }
            }
            if (this.kTF[this.mCurrentIndex] == null) {
                this.kTF[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.kTF[this.mCurrentIndex].j(this.kTD[this.mCurrentIndex]);
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
    public void tY(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.kTD != null) {
            for (int i = 0; i < this.kTD.length; i++) {
                ImageFileInfo imageFileInfo = this.kTD[i];
                if (imageFileInfo != null) {
                    this.kTD[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!PX()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.kTE != null && this.kTE.cWf() && this.kTK != null && this.kTK.kVY != null) {
                this.kTK.kVY.cje();
                TbImageView tbImageView = this.kTF[this.mCurrentIndex].EB;
                try {
                    bitmap = this.kTK.kVY.cXI();
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
                        this.kTD[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.kTD[this.mCurrentIndex].clearAllActions();
                        this.kTD[this.mCurrentIndex].clearPageActions();
                        this.kTD[this.mCurrentIndex].setIsGif(false);
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
                this.kTD[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b {
        private TbImageView EB;
        private int index;
        private FrameLayout kTO;
        private com.baidu.tbadk.img.b kTP;
        private ProgressBar kdI;

        public b(int i) {
            this.kdI = null;
            this.index = -1;
            this.index = i;
            this.kTO = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.kTC.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.EB = (TbImageView) this.kTO.findViewById(R.id.progress_tb_imageview);
            this.EB.setClickable(true);
            this.EB.setDefaultResource(0);
            this.EB.setDefaultErrorResource(0);
            this.EB.setDefaultBgResource(0);
            this.EB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.EB.setPadding(0, 0, 0, 0);
            this.kTP = new com.baidu.tbadk.img.b();
            this.EB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.kTE != null) {
                        MultiImagePagerAdapter.this.kTE.cWe();
                    }
                }
            });
            this.kdI = (ProgressBar) this.kTO.findViewById(R.id.progress_tb_imageview_progress);
            this.kdI.setVisibility(8);
        }

        public View getView() {
            return this.kTO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.EB != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.kTC), (l.getEquipmentHeight(MultiImagePagerAdapter.this.kTC) - l.getDimens(MultiImagePagerAdapter.this.kTC, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.EB.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.EB.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.EB);
                if (MultiImagePagerAdapter.this.kTK != null && MultiImagePagerAdapter.this.kTK.kVY != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.kTK.kVY.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.kTK.kVY.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cMG();
                this.kdI.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.kTP.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kdI.setVisibility(8);
                    return;
                }
                this.kTP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kdI.setVisibility(8);
                        if (MultiImagePagerAdapter.this.kTK != null) {
                            MultiImagePagerAdapter.this.kTK.bfS();
                        }
                    }
                }, false);
            }
        }

        public void cMG() {
            if (this.kTP != null) {
                this.kTP.cancelAllAsyncTask();
            }
            if (this.EB != null) {
            }
        }

        public boolean cWg() {
            return this.kdI.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

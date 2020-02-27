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
    private WriteMultiImgsActivity kRL;
    private ImageFileInfo[] kRM;
    private a kRN;
    private b[] kRO;
    private int kRP;
    private LinkedList<ImageFileInfo> kRQ = new LinkedList<>();
    private int kRR;
    private int kRS;
    private h kRT;
    private com.baidu.tbadk.core.dialog.a kRU;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes13.dex */
    public interface a {
        void U(int i, boolean z);

        void cVC();

        void cVE();

        boolean cVF();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.kRL = null;
        this.kRM = null;
        this.mViewPager = null;
        this.kRN = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.kRO = null;
        this.kRR = 120;
        this.kRS = 120;
        this.mIsFromIm = z;
        this.kRL = writeMultiImgsActivity;
        this.kRT = hVar;
        this.kRR = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.kRS = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.kRQ.size();
        this.kRM = new ImageFileInfo[this.mCount];
        this.kRO = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.kRM[i2] = this.kRQ.get(i2).cloneWithoutFilterAction(true);
            this.kRM[i2].addPageAction(com.baidu.tbadk.img.effect.d.aJ(this.kRR, this.kRS));
            linkedList.set(linkedList.indexOf(this.kRQ.get(i2)), this.kRM[i2]);
            this.kRM[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.kRN = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.kRQ.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.kRQ.add(next);
                }
            }
            return this.kRQ.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cVy() {
        return this.mCurrentIndex;
    }

    private boolean PS() {
        return (this.kRO == null || this.mCurrentIndex >= this.kRO.length || this.kRO[this.mCurrentIndex] == null || this.kRM == null || this.mCurrentIndex >= this.kRM.length || this.kRM[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean cVz() {
        if (this.mCurrentIndex >= this.kRM.length || this.kRM[this.mCurrentIndex] == null || !this.kRM[this.mCurrentIndex].isGif() || this.kRM[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.kRM[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cVz()) {
            if (this.kRN != null) {
                this.kRN.U(i, z);
            }
        } else if (z) {
            Er(i);
        } else if (PS() && (bVar = this.kRO[this.mCurrentIndex]) != null && (imageFileInfo = this.kRM[this.mCurrentIndex]) != null && bVar.cVG()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mC(i));
            this.kRL.cWE();
            bVar.j(imageFileInfo);
        }
    }

    private void Er(int i) {
        this.kRP = i;
        if (this.kRU == null) {
            this.kRU = new com.baidu.tbadk.core.dialog.a(this.kRL);
            this.kRU.jW(R.string.rorate_tip);
            this.kRU.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRU != null) {
                        MultiImagePagerAdapter.this.kRU.dismiss();
                    }
                    MultiImagePagerAdapter.this.kRT.kUh.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVB() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVC() {
                            MultiImagePagerAdapter.this.kRN.cVC();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVD() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.kRP, false);
                }
            });
            this.kRU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRU != null) {
                        MultiImagePagerAdapter.this.kRU.dismiss();
                    }
                }
            });
            this.kRU.b(this.kRL.getPageContext());
        }
        this.kRU.aEA();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kRO[i] == null) {
            this.kRO[i] = new b(i);
        }
        this.mViewPager.addView(this.kRO[i].getView());
        return this.kRO[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.kRO[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        cVA();
    }

    private void cVA() {
        if (this.mCurrentIndex >= 0 && this.kRO != null && this.mCurrentIndex < this.kRO.length && this.mCurrentIndex < this.kRM.length && this.kRM[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.kRO.length; i++) {
                if (this.kRO[i] != null) {
                    this.kRO[i].cMj();
                }
            }
            if (this.kRO[this.mCurrentIndex] == null) {
                this.kRO[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.kRO[this.mCurrentIndex].j(this.kRM[this.mCurrentIndex]);
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
        if (this.kRM != null) {
            for (int i = 0; i < this.kRM.length; i++) {
                ImageFileInfo imageFileInfo = this.kRM[i];
                if (imageFileInfo != null) {
                    this.kRM[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!PS()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.kRN != null && this.kRN.cVF() && this.kRT != null && this.kRT.kUh != null) {
                this.kRT.kUh.ciH();
                TbImageView tbImageView = this.kRO[this.mCurrentIndex].EB;
                try {
                    bitmap = this.kRT.kUh.cXh();
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
                        this.kRM[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.kRM[this.mCurrentIndex].clearAllActions();
                        this.kRM[this.mCurrentIndex].clearPageActions();
                        this.kRM[this.mCurrentIndex].setIsGif(false);
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
                this.kRM[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b {
        private TbImageView EB;
        private int index;
        private FrameLayout kRX;
        private com.baidu.tbadk.img.b kRY;
        private ProgressBar kbS;

        public b(int i) {
            this.kbS = null;
            this.index = -1;
            this.index = i;
            this.kRX = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.kRL.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.EB = (TbImageView) this.kRX.findViewById(R.id.progress_tb_imageview);
            this.EB.setClickable(true);
            this.EB.setDefaultResource(0);
            this.EB.setDefaultErrorResource(0);
            this.EB.setDefaultBgResource(0);
            this.EB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.EB.setPadding(0, 0, 0, 0);
            this.kRY = new com.baidu.tbadk.img.b();
            this.EB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.kRN != null) {
                        MultiImagePagerAdapter.this.kRN.cVE();
                    }
                }
            });
            this.kbS = (ProgressBar) this.kRX.findViewById(R.id.progress_tb_imageview_progress);
            this.kbS.setVisibility(8);
        }

        public View getView() {
            return this.kRX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.EB != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.kRL), (l.getEquipmentHeight(MultiImagePagerAdapter.this.kRL) - l.getDimens(MultiImagePagerAdapter.this.kRL, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.EB.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.EB.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.EB);
                if (MultiImagePagerAdapter.this.kRT != null && MultiImagePagerAdapter.this.kRT.kUh != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.kRT.kUh.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.kRT.kUh.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cMj();
                this.kbS.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.kRY.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kbS.setVisibility(8);
                    return;
                }
                this.kRY.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kbS.setVisibility(8);
                        if (MultiImagePagerAdapter.this.kRT != null) {
                            MultiImagePagerAdapter.this.kRT.bfK();
                        }
                    }
                }, false);
            }
        }

        public void cMj() {
            if (this.kRY != null) {
                this.kRY.cancelAllAsyncTask();
            }
            if (this.EB != null) {
            }
        }

        public boolean cVG() {
            return this.kbS.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

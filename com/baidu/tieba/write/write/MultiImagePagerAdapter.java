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
    private WriteMultiImgsActivity kRN;
    private ImageFileInfo[] kRO;
    private a kRP;
    private b[] kRQ;
    private int kRR;
    private LinkedList<ImageFileInfo> kRS = new LinkedList<>();
    private int kRT;
    private int kRU;
    private h kRV;
    private com.baidu.tbadk.core.dialog.a kRW;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes13.dex */
    public interface a {
        void U(int i, boolean z);

        void cVE();

        void cVG();

        boolean cVH();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.kRN = null;
        this.kRO = null;
        this.mViewPager = null;
        this.kRP = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.kRQ = null;
        this.kRT = 120;
        this.kRU = 120;
        this.mIsFromIm = z;
        this.kRN = writeMultiImgsActivity;
        this.kRV = hVar;
        this.kRT = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.kRU = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.kRS.size();
        this.kRO = new ImageFileInfo[this.mCount];
        this.kRQ = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.kRO[i2] = this.kRS.get(i2).cloneWithoutFilterAction(true);
            this.kRO[i2].addPageAction(com.baidu.tbadk.img.effect.d.aJ(this.kRT, this.kRU));
            linkedList.set(linkedList.indexOf(this.kRS.get(i2)), this.kRO[i2]);
            this.kRO[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.kRP = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.kRS.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.kRS.add(next);
                }
            }
            return this.kRS.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cVA() {
        return this.mCurrentIndex;
    }

    private boolean PU() {
        return (this.kRQ == null || this.mCurrentIndex >= this.kRQ.length || this.kRQ[this.mCurrentIndex] == null || this.kRO == null || this.mCurrentIndex >= this.kRO.length || this.kRO[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean cVB() {
        if (this.mCurrentIndex >= this.kRO.length || this.kRO[this.mCurrentIndex] == null || !this.kRO[this.mCurrentIndex].isGif() || this.kRO[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.kRO[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cVB()) {
            if (this.kRP != null) {
                this.kRP.U(i, z);
            }
        } else if (z) {
            Er(i);
        } else if (PU() && (bVar = this.kRQ[this.mCurrentIndex]) != null && (imageFileInfo = this.kRO[this.mCurrentIndex]) != null && bVar.cVI()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mC(i));
            this.kRN.cWG();
            bVar.j(imageFileInfo);
        }
    }

    private void Er(int i) {
        this.kRR = i;
        if (this.kRW == null) {
            this.kRW = new com.baidu.tbadk.core.dialog.a(this.kRN);
            this.kRW.jW(R.string.rorate_tip);
            this.kRW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRW != null) {
                        MultiImagePagerAdapter.this.kRW.dismiss();
                    }
                    MultiImagePagerAdapter.this.kRV.kUj.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVD() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVE() {
                            MultiImagePagerAdapter.this.kRP.cVE();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cVF() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.kRR, false);
                }
            });
            this.kRW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRW != null) {
                        MultiImagePagerAdapter.this.kRW.dismiss();
                    }
                }
            });
            this.kRW.b(this.kRN.getPageContext());
        }
        this.kRW.aEC();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kRQ[i] == null) {
            this.kRQ[i] = new b(i);
        }
        this.mViewPager.addView(this.kRQ[i].getView());
        return this.kRQ[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.kRQ[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        cVC();
    }

    private void cVC() {
        if (this.mCurrentIndex >= 0 && this.kRQ != null && this.mCurrentIndex < this.kRQ.length && this.mCurrentIndex < this.kRO.length && this.kRO[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.kRQ.length; i++) {
                if (this.kRQ[i] != null) {
                    this.kRQ[i].cMl();
                }
            }
            if (this.kRQ[this.mCurrentIndex] == null) {
                this.kRQ[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.kRQ[this.mCurrentIndex].j(this.kRO[this.mCurrentIndex]);
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
        if (this.kRO != null) {
            for (int i = 0; i < this.kRO.length; i++) {
                ImageFileInfo imageFileInfo = this.kRO[i];
                if (imageFileInfo != null) {
                    this.kRO[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!PU()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.kRP != null && this.kRP.cVH() && this.kRV != null && this.kRV.kUj != null) {
                this.kRV.kUj.ciJ();
                TbImageView tbImageView = this.kRQ[this.mCurrentIndex].EB;
                try {
                    bitmap = this.kRV.kUj.cXj();
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
                        this.kRO[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.kRO[this.mCurrentIndex].clearAllActions();
                        this.kRO[this.mCurrentIndex].clearPageActions();
                        this.kRO[this.mCurrentIndex].setIsGif(false);
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
                this.kRO[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b {
        private TbImageView EB;
        private int index;
        private FrameLayout kRZ;
        private com.baidu.tbadk.img.b kSa;
        private ProgressBar kbU;

        public b(int i) {
            this.kbU = null;
            this.index = -1;
            this.index = i;
            this.kRZ = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.kRN.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.EB = (TbImageView) this.kRZ.findViewById(R.id.progress_tb_imageview);
            this.EB.setClickable(true);
            this.EB.setDefaultResource(0);
            this.EB.setDefaultErrorResource(0);
            this.EB.setDefaultBgResource(0);
            this.EB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.EB.setPadding(0, 0, 0, 0);
            this.kSa = new com.baidu.tbadk.img.b();
            this.EB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.kRP != null) {
                        MultiImagePagerAdapter.this.kRP.cVG();
                    }
                }
            });
            this.kbU = (ProgressBar) this.kRZ.findViewById(R.id.progress_tb_imageview_progress);
            this.kbU.setVisibility(8);
        }

        public View getView() {
            return this.kRZ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.EB != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.kRN), (l.getEquipmentHeight(MultiImagePagerAdapter.this.kRN) - l.getDimens(MultiImagePagerAdapter.this.kRN, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.EB.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.EB.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.EB);
                if (MultiImagePagerAdapter.this.kRV != null && MultiImagePagerAdapter.this.kRV.kUj != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.kRV.kUj.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.kRV.kUj.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cMl();
                this.kbU.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.kSa.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kbU.setVisibility(8);
                    return;
                }
                this.kSa.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kbU.setVisibility(8);
                        if (MultiImagePagerAdapter.this.kRV != null) {
                            MultiImagePagerAdapter.this.kRV.bfM();
                        }
                    }
                }, false);
            }
        }

        public void cMl() {
            if (this.kSa != null) {
                this.kSa.cancelAllAsyncTask();
            }
            if (this.EB != null) {
            }
        }

        public boolean cVI() {
            return this.kbU.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

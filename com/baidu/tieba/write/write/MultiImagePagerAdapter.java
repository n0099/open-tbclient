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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;
    private WriteMultiImgsActivity nFO;
    private ImageFileInfo[] nFP;
    private a nFQ;
    private b[] nFR;
    private int nFS;
    private LinkedList<ImageFileInfo> nFT = new LinkedList<>();
    private int nFU;
    private int nFV;
    private j nFW;
    private com.baidu.tbadk.core.dialog.a nFX;

    /* loaded from: classes3.dex */
    public interface a {
        void am(int i, boolean z);

        void dSu();

        void dSw();

        boolean dSx();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.nFO = null;
        this.nFP = null;
        this.mViewPager = null;
        this.nFQ = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.nFR = null;
        this.nFU = 120;
        this.nFV = 120;
        this.mIsFromIm = z;
        this.nFO = writeMultiImgsActivity;
        this.nFW = jVar;
        this.nFU = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.nFV = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.nFT.size();
        this.nFP = new ImageFileInfo[this.mCount];
        this.nFR = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.nFP[i2] = this.nFT.get(i2).cloneWithoutFilterAction(true);
            this.nFP[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.nFU, this.nFV));
            linkedList.set(linkedList.indexOf(this.nFT.get(i2)), this.nFP[i2]);
            this.nFP[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.nFQ = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.nFT.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.nFT.add(next);
                }
            }
            return this.nFT.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dSq() {
        return this.mCurrentIndex;
    }

    private boolean aoD() {
        return (this.nFR == null || this.mCurrentIndex >= this.nFR.length || this.nFR[this.mCurrentIndex] == null || this.nFP == null || this.mCurrentIndex >= this.nFP.length || this.nFP[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dSr() {
        if (this.mCurrentIndex >= this.nFP.length || this.nFP[this.mCurrentIndex] == null || !this.nFP[this.mCurrentIndex].isGif() || this.nFP[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.nFP[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dSr()) {
            if (this.nFQ != null) {
                this.nFQ.am(i, z);
            }
        } else if (z) {
            Lr(i);
        } else if (aoD() && (bVar = this.nFR[this.mCurrentIndex]) != null && (imageFileInfo = this.nFP[this.mCurrentIndex]) != null && bVar.dSy()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rr(i));
            this.nFO.dTR();
            bVar.l(imageFileInfo);
        }
    }

    private void Lr(int i) {
        this.nFS = i;
        if (this.nFX == null) {
            this.nFX = new com.baidu.tbadk.core.dialog.a(this.nFO);
            this.nFX.om(R.string.rorate_tip);
            this.nFX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nFX != null) {
                        MultiImagePagerAdapter.this.nFX.dismiss();
                    }
                    MultiImagePagerAdapter.this.nFW.nIP.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dSt() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dSu() {
                            MultiImagePagerAdapter.this.nFQ.dSu();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dSv() {
                        }
                    });
                    MultiImagePagerAdapter.this.al(MultiImagePagerAdapter.this.nFS, false);
                }
            });
            this.nFX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nFX != null) {
                        MultiImagePagerAdapter.this.nFX.dismiss();
                    }
                }
            });
            this.nFX.b(this.nFO.getPageContext());
        }
        this.nFX.bmC();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.nFR[i] == null) {
            this.nFR[i] = new b(i);
        }
        this.mViewPager.addView(this.nFR[i].getView());
        return this.nFR[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.nFR[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dSs();
    }

    private void dSs() {
        if (this.mCurrentIndex >= 0 && this.nFR != null && this.mCurrentIndex < this.nFR.length && this.mCurrentIndex < this.nFP.length && this.nFP[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.nFR.length; i++) {
                if (this.nFR[i] != null) {
                    this.nFR[i].dIM();
                }
            }
            if (this.nFR[this.mCurrentIndex] == null) {
                this.nFR[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.nFR[this.mCurrentIndex].l(this.nFP[this.mCurrentIndex]);
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
            n.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void yx(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.nFP != null) {
            for (int i = 0; i < this.nFP.length; i++) {
                ImageFileInfo imageFileInfo = this.nFP[i];
                if (imageFileInfo != null) {
                    this.nFP[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!aoD()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.nFQ != null && this.nFQ.dSx() && this.nFW != null && this.nFW.nIP != null) {
                this.nFW.nIP.ddN();
                TbImageView tbImageView = this.nFR[this.mCurrentIndex].ZW;
                try {
                    bitmap = this.nFW.nIP.dUt();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bC = com.baidu.tbadk.util.h.bC(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bC;
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = bitmap;
                        bitmap3 = null;
                        if (bitmap2 == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap2 == null && bitmap3 != null && (a2 = com.baidu.tbadk.util.h.a(bitmap3, bitmap2, bitmap3.getWidth(), bitmap3.getHeight())) != null) {
                        this.nFP[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.nFP[this.mCurrentIndex].setContentUriStr(null);
                        this.nFP[this.mCurrentIndex].clearAllActions();
                        this.nFP[this.mCurrentIndex].clearPageActions();
                        this.nFP[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            T(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                T(this.mBitmap);
            }
        }
    }

    private void T(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.nFP[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView ZW;
        private int index;
        private ProgressBar mMe;
        private FrameLayout nGa;
        private com.baidu.tbadk.img.b nGb;

        public b(int i) {
            this.mMe = null;
            this.index = -1;
            this.index = i;
            this.nGa = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.nFO.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.ZW = (TbImageView) this.nGa.findViewById(R.id.progress_tb_imageview);
            this.ZW.setClickable(true);
            this.ZW.setDefaultResource(0);
            this.ZW.setDefaultErrorResource(0);
            this.ZW.setDefaultBgResource(0);
            this.ZW.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ZW.setPadding(0, 0, 0, 0);
            this.nGb = new com.baidu.tbadk.img.b();
            this.ZW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.nFQ != null) {
                        MultiImagePagerAdapter.this.nFQ.dSw();
                    }
                }
            });
            this.mMe = (ProgressBar) this.nGa.findViewById(R.id.progress_tb_imageview_progress);
            this.mMe.setVisibility(8);
        }

        public View getView() {
            return this.nGa;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.ZW != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.nFO), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.nFO) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.nFO, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ZW.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.ZW.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.ZW);
                if (MultiImagePagerAdapter.this.nFW != null && MultiImagePagerAdapter.this.nFW.nIP != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.nFW.nIP.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.nFW.nIP.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dIM();
                this.mMe.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.nGb.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.mMe.setVisibility(8);
                    return;
                }
                this.nGb.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.mMe.setVisibility(8);
                        if (MultiImagePagerAdapter.this.nFW != null) {
                            MultiImagePagerAdapter.this.nFW.bRf();
                        }
                    }
                }, false);
            }
        }

        public void dIM() {
            if (this.nGb != null) {
                this.nGb.cancelAllAsyncTask();
            }
            if (this.ZW != null) {
            }
        }

        public boolean dSy() {
            return this.mMe.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

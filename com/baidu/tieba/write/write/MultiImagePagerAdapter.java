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
    private WriteMultiImgsActivity mTF;
    private ImageFileInfo[] mTG;
    private a mTH;
    private b[] mTI;
    private int mTJ;
    private LinkedList<ImageFileInfo> mTK = new LinkedList<>();
    private int mTL;
    private int mTM;
    private j mTN;
    private com.baidu.tbadk.core.dialog.a mTO;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void aj(int i, boolean z);

        void dHw();

        void dHy();

        boolean dHz();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.mTF = null;
        this.mTG = null;
        this.mViewPager = null;
        this.mTH = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.mTI = null;
        this.mTL = 120;
        this.mTM = 120;
        this.mIsFromIm = z;
        this.mTF = writeMultiImgsActivity;
        this.mTN = jVar;
        this.mTL = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.mTM = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.mTK.size();
        this.mTG = new ImageFileInfo[this.mCount];
        this.mTI = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.mTG[i2] = this.mTK.get(i2).cloneWithoutFilterAction(true);
            this.mTG[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.mTL, this.mTM));
            linkedList.set(linkedList.indexOf(this.mTK.get(i2)), this.mTG[i2]);
            this.mTG[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.mTH = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.mTK.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.mTK.add(next);
                }
            }
            return this.mTK.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dHs() {
        return this.mCurrentIndex;
    }

    private boolean ajo() {
        return (this.mTI == null || this.mCurrentIndex >= this.mTI.length || this.mTI[this.mCurrentIndex] == null || this.mTG == null || this.mCurrentIndex >= this.mTG.length || this.mTG[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dHt() {
        if (this.mCurrentIndex >= this.mTG.length || this.mTG[this.mCurrentIndex] == null || !this.mTG[this.mCurrentIndex].isGif() || this.mTG[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.mTG[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dHt()) {
            if (this.mTH != null) {
                this.mTH.aj(i, z);
            }
        } else if (z) {
            JO(i);
        } else if (ajo() && (bVar = this.mTI[this.mCurrentIndex]) != null && (imageFileInfo = this.mTG[this.mCurrentIndex]) != null && bVar.dHA()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.qr(i));
            this.mTF.dIQ();
            bVar.l(imageFileInfo);
        }
    }

    private void JO(int i) {
        this.mTJ = i;
        if (this.mTO == null) {
            this.mTO = new com.baidu.tbadk.core.dialog.a(this.mTF);
            this.mTO.nt(R.string.rorate_tip);
            this.mTO.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mTO != null) {
                        MultiImagePagerAdapter.this.mTO.dismiss();
                    }
                    MultiImagePagerAdapter.this.mTN.mWB.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dHv() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dHw() {
                            MultiImagePagerAdapter.this.mTH.dHw();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean V(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dHx() {
                        }
                    });
                    MultiImagePagerAdapter.this.ai(MultiImagePagerAdapter.this.mTJ, false);
                }
            });
            this.mTO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mTO != null) {
                        MultiImagePagerAdapter.this.mTO.dismiss();
                    }
                }
            });
            this.mTO.b(this.mTF.getPageContext());
        }
        this.mTO.bhg();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mTI[i] == null) {
            this.mTI[i] = new b(i);
        }
        this.mViewPager.addView(this.mTI[i].getView());
        return this.mTI[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.mTI[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dHu();
    }

    private void dHu() {
        if (this.mCurrentIndex >= 0 && this.mTI != null && this.mCurrentIndex < this.mTI.length && this.mCurrentIndex < this.mTG.length && this.mTG[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.mTI.length; i++) {
                if (this.mTI[i] != null) {
                    this.mTI[i].dxU();
                }
            }
            if (this.mTI[this.mCurrentIndex] == null) {
                this.mTI[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.mTI[this.mCurrentIndex].l(this.mTG[this.mCurrentIndex]);
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
    public void xo(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.mTG != null) {
            for (int i = 0; i < this.mTG.length; i++) {
                ImageFileInfo imageFileInfo = this.mTG[i];
                if (imageFileInfo != null) {
                    this.mTG[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!ajo()) {
                if (!z && this.mIsFromIm) {
                    U(this.mBitmap);
                }
            } else if (this.mTH != null && this.mTH.dHz() && this.mTN != null && this.mTN.mWB != null) {
                this.mTN.mWB.cTq();
                TbImageView tbImageView = this.mTI[this.mCurrentIndex].Zl;
                try {
                    bitmap = this.mTN.mWB.dJs();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bt = com.baidu.tbadk.util.g.bt(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bt;
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = bitmap;
                        bitmap3 = null;
                        if (bitmap2 == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap2 == null && bitmap3 != null && (a2 = com.baidu.tbadk.util.g.a(bitmap3, bitmap2, bitmap3.getWidth(), bitmap3.getHeight())) != null) {
                        this.mTG[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.mTG[this.mCurrentIndex].setContentUriStr(null);
                        this.mTG[this.mCurrentIndex].clearAllActions();
                        this.mTG[this.mCurrentIndex].clearPageActions();
                        this.mTG[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            U(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                U(this.mBitmap);
            }
        }
    }

    private void U(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.mTG[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Zl;
        private int index;
        private FrameLayout mTR;
        private com.baidu.tbadk.img.b mTS;
        private ProgressBar maa;

        public b(int i) {
            this.maa = null;
            this.index = -1;
            this.index = i;
            this.mTR = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.mTF.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Zl = (TbImageView) this.mTR.findViewById(R.id.progress_tb_imageview);
            this.Zl.setClickable(true);
            this.Zl.setDefaultResource(0);
            this.Zl.setDefaultErrorResource(0);
            this.Zl.setDefaultBgResource(0);
            this.Zl.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Zl.setPadding(0, 0, 0, 0);
            this.mTS = new com.baidu.tbadk.img.b();
            this.Zl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.mTH != null) {
                        MultiImagePagerAdapter.this.mTH.dHy();
                    }
                }
            });
            this.maa = (ProgressBar) this.mTR.findViewById(R.id.progress_tb_imageview_progress);
            this.maa.setVisibility(8);
        }

        public View getView() {
            return this.mTR;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Zl != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.mTF), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.mTF) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.mTF, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Zl.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Zl.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Zl);
                if (MultiImagePagerAdapter.this.mTN != null && MultiImagePagerAdapter.this.mTN.mWB != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.mTN.mWB.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.mTN.mWB.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dxU();
                this.maa.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.mTS.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.maa.setVisibility(8);
                    return;
                }
                this.mTS.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.maa.setVisibility(8);
                        if (MultiImagePagerAdapter.this.mTN != null) {
                            MultiImagePagerAdapter.this.mTN.bKF();
                        }
                    }
                }, false);
            }
        }

        public void dxU() {
            if (this.mTS != null) {
                this.mTS.cancelAllAsyncTask();
            }
            if (this.Zl != null) {
            }
        }

        public boolean dHA() {
            return this.maa.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

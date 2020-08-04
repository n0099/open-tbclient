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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private WriteMultiImgsActivity mAR;
    private ImageFileInfo[] mAS;
    private a mAT;
    private b[] mAU;
    private int mAV;
    private LinkedList<ImageFileInfo> mAW = new LinkedList<>();
    private int mAX;
    private int mAY;
    private h mAZ;
    private com.baidu.tbadk.core.dialog.a mBa;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void ah(int i, boolean z);

        void dvT();

        void dvV();

        boolean dvW();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.mAR = null;
        this.mAS = null;
        this.mViewPager = null;
        this.mAT = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.mAU = null;
        this.mAX = 120;
        this.mAY = 120;
        this.mIsFromIm = z;
        this.mAR = writeMultiImgsActivity;
        this.mAZ = hVar;
        this.mAX = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.mAY = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.mAW.size();
        this.mAS = new ImageFileInfo[this.mCount];
        this.mAU = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.mAS[i2] = this.mAW.get(i2).cloneWithoutFilterAction(true);
            this.mAS[i2].addPageAction(com.baidu.tbadk.img.effect.d.aX(this.mAX, this.mAY));
            linkedList.set(linkedList.indexOf(this.mAW.get(i2)), this.mAS[i2]);
            this.mAS[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.mAT = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.mAW.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.mAW.add(next);
                }
            }
            return this.mAW.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dvP() {
        return this.mCurrentIndex;
    }

    private boolean acP() {
        return (this.mAU == null || this.mCurrentIndex >= this.mAU.length || this.mAU[this.mCurrentIndex] == null || this.mAS == null || this.mCurrentIndex >= this.mAS.length || this.mAS[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dvQ() {
        if (this.mCurrentIndex >= this.mAS.length || this.mAS[this.mCurrentIndex] == null || !this.mAS[this.mCurrentIndex].isGif() || this.mAS[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.mAS[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ag(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dvQ()) {
            if (this.mAT != null) {
                this.mAT.ah(i, z);
            }
        } else if (z) {
            Ho(i);
        } else if (acP() && (bVar = this.mAU[this.mCurrentIndex]) != null && (imageFileInfo = this.mAS[this.mCurrentIndex]) != null && bVar.dvX()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.og(i));
            this.mAR.dxc();
            bVar.l(imageFileInfo);
        }
    }

    private void Ho(int i) {
        this.mAV = i;
        if (this.mBa == null) {
            this.mBa = new com.baidu.tbadk.core.dialog.a(this.mAR);
            this.mBa.ln(R.string.rorate_tip);
            this.mBa.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mBa != null) {
                        MultiImagePagerAdapter.this.mBa.dismiss();
                    }
                    MultiImagePagerAdapter.this.mAZ.mDC.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dvS() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dvT() {
                            MultiImagePagerAdapter.this.mAT.dvT();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean V(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dvU() {
                        }
                    });
                    MultiImagePagerAdapter.this.ag(MultiImagePagerAdapter.this.mAV, false);
                }
            });
            this.mBa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mBa != null) {
                        MultiImagePagerAdapter.this.mBa.dismiss();
                    }
                }
            });
            this.mBa.b(this.mAR.getPageContext());
        }
        this.mBa.aYL();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mAU[i] == null) {
            this.mAU[i] = new b(i);
        }
        this.mViewPager.addView(this.mAU[i].getView());
        return this.mAU[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.mAU[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dvR();
    }

    private void dvR() {
        if (this.mCurrentIndex >= 0 && this.mAU != null && this.mCurrentIndex < this.mAU.length && this.mCurrentIndex < this.mAS.length && this.mAS[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.mAU.length; i++) {
                if (this.mAU[i] != null) {
                    this.mAU[i].dmz();
                }
            }
            if (this.mAU[this.mCurrentIndex] == null) {
                this.mAU[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.mAU[this.mCurrentIndex].l(this.mAS[this.mCurrentIndex]);
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
    public void wy(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.mAS != null) {
            for (int i = 0; i < this.mAS.length; i++) {
                ImageFileInfo imageFileInfo = this.mAS[i];
                if (imageFileInfo != null) {
                    this.mAS[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!acP()) {
                if (!z && this.mIsFromIm) {
                    U(this.mBitmap);
                }
            } else if (this.mAT != null && this.mAT.dvW() && this.mAZ != null && this.mAZ.mDC != null) {
                this.mAZ.mDC.cIB();
                TbImageView tbImageView = this.mAU[this.mCurrentIndex].YF;
                try {
                    bitmap = this.mAZ.mDC.dxF();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap br = com.baidu.tbadk.util.g.br(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = br;
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
                        this.mAS[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.mAS[this.mCurrentIndex].setContentUriStr(null);
                        this.mAS[this.mCurrentIndex].clearAllActions();
                        this.mAS[this.mCurrentIndex].clearPageActions();
                        this.mAS[this.mCurrentIndex].setIsGif(false);
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
                this.mAS[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView YF;
        private int index;
        private ProgressBar lIu;
        private FrameLayout mBd;
        private com.baidu.tbadk.img.b mBe;

        public b(int i) {
            this.lIu = null;
            this.index = -1;
            this.index = i;
            this.mBd = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.mAR.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.YF = (TbImageView) this.mBd.findViewById(R.id.progress_tb_imageview);
            this.YF.setClickable(true);
            this.YF.setDefaultResource(0);
            this.YF.setDefaultErrorResource(0);
            this.YF.setDefaultBgResource(0);
            this.YF.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.YF.setPadding(0, 0, 0, 0);
            this.mBe = new com.baidu.tbadk.img.b();
            this.YF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.mAT != null) {
                        MultiImagePagerAdapter.this.mAT.dvV();
                    }
                }
            });
            this.lIu = (ProgressBar) this.mBd.findViewById(R.id.progress_tb_imageview_progress);
            this.lIu.setVisibility(8);
        }

        public View getView() {
            return this.mBd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.YF != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.mAR), (l.getEquipmentHeight(MultiImagePagerAdapter.this.mAR) - l.getDimens(MultiImagePagerAdapter.this.mAR, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YF.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.YF.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.YF);
                if (MultiImagePagerAdapter.this.mAZ != null && MultiImagePagerAdapter.this.mAZ.mDC != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.mAZ.mDC.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.mAZ.mDC.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dmz();
                this.lIu.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.mBe.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.lIu.setVisibility(8);
                    return;
                }
                this.mBe.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.lIu.setVisibility(8);
                        if (MultiImagePagerAdapter.this.mAZ != null) {
                            MultiImagePagerAdapter.this.mAZ.bBl();
                        }
                    }
                }, false);
            }
        }

        public void dmz() {
            if (this.mBe != null) {
                this.mBe.cancelAllAsyncTask();
            }
            if (this.YF != null) {
            }
        }

        public boolean dvX() {
            return this.lIu.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

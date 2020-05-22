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
/* loaded from: classes2.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private WriteMultiImgsActivity lWU;
    private ImageFileInfo[] lWV;
    private a lWW;
    private b[] lWX;
    private int lWY;
    private LinkedList<ImageFileInfo> lWZ = new LinkedList<>();
    private int lXa;
    private int lXb;
    private h lXc;
    private com.baidu.tbadk.core.dialog.a lXd;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void af(int i, boolean z);

        void dnZ();

        void dob();

        boolean doc();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.lWU = null;
        this.lWV = null;
        this.mViewPager = null;
        this.lWW = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.lWX = null;
        this.lXa = 120;
        this.lXb = 120;
        this.mIsFromIm = z;
        this.lWU = writeMultiImgsActivity;
        this.lXc = hVar;
        this.lXa = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.lXb = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.lWZ.size();
        this.lWV = new ImageFileInfo[this.mCount];
        this.lWX = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.lWV[i2] = this.lWZ.get(i2).cloneWithoutFilterAction(true);
            this.lWV[i2].addPageAction(com.baidu.tbadk.img.effect.d.aS(this.lXa, this.lXb));
            linkedList.set(linkedList.indexOf(this.lWZ.get(i2)), this.lWV[i2]);
            this.lWV[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.lWW = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.lWZ.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.lWZ.add(next);
                }
            }
            return this.lWZ.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dnV() {
        return this.mCurrentIndex;
    }

    private boolean aaF() {
        return (this.lWX == null || this.mCurrentIndex >= this.lWX.length || this.lWX[this.mCurrentIndex] == null || this.lWV == null || this.mCurrentIndex >= this.lWV.length || this.lWV[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dnW() {
        if (this.mCurrentIndex >= this.lWV.length || this.lWV[this.mCurrentIndex] == null || !this.lWV[this.mCurrentIndex].isGif() || this.lWV[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.lWV[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ae(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dnW()) {
            if (this.lWW != null) {
                this.lWW.af(i, z);
            }
        } else if (z) {
            FM(i);
        } else if (aaF() && (bVar = this.lWX[this.mCurrentIndex]) != null && (imageFileInfo = this.lWV[this.mCurrentIndex]) != null && bVar.dod()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.nr(i));
            this.lWU.dpc();
            bVar.l(imageFileInfo);
        }
    }

    private void FM(int i) {
        this.lWY = i;
        if (this.lXd == null) {
            this.lXd = new com.baidu.tbadk.core.dialog.a(this.lWU);
            this.lXd.kD(R.string.rorate_tip);
            this.lXd.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lXd != null) {
                        MultiImagePagerAdapter.this.lXd.dismiss();
                    }
                    MultiImagePagerAdapter.this.lXc.lZr.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dnY() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dnZ() {
                            MultiImagePagerAdapter.this.lWW.dnZ();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean S(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void doa() {
                        }
                    });
                    MultiImagePagerAdapter.this.ae(MultiImagePagerAdapter.this.lWY, false);
                }
            });
            this.lXd.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lXd != null) {
                        MultiImagePagerAdapter.this.lXd.dismiss();
                    }
                }
            });
            this.lXd.b(this.lWU.getPageContext());
        }
        this.lXd.aST();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.lWX[i] == null) {
            this.lWX[i] = new b(i);
        }
        this.mViewPager.addView(this.lWX[i].getView());
        return this.lWX[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.lWX[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dnX();
    }

    private void dnX() {
        if (this.mCurrentIndex >= 0 && this.lWX != null && this.mCurrentIndex < this.lWX.length && this.mCurrentIndex < this.lWV.length && this.lWV[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.lWX.length; i++) {
                if (this.lWX[i] != null) {
                    this.lWX[i].deP();
                }
            }
            if (this.lWX[this.mCurrentIndex] == null) {
                this.lWX[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.lWX[this.mCurrentIndex].l(this.lWV[this.mCurrentIndex]);
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
    public void vy(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.lWV != null) {
            for (int i = 0; i < this.lWV.length; i++) {
                ImageFileInfo imageFileInfo = this.lWV[i];
                if (imageFileInfo != null) {
                    this.lWV[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!aaF()) {
                if (!z && this.mIsFromIm) {
                    R(this.mBitmap);
                }
            } else if (this.lWW != null && this.lWW.doc() && this.lXc != null && this.lXc.lZr != null) {
                this.lXc.lZr.cAk();
                TbImageView tbImageView = this.lWX[this.mCurrentIndex].Yl;
                try {
                    bitmap = this.lXc.lZr.dpF();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bk = com.baidu.tbadk.util.g.bk(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bk;
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
                        this.lWV[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.lWV[this.mCurrentIndex].setContentUriStr(null);
                        this.lWV[this.mCurrentIndex].clearAllActions();
                        this.lWV[this.mCurrentIndex].clearPageActions();
                        this.lWV[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            R(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                R(this.mBitmap);
            }
        }
    }

    private void R(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.lWV[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private TbImageView Yl;
        private int index;
        private FrameLayout lXg;
        private com.baidu.tbadk.img.b lXh;
        private ProgressBar lfX;

        public b(int i) {
            this.lfX = null;
            this.index = -1;
            this.index = i;
            this.lXg = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.lWU.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Yl = (TbImageView) this.lXg.findViewById(R.id.progress_tb_imageview);
            this.Yl.setClickable(true);
            this.Yl.setDefaultResource(0);
            this.Yl.setDefaultErrorResource(0);
            this.Yl.setDefaultBgResource(0);
            this.Yl.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Yl.setPadding(0, 0, 0, 0);
            this.lXh = new com.baidu.tbadk.img.b();
            this.Yl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.lWW != null) {
                        MultiImagePagerAdapter.this.lWW.dob();
                    }
                }
            });
            this.lfX = (ProgressBar) this.lXg.findViewById(R.id.progress_tb_imageview_progress);
            this.lfX.setVisibility(8);
        }

        public View getView() {
            return this.lXg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Yl != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.lWU), (l.getEquipmentHeight(MultiImagePagerAdapter.this.lWU) - l.getDimens(MultiImagePagerAdapter.this.lWU, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Yl.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Yl.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Yl);
                if (MultiImagePagerAdapter.this.lXc != null && MultiImagePagerAdapter.this.lXc.lZr != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.lXc.lZr.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.lXc.lZr.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                deP();
                this.lfX.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.lXh.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.lfX.setVisibility(8);
                    return;
                }
                this.lXh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.lfX.setVisibility(8);
                        if (MultiImagePagerAdapter.this.lXc != null) {
                            MultiImagePagerAdapter.this.lXc.buY();
                        }
                    }
                }, false);
            }
        }

        public void deP() {
            if (this.lXh != null) {
                this.lXh.cancelAllAsyncTask();
            }
            if (this.Yl != null) {
            }
        }

        public boolean dod() {
            return this.lfX.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

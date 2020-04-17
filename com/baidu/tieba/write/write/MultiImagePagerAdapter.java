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
    private WriteMultiImgsActivity lDC;
    private ImageFileInfo[] lDD;
    private a lDE;
    private b[] lDF;
    private int lDG;
    private LinkedList<ImageFileInfo> lDH = new LinkedList<>();
    private int lDI;
    private int lDJ;
    private h lDK;
    private com.baidu.tbadk.core.dialog.a lDL;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void ab(int i, boolean z);

        void dgK();

        void dgM();

        boolean dgN();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.lDC = null;
        this.lDD = null;
        this.mViewPager = null;
        this.lDE = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.lDF = null;
        this.lDI = 120;
        this.lDJ = 120;
        this.mIsFromIm = z;
        this.lDC = writeMultiImgsActivity;
        this.lDK = hVar;
        this.lDI = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.lDJ = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.lDH.size();
        this.lDD = new ImageFileInfo[this.mCount];
        this.lDF = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.lDD[i2] = this.lDH.get(i2).cloneWithoutFilterAction(true);
            this.lDD[i2].addPageAction(com.baidu.tbadk.img.effect.d.aO(this.lDI, this.lDJ));
            linkedList.set(linkedList.indexOf(this.lDH.get(i2)), this.lDD[i2]);
            this.lDD[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.lDE = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.lDH.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.lDH.add(next);
                }
            }
            return this.lDH.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dgG() {
        return this.mCurrentIndex;
    }

    private boolean XM() {
        return (this.lDF == null || this.mCurrentIndex >= this.lDF.length || this.lDF[this.mCurrentIndex] == null || this.lDD == null || this.mCurrentIndex >= this.lDD.length || this.lDD[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dgH() {
        if (this.mCurrentIndex >= this.lDD.length || this.lDD[this.mCurrentIndex] == null || !this.lDD[this.mCurrentIndex].isGif() || this.lDD[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.lDD[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dgH()) {
            if (this.lDE != null) {
                this.lDE.ab(i, z);
            }
        } else if (z) {
            EZ(i);
        } else if (XM() && (bVar = this.lDF[this.mCurrentIndex]) != null && (imageFileInfo = this.lDD[this.mCurrentIndex]) != null && bVar.dgO()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mP(i));
            this.lDC.dhN();
            bVar.l(imageFileInfo);
        }
    }

    private void EZ(int i) {
        this.lDG = i;
        if (this.lDL == null) {
            this.lDL = new com.baidu.tbadk.core.dialog.a(this.lDC);
            this.lDL.kd(R.string.rorate_tip);
            this.lDL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lDL != null) {
                        MultiImagePagerAdapter.this.lDL.dismiss();
                    }
                    MultiImagePagerAdapter.this.lDK.lFZ.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dgJ() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dgK() {
                            MultiImagePagerAdapter.this.lDE.dgK();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean Q(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dgL() {
                        }
                    });
                    MultiImagePagerAdapter.this.aa(MultiImagePagerAdapter.this.lDG, false);
                }
            });
            this.lDL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lDL != null) {
                        MultiImagePagerAdapter.this.lDL.dismiss();
                    }
                }
            });
            this.lDL.b(this.lDC.getPageContext());
        }
        this.lDL.aMU();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.lDF[i] == null) {
            this.lDF[i] = new b(i);
        }
        this.mViewPager.addView(this.lDF[i].getView());
        return this.lDF[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.lDF[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dgI();
    }

    private void dgI() {
        if (this.mCurrentIndex >= 0 && this.lDF != null && this.mCurrentIndex < this.lDF.length && this.mCurrentIndex < this.lDD.length && this.lDD[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.lDF.length; i++) {
                if (this.lDF[i] != null) {
                    this.lDF[i].cXD();
                }
            }
            if (this.lDF[this.mCurrentIndex] == null) {
                this.lDF[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.lDF[this.mCurrentIndex].l(this.lDD[this.mCurrentIndex]);
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
    public void va(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.lDD != null) {
            for (int i = 0; i < this.lDD.length; i++) {
                ImageFileInfo imageFileInfo = this.lDD[i];
                if (imageFileInfo != null) {
                    this.lDD[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!XM()) {
                if (!z && this.mIsFromIm) {
                    P(this.mBitmap);
                }
            } else if (this.lDE != null && this.lDE.dgN() && this.lDK != null && this.lDK.lFZ != null) {
                this.lDK.lFZ.ctK();
                TbImageView tbImageView = this.lDF[this.mCurrentIndex].XS;
                try {
                    bitmap = this.lDK.lFZ.diq();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bj = com.baidu.tbadk.util.g.bj(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bj;
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
                        this.lDD[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.lDD[this.mCurrentIndex].setContentUriStr(null);
                        this.lDD[this.mCurrentIndex].clearAllActions();
                        this.lDD[this.mCurrentIndex].clearPageActions();
                        this.lDD[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            P(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                P(this.mBitmap);
            }
        }
    }

    private void P(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.lDD[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private TbImageView XS;
        private int index;
        private ProgressBar kNC;
        private FrameLayout lDO;
        private com.baidu.tbadk.img.b lDP;

        public b(int i) {
            this.kNC = null;
            this.index = -1;
            this.index = i;
            this.lDO = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.lDC.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.XS = (TbImageView) this.lDO.findViewById(R.id.progress_tb_imageview);
            this.XS.setClickable(true);
            this.XS.setDefaultResource(0);
            this.XS.setDefaultErrorResource(0);
            this.XS.setDefaultBgResource(0);
            this.XS.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.XS.setPadding(0, 0, 0, 0);
            this.lDP = new com.baidu.tbadk.img.b();
            this.XS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.lDE != null) {
                        MultiImagePagerAdapter.this.lDE.dgM();
                    }
                }
            });
            this.kNC = (ProgressBar) this.lDO.findViewById(R.id.progress_tb_imageview_progress);
            this.kNC.setVisibility(8);
        }

        public View getView() {
            return this.lDO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.XS != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.lDC), (l.getEquipmentHeight(MultiImagePagerAdapter.this.lDC) - l.getDimens(MultiImagePagerAdapter.this.lDC, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.XS.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.XS.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.XS);
                if (MultiImagePagerAdapter.this.lDK != null && MultiImagePagerAdapter.this.lDK.lFZ != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.lDK.lFZ.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.lDK.lFZ.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cXD();
                this.kNC.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.lDP.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kNC.setVisibility(8);
                    return;
                }
                this.lDP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kNC.setVisibility(8);
                        if (MultiImagePagerAdapter.this.lDK != null) {
                            MultiImagePagerAdapter.this.lDK.bpj();
                        }
                    }
                }, false);
            }
        }

        public void cXD() {
            if (this.lDP != null) {
                this.lDP.cancelAllAsyncTask();
            }
            if (this.XS != null) {
            }
        }

        public boolean dgO() {
            return this.kNC.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

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
    private WriteMultiImgsActivity obB;
    private ImageFileInfo[] obC;
    private a obD;
    private b[] obE;
    private int obF;
    private LinkedList<ImageFileInfo> obG = new LinkedList<>();
    private int obH;
    private int obI;
    private j obJ;
    private com.baidu.tbadk.core.dialog.a obK;

    /* loaded from: classes3.dex */
    public interface a {
        void am(int i, boolean z);

        void eap();

        void ear();

        boolean eas();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.obB = null;
        this.obC = null;
        this.mViewPager = null;
        this.obD = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.obE = null;
        this.obH = 120;
        this.obI = 120;
        this.mIsFromIm = z;
        this.obB = writeMultiImgsActivity;
        this.obJ = jVar;
        this.obH = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.obI = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.obG.size();
        this.obC = new ImageFileInfo[this.mCount];
        this.obE = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.obC[i2] = this.obG.get(i2).cloneWithoutFilterAction(true);
            this.obC[i2].addPageAction(com.baidu.tbadk.img.effect.d.bi(this.obH, this.obI));
            linkedList.set(linkedList.indexOf(this.obG.get(i2)), this.obC[i2]);
            this.obC[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.obD = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.obG.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.obG.add(next);
                }
            }
            return this.obG.indexOf(imageFileInfo);
        }
        return i;
    }

    public int eal() {
        return this.mCurrentIndex;
    }

    private boolean atE() {
        return (this.obE == null || this.mCurrentIndex >= this.obE.length || this.obE[this.mCurrentIndex] == null || this.obC == null || this.mCurrentIndex >= this.obC.length || this.obC[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean eam() {
        if (this.mCurrentIndex >= this.obC.length || this.obC[this.mCurrentIndex] == null || !this.obC[this.mCurrentIndex].isGif() || this.obC[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.obC[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (eam()) {
            if (this.obD != null) {
                this.obD.am(i, z);
            }
        } else if (z) {
            MZ(i);
        } else if (atE() && (bVar = this.obE[this.mCurrentIndex]) != null && (imageFileInfo = this.obC[this.mCurrentIndex]) != null && bVar.eat()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.sA(i));
            this.obB.ebN();
            bVar.m(imageFileInfo);
        }
    }

    private void MZ(int i) {
        this.obF = i;
        if (this.obK == null) {
            this.obK = new com.baidu.tbadk.core.dialog.a(this.obB);
            this.obK.oQ(R.string.rorate_tip);
            this.obK.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.obK != null) {
                        MultiImagePagerAdapter.this.obK.dismiss();
                    }
                    MultiImagePagerAdapter.this.obJ.oeO.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void eao() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void eap() {
                            MultiImagePagerAdapter.this.obD.eap();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void eaq() {
                        }
                    });
                    MultiImagePagerAdapter.this.al(MultiImagePagerAdapter.this.obF, false);
                }
            });
            this.obK.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.obK != null) {
                        MultiImagePagerAdapter.this.obK.dismiss();
                    }
                }
            });
            this.obK.b(this.obB.getPageContext());
        }
        this.obK.brv();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.obE[i] == null) {
            this.obE[i] = new b(i);
        }
        this.mViewPager.addView(this.obE[i].getView());
        return this.obE[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.obE[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        ean();
    }

    private void ean() {
        if (this.mCurrentIndex >= 0 && this.obE != null && this.mCurrentIndex < this.obE.length && this.mCurrentIndex < this.obC.length && this.obC[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.obE.length; i++) {
                if (this.obE[i] != null) {
                    this.obE[i].dQF();
                }
            }
            if (this.obE[this.mCurrentIndex] == null) {
                this.obE[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.obE[this.mCurrentIndex].m(this.obC[this.mCurrentIndex]);
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
    public void zs(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.obC != null) {
            for (int i = 0; i < this.obC.length; i++) {
                ImageFileInfo imageFileInfo = this.obC[i];
                if (imageFileInfo != null) {
                    this.obC[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!atE()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.obD != null && this.obD.eas() && this.obJ != null && this.obJ.oeO != null) {
                this.obJ.oeO.dkY();
                TbImageView tbImageView = this.obE[this.mCurrentIndex].aaX;
                try {
                    bitmap = this.obJ.oeO.ecw();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bQ = com.baidu.tbadk.util.h.bQ(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bQ;
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
                        this.obC[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.obC[this.mCurrentIndex].setContentUriStr(null);
                        this.obC[this.mCurrentIndex].clearAllActions();
                        this.obC[this.mCurrentIndex].clearPageActions();
                        this.obC[this.mCurrentIndex].setIsGif(false);
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
                this.obC[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView aaX;
        private int index;
        private ProgressBar ngZ;
        private FrameLayout obN;
        private com.baidu.tbadk.img.b obO;

        public b(int i) {
            this.ngZ = null;
            this.index = -1;
            this.index = i;
            this.obN = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.obB.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.aaX = (TbImageView) this.obN.findViewById(R.id.progress_tb_imageview);
            this.aaX.setClickable(true);
            this.aaX.setDefaultResource(0);
            this.aaX.setDefaultErrorResource(0);
            this.aaX.setDefaultBgResource(0);
            this.aaX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aaX.setPadding(0, 0, 0, 0);
            this.obO = new com.baidu.tbadk.img.b();
            this.aaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.obD != null) {
                        MultiImagePagerAdapter.this.obD.ear();
                    }
                }
            });
            this.ngZ = (ProgressBar) this.obN.findViewById(R.id.progress_tb_imageview_progress);
            this.ngZ.setVisibility(8);
        }

        public View getView() {
            return this.obN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.aaX != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.obB), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.obB) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.obB, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aaX.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.aaX.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.aaX);
                if (MultiImagePagerAdapter.this.obJ != null && MultiImagePagerAdapter.this.obJ.oeO != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.obJ.oeO.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.obJ.oeO.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void m(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dQF();
                this.ngZ.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.obO.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.ngZ.setVisibility(8);
                    return;
                }
                this.obO.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.ngZ.setVisibility(8);
                        if (MultiImagePagerAdapter.this.obJ != null) {
                            MultiImagePagerAdapter.this.obJ.bWH();
                        }
                    }
                }, false);
            }
        }

        public void dQF() {
            if (this.obO != null) {
                this.obO.cancelAllAsyncTask();
            }
            if (this.aaX != null) {
            }
        }

        public boolean eat() {
            return this.ngZ.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

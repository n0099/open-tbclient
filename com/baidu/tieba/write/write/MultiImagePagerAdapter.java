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
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int apR;
    private WriteMultiImgsActivity jTC;
    private ImageFileInfo[] jTD;
    private a jTE;
    private b[] jTF;
    private int jTG;
    private LinkedList<ImageFileInfo> jTH = new LinkedList<>();
    private int jTI;
    private int jTJ;
    private h jTK;
    private com.baidu.tbadk.core.dialog.a jTL;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void U(int i, boolean z);

        void czl();

        void czn();

        boolean czo();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jTC = null;
        this.jTD = null;
        this.mViewPager = null;
        this.jTE = null;
        this.mCount = 0;
        this.apR = 0;
        this.jTF = null;
        this.jTI = 120;
        this.jTJ = 120;
        this.mIsFromIm = z;
        this.jTC = writeMultiImgsActivity;
        this.jTK = hVar;
        this.jTI = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jTJ = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.apR = b(linkedList, i);
        this.mCount = this.jTH.size();
        this.jTD = new ImageFileInfo[this.mCount];
        this.jTF = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jTD[i2] = this.jTH.get(i2).cloneWithoutFilterAction(true);
            this.jTD[i2].addPageAction(com.baidu.tbadk.img.effect.d.ao(this.jTI, this.jTJ));
            linkedList.set(linkedList.indexOf(this.jTH.get(i2)), this.jTD[i2]);
            this.jTD[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jTE = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jTH.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jTH.add(next);
                }
            }
            return this.jTH.indexOf(imageFileInfo);
        }
        return i;
    }

    public int czh() {
        return this.apR;
    }

    private boolean abh() {
        return (this.jTF == null || this.apR >= this.jTF.length || this.jTF[this.apR] == null || this.jTD == null || this.apR >= this.jTD.length || this.jTD[this.apR] == null) ? false : true;
    }

    public boolean czi() {
        if (this.apR >= this.jTD.length || this.jTD[this.apR] == null || !this.jTD[this.apR].isGif() || this.jTD[this.apR].mCount > 0) {
            return false;
        }
        this.jTD[this.apR].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (czi()) {
            if (this.jTE != null) {
                this.jTE.U(i, z);
            }
        } else if (z) {
            BL(i);
        } else if (abh() && (bVar = this.jTF[this.apR]) != null && (imageFileInfo = this.jTD[this.apR]) != null && bVar.czp()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.jY(i));
            this.jTC.cAm();
            bVar.j(imageFileInfo);
        }
    }

    private void BL(int i) {
        this.jTG = i;
        if (this.jTL == null) {
            this.jTL = new com.baidu.tbadk.core.dialog.a(this.jTC);
            this.jTL.hU(R.string.rorate_tip);
            this.jTL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jTL != null) {
                        MultiImagePagerAdapter.this.jTL.dismiss();
                    }
                    MultiImagePagerAdapter.this.jTK.jVZ.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void czk() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void czl() {
                            MultiImagePagerAdapter.this.jTE.czl();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void czm() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.jTG, false);
                }
            });
            this.jTL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jTL != null) {
                        MultiImagePagerAdapter.this.jTL.dismiss();
                    }
                }
            });
            this.jTL.b(this.jTC.getPageContext());
        }
        this.jTL.akO();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jTF[i] == null) {
            this.jTF[i] = new b(i);
        }
        this.mViewPager.addView(this.jTF[i].getView());
        return this.jTF[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jTF[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.apR = i;
        czj();
    }

    private void czj() {
        if (this.apR >= 0 && this.jTF != null && this.apR < this.jTF.length && this.apR < this.jTD.length && this.jTD[this.apR] != null) {
            for (int i = 0; i < this.jTF.length; i++) {
                if (this.jTF[i] != null) {
                    this.jTF[i].cpG();
                }
            }
            if (this.jTF[this.apR] == null) {
                this.jTF[this.apR] = new b(this.apR);
            }
            this.jTF[this.apR].j(this.jTD[this.apR]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.apR;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean b(String str, Bitmap bitmap) {
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
    public void rU(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jTD != null) {
            for (int i = 0; i < this.jTD.length; i++) {
                ImageFileInfo imageFileInfo = this.jTD[i];
                if (imageFileInfo != null) {
                    this.jTD[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!abh()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.jTE != null && this.jTE.czo() && this.jTK != null && this.jTK.jVZ != null) {
                this.jTK.jVZ.bOM();
                TbImageView tbImageView = this.jTF[this.apR].BX;
                try {
                    bitmap = this.jTK.jVZ.cAP();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.f.bh(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.f.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.jTD[this.apR].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jTD[this.apR].clearAllActions();
                        this.jTD[this.apR].clearPageActions();
                        this.jTD[this.apR].setIsGif(false);
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
            if (b(str, bitmap)) {
                this.jTD[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView BX;
        private int index;
        private FrameLayout jTO;
        private com.baidu.tbadk.img.b jTP;
        private ProgressBar jdP;

        public b(int i) {
            this.jdP = null;
            this.index = -1;
            this.index = i;
            this.jTO = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jTC.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.BX = (TbImageView) this.jTO.findViewById(R.id.progress_tb_imageview);
            this.BX.setClickable(true);
            this.BX.setDefaultResource(0);
            this.BX.setDefaultErrorResource(0);
            this.BX.setDefaultBgResource(0);
            this.BX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.BX.setPadding(0, 0, 0, 0);
            this.jTP = new com.baidu.tbadk.img.b();
            this.BX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jTE != null) {
                        MultiImagePagerAdapter.this.jTE.czn();
                    }
                }
            });
            this.jdP = (ProgressBar) this.jTO.findViewById(R.id.progress_tb_imageview_progress);
            this.jdP.setVisibility(8);
        }

        public View getView() {
            return this.jTO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.BX != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.jTC), (l.getEquipmentHeight(MultiImagePagerAdapter.this.jTC) - l.getDimens(MultiImagePagerAdapter.this.jTC, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.BX.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.BX.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.BX);
                if (MultiImagePagerAdapter.this.jTK != null && MultiImagePagerAdapter.this.jTK.jVZ != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jTK.jVZ.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.jTK.jVZ.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cpG();
                this.jdP.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jTP.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.jdP.setVisibility(8);
                    return;
                }
                this.jTP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.jdP.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jTK != null) {
                            MultiImagePagerAdapter.this.jTK.aMa();
                        }
                    }
                }, false);
            }
        }

        public void cpG() {
            if (this.jTP != null) {
                this.jTP.cancelAllAsyncTask();
            }
            if (this.BX != null) {
            }
        }

        public boolean czp() {
            return this.jdP.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

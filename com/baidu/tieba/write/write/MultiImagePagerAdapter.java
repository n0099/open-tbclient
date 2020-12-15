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
    private WriteMultiImgsActivity obD;
    private ImageFileInfo[] obE;
    private a obF;
    private b[] obG;
    private int obH;
    private LinkedList<ImageFileInfo> obI = new LinkedList<>();
    private int obJ;
    private int obK;
    private j obL;
    private com.baidu.tbadk.core.dialog.a obM;

    /* loaded from: classes3.dex */
    public interface a {
        void am(int i, boolean z);

        void eaq();

        void eas();

        boolean eat();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.obD = null;
        this.obE = null;
        this.mViewPager = null;
        this.obF = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.obG = null;
        this.obJ = 120;
        this.obK = 120;
        this.mIsFromIm = z;
        this.obD = writeMultiImgsActivity;
        this.obL = jVar;
        this.obJ = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.obK = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.obI.size();
        this.obE = new ImageFileInfo[this.mCount];
        this.obG = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.obE[i2] = this.obI.get(i2).cloneWithoutFilterAction(true);
            this.obE[i2].addPageAction(com.baidu.tbadk.img.effect.d.bi(this.obJ, this.obK));
            linkedList.set(linkedList.indexOf(this.obI.get(i2)), this.obE[i2]);
            this.obE[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.obF = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.obI.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.obI.add(next);
                }
            }
            return this.obI.indexOf(imageFileInfo);
        }
        return i;
    }

    public int eam() {
        return this.mCurrentIndex;
    }

    private boolean atE() {
        return (this.obG == null || this.mCurrentIndex >= this.obG.length || this.obG[this.mCurrentIndex] == null || this.obE == null || this.mCurrentIndex >= this.obE.length || this.obE[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean ean() {
        if (this.mCurrentIndex >= this.obE.length || this.obE[this.mCurrentIndex] == null || !this.obE[this.mCurrentIndex].isGif() || this.obE[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.obE[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (ean()) {
            if (this.obF != null) {
                this.obF.am(i, z);
            }
        } else if (z) {
            MZ(i);
        } else if (atE() && (bVar = this.obG[this.mCurrentIndex]) != null && (imageFileInfo = this.obE[this.mCurrentIndex]) != null && bVar.eau()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.sA(i));
            this.obD.ebO();
            bVar.m(imageFileInfo);
        }
    }

    private void MZ(int i) {
        this.obH = i;
        if (this.obM == null) {
            this.obM = new com.baidu.tbadk.core.dialog.a(this.obD);
            this.obM.oQ(R.string.rorate_tip);
            this.obM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.obM != null) {
                        MultiImagePagerAdapter.this.obM.dismiss();
                    }
                    MultiImagePagerAdapter.this.obL.oeQ.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void eap() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void eaq() {
                            MultiImagePagerAdapter.this.obF.eaq();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void ear() {
                        }
                    });
                    MultiImagePagerAdapter.this.al(MultiImagePagerAdapter.this.obH, false);
                }
            });
            this.obM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.obM != null) {
                        MultiImagePagerAdapter.this.obM.dismiss();
                    }
                }
            });
            this.obM.b(this.obD.getPageContext());
        }
        this.obM.brv();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.obG[i] == null) {
            this.obG[i] = new b(i);
        }
        this.mViewPager.addView(this.obG[i].getView());
        return this.obG[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.obG[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        eao();
    }

    private void eao() {
        if (this.mCurrentIndex >= 0 && this.obG != null && this.mCurrentIndex < this.obG.length && this.mCurrentIndex < this.obE.length && this.obE[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.obG.length; i++) {
                if (this.obG[i] != null) {
                    this.obG[i].dQG();
                }
            }
            if (this.obG[this.mCurrentIndex] == null) {
                this.obG[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.obG[this.mCurrentIndex].m(this.obE[this.mCurrentIndex]);
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
        if (this.obE != null) {
            for (int i = 0; i < this.obE.length; i++) {
                ImageFileInfo imageFileInfo = this.obE[i];
                if (imageFileInfo != null) {
                    this.obE[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!atE()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.obF != null && this.obF.eat() && this.obL != null && this.obL.oeQ != null) {
                this.obL.oeQ.dkZ();
                TbImageView tbImageView = this.obG[this.mCurrentIndex].aaX;
                try {
                    bitmap = this.obL.oeQ.ecx();
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
                        this.obE[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.obE[this.mCurrentIndex].setContentUriStr(null);
                        this.obE[this.mCurrentIndex].clearAllActions();
                        this.obE[this.mCurrentIndex].clearPageActions();
                        this.obE[this.mCurrentIndex].setIsGif(false);
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
                this.obE[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView aaX;
        private int index;
        private ProgressBar nhb;
        private FrameLayout obP;
        private com.baidu.tbadk.img.b obQ;

        public b(int i) {
            this.nhb = null;
            this.index = -1;
            this.index = i;
            this.obP = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.obD.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.aaX = (TbImageView) this.obP.findViewById(R.id.progress_tb_imageview);
            this.aaX.setClickable(true);
            this.aaX.setDefaultResource(0);
            this.aaX.setDefaultErrorResource(0);
            this.aaX.setDefaultBgResource(0);
            this.aaX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aaX.setPadding(0, 0, 0, 0);
            this.obQ = new com.baidu.tbadk.img.b();
            this.aaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.obF != null) {
                        MultiImagePagerAdapter.this.obF.eas();
                    }
                }
            });
            this.nhb = (ProgressBar) this.obP.findViewById(R.id.progress_tb_imageview_progress);
            this.nhb.setVisibility(8);
        }

        public View getView() {
            return this.obP;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.aaX != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.obD), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.obD) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.obD, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aaX.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.aaX.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.aaX);
                if (MultiImagePagerAdapter.this.obL != null && MultiImagePagerAdapter.this.obL.oeQ != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.obL.oeQ.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.obL.oeQ.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void m(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dQG();
                this.nhb.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.obQ.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nhb.setVisibility(8);
                    return;
                }
                this.obQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nhb.setVisibility(8);
                        if (MultiImagePagerAdapter.this.obL != null) {
                            MultiImagePagerAdapter.this.obL.bWI();
                        }
                    }
                }, false);
            }
        }

        public void dQG() {
            if (this.obQ != null) {
                this.obQ.cancelAllAsyncTask();
            }
            if (this.aaX != null) {
            }
        }

        public boolean eau() {
            return this.nhb.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

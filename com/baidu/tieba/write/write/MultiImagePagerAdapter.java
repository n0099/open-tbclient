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
    private WriteMultiImgsActivity mAP;
    private ImageFileInfo[] mAQ;
    private a mAR;
    private b[] mAS;
    private int mAT;
    private LinkedList<ImageFileInfo> mAU = new LinkedList<>();
    private int mAV;
    private int mAW;
    private h mAX;
    private com.baidu.tbadk.core.dialog.a mAY;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void ah(int i, boolean z);

        void dvS();

        void dvU();

        boolean dvV();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.mAP = null;
        this.mAQ = null;
        this.mViewPager = null;
        this.mAR = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.mAS = null;
        this.mAV = 120;
        this.mAW = 120;
        this.mIsFromIm = z;
        this.mAP = writeMultiImgsActivity;
        this.mAX = hVar;
        this.mAV = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.mAW = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.mAU.size();
        this.mAQ = new ImageFileInfo[this.mCount];
        this.mAS = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.mAQ[i2] = this.mAU.get(i2).cloneWithoutFilterAction(true);
            this.mAQ[i2].addPageAction(com.baidu.tbadk.img.effect.d.aX(this.mAV, this.mAW));
            linkedList.set(linkedList.indexOf(this.mAU.get(i2)), this.mAQ[i2]);
            this.mAQ[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.mAR = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.mAU.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.mAU.add(next);
                }
            }
            return this.mAU.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dvO() {
        return this.mCurrentIndex;
    }

    private boolean acP() {
        return (this.mAS == null || this.mCurrentIndex >= this.mAS.length || this.mAS[this.mCurrentIndex] == null || this.mAQ == null || this.mCurrentIndex >= this.mAQ.length || this.mAQ[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dvP() {
        if (this.mCurrentIndex >= this.mAQ.length || this.mAQ[this.mCurrentIndex] == null || !this.mAQ[this.mCurrentIndex].isGif() || this.mAQ[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.mAQ[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ag(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dvP()) {
            if (this.mAR != null) {
                this.mAR.ah(i, z);
            }
        } else if (z) {
            Ho(i);
        } else if (acP() && (bVar = this.mAS[this.mCurrentIndex]) != null && (imageFileInfo = this.mAQ[this.mCurrentIndex]) != null && bVar.dvW()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.og(i));
            this.mAP.dxb();
            bVar.l(imageFileInfo);
        }
    }

    private void Ho(int i) {
        this.mAT = i;
        if (this.mAY == null) {
            this.mAY = new com.baidu.tbadk.core.dialog.a(this.mAP);
            this.mAY.ln(R.string.rorate_tip);
            this.mAY.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mAY != null) {
                        MultiImagePagerAdapter.this.mAY.dismiss();
                    }
                    MultiImagePagerAdapter.this.mAX.mDA.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dvR() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dvS() {
                            MultiImagePagerAdapter.this.mAR.dvS();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean V(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dvT() {
                        }
                    });
                    MultiImagePagerAdapter.this.ag(MultiImagePagerAdapter.this.mAT, false);
                }
            });
            this.mAY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mAY != null) {
                        MultiImagePagerAdapter.this.mAY.dismiss();
                    }
                }
            });
            this.mAY.b(this.mAP.getPageContext());
        }
        this.mAY.aYL();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mAS[i] == null) {
            this.mAS[i] = new b(i);
        }
        this.mViewPager.addView(this.mAS[i].getView());
        return this.mAS[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.mAS[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dvQ();
    }

    private void dvQ() {
        if (this.mCurrentIndex >= 0 && this.mAS != null && this.mCurrentIndex < this.mAS.length && this.mCurrentIndex < this.mAQ.length && this.mAQ[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.mAS.length; i++) {
                if (this.mAS[i] != null) {
                    this.mAS[i].dmy();
                }
            }
            if (this.mAS[this.mCurrentIndex] == null) {
                this.mAS[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.mAS[this.mCurrentIndex].l(this.mAQ[this.mCurrentIndex]);
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
        if (this.mAQ != null) {
            for (int i = 0; i < this.mAQ.length; i++) {
                ImageFileInfo imageFileInfo = this.mAQ[i];
                if (imageFileInfo != null) {
                    this.mAQ[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!acP()) {
                if (!z && this.mIsFromIm) {
                    U(this.mBitmap);
                }
            } else if (this.mAR != null && this.mAR.dvV() && this.mAX != null && this.mAX.mDA != null) {
                this.mAX.mDA.cIB();
                TbImageView tbImageView = this.mAS[this.mCurrentIndex].YF;
                try {
                    bitmap = this.mAX.mDA.dxE();
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
                        this.mAQ[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.mAQ[this.mCurrentIndex].setContentUriStr(null);
                        this.mAQ[this.mCurrentIndex].clearAllActions();
                        this.mAQ[this.mCurrentIndex].clearPageActions();
                        this.mAQ[this.mCurrentIndex].setIsGif(false);
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
                this.mAQ[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView YF;
        private int index;
        private ProgressBar lIs;
        private FrameLayout mBb;
        private com.baidu.tbadk.img.b mBc;

        public b(int i) {
            this.lIs = null;
            this.index = -1;
            this.index = i;
            this.mBb = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.mAP.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.YF = (TbImageView) this.mBb.findViewById(R.id.progress_tb_imageview);
            this.YF.setClickable(true);
            this.YF.setDefaultResource(0);
            this.YF.setDefaultErrorResource(0);
            this.YF.setDefaultBgResource(0);
            this.YF.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.YF.setPadding(0, 0, 0, 0);
            this.mBc = new com.baidu.tbadk.img.b();
            this.YF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.mAR != null) {
                        MultiImagePagerAdapter.this.mAR.dvU();
                    }
                }
            });
            this.lIs = (ProgressBar) this.mBb.findViewById(R.id.progress_tb_imageview_progress);
            this.lIs.setVisibility(8);
        }

        public View getView() {
            return this.mBb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.YF != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.mAP), (l.getEquipmentHeight(MultiImagePagerAdapter.this.mAP) - l.getDimens(MultiImagePagerAdapter.this.mAP, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YF.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.YF.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.YF);
                if (MultiImagePagerAdapter.this.mAX != null && MultiImagePagerAdapter.this.mAX.mDA != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.mAX.mDA.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.mAX.mDA.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dmy();
                this.lIs.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.mBc.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.lIs.setVisibility(8);
                    return;
                }
                this.mBc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.lIs.setVisibility(8);
                        if (MultiImagePagerAdapter.this.mAX != null) {
                            MultiImagePagerAdapter.this.mAX.bBl();
                        }
                    }
                }, false);
            }
        }

        public void dmy() {
            if (this.mBc != null) {
                this.mBc.cancelAllAsyncTask();
            }
            if (this.YF != null) {
            }
        }

        public boolean dvW() {
            return this.lIs.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

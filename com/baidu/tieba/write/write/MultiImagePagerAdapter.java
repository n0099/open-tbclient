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
    private WriteMultiImgsActivity ndQ;
    private ImageFileInfo[] ndR;
    private a ndS;
    private b[] ndT;
    private int ndU;
    private LinkedList<ImageFileInfo> ndV = new LinkedList<>();
    private int ndW;
    private int ndX;
    private j ndY;
    private com.baidu.tbadk.core.dialog.a ndZ;

    /* loaded from: classes3.dex */
    public interface a {
        void ak(int i, boolean z);

        void dLA();

        void dLC();

        boolean dLD();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.ndQ = null;
        this.ndR = null;
        this.mViewPager = null;
        this.ndS = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.ndT = null;
        this.ndW = 120;
        this.ndX = 120;
        this.mIsFromIm = z;
        this.ndQ = writeMultiImgsActivity;
        this.ndY = jVar;
        this.ndW = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.ndX = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.ndV.size();
        this.ndR = new ImageFileInfo[this.mCount];
        this.ndT = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.ndR[i2] = this.ndV.get(i2).cloneWithoutFilterAction(true);
            this.ndR[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.ndW, this.ndX));
            linkedList.set(linkedList.indexOf(this.ndV.get(i2)), this.ndR[i2]);
            this.ndR[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.ndS = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.ndV.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.ndV.add(next);
                }
            }
            return this.ndV.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dLw() {
        return this.mCurrentIndex;
    }

    private boolean ajY() {
        return (this.ndT == null || this.mCurrentIndex >= this.ndT.length || this.ndT[this.mCurrentIndex] == null || this.ndR == null || this.mCurrentIndex >= this.ndR.length || this.ndR[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dLx() {
        if (this.mCurrentIndex >= this.ndR.length || this.ndR[this.mCurrentIndex] == null || !this.ndR[this.mCurrentIndex].isGif() || this.ndR[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.ndR[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dLx()) {
            if (this.ndS != null) {
                this.ndS.ak(i, z);
            }
        } else if (z) {
            Kt(i);
        } else if (ajY() && (bVar = this.ndT[this.mCurrentIndex]) != null && (imageFileInfo = this.ndR[this.mCurrentIndex]) != null && bVar.dLE()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.qI(i));
            this.ndQ.dMX();
            bVar.l(imageFileInfo);
        }
    }

    private void Kt(int i) {
        this.ndU = i;
        if (this.ndZ == null) {
            this.ndZ = new com.baidu.tbadk.core.dialog.a(this.ndQ);
            this.ndZ.nE(R.string.rorate_tip);
            this.ndZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ndZ != null) {
                        MultiImagePagerAdapter.this.ndZ.dismiss();
                    }
                    MultiImagePagerAdapter.this.ndY.ngS.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dLz() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dLA() {
                            MultiImagePagerAdapter.this.ndS.dLA();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dLB() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.ndU, false);
                }
            });
            this.ndZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ndZ != null) {
                        MultiImagePagerAdapter.this.ndZ.dismiss();
                    }
                }
            });
            this.ndZ.b(this.ndQ.getPageContext());
        }
        this.ndZ.bia();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ndT[i] == null) {
            this.ndT[i] = new b(i);
        }
        this.mViewPager.addView(this.ndT[i].getView());
        return this.ndT[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.ndT[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dLy();
    }

    private void dLy() {
        if (this.mCurrentIndex >= 0 && this.ndT != null && this.mCurrentIndex < this.ndT.length && this.mCurrentIndex < this.ndR.length && this.ndR[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.ndT.length; i++) {
                if (this.ndT[i] != null) {
                    this.ndT[i].dBS();
                }
            }
            if (this.ndT[this.mCurrentIndex] == null) {
                this.ndT[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.ndT[this.mCurrentIndex].l(this.ndR[this.mCurrentIndex]);
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
    public void xz(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.ndR != null) {
            for (int i = 0; i < this.ndR.length; i++) {
                ImageFileInfo imageFileInfo = this.ndR[i];
                if (imageFileInfo != null) {
                    this.ndR[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!ajY()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.ndS != null && this.ndS.dLD() && this.ndY != null && this.ndY.ngS != null) {
                this.ndY.ngS.cWW();
                TbImageView tbImageView = this.ndT[this.mCurrentIndex].ZF;
                try {
                    bitmap = this.ndY.ngS.dNz();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bx = com.baidu.tbadk.util.h.bx(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bx;
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
                        this.ndR[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.ndR[this.mCurrentIndex].setContentUriStr(null);
                        this.ndR[this.mCurrentIndex].clearAllActions();
                        this.ndR[this.mCurrentIndex].clearPageActions();
                        this.ndR[this.mCurrentIndex].setIsGif(false);
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
                this.ndR[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView ZF;
        private int index;
        private ProgressBar mjT;
        private FrameLayout nec;
        private com.baidu.tbadk.img.b ned;

        public b(int i) {
            this.mjT = null;
            this.index = -1;
            this.index = i;
            this.nec = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.ndQ.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.ZF = (TbImageView) this.nec.findViewById(R.id.progress_tb_imageview);
            this.ZF.setClickable(true);
            this.ZF.setDefaultResource(0);
            this.ZF.setDefaultErrorResource(0);
            this.ZF.setDefaultBgResource(0);
            this.ZF.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ZF.setPadding(0, 0, 0, 0);
            this.ned = new com.baidu.tbadk.img.b();
            this.ZF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.ndS != null) {
                        MultiImagePagerAdapter.this.ndS.dLC();
                    }
                }
            });
            this.mjT = (ProgressBar) this.nec.findViewById(R.id.progress_tb_imageview_progress);
            this.mjT.setVisibility(8);
        }

        public View getView() {
            return this.nec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.ZF != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.ndQ), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.ndQ) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.ndQ, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ZF.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.ZF.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.ZF);
                if (MultiImagePagerAdapter.this.ndY != null && MultiImagePagerAdapter.this.ndY.ngS != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.ndY.ngS.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.ndY.ngS.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dBS();
                this.mjT.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.ned.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.mjT.setVisibility(8);
                    return;
                }
                this.ned.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.mjT.setVisibility(8);
                        if (MultiImagePagerAdapter.this.ndY != null) {
                            MultiImagePagerAdapter.this.ndY.bLQ();
                        }
                    }
                }, false);
            }
        }

        public void dBS() {
            if (this.ned != null) {
                this.ned.cancelAllAsyncTask();
            }
            if (this.ZF != null) {
            }
        }

        public boolean dLE() {
            return this.mjT.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

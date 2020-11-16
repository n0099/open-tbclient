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
    private WriteMultiImgsActivity nNj;
    private ImageFileInfo[] nNk;
    private a nNl;
    private b[] nNm;
    private int nNn;
    private LinkedList<ImageFileInfo> nNo = new LinkedList<>();
    private int nNp;
    private int nNq;
    private j nNr;
    private com.baidu.tbadk.core.dialog.a nNs;

    /* loaded from: classes3.dex */
    public interface a {
        void am(int i, boolean z);

        void dUT();

        void dUV();

        boolean dUW();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.nNj = null;
        this.nNk = null;
        this.mViewPager = null;
        this.nNl = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.nNm = null;
        this.nNp = 120;
        this.nNq = 120;
        this.mIsFromIm = z;
        this.nNj = writeMultiImgsActivity;
        this.nNr = jVar;
        this.nNp = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.nNq = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.nNo.size();
        this.nNk = new ImageFileInfo[this.mCount];
        this.nNm = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.nNk[i2] = this.nNo.get(i2).cloneWithoutFilterAction(true);
            this.nNk[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.nNp, this.nNq));
            linkedList.set(linkedList.indexOf(this.nNo.get(i2)), this.nNk[i2]);
            this.nNk[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.nNl = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.nNo.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.nNo.add(next);
                }
            }
            return this.nNo.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dUP() {
        return this.mCurrentIndex;
    }

    private boolean aqw() {
        return (this.nNm == null || this.mCurrentIndex >= this.nNm.length || this.nNm[this.mCurrentIndex] == null || this.nNk == null || this.mCurrentIndex >= this.nNk.length || this.nNk[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dUQ() {
        if (this.mCurrentIndex >= this.nNk.length || this.nNk[this.mCurrentIndex] == null || !this.nNk[this.mCurrentIndex].isGif() || this.nNk[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.nNk[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dUQ()) {
            if (this.nNl != null) {
                this.nNl.am(i, z);
            }
        } else if (z) {
            Mh(i);
        } else if (aqw() && (bVar = this.nNm[this.mCurrentIndex]) != null && (imageFileInfo = this.nNk[this.mCurrentIndex]) != null && bVar.dUX()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rZ(i));
            this.nNj.dWq();
            bVar.l(imageFileInfo);
        }
    }

    private void Mh(int i) {
        this.nNn = i;
        if (this.nNs == null) {
            this.nNs = new com.baidu.tbadk.core.dialog.a(this.nNj);
            this.nNs.os(R.string.rorate_tip);
            this.nNs.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nNs != null) {
                        MultiImagePagerAdapter.this.nNs.dismiss();
                    }
                    MultiImagePagerAdapter.this.nNr.nQm.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dUS() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dUT() {
                            MultiImagePagerAdapter.this.nNl.dUT();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dUU() {
                        }
                    });
                    MultiImagePagerAdapter.this.al(MultiImagePagerAdapter.this.nNn, false);
                }
            });
            this.nNs.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nNs != null) {
                        MultiImagePagerAdapter.this.nNs.dismiss();
                    }
                }
            });
            this.nNs.b(this.nNj.getPageContext());
        }
        this.nNs.bog();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.nNm[i] == null) {
            this.nNm[i] = new b(i);
        }
        this.mViewPager.addView(this.nNm[i].getView());
        return this.nNm[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.nNm[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dUR();
    }

    private void dUR() {
        if (this.mCurrentIndex >= 0 && this.nNm != null && this.mCurrentIndex < this.nNm.length && this.mCurrentIndex < this.nNk.length && this.nNk[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.nNm.length; i++) {
                if (this.nNm[i] != null) {
                    this.nNm[i].dLn();
                }
            }
            if (this.nNm[this.mCurrentIndex] == null) {
                this.nNm[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.nNm[this.mCurrentIndex].l(this.nNk[this.mCurrentIndex]);
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
    public void yN(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.nNk != null) {
            for (int i = 0; i < this.nNk.length; i++) {
                ImageFileInfo imageFileInfo = this.nNk[i];
                if (imageFileInfo != null) {
                    this.nNk[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!aqw()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.nNl != null && this.nNl.dUW() && this.nNr != null && this.nNr.nQm != null) {
                this.nNr.nQm.dfM();
                TbImageView tbImageView = this.nNm[this.mCurrentIndex].aab;
                try {
                    bitmap = this.nNr.nQm.dWS();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bJ = com.baidu.tbadk.util.h.bJ(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bJ;
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
                        this.nNk[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.nNk[this.mCurrentIndex].setContentUriStr(null);
                        this.nNk[this.mCurrentIndex].clearAllActions();
                        this.nNk[this.mCurrentIndex].clearPageActions();
                        this.nNk[this.mCurrentIndex].setIsGif(false);
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
                this.nNk[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView aab;
        private int index;
        private ProgressBar mSY;
        private FrameLayout nNv;
        private com.baidu.tbadk.img.b nNw;

        public b(int i) {
            this.mSY = null;
            this.index = -1;
            this.index = i;
            this.nNv = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.nNj.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.aab = (TbImageView) this.nNv.findViewById(R.id.progress_tb_imageview);
            this.aab.setClickable(true);
            this.aab.setDefaultResource(0);
            this.aab.setDefaultErrorResource(0);
            this.aab.setDefaultBgResource(0);
            this.aab.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aab.setPadding(0, 0, 0, 0);
            this.nNw = new com.baidu.tbadk.img.b();
            this.aab.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.nNl != null) {
                        MultiImagePagerAdapter.this.nNl.dUV();
                    }
                }
            });
            this.mSY = (ProgressBar) this.nNv.findViewById(R.id.progress_tb_imageview_progress);
            this.mSY.setVisibility(8);
        }

        public View getView() {
            return this.nNv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.aab != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.nNj), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.nNj) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.nNj, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aab.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.aab.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.aab);
                if (MultiImagePagerAdapter.this.nNr != null && MultiImagePagerAdapter.this.nNr.nQm != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.nNr.nQm.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.nNr.nQm.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dLn();
                this.mSY.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.nNw.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.mSY.setVisibility(8);
                    return;
                }
                this.nNw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.mSY.setVisibility(8);
                        if (MultiImagePagerAdapter.this.nNr != null) {
                            MultiImagePagerAdapter.this.nNr.bSX();
                        }
                    }
                }, false);
            }
        }

        public void dLn() {
            if (this.nNw != null) {
                this.nNw.cancelAllAsyncTask();
            }
            if (this.aab != null) {
            }
        }

        public boolean dUX() {
            return this.mSY.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

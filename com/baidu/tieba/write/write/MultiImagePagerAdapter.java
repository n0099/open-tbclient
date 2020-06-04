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
    private WriteMultiImgsActivity lYf;
    private ImageFileInfo[] lYg;
    private a lYh;
    private b[] lYi;
    private int lYj;
    private LinkedList<ImageFileInfo> lYk = new LinkedList<>();
    private int lYl;
    private int lYm;
    private h lYn;
    private com.baidu.tbadk.core.dialog.a lYo;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void af(int i, boolean z);

        void doo();

        void doq();

        boolean dor();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.lYf = null;
        this.lYg = null;
        this.mViewPager = null;
        this.lYh = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.lYi = null;
        this.lYl = 120;
        this.lYm = 120;
        this.mIsFromIm = z;
        this.lYf = writeMultiImgsActivity;
        this.lYn = hVar;
        this.lYl = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.lYm = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.lYk.size();
        this.lYg = new ImageFileInfo[this.mCount];
        this.lYi = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.lYg[i2] = this.lYk.get(i2).cloneWithoutFilterAction(true);
            this.lYg[i2].addPageAction(com.baidu.tbadk.img.effect.d.aS(this.lYl, this.lYm));
            linkedList.set(linkedList.indexOf(this.lYk.get(i2)), this.lYg[i2]);
            this.lYg[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.lYh = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.lYk.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.lYk.add(next);
                }
            }
            return this.lYk.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dok() {
        return this.mCurrentIndex;
    }

    private boolean aaF() {
        return (this.lYi == null || this.mCurrentIndex >= this.lYi.length || this.lYi[this.mCurrentIndex] == null || this.lYg == null || this.mCurrentIndex >= this.lYg.length || this.lYg[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dol() {
        if (this.mCurrentIndex >= this.lYg.length || this.lYg[this.mCurrentIndex] == null || !this.lYg[this.mCurrentIndex].isGif() || this.lYg[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.lYg[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ae(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dol()) {
            if (this.lYh != null) {
                this.lYh.af(i, z);
            }
        } else if (z) {
            FO(i);
        } else if (aaF() && (bVar = this.lYi[this.mCurrentIndex]) != null && (imageFileInfo = this.lYg[this.mCurrentIndex]) != null && bVar.dos()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.nt(i));
            this.lYf.dpq();
            bVar.l(imageFileInfo);
        }
    }

    private void FO(int i) {
        this.lYj = i;
        if (this.lYo == null) {
            this.lYo = new com.baidu.tbadk.core.dialog.a(this.lYf);
            this.lYo.kF(R.string.rorate_tip);
            this.lYo.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lYo != null) {
                        MultiImagePagerAdapter.this.lYo.dismiss();
                    }
                    MultiImagePagerAdapter.this.lYn.maF.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void don() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void doo() {
                            MultiImagePagerAdapter.this.lYh.doo();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean S(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dop() {
                        }
                    });
                    MultiImagePagerAdapter.this.ae(MultiImagePagerAdapter.this.lYj, false);
                }
            });
            this.lYo.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lYo != null) {
                        MultiImagePagerAdapter.this.lYo.dismiss();
                    }
                }
            });
            this.lYo.b(this.lYf.getPageContext());
        }
        this.lYo.aST();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.lYi[i] == null) {
            this.lYi[i] = new b(i);
        }
        this.mViewPager.addView(this.lYi[i].getView());
        return this.lYi[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.lYi[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dom();
    }

    private void dom() {
        if (this.mCurrentIndex >= 0 && this.lYi != null && this.mCurrentIndex < this.lYi.length && this.mCurrentIndex < this.lYg.length && this.lYg[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.lYi.length; i++) {
                if (this.lYi[i] != null) {
                    this.lYi[i].dfe();
                }
            }
            if (this.lYi[this.mCurrentIndex] == null) {
                this.lYi[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.lYi[this.mCurrentIndex].l(this.lYg[this.mCurrentIndex]);
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
    public void vA(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.lYg != null) {
            for (int i = 0; i < this.lYg.length; i++) {
                ImageFileInfo imageFileInfo = this.lYg[i];
                if (imageFileInfo != null) {
                    this.lYg[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!aaF()) {
                if (!z && this.mIsFromIm) {
                    R(this.mBitmap);
                }
            } else if (this.lYh != null && this.lYh.dor() && this.lYn != null && this.lYn.maF != null) {
                this.lYn.maF.cAB();
                TbImageView tbImageView = this.lYi[this.mCurrentIndex].Yl;
                try {
                    bitmap = this.lYn.maF.dpT();
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
                        this.lYg[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.lYg[this.mCurrentIndex].setContentUriStr(null);
                        this.lYg[this.mCurrentIndex].clearAllActions();
                        this.lYg[this.mCurrentIndex].clearPageActions();
                        this.lYg[this.mCurrentIndex].setIsGif(false);
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
                this.lYg[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private TbImageView Yl;
        private int index;
        private FrameLayout lYr;
        private com.baidu.tbadk.img.b lYs;
        private ProgressBar lhg;

        public b(int i) {
            this.lhg = null;
            this.index = -1;
            this.index = i;
            this.lYr = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.lYf.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Yl = (TbImageView) this.lYr.findViewById(R.id.progress_tb_imageview);
            this.Yl.setClickable(true);
            this.Yl.setDefaultResource(0);
            this.Yl.setDefaultErrorResource(0);
            this.Yl.setDefaultBgResource(0);
            this.Yl.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Yl.setPadding(0, 0, 0, 0);
            this.lYs = new com.baidu.tbadk.img.b();
            this.Yl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.lYh != null) {
                        MultiImagePagerAdapter.this.lYh.doq();
                    }
                }
            });
            this.lhg = (ProgressBar) this.lYr.findViewById(R.id.progress_tb_imageview_progress);
            this.lhg.setVisibility(8);
        }

        public View getView() {
            return this.lYr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Yl != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.lYf), (l.getEquipmentHeight(MultiImagePagerAdapter.this.lYf) - l.getDimens(MultiImagePagerAdapter.this.lYf, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Yl.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Yl.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Yl);
                if (MultiImagePagerAdapter.this.lYn != null && MultiImagePagerAdapter.this.lYn.maF != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.lYn.maF.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.lYn.maF.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dfe();
                this.lhg.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.lYs.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.lhg.setVisibility(8);
                    return;
                }
                this.lYs.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.lhg.setVisibility(8);
                        if (MultiImagePagerAdapter.this.lYn != null) {
                            MultiImagePagerAdapter.this.lYn.bva();
                        }
                    }
                }, false);
            }
        }

        public void dfe() {
            if (this.lYs != null) {
                this.lYs.cancelAllAsyncTask();
            }
            if (this.Yl != null) {
            }
        }

        public boolean dos() {
            return this.lhg.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

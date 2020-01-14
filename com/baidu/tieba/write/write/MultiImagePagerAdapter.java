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
/* loaded from: classes11.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private WriteMultiImgsActivity kRf;
    private ImageFileInfo[] kRg;
    private a kRh;
    private b[] kRi;
    private int kRj;
    private LinkedList<ImageFileInfo> kRk = new LinkedList<>();
    private int kRl;
    private int kRm;
    private h kRn;
    private com.baidu.tbadk.core.dialog.a kRo;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public interface a {
        void V(int i, boolean z);

        void cUo();

        void cUq();

        boolean cUr();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.kRf = null;
        this.kRg = null;
        this.mViewPager = null;
        this.kRh = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.kRi = null;
        this.kRl = 120;
        this.kRm = 120;
        this.mIsFromIm = z;
        this.kRf = writeMultiImgsActivity;
        this.kRn = hVar;
        this.kRl = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.kRm = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.kRk.size();
        this.kRg = new ImageFileInfo[this.mCount];
        this.kRi = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.kRg[i2] = this.kRk.get(i2).cloneWithoutFilterAction(true);
            this.kRg[i2].addPageAction(com.baidu.tbadk.img.effect.d.aJ(this.kRl, this.kRm));
            linkedList.set(linkedList.indexOf(this.kRk.get(i2)), this.kRg[i2]);
            this.kRg[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.kRh = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.kRk.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.kRk.add(next);
                }
            }
            return this.kRk.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cUk() {
        return this.mCurrentIndex;
    }

    private boolean NE() {
        return (this.kRi == null || this.mCurrentIndex >= this.kRi.length || this.kRi[this.mCurrentIndex] == null || this.kRg == null || this.mCurrentIndex >= this.kRg.length || this.kRg[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean cUl() {
        if (this.mCurrentIndex >= this.kRg.length || this.kRg[this.mCurrentIndex] == null || !this.kRg[this.mCurrentIndex].isGif() || this.kRg[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.kRg[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cUl()) {
            if (this.kRh != null) {
                this.kRh.V(i, z);
            }
        } else if (z) {
            Em(i);
        } else if (NE() && (bVar = this.kRi[this.mCurrentIndex]) != null && (imageFileInfo = this.kRg[this.mCurrentIndex]) != null && bVar.cUs()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mk(i));
            this.kRf.cVq();
            bVar.j(imageFileInfo);
        }
    }

    private void Em(int i) {
        this.kRj = i;
        if (this.kRo == null) {
            this.kRo = new com.baidu.tbadk.core.dialog.a(this.kRf);
            this.kRo.jF(R.string.rorate_tip);
            this.kRo.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRo != null) {
                        MultiImagePagerAdapter.this.kRo.dismiss();
                    }
                    MultiImagePagerAdapter.this.kRn.kTB.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cUn() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cUo() {
                            MultiImagePagerAdapter.this.kRh.cUo();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cUp() {
                        }
                    });
                    MultiImagePagerAdapter.this.U(MultiImagePagerAdapter.this.kRj, false);
                }
            });
            this.kRo.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRo != null) {
                        MultiImagePagerAdapter.this.kRo.dismiss();
                    }
                }
            });
            this.kRo.b(this.kRf.getPageContext());
        }
        this.kRo.aCp();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kRi[i] == null) {
            this.kRi[i] = new b(i);
        }
        this.mViewPager.addView(this.kRi[i].getView());
        return this.kRi[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.kRi[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        cUm();
    }

    private void cUm() {
        if (this.mCurrentIndex >= 0 && this.kRi != null && this.mCurrentIndex < this.kRi.length && this.mCurrentIndex < this.kRg.length && this.kRg[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.kRi.length; i++) {
                if (this.kRi[i] != null) {
                    this.kRi[i].cKO();
                }
            }
            if (this.kRi[this.mCurrentIndex] == null) {
                this.kRi[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.kRi[this.mCurrentIndex].j(this.kRg[this.mCurrentIndex]);
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
    public void tN(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.kRg != null) {
            for (int i = 0; i < this.kRg.length; i++) {
                ImageFileInfo imageFileInfo = this.kRg[i];
                if (imageFileInfo != null) {
                    this.kRg[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!NE()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.kRh != null && this.kRh.cUr() && this.kRn != null && this.kRn.kTB != null) {
                this.kRn.kTB.chc();
                TbImageView tbImageView = this.kRi[this.mCurrentIndex].Ei;
                try {
                    bitmap = this.kRn.kTB.cVT();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.g.bi(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.g.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.kRg[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.kRg[this.mCurrentIndex].clearAllActions();
                        this.kRg[this.mCurrentIndex].clearPageActions();
                        this.kRg[this.mCurrentIndex].setIsGif(false);
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
            if (c(str, bitmap)) {
                this.kRg[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b {
        private TbImageView Ei;
        private int index;
        private FrameLayout kRr;
        private com.baidu.tbadk.img.b kRs;
        private ProgressBar kaT;

        public b(int i) {
            this.kaT = null;
            this.index = -1;
            this.index = i;
            this.kRr = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.kRf.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Ei = (TbImageView) this.kRr.findViewById(R.id.progress_tb_imageview);
            this.Ei.setClickable(true);
            this.Ei.setDefaultResource(0);
            this.Ei.setDefaultErrorResource(0);
            this.Ei.setDefaultBgResource(0);
            this.Ei.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Ei.setPadding(0, 0, 0, 0);
            this.kRs = new com.baidu.tbadk.img.b();
            this.Ei.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.kRh != null) {
                        MultiImagePagerAdapter.this.kRh.cUq();
                    }
                }
            });
            this.kaT = (ProgressBar) this.kRr.findViewById(R.id.progress_tb_imageview_progress);
            this.kaT.setVisibility(8);
        }

        public View getView() {
            return this.kRr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Ei != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.kRf), (l.getEquipmentHeight(MultiImagePagerAdapter.this.kRf) - l.getDimens(MultiImagePagerAdapter.this.kRf, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Ei.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Ei.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Ei);
                if (MultiImagePagerAdapter.this.kRn != null && MultiImagePagerAdapter.this.kRn.kTB != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.kRn.kTB.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.kRn.kTB.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cKO();
                this.kaT.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.kRs.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kaT.setVisibility(8);
                    return;
                }
                this.kRs.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kaT.setVisibility(8);
                        if (MultiImagePagerAdapter.this.kRn != null) {
                            MultiImagePagerAdapter.this.kRn.bdC();
                        }
                    }
                }, false);
            }
        }

        public void cKO() {
            if (this.kRs != null) {
                this.kRs.cancelAllAsyncTask();
            }
            if (this.Ei != null) {
            }
        }

        public boolean cUs() {
            return this.kaT.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

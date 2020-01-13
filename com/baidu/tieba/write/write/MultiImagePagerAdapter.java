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
    private WriteMultiImgsActivity kRa;
    private ImageFileInfo[] kRb;
    private a kRc;
    private b[] kRd;
    private int kRe;
    private LinkedList<ImageFileInfo> kRf = new LinkedList<>();
    private int kRg;
    private int kRh;
    private h kRi;
    private com.baidu.tbadk.core.dialog.a kRj;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public interface a {
        void V(int i, boolean z);

        void cUm();

        void cUo();

        boolean cUp();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.kRa = null;
        this.kRb = null;
        this.mViewPager = null;
        this.kRc = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.kRd = null;
        this.kRg = 120;
        this.kRh = 120;
        this.mIsFromIm = z;
        this.kRa = writeMultiImgsActivity;
        this.kRi = hVar;
        this.kRg = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.kRh = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.kRf.size();
        this.kRb = new ImageFileInfo[this.mCount];
        this.kRd = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.kRb[i2] = this.kRf.get(i2).cloneWithoutFilterAction(true);
            this.kRb[i2].addPageAction(com.baidu.tbadk.img.effect.d.aJ(this.kRg, this.kRh));
            linkedList.set(linkedList.indexOf(this.kRf.get(i2)), this.kRb[i2]);
            this.kRb[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.kRc = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.kRf.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.kRf.add(next);
                }
            }
            return this.kRf.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cUi() {
        return this.mCurrentIndex;
    }

    private boolean NE() {
        return (this.kRd == null || this.mCurrentIndex >= this.kRd.length || this.kRd[this.mCurrentIndex] == null || this.kRb == null || this.mCurrentIndex >= this.kRb.length || this.kRb[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean cUj() {
        if (this.mCurrentIndex >= this.kRb.length || this.kRb[this.mCurrentIndex] == null || !this.kRb[this.mCurrentIndex].isGif() || this.kRb[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.kRb[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cUj()) {
            if (this.kRc != null) {
                this.kRc.V(i, z);
            }
        } else if (z) {
            Em(i);
        } else if (NE() && (bVar = this.kRd[this.mCurrentIndex]) != null && (imageFileInfo = this.kRb[this.mCurrentIndex]) != null && bVar.cUq()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mk(i));
            this.kRa.cVo();
            bVar.j(imageFileInfo);
        }
    }

    private void Em(int i) {
        this.kRe = i;
        if (this.kRj == null) {
            this.kRj = new com.baidu.tbadk.core.dialog.a(this.kRa);
            this.kRj.jF(R.string.rorate_tip);
            this.kRj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRj != null) {
                        MultiImagePagerAdapter.this.kRj.dismiss();
                    }
                    MultiImagePagerAdapter.this.kRi.kTw.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cUl() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cUm() {
                            MultiImagePagerAdapter.this.kRc.cUm();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cUn() {
                        }
                    });
                    MultiImagePagerAdapter.this.U(MultiImagePagerAdapter.this.kRe, false);
                }
            });
            this.kRj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.kRj != null) {
                        MultiImagePagerAdapter.this.kRj.dismiss();
                    }
                }
            });
            this.kRj.b(this.kRa.getPageContext());
        }
        this.kRj.aCp();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kRd[i] == null) {
            this.kRd[i] = new b(i);
        }
        this.mViewPager.addView(this.kRd[i].getView());
        return this.kRd[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.kRd[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        cUk();
    }

    private void cUk() {
        if (this.mCurrentIndex >= 0 && this.kRd != null && this.mCurrentIndex < this.kRd.length && this.mCurrentIndex < this.kRb.length && this.kRb[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.kRd.length; i++) {
                if (this.kRd[i] != null) {
                    this.kRd[i].cKM();
                }
            }
            if (this.kRd[this.mCurrentIndex] == null) {
                this.kRd[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.kRd[this.mCurrentIndex].j(this.kRb[this.mCurrentIndex]);
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
        if (this.kRb != null) {
            for (int i = 0; i < this.kRb.length; i++) {
                ImageFileInfo imageFileInfo = this.kRb[i];
                if (imageFileInfo != null) {
                    this.kRb[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!NE()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.kRc != null && this.kRc.cUp() && this.kRi != null && this.kRi.kTw != null) {
                this.kRi.kTw.chc();
                TbImageView tbImageView = this.kRd[this.mCurrentIndex].Ei;
                try {
                    bitmap = this.kRi.kTw.cVR();
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
                        this.kRb[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.kRb[this.mCurrentIndex].clearAllActions();
                        this.kRb[this.mCurrentIndex].clearPageActions();
                        this.kRb[this.mCurrentIndex].setIsGif(false);
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
                this.kRb[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b {
        private TbImageView Ei;
        private int index;
        private FrameLayout kRm;
        private com.baidu.tbadk.img.b kRn;
        private ProgressBar kaO;

        public b(int i) {
            this.kaO = null;
            this.index = -1;
            this.index = i;
            this.kRm = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.kRa.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Ei = (TbImageView) this.kRm.findViewById(R.id.progress_tb_imageview);
            this.Ei.setClickable(true);
            this.Ei.setDefaultResource(0);
            this.Ei.setDefaultErrorResource(0);
            this.Ei.setDefaultBgResource(0);
            this.Ei.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Ei.setPadding(0, 0, 0, 0);
            this.kRn = new com.baidu.tbadk.img.b();
            this.Ei.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.kRc != null) {
                        MultiImagePagerAdapter.this.kRc.cUo();
                    }
                }
            });
            this.kaO = (ProgressBar) this.kRm.findViewById(R.id.progress_tb_imageview_progress);
            this.kaO.setVisibility(8);
        }

        public View getView() {
            return this.kRm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Ei != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.kRa), (l.getEquipmentHeight(MultiImagePagerAdapter.this.kRa) - l.getDimens(MultiImagePagerAdapter.this.kRa, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Ei.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Ei.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Ei);
                if (MultiImagePagerAdapter.this.kRi != null && MultiImagePagerAdapter.this.kRi.kTw != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.kRi.kTw.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.kRi.kTw.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cKM();
                this.kaO.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.kRn.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kaO.setVisibility(8);
                    return;
                }
                this.kRn.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kaO.setVisibility(8);
                        if (MultiImagePagerAdapter.this.kRi != null) {
                            MultiImagePagerAdapter.this.kRi.bdC();
                        }
                    }
                }, false);
            }
        }

        public void cKM() {
            if (this.kRn != null) {
                this.kRn.cancelAllAsyncTask();
            }
            if (this.Ei != null) {
            }
        }

        public boolean cUq() {
            return this.kaO.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

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
    private WriteMultiImgsActivity mTX;
    private ImageFileInfo[] mTY;
    private a mTZ;
    private b[] mUa;
    private int mUb;
    private LinkedList<ImageFileInfo> mUc = new LinkedList<>();
    private int mUd;
    private int mUe;
    private j mUf;
    private com.baidu.tbadk.core.dialog.a mUg;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void aj(int i, boolean z);

        void dHF();

        void dHH();

        boolean dHI();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.mTX = null;
        this.mTY = null;
        this.mViewPager = null;
        this.mTZ = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.mUa = null;
        this.mUd = 120;
        this.mUe = 120;
        this.mIsFromIm = z;
        this.mTX = writeMultiImgsActivity;
        this.mUf = jVar;
        this.mUd = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.mUe = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.mUc.size();
        this.mTY = new ImageFileInfo[this.mCount];
        this.mUa = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.mTY[i2] = this.mUc.get(i2).cloneWithoutFilterAction(true);
            this.mTY[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.mUd, this.mUe));
            linkedList.set(linkedList.indexOf(this.mUc.get(i2)), this.mTY[i2]);
            this.mTY[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.mTZ = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.mUc.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.mUc.add(next);
                }
            }
            return this.mUc.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dHB() {
        return this.mCurrentIndex;
    }

    private boolean ajo() {
        return (this.mUa == null || this.mCurrentIndex >= this.mUa.length || this.mUa[this.mCurrentIndex] == null || this.mTY == null || this.mCurrentIndex >= this.mTY.length || this.mTY[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dHC() {
        if (this.mCurrentIndex >= this.mTY.length || this.mTY[this.mCurrentIndex] == null || !this.mTY[this.mCurrentIndex].isGif() || this.mTY[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.mTY[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dHC()) {
            if (this.mTZ != null) {
                this.mTZ.aj(i, z);
            }
        } else if (z) {
            JO(i);
        } else if (ajo() && (bVar = this.mUa[this.mCurrentIndex]) != null && (imageFileInfo = this.mTY[this.mCurrentIndex]) != null && bVar.dHJ()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.qr(i));
            this.mTX.dIZ();
            bVar.l(imageFileInfo);
        }
    }

    private void JO(int i) {
        this.mUb = i;
        if (this.mUg == null) {
            this.mUg = new com.baidu.tbadk.core.dialog.a(this.mTX);
            this.mUg.nt(R.string.rorate_tip);
            this.mUg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mUg != null) {
                        MultiImagePagerAdapter.this.mUg.dismiss();
                    }
                    MultiImagePagerAdapter.this.mUf.mWU.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dHE() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dHF() {
                            MultiImagePagerAdapter.this.mTZ.dHF();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean V(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dHG() {
                        }
                    });
                    MultiImagePagerAdapter.this.ai(MultiImagePagerAdapter.this.mUb, false);
                }
            });
            this.mUg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.mUg != null) {
                        MultiImagePagerAdapter.this.mUg.dismiss();
                    }
                }
            });
            this.mUg.b(this.mTX.getPageContext());
        }
        this.mUg.bhg();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mUa[i] == null) {
            this.mUa[i] = new b(i);
        }
        this.mViewPager.addView(this.mUa[i].getView());
        return this.mUa[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.mUa[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dHD();
    }

    private void dHD() {
        if (this.mCurrentIndex >= 0 && this.mUa != null && this.mCurrentIndex < this.mUa.length && this.mCurrentIndex < this.mTY.length && this.mTY[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.mUa.length; i++) {
                if (this.mUa[i] != null) {
                    this.mUa[i].dxZ();
                }
            }
            if (this.mUa[this.mCurrentIndex] == null) {
                this.mUa[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.mUa[this.mCurrentIndex].l(this.mTY[this.mCurrentIndex]);
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
    public void xq(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.mTY != null) {
            for (int i = 0; i < this.mTY.length; i++) {
                ImageFileInfo imageFileInfo = this.mTY[i];
                if (imageFileInfo != null) {
                    this.mTY[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!ajo()) {
                if (!z && this.mIsFromIm) {
                    U(this.mBitmap);
                }
            } else if (this.mTZ != null && this.mTZ.dHI() && this.mUf != null && this.mUf.mWU != null) {
                this.mUf.mWU.cTr();
                TbImageView tbImageView = this.mUa[this.mCurrentIndex].Zn;
                try {
                    bitmap = this.mUf.mWU.dJB();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bt = com.baidu.tbadk.util.g.bt(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bt;
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
                        this.mTY[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.mTY[this.mCurrentIndex].setContentUriStr(null);
                        this.mTY[this.mCurrentIndex].clearAllActions();
                        this.mTY[this.mCurrentIndex].clearPageActions();
                        this.mTY[this.mCurrentIndex].setIsGif(false);
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
                this.mTY[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Zn;
        private int index;
        private FrameLayout mUj;
        private com.baidu.tbadk.img.b mUl;
        private ProgressBar mar;

        public b(int i) {
            this.mar = null;
            this.index = -1;
            this.index = i;
            this.mUj = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.mTX.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Zn = (TbImageView) this.mUj.findViewById(R.id.progress_tb_imageview);
            this.Zn.setClickable(true);
            this.Zn.setDefaultResource(0);
            this.Zn.setDefaultErrorResource(0);
            this.Zn.setDefaultBgResource(0);
            this.Zn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Zn.setPadding(0, 0, 0, 0);
            this.mUl = new com.baidu.tbadk.img.b();
            this.Zn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.mTZ != null) {
                        MultiImagePagerAdapter.this.mTZ.dHH();
                    }
                }
            });
            this.mar = (ProgressBar) this.mUj.findViewById(R.id.progress_tb_imageview_progress);
            this.mar.setVisibility(8);
        }

        public View getView() {
            return this.mUj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Zn != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.mTX), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.mTX) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.mTX, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Zn.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Zn.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Zn);
                if (MultiImagePagerAdapter.this.mUf != null && MultiImagePagerAdapter.this.mUf.mWU != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.mUf.mWU.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.mUf.mWU.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dxZ();
                this.mar.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.mUl.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.mar.setVisibility(8);
                    return;
                }
                this.mUl.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.mar.setVisibility(8);
                        if (MultiImagePagerAdapter.this.mUf != null) {
                            MultiImagePagerAdapter.this.mUf.bKG();
                        }
                    }
                }, false);
            }
        }

        public void dxZ() {
            if (this.mUl != null) {
                this.mUl.cancelAllAsyncTask();
            }
            if (this.Zn != null) {
            }
        }

        public boolean dHJ() {
            return this.mar.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

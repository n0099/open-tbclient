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
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private WriteMultiImgsActivity iab;
    private ImageFileInfo[] iac;
    private a iad;
    private b[] iae;
    private int iaf;
    private int iag;
    private int iah;
    private h iai;
    private com.baidu.tbadk.core.dialog.a iaj;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void J(int i, boolean z);

        void bPL();

        void bPN();

        boolean bPO();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.iab = null;
        this.iac = null;
        this.mViewPager = null;
        this.iad = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.iae = null;
        this.iag = 120;
        this.iah = 120;
        this.mIsFromIm = z;
        this.iab = writeMultiImgsActivity;
        this.iai = hVar;
        this.iag = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds720);
        this.iah = (int) writeMultiImgsActivity.getResources().getDimension(e.C0210e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.iac = new ImageFileInfo[this.mCount];
        this.iae = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.iac[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.iac[i2].addPageAction(com.baidu.tbadk.img.effect.d.L(this.iag, this.iah));
            linkedList.set(i2, this.iac[i2]);
            this.iac[i2].mCount = 0;
        }
        this.mCurrentIndex = i;
        this.mViewPager = viewPager;
        this.iad = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bPH() {
        return (this.iae == null || this.mCurrentIndex >= this.iae.length || this.iae[this.mCurrentIndex] == null || this.iac == null || this.mCurrentIndex >= this.iac.length || this.iac[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean bPI() {
        if (this.mCurrentIndex >= this.iac.length || this.iac[this.mCurrentIndex] == null || !this.iac[this.mCurrentIndex].isGif() || this.iac[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.iac[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bPI()) {
            if (this.iad != null) {
                this.iad.J(i, z);
            }
        } else if (z) {
            xF(i);
        } else if (bPH() && (bVar = this.iae[this.mCurrentIndex]) != null && (imageFileInfo = this.iac[this.mCurrentIndex]) != null && bVar.bPP()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.gc(i));
            this.iab.bQL();
            bVar.h(imageFileInfo);
        }
    }

    private void xF(int i) {
        this.iaf = i;
        if (this.iaj == null) {
            this.iaj = new com.baidu.tbadk.core.dialog.a(this.iab);
            this.iaj.db(e.j.rorate_tip);
            this.iaj.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.iaj != null) {
                        MultiImagePagerAdapter.this.iaj.dismiss();
                    }
                    MultiImagePagerAdapter.this.iai.icw.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bPK() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bPL() {
                            MultiImagePagerAdapter.this.iad.bPL();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean G(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bPM() {
                        }
                    });
                    MultiImagePagerAdapter.this.I(MultiImagePagerAdapter.this.iaf, false);
                }
            });
            this.iaj.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.iaj != null) {
                        MultiImagePagerAdapter.this.iaj.dismiss();
                    }
                }
            });
            this.iaj.b(this.iab.getPageContext());
        }
        this.iaj.BF();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.iae[i] == null) {
            this.iae[i] = new b(i);
        }
        this.mViewPager.addView(this.iae[i].getView());
        return this.iae[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.iae[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        bPJ();
    }

    private void bPJ() {
        if (this.mCurrentIndex >= 0 && this.iae != null && this.mCurrentIndex < this.iae.length && this.mCurrentIndex < this.iac.length && this.iac[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.iae.length; i++) {
                if (this.iae[i] != null) {
                    this.iae[i].aoW();
                }
            }
            if (this.iae[this.mCurrentIndex] == null) {
                this.iae[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.iae[this.mCurrentIndex].h(this.iac[this.mCurrentIndex]);
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

    private boolean e(String str, Bitmap bitmap) {
        try {
            l.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (l.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void oF(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.iac != null) {
            for (int i = 0; i < this.iac.length; i++) {
                ImageFileInfo imageFileInfo = this.iac[i];
                if (imageFileInfo != null) {
                    this.iac[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bPH()) {
                if (!z && this.mIsFromIm) {
                    F(this.mBitmap);
                }
            } else if (this.iad != null && this.iad.bPO() && this.iai != null && this.iai.icw != null) {
                this.iai.icw.bfo();
                TbImageView tbImageView = this.iae[this.mCurrentIndex].fod;
                try {
                    bitmap = this.iai.icw.bRo();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.e.ae(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.e.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.iac[this.mCurrentIndex].setFilePath(l.b(l.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.iac[this.mCurrentIndex].clearAllActions();
                        this.iac[this.mCurrentIndex].clearPageActions();
                        this.iac[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            F(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                F(this.mBitmap);
            }
        }
    }

    private void F(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = NgWebViewInitHelper.INIT_BWEBKIT_APPID + String.valueOf(new Date().getTime()) + ".jpg";
            if (e(str, bitmap)) {
                this.iac[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView fod;
        private ProgressBar hiR;
        private FrameLayout iam;
        private com.baidu.tbadk.img.b ian;
        private int index;

        public b(int i) {
            this.hiR = null;
            this.index = -1;
            this.index = i;
            this.iam = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.iab.getPageContext().getContext()).inflate(e.h.progress_tb_imageview, (ViewGroup) null);
            this.fod = (TbImageView) this.iam.findViewById(e.g.progress_tb_imageview);
            this.fod.setClickable(true);
            this.fod.setDefaultResource(0);
            this.fod.setDefaultErrorResource(0);
            this.fod.setDefaultBgResource(0);
            this.fod.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fod.setPadding(0, 0, 0, 0);
            this.ian = new com.baidu.tbadk.img.b();
            this.fod.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.iad != null) {
                        MultiImagePagerAdapter.this.iad.bPN();
                    }
                }
            });
            this.hiR = (ProgressBar) this.iam.findViewById(e.g.progress_tb_imageview_progress);
            this.hiR.setVisibility(8);
        }

        public View getView() {
            return this.iam;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.fod != null) {
                int[] c = com.baidu.adp.lib.util.l.c(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.aO(MultiImagePagerAdapter.this.iab), (com.baidu.adp.lib.util.l.aQ(MultiImagePagerAdapter.this.iab) - com.baidu.adp.lib.util.l.h(MultiImagePagerAdapter.this.iab, e.C0210e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fod.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.fod.setLayoutParams(layoutParams);
                aVar.a(this.fod);
                if (MultiImagePagerAdapter.this.iai != null && MultiImagePagerAdapter.this.iai.icw != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.iai.icw.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.iai.icw.setLayoutParams(layoutParams2);
                }
                if (aVar.op() != null && !aVar.op().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.op();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aoW();
                this.hiR.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.ian.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.hiR.setVisibility(8);
                    return;
                }
                this.ian.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.hiR.setVisibility(8);
                        if (MultiImagePagerAdapter.this.iai != null) {
                            MultiImagePagerAdapter.this.iai.bPC();
                        }
                    }
                }, false);
            }
        }

        public void aoW() {
            if (this.ian != null) {
                this.ian.NF();
            }
            if (this.fod != null) {
            }
        }

        public boolean bPP() {
            return this.hiR.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

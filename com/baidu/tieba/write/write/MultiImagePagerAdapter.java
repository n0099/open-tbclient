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
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int aOV;
    private WriteMultiImgsActivity hym;
    private ImageFileInfo[] hyn;
    private a hyo;
    private b[] hyp;
    private int hyq;
    private int hyr;
    private int hys;
    private h hyt;
    private com.baidu.tbadk.core.dialog.a hyu;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void I(int i, boolean z);

        void bHn();

        void bHp();

        boolean bHq();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hym = null;
        this.hyn = null;
        this.mViewPager = null;
        this.hyo = null;
        this.mCount = 0;
        this.aOV = 0;
        this.hyp = null;
        this.hyr = 120;
        this.hys = 120;
        this.mIsFromIm = z;
        this.hym = writeMultiImgsActivity;
        this.hyt = hVar;
        this.hyr = (int) writeMultiImgsActivity.getResources().getDimension(f.e.ds720);
        this.hys = (int) writeMultiImgsActivity.getResources().getDimension(f.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hyn = new ImageFileInfo[this.mCount];
        this.hyp = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hyn[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hyn[i2].addPageAction(com.baidu.tbadk.img.effect.d.I(this.hyr, this.hys));
            linkedList.set(i2, this.hyn[i2]);
            this.hyn[i2].mCount = 0;
        }
        this.aOV = i;
        this.mViewPager = viewPager;
        this.hyo = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bHj() {
        return (this.hyp == null || this.aOV >= this.hyp.length || this.hyp[this.aOV] == null || this.hyn == null || this.aOV >= this.hyn.length || this.hyn[this.aOV] == null) ? false : true;
    }

    public boolean bHk() {
        if (this.aOV >= this.hyn.length || this.hyn[this.aOV] == null || !this.hyn[this.aOV].isGif() || this.hyn[this.aOV].mCount > 0) {
            return false;
        }
        this.hyn[this.aOV].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bHk()) {
            if (this.hyo != null) {
                this.hyo.I(i, z);
            }
        } else if (z) {
            vF(i);
        } else if (bHj() && (bVar = this.hyp[this.aOV]) != null && (imageFileInfo = this.hyn[this.aOV]) != null && bVar.bHr()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fe(i));
            this.hym.bIo();
            bVar.h(imageFileInfo);
        }
    }

    private void vF(int i) {
        this.hyq = i;
        if (this.hyu == null) {
            this.hyu = new com.baidu.tbadk.core.dialog.a(this.hym);
            this.hyu.cf(f.j.rorate_tip);
            this.hyu.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hyu != null) {
                        MultiImagePagerAdapter.this.hyu.dismiss();
                    }
                    MultiImagePagerAdapter.this.hyt.hAH.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHm() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHn() {
                            MultiImagePagerAdapter.this.hyo.bHn();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean F(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHo() {
                        }
                    });
                    MultiImagePagerAdapter.this.H(MultiImagePagerAdapter.this.hyq, false);
                }
            });
            this.hyu.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hyu != null) {
                        MultiImagePagerAdapter.this.hyu.dismiss();
                    }
                }
            });
            this.hyu.b(this.hym.getPageContext());
        }
        this.hyu.xe();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hyp[i] == null) {
            this.hyp[i] = new b(i);
        }
        this.mViewPager.addView(this.hyp[i].getView());
        return this.hyp[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hyp[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aOV = i;
        bHl();
    }

    private void bHl() {
        if (this.aOV >= 0 && this.hyp != null && this.aOV < this.hyp.length && this.aOV < this.hyn.length && this.hyn[this.aOV] != null) {
            for (int i = 0; i < this.hyp.length; i++) {
                if (this.hyp[i] != null) {
                    this.hyp[i].ahG();
                }
            }
            if (this.hyp[this.aOV] == null) {
                this.hyp[this.aOV] = new b(this.aOV);
            }
            this.hyp[this.aOV].h(this.hyn[this.aOV]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aOV;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
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
    public void nz(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.hyn != null) {
            for (int i = 0; i < this.hyn.length; i++) {
                ImageFileInfo imageFileInfo = this.hyn[i];
                if (imageFileInfo != null) {
                    this.hyn[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bHj()) {
                if (!z && this.mIsFromIm) {
                    E(this.mBitmap);
                }
            } else if (this.hyo != null && this.hyo.bHq() && this.hyt != null && this.hyt.hAH != null) {
                this.hyt.hAH.aXO();
                TbImageView tbImageView = this.hyp[this.aOV].eNW;
                try {
                    bitmap = this.hyt.hAH.bIR();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.d.S(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.d.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.hyn[this.aOV].setFilePath(l.b(l.yj(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hyn[this.aOV].clearAllActions();
                        this.hyn[this.aOV].clearPageActions();
                        this.hyn[this.aOV].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            E(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                E(this.mBitmap);
            }
        }
    }

    private void E(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.hyn[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView eNW;
        private ProgressBar gIz;
        private FrameLayout hyx;
        private com.baidu.tbadk.img.b hyy;
        private int index;

        public b(int i) {
            this.gIz = null;
            this.index = -1;
            this.index = i;
            this.hyx = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hym.getPageContext().getContext()).inflate(f.h.progress_tb_imageview, (ViewGroup) null);
            this.eNW = (TbImageView) this.hyx.findViewById(f.g.progress_tb_imageview);
            this.eNW.setClickable(true);
            this.eNW.setDefaultResource(0);
            this.eNW.setDefaultErrorResource(0);
            this.eNW.setDefaultBgResource(0);
            this.eNW.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eNW.setPadding(0, 0, 0, 0);
            this.hyy = new com.baidu.tbadk.img.b();
            this.eNW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hyo != null) {
                        MultiImagePagerAdapter.this.hyo.bHp();
                    }
                }
            });
            this.gIz = (ProgressBar) this.hyx.findViewById(f.g.progress_tb_imageview_progress);
            this.gIz.setVisibility(8);
        }

        public View getView() {
            return this.hyx;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.eNW != null) {
                int[] b = com.baidu.adp.lib.util.l.b(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.ah(MultiImagePagerAdapter.this.hym), (com.baidu.adp.lib.util.l.aj(MultiImagePagerAdapter.this.hym) - com.baidu.adp.lib.util.l.f(MultiImagePagerAdapter.this.hym, f.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eNW.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.eNW.setLayoutParams(layoutParams);
                aVar.a(this.eNW);
                if (MultiImagePagerAdapter.this.hyt != null && MultiImagePagerAdapter.this.hyt.hAH != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hyt.hAH.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    MultiImagePagerAdapter.this.hyt.hAH.setLayoutParams(layoutParams2);
                }
                if (aVar.nb() != null && !aVar.nb().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.nb();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                ahG();
                this.gIz.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hyy.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gIz.setVisibility(8);
                    return;
                }
                this.hyy.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gIz.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hyt != null) {
                            MultiImagePagerAdapter.this.hyt.bHe();
                        }
                    }
                }, false);
            }
        }

        public void ahG() {
            if (this.hyy != null) {
                this.hyy.Ja();
            }
            if (this.eNW != null) {
            }
        }

        public boolean bHr() {
            return this.gIz.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

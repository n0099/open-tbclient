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
import com.baidu.tieba.d;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int aOY;
    private WriteMultiImgsActivity hyk;
    private ImageFileInfo[] hyl;
    private a hym;
    private b[] hyn;
    private int hyo;
    private int hyp;
    private int hyq;
    private h hyr;
    private com.baidu.tbadk.core.dialog.a hys;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void I(int i, boolean z);

        void bHj();

        void bHl();

        boolean bHm();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.hyk = null;
        this.hyl = null;
        this.mViewPager = null;
        this.hym = null;
        this.mCount = 0;
        this.aOY = 0;
        this.hyn = null;
        this.hyp = 120;
        this.hyq = 120;
        this.mIsFromIm = z;
        this.hyk = writeMultiImgsActivity;
        this.hyr = hVar;
        this.hyp = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hyq = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hyl = new ImageFileInfo[this.mCount];
        this.hyn = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.hyl[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hyl[i2].addPageAction(com.baidu.tbadk.img.effect.d.I(this.hyp, this.hyq));
            linkedList.set(i2, this.hyl[i2]);
            this.hyl[i2].mCount = 0;
        }
        this.aOY = i;
        this.mViewPager = viewPager;
        this.hym = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private boolean bHf() {
        return (this.hyn == null || this.aOY >= this.hyn.length || this.hyn[this.aOY] == null || this.hyl == null || this.aOY >= this.hyl.length || this.hyl[this.aOY] == null) ? false : true;
    }

    public boolean bHg() {
        if (this.aOY >= this.hyl.length || this.hyl[this.aOY] == null || !this.hyl[this.aOY].isGif() || this.hyl[this.aOY].mCount > 0) {
            return false;
        }
        this.hyl[this.aOY].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (bHg()) {
            if (this.hym != null) {
                this.hym.I(i, z);
            }
        } else if (z) {
            vF(i);
        } else if (bHf() && (bVar = this.hyn[this.aOY]) != null && (imageFileInfo = this.hyl[this.aOY]) != null && bVar.bHn()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.ff(i));
            this.hyk.bIk();
            bVar.h(imageFileInfo);
        }
    }

    private void vF(int i) {
        this.hyo = i;
        if (this.hys == null) {
            this.hys = new com.baidu.tbadk.core.dialog.a(this.hyk);
            this.hys.cf(d.j.rorate_tip);
            this.hys.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hys != null) {
                        MultiImagePagerAdapter.this.hys.dismiss();
                    }
                    MultiImagePagerAdapter.this.hyr.hAF.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHi() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHj() {
                            MultiImagePagerAdapter.this.hym.bHj();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean F(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHk() {
                        }
                    });
                    MultiImagePagerAdapter.this.H(MultiImagePagerAdapter.this.hyo, false);
                }
            });
            this.hys.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.hys != null) {
                        MultiImagePagerAdapter.this.hys.dismiss();
                    }
                }
            });
            this.hys.b(this.hyk.getPageContext());
        }
        this.hys.xf();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hyn[i] == null) {
            this.hyn[i] = new b(i);
        }
        this.mViewPager.addView(this.hyn[i].getView());
        return this.hyn[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.hyn[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aOY = i;
        bHh();
    }

    private void bHh() {
        if (this.aOY >= 0 && this.hyn != null && this.aOY < this.hyn.length && this.aOY < this.hyl.length && this.hyl[this.aOY] != null) {
            for (int i = 0; i < this.hyn.length; i++) {
                if (this.hyn[i] != null) {
                    this.hyn[i].ahE();
                }
            }
            if (this.hyn[this.aOY] == null) {
                this.hyn[this.aOY] = new b(this.aOY);
            }
            this.hyn[this.aOY].h(this.hyl[this.aOY]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aOY;
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
        if (this.hyl != null) {
            for (int i = 0; i < this.hyl.length; i++) {
                ImageFileInfo imageFileInfo = this.hyl[i];
                if (imageFileInfo != null) {
                    this.hyl[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!bHf()) {
                if (!z && this.mIsFromIm) {
                    E(this.mBitmap);
                }
            } else if (this.hym != null && this.hym.bHm() && this.hyr != null && this.hyr.hAF != null) {
                this.hyr.hAF.aXT();
                TbImageView tbImageView = this.hyn[this.aOY].eOb;
                try {
                    bitmap = this.hyr.hAF.bIN();
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
                        this.hyl[this.aOY].setFilePath(l.b(l.yk(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hyl[this.aOY].clearAllActions();
                        this.hyl[this.aOY].clearPageActions();
                        this.hyl[this.aOY].setIsGif(false);
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
                this.hyl[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView eOb;
        private ProgressBar gIw;
        private FrameLayout hyv;
        private com.baidu.tbadk.img.b hyw;
        private int index;

        public b(int i) {
            this.gIw = null;
            this.index = -1;
            this.index = i;
            this.hyv = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.hyk.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.eOb = (TbImageView) this.hyv.findViewById(d.g.progress_tb_imageview);
            this.eOb.setClickable(true);
            this.eOb.setDefaultResource(0);
            this.eOb.setDefaultErrorResource(0);
            this.eOb.setDefaultBgResource(0);
            this.eOb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eOb.setPadding(0, 0, 0, 0);
            this.hyw = new com.baidu.tbadk.img.b();
            this.eOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.hym != null) {
                        MultiImagePagerAdapter.this.hym.bHl();
                    }
                }
            });
            this.gIw = (ProgressBar) this.hyv.findViewById(d.g.progress_tb_imageview_progress);
            this.gIw.setVisibility(8);
        }

        public View getView() {
            return this.hyv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.eOb != null) {
                int[] b = com.baidu.adp.lib.util.l.b(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.ah(MultiImagePagerAdapter.this.hyk), (com.baidu.adp.lib.util.l.aj(MultiImagePagerAdapter.this.hyk) - com.baidu.adp.lib.util.l.f(MultiImagePagerAdapter.this.hyk, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eOb.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.eOb.setLayoutParams(layoutParams);
                aVar.a(this.eOb);
                if (MultiImagePagerAdapter.this.hyr != null && MultiImagePagerAdapter.this.hyr.hAF != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.hyr.hAF.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    MultiImagePagerAdapter.this.hyr.hAF.setLayoutParams(layoutParams2);
                }
                if (aVar.nb() != null && !aVar.nb().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.nb();
                }
            }
        }

        public void h(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                ahE();
                this.gIw.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.hyw.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.gIw.setVisibility(8);
                    return;
                }
                this.hyw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.gIw.setVisibility(8);
                        if (MultiImagePagerAdapter.this.hyr != null) {
                            MultiImagePagerAdapter.this.hyr.bHa();
                        }
                    }
                }, false);
            }
        }

        public void ahE() {
            if (this.hyw != null) {
                this.hyw.Ja();
            }
            if (this.eOb != null) {
            }
        }

        public boolean bHn() {
            return this.gIw.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

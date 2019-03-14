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
import com.baidu.tieba.d;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int biS;
    private WriteMultiImgsActivity jse;
    private ImageFileInfo[] jsf;
    private a jsg;
    private b[] jsh;
    private int jsi;
    private LinkedList<ImageFileInfo> jsj = new LinkedList<>();
    private int jsk;
    private int jsl;
    private h jsm;
    private com.baidu.tbadk.core.dialog.a jsn;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void P(int i, boolean z);

        void cqq();

        void cqs();

        boolean cqt();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jse = null;
        this.jsf = null;
        this.mViewPager = null;
        this.jsg = null;
        this.mCount = 0;
        this.biS = 0;
        this.jsh = null;
        this.jsk = 120;
        this.jsl = 120;
        this.mIsFromIm = z;
        this.jse = writeMultiImgsActivity;
        this.jsm = hVar;
        this.jsk = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.jsl = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        this.biS = e(linkedList, i);
        this.mCount = this.jsj.size();
        this.jsf = new ImageFileInfo[this.mCount];
        this.jsh = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jsf[i2] = this.jsj.get(i2).cloneWithoutFilterAction(true);
            this.jsf[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jsk, this.jsl));
            linkedList.set(linkedList.indexOf(this.jsj.get(i2)), this.jsf[i2]);
            this.jsf[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jsg = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jsj.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jsj.add(next);
                }
            }
            return this.jsj.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cqm() {
        return this.biS;
    }

    private boolean RK() {
        return (this.jsh == null || this.biS >= this.jsh.length || this.jsh[this.biS] == null || this.jsf == null || this.biS >= this.jsf.length || this.jsf[this.biS] == null) ? false : true;
    }

    public boolean cqn() {
        if (this.biS >= this.jsf.length || this.jsf[this.biS] == null || !this.jsf[this.biS].isGif() || this.jsf[this.biS].mCount > 0) {
            return false;
        }
        this.jsf[this.biS].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cqn()) {
            if (this.jsg != null) {
                this.jsg.P(i, z);
            }
        } else if (z) {
            Bx(i);
        } else if (RK() && (bVar = this.jsh[this.biS]) != null && (imageFileInfo = this.jsf[this.biS]) != null && bVar.cqu()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.jN(i));
            this.jse.crp();
            bVar.i(imageFileInfo);
        }
    }

    private void Bx(int i) {
        this.jsi = i;
        if (this.jsn == null) {
            this.jsn = new com.baidu.tbadk.core.dialog.a(this.jse);
            this.jsn.gD(d.j.rorate_tip);
            this.jsn.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsn != null) {
                        MultiImagePagerAdapter.this.jsn.dismiss();
                    }
                    MultiImagePagerAdapter.this.jsm.juB.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqp() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqq() {
                            MultiImagePagerAdapter.this.jsg.cqq();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean O(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqr() {
                        }
                    });
                    MultiImagePagerAdapter.this.O(MultiImagePagerAdapter.this.jsi, false);
                }
            });
            this.jsn.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsn != null) {
                        MultiImagePagerAdapter.this.jsn.dismiss();
                    }
                }
            });
            this.jsn.b(this.jse.getPageContext());
        }
        this.jsn.aaZ();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jsh[i] == null) {
            this.jsh[i] = new b(i);
        }
        this.mViewPager.addView(this.jsh[i].getView());
        return this.jsh[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jsh[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.biS = i;
        cqo();
    }

    private void cqo() {
        if (this.biS >= 0 && this.jsh != null && this.biS < this.jsh.length && this.biS < this.jsf.length && this.jsf[this.biS] != null) {
            for (int i = 0; i < this.jsh.length; i++) {
                if (this.jsh[i] != null) {
                    this.jsh[i].aPS();
                }
            }
            if (this.jsh[this.biS] == null) {
                this.jsh[this.biS] = new b(this.biS);
            }
            this.jsh[this.biS].i(this.jsf[this.biS]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.biS;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean f(String str, Bitmap bitmap) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void rg(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jsf != null) {
            for (int i = 0; i < this.jsf.length; i++) {
                ImageFileInfo imageFileInfo = this.jsf[i];
                if (imageFileInfo != null) {
                    this.jsf[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!RK()) {
                if (!z && this.mIsFromIm) {
                    N(this.mBitmap);
                }
            } else if (this.jsg != null && this.jsg.cqt() && this.jsm != null && this.jsm.juB != null) {
                this.jsm.juB.bGr();
                TbImageView tbImageView = this.jsh[this.biS].Uz;
                try {
                    bitmap = this.jsm.juB.crS();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.f.aZ(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.f.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.jsf[this.biS].setFilePath(m.b(m.acg(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jsf[this.biS].clearAllActions();
                        this.jsf[this.biS].clearPageActions();
                        this.jsf[this.biS].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            N(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                N(this.mBitmap);
            }
        }
    }

    private void N(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (f(str, bitmap)) {
                this.jsf[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Uz;
        private ProgressBar iBE;
        private int index;
        private FrameLayout jsq;
        private com.baidu.tbadk.img.b jsr;

        public b(int i) {
            this.iBE = null;
            this.index = -1;
            this.index = i;
            this.jsq = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jse.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.Uz = (TbImageView) this.jsq.findViewById(d.g.progress_tb_imageview);
            this.Uz.setClickable(true);
            this.Uz.setDefaultResource(0);
            this.Uz.setDefaultErrorResource(0);
            this.Uz.setDefaultBgResource(0);
            this.Uz.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Uz.setPadding(0, 0, 0, 0);
            this.jsr = new com.baidu.tbadk.img.b();
            this.Uz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jsg != null) {
                        MultiImagePagerAdapter.this.jsg.cqs();
                    }
                }
            });
            this.iBE = (ProgressBar) this.jsq.findViewById(d.g.progress_tb_imageview_progress);
            this.iBE.setVisibility(8);
        }

        public View getView() {
            return this.jsq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Uz != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.aO(MultiImagePagerAdapter.this.jse), (l.aQ(MultiImagePagerAdapter.this.jse) - l.h(MultiImagePagerAdapter.this.jse, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Uz.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.Uz.setLayoutParams(layoutParams);
                aVar.a(this.Uz);
                if (MultiImagePagerAdapter.this.jsm != null && MultiImagePagerAdapter.this.jsm.juB != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jsm.juB.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.jsm.juB.setLayoutParams(layoutParams2);
                }
                if (aVar.oy() != null && !aVar.oy().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.oy();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aPS();
                this.iBE.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jsr.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iBE.setVisibility(8);
                    return;
                }
                this.jsr.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iBE.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jsm != null) {
                            MultiImagePagerAdapter.this.jsm.cqh();
                        }
                    }
                }, false);
            }
        }

        public void aPS() {
            if (this.jsr != null) {
                this.jsr.anz();
            }
            if (this.Uz != null) {
            }
        }

        public boolean cqu() {
            return this.iBE.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

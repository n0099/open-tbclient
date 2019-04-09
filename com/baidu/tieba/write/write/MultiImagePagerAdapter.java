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
    private int biW;
    private WriteMultiImgsActivity jrV;
    private ImageFileInfo[] jrW;
    private a jrX;
    private b[] jrY;
    private int jrZ;
    private LinkedList<ImageFileInfo> jsa = new LinkedList<>();
    private int jsb;
    private int jsc;
    private h jsd;
    private com.baidu.tbadk.core.dialog.a jse;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void P(int i, boolean z);

        void cqo();

        void cqq();

        boolean cqr();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jrV = null;
        this.jrW = null;
        this.mViewPager = null;
        this.jrX = null;
        this.mCount = 0;
        this.biW = 0;
        this.jrY = null;
        this.jsb = 120;
        this.jsc = 120;
        this.mIsFromIm = z;
        this.jrV = writeMultiImgsActivity;
        this.jsd = hVar;
        this.jsb = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.jsc = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        this.biW = e(linkedList, i);
        this.mCount = this.jsa.size();
        this.jrW = new ImageFileInfo[this.mCount];
        this.jrY = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jrW[i2] = this.jsa.get(i2).cloneWithoutFilterAction(true);
            this.jrW[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jsb, this.jsc));
            linkedList.set(linkedList.indexOf(this.jsa.get(i2)), this.jrW[i2]);
            this.jrW[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jrX = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jsa.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jsa.add(next);
                }
            }
            return this.jsa.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cqk() {
        return this.biW;
    }

    private boolean RI() {
        return (this.jrY == null || this.biW >= this.jrY.length || this.jrY[this.biW] == null || this.jrW == null || this.biW >= this.jrW.length || this.jrW[this.biW] == null) ? false : true;
    }

    public boolean cql() {
        if (this.biW >= this.jrW.length || this.jrW[this.biW] == null || !this.jrW[this.biW].isGif() || this.jrW[this.biW].mCount > 0) {
            return false;
        }
        this.jrW[this.biW].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cql()) {
            if (this.jrX != null) {
                this.jrX.P(i, z);
            }
        } else if (z) {
            Bt(i);
        } else if (RI() && (bVar = this.jrY[this.biW]) != null && (imageFileInfo = this.jrW[this.biW]) != null && bVar.cqs()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.jM(i));
            this.jrV.crn();
            bVar.i(imageFileInfo);
        }
    }

    private void Bt(int i) {
        this.jrZ = i;
        if (this.jse == null) {
            this.jse = new com.baidu.tbadk.core.dialog.a(this.jrV);
            this.jse.gC(d.j.rorate_tip);
            this.jse.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jse != null) {
                        MultiImagePagerAdapter.this.jse.dismiss();
                    }
                    MultiImagePagerAdapter.this.jsd.jus.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqn() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqo() {
                            MultiImagePagerAdapter.this.jrX.cqo();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean O(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqp() {
                        }
                    });
                    MultiImagePagerAdapter.this.O(MultiImagePagerAdapter.this.jrZ, false);
                }
            });
            this.jse.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jse != null) {
                        MultiImagePagerAdapter.this.jse.dismiss();
                    }
                }
            });
            this.jse.b(this.jrV.getPageContext());
        }
        this.jse.aaW();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jrY[i] == null) {
            this.jrY[i] = new b(i);
        }
        this.mViewPager.addView(this.jrY[i].getView());
        return this.jrY[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jrY[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.biW = i;
        cqm();
    }

    private void cqm() {
        if (this.biW >= 0 && this.jrY != null && this.biW < this.jrY.length && this.biW < this.jrW.length && this.jrW[this.biW] != null) {
            for (int i = 0; i < this.jrY.length; i++) {
                if (this.jrY[i] != null) {
                    this.jrY[i].aPQ();
                }
            }
            if (this.jrY[this.biW] == null) {
                this.jrY[this.biW] = new b(this.biW);
            }
            this.jrY[this.biW].i(this.jrW[this.biW]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.biW;
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
        if (this.jrW != null) {
            for (int i = 0; i < this.jrW.length; i++) {
                ImageFileInfo imageFileInfo = this.jrW[i];
                if (imageFileInfo != null) {
                    this.jrW[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!RI()) {
                if (!z && this.mIsFromIm) {
                    N(this.mBitmap);
                }
            } else if (this.jrX != null && this.jrX.cqr() && this.jsd != null && this.jsd.jus != null) {
                this.jsd.jus.bGo();
                TbImageView tbImageView = this.jrY[this.biW].UB;
                try {
                    bitmap = this.jsd.jus.crQ();
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
                        this.jrW[this.biW].setFilePath(m.b(m.acd(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jrW[this.biW].clearAllActions();
                        this.jrW[this.biW].clearPageActions();
                        this.jrW[this.biW].setIsGif(false);
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
                this.jrW[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView UB;
        private ProgressBar iBp;
        private int index;
        private FrameLayout jsh;
        private com.baidu.tbadk.img.b jsi;

        public b(int i) {
            this.iBp = null;
            this.index = -1;
            this.index = i;
            this.jsh = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jrV.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.UB = (TbImageView) this.jsh.findViewById(d.g.progress_tb_imageview);
            this.UB.setClickable(true);
            this.UB.setDefaultResource(0);
            this.UB.setDefaultErrorResource(0);
            this.UB.setDefaultBgResource(0);
            this.UB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.UB.setPadding(0, 0, 0, 0);
            this.jsi = new com.baidu.tbadk.img.b();
            this.UB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jrX != null) {
                        MultiImagePagerAdapter.this.jrX.cqq();
                    }
                }
            });
            this.iBp = (ProgressBar) this.jsh.findViewById(d.g.progress_tb_imageview_progress);
            this.iBp.setVisibility(8);
        }

        public View getView() {
            return this.jsh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.UB != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.aO(MultiImagePagerAdapter.this.jrV), (l.aQ(MultiImagePagerAdapter.this.jrV) - l.h(MultiImagePagerAdapter.this.jrV, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.UB.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.UB.setLayoutParams(layoutParams);
                aVar.a(this.UB);
                if (MultiImagePagerAdapter.this.jsd != null && MultiImagePagerAdapter.this.jsd.jus != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jsd.jus.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.jsd.jus.setLayoutParams(layoutParams2);
                }
                if (aVar.oy() != null && !aVar.oy().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.oy();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aPQ();
                this.iBp.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jsi.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iBp.setVisibility(8);
                    return;
                }
                this.jsi.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iBp.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jsd != null) {
                            MultiImagePagerAdapter.this.jsd.cqf();
                        }
                    }
                }, false);
            }
        }

        public void aPQ() {
            if (this.jsi != null) {
                this.jsi.anw();
            }
            if (this.UB != null) {
            }
        }

        public boolean cqs() {
            return this.iBp.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

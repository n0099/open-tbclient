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
    private int biV;
    private WriteMultiImgsActivity jrU;
    private ImageFileInfo[] jrV;
    private a jrW;
    private b[] jrX;
    private int jrY;
    private LinkedList<ImageFileInfo> jrZ = new LinkedList<>();
    private int jsa;
    private int jsb;
    private h jsc;
    private com.baidu.tbadk.core.dialog.a jsd;
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
        this.jrU = null;
        this.jrV = null;
        this.mViewPager = null;
        this.jrW = null;
        this.mCount = 0;
        this.biV = 0;
        this.jrX = null;
        this.jsa = 120;
        this.jsb = 120;
        this.mIsFromIm = z;
        this.jrU = writeMultiImgsActivity;
        this.jsc = hVar;
        this.jsa = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.jsb = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        this.biV = e(linkedList, i);
        this.mCount = this.jrZ.size();
        this.jrV = new ImageFileInfo[this.mCount];
        this.jrX = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jrV[i2] = this.jrZ.get(i2).cloneWithoutFilterAction(true);
            this.jrV[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jsa, this.jsb));
            linkedList.set(linkedList.indexOf(this.jrZ.get(i2)), this.jrV[i2]);
            this.jrV[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jrW = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jrZ.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jrZ.add(next);
                }
            }
            return this.jrZ.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cqk() {
        return this.biV;
    }

    private boolean RI() {
        return (this.jrX == null || this.biV >= this.jrX.length || this.jrX[this.biV] == null || this.jrV == null || this.biV >= this.jrV.length || this.jrV[this.biV] == null) ? false : true;
    }

    public boolean cql() {
        if (this.biV >= this.jrV.length || this.jrV[this.biV] == null || !this.jrV[this.biV].isGif() || this.jrV[this.biV].mCount > 0) {
            return false;
        }
        this.jrV[this.biV].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cql()) {
            if (this.jrW != null) {
                this.jrW.P(i, z);
            }
        } else if (z) {
            Bt(i);
        } else if (RI() && (bVar = this.jrX[this.biV]) != null && (imageFileInfo = this.jrV[this.biV]) != null && bVar.cqs()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.jM(i));
            this.jrU.crn();
            bVar.i(imageFileInfo);
        }
    }

    private void Bt(int i) {
        this.jrY = i;
        if (this.jsd == null) {
            this.jsd = new com.baidu.tbadk.core.dialog.a(this.jrU);
            this.jsd.gC(d.j.rorate_tip);
            this.jsd.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsd != null) {
                        MultiImagePagerAdapter.this.jsd.dismiss();
                    }
                    MultiImagePagerAdapter.this.jsc.jur.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqn() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqo() {
                            MultiImagePagerAdapter.this.jrW.cqo();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean O(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cqp() {
                        }
                    });
                    MultiImagePagerAdapter.this.O(MultiImagePagerAdapter.this.jrY, false);
                }
            });
            this.jsd.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jsd != null) {
                        MultiImagePagerAdapter.this.jsd.dismiss();
                    }
                }
            });
            this.jsd.b(this.jrU.getPageContext());
        }
        this.jsd.aaW();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jrX[i] == null) {
            this.jrX[i] = new b(i);
        }
        this.mViewPager.addView(this.jrX[i].getView());
        return this.jrX[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jrX[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.biV = i;
        cqm();
    }

    private void cqm() {
        if (this.biV >= 0 && this.jrX != null && this.biV < this.jrX.length && this.biV < this.jrV.length && this.jrV[this.biV] != null) {
            for (int i = 0; i < this.jrX.length; i++) {
                if (this.jrX[i] != null) {
                    this.jrX[i].aPQ();
                }
            }
            if (this.jrX[this.biV] == null) {
                this.jrX[this.biV] = new b(this.biV);
            }
            this.jrX[this.biV].i(this.jrV[this.biV]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.biV;
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
        if (this.jrV != null) {
            for (int i = 0; i < this.jrV.length; i++) {
                ImageFileInfo imageFileInfo = this.jrV[i];
                if (imageFileInfo != null) {
                    this.jrV[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!RI()) {
                if (!z && this.mIsFromIm) {
                    N(this.mBitmap);
                }
            } else if (this.jrW != null && this.jrW.cqr() && this.jsc != null && this.jsc.jur != null) {
                this.jsc.jur.bGo();
                TbImageView tbImageView = this.jrX[this.biV].Uz;
                try {
                    bitmap = this.jsc.jur.crQ();
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
                        this.jrV[this.biV].setFilePath(m.b(m.acd(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jrV[this.biV].clearAllActions();
                        this.jrV[this.biV].clearPageActions();
                        this.jrV[this.biV].setIsGif(false);
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
                this.jrV[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Uz;
        private ProgressBar iBo;
        private int index;
        private FrameLayout jsg;
        private com.baidu.tbadk.img.b jsh;

        public b(int i) {
            this.iBo = null;
            this.index = -1;
            this.index = i;
            this.jsg = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jrU.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.Uz = (TbImageView) this.jsg.findViewById(d.g.progress_tb_imageview);
            this.Uz.setClickable(true);
            this.Uz.setDefaultResource(0);
            this.Uz.setDefaultErrorResource(0);
            this.Uz.setDefaultBgResource(0);
            this.Uz.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Uz.setPadding(0, 0, 0, 0);
            this.jsh = new com.baidu.tbadk.img.b();
            this.Uz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jrW != null) {
                        MultiImagePagerAdapter.this.jrW.cqq();
                    }
                }
            });
            this.iBo = (ProgressBar) this.jsg.findViewById(d.g.progress_tb_imageview_progress);
            this.iBo.setVisibility(8);
        }

        public View getView() {
            return this.jsg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Uz != null) {
                int[] c = l.c(aVar.getWidth(), aVar.getHeight(), l.aO(MultiImagePagerAdapter.this.jrU), (l.aQ(MultiImagePagerAdapter.this.jrU) - l.h(MultiImagePagerAdapter.this.jrU, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Uz.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = c[0];
                layoutParams.height = c[1];
                this.Uz.setLayoutParams(layoutParams);
                aVar.a(this.Uz);
                if (MultiImagePagerAdapter.this.jsc != null && MultiImagePagerAdapter.this.jsc.jur != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jsc.jur.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = c[0];
                    layoutParams2.height = c[1];
                    MultiImagePagerAdapter.this.jsc.jur.setLayoutParams(layoutParams2);
                }
                if (aVar.oy() != null && !aVar.oy().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.oy();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aPQ();
                this.iBo.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jsh.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iBo.setVisibility(8);
                    return;
                }
                this.jsh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iBo.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jsc != null) {
                            MultiImagePagerAdapter.this.jsc.cqf();
                        }
                    }
                }, false);
            }
        }

        public void aPQ() {
            if (this.jsh != null) {
                this.jsh.anw();
            }
            if (this.Uz != null) {
            }
        }

        public boolean cqs() {
            return this.iBo.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

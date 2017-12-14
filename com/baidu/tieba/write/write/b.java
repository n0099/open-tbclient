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
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0066a {
    private int aES;
    private ViewPager aEy;
    private WriteMultiImgsActivity hkr;
    private ImageFileInfo[] hks;
    private a hkt;
    private C0165b[] hku;
    private com.baidu.tbadk.coreExtra.view.a[] hkv;
    private int hkw;
    private int hkx;
    private g hky;
    private com.baidu.tbadk.core.dialog.a hkz;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;

    /* loaded from: classes2.dex */
    public interface a {
        void J(int i, boolean z);

        void bHZ();

        void bIb();

        void bIc();

        void bId();

        boolean bIe();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hkr = null;
        this.hks = null;
        this.aEy = null;
        this.hkt = null;
        this.mCount = 0;
        this.aES = 0;
        this.hku = null;
        this.hkv = null;
        this.hkw = 120;
        this.hkx = 120;
        this.mIsFromIm = z;
        this.hkr = writeMultiImgsActivity;
        this.hky = gVar;
        this.hkw = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hkx = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hks = new ImageFileInfo[this.mCount];
        this.hku = new C0165b[this.mCount];
        this.hkv = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hks[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hks[i2].addPageAction(com.baidu.tbadk.img.effect.d.J(this.hkw, this.hkx));
            linkedList.set(i2, this.hks[i2]);
            this.hks[i2].mCount = 0;
        }
        this.aES = i;
        this.aEy = viewPager;
        this.hkt = aVar;
        this.aEy.setOffscreenPageLimit(1);
        this.aEy.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hku == null || this.aES >= this.hku.length || this.hku[this.aES] == null || this.hks == null || this.aES >= this.hks.length || this.hks[this.aES] == null) ? false : true;
    }

    public boolean bHW() {
        if (this.aES >= this.hks.length || this.hks[this.aES] == null || !this.hks[this.aES].isGif() || this.hks[this.aES].mCount > 0) {
            return false;
        }
        this.hks[this.aES].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        if (bHW()) {
            if (this.hkt != null) {
                this.hkt.J(i, z);
            }
        } else if (z) {
            wr(i);
        } else if (checkValid()) {
            C0165b c0165b = this.hku[this.aES];
            ImageFileInfo imageFileInfo = this.hks[this.aES];
            if (c0165b.bIf()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fh(i));
                this.hkr.bIU();
                if (i == 0 || i == 1) {
                    imageFileInfo.setRotateType(imageFileInfo.getRotateType() + 1);
                }
                if (this.hkv[this.aES] != null && this.aES < this.hkv.length) {
                    String selectedFilter = this.hkv[this.aES].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gx(selectedFilter));
                        c0165b.i(cloneWithoutFilterAction);
                        return;
                    }
                    c0165b.i(imageFileInfo);
                    return;
                }
                c0165b.i(imageFileInfo);
            }
        }
    }

    private void wr(final int i) {
        if (this.hkz == null) {
            this.hkz = new com.baidu.tbadk.core.dialog.a(this.hkr);
            this.hkz.cd(d.j.rorate_tip);
            this.hkz.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hkz != null) {
                        b.this.hkz.dismiss();
                    }
                    b.this.hky.hmF.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHY() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHZ() {
                            b.this.hkt.bHZ();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean A(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIa() {
                        }
                    });
                    b.this.I(i, false);
                }
            });
            this.hkz.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hkz != null) {
                        b.this.hkz.dismiss();
                    }
                }
            });
            this.hkz.b(this.hkr.getPageContext());
        }
        this.hkz.th();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0066a
    public void fk(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hkr.bIU();
                ImageFileInfo cloneWithoutFilterAction = this.hks[this.aES].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gx(str));
                this.hku[this.aES].i(cloneWithoutFilterAction);
                return;
            }
            this.hkr.bIV();
            this.hku[this.aES].i(this.hks[this.aES]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hku[i] == null) {
            this.hku[i] = new C0165b(i);
        }
        this.aEy.addView(this.hku[i].getView());
        return this.hku[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aEy.removeView(this.hku[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aES = i;
        bHX();
    }

    private void bHX() {
        if (this.aES >= 0 && this.aES < this.hku.length && this.aES < this.hks.length && this.hks[this.aES] != null) {
            if (this.hku != null) {
                for (int i = 0; i < this.hku.length; i++) {
                    if (this.hku[i] != null) {
                        this.hku[i].aay();
                    }
                }
                if (this.hku[this.aES] == null) {
                    this.hku[this.aES] = new C0165b(this.aES);
                }
            }
            String selectedFilter = this.hkv[this.aES].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hks[this.aES].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gx(selectedFilter));
                    if (this.hku != null) {
                        this.hku[this.aES].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hku != null) {
                this.hku[this.aES].i(this.hks[this.aES]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aES;
    }

    private void a(ImageFileInfo imageFileInfo, int i) {
        String str;
        if (imageFileInfo.getPersistActionsList() != null) {
            Iterator<ImageOperation> it = imageFileInfo.getPersistActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if ("filter".equals(next.actionName)) {
                    str = next.actionParam;
                    break;
                }
            }
        }
        str = null;
        this.hkv[i] = new com.baidu.tbadk.coreExtra.view.a(this.hkr, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            k.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (k.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void of(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        String selectedFilter;
        Bitmap bitmap3 = null;
        if (this.hks != null) {
            for (int i = 0; i < this.hks.length; i++) {
                ImageFileInfo imageFileInfo = this.hks[i];
                if (imageFileInfo != null) {
                    this.hks[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hkv[i] != null && (selectedFilter = this.hkv[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hks[i].addPersistAction(com.baidu.tbadk.img.effect.a.gx(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    z(this.mBitmap);
                }
            } else if (this.hkt != null && this.hkt.bIe() && this.hky != null && this.hky.hmF != null) {
                this.hky.hmF.aPX();
                TbImageView tbImageView = this.hku[this.aES].aWC;
                try {
                    bitmap2 = this.hky.hmF.btZ();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap2 != null) {
                    try {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                        if (this.hks[this.aES].getRotateType() % 2 == 0) {
                            layoutParams.width = bitmap2.getWidth();
                            layoutParams.height = bitmap2.getHeight();
                        } else {
                            layoutParams.width = bitmap2.getHeight();
                            layoutParams.height = bitmap2.getWidth();
                        }
                        tbImageView.setLayoutParams(layoutParams);
                        bitmap3 = com.baidu.tbadk.util.d.S(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        bitmap = bitmap2;
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = bitmap;
                        if (bitmap2 == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap2 == null && bitmap3 != null && (a2 = com.baidu.tbadk.util.d.a(bitmap3, bitmap2, bitmap3.getWidth(), bitmap3.getHeight())) != null) {
                        this.hks[this.aES].setFilePath(k.b(k.uj(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hks[this.aES].clearAllActions();
                        this.hks[this.aES].clearPageActions();
                        this.hks[this.aES].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            z(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                z(this.mBitmap);
            }
        }
    }

    private void z(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.hks[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0165b {
        private TbImageView aWC;
        private ProgressBar fFK;
        private FrameLayout hkC;
        private com.baidu.tbadk.img.b hkD;
        private int index;

        public C0165b(int i) {
            this.fFK = null;
            this.index = -1;
            this.index = i;
            this.hkC = (FrameLayout) LayoutInflater.from(b.this.hkr.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.aWC = (TbImageView) this.hkC.findViewById(d.g.progress_tb_imageview);
            this.aWC.setClickable(true);
            this.aWC.setDefaultResource(0);
            this.aWC.setDefaultErrorResource(0);
            this.aWC.setDefaultBgResource(0);
            this.aWC.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aWC.setPadding(0, 0, 0, 0);
            this.hkD = new com.baidu.tbadk.img.b();
            this.aWC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hkt != null) {
                        b.this.hkt.bIb();
                    }
                }
            });
            this.fFK = (ProgressBar) this.hkC.findViewById(d.g.progress_tb_imageview_progress);
            this.fFK.setVisibility(8);
        }

        public View getView() {
            return this.hkC;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.aWC != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.ac(b.this.hkr), (l.ae(b.this.hkr) - l.f(b.this.hkr, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aWC.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.aWC.setLayoutParams(layoutParams);
                aVar.a(this.aWC);
                if (b.this.hky != null && b.this.hky.hmF != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hky.hmF.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    b.this.hky.hmF.setLayoutParams(layoutParams2);
                }
                if (aVar.kK() != null && !aVar.kK().isRecycled()) {
                    b.this.mBitmap = aVar.kK();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aay();
                com.baidu.adp.widget.a.a a = this.hkD.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                og(false);
                this.hkD.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0165b.this.og(true);
                        C0165b.this.c(imageFileInfo, aVar);
                        if (b.this.hky != null) {
                            b.this.hky.bHr();
                        }
                    }
                }, false);
            }
        }

        public void aay() {
            if (this.hkD != null) {
                this.hkD.EL();
            }
            if (this.aWC != null) {
                this.aWC.setImageDrawable(null);
            }
        }

        public boolean bIf() {
            return this.fFK.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void og(boolean z) {
            if (z) {
                if (this.fFK.getVisibility() != 8) {
                    if (b.this.hkt != null) {
                        b.this.hkt.bId();
                    }
                    this.fFK.setVisibility(8);
                    b.this.hkv[this.index].setCanbeClick(true);
                }
            } else if (this.fFK.getVisibility() != 0) {
                if (b.this.hkt != null) {
                    b.this.hkt.bIc();
                }
                this.fFK.setVisibility(0);
                b.this.hkv[this.index].setCanbeClick(false);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

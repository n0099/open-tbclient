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
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0052a {
    private int aEN;
    private ViewPager aEt;
    private a hhA;
    private C0148b[] hhB;
    private com.baidu.tbadk.coreExtra.view.a[] hhC;
    private int hhD;
    private int hhE;
    private g hhF;
    private com.baidu.tbadk.core.dialog.a hhG;
    private WriteMultiImgsActivity hhy;
    private ImageFileInfo[] hhz;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;

    /* loaded from: classes2.dex */
    public interface a {
        void J(int i, boolean z);

        void bHm();

        void bHo();

        void bHp();

        void bHq();

        boolean bHr();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hhy = null;
        this.hhz = null;
        this.aEt = null;
        this.hhA = null;
        this.mCount = 0;
        this.aEN = 0;
        this.hhB = null;
        this.hhC = null;
        this.hhD = 120;
        this.hhE = 120;
        this.mIsFromIm = z;
        this.hhy = writeMultiImgsActivity;
        this.hhF = gVar;
        this.hhD = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hhE = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hhz = new ImageFileInfo[this.mCount];
        this.hhB = new C0148b[this.mCount];
        this.hhC = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hhz[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hhz[i2].addPageAction(com.baidu.tbadk.img.effect.d.I(this.hhD, this.hhE));
            linkedList.set(i2, this.hhz[i2]);
            this.hhz[i2].mCount = 0;
        }
        this.aEN = i;
        this.aEt = viewPager;
        this.hhA = aVar;
        this.aEt.setOffscreenPageLimit(1);
        this.aEt.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hhB == null || this.aEN >= this.hhB.length || this.hhB[this.aEN] == null || this.hhz == null || this.aEN >= this.hhz.length || this.hhz[this.aEN] == null) ? false : true;
    }

    public boolean bHj() {
        if (this.aEN >= this.hhz.length || this.hhz[this.aEN] == null || !this.hhz[this.aEN].isGif() || this.hhz[this.aEN].mCount > 0) {
            return false;
        }
        this.hhz[this.aEN].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        if (bHj()) {
            if (this.hhA != null) {
                this.hhA.J(i, z);
            }
        } else if (z) {
            we(i);
        } else if (checkValid()) {
            C0148b c0148b = this.hhB[this.aEN];
            ImageFileInfo imageFileInfo = this.hhz[this.aEN];
            if (c0148b.bHs()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fh(i));
                this.hhy.bIh();
                if (i == 0 || i == 1) {
                    imageFileInfo.setRotateType(imageFileInfo.getRotateType() + 1);
                }
                if (this.hhC[this.aEN] != null && this.aEN < this.hhC.length) {
                    String selectedFilter = this.hhC[this.aEN].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gy(selectedFilter));
                        c0148b.i(cloneWithoutFilterAction);
                        return;
                    }
                    c0148b.i(imageFileInfo);
                    return;
                }
                c0148b.i(imageFileInfo);
            }
        }
    }

    private void we(final int i) {
        if (this.hhG == null) {
            this.hhG = new com.baidu.tbadk.core.dialog.a(this.hhy);
            this.hhG.cd(d.j.rorate_tip);
            this.hhG.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hhG != null) {
                        b.this.hhG.dismiss();
                    }
                    b.this.hhF.hjN.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHl() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHm() {
                            b.this.hhA.bHm();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean z(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHn() {
                        }
                    });
                    b.this.I(i, false);
                }
            });
            this.hhG.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hhG != null) {
                        b.this.hhG.dismiss();
                    }
                }
            });
            this.hhG.b(this.hhy.getPageContext());
        }
        this.hhG.tk();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0052a
    public void fl(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hhy.bIh();
                ImageFileInfo cloneWithoutFilterAction = this.hhz[this.aEN].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gy(str));
                this.hhB[this.aEN].i(cloneWithoutFilterAction);
                return;
            }
            this.hhy.bIi();
            this.hhB[this.aEN].i(this.hhz[this.aEN]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hhB[i] == null) {
            this.hhB[i] = new C0148b(i);
        }
        this.aEt.addView(this.hhB[i].getView());
        return this.hhB[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aEt.removeView(this.hhB[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEN = i;
        bHk();
    }

    private void bHk() {
        if (this.aEN >= 0 && this.aEN < this.hhB.length && this.aEN < this.hhz.length && this.hhz[this.aEN] != null) {
            if (this.hhB != null) {
                for (int i = 0; i < this.hhB.length; i++) {
                    if (this.hhB[i] != null) {
                        this.hhB[i].aax();
                    }
                }
                if (this.hhB[this.aEN] == null) {
                    this.hhB[this.aEN] = new C0148b(this.aEN);
                }
            }
            String selectedFilter = this.hhC[this.aEN].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hhz[this.aEN].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gy(selectedFilter));
                    if (this.hhB != null) {
                        this.hhB[this.aEN].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hhB != null) {
                this.hhB[this.aEN].i(this.hhz[this.aEN]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEN;
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
        this.hhC[i] = new com.baidu.tbadk.coreExtra.view.a(this.hhy, this, str);
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
    public void oe(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        String selectedFilter;
        Bitmap bitmap3 = null;
        if (this.hhz != null) {
            for (int i = 0; i < this.hhz.length; i++) {
                ImageFileInfo imageFileInfo = this.hhz[i];
                if (imageFileInfo != null) {
                    this.hhz[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hhC[i] != null && (selectedFilter = this.hhC[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hhz[i].addPersistAction(com.baidu.tbadk.img.effect.a.gy(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    y(this.mBitmap);
                }
            } else if (this.hhA != null && this.hhA.bHr() && this.hhF != null && this.hhF.hjN != null) {
                this.hhF.hjN.aPO();
                TbImageView tbImageView = this.hhB[this.aEN].aWA;
                try {
                    bitmap2 = this.hhF.hjN.btt();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap2 != null) {
                    try {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                        if (this.hhz[this.aEN].getRotateType() % 2 == 0) {
                            layoutParams.width = bitmap2.getWidth();
                            layoutParams.height = bitmap2.getHeight();
                        } else {
                            layoutParams.width = bitmap2.getHeight();
                            layoutParams.height = bitmap2.getWidth();
                        }
                        tbImageView.setLayoutParams(layoutParams);
                        bitmap3 = com.baidu.tbadk.util.d.R(tbImageView);
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
                        this.hhz[this.aEN].setFilePath(k.b(k.um(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hhz[this.aEN].clearAllActions();
                        this.hhz[this.aEN].clearPageActions();
                        this.hhz[this.aEN].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            y(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                y(this.mBitmap);
            }
        }
    }

    private void y(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.hhz[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0148b {
        private TbImageView aWA;
        private ProgressBar fES;
        private FrameLayout hhJ;
        private com.baidu.tbadk.img.b hhK;
        private int index;

        public C0148b(int i) {
            this.fES = null;
            this.index = -1;
            this.index = i;
            this.hhJ = (FrameLayout) LayoutInflater.from(b.this.hhy.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.aWA = (TbImageView) this.hhJ.findViewById(d.g.progress_tb_imageview);
            this.aWA.setClickable(true);
            this.aWA.setDefaultResource(0);
            this.aWA.setDefaultErrorResource(0);
            this.aWA.setDefaultBgResource(0);
            this.aWA.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.aWA.setPadding(0, 0, 0, 0);
            this.hhK = new com.baidu.tbadk.img.b();
            this.aWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hhA != null) {
                        b.this.hhA.bHo();
                    }
                }
            });
            this.fES = (ProgressBar) this.hhJ.findViewById(d.g.progress_tb_imageview_progress);
            this.fES.setVisibility(8);
        }

        public View getView() {
            return this.hhJ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.aWA != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.ac(b.this.hhy), (l.ae(b.this.hhy) - l.f(b.this.hhy, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aWA.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.aWA.setLayoutParams(layoutParams);
                aVar.a(this.aWA);
                if (b.this.hhF != null && b.this.hhF.hjN != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hhF.hjN.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    b.this.hhF.hjN.setLayoutParams(layoutParams2);
                }
                if (aVar.kK() != null && !aVar.kK().isRecycled()) {
                    b.this.mBitmap = aVar.kK();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aax();
                com.baidu.adp.widget.a.a a = this.hhK.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                of(false);
                this.hhK.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0148b.this.of(true);
                        C0148b.this.c(imageFileInfo, aVar);
                        if (b.this.hhF != null) {
                            b.this.hhF.bGF();
                        }
                    }
                }, false);
            }
        }

        public void aax() {
            if (this.hhK != null) {
                this.hhK.EK();
            }
            if (this.aWA != null) {
                this.aWA.setImageDrawable(null);
            }
        }

        public boolean bHs() {
            return this.fES.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void of(boolean z) {
            if (z) {
                if (this.fES.getVisibility() != 8) {
                    if (b.this.hhA != null) {
                        b.this.hhA.bHq();
                    }
                    this.fES.setVisibility(8);
                    b.this.hhC[this.index].setCanbeClick(true);
                }
            } else if (this.fES.getVisibility() != 0) {
                if (b.this.hhA != null) {
                    b.this.hhA.bHp();
                }
                this.fES.setVisibility(0);
                b.this.hhC[this.index].setCanbeClick(false);
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

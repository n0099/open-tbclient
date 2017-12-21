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
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0065a {
    private ViewPager aEB;
    private int aEV;
    private com.baidu.tbadk.coreExtra.view.a[] hkA;
    private int hkB;
    private int hkC;
    private g hkD;
    private com.baidu.tbadk.core.dialog.a hkE;
    private WriteMultiImgsActivity hkw;
    private ImageFileInfo[] hkx;
    private a hky;
    private C0164b[] hkz;
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
        this.hkw = null;
        this.hkx = null;
        this.aEB = null;
        this.hky = null;
        this.mCount = 0;
        this.aEV = 0;
        this.hkz = null;
        this.hkA = null;
        this.hkB = 120;
        this.hkC = 120;
        this.mIsFromIm = z;
        this.hkw = writeMultiImgsActivity;
        this.hkD = gVar;
        this.hkB = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hkC = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hkx = new ImageFileInfo[this.mCount];
        this.hkz = new C0164b[this.mCount];
        this.hkA = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hkx[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hkx[i2].addPageAction(com.baidu.tbadk.img.effect.d.J(this.hkB, this.hkC));
            linkedList.set(i2, this.hkx[i2]);
            this.hkx[i2].mCount = 0;
        }
        this.aEV = i;
        this.aEB = viewPager;
        this.hky = aVar;
        this.aEB.setOffscreenPageLimit(1);
        this.aEB.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hkz == null || this.aEV >= this.hkz.length || this.hkz[this.aEV] == null || this.hkx == null || this.aEV >= this.hkx.length || this.hkx[this.aEV] == null) ? false : true;
    }

    public boolean bHW() {
        if (this.aEV >= this.hkx.length || this.hkx[this.aEV] == null || !this.hkx[this.aEV].isGif() || this.hkx[this.aEV].mCount > 0) {
            return false;
        }
        this.hkx[this.aEV].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        if (bHW()) {
            if (this.hky != null) {
                this.hky.J(i, z);
            }
        } else if (z) {
            wr(i);
        } else if (checkValid()) {
            C0164b c0164b = this.hkz[this.aEV];
            ImageFileInfo imageFileInfo = this.hkx[this.aEV];
            if (c0164b.bIf()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.fh(i));
                this.hkw.bIU();
                if (i == 0 || i == 1) {
                    imageFileInfo.setRotateType(imageFileInfo.getRotateType() + 1);
                }
                if (this.hkA[this.aEV] != null && this.aEV < this.hkA.length) {
                    String selectedFilter = this.hkA[this.aEV].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gx(selectedFilter));
                        c0164b.i(cloneWithoutFilterAction);
                        return;
                    }
                    c0164b.i(imageFileInfo);
                    return;
                }
                c0164b.i(imageFileInfo);
            }
        }
    }

    private void wr(final int i) {
        if (this.hkE == null) {
            this.hkE = new com.baidu.tbadk.core.dialog.a(this.hkw);
            this.hkE.cd(d.j.rorate_tip);
            this.hkE.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hkE != null) {
                        b.this.hkE.dismiss();
                    }
                    b.this.hkD.hmK.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHY() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHZ() {
                            b.this.hky.bHZ();
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
            this.hkE.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hkE != null) {
                        b.this.hkE.dismiss();
                    }
                }
            });
            this.hkE.b(this.hkw.getPageContext());
        }
        this.hkE.th();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0065a
    public void fk(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hkw.bIU();
                ImageFileInfo cloneWithoutFilterAction = this.hkx[this.aEV].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gx(str));
                this.hkz[this.aEV].i(cloneWithoutFilterAction);
                return;
            }
            this.hkw.bIV();
            this.hkz[this.aEV].i(this.hkx[this.aEV]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hkz[i] == null) {
            this.hkz[i] = new C0164b(i);
        }
        this.aEB.addView(this.hkz[i].getView());
        return this.hkz[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aEB.removeView(this.hkz[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEV = i;
        bHX();
    }

    private void bHX() {
        if (this.aEV >= 0 && this.aEV < this.hkz.length && this.aEV < this.hkx.length && this.hkx[this.aEV] != null) {
            if (this.hkz != null) {
                for (int i = 0; i < this.hkz.length; i++) {
                    if (this.hkz[i] != null) {
                        this.hkz[i].aay();
                    }
                }
                if (this.hkz[this.aEV] == null) {
                    this.hkz[this.aEV] = new C0164b(this.aEV);
                }
            }
            String selectedFilter = this.hkA[this.aEV].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hkx[this.aEV].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gx(selectedFilter));
                    if (this.hkz != null) {
                        this.hkz[this.aEV].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hkz != null) {
                this.hkz[this.aEV].i(this.hkx[this.aEV]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEV;
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
        this.hkA[i] = new com.baidu.tbadk.coreExtra.view.a(this.hkw, this, str);
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
        if (this.hkx != null) {
            for (int i = 0; i < this.hkx.length; i++) {
                ImageFileInfo imageFileInfo = this.hkx[i];
                if (imageFileInfo != null) {
                    this.hkx[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hkA[i] != null && (selectedFilter = this.hkA[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hkx[i].addPersistAction(com.baidu.tbadk.img.effect.a.gx(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    z(this.mBitmap);
                }
            } else if (this.hky != null && this.hky.bIe() && this.hkD != null && this.hkD.hmK != null) {
                this.hkD.hmK.aPX();
                TbImageView tbImageView = this.hkz[this.aEV].aWG;
                try {
                    bitmap2 = this.hkD.hmK.btZ();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap2 != null) {
                    try {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                        if (this.hkx[this.aEV].getRotateType() % 2 == 0) {
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
                        this.hkx[this.aEV].setFilePath(k.b(k.uj(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hkx[this.aEV].clearAllActions();
                        this.hkx[this.aEV].clearPageActions();
                        this.hkx[this.aEV].setIsGif(false);
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
                this.hkx[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0164b {
        private TbImageView aWG;
        private ProgressBar fFP;
        private FrameLayout hkH;
        private com.baidu.tbadk.img.b hkI;
        private int index;

        public C0164b(int i) {
            this.fFP = null;
            this.index = -1;
            this.index = i;
            this.hkH = (FrameLayout) LayoutInflater.from(b.this.hkw.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.aWG = (TbImageView) this.hkH.findViewById(d.g.progress_tb_imageview);
            this.aWG.setClickable(true);
            this.aWG.setDefaultResource(0);
            this.aWG.setDefaultErrorResource(0);
            this.aWG.setDefaultBgResource(0);
            this.aWG.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aWG.setPadding(0, 0, 0, 0);
            this.hkI = new com.baidu.tbadk.img.b();
            this.aWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hky != null) {
                        b.this.hky.bIb();
                    }
                }
            });
            this.fFP = (ProgressBar) this.hkH.findViewById(d.g.progress_tb_imageview_progress);
            this.fFP.setVisibility(8);
        }

        public View getView() {
            return this.hkH;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.aWG != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.ac(b.this.hkw), (l.ae(b.this.hkw) - l.f(b.this.hkw, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aWG.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.aWG.setLayoutParams(layoutParams);
                aVar.a(this.aWG);
                if (b.this.hkD != null && b.this.hkD.hmK != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hkD.hmK.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    b.this.hkD.hmK.setLayoutParams(layoutParams2);
                }
                if (aVar.kK() != null && !aVar.kK().isRecycled()) {
                    b.this.mBitmap = aVar.kK();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aay();
                com.baidu.adp.widget.a.a a = this.hkI.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                og(false);
                this.hkI.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0164b.this.og(true);
                        C0164b.this.c(imageFileInfo, aVar);
                        if (b.this.hkD != null) {
                            b.this.hkD.bHr();
                        }
                    }
                }, false);
            }
        }

        public void aay() {
            if (this.hkI != null) {
                this.hkI.EL();
            }
            if (this.aWG != null) {
                this.aWG.setImageDrawable(null);
            }
        }

        public boolean bIf() {
            return this.fFP.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void og(boolean z) {
            if (z) {
                if (this.fFP.getVisibility() != 8) {
                    if (b.this.hky != null) {
                        b.this.hky.bId();
                    }
                    this.fFP.setVisibility(8);
                    b.this.hkA[this.index].setCanbeClick(true);
                }
            } else if (this.fFP.getVisibility() != 0) {
                if (b.this.hky != null) {
                    b.this.hky.bIc();
                }
                this.fFP.setVisibility(0);
                b.this.hkA[this.index].setCanbeClick(false);
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

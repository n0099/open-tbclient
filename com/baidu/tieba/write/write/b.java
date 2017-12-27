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
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0079a {
    private int bsN;
    private WriteMultiImgsActivity hSC;
    private ImageFileInfo[] hSD;
    private a hSE;
    private C0177b[] hSF;
    private com.baidu.tbadk.coreExtra.view.a[] hSG;
    private int hSH;
    private int hSI;
    private g hSJ;
    private com.baidu.tbadk.core.dialog.a hSK;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager qW;

    /* loaded from: classes2.dex */
    public interface a {
        void U(int i, boolean z);

        void bNN();

        void bNP();

        void bNQ();

        void bNR();

        boolean bNS();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hSC = null;
        this.hSD = null;
        this.qW = null;
        this.hSE = null;
        this.mCount = 0;
        this.bsN = 0;
        this.hSF = null;
        this.hSG = null;
        this.hSH = 120;
        this.hSI = 120;
        this.mIsFromIm = z;
        this.hSC = writeMultiImgsActivity;
        this.hSJ = gVar;
        this.hSH = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hSI = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hSD = new ImageFileInfo[this.mCount];
        this.hSF = new C0177b[this.mCount];
        this.hSG = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hSD[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hSD[i2].addPageAction(com.baidu.tbadk.img.effect.d.aI(this.hSH, this.hSI));
            linkedList.set(i2, this.hSD[i2]);
            this.hSD[i2].mCount = 0;
        }
        this.bsN = i;
        this.qW = viewPager;
        this.hSE = aVar;
        this.qW.setOffscreenPageLimit(1);
        this.qW.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hSF == null || this.bsN >= this.hSF.length || this.hSF[this.bsN] == null || this.hSD == null || this.bsN >= this.hSD.length || this.hSD[this.bsN] == null) ? false : true;
    }

    public boolean bNK() {
        if (this.bsN >= this.hSD.length || this.hSD[this.bsN] == null || !this.hSD[this.bsN].isGif() || this.hSD[this.bsN].mCount > 0) {
            return false;
        }
        this.hSD[this.bsN].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        if (bNK()) {
            if (this.hSE != null) {
                this.hSE.U(i, z);
            }
        } else if (z) {
            zi(i);
        } else if (checkValid()) {
            C0177b c0177b = this.hSF[this.bsN];
            ImageFileInfo imageFileInfo = this.hSD[this.bsN];
            if (c0177b.bNT()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.m13if(i));
                this.hSC.bOI();
                if (this.hSG[this.bsN] != null && this.bsN < this.hSG.length) {
                    String selectedFilter = this.hSG[this.bsN].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gC(selectedFilter));
                        c0177b.i(cloneWithoutFilterAction);
                        return;
                    }
                    c0177b.i(imageFileInfo);
                    return;
                }
                c0177b.i(imageFileInfo);
            }
        }
    }

    private void zi(final int i) {
        if (this.hSK == null) {
            this.hSK = new com.baidu.tbadk.core.dialog.a(this.hSC);
            this.hSK.fd(d.j.rorate_tip);
            this.hSK.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hSK != null) {
                        b.this.hSK.dismiss();
                    }
                    b.this.hSJ.hUQ.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNM() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNN() {
                            b.this.hSE.bNN();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean A(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bNO() {
                        }
                    });
                    b.this.T(i, false);
                }
            });
            this.hSK.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hSK != null) {
                        b.this.hSK.dismiss();
                    }
                }
            });
            this.hSK.b(this.hSC.getPageContext());
        }
        this.hSK.AI();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0079a
    public void fr(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hSC.bOI();
                ImageFileInfo cloneWithoutFilterAction = this.hSD[this.bsN].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gC(str));
                this.hSF[this.bsN].i(cloneWithoutFilterAction);
                return;
            }
            this.hSC.bOJ();
            this.hSF[this.bsN].i(this.hSD[this.bsN]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hSF[i] == null) {
            this.hSF[i] = new C0177b(i);
        }
        this.qW.addView(this.hSF[i].getView());
        return this.hSF[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.qW.removeView(this.hSF[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bsN = i;
        bNL();
    }

    private void bNL() {
        if (this.bsN >= 0 && this.bsN < this.hSF.length && this.bsN < this.hSD.length && this.hSD[this.bsN] != null) {
            if (this.hSF != null) {
                for (int i = 0; i < this.hSF.length; i++) {
                    if (this.hSF[i] != null) {
                        this.hSF[i].aie();
                    }
                }
                if (this.hSF[this.bsN] == null) {
                    this.hSF[this.bsN] = new C0177b(this.bsN);
                }
            }
            String selectedFilter = this.hSG[this.bsN].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hSD[this.bsN].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gC(selectedFilter));
                    if (this.hSF != null) {
                        this.hSF[this.bsN].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hSF != null) {
                this.hSF[this.bsN].i(this.hSD[this.bsN]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bsN;
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
        this.hSG[i] = new com.baidu.tbadk.coreExtra.view.a(this.hSC, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean b(String str, Bitmap bitmap) {
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
    public void oA(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        String selectedFilter;
        Bitmap bitmap2 = null;
        if (this.hSD != null) {
            for (int i = 0; i < this.hSD.length; i++) {
                ImageFileInfo imageFileInfo = this.hSD[i];
                if (imageFileInfo != null) {
                    this.hSD[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hSG[i] != null && (selectedFilter = this.hSG[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hSD[i].addPersistAction(com.baidu.tbadk.img.effect.a.gC(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    z(this.mBitmap);
                }
            } else if (this.hSE != null && this.hSE.bNS() && this.hSJ != null && this.hSJ.hUQ != null) {
                this.hSJ.hUQ.aXh();
                TbImageView tbImageView = this.hSF[this.bsN].bKv;
                try {
                    bitmap = this.hSJ.hUQ.bPn();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.d.bk(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.d.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.hSD[this.bsN].setFilePath(k.b(k.BJ(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hSD[this.bsN].clearAllActions();
                        this.hSD[this.bsN].clearPageActions();
                        this.hSD[this.bsN].setIsGif(false);
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
            if (b(str, bitmap)) {
                this.hSD[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0177b {
        private TbImageView bKv;
        private ProgressBar gsP;
        private FrameLayout hSN;
        private com.baidu.tbadk.img.b hSO;
        private int index;

        public C0177b(int i) {
            this.gsP = null;
            this.index = -1;
            this.index = i;
            this.hSN = (FrameLayout) LayoutInflater.from(b.this.hSC.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.bKv = (TbImageView) this.hSN.findViewById(d.g.progress_tb_imageview);
            this.bKv.setClickable(true);
            this.bKv.setDefaultResource(0);
            this.bKv.setDefaultErrorResource(0);
            this.bKv.setDefaultBgResource(0);
            this.bKv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bKv.setPadding(0, 0, 0, 0);
            this.hSO = new com.baidu.tbadk.img.b();
            this.bKv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hSE != null) {
                        b.this.hSE.bNP();
                    }
                }
            });
            this.gsP = (ProgressBar) this.hSN.findViewById(d.g.progress_tb_imageview_progress);
            this.gsP.setVisibility(8);
        }

        public View getView() {
            return this.hSN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.bKv != null) {
                int[] j = l.j(aVar.getWidth(), aVar.getHeight(), l.ao(b.this.hSC), (l.aq(b.this.hSC) - l.s(b.this.hSC, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bKv.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = j[0];
                layoutParams.height = j[1];
                this.bKv.setLayoutParams(layoutParams);
                aVar.a(this.bKv);
                if (b.this.hSJ != null && b.this.hSJ.hUQ != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hSJ.hUQ.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = j[0];
                    layoutParams2.height = j[1];
                    b.this.hSJ.hUQ.setLayoutParams(layoutParams2);
                }
                if (aVar.si() != null && !aVar.si().isRecycled()) {
                    b.this.mBitmap = aVar.si();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aie();
                com.baidu.adp.widget.a.a a = this.hSO.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                oB(false);
                this.hSO.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0177b.this.oB(true);
                        C0177b.this.c(imageFileInfo, aVar);
                        if (b.this.hSJ != null) {
                            b.this.hSJ.bNf();
                        }
                    }
                }, false);
            }
        }

        public void aie() {
            if (this.hSO != null) {
                this.hSO.Ml();
            }
            if (this.bKv != null) {
                this.bKv.setImageDrawable(null);
            }
        }

        public boolean bNT() {
            return this.gsP.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oB(boolean z) {
            if (z) {
                if (this.gsP.getVisibility() != 8) {
                    if (b.this.hSE != null) {
                        b.this.hSE.bNR();
                    }
                    this.gsP.setVisibility(8);
                    b.this.hSG[this.index].setCanbeClick(true);
                }
            } else if (this.gsP.getVisibility() != 0) {
                if (b.this.hSE != null) {
                    b.this.hSE.bNQ();
                }
                this.gsP.setVisibility(0);
                b.this.hSG[this.index].setCanbeClick(false);
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

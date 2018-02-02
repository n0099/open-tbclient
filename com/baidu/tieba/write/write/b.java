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
    private int btf;
    private WriteMultiImgsActivity hIF;
    private ImageFileInfo[] hIG;
    private a hIH;
    private C0177b[] hII;
    private com.baidu.tbadk.coreExtra.view.a[] hIJ;
    private int hIK;
    private int hIL;
    private g hIM;
    private com.baidu.tbadk.core.dialog.a hIN;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager qW;

    /* loaded from: classes2.dex */
    public interface a {
        void U(int i, boolean z);

        void bHp();

        void bHr();

        void bHs();

        void bHt();

        boolean bHu();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hIF = null;
        this.hIG = null;
        this.qW = null;
        this.hIH = null;
        this.mCount = 0;
        this.btf = 0;
        this.hII = null;
        this.hIJ = null;
        this.hIK = 120;
        this.hIL = 120;
        this.mIsFromIm = z;
        this.hIF = writeMultiImgsActivity;
        this.hIM = gVar;
        this.hIK = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hIL = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hIG = new ImageFileInfo[this.mCount];
        this.hII = new C0177b[this.mCount];
        this.hIJ = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hIG[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hIG[i2].addPageAction(com.baidu.tbadk.img.effect.d.aI(this.hIK, this.hIL));
            linkedList.set(i2, this.hIG[i2]);
            this.hIG[i2].mCount = 0;
        }
        this.btf = i;
        this.qW = viewPager;
        this.hIH = aVar;
        this.qW.setOffscreenPageLimit(1);
        this.qW.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hII == null || this.btf >= this.hII.length || this.hII[this.btf] == null || this.hIG == null || this.btf >= this.hIG.length || this.hIG[this.btf] == null) ? false : true;
    }

    public boolean bHm() {
        if (this.btf >= this.hIG.length || this.hIG[this.btf] == null || !this.hIG[this.btf].isGif() || this.hIG[this.btf].mCount > 0) {
            return false;
        }
        this.hIG[this.btf].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        if (bHm()) {
            if (this.hIH != null) {
                this.hIH.U(i, z);
            }
        } else if (z) {
            xL(i);
        } else if (checkValid()) {
            C0177b c0177b = this.hII[this.btf];
            ImageFileInfo imageFileInfo = this.hIG[this.btf];
            if (c0177b.bHv()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.ib(i));
                this.hIF.bIn();
                if (this.hIJ[this.btf] != null && this.btf < this.hIJ.length) {
                    String selectedFilter = this.hIJ[this.btf].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gL(selectedFilter));
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

    private void xL(final int i) {
        if (this.hIN == null) {
            this.hIN = new com.baidu.tbadk.core.dialog.a(this.hIF);
            this.hIN.fb(d.j.rorate_tip);
            this.hIN.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hIN != null) {
                        b.this.hIN.dismiss();
                    }
                    b.this.hIM.hKU.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHo() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHp() {
                            b.this.hIH.bHp();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean A(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHq() {
                        }
                    });
                    b.this.T(i, false);
                }
            });
            this.hIN.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hIN != null) {
                        b.this.hIN.dismiss();
                    }
                }
            });
            this.hIN.b(this.hIF.getPageContext());
        }
        this.hIN.AB();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0079a
    public void fz(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hIF.bIn();
                ImageFileInfo cloneWithoutFilterAction = this.hIG[this.btf].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gL(str));
                this.hII[this.btf].i(cloneWithoutFilterAction);
                return;
            }
            this.hIF.bIo();
            this.hII[this.btf].i(this.hIG[this.btf]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hII[i] == null) {
            this.hII[i] = new C0177b(i);
        }
        this.qW.addView(this.hII[i].getView());
        return this.hII[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.qW.removeView(this.hII[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.btf = i;
        bHn();
    }

    private void bHn() {
        if (this.btf >= 0 && this.btf < this.hII.length && this.btf < this.hIG.length && this.hIG[this.btf] != null) {
            if (this.hII != null) {
                for (int i = 0; i < this.hII.length; i++) {
                    if (this.hII[i] != null) {
                        this.hII[i].ajm();
                    }
                }
                if (this.hII[this.btf] == null) {
                    this.hII[this.btf] = new C0177b(this.btf);
                }
            }
            String selectedFilter = this.hIJ[this.btf].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hIG[this.btf].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gL(selectedFilter));
                    if (this.hII != null) {
                        this.hII[this.btf].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hII != null) {
                this.hII[this.btf].i(this.hIG[this.btf]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.btf;
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
        this.hIJ[i] = new com.baidu.tbadk.coreExtra.view.a(this.hIF, this, str);
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
    public void nG(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        String selectedFilter;
        Bitmap bitmap2 = null;
        if (this.hIG != null) {
            for (int i = 0; i < this.hIG.length; i++) {
                ImageFileInfo imageFileInfo = this.hIG[i];
                if (imageFileInfo != null) {
                    this.hIG[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hIJ[i] != null && (selectedFilter = this.hIJ[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hIG[i].addPersistAction(com.baidu.tbadk.img.effect.a.gL(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    z(this.mBitmap);
                }
            } else if (this.hIH != null && this.hIH.bHu() && this.hIM != null && this.hIM.hKU != null) {
                this.hIM.hKU.aXr();
                TbImageView tbImageView = this.hII[this.btf].bKL;
                try {
                    bitmap = this.hIM.hKU.bIS();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.d.bm(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.d.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.hIG[this.btf].setFilePath(k.b(k.BC(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hIG[this.btf].clearAllActions();
                        this.hIG[this.btf].clearPageActions();
                        this.hIG[this.btf].setIsGif(false);
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
                this.hIG[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0177b {
        private TbImageView bKL;
        private ProgressBar gTH;
        private FrameLayout hIQ;
        private com.baidu.tbadk.img.b hIR;
        private int index;

        public C0177b(int i) {
            this.gTH = null;
            this.index = -1;
            this.index = i;
            this.hIQ = (FrameLayout) LayoutInflater.from(b.this.hIF.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.bKL = (TbImageView) this.hIQ.findViewById(d.g.progress_tb_imageview);
            this.bKL.setClickable(true);
            this.bKL.setDefaultResource(0);
            this.bKL.setDefaultErrorResource(0);
            this.bKL.setDefaultBgResource(0);
            this.bKL.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bKL.setPadding(0, 0, 0, 0);
            this.hIR = new com.baidu.tbadk.img.b();
            this.bKL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hIH != null) {
                        b.this.hIH.bHr();
                    }
                }
            });
            this.gTH = (ProgressBar) this.hIQ.findViewById(d.g.progress_tb_imageview_progress);
            this.gTH.setVisibility(8);
        }

        public View getView() {
            return this.hIQ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.bKL != null) {
                int[] j = l.j(aVar.getWidth(), aVar.getHeight(), l.ao(b.this.hIF), (l.aq(b.this.hIF) - l.s(b.this.hIF, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bKL.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = j[0];
                layoutParams.height = j[1];
                this.bKL.setLayoutParams(layoutParams);
                aVar.a(this.bKL);
                if (b.this.hIM != null && b.this.hIM.hKU != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hIM.hKU.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = j[0];
                    layoutParams2.height = j[1];
                    b.this.hIM.hKU.setLayoutParams(layoutParams2);
                }
                if (aVar.sj() != null && !aVar.sj().isRecycled()) {
                    b.this.mBitmap = aVar.sj();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                ajm();
                com.baidu.adp.widget.a.a a = this.hIR.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                nH(false);
                this.hIR.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0177b.this.nH(true);
                        C0177b.this.c(imageFileInfo, aVar);
                        if (b.this.hIM != null) {
                            b.this.hIM.bGH();
                        }
                    }
                }, false);
            }
        }

        public void ajm() {
            if (this.hIR != null) {
                this.hIR.Mb();
            }
            if (this.bKL != null) {
                this.bKL.setImageDrawable(null);
            }
        }

        public boolean bHv() {
            return this.gTH.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nH(boolean z) {
            if (z) {
                if (this.gTH.getVisibility() != 8) {
                    if (b.this.hIH != null) {
                        b.this.hIH.bHt();
                    }
                    this.gTH.setVisibility(8);
                    b.this.hIJ[this.index].setCanbeClick(true);
                }
            } else if (this.gTH.getVisibility() != 0) {
                if (b.this.hIH != null) {
                    b.this.hIH.bHs();
                }
                this.gTH.setVisibility(0);
                b.this.hIJ[this.index].setCanbeClick(false);
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

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
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0103a {
    private int bvf;
    private WriteMultiImgsActivity hJO;
    private ImageFileInfo[] hJP;
    private a hJQ;
    private C0260b[] hJR;
    private com.baidu.tbadk.coreExtra.view.a[] hJS;
    private int hJT;
    private int hJU;
    private g hJV;
    private com.baidu.tbadk.core.dialog.a hJW;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager qV;

    /* loaded from: classes2.dex */
    public interface a {
        void aa(int i, boolean z);

        void bIc();

        void bIe();

        void bIf();

        void bIg();

        boolean bIh();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hJO = null;
        this.hJP = null;
        this.qV = null;
        this.hJQ = null;
        this.mCount = 0;
        this.bvf = 0;
        this.hJR = null;
        this.hJS = null;
        this.hJT = 120;
        this.hJU = 120;
        this.mIsFromIm = z;
        this.hJO = writeMultiImgsActivity;
        this.hJV = gVar;
        this.hJT = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hJU = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hJP = new ImageFileInfo[this.mCount];
        this.hJR = new C0260b[this.mCount];
        this.hJS = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hJP[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hJP[i2].addPageAction(com.baidu.tbadk.img.effect.d.aI(this.hJT, this.hJU));
            linkedList.set(i2, this.hJP[i2]);
            this.hJP[i2].mCount = 0;
        }
        this.bvf = i;
        this.qV = viewPager;
        this.hJQ = aVar;
        this.qV.setOffscreenPageLimit(1);
        this.qV.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hJR == null || this.bvf >= this.hJR.length || this.hJR[this.bvf] == null || this.hJP == null || this.bvf >= this.hJP.length || this.hJP[this.bvf] == null) ? false : true;
    }

    public boolean bHZ() {
        if (this.bvf >= this.hJP.length || this.hJP[this.bvf] == null || !this.hJP[this.bvf].isGif() || this.hJP[this.bvf].mCount > 0) {
            return false;
        }
        this.hJP[this.bvf].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(int i, boolean z) {
        if (bHZ()) {
            if (this.hJQ != null) {
                this.hJQ.aa(i, z);
            }
        } else if (z) {
            xL(i);
        } else if (checkValid()) {
            C0260b c0260b = this.hJR[this.bvf];
            ImageFileInfo imageFileInfo = this.hJP[this.bvf];
            if (c0260b.bIi()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.hZ(i));
                this.hJO.bJa();
                if (this.hJS[this.bvf] != null && this.bvf < this.hJS.length) {
                    String selectedFilter = this.hJS[this.bvf].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                        c0260b.i(cloneWithoutFilterAction);
                        return;
                    }
                    c0260b.i(imageFileInfo);
                    return;
                }
                c0260b.i(imageFileInfo);
            }
        }
    }

    private void xL(final int i) {
        if (this.hJW == null) {
            this.hJW = new com.baidu.tbadk.core.dialog.a(this.hJO);
            this.hJW.fb(d.j.rorate_tip);
            this.hJW.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hJW != null) {
                        b.this.hJW.dismiss();
                    }
                    b.this.hJV.hMf.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIb() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIc() {
                            b.this.hJQ.bIc();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean D(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bId() {
                        }
                    });
                    b.this.Z(i, false);
                }
            });
            this.hJW.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hJW != null) {
                        b.this.hJW.dismiss();
                    }
                }
            });
            this.hJW.b(this.hJO.getPageContext());
        }
        this.hJW.AU();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0103a
    public void fI(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hJO.bJa();
                ImageFileInfo cloneWithoutFilterAction = this.hJP[this.bvf].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(str));
                this.hJR[this.bvf].i(cloneWithoutFilterAction);
                return;
            }
            this.hJO.bJb();
            this.hJR[this.bvf].i(this.hJP[this.bvf]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hJR[i] == null) {
            this.hJR[i] = new C0260b(i);
        }
        this.qV.addView(this.hJR[i].getView());
        return this.hJR[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.qV.removeView(this.hJR[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bvf = i;
        bIa();
    }

    private void bIa() {
        if (this.bvf >= 0 && this.bvf < this.hJR.length && this.bvf < this.hJP.length && this.hJP[this.bvf] != null) {
            if (this.hJR != null) {
                for (int i = 0; i < this.hJR.length; i++) {
                    if (this.hJR[i] != null) {
                        this.hJR[i].akj();
                    }
                }
                if (this.hJR[this.bvf] == null) {
                    this.hJR[this.bvf] = new C0260b(this.bvf);
                }
            }
            String selectedFilter = this.hJS[this.bvf].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hJP[this.bvf].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                    if (this.hJR != null) {
                        this.hJR[this.bvf].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hJR != null) {
                this.hJR[this.bvf].i(this.hJP[this.bvf]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bvf;
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
        this.hJS[i] = new com.baidu.tbadk.coreExtra.view.a(this.hJO, this, str);
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
    public void nN(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        String selectedFilter;
        Bitmap bitmap2 = null;
        if (this.hJP != null) {
            for (int i = 0; i < this.hJP.length; i++) {
                ImageFileInfo imageFileInfo = this.hJP[i];
                if (imageFileInfo != null) {
                    this.hJP[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hJS[i] != null && (selectedFilter = this.hJS[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hJP[i].addPersistAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    C(this.mBitmap);
                }
            } else if (this.hJQ != null && this.hJQ.bIh() && this.hJV != null && this.hJV.hMf != null) {
                this.hJV.hMf.aYZ();
                TbImageView tbImageView = this.hJR[this.bvf].bMC;
                try {
                    bitmap = this.hJV.hMf.bJE();
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
                        this.hJP[this.bvf].setFilePath(k.b(k.BU(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hJP[this.bvf].clearAllActions();
                        this.hJP[this.bvf].clearPageActions();
                        this.hJP[this.bvf].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            C(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                C(this.mBitmap);
            }
        }
    }

    private void C(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (b(str, bitmap)) {
                this.hJP[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0260b {
        private TbImageView bMC;
        private ProgressBar gVL;
        private FrameLayout hJZ;
        private com.baidu.tbadk.img.b hKa;
        private int index;

        public C0260b(int i) {
            this.gVL = null;
            this.index = -1;
            this.index = i;
            this.hJZ = (FrameLayout) LayoutInflater.from(b.this.hJO.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.bMC = (TbImageView) this.hJZ.findViewById(d.g.progress_tb_imageview);
            this.bMC.setClickable(true);
            this.bMC.setDefaultResource(0);
            this.bMC.setDefaultErrorResource(0);
            this.bMC.setDefaultBgResource(0);
            this.bMC.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bMC.setPadding(0, 0, 0, 0);
            this.hKa = new com.baidu.tbadk.img.b();
            this.bMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hJQ != null) {
                        b.this.hJQ.bIe();
                    }
                }
            });
            this.gVL = (ProgressBar) this.hJZ.findViewById(d.g.progress_tb_imageview_progress);
            this.gVL.setVisibility(8);
        }

        public View getView() {
            return this.hJZ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.bMC != null) {
                int[] j = l.j(aVar.getWidth(), aVar.getHeight(), l.ao(b.this.hJO), (l.aq(b.this.hJO) - l.t(b.this.hJO, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bMC.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = j[0];
                layoutParams.height = j[1];
                this.bMC.setLayoutParams(layoutParams);
                aVar.a(this.bMC);
                if (b.this.hJV != null && b.this.hJV.hMf != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hJV.hMf.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = j[0];
                    layoutParams2.height = j[1];
                    b.this.hJV.hMf.setLayoutParams(layoutParams2);
                }
                if (aVar.sh() != null && !aVar.sh().isRecycled()) {
                    b.this.mBitmap = aVar.sh();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                akj();
                com.baidu.adp.widget.a.a a = this.hKa.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                nO(false);
                this.hKa.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0260b.this.nO(true);
                        C0260b.this.c(imageFileInfo, aVar);
                        if (b.this.hJV != null) {
                            b.this.hJV.bHu();
                        }
                    }
                }, false);
            }
        }

        public void akj() {
            if (this.hKa != null) {
                this.hKa.MG();
            }
            if (this.bMC != null) {
                this.bMC.setImageDrawable(null);
            }
        }

        public boolean bIi() {
            return this.gVL.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nO(boolean z) {
            if (z) {
                if (this.gVL.getVisibility() != 8) {
                    if (b.this.hJQ != null) {
                        b.this.hJQ.bIg();
                    }
                    this.gVL.setVisibility(8);
                    b.this.hJS[this.index].setCanbeClick(true);
                }
            } else if (this.gVL.getVisibility() != 0) {
                if (b.this.hJQ != null) {
                    b.this.hJQ.bIf();
                }
                this.gVL.setVisibility(0);
                b.this.hJS[this.index].setCanbeClick(false);
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

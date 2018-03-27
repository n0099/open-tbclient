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
    private int bvi;
    private WriteMultiImgsActivity hKm;
    private ImageFileInfo[] hKn;
    private a hKo;
    private C0260b[] hKp;
    private com.baidu.tbadk.coreExtra.view.a[] hKq;
    private int hKr;
    private int hKs;
    private g hKt;
    private com.baidu.tbadk.core.dialog.a hKu;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager qV;

    /* loaded from: classes2.dex */
    public interface a {
        void aa(int i, boolean z);

        void bIh();

        void bIj();

        void bIk();

        void bIl();

        boolean bIm();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hKm = null;
        this.hKn = null;
        this.qV = null;
        this.hKo = null;
        this.mCount = 0;
        this.bvi = 0;
        this.hKp = null;
        this.hKq = null;
        this.hKr = 120;
        this.hKs = 120;
        this.mIsFromIm = z;
        this.hKm = writeMultiImgsActivity;
        this.hKt = gVar;
        this.hKr = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hKs = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hKn = new ImageFileInfo[this.mCount];
        this.hKp = new C0260b[this.mCount];
        this.hKq = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hKn[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hKn[i2].addPageAction(com.baidu.tbadk.img.effect.d.aI(this.hKr, this.hKs));
            linkedList.set(i2, this.hKn[i2]);
            this.hKn[i2].mCount = 0;
        }
        this.bvi = i;
        this.qV = viewPager;
        this.hKo = aVar;
        this.qV.setOffscreenPageLimit(1);
        this.qV.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hKp == null || this.bvi >= this.hKp.length || this.hKp[this.bvi] == null || this.hKn == null || this.bvi >= this.hKn.length || this.hKn[this.bvi] == null) ? false : true;
    }

    public boolean bIe() {
        if (this.bvi >= this.hKn.length || this.hKn[this.bvi] == null || !this.hKn[this.bvi].isGif() || this.hKn[this.bvi].mCount > 0) {
            return false;
        }
        this.hKn[this.bvi].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(int i, boolean z) {
        if (bIe()) {
            if (this.hKo != null) {
                this.hKo.aa(i, z);
            }
        } else if (z) {
            xL(i);
        } else if (checkValid()) {
            C0260b c0260b = this.hKp[this.bvi];
            ImageFileInfo imageFileInfo = this.hKn[this.bvi];
            if (c0260b.bIn()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.hZ(i));
                this.hKm.bJf();
                if (this.hKq[this.bvi] != null && this.bvi < this.hKq.length) {
                    String selectedFilter = this.hKq[this.bvi].getSelectedFilter();
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
        if (this.hKu == null) {
            this.hKu = new com.baidu.tbadk.core.dialog.a(this.hKm);
            this.hKu.fb(d.j.rorate_tip);
            this.hKu.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hKu != null) {
                        b.this.hKu.dismiss();
                    }
                    b.this.hKt.hMD.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIg() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIh() {
                            b.this.hKo.bIh();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean D(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIi() {
                        }
                    });
                    b.this.Z(i, false);
                }
            });
            this.hKu.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hKu != null) {
                        b.this.hKu.dismiss();
                    }
                }
            });
            this.hKu.b(this.hKm.getPageContext());
        }
        this.hKu.AV();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0103a
    public void fI(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hKm.bJf();
                ImageFileInfo cloneWithoutFilterAction = this.hKn[this.bvi].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(str));
                this.hKp[this.bvi].i(cloneWithoutFilterAction);
                return;
            }
            this.hKm.bJg();
            this.hKp[this.bvi].i(this.hKn[this.bvi]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hKp[i] == null) {
            this.hKp[i] = new C0260b(i);
        }
        this.qV.addView(this.hKp[i].getView());
        return this.hKp[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.qV.removeView(this.hKp[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bvi = i;
        bIf();
    }

    private void bIf() {
        if (this.bvi >= 0 && this.bvi < this.hKp.length && this.bvi < this.hKn.length && this.hKn[this.bvi] != null) {
            if (this.hKp != null) {
                for (int i = 0; i < this.hKp.length; i++) {
                    if (this.hKp[i] != null) {
                        this.hKp[i].akk();
                    }
                }
                if (this.hKp[this.bvi] == null) {
                    this.hKp[this.bvi] = new C0260b(this.bvi);
                }
            }
            String selectedFilter = this.hKq[this.bvi].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hKn[this.bvi].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                    if (this.hKp != null) {
                        this.hKp[this.bvi].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hKp != null) {
                this.hKp[this.bvi].i(this.hKn[this.bvi]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bvi;
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
        this.hKq[i] = new com.baidu.tbadk.coreExtra.view.a(this.hKm, this, str);
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
    public void nS(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        String selectedFilter;
        Bitmap bitmap2 = null;
        if (this.hKn != null) {
            for (int i = 0; i < this.hKn.length; i++) {
                ImageFileInfo imageFileInfo = this.hKn[i];
                if (imageFileInfo != null) {
                    this.hKn[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hKq[i] != null && (selectedFilter = this.hKq[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hKn[i].addPersistAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    C(this.mBitmap);
                }
            } else if (this.hKo != null && this.hKo.bIm() && this.hKt != null && this.hKt.hMD != null) {
                this.hKt.hMD.aZa();
                TbImageView tbImageView = this.hKp[this.bvi].bMF;
                try {
                    bitmap = this.hKt.hMD.bJJ();
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
                        this.hKn[this.bvi].setFilePath(k.b(k.BV(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hKn[this.bvi].clearAllActions();
                        this.hKn[this.bvi].clearPageActions();
                        this.hKn[this.bvi].setIsGif(false);
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
                this.hKn[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0260b {
        private TbImageView bMF;
        private ProgressBar gWb;
        private FrameLayout hKx;
        private com.baidu.tbadk.img.b hKy;
        private int index;

        public C0260b(int i) {
            this.gWb = null;
            this.index = -1;
            this.index = i;
            this.hKx = (FrameLayout) LayoutInflater.from(b.this.hKm.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.bMF = (TbImageView) this.hKx.findViewById(d.g.progress_tb_imageview);
            this.bMF.setClickable(true);
            this.bMF.setDefaultResource(0);
            this.bMF.setDefaultErrorResource(0);
            this.bMF.setDefaultBgResource(0);
            this.bMF.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bMF.setPadding(0, 0, 0, 0);
            this.hKy = new com.baidu.tbadk.img.b();
            this.bMF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hKo != null) {
                        b.this.hKo.bIj();
                    }
                }
            });
            this.gWb = (ProgressBar) this.hKx.findViewById(d.g.progress_tb_imageview_progress);
            this.gWb.setVisibility(8);
        }

        public View getView() {
            return this.hKx;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.bMF != null) {
                int[] j = l.j(aVar.getWidth(), aVar.getHeight(), l.ao(b.this.hKm), (l.aq(b.this.hKm) - l.t(b.this.hKm, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bMF.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = j[0];
                layoutParams.height = j[1];
                this.bMF.setLayoutParams(layoutParams);
                aVar.a(this.bMF);
                if (b.this.hKt != null && b.this.hKt.hMD != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hKt.hMD.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = j[0];
                    layoutParams2.height = j[1];
                    b.this.hKt.hMD.setLayoutParams(layoutParams2);
                }
                if (aVar.sh() != null && !aVar.sh().isRecycled()) {
                    b.this.mBitmap = aVar.sh();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                akk();
                com.baidu.adp.widget.a.a a = this.hKy.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                nT(false);
                this.hKy.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0260b.this.nT(true);
                        C0260b.this.c(imageFileInfo, aVar);
                        if (b.this.hKt != null) {
                            b.this.hKt.bHz();
                        }
                    }
                }, false);
            }
        }

        public void akk() {
            if (this.hKy != null) {
                this.hKy.MH();
            }
            if (this.bMF != null) {
                this.bMF.setImageDrawable(null);
            }
        }

        public boolean bIn() {
            return this.gWb.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nT(boolean z) {
            if (z) {
                if (this.gWb.getVisibility() != 8) {
                    if (b.this.hKo != null) {
                        b.this.hKo.bIl();
                    }
                    this.gWb.setVisibility(8);
                    b.this.hKq[this.index].setCanbeClick(true);
                }
            } else if (this.gWb.getVisibility() != 0) {
                if (b.this.hKo != null) {
                    b.this.hKo.bIk();
                }
                this.gWb.setVisibility(0);
                b.this.hKq[this.index].setCanbeClick(false);
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

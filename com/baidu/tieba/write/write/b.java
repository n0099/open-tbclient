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
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0102a {
    private int bvs;
    private WriteMultiImgsActivity hKb;
    private ImageFileInfo[] hKc;
    private a hKd;
    private C0259b[] hKe;
    private com.baidu.tbadk.coreExtra.view.a[] hKf;
    private int hKg;
    private int hKh;
    private g hKi;
    private com.baidu.tbadk.core.dialog.a hKj;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager qW;

    /* loaded from: classes2.dex */
    public interface a {
        void aa(int i, boolean z);

        void bId();

        void bIf();

        void bIg();

        void bIh();

        boolean bIi();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hKb = null;
        this.hKc = null;
        this.qW = null;
        this.hKd = null;
        this.mCount = 0;
        this.bvs = 0;
        this.hKe = null;
        this.hKf = null;
        this.hKg = 120;
        this.hKh = 120;
        this.mIsFromIm = z;
        this.hKb = writeMultiImgsActivity;
        this.hKi = gVar;
        this.hKg = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hKh = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hKc = new ImageFileInfo[this.mCount];
        this.hKe = new C0259b[this.mCount];
        this.hKf = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hKc[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hKc[i2].addPageAction(com.baidu.tbadk.img.effect.d.aI(this.hKg, this.hKh));
            linkedList.set(i2, this.hKc[i2]);
            this.hKc[i2].mCount = 0;
        }
        this.bvs = i;
        this.qW = viewPager;
        this.hKd = aVar;
        this.qW.setOffscreenPageLimit(1);
        this.qW.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hKe == null || this.bvs >= this.hKe.length || this.hKe[this.bvs] == null || this.hKc == null || this.bvs >= this.hKc.length || this.hKc[this.bvs] == null) ? false : true;
    }

    public boolean bIa() {
        if (this.bvs >= this.hKc.length || this.hKc[this.bvs] == null || !this.hKc[this.bvs].isGif() || this.hKc[this.bvs].mCount > 0) {
            return false;
        }
        this.hKc[this.bvs].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(int i, boolean z) {
        if (bIa()) {
            if (this.hKd != null) {
                this.hKd.aa(i, z);
            }
        } else if (z) {
            xK(i);
        } else if (checkValid()) {
            C0259b c0259b = this.hKe[this.bvs];
            ImageFileInfo imageFileInfo = this.hKc[this.bvs];
            if (c0259b.bIj()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.hZ(i));
                this.hKb.bJb();
                if (this.hKf[this.bvs] != null && this.bvs < this.hKf.length) {
                    String selectedFilter = this.hKf[this.bvs].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                        c0259b.i(cloneWithoutFilterAction);
                        return;
                    }
                    c0259b.i(imageFileInfo);
                    return;
                }
                c0259b.i(imageFileInfo);
            }
        }
    }

    private void xK(final int i) {
        if (this.hKj == null) {
            this.hKj = new com.baidu.tbadk.core.dialog.a(this.hKb);
            this.hKj.fb(d.j.rorate_tip);
            this.hKj.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hKj != null) {
                        b.this.hKj.dismiss();
                    }
                    b.this.hKi.hMs.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIc() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bId() {
                            b.this.hKd.bId();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean D(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bIe() {
                        }
                    });
                    b.this.Z(i, false);
                }
            });
            this.hKj.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hKj != null) {
                        b.this.hKj.dismiss();
                    }
                }
            });
            this.hKj.b(this.hKb.getPageContext());
        }
        this.hKj.AU();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0102a
    public void fI(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hKb.bJb();
                ImageFileInfo cloneWithoutFilterAction = this.hKc[this.bvs].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(str));
                this.hKe[this.bvs].i(cloneWithoutFilterAction);
                return;
            }
            this.hKb.bJc();
            this.hKe[this.bvs].i(this.hKc[this.bvs]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hKe[i] == null) {
            this.hKe[i] = new C0259b(i);
        }
        this.qW.addView(this.hKe[i].getView());
        return this.hKe[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.qW.removeView(this.hKe[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bvs = i;
        bIb();
    }

    private void bIb() {
        if (this.bvs >= 0 && this.bvs < this.hKe.length && this.bvs < this.hKc.length && this.hKc[this.bvs] != null) {
            if (this.hKe != null) {
                for (int i = 0; i < this.hKe.length; i++) {
                    if (this.hKe[i] != null) {
                        this.hKe[i].akk();
                    }
                }
                if (this.hKe[this.bvs] == null) {
                    this.hKe[this.bvs] = new C0259b(this.bvs);
                }
            }
            String selectedFilter = this.hKf[this.bvs].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hKc[this.bvs].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                    if (this.hKe != null) {
                        this.hKe[this.bvs].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hKe != null) {
                this.hKe[this.bvs].i(this.hKc[this.bvs]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bvs;
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
        this.hKf[i] = new com.baidu.tbadk.coreExtra.view.a(this.hKb, this, str);
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
        if (this.hKc != null) {
            for (int i = 0; i < this.hKc.length; i++) {
                ImageFileInfo imageFileInfo = this.hKc[i];
                if (imageFileInfo != null) {
                    this.hKc[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hKf[i] != null && (selectedFilter = this.hKf[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hKc[i].addPersistAction(com.baidu.tbadk.img.effect.a.gU(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    C(this.mBitmap);
                }
            } else if (this.hKd != null && this.hKd.bIi() && this.hKi != null && this.hKi.hMs != null) {
                this.hKi.hMs.aZa();
                TbImageView tbImageView = this.hKe[this.bvs].bMP;
                try {
                    bitmap = this.hKi.hMs.bJF();
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
                        this.hKc[this.bvs].setFilePath(k.b(k.BV(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hKc[this.bvs].clearAllActions();
                        this.hKc[this.bvs].clearPageActions();
                        this.hKc[this.bvs].setIsGif(false);
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
                this.hKc[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0259b {
        private TbImageView bMP;
        private ProgressBar gWa;
        private FrameLayout hKm;
        private com.baidu.tbadk.img.b hKn;
        private int index;

        public C0259b(int i) {
            this.gWa = null;
            this.index = -1;
            this.index = i;
            this.hKm = (FrameLayout) LayoutInflater.from(b.this.hKb.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.bMP = (TbImageView) this.hKm.findViewById(d.g.progress_tb_imageview);
            this.bMP.setClickable(true);
            this.bMP.setDefaultResource(0);
            this.bMP.setDefaultErrorResource(0);
            this.bMP.setDefaultBgResource(0);
            this.bMP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bMP.setPadding(0, 0, 0, 0);
            this.hKn = new com.baidu.tbadk.img.b();
            this.bMP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hKd != null) {
                        b.this.hKd.bIf();
                    }
                }
            });
            this.gWa = (ProgressBar) this.hKm.findViewById(d.g.progress_tb_imageview_progress);
            this.gWa.setVisibility(8);
        }

        public View getView() {
            return this.hKm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.bMP != null) {
                int[] j = l.j(aVar.getWidth(), aVar.getHeight(), l.ao(b.this.hKb), (l.aq(b.this.hKb) - l.t(b.this.hKb, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bMP.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = j[0];
                layoutParams.height = j[1];
                this.bMP.setLayoutParams(layoutParams);
                aVar.a(this.bMP);
                if (b.this.hKi != null && b.this.hKi.hMs != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hKi.hMs.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = j[0];
                    layoutParams2.height = j[1];
                    b.this.hKi.hMs.setLayoutParams(layoutParams2);
                }
                if (aVar.sh() != null && !aVar.sh().isRecycled()) {
                    b.this.mBitmap = aVar.sh();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                akk();
                com.baidu.adp.widget.a.a a = this.hKn.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                nO(false);
                this.hKn.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0259b.this.nO(true);
                        C0259b.this.c(imageFileInfo, aVar);
                        if (b.this.hKi != null) {
                            b.this.hKi.bHv();
                        }
                    }
                }, false);
            }
        }

        public void akk() {
            if (this.hKn != null) {
                this.hKn.MH();
            }
            if (this.bMP != null) {
                this.bMP.setImageDrawable(null);
            }
        }

        public boolean bIj() {
            return this.gWa.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nO(boolean z) {
            if (z) {
                if (this.gWa.getVisibility() != 8) {
                    if (b.this.hKd != null) {
                        b.this.hKd.bIh();
                    }
                    this.gWa.setVisibility(8);
                    b.this.hKf[this.index].setCanbeClick(true);
                }
            } else if (this.gWa.getVisibility() != 0) {
                if (b.this.hKd != null) {
                    b.this.hKd.bIg();
                }
                this.gWa.setVisibility(0);
                b.this.hKf[this.index].setCanbeClick(false);
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

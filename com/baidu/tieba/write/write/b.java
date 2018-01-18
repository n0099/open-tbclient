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
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0078a {
    private int bsW;
    private WriteMultiImgsActivity hIl;
    private ImageFileInfo[] hIm;
    private a hIn;
    private C0176b[] hIo;
    private com.baidu.tbadk.coreExtra.view.a[] hIp;
    private int hIq;
    private int hIr;
    private g hIs;
    private com.baidu.tbadk.core.dialog.a hIt;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager qW;

    /* loaded from: classes2.dex */
    public interface a {
        void U(int i, boolean z);

        void bHn();

        void bHp();

        void bHq();

        void bHr();

        boolean bHs();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, g gVar, boolean z) {
        this.hIl = null;
        this.hIm = null;
        this.qW = null;
        this.hIn = null;
        this.mCount = 0;
        this.bsW = 0;
        this.hIo = null;
        this.hIp = null;
        this.hIq = 120;
        this.hIr = 120;
        this.mIsFromIm = z;
        this.hIl = writeMultiImgsActivity;
        this.hIs = gVar;
        this.hIq = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.hIr = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.hIm = new ImageFileInfo[this.mCount];
        this.hIo = new C0176b[this.mCount];
        this.hIp = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            a(linkedList.get(i2), i2);
            this.hIm[i2] = linkedList.get(i2).cloneWithoutFilterAction(true);
            this.hIm[i2].addPageAction(com.baidu.tbadk.img.effect.d.aI(this.hIq, this.hIr));
            linkedList.set(i2, this.hIm[i2]);
            this.hIm[i2].mCount = 0;
        }
        this.bsW = i;
        this.qW = viewPager;
        this.hIn = aVar;
        this.qW.setOffscreenPageLimit(1);
        this.qW.setOnPageChangeListener(this);
    }

    private boolean checkValid() {
        return (this.hIo == null || this.bsW >= this.hIo.length || this.hIo[this.bsW] == null || this.hIm == null || this.bsW >= this.hIm.length || this.hIm[this.bsW] == null) ? false : true;
    }

    public boolean bHk() {
        if (this.bsW >= this.hIm.length || this.hIm[this.bsW] == null || !this.hIm[this.bsW].isGif() || this.hIm[this.bsW].mCount > 0) {
            return false;
        }
        this.hIm[this.bsW].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        if (bHk()) {
            if (this.hIn != null) {
                this.hIn.U(i, z);
            }
        } else if (z) {
            xL(i);
        } else if (checkValid()) {
            C0176b c0176b = this.hIo[this.bsW];
            ImageFileInfo imageFileInfo = this.hIm[this.bsW];
            if (c0176b.bHt()) {
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.ib(i));
                this.hIl.bIl();
                if (this.hIp[this.bsW] != null && this.bsW < this.hIp.length) {
                    String selectedFilter = this.hIp[this.bsW].getSelectedFilter();
                    if (selectedFilter != null && !selectedFilter.equals("normal")) {
                        ImageFileInfo cloneWithoutFilterAction = imageFileInfo.cloneWithoutFilterAction(false);
                        cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gD(selectedFilter));
                        c0176b.i(cloneWithoutFilterAction);
                        return;
                    }
                    c0176b.i(imageFileInfo);
                    return;
                }
                c0176b.i(imageFileInfo);
            }
        }
    }

    private void xL(final int i) {
        if (this.hIt == null) {
            this.hIt = new com.baidu.tbadk.core.dialog.a(this.hIl);
            this.hIt.fb(d.j.rorate_tip);
            this.hIt.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hIt != null) {
                        b.this.hIt.dismiss();
                    }
                    b.this.hIs.hKA.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.b.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHm() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHn() {
                            b.this.hIn.bHn();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean A(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void bHo() {
                        }
                    });
                    b.this.T(i, false);
                }
            });
            this.hIt.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (b.this.hIt != null) {
                        b.this.hIt.dismiss();
                    }
                }
            });
            this.hIt.b(this.hIl.getPageContext());
        }
        this.hIt.AA();
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0078a
    public void fr(String str) {
        if (checkValid()) {
            if (str != null && !str.equals("normal")) {
                this.hIl.bIl();
                ImageFileInfo cloneWithoutFilterAction = this.hIm[this.bsW].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gD(str));
                this.hIo[this.bsW].i(cloneWithoutFilterAction);
                return;
            }
            this.hIl.bIm();
            this.hIo[this.bsW].i(this.hIm[this.bsW]);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hIo[i] == null) {
            this.hIo[i] = new C0176b(i);
        }
        this.qW.addView(this.hIo[i].getView());
        return this.hIo[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.qW.removeView(this.hIo[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bsW = i;
        bHl();
    }

    private void bHl() {
        if (this.bsW >= 0 && this.bsW < this.hIo.length && this.bsW < this.hIm.length && this.hIm[this.bsW] != null) {
            if (this.hIo != null) {
                for (int i = 0; i < this.hIo.length; i++) {
                    if (this.hIo[i] != null) {
                        this.hIo[i].ajh();
                    }
                }
                if (this.hIo[this.bsW] == null) {
                    this.hIo[this.bsW] = new C0176b(this.bsW);
                }
            }
            String selectedFilter = this.hIp[this.bsW].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.hIm[this.bsW].cloneWithoutFilterAction(false);
                if (cloneWithoutFilterAction != null) {
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gD(selectedFilter));
                    if (this.hIo != null) {
                        this.hIo[this.bsW].i(cloneWithoutFilterAction);
                    }
                }
            } else if (this.hIo != null) {
                this.hIo[this.bsW].i(this.hIm[this.bsW]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bsW;
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
        this.hIp[i] = new com.baidu.tbadk.coreExtra.view.a(this.hIl, this, str);
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
    public void nD(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        String selectedFilter;
        Bitmap bitmap2 = null;
        if (this.hIm != null) {
            for (int i = 0; i < this.hIm.length; i++) {
                ImageFileInfo imageFileInfo = this.hIm[i];
                if (imageFileInfo != null) {
                    this.hIm[i].applayRotatePageActionToPersistAction(imageFileInfo);
                    if (this.hIp[i] != null && (selectedFilter = this.hIp[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                        this.hIm[i].addPersistAction(com.baidu.tbadk.img.effect.a.gD(selectedFilter));
                    }
                }
            }
            if (!checkValid()) {
                if (!z && this.mIsFromIm) {
                    z(this.mBitmap);
                }
            } else if (this.hIn != null && this.hIn.bHs() && this.hIs != null && this.hIs.hKA != null) {
                this.hIs.hKA.aXm();
                TbImageView tbImageView = this.hIo[this.bsW].bKD;
                try {
                    bitmap = this.hIs.hKA.bIQ();
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
                        this.hIm[this.bsW].setFilePath(k.b(k.BB(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.hIm[this.bsW].clearAllActions();
                        this.hIm[this.bsW].clearPageActions();
                        this.hIm[this.bsW].setIsGif(false);
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
                this.hIm[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0176b {
        private TbImageView bKD;
        private ProgressBar gTn;
        private FrameLayout hIw;
        private com.baidu.tbadk.img.b hIx;
        private int index;

        public C0176b(int i) {
            this.gTn = null;
            this.index = -1;
            this.index = i;
            this.hIw = (FrameLayout) LayoutInflater.from(b.this.hIl.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.bKD = (TbImageView) this.hIw.findViewById(d.g.progress_tb_imageview);
            this.bKD.setClickable(true);
            this.bKD.setDefaultResource(0);
            this.bKD.setDefaultErrorResource(0);
            this.bKD.setDefaultBgResource(0);
            this.bKD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bKD.setPadding(0, 0, 0, 0);
            this.hIx = new com.baidu.tbadk.img.b();
            this.bKD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hIn != null) {
                        b.this.hIn.bHp();
                    }
                }
            });
            this.gTn = (ProgressBar) this.hIw.findViewById(d.g.progress_tb_imageview_progress);
            this.gTn.setVisibility(8);
        }

        public View getView() {
            return this.hIw;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
            if (aVar != null && this.bKD != null) {
                int[] j = l.j(aVar.getWidth(), aVar.getHeight(), l.ao(b.this.hIl), (l.aq(b.this.hIl) - l.s(b.this.hIl, d.e.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bKD.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = j[0];
                layoutParams.height = j[1];
                this.bKD.setLayoutParams(layoutParams);
                aVar.a(this.bKD);
                if (b.this.hIs != null && b.this.hIs.hKA != null && aVar != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) b.this.hIs.hKA.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = j[0];
                    layoutParams2.height = j[1];
                    b.this.hIs.hKA.setLayoutParams(layoutParams2);
                }
                if (aVar.si() != null && !aVar.si().isRecycled()) {
                    b.this.mBitmap = aVar.si();
                }
            }
        }

        public void i(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                ajh();
                com.baidu.adp.widget.a.a a = this.hIx.a(imageFileInfo, false);
                if (a != null) {
                    c(imageFileInfo, a);
                    return;
                }
                nE(false);
                this.hIx.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        C0176b.this.nE(true);
                        C0176b.this.c(imageFileInfo, aVar);
                        if (b.this.hIs != null) {
                            b.this.hIs.bGF();
                        }
                    }
                }, false);
            }
        }

        public void ajh() {
            if (this.hIx != null) {
                this.hIx.LZ();
            }
            if (this.bKD != null) {
                this.bKD.setImageDrawable(null);
            }
        }

        public boolean bHt() {
            return this.gTn.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nE(boolean z) {
            if (z) {
                if (this.gTn.getVisibility() != 8) {
                    if (b.this.hIn != null) {
                        b.this.hIn.bHr();
                    }
                    this.gTn.setVisibility(8);
                    b.this.hIp[this.index].setCanbeClick(true);
                }
            } else if (this.gTn.getVisibility() != 0) {
                if (b.this.hIn != null) {
                    b.this.hIn.bHq();
                }
                this.gTn.setVisibility(0);
                b.this.hIp[this.index].setCanbeClick(false);
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

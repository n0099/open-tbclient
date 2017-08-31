package com.baidu.tieba.write.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.img.effect.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0052a {
    private int aEq;
    private WriteMultiImgsActivity gFP;
    private ImageFileInfo[] gFQ;
    private a gFR;
    private C0133b[] gFS;
    private com.baidu.tbadk.coreExtra.view.a[] gFT;
    private int gFU;
    private int gFV;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bzA();

        void bzB();

        void bzC();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gFP = null;
        this.gFQ = null;
        this.mViewPager = null;
        this.gFR = null;
        this.mCount = 0;
        this.aEq = 0;
        this.gFS = null;
        this.gFT = null;
        this.gFU = 120;
        this.gFV = 120;
        this.gFP = writeMultiImgsActivity;
        this.gFU = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gFV = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gFQ = new ImageFileInfo[this.mCount];
        this.gFS = new C0133b[this.mCount];
        this.gFT = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gFQ[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gFQ[i3].addPageAction(com.baidu.tbadk.img.effect.d.J(this.gFU, this.gFV));
                linkedList.set(i3, this.gFQ[i3]);
                i2 = i3 + 1;
            } else {
                this.aEq = i;
                this.mViewPager = viewPager;
                this.gFR = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uM(int i) {
        if (this.gFS[this.aEq].bzD()) {
            this.gFQ[this.aEq].addPageAction(e.eY(i));
            this.gFP.bAo();
            if (this.gFT[this.aEq] != null) {
                String selectedFilter = this.gFT[this.aEq].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.gFQ[this.aEq].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gq(selectedFilter));
                    this.gFS[this.aEq].j(cloneWithoutFilterAction);
                    return;
                }
                this.gFS[this.aEq].j(this.gFQ[this.aEq]);
                return;
            }
            this.gFS[this.aEq].j(this.gFQ[this.aEq]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0052a
    public void ff(String str) {
        if (str != null && !str.equals("normal")) {
            this.gFP.bAo();
            ImageFileInfo cloneWithoutFilterAction = this.gFQ[this.aEq].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gq(str));
            this.gFS[this.aEq].j(cloneWithoutFilterAction);
            return;
        }
        this.gFP.bAp();
        this.gFS[this.aEq].j(this.gFQ[this.aEq]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gFS[i] == null) {
            this.gFS[i] = new C0133b(i);
        }
        this.mViewPager.addView(this.gFS[i].getView());
        return this.gFS[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gFS[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEq = i;
        bzy();
        if (this.gFR != null) {
            this.gFR.a(this.gFT[i], i);
        }
    }

    private void bzy() {
        if (this.aEq >= 0) {
            if (this.gFS != null) {
                for (int i = 0; i < this.gFS.length; i++) {
                    if (this.gFS[i] != null) {
                        this.gFS[i].VT();
                    }
                }
                if (this.gFS[this.aEq] == null) {
                    this.gFS[this.aEq] = new C0133b(this.aEq);
                }
            }
            String selectedFilter = this.gFT[this.aEq].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.gFQ[this.aEq].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gq(selectedFilter));
                if (this.gFS != null) {
                    this.gFS[this.aEq].j(cloneWithoutFilterAction);
                }
            } else if (this.gFS != null) {
                this.gFS[this.aEq].j(this.gFQ[this.aEq]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEq;
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
        this.gFT[i] = new com.baidu.tbadk.coreExtra.view.a(this.gFP, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bzz() {
        String selectedFilter;
        for (int i = 0; i < this.gFQ.length; i++) {
            this.gFQ[i].applayRotatePageActionToPersistAction();
            if (this.gFT[i] != null && (selectedFilter = this.gFT[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.gFQ[i].addPersistAction(com.baidu.tbadk.img.effect.a.gq(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0133b {
        private TbImageView aSE;
        private ProgressBar fqp;
        private FrameLayout gFW;
        private com.baidu.tbadk.img.b gFX;
        private int index;

        public C0133b(int i) {
            this.fqp = null;
            this.index = -1;
            this.index = i;
            this.gFW = (FrameLayout) LayoutInflater.from(b.this.gFP.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aSE = (TbImageView) this.gFW.findViewById(d.h.progress_tb_imageview);
            this.aSE.setClickable(true);
            this.aSE.setDefaultResource(0);
            this.aSE.setDefaultErrorResource(0);
            this.aSE.setDefaultBgResource(0);
            this.aSE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gFX = new com.baidu.tbadk.img.b();
            this.aSE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gFR != null) {
                        b.this.gFR.bzA();
                    }
                }
            });
            this.fqp = (ProgressBar) this.gFW.findViewById(d.h.progress_tb_imageview_progress);
            this.fqp.setVisibility(8);
        }

        public View getView() {
            return this.gFW;
        }

        public void j(ImageFileInfo imageFileInfo) {
            VT();
            this.aSE.setDefaultResource(0);
            this.aSE.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gFX.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aSE);
                return;
            }
            np(false);
            this.gFX.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    C0133b.this.np(true);
                    if (aVar != null) {
                        aVar.a(C0133b.this.aSE);
                    } else {
                        C0133b.this.aSE.setDefaultResource(d.g.image_group_load_f);
                    }
                }
            }, false);
        }

        public void VT() {
            if (this.gFX != null) {
                this.gFX.EF();
            }
            if (this.aSE != null) {
                this.aSE.setImageDrawable(null);
            }
        }

        public boolean bzD() {
            return this.fqp.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void np(boolean z) {
            if (z) {
                if (this.fqp.getVisibility() != 8) {
                    if (b.this.gFR != null) {
                        b.this.gFR.bzC();
                    }
                    this.fqp.setVisibility(8);
                    b.this.gFT[this.index].setCanbeClick(true);
                }
            } else if (this.fqp.getVisibility() != 0) {
                if (b.this.gFR != null) {
                    b.this.gFR.bzB();
                }
                this.fqp.setVisibility(0);
                b.this.gFT[this.index].setCanbeClick(false);
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

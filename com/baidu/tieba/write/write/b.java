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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0052a {
    private ViewPager aDT;
    private int aEm;
    private a gWA;
    private C0149b[] gWB;
    private com.baidu.tbadk.coreExtra.view.a[] gWC;
    private int gWD;
    private int gWE;
    private WriteMultiImgsActivity gWy;
    private ImageFileInfo[] gWz;
    private int mCount;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bEC();

        void bED();

        void bEE();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gWy = null;
        this.gWz = null;
        this.aDT = null;
        this.gWA = null;
        this.mCount = 0;
        this.aEm = 0;
        this.gWB = null;
        this.gWC = null;
        this.gWD = 120;
        this.gWE = 120;
        this.gWy = writeMultiImgsActivity;
        this.gWD = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.gWE = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gWz = new ImageFileInfo[this.mCount];
        this.gWB = new C0149b[this.mCount];
        this.gWC = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gWz[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gWz[i3].addPageAction(com.baidu.tbadk.img.effect.d.K(this.gWD, this.gWE));
                linkedList.set(i3, this.gWz[i3]);
                i2 = i3 + 1;
            } else {
                this.aEm = i;
                this.aDT = viewPager;
                this.gWA = aVar;
                this.aDT.setOffscreenPageLimit(1);
                this.aDT.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vI(int i) {
        if (this.gWB[this.aEm].bEF()) {
            this.gWz[this.aEm].addPageAction(com.baidu.tbadk.img.effect.e.fi(i));
            this.gWy.bFq();
            if (this.gWC[this.aEm] != null) {
                String selectedFilter = this.gWC[this.aEm].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.gWz[this.aEm].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gv(selectedFilter));
                    this.gWB[this.aEm].j(cloneWithoutFilterAction);
                    return;
                }
                this.gWB[this.aEm].j(this.gWz[this.aEm]);
                return;
            }
            this.gWB[this.aEm].j(this.gWz[this.aEm]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0052a
    public void ff(String str) {
        if (str != null && !str.equals("normal")) {
            this.gWy.bFq();
            ImageFileInfo cloneWithoutFilterAction = this.gWz[this.aEm].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gv(str));
            this.gWB[this.aEm].j(cloneWithoutFilterAction);
            return;
        }
        this.gWy.bFr();
        this.gWB[this.aEm].j(this.gWz[this.aEm]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gWB[i] == null) {
            this.gWB[i] = new C0149b(i);
        }
        this.aDT.addView(this.gWB[i].getView());
        return this.gWB[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aDT.removeView(this.gWB[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEm = i;
        bEA();
        if (this.gWA != null) {
            this.gWA.a(this.gWC[i], i);
        }
    }

    private void bEA() {
        if (this.aEm >= 0) {
            if (this.gWB != null) {
                for (int i = 0; i < this.gWB.length; i++) {
                    if (this.gWB[i] != null) {
                        this.gWB[i].YO();
                    }
                }
                if (this.gWB[this.aEm] == null) {
                    this.gWB[this.aEm] = new C0149b(this.aEm);
                }
            }
            String selectedFilter = this.gWC[this.aEm].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.gWz[this.aEm].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gv(selectedFilter));
                if (this.gWB != null) {
                    this.gWB[this.aEm].j(cloneWithoutFilterAction);
                }
            } else if (this.gWB != null) {
                this.gWB[this.aEm].j(this.gWz[this.aEm]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEm;
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
        this.gWC[i] = new com.baidu.tbadk.coreExtra.view.a(this.gWy, this, str);
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
    public void bEB() {
        String selectedFilter;
        for (int i = 0; i < this.gWz.length; i++) {
            this.gWz[i].applayRotatePageActionToPersistAction();
            if (this.gWC[i] != null && (selectedFilter = this.gWC[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.gWz[i].addPersistAction(com.baidu.tbadk.img.effect.a.gv(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0149b {
        private TbImageView aTz;
        private ProgressBar fwj;
        private FrameLayout gWF;
        private com.baidu.tbadk.img.b gWG;
        private int index;

        public C0149b(int i) {
            this.fwj = null;
            this.index = -1;
            this.index = i;
            this.gWF = (FrameLayout) LayoutInflater.from(b.this.gWy.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.aTz = (TbImageView) this.gWF.findViewById(d.g.progress_tb_imageview);
            this.aTz.setClickable(true);
            this.aTz.setDefaultResource(0);
            this.aTz.setDefaultErrorResource(0);
            this.aTz.setDefaultBgResource(0);
            this.aTz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gWG = new com.baidu.tbadk.img.b();
            this.aTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gWA != null) {
                        b.this.gWA.bEC();
                    }
                }
            });
            this.fwj = (ProgressBar) this.gWF.findViewById(d.g.progress_tb_imageview_progress);
            this.fwj.setVisibility(8);
        }

        public View getView() {
            return this.gWF;
        }

        public void j(ImageFileInfo imageFileInfo) {
            YO();
            this.aTz.setDefaultResource(0);
            this.aTz.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gWG.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aTz);
                return;
            }
            nD(false);
            this.gWG.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    C0149b.this.nD(true);
                    if (aVar != null) {
                        aVar.a(C0149b.this.aTz);
                    } else {
                        C0149b.this.aTz.setDefaultResource(d.f.image_group_load_f);
                    }
                }
            }, false);
        }

        public void YO() {
            if (this.gWG != null) {
                this.gWG.ED();
            }
            if (this.aTz != null) {
                this.aTz.setImageDrawable(null);
            }
        }

        public boolean bEF() {
            return this.fwj.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nD(boolean z) {
            if (z) {
                if (this.fwj.getVisibility() != 8) {
                    if (b.this.gWA != null) {
                        b.this.gWA.bEE();
                    }
                    this.fwj.setVisibility(8);
                    b.this.gWC[this.index].setCanbeClick(true);
                }
            } else if (this.fwj.getVisibility() != 0) {
                if (b.this.gWA != null) {
                    b.this.gWA.bED();
                }
                this.fwj.setVisibility(0);
                b.this.gWC[this.index].setCanbeClick(false);
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

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
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0051a {
    private int aEn;
    private WriteMultiImgsActivity gGI;
    private ImageFileInfo[] gGJ;
    private a gGK;
    private C0132b[] gGL;
    private com.baidu.tbadk.coreExtra.view.a[] gGM;
    private int gGN;
    private int gGO;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bzL();

        void bzM();

        void bzN();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gGI = null;
        this.gGJ = null;
        this.mViewPager = null;
        this.gGK = null;
        this.mCount = 0;
        this.aEn = 0;
        this.gGL = null;
        this.gGM = null;
        this.gGN = 120;
        this.gGO = 120;
        this.gGI = writeMultiImgsActivity;
        this.gGN = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gGO = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gGJ = new ImageFileInfo[this.mCount];
        this.gGL = new C0132b[this.mCount];
        this.gGM = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gGJ[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gGJ[i3].addPageAction(com.baidu.tbadk.img.effect.d.J(this.gGN, this.gGO));
                linkedList.set(i3, this.gGJ[i3]);
                i2 = i3 + 1;
            } else {
                this.aEn = i;
                this.mViewPager = viewPager;
                this.gGK = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uO(int i) {
        if (this.gGL[this.aEn].bzO()) {
            this.gGJ[this.aEn].addPageAction(e.eY(i));
            this.gGI.bAz();
            if (this.gGM[this.aEn] != null) {
                String selectedFilter = this.gGM[this.aEn].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.gGJ[this.aEn].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gq(selectedFilter));
                    this.gGL[this.aEn].j(cloneWithoutFilterAction);
                    return;
                }
                this.gGL[this.aEn].j(this.gGJ[this.aEn]);
                return;
            }
            this.gGL[this.aEn].j(this.gGJ[this.aEn]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0051a
    public void ff(String str) {
        if (str != null && !str.equals("normal")) {
            this.gGI.bAz();
            ImageFileInfo cloneWithoutFilterAction = this.gGJ[this.aEn].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gq(str));
            this.gGL[this.aEn].j(cloneWithoutFilterAction);
            return;
        }
        this.gGI.bAA();
        this.gGL[this.aEn].j(this.gGJ[this.aEn]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gGL[i] == null) {
            this.gGL[i] = new C0132b(i);
        }
        this.mViewPager.addView(this.gGL[i].getView());
        return this.gGL[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gGL[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEn = i;
        bzJ();
        if (this.gGK != null) {
            this.gGK.a(this.gGM[i], i);
        }
    }

    private void bzJ() {
        if (this.aEn >= 0) {
            if (this.gGL != null) {
                for (int i = 0; i < this.gGL.length; i++) {
                    if (this.gGL[i] != null) {
                        this.gGL[i].We();
                    }
                }
                if (this.gGL[this.aEn] == null) {
                    this.gGL[this.aEn] = new C0132b(this.aEn);
                }
            }
            String selectedFilter = this.gGM[this.aEn].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.gGJ[this.aEn].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gq(selectedFilter));
                if (this.gGL != null) {
                    this.gGL[this.aEn].j(cloneWithoutFilterAction);
                }
            } else if (this.gGL != null) {
                this.gGL[this.aEn].j(this.gGJ[this.aEn]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEn;
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
        this.gGM[i] = new com.baidu.tbadk.coreExtra.view.a(this.gGI, this, str);
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
    public void bzK() {
        String selectedFilter;
        for (int i = 0; i < this.gGJ.length; i++) {
            this.gGJ[i].applayRotatePageActionToPersistAction();
            if (this.gGM[i] != null && (selectedFilter = this.gGM[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.gGJ[i].addPersistAction(com.baidu.tbadk.img.effect.a.gq(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0132b {
        private TbImageView aSB;
        private ProgressBar fri;
        private FrameLayout gGP;
        private com.baidu.tbadk.img.b gGQ;
        private int index;

        public C0132b(int i) {
            this.fri = null;
            this.index = -1;
            this.index = i;
            this.gGP = (FrameLayout) LayoutInflater.from(b.this.gGI.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aSB = (TbImageView) this.gGP.findViewById(d.h.progress_tb_imageview);
            this.aSB.setClickable(true);
            this.aSB.setDefaultResource(0);
            this.aSB.setDefaultErrorResource(0);
            this.aSB.setDefaultBgResource(0);
            this.aSB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gGQ = new com.baidu.tbadk.img.b();
            this.aSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gGK != null) {
                        b.this.gGK.bzL();
                    }
                }
            });
            this.fri = (ProgressBar) this.gGP.findViewById(d.h.progress_tb_imageview_progress);
            this.fri.setVisibility(8);
        }

        public View getView() {
            return this.gGP;
        }

        public void j(ImageFileInfo imageFileInfo) {
            We();
            this.aSB.setDefaultResource(0);
            this.aSB.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gGQ.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aSB);
                return;
            }
            nq(false);
            this.gGQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    C0132b.this.nq(true);
                    if (aVar != null) {
                        aVar.a(C0132b.this.aSB);
                    } else {
                        C0132b.this.aSB.setDefaultResource(d.g.image_group_load_f);
                    }
                }
            }, false);
        }

        public void We() {
            if (this.gGQ != null) {
                this.gGQ.EF();
            }
            if (this.aSB != null) {
                this.aSB.setImageDrawable(null);
            }
        }

        public boolean bzO() {
            return this.fri.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nq(boolean z) {
            if (z) {
                if (this.fri.getVisibility() != 8) {
                    if (b.this.gGK != null) {
                        b.this.gGK.bzN();
                    }
                    this.fri.setVisibility(8);
                    b.this.gGM[this.index].setCanbeClick(true);
                }
            } else if (this.fri.getVisibility() != 0) {
                if (b.this.gGK != null) {
                    b.this.gGK.bzM();
                }
                this.fri.setVisibility(0);
                b.this.gGM[this.index].setCanbeClick(false);
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

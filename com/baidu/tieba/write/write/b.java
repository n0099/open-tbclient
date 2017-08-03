package com.baidu.tieba.write.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.img.effect.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener, a.InterfaceC0049a {
    private int aDH;
    private WriteMultiImgsActivity gEh;
    private ImageFileInfo[] gEi;
    private a gEj;
    private C0130b[] gEk;
    private com.baidu.tbadk.coreExtra.view.a[] gEl;
    private int gEm;
    private int gEn;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bzE();

        void bzF();

        void bzG();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gEh = null;
        this.gEi = null;
        this.mViewPager = null;
        this.gEj = null;
        this.mCount = 0;
        this.aDH = 0;
        this.gEk = null;
        this.gEl = null;
        this.gEm = 120;
        this.gEn = 120;
        this.gEh = writeMultiImgsActivity;
        this.gEm = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gEn = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gEi = new ImageFileInfo[this.mCount];
        this.gEk = new C0130b[this.mCount];
        this.gEl = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gEi[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gEi[i3].addPageAction(com.baidu.tbadk.img.effect.d.L(this.gEm, this.gEn));
                linkedList.set(i3, this.gEi[i3]);
                i2 = i3 + 1;
            } else {
                this.aDH = i;
                this.mViewPager = viewPager;
                this.gEj = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uB(int i) {
        if (this.gEk[this.aDH].bzH()) {
            this.gEi[this.aDH].addPageAction(e.eW(i));
            this.gEh.bAs();
            if (this.gEl[this.aDH] != null) {
                String selectedFilter = this.gEl[this.aDH].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.gEi[this.aDH].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gm(selectedFilter));
                    this.gEk[this.aDH].j(cloneWithoutFilterAction);
                    return;
                }
                this.gEk[this.aDH].j(this.gEi[this.aDH]);
                return;
            }
            this.gEk[this.aDH].j(this.gEi[this.aDH]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0049a
    public void fa(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.gEh.bAs();
            ImageFileInfo cloneWithoutFilterAction = this.gEi[this.aDH].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gm(str));
            this.gEk[this.aDH].j(cloneWithoutFilterAction);
            return;
        }
        this.gEh.bAt();
        this.gEk[this.aDH].j(this.gEi[this.aDH]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gEk[i] == null) {
            this.gEk[i] = new C0130b(i);
        }
        this.mViewPager.addView(this.gEk[i].getView());
        return this.gEk[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gEk[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aDH = i;
        bzC();
        if (this.gEj != null) {
            this.gEj.a(this.gEl[i], i);
        }
    }

    private void bzC() {
        if (this.aDH >= 0) {
            if (this.gEk != null) {
                for (int i = 0; i < this.gEk.length; i++) {
                    if (this.gEk[i] != null) {
                        this.gEk[i].Uu();
                    }
                }
                if (this.gEk[this.aDH] == null) {
                    this.gEk[this.aDH] = new C0130b(this.aDH);
                }
            }
            String selectedFilter = this.gEl[this.aDH].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.gEi[this.aDH].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gm(selectedFilter));
                if (this.gEk != null) {
                    this.gEk[this.aDH].j(cloneWithoutFilterAction);
                }
            } else if (this.gEk != null) {
                this.gEk[this.aDH].j(this.gEi[this.aDH]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aDH;
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
        this.gEl[i] = new com.baidu.tbadk.coreExtra.view.a(this.gEh, this, str);
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
    public void bzD() {
        String selectedFilter;
        for (int i = 0; i < this.gEi.length; i++) {
            this.gEi[i].applayRotatePageActionToPersistAction();
            if (this.gEl[i] != null && (selectedFilter = this.gEl[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.gEi[i].addPersistAction(com.baidu.tbadk.img.effect.a.gm(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130b {
        private TbImageView aRG;
        private ProgressBar foM;
        private FrameLayout gEo;
        private com.baidu.tbadk.img.b gEp;
        private int index;

        public C0130b(int i) {
            this.foM = null;
            this.index = -1;
            this.index = i;
            this.gEo = (FrameLayout) LayoutInflater.from(b.this.gEh.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aRG = (TbImageView) this.gEo.findViewById(d.h.progress_tb_imageview);
            this.aRG.setClickable(true);
            this.aRG.setDefaultResource(0);
            this.aRG.setDefaultErrorResource(0);
            this.aRG.setDefaultBgResource(0);
            this.aRG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gEp = new com.baidu.tbadk.img.b();
            this.aRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gEj != null) {
                        b.this.gEj.bzE();
                    }
                }
            });
            this.foM = (ProgressBar) this.gEo.findViewById(d.h.progress_tb_imageview_progress);
            this.foM.setVisibility(8);
        }

        public View getView() {
            return this.gEo;
        }

        public void j(ImageFileInfo imageFileInfo) {
            Uu();
            this.aRG.setDefaultResource(0);
            this.aRG.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gEp.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aRG);
                return;
            }
            ng(false);
            this.gEp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    C0130b.this.ng(true);
                    if (aVar != null) {
                        aVar.e(C0130b.this.aRG);
                    } else {
                        C0130b.this.aRG.setDefaultResource(d.g.image_group_load_f);
                    }
                }
            }, false);
        }

        public void Uu() {
            if (this.gEp != null) {
                this.gEp.Ez();
            }
            if (this.aRG != null) {
                this.aRG.setImageDrawable(null);
            }
        }

        public boolean bzH() {
            return this.foM.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ng(boolean z) {
            if (z) {
                if (this.foM.getVisibility() != 8) {
                    if (b.this.gEj != null) {
                        b.this.gEj.bzG();
                    }
                    this.foM.setVisibility(8);
                    b.this.gEl[this.index].setCanbeClick(true);
                }
            } else if (this.foM.getVisibility() != 0) {
                if (b.this.gEj != null) {
                    b.this.gEj.bzF();
                }
                this.foM.setVisibility(0);
                b.this.gEl[this.index].setCanbeClick(false);
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

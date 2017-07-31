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
    private int aEX;
    private WriteMultiImgsActivity gFs;
    private ImageFileInfo[] gFt;
    private a gFu;
    private C0129b[] gFv;
    private com.baidu.tbadk.coreExtra.view.a[] gFw;
    private int gFx;
    private int gFy;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bzL();

        void bzM();

        void bzN();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gFs = null;
        this.gFt = null;
        this.mViewPager = null;
        this.gFu = null;
        this.mCount = 0;
        this.aEX = 0;
        this.gFv = null;
        this.gFw = null;
        this.gFx = 120;
        this.gFy = 120;
        this.gFs = writeMultiImgsActivity;
        this.gFx = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gFy = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gFt = new ImageFileInfo[this.mCount];
        this.gFv = new C0129b[this.mCount];
        this.gFw = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gFt[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gFt[i3].addPageAction(com.baidu.tbadk.img.effect.d.M(this.gFx, this.gFy));
                linkedList.set(i3, this.gFt[i3]);
                i2 = i3 + 1;
            } else {
                this.aEX = i;
                this.mViewPager = viewPager;
                this.gFu = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uB(int i) {
        if (this.gFv[this.aEX].bzO()) {
            this.gFt[this.aEX].addPageAction(e.eY(i));
            this.gFs.bAz();
            if (this.gFw[this.aEX] != null) {
                String selectedFilter = this.gFw[this.aEX].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.gFt[this.aEX].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gr(selectedFilter));
                    this.gFv[this.aEX].j(cloneWithoutFilterAction);
                    return;
                }
                this.gFv[this.aEX].j(this.gFt[this.aEX]);
                return;
            }
            this.gFv[this.aEX].j(this.gFt[this.aEX]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0049a
    public void fg(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.gFs.bAz();
            ImageFileInfo cloneWithoutFilterAction = this.gFt[this.aEX].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gr(str));
            this.gFv[this.aEX].j(cloneWithoutFilterAction);
            return;
        }
        this.gFs.bAA();
        this.gFv[this.aEX].j(this.gFt[this.aEX]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gFv[i] == null) {
            this.gFv[i] = new C0129b(i);
        }
        this.mViewPager.addView(this.gFv[i].getView());
        return this.gFv[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gFv[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEX = i;
        bzJ();
        if (this.gFu != null) {
            this.gFu.a(this.gFw[i], i);
        }
    }

    private void bzJ() {
        if (this.aEX >= 0) {
            if (this.gFv != null) {
                for (int i = 0; i < this.gFv.length; i++) {
                    if (this.gFv[i] != null) {
                        this.gFv[i].Uz();
                    }
                }
                if (this.gFv[this.aEX] == null) {
                    this.gFv[this.aEX] = new C0129b(this.aEX);
                }
            }
            String selectedFilter = this.gFw[this.aEX].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.gFt[this.aEX].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gr(selectedFilter));
                if (this.gFv != null) {
                    this.gFv[this.aEX].j(cloneWithoutFilterAction);
                }
            } else if (this.gFv != null) {
                this.gFv[this.aEX].j(this.gFt[this.aEX]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEX;
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
        this.gFw[i] = new com.baidu.tbadk.coreExtra.view.a(this.gFs, this, str);
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
        for (int i = 0; i < this.gFt.length; i++) {
            this.gFt[i].applayRotatePageActionToPersistAction();
            if (this.gFw[i] != null && (selectedFilter = this.gFw[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.gFt[i].addPersistAction(com.baidu.tbadk.img.effect.a.gr(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0129b {
        private TbImageView aSS;
        private ProgressBar fpZ;
        private com.baidu.tbadk.img.b gFA;
        private FrameLayout gFz;
        private int index;

        public C0129b(int i) {
            this.fpZ = null;
            this.index = -1;
            this.index = i;
            this.gFz = (FrameLayout) LayoutInflater.from(b.this.gFs.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aSS = (TbImageView) this.gFz.findViewById(d.h.progress_tb_imageview);
            this.aSS.setClickable(true);
            this.aSS.setDefaultResource(0);
            this.aSS.setDefaultErrorResource(0);
            this.aSS.setDefaultBgResource(0);
            this.aSS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gFA = new com.baidu.tbadk.img.b();
            this.aSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gFu != null) {
                        b.this.gFu.bzL();
                    }
                }
            });
            this.fpZ = (ProgressBar) this.gFz.findViewById(d.h.progress_tb_imageview_progress);
            this.fpZ.setVisibility(8);
        }

        public View getView() {
            return this.gFz;
        }

        public void j(ImageFileInfo imageFileInfo) {
            Uz();
            this.aSS.setDefaultResource(0);
            this.aSS.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gFA.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aSS);
                return;
            }
            ng(false);
            this.gFA.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    C0129b.this.ng(true);
                    if (aVar != null) {
                        aVar.e(C0129b.this.aSS);
                    } else {
                        C0129b.this.aSS.setDefaultResource(d.g.image_group_load_f);
                    }
                }
            }, false);
        }

        public void Uz() {
            if (this.gFA != null) {
                this.gFA.EH();
            }
            if (this.aSS != null) {
                this.aSS.setImageDrawable(null);
            }
        }

        public boolean bzO() {
            return this.fpZ.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ng(boolean z) {
            if (z) {
                if (this.fpZ.getVisibility() != 8) {
                    if (b.this.gFu != null) {
                        b.this.gFu.bzN();
                    }
                    this.fpZ.setVisibility(8);
                    b.this.gFw[this.index].setCanbeClick(true);
                }
            } else if (this.fpZ.getVisibility() != 0) {
                if (b.this.gFu != null) {
                    b.this.gFu.bzM();
                }
                this.fpZ.setVisibility(0);
                b.this.gFw[this.index].setCanbeClick(false);
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

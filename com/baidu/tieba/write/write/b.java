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
    private int aEY;
    private WriteMultiImgsActivity gHk;
    private ImageFileInfo[] gHl;
    private a gHm;
    private C0130b[] gHn;
    private com.baidu.tbadk.coreExtra.view.a[] gHo;
    private int gHp;
    private int gHq;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bAs();

        void bAt();

        void bAu();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gHk = null;
        this.gHl = null;
        this.mViewPager = null;
        this.gHm = null;
        this.mCount = 0;
        this.aEY = 0;
        this.gHn = null;
        this.gHo = null;
        this.gHp = 120;
        this.gHq = 120;
        this.gHk = writeMultiImgsActivity;
        this.gHp = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gHq = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gHl = new ImageFileInfo[this.mCount];
        this.gHn = new C0130b[this.mCount];
        this.gHo = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gHl[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gHl[i3].addPageAction(com.baidu.tbadk.img.effect.d.M(this.gHp, this.gHq));
                linkedList.set(i3, this.gHl[i3]);
                i2 = i3 + 1;
            } else {
                this.aEY = i;
                this.mViewPager = viewPager;
                this.gHm = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uK(int i) {
        if (this.gHn[this.aEY].bAv()) {
            this.gHl[this.aEY].addPageAction(e.eY(i));
            this.gHk.bBg();
            if (this.gHo[this.aEY] != null) {
                String selectedFilter = this.gHo[this.aEY].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.gHl[this.aEY].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gr(selectedFilter));
                    this.gHn[this.aEY].j(cloneWithoutFilterAction);
                    return;
                }
                this.gHn[this.aEY].j(this.gHl[this.aEY]);
                return;
            }
            this.gHn[this.aEY].j(this.gHl[this.aEY]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0049a
    public void fg(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.gHk.bBg();
            ImageFileInfo cloneWithoutFilterAction = this.gHl[this.aEY].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gr(str));
            this.gHn[this.aEY].j(cloneWithoutFilterAction);
            return;
        }
        this.gHk.bBh();
        this.gHn[this.aEY].j(this.gHl[this.aEY]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gHn[i] == null) {
            this.gHn[i] = new C0130b(i);
        }
        this.mViewPager.addView(this.gHn[i].getView());
        return this.gHn[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gHn[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEY = i;
        bAq();
        if (this.gHm != null) {
            this.gHm.a(this.gHo[i], i);
        }
    }

    private void bAq() {
        if (this.aEY >= 0) {
            if (this.gHn != null) {
                for (int i = 0; i < this.gHn.length; i++) {
                    if (this.gHn[i] != null) {
                        this.gHn[i].UV();
                    }
                }
                if (this.gHn[this.aEY] == null) {
                    this.gHn[this.aEY] = new C0130b(this.aEY);
                }
            }
            String selectedFilter = this.gHo[this.aEY].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.gHl[this.aEY].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gr(selectedFilter));
                if (this.gHn != null) {
                    this.gHn[this.aEY].j(cloneWithoutFilterAction);
                }
            } else if (this.gHn != null) {
                this.gHn[this.aEY].j(this.gHl[this.aEY]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEY;
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
        this.gHo[i] = new com.baidu.tbadk.coreExtra.view.a(this.gHk, this, str);
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
    public void bAr() {
        String selectedFilter;
        for (int i = 0; i < this.gHl.length; i++) {
            this.gHl[i].applayRotatePageActionToPersistAction();
            if (this.gHo[i] != null && (selectedFilter = this.gHo[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.gHl[i].addPersistAction(com.baidu.tbadk.img.effect.a.gr(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130b {
        private TbImageView aST;
        private ProgressBar frT;
        private FrameLayout gHr;
        private com.baidu.tbadk.img.b gHs;
        private int index;

        public C0130b(int i) {
            this.frT = null;
            this.index = -1;
            this.index = i;
            this.gHr = (FrameLayout) LayoutInflater.from(b.this.gHk.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aST = (TbImageView) this.gHr.findViewById(d.h.progress_tb_imageview);
            this.aST.setClickable(true);
            this.aST.setDefaultResource(0);
            this.aST.setDefaultErrorResource(0);
            this.aST.setDefaultBgResource(0);
            this.aST.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gHs = new com.baidu.tbadk.img.b();
            this.aST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gHm != null) {
                        b.this.gHm.bAs();
                    }
                }
            });
            this.frT = (ProgressBar) this.gHr.findViewById(d.h.progress_tb_imageview_progress);
            this.frT.setVisibility(8);
        }

        public View getView() {
            return this.gHr;
        }

        public void j(ImageFileInfo imageFileInfo) {
            UV();
            this.aST.setDefaultResource(0);
            this.aST.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gHs.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aST);
                return;
            }
            nj(false);
            this.gHs.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    C0130b.this.nj(true);
                    if (aVar != null) {
                        aVar.e(C0130b.this.aST);
                    } else {
                        C0130b.this.aST.setDefaultResource(d.g.image_group_load_f);
                    }
                }
            }, false);
        }

        public void UV() {
            if (this.gHs != null) {
                this.gHs.EH();
            }
            if (this.aST != null) {
                this.aST.setImageDrawable(null);
            }
        }

        public boolean bAv() {
            return this.frT.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nj(boolean z) {
            if (z) {
                if (this.frT.getVisibility() != 8) {
                    if (b.this.gHm != null) {
                        b.this.gHm.bAu();
                    }
                    this.frT.setVisibility(8);
                    b.this.gHo[this.index].setCanbeClick(true);
                }
            } else if (this.frT.getVisibility() != 0) {
                if (b.this.gHm != null) {
                    b.this.gHm.bAt();
                }
                this.frT.setVisibility(0);
                b.this.gHo[this.index].setCanbeClick(false);
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

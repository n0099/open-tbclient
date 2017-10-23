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
    private int aDt;
    private WriteMultiImgsActivity gLo;
    private ImageFileInfo[] gLp;
    private a gLq;
    private C0144b[] gLr;
    private com.baidu.tbadk.coreExtra.view.a[] gLs;
    private int gLt;
    private int gLu;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bAS();

        void bAT();

        void bAU();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gLo = null;
        this.gLp = null;
        this.mViewPager = null;
        this.gLq = null;
        this.mCount = 0;
        this.aDt = 0;
        this.gLr = null;
        this.gLs = null;
        this.gLt = 120;
        this.gLu = 120;
        this.gLo = writeMultiImgsActivity;
        this.gLt = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gLu = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gLp = new ImageFileInfo[this.mCount];
        this.gLr = new C0144b[this.mCount];
        this.gLs = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gLp[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gLp[i3].addPageAction(com.baidu.tbadk.img.effect.d.K(this.gLt, this.gLu));
                linkedList.set(i3, this.gLp[i3]);
                i2 = i3 + 1;
            } else {
                this.aDt = i;
                this.mViewPager = viewPager;
                this.gLq = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vj(int i) {
        if (this.gLr[this.aDt].bAV()) {
            this.gLp[this.aDt].addPageAction(e.fi(i));
            this.gLo.bBG();
            if (this.gLs[this.aDt] != null) {
                String selectedFilter = this.gLs[this.aDt].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.gLp[this.aDt].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gm(selectedFilter));
                    this.gLr[this.aDt].j(cloneWithoutFilterAction);
                    return;
                }
                this.gLr[this.aDt].j(this.gLp[this.aDt]);
                return;
            }
            this.gLr[this.aDt].j(this.gLp[this.aDt]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0052a
    public void eX(String str) {
        if (str != null && !str.equals("normal")) {
            this.gLo.bBG();
            ImageFileInfo cloneWithoutFilterAction = this.gLp[this.aDt].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gm(str));
            this.gLr[this.aDt].j(cloneWithoutFilterAction);
            return;
        }
        this.gLo.bBH();
        this.gLr[this.aDt].j(this.gLp[this.aDt]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gLr[i] == null) {
            this.gLr[i] = new C0144b(i);
        }
        this.mViewPager.addView(this.gLr[i].getView());
        return this.gLr[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gLr[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aDt = i;
        bAQ();
        if (this.gLq != null) {
            this.gLq.a(this.gLs[i], i);
        }
    }

    private void bAQ() {
        if (this.aDt >= 0) {
            if (this.gLr != null) {
                for (int i = 0; i < this.gLr.length; i++) {
                    if (this.gLr[i] != null) {
                        this.gLr[i].Wu();
                    }
                }
                if (this.gLr[this.aDt] == null) {
                    this.gLr[this.aDt] = new C0144b(this.aDt);
                }
            }
            String selectedFilter = this.gLs[this.aDt].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.gLp[this.aDt].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gm(selectedFilter));
                if (this.gLr != null) {
                    this.gLr[this.aDt].j(cloneWithoutFilterAction);
                }
            } else if (this.gLr != null) {
                this.gLr[this.aDt].j(this.gLp[this.aDt]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aDt;
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
        this.gLs[i] = new com.baidu.tbadk.coreExtra.view.a(this.gLo, this, str);
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
    public void bAR() {
        String selectedFilter;
        for (int i = 0; i < this.gLp.length; i++) {
            this.gLp[i].applayRotatePageActionToPersistAction();
            if (this.gLs[i] != null && (selectedFilter = this.gLs[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.gLp[i].addPersistAction(com.baidu.tbadk.img.effect.a.gm(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0144b {
        private TbImageView aTn;
        private ProgressBar fmZ;
        private FrameLayout gLv;
        private com.baidu.tbadk.img.b gLw;
        private int index;

        public C0144b(int i) {
            this.fmZ = null;
            this.index = -1;
            this.index = i;
            this.gLv = (FrameLayout) LayoutInflater.from(b.this.gLo.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aTn = (TbImageView) this.gLv.findViewById(d.h.progress_tb_imageview);
            this.aTn.setClickable(true);
            this.aTn.setDefaultResource(0);
            this.aTn.setDefaultErrorResource(0);
            this.aTn.setDefaultBgResource(0);
            this.aTn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gLw = new com.baidu.tbadk.img.b();
            this.aTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gLq != null) {
                        b.this.gLq.bAS();
                    }
                }
            });
            this.fmZ = (ProgressBar) this.gLv.findViewById(d.h.progress_tb_imageview_progress);
            this.fmZ.setVisibility(8);
        }

        public View getView() {
            return this.gLv;
        }

        public void j(ImageFileInfo imageFileInfo) {
            Wu();
            this.aTn.setDefaultResource(0);
            this.aTn.setDefaultBgResource(0);
            com.baidu.adp.widget.ImageView.a a = this.gLw.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aTn);
                return;
            }
            nv(false);
            this.gLw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                    C0144b.this.nv(true);
                    if (aVar != null) {
                        aVar.a(C0144b.this.aTn);
                    } else {
                        C0144b.this.aTn.setDefaultResource(d.g.image_group_load_f);
                    }
                }
            }, false);
        }

        public void Wu() {
            if (this.gLw != null) {
                this.gLw.Ee();
            }
            if (this.aTn != null) {
                this.aTn.setImageDrawable(null);
            }
        }

        public boolean bAV() {
            return this.fmZ.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nv(boolean z) {
            if (z) {
                if (this.fmZ.getVisibility() != 8) {
                    if (b.this.gLq != null) {
                        b.this.gLq.bAU();
                    }
                    this.fmZ.setVisibility(8);
                    b.this.gLs[this.index].setCanbeClick(true);
                }
            } else if (this.fmZ.getVisibility() != 0) {
                if (b.this.gLq != null) {
                    b.this.gLq.bAT();
                }
                this.fmZ.setVisibility(0);
                b.this.gLs[this.index].setCanbeClick(false);
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

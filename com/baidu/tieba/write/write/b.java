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
    private ViewPager aDL;
    private int aEe;
    private WriteMultiImgsActivity gVo;
    private ImageFileInfo[] gVp;
    private a gVq;
    private C0146b[] gVr;
    private com.baidu.tbadk.coreExtra.view.a[] gVs;
    private int gVt;
    private int gVu;
    private int mCount;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bEp();

        void bEq();

        void bEr();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gVo = null;
        this.gVp = null;
        this.aDL = null;
        this.gVq = null;
        this.mCount = 0;
        this.aEe = 0;
        this.gVr = null;
        this.gVs = null;
        this.gVt = 120;
        this.gVu = 120;
        this.gVo = writeMultiImgsActivity;
        this.gVt = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds720);
        this.gVu = (int) writeMultiImgsActivity.getResources().getDimension(d.e.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gVp = new ImageFileInfo[this.mCount];
        this.gVr = new C0146b[this.mCount];
        this.gVs = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gVp[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gVp[i3].addPageAction(com.baidu.tbadk.img.effect.d.K(this.gVt, this.gVu));
                linkedList.set(i3, this.gVp[i3]);
                i2 = i3 + 1;
            } else {
                this.aEe = i;
                this.aDL = viewPager;
                this.gVq = aVar;
                this.aDL.setOffscreenPageLimit(1);
                this.aDL.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vE(int i) {
        if (this.gVr[this.aEe].bEs()) {
            this.gVp[this.aEe].addPageAction(com.baidu.tbadk.img.effect.e.fj(i));
            this.gVo.bFd();
            if (this.gVs[this.aEe] != null) {
                String selectedFilter = this.gVs[this.aEe].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.gVp[this.aEe].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gu(selectedFilter));
                    this.gVr[this.aEe].j(cloneWithoutFilterAction);
                    return;
                }
                this.gVr[this.aEe].j(this.gVp[this.aEe]);
                return;
            }
            this.gVr[this.aEe].j(this.gVp[this.aEe]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0052a
    public void fe(String str) {
        if (str != null && !str.equals("normal")) {
            this.gVo.bFd();
            ImageFileInfo cloneWithoutFilterAction = this.gVp[this.aEe].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gu(str));
            this.gVr[this.aEe].j(cloneWithoutFilterAction);
            return;
        }
        this.gVo.bFe();
        this.gVr[this.aEe].j(this.gVp[this.aEe]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gVr[i] == null) {
            this.gVr[i] = new C0146b(i);
        }
        this.aDL.addView(this.gVr[i].getView());
        return this.gVr[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aDL.removeView(this.gVr[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aEe = i;
        bEn();
        if (this.gVq != null) {
            this.gVq.a(this.gVs[i], i);
        }
    }

    private void bEn() {
        if (this.aEe >= 0) {
            if (this.gVr != null) {
                for (int i = 0; i < this.gVr.length; i++) {
                    if (this.gVr[i] != null) {
                        this.gVr[i].YC();
                    }
                }
                if (this.gVr[this.aEe] == null) {
                    this.gVr[this.aEe] = new C0146b(this.aEe);
                }
            }
            String selectedFilter = this.gVs[this.aEe].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.gVp[this.aEe].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gu(selectedFilter));
                if (this.gVr != null) {
                    this.gVr[this.aEe].j(cloneWithoutFilterAction);
                }
            } else if (this.gVr != null) {
                this.gVr[this.aEe].j(this.gVp[this.aEe]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aEe;
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
        this.gVs[i] = new com.baidu.tbadk.coreExtra.view.a(this.gVo, this, str);
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
    public void bEo() {
        String selectedFilter;
        for (int i = 0; i < this.gVp.length; i++) {
            this.gVp[i].applayRotatePageActionToPersistAction();
            if (this.gVs[i] != null && (selectedFilter = this.gVs[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.gVp[i].addPersistAction(com.baidu.tbadk.img.effect.a.gu(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0146b {
        private TbImageView aTr;
        private ProgressBar fvM;
        private FrameLayout gVv;
        private com.baidu.tbadk.img.b gVw;
        private int index;

        public C0146b(int i) {
            this.fvM = null;
            this.index = -1;
            this.index = i;
            this.gVv = (FrameLayout) LayoutInflater.from(b.this.gVo.getPageContext().getContext()).inflate(d.h.progress_tb_imageview, (ViewGroup) null);
            this.aTr = (TbImageView) this.gVv.findViewById(d.g.progress_tb_imageview);
            this.aTr.setClickable(true);
            this.aTr.setDefaultResource(0);
            this.aTr.setDefaultErrorResource(0);
            this.aTr.setDefaultBgResource(0);
            this.aTr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gVw = new com.baidu.tbadk.img.b();
            this.aTr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gVq != null) {
                        b.this.gVq.bEp();
                    }
                }
            });
            this.fvM = (ProgressBar) this.gVv.findViewById(d.g.progress_tb_imageview_progress);
            this.fvM.setVisibility(8);
        }

        public View getView() {
            return this.gVv;
        }

        public void j(ImageFileInfo imageFileInfo) {
            YC();
            this.aTr.setDefaultResource(0);
            this.aTr.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gVw.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aTr);
                return;
            }
            nv(false);
            this.gVw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    C0146b.this.nv(true);
                    if (aVar != null) {
                        aVar.a(C0146b.this.aTr);
                    } else {
                        C0146b.this.aTr.setDefaultResource(d.f.image_group_load_f);
                    }
                }
            }, false);
        }

        public void YC() {
            if (this.gVw != null) {
                this.gVw.Er();
            }
            if (this.aTr != null) {
                this.aTr.setImageDrawable(null);
            }
        }

        public boolean bEs() {
            return this.fvM.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nv(boolean z) {
            if (z) {
                if (this.fvM.getVisibility() != 8) {
                    if (b.this.gVq != null) {
                        b.this.gVq.bEr();
                    }
                    this.fvM.setVisibility(8);
                    b.this.gVs[this.index].setCanbeClick(true);
                }
            } else if (this.fvM.getVisibility() != 0) {
                if (b.this.gVq != null) {
                    b.this.gVq.bEq();
                }
                this.fvM.setVisibility(0);
                b.this.gVs[this.index].setCanbeClick(false);
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

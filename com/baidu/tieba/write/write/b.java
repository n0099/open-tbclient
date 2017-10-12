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
    private int aDG;
    private WriteMultiImgsActivity gLD;
    private ImageFileInfo[] gLE;
    private a gLF;
    private C0144b[] gLG;
    private com.baidu.tbadk.coreExtra.view.a[] gLH;
    private int gLI;
    private int gLJ;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bAY();

        void bAZ();

        void bBa();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gLD = null;
        this.gLE = null;
        this.mViewPager = null;
        this.gLF = null;
        this.mCount = 0;
        this.aDG = 0;
        this.gLG = null;
        this.gLH = null;
        this.gLI = 120;
        this.gLJ = 120;
        this.gLD = writeMultiImgsActivity;
        this.gLI = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gLJ = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gLE = new ImageFileInfo[this.mCount];
        this.gLG = new C0144b[this.mCount];
        this.gLH = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gLE[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gLE[i3].addPageAction(com.baidu.tbadk.img.effect.d.K(this.gLI, this.gLJ));
                linkedList.set(i3, this.gLE[i3]);
                i2 = i3 + 1;
            } else {
                this.aDG = i;
                this.mViewPager = viewPager;
                this.gLF = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vk(int i) {
        if (this.gLG[this.aDG].bBb()) {
            this.gLE[this.aDG].addPageAction(e.fj(i));
            this.gLD.bBM();
            if (this.gLH[this.aDG] != null) {
                String selectedFilter = this.gLH[this.aDG].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.gLE[this.aDG].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gn(selectedFilter));
                    this.gLG[this.aDG].j(cloneWithoutFilterAction);
                    return;
                }
                this.gLG[this.aDG].j(this.gLE[this.aDG]);
                return;
            }
            this.gLG[this.aDG].j(this.gLE[this.aDG]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0052a
    public void eY(String str) {
        if (str != null && !str.equals("normal")) {
            this.gLD.bBM();
            ImageFileInfo cloneWithoutFilterAction = this.gLE[this.aDG].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gn(str));
            this.gLG[this.aDG].j(cloneWithoutFilterAction);
            return;
        }
        this.gLD.bBN();
        this.gLG[this.aDG].j(this.gLE[this.aDG]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gLG[i] == null) {
            this.gLG[i] = new C0144b(i);
        }
        this.mViewPager.addView(this.gLG[i].getView());
        return this.gLG[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gLG[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aDG = i;
        bAW();
        if (this.gLF != null) {
            this.gLF.a(this.gLH[i], i);
        }
    }

    private void bAW() {
        if (this.aDG >= 0) {
            if (this.gLG != null) {
                for (int i = 0; i < this.gLG.length; i++) {
                    if (this.gLG[i] != null) {
                        this.gLG[i].Wy();
                    }
                }
                if (this.gLG[this.aDG] == null) {
                    this.gLG[this.aDG] = new C0144b(this.aDG);
                }
            }
            String selectedFilter = this.gLH[this.aDG].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.gLE[this.aDG].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gn(selectedFilter));
                if (this.gLG != null) {
                    this.gLG[this.aDG].j(cloneWithoutFilterAction);
                }
            } else if (this.gLG != null) {
                this.gLG[this.aDG].j(this.gLE[this.aDG]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aDG;
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
        this.gLH[i] = new com.baidu.tbadk.coreExtra.view.a(this.gLD, this, str);
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
    public void bAX() {
        String selectedFilter;
        for (int i = 0; i < this.gLE.length; i++) {
            this.gLE[i].applayRotatePageActionToPersistAction();
            if (this.gLH[i] != null && (selectedFilter = this.gLH[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.gLE[i].addPersistAction(com.baidu.tbadk.img.effect.a.gn(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0144b {
        private TbImageView aTA;
        private ProgressBar fnn;
        private FrameLayout gLK;
        private com.baidu.tbadk.img.b gLL;
        private int index;

        public C0144b(int i) {
            this.fnn = null;
            this.index = -1;
            this.index = i;
            this.gLK = (FrameLayout) LayoutInflater.from(b.this.gLD.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aTA = (TbImageView) this.gLK.findViewById(d.h.progress_tb_imageview);
            this.aTA.setClickable(true);
            this.aTA.setDefaultResource(0);
            this.aTA.setDefaultErrorResource(0);
            this.aTA.setDefaultBgResource(0);
            this.aTA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gLL = new com.baidu.tbadk.img.b();
            this.aTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gLF != null) {
                        b.this.gLF.bAY();
                    }
                }
            });
            this.fnn = (ProgressBar) this.gLK.findViewById(d.h.progress_tb_imageview_progress);
            this.fnn.setVisibility(8);
        }

        public View getView() {
            return this.gLK;
        }

        public void j(ImageFileInfo imageFileInfo) {
            Wy();
            this.aTA.setDefaultResource(0);
            this.aTA.setDefaultBgResource(0);
            com.baidu.adp.widget.ImageView.a a = this.gLL.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aTA);
                return;
            }
            nw(false);
            this.gLL.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                    C0144b.this.nw(true);
                    if (aVar != null) {
                        aVar.a(C0144b.this.aTA);
                    } else {
                        C0144b.this.aTA.setDefaultResource(d.g.image_group_load_f);
                    }
                }
            }, false);
        }

        public void Wy() {
            if (this.gLL != null) {
                this.gLL.Ek();
            }
            if (this.aTA != null) {
                this.aTA.setImageDrawable(null);
            }
        }

        public boolean bBb() {
            return this.fnn.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nw(boolean z) {
            if (z) {
                if (this.fnn.getVisibility() != 8) {
                    if (b.this.gLF != null) {
                        b.this.gLF.bBa();
                    }
                    this.fnn.setVisibility(8);
                    b.this.gLH[this.index].setCanbeClick(true);
                }
            } else if (this.fnn.getVisibility() != 0) {
                if (b.this.gLF != null) {
                    b.this.gLF.bAZ();
                }
                this.fnn.setVisibility(0);
                b.this.gLH[this.index].setCanbeClick(false);
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

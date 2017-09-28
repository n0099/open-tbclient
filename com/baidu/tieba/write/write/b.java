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
    private WriteMultiImgsActivity gLE;
    private ImageFileInfo[] gLF;
    private a gLG;
    private C0144b[] gLH;
    private com.baidu.tbadk.coreExtra.view.a[] gLI;
    private int gLJ;
    private int gLK;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.a aVar, int i);

        void bAZ();

        void bBa();

        void bBb();
    }

    public b(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.gLE = null;
        this.gLF = null;
        this.mViewPager = null;
        this.gLG = null;
        this.mCount = 0;
        this.aDG = 0;
        this.gLH = null;
        this.gLI = null;
        this.gLJ = 120;
        this.gLK = 120;
        this.gLE = writeMultiImgsActivity;
        this.gLJ = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds720);
        this.gLK = (int) writeMultiImgsActivity.getResources().getDimension(d.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.gLF = new ImageFileInfo[this.mCount];
        this.gLH = new C0144b[this.mCount];
        this.gLI = new com.baidu.tbadk.coreExtra.view.a[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.gLF[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gLF[i3].addPageAction(com.baidu.tbadk.img.effect.d.K(this.gLJ, this.gLK));
                linkedList.set(i3, this.gLF[i3]);
                i2 = i3 + 1;
            } else {
                this.aDG = i;
                this.mViewPager = viewPager;
                this.gLG = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vk(int i) {
        if (this.gLH[this.aDG].bBc()) {
            this.gLF[this.aDG].addPageAction(e.fj(i));
            this.gLE.bBN();
            if (this.gLI[this.aDG] != null) {
                String selectedFilter = this.gLI[this.aDG].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals("normal")) {
                    ImageFileInfo cloneWithoutFilterAction = this.gLF[this.aDG].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gn(selectedFilter));
                    this.gLH[this.aDG].j(cloneWithoutFilterAction);
                    return;
                }
                this.gLH[this.aDG].j(this.gLF[this.aDG]);
                return;
            }
            this.gLH[this.aDG].j(this.gLF[this.aDG]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0052a
    public void eY(String str) {
        if (str != null && !str.equals("normal")) {
            this.gLE.bBN();
            ImageFileInfo cloneWithoutFilterAction = this.gLF[this.aDG].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gn(str));
            this.gLH[this.aDG].j(cloneWithoutFilterAction);
            return;
        }
        this.gLE.bBO();
        this.gLH[this.aDG].j(this.gLF[this.aDG]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gLH[i] == null) {
            this.gLH[i] = new C0144b(i);
        }
        this.mViewPager.addView(this.gLH[i].getView());
        return this.gLH[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.gLH[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aDG = i;
        bAX();
        if (this.gLG != null) {
            this.gLG.a(this.gLI[i], i);
        }
    }

    private void bAX() {
        if (this.aDG >= 0) {
            if (this.gLH != null) {
                for (int i = 0; i < this.gLH.length; i++) {
                    if (this.gLH[i] != null) {
                        this.gLH[i].Wy();
                    }
                }
                if (this.gLH[this.aDG] == null) {
                    this.gLH[this.aDG] = new C0144b(this.aDG);
                }
            }
            String selectedFilter = this.gLI[this.aDG].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals("normal")) {
                ImageFileInfo cloneWithoutFilterAction = this.gLF[this.aDG].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.gn(selectedFilter));
                if (this.gLH != null) {
                    this.gLH[this.aDG].j(cloneWithoutFilterAction);
                }
            } else if (this.gLH != null) {
                this.gLH[this.aDG].j(this.gLF[this.aDG]);
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
        this.gLI[i] = new com.baidu.tbadk.coreExtra.view.a(this.gLE, this, str);
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
    public void bAY() {
        String selectedFilter;
        for (int i = 0; i < this.gLF.length; i++) {
            this.gLF[i].applayRotatePageActionToPersistAction();
            if (this.gLI[i] != null && (selectedFilter = this.gLI[i].getSelectedFilter()) != null && !selectedFilter.equals("normal")) {
                this.gLF[i].addPersistAction(com.baidu.tbadk.img.effect.a.gn(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0144b {
        private TbImageView aTA;
        private ProgressBar fno;
        private FrameLayout gLL;
        private com.baidu.tbadk.img.b gLM;
        private int index;

        public C0144b(int i) {
            this.fno = null;
            this.index = -1;
            this.index = i;
            this.gLL = (FrameLayout) LayoutInflater.from(b.this.gLE.getPageContext().getContext()).inflate(d.j.progress_tb_imageview, (ViewGroup) null);
            this.aTA = (TbImageView) this.gLL.findViewById(d.h.progress_tb_imageview);
            this.aTA.setClickable(true);
            this.aTA.setDefaultResource(0);
            this.aTA.setDefaultErrorResource(0);
            this.aTA.setDefaultBgResource(0);
            this.aTA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gLM = new com.baidu.tbadk.img.b();
            this.aTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gLG != null) {
                        b.this.gLG.bAZ();
                    }
                }
            });
            this.fno = (ProgressBar) this.gLL.findViewById(d.h.progress_tb_imageview_progress);
            this.fno.setVisibility(8);
        }

        public View getView() {
            return this.gLL;
        }

        public void j(ImageFileInfo imageFileInfo) {
            Wy();
            this.aTA.setDefaultResource(0);
            this.aTA.setDefaultBgResource(0);
            com.baidu.adp.widget.ImageView.a a = this.gLM.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aTA);
                return;
            }
            nw(false);
            this.gLM.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.b.b.2
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
            if (this.gLM != null) {
                this.gLM.Ek();
            }
            if (this.aTA != null) {
                this.aTA.setImageDrawable(null);
            }
        }

        public boolean bBc() {
            return this.fno.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nw(boolean z) {
            if (z) {
                if (this.fno.getVisibility() != 8) {
                    if (b.this.gLG != null) {
                        b.this.gLG.bBb();
                    }
                    this.fno.setVisibility(8);
                    b.this.gLI[this.index].setCanbeClick(true);
                }
            } else if (this.fno.getVisibility() != 0) {
                if (b.this.gLG != null) {
                    b.this.gLG.bBa();
                }
                this.fno.setVisibility(0);
                b.this.gLI[this.index].setCanbeClick(false);
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

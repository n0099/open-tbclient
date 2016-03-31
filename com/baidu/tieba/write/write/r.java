package com.baidu.tieba.write.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private ViewPager aim;
    private int awy;
    private WriteMultiImgsActivity eLP;
    private ImageFileInfo[] eLQ;
    private a eLR;
    private b[] eLS;
    private com.baidu.tbadk.coreExtra.view.c[] eLT;
    private int eLU;
    private int eLV;
    private int xj;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bbd();

        void bbe();

        void bbf();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.eLP = null;
        this.eLQ = null;
        this.aim = null;
        this.eLR = null;
        this.xj = 0;
        this.awy = 0;
        this.eLS = null;
        this.eLT = null;
        this.eLU = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.eLV = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.eLP = writeMultiImgsActivity;
        this.eLU = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_width);
        this.eLV = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_height);
        if (linkedList != null) {
            this.xj = linkedList.size();
        }
        this.eLQ = new ImageFileInfo[this.xj];
        this.eLS = new b[this.xj];
        this.eLT = new com.baidu.tbadk.coreExtra.view.c[this.xj];
        while (true) {
            int i3 = i2;
            if (i3 < this.xj) {
                a(linkedList.get(i3), i3);
                this.eLQ[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.eLQ[i3].addPageAction(com.baidu.tbadk.img.effect.d.D(this.eLU, this.eLV));
                linkedList.set(i3, this.eLQ[i3]);
                i2 = i3 + 1;
            } else {
                this.awy = i;
                this.aim = viewPager;
                this.eLR = aVar;
                this.aim.setOffscreenPageLimit(1);
                this.aim.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qQ(int i) {
        if (this.eLS[this.awy].bbg()) {
            this.eLQ[this.awy].addPageAction(com.baidu.tbadk.img.effect.e.eU(i));
            this.eLP.bbM();
            if (this.eLT[this.awy] != null) {
                String selectedFilter = this.eLT[this.awy].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.eLQ[this.awy].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fQ(selectedFilter));
                    this.eLS[this.awy].k(cloneWithoutFilterAction);
                    return;
                }
                this.eLS[this.awy].k(this.eLQ[this.awy]);
                return;
            }
            this.eLS[this.awy].k(this.eLQ[this.awy]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eK(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.eLP.bbM();
            ImageFileInfo cloneWithoutFilterAction = this.eLQ[this.awy].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fQ(str));
            this.eLS[this.awy].k(cloneWithoutFilterAction);
            return;
        }
        this.eLP.bbN();
        this.eLS[this.awy].k(this.eLQ[this.awy]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.eLS[i] == null) {
            this.eLS[i] = new b(i);
        }
        this.aim.addView(this.eLS[i].getView());
        return this.eLS[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aim.removeView(this.eLS[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.awy = i;
        bbb();
        if (this.eLR != null) {
            this.eLR.a(this.eLT[i], i);
        }
    }

    private void bbb() {
        if (this.awy >= 0) {
            if (this.eLS != null) {
                for (int i = 0; i < this.eLS.length; i++) {
                    if (this.eLS[i] != null) {
                        this.eLS[i].aUI();
                    }
                }
                if (this.eLS[this.awy] == null) {
                    this.eLS[this.awy] = new b(this.awy);
                }
            }
            String selectedFilter = this.eLT[this.awy].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.eLQ[this.awy].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fQ(selectedFilter));
                if (this.eLS != null) {
                    this.eLS[this.awy].k(cloneWithoutFilterAction);
                }
            } else if (this.eLS != null) {
                this.eLS[this.awy].k(this.eLQ[this.awy]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.awy;
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
        this.eLT[i] = new com.baidu.tbadk.coreExtra.view.c(this.eLP, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.xj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbc() {
        String selectedFilter;
        for (int i = 0; i < this.eLQ.length; i++) {
            this.eLQ[i].applayRotatePageActionToPersistAction();
            if (this.eLT[i] != null && (selectedFilter = this.eLT[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.eLQ[i].addPersistAction(com.baidu.tbadk.img.effect.a.fQ(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aJQ;
        private ProgressBar dIe;
        private FrameLayout eLW;
        private com.baidu.tbadk.img.b eLX;
        private int index;

        public b(int i) {
            this.dIe = null;
            this.index = -1;
            this.index = i;
            this.eLW = (FrameLayout) LayoutInflater.from(r.this.eLP.getPageContext().getContext()).inflate(t.h.progress_tb_imageview, (ViewGroup) null);
            this.aJQ = (TbImageView) this.eLW.findViewById(t.g.progress_tb_imageview);
            this.aJQ.setClickable(true);
            this.aJQ.setDefaultResource(0);
            this.aJQ.setDefaultErrorResource(0);
            this.aJQ.setDefaultBgResource(0);
            this.aJQ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.eLX = new com.baidu.tbadk.img.b();
            this.aJQ.setOnClickListener(new s(this));
            this.dIe = (ProgressBar) this.eLW.findViewById(t.g.progress_tb_imageview_progress);
            this.dIe.setVisibility(8);
        }

        public View getView() {
            return this.eLW;
        }

        public void k(ImageFileInfo imageFileInfo) {
            aUI();
            this.aJQ.setDefaultResource(0);
            this.aJQ.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.eLX.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aJQ);
                return;
            }
            jv(false);
            this.eLX.a(imageFileInfo, new t(this), false);
        }

        public void aUI() {
            if (this.eLX != null) {
                this.eLX.EU();
            }
            if (this.aJQ != null) {
                this.aJQ.setImageDrawable(null);
            }
        }

        public boolean bbg() {
            return this.dIe.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jv(boolean z) {
            if (z) {
                if (this.dIe.getVisibility() != 8) {
                    if (r.this.eLR != null) {
                        r.this.eLR.bbf();
                    }
                    this.dIe.setVisibility(8);
                    r.this.eLT[this.index].setCanbeClick(true);
                }
            } else if (this.dIe.getVisibility() != 0) {
                if (r.this.eLR != null) {
                    r.this.eLR.bbe();
                }
                this.dIe.setVisibility(0);
                r.this.eLT[this.index].setCanbeClick(false);
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

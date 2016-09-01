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
    private ViewPager awS;
    private int axl;
    private WriteMultiImgsActivity geb;
    private ImageFileInfo[] gec;
    private a ged;
    private b[] gee;
    private com.baidu.tbadk.coreExtra.view.c[] gef;
    private int geg;
    private int geh;
    private int qg;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void btd();

        void bte();

        void btf();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.geb = null;
        this.gec = null;
        this.awS = null;
        this.ged = null;
        this.qg = 0;
        this.axl = 0;
        this.gee = null;
        this.gef = null;
        this.geg = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.geh = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.geb = writeMultiImgsActivity;
        this.geg = (int) writeMultiImgsActivity.getResources().getDimension(t.e.ds720);
        this.geh = (int) writeMultiImgsActivity.getResources().getDimension(t.e.ds1280);
        if (linkedList != null) {
            this.qg = linkedList.size();
        }
        this.gec = new ImageFileInfo[this.qg];
        this.gee = new b[this.qg];
        this.gef = new com.baidu.tbadk.coreExtra.view.c[this.qg];
        while (true) {
            int i3 = i2;
            if (i3 < this.qg) {
                a(linkedList.get(i3), i3);
                this.gec[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.gec[i3].addPageAction(com.baidu.tbadk.img.effect.d.F(this.geg, this.geh));
                linkedList.set(i3, this.gec[i3]);
                i2 = i3 + 1;
            } else {
                this.axl = i;
                this.awS = viewPager;
                this.ged = aVar;
                this.awS.setOffscreenPageLimit(1);
                this.awS.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tq(int i) {
        if (this.gee[this.axl].btg()) {
            this.gec[this.axl].addPageAction(com.baidu.tbadk.img.effect.e.eS(i));
            this.geb.btP();
            if (this.gef[this.axl] != null) {
                String selectedFilter = this.gef[this.axl].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.gec[this.axl].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fU(selectedFilter));
                    this.gee[this.axl].l(cloneWithoutFilterAction);
                    return;
                }
                this.gee[this.axl].l(this.gec[this.axl]);
                return;
            }
            this.gee[this.axl].l(this.gec[this.axl]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eM(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.geb.btP();
            ImageFileInfo cloneWithoutFilterAction = this.gec[this.axl].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fU(str));
            this.gee[this.axl].l(cloneWithoutFilterAction);
            return;
        }
        this.geb.btQ();
        this.gee[this.axl].l(this.gec[this.axl]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.gee[i] == null) {
            this.gee[i] = new b(i);
        }
        this.awS.addView(this.gee[i].getView());
        return this.gee[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.awS.removeView(this.gee[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.axl = i;
        btb();
        if (this.ged != null) {
            this.ged.a(this.gef[i], i);
        }
    }

    private void btb() {
        if (this.axl >= 0) {
            if (this.gee != null) {
                for (int i = 0; i < this.gee.length; i++) {
                    if (this.gee[i] != null) {
                        this.gee[i].bkp();
                    }
                }
                if (this.gee[this.axl] == null) {
                    this.gee[this.axl] = new b(this.axl);
                }
            }
            String selectedFilter = this.gef[this.axl].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.gec[this.axl].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fU(selectedFilter));
                if (this.gee != null) {
                    this.gee[this.axl].l(cloneWithoutFilterAction);
                }
            } else if (this.gee != null) {
                this.gee[this.axl].l(this.gec[this.axl]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.axl;
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
        this.gef[i] = new com.baidu.tbadk.coreExtra.view.c(this.geb, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.qg;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void btc() {
        String selectedFilter;
        for (int i = 0; i < this.gec.length; i++) {
            this.gec[i].applayRotatePageActionToPersistAction();
            if (this.gef[i] != null && (selectedFilter = this.gef[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.gec[i].addPersistAction(com.baidu.tbadk.img.effect.a.fU(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aKI;
        private ProgressBar eNp;
        private FrameLayout gei;
        private com.baidu.tbadk.img.b gej;
        private int index;

        public b(int i) {
            this.eNp = null;
            this.index = -1;
            this.index = i;
            this.gei = (FrameLayout) LayoutInflater.from(r.this.geb.getPageContext().getContext()).inflate(t.h.progress_tb_imageview, (ViewGroup) null);
            this.aKI = (TbImageView) this.gei.findViewById(t.g.progress_tb_imageview);
            this.aKI.setClickable(true);
            this.aKI.setDefaultResource(0);
            this.aKI.setDefaultErrorResource(0);
            this.aKI.setDefaultBgResource(0);
            this.aKI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.gej = new com.baidu.tbadk.img.b();
            this.aKI.setOnClickListener(new s(this));
            this.eNp = (ProgressBar) this.gei.findViewById(t.g.progress_tb_imageview_progress);
            this.eNp.setVisibility(8);
        }

        public View getView() {
            return this.gei;
        }

        public void l(ImageFileInfo imageFileInfo) {
            bkp();
            this.aKI.setDefaultResource(0);
            this.aKI.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.gej.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aKI);
                return;
            }
            lO(false);
            this.gej.a(imageFileInfo, new t(this), false);
        }

        public void bkp() {
            if (this.gej != null) {
                this.gej.Eq();
            }
            if (this.aKI != null) {
                this.aKI.setImageDrawable(null);
            }
        }

        public boolean btg() {
            return this.eNp.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lO(boolean z) {
            if (z) {
                if (this.eNp.getVisibility() != 8) {
                    if (r.this.ged != null) {
                        r.this.ged.btf();
                    }
                    this.eNp.setVisibility(8);
                    r.this.gef[this.index].setCanbeClick(true);
                }
            } else if (this.eNp.getVisibility() != 0) {
                if (r.this.ged != null) {
                    r.this.ged.bte();
                }
                this.eNp.setVisibility(0);
                r.this.gef[this.index].setCanbeClick(false);
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

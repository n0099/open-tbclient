package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int boZ;
    private WriteMultiImgsActivity jLb;
    private ImageFileInfo[] jLc;
    private a jLd;
    private b[] jLe;
    private int jLf;
    private LinkedList<ImageFileInfo> jLg = new LinkedList<>();
    private int jLh;
    private int jLi;
    private h jLj;
    private com.baidu.tbadk.core.dialog.a jLk;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void U(int i, boolean z);

        void cyu();

        void cyw();

        boolean cyx();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jLb = null;
        this.jLc = null;
        this.mViewPager = null;
        this.jLd = null;
        this.mCount = 0;
        this.boZ = 0;
        this.jLe = null;
        this.jLh = 120;
        this.jLi = 120;
        this.mIsFromIm = z;
        this.jLb = writeMultiImgsActivity;
        this.jLj = hVar;
        this.jLh = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jLi = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.boZ = e(linkedList, i);
        this.mCount = this.jLg.size();
        this.jLc = new ImageFileInfo[this.mCount];
        this.jLe = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jLc[i2] = this.jLg.get(i2).cloneWithoutFilterAction(true);
            this.jLc[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jLh, this.jLi));
            linkedList.set(linkedList.indexOf(this.jLg.get(i2)), this.jLc[i2]);
            this.jLc[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jLd = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jLg.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jLg.add(next);
                }
            }
            return this.jLg.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cyq() {
        return this.boZ;
    }

    private boolean Vv() {
        return (this.jLe == null || this.boZ >= this.jLe.length || this.jLe[this.boZ] == null || this.jLc == null || this.boZ >= this.jLc.length || this.jLc[this.boZ] == null) ? false : true;
    }

    public boolean cyr() {
        if (this.boZ >= this.jLc.length || this.jLc[this.boZ] == null || !this.jLc[this.boZ].isGif() || this.jLc[this.boZ].mCount > 0) {
            return false;
        }
        this.jLc[this.boZ].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cyr()) {
            if (this.jLd != null) {
                this.jLd.U(i, z);
            }
        } else if (z) {
            CC(i);
        } else if (Vv() && (bVar = this.jLe[this.boZ]) != null && (imageFileInfo = this.jLc[this.boZ]) != null && bVar.cyy()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.kA(i));
            this.jLb.czv();
            bVar.j(imageFileInfo);
        }
    }

    private void CC(int i) {
        this.jLf = i;
        if (this.jLk == null) {
            this.jLk = new com.baidu.tbadk.core.dialog.a(this.jLb);
            this.jLk.ho(R.string.rorate_tip);
            this.jLk.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jLk != null) {
                        MultiImagePagerAdapter.this.jLk.dismiss();
                    }
                    MultiImagePagerAdapter.this.jLj.jNy.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyt() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyu() {
                            MultiImagePagerAdapter.this.jLd.cyu();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean P(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyv() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.jLf, false);
                }
            });
            this.jLk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jLk != null) {
                        MultiImagePagerAdapter.this.jLk.dismiss();
                    }
                }
            });
            this.jLk.b(this.jLb.getPageContext());
        }
        this.jLk.afG();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jLe[i] == null) {
            this.jLe[i] = new b(i);
        }
        this.mViewPager.addView(this.jLe[i].getView());
        return this.jLe[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jLe[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.boZ = i;
        cys();
    }

    private void cys() {
        if (this.boZ >= 0 && this.jLe != null && this.boZ < this.jLe.length && this.boZ < this.jLc.length && this.jLc[this.boZ] != null) {
            for (int i = 0; i < this.jLe.length; i++) {
                if (this.jLe[i] != null) {
                    this.jLe[i].aWd();
                }
            }
            if (this.jLe[this.boZ] == null) {
                this.jLe[this.boZ] = new b(this.boZ);
            }
            this.jLe[this.boZ].j(this.jLc[this.boZ]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.boZ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean f(String str, Bitmap bitmap) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rW(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jLc != null) {
            for (int i = 0; i < this.jLc.length; i++) {
                ImageFileInfo imageFileInfo = this.jLc[i];
                if (imageFileInfo != null) {
                    this.jLc[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!Vv()) {
                if (!z && this.mIsFromIm) {
                    O(this.mBitmap);
                }
            } else if (this.jLd != null && this.jLd.cyx() && this.jLj != null && this.jLj.jNy != null) {
                this.jLj.jNy.bOc();
                TbImageView tbImageView = this.jLe[this.boZ].Sl;
                try {
                    bitmap = this.jLj.jNy.czY();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.f.bf(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.f.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.jLc[this.boZ].setFilePath(m.b(m.ahb(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jLc[this.boZ].clearAllActions();
                        this.jLc[this.boZ].clearPageActions();
                        this.jLc[this.boZ].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            O(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                O(this.mBitmap);
            }
        }
    }

    private void O(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (f(str, bitmap)) {
                this.jLc[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Sl;
        private ProgressBar iUj;
        private int index;
        private FrameLayout jLn;
        private com.baidu.tbadk.img.b jLo;

        public b(int i) {
            this.iUj = null;
            this.index = -1;
            this.index = i;
            this.jLn = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jLb.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Sl = (TbImageView) this.jLn.findViewById(R.id.progress_tb_imageview);
            this.Sl.setClickable(true);
            this.Sl.setDefaultResource(0);
            this.Sl.setDefaultErrorResource(0);
            this.Sl.setDefaultBgResource(0);
            this.Sl.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Sl.setPadding(0, 0, 0, 0);
            this.jLo = new com.baidu.tbadk.img.b();
            this.Sl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jLd != null) {
                        MultiImagePagerAdapter.this.jLd.cyw();
                    }
                }
            });
            this.iUj = (ProgressBar) this.jLn.findViewById(R.id.progress_tb_imageview_progress);
            this.iUj.setVisibility(8);
        }

        public View getView() {
            return this.jLn;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Sl != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.jLb), (l.ah(MultiImagePagerAdapter.this.jLb) - l.g(MultiImagePagerAdapter.this.jLb, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Sl.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.Sl.setLayoutParams(layoutParams);
                aVar.a(this.Sl);
                if (MultiImagePagerAdapter.this.jLj != null && MultiImagePagerAdapter.this.jLj.jNy != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jLj.jNy.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    MultiImagePagerAdapter.this.jLj.jNy.setLayoutParams(layoutParams2);
                }
                if (aVar.ns() != null && !aVar.ns().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.ns();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aWd();
                this.iUj.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jLo.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iUj.setVisibility(8);
                    return;
                }
                this.jLo.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iUj.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jLj != null) {
                            MultiImagePagerAdapter.this.jLj.cyl();
                        }
                    }
                }, false);
            }
        }

        public void aWd() {
            if (this.jLo != null) {
                this.jLo.asz();
            }
            if (this.Sl != null) {
            }
        }

        public boolean cyy() {
            return this.iUj.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

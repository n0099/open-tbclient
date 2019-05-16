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
    private WriteMultiImgsActivity jKX;
    private ImageFileInfo[] jKY;
    private a jKZ;
    private b[] jLa;
    private int jLb;
    private LinkedList<ImageFileInfo> jLc = new LinkedList<>();
    private int jLd;
    private int jLe;
    private h jLf;
    private com.baidu.tbadk.core.dialog.a jLg;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void U(int i, boolean z);

        void cyt();

        void cyv();

        boolean cyw();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jKX = null;
        this.jKY = null;
        this.mViewPager = null;
        this.jKZ = null;
        this.mCount = 0;
        this.boZ = 0;
        this.jLa = null;
        this.jLd = 120;
        this.jLe = 120;
        this.mIsFromIm = z;
        this.jKX = writeMultiImgsActivity;
        this.jLf = hVar;
        this.jLd = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jLe = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.boZ = e(linkedList, i);
        this.mCount = this.jLc.size();
        this.jKY = new ImageFileInfo[this.mCount];
        this.jLa = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jKY[i2] = this.jLc.get(i2).cloneWithoutFilterAction(true);
            this.jKY[i2].addPageAction(com.baidu.tbadk.img.effect.d.ai(this.jLd, this.jLe));
            linkedList.set(linkedList.indexOf(this.jLc.get(i2)), this.jKY[i2]);
            this.jKY[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jKZ = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jLc.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jLc.add(next);
                }
            }
            return this.jLc.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cyp() {
        return this.boZ;
    }

    private boolean Vv() {
        return (this.jLa == null || this.boZ >= this.jLa.length || this.jLa[this.boZ] == null || this.jKY == null || this.boZ >= this.jKY.length || this.jKY[this.boZ] == null) ? false : true;
    }

    public boolean cyq() {
        if (this.boZ >= this.jKY.length || this.jKY[this.boZ] == null || !this.jKY[this.boZ].isGif() || this.jKY[this.boZ].mCount > 0) {
            return false;
        }
        this.jKY[this.boZ].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cyq()) {
            if (this.jKZ != null) {
                this.jKZ.U(i, z);
            }
        } else if (z) {
            CC(i);
        } else if (Vv() && (bVar = this.jLa[this.boZ]) != null && (imageFileInfo = this.jKY[this.boZ]) != null && bVar.cyx()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.kA(i));
            this.jKX.czu();
            bVar.j(imageFileInfo);
        }
    }

    private void CC(int i) {
        this.jLb = i;
        if (this.jLg == null) {
            this.jLg = new com.baidu.tbadk.core.dialog.a(this.jKX);
            this.jLg.ho(R.string.rorate_tip);
            this.jLg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jLg != null) {
                        MultiImagePagerAdapter.this.jLg.dismiss();
                    }
                    MultiImagePagerAdapter.this.jLf.jNu.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cys() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyt() {
                            MultiImagePagerAdapter.this.jKZ.cyt();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean P(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cyu() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.jLb, false);
                }
            });
            this.jLg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jLg != null) {
                        MultiImagePagerAdapter.this.jLg.dismiss();
                    }
                }
            });
            this.jLg.b(this.jKX.getPageContext());
        }
        this.jLg.afG();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jLa[i] == null) {
            this.jLa[i] = new b(i);
        }
        this.mViewPager.addView(this.jLa[i].getView());
        return this.jLa[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jLa[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.boZ = i;
        cyr();
    }

    private void cyr() {
        if (this.boZ >= 0 && this.jLa != null && this.boZ < this.jLa.length && this.boZ < this.jKY.length && this.jKY[this.boZ] != null) {
            for (int i = 0; i < this.jLa.length; i++) {
                if (this.jLa[i] != null) {
                    this.jLa[i].aWa();
                }
            }
            if (this.jLa[this.boZ] == null) {
                this.jLa[this.boZ] = new b(this.boZ);
            }
            this.jLa[this.boZ].j(this.jKY[this.boZ]);
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
    public void rV(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jKY != null) {
            for (int i = 0; i < this.jKY.length; i++) {
                ImageFileInfo imageFileInfo = this.jKY[i];
                if (imageFileInfo != null) {
                    this.jKY[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!Vv()) {
                if (!z && this.mIsFromIm) {
                    O(this.mBitmap);
                }
            } else if (this.jKZ != null && this.jKZ.cyw() && this.jLf != null && this.jLf.jNu != null) {
                this.jLf.jNu.bNY();
                TbImageView tbImageView = this.jLa[this.boZ].Sm;
                try {
                    bitmap = this.jLf.jNu.czX();
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
                        this.jKY[this.boZ].setFilePath(m.b(m.ahb(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jKY[this.boZ].clearAllActions();
                        this.jKY[this.boZ].clearPageActions();
                        this.jKY[this.boZ].setIsGif(false);
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
                this.jKY[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Sm;
        private ProgressBar iUd;
        private int index;
        private FrameLayout jLj;
        private com.baidu.tbadk.img.b jLk;

        public b(int i) {
            this.iUd = null;
            this.index = -1;
            this.index = i;
            this.jLj = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jKX.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Sm = (TbImageView) this.jLj.findViewById(R.id.progress_tb_imageview);
            this.Sm.setClickable(true);
            this.Sm.setDefaultResource(0);
            this.Sm.setDefaultErrorResource(0);
            this.Sm.setDefaultBgResource(0);
            this.Sm.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Sm.setPadding(0, 0, 0, 0);
            this.jLk = new com.baidu.tbadk.img.b();
            this.Sm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jKZ != null) {
                        MultiImagePagerAdapter.this.jKZ.cyv();
                    }
                }
            });
            this.iUd = (ProgressBar) this.jLj.findViewById(R.id.progress_tb_imageview_progress);
            this.iUd.setVisibility(8);
        }

        public View getView() {
            return this.jLj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Sm != null) {
                int[] b = l.b(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.jKX), (l.ah(MultiImagePagerAdapter.this.jKX) - l.g(MultiImagePagerAdapter.this.jKX, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Sm.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                this.Sm.setLayoutParams(layoutParams);
                aVar.a(this.Sm);
                if (MultiImagePagerAdapter.this.jLf != null && MultiImagePagerAdapter.this.jLf.jNu != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jLf.jNu.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = b[0];
                    layoutParams2.height = b[1];
                    MultiImagePagerAdapter.this.jLf.jNu.setLayoutParams(layoutParams2);
                }
                if (aVar.ns() != null && !aVar.ns().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.ns();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aWa();
                this.iUd.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jLk.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.iUd.setVisibility(8);
                    return;
                }
                this.jLk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.iUd.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jLf != null) {
                            MultiImagePagerAdapter.this.jLf.cyk();
                        }
                    }
                }, false);
            }
        }

        public void aWa() {
            if (this.jLk != null) {
                this.jLk.asz();
            }
            if (this.Sm != null) {
            }
        }

        public boolean cyx() {
            return this.iUd.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager Ze;
    private int bLv;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private WriteMultiImgsActivity ojc;
    private ImageFileInfo[] ojd;
    private a oje;
    private b[] ojf;
    private int ojg;
    private LinkedList<ImageFileInfo> ojh = new LinkedList<>();
    private int oji;
    private int ojj;
    private j ojk;
    private com.baidu.tbadk.core.dialog.a ojl;

    /* loaded from: classes8.dex */
    public interface a {
        void ak(int i, boolean z);

        void dXT();

        void dXV();

        boolean dXW();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.ojc = null;
        this.ojd = null;
        this.Ze = null;
        this.oje = null;
        this.mCount = 0;
        this.bLv = 0;
        this.ojf = null;
        this.oji = 120;
        this.ojj = 120;
        this.mIsFromIm = z;
        this.ojc = writeMultiImgsActivity;
        this.ojk = jVar;
        this.oji = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.ojj = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bLv = b(linkedList, i);
        this.mCount = this.ojh.size();
        this.ojd = new ImageFileInfo[this.mCount];
        this.ojf = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.ojd[i2] = this.ojh.get(i2).cloneWithoutFilterAction(true);
            this.ojd[i2].addPageAction(com.baidu.tbadk.img.effect.d.bd(this.oji, this.ojj));
            linkedList.set(linkedList.indexOf(this.ojh.get(i2)), this.ojd[i2]);
            this.ojd[i2].mCount = 0;
        }
        this.Ze = viewPager;
        this.oje = aVar;
        this.Ze.setOffscreenPageLimit(1);
        this.Ze.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.ojh.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.ojh.add(next);
                }
            }
            return this.ojh.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dXP() {
        return this.bLv;
    }

    private boolean arz() {
        return (this.ojf == null || this.bLv >= this.ojf.length || this.ojf[this.bLv] == null || this.ojd == null || this.bLv >= this.ojd.length || this.ojd[this.bLv] == null) ? false : true;
    }

    public boolean dXQ() {
        if (this.bLv >= this.ojd.length || this.ojd[this.bLv] == null || !this.ojd[this.bLv].isGif() || this.ojd[this.bLv].mCount > 0) {
            return false;
        }
        this.ojd[this.bLv].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dXQ()) {
            if (this.oje != null) {
                this.oje.ak(i, z);
            }
        } else if (z) {
            Ly(i);
        } else if (arz() && (bVar = this.ojf[this.bLv]) != null && (imageFileInfo = this.ojd[this.bLv]) != null && bVar.dXX()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rl(i));
            this.ojc.dZu();
            bVar.k(imageFileInfo);
        }
    }

    private void Ly(int i) {
        this.ojg = i;
        if (this.ojl == null) {
            this.ojl = new com.baidu.tbadk.core.dialog.a(this.ojc);
            this.ojl.nx(R.string.rorate_tip);
            this.ojl.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ojl != null) {
                        MultiImagePagerAdapter.this.ojl.dismiss();
                    }
                    MultiImagePagerAdapter.this.ojk.omp.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dXS() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dXT() {
                            MultiImagePagerAdapter.this.oje.dXT();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean T(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dXU() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.ojg, false);
                }
            });
            this.ojl.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.ojl != null) {
                        MultiImagePagerAdapter.this.ojl.dismiss();
                    }
                }
            });
            this.ojl.b(this.ojc.getPageContext());
        }
        this.ojl.bqx();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ojf[i] == null) {
            this.ojf[i] = new b(i);
        }
        this.Ze.addView(this.ojf[i].getView());
        return this.ojf[i].getView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Ze.removeView(this.ojf[i].getView());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bLv = i;
        dXR();
    }

    private void dXR() {
        if (this.bLv >= 0 && this.ojf != null && this.bLv < this.ojf.length && this.bLv < this.ojd.length && this.ojd[this.bLv] != null) {
            for (int i = 0; i < this.ojf.length; i++) {
                if (this.ojf[i] != null) {
                    this.ojf[i].dPl();
                }
            }
            if (this.ojf[this.bLv] == null) {
                this.ojf[this.bLv] = new b(this.bLv);
            }
            this.ojf[this.bLv].k(this.ojd[this.bLv]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bLv;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            o.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (o.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zG(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        if (this.ojd != null) {
            for (int i = 0; i < this.ojd.length; i++) {
                ImageFileInfo imageFileInfo = this.ojd[i];
                if (imageFileInfo != null) {
                    this.ojd[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!arz()) {
                if (!z && this.mIsFromIm) {
                    S(this.mBitmap);
                }
            } else if (this.oje != null && this.oje.dXW() && this.ojk != null && this.ojk.omp != null) {
                this.ojk.omp.diT();
                TbImageView tbImageView = this.ojf[this.bLv].abB;
                try {
                    bitmap = this.ojk.omp.dZN();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.h.bV(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = null;
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.h.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.ojd[this.bLv].setFilePath(o.saveFileAsPNG(o.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.ojd[this.bLv].setContentUriStr(null);
                        this.ojd[this.bLv].clearAllActions();
                        this.ojd[this.bLv].clearPageActions();
                        this.ojd[this.bLv].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            S(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                S(this.mBitmap);
            }
        }
    }

    private void S(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.ojd[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b {
        private TbImageView abB;
        private int index;
        private ProgressBar nrK;
        private FrameLayout ojo;
        private com.baidu.tbadk.img.b ojp;

        public b(int i) {
            this.nrK = null;
            this.index = -1;
            this.index = i;
            this.ojo = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.ojc.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.abB = (TbImageView) this.ojo.findViewById(R.id.progress_tb_imageview);
            this.abB.setClickable(true);
            this.abB.setDefaultResource(0);
            this.abB.setDefaultBgResource(0);
            this.abB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.abB.setPadding(0, 0, 0, 0);
            this.ojp = new com.baidu.tbadk.img.b();
            this.abB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.oje != null) {
                        MultiImagePagerAdapter.this.oje.dXV();
                    }
                }
            });
            this.nrK = (ProgressBar) this.ojo.findViewById(R.id.progress_tb_imageview_progress);
            this.nrK.setVisibility(8);
        }

        public View getView() {
            return this.ojo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.abB != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.ojc), (l.getEquipmentHeight(MultiImagePagerAdapter.this.ojc) - l.getDimens(MultiImagePagerAdapter.this.ojc, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abB.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.abB.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.abB);
                if (MultiImagePagerAdapter.this.ojk != null && MultiImagePagerAdapter.this.ojk.omp != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.ojk.omp.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.ojk.omp.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void k(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dPl();
                this.nrK.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.ojp.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nrK.setVisibility(8);
                    return;
                }
                this.ojp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nrK.setVisibility(8);
                        if (MultiImagePagerAdapter.this.ojk != null) {
                            MultiImagePagerAdapter.this.ojk.bWa();
                        }
                    }
                }, false);
            }
        }

        public void dPl() {
            if (this.ojp != null) {
                this.ojp.cancelAllAsyncTask();
            }
            if (this.abB != null) {
            }
        }

        public boolean dXX() {
            return this.nrK.getVisibility() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

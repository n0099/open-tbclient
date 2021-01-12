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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager Zi;
    private int bHL;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private WriteMultiImgsActivity nZg;
    private ImageFileInfo[] nZh;
    private a nZi;
    private b[] nZj;
    private int nZk;
    private LinkedList<ImageFileInfo> nZl = new LinkedList<>();
    private int nZm;
    private int nZn;
    private j nZo;
    private com.baidu.tbadk.core.dialog.a nZp;

    /* loaded from: classes7.dex */
    public interface a {
        void ak(int i, boolean z);

        void dVI();

        void dVK();

        boolean dVL();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.nZg = null;
        this.nZh = null;
        this.Zi = null;
        this.nZi = null;
        this.mCount = 0;
        this.bHL = 0;
        this.nZj = null;
        this.nZm = 120;
        this.nZn = 120;
        this.mIsFromIm = z;
        this.nZg = writeMultiImgsActivity;
        this.nZo = jVar;
        this.nZm = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.nZn = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bHL = b(linkedList, i);
        this.mCount = this.nZl.size();
        this.nZh = new ImageFileInfo[this.mCount];
        this.nZj = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.nZh[i2] = this.nZl.get(i2).cloneWithoutFilterAction(true);
            this.nZh[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.nZm, this.nZn));
            linkedList.set(linkedList.indexOf(this.nZl.get(i2)), this.nZh[i2]);
            this.nZh[i2].mCount = 0;
        }
        this.Zi = viewPager;
        this.nZi = aVar;
        this.Zi.setOffscreenPageLimit(1);
        this.Zi.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.nZl.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.nZl.add(next);
                }
            }
            return this.nZl.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dVE() {
        return this.bHL;
    }

    private boolean arb() {
        return (this.nZj == null || this.bHL >= this.nZj.length || this.nZj[this.bHL] == null || this.nZh == null || this.bHL >= this.nZh.length || this.nZh[this.bHL] == null) ? false : true;
    }

    public boolean dVF() {
        if (this.bHL >= this.nZh.length || this.nZh[this.bHL] == null || !this.nZh[this.bHL].isGif() || this.nZh[this.bHL].mCount > 0) {
            return false;
        }
        this.nZh[this.bHL].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dVF()) {
            if (this.nZi != null) {
                this.nZi.ak(i, z);
            }
        } else if (z) {
            Le(i);
        } else if (arb() && (bVar = this.nZj[this.bHL]) != null && (imageFileInfo = this.nZh[this.bHL]) != null && bVar.dVM()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rg(i));
            this.nZg.dXj();
            bVar.k(imageFileInfo);
        }
    }

    private void Le(int i) {
        this.nZk = i;
        if (this.nZp == null) {
            this.nZp = new com.baidu.tbadk.core.dialog.a(this.nZg);
            this.nZp.nu(R.string.rorate_tip);
            this.nZp.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nZp != null) {
                        MultiImagePagerAdapter.this.nZp.dismiss();
                    }
                    MultiImagePagerAdapter.this.nZo.ocw.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dVH() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dVI() {
                            MultiImagePagerAdapter.this.nZi.dVI();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dVJ() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.nZk, false);
                }
            });
            this.nZp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nZp != null) {
                        MultiImagePagerAdapter.this.nZp.dismiss();
                    }
                }
            });
            this.nZp.b(this.nZg.getPageContext());
        }
        this.nZp.bqe();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.nZj[i] == null) {
            this.nZj[i] = new b(i);
        }
        this.Zi.addView(this.nZj[i].getView());
        return this.nZj[i].getView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Zi.removeView(this.nZj[i].getView());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bHL = i;
        dVG();
    }

    private void dVG() {
        if (this.bHL >= 0 && this.nZj != null && this.bHL < this.nZj.length && this.bHL < this.nZh.length && this.nZh[this.bHL] != null) {
            for (int i = 0; i < this.nZj.length; i++) {
                if (this.nZj[i] != null) {
                    this.nZj[i].dNa();
                }
            }
            if (this.nZj[this.bHL] == null) {
                this.nZj[this.bHL] = new b(this.bHL);
            }
            this.nZj[this.bHL].k(this.nZh[this.bHL]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bHL;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            n.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void zl(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        if (this.nZh != null) {
            for (int i = 0; i < this.nZh.length; i++) {
                ImageFileInfo imageFileInfo = this.nZh[i];
                if (imageFileInfo != null) {
                    this.nZh[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!arb()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.nZi != null && this.nZi.dVL() && this.nZo != null && this.nZo.ocw != null) {
                this.nZo.ocw.dgS();
                TbImageView tbImageView = this.nZj[this.bHL].abG;
                try {
                    bitmap = this.nZo.ocw.dXC();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.g.bZ(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = null;
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.g.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.nZh[this.bHL].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.nZh[this.bHL].setContentUriStr(null);
                        this.nZh[this.bHL].clearAllActions();
                        this.nZh[this.bHL].clearPageActions();
                        this.nZh[this.bHL].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            T(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                T(this.mBitmap);
            }
        }
    }

    private void T(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.nZh[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b {
        private TbImageView abG;
        private int index;
        private FrameLayout nZs;
        private com.baidu.tbadk.img.b nZt;
        private ProgressBar nib;

        public b(int i) {
            this.nib = null;
            this.index = -1;
            this.index = i;
            this.nZs = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.nZg.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.abG = (TbImageView) this.nZs.findViewById(R.id.progress_tb_imageview);
            this.abG.setClickable(true);
            this.abG.setDefaultResource(0);
            this.abG.setDefaultBgResource(0);
            this.abG.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.abG.setPadding(0, 0, 0, 0);
            this.nZt = new com.baidu.tbadk.img.b();
            this.abG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.nZi != null) {
                        MultiImagePagerAdapter.this.nZi.dVK();
                    }
                }
            });
            this.nib = (ProgressBar) this.nZs.findViewById(R.id.progress_tb_imageview_progress);
            this.nib.setVisibility(8);
        }

        public View getView() {
            return this.nZs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.abG != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.nZg), (l.getEquipmentHeight(MultiImagePagerAdapter.this.nZg) - l.getDimens(MultiImagePagerAdapter.this.nZg, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abG.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.abG.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.abG);
                if (MultiImagePagerAdapter.this.nZo != null && MultiImagePagerAdapter.this.nZo.ocw != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.nZo.ocw.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.nZo.ocw.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void k(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dNa();
                this.nib.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.nZt.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nib.setVisibility(8);
                    return;
                }
                this.nZt.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nib.setVisibility(8);
                        if (MultiImagePagerAdapter.this.nZo != null) {
                            MultiImagePagerAdapter.this.nZo.bVw();
                        }
                    }
                }, false);
            }
        }

        public void dNa() {
            if (this.nZt != null) {
                this.nZt.cancelAllAsyncTask();
            }
            if (this.abG != null) {
            }
        }

        public boolean dVM() {
            return this.nib.getVisibility() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

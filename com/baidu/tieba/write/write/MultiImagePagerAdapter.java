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
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;
    private WriteMultiImgsActivity nLI;
    private ImageFileInfo[] nLJ;
    private a nLK;
    private b[] nLL;
    private int nLM;
    private LinkedList<ImageFileInfo> nLN = new LinkedList<>();
    private int nLO;
    private int nLP;
    private j nLQ;
    private com.baidu.tbadk.core.dialog.a nLR;

    /* loaded from: classes3.dex */
    public interface a {
        void am(int i, boolean z);

        void dUU();

        void dUW();

        boolean dUX();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.nLI = null;
        this.nLJ = null;
        this.mViewPager = null;
        this.nLK = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.nLL = null;
        this.nLO = 120;
        this.nLP = 120;
        this.mIsFromIm = z;
        this.nLI = writeMultiImgsActivity;
        this.nLQ = jVar;
        this.nLO = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.nLP = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.nLN.size();
        this.nLJ = new ImageFileInfo[this.mCount];
        this.nLL = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.nLJ[i2] = this.nLN.get(i2).cloneWithoutFilterAction(true);
            this.nLJ[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.nLO, this.nLP));
            linkedList.set(linkedList.indexOf(this.nLN.get(i2)), this.nLJ[i2]);
            this.nLJ[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.nLK = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.nLN.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.nLN.add(next);
                }
            }
            return this.nLN.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dUQ() {
        return this.mCurrentIndex;
    }

    private boolean are() {
        return (this.nLL == null || this.mCurrentIndex >= this.nLL.length || this.nLL[this.mCurrentIndex] == null || this.nLJ == null || this.mCurrentIndex >= this.nLJ.length || this.nLJ[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dUR() {
        if (this.mCurrentIndex >= this.nLJ.length || this.nLJ[this.mCurrentIndex] == null || !this.nLJ[this.mCurrentIndex].isGif() || this.nLJ[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.nLJ[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dUR()) {
            if (this.nLK != null) {
                this.nLK.am(i, z);
            }
        } else if (z) {
            LE(i);
        } else if (are() && (bVar = this.nLL[this.mCurrentIndex]) != null && (imageFileInfo = this.nLJ[this.mCurrentIndex]) != null && bVar.dUY()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rB(i));
            this.nLI.dWr();
            bVar.l(imageFileInfo);
        }
    }

    private void LE(int i) {
        this.nLM = i;
        if (this.nLR == null) {
            this.nLR = new com.baidu.tbadk.core.dialog.a(this.nLI);
            this.nLR.ow(R.string.rorate_tip);
            this.nLR.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nLR != null) {
                        MultiImagePagerAdapter.this.nLR.dismiss();
                    }
                    MultiImagePagerAdapter.this.nLQ.nOJ.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dUT() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dUU() {
                            MultiImagePagerAdapter.this.nLK.dUU();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dUV() {
                        }
                    });
                    MultiImagePagerAdapter.this.al(MultiImagePagerAdapter.this.nLM, false);
                }
            });
            this.nLR.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.nLR != null) {
                        MultiImagePagerAdapter.this.nLR.dismiss();
                    }
                }
            });
            this.nLR.b(this.nLI.getPageContext());
        }
        this.nLR.bpc();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.nLL[i] == null) {
            this.nLL[i] = new b(i);
        }
        this.mViewPager.addView(this.nLL[i].getView());
        return this.nLL[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.nLL[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dUS();
    }

    private void dUS() {
        if (this.mCurrentIndex >= 0 && this.nLL != null && this.mCurrentIndex < this.nLL.length && this.mCurrentIndex < this.nLJ.length && this.nLJ[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.nLL.length; i++) {
                if (this.nLL[i] != null) {
                    this.nLL[i].dLo();
                }
            }
            if (this.nLL[this.mCurrentIndex] == null) {
                this.nLL[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.nLL[this.mCurrentIndex].l(this.nLJ[this.mCurrentIndex]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    @Override // android.support.v4.view.PagerAdapter
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

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yG(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.nLJ != null) {
            for (int i = 0; i < this.nLJ.length; i++) {
                ImageFileInfo imageFileInfo = this.nLJ[i];
                if (imageFileInfo != null) {
                    this.nLJ[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!are()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.nLK != null && this.nLK.dUX() && this.nLQ != null && this.nLQ.nOJ != null) {
                this.nLQ.nOJ.dgp();
                TbImageView tbImageView = this.nLL[this.mCurrentIndex].ZW;
                try {
                    bitmap = this.nLQ.nOJ.dWT();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bG = com.baidu.tbadk.util.h.bG(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bG;
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = bitmap;
                        bitmap3 = null;
                        if (bitmap2 == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap2 == null && bitmap3 != null && (a2 = com.baidu.tbadk.util.h.a(bitmap3, bitmap2, bitmap3.getWidth(), bitmap3.getHeight())) != null) {
                        this.nLJ[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.nLJ[this.mCurrentIndex].setContentUriStr(null);
                        this.nLJ[this.mCurrentIndex].clearAllActions();
                        this.nLJ[this.mCurrentIndex].clearPageActions();
                        this.nLJ[this.mCurrentIndex].setIsGif(false);
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
                this.nLJ[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView ZW;
        private int index;
        private ProgressBar mSc;
        private FrameLayout nLU;
        private com.baidu.tbadk.img.b nLV;

        public b(int i) {
            this.mSc = null;
            this.index = -1;
            this.index = i;
            this.nLU = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.nLI.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.ZW = (TbImageView) this.nLU.findViewById(R.id.progress_tb_imageview);
            this.ZW.setClickable(true);
            this.ZW.setDefaultResource(0);
            this.ZW.setDefaultErrorResource(0);
            this.ZW.setDefaultBgResource(0);
            this.ZW.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ZW.setPadding(0, 0, 0, 0);
            this.nLV = new com.baidu.tbadk.img.b();
            this.ZW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.nLK != null) {
                        MultiImagePagerAdapter.this.nLK.dUW();
                    }
                }
            });
            this.mSc = (ProgressBar) this.nLU.findViewById(R.id.progress_tb_imageview_progress);
            this.mSc.setVisibility(8);
        }

        public View getView() {
            return this.nLU;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.ZW != null) {
                int[] imageResize = com.baidu.adp.lib.util.l.getImageResize(aVar.getWidth(), aVar.getHeight(), com.baidu.adp.lib.util.l.getEquipmentWidth(MultiImagePagerAdapter.this.nLI), (com.baidu.adp.lib.util.l.getEquipmentHeight(MultiImagePagerAdapter.this.nLI) - com.baidu.adp.lib.util.l.getDimens(MultiImagePagerAdapter.this.nLI, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ZW.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.ZW.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.ZW);
                if (MultiImagePagerAdapter.this.nLQ != null && MultiImagePagerAdapter.this.nLQ.nOJ != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.nLQ.nOJ.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.nLQ.nOJ.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dLo();
                this.mSc.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.nLV.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.mSc.setVisibility(8);
                    return;
                }
                this.nLV.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.mSc.setVisibility(8);
                        if (MultiImagePagerAdapter.this.nLQ != null) {
                            MultiImagePagerAdapter.this.nLQ.bTE();
                        }
                    }
                }, false);
            }
        }

        public void dLo() {
            if (this.nLV != null) {
                this.nLV.cancelAllAsyncTask();
            }
            if (this.ZW != null) {
            }
        }

        public boolean dUY() {
            return this.mSc.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

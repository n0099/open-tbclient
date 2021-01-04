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
/* loaded from: classes8.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager Zk;
    private int bMx;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private WriteMultiImgsActivity odO;
    private ImageFileInfo[] odP;
    private a odQ;
    private b[] odR;
    private int odS;
    private LinkedList<ImageFileInfo> odT = new LinkedList<>();
    private int odU;
    private int odV;
    private j odW;
    private com.baidu.tbadk.core.dialog.a odX;

    /* loaded from: classes8.dex */
    public interface a {
        void ak(int i, boolean z);

        void dZB();

        boolean dZC();

        void dZz();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.odO = null;
        this.odP = null;
        this.Zk = null;
        this.odQ = null;
        this.mCount = 0;
        this.bMx = 0;
        this.odR = null;
        this.odU = 120;
        this.odV = 120;
        this.mIsFromIm = z;
        this.odO = writeMultiImgsActivity;
        this.odW = jVar;
        this.odU = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.odV = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bMx = b(linkedList, i);
        this.mCount = this.odT.size();
        this.odP = new ImageFileInfo[this.mCount];
        this.odR = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.odP[i2] = this.odT.get(i2).cloneWithoutFilterAction(true);
            this.odP[i2].addPageAction(com.baidu.tbadk.img.effect.d.bg(this.odU, this.odV));
            linkedList.set(linkedList.indexOf(this.odT.get(i2)), this.odP[i2]);
            this.odP[i2].mCount = 0;
        }
        this.Zk = viewPager;
        this.odQ = aVar;
        this.Zk.setOffscreenPageLimit(1);
        this.Zk.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.odT.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.odT.add(next);
                }
            }
            return this.odT.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dZv() {
        return this.bMx;
    }

    private boolean auV() {
        return (this.odR == null || this.bMx >= this.odR.length || this.odR[this.bMx] == null || this.odP == null || this.bMx >= this.odP.length || this.odP[this.bMx] == null) ? false : true;
    }

    public boolean dZw() {
        if (this.bMx >= this.odP.length || this.odP[this.bMx] == null || !this.odP[this.bMx].isGif() || this.odP[this.bMx].mCount > 0) {
            return false;
        }
        this.odP[this.bMx].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dZw()) {
            if (this.odQ != null) {
                this.odQ.ak(i, z);
            }
        } else if (z) {
            ML(i);
        } else if (auV() && (bVar = this.odR[this.bMx]) != null && (imageFileInfo = this.odP[this.bMx]) != null && bVar.dZD()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.sM(i));
            this.odO.eba();
            bVar.k(imageFileInfo);
        }
    }

    private void ML(int i) {
        this.odS = i;
        if (this.odX == null) {
            this.odX = new com.baidu.tbadk.core.dialog.a(this.odO);
            this.odX.pa(R.string.rorate_tip);
            this.odX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.odX != null) {
                        MultiImagePagerAdapter.this.odX.dismiss();
                    }
                    MultiImagePagerAdapter.this.odW.ohd.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dZy() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dZz() {
                            MultiImagePagerAdapter.this.odQ.dZz();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean U(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dZA() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.odS, false);
                }
            });
            this.odX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.odX != null) {
                        MultiImagePagerAdapter.this.odX.dismiss();
                    }
                }
            });
            this.odX.b(this.odO.getPageContext());
        }
        this.odX.btX();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.odR[i] == null) {
            this.odR[i] = new b(i);
        }
        this.Zk.addView(this.odR[i].getView());
        return this.odR[i].getView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.Zk.removeView(this.odR[i].getView());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bMx = i;
        dZx();
    }

    private void dZx() {
        if (this.bMx >= 0 && this.odR != null && this.bMx < this.odR.length && this.bMx < this.odP.length && this.odP[this.bMx] != null) {
            for (int i = 0; i < this.odR.length; i++) {
                if (this.odR[i] != null) {
                    this.odR[i].dQR();
                }
            }
            if (this.odR[this.bMx] == null) {
                this.odR[this.bMx] = new b(this.bMx);
            }
            this.odR[this.bMx].k(this.odP[this.bMx]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bMx;
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
    public void zp(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        if (this.odP != null) {
            for (int i = 0; i < this.odP.length; i++) {
                ImageFileInfo imageFileInfo = this.odP[i];
                if (imageFileInfo != null) {
                    this.odP[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!auV()) {
                if (!z && this.mIsFromIm) {
                    T(this.mBitmap);
                }
            } else if (this.odQ != null && this.odQ.dZC() && this.odW != null && this.odW.ohd != null) {
                this.odW.ohd.dkJ();
                TbImageView tbImageView = this.odR[this.bMx].abI;
                try {
                    bitmap = this.odW.ohd.ebt();
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
                        this.odP[this.bMx].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.odP[this.bMx].setContentUriStr(null);
                        this.odP[this.bMx].clearAllActions();
                        this.odP[this.bMx].clearPageActions();
                        this.odP[this.bMx].setIsGif(false);
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
                this.odP[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b {
        private TbImageView abI;
        private int index;
        private ProgressBar nmH;
        private FrameLayout oea;
        private com.baidu.tbadk.img.b oeb;

        public b(int i) {
            this.nmH = null;
            this.index = -1;
            this.index = i;
            this.oea = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.odO.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.abI = (TbImageView) this.oea.findViewById(R.id.progress_tb_imageview);
            this.abI.setClickable(true);
            this.abI.setDefaultResource(0);
            this.abI.setDefaultBgResource(0);
            this.abI.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.abI.setPadding(0, 0, 0, 0);
            this.oeb = new com.baidu.tbadk.img.b();
            this.abI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.odQ != null) {
                        MultiImagePagerAdapter.this.odQ.dZB();
                    }
                }
            });
            this.nmH = (ProgressBar) this.oea.findViewById(R.id.progress_tb_imageview_progress);
            this.nmH.setVisibility(8);
        }

        public View getView() {
            return this.oea;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.abI != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.odO), (l.getEquipmentHeight(MultiImagePagerAdapter.this.odO) - l.getDimens(MultiImagePagerAdapter.this.odO, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abI.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.abI.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.abI);
                if (MultiImagePagerAdapter.this.odW != null && MultiImagePagerAdapter.this.odW.ohd != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.odW.ohd.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.odW.ohd.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void k(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dQR();
                this.nmH.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.oeb.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nmH.setVisibility(8);
                    return;
                }
                this.oeb.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nmH.setVisibility(8);
                        if (MultiImagePagerAdapter.this.odW != null) {
                            MultiImagePagerAdapter.this.odW.bZn();
                        }
                    }
                }, false);
            }
        }

        public void dQR() {
            if (this.oeb != null) {
                this.oeb.cancelAllAsyncTask();
            }
            if (this.abI != null) {
            }
        }

        public boolean dZD() {
            return this.nmH.getVisibility() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}

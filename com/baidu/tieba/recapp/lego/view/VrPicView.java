package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.b.a.d.a;
import com.b.a.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View abp;
    private g gix;
    private GLTextureView gmS;
    private View gmT;
    private String gmU;
    private int gmV;
    private int gmW;
    private a.b gmX;
    private CustomMessageListener gmY;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gix = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gmX == null || aVar == null || aVar.mZ() == null) {
                    VrPicView.this.lK(true);
                    return;
                }
                VrPicView.this.lL(false);
                Bitmap mZ = aVar.mZ();
                VrPicView.this.gix.i(mZ.getWidth(), mZ.getHeight());
                try {
                    VrPicView.this.gmX.c(mZ);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = mZ.getWidth();
                        int height = mZ.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(mZ, width / 2, height / 2, true);
                        VrPicView.this.gix.i(width / 2, height / 2);
                        VrPicView.this.gmX.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lK(true);
                    }
                }
            }
        };
        this.gmY = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lK(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gix = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gmX == null || aVar == null || aVar.mZ() == null) {
                    VrPicView.this.lK(true);
                    return;
                }
                VrPicView.this.lL(false);
                Bitmap mZ = aVar.mZ();
                VrPicView.this.gix.i(mZ.getWidth(), mZ.getHeight());
                try {
                    VrPicView.this.gmX.c(mZ);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = mZ.getWidth();
                        int height = mZ.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(mZ, width / 2, height / 2, true);
                        VrPicView.this.gix.i(width / 2, height / 2);
                        VrPicView.this.gmX.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lK(true);
                    }
                }
            }
        };
        this.gmY = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lK(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gix = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gmX == null || aVar == null || aVar.mZ() == null) {
                    VrPicView.this.lK(true);
                    return;
                }
                VrPicView.this.lL(false);
                Bitmap mZ = aVar.mZ();
                VrPicView.this.gix.i(mZ.getWidth(), mZ.getHeight());
                try {
                    VrPicView.this.gmX.c(mZ);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = mZ.getWidth();
                        int height = mZ.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(mZ, width / 2, height / 2, true);
                        VrPicView.this.gix.i(width / 2, height / 2);
                        VrPicView.this.gmX.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lK(true);
                    }
                }
            }
        };
        this.gmY = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lK(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.abp = LayoutInflater.from(context).inflate(d.i.card_vr_pic_view, (ViewGroup) this, true);
            this.gmS = this.abp.findViewById(d.g.lego_gl_view);
            this.gmT = this.abp.findViewById(d.g.error_tips);
            this.mPromptView = this.abp.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.adX != null) {
            this.mPageContext = tbPageContext;
            this.gmY.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gmY);
            this.gmU = advertAppInfo.adX.aei;
            if (TextUtils.isEmpty(this.gmU)) {
                this.mPageContext.showToast(d.k.lego_error_url);
                return;
            }
            this.gmV = advertAppInfo.adX.width;
            this.gmW = advertAppInfo.adX.height;
            if (this.gix == null) {
                this.gix = g.e(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gmX = bVar;
                        VrPicView.this.boG();
                    }
                }).m(true).b(this.gmS);
                this.gix.onResume(this.mPageContext.getPageActivity());
                return;
            }
            start(this.gmU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boG() {
        if (!StringUtils.isNull(this.gmU) && this.gmX != null) {
            lK(false);
            lL(true);
            c.ig().a(this.gmU, 10, this.mCallback, this.gmV, this.gmW, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void start(String str) {
        boG();
    }

    public void onDestroy() {
        if (this.gix != null) {
            this.gix.onDestroy();
        }
    }

    public void onResume() {
        if (this.gix != null) {
            this.gix.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gix != null) {
            this.gix.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(boolean z) {
        if (z) {
            this.gmT.setVisibility(0);
        } else {
            this.gmT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(boolean z) {
        if (z) {
            this.mPromptView.setVisibility(0);
        } else {
            this.mPromptView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            onPause();
        } else if (i == 0) {
            onResume();
        }
    }
}

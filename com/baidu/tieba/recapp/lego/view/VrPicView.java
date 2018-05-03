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
    private View Tl;
    private g fVZ;
    private CustomMessageListener gaA;
    private GLTextureView gau;
    private View gav;
    private String gaw;
    private int gax;
    private int gay;
    private a.b gaz;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fVZ = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gaz == null || aVar == null || aVar.km() == null) {
                    VrPicView.this.lD(true);
                    return;
                }
                VrPicView.this.lE(false);
                Bitmap km = aVar.km();
                VrPicView.this.fVZ.b(km.getWidth(), km.getHeight());
                try {
                    VrPicView.this.gaz.d(km);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = km.getWidth();
                        int height = km.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(km, width / 2, height / 2, true);
                        VrPicView.this.fVZ.b(width / 2, height / 2);
                        VrPicView.this.gaz.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lD(true);
                    }
                }
            }
        };
        this.gaA = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lD(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.fVZ = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gaz == null || aVar == null || aVar.km() == null) {
                    VrPicView.this.lD(true);
                    return;
                }
                VrPicView.this.lE(false);
                Bitmap km = aVar.km();
                VrPicView.this.fVZ.b(km.getWidth(), km.getHeight());
                try {
                    VrPicView.this.gaz.d(km);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = km.getWidth();
                        int height = km.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(km, width / 2, height / 2, true);
                        VrPicView.this.fVZ.b(width / 2, height / 2);
                        VrPicView.this.gaz.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lD(true);
                    }
                }
            }
        };
        this.gaA = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lD(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVZ = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gaz == null || aVar == null || aVar.km() == null) {
                    VrPicView.this.lD(true);
                    return;
                }
                VrPicView.this.lE(false);
                Bitmap km = aVar.km();
                VrPicView.this.fVZ.b(km.getWidth(), km.getHeight());
                try {
                    VrPicView.this.gaz.d(km);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = km.getWidth();
                        int height = km.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(km, width / 2, height / 2, true);
                        VrPicView.this.fVZ.b(width / 2, height / 2);
                        VrPicView.this.gaz.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lD(true);
                    }
                }
            }
        };
        this.gaA = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lD(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.Tl = LayoutInflater.from(context).inflate(d.i.card_vr_pic_view, (ViewGroup) this, true);
            this.gau = this.Tl.findViewById(d.g.lego_gl_view);
            this.gav = this.Tl.findViewById(d.g.error_tips);
            this.mPromptView = this.Tl.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.Wb != null) {
            this.mPageContext = tbPageContext;
            this.gaA.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gaA);
            this.gaw = advertAppInfo.Wb.Wl;
            if (TextUtils.isEmpty(this.gaw)) {
                this.mPageContext.showToast(d.k.lego_error_url);
                return;
            }
            this.gax = advertAppInfo.Wb.width;
            this.gay = advertAppInfo.Wb.height;
            if (this.fVZ == null) {
                this.fVZ = g.f(tbPageContext.getPageActivity()).l(101).m(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gaz = bVar;
                        VrPicView.this.bjI();
                    }
                }).k(true).b(this.gau);
                this.fVZ.onResume(this.mPageContext.getPageActivity());
                return;
            }
            start(this.gaw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjI() {
        if (!StringUtils.isNull(this.gaw) && this.gaz != null) {
            lD(false);
            lE(true);
            c.fp().a(this.gaw, 10, this.mCallback, this.gax, this.gay, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void start(String str) {
        bjI();
    }

    public void onDestroy() {
        if (this.fVZ != null) {
            this.fVZ.onDestroy();
        }
    }

    public void onResume() {
        if (this.fVZ != null) {
            this.fVZ.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.fVZ != null) {
            this.fVZ.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(boolean z) {
        if (z) {
            this.gav.setVisibility(0);
        } else {
            this.gav.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(boolean z) {
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

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
import com.baidu.tieba.e;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View ajk;
    private g gDX;
    private CustomMessageListener gIA;
    private GLTextureView gIu;
    private View gIv;
    private String gIw;
    private int gIx;
    private int gIy;
    private a.b gIz;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gDX = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gIz == null || aVar == null || aVar.oq() == null) {
                    VrPicView.this.mH(true);
                    return;
                }
                VrPicView.this.mI(false);
                Bitmap oq = aVar.oq();
                VrPicView.this.gDX.l(oq.getWidth(), oq.getHeight());
                try {
                    VrPicView.this.gIz.d(oq);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oq.getWidth();
                        int height = oq.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oq, width / 2, height / 2, true);
                        VrPicView.this.gDX.l(width / 2, height / 2);
                        VrPicView.this.gIz.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mH(true);
                    }
                }
            }
        };
        this.gIA = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mH(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gDX = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gIz == null || aVar == null || aVar.oq() == null) {
                    VrPicView.this.mH(true);
                    return;
                }
                VrPicView.this.mI(false);
                Bitmap oq = aVar.oq();
                VrPicView.this.gDX.l(oq.getWidth(), oq.getHeight());
                try {
                    VrPicView.this.gIz.d(oq);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oq.getWidth();
                        int height = oq.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oq, width / 2, height / 2, true);
                        VrPicView.this.gDX.l(width / 2, height / 2);
                        VrPicView.this.gIz.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mH(true);
                    }
                }
            }
        };
        this.gIA = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mH(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gDX = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gIz == null || aVar == null || aVar.oq() == null) {
                    VrPicView.this.mH(true);
                    return;
                }
                VrPicView.this.mI(false);
                Bitmap oq = aVar.oq();
                VrPicView.this.gDX.l(oq.getWidth(), oq.getHeight());
                try {
                    VrPicView.this.gIz.d(oq);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oq.getWidth();
                        int height = oq.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oq, width / 2, height / 2, true);
                        VrPicView.this.gDX.l(width / 2, height / 2);
                        VrPicView.this.gIz.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mH(true);
                    }
                }
            }
        };
        this.gIA = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mH(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.ajk = LayoutInflater.from(context).inflate(e.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gIu = this.ajk.findViewById(e.g.lego_gl_view);
            this.gIv = this.ajk.findViewById(e.g.error_tips);
            this.mPromptView = this.ajk.findViewById(e.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.ama != null) {
            this.mPageContext = tbPageContext;
            this.gIA.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gIA);
            this.gIw = advertAppInfo.ama.aml;
            if (TextUtils.isEmpty(this.gIw)) {
                this.mPageContext.showToast(e.j.lego_error_url);
                return;
            }
            this.gIx = advertAppInfo.ama.width;
            this.gIy = advertAppInfo.ama.height;
            if (this.gDX == null) {
                this.gDX = g.h(tbPageContext.getPageActivity()).M(101).N(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gIz = bVar;
                        VrPicView.this.bte();
                    }
                }).I(true).b(this.gIu);
                this.gDX.onResume(this.mPageContext.getPageActivity());
                return;
            }
            al(this.gIw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bte() {
        if (!StringUtils.isNull(this.gIw) && this.gIz != null) {
            mH(false);
            mI(true);
            c.jA().a(this.gIw, 10, this.mCallback, this.gIx, this.gIy, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void al(String str) {
        bte();
    }

    public void onDestroy() {
        if (this.gDX != null) {
            this.gDX.onDestroy();
        }
    }

    public void onResume() {
        if (this.gDX != null) {
            this.gDX.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gDX != null) {
            this.gDX.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mH(boolean z) {
        if (z) {
            this.gIv.setVisibility(0);
        } else {
            this.gIv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(boolean z) {
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

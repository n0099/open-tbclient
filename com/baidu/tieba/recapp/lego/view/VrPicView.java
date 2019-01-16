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
    private View ano;
    private g gOI;
    private GLTextureView gTh;
    private View gTi;
    private String gTj;
    private int gTk;
    private int gTl;
    private a.b gTm;
    private CustomMessageListener gTn;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gOI = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gTm == null || aVar == null || aVar.ot() == null) {
                    VrPicView.this.mO(true);
                    return;
                }
                VrPicView.this.mP(false);
                Bitmap ot = aVar.ot();
                VrPicView.this.gOI.l(ot.getWidth(), ot.getHeight());
                try {
                    VrPicView.this.gTm.d(ot);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ot.getWidth();
                        int height = ot.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ot, width / 2, height / 2, true);
                        VrPicView.this.gOI.l(width / 2, height / 2);
                        VrPicView.this.gTm.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mO(true);
                    }
                }
            }
        };
        this.gTn = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mO(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gOI = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gTm == null || aVar == null || aVar.ot() == null) {
                    VrPicView.this.mO(true);
                    return;
                }
                VrPicView.this.mP(false);
                Bitmap ot = aVar.ot();
                VrPicView.this.gOI.l(ot.getWidth(), ot.getHeight());
                try {
                    VrPicView.this.gTm.d(ot);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ot.getWidth();
                        int height = ot.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ot, width / 2, height / 2, true);
                        VrPicView.this.gOI.l(width / 2, height / 2);
                        VrPicView.this.gTm.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mO(true);
                    }
                }
            }
        };
        this.gTn = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mO(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gOI = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gTm == null || aVar == null || aVar.ot() == null) {
                    VrPicView.this.mO(true);
                    return;
                }
                VrPicView.this.mP(false);
                Bitmap ot = aVar.ot();
                VrPicView.this.gOI.l(ot.getWidth(), ot.getHeight());
                try {
                    VrPicView.this.gTm.d(ot);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ot.getWidth();
                        int height = ot.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ot, width / 2, height / 2, true);
                        VrPicView.this.gOI.l(width / 2, height / 2);
                        VrPicView.this.gTm.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mO(true);
                    }
                }
            }
        };
        this.gTn = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mO(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.ano = LayoutInflater.from(context).inflate(e.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gTh = this.ano.findViewById(e.g.lego_gl_view);
            this.gTi = this.ano.findViewById(e.g.error_tips);
            this.mPromptView = this.ano.findViewById(e.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.aqd != null) {
            this.mPageContext = tbPageContext;
            this.gTn.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gTn);
            this.gTj = advertAppInfo.aqd.aqo;
            if (TextUtils.isEmpty(this.gTj)) {
                this.mPageContext.showToast(e.j.lego_error_url);
                return;
            }
            this.gTk = advertAppInfo.aqd.width;
            this.gTl = advertAppInfo.aqd.height;
            if (this.gOI == null) {
                this.gOI = g.h(tbPageContext.getPageActivity()).M(101).N(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gTm = bVar;
                        VrPicView.this.bwr();
                    }
                }).I(true).b(this.gTh);
                this.gOI.onResume(this.mPageContext.getPageActivity());
                return;
            }
            al(this.gTj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwr() {
        if (!StringUtils.isNull(this.gTj) && this.gTm != null) {
            mO(false);
            mP(true);
            c.jA().a(this.gTj, 10, this.mCallback, this.gTk, this.gTl, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void al(String str) {
        bwr();
    }

    public void onDestroy() {
        if (this.gOI != null) {
            this.gOI.onDestroy();
        }
    }

    public void onResume() {
        if (this.gOI != null) {
            this.gOI.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gOI != null) {
            this.gOI.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(boolean z) {
        if (z) {
            this.gTi.setVisibility(0);
        } else {
            this.gTi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
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

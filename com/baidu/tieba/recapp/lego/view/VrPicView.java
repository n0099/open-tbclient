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
    private View amM;
    private g gNE;
    private GLTextureView gSc;
    private View gSd;
    private String gSe;
    private int gSf;
    private int gSg;
    private a.b gSh;
    private CustomMessageListener gSi;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gNE = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gSh == null || aVar == null || aVar.op() == null) {
                    VrPicView.this.mN(true);
                    return;
                }
                VrPicView.this.mO(false);
                Bitmap op = aVar.op();
                VrPicView.this.gNE.l(op.getWidth(), op.getHeight());
                try {
                    VrPicView.this.gSh.d(op);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = op.getWidth();
                        int height = op.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(op, width / 2, height / 2, true);
                        VrPicView.this.gNE.l(width / 2, height / 2);
                        VrPicView.this.gSh.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mN(true);
                    }
                }
            }
        };
        this.gSi = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mN(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gNE = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gSh == null || aVar == null || aVar.op() == null) {
                    VrPicView.this.mN(true);
                    return;
                }
                VrPicView.this.mO(false);
                Bitmap op = aVar.op();
                VrPicView.this.gNE.l(op.getWidth(), op.getHeight());
                try {
                    VrPicView.this.gSh.d(op);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = op.getWidth();
                        int height = op.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(op, width / 2, height / 2, true);
                        VrPicView.this.gNE.l(width / 2, height / 2);
                        VrPicView.this.gSh.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mN(true);
                    }
                }
            }
        };
        this.gSi = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mN(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gNE = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gSh == null || aVar == null || aVar.op() == null) {
                    VrPicView.this.mN(true);
                    return;
                }
                VrPicView.this.mO(false);
                Bitmap op = aVar.op();
                VrPicView.this.gNE.l(op.getWidth(), op.getHeight());
                try {
                    VrPicView.this.gSh.d(op);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = op.getWidth();
                        int height = op.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(op, width / 2, height / 2, true);
                        VrPicView.this.gNE.l(width / 2, height / 2);
                        VrPicView.this.gSh.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mN(true);
                    }
                }
            }
        };
        this.gSi = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mN(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.amM = LayoutInflater.from(context).inflate(e.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gSc = this.amM.findViewById(e.g.lego_gl_view);
            this.gSd = this.amM.findViewById(e.g.error_tips);
            this.mPromptView = this.amM.findViewById(e.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.apB != null) {
            this.mPageContext = tbPageContext;
            this.gSi.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gSi);
            this.gSe = advertAppInfo.apB.apM;
            if (TextUtils.isEmpty(this.gSe)) {
                this.mPageContext.showToast(e.j.lego_error_url);
                return;
            }
            this.gSf = advertAppInfo.apB.width;
            this.gSg = advertAppInfo.apB.height;
            if (this.gNE == null) {
                this.gNE = g.h(tbPageContext.getPageActivity()).M(101).N(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gSh = bVar;
                        VrPicView.this.bvI();
                    }
                }).I(true).b(this.gSc);
                this.gNE.onResume(this.mPageContext.getPageActivity());
                return;
            }
            al(this.gSe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        if (!StringUtils.isNull(this.gSe) && this.gSh != null) {
            mN(false);
            mO(true);
            c.jA().a(this.gSe, 10, this.mCallback, this.gSf, this.gSg, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void al(String str) {
        bvI();
    }

    public void onDestroy() {
        if (this.gNE != null) {
            this.gNE.onDestroy();
        }
    }

    public void onResume() {
        if (this.gNE != null) {
            this.gNE.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gNE != null) {
            this.gNE.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN(boolean z) {
        if (z) {
            this.gSd.setVisibility(0);
        } else {
            this.gSd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(boolean z) {
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

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
    private g gKN;
    private GLTextureView gPk;
    private View gPl;
    private String gPm;
    private int gPn;
    private int gPo;
    private a.b gPp;
    private CustomMessageListener gPq;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKN = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gPp == null || aVar == null || aVar.op() == null) {
                    VrPicView.this.mK(true);
                    return;
                }
                VrPicView.this.mL(false);
                Bitmap op = aVar.op();
                VrPicView.this.gKN.l(op.getWidth(), op.getHeight());
                try {
                    VrPicView.this.gPp.d(op);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = op.getWidth();
                        int height = op.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(op, width / 2, height / 2, true);
                        VrPicView.this.gKN.l(width / 2, height / 2);
                        VrPicView.this.gPp.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mK(true);
                    }
                }
            }
        };
        this.gPq = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mK(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gKN = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gPp == null || aVar == null || aVar.op() == null) {
                    VrPicView.this.mK(true);
                    return;
                }
                VrPicView.this.mL(false);
                Bitmap op = aVar.op();
                VrPicView.this.gKN.l(op.getWidth(), op.getHeight());
                try {
                    VrPicView.this.gPp.d(op);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = op.getWidth();
                        int height = op.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(op, width / 2, height / 2, true);
                        VrPicView.this.gKN.l(width / 2, height / 2);
                        VrPicView.this.gPp.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mK(true);
                    }
                }
            }
        };
        this.gPq = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mK(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKN = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gPp == null || aVar == null || aVar.op() == null) {
                    VrPicView.this.mK(true);
                    return;
                }
                VrPicView.this.mL(false);
                Bitmap op = aVar.op();
                VrPicView.this.gKN.l(op.getWidth(), op.getHeight());
                try {
                    VrPicView.this.gPp.d(op);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = op.getWidth();
                        int height = op.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(op, width / 2, height / 2, true);
                        VrPicView.this.gKN.l(width / 2, height / 2);
                        VrPicView.this.gPp.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mK(true);
                    }
                }
            }
        };
        this.gPq = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mK(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.amM = LayoutInflater.from(context).inflate(e.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gPk = this.amM.findViewById(e.g.lego_gl_view);
            this.gPl = this.amM.findViewById(e.g.error_tips);
            this.mPromptView = this.amM.findViewById(e.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.apB != null) {
            this.mPageContext = tbPageContext;
            this.gPq.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gPq);
            this.gPm = advertAppInfo.apB.apM;
            if (TextUtils.isEmpty(this.gPm)) {
                this.mPageContext.showToast(e.j.lego_error_url);
                return;
            }
            this.gPn = advertAppInfo.apB.width;
            this.gPo = advertAppInfo.apB.height;
            if (this.gKN == null) {
                this.gKN = g.h(tbPageContext.getPageActivity()).M(101).N(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gPp = bVar;
                        VrPicView.this.buX();
                    }
                }).I(true).b(this.gPk);
                this.gKN.onResume(this.mPageContext.getPageActivity());
                return;
            }
            al(this.gPm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buX() {
        if (!StringUtils.isNull(this.gPm) && this.gPp != null) {
            mK(false);
            mL(true);
            c.jA().a(this.gPm, 10, this.mCallback, this.gPn, this.gPo, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void al(String str) {
        buX();
    }

    public void onDestroy() {
        if (this.gKN != null) {
            this.gKN.onDestroy();
        }
    }

    public void onResume() {
        if (this.gKN != null) {
            this.gKN.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gKN != null) {
            this.gKN.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK(boolean z) {
        if (z) {
            this.gPl.setVisibility(0);
        } else {
            this.gPl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(boolean z) {
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

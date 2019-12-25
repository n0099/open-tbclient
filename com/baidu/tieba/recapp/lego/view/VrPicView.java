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
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes10.dex */
public class VrPicView extends RelativeLayout {
    private b<com.baidu.adp.widget.ImageView.a> cUm;
    private g jAP;
    private GLTextureView jFq;
    private View jFr;
    private String jFs;
    private int jFt;
    private int jFu;
    private a.b jFv;
    private CustomMessageListener jFw;
    private TbPageContext<?> mPageContext;
    private View mPromptView;
    private View mRoot;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jAP = null;
        this.cUm = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jFv == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rM(true);
                    return;
                }
                VrPicView.this.rN(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jAP.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jFv.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jAP.k(width / 2, height / 2);
                        VrPicView.this.jFv.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rM(true);
                    }
                }
            }
        };
        this.jFw = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.rM(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.jAP = null;
        this.cUm = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jFv == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rM(true);
                    return;
                }
                VrPicView.this.rN(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jAP.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jFv.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jAP.k(width / 2, height / 2);
                        VrPicView.this.jFv.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rM(true);
                    }
                }
            }
        };
        this.jFw = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.rM(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jAP = null;
        this.cUm = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jFv == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rM(true);
                    return;
                }
                VrPicView.this.rN(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jAP.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jFv.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jAP.k(width / 2, height / 2);
                        VrPicView.this.jFv.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rM(true);
                    }
                }
            }
        };
        this.jFw = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.rM(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) != null) {
            this.mRoot = LayoutInflater.from(context).inflate(R.layout.card_vr_pic_view, (ViewGroup) this, true);
            this.jFq = this.mRoot.findViewById(R.id.lego_gl_view);
            this.jFr = this.mRoot.findViewById(R.id.error_tips);
            this.mPromptView = this.mRoot.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.cIQ != null) {
            this.mPageContext = tbPageContext;
            this.jFw.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.jFw);
            this.jFs = advertAppInfo.cIQ.cJb;
            if (TextUtils.isEmpty(this.jFs)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.jFt = advertAppInfo.cIQ.width;
            this.jFu = advertAppInfo.cIQ.height;
            if (this.jAP == null) {
                this.jAP = g.m(tbPageContext.getPageActivity()).o(101).p(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.jFv = bVar;
                        VrPicView.this.cAn();
                    }
                }).B(true).b(this.jFq);
                this.jAP.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.jFs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAn() {
        if (!StringUtils.isNull(this.jFs) && this.jFv != null) {
            rM(false);
            rN(true);
            c.gs().a(this.jFs, 10, this.cUm, this.jFt, this.jFu, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        cAn();
    }

    public void onDestroy() {
        if (this.jAP != null) {
            this.jAP.onDestroy();
        }
    }

    public void onResume() {
        if (this.jAP != null) {
            this.jAP.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.jAP != null) {
            this.jAP.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM(boolean z) {
        if (z) {
            this.jFr.setVisibility(0);
        } else {
            this.jFr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN(boolean z) {
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

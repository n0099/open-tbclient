package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.a.a.d.a;
import com.a.a.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private b<com.baidu.adp.widget.ImageView.a> cit;
    private g iHo;
    private GLTextureView iLR;
    private View iLS;
    private String iLT;
    private int iLU;
    private int iLV;
    private a.b iLW;
    private CustomMessageListener iLX;
    private TbPageContext<?> mPageContext;
    private View mPromptView;
    private View mRoot;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iHo = null;
        this.cit = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iLW == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.qd(true);
                    return;
                }
                VrPicView.this.qe(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.iHo.l(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.iLW.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.iHo.l(width / 2, height / 2);
                        VrPicView.this.iLW.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qd(true);
                    }
                }
            }
        };
        this.iLX = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qd(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.iHo = null;
        this.cit = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iLW == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.qd(true);
                    return;
                }
                VrPicView.this.qe(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.iHo.l(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.iLW.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.iHo.l(width / 2, height / 2);
                        VrPicView.this.iLW.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qd(true);
                    }
                }
            }
        };
        this.iLX = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qd(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iHo = null;
        this.cit = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iLW == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.qd(true);
                    return;
                }
                VrPicView.this.qe(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.iHo.l(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.iLW.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.iHo.l(width / 2, height / 2);
                        VrPicView.this.iLW.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qd(true);
                    }
                }
            }
        };
        this.iLX = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qd(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) != null) {
            this.mRoot = LayoutInflater.from(context).inflate(R.layout.card_vr_pic_view, (ViewGroup) this, true);
            this.iLR = this.mRoot.findViewById(R.id.lego_gl_view);
            this.iLS = this.mRoot.findViewById(R.id.error_tips);
            this.mPromptView = this.mRoot.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.bXu != null) {
            this.mPageContext = tbPageContext;
            this.iLX.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.iLX);
            this.iLT = advertAppInfo.bXu.bXF;
            if (TextUtils.isEmpty(this.iLT)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.iLU = advertAppInfo.bXu.width;
            this.iLV = advertAppInfo.bXu.height;
            if (this.iHo == null) {
                this.iHo = g.k(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.iLW = bVar;
                        VrPicView.this.cgl();
                    }
                }).x(true).b(this.iLR);
                this.iHo.onResume(this.mPageContext.getPageActivity());
                return;
            }
            P(this.iLT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgl() {
        if (!StringUtils.isNull(this.iLT) && this.iLW != null) {
            qd(false);
            qe(true);
            c.fT().a(this.iLT, 10, this.cit, this.iLU, this.iLV, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void P(String str) {
        cgl();
    }

    public void onDestroy() {
        if (this.iHo != null) {
            this.iHo.onDestroy();
        }
    }

    public void onResume() {
        if (this.iHo != null) {
            this.iHo.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.iHo != null) {
            this.iHo.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd(boolean z) {
        if (z) {
            this.iLS.setVisibility(0);
        } else {
            this.iLS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(boolean z) {
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

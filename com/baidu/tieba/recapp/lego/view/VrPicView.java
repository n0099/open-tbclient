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
/* loaded from: classes11.dex */
public class VrPicView extends RelativeLayout {
    private b<com.baidu.adp.widget.ImageView.a> cUw;
    private g jEr;
    private GLTextureView jIS;
    private View jIT;
    private String jIU;
    private int jIV;
    private int jIW;
    private a.b jIX;
    private CustomMessageListener jIY;
    private TbPageContext<?> mPageContext;
    private View mPromptView;
    private View mRoot;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEr = null;
        this.cUw = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jIX == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rY(true);
                    return;
                }
                VrPicView.this.rZ(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jEr.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jIX.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jEr.k(width / 2, height / 2);
                        VrPicView.this.jIX.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rY(true);
                    }
                }
            }
        };
        this.jIY = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.rY(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.jEr = null;
        this.cUw = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jIX == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rY(true);
                    return;
                }
                VrPicView.this.rZ(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jEr.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jIX.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jEr.k(width / 2, height / 2);
                        VrPicView.this.jIX.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rY(true);
                    }
                }
            }
        };
        this.jIY = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.rY(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jEr = null;
        this.cUw = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jIX == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rY(true);
                    return;
                }
                VrPicView.this.rZ(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jEr.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jIX.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jEr.k(width / 2, height / 2);
                        VrPicView.this.jIX.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rY(true);
                    }
                }
            }
        };
        this.jIY = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.rY(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) != null) {
            this.mRoot = LayoutInflater.from(context).inflate(R.layout.card_vr_pic_view, (ViewGroup) this, true);
            this.jIS = this.mRoot.findViewById(R.id.lego_gl_view);
            this.jIT = this.mRoot.findViewById(R.id.error_tips);
            this.mPromptView = this.mRoot.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.cJb != null) {
            this.mPageContext = tbPageContext;
            this.jIY.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.jIY);
            this.jIU = advertAppInfo.cJb.cJm;
            if (TextUtils.isEmpty(this.jIU)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.jIV = advertAppInfo.cJb.width;
            this.jIW = advertAppInfo.cJb.height;
            if (this.jEr == null) {
                this.jEr = g.m(tbPageContext.getPageActivity()).o(101).p(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.jIX = bVar;
                        VrPicView.this.cBu();
                    }
                }).B(true).b(this.jIS);
                this.jEr.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.jIU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBu() {
        if (!StringUtils.isNull(this.jIU) && this.jIX != null) {
            rY(false);
            rZ(true);
            c.gr().a(this.jIU, 10, this.cUw, this.jIV, this.jIW, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        cBu();
    }

    public void onDestroy() {
        if (this.jEr != null) {
            this.jEr.onDestroy();
        }
    }

    public void onResume() {
        if (this.jEr != null) {
            this.jEr.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.jEr != null) {
            this.jEr.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(boolean z) {
        if (z) {
            this.jIT.setVisibility(0);
        } else {
            this.jIT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ(boolean z) {
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

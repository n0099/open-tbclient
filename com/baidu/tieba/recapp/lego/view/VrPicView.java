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
    private g jEw;
    private GLTextureView jIX;
    private View jIY;
    private String jIZ;
    private int jJa;
    private int jJb;
    private a.b jJc;
    private CustomMessageListener jJd;
    private TbPageContext<?> mPageContext;
    private View mPromptView;
    private View mRoot;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEw = null;
        this.cUw = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jJc == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rY(true);
                    return;
                }
                VrPicView.this.rZ(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jEw.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jJc.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jEw.k(width / 2, height / 2);
                        VrPicView.this.jJc.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rY(true);
                    }
                }
            }
        };
        this.jJd = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
        this.jEw = null;
        this.cUw = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jJc == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rY(true);
                    return;
                }
                VrPicView.this.rZ(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jEw.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jJc.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jEw.k(width / 2, height / 2);
                        VrPicView.this.jJc.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rY(true);
                    }
                }
            }
        };
        this.jJd = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
        this.jEw = null;
        this.cUw = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jJc == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.rY(true);
                    return;
                }
                VrPicView.this.rZ(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jEw.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jJc.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jEw.k(width / 2, height / 2);
                        VrPicView.this.jJc.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.rY(true);
                    }
                }
            }
        };
        this.jJd = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
            this.jIX = this.mRoot.findViewById(R.id.lego_gl_view);
            this.jIY = this.mRoot.findViewById(R.id.error_tips);
            this.mPromptView = this.mRoot.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.cJb != null) {
            this.mPageContext = tbPageContext;
            this.jJd.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.jJd);
            this.jIZ = advertAppInfo.cJb.cJm;
            if (TextUtils.isEmpty(this.jIZ)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.jJa = advertAppInfo.cJb.width;
            this.jJb = advertAppInfo.cJb.height;
            if (this.jEw == null) {
                this.jEw = g.m(tbPageContext.getPageActivity()).o(101).p(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.jJc = bVar;
                        VrPicView.this.cBw();
                    }
                }).B(true).b(this.jIX);
                this.jEw.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.jIZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBw() {
        if (!StringUtils.isNull(this.jIZ) && this.jJc != null) {
            rY(false);
            rZ(true);
            c.gr().a(this.jIZ, 10, this.cUw, this.jJa, this.jJb, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        cBw();
    }

    public void onDestroy() {
        if (this.jEw != null) {
            this.jEw.onDestroy();
        }
    }

    public void onResume() {
        if (this.jEw != null) {
            this.jEw.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.jEw != null) {
            this.jEw.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(boolean z) {
        if (z) {
            this.jIY.setVisibility(0);
        } else {
            this.jIY.setVisibility(8);
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

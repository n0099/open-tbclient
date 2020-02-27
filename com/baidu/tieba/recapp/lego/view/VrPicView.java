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
/* loaded from: classes13.dex */
public class VrPicView extends RelativeLayout {
    private b<com.baidu.adp.widget.ImageView.a> cYy;
    private g jFn;
    private GLTextureView jJT;
    private View jJU;
    private String jJV;
    private int jJW;
    private int jJX;
    private a.b jJY;
    private CustomMessageListener jJZ;
    private TbPageContext<?> mPageContext;
    private View mPromptView;
    private View mRoot;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFn = null;
        this.cYy = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jJY == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.sb(true);
                    return;
                }
                VrPicView.this.sc(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jFn.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jJY.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jFn.k(width / 2, height / 2);
                        VrPicView.this.jJY.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.sb(true);
                    }
                }
            }
        };
        this.jJZ = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.sb(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.jFn = null;
        this.cYy = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jJY == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.sb(true);
                    return;
                }
                VrPicView.this.sc(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jFn.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jJY.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jFn.k(width / 2, height / 2);
                        VrPicView.this.jJY.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.sb(true);
                    }
                }
            }
        };
        this.jJZ = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.sb(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFn = null;
        this.cYy = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jJY == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.sb(true);
                    return;
                }
                VrPicView.this.sc(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jFn.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jJY.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jFn.k(width / 2, height / 2);
                        VrPicView.this.jJY.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.sb(true);
                    }
                }
            }
        };
        this.jJZ = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.sb(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) != null) {
            this.mRoot = LayoutInflater.from(context).inflate(R.layout.card_vr_pic_view, (ViewGroup) this, true);
            this.jJT = this.mRoot.findViewById(R.id.lego_gl_view);
            this.jJU = this.mRoot.findViewById(R.id.error_tips);
            this.mPromptView = this.mRoot.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.cNe != null) {
            this.mPageContext = tbPageContext;
            this.jJZ.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.jJZ);
            this.jJV = advertAppInfo.cNe.cNp;
            if (TextUtils.isEmpty(this.jJV)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.jJW = advertAppInfo.cNe.width;
            this.jJX = advertAppInfo.cNe.height;
            if (this.jFn == null) {
                this.jFn = g.m(tbPageContext.getPageActivity()).r(101).s(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.jJY = bVar;
                        VrPicView.this.cCS();
                    }
                }).B(true).b(this.jJT);
                this.jFn.onResume(this.mPageContext.getPageActivity());
                return;
            }
            V(this.jJV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCS() {
        if (!StringUtils.isNull(this.jJV) && this.jJY != null) {
            sb(false);
            sc(true);
            c.gr().a(this.jJV, 10, this.cYy, this.jJW, this.jJX, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void V(String str) {
        cCS();
    }

    public void onDestroy() {
        if (this.jFn != null) {
            this.jFn.onDestroy();
        }
    }

    public void onResume() {
        if (this.jFn != null) {
            this.jFn.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.jFn != null) {
            this.jFn.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(boolean z) {
        if (z) {
            this.jJU.setVisibility(0);
        } else {
            this.jJU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z) {
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

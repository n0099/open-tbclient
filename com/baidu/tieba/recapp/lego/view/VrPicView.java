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
    private b<com.baidu.adp.widget.ImageView.a> cYA;
    private g jFB;
    private GLTextureView jKh;
    private View jKi;
    private String jKj;
    private int jKk;
    private int jKl;
    private a.b jKm;
    private CustomMessageListener jKn;
    private TbPageContext<?> mPageContext;
    private View mPromptView;
    private View mRoot;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFB = null;
        this.cYA = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jKm == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.sb(true);
                    return;
                }
                VrPicView.this.sc(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jFB.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jKm.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jFB.k(width / 2, height / 2);
                        VrPicView.this.jKm.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.sb(true);
                    }
                }
            }
        };
        this.jKn = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
        this.jFB = null;
        this.cYA = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jKm == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.sb(true);
                    return;
                }
                VrPicView.this.sc(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jFB.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jKm.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jFB.k(width / 2, height / 2);
                        VrPicView.this.jKm.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.sb(true);
                    }
                }
            }
        };
        this.jKn = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
        this.jFB = null;
        this.cYA = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.jKm == null || aVar == null || aVar.getRawBitmap() == null) {
                    VrPicView.this.sb(true);
                    return;
                }
                VrPicView.this.sc(false);
                Bitmap rawBitmap = aVar.getRawBitmap();
                VrPicView.this.jFB.k(rawBitmap.getWidth(), rawBitmap.getHeight());
                try {
                    VrPicView.this.jKm.d(rawBitmap);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = rawBitmap.getWidth();
                        int height = rawBitmap.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(rawBitmap, width / 2, height / 2, true);
                        VrPicView.this.jFB.k(width / 2, height / 2);
                        VrPicView.this.jKm.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.sb(true);
                    }
                }
            }
        };
        this.jKn = new CustomMessageListener(CmdConfigCustom.CMD_VR_GL_ERROR) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
            this.jKh = this.mRoot.findViewById(R.id.lego_gl_view);
            this.jKi = this.mRoot.findViewById(R.id.error_tips);
            this.mPromptView = this.mRoot.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.cNg != null) {
            this.mPageContext = tbPageContext;
            this.jKn.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.jKn);
            this.jKj = advertAppInfo.cNg.cNr;
            if (TextUtils.isEmpty(this.jKj)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.jKk = advertAppInfo.cNg.width;
            this.jKl = advertAppInfo.cNg.height;
            if (this.jFB == null) {
                this.jFB = g.m(tbPageContext.getPageActivity()).r(101).s(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.jKm = bVar;
                        VrPicView.this.cCV();
                    }
                }).B(true).b(this.jKh);
                this.jFB.onResume(this.mPageContext.getPageActivity());
                return;
            }
            V(this.jKj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCV() {
        if (!StringUtils.isNull(this.jKj) && this.jKm != null) {
            sb(false);
            sc(true);
            c.gr().a(this.jKj, 10, this.cYA, this.jKk, this.jKl, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void V(String str) {
        cCV();
    }

    public void onDestroy() {
        if (this.jFB != null) {
            this.jFB.onDestroy();
        }
    }

    public void onResume() {
        if (this.jFB != null) {
            this.jFB.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.jFB != null) {
            this.jFB.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(boolean z) {
        if (z) {
            this.jKi.setVisibility(0);
        } else {
            this.jKi.setVisibility(8);
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

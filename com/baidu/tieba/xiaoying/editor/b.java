package com.baidu.tieba.xiaoying.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends RelativeLayout implements s {
    private i axH;
    private int axI;
    private ImageView hOa;
    private ForeDrawableImageView hOb;
    private String huE;
    private int mVideoHeight;
    private int mVideoWidth;
    private String videoUrl;

    public b(Context context) {
        super(context);
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater.from(context).inflate(d.h.xiaoying_pannel, this);
        this.hOb = (ForeDrawableImageView) findViewById(d.g.video_pannel);
        this.hOb.setForegroundDrawable(d.f.icon_play_video);
        this.hOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xiaoying.editor.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(b.this.videoUrl)) {
                    XiaoyingUtil.startPlayXiaoyingVideo(b.this.getContext(), b.this.videoUrl, b.this.mVideoWidth, b.this.mVideoHeight, b.this.huE);
                }
            }
        });
        this.hOa = (ImageView) findViewById(d.g.video_cancel);
        this.hOa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xiaoying.editor.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.b(new com.baidu.tbadk.editortools.a(29, -1, null));
            }
        });
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hOb.getLayoutParams();
        int keyboardHeight = TbadkCoreApplication.getInst().getKeyboardHeight();
        int dimension = (int) getResources().getDimension(d.e.ds460);
        if (keyboardHeight <= 0) {
            keyboardHeight = dimension;
        }
        if (layoutParams != null) {
            layoutParams.height = keyboardHeight - (((int) getResources().getDimension(d.e.ds76)) * 2);
            layoutParams.width = layoutParams.height;
            this.hOb.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    return;
                case 28:
                    Object obj = aVar.data;
                    if (obj instanceof VideoInfo) {
                        VideoInfo videoInfo = (VideoInfo) obj;
                        Bitmap sk = sk(videoInfo.getThumbPath());
                        if (sk != null) {
                            this.hOb.setImageBitmap(sk);
                        }
                        this.videoUrl = videoInfo.getVideoPath();
                        this.mVideoWidth = videoInfo.getVideoWidth();
                        this.mVideoHeight = videoInfo.getVideoHeight();
                        this.huE = videoInfo.getThumbPath();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private Bitmap sk(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            System.gc();
            try {
                return BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axI;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.c(this.hOa, d.f.btn_add_photo_close);
        if (this.hOb != null) {
            this.hOb.setForegroundDrawable(d.f.icon_play_video);
        }
    }
}

package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.d;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bg XR;
    private c iar;
    private View ias;
    private ImageView iat;
    private View iau;
    private ImageView iav;
    private View iaw;
    private ImageView iax;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.ias) {
                        OperableVideoShareView.this.xt(3);
                    } else if (view == OperableVideoShareView.this.iau) {
                        OperableVideoShareView.this.xt(2);
                    } else if (view == OperableVideoShareView.this.iaw) {
                        OperableVideoShareView.this.xt(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.ias) {
                        OperableVideoShareView.this.xt(3);
                    } else if (view == OperableVideoShareView.this.iau) {
                        OperableVideoShareView.this.xt(2);
                    } else if (view == OperableVideoShareView.this.iaw) {
                        OperableVideoShareView.this.xt(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.ias) {
                        OperableVideoShareView.this.xt(3);
                    } else if (view == OperableVideoShareView.this.iau) {
                        OperableVideoShareView.this.xt(2);
                    } else if (view == OperableVideoShareView.this.iaw) {
                        OperableVideoShareView.this.xt(8);
                    }
                }
            }
        };
        init();
    }

    public int getLayoutR() {
        return d.h.operable_video_share_view;
    }

    private void init() {
        inflate(getContext(), getLayoutR(), this);
        this.ias = findViewById(d.g.share_weixin);
        this.iau = findViewById(d.g.share_weixin_timeline);
        this.iaw = findViewById(d.g.share_qq);
        this.iat = (ImageView) findViewById(d.g.share_weixin_img);
        this.iav = (ImageView) findViewById(d.g.share_weixin_timeline_img);
        this.iax = (ImageView) findViewById(d.g.share_qq_img);
        this.ias.setOnClickListener(this.mOnClickListener);
        this.iau.setOnClickListener(this.mOnClickListener);
        this.iaw.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.iar = cVar;
    }

    public void setShareData(bg bgVar) {
        this.XR = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i) {
        if (this.XR != null) {
            String valueOf = String.valueOf(this.XR.getFid());
            String YW = this.XR.YW();
            if (this.XR.bDC != null) {
                valueOf = this.XR.bDC.id;
                YW = this.XR.bDC.ori_fname;
            }
            String title = this.XR.getTitle();
            String tid = this.XR.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.XR);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.XR.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.cby = str2;
            dVar.linkUrl = str;
            dVar.bDT = 3;
            dVar.extData = tid;
            dVar.cbB = 3;
            dVar.cbC = 1;
            dVar.cbD = 0;
            dVar.fid = valueOf;
            dVar.cbs = YW;
            dVar.tid = tid;
            dVar.cbo = true;
            dVar.cbA = 3;
            dVar.cbF = s(this.XR);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.XR);
            dVar.cbE = 1;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putString("tid", dVar.tid);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putInt("obj_type", dVar.cbF);
            bundle.putInt("obj_param1", dVar.cbB);
            bundle.putInt("obj_param2", dVar.cbC);
            bundle.putInt("obj_param3", dVar.cbD);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDT);
            bundle.putInt("obj_locate", dVar.cbE);
            dVar.D(bundle);
            if (com.baidu.tbadk.plugins.c.ay(getContext(), "com.baidu.tieba.pluginCore")) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, dVar, true));
            }
        }
    }

    private String r(bg bgVar) {
        if (bgVar == null || bgVar.Zb() == null) {
            return null;
        }
        ArrayList<MediaData> Zb = bgVar.Zb();
        int size = Zb.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = Zb.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    return mediaData.getThumbnails_url();
                }
                if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    return mediaData.getPicUrl();
                }
            }
        }
        return null;
    }

    private int s(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.YT()) {
                return 4;
            }
            if (bgVar.YO() == 1) {
                return 3;
            }
            return bgVar.aad() ? 2 : 1;
        }
        return 0;
    }

    public void af(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iau.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.iat.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.iav.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.iax.getLayoutParams();
        if (!z2) {
            if (z) {
                layoutParams2.leftMargin = (int) getResources().getDimension(d.e.tbds30);
                layoutParams2.rightMargin = (int) getResources().getDimension(d.e.tbds30);
            } else {
                layoutParams2.leftMargin = (int) getResources().getDimension(d.e.tbds130);
                layoutParams2.rightMargin = (int) getResources().getDimension(d.e.tbds130);
            }
            int dimension = (int) getResources().getDimension(d.e.tbds104);
            layoutParams5.width = dimension;
            layoutParams5.height = dimension;
            layoutParams4.width = dimension;
            layoutParams4.height = dimension;
            layoutParams3.width = dimension;
            layoutParams3.height = dimension;
        } else {
            layoutParams.topMargin = 0;
            layoutParams2.leftMargin = (int) getResources().getDimension(d.e.tbds130);
            layoutParams2.rightMargin = (int) getResources().getDimension(d.e.tbds130);
            setGravity(17);
            int dimension2 = (int) getResources().getDimension(d.e.tbds156);
            layoutParams5.width = dimension2;
            layoutParams5.height = dimension2;
            layoutParams4.width = dimension2;
            layoutParams4.height = dimension2;
            layoutParams3.width = dimension2;
            layoutParams3.height = dimension2;
        }
        setLayoutParams(layoutParams);
        this.iau.setLayoutParams(layoutParams2);
    }
}

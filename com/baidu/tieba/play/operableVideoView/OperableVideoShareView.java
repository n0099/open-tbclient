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
    private bg XS;
    private c hZY;
    private View hZZ;
    private ImageView iaa;
    private View iab;
    private ImageView iac;
    private View iad;
    private ImageView iae;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.hZZ) {
                        OperableVideoShareView.this.xp(3);
                    } else if (view == OperableVideoShareView.this.iab) {
                        OperableVideoShareView.this.xp(2);
                    } else if (view == OperableVideoShareView.this.iad) {
                        OperableVideoShareView.this.xp(8);
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
                    if (view == OperableVideoShareView.this.hZZ) {
                        OperableVideoShareView.this.xp(3);
                    } else if (view == OperableVideoShareView.this.iab) {
                        OperableVideoShareView.this.xp(2);
                    } else if (view == OperableVideoShareView.this.iad) {
                        OperableVideoShareView.this.xp(8);
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
                    if (view == OperableVideoShareView.this.hZZ) {
                        OperableVideoShareView.this.xp(3);
                    } else if (view == OperableVideoShareView.this.iab) {
                        OperableVideoShareView.this.xp(2);
                    } else if (view == OperableVideoShareView.this.iad) {
                        OperableVideoShareView.this.xp(8);
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
        this.hZZ = findViewById(d.g.share_weixin);
        this.iab = findViewById(d.g.share_weixin_timeline);
        this.iad = findViewById(d.g.share_qq);
        this.iaa = (ImageView) findViewById(d.g.share_weixin_img);
        this.iac = (ImageView) findViewById(d.g.share_weixin_timeline_img);
        this.iae = (ImageView) findViewById(d.g.share_qq_img);
        this.hZZ.setOnClickListener(this.mOnClickListener);
        this.iab.setOnClickListener(this.mOnClickListener);
        this.iad.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.hZY = cVar;
    }

    public void setShareData(bg bgVar) {
        this.XS = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xp(int i) {
        if (this.XS != null) {
            String valueOf = String.valueOf(this.XS.getFid());
            String YT = this.XS.YT();
            if (this.XS.bDH != null) {
                valueOf = this.XS.bDH.id;
                YT = this.XS.bDH.ori_fname;
            }
            String title = this.XS.getTitle();
            String tid = this.XS.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.XS);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.XS.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.cbA = str2;
            dVar.linkUrl = str;
            dVar.bDY = 3;
            dVar.extData = tid;
            dVar.cbD = 3;
            dVar.cbE = 1;
            dVar.cbF = 0;
            dVar.fid = valueOf;
            dVar.cbu = YT;
            dVar.tid = tid;
            dVar.cbq = true;
            dVar.cbC = 3;
            dVar.cbH = s(this.XS);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.XS);
            dVar.cbG = 1;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putString("tid", dVar.tid);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putInt("obj_type", dVar.cbH);
            bundle.putInt("obj_param1", dVar.cbD);
            bundle.putInt("obj_param2", dVar.cbE);
            bundle.putInt("obj_param3", dVar.cbF);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDY);
            bundle.putInt("obj_locate", dVar.cbG);
            dVar.D(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, dVar, true));
        }
    }

    private String r(bg bgVar) {
        if (bgVar == null || bgVar.YY() == null) {
            return null;
        }
        ArrayList<MediaData> YY = bgVar.YY();
        int size = YY.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = YY.get(i);
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
            if (bgVar.YQ()) {
                return 4;
            }
            if (bgVar.YL() == 1) {
                return 3;
            }
            return bgVar.aaa() ? 2 : 1;
        }
        return 0;
    }

    public void ad(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iab.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.iaa.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.iac.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.iae.getLayoutParams();
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
        this.iab.setLayoutParams(layoutParams2);
    }
}

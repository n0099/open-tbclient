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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bh FT;
    private c iAS;
    private View iAT;
    private ImageView iAU;
    private View iAV;
    private ImageView iAW;
    private View iAX;
    private ImageView iAY;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.iAT) {
                        OperableVideoShareView.this.xL(3);
                    } else if (view == OperableVideoShareView.this.iAV) {
                        OperableVideoShareView.this.xL(2);
                    } else if (view == OperableVideoShareView.this.iAX) {
                        OperableVideoShareView.this.xL(8);
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
                    if (view == OperableVideoShareView.this.iAT) {
                        OperableVideoShareView.this.xL(3);
                    } else if (view == OperableVideoShareView.this.iAV) {
                        OperableVideoShareView.this.xL(2);
                    } else if (view == OperableVideoShareView.this.iAX) {
                        OperableVideoShareView.this.xL(8);
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
                    if (view == OperableVideoShareView.this.iAT) {
                        OperableVideoShareView.this.xL(3);
                    } else if (view == OperableVideoShareView.this.iAV) {
                        OperableVideoShareView.this.xL(2);
                    } else if (view == OperableVideoShareView.this.iAX) {
                        OperableVideoShareView.this.xL(8);
                    }
                }
            }
        };
        init();
    }

    public int getLayoutR() {
        return R.layout.operable_video_share_view;
    }

    private void init() {
        inflate(getContext(), getLayoutR(), this);
        this.iAT = findViewById(R.id.share_weixin);
        this.iAV = findViewById(R.id.share_weixin_timeline);
        this.iAX = findViewById(R.id.share_qq);
        this.iAU = (ImageView) findViewById(R.id.share_weixin_img);
        this.iAW = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.iAY = (ImageView) findViewById(R.id.share_qq_img);
        this.iAT.setOnClickListener(this.mOnClickListener);
        this.iAV.setOnClickListener(this.mOnClickListener);
        this.iAX.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.iAS = cVar;
    }

    public void setShareData(bh bhVar) {
        this.FT = bhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(int i) {
        if (this.FT != null) {
            String valueOf = String.valueOf(this.FT.getFid());
            String aiL = this.FT.aiL();
            if (this.FT.cem != null) {
                valueOf = this.FT.cem.id;
                aiL = this.FT.cem.ori_fname;
            }
            String title = this.FT.getTitle();
            String tid = this.FT.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String t = t(this.FT);
            Uri parse = t == null ? null : Uri.parse(t);
            String str2 = this.FT.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            e eVar = new e();
            eVar.title = title;
            eVar.content = format;
            eVar.cyK = str2;
            eVar.linkUrl = str;
            eVar.ceG = 3;
            eVar.extData = tid;
            eVar.cyN = 3;
            eVar.cyO = 1;
            eVar.cyP = 0;
            eVar.fid = valueOf;
            eVar.cyE = aiL;
            eVar.tid = tid;
            eVar.cyz = true;
            eVar.cyM = 3;
            eVar.cyR = u(this.FT);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.FT);
            eVar.cyQ = 1;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.czb = this.FT.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", eVar.tid);
            bundle.putString("fid", eVar.fid);
            bundle.putInt("obj_type", eVar.cyR);
            bundle.putInt("obj_param1", eVar.cyN);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, eVar.cyO);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, eVar.cyP);
            bundle.putInt("obj_source", eVar.ceG);
            bundle.putInt("obj_locate", eVar.cyQ);
            eVar.E(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, eVar, true));
        }
    }

    private String t(bh bhVar) {
        if (bhVar == null || bhVar.aiQ() == null) {
            return null;
        }
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        int size = aiQ.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aiQ.get(i);
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

    private int u(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aiI()) {
                return 4;
            }
            if (bhVar.aiD() == 1) {
                return 3;
            }
            return bhVar.ajR() ? 2 : 1;
        }
        return 0;
    }

    public void ah(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iAV.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.iAU.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.iAW.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.iAY.getLayoutParams();
        if (!z2) {
            if (z) {
                layoutParams2.leftMargin = (int) getResources().getDimension(R.dimen.tbds30);
                layoutParams2.rightMargin = (int) getResources().getDimension(R.dimen.tbds30);
            } else {
                layoutParams2.leftMargin = (int) getResources().getDimension(R.dimen.tbds130);
                layoutParams2.rightMargin = (int) getResources().getDimension(R.dimen.tbds130);
            }
            int dimension = (int) getResources().getDimension(R.dimen.tbds104);
            layoutParams5.width = dimension;
            layoutParams5.height = dimension;
            layoutParams4.width = dimension;
            layoutParams4.height = dimension;
            layoutParams3.width = dimension;
            layoutParams3.height = dimension;
        } else {
            layoutParams.topMargin = 0;
            layoutParams2.leftMargin = (int) getResources().getDimension(R.dimen.tbds130);
            layoutParams2.rightMargin = (int) getResources().getDimension(R.dimen.tbds130);
            setGravity(17);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds156);
            layoutParams5.width = dimension2;
            layoutParams5.height = dimension2;
            layoutParams4.width = dimension2;
            layoutParams4.height = dimension2;
            layoutParams3.width = dimension2;
            layoutParams3.height = dimension2;
        }
        setLayoutParams(layoutParams);
        this.iAV.setLayoutParams(layoutParams2);
    }
}

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
    private bh Fs;
    private c iAb;
    private View iAc;
    private ImageView iAd;
    private View iAe;
    private ImageView iAf;
    private View iAg;
    private ImageView iAh;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.iAc) {
                        OperableVideoShareView.this.xK(3);
                    } else if (view == OperableVideoShareView.this.iAe) {
                        OperableVideoShareView.this.xK(2);
                    } else if (view == OperableVideoShareView.this.iAg) {
                        OperableVideoShareView.this.xK(8);
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
                    if (view == OperableVideoShareView.this.iAc) {
                        OperableVideoShareView.this.xK(3);
                    } else if (view == OperableVideoShareView.this.iAe) {
                        OperableVideoShareView.this.xK(2);
                    } else if (view == OperableVideoShareView.this.iAg) {
                        OperableVideoShareView.this.xK(8);
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
                    if (view == OperableVideoShareView.this.iAc) {
                        OperableVideoShareView.this.xK(3);
                    } else if (view == OperableVideoShareView.this.iAe) {
                        OperableVideoShareView.this.xK(2);
                    } else if (view == OperableVideoShareView.this.iAg) {
                        OperableVideoShareView.this.xK(8);
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
        this.iAc = findViewById(R.id.share_weixin);
        this.iAe = findViewById(R.id.share_weixin_timeline);
        this.iAg = findViewById(R.id.share_qq);
        this.iAd = (ImageView) findViewById(R.id.share_weixin_img);
        this.iAf = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.iAh = (ImageView) findViewById(R.id.share_qq_img);
        this.iAc.setOnClickListener(this.mOnClickListener);
        this.iAe.setOnClickListener(this.mOnClickListener);
        this.iAg.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.iAb = cVar;
    }

    public void setShareData(bh bhVar) {
        this.Fs = bhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xK(int i) {
        if (this.Fs != null) {
            String valueOf = String.valueOf(this.Fs.getFid());
            String aiJ = this.Fs.aiJ();
            if (this.Fs.cdv != null) {
                valueOf = this.Fs.cdv.id;
                aiJ = this.Fs.cdv.ori_fname;
            }
            String title = this.Fs.getTitle();
            String tid = this.Fs.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String t = t(this.Fs);
            Uri parse = t == null ? null : Uri.parse(t);
            String str2 = this.Fs.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            e eVar = new e();
            eVar.title = title;
            eVar.content = format;
            eVar.cxT = str2;
            eVar.linkUrl = str;
            eVar.cdP = 3;
            eVar.extData = tid;
            eVar.cxW = 3;
            eVar.cxX = 1;
            eVar.cxY = 0;
            eVar.fid = valueOf;
            eVar.cxN = aiJ;
            eVar.tid = tid;
            eVar.cxI = true;
            eVar.cxV = 3;
            eVar.cya = u(this.Fs);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Fs);
            eVar.cxZ = 1;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.cyk = this.Fs.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", eVar.tid);
            bundle.putString("fid", eVar.fid);
            bundle.putInt("obj_type", eVar.cya);
            bundle.putInt("obj_param1", eVar.cxW);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, eVar.cxX);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, eVar.cxY);
            bundle.putInt("obj_source", eVar.cdP);
            bundle.putInt("obj_locate", eVar.cxZ);
            eVar.E(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, eVar, true));
        }
    }

    private String t(bh bhVar) {
        if (bhVar == null || bhVar.aiO() == null) {
            return null;
        }
        ArrayList<MediaData> aiO = bhVar.aiO();
        int size = aiO.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aiO.get(i);
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
            if (bhVar.aiG()) {
                return 4;
            }
            if (bhVar.aiB() == 1) {
                return 3;
            }
            return bhVar.ajP() ? 2 : 1;
        }
        return 0;
    }

    public void ah(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iAe.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.iAd.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.iAf.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.iAh.getLayoutParams();
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
        this.iAe.setLayoutParams(layoutParams2);
    }
}

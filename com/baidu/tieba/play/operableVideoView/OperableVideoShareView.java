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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bg We;
    private c iza;
    private View izb;
    private ImageView izc;
    private View izd;
    private ImageView ize;
    private View izf;
    private ImageView izg;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.izb) {
                        OperableVideoShareView.this.zb(3);
                    } else if (view == OperableVideoShareView.this.izd) {
                        OperableVideoShareView.this.zb(2);
                    } else if (view == OperableVideoShareView.this.izf) {
                        OperableVideoShareView.this.zb(8);
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
                    if (view == OperableVideoShareView.this.izb) {
                        OperableVideoShareView.this.zb(3);
                    } else if (view == OperableVideoShareView.this.izd) {
                        OperableVideoShareView.this.zb(2);
                    } else if (view == OperableVideoShareView.this.izf) {
                        OperableVideoShareView.this.zb(8);
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
                    if (view == OperableVideoShareView.this.izb) {
                        OperableVideoShareView.this.zb(3);
                    } else if (view == OperableVideoShareView.this.izd) {
                        OperableVideoShareView.this.zb(2);
                    } else if (view == OperableVideoShareView.this.izf) {
                        OperableVideoShareView.this.zb(8);
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
        this.izb = findViewById(R.id.share_weixin);
        this.izd = findViewById(R.id.share_weixin_timeline);
        this.izf = findViewById(R.id.share_qq);
        this.izc = (ImageView) findViewById(R.id.share_weixin_img);
        this.ize = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.izg = (ImageView) findViewById(R.id.share_qq_img);
        this.izb.setOnClickListener(this.mOnClickListener);
        this.izd.setOnClickListener(this.mOnClickListener);
        this.izf.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.iza = cVar;
    }

    public void setShareData(bg bgVar) {
        this.We = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb(int i) {
        if (this.We != null) {
            String valueOf = String.valueOf(this.We.getFid());
            String aeC = this.We.aeC();
            if (this.We.bMa != null) {
                valueOf = this.We.bMa.id;
                aeC = this.We.bMa.ori_fname;
            }
            String title = this.We.getTitle();
            String tid = this.We.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.We);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.We.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            e eVar = new e();
            eVar.title = title;
            eVar.content = format;
            eVar.ckI = str2;
            eVar.linkUrl = str;
            eVar.bMt = 3;
            eVar.extData = tid;
            eVar.ckL = 3;
            eVar.ckM = 1;
            eVar.ckN = 0;
            eVar.fid = valueOf;
            eVar.ckC = aeC;
            eVar.tid = tid;
            eVar.ckx = true;
            eVar.ckK = 3;
            eVar.ckP = s(this.We);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.We);
            eVar.ckO = 1;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.ckZ = this.We.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", eVar.tid);
            bundle.putString("fid", eVar.fid);
            bundle.putInt("obj_type", eVar.ckP);
            bundle.putInt("obj_param1", eVar.ckL);
            bundle.putInt("obj_param2", eVar.ckM);
            bundle.putInt("obj_param3", eVar.ckN);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMt);
            bundle.putInt("obj_locate", eVar.ckO);
            eVar.E(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, eVar, true));
        }
    }

    private String r(bg bgVar) {
        if (bgVar == null || bgVar.aeH() == null) {
            return null;
        }
        ArrayList<MediaData> aeH = bgVar.aeH();
        int size = aeH.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aeH.get(i);
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
            if (bgVar.aez()) {
                return 4;
            }
            if (bgVar.aeu() == 1) {
                return 3;
            }
            return bgVar.afJ() ? 2 : 1;
        }
        return 0;
    }

    public void ah(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.izd.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.izc.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.ize.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.izg.getLayoutParams();
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
        this.izd.setLayoutParams(layoutParams2);
    }
}

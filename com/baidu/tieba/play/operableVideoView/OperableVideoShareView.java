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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bh We;
    private c iAe;
    private View iAf;
    private ImageView iAg;
    private View iAh;
    private ImageView iAi;
    private View iAj;
    private ImageView iAk;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.iAf) {
                        OperableVideoShareView.this.zd(3);
                    } else if (view == OperableVideoShareView.this.iAh) {
                        OperableVideoShareView.this.zd(2);
                    } else if (view == OperableVideoShareView.this.iAj) {
                        OperableVideoShareView.this.zd(8);
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
                    if (view == OperableVideoShareView.this.iAf) {
                        OperableVideoShareView.this.zd(3);
                    } else if (view == OperableVideoShareView.this.iAh) {
                        OperableVideoShareView.this.zd(2);
                    } else if (view == OperableVideoShareView.this.iAj) {
                        OperableVideoShareView.this.zd(8);
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
                    if (view == OperableVideoShareView.this.iAf) {
                        OperableVideoShareView.this.zd(3);
                    } else if (view == OperableVideoShareView.this.iAh) {
                        OperableVideoShareView.this.zd(2);
                    } else if (view == OperableVideoShareView.this.iAj) {
                        OperableVideoShareView.this.zd(8);
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
        this.iAf = findViewById(R.id.share_weixin);
        this.iAh = findViewById(R.id.share_weixin_timeline);
        this.iAj = findViewById(R.id.share_qq);
        this.iAg = (ImageView) findViewById(R.id.share_weixin_img);
        this.iAi = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.iAk = (ImageView) findViewById(R.id.share_qq_img);
        this.iAf.setOnClickListener(this.mOnClickListener);
        this.iAh.setOnClickListener(this.mOnClickListener);
        this.iAj.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.iAe = cVar;
    }

    public void setShareData(bh bhVar) {
        this.We = bhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd(int i) {
        if (this.We != null) {
            String valueOf = String.valueOf(this.We.getFid());
            String aeD = this.We.aeD();
            if (this.We.bMf != null) {
                valueOf = this.We.bMf.id;
                aeD = this.We.bMf.ori_fname;
            }
            String title = this.We.getTitle();
            String tid = this.We.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String s = s(this.We);
            Uri parse = s == null ? null : Uri.parse(s);
            String str2 = this.We.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            e eVar = new e();
            eVar.title = title;
            eVar.content = format;
            eVar.ckP = str2;
            eVar.linkUrl = str;
            eVar.bMy = 3;
            eVar.extData = tid;
            eVar.ckS = 3;
            eVar.ckT = 1;
            eVar.ckU = 0;
            eVar.fid = valueOf;
            eVar.ckJ = aeD;
            eVar.tid = tid;
            eVar.ckE = true;
            eVar.ckR = 3;
            eVar.ckW = t(this.We);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.We);
            eVar.ckV = 1;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.clg = this.We.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", eVar.tid);
            bundle.putString("fid", eVar.fid);
            bundle.putInt("obj_type", eVar.ckW);
            bundle.putInt("obj_param1", eVar.ckS);
            bundle.putInt("obj_param2", eVar.ckT);
            bundle.putInt("obj_param3", eVar.ckU);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMy);
            bundle.putInt("obj_locate", eVar.ckV);
            eVar.E(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, eVar, true));
        }
    }

    private String s(bh bhVar) {
        if (bhVar == null || bhVar.aeI() == null) {
            return null;
        }
        ArrayList<MediaData> aeI = bhVar.aeI();
        int size = aeI.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aeI.get(i);
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

    private int t(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aeA()) {
                return 4;
            }
            if (bhVar.aev() == 1) {
                return 3;
            }
            return bhVar.afK() ? 2 : 1;
        }
        return 0;
    }

    public void ah(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iAh.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.iAg.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.iAi.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.iAk.getLayoutParams();
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
        this.iAh.setLayoutParams(layoutParams2);
    }
}

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
    private bh Wd;
    private ImageView iCA;
    private View iCB;
    private ImageView iCC;
    private c iCw;
    private View iCx;
    private ImageView iCy;
    private View iCz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.iCx) {
                        OperableVideoShareView.this.zg(3);
                    } else if (view == OperableVideoShareView.this.iCz) {
                        OperableVideoShareView.this.zg(2);
                    } else if (view == OperableVideoShareView.this.iCB) {
                        OperableVideoShareView.this.zg(8);
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
                    if (view == OperableVideoShareView.this.iCx) {
                        OperableVideoShareView.this.zg(3);
                    } else if (view == OperableVideoShareView.this.iCz) {
                        OperableVideoShareView.this.zg(2);
                    } else if (view == OperableVideoShareView.this.iCB) {
                        OperableVideoShareView.this.zg(8);
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
                    if (view == OperableVideoShareView.this.iCx) {
                        OperableVideoShareView.this.zg(3);
                    } else if (view == OperableVideoShareView.this.iCz) {
                        OperableVideoShareView.this.zg(2);
                    } else if (view == OperableVideoShareView.this.iCB) {
                        OperableVideoShareView.this.zg(8);
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
        this.iCx = findViewById(R.id.share_weixin);
        this.iCz = findViewById(R.id.share_weixin_timeline);
        this.iCB = findViewById(R.id.share_qq);
        this.iCy = (ImageView) findViewById(R.id.share_weixin_img);
        this.iCA = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.iCC = (ImageView) findViewById(R.id.share_qq_img);
        this.iCx.setOnClickListener(this.mOnClickListener);
        this.iCz.setOnClickListener(this.mOnClickListener);
        this.iCB.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.iCw = cVar;
    }

    public void setShareData(bh bhVar) {
        this.Wd = bhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg(int i) {
        if (this.Wd != null) {
            String valueOf = String.valueOf(this.Wd.getFid());
            String aeH = this.Wd.aeH();
            if (this.Wd.bMD != null) {
                valueOf = this.Wd.bMD.id;
                aeH = this.Wd.bMD.ori_fname;
            }
            String title = this.Wd.getTitle();
            String tid = this.Wd.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String t = t(this.Wd);
            Uri parse = t == null ? null : Uri.parse(t);
            String str2 = this.Wd.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            e eVar = new e();
            eVar.title = title;
            eVar.content = format;
            eVar.clK = str2;
            eVar.linkUrl = str;
            eVar.bMX = 3;
            eVar.extData = tid;
            eVar.clN = 3;
            eVar.clO = 1;
            eVar.clP = 0;
            eVar.fid = valueOf;
            eVar.clE = aeH;
            eVar.tid = tid;
            eVar.clz = true;
            eVar.clM = 3;
            eVar.clR = u(this.Wd);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Wd);
            eVar.clQ = 1;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.cmb = this.Wd.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", eVar.tid);
            bundle.putString("fid", eVar.fid);
            bundle.putInt("obj_type", eVar.clR);
            bundle.putInt("obj_param1", eVar.clN);
            bundle.putInt("obj_param2", eVar.clO);
            bundle.putInt("obj_param3", eVar.clP);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMX);
            bundle.putInt("obj_locate", eVar.clQ);
            eVar.E(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, eVar, true));
        }
    }

    private String t(bh bhVar) {
        if (bhVar == null || bhVar.aeM() == null) {
            return null;
        }
        ArrayList<MediaData> aeM = bhVar.aeM();
        int size = aeM.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aeM.get(i);
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
            if (bhVar.aeE()) {
                return 4;
            }
            if (bhVar.aez() == 1) {
                return 3;
            }
            return bhVar.afO() ? 2 : 1;
        }
        return 0;
    }

    public void af(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iCz.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.iCy.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.iCA.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.iCC.getLayoutParams();
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
        this.iCz.setLayoutParams(layoutParams2);
    }
}

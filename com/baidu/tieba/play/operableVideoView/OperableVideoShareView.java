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
    private bg VJ;
    private c isJ;
    private View isK;
    private ImageView isL;
    private View isM;
    private ImageView isN;
    private View isO;
    private ImageView isP;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.isK) {
                        OperableVideoShareView.this.yw(3);
                    } else if (view == OperableVideoShareView.this.isM) {
                        OperableVideoShareView.this.yw(2);
                    } else if (view == OperableVideoShareView.this.isO) {
                        OperableVideoShareView.this.yw(8);
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
                    if (view == OperableVideoShareView.this.isK) {
                        OperableVideoShareView.this.yw(3);
                    } else if (view == OperableVideoShareView.this.isM) {
                        OperableVideoShareView.this.yw(2);
                    } else if (view == OperableVideoShareView.this.isO) {
                        OperableVideoShareView.this.yw(8);
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
                    if (view == OperableVideoShareView.this.isK) {
                        OperableVideoShareView.this.yw(3);
                    } else if (view == OperableVideoShareView.this.isM) {
                        OperableVideoShareView.this.yw(2);
                    } else if (view == OperableVideoShareView.this.isO) {
                        OperableVideoShareView.this.yw(8);
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
        this.isK = findViewById(R.id.share_weixin);
        this.isM = findViewById(R.id.share_weixin_timeline);
        this.isO = findViewById(R.id.share_qq);
        this.isL = (ImageView) findViewById(R.id.share_weixin_img);
        this.isN = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.isP = (ImageView) findViewById(R.id.share_qq_img);
        this.isK.setOnClickListener(this.mOnClickListener);
        this.isM.setOnClickListener(this.mOnClickListener);
        this.isO.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.isJ = cVar;
    }

    public void setShareData(bg bgVar) {
        this.VJ = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (this.VJ != null) {
            String valueOf = String.valueOf(this.VJ.getFid());
            String adA = this.VJ.adA();
            if (this.VJ.bLa != null) {
                valueOf = this.VJ.bLa.id;
                adA = this.VJ.bLa.ori_fname;
            }
            String title = this.VJ.getTitle();
            String tid = this.VJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.VJ);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.VJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            e eVar = new e();
            eVar.title = title;
            eVar.content = format;
            eVar.cjD = str2;
            eVar.linkUrl = str;
            eVar.bLt = 3;
            eVar.extData = tid;
            eVar.cjG = 3;
            eVar.cjH = 1;
            eVar.cjI = 0;
            eVar.fid = valueOf;
            eVar.cjx = adA;
            eVar.tid = tid;
            eVar.cjs = true;
            eVar.cjF = 3;
            eVar.cjK = s(this.VJ);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.VJ);
            eVar.cjJ = 1;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.cjU = this.VJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", eVar.tid);
            bundle.putString("fid", eVar.fid);
            bundle.putInt("obj_type", eVar.cjK);
            bundle.putInt("obj_param1", eVar.cjG);
            bundle.putInt("obj_param2", eVar.cjH);
            bundle.putInt("obj_param3", eVar.cjI);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLt);
            bundle.putInt("obj_locate", eVar.cjJ);
            eVar.E(bundle);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, eVar, true));
        }
    }

    private String r(bg bgVar) {
        if (bgVar == null || bgVar.adF() == null) {
            return null;
        }
        ArrayList<MediaData> adF = bgVar.adF();
        int size = adF.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = adF.get(i);
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
            if (bgVar.adx()) {
                return 4;
            }
            if (bgVar.ads() == 1) {
                return 3;
            }
            return bgVar.aeH() ? 2 : 1;
        }
        return 0;
    }

    public void ae(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.isM.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.isL.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.isN.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.isP.getLayoutParams();
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
        this.isM.setLayoutParams(layoutParams2);
    }
}

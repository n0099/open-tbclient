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
    private bg VK;
    private c isI;
    private View isJ;
    private ImageView isK;
    private View isL;
    private ImageView isM;
    private View isN;
    private ImageView isO;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!i.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.isJ) {
                        OperableVideoShareView.this.yw(3);
                    } else if (view == OperableVideoShareView.this.isL) {
                        OperableVideoShareView.this.yw(2);
                    } else if (view == OperableVideoShareView.this.isN) {
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
                    if (view == OperableVideoShareView.this.isJ) {
                        OperableVideoShareView.this.yw(3);
                    } else if (view == OperableVideoShareView.this.isL) {
                        OperableVideoShareView.this.yw(2);
                    } else if (view == OperableVideoShareView.this.isN) {
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
                    if (view == OperableVideoShareView.this.isJ) {
                        OperableVideoShareView.this.yw(3);
                    } else if (view == OperableVideoShareView.this.isL) {
                        OperableVideoShareView.this.yw(2);
                    } else if (view == OperableVideoShareView.this.isN) {
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
        this.isJ = findViewById(R.id.share_weixin);
        this.isL = findViewById(R.id.share_weixin_timeline);
        this.isN = findViewById(R.id.share_qq);
        this.isK = (ImageView) findViewById(R.id.share_weixin_img);
        this.isM = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.isO = (ImageView) findViewById(R.id.share_qq_img);
        this.isJ.setOnClickListener(this.mOnClickListener);
        this.isL.setOnClickListener(this.mOnClickListener);
        this.isN.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoContainer(c cVar) {
        this.isI = cVar;
    }

    public void setShareData(bg bgVar) {
        this.VK = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (this.VK != null) {
            String valueOf = String.valueOf(this.VK.getFid());
            String adA = this.VK.adA();
            if (this.VK.bKZ != null) {
                valueOf = this.VK.bKZ.id;
                adA = this.VK.bKZ.ori_fname;
            }
            String title = this.VK.getTitle();
            String tid = this.VK.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.VK);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.VK.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            e eVar = new e();
            eVar.title = title;
            eVar.content = format;
            eVar.cjC = str2;
            eVar.linkUrl = str;
            eVar.bLs = 3;
            eVar.extData = tid;
            eVar.cjF = 3;
            eVar.cjG = 1;
            eVar.cjH = 0;
            eVar.fid = valueOf;
            eVar.cjw = adA;
            eVar.tid = tid;
            eVar.cjr = true;
            eVar.cjE = 3;
            eVar.cjJ = s(this.VK);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.VK);
            eVar.cjI = 1;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.cjT = this.VK.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", eVar.tid);
            bundle.putString("fid", eVar.fid);
            bundle.putInt("obj_type", eVar.cjJ);
            bundle.putInt("obj_param1", eVar.cjF);
            bundle.putInt("obj_param2", eVar.cjG);
            bundle.putInt("obj_param3", eVar.cjH);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLs);
            bundle.putInt("obj_locate", eVar.cjI);
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
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.isL.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.isK.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.isM.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = this.isO.getLayoutParams();
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
        this.isL.setLayoutParams(layoutParams2);
    }
}

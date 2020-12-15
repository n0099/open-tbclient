package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private by ahA;
    private int eMJ;
    private View fYf;
    private d mAD;
    private View mAE;
    private ImageView mAF;
    private View mAG;
    private ImageView mAH;
    private View mAI;
    private ImageView mAJ;
    private View mAK;
    private ImageView mAL;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eMJ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mAE) {
                        OperableVideoShareView.this.IN(3);
                    } else if (view == OperableVideoShareView.this.mAG) {
                        OperableVideoShareView.this.IN(2);
                    } else if (view == OperableVideoShareView.this.mAI) {
                        OperableVideoShareView.this.IN(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eMJ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mAE) {
                        OperableVideoShareView.this.IN(3);
                    } else if (view == OperableVideoShareView.this.mAG) {
                        OperableVideoShareView.this.IN(2);
                    } else if (view == OperableVideoShareView.this.mAI) {
                        OperableVideoShareView.this.IN(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMJ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mAE) {
                        OperableVideoShareView.this.IN(3);
                    } else if (view == OperableVideoShareView.this.mAG) {
                        OperableVideoShareView.this.IN(2);
                    } else if (view == OperableVideoShareView.this.mAI) {
                        OperableVideoShareView.this.IN(8);
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
        this.mAE = findViewById(R.id.share_weixin);
        this.mAF = (ImageView) findViewById(R.id.share_weixin_img);
        this.mAG = findViewById(R.id.share_weixin_timeline);
        this.mAH = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mAI = findViewById(R.id.share_qq);
        this.mAJ = (ImageView) findViewById(R.id.share_qq_img);
        this.fYf = findViewById(R.id.divider_line);
        this.mAK = findViewById(R.id.video_replay);
        this.mAL = (ImageView) findViewById(R.id.replay_img);
        this.mAE.setOnClickListener(this.mOnClickListener);
        this.mAG.setOnClickListener(this.mOnClickListener);
        this.mAI.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mAF.setImageDrawable(SvgManager.btW().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mAH.setImageDrawable(SvgManager.btW().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mAJ.setImageDrawable(SvgManager.btW().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mAL.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null, false));
        this.mAL.setBackgroundDrawable(ap.aR(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public void setVideoContainer(d dVar) {
        this.mAD = dVar;
        this.mAK.setOnClickListener(this.mAD);
    }

    public void setShareData(by byVar) {
        this.ahA = byVar;
        if (this.ahA != null && !this.ahA.bnz()) {
            this.mAI.setVisibility(0);
            this.mAE.setVisibility(0);
            this.mAG.setVisibility(0);
            this.fYf.setVisibility(0);
            return;
        }
        this.mAI.setVisibility(8);
        this.mAE.setVisibility(8);
        this.mAG.setVisibility(8);
        this.fYf.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eMJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN(int i) {
        if (this.ahA != null) {
            String valueOf = String.valueOf(this.ahA.getFid());
            String boT = this.ahA.boT();
            if (this.ahA.eLS != null) {
                valueOf = this.ahA.eLS.id;
                boT = this.ahA.eLS.ori_fname;
            }
            String title = this.ahA.getTitle();
            String tid = this.ahA.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.ahA);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.ahA.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.ahA.bnz() && this.ahA.bqj() && this.ahA.bph() != null) {
                shareItem.readCount = this.ahA.bph().play_count.intValue();
            }
            shareItem.fnC = str2;
            shareItem.linkUrl = str;
            shareItem.eMJ = this.eMJ;
            shareItem.extData = tid;
            shareItem.fnF = 3;
            shareItem.fnG = 1;
            if (i == 3) {
                shareItem.fnH = 1;
            } else if (i == 2) {
                shareItem.fnH = 2;
            } else if (i == 8) {
                shareItem.fnH = 3;
            } else {
                shareItem.fnH = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = boT;
            shareItem.tid = tid;
            shareItem.nid = this.ahA.getNid();
            shareItem.fnt = true;
            shareItem.fnE = 3;
            shareItem.fnJ = getStateThreadType(this.ahA);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahA);
            shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(this.ahA);
            shareItem.fnI = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fnT = this.ahA.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fnJ);
            bundle.putInt("obj_param1", shareItem.fnF);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fnG);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fnH);
            bundle.putInt("obj_source", shareItem.eMJ);
            bundle.putInt("obj_locate", shareItem.fnI);
            shareItem.ae(bundle);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dY("tid", shareItem.tid);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("fid", shareItem.fid);
            arVar.al("obj_locate", this.eMJ);
            arVar.al(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fnH);
            arVar.dY("nid", shareItem.nid);
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(by byVar) {
        if (byVar == null || byVar.boY() == null) {
            return null;
        }
        ArrayList<MediaData> boY = byVar.boY();
        int size = boY.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = boY.get(i);
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

    private int getStateThreadType(by byVar) {
        if (byVar != null) {
            if (byVar.boR()) {
                return 4;
            }
            if (byVar.boM() == 1) {
                return 3;
            }
            return byVar.bqj() ? 2 : 1;
        }
        return 0;
    }

    public void as(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mAG.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mAE.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mAI.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fYf.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mAK.getLayoutParams();
        if (z2 && !z) {
            dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds72);
            dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52);
        } else {
            dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds36);
            dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26);
        }
        layoutParams4.rightMargin = dimens2;
        layoutParams4.leftMargin = dimens2;
        layoutParams5.rightMargin = dimens;
        layoutParams5.leftMargin = dimens;
        layoutParams3.rightMargin = dimens;
        layoutParams3.leftMargin = dimens;
        layoutParams2.rightMargin = dimens;
        layoutParams2.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
    }
}

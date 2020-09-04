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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bw afL;
    private int eeF;
    private View fmI;
    private d lvC;
    private View lvD;
    private ImageView lvE;
    private View lvF;
    private ImageView lvG;
    private View lvH;
    private ImageView lvI;
    private View lvJ;
    private ImageView lvK;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eeF = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lvD) {
                        OperableVideoShareView.this.FL(3);
                    } else if (view == OperableVideoShareView.this.lvF) {
                        OperableVideoShareView.this.FL(2);
                    } else if (view == OperableVideoShareView.this.lvH) {
                        OperableVideoShareView.this.FL(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eeF = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lvD) {
                        OperableVideoShareView.this.FL(3);
                    } else if (view == OperableVideoShareView.this.lvF) {
                        OperableVideoShareView.this.FL(2);
                    } else if (view == OperableVideoShareView.this.lvH) {
                        OperableVideoShareView.this.FL(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eeF = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lvD) {
                        OperableVideoShareView.this.FL(3);
                    } else if (view == OperableVideoShareView.this.lvF) {
                        OperableVideoShareView.this.FL(2);
                    } else if (view == OperableVideoShareView.this.lvH) {
                        OperableVideoShareView.this.FL(8);
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
        this.lvD = findViewById(R.id.share_weixin);
        this.lvE = (ImageView) findViewById(R.id.share_weixin_img);
        this.lvF = findViewById(R.id.share_weixin_timeline);
        this.lvG = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.lvH = findViewById(R.id.share_qq);
        this.lvI = (ImageView) findViewById(R.id.share_qq_img);
        this.fmI = findViewById(R.id.divider_line);
        this.lvJ = findViewById(R.id.video_replay);
        this.lvK = (ImageView) findViewById(R.id.replay_img);
        this.lvD.setOnClickListener(this.mOnClickListener);
        this.lvF.setOnClickListener(this.mOnClickListener);
        this.lvH.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.lvE.setImageDrawable(SvgManager.bjq().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.lvG.setImageDrawable(SvgManager.bjq().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.lvI.setImageDrawable(SvgManager.bjq().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.lvK.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.lvK.setBackgroundDrawable(ap.aO(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.lvC = dVar;
        this.lvJ.setOnClickListener(this.lvC);
    }

    public void setShareData(bw bwVar) {
        this.afL = bwVar;
        if (this.afL != null && !this.afL.bdo()) {
            this.lvH.setVisibility(0);
            this.lvD.setVisibility(0);
            this.lvF.setVisibility(0);
            this.fmI.setVisibility(0);
            return;
        }
        this.lvH.setVisibility(8);
        this.lvD.setVisibility(8);
        this.lvF.setVisibility(8);
        this.fmI.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eeF = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL(int i) {
        if (this.afL != null) {
            String valueOf = String.valueOf(this.afL.getFid());
            String beI = this.afL.beI();
            if (this.afL.edT != null) {
                valueOf = this.afL.edT.id;
                beI = this.afL.edT.ori_fname;
            }
            String title = this.afL.getTitle();
            String tid = this.afL.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.afL);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.afL.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.afL.bdo() && this.afL.bfW() && this.afL.beW() != null) {
                shareItem.readCount = this.afL.beW().play_count.intValue();
            }
            shareItem.eEu = str2;
            shareItem.linkUrl = str;
            shareItem.eeF = this.eeF;
            shareItem.extData = tid;
            shareItem.eEx = 3;
            shareItem.eEy = 1;
            if (i == 3) {
                shareItem.eEz = 1;
            } else if (i == 2) {
                shareItem.eEz = 2;
            } else if (i == 8) {
                shareItem.eEz = 3;
            } else {
                shareItem.eEz = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = beI;
            shareItem.tid = tid;
            shareItem.nid = this.afL.getNid();
            shareItem.eEl = true;
            shareItem.eEw = 3;
            shareItem.eEB = getStateThreadType(this.afL);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo(this.afL);
            shareItem.eEF = ShareItem.ForwardInfo.generateForwardInfo(this.afL);
            shareItem.eEA = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eEL = this.afL.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.eEB);
            bundle.putInt("obj_param1", shareItem.eEx);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eEy);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eEz);
            bundle.putInt("obj_source", shareItem.eeF);
            bundle.putInt("obj_locate", shareItem.eEA);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dD("tid", shareItem.tid);
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("fid", shareItem.fid);
            aqVar.ai("obj_locate", this.eeF);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eEz);
            aqVar.dD("nid", shareItem.nid);
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.beN() == null) {
            return null;
        }
        ArrayList<MediaData> beN = bwVar.beN();
        int size = beN.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = beN.get(i);
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

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.beG()) {
                return 4;
            }
            if (bwVar.beB() == 1) {
                return 3;
            }
            return bwVar.bfW() ? 2 : 1;
        }
        return 0;
    }

    public void ar(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvF.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lvD.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lvH.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fmI.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.lvJ.getLayoutParams();
        if (z2 && !z) {
            dimens = l.getDimens(getContext(), R.dimen.tbds72);
            dimens2 = l.getDimens(getContext(), R.dimen.tbds52);
        } else {
            dimens = l.getDimens(getContext(), R.dimen.tbds36);
            dimens2 = l.getDimens(getContext(), R.dimen.tbds26);
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

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
/* loaded from: classes2.dex */
public class OperableVideoShareView extends LinearLayout {
    private bw afJ;
    private int eeB;
    private View fmE;
    private d lvr;
    private View lvs;
    private ImageView lvt;
    private View lvu;
    private ImageView lvv;
    private View lvw;
    private ImageView lvx;
    private View lvy;
    private ImageView lvz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eeB = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lvs) {
                        OperableVideoShareView.this.FL(3);
                    } else if (view == OperableVideoShareView.this.lvu) {
                        OperableVideoShareView.this.FL(2);
                    } else if (view == OperableVideoShareView.this.lvw) {
                        OperableVideoShareView.this.FL(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eeB = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lvs) {
                        OperableVideoShareView.this.FL(3);
                    } else if (view == OperableVideoShareView.this.lvu) {
                        OperableVideoShareView.this.FL(2);
                    } else if (view == OperableVideoShareView.this.lvw) {
                        OperableVideoShareView.this.FL(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eeB = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lvs) {
                        OperableVideoShareView.this.FL(3);
                    } else if (view == OperableVideoShareView.this.lvu) {
                        OperableVideoShareView.this.FL(2);
                    } else if (view == OperableVideoShareView.this.lvw) {
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
        this.lvs = findViewById(R.id.share_weixin);
        this.lvt = (ImageView) findViewById(R.id.share_weixin_img);
        this.lvu = findViewById(R.id.share_weixin_timeline);
        this.lvv = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.lvw = findViewById(R.id.share_qq);
        this.lvx = (ImageView) findViewById(R.id.share_qq_img);
        this.fmE = findViewById(R.id.divider_line);
        this.lvy = findViewById(R.id.video_replay);
        this.lvz = (ImageView) findViewById(R.id.replay_img);
        this.lvs.setOnClickListener(this.mOnClickListener);
        this.lvu.setOnClickListener(this.mOnClickListener);
        this.lvw.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.lvt.setImageDrawable(SvgManager.bjq().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.lvv.setImageDrawable(SvgManager.bjq().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.lvx.setImageDrawable(SvgManager.bjq().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.lvz.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.lvz.setBackgroundDrawable(ap.aO(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.lvr = dVar;
        this.lvy.setOnClickListener(this.lvr);
    }

    public void setShareData(bw bwVar) {
        this.afJ = bwVar;
        if (this.afJ != null && !this.afJ.bdo()) {
            this.lvw.setVisibility(0);
            this.lvs.setVisibility(0);
            this.lvu.setVisibility(0);
            this.fmE.setVisibility(0);
            return;
        }
        this.lvw.setVisibility(8);
        this.lvs.setVisibility(8);
        this.lvu.setVisibility(8);
        this.fmE.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eeB = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL(int i) {
        if (this.afJ != null) {
            String valueOf = String.valueOf(this.afJ.getFid());
            String beI = this.afJ.beI();
            if (this.afJ.edP != null) {
                valueOf = this.afJ.edP.id;
                beI = this.afJ.edP.ori_fname;
            }
            String title = this.afJ.getTitle();
            String tid = this.afJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.afJ);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.afJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.afJ.bdo() && this.afJ.bfW() && this.afJ.beW() != null) {
                shareItem.readCount = this.afJ.beW().play_count.intValue();
            }
            shareItem.eEq = str2;
            shareItem.linkUrl = str;
            shareItem.eeB = this.eeB;
            shareItem.extData = tid;
            shareItem.eEt = 3;
            shareItem.eEu = 1;
            if (i == 3) {
                shareItem.eEv = 1;
            } else if (i == 2) {
                shareItem.eEv = 2;
            } else if (i == 8) {
                shareItem.eEv = 3;
            } else {
                shareItem.eEv = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = beI;
            shareItem.tid = tid;
            shareItem.nid = this.afJ.getNid();
            shareItem.eEh = true;
            shareItem.eEs = 3;
            shareItem.eEx = getStateThreadType(this.afJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(this.afJ);
            shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(this.afJ);
            shareItem.eEw = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eEH = this.afJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.eEx);
            bundle.putInt("obj_param1", shareItem.eEt);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eEu);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eEv);
            bundle.putInt("obj_source", shareItem.eeB);
            bundle.putInt("obj_locate", shareItem.eEw);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dD("tid", shareItem.tid);
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("fid", shareItem.fid);
            aqVar.ai("obj_locate", this.eeB);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eEv);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvu.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lvs.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lvw.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fmE.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.lvy.getLayoutParams();
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

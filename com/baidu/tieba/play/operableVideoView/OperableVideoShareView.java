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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    private cb ahi;
    private int eUk;
    private View gft;
    private ImageView mKA;
    private View mKB;
    private ImageView mKC;
    private d mKu;
    private View mKv;
    private ImageView mKw;
    private View mKx;
    private ImageView mKy;
    private View mKz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eUk = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mKv) {
                        OperableVideoShareView.this.Hs(3);
                    } else if (view == OperableVideoShareView.this.mKx) {
                        OperableVideoShareView.this.Hs(2);
                    } else if (view == OperableVideoShareView.this.mKz) {
                        OperableVideoShareView.this.Hs(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eUk = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mKv) {
                        OperableVideoShareView.this.Hs(3);
                    } else if (view == OperableVideoShareView.this.mKx) {
                        OperableVideoShareView.this.Hs(2);
                    } else if (view == OperableVideoShareView.this.mKz) {
                        OperableVideoShareView.this.Hs(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUk = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mKv) {
                        OperableVideoShareView.this.Hs(3);
                    } else if (view == OperableVideoShareView.this.mKx) {
                        OperableVideoShareView.this.Hs(2);
                    } else if (view == OperableVideoShareView.this.mKz) {
                        OperableVideoShareView.this.Hs(8);
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
        this.mKv = findViewById(R.id.share_weixin);
        this.mKw = (ImageView) findViewById(R.id.share_weixin_img);
        this.mKx = findViewById(R.id.share_weixin_timeline);
        this.mKy = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mKz = findViewById(R.id.share_qq);
        this.mKA = (ImageView) findViewById(R.id.share_qq_img);
        this.gft = findViewById(R.id.divider_line);
        this.mKB = findViewById(R.id.video_replay);
        this.mKC = (ImageView) findViewById(R.id.replay_img);
        this.mKv.setOnClickListener(this.mOnClickListener);
        this.mKx.setOnClickListener(this.mOnClickListener);
        this.mKz.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mKw.setImageDrawable(SvgManager.bsR().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mKy.setImageDrawable(SvgManager.bsR().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mKA.setImageDrawable(SvgManager.bsR().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mKC.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null, false));
        this.mKC.setBackgroundDrawable(ap.aL(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public void setVideoContainer(d dVar) {
        this.mKu = dVar;
        this.mKB.setOnClickListener(this.mKu);
    }

    public void setShareData(cb cbVar) {
        this.ahi = cbVar;
        if (this.ahi != null && !this.ahi.bmz()) {
            this.mKz.setVisibility(0);
            this.mKv.setVisibility(0);
            this.mKx.setVisibility(0);
            this.gft.setVisibility(0);
            return;
        }
        this.mKz.setVisibility(8);
        this.mKv.setVisibility(8);
        this.mKx.setVisibility(8);
        this.gft.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eUk = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hs(int i) {
        if (this.ahi != null) {
            String valueOf = String.valueOf(this.ahi.getFid());
            String bnU = this.ahi.bnU();
            if (this.ahi.eTn != null) {
                valueOf = this.ahi.eTn.id;
                bnU = this.ahi.eTn.ori_fname;
            }
            String title = this.ahi.getTitle();
            String tid = this.ahi.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.ahi);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.ahi.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.ahi.bmz() && this.ahi.bpk() && this.ahi.boh() != null) {
                shareItem.readCount = this.ahi.boh().play_count.intValue();
            }
            shareItem.fuV = str2;
            shareItem.linkUrl = str;
            shareItem.eUk = this.eUk;
            shareItem.extData = tid;
            shareItem.fuY = 3;
            shareItem.fuZ = 1;
            if (i == 3) {
                shareItem.fva = 1;
            } else if (i == 2) {
                shareItem.fva = 2;
            } else if (i == 8) {
                shareItem.fva = 3;
            } else {
                shareItem.fva = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bnU;
            shareItem.tid = tid;
            shareItem.nid = this.ahi.bmo();
            shareItem.fuM = true;
            shareItem.fuX = 3;
            shareItem.fvc = getStateThreadType(this.ahi);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahi);
            shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(this.ahi);
            shareItem.fvb = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fvm = this.ahi.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fvc);
            bundle.putInt("obj_param1", shareItem.fuY);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fuZ);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fva);
            bundle.putInt("obj_source", shareItem.eUk);
            bundle.putInt("obj_locate", shareItem.fvb);
            shareItem.ae(bundle);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dR("tid", shareItem.tid);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("fid", shareItem.fid);
            arVar.ap("obj_locate", this.eUk);
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fva);
            arVar.dR(IntentConfig.NID, shareItem.nid);
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(cb cbVar) {
        if (cbVar == null || cbVar.bnZ() == null) {
            return null;
        }
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        int size = bnZ.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bnZ.get(i);
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

    private int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnS()) {
                return 4;
            }
            if (cbVar.bnN() == 1) {
                return 3;
            }
            return cbVar.bpk() ? 2 : 1;
        }
        return 0;
    }

    public void au(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mKx.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mKv.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mKz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.gft.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mKB.getLayoutParams();
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

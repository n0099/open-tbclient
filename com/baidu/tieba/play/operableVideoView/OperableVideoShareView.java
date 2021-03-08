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
    private cb aiB;
    private int eVJ;
    private View ghb;
    private d mML;
    private View mMM;
    private ImageView mMN;
    private View mMO;
    private ImageView mMP;
    private View mMQ;
    private ImageView mMR;
    private View mMS;
    private ImageView mMT;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eVJ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mMM) {
                        OperableVideoShareView.this.Hv(3);
                    } else if (view == OperableVideoShareView.this.mMO) {
                        OperableVideoShareView.this.Hv(2);
                    } else if (view == OperableVideoShareView.this.mMQ) {
                        OperableVideoShareView.this.Hv(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVJ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mMM) {
                        OperableVideoShareView.this.Hv(3);
                    } else if (view == OperableVideoShareView.this.mMO) {
                        OperableVideoShareView.this.Hv(2);
                    } else if (view == OperableVideoShareView.this.mMQ) {
                        OperableVideoShareView.this.Hv(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eVJ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mMM) {
                        OperableVideoShareView.this.Hv(3);
                    } else if (view == OperableVideoShareView.this.mMO) {
                        OperableVideoShareView.this.Hv(2);
                    } else if (view == OperableVideoShareView.this.mMQ) {
                        OperableVideoShareView.this.Hv(8);
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
        this.mMM = findViewById(R.id.share_weixin);
        this.mMN = (ImageView) findViewById(R.id.share_weixin_img);
        this.mMO = findViewById(R.id.share_weixin_timeline);
        this.mMP = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mMQ = findViewById(R.id.share_qq);
        this.mMR = (ImageView) findViewById(R.id.share_qq_img);
        this.ghb = findViewById(R.id.divider_line);
        this.mMS = findViewById(R.id.video_replay);
        this.mMT = (ImageView) findViewById(R.id.replay_img);
        this.mMM.setOnClickListener(this.mOnClickListener);
        this.mMO.setOnClickListener(this.mOnClickListener);
        this.mMQ.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mMN.setImageDrawable(SvgManager.bsU().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mMP.setImageDrawable(SvgManager.bsU().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mMR.setImageDrawable(SvgManager.bsU().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mMT.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null, false));
        this.mMT.setBackgroundDrawable(ap.aL(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public void setVideoContainer(d dVar) {
        this.mML = dVar;
        this.mMS.setOnClickListener(this.mML);
    }

    public void setShareData(cb cbVar) {
        this.aiB = cbVar;
        if (this.aiB != null && !this.aiB.bmB()) {
            this.mMQ.setVisibility(0);
            this.mMM.setVisibility(0);
            this.mMO.setVisibility(0);
            this.ghb.setVisibility(0);
            return;
        }
        this.mMQ.setVisibility(8);
        this.mMM.setVisibility(8);
        this.mMO.setVisibility(8);
        this.ghb.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eVJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv(int i) {
        if (this.aiB != null) {
            String valueOf = String.valueOf(this.aiB.getFid());
            String bnW = this.aiB.bnW();
            if (this.aiB.eUO != null) {
                valueOf = this.aiB.eUO.id;
                bnW = this.aiB.eUO.ori_fname;
            }
            String title = this.aiB.getTitle();
            String tid = this.aiB.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.aiB);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.aiB.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.aiB.bmB() && this.aiB.bpm() && this.aiB.boj() != null) {
                shareItem.readCount = this.aiB.boj().play_count.intValue();
            }
            shareItem.fwu = str2;
            shareItem.linkUrl = str;
            shareItem.eVJ = this.eVJ;
            shareItem.extData = tid;
            shareItem.fwx = 3;
            shareItem.fwy = 1;
            if (i == 3) {
                shareItem.fwz = 1;
            } else if (i == 2) {
                shareItem.fwz = 2;
            } else if (i == 8) {
                shareItem.fwz = 3;
            } else {
                shareItem.fwz = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bnW;
            shareItem.tid = tid;
            shareItem.nid = this.aiB.bmq();
            shareItem.fwl = true;
            shareItem.fww = 3;
            shareItem.fwB = getStateThreadType(this.aiB);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aiB);
            shareItem.fwF = ShareItem.ForwardInfo.generateForwardInfo(this.aiB);
            shareItem.fwA = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fwL = this.aiB.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fwB);
            bundle.putInt("obj_param1", shareItem.fwx);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fwy);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fwz);
            bundle.putInt("obj_source", shareItem.eVJ);
            bundle.putInt("obj_locate", shareItem.fwA);
            shareItem.ae(bundle);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dR("tid", shareItem.tid);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("fid", shareItem.fid);
            arVar.aq("obj_locate", this.eVJ);
            arVar.aq(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fwz);
            arVar.dR(IntentConfig.NID, shareItem.nid);
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(cb cbVar) {
        if (cbVar == null || cbVar.bob() == null) {
            return null;
        }
        ArrayList<MediaData> bob = cbVar.bob();
        int size = bob.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bob.get(i);
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
            if (cbVar.bnU()) {
                return 4;
            }
            if (cbVar.bnP() == 1) {
                return 3;
            }
            return cbVar.bpm() ? 2 : 1;
        }
        return 0;
    }

    public void au(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mMO.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mMM.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mMQ.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.ghb.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mMS.getLayoutParams();
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

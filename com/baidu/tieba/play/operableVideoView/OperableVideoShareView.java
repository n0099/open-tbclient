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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
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
    private bz aim;
    private int eWH;
    private View ghM;
    private d mFU;
    private View mFV;
    private ImageView mFW;
    private View mFX;
    private ImageView mFY;
    private View mFZ;
    private ImageView mGa;
    private View mGb;
    private ImageView mGc;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eWH = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mFV) {
                        OperableVideoShareView.this.IH(3);
                    } else if (view == OperableVideoShareView.this.mFX) {
                        OperableVideoShareView.this.IH(2);
                    } else if (view == OperableVideoShareView.this.mFZ) {
                        OperableVideoShareView.this.IH(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWH = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mFV) {
                        OperableVideoShareView.this.IH(3);
                    } else if (view == OperableVideoShareView.this.mFX) {
                        OperableVideoShareView.this.IH(2);
                    } else if (view == OperableVideoShareView.this.mFZ) {
                        OperableVideoShareView.this.IH(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWH = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mFV) {
                        OperableVideoShareView.this.IH(3);
                    } else if (view == OperableVideoShareView.this.mFX) {
                        OperableVideoShareView.this.IH(2);
                    } else if (view == OperableVideoShareView.this.mFZ) {
                        OperableVideoShareView.this.IH(8);
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
        this.mFV = findViewById(R.id.share_weixin);
        this.mFW = (ImageView) findViewById(R.id.share_weixin_img);
        this.mFX = findViewById(R.id.share_weixin_timeline);
        this.mFY = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mFZ = findViewById(R.id.share_qq);
        this.mGa = (ImageView) findViewById(R.id.share_qq_img);
        this.ghM = findViewById(R.id.divider_line);
        this.mGb = findViewById(R.id.video_replay);
        this.mGc = (ImageView) findViewById(R.id.replay_img);
        this.mFV.setOnClickListener(this.mOnClickListener);
        this.mFX.setOnClickListener(this.mOnClickListener);
        this.mFZ.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mFW.setImageDrawable(SvgManager.bwq().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mFY.setImageDrawable(SvgManager.bwq().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mGa.setImageDrawable(SvgManager.bwq().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mGc.setImageDrawable(SvgManager.bwq().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null, false));
        this.mGc.setBackgroundDrawable(ao.aO(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public void setVideoContainer(d dVar) {
        this.mFU = dVar;
        this.mGb.setOnClickListener(this.mFU);
    }

    public void setShareData(bz bzVar) {
        this.aim = bzVar;
        if (this.aim != null && !this.aim.bpZ()) {
            this.mFZ.setVisibility(0);
            this.mFV.setVisibility(0);
            this.mFX.setVisibility(0);
            this.ghM.setVisibility(0);
            return;
        }
        this.mFZ.setVisibility(8);
        this.mFV.setVisibility(8);
        this.mFX.setVisibility(8);
        this.ghM.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eWH = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IH(int i) {
        if (this.aim != null) {
            String valueOf = String.valueOf(this.aim.getFid());
            String bru = this.aim.bru();
            if (this.aim.eVM != null) {
                valueOf = this.aim.eVM.id;
                bru = this.aim.eVM.ori_fname;
            }
            String title = this.aim.getTitle();
            String tid = this.aim.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.aim);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.aim.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.aim.bpZ() && this.aim.bsL() && this.aim.brH() != null) {
                shareItem.readCount = this.aim.brH().play_count.intValue();
            }
            shareItem.fxm = str2;
            shareItem.linkUrl = str;
            shareItem.eWH = this.eWH;
            shareItem.extData = tid;
            shareItem.fxp = 3;
            shareItem.fxq = 1;
            if (i == 3) {
                shareItem.fxr = 1;
            } else if (i == 2) {
                shareItem.fxr = 2;
            } else if (i == 8) {
                shareItem.fxr = 3;
            } else {
                shareItem.fxr = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bru;
            shareItem.tid = tid;
            shareItem.nid = this.aim.bpO();
            shareItem.fxd = true;
            shareItem.fxo = 3;
            shareItem.fxt = getStateThreadType(this.aim);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aim);
            shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(this.aim);
            shareItem.fxs = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fxD = this.aim.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fxt);
            bundle.putInt("obj_param1", shareItem.fxp);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fxq);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fxr);
            bundle.putInt("obj_source", shareItem.eWH);
            bundle.putInt("obj_locate", shareItem.fxs);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dX("tid", shareItem.tid);
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dX("fid", shareItem.fid);
            aqVar.an("obj_locate", this.eWH);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fxr);
            aqVar.dX(IntentConfig.NID, shareItem.nid);
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bz bzVar) {
        if (bzVar == null || bzVar.brz() == null) {
            return null;
        }
        ArrayList<MediaData> brz = bzVar.brz();
        int size = brz.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = brz.get(i);
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

    private int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.brs()) {
                return 4;
            }
            if (bzVar.brn() == 1) {
                return 3;
            }
            return bzVar.bsL() ? 2 : 1;
        }
        return 0;
    }

    public void au(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mFX.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mFV.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mFZ.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.ghM.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mGb.getLayoutParams();
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

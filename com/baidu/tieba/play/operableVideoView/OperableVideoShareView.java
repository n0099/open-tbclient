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
    private bz ahu;
    private int eRW;
    private View gde;
    private d mBl;
    private View mBm;
    private ImageView mBn;
    private View mBo;
    private ImageView mBp;
    private View mBq;
    private ImageView mBr;
    private View mBs;
    private ImageView mBt;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eRW = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mBm) {
                        OperableVideoShareView.this.Ha(3);
                    } else if (view == OperableVideoShareView.this.mBo) {
                        OperableVideoShareView.this.Ha(2);
                    } else if (view == OperableVideoShareView.this.mBq) {
                        OperableVideoShareView.this.Ha(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eRW = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mBm) {
                        OperableVideoShareView.this.Ha(3);
                    } else if (view == OperableVideoShareView.this.mBo) {
                        OperableVideoShareView.this.Ha(2);
                    } else if (view == OperableVideoShareView.this.mBq) {
                        OperableVideoShareView.this.Ha(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eRW = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mBm) {
                        OperableVideoShareView.this.Ha(3);
                    } else if (view == OperableVideoShareView.this.mBo) {
                        OperableVideoShareView.this.Ha(2);
                    } else if (view == OperableVideoShareView.this.mBq) {
                        OperableVideoShareView.this.Ha(8);
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
        this.mBm = findViewById(R.id.share_weixin);
        this.mBn = (ImageView) findViewById(R.id.share_weixin_img);
        this.mBo = findViewById(R.id.share_weixin_timeline);
        this.mBp = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mBq = findViewById(R.id.share_qq);
        this.mBr = (ImageView) findViewById(R.id.share_qq_img);
        this.gde = findViewById(R.id.divider_line);
        this.mBs = findViewById(R.id.video_replay);
        this.mBt = (ImageView) findViewById(R.id.replay_img);
        this.mBm.setOnClickListener(this.mOnClickListener);
        this.mBo.setOnClickListener(this.mOnClickListener);
        this.mBq.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mBn.setImageDrawable(SvgManager.bsx().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mBp.setImageDrawable(SvgManager.bsx().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mBr.setImageDrawable(SvgManager.bsx().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mBt.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null, false));
        this.mBt.setBackgroundDrawable(ao.aO(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public void setVideoContainer(d dVar) {
        this.mBl = dVar;
        this.mBs.setOnClickListener(this.mBl);
    }

    public void setShareData(bz bzVar) {
        this.ahu = bzVar;
        if (this.ahu != null && !this.ahu.bmg()) {
            this.mBq.setVisibility(0);
            this.mBm.setVisibility(0);
            this.mBo.setVisibility(0);
            this.gde.setVisibility(0);
            return;
        }
        this.mBq.setVisibility(8);
        this.mBm.setVisibility(8);
        this.mBo.setVisibility(8);
        this.gde.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eRW = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha(int i) {
        if (this.ahu != null) {
            String valueOf = String.valueOf(this.ahu.getFid());
            String bnB = this.ahu.bnB();
            if (this.ahu.eRb != null) {
                valueOf = this.ahu.eRb.id;
                bnB = this.ahu.eRb.ori_fname;
            }
            String title = this.ahu.getTitle();
            String tid = this.ahu.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.ahu);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.ahu.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.ahu.bmg() && this.ahu.boS() && this.ahu.bnO() != null) {
                shareItem.readCount = this.ahu.bnO().play_count.intValue();
            }
            shareItem.fsD = str2;
            shareItem.linkUrl = str;
            shareItem.eRW = this.eRW;
            shareItem.extData = tid;
            shareItem.fsG = 3;
            shareItem.fsH = 1;
            if (i == 3) {
                shareItem.fsI = 1;
            } else if (i == 2) {
                shareItem.fsI = 2;
            } else if (i == 8) {
                shareItem.fsI = 3;
            } else {
                shareItem.fsI = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bnB;
            shareItem.tid = tid;
            shareItem.nid = this.ahu.blV();
            shareItem.fsu = true;
            shareItem.fsF = 3;
            shareItem.fsK = getStateThreadType(this.ahu);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahu);
            shareItem.fsO = ShareItem.ForwardInfo.generateForwardInfo(this.ahu);
            shareItem.fsJ = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fsU = this.ahu.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fsK);
            bundle.putInt("obj_param1", shareItem.fsG);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fsH);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fsI);
            bundle.putInt("obj_source", shareItem.eRW);
            bundle.putInt("obj_locate", shareItem.fsJ);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dW("tid", shareItem.tid);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("fid", shareItem.fid);
            aqVar.an("obj_locate", this.eRW);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fsI);
            aqVar.dW(IntentConfig.NID, shareItem.nid);
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bz bzVar) {
        if (bzVar == null || bzVar.bnG() == null) {
            return null;
        }
        ArrayList<MediaData> bnG = bzVar.bnG();
        int size = bnG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bnG.get(i);
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
            if (bzVar.bnz()) {
                return 4;
            }
            if (bzVar.bnu() == 1) {
                return 3;
            }
            return bzVar.boS() ? 2 : 1;
        }
        return 0;
    }

    public void au(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBo.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBm.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mBq.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.gde.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mBs.getLayoutParams();
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

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
import com.baidu.tbadk.core.data.bx;
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
    private bx agB;
    private int eFG;
    private View fPU;
    private View.OnClickListener mOnClickListener;
    private ImageView mmA;
    private View mmB;
    private ImageView mmC;
    private View mmD;
    private ImageView mmE;
    private View mmF;
    private ImageView mmG;
    private d mmy;
    private View mmz;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eFG = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mmz) {
                        OperableVideoShareView.this.HW(3);
                    } else if (view == OperableVideoShareView.this.mmB) {
                        OperableVideoShareView.this.HW(2);
                    } else if (view == OperableVideoShareView.this.mmD) {
                        OperableVideoShareView.this.HW(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFG = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mmz) {
                        OperableVideoShareView.this.HW(3);
                    } else if (view == OperableVideoShareView.this.mmB) {
                        OperableVideoShareView.this.HW(2);
                    } else if (view == OperableVideoShareView.this.mmD) {
                        OperableVideoShareView.this.HW(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFG = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mmz) {
                        OperableVideoShareView.this.HW(3);
                    } else if (view == OperableVideoShareView.this.mmB) {
                        OperableVideoShareView.this.HW(2);
                    } else if (view == OperableVideoShareView.this.mmD) {
                        OperableVideoShareView.this.HW(8);
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
        this.mmz = findViewById(R.id.share_weixin);
        this.mmA = (ImageView) findViewById(R.id.share_weixin_img);
        this.mmB = findViewById(R.id.share_weixin_timeline);
        this.mmC = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mmD = findViewById(R.id.share_qq);
        this.mmE = (ImageView) findViewById(R.id.share_qq_img);
        this.fPU = findViewById(R.id.divider_line);
        this.mmF = findViewById(R.id.video_replay);
        this.mmG = (ImageView) findViewById(R.id.replay_img);
        this.mmz.setOnClickListener(this.mOnClickListener);
        this.mmB.setOnClickListener(this.mOnClickListener);
        this.mmD.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mmA.setImageDrawable(SvgManager.bqB().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mmC.setImageDrawable(SvgManager.bqB().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mmE.setImageDrawable(SvgManager.bqB().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mmG.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null, false));
        this.mmG.setBackgroundDrawable(ap.aP(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public void setVideoContainer(d dVar) {
        this.mmy = dVar;
        this.mmF.setOnClickListener(this.mmy);
    }

    public void setShareData(bx bxVar) {
        this.agB = bxVar;
        if (this.agB != null && !this.agB.bkm()) {
            this.mmD.setVisibility(0);
            this.mmz.setVisibility(0);
            this.mmB.setVisibility(0);
            this.fPU.setVisibility(0);
            return;
        }
        this.mmD.setVisibility(8);
        this.mmz.setVisibility(8);
        this.mmB.setVisibility(8);
        this.fPU.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eFG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HW(int i) {
        if (this.agB != null) {
            String valueOf = String.valueOf(this.agB.getFid());
            String blG = this.agB.blG();
            if (this.agB.eEQ != null) {
                valueOf = this.agB.eEQ.id;
                blG = this.agB.eEQ.ori_fname;
            }
            String title = this.agB.getTitle();
            String tid = this.agB.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agB);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agB.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.agB.bkm() && this.agB.bmW() && this.agB.blU() != null) {
                shareItem.readCount = this.agB.blU().play_count.intValue();
            }
            shareItem.fgc = str2;
            shareItem.linkUrl = str;
            shareItem.eFG = this.eFG;
            shareItem.extData = tid;
            shareItem.fgf = 3;
            shareItem.fgg = 1;
            if (i == 3) {
                shareItem.fgh = 1;
            } else if (i == 2) {
                shareItem.fgh = 2;
            } else if (i == 8) {
                shareItem.fgh = 3;
            } else {
                shareItem.fgh = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = blG;
            shareItem.tid = tid;
            shareItem.nid = this.agB.getNid();
            shareItem.ffT = true;
            shareItem.fge = 3;
            shareItem.fgj = getStateThreadType(this.agB);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agB);
            shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(this.agB);
            shareItem.fgi = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fgt = this.agB.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fgj);
            bundle.putInt("obj_param1", shareItem.fgf);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgg);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fgh);
            bundle.putInt("obj_source", shareItem.eFG);
            bundle.putInt("obj_locate", shareItem.fgi);
            shareItem.ae(bundle);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dR("tid", shareItem.tid);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("fid", shareItem.fid);
            arVar.ak("obj_locate", this.eFG);
            arVar.ak(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fgh);
            arVar.dR("nid", shareItem.nid);
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bx bxVar) {
        if (bxVar == null || bxVar.blL() == null) {
            return null;
        }
        ArrayList<MediaData> blL = bxVar.blL();
        int size = blL.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = blL.get(i);
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

    private int getStateThreadType(bx bxVar) {
        if (bxVar != null) {
            if (bxVar.blE()) {
                return 4;
            }
            if (bxVar.blz() == 1) {
                return 3;
            }
            return bxVar.bmW() ? 2 : 1;
        }
        return 0;
    }

    public void as(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mmB.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mmz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mmD.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fPU.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mmF.getLayoutParams();
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

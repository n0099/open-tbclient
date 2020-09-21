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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bw agf;
    private int egT;
    private View fpN;
    private View lEA;
    private ImageView lEB;
    private d lEt;
    private View lEu;
    private ImageView lEv;
    private View lEw;
    private ImageView lEx;
    private View lEy;
    private ImageView lEz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.egT = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lEu) {
                        OperableVideoShareView.this.Gm(3);
                    } else if (view == OperableVideoShareView.this.lEw) {
                        OperableVideoShareView.this.Gm(2);
                    } else if (view == OperableVideoShareView.this.lEy) {
                        OperableVideoShareView.this.Gm(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egT = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lEu) {
                        OperableVideoShareView.this.Gm(3);
                    } else if (view == OperableVideoShareView.this.lEw) {
                        OperableVideoShareView.this.Gm(2);
                    } else if (view == OperableVideoShareView.this.lEy) {
                        OperableVideoShareView.this.Gm(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egT = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lEu) {
                        OperableVideoShareView.this.Gm(3);
                    } else if (view == OperableVideoShareView.this.lEw) {
                        OperableVideoShareView.this.Gm(2);
                    } else if (view == OperableVideoShareView.this.lEy) {
                        OperableVideoShareView.this.Gm(8);
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
        this.lEu = findViewById(R.id.share_weixin);
        this.lEv = (ImageView) findViewById(R.id.share_weixin_img);
        this.lEw = findViewById(R.id.share_weixin_timeline);
        this.lEx = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.lEy = findViewById(R.id.share_qq);
        this.lEz = (ImageView) findViewById(R.id.share_qq_img);
        this.fpN = findViewById(R.id.divider_line);
        this.lEA = findViewById(R.id.video_replay);
        this.lEB = (ImageView) findViewById(R.id.replay_img);
        this.lEu.setOnClickListener(this.mOnClickListener);
        this.lEw.setOnClickListener(this.mOnClickListener);
        this.lEy.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.lEv.setImageDrawable(SvgManager.bkl().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.lEx.setImageDrawable(SvgManager.bkl().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.lEz.setImageDrawable(SvgManager.bkl().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.lEB.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.lEB.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.lEt = dVar;
        this.lEA.setOnClickListener(this.lEt);
    }

    public void setShareData(bw bwVar) {
        this.agf = bwVar;
        if (this.agf != null && !this.agf.bei()) {
            this.lEy.setVisibility(0);
            this.lEu.setVisibility(0);
            this.lEw.setVisibility(0);
            this.fpN.setVisibility(0);
            return;
        }
        this.lEy.setVisibility(8);
        this.lEu.setVisibility(8);
        this.lEw.setVisibility(8);
        this.fpN.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.egT = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gm(int i) {
        if (this.agf != null) {
            String valueOf = String.valueOf(this.agf.getFid());
            String bfC = this.agf.bfC();
            if (this.agf.egd != null) {
                valueOf = this.agf.egd.id;
                bfC = this.agf.egd.ori_fname;
            }
            String title = this.agf.getTitle();
            String tid = this.agf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agf);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agf.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.agf.bei() && this.agf.bgQ() && this.agf.bfQ() != null) {
                shareItem.readCount = this.agf.bfQ().play_count.intValue();
            }
            shareItem.eGA = str2;
            shareItem.linkUrl = str;
            shareItem.egT = this.egT;
            shareItem.extData = tid;
            shareItem.eGD = 3;
            shareItem.eGE = 1;
            if (i == 3) {
                shareItem.eGF = 1;
            } else if (i == 2) {
                shareItem.eGF = 2;
            } else if (i == 8) {
                shareItem.eGF = 3;
            } else {
                shareItem.eGF = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bfC;
            shareItem.tid = tid;
            shareItem.nid = this.agf.getNid();
            shareItem.eGr = true;
            shareItem.eGC = 3;
            shareItem.eGH = getStateThreadType(this.agf);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eGK = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agf);
            shareItem.eGL = ShareItem.ForwardInfo.generateForwardInfo(this.agf);
            shareItem.eGG = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eGR = this.agf.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.eGH);
            bundle.putInt("obj_param1", shareItem.eGD);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eGE);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eGF);
            bundle.putInt("obj_source", shareItem.egT);
            bundle.putInt("obj_locate", shareItem.eGG);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dF("tid", shareItem.tid);
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dF("fid", shareItem.fid);
            aqVar.ai("obj_locate", this.egT);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eGF);
            aqVar.dF("nid", shareItem.nid);
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.bfH() == null) {
            return null;
        }
        ArrayList<MediaData> bfH = bwVar.bfH();
        int size = bfH.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bfH.get(i);
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
            if (bwVar.bfA()) {
                return 4;
            }
            if (bwVar.bfv() == 1) {
                return 3;
            }
            return bwVar.bgQ() ? 2 : 1;
        }
        return 0;
    }

    public void at(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lEw.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lEu.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lEy.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fpN.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.lEA.getLayoutParams();
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

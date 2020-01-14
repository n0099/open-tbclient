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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bj Kn;
    private int cQy;
    private View caf;
    private d jxK;
    private View jxL;
    private ImageView jxM;
    private View jxN;
    private ImageView jxO;
    private View jxP;
    private ImageView jxQ;
    private View jxR;
    private ImageView jxS;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.cQy = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jxL) {
                        OperableVideoShareView.this.Al(3);
                    } else if (view == OperableVideoShareView.this.jxN) {
                        OperableVideoShareView.this.Al(2);
                    } else if (view == OperableVideoShareView.this.jxP) {
                        OperableVideoShareView.this.Al(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cQy = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jxL) {
                        OperableVideoShareView.this.Al(3);
                    } else if (view == OperableVideoShareView.this.jxN) {
                        OperableVideoShareView.this.Al(2);
                    } else if (view == OperableVideoShareView.this.jxP) {
                        OperableVideoShareView.this.Al(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cQy = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jxL) {
                        OperableVideoShareView.this.Al(3);
                    } else if (view == OperableVideoShareView.this.jxN) {
                        OperableVideoShareView.this.Al(2);
                    } else if (view == OperableVideoShareView.this.jxP) {
                        OperableVideoShareView.this.Al(8);
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
        this.jxL = findViewById(R.id.share_weixin);
        this.jxM = (ImageView) findViewById(R.id.share_weixin_img);
        this.jxN = findViewById(R.id.share_weixin_timeline);
        this.jxO = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.jxP = findViewById(R.id.share_qq);
        this.jxQ = (ImageView) findViewById(R.id.share_qq_img);
        this.caf = findViewById(R.id.divider_line);
        this.jxR = findViewById(R.id.video_replay);
        this.jxS = (ImageView) findViewById(R.id.replay_img);
        this.jxL.setOnClickListener(this.mOnClickListener);
        this.jxN.setOnClickListener(this.mOnClickListener);
        this.jxP.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.jxM.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.jxO.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.jxQ.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.jxS.setImageDrawable(SvgManager.aEp().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.jxS.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.jxK = dVar;
        this.jxR.setOnClickListener(this.jxK);
    }

    public void setShareData(bj bjVar) {
        this.Kn = bjVar;
        if (this.Kn != null && !this.Kn.aBV()) {
            this.jxP.setVisibility(0);
            this.jxL.setVisibility(0);
            this.jxN.setVisibility(0);
            this.caf.setVisibility(0);
            return;
        }
        this.jxP.setVisibility(8);
        this.jxL.setVisibility(8);
        this.jxN.setVisibility(8);
        this.caf.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.cQy = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Al(int i) {
        if (this.Kn != null) {
            String valueOf = String.valueOf(this.Kn.getFid());
            String aAc = this.Kn.aAc();
            if (this.Kn.cPX != null) {
                valueOf = this.Kn.cPX.id;
                aAc = this.Kn.cPX.ori_fname;
            }
            String title = this.Kn.getTitle();
            String tid = this.Kn.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String x = x(this.Kn);
            Uri parse = x == null ? null : Uri.parse(x);
            String str2 = this.Kn.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.dlS = str2;
            shareItem.linkUrl = str;
            shareItem.cQy = this.cQy;
            shareItem.extData = tid;
            shareItem.dlV = 3;
            shareItem.dlW = 1;
            if (i == 3) {
                shareItem.dlX = 1;
            } else if (i == 2) {
                shareItem.dlX = 2;
            } else if (i == 8) {
                shareItem.dlX = 3;
            } else {
                shareItem.dlX = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aAc;
            shareItem.tid = tid;
            shareItem.dlL = true;
            shareItem.dlU = 3;
            shareItem.dlZ = y(this.Kn);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Kn);
            shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(this.Kn);
            shareItem.dlY = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dmj = this.Kn.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.dlZ);
            bundle.putInt("obj_param1", shareItem.dlV);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dlW);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dlX);
            bundle.putInt("obj_source", shareItem.cQy);
            bundle.putInt("obj_locate", shareItem.dlY);
            shareItem.Y(bundle);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cp("tid", shareItem.tid);
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("fid", shareItem.fid);
            anVar.Z("obj_locate", this.cQy);
            anVar.Z(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dlX);
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String x(bj bjVar) {
        if (bjVar == null || bjVar.aAh() == null) {
            return null;
        }
        ArrayList<MediaData> aAh = bjVar.aAh();
        int size = aAh.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aAh.get(i);
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

    private int y(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.azZ()) {
                return 4;
            }
            if (bjVar.azU() == 1) {
                return 3;
            }
            return bjVar.aBm() ? 2 : 1;
        }
        return 0;
    }

    public void af(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jxN.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jxL.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jxP.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.caf.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.jxR.getLayoutParams();
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

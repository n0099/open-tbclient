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
    private bw agw;
    private int esZ;
    private View fCa;
    private d lTH;
    private View lTI;
    private ImageView lTJ;
    private View lTK;
    private ImageView lTL;
    private View lTM;
    private ImageView lTN;
    private View lTO;
    private ImageView lTP;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.esZ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lTI) {
                        OperableVideoShareView.this.GS(3);
                    } else if (view == OperableVideoShareView.this.lTK) {
                        OperableVideoShareView.this.GS(2);
                    } else if (view == OperableVideoShareView.this.lTM) {
                        OperableVideoShareView.this.GS(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esZ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lTI) {
                        OperableVideoShareView.this.GS(3);
                    } else if (view == OperableVideoShareView.this.lTK) {
                        OperableVideoShareView.this.GS(2);
                    } else if (view == OperableVideoShareView.this.lTM) {
                        OperableVideoShareView.this.GS(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.esZ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.lTI) {
                        OperableVideoShareView.this.GS(3);
                    } else if (view == OperableVideoShareView.this.lTK) {
                        OperableVideoShareView.this.GS(2);
                    } else if (view == OperableVideoShareView.this.lTM) {
                        OperableVideoShareView.this.GS(8);
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
        this.lTI = findViewById(R.id.share_weixin);
        this.lTJ = (ImageView) findViewById(R.id.share_weixin_img);
        this.lTK = findViewById(R.id.share_weixin_timeline);
        this.lTL = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.lTM = findViewById(R.id.share_qq);
        this.lTN = (ImageView) findViewById(R.id.share_qq_img);
        this.fCa = findViewById(R.id.divider_line);
        this.lTO = findViewById(R.id.video_replay);
        this.lTP = (ImageView) findViewById(R.id.replay_img);
        this.lTI.setOnClickListener(this.mOnClickListener);
        this.lTK.setOnClickListener(this.mOnClickListener);
        this.lTM.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.lTJ.setImageDrawable(SvgManager.bmU().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.lTL.setImageDrawable(SvgManager.bmU().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.lTN.setImageDrawable(SvgManager.bmU().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.lTP.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.lTP.setBackgroundDrawable(ap.aN(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.lTH = dVar;
        this.lTO.setOnClickListener(this.lTH);
    }

    public void setShareData(bw bwVar) {
        this.agw = bwVar;
        if (this.agw != null && !this.agw.bgR()) {
            this.lTM.setVisibility(0);
            this.lTI.setVisibility(0);
            this.lTK.setVisibility(0);
            this.fCa.setVisibility(0);
            return;
        }
        this.lTM.setVisibility(8);
        this.lTI.setVisibility(8);
        this.lTK.setVisibility(8);
        this.fCa.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.esZ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS(int i) {
        if (this.agw != null) {
            String valueOf = String.valueOf(this.agw.getFid());
            String bil = this.agw.bil();
            if (this.agw.esj != null) {
                valueOf = this.agw.esj.id;
                bil = this.agw.esj.ori_fname;
            }
            String title = this.agw.getTitle();
            String tid = this.agw.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agw);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agw.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.agw.bgR() && this.agw.bjz() && this.agw.biz() != null) {
                shareItem.readCount = this.agw.biz().play_count.intValue();
            }
            shareItem.eSH = str2;
            shareItem.linkUrl = str;
            shareItem.esZ = this.esZ;
            shareItem.extData = tid;
            shareItem.eSK = 3;
            shareItem.eSL = 1;
            if (i == 3) {
                shareItem.eSM = 1;
            } else if (i == 2) {
                shareItem.eSM = 2;
            } else if (i == 8) {
                shareItem.eSM = 3;
            } else {
                shareItem.eSM = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bil;
            shareItem.tid = tid;
            shareItem.nid = this.agw.getNid();
            shareItem.eSy = true;
            shareItem.eSJ = 3;
            shareItem.eSO = getStateThreadType(this.agw);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agw);
            shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(this.agw);
            shareItem.eSN = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eSY = this.agw.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.eSO);
            bundle.putInt("obj_param1", shareItem.eSK);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eSL);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eSM);
            bundle.putInt("obj_source", shareItem.esZ);
            bundle.putInt("obj_locate", shareItem.eSN);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dK("tid", shareItem.tid);
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dK("fid", shareItem.fid);
            aqVar.aj("obj_locate", this.esZ);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eSM);
            aqVar.dK("nid", shareItem.nid);
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.biq() == null) {
            return null;
        }
        ArrayList<MediaData> biq = bwVar.biq();
        int size = biq.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = biq.get(i);
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
            if (bwVar.bij()) {
                return 4;
            }
            if (bwVar.bie() == 1) {
                return 3;
            }
            return bwVar.bjz() ? 2 : 1;
        }
        return 0;
    }

    public void as(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lTK.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lTI.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lTM.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fCa.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.lTO.getLayoutParams();
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

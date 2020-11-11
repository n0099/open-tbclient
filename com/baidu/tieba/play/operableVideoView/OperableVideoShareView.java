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
    private bw agx;
    private int eHo;
    private View fQl;
    private View.OnClickListener mOnClickListener;
    private d mme;
    private View mmf;
    private ImageView mmg;
    private View mmh;
    private ImageView mmi;
    private View mmj;
    private ImageView mmk;
    private View mml;
    private ImageView mmm;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eHo = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mmf) {
                        OperableVideoShareView.this.Hy(3);
                    } else if (view == OperableVideoShareView.this.mmh) {
                        OperableVideoShareView.this.Hy(2);
                    } else if (view == OperableVideoShareView.this.mmj) {
                        OperableVideoShareView.this.Hy(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHo = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mmf) {
                        OperableVideoShareView.this.Hy(3);
                    } else if (view == OperableVideoShareView.this.mmh) {
                        OperableVideoShareView.this.Hy(2);
                    } else if (view == OperableVideoShareView.this.mmj) {
                        OperableVideoShareView.this.Hy(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHo = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mmf) {
                        OperableVideoShareView.this.Hy(3);
                    } else if (view == OperableVideoShareView.this.mmh) {
                        OperableVideoShareView.this.Hy(2);
                    } else if (view == OperableVideoShareView.this.mmj) {
                        OperableVideoShareView.this.Hy(8);
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
        this.mmf = findViewById(R.id.share_weixin);
        this.mmg = (ImageView) findViewById(R.id.share_weixin_img);
        this.mmh = findViewById(R.id.share_weixin_timeline);
        this.mmi = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mmj = findViewById(R.id.share_qq);
        this.mmk = (ImageView) findViewById(R.id.share_qq_img);
        this.fQl = findViewById(R.id.divider_line);
        this.mml = findViewById(R.id.video_replay);
        this.mmm = (ImageView) findViewById(R.id.replay_img);
        this.mmf.setOnClickListener(this.mOnClickListener);
        this.mmh.setOnClickListener(this.mOnClickListener);
        this.mmj.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mmg.setImageDrawable(SvgManager.brn().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mmi.setImageDrawable(SvgManager.brn().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mmk.setImageDrawable(SvgManager.brn().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mmm.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.mmm.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.mme = dVar;
        this.mml.setOnClickListener(this.mme);
    }

    public void setShareData(bw bwVar) {
        this.agx = bwVar;
        if (this.agx != null && !this.agx.blk()) {
            this.mmj.setVisibility(0);
            this.mmf.setVisibility(0);
            this.mmh.setVisibility(0);
            this.fQl.setVisibility(0);
            return;
        }
        this.mmj.setVisibility(8);
        this.mmf.setVisibility(8);
        this.mmh.setVisibility(8);
        this.fQl.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eHo = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(int i) {
        if (this.agx != null) {
            String valueOf = String.valueOf(this.agx.getFid());
            String bmE = this.agx.bmE();
            if (this.agx.eGy != null) {
                valueOf = this.agx.eGy.id;
                bmE = this.agx.eGy.ori_fname;
            }
            String title = this.agx.getTitle();
            String tid = this.agx.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agx);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agx.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.agx.blk() && this.agx.bnS() && this.agx.bmS() != null) {
                shareItem.readCount = this.agx.bmS().play_count.intValue();
            }
            shareItem.fgU = str2;
            shareItem.linkUrl = str;
            shareItem.eHo = this.eHo;
            shareItem.extData = tid;
            shareItem.fgX = 3;
            shareItem.fgY = 1;
            if (i == 3) {
                shareItem.fgZ = 1;
            } else if (i == 2) {
                shareItem.fgZ = 2;
            } else if (i == 8) {
                shareItem.fgZ = 3;
            } else {
                shareItem.fgZ = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bmE;
            shareItem.tid = tid;
            shareItem.nid = this.agx.getNid();
            shareItem.fgL = true;
            shareItem.fgW = 3;
            shareItem.fhb = getStateThreadType(this.agx);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agx);
            shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(this.agx);
            shareItem.fha = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fhl = this.agx.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fhb);
            bundle.putInt("obj_param1", shareItem.fgX);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgY);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fgZ);
            bundle.putInt("obj_source", shareItem.eHo);
            bundle.putInt("obj_locate", shareItem.fha);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dR("tid", shareItem.tid);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("fid", shareItem.fid);
            aqVar.al("obj_locate", this.eHo);
            aqVar.al(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fgZ);
            aqVar.dR("nid", shareItem.nid);
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.bmJ() == null) {
            return null;
        }
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        int size = bmJ.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bmJ.get(i);
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
            if (bwVar.bmC()) {
                return 4;
            }
            if (bwVar.bmx() == 1) {
                return 3;
            }
            return bwVar.bnS() ? 2 : 1;
        }
        return 0;
    }

    public void av(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mmh.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mmf.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mmj.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fQl.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mml.getLayoutParams();
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

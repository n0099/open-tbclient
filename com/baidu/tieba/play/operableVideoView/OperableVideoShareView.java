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
import com.baidu.tbadk.core.data.bk;
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
    private bk aee;
    private int dHZ;
    private View eLg;
    private d kCr;
    private View kCs;
    private ImageView kCt;
    private View kCu;
    private ImageView kCv;
    private View kCw;
    private ImageView kCx;
    private View kCy;
    private ImageView kCz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.dHZ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kCs) {
                        OperableVideoShareView.this.BN(3);
                    } else if (view == OperableVideoShareView.this.kCu) {
                        OperableVideoShareView.this.BN(2);
                    } else if (view == OperableVideoShareView.this.kCw) {
                        OperableVideoShareView.this.BN(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHZ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kCs) {
                        OperableVideoShareView.this.BN(3);
                    } else if (view == OperableVideoShareView.this.kCu) {
                        OperableVideoShareView.this.BN(2);
                    } else if (view == OperableVideoShareView.this.kCw) {
                        OperableVideoShareView.this.BN(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dHZ = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kCs) {
                        OperableVideoShareView.this.BN(3);
                    } else if (view == OperableVideoShareView.this.kCu) {
                        OperableVideoShareView.this.BN(2);
                    } else if (view == OperableVideoShareView.this.kCw) {
                        OperableVideoShareView.this.BN(8);
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
        this.kCs = findViewById(R.id.share_weixin);
        this.kCt = (ImageView) findViewById(R.id.share_weixin_img);
        this.kCu = findViewById(R.id.share_weixin_timeline);
        this.kCv = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.kCw = findViewById(R.id.share_qq);
        this.kCx = (ImageView) findViewById(R.id.share_qq_img);
        this.eLg = findViewById(R.id.divider_line);
        this.kCy = findViewById(R.id.video_replay);
        this.kCz = (ImageView) findViewById(R.id.replay_img);
        this.kCs.setOnClickListener(this.mOnClickListener);
        this.kCu.setOnClickListener(this.mOnClickListener);
        this.kCw.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.kCt.setImageDrawable(SvgManager.aUV().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.kCv.setImageDrawable(SvgManager.aUV().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.kCx.setImageDrawable(SvgManager.aUV().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.kCz.setImageDrawable(SvgManager.aUV().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.kCz.setBackgroundDrawable(am.aE(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.kCr = dVar;
        this.kCy.setOnClickListener(this.kCr);
    }

    public void setShareData(bk bkVar) {
        this.aee = bkVar;
        if (this.aee != null && !this.aee.aSx()) {
            this.kCw.setVisibility(0);
            this.kCs.setVisibility(0);
            this.kCu.setVisibility(0);
            this.eLg.setVisibility(0);
            return;
        }
        this.kCw.setVisibility(8);
        this.kCs.setVisibility(8);
        this.kCu.setVisibility(8);
        this.eLg.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.dHZ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(int i) {
        if (this.aee != null) {
            String valueOf = String.valueOf(this.aee.getFid());
            String aQC = this.aee.aQC();
            if (this.aee.dHw != null) {
                valueOf = this.aee.dHw.id;
                aQC = this.aee.dHw.ori_fname;
            }
            String title = this.aee.getTitle();
            String tid = this.aee.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String A = A(this.aee);
            Uri parse = A == null ? null : Uri.parse(A);
            String str2 = this.aee.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.aee.aSx() && this.aee.aRQ() && this.aee.aQQ() != null) {
                shareItem.readCount = this.aee.aQQ().play_count.intValue();
            }
            shareItem.eeT = str2;
            shareItem.linkUrl = str;
            shareItem.dHZ = this.dHZ;
            shareItem.extData = tid;
            shareItem.eeW = 3;
            shareItem.eeX = 1;
            if (i == 3) {
                shareItem.eeY = 1;
            } else if (i == 2) {
                shareItem.eeY = 2;
            } else if (i == 8) {
                shareItem.eeY = 3;
            } else {
                shareItem.eeY = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aQC;
            shareItem.tid = tid;
            shareItem.nid = this.aee.getNid();
            shareItem.eeM = true;
            shareItem.eeV = 3;
            shareItem.efa = B(this.aee);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aee);
            shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(this.aee);
            shareItem.eeZ = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.efk = this.aee.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.efa);
            bundle.putInt("obj_param1", shareItem.eeW);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eeX);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eeY);
            bundle.putInt("obj_source", shareItem.dHZ);
            bundle.putInt("obj_locate", shareItem.eeZ);
            shareItem.ae(bundle);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.dh("tid", shareItem.tid);
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("fid", shareItem.fid);
            anVar.ag("obj_locate", this.dHZ);
            anVar.ag(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eeY);
            anVar.dh("nid", shareItem.nid);
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String A(bk bkVar) {
        if (bkVar == null || bkVar.aQH() == null) {
            return null;
        }
        ArrayList<MediaData> aQH = bkVar.aQH();
        int size = aQH.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aQH.get(i);
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

    private int B(bk bkVar) {
        if (bkVar != null) {
            if (bkVar.aQz()) {
                return 4;
            }
            if (bkVar.aQu() == 1) {
                return 3;
            }
            return bkVar.aRQ() ? 2 : 1;
        }
        return 0;
    }

    public void al(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kCu.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kCs.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kCw.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.eLg.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.kCy.getLayoutParams();
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

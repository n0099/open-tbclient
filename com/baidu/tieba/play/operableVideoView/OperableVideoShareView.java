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
    private bj KJ;
    private int cUC;
    private View cen;
    private d jyO;
    private View jyP;
    private ImageView jyQ;
    private View jyR;
    private ImageView jyS;
    private View jyT;
    private ImageView jyU;
    private View jyV;
    private ImageView jyW;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.cUC = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jyP) {
                        OperableVideoShareView.this.Av(3);
                    } else if (view == OperableVideoShareView.this.jyR) {
                        OperableVideoShareView.this.Av(2);
                    } else if (view == OperableVideoShareView.this.jyT) {
                        OperableVideoShareView.this.Av(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUC = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jyP) {
                        OperableVideoShareView.this.Av(3);
                    } else if (view == OperableVideoShareView.this.jyR) {
                        OperableVideoShareView.this.Av(2);
                    } else if (view == OperableVideoShareView.this.jyT) {
                        OperableVideoShareView.this.Av(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cUC = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jyP) {
                        OperableVideoShareView.this.Av(3);
                    } else if (view == OperableVideoShareView.this.jyR) {
                        OperableVideoShareView.this.Av(2);
                    } else if (view == OperableVideoShareView.this.jyT) {
                        OperableVideoShareView.this.Av(8);
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
        this.jyP = findViewById(R.id.share_weixin);
        this.jyQ = (ImageView) findViewById(R.id.share_weixin_img);
        this.jyR = findViewById(R.id.share_weixin_timeline);
        this.jyS = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.jyT = findViewById(R.id.share_qq);
        this.jyU = (ImageView) findViewById(R.id.share_qq_img);
        this.cen = findViewById(R.id.divider_line);
        this.jyV = findViewById(R.id.video_replay);
        this.jyW = (ImageView) findViewById(R.id.replay_img);
        this.jyP.setOnClickListener(this.mOnClickListener);
        this.jyR.setOnClickListener(this.mOnClickListener);
        this.jyT.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.jyQ.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.jyS.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.jyU.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.jyW.setImageDrawable(SvgManager.aGC().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.jyW.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.jyO = dVar;
        this.jyV.setOnClickListener(this.jyO);
    }

    public void setShareData(bj bjVar) {
        this.KJ = bjVar;
        if (this.KJ != null && !this.KJ.aEi()) {
            this.jyT.setVisibility(0);
            this.jyP.setVisibility(0);
            this.jyR.setVisibility(0);
            this.cen.setVisibility(0);
            return;
        }
        this.jyT.setVisibility(8);
        this.jyP.setVisibility(8);
        this.jyR.setVisibility(8);
        this.cen.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.cUC = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Av(int i) {
        if (this.KJ != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCt = this.KJ.aCt();
            if (this.KJ.cUb != null) {
                valueOf = this.KJ.cUb.id;
                aCt = this.KJ.cUb.ori_fname;
            }
            String title = this.KJ.getTitle();
            String tid = this.KJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String y = y(this.KJ);
            Uri parse = y == null ? null : Uri.parse(y);
            String str2 = this.KJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.KJ.aEi() && this.KJ.aDB() && this.KJ.aCF() != null) {
                shareItem.readCount = this.KJ.aCF().play_count.intValue();
            }
            shareItem.dqp = str2;
            shareItem.linkUrl = str;
            shareItem.cUC = this.cUC;
            shareItem.extData = tid;
            shareItem.dqs = 3;
            shareItem.dqt = 1;
            if (i == 3) {
                shareItem.dqu = 1;
            } else if (i == 2) {
                shareItem.dqu = 2;
            } else if (i == 8) {
                shareItem.dqu = 3;
            } else {
                shareItem.dqu = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aCt;
            shareItem.tid = tid;
            shareItem.dqh = true;
            shareItem.dqr = 3;
            shareItem.dqw = z(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dqz = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            shareItem.dqA = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            shareItem.dqv = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dqG = this.KJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.dqw);
            bundle.putInt("obj_param1", shareItem.dqs);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dqt);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dqu);
            bundle.putInt("obj_source", shareItem.cUC);
            bundle.putInt("obj_locate", shareItem.dqv);
            shareItem.Y(bundle);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cy("tid", shareItem.tid);
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("fid", shareItem.fid);
            anVar.X("obj_locate", this.cUC);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dqu);
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String y(bj bjVar) {
        if (bjVar == null || bjVar.aCy() == null) {
            return null;
        }
        ArrayList<MediaData> aCy = bjVar.aCy();
        int size = aCy.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aCy.get(i);
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

    private int z(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCq()) {
                return 4;
            }
            if (bjVar.aCl() == 1) {
                return 3;
            }
            return bjVar.aDB() ? 2 : 1;
        }
        return 0;
    }

    public void ah(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jyR.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jyP.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jyT.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.cen.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.jyV.getLayoutParams();
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

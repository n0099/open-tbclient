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
    private int cUP;
    private View cey;
    private d jAn;
    private View jAo;
    private ImageView jAp;
    private View jAq;
    private ImageView jAr;
    private View jAs;
    private ImageView jAt;
    private View jAu;
    private ImageView jAv;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.cUP = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jAo) {
                        OperableVideoShareView.this.AD(3);
                    } else if (view == OperableVideoShareView.this.jAq) {
                        OperableVideoShareView.this.AD(2);
                    } else if (view == OperableVideoShareView.this.jAs) {
                        OperableVideoShareView.this.AD(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUP = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jAo) {
                        OperableVideoShareView.this.AD(3);
                    } else if (view == OperableVideoShareView.this.jAq) {
                        OperableVideoShareView.this.AD(2);
                    } else if (view == OperableVideoShareView.this.jAs) {
                        OperableVideoShareView.this.AD(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cUP = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jAo) {
                        OperableVideoShareView.this.AD(3);
                    } else if (view == OperableVideoShareView.this.jAq) {
                        OperableVideoShareView.this.AD(2);
                    } else if (view == OperableVideoShareView.this.jAs) {
                        OperableVideoShareView.this.AD(8);
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
        this.jAo = findViewById(R.id.share_weixin);
        this.jAp = (ImageView) findViewById(R.id.share_weixin_img);
        this.jAq = findViewById(R.id.share_weixin_timeline);
        this.jAr = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.jAs = findViewById(R.id.share_qq);
        this.jAt = (ImageView) findViewById(R.id.share_qq_img);
        this.cey = findViewById(R.id.divider_line);
        this.jAu = findViewById(R.id.video_replay);
        this.jAv = (ImageView) findViewById(R.id.replay_img);
        this.jAo.setOnClickListener(this.mOnClickListener);
        this.jAq.setOnClickListener(this.mOnClickListener);
        this.jAs.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.jAp.setImageDrawable(SvgManager.aGG().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.jAr.setImageDrawable(SvgManager.aGG().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.jAt.setImageDrawable(SvgManager.aGG().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.jAv.setImageDrawable(SvgManager.aGG().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.jAv.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.jAn = dVar;
        this.jAu.setOnClickListener(this.jAn);
    }

    public void setShareData(bj bjVar) {
        this.KJ = bjVar;
        if (this.KJ != null && !this.KJ.aEm()) {
            this.jAs.setVisibility(0);
            this.jAo.setVisibility(0);
            this.jAq.setVisibility(0);
            this.cey.setVisibility(0);
            return;
        }
        this.jAs.setVisibility(8);
        this.jAo.setVisibility(8);
        this.jAq.setVisibility(8);
        this.cey.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.cUP = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD(int i) {
        if (this.KJ != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCw = this.KJ.aCw();
            if (this.KJ.cUo != null) {
                valueOf = this.KJ.cUo.id;
                aCw = this.KJ.cUo.ori_fname;
            }
            String title = this.KJ.getTitle();
            String tid = this.KJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String z = z(this.KJ);
            Uri parse = z == null ? null : Uri.parse(z);
            String str2 = this.KJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.KJ.aEm() && this.KJ.aDF() && this.KJ.aCI() != null) {
                shareItem.readCount = this.KJ.aCI().play_count.intValue();
            }
            shareItem.dqC = str2;
            shareItem.linkUrl = str;
            shareItem.cUP = this.cUP;
            shareItem.extData = tid;
            shareItem.dqF = 3;
            shareItem.dqG = 1;
            if (i == 3) {
                shareItem.dqH = 1;
            } else if (i == 2) {
                shareItem.dqH = 2;
            } else if (i == 8) {
                shareItem.dqH = 3;
            } else {
                shareItem.dqH = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aCw;
            shareItem.tid = tid;
            shareItem.dqu = true;
            shareItem.dqE = 3;
            shareItem.dqJ = A(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            shareItem.dqI = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dqT = this.KJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.dqJ);
            bundle.putInt("obj_param1", shareItem.dqF);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dqG);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dqH);
            bundle.putInt("obj_source", shareItem.cUP);
            bundle.putInt("obj_locate", shareItem.dqI);
            shareItem.Y(bundle);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cx("tid", shareItem.tid);
            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cx("fid", shareItem.fid);
            anVar.X("obj_locate", this.cUP);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dqH);
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String z(bj bjVar) {
        if (bjVar == null || bjVar.aCB() == null) {
            return null;
        }
        ArrayList<MediaData> aCB = bjVar.aCB();
        int size = aCB.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aCB.get(i);
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

    private int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCt()) {
                return 4;
            }
            if (bjVar.aCo() == 1) {
                return 3;
            }
            return bjVar.aDF() ? 2 : 1;
        }
        return 0;
    }

    public void ah(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jAq.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jAo.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jAs.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.cey.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.jAu.getLayoutParams();
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

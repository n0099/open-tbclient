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
    private bj adJ;
    private View cDC;
    private int due;
    private ImageView kkA;
    private View kkB;
    private ImageView kkC;
    private View kkD;
    private ImageView kkE;
    private d kkw;
    private View kkx;
    private ImageView kky;
    private View kkz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.due = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kkx) {
                        OperableVideoShareView.this.Bd(3);
                    } else if (view == OperableVideoShareView.this.kkz) {
                        OperableVideoShareView.this.Bd(2);
                    } else if (view == OperableVideoShareView.this.kkB) {
                        OperableVideoShareView.this.Bd(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.due = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kkx) {
                        OperableVideoShareView.this.Bd(3);
                    } else if (view == OperableVideoShareView.this.kkz) {
                        OperableVideoShareView.this.Bd(2);
                    } else if (view == OperableVideoShareView.this.kkB) {
                        OperableVideoShareView.this.Bd(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.due = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kkx) {
                        OperableVideoShareView.this.Bd(3);
                    } else if (view == OperableVideoShareView.this.kkz) {
                        OperableVideoShareView.this.Bd(2);
                    } else if (view == OperableVideoShareView.this.kkB) {
                        OperableVideoShareView.this.Bd(8);
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
        this.kkx = findViewById(R.id.share_weixin);
        this.kky = (ImageView) findViewById(R.id.share_weixin_img);
        this.kkz = findViewById(R.id.share_weixin_timeline);
        this.kkA = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.kkB = findViewById(R.id.share_qq);
        this.kkC = (ImageView) findViewById(R.id.share_qq_img);
        this.cDC = findViewById(R.id.divider_line);
        this.kkD = findViewById(R.id.video_replay);
        this.kkE = (ImageView) findViewById(R.id.replay_img);
        this.kkx.setOnClickListener(this.mOnClickListener);
        this.kkz.setOnClickListener(this.mOnClickListener);
        this.kkB.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.kky.setImageDrawable(SvgManager.aOR().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.kkA.setImageDrawable(SvgManager.aOR().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.kkC.setImageDrawable(SvgManager.aOR().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.kkE.setImageDrawable(SvgManager.aOR().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.kkE.setBackgroundDrawable(am.aB(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.kkw = dVar;
        this.kkD.setOnClickListener(this.kkw);
    }

    public void setShareData(bj bjVar) {
        this.adJ = bjVar;
        if (this.adJ != null && !this.adJ.aMy()) {
            this.kkB.setVisibility(0);
            this.kkx.setVisibility(0);
            this.kkz.setVisibility(0);
            this.cDC.setVisibility(0);
            return;
        }
        this.kkB.setVisibility(8);
        this.kkx.setVisibility(8);
        this.kkz.setVisibility(8);
        this.cDC.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.due = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd(int i) {
        if (this.adJ != null) {
            String valueOf = String.valueOf(this.adJ.getFid());
            String aKH = this.adJ.aKH();
            if (this.adJ.dtD != null) {
                valueOf = this.adJ.dtD.id;
                aKH = this.adJ.dtD.ori_fname;
            }
            String title = this.adJ.getTitle();
            String tid = this.adJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String z = z(this.adJ);
            Uri parse = z == null ? null : Uri.parse(z);
            String str2 = this.adJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.adJ.aMy() && this.adJ.aLR() && this.adJ.aKT() != null) {
                shareItem.readCount = this.adJ.aKT().play_count.intValue();
            }
            shareItem.dQA = str2;
            shareItem.linkUrl = str;
            shareItem.due = this.due;
            shareItem.extData = tid;
            shareItem.dQD = 3;
            shareItem.dQE = 1;
            if (i == 3) {
                shareItem.dQF = 1;
            } else if (i == 2) {
                shareItem.dQF = 2;
            } else if (i == 8) {
                shareItem.dQF = 3;
            } else {
                shareItem.dQF = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aKH;
            shareItem.tid = tid;
            shareItem.dQs = true;
            shareItem.dQC = 3;
            shareItem.dQH = A(this.adJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(this.adJ);
            shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(this.adJ);
            shareItem.dQG = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dQR = this.adJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.dQH);
            bundle.putInt("obj_param1", shareItem.dQD);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dQE);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dQF);
            bundle.putInt("obj_source", shareItem.due);
            bundle.putInt("obj_locate", shareItem.dQG);
            shareItem.Y(bundle);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cI("tid", shareItem.tid);
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("fid", shareItem.fid);
            anVar.af("obj_locate", this.due);
            anVar.af(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dQF);
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String z(bj bjVar) {
        if (bjVar == null || bjVar.aKM() == null) {
            return null;
        }
        ArrayList<MediaData> aKM = bjVar.aKM();
        int size = aKM.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aKM.get(i);
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
            if (bjVar.aKE()) {
                return 4;
            }
            if (bjVar.aKz() == 1) {
                return 3;
            }
            return bjVar.aLR() ? 2 : 1;
        }
        return 0;
    }

    public void ai(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kkz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kkx.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kkB.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.cDC.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.kkD.getLayoutParams();
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

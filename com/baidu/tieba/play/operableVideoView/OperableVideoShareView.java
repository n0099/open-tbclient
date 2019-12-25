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
    private bj Ki;
    private View bZT;
    private int cQo;
    private d jud;
    private View jue;
    private ImageView juf;
    private View jug;
    private ImageView juh;
    private View jui;
    private ImageView juj;
    private View juk;
    private ImageView jul;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.cQo = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jue) {
                        OperableVideoShareView.this.Ag(3);
                    } else if (view == OperableVideoShareView.this.jug) {
                        OperableVideoShareView.this.Ag(2);
                    } else if (view == OperableVideoShareView.this.jui) {
                        OperableVideoShareView.this.Ag(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cQo = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jue) {
                        OperableVideoShareView.this.Ag(3);
                    } else if (view == OperableVideoShareView.this.jug) {
                        OperableVideoShareView.this.Ag(2);
                    } else if (view == OperableVideoShareView.this.jui) {
                        OperableVideoShareView.this.Ag(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cQo = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.jue) {
                        OperableVideoShareView.this.Ag(3);
                    } else if (view == OperableVideoShareView.this.jug) {
                        OperableVideoShareView.this.Ag(2);
                    } else if (view == OperableVideoShareView.this.jui) {
                        OperableVideoShareView.this.Ag(8);
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
        this.jue = findViewById(R.id.share_weixin);
        this.juf = (ImageView) findViewById(R.id.share_weixin_img);
        this.jug = findViewById(R.id.share_weixin_timeline);
        this.juh = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.jui = findViewById(R.id.share_qq);
        this.juj = (ImageView) findViewById(R.id.share_qq_img);
        this.bZT = findViewById(R.id.divider_line);
        this.juk = findViewById(R.id.video_replay);
        this.jul = (ImageView) findViewById(R.id.replay_img);
        this.jue.setOnClickListener(this.mOnClickListener);
        this.jug.setOnClickListener(this.mOnClickListener);
        this.jui.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.juf.setImageDrawable(SvgManager.aDW().h(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.juh.setImageDrawable(SvgManager.aDW().h(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.juj.setImageDrawable(SvgManager.aDW().h(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.jul.setImageDrawable(SvgManager.aDW().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.jul.setBackgroundDrawable(am.au(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.jud = dVar;
        this.juk.setOnClickListener(this.jud);
    }

    public void setShareData(bj bjVar) {
        this.Ki = bjVar;
        if (this.Ki != null && !this.Ki.aBC()) {
            this.jui.setVisibility(0);
            this.jue.setVisibility(0);
            this.jug.setVisibility(0);
            this.bZT.setVisibility(0);
            return;
        }
        this.jui.setVisibility(8);
        this.jue.setVisibility(8);
        this.jug.setVisibility(8);
        this.bZT.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.cQo = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ag(int i) {
        if (this.Ki != null) {
            String valueOf = String.valueOf(this.Ki.getFid());
            String azJ = this.Ki.azJ();
            if (this.Ki.cPN != null) {
                valueOf = this.Ki.cPN.id;
                azJ = this.Ki.cPN.ori_fname;
            }
            String title = this.Ki.getTitle();
            String tid = this.Ki.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String x = x(this.Ki);
            Uri parse = x == null ? null : Uri.parse(x);
            String str2 = this.Ki.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.dlC = str2;
            shareItem.linkUrl = str;
            shareItem.cQo = this.cQo;
            shareItem.extData = tid;
            shareItem.dlF = 3;
            shareItem.dlG = 1;
            if (i == 3) {
                shareItem.dlH = 1;
            } else if (i == 2) {
                shareItem.dlH = 2;
            } else if (i == 8) {
                shareItem.dlH = 3;
            } else {
                shareItem.dlH = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = azJ;
            shareItem.tid = tid;
            shareItem.dlv = true;
            shareItem.dlE = 3;
            shareItem.dlJ = y(this.Ki);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Ki);
            shareItem.dlN = ShareItem.ForwardInfo.generateForwardInfo(this.Ki);
            shareItem.dlI = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dlT = this.Ki.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.dlJ);
            bundle.putInt("obj_param1", shareItem.dlF);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dlG);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dlH);
            bundle.putInt("obj_source", shareItem.cQo);
            bundle.putInt("obj_locate", shareItem.dlI);
            shareItem.Y(bundle);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cp("tid", shareItem.tid);
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("fid", shareItem.fid);
            anVar.Z("obj_locate", this.cQo);
            anVar.Z(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dlH);
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String x(bj bjVar) {
        if (bjVar == null || bjVar.azO() == null) {
            return null;
        }
        ArrayList<MediaData> azO = bjVar.azO();
        int size = azO.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = azO.get(i);
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
            if (bjVar.azG()) {
                return 4;
            }
            if (bjVar.azB() == 1) {
                return 3;
            }
            return bjVar.aAT() ? 2 : 1;
        }
        return 0;
    }

    public void af(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jug.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jue.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jui.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bZT.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.juk.getLayoutParams();
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

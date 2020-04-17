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
    private bj adG;
    private View cDw;
    private int dua;
    private ImageView kkA;
    private d kks;
    private View kkt;
    private ImageView kku;
    private View kkv;
    private ImageView kkw;
    private View kkx;
    private ImageView kky;
    private View kkz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.dua = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kkt) {
                        OperableVideoShareView.this.Bd(3);
                    } else if (view == OperableVideoShareView.this.kkv) {
                        OperableVideoShareView.this.Bd(2);
                    } else if (view == OperableVideoShareView.this.kkx) {
                        OperableVideoShareView.this.Bd(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dua = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kkt) {
                        OperableVideoShareView.this.Bd(3);
                    } else if (view == OperableVideoShareView.this.kkv) {
                        OperableVideoShareView.this.Bd(2);
                    } else if (view == OperableVideoShareView.this.kkx) {
                        OperableVideoShareView.this.Bd(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dua = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kkt) {
                        OperableVideoShareView.this.Bd(3);
                    } else if (view == OperableVideoShareView.this.kkv) {
                        OperableVideoShareView.this.Bd(2);
                    } else if (view == OperableVideoShareView.this.kkx) {
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
        this.kkt = findViewById(R.id.share_weixin);
        this.kku = (ImageView) findViewById(R.id.share_weixin_img);
        this.kkv = findViewById(R.id.share_weixin_timeline);
        this.kkw = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.kkx = findViewById(R.id.share_qq);
        this.kky = (ImageView) findViewById(R.id.share_qq_img);
        this.cDw = findViewById(R.id.divider_line);
        this.kkz = findViewById(R.id.video_replay);
        this.kkA = (ImageView) findViewById(R.id.replay_img);
        this.kkt.setOnClickListener(this.mOnClickListener);
        this.kkv.setOnClickListener(this.mOnClickListener);
        this.kkx.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.kku.setImageDrawable(SvgManager.aOU().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.kkw.setImageDrawable(SvgManager.aOU().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.kky.setImageDrawable(SvgManager.aOU().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.kkA.setImageDrawable(SvgManager.aOU().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.kkA.setBackgroundDrawable(am.aB(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.kks = dVar;
        this.kkz.setOnClickListener(this.kks);
    }

    public void setShareData(bj bjVar) {
        this.adG = bjVar;
        if (this.adG != null && !this.adG.aMA()) {
            this.kkx.setVisibility(0);
            this.kkt.setVisibility(0);
            this.kkv.setVisibility(0);
            this.cDw.setVisibility(0);
            return;
        }
        this.kkx.setVisibility(8);
        this.kkt.setVisibility(8);
        this.kkv.setVisibility(8);
        this.cDw.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.dua = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd(int i) {
        if (this.adG != null) {
            String valueOf = String.valueOf(this.adG.getFid());
            String aKJ = this.adG.aKJ();
            if (this.adG.dtz != null) {
                valueOf = this.adG.dtz.id;
                aKJ = this.adG.dtz.ori_fname;
            }
            String title = this.adG.getTitle();
            String tid = this.adG.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String z = z(this.adG);
            Uri parse = z == null ? null : Uri.parse(z);
            String str2 = this.adG.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.adG.aMA() && this.adG.aLT() && this.adG.aKV() != null) {
                shareItem.readCount = this.adG.aKV().play_count.intValue();
            }
            shareItem.dQv = str2;
            shareItem.linkUrl = str;
            shareItem.dua = this.dua;
            shareItem.extData = tid;
            shareItem.dQy = 3;
            shareItem.dQz = 1;
            if (i == 3) {
                shareItem.dQA = 1;
            } else if (i == 2) {
                shareItem.dQA = 2;
            } else if (i == 8) {
                shareItem.dQA = 3;
            } else {
                shareItem.dQA = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aKJ;
            shareItem.tid = tid;
            shareItem.dQn = true;
            shareItem.dQx = 3;
            shareItem.dQC = A(this.adG);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo(this.adG);
            shareItem.dQG = ShareItem.ForwardInfo.generateForwardInfo(this.adG);
            shareItem.dQB = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dQM = this.adG.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.dQC);
            bundle.putInt("obj_param1", shareItem.dQy);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dQz);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dQA);
            bundle.putInt("obj_source", shareItem.dua);
            bundle.putInt("obj_locate", shareItem.dQB);
            shareItem.Y(bundle);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cI("tid", shareItem.tid);
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("fid", shareItem.fid);
            anVar.af("obj_locate", this.dua);
            anVar.af(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dQA);
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String z(bj bjVar) {
        if (bjVar == null || bjVar.aKO() == null) {
            return null;
        }
        ArrayList<MediaData> aKO = bjVar.aKO();
        int size = aKO.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aKO.get(i);
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
            if (bjVar.aKG()) {
                return 4;
            }
            if (bjVar.aKB() == 1) {
                return 3;
            }
            return bjVar.aLT() ? 2 : 1;
        }
        return 0;
    }

    public void ai(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kkv.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kkt.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kkx.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.cDw.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.kkz.getLayoutParams();
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

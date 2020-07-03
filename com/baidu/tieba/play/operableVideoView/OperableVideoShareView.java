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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bu aeK;
    private int dOP;
    private View eVD;
    private View kXA;
    private ImageView kXB;
    private View kXC;
    private ImageView kXD;
    private d kXv;
    private View kXw;
    private ImageView kXx;
    private View kXy;
    private ImageView kXz;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.dOP = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kXw) {
                        OperableVideoShareView.this.CR(3);
                    } else if (view == OperableVideoShareView.this.kXy) {
                        OperableVideoShareView.this.CR(2);
                    } else if (view == OperableVideoShareView.this.kXA) {
                        OperableVideoShareView.this.CR(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOP = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kXw) {
                        OperableVideoShareView.this.CR(3);
                    } else if (view == OperableVideoShareView.this.kXy) {
                        OperableVideoShareView.this.CR(2);
                    } else if (view == OperableVideoShareView.this.kXA) {
                        OperableVideoShareView.this.CR(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dOP = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.kXw) {
                        OperableVideoShareView.this.CR(3);
                    } else if (view == OperableVideoShareView.this.kXy) {
                        OperableVideoShareView.this.CR(2);
                    } else if (view == OperableVideoShareView.this.kXA) {
                        OperableVideoShareView.this.CR(8);
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
        this.kXw = findViewById(R.id.share_weixin);
        this.kXx = (ImageView) findViewById(R.id.share_weixin_img);
        this.kXy = findViewById(R.id.share_weixin_timeline);
        this.kXz = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.kXA = findViewById(R.id.share_qq);
        this.kXB = (ImageView) findViewById(R.id.share_qq_img);
        this.eVD = findViewById(R.id.divider_line);
        this.kXC = findViewById(R.id.video_replay);
        this.kXD = (ImageView) findViewById(R.id.replay_img);
        this.kXw.setOnClickListener(this.mOnClickListener);
        this.kXy.setOnClickListener(this.mOnClickListener);
        this.kXA.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.kXx.setImageDrawable(SvgManager.aWQ().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.kXz.setImageDrawable(SvgManager.aWQ().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.kXB.setImageDrawable(SvgManager.aWQ().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.kXD.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.kXD.setBackgroundDrawable(an.aG(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.kXv = dVar;
        this.kXC.setOnClickListener(this.kXv);
    }

    public void setShareData(bu buVar) {
        this.aeK = buVar;
        if (this.aeK != null && !this.aeK.aQZ()) {
            this.kXA.setVisibility(0);
            this.kXw.setVisibility(0);
            this.kXy.setVisibility(0);
            this.eVD.setVisibility(0);
            return;
        }
        this.kXA.setVisibility(8);
        this.kXw.setVisibility(8);
        this.kXy.setVisibility(8);
        this.eVD.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.dOP = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR(int i) {
        if (this.aeK != null) {
            String valueOf = String.valueOf(this.aeK.getFid());
            String aSt = this.aeK.aSt();
            if (this.aeK.dOi != null) {
                valueOf = this.aeK.dOi.id;
                aSt = this.aeK.dOi.ori_fname;
            }
            String title = this.aeK.getTitle();
            String tid = this.aeK.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String A = A(this.aeK);
            Uri parse = A == null ? null : Uri.parse(A);
            String str2 = this.aeK.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.aeK.aQZ() && this.aeK.aTH() && this.aeK.aSH() != null) {
                shareItem.readCount = this.aeK.aSH().play_count.intValue();
            }
            shareItem.enE = str2;
            shareItem.linkUrl = str;
            shareItem.dOP = this.dOP;
            shareItem.extData = tid;
            shareItem.enH = 3;
            shareItem.enI = 1;
            if (i == 3) {
                shareItem.enJ = 1;
            } else if (i == 2) {
                shareItem.enJ = 2;
            } else if (i == 8) {
                shareItem.enJ = 3;
            } else {
                shareItem.enJ = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aSt;
            shareItem.tid = tid;
            shareItem.nid = this.aeK.getNid();
            shareItem.enx = true;
            shareItem.enG = 3;
            shareItem.enL = B(this.aeK);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aeK);
            shareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(this.aeK);
            shareItem.enK = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.enV = this.aeK.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.enL);
            bundle.putInt("obj_param1", shareItem.enH);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.enI);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.enJ);
            bundle.putInt("obj_source", shareItem.dOP);
            bundle.putInt("obj_locate", shareItem.enK);
            shareItem.ae(bundle);
            ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aoVar.dk("tid", shareItem.tid);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.dk("fid", shareItem.fid);
            aoVar.ag("obj_locate", this.dOP);
            aoVar.ag(TiebaInitialize.Params.OBJ_PARAM3, shareItem.enJ);
            aoVar.dk("nid", shareItem.nid);
            if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aoVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String A(bu buVar) {
        if (buVar == null || buVar.aSy() == null) {
            return null;
        }
        ArrayList<MediaData> aSy = buVar.aSy();
        int size = aSy.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aSy.get(i);
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

    private int B(bu buVar) {
        if (buVar != null) {
            if (buVar.aSr()) {
                return 4;
            }
            if (buVar.aSm() == 1) {
                return 3;
            }
            return buVar.aTH() ? 2 : 1;
        }
        return 0;
    }

    public void am(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kXy.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kXw.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kXA.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.eVD.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.kXC.getLayoutParams();
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

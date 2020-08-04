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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OperableVideoShareView extends LinearLayout {
    private bv aeA;
    private int dVb;
    private View fbk;
    private d leY;
    private View leZ;
    private ImageView lfa;
    private View lfb;
    private ImageView lfc;
    private View lfd;
    private ImageView lfe;
    private View lff;
    private ImageView lfg;
    private View.OnClickListener mOnClickListener;

    public OperableVideoShareView(Context context) {
        super(context);
        this.dVb = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.leZ) {
                        OperableVideoShareView.this.Dq(3);
                    } else if (view == OperableVideoShareView.this.lfb) {
                        OperableVideoShareView.this.Dq(2);
                    } else if (view == OperableVideoShareView.this.lfd) {
                        OperableVideoShareView.this.Dq(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVb = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.leZ) {
                        OperableVideoShareView.this.Dq(3);
                    } else if (view == OperableVideoShareView.this.lfb) {
                        OperableVideoShareView.this.Dq(2);
                    } else if (view == OperableVideoShareView.this.lfd) {
                        OperableVideoShareView.this.Dq(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVb = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!k.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.leZ) {
                        OperableVideoShareView.this.Dq(3);
                    } else if (view == OperableVideoShareView.this.lfb) {
                        OperableVideoShareView.this.Dq(2);
                    } else if (view == OperableVideoShareView.this.lfd) {
                        OperableVideoShareView.this.Dq(8);
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
        this.leZ = findViewById(R.id.share_weixin);
        this.lfa = (ImageView) findViewById(R.id.share_weixin_img);
        this.lfb = findViewById(R.id.share_weixin_timeline);
        this.lfc = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.lfd = findViewById(R.id.share_qq);
        this.lfe = (ImageView) findViewById(R.id.share_qq_img);
        this.fbk = findViewById(R.id.divider_line);
        this.lff = findViewById(R.id.video_replay);
        this.lfg = (ImageView) findViewById(R.id.replay_img);
        this.leZ.setOnClickListener(this.mOnClickListener);
        this.lfb.setOnClickListener(this.mOnClickListener);
        this.lfd.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.lfa.setImageDrawable(SvgManager.baR().i(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.lfc.setImageDrawable(SvgManager.baR().i(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.lfe.setImageDrawable(SvgManager.baR().i(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.lfg.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.lfg.setBackgroundDrawable(ao.aH(l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.leY = dVar;
        this.lff.setOnClickListener(this.leY);
    }

    public void setShareData(bv bvVar) {
        this.aeA = bvVar;
        if (this.aeA != null && !this.aeA.aUV()) {
            this.lfd.setVisibility(0);
            this.leZ.setVisibility(0);
            this.lfb.setVisibility(0);
            this.fbk.setVisibility(0);
            return;
        }
        this.lfd.setVisibility(8);
        this.leZ.setVisibility(8);
        this.lfb.setVisibility(8);
        this.fbk.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.dVb = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq(int i) {
        if (this.aeA != null) {
            String valueOf = String.valueOf(this.aeA.getFid());
            String aWp = this.aeA.aWp();
            if (this.aeA.dUt != null) {
                valueOf = this.aeA.dUt.id;
                aWp = this.aeA.dUt.ori_fname;
            }
            String title = this.aeA.getTitle();
            String tid = this.aeA.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.aeA);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.aeA.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            if (!this.aeA.aUV() && this.aeA.aXD() && this.aeA.aWD() != null) {
                shareItem.readCount = this.aeA.aWD().play_count.intValue();
            }
            shareItem.etQ = str2;
            shareItem.linkUrl = str;
            shareItem.dVb = this.dVb;
            shareItem.extData = tid;
            shareItem.etT = 3;
            shareItem.etU = 1;
            if (i == 3) {
                shareItem.etV = 1;
            } else if (i == 2) {
                shareItem.etV = 2;
            } else if (i == 8) {
                shareItem.etV = 3;
            } else {
                shareItem.etV = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = aWp;
            shareItem.tid = tid;
            shareItem.nid = this.aeA.getNid();
            shareItem.etJ = true;
            shareItem.etS = 3;
            shareItem.etX = getStateThreadType(this.aeA);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aeA);
            shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(this.aeA);
            shareItem.etW = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.euh = this.aeA.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.etX);
            bundle.putInt("obj_param1", shareItem.etT);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.etU);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.etV);
            bundle.putInt("obj_source", shareItem.dVb);
            bundle.putInt("obj_locate", shareItem.etW);
            shareItem.af(bundle);
            ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            apVar.dn("tid", shareItem.tid);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("fid", shareItem.fid);
            apVar.ah("obj_locate", this.dVb);
            apVar.ah(TiebaInitialize.Params.OBJ_PARAM3, shareItem.etV);
            apVar.dn("nid", shareItem.nid);
            if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(apVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bv bvVar) {
        if (bvVar == null || bvVar.aWu() == null) {
            return null;
        }
        ArrayList<MediaData> aWu = bvVar.aWu();
        int size = aWu.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aWu.get(i);
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

    private int getStateThreadType(bv bvVar) {
        if (bvVar != null) {
            if (bvVar.aWn()) {
                return 4;
            }
            if (bvVar.aWi() == 1) {
                return 3;
            }
            return bvVar.aXD() ? 2 : 1;
        }
        return 0;
    }

    public void an(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lfb.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.leZ.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lfd.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fbk.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.lff.getLayoutParams();
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

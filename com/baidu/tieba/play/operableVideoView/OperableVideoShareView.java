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
    private int eBz;
    private View fKv;
    private View.OnClickListener mOnClickListener;
    private d mgg;
    private View mgh;
    private ImageView mgi;
    private View mgj;
    private ImageView mgk;
    private View mgl;
    private ImageView mgm;
    private View mgn;
    private ImageView mgo;

    public OperableVideoShareView(Context context) {
        super(context);
        this.eBz = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mgh) {
                        OperableVideoShareView.this.Hl(3);
                    } else if (view == OperableVideoShareView.this.mgj) {
                        OperableVideoShareView.this.Hl(2);
                    } else if (view == OperableVideoShareView.this.mgl) {
                        OperableVideoShareView.this.Hl(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eBz = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mgh) {
                        OperableVideoShareView.this.Hl(3);
                    } else if (view == OperableVideoShareView.this.mgj) {
                        OperableVideoShareView.this.Hl(2);
                    } else if (view == OperableVideoShareView.this.mgl) {
                        OperableVideoShareView.this.Hl(8);
                    }
                }
            }
        };
        init();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBz = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isFastDoubleClick()) {
                    if (view == OperableVideoShareView.this.mgh) {
                        OperableVideoShareView.this.Hl(3);
                    } else if (view == OperableVideoShareView.this.mgj) {
                        OperableVideoShareView.this.Hl(2);
                    } else if (view == OperableVideoShareView.this.mgl) {
                        OperableVideoShareView.this.Hl(8);
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
        this.mgh = findViewById(R.id.share_weixin);
        this.mgi = (ImageView) findViewById(R.id.share_weixin_img);
        this.mgj = findViewById(R.id.share_weixin_timeline);
        this.mgk = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.mgl = findViewById(R.id.share_qq);
        this.mgm = (ImageView) findViewById(R.id.share_qq_img);
        this.fKv = findViewById(R.id.divider_line);
        this.mgn = findViewById(R.id.video_replay);
        this.mgo = (ImageView) findViewById(R.id.replay_img);
        this.mgh.setOnClickListener(this.mOnClickListener);
        this.mgj.setOnClickListener(this.mOnClickListener);
        this.mgl.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
        this.mgi.setImageDrawable(SvgManager.boN().j(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.mgk.setImageDrawable(SvgManager.boN().j(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.mgm.setImageDrawable(SvgManager.boN().j(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.mgo.setImageDrawable(SvgManager.boN().a(R.drawable.ic_icon_pure_video_replay44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null, false));
        this.mgo.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds52), getResources().getColor(R.color.cp_mask_c_alpha100)));
    }

    public void setVideoContainer(d dVar) {
        this.mgg = dVar;
        this.mgn.setOnClickListener(this.mgg);
    }

    public void setShareData(bw bwVar) {
        this.agx = bwVar;
        if (this.agx != null && !this.agx.biK()) {
            this.mgl.setVisibility(0);
            this.mgh.setVisibility(0);
            this.mgj.setVisibility(0);
            this.fKv.setVisibility(0);
            return;
        }
        this.mgl.setVisibility(8);
        this.mgh.setVisibility(8);
        this.mgj.setVisibility(8);
        this.fKv.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.eBz = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl(int i) {
        if (this.agx != null) {
            String valueOf = String.valueOf(this.agx.getFid());
            String bke = this.agx.bke();
            if (this.agx.eAJ != null) {
                valueOf = this.agx.eAJ.id;
                bke = this.agx.eAJ.ori_fname;
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
            if (!this.agx.biK() && this.agx.bls() && this.agx.bks() != null) {
                shareItem.readCount = this.agx.bks().play_count.intValue();
            }
            shareItem.fbd = str2;
            shareItem.linkUrl = str;
            shareItem.eBz = this.eBz;
            shareItem.extData = tid;
            shareItem.fbg = 3;
            shareItem.fbh = 1;
            if (i == 3) {
                shareItem.fbi = 1;
            } else if (i == 2) {
                shareItem.fbi = 2;
            } else if (i == 8) {
                shareItem.fbi = 3;
            } else {
                shareItem.fbi = 0;
            }
            shareItem.fid = valueOf;
            shareItem.fName = bke;
            shareItem.tid = tid;
            shareItem.nid = this.agx.getNid();
            shareItem.faU = true;
            shareItem.fbf = 3;
            shareItem.fbk = getStateThreadType(this.agx);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agx);
            shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(this.agx);
            shareItem.fbj = 1;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fbu = this.agx.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putString("tid", shareItem.tid);
            bundle.putString("fid", shareItem.fid);
            bundle.putInt("obj_type", shareItem.fbk);
            bundle.putInt("obj_param1", shareItem.fbg);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fbh);
            bundle.putInt(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fbi);
            bundle.putInt("obj_source", shareItem.eBz);
            bundle.putInt("obj_locate", shareItem.fbj);
            shareItem.ae(bundle);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dR("tid", shareItem.tid);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("fid", shareItem.fid);
            aqVar.aj("obj_locate", this.eBz);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fbi);
            aqVar.dR("nid", shareItem.nid);
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
        }
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.bkj() == null) {
            return null;
        }
        ArrayList<MediaData> bkj = bwVar.bkj();
        int size = bkj.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bkj.get(i);
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
            if (bwVar.bkc()) {
                return 4;
            }
            if (bwVar.bjX() == 1) {
                return 3;
            }
            return bwVar.bls() ? 2 : 1;
        }
        return 0;
    }

    public void av(boolean z, boolean z2) {
        int dimens;
        int dimens2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mgj.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mgh.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mgl.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.fKv.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.mgn.getLayoutParams();
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

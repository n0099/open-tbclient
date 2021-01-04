package com.baidu.tieba.sharesdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d {
    private ImageView kdV;
    private m nfP;
    private View nfQ;
    private View nfR;
    private View nfS;
    private TbImageView nfT;
    private LinearLayout nfU;
    private TbImageView nfV;
    private TextView nfW;
    private View nfX;
    private TextView nfY;
    private TextView nfZ;
    private TbImageView nga;
    private View ngb;
    private TextView ngc;
    private TextView ngd;
    private LinearLayout nge;
    private PlayVoiceBntNew ngf;
    private View rootView;

    public c(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.nfP = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.nfQ = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.nfR = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.nfS = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.nfT = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.nfU = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.nfV = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.nfV.setPlaceHolder(2);
        this.nfV.setConrers(15);
        this.nfV.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.nfV.setGifIconSupport(false);
        this.nfV.setLongIconSupport(false);
        this.nfW = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.nfX = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.kdV = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.nfY = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.nfZ = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.nga = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.ngb = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.ngc = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.ngd = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.nge = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.ngf = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.dnx().dPf());
        dLd();
        Ko(2);
    }

    private void dLd() {
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cIx() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.view.d
    public ShareItem Kf(int i) {
        ShareItem shareItem = this.nfA.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fxB = false;
        shareItem.fxA = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.x(ei(this.nfQ));
        shareItem.bCG();
        this.nfA.put(1, shareItem);
        return super.Kf(i);
    }

    private Bitmap ei(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(ao.getColor(R.color.CAM_X0206));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public void show() {
        if (this.nfP != null) {
            this.rootView.setBackgroundColor(ao.getColor(R.color.CAM_X0209));
            ao.d(this.nfS, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ao.getColor(R.color.CAM_X0206));
            this.nfU.setBackgroundDrawable(gradientDrawable);
            ao.setViewTextColor(this.nfW, R.color.CAM_X0107);
            this.nfW.setText(this.nfP.getContent());
            dLe();
            ao.setBackgroundColor(this.ngb, R.color.CAM_X0109);
            String name_show = this.nfP.dnx().brq().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.ngc.setText(name_show);
            ao.setViewTextColor(this.ngc, R.color.CAM_X0109);
            ao.setViewTextColor(this.nfY, R.color.CAM_X0304);
            ao.setViewTextColor(this.nfZ, R.color.CAM_X0105);
            this.nga.setImageBitmap(this.nfP.dnw());
            ao.setImageResource(this.nfT, R.drawable.pic_pb_post_share_logo);
            xJ(false);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected void d(Window window) {
        window.setLayout(-1, -1);
    }

    private void dLe() {
        switch (this.nfP.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.nfP.getThreadImgUrl())) {
                    this.nfV.startLoad(this.nfP.getThreadImgUrl(), 10, false);
                    return;
                }
                this.nfV.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.nfV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.nfV.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.nfV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.nfX.setVisibility(0);
                this.kdV.setVisibility(0);
                this.kdV.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.f.a.bwU().qq(0).m(R.color.CAM_X0601, R.color.CAM_X0604).qx(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bz(this.nfX);
                this.nfV.startLoad(this.nfP.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bKW() != null && !tbRichText.bKW().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bKW().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.ngd.getVisibility() == 8) {
                                ao.setViewTextColor(this.ngd, R.color.CAM_X0105);
                                this.ngd.setText(next.bLd());
                                this.ngd.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.ngf.setVoiceModel((VoiceData.VoiceModel) next.bLe().bLV());
                            if (this.ngd.getVisibility() == 0 || this.nge.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ngf.getLayoutParams();
                                if (this.ngd.getVisibility() == 0 && this.nge.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.ngf.setLayoutParams(layoutParams);
                            }
                            this.ngf.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bKX().isEmpty()) {
                if (this.ngd.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nge.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.nge.setLayoutParams(layoutParams2);
                }
                this.nge.setVisibility(0);
                c(context, tbRichText.bKX());
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 9) {
            this.nge.addView(a(context, a(list.get(i), this.nfP.dny()), list.get(i), i == 0, this.nfP.dny().mIsFromCDN));
            i++;
        }
    }

    private TbImageView a(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        int[] ag = ag(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
        TbImageView tbImageView = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ag[0], ag[1]);
        if (!z) {
            layoutParams.setMargins(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (tbRichTextImageInfo.bLu()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bKV() ? tbRichTextImageInfo.bLm() : tbRichTextImageInfo.bLp();
    }

    private int[] ag(int i, int i2, int i3) {
        int i4;
        int[] iArr = new int[2];
        iArr[0] = i3;
        float f = (i * 1.0f) / (i3 * 1.0f);
        if (f <= 1.0f) {
            i4 = (int) (i2 / f);
        } else {
            i4 = (int) (f * i2);
        }
        iArr[1] = i4;
        return iArr;
    }
}

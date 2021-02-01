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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d {
    private ImageView kgT;
    private n nkR;
    private View nkS;
    private View nkT;
    private View nkU;
    private TbImageView nkV;
    private LinearLayout nkW;
    private TbImageView nkX;
    private TextView nkY;
    private View nkZ;
    private TextView nla;
    private TextView nlb;
    private TbImageView nlc;
    private View nld;
    private TextView nle;
    private TextView nlf;
    private LinearLayout nlg;
    private PlayVoiceBntNew nlh;
    private View rootView;

    public c(Context context, boolean z, int i, n nVar) {
        super(context, z, i);
        this.nkR = nVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.nkS = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.nkT = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.nkU = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.nkV = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.nkW = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.nkX = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.nkX.setPlaceHolder(2);
        this.nkX.setConrers(15);
        this.nkX.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.nkX.setGifIconSupport(false);
        this.nkX.setLongIconSupport(false);
        this.nkY = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.nkZ = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.kgT = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.nla = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.nlb = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.nlc = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.nld = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.nle = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.nlf = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.nlg = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.nlh = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, nVar.dlR().dNz());
        dJx();
        Jb(2);
    }

    private void dJx() {
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cFT() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.view.d
    public ShareItem IS(int i) {
        ShareItem shareItem = this.nkC.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fvk = false;
        shareItem.fvj = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(eg(this.nkS));
        shareItem.bzf();
        this.nkC.put(1, shareItem);
        return super.IS(i);
    }

    private Bitmap eg(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(ap.getColor(R.color.CAM_X0206));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public void show() {
        if (this.nkR != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            ap.d(this.nkU, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0206));
            this.nkW.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.nkY, R.color.CAM_X0107);
            this.nkY.setText(this.nkR.getContent());
            dJy();
            ap.setBackgroundColor(this.nld, R.color.CAM_X0109);
            String name_show = this.nkR.dlR().bnQ().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.nle.setText(name_show);
            ap.setViewTextColor(this.nle, R.color.CAM_X0109);
            ap.setViewTextColor(this.nla, R.color.CAM_X0304);
            ap.setViewTextColor(this.nlb, R.color.CAM_X0105);
            this.nlc.setImageBitmap(this.nkR.dlQ());
            ap.setImageResource(this.nkV, R.drawable.pic_pb_post_share_logo);
            xY(false);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected void d(Window window) {
        window.setLayout(-1, -1);
    }

    private void dJy() {
        switch (this.nkR.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.nkR.getThreadImgUrl())) {
                    this.nkX.startLoad(this.nkR.getThreadImgUrl(), 10, false);
                    return;
                }
                this.nkX.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.nkX.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.nkX.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.nkX.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.nkZ.setVisibility(0);
                this.kgT.setVisibility(0);
                this.kgT.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.f.a.btv().oO(0).m(R.color.CAM_X0601, R.color.CAM_X0604).oV(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bv(this.nkZ);
                this.nkX.startLoad(this.nkR.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bHz() != null && !tbRichText.bHz().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bHz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.nlf.getVisibility() == 8) {
                                ap.setViewTextColor(this.nlf, R.color.CAM_X0105);
                                this.nlf.setText(next.bHG());
                                this.nlf.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.nlh.setVoiceModel((VoiceData.VoiceModel) next.bHH().bIx());
                            if (this.nlf.getVisibility() == 0 || this.nlg.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nlh.getLayoutParams();
                                if (this.nlf.getVisibility() == 0 && this.nlg.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.nlh.setLayoutParams(layoutParams);
                            }
                            this.nlh.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bHA().isEmpty()) {
                if (this.nlf.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nlg.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.nlg.setLayoutParams(layoutParams2);
                }
                this.nlg.setVisibility(0);
                d(context, tbRichText.bHA());
            }
        }
    }

    private void d(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 9) {
            this.nlg.addView(a(context, a(list.get(i), this.nkR.dlS()), list.get(i), i == 0, this.nkR.dlS().mIsFromCDN));
            i++;
        }
    }

    private TbImageView a(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        int[] ae = ae(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
        TbImageView tbImageView = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ae[0], ae[1]);
        if (!z) {
            layoutParams.setMargins(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (tbRichTextImageInfo.bHX()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bHy() ? tbRichTextImageInfo.bHP() : tbRichTextImageInfo.bHS();
    }

    private int[] ae(int i, int i2, int i3) {
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

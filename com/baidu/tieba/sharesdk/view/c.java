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
/* loaded from: classes7.dex */
public class c extends d {
    private ImageView kjk;
    private LinearLayout nnA;
    private TbImageView nnB;
    private TextView nnC;
    private View nnD;
    private TextView nnE;
    private TextView nnF;
    private TbImageView nnG;
    private View nnH;
    private TextView nnI;
    private TextView nnJ;
    private LinearLayout nnK;
    private PlayVoiceBntNew nnL;
    private n nnv;
    private View nnw;
    private View nnx;
    private View nny;
    private TbImageView nnz;
    private View rootView;

    public c(Context context, boolean z, int i, n nVar) {
        super(context, z, i);
        this.nnv = nVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.nnw = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.nnx = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.nny = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.nnz = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.nnA = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.nnB = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.nnB.setPlaceHolder(2);
        this.nnB.setConrers(15);
        this.nnB.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.nnB.setGifIconSupport(false);
        this.nnB.setLongIconSupport(false);
        this.nnC = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.nnD = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.kjk = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.nnE = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.nnF = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.nnG = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.nnH = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.nnI = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.nnJ = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.nnK = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.nnL = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, nVar.dmh().dNQ());
        dJN();
        Jf(2);
    }

    private void dJN() {
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cGg() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.view.d
    public ShareItem IW(int i) {
        ShareItem shareItem = this.nng.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fwJ = false;
        shareItem.fwI = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(eg(this.nnw));
        shareItem.bzi();
        this.nng.put(1, shareItem);
        return super.IW(i);
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
        if (this.nnv != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            ap.d(this.nny, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0206));
            this.nnA.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.nnC, R.color.CAM_X0107);
            this.nnC.setText(this.nnv.getContent());
            dJO();
            ap.setBackgroundColor(this.nnH, R.color.CAM_X0109);
            String name_show = this.nnv.dmh().bnS().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.nnI.setText(name_show);
            ap.setViewTextColor(this.nnI, R.color.CAM_X0109);
            ap.setViewTextColor(this.nnE, R.color.CAM_X0304);
            ap.setViewTextColor(this.nnF, R.color.CAM_X0105);
            this.nnG.setImageBitmap(this.nnv.dmg());
            ap.setImageResource(this.nnz, R.drawable.pic_pb_post_share_logo);
            xY(false);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected void d(Window window) {
        window.setLayout(-1, -1);
    }

    private void dJO() {
        switch (this.nnv.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.nnv.getThreadImgUrl())) {
                    this.nnB.startLoad(this.nnv.getThreadImgUrl(), 10, false);
                    return;
                }
                this.nnB.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.nnB.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.nnB.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.nnB.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.nnD.setVisibility(0);
                this.kjk.setVisibility(0);
                this.kjk.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.f.a.bty().oP(0).m(R.color.CAM_X0601, R.color.CAM_X0604).oW(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bv(this.nnD);
                this.nnB.startLoad(this.nnv.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bHD() != null && !tbRichText.bHD().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bHD().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.nnJ.getVisibility() == 8) {
                                ap.setViewTextColor(this.nnJ, R.color.CAM_X0105);
                                this.nnJ.setText(next.bHK());
                                this.nnJ.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.nnL.setVoiceModel((VoiceData.VoiceModel) next.bHL().bIB());
                            if (this.nnJ.getVisibility() == 0 || this.nnK.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nnL.getLayoutParams();
                                if (this.nnJ.getVisibility() == 0 && this.nnK.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.nnL.setLayoutParams(layoutParams);
                            }
                            this.nnL.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bHE().isEmpty()) {
                if (this.nnJ.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nnK.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.nnK.setLayoutParams(layoutParams2);
                }
                this.nnK.setVisibility(0);
                d(context, tbRichText.bHE());
            }
        }
    }

    private void d(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 9) {
            this.nnK.addView(a(context, a(list.get(i), this.nnv.dmi()), list.get(i), i == 0, this.nnv.dmi().mIsFromCDN));
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
        if (tbRichTextImageInfo.bIb()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bHC() ? tbRichTextImageInfo.bHT() : tbRichTextImageInfo.bHW();
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

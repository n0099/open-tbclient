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
/* loaded from: classes7.dex */
public class c extends d {
    private ImageView jZq;
    private m nbj;
    private View nbk;
    private View nbl;
    private View nbm;
    private TbImageView nbn;
    private LinearLayout nbo;
    private TbImageView nbp;
    private TextView nbq;
    private View nbr;
    private TextView nbs;
    private TextView nbt;
    private TbImageView nbu;
    private View nbv;
    private TextView nbw;
    private TextView nbx;
    private LinearLayout nby;
    private PlayVoiceBntNew nbz;
    private View rootView;

    public c(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.nbj = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.nbk = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.nbl = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.nbm = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.nbn = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.nbo = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.nbp = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.nbp.setPlaceHolder(2);
        this.nbp.setConrers(15);
        this.nbp.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.nbp.setGifIconSupport(false);
        this.nbp.setLongIconSupport(false);
        this.nbq = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.nbr = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jZq = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.nbs = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.nbt = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.nbu = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.nbv = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.nbw = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.nbx = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.nby = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.nbz = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.djF().dLo());
        dHm();
        IH(2);
    }

    private void dHm() {
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cEG() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.view.d
    public ShareItem Iy(int i) {
        ShareItem shareItem = this.naU.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fsS = false;
        shareItem.fsR = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.x(ei(this.nbk));
        shareItem.byN();
        this.naU.put(1, shareItem);
        return super.Iy(i);
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
        if (this.nbj != null) {
            this.rootView.setBackgroundColor(ao.getColor(R.color.CAM_X0209));
            ao.d(this.nbm, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ao.getColor(R.color.CAM_X0206));
            this.nbo.setBackgroundDrawable(gradientDrawable);
            ao.setViewTextColor(this.nbq, R.color.CAM_X0107);
            this.nbq.setText(this.nbj.getContent());
            dHn();
            ao.setBackgroundColor(this.nbv, R.color.CAM_X0109);
            String name_show = this.nbj.djF().bnx().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.nbw.setText(name_show);
            ao.setViewTextColor(this.nbw, R.color.CAM_X0109);
            ao.setViewTextColor(this.nbs, R.color.CAM_X0304);
            ao.setViewTextColor(this.nbt, R.color.CAM_X0105);
            this.nbu.setImageBitmap(this.nbj.djE());
            ao.setImageResource(this.nbn, R.drawable.pic_pb_post_share_logo);
            xF(false);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected void d(Window window) {
        window.setLayout(-1, -1);
    }

    private void dHn() {
        switch (this.nbj.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.nbj.getThreadImgUrl())) {
                    this.nbp.startLoad(this.nbj.getThreadImgUrl(), 10, false);
                    return;
                }
                this.nbp.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.nbp.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.nbp.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.nbp.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.nbr.setVisibility(0);
                this.jZq.setVisibility(0);
                this.jZq.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.f.a.btb().oJ(0).m(R.color.CAM_X0601, R.color.CAM_X0604).oQ(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bz(this.nbr);
                this.nbp.startLoad(this.nbj.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bHf() != null && !tbRichText.bHf().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bHf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.nbx.getVisibility() == 8) {
                                ao.setViewTextColor(this.nbx, R.color.CAM_X0105);
                                this.nbx.setText(next.bHm());
                                this.nbx.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.nbz.setVoiceModel((VoiceData.VoiceModel) next.bHn().bIe());
                            if (this.nbx.getVisibility() == 0 || this.nby.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nbz.getLayoutParams();
                                if (this.nbx.getVisibility() == 0 && this.nby.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.nbz.setLayoutParams(layoutParams);
                            }
                            this.nbz.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bHg().isEmpty()) {
                if (this.nbx.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nby.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.nby.setLayoutParams(layoutParams2);
                }
                this.nby.setVisibility(0);
                c(context, tbRichText.bHg());
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 9) {
            this.nby.addView(a(context, a(list.get(i), this.nbj.djG()), list.get(i), i == 0, this.nbj.djG().mIsFromCDN));
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
        if (tbRichTextImageInfo.bHD()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bHe() ? tbRichTextImageInfo.bHv() : tbRichTextImageInfo.bHy();
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

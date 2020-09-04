package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private TextView dTU;
    private int ds42;
    private int ds48;
    private TbPageContext efr;
    private TextView fGY;
    private HeadImageView hcR;
    public OriginalThreadCardView hle;
    private View jGA;
    private a jGB;
    private OriginalThreadCardView.a jGC;
    private TextView jGv;
    private TextView jGw;
    private View jGx;
    private View jGy;
    private MessageCardBottomView jGz;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.jGC = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.jGB != null && c.this.jGB.cKb() != null) {
                    aq ai = new aq(c.this.jGB.cKb()).ai("obj_locate", 2);
                    if (c.this.jGB.getType() == a.jGr || c.this.jGB.getType() == a.jGn) {
                        ai.ai("obj_type", 1);
                    } else {
                        ai.ai("obj_type", 2);
                    }
                    TiebaStatic.log(ai);
                }
                if (c.this.cbA() != null) {
                    c.this.cbA().a(c.this.hle, c.this.jGB);
                }
            }
        };
        this.efr = tbPageContext;
        this.ds42 = l.getDimens(this.efr.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.efr.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hcR = (HeadImageView) view.findViewById(R.id.photo);
        this.dTU = (TextView) view.findViewById(R.id.user_name);
        this.jGv = (TextView) view.findViewById(R.id.fans_reply);
        this.jGw = (TextView) view.findViewById(R.id.post_from);
        this.jGx = view.findViewById(R.id.divider_between_time_and_post_from);
        this.fGY = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.jGy = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.hle = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.jGz = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.jGA = view.findViewById(R.id.new_message);
        this.hle.setUsePlaceHolder(false);
        this.hcR.setOnClickListener(this);
        this.dTU.setOnClickListener(this);
        this.jGz.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
            ap.setViewTextColor(this.dTU, R.color.cp_cont_f);
            ap.setViewTextColor(this.jGv, R.color.cp_cont_d);
            ap.setBackgroundResource(this.jGv, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.jGw, R.color.cp_cont_d);
            ap.setViewTextColor(this.fGY, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jGx, R.color.cp_cont_e);
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.jGy, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mSubTitle, R.color.cp_cont_j);
            if (this.hle != null) {
                this.hle.onChangeSkinType();
            }
            if (this.jGz != null) {
                this.jGz.onChangeSkinType();
            }
            ap.setBackgroundResource(this.jGA, R.drawable.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: f */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.jGB = aVar;
            MetaData replyer = aVar.getReplyer();
            this.hcR.setVisibility(0);
            this.hcR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hcR.setPlaceHolder(1);
            this.hcR.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.hcR, replyer, 0);
            this.hcR.setTag(null);
            this.hcR.setPageId(this.efr.getUniqueId());
            this.hcR.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.dTU.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.jGv.setVisibility(0);
            } else {
                this.jGv.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.jGx.setVisibility(0);
                this.jGw.setVisibility(0);
                this.jGw.setText(aVar.getPostFrom());
            } else {
                this.jGx.setVisibility(8);
                this.jGw.setVisibility(8);
            }
            this.fGY.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bsW().b(this.efr.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.jGy.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bsW().b(this.efr.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.jGy.setVisibility(0);
            }
            this.hle.b(aVar.getOriginalThreadInfo());
            this.hle.setSubClickListener(this.jGC);
            MessageCardBottomView messageCardBottomView = this.jGz;
            String fname = aVar.getFname();
            if (aVar.getType() == a.jGn || aVar.getType() == a.jGo) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.jGA.setVisibility(0);
            } else {
                this.jGA.setVisibility(8);
            }
            onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jGB != null || this.efr != null) {
            if (view == this.hcR || view == this.dTU) {
                if (this.jGB.getReplyer() != null) {
                    String userId = this.jGB.getReplyer().getUserId();
                    String userName = this.jGB.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.efr.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cbA() != null) {
                cbA().a(view, this.jGB);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.efr == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.efr.getPageActivity()) - (this.efr.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}

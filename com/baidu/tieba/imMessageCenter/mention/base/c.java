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
    private TextView dTQ;
    private int ds42;
    private int ds48;
    private TbPageContext efn;
    private TextView fGU;
    private HeadImageView hcN;
    public OriginalThreadCardView hla;
    private TextView jGp;
    private TextView jGq;
    private View jGr;
    private View jGs;
    private MessageCardBottomView jGt;
    private View jGu;
    private a jGv;
    private OriginalThreadCardView.a jGw;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.jGw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.jGv != null && c.this.jGv.cKa() != null) {
                    aq ai = new aq(c.this.jGv.cKa()).ai("obj_locate", 2);
                    if (c.this.jGv.getType() == a.jGl || c.this.jGv.getType() == a.jGh) {
                        ai.ai("obj_type", 1);
                    } else {
                        ai.ai("obj_type", 2);
                    }
                    TiebaStatic.log(ai);
                }
                if (c.this.cbz() != null) {
                    c.this.cbz().a(c.this.hla, c.this.jGv);
                }
            }
        };
        this.efn = tbPageContext;
        this.ds42 = l.getDimens(this.efn.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.efn.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hcN = (HeadImageView) view.findViewById(R.id.photo);
        this.dTQ = (TextView) view.findViewById(R.id.user_name);
        this.jGp = (TextView) view.findViewById(R.id.fans_reply);
        this.jGq = (TextView) view.findViewById(R.id.post_from);
        this.jGr = view.findViewById(R.id.divider_between_time_and_post_from);
        this.fGU = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.jGs = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.hla = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.jGt = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.jGu = view.findViewById(R.id.new_message);
        this.hla.setUsePlaceHolder(false);
        this.hcN.setOnClickListener(this);
        this.dTQ.setOnClickListener(this);
        this.jGt.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
            ap.setViewTextColor(this.dTQ, R.color.cp_cont_f);
            ap.setViewTextColor(this.jGp, R.color.cp_cont_d);
            ap.setBackgroundResource(this.jGp, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.jGq, R.color.cp_cont_d);
            ap.setViewTextColor(this.fGU, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jGr, R.color.cp_cont_e);
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.jGs, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mSubTitle, R.color.cp_cont_j);
            if (this.hla != null) {
                this.hla.onChangeSkinType();
            }
            if (this.jGt != null) {
                this.jGt.onChangeSkinType();
            }
            ap.setBackgroundResource(this.jGu, R.drawable.icon_news_red_dot);
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
            this.jGv = aVar;
            MetaData replyer = aVar.getReplyer();
            this.hcN.setVisibility(0);
            this.hcN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hcN.setPlaceHolder(1);
            this.hcN.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.hcN, replyer, 0);
            this.hcN.setTag(null);
            this.hcN.setPageId(this.efn.getUniqueId());
            this.hcN.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.dTQ.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.jGp.setVisibility(0);
            } else {
                this.jGp.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.jGr.setVisibility(0);
                this.jGq.setVisibility(0);
                this.jGq.setText(aVar.getPostFrom());
            } else {
                this.jGr.setVisibility(8);
                this.jGq.setVisibility(8);
            }
            this.fGU.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bsV().b(this.efn.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.jGs.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bsV().b(this.efn.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.jGs.setVisibility(0);
            }
            this.hla.b(aVar.getOriginalThreadInfo());
            this.hla.setSubClickListener(this.jGw);
            MessageCardBottomView messageCardBottomView = this.jGt;
            String fname = aVar.getFname();
            if (aVar.getType() == a.jGh || aVar.getType() == a.jGi) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.jGu.setVisibility(0);
            } else {
                this.jGu.setVisibility(8);
            }
            onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jGv != null || this.efn != null) {
            if (view == this.hcN || view == this.dTQ) {
                if (this.jGv.getReplyer() != null) {
                    String userId = this.jGv.getReplyer().getUserId();
                    String userName = this.jGv.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.efn.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (cbz() != null) {
                cbz().a(view, this.jGv);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.efn == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.efn.getPageActivity()) - (this.efn.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}

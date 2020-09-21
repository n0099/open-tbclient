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
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private TextView dWe;
    private int ds42;
    private int ds48;
    private TbPageContext ehG;
    private TextView fKk;
    private HeadImageView hjQ;
    public OriginalThreadCardView hsh;
    private TextView jOX;
    private TextView jOY;
    private View jOZ;
    private View jPa;
    private MessageCardBottomView jPb;
    private View jPc;
    private a jPd;
    private OriginalThreadCardView.a jPe;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.jPe = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.jPd != null && c.this.jPd.cNH() != null) {
                    aq ai = new aq(c.this.jPd.cNH()).ai("obj_locate", 2);
                    if (c.this.jPd.getType() == a.jOT || c.this.jPd.getType() == a.jOP) {
                        ai.ai("obj_type", 1);
                    } else {
                        ai.ai("obj_type", 2);
                    }
                    TiebaStatic.log(ai);
                }
                if (c.this.ceP() != null) {
                    c.this.ceP().a(c.this.hsh, c.this.jPd);
                }
            }
        };
        this.ehG = tbPageContext;
        this.ds42 = l.getDimens(this.ehG.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.ehG.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hjQ = (HeadImageView) view.findViewById(R.id.photo);
        this.dWe = (TextView) view.findViewById(R.id.user_name);
        this.jOX = (TextView) view.findViewById(R.id.fans_reply);
        this.jOY = (TextView) view.findViewById(R.id.post_from);
        this.jOZ = view.findViewById(R.id.divider_between_time_and_post_from);
        this.fKk = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.jPa = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.hsh = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.jPb = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.jPc = view.findViewById(R.id.new_message);
        this.hsh.setUsePlaceHolder(false);
        this.hjQ.setOnClickListener(this);
        this.dWe.setOnClickListener(this);
        this.jPb.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(ap.of(R.color.cp_bg_line_e));
            ap.setViewTextColor(this.dWe, R.color.cp_cont_f);
            ap.setViewTextColor(this.jOX, R.color.cp_cont_d);
            ap.setBackgroundResource(this.jOX, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            ap.setViewTextColor(this.jOY, R.color.cp_cont_d);
            ap.setViewTextColor(this.fKk, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jOZ, R.color.cp_cont_e);
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.jPa, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mSubTitle, R.color.cp_cont_j);
            if (this.hsh != null) {
                this.hsh.onChangeSkinType();
            }
            if (this.jPb != null) {
                this.jPb.onChangeSkinType();
            }
            ap.setBackgroundResource(this.jPc, R.drawable.icon_news_red_dot);
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
            this.jPd = aVar;
            MetaData replyer = aVar.getReplyer();
            this.hjQ.setVisibility(0);
            this.hjQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjQ.setPlaceHolder(1);
            this.hjQ.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.hjQ, replyer, 0);
            this.hjQ.setTag(null);
            this.hjQ.setPageId(this.ehG.getUniqueId());
            this.hjQ.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.dWe.setText(at.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.jOX.setVisibility(0);
            } else {
                this.jOX.setVisibility(8);
            }
            if (!at.isEmpty(aVar.getPostFrom())) {
                this.jOZ.setVisibility(0);
                this.jOY.setVisibility(0);
                this.jOY.setText(aVar.getPostFrom());
            } else {
                this.jOZ.setVisibility(8);
                this.jOY.setVisibility(8);
            }
            this.fKk.setText(at.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bua().b(this.ehG.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (at.isEmpty(aVar.getSubTitle())) {
                this.jPa.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bua().b(this.ehG.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.jPa.setVisibility(0);
            }
            this.hsh.b(aVar.getOriginalThreadInfo());
            this.hsh.setSubClickListener(this.jPe);
            MessageCardBottomView messageCardBottomView = this.jPb;
            String fname = aVar.getFname();
            if (aVar.getType() == a.jOP || aVar.getType() == a.jOQ) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.jPc.setVisibility(0);
            } else {
                this.jPc.setVisibility(8);
            }
            onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jPd != null || this.ehG != null) {
            if (view == this.hjQ || view == this.dWe) {
                if (this.jPd.getReplyer() != null) {
                    String userId = this.jPd.getReplyer().getUserId();
                    String userName = this.jPd.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ehG.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (ceP() != null) {
                ceP().a(view, this.jPd);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.ehG == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.ehG.getPageActivity()) - (this.ehG.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}

package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aIL;
    private TextView cdg;
    private TextView dqc;
    private int ds42;
    private int ds48;
    public OriginalThreadCardView eEg;
    private HeadImageView evL;
    private TextView gXI;
    private TextView gXJ;
    private View gXK;
    private View gXL;
    private MessageCardBottomView gXM;
    private View gXN;
    private a gXO;
    private OriginalThreadCardView.a gXP;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gXP = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gXO != null && c.this.gXO.bIy() != null) {
                    an P = new an(c.this.gXO.bIy()).P("obj_locate", 2);
                    if (c.this.gXO.getType() == a.gXE || c.this.gXO.getType() == a.gXA) {
                        P.P("obj_type", 1);
                    } else {
                        P.P("obj_type", 2);
                    }
                    TiebaStatic.log(P);
                }
                if (c.this.aZq() != null) {
                    c.this.aZq().a(c.this.eEg, c.this.gXO);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.g(this.mContext.getContext(), R.dimen.tbds42);
        this.ds48 = l.g(this.mContext.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.evL = (HeadImageView) view.findViewById(R.id.photo);
        this.cdg = (TextView) view.findViewById(R.id.user_name);
        this.gXI = (TextView) view.findViewById(R.id.fans_reply);
        this.gXJ = (TextView) view.findViewById(R.id.post_from);
        this.gXK = view.findViewById(R.id.divider_between_time_and_post_from);
        this.dqc = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gXL = view.findViewById(R.id.card_message_divider_line);
        this.aIL = (TextView) view.findViewById(R.id.card_message_post_title);
        this.eEg = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gXM = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gXN = view.findViewById(R.id.new_message);
        this.evL.setOnClickListener(this);
        this.cdg.setOnClickListener(this);
        this.gXM.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.j(this.cdg, R.color.cp_cont_f);
            am.j(this.gXI, R.color.cp_cont_d);
            am.k(this.gXI, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.j(this.gXJ, R.color.cp_cont_d);
            am.j(this.dqc, R.color.cp_cont_d);
            am.l(this.gXK, R.color.cp_cont_e);
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.gXL, R.color.cp_bg_line_c);
            am.j(this.aIL, R.color.cp_cont_j);
            if (this.eEg != null) {
                this.eEg.onChangeSkinType();
            }
            if (this.gXM != null) {
                this.gXM.onChangeSkinType();
            }
            am.k(this.gXN, R.drawable.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.gXO = aVar;
            this.evL.setVisibility(0);
            this.evL.setDefaultResource(R.drawable.icon_default_avatar100);
            this.evL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.evL.setDefaultBgResource(R.color.cp_bg_line_e);
            this.evL.setIsRound(true);
            this.evL.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.evL.setTag(null);
            this.evL.setPageId(this.mContext.getUniqueId());
            this.evL.startLoad(portrait, 12, false);
            this.cdg.setText(aq.j(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gXI.setVisibility(0);
            } else {
                this.gXI.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.gXK.setVisibility(0);
                this.gXJ.setVisibility(0);
                this.gXJ.setText(aVar.getPostFrom());
            } else {
                this.gXK.setVisibility(8);
                this.gXJ.setVisibility(8);
            }
            this.dqc.setText(aq.aD(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.atx().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.gXL.setVisibility(8);
                this.aIL.setVisibility(8);
            } else {
                this.aIL.setText(a(this.aIL, TbFaceManager.atx().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aIL.setVisibility(0);
                this.gXL.setVisibility(0);
            }
            this.eEg.b(aVar.getOriginalThreadInfo());
            this.eEg.setSubClickListener(this.gXP);
            MessageCardBottomView messageCardBottomView = this.gXM;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gXA || aVar.getType() == a.gXB) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gXN.setVisibility(0);
            } else {
                this.gXN.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gXO != null || this.mContext != null) {
            if (view == this.evL || view == this.cdg) {
                if (this.gXO.getReplyer() != null) {
                    String userId = this.gXO.getReplyer().getUserId();
                    String userName = this.gXO.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aZq() != null) {
                aZq().a(view, this.gXO);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.af(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}

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
    private TextView ccZ;
    private TextView dpV;
    private int ds42;
    private int ds48;
    public OriginalThreadCardView eDZ;
    private HeadImageView evE;
    private TextView gWQ;
    private TextView gWR;
    private View gWS;
    private View gWT;
    private MessageCardBottomView gWU;
    private View gWV;
    private a gWW;
    private OriginalThreadCardView.a gWX;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gWX = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gWW != null && c.this.gWW.bIk() != null) {
                    an P = new an(c.this.gWW.bIk()).P("obj_locate", 2);
                    if (c.this.gWW.getType() == a.gWM || c.this.gWW.getType() == a.gWI) {
                        P.P("obj_type", 1);
                    } else {
                        P.P("obj_type", 2);
                    }
                    TiebaStatic.log(P);
                }
                if (c.this.aZo() != null) {
                    c.this.aZo().a(c.this.eDZ, c.this.gWW);
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
        this.evE = (HeadImageView) view.findViewById(R.id.photo);
        this.ccZ = (TextView) view.findViewById(R.id.user_name);
        this.gWQ = (TextView) view.findViewById(R.id.fans_reply);
        this.gWR = (TextView) view.findViewById(R.id.post_from);
        this.gWS = view.findViewById(R.id.divider_between_time_and_post_from);
        this.dpV = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gWT = view.findViewById(R.id.card_message_divider_line);
        this.aIL = (TextView) view.findViewById(R.id.card_message_post_title);
        this.eDZ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gWU = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gWV = view.findViewById(R.id.new_message);
        this.evE.setOnClickListener(this);
        this.ccZ.setOnClickListener(this);
        this.gWU.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.j(this.ccZ, R.color.cp_cont_f);
            am.j(this.gWQ, R.color.cp_cont_d);
            am.k(this.gWQ, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.j(this.gWR, R.color.cp_cont_d);
            am.j(this.dpV, R.color.cp_cont_d);
            am.l(this.gWS, R.color.cp_cont_e);
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.gWT, R.color.cp_bg_line_c);
            am.j(this.aIL, R.color.cp_cont_j);
            if (this.eDZ != null) {
                this.eDZ.onChangeSkinType();
            }
            if (this.gWU != null) {
                this.gWU.onChangeSkinType();
            }
            am.k(this.gWV, R.drawable.icon_news_red_dot);
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
            this.gWW = aVar;
            this.evE.setVisibility(0);
            this.evE.setDefaultResource(R.drawable.icon_default_avatar100);
            this.evE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.evE.setDefaultBgResource(R.color.cp_bg_line_e);
            this.evE.setIsRound(true);
            this.evE.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.evE.setTag(null);
            this.evE.setPageId(this.mContext.getUniqueId());
            this.evE.startLoad(portrait, 12, false);
            this.ccZ.setText(aq.j(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gWQ.setVisibility(0);
            } else {
                this.gWQ.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.gWS.setVisibility(0);
                this.gWR.setVisibility(0);
                this.gWR.setText(aVar.getPostFrom());
            } else {
                this.gWS.setVisibility(8);
                this.gWR.setVisibility(8);
            }
            this.dpV.setText(aq.aD(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.atv().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.gWT.setVisibility(8);
                this.aIL.setVisibility(8);
            } else {
                this.aIL.setText(a(this.aIL, TbFaceManager.atv().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aIL.setVisibility(0);
                this.gWT.setVisibility(0);
            }
            this.eDZ.b(aVar.getOriginalThreadInfo());
            this.eDZ.setSubClickListener(this.gWX);
            MessageCardBottomView messageCardBottomView = this.gWU;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gWI || aVar.getType() == a.gWJ) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gWV.setVisibility(0);
            } else {
                this.gWV.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gWW != null || this.mContext != null) {
            if (view == this.evE || view == this.ccZ) {
                if (this.gWW.getReplyer() != null) {
                    String userId = this.gWW.getReplyer().getUserId();
                    String userName = this.gWW.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aZo() != null) {
                aZo().a(view, this.gWW);
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

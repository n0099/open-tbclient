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
    private TextView aJj;
    private TextView cdZ;
    private TextView drN;
    private int ds42;
    private int ds48;
    public OriginalThreadCardView eFP;
    private HeadImageView exw;
    private TextView gZC;
    private TextView gZD;
    private View gZE;
    private View gZF;
    private MessageCardBottomView gZG;
    private View gZH;
    private a gZI;
    private OriginalThreadCardView.a gZJ;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gZJ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gZI != null && c.this.gZI.bJm() != null) {
                    an P = new an(c.this.gZI.bJm()).P("obj_locate", 2);
                    if (c.this.gZI.getType() == a.gZy || c.this.gZI.getType() == a.gZu) {
                        P.P("obj_type", 1);
                    } else {
                        P.P("obj_type", 2);
                    }
                    TiebaStatic.log(P);
                }
                if (c.this.aZU() != null) {
                    c.this.aZU().a(c.this.eFP, c.this.gZI);
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
        this.exw = (HeadImageView) view.findViewById(R.id.photo);
        this.cdZ = (TextView) view.findViewById(R.id.user_name);
        this.gZC = (TextView) view.findViewById(R.id.fans_reply);
        this.gZD = (TextView) view.findViewById(R.id.post_from);
        this.gZE = view.findViewById(R.id.divider_between_time_and_post_from);
        this.drN = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gZF = view.findViewById(R.id.card_message_divider_line);
        this.aJj = (TextView) view.findViewById(R.id.card_message_post_title);
        this.eFP = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gZG = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gZH = view.findViewById(R.id.new_message);
        this.exw.setOnClickListener(this);
        this.cdZ.setOnClickListener(this);
        this.gZG.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
            am.j(this.cdZ, R.color.cp_cont_f);
            am.j(this.gZC, R.color.cp_cont_d);
            am.k(this.gZC, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.j(this.gZD, R.color.cp_cont_d);
            am.j(this.drN, R.color.cp_cont_d);
            am.l(this.gZE, R.color.cp_cont_e);
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.gZF, R.color.cp_bg_line_c);
            am.j(this.aJj, R.color.cp_cont_j);
            if (this.eFP != null) {
                this.eFP.onChangeSkinType();
            }
            if (this.gZG != null) {
                this.gZG.onChangeSkinType();
            }
            am.k(this.gZH, R.drawable.icon_news_red_dot);
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
            this.gZI = aVar;
            this.exw.setVisibility(0);
            this.exw.setDefaultResource(R.drawable.icon_default_avatar100);
            this.exw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exw.setDefaultBgResource(R.color.cp_bg_line_e);
            this.exw.setIsRound(true);
            this.exw.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.exw.setTag(null);
            this.exw.setPageId(this.mContext.getUniqueId());
            this.exw.startLoad(portrait, 12, false);
            this.cdZ.setText(aq.j(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gZC.setVisibility(0);
            } else {
                this.gZC.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.gZE.setVisibility(0);
                this.gZD.setVisibility(0);
                this.gZD.setText(aVar.getPostFrom());
            } else {
                this.gZE.setVisibility(8);
                this.gZD.setVisibility(8);
            }
            this.drN.setText(aq.aD(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.atJ().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.gZF.setVisibility(8);
                this.aJj.setVisibility(8);
            } else {
                this.aJj.setText(a(this.aJj, TbFaceManager.atJ().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aJj.setVisibility(0);
                this.gZF.setVisibility(0);
            }
            this.eFP.b(aVar.getOriginalThreadInfo());
            this.eFP.setSubClickListener(this.gZJ);
            MessageCardBottomView messageCardBottomView = this.gZG;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gZu || aVar.getType() == a.gZv) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gZH.setVisibility(0);
            } else {
                this.gZH.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gZI != null || this.mContext != null) {
            if (view == this.exw || view == this.cdZ) {
                if (this.gZI.getReplyer() != null) {
                    String userId = this.gZI.getReplyer().getUserId();
                    String userName = this.gZI.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aZU() != null) {
                aZU().a(view, this.gZI);
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

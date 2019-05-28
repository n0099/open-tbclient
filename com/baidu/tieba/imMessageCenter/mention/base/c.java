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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aId;
    private TextView cbV;
    private int ds42;
    private int ds48;
    private HeadImageView eqG;
    public OriginalThreadCardView ezc;
    private TextView faX;
    private TextView gQE;
    private TextView gQF;
    private View gQG;
    private View gQH;
    private MessageCardBottomView gQI;
    private View gQJ;
    private a gQK;
    private OriginalThreadCardView.a gQL;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gQL = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gQK != null && c.this.gQK.bFC() != null) {
                    am P = new am(c.this.gQK.bFC()).P("obj_locate", 2);
                    if (c.this.gQK.getType() == a.gQA || c.this.gQK.getType() == a.gQw) {
                        P.P("obj_type", 1);
                    } else {
                        P.P("obj_type", 2);
                    }
                    TiebaStatic.log(P);
                }
                if (c.this.aXr() != null) {
                    c.this.aXr().a(c.this.ezc, c.this.gQK);
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
        this.eqG = (HeadImageView) view.findViewById(R.id.photo);
        this.cbV = (TextView) view.findViewById(R.id.user_name);
        this.gQE = (TextView) view.findViewById(R.id.fans_reply);
        this.gQF = (TextView) view.findViewById(R.id.post_from);
        this.gQG = view.findViewById(R.id.divider_between_time_and_post_from);
        this.faX = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.gQH = view.findViewById(R.id.card_message_divider_line);
        this.aId = (TextView) view.findViewById(R.id.card_message_post_title);
        this.ezc = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gQI = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.gQJ = view.findViewById(R.id.new_message);
        this.eqG.setOnClickListener(this);
        this.cbV.setOnClickListener(this);
        this.gQI.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(getView(), R.drawable.addresslist_item_bg);
            al.j(this.cbV, R.color.cp_cont_f);
            al.j(this.gQE, R.color.cp_cont_d);
            al.k(this.gQE, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            al.j(this.gQF, R.color.cp_cont_d);
            al.j(this.faX, R.color.cp_cont_d);
            al.l(this.gQG, R.color.cp_cont_e);
            al.j(this.mTitle, R.color.cp_cont_b);
            al.l(this.gQH, R.color.cp_bg_line_c);
            al.j(this.aId, R.color.cp_cont_j);
            if (this.ezc != null) {
                this.ezc.onChangeSkinType();
            }
            if (this.gQI != null) {
                this.gQI.onChangeSkinType();
            }
            al.k(this.gQJ, R.drawable.icon_news_red_dot);
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
            this.gQK = aVar;
            this.eqG.setVisibility(0);
            this.eqG.setDefaultResource(R.drawable.icon_default_avatar100);
            this.eqG.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eqG.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eqG.setIsRound(true);
            this.eqG.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eqG.setTag(null);
            this.eqG.setPageId(this.mContext.getUniqueId());
            this.eqG.startLoad(portrait, 12, false);
            this.cbV.setText(ap.j(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gQE.setVisibility(0);
            } else {
                this.gQE.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.gQG.setVisibility(0);
                this.gQF.setVisibility(0);
                this.gQF.setText(aVar.getPostFrom());
            } else {
                this.gQG.setVisibility(8);
                this.gQF.setVisibility(8);
            }
            this.faX.setText(ap.aC(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aso().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.gQH.setVisibility(8);
                this.aId.setVisibility(8);
            } else {
                this.aId.setText(a(this.aId, TbFaceManager.aso().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aId.setVisibility(0);
                this.gQH.setVisibility(0);
            }
            this.ezc.b(aVar.getOriginalThreadInfo());
            this.ezc.setSubClickListener(this.gQL);
            MessageCardBottomView messageCardBottomView = this.gQI;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gQw || aVar.getType() == a.gQx) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gQJ.setVisibility(0);
            } else {
                this.gQJ.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gQK != null || this.mContext != null) {
            if (view == this.eqG || view == this.cbV) {
                if (this.gQK.getReplyer() != null) {
                    String userId = this.gQK.getReplyer().getUserId();
                    String userName = this.gQK.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aXr() != null) {
                aXr().a(view, this.gQK);
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
